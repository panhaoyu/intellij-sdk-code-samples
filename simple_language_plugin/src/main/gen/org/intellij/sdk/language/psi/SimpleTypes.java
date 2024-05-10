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
  IElementType COMMA_OPERATOR = new SimpleTokenType("Comma_Operator");
  IElementType COMMENT = new SimpleTokenType("COMMENT");
  IElementType CRLF = new SimpleTokenType("CRLF");
  IElementType DOT_OPERATOR = new SimpleTokenType("Dot_Operator");
  IElementType FUNCTION_CALL_OPERATOR = new SimpleTokenType("Function_Call_Operator");
  IElementType IDENTIFIER = new SimpleTokenType("IDENTIFIER");
  IElementType KEY = new SimpleTokenType("KEY");
  IElementType KEYWORD = new SimpleTokenType("KEYWORD");
  IElementType LEFT_CURLY_BRACKET = new SimpleTokenType("Left_Curly_Bracket");
  IElementType LEFT_PARENTHESIS = new SimpleTokenType("Left_Parenthesis");
  IElementType LEFT_SQUARE_BRACKET = new SimpleTokenType("Left_Square_Bracket");
  IElementType NUMBER_LITERAL = new SimpleTokenType("NUMBER_LITERAL");
  IElementType RIGHT_CURLY_BRACKET = new SimpleTokenType("Right_Curly_Bracket");
  IElementType RIGHT_PARENTHESIS = new SimpleTokenType("Right_Parenthesis");
  IElementType RIGHT_SQUARE_BRACKET = new SimpleTokenType("Right_Square_Bracket");
  IElementType SEPARATOR = new SimpleTokenType("SEPARATOR");
  IElementType STRING_LITERAL = new SimpleTokenType("STRING_LITERAL");
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
