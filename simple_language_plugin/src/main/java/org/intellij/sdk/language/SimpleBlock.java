// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.language;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.TokenType;
import com.intellij.psi.formatter.common.AbstractBlock;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

// SimpleBlock类继承自AbstractBlock，用于自定义代码块的格式化
public class SimpleBlock extends AbstractBlock {

    // 定义一个SpacingBuilder实例，用于处理代码块间的空间
    private final SpacingBuilder spacingBuilder;

    // SimpleBlock的构造函数，接收一个AST节点，包装类型，对齐方式，和空间构建器
    protected SimpleBlock(@NotNull ASTNode node, @Nullable Wrap wrap, @Nullable Alignment alignment, SpacingBuilder spacingBuilder) {
        super(node, wrap, alignment);  // 调用父类AbstractBlock的构造函数
        this.spacingBuilder = spacingBuilder;  // 初始化spacingBuilder
    }

    // 重写buildChildren方法，用于构建当前代码块的子块
    @Override
    protected List<Block> buildChildren() {
        List<Block> blocks = new ArrayList<>();  // 创建一个列表用于存储子块
        ASTNode child = myNode.getFirstChildNode();  // 获取当前节点的第一个子节点
        while (child != null) {  // 遍历所有子节点
            if (child.getElementType() != TokenType.WHITE_SPACE) {  // 如果子节点不是空白节点
                // 为每个非空白的子节点创建一个新的SimpleBlock实例
                Block block = new SimpleBlock(child, Wrap.createWrap(WrapType.NONE, false), Alignment.createAlignment(), spacingBuilder);
                blocks.add(block);  // 将新创建的块添加到列表中
            }
            child = child.getTreeNext();  // 移动到下一个兄弟节点
        }
        return blocks;  // 返回构建的子块列表
    }

    // 重写getIndent方法，定义这个块的缩进规则
    @Override
    public Indent getIndent() {
        return Indent.getNoneIndent();  // 返回无缩进
    }

    // 重写getSpacing方法，定义子块间的间隔
    @Nullable
    @Override
    public Spacing getSpacing(@Nullable Block child1, @NotNull Block child2) {
        return spacingBuilder.getSpacing(this, child1, child2);  // 通过spacingBuilder计算间距
    }

    // 重写isLeaf方法，判断当前节点是否为叶子节点（没有子节点的节点）
    @Override
    public boolean isLeaf() {
        return myNode.getFirstChildNode() == null;  // 如果第一个子节点为null，则为叶子节点
    }

}