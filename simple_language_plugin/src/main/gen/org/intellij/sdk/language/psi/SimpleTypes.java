// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.intellij.sdk.language.psi.impl.*;

public interface SimpleTypes {

  IElementType FUNCTION_DEFINE = new SimpleElementType("FUNCTION_DEFINE");
  IElementType FUNCTION_DEFINE_HEADER = new SimpleElementType("FUNCTION_DEFINE_HEADER");
  IElementType PROPERTY = new SimpleElementType("PROPERTY");
  IElementType SINGLE_STATEMENT = new SimpleElementType("SINGLE_STATEMENT");
  IElementType STATEMENT_BLOCK = new SimpleElementType("STATEMENT_BLOCK");

  IElementType ASSIGNMENT_OPERATOR = new SimpleTokenType("ASSIGNMENT_OPERATOR");
  IElementType BINARY_OPERATOR = new SimpleTokenType("BINARY_OPERATOR");
  IElementType CASE = new SimpleTokenType("CASE");
  IElementType CASEOF = new SimpleTokenType("CASEOF");
  IElementType COMMAND = new SimpleTokenType("COMMAND");
  IElementType COMMA_OPERATOR = new SimpleTokenType("COMMA_OPERATOR");
  IElementType COMMENT = new SimpleTokenType("COMMENT");
  IElementType CONTINUE = new SimpleTokenType("CONTINUE");
  IElementType CRLF = new SimpleTokenType("CRLF");
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
  IElementType FUNCTION_CALL_OPERATOR = new SimpleTokenType("FUNCTION_CALL_OPERATOR");
  IElementType GLOBAL = new SimpleTokenType("GLOBAL");
  IElementType IDENTIFIER = new SimpleTokenType("IDENTIFIER");
  IElementType IF = new SimpleTokenType("IF");
  IElementType KEYWORD = new SimpleTokenType("KEYWORD");
  IElementType KEYWORDS_IN_COMMAND_BLOCK_22_0 = new SimpleTokenType("keywords_in_command_block_22_0");
  IElementType LEFT_CURLY_BRACKET = new SimpleTokenType("LEFT_CURLY_BRACKET");
  IElementType LEFT_PARENTHESIS = new SimpleTokenType("LEFT_PARENTHESIS");
  IElementType LEFT_SQUARE_BRACKET = new SimpleTokenType("LEFT_SQUARE_BRACKET");
  IElementType LOCAL = new SimpleTokenType("LOCAL");
  IElementType LOCK = new SimpleTokenType("LOCK");
  IElementType LOOP = new SimpleTokenType("LOOP");
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

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == FUNCTION_DEFINE) {
        return new SimpleFunctionDefineImpl(node);
      }
      else if (type == FUNCTION_DEFINE_HEADER) {
        return new SimpleFunctionDefineHeaderImpl(node);
      }
      else if (type == PROPERTY) {
        return new SimplePropertyImpl(node);
      }
      else if (type == SINGLE_STATEMENT) {
        return new SimpleSingleStatementImpl(node);
      }
      else if (type == STATEMENT_BLOCK) {
        return new SimpleStatementBlockImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
