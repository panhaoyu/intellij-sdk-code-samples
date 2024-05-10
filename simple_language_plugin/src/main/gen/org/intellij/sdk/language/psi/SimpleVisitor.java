// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class SimpleVisitor extends PsiElementVisitor {

  public void visitFunctionDefine(@NotNull SimpleFunctionDefine o) {
    visitPsiElement(o);
  }

  public void visitFunctionDefineHeader(@NotNull SimpleFunctionDefineHeader o) {
    visitPsiElement(o);
  }

  public void visitLiteral(@NotNull SimpleLiteral o) {
    visitPsiElement(o);
  }

  public void visitProperty(@NotNull SimpleProperty o) {
    visitNamedElement(o);
  }

  public void visitSingleStatement(@NotNull SimpleSingleStatement o) {
    visitPsiElement(o);
  }

  public void visitStatementBlock(@NotNull SimpleStatementBlock o) {
    visitPsiElement(o);
  }

  public void visitValue(@NotNull SimpleValue o) {
    visitPsiElement(o);
  }

  public void visitNamedElement(@NotNull SimpleNamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
