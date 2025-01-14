// Copyright 2000-2023 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.language;

import com.intellij.formatting.*;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import org.intellij.sdk.language.psi.SimpleTokenSets;
import org.intellij.sdk.language.psi.SimpleTypes;
import org.jetbrains.annotations.NotNull;

final class SimpleFormattingModelBuilder implements FormattingModelBuilder {

    private static SpacingBuilder createSpaceBuilder(CodeStyleSettings settings) {
        return new SpacingBuilder(settings, SimpleLanguage.INSTANCE)
//                .around(SimpleTypes.TK_VALUE).spaces(1)
                .around(SimpleTypes.ASSIGNMENT_OPERATOR).spaces(1)
                .around(SimpleTypes.BINARY_OPERATOR).spaces(1)
                .around(SimpleTypes.UNARY_OPERATOR).spaces(1)
                .before(SimpleTypes.FUNCTION_CALL_OPERATOR).spaces(1)
                .after(SimpleTypes.FUNCTION_CALL_OPERATOR).none()
                // 括号内侧不加空格，括号外侧加空格
                .after(SimpleTokenSets.LeftBrackets).none()
                .before(SimpleTokenSets.RightBrackets).none()
                .between(SimpleTokenSets.RightBrackets, SimpleTokenSets.LeftBrackets).spaces(1)
                // 逗号前面没有空格，后面有空格
                .before(SimpleTypes.COMMA_OPERATOR).none()
                .after(SimpleTypes.COMMA_OPERATOR).spaces(1)
                ;
    }

    @Override
    public @NotNull FormattingModel createModel(@NotNull FormattingContext formattingContext) {
        final CodeStyleSettings codeStyleSettings = formattingContext.getCodeStyleSettings();
        return FormattingModelProvider
                .createFormattingModelForPsiFile(formattingContext.getContainingFile(),
                        new SimpleBlock(formattingContext.getNode(),
                                Wrap.createWrap(WrapType.NONE, false),
                                Alignment.createAlignment(),
                                createSpaceBuilder(codeStyleSettings)),
                        codeStyleSettings);
    }

}
