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
                // 处理的过程是自下向上的
                .between(SimpleTypes.FISH_EXPR_ASSIGN_LEFT_FOR_LOOP, SimpleTypes.FISH_EXPR_LOOP_INDEXED).spaces(1)

                .between(SimpleTokenSets.EndOfLine, SimpleTypes.FISH_LINE).spaces(0)
                .between(SimpleTokenSets.EndOfLine, SimpleTypes.FISH_DEFINE).spaces(0)

                // 换行符前面不要有空格
                .before(SimpleTokenSets.NewLine).none()
                .between(SimpleTypes.COMMAND_LINE_OTHER_WORDS, SimpleTokenSets.COMMENTS).spaces(2)
                .between(SimpleTypes.FISH_LINE, SimpleTokenSets.COMMENTS).spaces(2)
                .between(SimpleTypes.FISH_BLOCK_SINGLE, SimpleTokenSets.COMMENTS).spaces(2)
                .between(SimpleTokenSets.IDENTIFIERS_AND_LITERALS, SimpleTokenSets.COMMENTS).spaces(2)

                // 关键词
                .between(SimpleTokenSets.IDENTIFIERS_AND_LITERALS, SimpleTokenSets.KeyWords).spaces(1)  // 关键词与标识符之间只有一个空格

                // 括号内侧不加空格，括号外侧加空格
                .between(SimpleTokenSets.RightBrackets, SimpleTypes.COMMA_OPERATOR).none()  // ")," 中间不要有空格
                .betweenInside(SimpleTokenSets.IDENTIFIERS_AND_LITERALS, SimpleTokenSets.LeftBrackets, SimpleTypes.COMMAND_LINE_OTHER_WORDS).spaces(1)
                .between(SimpleTokenSets.IDENTIFIERS_AND_LITERALS, SimpleTokenSets.LeftBrackets).none() // 函数调用
                .before(SimpleTokenSets.LeftBrackets).spaces(1)
                .after(SimpleTokenSets.LeftBrackets).none()
                .before(SimpleTokenSets.RightBrackets).none()
                .after(SimpleTokenSets.RightBrackets).spaces(1)

                // 对一些特殊的符号进行调整
                // 逗号前面没有空格，后面有空格
                .after(SimpleTypes.FUNCTION_CALL_OPERATOR).none()  // @函数调用的时候，@前面要有空格，但后面不要有空格
                .before(SimpleTypes.COMMA_OPERATOR).none()  // 逗号的前面不要有空格


                // 确保有且只有一个空格
                .aroundInside(SimpleTokenSets.OperatorsWithoutMinus, SimpleTypes.COMMAND_LINE_OTHER_WORDS).spaces(1)  // 运算符前后有空格
                .betweenInside(SimpleTokenSets.IDENTIFIERS_AND_LITERALS, SimpleTokenSets.IDENTIFIERS_AND_LITERALS, SimpleTypes.COMMAND_LINE_OTHER_WORDS).spaces(1)  // 标识符前后有一个空格

                .aroundInside(SimpleTypes.MINUS_OPERATOR, SimpleTypes.FISH_LINE).spaces(1)  // 运算符前后有空格
                .around(SimpleTokenSets.OperatorsWithoutMinus).spaces(1)  // 运算符前后有空格
                .aroundInside(SimpleTokenSets.IDENTIFIERS_AND_LITERALS, SimpleTypes.FISH_LINE).spaces(1)  // 标识符前后有一个空格
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
