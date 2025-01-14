// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package org.intellij.sdk.language.psi;

import com.intellij.psi.tree.TokenSet;

public interface SimpleTokenSets {

    TokenSet IDENTIFIERS = TokenSet.create(
            SimpleTypes.IDENTIFIER,
            SimpleTypes.TK_IDENTIFIER
    );
    TokenSet COMMENTS = TokenSet.create(
            SimpleTypes.COMMENT
    );

    TokenSet STRING_LITERALS = TokenSet.create(SimpleTypes.STRING_LITERAL);
    TokenSet LITERALS = TokenSet.create(SimpleTypes.STRING_LITERAL, SimpleTypes.NUMBER_LITERAL);


    TokenSet IDENTIFIERS_AND_LITERALS = TokenSet.create(
            SimpleTypes.IDENTIFIER,
            SimpleTypes.TK_IDENTIFIER,
            SimpleTypes.STRING_LITERAL,
            SimpleTypes.NUMBER_LITERAL
    );


    TokenSet OperatorsWithoutMinus = TokenSet.create(
            SimpleTypes.ASSIGNMENT_OPERATOR,
            SimpleTypes.UNARY_OPERATOR,
            // SimpleTypes.MINUS_OPERATOR, // 注意，减号并不永远是减号。在command语句里面，减号是可以作为标识符的一部分存在的。
            SimpleTypes.BINARY_OPERATOR,
            SimpleTypes.COMMA_OPERATOR,
            SimpleTypes.FUNCTION_CALL_OPERATOR,
            SimpleTypes.DOT_OPERATOR
    );

    TokenSet Operators = TokenSet.create(
            SimpleTypes.ASSIGNMENT_OPERATOR,
            SimpleTypes.UNARY_OPERATOR,
            SimpleTypes.MINUS_OPERATOR, // 注意，减号并不永远是减号。在command语句里面，减号是可以作为标识符的一部分存在的。
            SimpleTypes.BINARY_OPERATOR,
            SimpleTypes.COMMA_OPERATOR,
            SimpleTypes.FUNCTION_CALL_OPERATOR,
            SimpleTypes.DOT_OPERATOR
    );

    TokenSet RightBrackets = TokenSet.create(
            SimpleTypes.RIGHT_CURLY_BRACKET,
            SimpleTypes.RIGHT_PARENTHESIS,
            SimpleTypes.RIGHT_SQUARE_BRACKET
    );
    TokenSet LeftBrackets = TokenSet.create(
            SimpleTypes.LEFT_CURLY_BRACKET,
            SimpleTypes.LEFT_PARENTHESIS,
            SimpleTypes.LEFT_SQUARE_BRACKET
    );

    TokenSet Brackets = TokenSet.create(
            SimpleTypes.RIGHT_CURLY_BRACKET,
            SimpleTypes.RIGHT_PARENTHESIS,
            SimpleTypes.RIGHT_SQUARE_BRACKET,
            SimpleTypes.LEFT_CURLY_BRACKET,
            SimpleTypes.LEFT_PARENTHESIS,
            SimpleTypes.LEFT_SQUARE_BRACKET
    );
    TokenSet NewLine = TokenSet.create(
            SimpleTypes.NEWLINE
    );

    TokenSet KeyWords = TokenSet.create(
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
}
