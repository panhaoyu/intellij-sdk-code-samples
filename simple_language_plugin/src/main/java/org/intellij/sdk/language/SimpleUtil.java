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

// SimpleUtil���ṩ��һϵ�о�̬���������������Ͳ���Simple�����ļ�
public class SimpleUtil {
    /**
     * ��������Ŀ�����������ض�����Simple���ԡ�
     *
     * @param project ��ǰ��Ŀ
     * @param key Ҫ�����ļ�
     * @return ƥ��������б�
     */
//    private static final Map<Project, List<SimpleIdentifierElement>> cachedKeys = new HashMap<>();
    public static List<SimpleProperty> findProperties(Project project, String key) {
        List<SimpleProperty> result = new ArrayList<>(); // ����һ�����б����ڴ���ҵ�������

        // ������Ŀ�����е�Simple�ļ�
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(SimpleFileType.INSTANCE, GlobalSearchScope.allScope(project));
        // ����ÿһ���ļ�
        for (VirtualFile virtualFile : virtualFiles) {
            // ͨ��PsiManager��VirtualFileת����SimpleFile
            SimpleFile simpleFile = (SimpleFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (simpleFile != null) { // ȷ���ļ���Ϊ��
                // ��ȡsimpleFile�����е�SimpleProperty����
                SimpleProperty[] properties = PsiTreeUtil.getChildrenOfType(simpleFile, SimpleProperty.class);
                if (properties != null) { // ȷ�������б�Ϊ��
                    // ɸѡ�������������ƥ�������
                    for (SimpleProperty property : properties) {
                        if (key.equals(property.getName())) {
                            result.add(property); // ��ƥ���������ӵ�����б���
                        }
                    }
                }
            }
        }
        return result; // �����ҵ�������ƥ�����Ե��б�
    }

    /**
     * ��ȡ��Ŀ�����е�Simple���ԡ�
     *
     * @param project ��ǰ��Ŀ
     * @return �������Ե��б�
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
     * �ռ�Simple��/ֵ���Ϸ�������ע��Ԫ�ء�
     *
     * @param property Simple����
     * @return ��Ϻ���ĵ�ע��
     */
    public static @NotNull String findDocumentationComment(SimpleProperty property) {
        List<String> result = new LinkedList<>();
        PsiElement element = property.getPrevSibling();
        while (element instanceof PsiComment || element instanceof PsiWhiteSpace) {
            if (element instanceof PsiComment) {
                // ���ע�ͷ��ţ�����ע����ӵ��б���
                String commentText = element.getText().replaceFirst("[!# ]+", "");
                result.add(commentText);
            }
            element = element.getPrevSibling();
        }
        // ������ע�ͷ������ӳɵ����ַ���
        return StringUtil.join(Lists.reverse(result), "\n ");
    }

    /**
     * ����������Ŀ�����б�ʶ��Ԫ�أ�SimpleNamedElement����
     *
     * @param project ��ǰ��Ŀ
     * @return �ҵ������б�ʶ��Ԫ�ص��б�
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
     * ����������Ŀ�����б�ʶ��Ԫ�أ�SimpleNamedElement����
     *
     * @param project ��ǰ��Ŀ
     * @return �ҵ������б�ʶ��Ԫ�ص��б�
     */
    public static List<SimpleTkIdentifier> findIdentifiers(Project project, String key) {
        final List<SimpleTkIdentifier> properties = findIdentifiers(project); // �������ֵ��ص������б�
        List<SimpleTkIdentifier> results = new ArrayList<>(); // ������������б�
        for (SimpleTkIdentifier identifier : properties) { // �����ҵ�������
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
