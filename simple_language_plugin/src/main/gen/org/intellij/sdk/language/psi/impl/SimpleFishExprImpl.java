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

public class SimpleFishExprImpl extends ASTWrapperPsiElement implements SimpleFishExpr {

  public SimpleFishExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitFishExpr(this);
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
  public List<SimpleFishExprFuncCall> getFishExprFuncCallList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SimpleFishExprFuncCall.class);
  }

  @Override
  @NotNull
  public List<SimpleFishExprParen> getFishExprParenList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SimpleFishExprParen.class);
  }

  @Override
  @NotNull
  public List<SimpleOpBinary> getOpBinaryList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SimpleOpBinary.class);
  }

  @Override
  @NotNull
  public List<SimpleOpUnary> getOpUnaryList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SimpleOpUnary.class);
  }

  @Override
  @Nullable
  public SimpleSquareL getSquareL() {
    return findChildByClass(SimpleSquareL.class);
  }

  @Override
  @Nullable
  public SimpleSquareR getSquareR() {
    return findChildByClass(SimpleSquareR.class);
  }

  @Override
  @NotNull
  public List<SimpleTkValue> getTkValueList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SimpleTkValue.class);
  }

}
