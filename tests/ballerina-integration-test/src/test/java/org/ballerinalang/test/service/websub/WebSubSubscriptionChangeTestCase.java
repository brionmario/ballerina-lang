/*
 *  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.ballerinalang.test.service.websub;

import org.awaitility.Duration;
import org.ballerinalang.test.BaseTest;
import org.ballerinalang.test.context.BMainInstance;
import org.ballerinalang.test.context.BServerInstance;
import org.ballerinalang.test.context.BallerinaTestException;
import org.ballerinalang.test.context.LogLeecher;
import org.ballerinalang.test.util.HttpResponse;
import org.ballerinalang.test.util.HttpsClientRequest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.ConnectException;
import java.util.concurrent.Executors;

import static org.awaitility.Awaitility.given;
import static org.ballerinalang.test.service.websub.WebSubTestUtils.updateNotified;
import static org.ballerinalang.test.service.websub.WebSubTestUtils.updateSubscribed;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * This class includes an integration scenario which tests unsubscription and not receiving content after
 * unsubscription in addition to the following:
 * 1. Bringing up the Ballerina Hub
 * 2. Sending the subscription request for WebSub Subscriber services on start up, and auto verifying intent to
 * subscribe, when the hub sends an intent verification request, since an onIntentVerification resource is not
 * specified
 * 3. Functions made available to the Publishers - publishing directly on to the Ballerina Hub or to a Hub by
 * specifying the URL (usecase: remote hubs)
 * 4. Content Delivery process - by verifying content is delivered when update notification is done for a subscribed
 * topic - both directly to the hub and specifying hub URL
 */
public class WebSubSubscriptionChangeTestCase extends BaseTest {
    private BServerInstance webSubSubscriber;
    private BMainInstance webSubPublisher;

    private final int subscriberServicePort = 8181;
    private final String helperServicePortAsString = "8096";

    private static String hubUrl = "https://localhost:9393/websub/hub";
    private static final String SUBSCRIPTION_INTENT_VERIFICATION_LOG = "ballerina: Intent Verification agreed - Mode "
            + "[subscribe], Topic [http://www.websubpubtopic.com], Lease Seconds [86400]";
    private static final String UNSUBSCRIPTION_INTENT_VERIFICATION_LOG = "ballerina: Intent Verification agreed - Mode "
            + "[unsubscribe], Topic [http://www.websubpubtopic.com]";
    private static final String INTERNAL_HUB_NOTIFICATION_LOG = "WebSub Notification Received: "
            + "{\"action\":\"publish\", \"mode\":\"internal-hub\"}";

    private LogLeecher subscriptionIntentVerificationLogLeecher = new LogLeecher(SUBSCRIPTION_INTENT_VERIFICATION_LOG);
    private LogLeecher unsubscriptionIntentVerificationLogLeecher = new LogLeecher(
            UNSUBSCRIPTION_INTENT_VERIFICATION_LOG);
    private LogLeecher internalHubNotificationLogLeecher = new LogLeecher(INTERNAL_HUB_NOTIFICATION_LOG);
    private LogLeecher logAbsenceTestLogLeecher = new LogLeecher(INTERNAL_HUB_NOTIFICATION_LOG);


    @BeforeClass
    public void setup() throws BallerinaTestException {
        webSubSubscriber = new BServerInstance(balServer);
        webSubPublisher = new BMainInstance(balServer);

        String publisherBal = new File("src" + File.separator + "test" + File.separator + "resources"
                + File.separator + "websub" + File.separator + "websub_test_periodic_publisher.bal").getAbsolutePath();
        String[] publisherArgs = {"-e b7a.websub.hub.remotepublish=true",
                "-e test.helper.service.port=" + helperServicePortAsString};

        String subscriberBal = new File("src" + File.separator + "test" + File.separator + "resources"
                + File.separator + "websub" + File.separator + "websub_test_subscriber.bal").getAbsolutePath();

        webSubSubscriber.addLogLeecher(subscriptionIntentVerificationLogLeecher);
        webSubSubscriber.addLogLeecher(unsubscriptionIntentVerificationLogLeecher);
        webSubSubscriber.addLogLeecher(internalHubNotificationLogLeecher);

        Executors.newSingleThreadExecutor().execute(() -> {
            try {
                webSubPublisher.runMain(publisherBal, publisherArgs, new String[]{});
            } catch (BallerinaTestException e) {
                //ignored since any errors here would be reflected as test failures
            }
        });

        //Allow to bring up the hub
        given().ignoreException(ConnectException.class).with().pollInterval(Duration.ONE_SECOND).await()
                .atMost(60, SECONDS).until(() -> {
            //using same pack location, hence server home is same
            HttpResponse response = HttpsClientRequest.doGet(hubUrl, webSubSubscriber.getServerHome());
            return response.getResponseCode() == 202;
        });

        String[] subscriberArgs = {"-e test.hub.url=" + hubUrl};
        webSubSubscriber.startServer(subscriberBal, subscriberArgs, new int[]{subscriberServicePort});
    }

    @Test
    public void testSubscriptionAndIntentVerification() throws BallerinaTestException {
        subscriptionIntentVerificationLogLeecher.waitForText(30000);
        updateSubscribed(helperServicePortAsString);
    }

    @Test(dependsOnMethods = "testSubscriptionAndIntentVerification")
    public void testContentReceipt() throws BallerinaTestException {
        internalHubNotificationLogLeecher.waitForText(45000);
    }

    @Test(dependsOnMethods = "testContentReceipt")
    public void testUnsubscriptionIntentVerification() throws BallerinaTestException {
        String balFile = new File("src" + File.separator + "test" + File.separator + "resources"
                + File.separator + "websub" + File.separator +
                "websub_test_unsubscription_client.bal").getAbsolutePath();
        webSubPublisher.runMain(balFile);
        webSubSubscriber.addLogLeecher(logAbsenceTestLogLeecher);
        unsubscriptionIntentVerificationLogLeecher.waitForText(30000);
    }

    @Test(dependsOnMethods = "testUnsubscriptionIntentVerification",
            description = "Tests that no notifications are received after unsubscription",
            expectedExceptions = BallerinaTestException.class,
            expectedExceptionsMessageRegExp = ".*Timeout expired waiting for matching log.*"
    )
    public void testUnsubscription() throws BallerinaTestException {
        logAbsenceTestLogLeecher.waitForText(5000);
    }

    @AfterClass
    private void cleanup() throws Exception {
        updateNotified(helperServicePortAsString);
        webSubSubscriber.shutdownServer();
    }

}
