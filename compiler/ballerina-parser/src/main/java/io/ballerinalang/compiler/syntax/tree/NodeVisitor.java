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
package io.ballerinalang.compiler.syntax.tree;


/**
 * The {@code NodeVisitor} visits each node in the syntax tree allowing
 * us to do something at each node.
 * <p>
 * This class separates tree nodes from various unrelated operations that needs
 * to be performed on the syntax tree nodes.
 * <p>
 * {@code NodeVisitor} is a abstract class that itself visits the complete
 * tree. Subclasses have the ability to override only the required visit methods.
 * <p>
 * There exists a visit method for each node in the Ballerina syntax tree.
 * These methods return void. If you are looking for a visitor that has visit
 * methods that returns something, see {@link NodeTransformer}.
 *
 * This is a generated class.
 *
 * @see NodeTransformer
 * @since 1.3.0
 */
public abstract class NodeVisitor {

    public void visit(ModulePartNode modulePartNode) {
        visitSyntaxNode(modulePartNode);
    }

    public void visit(FunctionDefinitionNode functionDefinitionNode) {
        visitSyntaxNode(functionDefinitionNode);
    }

    public void visit(ImportDeclarationNode importDeclarationNode) {
        visitSyntaxNode(importDeclarationNode);
    }

    public void visit(ListenerDeclarationNode listenerDeclarationNode) {
        visitSyntaxNode(listenerDeclarationNode);
    }

    public void visit(TypeDefinitionNode typeDefinitionNode) {
        visitSyntaxNode(typeDefinitionNode);
    }

    public void visit(ServiceDeclarationNode serviceDeclarationNode) {
        visitSyntaxNode(serviceDeclarationNode);
    }

    public void visit(AssignmentStatementNode assignmentStatementNode) {
        visitSyntaxNode(assignmentStatementNode);
    }

    public void visit(CompoundAssignmentStatementNode compoundAssignmentStatementNode) {
        visitSyntaxNode(compoundAssignmentStatementNode);
    }

    public void visit(VariableDeclarationNode variableDeclarationNode) {
        visitSyntaxNode(variableDeclarationNode);
    }

    public void visit(BlockStatementNode blockStatementNode) {
        visitSyntaxNode(blockStatementNode);
    }

    public void visit(BreakStatementNode breakStatementNode) {
        visitSyntaxNode(breakStatementNode);
    }

    public void visit(ExpressionStatementNode expressionStatementNode) {
        visitSyntaxNode(expressionStatementNode);
    }

    public void visit(ContinueStatementNode continueStatementNode) {
        visitSyntaxNode(continueStatementNode);
    }

    public void visit(ExternalFunctionBodyNode externalFunctionBodyNode) {
        visitSyntaxNode(externalFunctionBodyNode);
    }

    public void visit(IfElseStatementNode ifElseStatementNode) {
        visitSyntaxNode(ifElseStatementNode);
    }

    public void visit(ElseBlockNode elseBlockNode) {
        visitSyntaxNode(elseBlockNode);
    }

    public void visit(WhileStatementNode whileStatementNode) {
        visitSyntaxNode(whileStatementNode);
    }

    public void visit(PanicStatementNode panicStatementNode) {
        visitSyntaxNode(panicStatementNode);
    }

    public void visit(ReturnStatementNode returnStatementNode) {
        visitSyntaxNode(returnStatementNode);
    }

    public void visit(LocalTypeDefinitionStatementNode localTypeDefinitionStatementNode) {
        visitSyntaxNode(localTypeDefinitionStatementNode);
    }

    public void visit(LockStatementNode lockStatementNode) {
        visitSyntaxNode(lockStatementNode);
    }

    public void visit(BinaryExpressionNode binaryExpressionNode) {
        visitSyntaxNode(binaryExpressionNode);
    }

    public void visit(BracedExpressionNode bracedExpressionNode) {
        visitSyntaxNode(bracedExpressionNode);
    }

    public void visit(CheckExpressionNode checkExpressionNode) {
        visitSyntaxNode(checkExpressionNode);
    }

    public void visit(FieldAccessExpressionNode fieldAccessExpressionNode) {
        visitSyntaxNode(fieldAccessExpressionNode);
    }

    public void visit(FunctionCallExpressionNode functionCallExpressionNode) {
        visitSyntaxNode(functionCallExpressionNode);
    }

    public void visit(MethodCallExpressionNode methodCallExpressionNode) {
        visitSyntaxNode(methodCallExpressionNode);
    }

    public void visit(MappingConstructorExpressionNode mappingConstructorExpressionNode) {
        visitSyntaxNode(mappingConstructorExpressionNode);
    }

    public void visit(MemberAccessExpressionNode memberAccessExpressionNode) {
        visitSyntaxNode(memberAccessExpressionNode);
    }

    public void visit(TypeofExpressionNode typeofExpressionNode) {
        visitSyntaxNode(typeofExpressionNode);
    }

    public void visit(UnaryExpressionNode unaryExpressionNode) {
        visitSyntaxNode(unaryExpressionNode);
    }

    public void visit(ComputedNameFieldNode computedNameFieldNode) {
        visitSyntaxNode(computedNameFieldNode);
    }

    public void visit(ConstantDeclarationNode constantDeclarationNode) {
        visitSyntaxNode(constantDeclarationNode);
    }

    public void visit(DefaultableParameterNode defaultableParameterNode) {
        visitSyntaxNode(defaultableParameterNode);
    }

    public void visit(RequiredParameterNode requiredParameterNode) {
        visitSyntaxNode(requiredParameterNode);
    }

