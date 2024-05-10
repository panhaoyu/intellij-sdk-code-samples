// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import org.intellij.sdk.language.psi.impl.SimplePropertyImpl;

public interface SimpleTypes {

    IElementType PROPERTY = new SimpleElementType("PROPERTY");

    IElementType COMMENT = new SimpleTokenType("COMMENT");
    IElementType CRLF = new SimpleTokenType("CRLF");
    IElementType KEYWORD = new SimpleTokenType("KEYWORD");
    IElementType SEPARATOR = new SimpleTokenType("SEPARATOR");
    IElementType STRING_LITERAL = new SimpleTokenType("STRING_LITERAL");
    IElementType NUMBER_LITERAL = new SimpleTokenType("NUMBER_LITERAL");
    IElementType IDENTIFIER = new SimpleTokenType("IDENTIFIER");
    IElementType OPERATOR = new SimpleTokenType("OPERATOR");

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
