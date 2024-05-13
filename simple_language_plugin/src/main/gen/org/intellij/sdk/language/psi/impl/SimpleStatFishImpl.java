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

public class SimpleStatFishImpl extends ASTWrapperPsiElement implements SimpleStatFish {

  public SimpleStatFishImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitStatFish(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SimpleStatAssign getStatAssign() {
    return findChildByClass(SimpleStatAssign.class);
  }

  @Override
  @Nullable
  public SimpleTkIdentifier getTkIdentifier() {
    return findChildByClass(SimpleTkIdentifier.class);
  }

  @Override
  @NotNull
  public List<SimpleTkValue> getTkValueList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SimpleTkValue.class);
  }

}
