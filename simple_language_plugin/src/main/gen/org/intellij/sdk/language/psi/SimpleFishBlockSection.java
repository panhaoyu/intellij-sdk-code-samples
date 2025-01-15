// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SimpleFishBlockSection extends PsiElement {

  @NotNull
  List<SimpleEol> getEolList();

  @Nullable
  SimpleFishBlockBodySection getFishBlockBodySection();

  @NotNull
  SimpleFishLineSectionFooter getFishLineSectionFooter();

  @NotNull
  SimpleFishLineSectionHeader getFishLineSectionHeader();

}
