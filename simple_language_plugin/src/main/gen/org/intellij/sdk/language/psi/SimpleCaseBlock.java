// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SimpleCaseBlock extends PsiElement {

  @NotNull
  List<SimpleEndOfLine> getEndOfLineList();

  @NotNull
  List<SimpleFishBlock> getFishBlockList();

  @NotNull
  List<SimpleIdentifierElement> getIdentifierElementList();

  @NotNull
  List<SimpleValue> getValueList();

}
