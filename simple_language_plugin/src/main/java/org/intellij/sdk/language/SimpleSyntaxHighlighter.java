// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.language;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.intellij.sdk.language.psi.SimpleTypes;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class SimpleSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey OPERATOR =
            createTextAttributesKey("SIMPLE_OPERATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey KEYWORD =
            createTextAttributesKey("SIMPLE_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey FISH_FUNCTION =
            createTextAttributesKey("FISH_FUNCTIONS", DefaultLanguageHighlighterColors.FUNCTION_CALL);
    public static final TextAttributesKey STRING_LITERAL =
            createTextAttributesKey("SIMPLE_VALUE", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey NUMBER_LITERAL =
            createTextAttributesKey("SIMPLE_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey IDENTIFIER =
            createTextAttributesKey("SIMPLE_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("SIMPLE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("SIMPLE_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);


    private static final TextAttributesKey[] BAD_CHARACTER_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] OPERATOR_KEYS = new TextAttributesKey[]{OPERATOR};
    private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{KEYWORD};
    private static final TextAttributesKey[] STRING_LITERAL_KEYS = new TextAttributesKey[]{STRING_LITERAL};
    private static final TextAttributesKey[] NUMBER_LITERAL_KEYS = new TextAttributesKey[]{NUMBER_LITERAL};
    private static final TextAttributesKey[] IDENTIFIER_KEYS = new TextAttributesKey[]{IDENTIFIER};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];
    private static final TextAttributesKey[] FUNCTION_DECLARATION_KEYS = new TextAttributesKey[]{
            createTextAttributesKey("SIMPLE_KEYWORD", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION)
    };
    private static final TextAttributesKey[] BRACKETS_KEYS = new TextAttributesKey[]{
            createTextAttributesKey("SIMPLE_KEYWORD", DefaultLanguageHighlighterColors.BRACKETS)
    };

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new SimpleLexerAdapter();
    }

    private final HashMap<IElementType, TextAttributesKey[]> highlightingMap = new HashMap<>() {{
        put(SimpleTypes.ASSIGNMENT_OPERATOR, OPERATOR_KEYS);
        put(SimpleTypes.BINARY_OPERATOR, OPERATOR_KEYS);
        put(SimpleTypes.COMMA_OPERATOR, OPERATOR_KEYS);
        put(SimpleTypes.DOT_OPERATOR, OPERATOR_KEYS);
        put(SimpleTypes.ELLIPSIS, OPERATOR_KEYS);
        put(SimpleTypes.FUNCTION_CALL_OPERATOR, OPERATOR_KEYS);
        put(SimpleTypes.MINUS_OPERATOR, OPERATOR_KEYS);
        put(SimpleTypes.UNARY_OPERATOR, OPERATOR_KEYS);

        put(SimpleTypes.NUMBER_LITERAL, NUMBER_LITERAL_KEYS);
        put(SimpleTypes.IDENTIFIER, IDENTIFIER_KEYS);
        put(SimpleTypes.COMMENT, COMMENT_KEYS);
        put(SimpleTypes.STRING_LITERAL, STRING_LITERAL_KEYS);

        put(TokenType.WHITE_SPACE, EMPTY_KEYS);
        put(SimpleTypes.NEWLINE, EMPTY_KEYS);

        put(SimpleTypes.LEFT_CURLY_BRACKET, BRACKETS_KEYS);
        put(SimpleTypes.LEFT_PARENTHESIS, BRACKETS_KEYS);
        put(SimpleTypes.LEFT_SQUARE_BRACKET, BRACKETS_KEYS);
        put(SimpleTypes.RIGHT_CURLY_BRACKET, BRACKETS_KEYS);
        put(SimpleTypes.RIGHT_PARENTHESIS, BRACKETS_KEYS);
        put(SimpleTypes.RIGHT_SQUARE_BRACKET, BRACKETS_KEYS);


        put(SimpleTypes.ARRAY, KEYWORD_KEYS);
        put(SimpleTypes.BREAK, KEYWORD_KEYS);
        put(SimpleTypes.CASE, KEYWORD_KEYS);
        put(SimpleTypes.CASEOF, KEYWORD_KEYS);
        put(SimpleTypes.COMMAND, KEYWORD_KEYS);
        put(SimpleTypes.CONTINUE, KEYWORD_KEYS);
        put(SimpleTypes.DEFINE, KEYWORD_KEYS);
        put(SimpleTypes.ELSE, KEYWORD_KEYS);
        put(SimpleTypes.ELSEIF, KEYWORD_KEYS);
        put(SimpleTypes.END, KEYWORD_KEYS);
        put(SimpleTypes.ENDCASE, KEYWORD_KEYS);
        put(SimpleTypes.ENDCOMMAND, KEYWORD_KEYS);
        put(SimpleTypes.ENDIF, KEYWORD_KEYS);
        put(SimpleTypes.ENDLOOP, KEYWORD_KEYS);
        put(SimpleTypes.ENDSECTION, KEYWORD_KEYS);
        put(SimpleTypes.EXIT, KEYWORD_KEYS);
        put(SimpleTypes.FISH, KEYWORD_KEYS);
        put(SimpleTypes.FOR, KEYWORD_KEYS);
        put(SimpleTypes.FOREACH, KEYWORD_KEYS);
        put(SimpleTypes.GLOBAL, KEYWORD_KEYS);
        put(SimpleTypes.IF, KEYWORD_KEYS);
        put(SimpleTypes.LOCAL, KEYWORD_KEYS);
        put(SimpleTypes.LOCK, KEYWORD_KEYS);
        put(SimpleTypes.LOOP, KEYWORD_KEYS);
        put(SimpleTypes.RETURN, KEYWORD_KEYS);
        put(SimpleTypes.SECTION, KEYWORD_KEYS);
        put(SimpleTypes.STRUCT, KEYWORD_KEYS);
        put(SimpleTypes.THEN, KEYWORD_KEYS);
        put(SimpleTypes.WHILE, KEYWORD_KEYS);

    }};


    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        return highlightingMap.getOrDefault(tokenType, BAD_CHARACTER_KEYS);
    }
}
