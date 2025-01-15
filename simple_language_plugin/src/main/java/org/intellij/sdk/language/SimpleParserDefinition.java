// Copyright 2000-2023 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.language;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.intellij.sdk.language.parser.SimpleParser;
import org.intellij.sdk.language.psi.SimpleFile;
import org.intellij.sdk.language.psi.SimpleTokenSets;
import org.intellij.sdk.language.psi.SimpleTypes;
import org.jetbrains.annotations.NotNull;

final class SimpleParserDefinition implements ParserDefinition {

    public static final IFileElementType FILE = new IFileElementType(SimpleLanguage.INSTANCE);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new SimpleLexerAdapter();
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        // todo 这里本应使用 SimpleTokenSets.COMMENTS 来标记注释对象的，不过由于对框架的理解不够深入，标记后会导致格式化的时候出问题。
        //   标记后会导致注释被忽略掉，而不是作为PSI树的一部分，格式化的时候，注释会消失不见。
        //   不过，如果不指定为注释，就会导致注释里面的 TO DO 不会被自动标蓝了。
        //   似乎还不仅仅是这里一个地方的问题，即使把这里改成 COMMENT 也不会恢复 to do 的高亮。
        return SimpleTokenSets.NOTHING;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return SimpleTokenSets.STRING_LITERALS;
    }

    @NotNull
    @Override
    public PsiParser createParser(final Project project) {
        return new SimpleParser();
    }

    @NotNull
    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @NotNull
    @Override
    public PsiFile createFile(@NotNull FileViewProvider viewProvider) {
        return new SimpleFile(viewProvider);
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
        return SimpleTypes.Factory.createElement(node);
    }

}
