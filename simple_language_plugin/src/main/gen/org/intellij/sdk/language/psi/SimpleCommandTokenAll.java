// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SimpleCommandTokenAll extends PsiElement {

  @Nullable
  SimpleCommandExprFuncCall getCommandExprFuncCall();

  @NotNull
  List<SimpleCommandTokenAll> getCommandTokenAllList();

  @Nullable
  SimpleCommandTokenIdentifier getCommandTokenIdentifier();

  @Nullable
  SimpleCommandTokenInlineFish getCommandTokenInlineFish();

  @Nullable
  SimpleCurlyL getCurlyL();

  @Nullable
  SimpleCurlyR getCurlyR();

  @Nullable
  SimpleOpAssign getOpAssign();

  @Nullable
  SimpleOpBinaryWithoutMinus getOpBinaryWithoutMinus();

  @NotNull
  List<SimpleOpComma> getOpCommaList();

  @Nullable
  SimpleOpDot getOpDot();

  @Nullable
  SimpleOpUnary getOpUnary();

  @Nullable
  SimpleParenL getParenL();

  @Nullable
  SimpleParenR getParenR();

  @Nullable
  SimpleSquareL getSquareL();

  @Nullable
  SimpleSquareR getSquareR();

  @Nullable
  SimpleTkLiteral getTkLiteral();

}
