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
import org.intellij.sdk.language.psi.SimpleCommandBlockDefine;
import org.intellij.sdk.language.psi.SimpleElementFactory;
import org.intellij.sdk.language.psi.SimpleTkIdentifierRaw;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

public class SimplePsiImplUtil {
    public static String getName(SimpleCommandBlockDefine element) {
        SimpleTkIdentifierRaw child = PsiTreeUtil.findChildOfType(element, SimpleTkIdentifierRaw.class);
        return Objects.requireNonNull(child).getName();
    }

    public static String getName(SimpleTkIdentifierRaw element) {
        return element.getText();
    }


    public static PsiElement setName(SimpleTkIdentifierRaw element, String newName) {
        ASTNode node = element.getNode();
        ASTNode parent = node.getTreeParent();
        SimpleTkIdentifierRaw newElement = SimpleElementFactory.createIdentifier(element.getProject(), newName);
        parent.replaceChild(node, newElement.getNode());
        return newElement;
    }

    public static PsiElement getNameIdentifier(SimpleTkIdentifierRaw element) {
        return element;
    }

    public static ItemPresentation getPresentation(final SimpleTkIdentifierRaw element) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                @Nullable SimpleCommandBlockDefine parent = PsiTreeUtil.getParentOfType(element, SimpleCommandBlockDefine.class);
                String name = element.getName();
                if (parent == null) {
                    return name;
                } else {
                    String parentName = parent.getName();
                    return parentName + "/" + name;
                }
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

    public static ItemPresentation getPresentation(final SimpleCommandBlockDefine element) {
        return new ItemPresentation() {
            final SimpleTkIdentifierRaw identifier = PsiTreeUtil.findChildOfType(element, SimpleTkIdentifierRaw.class);

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


    public static SimpleReference @NotNull [] getReferences(final SimpleTkIdentifierRaw element) {
        ArrayList<SimpleReference> references = new ArrayList<>();
        references.add(new SimpleReference(element, new TextRange(0, element.getTextLength())));
        return references.toArray(SimpleReference[]::new);
    }

    public static PsiReference getReference(final SimpleTkIdentifierRaw element) {
        SimpleReference[] references = getReferences(element);
        if (references.length == 1) {
            return references[0];
        } else if (references.length > 1) {
            return new PsiMultiReference(references, element);
        } else {
            return null;
        }
    }

    public static int getTextOffset(final SimpleTkIdentifierRaw element) {
        return element.getTextRange().getStartOffset();
    }
}
