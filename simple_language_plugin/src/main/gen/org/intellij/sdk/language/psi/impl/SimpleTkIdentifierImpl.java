// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiReference;
import org.intellij.sdk.language.SimpleReference;
import org.intellij.sdk.language.psi.SimpleTkIdentifier;
import org.intellij.sdk.language.psi.SimpleVisitor;
import org.jetbrains.annotations.NotNull;

public class SimpleTkIdentifierImpl extends SimpleNamedElementImpl implements SimpleTkIdentifier {

  public SimpleTkIdentifierImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitTkIdentifier(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  public String getName() {
    return SimplePsiImplUtil.getName(this);
  }

  @Override
  public PsiElement setName(String newName) {
    return SimplePsiImplUtil.setName(this, newName);
  }

  @Override
  public PsiElement getNameIdentifier() {
    return SimplePsiImplUtil.getNameIdentifier(this);
  }

  @Override
  public ItemPresentation getPresentation() {
    return SimplePsiImplUtil.getPresentation(this);
  }

  @Override
  public PsiReference getReference() {
    return SimplePsiImplUtil.getReference(this);
  }

  @Override
  public SimpleReference @NotNull [] getReferences() {
    return SimplePsiImplUtil.getReferences(this);
  }

  @Override
  public int getTextOffset() {
    return SimplePsiImplUtil.getTextOffset(this);
  }

}
