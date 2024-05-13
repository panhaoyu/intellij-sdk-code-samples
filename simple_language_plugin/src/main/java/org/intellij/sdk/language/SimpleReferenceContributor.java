package org.intellij.sdk.language;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.util.TextRange;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import org.intellij.sdk.language.psi.SimpleIdentifierElement;
import org.jetbrains.annotations.NotNull;

// ����SimpleReferenceContributor�࣬�̳���PsiReferenceContributor
final class SimpleReferenceContributor extends PsiReferenceContributor {
    private static final Logger LOG = Logger.getInstance(SimpleReferenceContributor.class); // ��־��¼��

    // ��дregisterReferenceProviders����������ע�������ṩ��
    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        LOG.info("ע�������ṩ�ߣ����� SimpleIdentifierElement ���͵� PSI Ԫ��");

        registrar.registerReferenceProvider(
                PlatformPatterns.psiElement(),
                new PsiReferenceProvider() {
                    @Override
                    public PsiReference @NotNull [] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext context) {
                        SimpleIdentifierElement identifier = (SimpleIdentifierElement) element;
                        String value = identifier.getName();

                        if (value != null) {
                            LOG.info("ΪԪ�� '" + identifier + "' �������ã����ʶ��Ϊ: " + value);
                            TextRange range = new TextRange(0, value.length());
                            return new PsiReference[]{new SimpleReference(identifier, range)};
                        } else {
                            LOG.warn("δ�ҵ���ʶ�����ƣ��޷�ΪԪ�� '" + identifier + "' ��������");
                        }
                        return PsiReference.EMPTY_ARRAY;
                    }
                }
        );
        LOG.info("�����ṩ��ע�����");
    }
}