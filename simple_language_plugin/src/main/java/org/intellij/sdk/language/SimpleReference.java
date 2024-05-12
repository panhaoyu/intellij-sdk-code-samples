package org.intellij.sdk.language;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import org.intellij.sdk.language.psi.SimpleNamedElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

// ����SimpleReference�࣬����PsiReferenceBase�����࣬ʵ����PsiPolyVariantReference�ӿ�
final class SimpleReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {

    private static final Logger LOG = Logger.getInstance(SimpleReference.class); // ��־��¼��
    // ����һ���ַ�����Ա�������ڴ洢��ֵ
    private final String key;

    // ���캯������ʼ�����úͼ�ֵ
    SimpleReference(@NotNull PsiElement element, TextRange textRange) {
        super(element, textRange);  // ���ø��๹�캯��������Ԫ�غ��ı���Χ
        key = element.getText().substring(textRange.getStartOffset(), textRange.getEndOffset()); // ���ı���Χ��ȡ��ֵ
        LOG.error("SimpleReference initialized for key: " + key); // ��¼��־
    }

    // ��дmultiResolve���������ڽ���������ܵ����ý��
    @Override
    public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
        Project project = myElement.getProject(); // ��ȡ��ǰԪ�����ڵ���Ŀ
        final List<SimpleNamedElement> properties = SimpleUtil.findAllIdentifiers(project); // �������ֵ��ص������б�
        List<ResolveResult> results = new ArrayList<>(); // ������������б�
        for (SimpleNamedElement property : properties) { // �����ҵ�������
            if (property.getName() != null && property.getName().equals(key)) {
                results.add(new PsiElementResolveResult(property)); // �����Է�װΪ�����������ӵ��б���
                LOG.error("Matching identifier found: " + property.getName()); // ��¼ƥ����Ϣ
            }
        }
        LOG.error("Total identifiers resolved: " + results.size()); // ��¼����������
        return results.toArray(new ResolveResult[0]); // ���б�ת��Ϊ���鲢����
    }

    // ��дresolve���������ص�һ�Ľ������
    @Nullable
    @Override
    public PsiElement resolve() {
        ResolveResult[] resolveResults = multiResolve(false); // ��ȡ����������
        PsiElement result = resolveResults.length == 1 ? resolveResults[0].getElement() : null;
        LOG.error("Resolve result: " + (result != null ? result.getText() : "null")); // ��¼�������
        return result;
    }

    // ��дgetVariants���������ڻ�ȡ���п��ܵ��Զ���ȫѡ��
    @Override
    public Object @NotNull [] getVariants() {
        Project project = myElement.getProject(); // ��ȡ��ǰԪ�����ڵ���Ŀ
        List<SimpleNamedElement> properties = SimpleUtil.findAllIdentifiers(project); // ��ȡ��������
        List<LookupElement> variants = new ArrayList<>(); // �����Զ���ȫѡ���б�
        for (final SimpleNamedElement property : properties) { // ������������
            if (property.getName() != null && !property.getName().isEmpty()) { // ������Եļ���Ϊ��
                variants.add(LookupElementBuilder // �����Զ���ȫѡ��
                        .create(property).withIcon(SimpleIcons.FILE) // ����ͼ��
                        .withTypeText(property.getContainingFile().getName()) // ���������ı�Ϊ�ļ���
                );
            }
        }
        LOG.error("Autocomplete variants count: " + variants.size()); // ��¼�Զ���ȫ��ѡ����
        return variants.toArray(); // ���б�ת��Ϊ���鲢����
    }

}