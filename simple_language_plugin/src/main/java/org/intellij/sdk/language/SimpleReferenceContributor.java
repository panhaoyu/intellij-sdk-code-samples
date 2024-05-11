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

// ����SimpleReferenceContributor�࣬�̳���PsiReferenceContributor
final class SimpleReferenceContributor extends PsiReferenceContributor {

    // ��дregisterReferenceProviders����������ע�������ṩ��
    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        // ע�������ṩ�ߣ�ָ����PsiLiteralExpression���Ԫ�ؽ��д���
        registrar.registerReferenceProvider(PlatformPatterns.psiElement(PsiLiteralExpression.class),
                new PsiReferenceProvider() {
                    // ��дgetReferencesByElement���������ڸ���Ԫ��������������
                    @Override
                    public PsiReference @NotNull [] getReferencesByElement(@NotNull PsiElement element,
                                                                           @NotNull ProcessingContext context) {
                        PsiLiteralExpression literalExpression = (PsiLiteralExpression) element;  // ��Ԫ��ת��ΪPsiLiteralExpression����
                        // ��ȡ����ֵ���ʽ��ֵ��������ַ�������ת��ΪString����
                        String value = literalExpression.getValue() instanceof String ?
                                (String) literalExpression.getValue() : null;
                        // �ж�ֵ�Ƿ����ض���ǰ׺��ʼ
                        if ((value != null && value.startsWith(SIMPLE_PREFIX_STR + SIMPLE_SEPARATOR_STR))) {
                            // ����Ӧ�ô������õ��ı���Χ
                            TextRange property = new TextRange(SIMPLE_PREFIX_STR.length() + SIMPLE_SEPARATOR_STR.length() + 1,
                                    value.length() + 1);
                            // ����������SimpleReference����
                            return new PsiReference[]{new SimpleReference(element, property)};
                        }
                        // ������������������ؿ�����
                        return PsiReference.EMPTY_ARRAY;
                    }
                });
    }

}