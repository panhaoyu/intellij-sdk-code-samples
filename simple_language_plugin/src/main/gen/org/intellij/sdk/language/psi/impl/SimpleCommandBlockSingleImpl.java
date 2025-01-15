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

public class SimpleCommandBlockSingleImpl extends ASTWrapperPsiElement implements SimpleCommandBlockSingle {

  public SimpleCommandBlockSingleImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitCommandBlockSingle(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SimpleCommandBlockDefine getCommandBlockDefine() {
    return findChildByClass(SimpleCommandBlockDefine.class);
  }

  @Override
  @Nullable
  public SimpleCommandLineComment getCommandLineComment() {
    return findChildByClass(SimpleCommandLineComment.class);
  }

  @Override
  @Nullable
  public SimpleCommandLineFuncCall getCommandLineFuncCall() {
    return findChildByClass(SimpleCommandLineFuncCall.class);
  }

  @Override
  @Nullable
  public SimpleCommandLineInlineFish getCommandLineInlineFish() {
    return findChildByClass(SimpleCommandLineInlineFish.class);
  }

  @Override
  @Nullable
  public SimpleCommandLineOtherWords getCommandLineOtherWords() {
    return findChildByClass(SimpleCommandLineOtherWords.class);
  }

}
