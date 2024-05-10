// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.intellij.sdk.language.psi.impl.*;

public interface SimpleTypes {

  IElementType PROPERTY = new SimpleElementType("PROPERTY");

  IElementType COMMENT = new SimpleTokenType("COMMENT");
  IElementType CRLF = new SimpleTokenType("CRLF");
  IElementType FISH_FUNCTION = new SimpleTokenType("FISH_FUNCTION");
  IElementType IDENTIFIER = new SimpleTokenType("IDENTIFIER");
  IElementType KEYWORD = new SimpleTokenType("KEYWORD");
  IElementType NUMBER_LITERAL = new SimpleTokenType("NUMBER_LITERAL");
  IElementType OPERATOR = new SimpleTokenType("OPERATOR");
  IElementType STRING_LITERAL = new SimpleTokenType("STRING_LITERAL");

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
