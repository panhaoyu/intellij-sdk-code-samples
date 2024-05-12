package org.intellij.sdk.language;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElementResolveResult;
import com.intellij.psi.PsiPolyVariantReference;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.ResolveResult;
import org.intellij.sdk.language.psi.SimpleIdentifierElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

// 创建SimpleReference类，它是PsiReferenceBase的子类，实现了PsiPolyVariantReference接口
public final class SimpleReference extends PsiReferenceBase<SimpleIdentifierElement> implements PsiPolyVariantReference {

    private static final Logger LOG = Logger.getInstance(SimpleReference.class); // 日志记录器
    // 定义一个字符串成员变量用于存储键值

    private final String key;


    // 构造函数，初始化引用和键值
    public SimpleReference(@NotNull SimpleIdentifierElement element, TextRange textRange) {
        super(element, textRange);
        key = element.getText();
    }

    // 重写multiResolve方法，用于解析多个可能的引用结果
    @Override
    public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
        Project project = myElement.getProject();
        final List<SimpleIdentifierElement> identifiers = SimpleUtil.findIdentifiers(project, myElement.getName()); // 查找与键值相关的属性列表
        List<ResolveResult> results = new ArrayList<>(); // 创建解析结果列表
        for (SimpleIdentifierElement identifier : identifiers) { // 遍历找到的属性
            results.add(new PsiElementResolveResult(identifier)); // 将属性封装为解析结果并添加到列表中
        }
        LOG.info("Total identifiers resolved: " + results.size()); // 记录解析的数量
        return results.toArray(new ResolveResult[0]); // 将列表转换为数组并返回
    }

    @Nullable
    @Override
    public SimpleIdentifierElement resolve() {
        ResolveResult[] resolveResults = multiResolve(false);
        return resolveResults.length == 1 ? (SimpleIdentifierElement) resolveResults[0].getElement() : null;
    }


    // 重写getVariants方法，用于获取所有可能的自动补全选项
    @Override
    public Object @NotNull [] getVariants() {
        Project project = myElement.getProject();
        List<SimpleIdentifierElement> properties = SimpleUtil.findAllIdentifiers(project); // 获取所有属性
        List<LookupElement> variants = new ArrayList<>(); // 创建自动补全选项列表
        for (final SimpleIdentifierElement identifier : properties) { // 遍历所有属性
            if (identifier.getName() != null && !identifier.getName().isEmpty()) { // 如果属性的键不为空
                variants.add(LookupElementBuilder // 创建自动补全选项
                        .create(identifier).withIcon(SimpleIcons.FILE) // 设置图标
                        .withTypeText(identifier.getContainingFile().getName()) // 设置类型文本为文件名
                );
            }
        }
        LOG.info("Autocomplete variants count: " + variants.size()); // 记录自动补全候选数量
        return variants.toArray(); // 将列表转换为数组并返回
    }

}