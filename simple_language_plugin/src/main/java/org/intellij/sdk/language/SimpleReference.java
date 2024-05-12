package org.intellij.sdk.language;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import org.intellij.sdk.language.psi.SimpleNamedElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

// 创建SimpleReference类，它是PsiReferenceBase的子类，实现了PsiPolyVariantReference接口
final class SimpleReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {

    private static final Logger LOG = Logger.getInstance(SimpleReference.class); // 日志记录器
    // 定义一个字符串成员变量用于存储键值
    private final String key;

    // 构造函数，初始化引用和键值
    SimpleReference(@NotNull PsiElement element, TextRange textRange) {
        super(element, textRange);  // 调用父类构造函数，传入元素和文本范围
        key = element.getText().substring(textRange.getStartOffset(), textRange.getEndOffset()); // 从文本范围截取键值
        LOG.error("SimpleReference initialized for key: " + key); // 记录日志
    }

    // 重写multiResolve方法，用于解析多个可能的引用结果
    @Override
    public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
        Project project = myElement.getProject(); // 获取当前元素所在的项目
        final List<SimpleNamedElement> properties = SimpleUtil.findAllIdentifiers(project); // 查找与键值相关的属性列表
        List<ResolveResult> results = new ArrayList<>(); // 创建解析结果列表
        for (SimpleNamedElement property : properties) { // 遍历找到的属性
            if (property.getName() != null && property.getName().equals(key)) {
                results.add(new PsiElementResolveResult(property)); // 将属性封装为解析结果并添加到列表中
                LOG.error("Matching identifier found: " + property.getName()); // 记录匹配信息
            }
        }
        LOG.error("Total identifiers resolved: " + results.size()); // 记录解析的数量
        return results.toArray(new ResolveResult[0]); // 将列表转换为数组并返回
    }

    // 重写resolve方法，返回单一的解析结果
    @Nullable
    @Override
    public PsiElement resolve() {
        ResolveResult[] resolveResults = multiResolve(false); // 获取多个解析结果
        PsiElement result = resolveResults.length == 1 ? resolveResults[0].getElement() : null;
        LOG.error("Resolve result: " + (result != null ? result.getText() : "null")); // 记录解析结果
        return result;
    }

    // 重写getVariants方法，用于获取所有可能的自动补全选项
    @Override
    public Object @NotNull [] getVariants() {
        Project project = myElement.getProject(); // 获取当前元素所在的项目
        List<SimpleNamedElement> properties = SimpleUtil.findAllIdentifiers(project); // 获取所有属性
        List<LookupElement> variants = new ArrayList<>(); // 创建自动补全选项列表
        for (final SimpleNamedElement property : properties) { // 遍历所有属性
            if (property.getName() != null && !property.getName().isEmpty()) { // 如果属性的键不为空
                variants.add(LookupElementBuilder // 创建自动补全选项
                        .create(property).withIcon(SimpleIcons.FILE) // 设置图标
                        .withTypeText(property.getContainingFile().getName()) // 设置类型文本为文件名
                );
            }
        }
        LOG.error("Autocomplete variants count: " + variants.size()); // 记录自动补全候选数量
        return variants.toArray(); // 将列表转换为数组并返回
    }

}