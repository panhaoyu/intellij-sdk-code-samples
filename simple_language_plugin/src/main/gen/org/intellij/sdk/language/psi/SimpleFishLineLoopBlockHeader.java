// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SimpleFishLineLoopBlockHeader extends PsiElement {

  @Nullable
  SimpleFishExprLoopIndexed getFishExprLoopIndexed();

  @NotNull
  SimpleKwLoop getKwLoop();

  @Nullable
  SimpleLoopEach getLoopEach();

  @Nullable
  SimpleLoopFor getLoopFor();

  @Nullable
  SimpleLoopWhile getLoopWhile();

  @Nullable
  SimpleTkComment getTkComment();

}
