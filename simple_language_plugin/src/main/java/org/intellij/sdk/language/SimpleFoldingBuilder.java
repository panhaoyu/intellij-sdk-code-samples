// Copyright 2000-2024 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package org.intellij.sdk.language;

import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilderEx;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.FoldingGroup;
import com.intellij.psi.PsiElement;
import org.intellij.sdk.language.psi.SimpleBlockCmd;
import org.intellij.sdk.language.psi.SimpleBlockDefine;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

// SimpleFoldingBuilder类，实现代码折叠构建
final class SimpleFoldingBuilder extends FoldingBuilderEx {

    // 构建折叠区域的方法
    @Override
    public FoldingDescriptor @NotNull [] buildFoldRegions(@NotNull PsiElement root,
                                                          @NotNull Document document,
                                                          boolean quick) {


        List<FoldingDescriptor> descriptors = new ArrayList<>();
        root.accept(new FishRecursiveElementWalkingVisitor() {
            @Override
            public void visitBlockCmd(@NotNull SimpleBlockCmd o) {
                super.visitBlockCmd(o);
                String groupName = "CommandBlock";
                FoldingGroup group = FoldingGroup.newGroup(o.getContainingFile().getName() + "/" + groupName + "/" + o.getTextRange());
                descriptors.add(new FoldingDescriptor(o.getNode(), o.getTextRange(), group));
            }

            @Override
            public void visitBlockDefine(@NotNull SimpleBlockDefine o) {
                super.visitBlockDefine(o);
                String groupName = "FishDefineBlock";
                FoldingGroup group = FoldingGroup.newGroup(o.getContainingFile().getName() + "/" + groupName + "/" + o.getTextRange());
                descriptors.add(new FoldingDescriptor(o.getNode(), o.getTextRange(), group));
            }
        });
        return descriptors.toArray(new FoldingDescriptor[0]);
    }

    // 获取占位文本的方法，通常用于显示折叠时的简略信息
    @Override
    public String getPlaceholderText(@NotNull ASTNode node) {
        return node.getText();
    }

    // 判断节点在初始化时是否应该默认折叠


    @Override
    public boolean isCollapsedByDefault(@NotNull ASTNode node) {
        return false;
    }

}