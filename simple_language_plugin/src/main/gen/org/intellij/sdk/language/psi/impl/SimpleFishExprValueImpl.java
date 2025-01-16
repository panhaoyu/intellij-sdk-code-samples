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

public class SimpleFishExprValueImpl extends ASTWrapperPsiElement implements SimpleFishExprValue {

  public SimpleFishExprValueImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitFishExprValue(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SimpleFishExprFuncCall getFishExprFuncCall() {
    return findChildByClass(SimpleFishExprFuncCall.class);
  }

  @Override
  @Nullable
  public SimpleFishExprParen getFishExprParen() {
    return findChildByClass(SimpleFishExprParen.class);
  }

  @Override
  @Nullable
  public SimpleFishExprSquare getFishExprSquare() {
    return findChildByClass(SimpleFishExprSquare.class);
  }

  @Override
  @Nullable
  public SimpleFishExprUnary getFishExprUnary() {
    return findChildByClass(SimpleFishExprUnary.class);
  }

  @Override
  @Nullable
  public SimpleTkValue getTkValue() {
    return findChildByClass(SimpleTkValue.class);
  }

}
