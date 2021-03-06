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
package org.ballerinalang.jvm.util.exceptions;

import static org.ballerinalang.jvm.util.BLangConstants.ARRAY_LANG_LIB;
import static org.ballerinalang.jvm.util.BLangConstants.FUTURE_LANG_LIB;
import static org.ballerinalang.jvm.util.BLangConstants.MAP_LANG_LIB;
import static org.ballerinalang.jvm.util.BLangConstants.STRING_LANG_LIB;
import static org.ballerinalang.jvm.util.BLangConstants.TABLE_LANG_LIB;
import static org.ballerinalang.jvm.util.BLangConstants.TYPEDESC_LANG_LIB;
import static org.ballerinalang.jvm.util.BLangConstants.VALUE_LANG_LIB;
import static org.ballerinalang.jvm.util.BLangConstants.XML_LANG_LIB;

/**
 * This is a temporary class for reasons for Ballerina errors from the VM either returned or causing panic.
 *
 * @since 0.990.0
 */
public class BallerinaErrorReasons {

    private static final String BALLERINA_PREFIX = "{ballerina}";
    private static final String BALLERINA_ORG_PREFIX = "{ballerina/";
    private static final String CLOSING_CURLY_BRACE = "}";

    public static final String TYPE_CAST_ERROR = BALLERINA_PREFIX.concat("TypeCastError");
    public static final String NUMBER_CONVERSION_ERROR = BALLERINA_PREFIX.concat("NumberConversionError");
    public static final String JSON_OPERATION_ERROR = BALLERINA_PREFIX.concat("JSONOperationError");
    public static final String TABLE_OPERATION_ERROR = BALLERINA_PREFIX.concat("TableOperationError");
    public static final String TABLE_CLOSED_ERROR = BALLERINA_PREFIX.concat("TableClosedError");

    public static final String DIVISION_BY_ZERO_ERROR = BALLERINA_PREFIX.concat("DivisionByZero");
    public static final String NUMBER_OVERFLOW = BALLERINA_PREFIX.concat("NumberOverflow");
    public static final String ARITHMETIC_OPERATION_ERROR = BALLERINA_PREFIX.concat("ArithmeticOperationError");
    public static final String JAVA_NULL_REFERENCE_ERROR = BALLERINA_PREFIX.concat("JavaNullReferenceError");
    public static final String JAVA_CLASS_NOT_FOUND_ERROR = BALLERINA_PREFIX.concat("JavaClassNotFoundError");

    // TODO: 8/28/19 Errors we should be able to remove once all migration is done.
    public static final String BALLERINA_PREFIXED_CLONE_ERROR = BALLERINA_PREFIX.concat("CloneError");
    public static final String BALLERINA_PREFIXED_FREEZE_ERROR = BALLERINA_PREFIX.concat("FreezeError");
    public static final String BALLERINA_PREFIXED_STAMP_ERROR = BALLERINA_PREFIX.concat("StampError");
    public static final String BALLERINA_PREFIXED_CONVERSION_ERROR = BALLERINA_PREFIX.concat("ConversionError");
    public static final String CONCURRENT_MODIFICATION_ERROR = BALLERINA_PREFIX.concat("ConcurrentModification");
    public static final String ITERATOR_MUTABILITY_ERROR = BALLERINA_PREFIX.concat("IteratorMutabilityError");

    public static final String NUMBER_PARSING_ERROR_IDENTIFIER = "NumberParsingError";
    public static final String BOOLEAN_PARSING_ERROR_IDENTIFIER = "BooleanParsingError";
    public static final String INVALID_UPDATE_ERROR_IDENTIFIER = "InvalidUpdate";
    public static final String INDEX_OUT_OF_RANGE_ERROR_IDENTIFIER = "IndexOutOfRange";
    public static final String INHERENT_TYPE_VIOLATION_ERROR_IDENTIFIER = "InherentTypeViolation";
    public static final String OPERATION_NOT_SUPPORTED_IDENTIFIER = "OperationNotSupported";
    public static final String KEY_NOT_FOUND_ERROR_IDENTIFIER = "KeyNotFound";

    public static final String TRANSACTION_ERROR = BALLERINA_PREFIX.concat("TransactionError");
    public static final String JSON_CONVERSION_ERROR = BALLERINA_PREFIX.concat("JSONConversionError");
    public static final String XML_CREATION_ERROR = BALLERINA_PREFIX.concat("XMLCreationError");
    public static final String STACK_OVERFLOW_ERROR = BALLERINA_PREFIX.concat("StackOverflow");

    public static final String CONSTRUCT_FROM_CONVERSION_ERROR = getModulePrefixedReason(TYPEDESC_LANG_LIB,
                                                                                         "ConversionError");
    public static final String CONSTRUCT_FROM_CYCLIC_VALUE_REFERENCE_ERROR =
            getModulePrefixedReason(TYPEDESC_LANG_LIB, "CyclicValueReferenceError");
    public static final String MERGE_JSON_ERROR = getModulePrefixedReason(VALUE_LANG_LIB, "MergeJsonError");
    public static final String STRING_OPERATION_ERROR = getModulePrefixedReason(STRING_LANG_LIB,
                                                                                "StringOperationError");
    public static final String XML_OPERATION_ERROR = getModulePrefixedReason(XML_LANG_LIB, "XMLOperationError");
    public static final String MAP_KEY_NOT_FOUND_ERROR = getModulePrefixedReason(MAP_LANG_LIB,
                                                                                 KEY_NOT_FOUND_ERROR_IDENTIFIER);
    public static final String TABLE_KEY_NOT_FOUND_ERROR = getModulePrefixedReason(TABLE_LANG_LIB,
            KEY_NOT_FOUND_ERROR_IDENTIFIER);
    public static final String TABLE_KEY_CYCLIC_VALUE_REFERENCE_ERROR =
            getModulePrefixedReason(TABLE_LANG_LIB, "CyclicValueReferenceError");
    public static final String TABLE_HAS_A_VALUE_FOR_KEY_ERROR = getModulePrefixedReason(TABLE_LANG_LIB,
            "KeyConstraintViolation");
    public static final String ILLEGAL_LIST_INSERTION_ERROR = getModulePrefixedReason(ARRAY_LANG_LIB,
                                                                                      "IllegalListInsertion");
    public static final String FUTURE_CANCELLED = getModulePrefixedReason(FUTURE_LANG_LIB, "FutureAlreadyCancelled");

    public static final String ASYNC_CALL_INSIDE_LOCK = BALLERINA_PREFIX.concat("AsyncCallInsideLockError");

    public static String getModulePrefixedReason(String moduleName, String identifier) {
        return BALLERINA_ORG_PREFIX.concat(moduleName).concat(CLOSING_CURLY_BRACE).concat(identifier);
    }
}
