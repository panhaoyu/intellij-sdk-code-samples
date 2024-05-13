// Copyright 2000-2024 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package org.intellij.sdk.language;

import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilderEx;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.FoldingGroup;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLiteralExpression;
import com.intellij.psi.util.PsiLiteralUtil;
import com.intellij.util.containers.ContainerUtil;
import org.intellij.sdk.language.psi.SimpleBlockCmd;
import org.intellij.sdk.language.psi.SimpleBlockDefine;
import org.intellij.sdk.language.psi.SimpleProperty;
import org.intellij.sdk.language.psi.SimpleVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
        SimpleVisitor simpleVisitor = new FishRecursiveElementWalkingVisitor() {
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
        };
        root.accept(simpleVisitor);
        return descriptors.toArray(new FoldingDescriptor[0]);
    }

    // 获取占位文本的方法，通常用于显示折叠时的简略信息

    /**
     * Gets the Simple Language 'value' string corresponding to the 'key'
     *
     * @param node Node corresponding to PsiLiteralExpression containing a string in the format
     *             SIMPLE_PREFIX_STR + SIMPLE_SEPARATOR_STR + Key, where Key is
     *             defined by the Simple language file.
     */
    @Nullable
    @Override
    public String getPlaceholderText(@NotNull ASTNode node) {
        if (node.getPsi() instanceof PsiLiteralExpression psiLiteralExpression) {
            String text = PsiLiteralUtil.getStringLiteralContent(psiLiteralExpression);
            if (text == null) {
                return null;
            }

            String key = text.substring(SimpleAnnotator.SIMPLE_PREFIX_STR.length() +
                    SimpleAnnotator.SIMPLE_SEPARATOR_STR.length());

            SimpleProperty simpleProperty = ContainerUtil.getOnlyItem(
                    SimpleUtil.findProperties(psiLiteralExpression.getProject(), key)
            );
            if (simpleProperty == null) {
                return StringUtil.THREE_DOTS;
            }

            String propertyValue = simpleProperty.getName();
            // IMPORTANT: keys can come with no values, so a test for null is needed
            // IMPORTANT: Convert embedded \n to backslash n, so that the string will look
            // like it has LF embedded in it and embedded " to escaped "
            if (propertyValue == null) {
                return StringUtil.THREE_DOTS;
            }

            // 将换行符和双引号进行转义，以确保文本格式正确
            return propertyValue
                    .replaceAll("\n", "\\n")
                    .replaceAll("\"", "\\\\\"");
        }

        return null;
    }

    // 判断节点在初始化时是否应该默认折叠


    @Override
    public boolean isCollapsedByDefault(@NotNull ASTNode node) {
        return true;
    }

}