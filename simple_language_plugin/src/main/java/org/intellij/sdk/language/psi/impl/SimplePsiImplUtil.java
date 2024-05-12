// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package org.intellij.sdk.language.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReference;
import org.intellij.sdk.language.SimpleReference;
import org.intellij.sdk.language.psi.SimpleElementFactory;
import org.intellij.sdk.language.psi.SimpleIdentifierElement;
import org.intellij.sdk.language.psi.SimpleProperty;
import org.intellij.sdk.language.psi.SimpleTypes;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.ArrayList;

public class SimplePsiImplUtil {

    public static String getName(SimpleProperty element) {
        return element.getText();
    }

    public static PsiElement setName(SimpleProperty element, String newName) {
        ASTNode keyNode = element.getNode().findChildByType(SimpleTypes.IF);
        if (keyNode != null) {
            SimpleProperty property = SimpleElementFactory.createProperty(element.getProject(), newName);
            ASTNode newKeyNode = property.getFirstChild().getNode();
            element.getNode().replaceChild(keyNode, newKeyNode);
        }
        return element;
    }

    public static PsiElement getNameIdentifier(SimpleProperty element) {
        ASTNode keyNode = element.getNode().findChildByType(SimpleTypes.IF);
        if (keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }

    public static ItemPresentation getPresentation(final SimpleProperty element) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return element.getName();
            }

            @Nullable
            @Override
            public String getLocationString() {
                PsiFile containingFile = element.getContainingFile();
                return containingFile == null ? null : containingFile.getName();
            }

            @Override
            public Icon getIcon(boolean unused) {
                return element.getIcon(0);
            }
        };
    }


    public static String getName(SimpleIdentifierElement element) {
        return element.getText();
    }

    public static PsiElement setName(SimpleIdentifierElement element, String newName) {
        ASTNode node = element.getNode();
        ASTNode parent = node.getTreeParent();
        SimpleIdentifierElement newElement = SimpleElementFactory.createIdentifier(element.getProject(), newName);
        parent.replaceChild(node, newElement.getNode());
        return newElement;
    }

    public static PsiElement getNameIdentifier(SimpleIdentifierElement element) {
        return element;
    }

    public static ItemPresentation getPresentation(final SimpleIdentifierElement element) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return element.getName();
            }

            @Nullable
            @Override
            public String getLocationString() {
                PsiFile containingFile = element.getContainingFile();
                return containingFile == null ? null : containingFile.getName();
            }

            @Override
            public Icon getIcon(boolean unused) {
                return element.getIcon(0);
            }
        };
    }


    public static SimpleReference[] getReferences(final SimpleIdentifierElement element) {
        ArrayList<SimpleReference> references = new ArrayList<>();
        references.add(new SimpleReference(element, new TextRange(0, element.getTextLength())));
        return references.toArray(SimpleReference[]::new);
    }

    public static PsiReference getReference(final SimpleIdentifierElement element) {
        SimpleReference[] references = getReferences(element);
        return references.length > 0 ? references[0] : null;
    }

    public static int getTextOffset(final SimpleIdentifierElement element) {
        return element.getTextRange().getStartOffset();
    }
}
