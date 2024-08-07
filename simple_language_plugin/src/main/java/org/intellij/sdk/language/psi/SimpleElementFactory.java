// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.language.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;
import org.intellij.sdk.language.SimpleFileType;

public class SimpleElementFactory {

    public static SimpleTkIdentifier createIdentifier(Project project, String name) {
        PsiElement element = createFile(project, "@" + name);
        while (!(element instanceof SimpleTkIdentifier)) {
            element = element.getLastChild();
        }
        return (SimpleTkIdentifier) element;
    }

    public static SimpleFile createFile(Project project, String text) {
        String name = "dummy.fis";
        return (SimpleFile) PsiFileFactory.getInstance(project).createFileFromText(name, SimpleFileType.INSTANCE, text);
    }

    public static PsiElement createCRLF(Project project) {
        final SimpleFile file = createFile(project, "\n");
        return file.getFirstChild();
    }

}
