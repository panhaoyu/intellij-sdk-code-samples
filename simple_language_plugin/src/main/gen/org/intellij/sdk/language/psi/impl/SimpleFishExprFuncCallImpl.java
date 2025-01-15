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

public class SimpleFishExprFuncCallImpl extends ASTWrapperPsiElement implements SimpleFishExprFuncCall {

  public SimpleFishExprFuncCallImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitFishExprFuncCall(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public SimpleExprParenCsv getExprParenCsv() {
    return findNotNullChildByClass(SimpleExprParenCsv.class);
  }

  @Override
  @NotNull
  public SimpleFishExprFuncCallFuncName getFishExprFuncCallFuncName() {
    return findNotNullChildByClass(SimpleFishExprFuncCallFuncName.class);
  }

}
