package org.intellij.sdk.language;

import com.intellij.codeInsight.editorActions.TypedHandlerDelegate;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

public class BraceTypedHandler extends TypedHandlerDelegate {

    @Override
    public @NotNull Result charTyped(char c, @NotNull Project project, @NotNull Editor editor, @NotNull PsiFile file) {
        // 检查文件的语言类型是否为 SimpleLanguage
        if (file.getLanguage().isKindOf(SimpleLanguage.INSTANCE)) {
            // 获取当前光标的位置
            int caretOffset = editor.getCaretModel().getOffset();
            // 根据输入的字符决定插入哪个右括号
            if (c == '(') {
                editor.getDocument().insertString(caretOffset, ")");
            } else if (c == '{') {
                editor.getDocument().insertString(caretOffset, "}");
            } else if (c == '[') {
                editor.getDocument().insertString(caretOffset, "]");
            }
        }
        // 继续处理其他字符
        return Result.CONTINUE;
    }
}
