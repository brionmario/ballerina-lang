/*
 *  Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.ballerinalang.test.docerina;

import org.ballerinalang.docgen.docs.BallerinaDocGenerator;
import org.ballerinalang.docgen.generator.model.DefaultableVarible;
import org.ballerinalang.docgen.generator.model.Module;
import org.ballerinalang.docgen.generator.model.Object;
import org.ballerinalang.docgen.generator.model.Project;
import org.ballerinalang.docgen.generator.model.Record;
import org.ballerinalang.docgen.model.ModuleDoc;
import org.ballerinalang.test.util.BCompileUtil;
import org.ballerinalang.test.util.CompileResult;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.wso2.ballerinalang.compiler.tree.BLangPackage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Test class to check record/object field-level documentation in docerina.
 */
public class FieldLevelDocsTest {

    // record with module-level documentation
    private Record addressRecord;
    // record with field-level documentation
    private Record personRecord;
    // record with both module-level & field-level documentation
    private Record apartmentRecord;
    // Object with module-level documentation
    private Object studentObj;
    // Object with field-level documentation
    private Object teacherObj;

    private static final String PARAGRAPH_OPEN_TAG = "<p>";
    private static final String PARAGRAPH_CLOSE_TAG = "</p>";
    private static final String NEW_LINE = "\n";
    private static final String PARAGRAPH_CLOSE_WITH_NEW_LINE = PARAGRAPH_CLOSE_TAG + NEW_LINE;

    @BeforeClass
    public void setup() throws IOException {
        String sourceRoot = "test-src" + File.separator + "docerina" + File.separator + "fieldLevelDocsProject";
        CompileResult result = BCompileUtil.compile(sourceRoot, "testModule");

        List<BLangPackage> modules = new LinkedList<>();
        modules.add((BLangPackage) result.getAST());
        Map<String, ModuleDoc> docsMap = BallerinaDocGenerator.generateModuleDocsFromBLangPackages(
                Paths.get("src", "test", "resources", sourceRoot).toAbsolutePath().toString(), modules);
        List<ModuleDoc> moduleDocList = new ArrayList<>(docsMap.values());
        moduleDocList.sort(Comparator.comparing(pkg -> pkg.bLangPackage.packageID.toString()));
        Map<String, List<Path>> resources = new HashMap<>();

        Project project = BallerinaDocGenerator.getDocsGenModel(moduleDocList, resources);
        Module testModule = project.modules.get(0);

        for (Record record : testModule.records) {
            String recordName = record.name;

            if ("Address".equals(recordName)) {
                addressRecord = record;
            } else if ("Person".equals(recordName)) {
                personRecord = record;
            } else if ("Apartment".equals(recordName)) {
                apartmentRecord = record;
            }
        }

        for (Object obj : testModule.objects) {
            String objName = obj.name;

            if ("Student".equals(objName)) {
                studentObj = obj;
            } else if ("Teacher".equals(objName)) {
                teacherObj = obj;
            }
        }
    }

    @Test(description = "Test records with module-level field docs")
    public void testRecordWithModuleLevelFieldDocs() {
        DefaultableVarible streetField = null;
        DefaultableVarible cityField = null;
        DefaultableVarible countryCodeField = null;

        List<DefaultableVarible> fields = addressRecord.fields;

        for (DefaultableVarible field : fields) {
            String fieldName = field.name;

            if ("street".equals(fieldName)) {
                streetField = field;
            } else if ("city".equals(fieldName)) {
                cityField = field;
            } else if ("countryCode".equals(fieldName)) {
                countryCodeField = field;
            }
        }

        testDescription(streetField, formatHtmlDescription("street of the address"));
        testDescription(cityField, formatHtmlDescription("city of the address"));
        testDescription(countryCodeField, formatHtmlDescription("country code of the address"));
    }

    @Test(description = "Test records with field-level field docs")
    public void testRecordWithFieldLevelFieldDocs() {
        DefaultableVarible nameField = null;
        DefaultableVarible ageField = null;
        DefaultableVarible countryCodeField = null;

        List<DefaultableVarible> fields = personRecord.fields;

        for (DefaultableVarible field : fields) {
            String fieldName = field.name;

            if ("name".equals(fieldName)) {
                nameField = field;
            } else if ("age".equals(fieldName)) {
                ageField = field;
            } else if ("countryCode".equals(fieldName)) {
                countryCodeField = field;
            }
        }

        testDescription(nameField, formatHtmlDescription("name of the person"));
        testDescription(ageField, formatHtmlDescription("age of the person"));
        testDescription(countryCodeField, formatHtmlDescription("country code of the person"));
    }


    @Test(description = "Test records with both module-level & field-level field docs. module-level is the priority")
    public void testRecordWithModuleLevelAndFieldLevelFieldDocs() {
        DefaultableVarible numberField = null;
        DefaultableVarible streetField = null;
        DefaultableVarible countryCodeField = null;

        List<DefaultableVarible> fields = apartmentRecord.fields;

        for (DefaultableVarible field : fields) {
            String fieldName = field.name;

            if ("number".equals(fieldName)) {
                numberField = field;
            } else if ("street".equals(fieldName)) {
                streetField = field;
            } else if ("countryCode".equals(fieldName)) {
                countryCodeField = field;
            }
        }

        testDescription(numberField, formatHtmlDescription("number of the apartment"));
        testDescription(streetField, formatHtmlDescription("street of the apartment"));
        testDescription(countryCodeField, formatHtmlDescription("country code of the apartment"));
    }

    @Test(description = "Test object with module-level field docs")
    public void testObjectWithModuleLevelFieldDocs() {
        DefaultableVarible nameField = null;
        DefaultableVarible ageField = null;

        List<DefaultableVarible> fields = studentObj.fields;

        for (DefaultableVarible field : fields) {
            String fieldName = field.name;

            if ("name".equals(fieldName)) {
                nameField = field;
            } else if ("age".equals(fieldName)) {
                ageField = field;
            }
        }

        testDescription(nameField, formatHtmlDescription("student name"));
        testDescription(ageField, formatHtmlDescription("student age"));
    }

    @Test(description = "Test object with field-level field docs")
    public void testObjectWithFieldLevelFieldDocs() {
        DefaultableVarible nameField = null;
        DefaultableVarible ageField = null;

        List<DefaultableVarible> fields = teacherObj.fields;

        for (DefaultableVarible field : fields) {
            String fieldName = field.name;

            if ("name".equals(fieldName)) {
                nameField = field;
            } else if ("age".equals(fieldName)) {
                ageField = field;
            }
        }

        testDescription(nameField, formatHtmlDescription("Teacher name"));
        testDescription(ageField, formatHtmlDescription("Teacher age"));
    }

    @Test(description = "Test documentation with markdown styles")
    public void testDocumentsWithMarkdownStyles() {
        Assert.assertEquals(teacherObj.description.trim(),
                "<p><code>Teacher</code> object in <em>school</em> located in <strong>New York</strong>\n"
                        + "<code>Senior</code> teacher of the school</p>");
    }

    private void testDescription(DefaultableVarible field, String expectedDesc) {
        Assert.assertNotNull(field);
        Assert.assertEquals(field.description, expectedDesc);
    }

    private String formatHtmlDescription(String desc) {
        return PARAGRAPH_OPEN_TAG + desc + PARAGRAPH_CLOSE_WITH_NEW_LINE;
    }
}