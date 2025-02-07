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

public class SimpleFishLineLoopBlockHeaderImpl extends ASTWrapperPsiElement implements SimpleFishLineLoopBlockHeader {

  public SimpleFishLineLoopBlockHeaderImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitFishLineLoopBlockHeader(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SimpleFishExprLoopIndexed getFishExprLoopIndexed() {
    return findChildByClass(SimpleFishExprLoopIndexed.class);
  }

  @Override
  @NotNull
  public SimpleKwLoop getKwLoop() {
    return findNotNullChildByClass(SimpleKwLoop.class);
  }

  @Override
  @Nullable
  public SimpleLoopEach getLoopEach() {
    return findChildByClass(SimpleLoopEach.class);
  }

  @Override
  @Nullable
  public SimpleLoopFor getLoopFor() {
    return findChildByClass(SimpleLoopFor.class);
  }

  @Override
  @Nullable
  public SimpleLoopWhile getLoopWhile() {
    return findChildByClass(SimpleLoopWhile.class);
  }

  @Override
  @Nullable
  public SimpleTkComment getTkComment() {
    return findChildByClass(SimpleTkComment.class);
  }

}
