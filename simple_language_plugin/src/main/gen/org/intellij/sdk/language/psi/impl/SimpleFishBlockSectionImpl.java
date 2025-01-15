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

public class SimpleFishBlockSectionImpl extends ASTWrapperPsiElement implements SimpleFishBlockSection {

  public SimpleFishBlockSectionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitFishBlockSection(this);
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
  public SimpleFishBlockBodySection getFishBlockBodySection() {
    return findChildByClass(SimpleFishBlockBodySection.class);
  }

  @Override
  @NotNull
  public SimpleFishLineSectionFooter getFishLineSectionFooter() {
    return findNotNullChildByClass(SimpleFishLineSectionFooter.class);
  }

  @Override
  @NotNull
  public SimpleFishLineSectionHeader getFishLineSectionHeader() {
    return findNotNullChildByClass(SimpleFishLineSectionHeader.class);
  }

}
