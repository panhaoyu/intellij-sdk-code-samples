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

public class SimpleCommandTokenInlineFishImpl extends ASTWrapperPsiElement implements SimpleCommandTokenInlineFish {

  public SimpleCommandTokenInlineFishImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitCommandTokenInlineFish(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public SimpleCommandInlineFishLine getCommandInlineFishLine() {
    return findNotNullChildByClass(SimpleCommandInlineFishLine.class);
  }

  @Override
  @NotNull
  public SimpleSquareL getSquareL() {
    return findNotNullChildByClass(SimpleSquareL.class);
  }

  @Override
  @NotNull
  public SimpleSquareR getSquareR() {
    return findNotNullChildByClass(SimpleSquareR.class);
  }

}
