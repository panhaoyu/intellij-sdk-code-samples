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

public class SimpleFishExprUnaryImpl extends ASTWrapperPsiElement implements SimpleFishExprUnary {

  public SimpleFishExprUnaryImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitFishExprUnary(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public SimpleFishExpr getFishExpr() {
    return findNotNullChildByClass(SimpleFishExpr.class);
  }

  @Override
  @NotNull
  public SimpleOpUnary getOpUnary() {
    return findNotNullChildByClass(SimpleOpUnary.class);
  }

}
