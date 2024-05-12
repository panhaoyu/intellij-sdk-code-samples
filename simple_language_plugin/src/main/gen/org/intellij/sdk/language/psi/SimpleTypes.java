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
  IElementType COMMAND_SCOPE_INLINE_FISH_STATEMENT = new SimpleElementType("COMMAND_SCOPE_INLINE_FISH_STATEMENT");
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

  IElementType ARRAY = new SimpleTokenType("ARRAY");
  IElementType ASSIGNMENT_OPERATOR = new SimpleTokenType("ASSIGNMENT_OPERATOR");
  IElementType BINARY_OPERATOR = new SimpleTokenType("BINARY_OPERATOR");
  IElementType BREAK = new SimpleTokenType("BREAK");
  IElementType CASE = new SimpleTokenType("CASE");
  IElementType CASEOF = new SimpleTokenType("CASEOF");
  IElementType COMMAND = new SimpleTokenType("COMMAND");
  IElementType COMMA_OPERATOR = new SimpleTokenType("COMMA_OPERATOR");
  IElementType COMMENT = new SimpleTokenType("COMMENT");
  IElementType CONTINUE = new SimpleTokenType("CONTINUE");
  IElementType DEFINE = new SimpleTokenType("DEFINE");
  IElementType DOT_OPERATOR = new SimpleTokenType("DOT_OPERATOR");
  IElementType ELLIPSIS = new SimpleTokenType("ELLIPSIS");
  IElementType ELSE = new SimpleTokenType("ELSE");
  IElementType ELSEIF = new SimpleTokenType("ELSEIF");
  IElementType END = new SimpleTokenType("END");
  IElementType ENDCASE = new SimpleTokenType("ENDCASE");
  IElementType ENDCOMMAND = new SimpleTokenType("ENDCOMMAND");
  IElementType ENDIF = new SimpleTokenType("ENDIF");
  IElementType ENDLOOP = new SimpleTokenType("ENDLOOP");
  IElementType ENDSECTION = new SimpleTokenType("ENDSECTION");
  IElementType EXIT = new SimpleTokenType("EXIT");
  IElementType FISH = new SimpleTokenType("FISH");
  IElementType FOR = new SimpleTokenType("FOR");
  IElementType FOREACH = new SimpleTokenType("FOREACH");
  IElementType FUNCTION_CALL_OPERATOR = new SimpleTokenType("FUNCTION_CALL_OPERATOR");
  IElementType GLOBAL = new SimpleTokenType("GLOBAL");
  IElementType IDENTIFIER = new SimpleTokenType("IDENTIFIER");
  IElementType IF = new SimpleTokenType("IF");
  IElementType LEFT_CURLY_BRACKET = new SimpleTokenType("LEFT_CURLY_BRACKET");
  IElementType LEFT_PARENTHESIS = new SimpleTokenType("LEFT_PARENTHESIS");
  IElementType LEFT_SQUARE_BRACKET = new SimpleTokenType("LEFT_SQUARE_BRACKET");
  IElementType LOCAL = new SimpleTokenType("LOCAL");
  IElementType LOCK = new SimpleTokenType("LOCK");
  IElementType LOOP = new SimpleTokenType("LOOP");
  IElementType MINUS_OPERATOR = new SimpleTokenType("MINUS_OPERATOR");
  IElementType NEWLINE = new SimpleTokenType("NEWLINE");
  IElementType NUMBER_LITERAL = new SimpleTokenType("NUMBER_LITERAL");
  IElementType RETURN = new SimpleTokenType("RETURN");
  IElementType RIGHT_CURLY_BRACKET = new SimpleTokenType("RIGHT_CURLY_BRACKET");
  IElementType RIGHT_PARENTHESIS = new SimpleTokenType("RIGHT_PARENTHESIS");
  IElementType RIGHT_SQUARE_BRACKET = new SimpleTokenType("RIGHT_SQUARE_BRACKET");
  IElementType SECTION = new SimpleTokenType("SECTION");
  IElementType STRING_LITERAL = new SimpleTokenType("STRING_LITERAL");
  IElementType STRUCT = new SimpleTokenType("STRUCT");
  IElementType THEN = new SimpleTokenType("THEN");
  IElementType UNARY_OPERATOR = new SimpleTokenType("UNARY_OPERATOR");
  IElementType WHILE = new SimpleTokenType("WHILE");

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
      else if (type == COMMAND_SCOPE_INLINE_FISH_STATEMENT) {
        return new SimpleCommandScopeInlineFishStatementImpl(node);
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
