// Copyright 2000-2024 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package org.intellij.sdk.language;

import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.psi.codeStyle.CodeStyleManager;
import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase;

import java.util.List;

public class SimpleCodeInsightTest extends LightJavaCodeInsightFixtureTestCase {

    /**
     * @return path to test data file directory relative to working directory in the run configuration for this test.
     */
    @Override
    protected String getTestDataPath() {
        return "src/test/testData";
    }
//
//    public void testCompletion() {
//        myFixture.configureByFiles("CompleteTestData.java", "DefaultTestData.fis");
//        myFixture.complete(CompletionType.BASIC);
//        List<String> lookupElementStrings = myFixture.getLookupElementStrings();
//        assertNotNull(lookupElementStrings);
//        assertSameElements(lookupElementStrings, "key with spaces", "language", "message", "tab", "website");
//    }
//
//    public void testAnnotator() {
//        myFixture.configureByFiles("AnnotatorTestData.java", "DefaultTestData.fis");
//        myFixture.checkHighlighting(false, false, true, true);
//    }


    private void 校验一组文件(String name) {
        myFixture.configureByFile(String.format("缩进调整/%s/输入.fis", name));
//        CodeStyle.getLanguageSettings(myFixture.getFile()).SPACE_AROUND_ASSIGNMENT_OPERATORS = true;
//        CodeStyle.getLanguageSettings(myFixture.getFile()).KEEP_BLANK_LINES_IN_CODE = 2;
        WriteCommandAction.writeCommandAction(getProject()).run(() ->
                CodeStyleManager.getInstance(getProject()).reformatText(
                        myFixture.getFile(),
                        List.of(myFixture.getFile().getTextRange())
                )
        );
        myFixture.checkResultByFile(String.format("缩进调整/%s/输出.fis", name));
    }

    public void test_全文格式化() {
        校验一组文件("全文格式化");
    }

    public void test_函数缩进调整() {
        校验一组文件("函数缩进调整");
    }

    public void test_函数及注释缩进调整() {
        校验一组文件("函数及注释缩进调整");
    }

    public void test_条件分支() {
        校验一组文件("条件分支");
    }

    public void test_两个函数及注释() {
        校验一组文件("两个函数及注释");
    }

//    public void testRename() {
//        myFixture.configureByFiles("RenameTestData.java", "RenameTestData.fis");
//        myFixture.renameElementAtCaret("websiteUrl");
//        myFixture.checkResultByFile("RenameTestData.fis", "RenameTestDataAfter.fis", false);
//    }
//
//    public void testFolding() {
//        myFixture.configureByFile("DefaultTestData.fis");
//        myFixture.testFolding(getTestDataPath() + "/FoldingTestData.java");
//    }
//
//    public void testFindUsages() {
//        Collection<UsageInfo> usageInfos = myFixture.testFindUsages("FindUsagesTestData.fis", "FindUsagesTestData.java");
//        assertEquals(1, usageInfos.size());
//    }
//
//    public void testCommenter() {
//        myFixture.configureByText(SimpleFileType.INSTANCE, "<caret>website = https://en.wikipedia.org/");
//        CommentByLineCommentAction commentAction = new CommentByLineCommentAction();
//        commentAction.actionPerformedImpl(getProject(), myFixture.getEditor());
//        myFixture.checkResult("#website = https://en.wikipedia.org/");
//        commentAction.actionPerformedImpl(getProject(), myFixture.getEditor());
//        myFixture.checkResult("website = https://en.wikipedia.org/");
//    }

//  public void testReference() {
//    PsiReference referenceAtCaret =
//        myFixture.getReferenceAtCaretPositionWithAssertion("ReferenceTestData.java", "DefaultTestData.fis");
//    final SimpleProperty resolvedSimpleProperty = assertInstanceOf(referenceAtCaret.resolve(), SimpleProperty.class);
//    assertEquals("https://en.wikipedia.org/", resolvedSimpleProperty.getName());
//  }

//  public void testDocumentation() {
//    myFixture.configureByFiles("DocumentationTestData.java", "DocumentationTestData.fis");
//    final PsiElement originalElement = myFixture.getElementAtCaret();
//    PsiElement element = DocumentationManager
//        .getInstance(getProject())
//        .findTargetElement(myFixture.getEditor(), originalElement.getContainingFile(), originalElement);
//
//    if (element == null) {
//      element = originalElement;
//    }
//
//    final DocumentationProvider documentationProvider = DocumentationManager.getProviderFromElement(element);
//    final String generateDoc = documentationProvider.generateDoc(element, originalElement);
//    assertNotNull(generateDoc);
//    assertSameLinesWithFile(getTestDataPath() + "/" + "DocumentationTest.html.expected", generateDoc);
//  }

}
