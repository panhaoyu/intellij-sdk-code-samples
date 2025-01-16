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

                // python calculate (value1, value2)  Command 里面，也是可以支持函数调用的，保证括号的显示正常即可
                .afterInside(SimpleTokenSets.LEFT_BRACKETS, SimpleTypes.COMMAND_LINE).spaces(0)
                .beforeInside(SimpleTokenSets.RIGHT_BRACKETS, SimpleTypes.COMMAND_LINE).spaces(0)
                .beforeInside(SimpleTypes.OP_COMMA, SimpleTypes.COMMAND_LINE).spaces(0)
                .afterInside(SimpleTypes.OP_COMMA, SimpleTypes.COMMAND_LINE).spaces(0)
                // [abc]                    Command 里面，行内调用的 fish 的两侧不必有空格
                .afterInside(SimpleTypes.SQUARE_L, SimpleTypes.COMMAND_TOKEN_INLINE_FISH).spaces(0)
                .beforeInside(SimpleTypes.SQUARE_R, SimpleTypes.COMMAND_TOKEN_INLINE_FISH).spaces(0)
                // abc fish-halt bcd        Command 里面，各个命令之间应当有一个空格
                .betweenInside(SimpleTypes.COMMAND_TOKEN_ALL, SimpleTypes.COMMAND_TOKEN_ALL, SimpleTypes.COMMAND_LINE).spaces(1)
                // @func                    Command 里面，函数调用的，前面有空格，后面没有空格
                .afterInside(SimpleTypes.OP_AT, SimpleTypes.COMMAND_TOKEN_FUNC_CALL).none()  // @函数调用的时候，@前面要有空格，但后面不要有空格
                // loop i (5, 5)            循环变量后面要有空格
                .after(SimpleTypes.FISH_EXPR_ASSIGN_LEFT_FOR_LOOP).spaces(1)
                // func(params)             Fish 里面，函数调用的，函数后面不要有空格
                .after(SimpleTypes.FISH_EXPR_FUNC_CALL_FUNC_NAME).none()

                // 注释的前面有两个空格
                .before(SimpleTypes.TK_COMMENT).spaces(2)

                .between(SimpleTokenSets.NEW_LINE, SimpleTypes.FISH_LINE).spaces(0)
                .between(SimpleTokenSets.NEW_LINE, SimpleTypes.FISH_DEFINE).spaces(0)

                // 换行符前面不要有空格
                .before(SimpleTokenSets.NEW_LINE).none()

                // 关键词与标签符之间的间距调整
                .after(SimpleTypes.KW_IF).spaces(1)
                .after(SimpleTypes.KW_ELSE_IF).spaces(1)
                .before(SimpleTypes.KW_THEN).spaces(1)
                .after(SimpleTypes.KW_FISH_DEFINE).spaces(1)
                .after(SimpleTypes.KW_FISH_OPERATOR).spaces(1)

                // xxx),                    这种括号后面有一个逗号的，中间不要加空格
                .between(SimpleTokenSets.RIGHT_BRACKETS, SimpleTypes.OP_COMMA).none()
                // ,                        逗号后面的全部情况都可以加一个空格
                .after(SimpleTypes.OP_COMMA).spaces(1)
                // name (xxx                括号外侧与名称之间要有一个空格
                // xxx) name
                .between(SimpleTokenSets.IDENTIFIERS_AND_LITERALS, SimpleTokenSets.LEFT_BRACKETS).spaces(1)
                .between(SimpleTokenSets.RIGHT_BRACKETS, SimpleTokenSets.IDENTIFIERS_AND_LITERALS).spaces(1)

                // 括号内侧不加空格，括号外侧加空格
                .before(SimpleTokenSets.LEFT_BRACKETS).spaces(1)
                .after(SimpleTokenSets.LEFT_BRACKETS).none()
                .before(SimpleTokenSets.RIGHT_BRACKETS).none()
                .after(SimpleTokenSets.RIGHT_BRACKETS).spaces(1)

                // 对一些特殊的符号进行调整
                // xxx, xxx                 逗号前面没有空格，后面有空格
                .before(SimpleTypes.OP_COMMA).none()
                // a = b                    赋值的前后都要有一个空格
                .around(SimpleTypes.OP_ASSIGN).spaces(1)
                .between(SimpleTypes.FISH_EXPR_ASSIGN_TARGET, SimpleTypes.FISH_EXPR_ASSIGN_RIGHT).spaces(1)
                .after(SimpleTypes.OP_ASSIGN).spaces(1)

                // a = b - c                在 Fish 中，减号两侧也加一个空格
                // 二元运算符的两侧均加一个空格，不过不处理减号
                .around(SimpleTypes.OP_BINARY).spaces(1)
                .around(SimpleTypes.OP_ASSIGN).spaces(1)
                // fish-halt                减号要进行特殊处理，仅对于 Fish 里面可以加空格，而不能在 Command 里面加上空格
                .aroundInside(SimpleTypes.OP_MINUS, SimpleTypes.FISH_EXPR).spaces(1)
                // 两个标识符或者字面量之间只有一个空格
                .between(SimpleTokenSets.IDENTIFIERS_AND_LITERALS, SimpleTokenSets.IDENTIFIERS_AND_LITERALS).spaces(1)  // 标识符前后有一个空格

                .after(SimpleTypes.FISH_ASSIGN_SCOPE).spaces(1)
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
