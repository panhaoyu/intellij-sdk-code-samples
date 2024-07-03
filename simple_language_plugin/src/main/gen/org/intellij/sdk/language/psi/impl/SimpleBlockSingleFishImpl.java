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

public class SimpleBlockSingleFishImpl extends ASTWrapperPsiElement implements SimpleBlockSingleFish {

  public SimpleBlockSingleFishImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitBlockSingleFish(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SimpleBlockCaseOf getBlockCaseOf() {
    return findChildByClass(SimpleBlockCaseOf.class);
  }

  @Override
  @Nullable
  public SimpleBlockCmd getBlockCmd() {
    return findChildByClass(SimpleBlockCmd.class);
  }

  @Override
  @Nullable
  public SimpleBlockIf getBlockIf() {
    return findChildByClass(SimpleBlockIf.class);
  }

  @Override
  @Nullable
  public SimpleBlockLoop getBlockLoop() {
    return findChildByClass(SimpleBlockLoop.class);
  }

  @Override
  @Nullable
  public SimpleBlockSection getBlockSection() {
    return findChildByClass(SimpleBlockSection.class);
  }

  @Override
  @Nullable
  public SimpleStatFish getStatFish() {
    return findChildByClass(SimpleStatFish.class);
  }

}
