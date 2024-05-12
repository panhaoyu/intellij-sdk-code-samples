// Copyright 2000-2023 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.language;

import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLiteralExpression;
import org.intellij.sdk.language.psi.SimpleProperty;
import org.jetbrains.annotations.NotNull;

import java.util.List;

// 该类实现了Annotator接口，用于添加注释，如语法高亮等
final class SimpleAnnotator implements Annotator {

    // 定义用于注释、行标记等的Simple语言前缀字符串
    public static final String SIMPLE_PREFIX_STR = "simple";
    public static final String SIMPLE_SEPARATOR_STR = ":";


    @Override
    public void annotate(@NotNull final PsiElement element, @NotNull AnnotationHolder holder) {
//        if (element instanceof SimpleCommandBlock) {
//            holder.newSilentAnnotation(HighlightSeverity.TEXT_ATTRIBUTES)
//                    .range(element.getTextRange())
//                    .textAttributes(BOLD)
//                    .create();
//            return;
//        }


        // 确保传入的PSI元素是一个表达式
        if (!(element instanceof PsiLiteralExpression literalExpression)) {
            return;
        }

        // 确保PSI元素包含以前缀和分隔符开头的字符串
        String value = literalExpression.getValue() instanceof String ? (String) literalExpression.getValue() : null;
        if (value == null || !value.startsWith(SIMPLE_PREFIX_STR + SIMPLE_SEPARATOR_STR)) {
            return;
        }

        // 定义文本范围（开始包括，结束不包括）
        // "simple:key"
        //  01234567890
        TextRange prefixRange = TextRange.from(element.getTextRange().getStartOffset(), SIMPLE_PREFIX_STR.length() + 1);
        TextRange separatorRange = TextRange.from(prefixRange.getEndOffset(), SIMPLE_SEPARATOR_STR.length());
        TextRange keyRange = new TextRange(separatorRange.getEndOffset(), element.getTextRange().getEndOffset() - 1);

        // 高亮显示"simple"前缀和":"分隔符
        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                .range(prefixRange).textAttributes(DefaultLanguageHighlighterColors.KEYWORD).create();
        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                .range(separatorRange).textAttributes(SimpleSyntaxHighlighter.OPERATOR).create();

        // 获取给定键的属性列表
        String key = value.substring(SIMPLE_PREFIX_STR.length() + SIMPLE_SEPARATOR_STR.length());
        List<SimpleProperty> properties = SimpleUtil.findProperties(element.getProject(), key);
        if (properties.isEmpty()) {
            holder.newAnnotation(HighlightSeverity.ERROR, "Unresolved property")
                    .range(keyRange)
                    .highlightType(ProblemHighlightType.LIKE_UNKNOWN_SYMBOL)
                    // 添加一个快速修复建议，为找不到的属性提供可能的创建选项
                    .withFix(new SimpleCreatePropertyQuickFix(key))
                    .create();
        } else {
            // 如果找到至少一个属性，强制将文本属性设置为Simple语法值字符
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(keyRange).textAttributes(SimpleSyntaxHighlighter.STRING_LITERAL).create();
        }
    }

}
