// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SimpleFishLineIfBlockHeader extends PsiElement {

  @NotNull
  SimpleFishExpr getFishExpr();

  @NotNull
  SimpleKwIf getKwIf();

  @Nullable
  SimpleKwThen getKwThen();

  @Nullable
  SimpleTkComment getTkComment();

}
