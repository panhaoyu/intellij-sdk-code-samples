// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SimpleFishExprDefineParams extends PsiElement {

  @NotNull
  List<SimpleOpComma> getOpCommaList();

  @NotNull
  SimpleParenL getParenL();

  @NotNull
  SimpleParenR getParenR();

  @NotNull
  List<SimpleTkIdentifier> getTkIdentifierList();

}
