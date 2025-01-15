// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SimpleFishLineDefineHeader extends PsiElement {

  @Nullable
  SimpleFishExprDefineParams getFishExprDefineParams();

  @Nullable
  SimpleKwFishDefine getKwFishDefine();

  @Nullable
  SimpleKwFishOperator getKwFishOperator();

  @Nullable
  SimpleTkComment getTkComment();

  @NotNull
  SimpleTkIdentifier getTkIdentifier();

}
