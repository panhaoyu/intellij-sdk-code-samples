package org.intellij.sdk.language.psi;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.ElementManipulator;
import com.intellij.psi.PsiFileFactory;
import com.intellij.util.IncorrectOperationException;
import org.intellij.sdk.language.SimpleLanguage;
import org.intellij.sdk.language.psi.impl.SimpleTkIdentifierRawImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SimpleTkIdentifierManipulator implements ElementManipulator<SimpleTkIdentifierRawImpl> {
    @Override
    public SimpleTkIdentifierRawImpl handleContentChange(@NotNull SimpleTkIdentifierRawImpl element, @NotNull TextRange range, String newContent) {
        // 您的内容更改逻辑
        String oldText = element.getText();
        String newText = oldText.substring(0, range.getStartOffset()) + newContent + oldText.substring(range.getEndOffset());
        // 重新解析并替换元素
        return (SimpleTkIdentifierRawImpl) element.replace(createElement(element.getProject(), newText));
    }

    @Override
    public @Nullable SimpleTkIdentifierRawImpl handleContentChange(@NotNull SimpleTkIdentifierRawImpl element, String newContent) throws IncorrectOperationException {
        // 调用上面的 handleContentChange 方法
        return handleContentChange(element, getRangeInElement(element), newContent);
    }

    @Override
    public @NotNull TextRange getRangeInElement(@NotNull SimpleTkIdentifierRawImpl element) {
        // 返回元素的范围
        return new TextRange(0, element.getTextLength());
    }

    private SimpleTkIdentifierRawImpl createElement(Project project, String text) {
        // 创建并返回新的 SimpleTkIdentifierImpl 实例
        // 这个实现依赖于您的语言的具体解析器和 PSI 树结构
        PsiFileFactory psiFileFactory = PsiFileFactory.getInstance(project);
        return (SimpleTkIdentifierRawImpl) psiFileFactory
                .createFileFromText("dummy.simple", SimpleLanguage.INSTANCE, text)
                .getFirstChild();
    }
}