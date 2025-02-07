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

public class SimpleCommandInlineFishLineAssignImpl extends ASTWrapperPsiElement implements SimpleCommandInlineFishLineAssign {

  public SimpleCommandInlineFishLineAssignImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitCommandInlineFishLineAssign(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public SimpleFishAssignScope getFishAssignScope() {
    return findNotNullChildByClass(SimpleFishAssignScope.class);
  }

  @Override
  @NotNull
  public List<SimpleFishExprAssign> getFishExprAssignList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SimpleFishExprAssign.class);
  }

  @Override
  @NotNull
  public List<SimpleOpComma> getOpCommaList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SimpleOpComma.class);
  }

}
