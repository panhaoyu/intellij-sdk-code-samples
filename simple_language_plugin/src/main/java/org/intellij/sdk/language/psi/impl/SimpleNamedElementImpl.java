// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
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


    @Override
    public PsiReference getReference() {
        // 获取当前项目
        @NotNull Project project = this.getProject();
        // 查找所有的声明
        List<SimpleIdentifierElement> declarations = SimpleUtil.findDeclarations(project);
        // 流处理，筛选出第一个同名的元素
        return declarations.stream()
                .filter(e -> Objects.equals(e.getName(), this.getName()) && !e.equals(this))
                .findFirst()
                .map(e -> new SimpleReference(e, e.getTextRange())) // 创建引用
                .orElse(null); // 如果没有找到任何匹配项，则返回null
    }
}
