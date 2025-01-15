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

public class SimpleCommandInlineFishLineImpl extends ASTWrapperPsiElement implements SimpleCommandInlineFishLine {

  public SimpleCommandInlineFishLineImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitCommandInlineFishLine(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SimpleCommandInlineFishLineArrayDeclare getCommandInlineFishLineArrayDeclare() {
    return findChildByClass(SimpleCommandInlineFishLineArrayDeclare.class);
  }

  @Override
  @Nullable
  public SimpleCommandInlineFishLineAssign getCommandInlineFishLineAssign() {
    return findChildByClass(SimpleCommandInlineFishLineAssign.class);
  }

  @Override
  @Nullable
  public SimpleCommandInlineFishLineExpr getCommandInlineFishLineExpr() {
    return findChildByClass(SimpleCommandInlineFishLineExpr.class);
  }

}
