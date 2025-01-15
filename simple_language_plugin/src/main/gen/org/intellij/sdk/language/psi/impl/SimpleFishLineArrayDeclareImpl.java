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

public class SimpleFishLineArrayDeclareImpl extends ASTWrapperPsiElement implements SimpleFishLineArrayDeclare {

  public SimpleFishLineArrayDeclareImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitFishLineArrayDeclare(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public SimpleLiteralNumber getLiteralNumber() {
    return findNotNullChildByClass(SimpleLiteralNumber.class);
  }

  @Override
  @NotNull
  public SimpleParenL getParenL() {
    return findNotNullChildByClass(SimpleParenL.class);
  }

  @Override
  @NotNull
  public SimpleParenR getParenR() {
    return findNotNullChildByClass(SimpleParenR.class);
  }

  @Override
  @Nullable
  public SimpleTkComment getTkComment() {
    return findChildByClass(SimpleTkComment.class);
  }

  @Override
  @NotNull
  public SimpleTkIdentifier getTkIdentifier() {
    return findNotNullChildByClass(SimpleTkIdentifier.class);
  }

}
