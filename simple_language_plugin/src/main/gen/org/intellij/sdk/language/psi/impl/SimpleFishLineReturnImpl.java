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

public class SimpleFishLineReturnImpl extends ASTWrapperPsiElement implements SimpleFishLineReturn {

  public SimpleFishLineReturnImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitFishLineReturn(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SimpleFishExpr getFishExpr() {
    return findChildByClass(SimpleFishExpr.class);
  }

  @Override
  @NotNull
  public SimpleKwReturn getKwReturn() {
    return findNotNullChildByClass(SimpleKwReturn.class);
  }

  @Override
  @Nullable
  public SimpleTkComment getTkComment() {
    return findChildByClass(SimpleTkComment.class);
  }

}
