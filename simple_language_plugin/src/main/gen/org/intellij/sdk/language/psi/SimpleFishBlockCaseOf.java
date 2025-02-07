// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SimpleFishBlockCaseOf extends PsiElement {

  @NotNull
  List<SimpleEol> getEolList();

  @NotNull
  List<SimpleFishBlockBodyCaseOf> getFishBlockBodyCaseOfList();

  @NotNull
  SimpleFishLineCaseOfBlockFooter getFishLineCaseOfBlockFooter();

  @NotNull
  SimpleFishLineCaseOfBlockHeader getFishLineCaseOfBlockHeader();

  @NotNull
  List<SimpleFishLineCaseOfBlockOption> getFishLineCaseOfBlockOptionList();

}
