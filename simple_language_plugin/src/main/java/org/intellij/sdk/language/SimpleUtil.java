// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.language;

import com.google.common.collect.Lists;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiWhiteSpace;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import org.intellij.sdk.language.psi.SimpleFile;
import org.intellij.sdk.language.psi.SimpleProperty;
import org.intellij.sdk.language.psi.SimpleTkIdentifier;
import org.jetbrains.annotations.NotNull;

import java.util.*;

// SimpleUtil类提供了一系列静态方法，用于搜索和操作Simple语言文件
public class SimpleUtil {
    /**
     * 在整个项目中搜索含有特定键的Simple属性。
     *
     * @param project 当前项目
     * @param key 要搜索的键
     * @return 匹配的属性列表
     */
//    private static final Map<Project, List<SimpleIdentifierElement>> cachedKeys = new HashMap<>();
    public static List<SimpleProperty> findProperties(Project project, String key) {
        List<SimpleProperty> result = new ArrayList<>(); // 创建一个空列表用于存放找到的属性

        // 搜索项目中所有的Simple文件
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(SimpleFileType.INSTANCE, GlobalSearchScope.allScope(project));
        // 遍历每一个文件
        for (VirtualFile virtualFile : virtualFiles) {
            // 通过PsiManager将VirtualFile转换成SimpleFile
            SimpleFile simpleFile = (SimpleFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (simpleFile != null) { // 确保文件不为空
                // 获取simpleFile中所有的SimpleProperty对象
                SimpleProperty[] properties = PsiTreeUtil.getChildrenOfType(simpleFile, SimpleProperty.class);
                if (properties != null) { // 确保属性列表不为空
                    // 筛选出键与给定键相匹配的属性
                    for (SimpleProperty property : properties) {
                        if (key.equals(property.getName())) {
                            result.add(property); // 将匹配的属性添加到结果列表中
                        }
                    }
                }
            }
        }
        return result; // 返回找到的所有匹配属性的列表
    }

    /**
     * 获取项目中所有的Simple属性。
     *
     * @param project 当前项目
     * @return 所有属性的列表
     */
    public static List<SimpleProperty> findProperties(Project project) {
        List<SimpleProperty> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(SimpleFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            SimpleFile simpleFile = (SimpleFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (simpleFile != null) {
                SimpleProperty[] properties = PsiTreeUtil.getChildrenOfType(simpleFile, SimpleProperty.class);
                if (properties != null) {
                    Collections.addAll(result, properties);
                }
            }
        }
        return result;
    }

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
            SimpleFile simpleFile = (SimpleFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (simpleFile != null) {
                Collection<SimpleTkIdentifier> identifiers = PsiTreeUtil.findChildrenOfType(simpleFile, SimpleTkIdentifier.class);
                result.addAll(identifiers);
            }
        }
        return result;
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
