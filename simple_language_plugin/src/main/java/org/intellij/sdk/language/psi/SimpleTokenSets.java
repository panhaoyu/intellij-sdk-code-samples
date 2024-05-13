// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package org.intellij.sdk.language.psi;

import com.intellij.psi.tree.TokenSet;

public interface SimpleTokenSets {

    TokenSet IDENTIFIERS = TokenSet.create(SimpleTypes.IDENTIFIER);

    TokenSet COMMENTS = TokenSet.create(SimpleTypes.COMMENT);

    TokenSet LITERALS = TokenSet.create(SimpleTypes.STRING_LITERAL, SimpleTypes.NUMBER_LITERAL);

    TokenSet STRING_LITERALS = TokenSet.create(SimpleTypes.STRING_LITERAL);

    TokenSet Operators = TokenSet.create(
            SimpleTypes.ASSIGNMENT_OPERATOR,
            SimpleTypes.UNARY_OPERATOR,
            SimpleTypes.MINUS_OPERATOR,
            SimpleTypes.BINARY_OPERATOR
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


}
