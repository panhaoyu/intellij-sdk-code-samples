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

public class SimpleCommandTokenKeywordAllImpl extends ASTWrapperPsiElement implements SimpleCommandTokenKeywordAll {

  public SimpleCommandTokenKeywordAllImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitCommandTokenKeywordAll(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SimpleKwCase getKwCase() {
    return findChildByClass(SimpleKwCase.class);
  }

  @Override
  @Nullable
  public SimpleKwCaseOf getKwCaseOf() {
    return findChildByClass(SimpleKwCaseOf.class);
  }

  @Override
  @Nullable
  public SimpleKwContinue getKwContinue() {
    return findChildByClass(SimpleKwContinue.class);
  }

  @Override
  @Nullable
  public SimpleKwElse getKwElse() {
    return findChildByClass(SimpleKwElse.class);
  }

  @Override
  @Nullable
  public SimpleKwElseIf getKwElseIf() {
    return findChildByClass(SimpleKwElseIf.class);
  }

  @Override
  @Nullable
  public SimpleKwEndCase getKwEndCase() {
    return findChildByClass(SimpleKwEndCase.class);
  }

  @Override
  @Nullable
  public SimpleKwEndIf getKwEndIf() {
    return findChildByClass(SimpleKwEndIf.class);
  }

  @Override
  @Nullable
  public SimpleKwEndSection getKwEndSection() {
    return findChildByClass(SimpleKwEndSection.class);
  }

  @Override
  @Nullable
  public SimpleKwEndloop getKwEndloop() {
    return findChildByClass(SimpleKwEndloop.class);
  }

  @Override
  @Nullable
  public SimpleKwExit getKwExit() {
    return findChildByClass(SimpleKwExit.class);
  }

  @Override
  @Nullable
  public SimpleKwGlobal getKwGlobal() {
    return findChildByClass(SimpleKwGlobal.class);
  }

  @Override
  @Nullable
  public SimpleKwIf getKwIf() {
    return findChildByClass(SimpleKwIf.class);
  }

  @Override
  @Nullable
  public SimpleKwLocal getKwLocal() {
    return findChildByClass(SimpleKwLocal.class);
  }

  @Override
  @Nullable
  public SimpleKwLoop getKwLoop() {
    return findChildByClass(SimpleKwLoop.class);
  }

  @Override
  @Nullable
  public SimpleKwReturn getKwReturn() {
    return findChildByClass(SimpleKwReturn.class);
  }

  @Override
  @Nullable
  public SimpleKwSection getKwSection() {
    return findChildByClass(SimpleKwSection.class);
  }

  @Override
  @Nullable
  public SimpleKwStruct getKwStruct() {
    return findChildByClass(SimpleKwStruct.class);
  }

  @Override
  @Nullable
  public SimpleKwThen getKwThen() {
    return findChildByClass(SimpleKwThen.class);
  }

}
