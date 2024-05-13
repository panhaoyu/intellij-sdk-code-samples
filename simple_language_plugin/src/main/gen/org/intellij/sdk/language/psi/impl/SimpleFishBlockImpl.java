// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.intellij.sdk.language.psi.SimpleTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.intellij.sdk.language.psi.*;

public class SimpleFishBlockImpl extends ASTWrapperPsiElement implements SimpleFishBlock {

  public SimpleFishBlockImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitFishBlock(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<SimpleCaseBlock> getCaseBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SimpleCaseBlock.class);
  }

  @Override
  @NotNull
  public List<SimpleCommandBlock> getCommandBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SimpleCommandBlock.class);
  }

  @Override
  @NotNull
  public List<SimpleEndOfLine> getEndOfLineList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SimpleEndOfLine.class);
  }

  @Override
  @NotNull
  public List<SimpleFishStatement> getFishStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SimpleFishStatement.class);
  }

  @Override
  @NotNull
  public List<SimpleIfBlock> getIfBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SimpleIfBlock.class);
  }

  @Override
  @NotNull
  public List<SimpleLoopBlock> getLoopBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SimpleLoopBlock.class);
  }

}
