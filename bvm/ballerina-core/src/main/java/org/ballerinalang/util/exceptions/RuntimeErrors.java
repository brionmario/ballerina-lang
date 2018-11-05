/*
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.ballerinalang.util.exceptions;

/**
 * Error codes and Error keys to represent the runtime errors.
 */
public enum RuntimeErrors {

    CASTING_ANY_TYPE_TO_WRONG_VALUE_TYPE("casting.any.to.wrong.value.type", "RUNTIME_0001"),
    CASTING_ANY_TYPE_WITHOUT_INIT("casting.any.without.init", "RUNTIME_0002"),
    INDEX_NUMBER_TOO_LARGE("index.number.too.large", "RUNTIME_0003"),
    ARRAY_INDEX_OUT_OF_RANGE("array.index.out.of.range", "RUNTIME_0004"),
    INCOMPATIBLE_TYPE("incompatible.types", "RUNTIME_0005"),
    CASTING_WITHOUT_REQUIRED_FIELD("casting.without.required.field", "RUNTIME_0006"),
    CASTING_FAILED_WITH_CAUSE("casting.failed.with.cause", "RUNTIME_0007"),
    MISSING_FIELD_IN_JSON("missing.field.in.json", "RUNTIME_0008"),
    CANNOT_SET_VALUE_INCOMPATIBLE_TYPES("cannot.set.value.incompatible.types", "RUNTIME_0009"),
    CANNOT_GET_VALUE_INCOMPATIBLE_TYPES("cannot.get.value.incompatible.types", "RUNTIME_0010"),
    INCOMPATIBLE_FIELD_TYPE_FOR_CASTING("incompatible.field.type.for.casting", "RUNTIME_0011"),
    INCOMPATIBLE_TYPE_FOR_CASTING_JSON("incompatible.types.in.json", "RUNTIME_0012"),
    JSON_SET_ERROR("json.set.error", "RUNTIME_0013"),
    JSON_GET_ERROR("json.get.error", "RUNTIME_0014"),
    ARRAY_TYPE_MISMATCH("from.and.to.array.type.mismatch", "RUNTIME_0015"),
    SERVER_CONNECTOR_ALREADY_EXIST("server.connector.already.exist", "RUNTIME_0016"),
    INVALID_SERVICE_PROTOCOL("invalid.service.protocol", "RUNTIME_0017"),
    CONNECTOR_INPUT_TYPES_NOT_EQUIVALENT("connector.input.types.are.not.equivalent", "RUNTIME_0018"),
    UNKNOWN_FIELD_JSON_STRUCT("unknown.field.in.json.struct", "RUNTIME_0019"),
    INVALID_RETRY_COUNT("invalid.retry.count", "RUNTIME_0020"),
    NOT_ENOUGH_FORMAT_ARGUMENTS("not.enough.format.arguments", "RUNTIME_0021"),
    INVALID_FORMAT_SPECIFIER("invalid.format.specifier", "RUNTIME_0022"),
    INVALID_MAP_INSERTION("invalid.map.insertion", "RUNTIME_0023"),
    INVALID_VALUE_LOAD("invalid.value.load", "RUNTIME_0024"),
    INVALID_TASK_CONFIG("invalid.task.config", "RUNTIME_0025"),
    TASK_ALREADY_RUNNING("task.already.running", "RUNTIME_0026"),
    TASK_NOT_RUNNING("task.not.running", "RUNTIME_0027"),
    ILLEGAL_FORMAT_CONVERSION("illegal.format.conversion", "RUNTIME_0028"),
    INCOMPATIBLE_SEAL_OPERATION("incompatible.seal.operation", "RUNTIME_0029");

    private String errorMsgKey;
    private String errorCode;

    RuntimeErrors(String errorMessageKey, String errorCode) {
        this.errorMsgKey = errorMessageKey;
        this.errorCode = errorCode;
    }

    public String getErrorMsgKey() {
        return errorMsgKey;
    }

    public void setErrorMsgKey(String errorMsgKey) {
        this.errorMsgKey = errorMsgKey;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
