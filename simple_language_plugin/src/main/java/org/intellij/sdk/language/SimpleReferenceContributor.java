// Copyright 2000-2023 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.language;

import com.intellij.openapi.util.TextRange;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import org.intellij.sdk.language.psi.SimpleTypes;
import org.jetbrains.annotations.NotNull;

import static org.intellij.sdk.language.SimpleAnnotator.SIMPLE_PREFIX_STR;
import static org.intellij.sdk.language.SimpleAnnotator.SIMPLE_SEPARATOR_STR;

// 定义SimpleReferenceContributor类，继承自PsiReferenceContributor
final class SimpleReferenceContributor extends PsiReferenceContributor {

    // 重写registerReferenceProviders方法，用于注册引用提供者
    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        // 注册引用提供者，指定对PsiLiteralExpression类的元素进行处理
        registrar.registerReferenceProvider(PlatformPatterns.psiElement(PsiLiteralExpression.class),
                new PsiReferenceProvider() {
                    // 重写getReferencesByElement方法，用于根据元素生成引用数组
                    @Override
                    public PsiReference @NotNull [] getReferencesByElement(@NotNull PsiElement element,
                                                                           @NotNull ProcessingContext context) {
                        PsiLiteralExpression literalExpression = (PsiLiteralExpression) element;  // 将元素转换为PsiLiteralExpression类型
                        // 获取字面值表达式的值，如果是字符串，则转换为String类型
                        String value = literalExpression.getValue() instanceof String ?
                                (String) literalExpression.getValue() : null;
                        // 判断值是否以特定的前缀开始
                        if ((value != null && value.startsWith(SIMPLE_PREFIX_STR + SIMPLE_SEPARATOR_STR))) {
                            // 计算应该创建引用的文本范围
                            TextRange property = new TextRange(SIMPLE_PREFIX_STR.length() + SIMPLE_SEPARATOR_STR.length() + 1,
                                    value.length() + 1);
                            // 创建并返回SimpleReference数组
                            return new PsiReference[]{new SimpleReference(element, property)};
                        }
                        // 如果不满足条件，返回空数组
                        return PsiReference.EMPTY_ARRAY;
                    }
                });
    }

}