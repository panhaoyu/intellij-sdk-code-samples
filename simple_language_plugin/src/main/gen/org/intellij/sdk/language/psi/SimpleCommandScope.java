// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SimpleCommandScope extends PsiElement {

  @Nullable
  SimpleCommandScopeFunctionCallStatement getCommandScopeFunctionCallStatement();

  @Nullable
  SimpleCommandScopeInlineFishStatement getCommandScopeInlineFishStatement();

  @Nullable
  SimpleCommandStatement getCommandStatement();

  @Nullable
  SimpleFunctionDefineBlock getFunctionDefineBlock();

}
