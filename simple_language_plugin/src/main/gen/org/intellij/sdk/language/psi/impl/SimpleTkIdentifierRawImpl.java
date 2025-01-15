// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.intellij.sdk.language.psi.SimpleTypes.*;
import org.intellij.sdk.language.psi.*;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiReference;
import org.intellij.sdk.language.SimpleReference;

public class SimpleTkIdentifierRawImpl extends SimpleNamedElementImpl implements SimpleTkIdentifierRaw {

  public SimpleTkIdentifierRawImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitTkIdentifierRaw(this);
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
