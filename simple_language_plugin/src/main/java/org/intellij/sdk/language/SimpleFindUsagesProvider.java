// Copyright 2000-2024 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package org.intellij.sdk.language;

import com.intellij.lang.cacheBuilder.DefaultWordsScanner;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.PsiElement;
import org.intellij.sdk.language.psi.SimpleTkIdentifier;
import org.intellij.sdk.language.psi.SimpleTokenSets;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

final class SimpleFindUsagesProvider implements FindUsagesProvider {

    @Override
    public WordsScanner getWordsScanner() {
        return new DefaultWordsScanner(new SimpleLexerAdapter(), SimpleTokenSets.IDENTIFIERS, SimpleTokenSets.COMMENTS, SimpleTokenSets.LITERALS);
    }

    @Override
    public boolean canFindUsagesFor(@NotNull PsiElement psiElement) {
        return psiElement instanceof SimpleTkIdentifier;
    }

    @Override
    public @NotNull String getHelpId(@NotNull PsiElement psiElement) {
        return psiElement.getTextRange().toString();
    }

    @NotNull
    @Override
    public String getType(@NotNull PsiElement element) {
        if (element instanceof SimpleTkIdentifier) {
            return "identifier";
        }
        return "";
    }

    @NotNull
    @Override
    public String getDescriptiveName(@NotNull PsiElement element) {
        if (element instanceof SimpleTkIdentifier identifierElement) {
            return Objects.requireNonNull(identifierElement.getName());
        }
        return "";
    }

    @NotNull
    @Override
    public String getNodeText(@NotNull PsiElement element, boolean useFullName) {
        return getDescriptiveName(element);
    }

}
