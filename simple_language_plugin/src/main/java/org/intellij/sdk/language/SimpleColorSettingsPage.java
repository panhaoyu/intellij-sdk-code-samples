// Copyright 2000-2024 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package org.intellij.sdk.language;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

final class SimpleColorSettingsPage implements ColorSettingsPage {

    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("OPERATOR", SimpleSyntaxHighlighter.OPERATOR),
            new AttributesDescriptor("KEYWORD", SimpleSyntaxHighlighter.KEYWORD),
            new AttributesDescriptor("STRING_LITERAL", SimpleSyntaxHighlighter.STRING_LITERAL),
            new AttributesDescriptor("BAD_CHARACTER", SimpleSyntaxHighlighter.BAD_CHARACTER),
            new AttributesDescriptor("NUMBER_LITERAL", SimpleSyntaxHighlighter.NUMBER_LITERAL),
            new AttributesDescriptor("COMMENT", SimpleSyntaxHighlighter.COMMENT),
            new AttributesDescriptor("IDENTIFIER", SimpleSyntaxHighlighter.IDENTIFIER),
            new AttributesDescriptor("BRACKETS", SimpleSyntaxHighlighter.BRACKETS),
            new AttributesDescriptor("IMPORTANT_KEYWORD", SimpleSyntaxHighlighter.IMPORTANT_KEYWORD),
    };

    @Override
    public Icon getIcon() {
        return SimpleIcons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new SimpleSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return """
                fish define _msSBiGrpName( sb_state )
                    caseof sb_state
                        system.error = '_msSBiGrpName: sb_state not in range 0-5'
                    case 0
                        _msSBiGrpName = 'unbonded'
                    endcase
                    command
                        project save
                    endcommand
                end
                """;
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @Override
    public AttributesDescriptor @NotNull [] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @Override
    public ColorDescriptor @NotNull [] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Simple";
    }

}