    public void visit(RestParameterNode restParameterNode) {
        visitSyntaxNode(restParameterNode);
    }

    public void visit(ExpressionListItemNode expressionListItemNode) {
        visitSyntaxNode(expressionListItemNode);
    }

    public void visit(ImportOrgNameNode importOrgNameNode) {
        visitSyntaxNode(importOrgNameNode);
    }

    public void visit(ImportPrefixNode importPrefixNode) {
        visitSyntaxNode(importPrefixNode);
    }

    public void visit(ImportSubVersionNode importSubVersionNode) {
        visitSyntaxNode(importSubVersionNode);
    }

    public void visit(ImportVersionNode importVersionNode) {
        visitSyntaxNode(importVersionNode);
    }

    public void visit(SpecificFieldNode specificFieldNode) {
        visitSyntaxNode(specificFieldNode);
    }

    public void visit(SpreadFieldNode spreadFieldNode) {
        visitSyntaxNode(spreadFieldNode);
    }

    public void visit(NamedArgumentNode namedArgumentNode) {
        visitSyntaxNode(namedArgumentNode);
    }

    public void visit(PositionalArgumentNode positionalArgumentNode) {
        visitSyntaxNode(positionalArgumentNode);
    }

    public void visit(RestArgumentNode restArgumentNode) {
        visitSyntaxNode(restArgumentNode);
    }

    public void visit(ObjectTypeDescriptorNode objectTypeDescriptorNode) {
        visitSyntaxNode(objectTypeDescriptorNode);
    }

    public void visit(RecordTypeDescriptorNode recordTypeDescriptorNode) {
        visitSyntaxNode(recordTypeDescriptorNode);
    }

    public void visit(ReturnTypeDescriptorNode returnTypeDescriptorNode) {
        visitSyntaxNode(returnTypeDescriptorNode);
    }

    public void visit(NilTypeDescriptorNode nilTypeDescriptorNode) {
        visitSyntaxNode(nilTypeDescriptorNode);
    }

    public void visit(OptionalTypeDescriptorNode optionalTypeDescriptorNode) {
        visitSyntaxNode(optionalTypeDescriptorNode);
    }

    public void visit(ObjectFieldNode objectFieldNode) {
        visitSyntaxNode(objectFieldNode);
    }

    public void visit(RecordFieldNode recordFieldNode) {
        visitSyntaxNode(recordFieldNode);
    }

    public void visit(RecordFieldWithDefaultValueNode recordFieldWithDefaultValueNode) {
        visitSyntaxNode(recordFieldWithDefaultValueNode);
    }

    public void visit(RecordRestDescriptorNode recordRestDescriptorNode) {
        visitSyntaxNode(recordRestDescriptorNode);
    }

    public void visit(TypeReferenceNode typeReferenceNode) {
        visitSyntaxNode(typeReferenceNode);
    }

    public void visit(QualifiedIdentifierNode qualifiedIdentifierNode) {
        visitSyntaxNode(qualifiedIdentifierNode);
    }

    public void visit(ServiceBodyNode serviceBodyNode) {
        visitSyntaxNode(serviceBodyNode);
    }

    public void visit(AnnotationNode annotationNode) {
        visitSyntaxNode(annotationNode);
    }

    public void visit(MetadataNode metadataNode) {
        visitSyntaxNode(metadataNode);
    }

    public void visit(ModuleVariableDeclarationNode moduleVariableDeclarationNode) {
        visitSyntaxNode(moduleVariableDeclarationNode);
    }

    public void visit(TypeTestExpressionNode typeTestExpressionNode) {
        visitSyntaxNode(typeTestExpressionNode);
    }

    public void visit(ArrayTypeDescriptorNode arrayTypeDescriptorNode) {
        visitSyntaxNode(arrayTypeDescriptorNode);
    }

    public void visit(RemoteMethodCallActionNode remoteMethodCallActionNode) {
        visitSyntaxNode(remoteMethodCallActionNode);
    }

    public void visit(NilLiteralNode nilLiteralNode) {
        visitSyntaxNode(nilLiteralNode);
    }

    public void visit(AnnotationDeclarationNode annotationDeclarationNode) {
        visitSyntaxNode(annotationDeclarationNode);
    }

    public void visit(AnnotationAttachPointNode annotationAttachPointNode) {
        visitSyntaxNode(annotationAttachPointNode);
    }

    public void visit(XMLNamespaceDeclarationNode xMLNamespaceDeclarationNode) {
        visitSyntaxNode(xMLNamespaceDeclarationNode);
    }

    public void visit(FunctionBodyBlockNode functionBodyBlockNode) {
        visitSyntaxNode(functionBodyBlockNode);
    }

    public void visit(NamedWorkerDeclarationNode namedWorkerDeclarationNode) {
        visitSyntaxNode(namedWorkerDeclarationNode);
    }

    public void visit(NamedWorkerDeclarator namedWorkerDeclarator) {
        visitSyntaxNode(namedWorkerDeclarator);
    }

    public void visit(DocumentationStringNode documentationStringNode) {
        visitSyntaxNode(documentationStringNode);
    }

    // Tokens

    public void visit(Token token) {
    }

    // Misc

    public void visit(Minutiae minutiae) {
    }

    protected void visitSyntaxNode(Node node) {
        // TODO Find a better way to check for token
        if (node instanceof Token) {
            node.accept(this);
            return;
        }

        NonTerminalNode nonTerminalNode = (NonTerminalNode) node;
        for (Node child : nonTerminalNode.children()) {
            child.accept(this);
        }
    }
}
