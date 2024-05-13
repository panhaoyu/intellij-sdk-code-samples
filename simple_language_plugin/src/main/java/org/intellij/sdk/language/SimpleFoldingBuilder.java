// Copyright 2000-2024 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package org.intellij.sdk.language;

import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilderEx;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.FoldingGroup;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLiteralExpression;
import com.intellij.psi.util.PsiLiteralUtil;
import com.intellij.util.containers.ContainerUtil;
import org.intellij.sdk.language.psi.SimpleBlockDefine;
import org.intellij.sdk.language.psi.SimpleProperty;
import org.intellij.sdk.language.psi.SimpleVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// SimpleFoldingBuilder类，实现代码折叠构建
final class SimpleFoldingBuilder extends FoldingBuilderEx implements DumbAware {

    // 构建折叠区域的方法
    @Override
    public FoldingDescriptor @NotNull [] buildFoldRegions(@NotNull PsiElement root,
                                                          @NotNull Document document,
                                                          boolean quick) {
        // 初始化折叠组，相同组的折叠区域会同时展开或折叠
        FoldingGroup group = FoldingGroup.newGroup(SimpleAnnotator.SIMPLE_PREFIX_STR);
        // 初始化折叠描述符列表
        List<FoldingDescriptor> descriptors = new ArrayList<>();

        // 使用访问者模式递归遍历代码的AST节点
        root.accept(new SimpleVisitor() {
            @Override
            public void visitBlockDefine(@NotNull SimpleBlockDefine blockDefine) {
                super.visitBlockDefine(blockDefine);

                String value = blockDefine.getFirstChild().getText();
                if (value != null &&
                        value.startsWith(SimpleAnnotator.SIMPLE_PREFIX_STR + SimpleAnnotator.SIMPLE_SEPARATOR_STR)) {
                    Project project = blockDefine.getProject();
                    String key = value.substring(
                            SimpleAnnotator.SIMPLE_PREFIX_STR.length() + SimpleAnnotator.SIMPLE_SEPARATOR_STR.length()
                    );
                    // 在项目中查找与键对应的SimpleProperty
                    SimpleProperty simpleProperty = ContainerUtil.getOnlyItem(SimpleUtil.findProperties(project, key));
                    if (simpleProperty != null) {
                        // 为当前字面量表达式创建一个新的折叠描述符，并添加到列表中
                        descriptors.add(new FoldingDescriptor(blockDefine.getNode(),
                                new TextRange(blockDefine.getTextRange().getStartOffset() + 1,
                                        blockDefine.getTextRange().getEndOffset() - 1),
                                group, Collections.singleton(simpleProperty)));
                    }
                }
            }
        });

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