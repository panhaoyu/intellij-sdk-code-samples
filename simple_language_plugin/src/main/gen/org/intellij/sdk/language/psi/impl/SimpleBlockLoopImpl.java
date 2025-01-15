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

public class SimpleBlockLoopImpl extends ASTWrapperPsiElement implements SimpleBlockLoop {

  public SimpleBlockLoopImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitBlockLoop(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public SimpleBlockHeaderLoop getBlockHeaderLoop() {
    return findNotNullChildByClass(SimpleBlockHeaderLoop.class);
  }

  @Override
  @Nullable
  public SimpleBodyLoop getBodyLoop() {
    return findChildByClass(SimpleBodyLoop.class);
  }

  @Override
  @NotNull
  public List<SimpleEol> getEolList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SimpleEol.class);
  }

}
