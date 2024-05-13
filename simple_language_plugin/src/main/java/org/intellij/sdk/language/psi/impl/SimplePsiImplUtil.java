// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package org.intellij.sdk.language.psi.impl;

import com.intellij.icons.AllIcons;
import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.resolve.reference.impl.PsiMultiReference;
import com.intellij.psi.util.PsiTreeUtil;
import org.intellij.sdk.language.SimpleReference;
import org.intellij.sdk.language.psi.*;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

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


    public static String getName(SimpleBlockDefine element) {
        return element.getText();
    }

    public static String getName(SimpleTkIdentifier element) {
        return element.getText();
    }


    public static PsiElement setName(SimpleTkIdentifier element, String newName) {
        ASTNode node = element.getNode();
        ASTNode parent = node.getTreeParent();
        SimpleTkIdentifier newElement = SimpleElementFactory.createIdentifier(element.getProject(), newName);
        parent.replaceChild(node, newElement.getNode());
        return newElement;
    }

    public static PsiElement getNameIdentifier(SimpleTkIdentifier element) {
        return element;
    }

    public static ItemPresentation getPresentation(final SimpleTkIdentifier element) {
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
                return AllIcons.Nodes.Variable;
            }
        };
    }

    public static ItemPresentation getPresentation(final SimpleBlockDefine element) {
        return new ItemPresentation() {
            final SimpleTkIdentifier identifier = PsiTreeUtil.findChildOfType(element, SimpleTkIdentifier.class);

            @Nullable
            @Override
            public String getPresentableText() {
                return Objects.requireNonNull(identifier).getName();
            }

            @Nullable
            @Override
            public String getLocationString() {
                PsiFile containingFile = element.getContainingFile();
                return containingFile == null ? null : containingFile.getName();
            }

            @Override
            public Icon getIcon(boolean unused) {
                return AllIcons.Nodes.Function;
            }
        };
    }


    public static SimpleReference[] getReferences(final SimpleTkIdentifier element) {
        ArrayList<SimpleReference> references = new ArrayList<>();
        references.add(new SimpleReference(element, new TextRange(0, element.getTextLength())));
        return references.toArray(SimpleReference[]::new);
    }

    public static PsiReference getReference(final SimpleTkIdentifier element) {
        SimpleReference[] references = getReferences(element);
        if (references.length == 1) {
            return references[0];
        } else if (references.length > 1) {
            return new PsiMultiReference(references, element);
        } else {
            return null;
        }
    }

    public static int getTextOffset(final SimpleTkIdentifier element) {
        return element.getTextRange().getStartOffset();
    }
}
