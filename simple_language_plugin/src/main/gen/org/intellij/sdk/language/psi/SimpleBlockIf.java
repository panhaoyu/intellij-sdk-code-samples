// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SimpleBlockIf extends PsiElement {

  @Nullable
  SimpleBlockElse getBlockElse();

  @NotNull
  List<SimpleBlockElseIf> getBlockElseIfList();

  @Nullable
  SimpleBlockFish getBlockFish();

  @NotNull
  List<SimpleEol> getEolList();

  @NotNull
  List<SimpleTkIdentifier> getTkIdentifierList();

  @NotNull
  List<SimpleTkValue> getTkValueList();

}
