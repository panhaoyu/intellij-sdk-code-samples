// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SimpleBlockElseIf extends PsiElement {

  @Nullable
  SimpleBlockFish getBlockFish();

  @Nullable
  SimpleEol getEol();

  @NotNull
  List<SimpleTkIdentifier> getTkIdentifierList();

  @NotNull
  List<SimpleTkValue> getTkValueList();

}
