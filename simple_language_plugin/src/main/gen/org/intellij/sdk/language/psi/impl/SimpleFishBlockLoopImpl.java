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

public class SimpleFishBlockLoopImpl extends ASTWrapperPsiElement implements SimpleFishBlockLoop {

  public SimpleFishBlockLoopImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitFishBlockLoop(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<SimpleEol> getEolList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SimpleEol.class);
  }

  @Override
  @Nullable
  public SimpleFishBlockBodyLoop getFishBlockBodyLoop() {
    return findChildByClass(SimpleFishBlockBodyLoop.class);
  }

  @Override
  @NotNull
  public SimpleFishLineLoopBlockFooter getFishLineLoopBlockFooter() {
    return findNotNullChildByClass(SimpleFishLineLoopBlockFooter.class);
  }

  @Override
  @NotNull
  public SimpleFishLineLoopBlockHeader getFishLineLoopBlockHeader() {
    return findNotNullChildByClass(SimpleFishLineLoopBlockHeader.class);
  }

}
