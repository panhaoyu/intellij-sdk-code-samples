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

public class SimpleFishStatementImpl extends ASTWrapperPsiElement implements SimpleFishStatement {

  public SimpleFishStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitFishStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SimpleAssignmentStatement getAssignmentStatement() {
    return findChildByClass(SimpleAssignmentStatement.class);
  }

  @Override
  @Nullable
  public SimpleIdentifierElement getIdentifierElement() {
    return findChildByClass(SimpleIdentifierElement.class);
  }

  @Override
  @NotNull
  public List<SimpleValue> getValueList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SimpleValue.class);
  }

}