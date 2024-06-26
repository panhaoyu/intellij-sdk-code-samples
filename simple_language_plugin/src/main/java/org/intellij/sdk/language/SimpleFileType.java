// Copyright 2000-2024 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package org.intellij.sdk.language;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public final class SimpleFileType extends LanguageFileType {

    public static final SimpleFileType INSTANCE = new SimpleFileType();

    private SimpleFileType() {
        super(SimpleLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Itasca Fish";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Itasca Fish Script";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "fis";
    }

    @Override
    public Icon getIcon() {
        return SimpleIcons.FILE;
    }

}
