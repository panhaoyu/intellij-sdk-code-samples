// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.language;

import com.google.common.collect.Lists;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.*;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.CachedValueProvider;
import com.intellij.psi.util.CachedValuesManager;
import com.intellij.psi.util.PsiModificationTracker;
import com.intellij.psi.util.PsiTreeUtil;
import org.intellij.sdk.language.psi.SimpleFile;
import org.intellij.sdk.language.psi.SimpleProperty;
import org.intellij.sdk.language.psi.SimpleTkIdentifier;
import org.jetbrains.annotations.NotNull;

import java.util.*;

// SimpleUtil类提供了一系列静态方法，用于搜索和操作Simple语言文件
public class SimpleUtil {
    /**
     * 收集Simple键/值对上方的所有注释元素。
     *
     * @param property Simple属性
     * @return 组合后的文档注释
     */
    public static @NotNull String findDocumentationComment(SimpleProperty property) {
        List<String> result = new LinkedList<>();
        PsiElement element = property.getPrevSibling();
        while (element instanceof PsiComment || element instanceof PsiWhiteSpace) {
            if (element instanceof PsiComment) {
                // 清除注释符号，并将注释添加到列表中
                String commentText = element.getText().replaceFirst("[!# ]+", "");
                result.add(commentText);
            }
            element = element.getPrevSibling();
        }
        // 将所有注释反向连接成单个字符串
        return StringUtil.join(Lists.reverse(result), "\n ");
    }

    /**
     * 查找整个项目中所有标识符元素（SimpleNamedElement）。
     *
     * @param project 当前项目
     * @return 找到的所有标识符元素的列表
     */
    public static List<SimpleTkIdentifier> findIdentifiers(Project project) {
        List<SimpleTkIdentifier> result = new ArrayList<>();
        Collection<VirtualFile> files = FileTypeIndex.getFiles(SimpleFileType.INSTANCE, GlobalSearchScope.allScope(project));

        for (VirtualFile virtualFile : files) {
            PsiFile psiFile = PsiManager.getInstance(project).findFile(virtualFile);
            if (psiFile instanceof SimpleFile simpleFile) {
                List<SimpleTkIdentifier> identifiers = getCachedIdentifiersForFile(simpleFile);
                result.addAll(identifiers);
            }
        }
        return result;
    }

    /**
     * 获取某个文件中的标识符元素，并进行缓存。
     *
     * @param simpleFile 要处理的文件
     * @return 文件中的标识符元素列表
     */
    private static List<SimpleTkIdentifier> getCachedIdentifiersForFile(SimpleFile simpleFile) {
        return CachedValuesManager.getCachedValue(simpleFile, () -> {
            Collection<SimpleTkIdentifier> identifiers = PsiTreeUtil.findChildrenOfType(simpleFile, SimpleTkIdentifier.class);
            List<SimpleTkIdentifier> identifierList = new ArrayList<>(identifiers);

            return CachedValueProvider.Result.create(identifierList, simpleFile, PsiModificationTracker.MODIFICATION_COUNT);
        });
    }

    /**
     * 查找整个项目中所有标识符元素（SimpleNamedElement）。
     *
     * @param project 当前项目
     * @return 找到的所有标识符元素的列表
     */
    public static List<SimpleTkIdentifier> findIdentifiers(Project project, String key) {
        final List<SimpleTkIdentifier> properties = findIdentifiers(project); // 查找与键值相关的属性列表
        List<SimpleTkIdentifier> results = new ArrayList<>(); // 创建解析结果列表
        for (SimpleTkIdentifier identifier : properties) { // 遍历找到的属性
            if (Objects.equals(identifier.getName(), key)) {
                results.add(identifier);
            }
        }
        return results;
    }

    /**
     * Finds the declarations of all identifiers within a project. Only the first occurrence of each identifier is considered the declaration.
     *
     * @param project the current project in which to search for declarations.
     * @return a list of SimpleNamedElement, each representing a declaration.
     */
    public static List<SimpleTkIdentifier> findAllDeclarations(Project project) {
        List<SimpleTkIdentifier> result = new ArrayList<>();
        Set<String> seenNames = new HashSet<>();

        for (SimpleTkIdentifier element : findIdentifiers(project)) {
            if (!seenNames.contains(element.getName())) {
                seenNames.add(element.getName());
                result.add(element);
            }
        }
        return result;
    }
}
