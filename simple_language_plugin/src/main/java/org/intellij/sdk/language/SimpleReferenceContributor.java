package org.intellij.sdk.language;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.util.TextRange;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import org.intellij.sdk.language.psi.SimpleTkIdentifierRaw;
import org.jetbrains.annotations.NotNull;

// 定义SimpleReferenceContributor类，继承自PsiReferenceContributor
final class SimpleReferenceContributor extends PsiReferenceContributor {
    private static final Logger LOG = Logger.getInstance(SimpleReferenceContributor.class); // 日志记录器

    // 重写registerReferenceProviders方法，用于注册引用提供者
    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        registrar.registerReferenceProvider(
                PlatformPatterns.psiElement(),
                new PsiReferenceProvider() {
                    @Override
                    public PsiReference @NotNull [] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext context) {

                        if (!(element instanceof SimpleTkIdentifierRaw identifier)){
                            return PsiReference.EMPTY_ARRAY;
                        }
                        String value = identifier.getName();

                        if (value != null) {
                            TextRange range = new TextRange(0, value.length());
                            return new PsiReference[]{new SimpleReference(identifier, range)};
                        }
                        return PsiReference.EMPTY_ARRAY;
                    }
                }
        );
    }
}