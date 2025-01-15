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

public class SimpleCommandTokenAllImpl extends ASTWrapperPsiElement implements SimpleCommandTokenAll {

  public SimpleCommandTokenAllImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitCommandTokenAll(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SimpleCommandExprFuncCall getCommandExprFuncCall() {
    return findChildByClass(SimpleCommandExprFuncCall.class);
  }

  @Override
  @Nullable
  public SimpleCommandTokenConnectedWithMinus getCommandTokenConnectedWithMinus() {
    return findChildByClass(SimpleCommandTokenConnectedWithMinus.class);
  }

  @Override
  @Nullable
  public SimpleCommandTokenInlineFish getCommandTokenInlineFish() {
    return findChildByClass(SimpleCommandTokenInlineFish.class);
  }

  @Override
  @Nullable
  public SimpleCommandTokenKeywordAll getCommandTokenKeywordAll() {
    return findChildByClass(SimpleCommandTokenKeywordAll.class);
  }

  @Override
  @Nullable
  public SimpleOpAssign getOpAssign() {
    return findChildByClass(SimpleOpAssign.class);
  }

  @Override
  @Nullable
  public SimpleOpBinaryWithoutMinus getOpBinaryWithoutMinus() {
    return findChildByClass(SimpleOpBinaryWithoutMinus.class);
  }

  @Override
  @Nullable
  public SimpleOpComma getOpComma() {
    return findChildByClass(SimpleOpComma.class);
  }

  @Override
  @Nullable
  public SimpleOpDot getOpDot() {
    return findChildByClass(SimpleOpDot.class);
  }

  @Override
  @Nullable
  public SimpleOpUnary getOpUnary() {
    return findChildByClass(SimpleOpUnary.class);
  }

  @Override
  @Nullable
  public SimpleParenL getParenL() {
    return findChildByClass(SimpleParenL.class);
  }

  @Override
  @Nullable
  public SimpleParenR getParenR() {
    return findChildByClass(SimpleParenR.class);
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
  @Nullable
  public SimpleTkLiteral getTkLiteral() {
    return findChildByClass(SimpleTkLiteral.class);
  }

  @Override
  @Nullable
  public SimpleTkValue getTkValue() {
    return findChildByClass(SimpleTkValue.class);
  }

}
