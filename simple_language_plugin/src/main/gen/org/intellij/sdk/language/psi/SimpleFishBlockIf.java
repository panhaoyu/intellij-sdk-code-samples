// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SimpleFishBlockIf extends PsiElement {

  @NotNull
  List<SimpleEol> getEolList();

  @Nullable
  SimpleFishBlockBodyElse getFishBlockBodyElse();

  @NotNull
  List<SimpleFishBlockBodyElseIf> getFishBlockBodyElseIfList();

  @Nullable
  SimpleFishBlockBodyIf getFishBlockBodyIf();

  @Nullable
  SimpleFishLineIfBlockElse getFishLineIfBlockElse();

  @NotNull
  List<SimpleFishLineIfBlockElseIf> getFishLineIfBlockElseIfList();

  @NotNull
  SimpleFishLineIfBlockFooter getFishLineIfBlockFooter();

  @NotNull
  SimpleFishLineIfBlockHeader getFishLineIfBlockHeader();

}
