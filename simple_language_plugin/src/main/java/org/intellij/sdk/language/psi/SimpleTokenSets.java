// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package org.intellij.sdk.language.psi;

import com.intellij.psi.TokenType;
import com.intellij.psi.tree.TokenSet;

public interface SimpleTokenSets {

    TokenSet IDENTIFIERS = TokenSet.create(
            SimpleTypes.IDENTIFIER,
            SimpleTypes.TK_IDENTIFIER
    );
    TokenSet NOTHING = TokenSet.create();
    TokenSet COMMENTS = TokenSet.create(
            SimpleTypes.COMMENT_TEXT,
            SimpleTypes.COMMENT_OPERATOR,
            SimpleTypes.OP_COMMENT,
            SimpleTypes.TK_COMMENT_TEXT,
            SimpleTypes.TK_COMMENT
    );

    TokenSet STRING_LITERALS = TokenSet.create(SimpleTypes.STRING_LITERAL);
    TokenSet LITERALS = TokenSet.create(
            SimpleTypes.STRING_LITERAL,
            SimpleTypes.NUMBER_LITERAL
    );


    TokenSet IDENTIFIERS_AND_LITERALS = TokenSet.create(
            SimpleTypes.TK_VALUE,
            SimpleTypes.TK_IDENTIFIER,
            SimpleTypes.TK_LITERAL,
            SimpleTypes.IDENTIFIER,
            SimpleTypes.STRING_LITERAL,
            SimpleTypes.NUMBER_LITERAL
    );


    TokenSet OPERATORS_WITHOUT_MINUS = TokenSet.create(
            SimpleTypes.ASSIGNMENT_OPERATOR,
            SimpleTypes.UNARY_OPERATOR,
            // SimpleTypes.MINUS_OPERATOR, // 注意，减号并不永远是减号。在command语句里面，减号是可以作为标识符的一部分存在的。
            SimpleTypes.BINARY_OPERATOR,
            SimpleTypes.COMMA_OPERATOR,
            SimpleTypes.FUNCTION_CALL_OPERATOR,
            SimpleTypes.DOT_OPERATOR
    );

    TokenSet OPERATORS = TokenSet.create(
            SimpleTypes.ASSIGNMENT_OPERATOR,
            SimpleTypes.UNARY_OPERATOR,
            SimpleTypes.MINUS_OPERATOR, // 注意，减号并不永远是减号。在command语句里面，减号是可以作为标识符的一部分存在的。
            SimpleTypes.BINARY_OPERATOR,
            SimpleTypes.COMMA_OPERATOR,
            SimpleTypes.FUNCTION_CALL_OPERATOR,
            SimpleTypes.DOT_OPERATOR
    );

    TokenSet RIGHT_BRACKETS = TokenSet.create(
            SimpleTypes.RIGHT_CURLY_BRACKET,
            SimpleTypes.RIGHT_PARENTHESIS,
            SimpleTypes.RIGHT_SQUARE_BRACKET
    );
    TokenSet LEFT_BRACKETS = TokenSet.create(
            SimpleTypes.LEFT_CURLY_BRACKET,
            SimpleTypes.LEFT_PARENTHESIS,
            SimpleTypes.LEFT_SQUARE_BRACKET
    );

    TokenSet BRACKETS = TokenSet.create(
            SimpleTypes.RIGHT_CURLY_BRACKET,
            SimpleTypes.RIGHT_PARENTHESIS,
            SimpleTypes.RIGHT_SQUARE_BRACKET,
            SimpleTypes.LEFT_CURLY_BRACKET,
            SimpleTypes.LEFT_PARENTHESIS,
            SimpleTypes.LEFT_SQUARE_BRACKET
    );
    TokenSet NEW_LINE = TokenSet.create(
            TokenType.NEW_LINE_INDENT,
            SimpleTypes.EOL,
            SimpleTypes.NEWLINE,
            SimpleTypes.TK_NEWLINE
    );


    TokenSet KEYWORDS = TokenSet.create(
            SimpleTypes.ARRAY,
            SimpleTypes.BREAK,
            SimpleTypes.CASE,
            SimpleTypes.CASEOF,
            SimpleTypes.COMMAND,
            SimpleTypes.CONTINUE,
            SimpleTypes.FISH_DEFINE,
            SimpleTypes.FISH_OPERATOR,
            SimpleTypes.ELSE,
            SimpleTypes.ELSEIF,
            SimpleTypes.END,
            SimpleTypes.ENDCASE,
            SimpleTypes.ENDCOMMAND,
            SimpleTypes.ENDIF,
            SimpleTypes.ENDLOOP,
            SimpleTypes.ENDSECTION,
            SimpleTypes.EXIT,
            SimpleTypes.FOR,
            SimpleTypes.FOREACH,
            SimpleTypes.GLOBAL,
            SimpleTypes.IF,
            SimpleTypes.LOCAL,
            SimpleTypes.LOCK,
            SimpleTypes.LOOP,
            SimpleTypes.RETURN,
            SimpleTypes.SECTION,
            SimpleTypes.STRUCT,
            SimpleTypes.THEN,
            SimpleTypes.WHILE
    );

    // 用于进行缩进
    TokenSet BLOCK_BODY = TokenSet.create(
            SimpleTypes.FISH_BLOCK_BODY_IF,
            SimpleTypes.FISH_BLOCK_BODY_ELSE_IF,
            SimpleTypes.FISH_BLOCK_BODY_ELSE,
            SimpleTypes.FISH_BLOCK_BODY_DEFINE,
            SimpleTypes.FISH_BLOCK_BODY_LOOP,
            SimpleTypes.FISH_BLOCK_BODY_SECTION,
            SimpleTypes.FISH_BLOCK_BODY_CASE_OF,
            SimpleTypes.FISH_BLOCK_BODY_COMMAND
    );

    // 用于避免缩进
    TokenSet BLOCK_SKIP = TokenSet.create(
            TokenType.NEW_LINE_INDENT,
            TokenType.WHITE_SPACE,
            SimpleTypes.NEWLINE,
            SimpleTypes.TK_NEWLINE,
            SimpleTypes.EOL
    );
}
