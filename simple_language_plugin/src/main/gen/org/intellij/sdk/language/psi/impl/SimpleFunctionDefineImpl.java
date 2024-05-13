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

public class SimpleFunctionDefineImpl extends ASTWrapperPsiElement implements SimpleFunctionDefine {

  public SimpleFunctionDefineImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitFunctionDefine(this);
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
  public SimpleFishBlock getFishBlock() {
    return findChildByClass(SimpleFishBlock.class);
  }

  @Override
  @NotNull
  public List<SimpleIdentifierElement> getIdentifierElementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SimpleIdentifierElement.class);
  }

}
