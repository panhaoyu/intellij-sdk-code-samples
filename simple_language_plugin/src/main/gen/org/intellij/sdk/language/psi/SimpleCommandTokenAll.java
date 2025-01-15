// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SimpleCommandTokenAll extends PsiElement {

  @Nullable
  SimpleCommandExprFuncCall getCommandExprFuncCall();

  @Nullable
  SimpleCommandTokenConnectedWithMinus getCommandTokenConnectedWithMinus();

  @Nullable
  SimpleCommandTokenInlineFish getCommandTokenInlineFish();

  @Nullable
  SimpleCommandTokenKeywordAll getCommandTokenKeywordAll();

  @Nullable
  SimpleOpAssign getOpAssign();

  @Nullable
  SimpleOpAt getOpAt();

  @Nullable
  SimpleOpBinary getOpBinary();

  @Nullable
  SimpleOpComma getOpComma();

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

  @Nullable
  SimpleTkValue getTkValue();

}
