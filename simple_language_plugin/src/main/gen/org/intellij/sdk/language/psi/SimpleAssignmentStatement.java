// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SimpleAssignmentStatement extends PsiElement {

  @NotNull
  List<SimpleIdentifier> getIdentifierList();

  @NotNull
  List<SimpleValue> getValueList();

}
