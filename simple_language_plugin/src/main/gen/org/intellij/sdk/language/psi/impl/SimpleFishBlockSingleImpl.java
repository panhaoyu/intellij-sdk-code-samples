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

public class SimpleFishBlockSingleImpl extends ASTWrapperPsiElement implements SimpleFishBlockSingle {

  public SimpleFishBlockSingleImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitFishBlockSingle(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SimpleFishBlockCaseOf getFishBlockCaseOf() {
    return findChildByClass(SimpleFishBlockCaseOf.class);
  }

  @Override
  @Nullable
  public SimpleFishBlockCommand getFishBlockCommand() {
    return findChildByClass(SimpleFishBlockCommand.class);
  }

  @Override
  @Nullable
  public SimpleFishBlockIf getFishBlockIf() {
    return findChildByClass(SimpleFishBlockIf.class);
  }

  @Override
  @Nullable
  public SimpleFishBlockLoop getFishBlockLoop() {
    return findChildByClass(SimpleFishBlockLoop.class);
  }

  @Override
  @Nullable
  public SimpleFishBlockSection getFishBlockSection() {
    return findChildByClass(SimpleFishBlockSection.class);
  }

  @Override
  @Nullable
  public SimpleFishLine getFishLine() {
    return findChildByClass(SimpleFishLine.class);
  }

}
