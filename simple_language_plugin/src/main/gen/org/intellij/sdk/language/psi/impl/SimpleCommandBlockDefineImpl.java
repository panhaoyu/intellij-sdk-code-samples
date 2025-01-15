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

public class SimpleCommandBlockDefineImpl extends ASTWrapperPsiElement implements SimpleCommandBlockDefine {

  public SimpleCommandBlockDefineImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitCommandBlockDefine(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<SimpleEol> getEolList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SimpleEol.class);
  }

  @Override
  @Nullable
  public SimpleFishBlockBodyDefine getFishBlockBodyDefine() {
    return findChildByClass(SimpleFishBlockBodyDefine.class);
  }

  @Override
  @NotNull
  public SimpleFishLineDefineFooter getFishLineDefineFooter() {
    return findNotNullChildByClass(SimpleFishLineDefineFooter.class);
  }

  @Override
  @NotNull
  public SimpleFishLineDefineHeader getFishLineDefineHeader() {
    return findNotNullChildByClass(SimpleFishLineDefineHeader.class);
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
