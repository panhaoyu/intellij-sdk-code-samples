// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SimpleBlockLoop extends PsiElement {

  @NotNull
  SimpleBlockHeaderLoop getBlockHeaderLoop();

  @Nullable
  SimpleBodyLoop getBodyLoop();

  @NotNull
  List<SimpleEol> getEolList();

}
