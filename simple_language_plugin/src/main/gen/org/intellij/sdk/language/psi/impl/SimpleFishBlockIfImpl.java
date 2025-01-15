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

public class SimpleFishBlockIfImpl extends ASTWrapperPsiElement implements SimpleFishBlockIf {

  public SimpleFishBlockIfImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitFishBlockIf(this);
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
  public SimpleFishBlockBodyElse getFishBlockBodyElse() {
    return findChildByClass(SimpleFishBlockBodyElse.class);
  }

  @Override
  @NotNull
  public List<SimpleFishBlockBodyElseIf> getFishBlockBodyElseIfList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SimpleFishBlockBodyElseIf.class);
  }

  @Override
  @Nullable
  public SimpleFishBlockBodyIf getFishBlockBodyIf() {
    return findChildByClass(SimpleFishBlockBodyIf.class);
  }

  @Override
  @Nullable
  public SimpleFishLineIfBlockElse getFishLineIfBlockElse() {
    return findChildByClass(SimpleFishLineIfBlockElse.class);
  }

  @Override
  @NotNull
  public List<SimpleFishLineIfBlockElseIf> getFishLineIfBlockElseIfList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SimpleFishLineIfBlockElseIf.class);
  }

  @Override
  @NotNull
  public SimpleFishLineIfBlockFooter getFishLineIfBlockFooter() {
    return findNotNullChildByClass(SimpleFishLineIfBlockFooter.class);
  }

  @Override
  @NotNull
  public SimpleFishLineIfBlockHeader getFishLineIfBlockHeader() {
    return findNotNullChildByClass(SimpleFishLineIfBlockHeader.class);
  }

}
