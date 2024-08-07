// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.navigation.ItemPresentation;

public interface SimpleBlockDefine extends PsiElement {

  @Nullable
  SimpleBlockFish getBlockFish();

  @NotNull
  List<SimpleEol> getEolList();

  @NotNull
  SimpleFishDefineHeader getFishDefineHeader();

  String getName();

  ItemPresentation getPresentation();

}
