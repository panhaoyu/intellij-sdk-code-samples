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

public class SimpleCommandExprFuncCallImpl extends ASTWrapperPsiElement implements SimpleCommandExprFuncCall {

  public SimpleCommandExprFuncCallImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitCommandExprFuncCall(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public SimpleFishExprFuncCall getFishExprFuncCall() {
    return findNotNullChildByClass(SimpleFishExprFuncCall.class);
  }

  @Override
  @NotNull
  public SimpleOpAt getOpAt() {
    return findNotNullChildByClass(SimpleOpAt.class);
  }

}
