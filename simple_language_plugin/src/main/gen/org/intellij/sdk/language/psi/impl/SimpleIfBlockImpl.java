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

public class SimpleIfBlockImpl extends ASTWrapperPsiElement implements SimpleIfBlock {

  public SimpleIfBlockImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitIfBlock(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SimpleElseBlock getElseBlock() {
    return findChildByClass(SimpleElseBlock.class);
  }

  @Override
  @NotNull
  public List<SimpleElseIfBlock> getElseIfBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SimpleElseIfBlock.class);
  }

  @Override
  @NotNull
  public List<SimpleEndOfLine> getEndOfLineList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SimpleEndOfLine.class);
  }

  @Override
  @Nullable
  public SimpleFishBlock getFishBlock() {
    return findChildByClass(SimpleFishBlock.class);
  }

  @Override
  @NotNull
  public List<SimpleIdentifierElement> getIdentifierElementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SimpleIdentifierElement.class);
  }

  @Override
  @NotNull
  public List<SimpleValue> getValueList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SimpleValue.class);
  }

}
