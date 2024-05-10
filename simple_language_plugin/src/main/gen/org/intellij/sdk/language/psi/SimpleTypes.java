// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.intellij.sdk.language.psi.impl.*;

public interface SimpleTypes {

  IElementType PROPERTY = new SimpleElementType("PROPERTY");

  IElementType ASSIGNMENT_OPERATOR = new SimpleTokenType("ASSIGNMENT_OPERATOR");
  IElementType BINARY_OPERATOR = new SimpleTokenType("BINARY_OPERATOR");
  IElementType CASE = new SimpleTokenType("CASE");
  IElementType CASEOF = new SimpleTokenType("CASEOF");
  IElementType COMMAND = new SimpleTokenType("COMMAND");
  IElementType COMMA_OPERATOR = new SimpleTokenType("Comma_Operator");
  IElementType COMMENT = new SimpleTokenType("COMMENT");
  IElementType CONTINUE = new SimpleTokenType("CONTINUE");
  IElementType CRLF = new SimpleTokenType("CRLF");
  IElementType DEFINE = new SimpleTokenType("DEFINE");
  IElementType DOT_OPERATOR = new SimpleTokenType("Dot_Operator");
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
  IElementType EXITLOOP = new SimpleTokenType("EXITLOOP");
  IElementType EXITSECTION = new SimpleTokenType("EXITSECTION");
  IElementType FISH = new SimpleTokenType("FISH");
  IElementType FUNCTION_CALL_OPERATOR = new SimpleTokenType("Function_Call_Operator");
  IElementType GLOBAL = new SimpleTokenType("GLOBAL");
  IElementType IDENTIFIER = new SimpleTokenType("IDENTIFIER");
  IElementType IF = new SimpleTokenType("IF");
  IElementType KEYWORD = new SimpleTokenType("KEYWORD");
  IElementType LEFT_CURLY_BRACKET = new SimpleTokenType("Left_Curly_Bracket");
  IElementType LEFT_PARENTHESIS = new SimpleTokenType("Left_Parenthesis");
  IElementType LEFT_SQUARE_BRACKET = new SimpleTokenType("Left_Square_Bracket");
  IElementType LOCAL = new SimpleTokenType("LOCAL");
  IElementType LOCK = new SimpleTokenType("LOCK");
  IElementType LOOP = new SimpleTokenType("LOOP");
  IElementType NUMBER_LITERAL = new SimpleTokenType("NUMBER_LITERAL");
  IElementType RETURN = new SimpleTokenType("RETURN");
  IElementType RIGHT_CURLY_BRACKET = new SimpleTokenType("Right_Curly_Bracket");
  IElementType RIGHT_PARENTHESIS = new SimpleTokenType("Right_Parenthesis");
  IElementType RIGHT_SQUARE_BRACKET = new SimpleTokenType("Right_Square_Bracket");
  IElementType SECTION = new SimpleTokenType("SECTION");
  IElementType STRING_LITERAL = new SimpleTokenType("STRING_LITERAL");
  IElementType STRUCT = new SimpleTokenType("STRUCT");
  IElementType THEN = new SimpleTokenType("THEN");
  IElementType UNARY_OPERATOR = new SimpleTokenType("UNARY_OPERATOR");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == PROPERTY) {
        return new SimplePropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
