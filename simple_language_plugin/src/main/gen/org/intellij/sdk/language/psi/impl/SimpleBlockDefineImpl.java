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
import com.intellij.navigation.ItemPresentation;

public class SimpleBlockDefineImpl extends ASTWrapperPsiElement implements SimpleBlockDefine {

  public SimpleBlockDefineImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitBlockDefine(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SimpleBlockFish getBlockFish() {
    return findChildByClass(SimpleBlockFish.class);
  }

  @Override
  @NotNull
  public List<SimpleEol> getEolList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SimpleEol.class);
  }

  @Override
  @NotNull
  public SimpleFishDefineHeader getFishDefineHeader() {
    return findNotNullChildByClass(SimpleFishDefineHeader.class);
  }

  @Override
  public String getName() {
    return SimplePsiImplUtil.getName(this);
  }

  @Override
  public ItemPresentation getPresentation() {
    return SimplePsiImplUtil.getPresentation(this);
  }

}
