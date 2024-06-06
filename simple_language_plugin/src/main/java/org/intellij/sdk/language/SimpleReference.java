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
import org.intellij.sdk.language.psi.SimpleTkIdentifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 创建SimpleReference类，它是PsiReferenceBase的子类，实现了PsiPolyVariantReference接口
public final class SimpleReference extends PsiReferenceBase<SimpleTkIdentifier> implements PsiPolyVariantReference {

    private static final Logger LOG = Logger.getInstance(SimpleReference.class); // 日志记录器
    // 定义一个字符串成员变量用于存储键值


    // 构造函数，初始化引用和键值
    public SimpleReference(@NotNull SimpleTkIdentifier element, TextRange textRange) {
        super(element, textRange);
    }

    // 重写multiResolve方法，用于解析多个可能的引用结果
    @Override
    public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
        Project project = myElement.getProject();
        String name = myElement.getName();
        if (name == null) {
            return ResolveResult.EMPTY_ARRAY;
        }
        final List<SimpleTkIdentifier> identifiers = SimpleUtil.findIdentifiers(project, name); // 查找与键值相关的属性列表
        List<ResolveResult> results = new ArrayList<>(); // 创建解析结果列表
        for (SimpleTkIdentifier identifier : identifiers) { // 遍历找到的属性
            results.add(new PsiElementResolveResult(identifier)); // 将属性封装为解析结果并添加到列表中
        }
        LOG.debug("Total identifiers resolved: " + results.size());
        return results.toArray(ResolveResult[]::new); // 将列表转换为数组并返回
    }

    @Nullable
    @Override
    public SimpleTkIdentifier resolve() {
        ResolveResult[] resolveResults = multiResolve(false);
        return resolveResults.length == 1 ? (SimpleTkIdentifier) resolveResults[0].getElement() : null;
    }


    // 重写getVariants方法，用于获取所有可能的自动补全选项
    @Override
    public Object @NotNull [] getVariants() {
        Project project = myElement.getProject();
        List<SimpleTkIdentifier> identifiers = SimpleUtil.findIdentifiers(project); // 获取所有属性
        List<LookupElement> variants = new ArrayList<>(); // 创建自动补全选项列表
        Set<String> seenNames = new HashSet<>(); // 用于跟踪已经添加的名称

        for (final SimpleTkIdentifier identifier : identifiers) { // 遍历所有属性
            String name = identifier.getName();
            if (name != null && !name.isEmpty() && !seenNames.contains(name)) { // 如果属性的键不为空且未被添加
                seenNames.add(name); // 记录名称
                variants.add(LookupElementBuilder // 创建自动补全选项
                        .create(identifier).withIcon(SimpleIcons.FILE) // 设置图标
                        .withTypeText(identifier.getContainingFile().getName()) // 设置类型文本为文件名
                );
            }
        }
        LOG.debug("Autocomplete variants count: " + variants.size());
        return variants.toArray(); // 将列表转换为数组并返回
    }

}