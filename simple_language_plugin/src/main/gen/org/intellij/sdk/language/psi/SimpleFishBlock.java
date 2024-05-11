// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SimpleFishBlock extends PsiElement {

  @NotNull
  List<SimpleCaseBlock> getCaseBlockList();

  @NotNull
  List<SimpleCommandBlock> getCommandBlockList();

  @NotNull
  List<SimpleFishStatement> getFishStatementList();

  @NotNull
  List<SimpleIfBlock> getIfBlockList();

  @NotNull
  List<SimpleLoopBlock> getLoopBlockList();

}
