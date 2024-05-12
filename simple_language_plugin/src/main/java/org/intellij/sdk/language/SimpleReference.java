package org.intellij.sdk.language;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import org.intellij.sdk.language.psi.SimpleIdentifierElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// ����SimpleReference�࣬����PsiReferenceBase�����࣬ʵ����PsiPolyVariantReference�ӿ�
public final class SimpleReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {

    private static final Logger LOG = Logger.getInstance(SimpleReference.class); // ��־��¼��
    // ����һ���ַ�����Ա�������ڴ洢��ֵ
    private final String key;

    // ���캯������ʼ�����úͼ�ֵ
    public SimpleReference(@NotNull PsiElement element, TextRange textRange) {
        super(element, textRange);
        // ȷ���ı���Χ��Ч
        String elementText = element.getText();
        int startOffset = Math.min(textRange.getStartOffset(), elementText.length());
        int endOffset = Math.min(textRange.getEndOffset(), elementText.length());
        if (startOffset <= endOffset) {
            key = elementText.substring(startOffset, endOffset);
            LOG.info("SimpleReference initialized for key: " + key);
        } else {
            key = "";
            LOG.error("Invalid TextRange: startOffset " + startOffset + ", endOffset " + endOffset);
        }
    }

    // ��дmultiResolve���������ڽ���������ܵ����ý��
    @Override
    public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
        Project project = this.getElement().getProject();
        final List<SimpleIdentifierElement> properties = SimpleUtil.findAllIdentifiers(project); // �������ֵ��ص������б�
        List<ResolveResult> results = new ArrayList<>(); // ������������б�
        for (SimpleIdentifierElement identifier : properties) { // �����ҵ�������
            if (identifier.getName() != null && identifier.getName().equals(key)) {
                results.add(new PsiElementResolveResult(identifier)); // �����Է�װΪ�����������ӵ��б���
                LOG.error("Matching identifier found: " + identifier.getName()); // ��¼ƥ����Ϣ
            }
        }
        LOG.error("Total identifiers resolved: " + results.size()); // ��¼����������
        return results.toArray(new ResolveResult[0]); // ���б�ת��Ϊ���鲢����
    }

    // ��дresolve���������ص�һ�Ľ������
    @Nullable
    @Override
    public PsiElement resolve() {
        Project project = this.getElement().getProject();
        List<SimpleIdentifierElement> declarations = SimpleUtil.findDeclarations(project);
        for (SimpleIdentifierElement decl : declarations) {
            if (Objects.equals(decl.getName(), key)) {
                return decl;
            }
        }
        return null;
    }

    // ��дgetVariants���������ڻ�ȡ���п��ܵ��Զ���ȫѡ��
    @Override
    public Object @NotNull [] getVariants() {
        Project project = this.getElement().getProject();
        List<SimpleIdentifierElement> properties = SimpleUtil.findAllIdentifiers(project); // ��ȡ��������
        List<LookupElement> variants = new ArrayList<>(); // �����Զ���ȫѡ���б�
        for (final SimpleIdentifierElement identifier : properties) { // ������������
            if (identifier.getName() != null && !identifier.getName().isEmpty()) { // ������Եļ���Ϊ��
                variants.add(LookupElementBuilder // �����Զ���ȫѡ��
                        .create(identifier).withIcon(SimpleIcons.FILE) // ����ͼ��
                        .withTypeText(identifier.getContainingFile().getName()) // ���������ı�Ϊ�ļ���
                );
            }
        }
        LOG.error("Autocomplete variants count: " + variants.size()); // ��¼�Զ���ȫ��ѡ����
        return variants.toArray(); // ���б�ת��Ϊ���鲢����
    }

}