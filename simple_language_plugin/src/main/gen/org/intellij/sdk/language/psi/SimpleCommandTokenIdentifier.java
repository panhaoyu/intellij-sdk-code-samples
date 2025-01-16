// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SimpleCommandTokenIdentifier extends PsiElement {

  @NotNull
  List<SimpleCommandTokenIdentifierWithoutMinus> getCommandTokenIdentifierWithoutMinusList();

  @NotNull
  List<SimpleOpMinus> getOpMinusList();

  @NotNull
  List<SimpleTkNumberLiteral> getTkNumberLiteralList();

}
