// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.intellij.sdk.language.psi.impl.*;

public interface SimpleTypes {

  IElementType ASSIGNMENT_STATEMENT = new SimpleElementType("ASSIGNMENT_STATEMENT");
  IElementType CASE_BLOCK = new SimpleElementType("CASE_BLOCK");
  IElementType COMMAND_BLOCK = new SimpleElementType("COMMAND_BLOCK");
  IElementType COMMAND_SCOPE = new SimpleElementType("COMMAND_SCOPE");
  IElementType COMMAND_SCOPE_INLINE_FISH_STATEMENT = new SimpleElementType("COMMAND_SCOPE_INLINE_FISH_STATEMENT");
  IElementType ELSE_IF_STATEMENT = new SimpleElementType("ELSE_IF_STATEMENT");
  IElementType ELSE_STATEMENT = new SimpleElementType("ELSE_STATEMENT");
  IElementType FISH_BLOCK = new SimpleElementType("FISH_BLOCK");
  IElementType FISH_STATEMENT = new SimpleElementType("FISH_STATEMENT");
  IElementType FUNCTION_CALL_STATEMENT = new SimpleElementType("FUNCTION_CALL_STATEMENT");
  IElementType FUNCTION_DEFINE = new SimpleElementType("FUNCTION_DEFINE");
  IElementType IDENTIFIER_ELEMENT = new SimpleElementType("IDENTIFIER_ELEMENT");
  IElementType IF_BLOCK = new SimpleElementType("IF_BLOCK");
  IElementType LITERAL = new SimpleElementType("LITERAL");
  IElementType LOOP_BLOCK = new SimpleElementType("LOOP_BLOCK");
  IElementType PROPERTY = new SimpleElementType("PROPERTY");
  IElementType VALUE = new SimpleElementType("VALUE");

  IElementType ARRAY = new SimpleTokenType("[Aa]rray");
  IElementType ASSIGNMENT_OPERATOR = new SimpleTokenType("=");
  IElementType BINARY_OPERATOR = new SimpleTokenType("BINARY_OPERATOR");
  IElementType BREAK = new SimpleTokenType("break");
  IElementType CASE = new SimpleTokenType("case");
  IElementType CASEOF = new SimpleTokenType("caseof");
  IElementType COMMAND = new SimpleTokenType("command");
  IElementType COMMA_OPERATOR = new SimpleTokenType(",");
  IElementType COMMENT = new SimpleTokenType(";.*?");
  IElementType CONTINUE = new SimpleTokenType("continue");
  IElementType DEFINE = new SimpleTokenType("define");
  IElementType DOT_OPERATOR = new SimpleTokenType(".");
  IElementType ELLIPSIS = new SimpleTokenType("...");
  IElementType ELSE = new SimpleTokenType("else");
  IElementType ELSEIF = new SimpleTokenType("else if");
  IElementType END = new SimpleTokenType("end");
  IElementType ENDCASE = new SimpleTokenType("endcase");
  IElementType ENDCOMMAND = new SimpleTokenType("endcommand");
  IElementType ENDIF = new SimpleTokenType("endif");
  IElementType ENDLOOP = new SimpleTokenType("endloop");
  IElementType ENDSECTION = new SimpleTokenType("endsection");
  IElementType EXIT = new SimpleTokenType("exit");
  IElementType FISH = new SimpleTokenType("fish");
  IElementType FOR = new SimpleTokenType("for");
  IElementType FOREACH = new SimpleTokenType("foreach");
  IElementType FUNCTION_CALL_OPERATOR = new SimpleTokenType("@");
  IElementType GLOBAL = new SimpleTokenType("global");
  IElementType IDENTIFIER = new SimpleTokenType("IDENTIFIER");
  IElementType IF = new SimpleTokenType("if");
  IElementType LEFT_CURLY_BRACKET = new SimpleTokenType("{");
  IElementType LEFT_PARENTHESIS = new SimpleTokenType("(");
  IElementType LEFT_SQUARE_BRACKET = new SimpleTokenType("[");
  IElementType LOCAL = new SimpleTokenType("local");
  IElementType LOCK = new SimpleTokenType("lock");
  IElementType LOOP = new SimpleTokenType("loop");
  IElementType MINUS_OPERATOR = new SimpleTokenType("MINUS_OPERATOR");
  IElementType NEWLINE = new SimpleTokenType("NEWLINE");
  IElementType NUMBER_LITERAL = new SimpleTokenType("[0-9][0-9*](\\.[0-9])?");
  IElementType RETURN = new SimpleTokenType("return");
  IElementType RIGHT_CURLY_BRACKET = new SimpleTokenType("}");
  IElementType RIGHT_PARENTHESIS = new SimpleTokenType(")");
  IElementType RIGHT_SQUARE_BRACKET = new SimpleTokenType("]");
  IElementType SECTION = new SimpleTokenType("section");
  IElementType STRING_LITERAL = new SimpleTokenType("\".*?\"");
  IElementType STRUCT = new SimpleTokenType("struct");
  IElementType THEN = new SimpleTokenType("then");
  IElementType UNARY_OPERATOR = new SimpleTokenType("UNARY_OPERATOR");
  IElementType WHILE = new SimpleTokenType("while");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ASSIGNMENT_STATEMENT) {
        return new SimpleAssignmentStatementImpl(node);
      }
      else if (type == CASE_BLOCK) {
        return new SimpleCaseBlockImpl(node);
      }
      else if (type == COMMAND_BLOCK) {
        return new SimpleCommandBlockImpl(node);
      }
      else if (type == COMMAND_SCOPE) {
        return new SimpleCommandScopeImpl(node);
      }
      else if (type == COMMAND_SCOPE_INLINE_FISH_STATEMENT) {
        return new SimpleCommandScopeInlineFishStatementImpl(node);
      }
      else if (type == ELSE_IF_STATEMENT) {
        return new SimpleElseIfStatementImpl(node);
      }
      else if (type == ELSE_STATEMENT) {
        return new SimpleElseStatementImpl(node);
      }
      else if (type == FISH_BLOCK) {
        return new SimpleFishBlockImpl(node);
      }
      else if (type == FISH_STATEMENT) {
        return new SimpleFishStatementImpl(node);
      }
      else if (type == FUNCTION_CALL_STATEMENT) {
        return new SimpleFunctionCallStatementImpl(node);
      }
      else if (type == FUNCTION_DEFINE) {
        return new SimpleFunctionDefineImpl(node);
      }
      else if (type == IDENTIFIER_ELEMENT) {
        return new SimpleIdentifierElementImpl(node);
      }
      else if (type == IF_BLOCK) {
        return new SimpleIfBlockImpl(node);
      }
      else if (type == LITERAL) {
        return new SimpleLiteralImpl(node);
      }
      else if (type == LOOP_BLOCK) {
        return new SimpleLoopBlockImpl(node);
      }
      else if (type == PROPERTY) {
        return new SimplePropertyImpl(node);
      }
      else if (type == VALUE) {
        return new SimpleValueImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
