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

public class SimpleLoopForImpl extends ASTWrapperPsiElement implements SimpleLoopFor {

  public SimpleLoopForImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitLoopFor(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<SimpleFishExpr> getFishExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SimpleFishExpr.class);
  }

  @Override
  @NotNull
  public SimpleKwFor getKwFor() {
    return findNotNullChildByClass(SimpleKwFor.class);
  }

  @Override
  @Nullable
  public SimpleKwLocal getKwLocal() {
    return findChildByClass(SimpleKwLocal.class);
  }

  @Override
  @NotNull
  public List<SimpleOpComma> getOpCommaList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SimpleOpComma.class);
  }

  @Override
  @NotNull
  public SimpleParenL getParenL() {
    return findNotNullChildByClass(SimpleParenL.class);
  }

  @Override
  @NotNull
  public SimpleParenR getParenR() {
    return findNotNullChildByClass(SimpleParenR.class);
  }

}
