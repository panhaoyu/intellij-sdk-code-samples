// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiReference;
import org.intellij.sdk.language.SimpleReference;
import org.intellij.sdk.language.SimpleUtil;
import org.intellij.sdk.language.psi.SimpleNamedElement;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public abstract class SimpleNamedElementImpl extends ASTWrapperPsiElement implements SimpleNamedElement {

    public SimpleNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }

    /**
     * Checks if this element is the declaration of the identifier.
     *
     * @return true if this is the first occurrence of the identifier in the scope.
     */
    private boolean isDeclaration() {
        // Assuming that a declaration in your language is defined as the first occurrence
        // in the file or a specific structural scope.
        SimpleNamedElement firstDeclaration = SimpleUtil.findDeclarations(this.getProject()).stream()
                .filter(e -> Objects.equals(e.getName(), this.getName()) && e.equals(this))
                .findFirst()
                .orElse(null);

        return firstDeclaration != null && firstDeclaration.equals(this);
    }

    @Override
    public PsiReference getReference() {
        if (this.isDeclaration()) {
            return null;
        }
        return new SimpleReference(this, getTextRange());
    }
}
