package org.intellij.sdk.language;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.util.TextRange;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import org.intellij.sdk.language.psi.SimpleIdentifierElement;
import org.jetbrains.annotations.NotNull;

// 定义SimpleReferenceContributor类，继承自PsiReferenceContributor
final class SimpleReferenceContributor extends PsiReferenceContributor {
    private static final Logger LOG = Logger.getInstance(SimpleReferenceContributor.class); // 日志记录器

    // 重写registerReferenceProviders方法，用于注册引用提供者
    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        LOG.info("注册引用提供者，处理 SimpleIdentifierElement 类型的 PSI 元素");

        registrar.registerReferenceProvider(
                PlatformPatterns.psiElement(),
                new PsiReferenceProvider() {
                    @Override
                    public PsiReference @NotNull [] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext context) {
                        SimpleIdentifierElement identifier = (SimpleIdentifierElement) element;
                        String value = identifier.getName();

                        if (value != null) {
                            LOG.info("为元素 '" + identifier + "' 创建引用，其标识符为: " + value);
                            TextRange range = new TextRange(0, value.length());
                            return new PsiReference[]{new SimpleReference(identifier, range)};
                        } else {
                            LOG.warn("未找到标识符名称，无法为元素 '" + identifier + "' 创建引用");
                        }
                        return PsiReference.EMPTY_ARRAY;
                    }
                }
        );
        LOG.info("引用提供者注册完成");
    }
}