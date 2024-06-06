// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

public interface SimpleProperty extends SimpleNamedElement {

  @NotNull
  SimpleTkIdentifier getTkIdentifier();

  String getName();

  PsiElement setName(String newName);

  PsiElement getNameIdentifier();

  ItemPresentation getPresentation();

}
