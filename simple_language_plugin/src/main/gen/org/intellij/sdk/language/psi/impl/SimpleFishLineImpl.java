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

public class SimpleFishLineImpl extends ASTWrapperPsiElement implements SimpleFishLine {

  public SimpleFishLineImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitFishLine(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SimpleFishLineArrayDeclare getFishLineArrayDeclare() {
    return findChildByClass(SimpleFishLineArrayDeclare.class);
  }

  @Override
  @Nullable
  public SimpleFishLineAssign getFishLineAssign() {
    return findChildByClass(SimpleFishLineAssign.class);
  }

  @Override
  @Nullable
  public SimpleFishLineBreak getFishLineBreak() {
    return findChildByClass(SimpleFishLineBreak.class);
  }

  @Override
  @Nullable
  public SimpleFishLineContinue getFishLineContinue() {
    return findChildByClass(SimpleFishLineContinue.class);
  }

  @Override
  @Nullable
  public SimpleFishLineExit getFishLineExit() {
    return findChildByClass(SimpleFishLineExit.class);
  }

  @Override
  @Nullable
  public SimpleFishLineExitLoop getFishLineExitLoop() {
    return findChildByClass(SimpleFishLineExitLoop.class);
  }

  @Override
  @Nullable
  public SimpleFishLineExitSection getFishLineExitSection() {
    return findChildByClass(SimpleFishLineExitSection.class);
  }

  @Override
  @Nullable
  public SimpleFishLineExpr getFishLineExpr() {
    return findChildByClass(SimpleFishLineExpr.class);
  }

  @Override
  @Nullable
  public SimpleFishLineReturn getFishLineReturn() {
    return findChildByClass(SimpleFishLineReturn.class);
  }

}
