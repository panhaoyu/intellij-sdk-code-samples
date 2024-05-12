// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SimpleFishStatement extends PsiElement {

  @Nullable
  SimpleAssignmentStatement getAssignmentStatement();

  @Nullable
  SimpleIdentifierElement getIdentifierElement();

  @NotNull
  List<SimpleValue> getValueList();

}
