// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SimpleFishExpr extends PsiElement {

  @NotNull
  List<SimpleFishExpr> getFishExprList();

  @NotNull
  List<SimpleFishExprFuncCall> getFishExprFuncCallList();

  @NotNull
  List<SimpleFishExprParen> getFishExprParenList();

  @NotNull
  List<SimpleTkValue> getTkValueList();

}
