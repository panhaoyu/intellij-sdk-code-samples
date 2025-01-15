// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.navigation.ItemPresentation;

public interface SimpleCommandBlockDefine extends PsiElement {

  @NotNull
  List<SimpleEol> getEolList();

  @Nullable
  SimpleFishBlockDefineBody getFishBlockDefineBody();

  @NotNull
  List<SimpleTkComment> getTkCommentList();

  @NotNull
  List<SimpleTkIdentifier> getTkIdentifierList();

  String getName();

  ItemPresentation getPresentation();

}
