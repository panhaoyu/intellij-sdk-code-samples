// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SimpleStatFish extends PsiElement {

  @Nullable
  SimpleStatAssign getStatAssign();

  @Nullable
  SimpleTkIdentifier getTkIdentifier();

  @NotNull
  List<SimpleTkValue> getTkValueList();

}
