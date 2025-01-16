// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SimpleFishExprValue extends PsiElement {

  @Nullable
  SimpleFishExprFuncCall getFishExprFuncCall();

  @Nullable
  SimpleFishExprParen getFishExprParen();

  @Nullable
  SimpleFishExprSquare getFishExprSquare();

  @Nullable
  SimpleFishExprUnary getFishExprUnary();

  @Nullable
  SimpleTkValue getTkValue();

}
