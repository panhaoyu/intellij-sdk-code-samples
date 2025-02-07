// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SimpleFishBlockLoop extends PsiElement {

  @NotNull
  List<SimpleEol> getEolList();

  @Nullable
  SimpleFishBlockBodyLoop getFishBlockBodyLoop();

  @NotNull
  SimpleFishLineLoopBlockFooter getFishLineLoopBlockFooter();

  @NotNull
  SimpleFishLineLoopBlockHeader getFishLineLoopBlockHeader();

}
