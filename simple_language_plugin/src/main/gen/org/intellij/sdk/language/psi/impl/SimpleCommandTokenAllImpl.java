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
  @NotNull
  public List<SimpleCommandTokenAll> getCommandTokenAllList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SimpleCommandTokenAll.class);
  }

  @Override
  @Nullable
  public SimpleCommandTokenFuncCall getCommandTokenFuncCall() {
    return findChildByClass(SimpleCommandTokenFuncCall.class);
  }

  @Override
  @Nullable
  public SimpleCommandTokenIdentifier getCommandTokenIdentifier() {
    return findChildByClass(SimpleCommandTokenIdentifier.class);
  }

  @Override
  @Nullable
  public SimpleCommandTokenInlineFish getCommandTokenInlineFish() {
    return findChildByClass(SimpleCommandTokenInlineFish.class);
  }

  @Override
  @Nullable
  public SimpleCommandTokenNumberLiteral getCommandTokenNumberLiteral() {
    return findChildByClass(SimpleCommandTokenNumberLiteral.class);
  }

  @Override
  @Nullable
  public SimpleCommandTokenSimpleOperation getCommandTokenSimpleOperation() {
    return findChildByClass(SimpleCommandTokenSimpleOperation.class);
  }

  @Override
  @Nullable
  public SimpleCurlyL getCurlyL() {
    return findChildByClass(SimpleCurlyL.class);
  }

  @Override
  @Nullable
  public SimpleCurlyR getCurlyR() {
    return findChildByClass(SimpleCurlyR.class);
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
  @NotNull
  public List<SimpleOpComma> getOpCommaList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SimpleOpComma.class);
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

}
