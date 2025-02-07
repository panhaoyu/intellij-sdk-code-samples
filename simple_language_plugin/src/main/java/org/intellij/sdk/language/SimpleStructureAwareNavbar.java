// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package org.intellij.sdk.language;

import com.intellij.icons.AllIcons;
import com.intellij.ide.navigationToolbar.StructureAwareNavBarModelExtension;
import com.intellij.lang.Language;
import org.intellij.sdk.language.psi.SimpleCommandBlockDefine;
import org.intellij.sdk.language.psi.SimpleFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

final class SimpleStructureAwareNavbar extends StructureAwareNavBarModelExtension {

    @NotNull
    @Override
    protected Language getLanguage() {
        return SimpleLanguage.INSTANCE;
    }

    @Override
    public @Nullable String getPresentableText(Object object) {
        if (object instanceof SimpleFile file) {
            return file.getName();
        }
        if (object instanceof SimpleCommandBlockDefine blockDefine) {
            return blockDefine.getText();
        }

        return null;
    }

    @Override
    @Nullable
    public Icon getIcon(Object object) {
        if (object instanceof SimpleCommandBlockDefine) {
            return AllIcons.Nodes.Function;
        }

        return null;
    }

}
