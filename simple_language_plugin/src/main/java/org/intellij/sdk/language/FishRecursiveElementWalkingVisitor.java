package org.intellij.sdk.language;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiRecursiveVisitor;
import com.intellij.psi.PsiWalkingState;
import org.intellij.sdk.language.psi.SimpleVisitor;
import org.jetbrains.annotations.NotNull;

public class FishRecursiveElementWalkingVisitor extends SimpleVisitor implements PsiRecursiveVisitor {
    private final PsiWalkingState myWalkingState = new PsiWalkingState(this) {
        @Override
        public void elementFinished(@NotNull PsiElement element) {
            FishRecursiveElementWalkingVisitor.this.elementFinished(element);
        }
    };

    @Override
    public void visitElement(@NotNull PsiElement element) {
        myWalkingState.elementStarted(element);
    }

    protected void elementFinished(@NotNull PsiElement element) {
    }

    public void stopWalking() {
        myWalkingState.stopWalking();
    }
}
