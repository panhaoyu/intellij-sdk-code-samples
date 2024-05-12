// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiReference;
import org.intellij.sdk.language.SimpleReference;
import org.intellij.sdk.language.SimpleUtil;
import org.intellij.sdk.language.psi.SimpleIdentifierElement;
import org.intellij.sdk.language.psi.SimpleNamedElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public abstract class SimpleNamedElementImpl extends ASTWrapperPsiElement implements SimpleNamedElement {
    public SimpleNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }

    private static final Logger LOG = Logger.getInstance(SimpleNamedElementImpl.class);


    @Override
    public PsiReference getReference() {
        if (!(this instanceof SimpleIdentifierElement)) return null; // 仅处理IdentifierElement
        Project project = this.getProject();
        String currentName = this.getName();

        List<SimpleIdentifierElement> declarations = SimpleUtil.findDeclarations(project);

        for (SimpleIdentifierElement declaration : declarations) {
            String declarationName = declaration.getName();
            if (Objects.equals(declarationName, currentName)) {
                if (!declaration.equals(this)) {
                    return new SimpleReference(declaration, declaration.getTextRange());
                }
            }
        }
        return null;
    }
}