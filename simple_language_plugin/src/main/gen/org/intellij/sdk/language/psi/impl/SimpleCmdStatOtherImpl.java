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

public class SimpleCmdStatOtherImpl extends ASTWrapperPsiElement implements SimpleCmdStatOther {

  public SimpleCmdStatOtherImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitCmdStatOther(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<SimpleTkIdentifier> getTkIdentifierList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SimpleTkIdentifier.class);
  }

  @Override
  @NotNull
  public List<SimpleTkLiteral> getTkLiteralList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SimpleTkLiteral.class);
  }

}
