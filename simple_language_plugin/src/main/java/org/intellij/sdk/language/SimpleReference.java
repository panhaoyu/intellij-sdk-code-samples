package org.intellij.sdk.language;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElementResolveResult;
import com.intellij.psi.PsiPolyVariantReference;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.ResolveResult;
import org.intellij.sdk.language.psi.SimpleIdentifierElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

// ����SimpleReference�࣬����PsiReferenceBase�����࣬ʵ����PsiPolyVariantReference�ӿ�
public final class SimpleReference extends PsiReferenceBase<SimpleIdentifierElement> implements PsiPolyVariantReference {

    private static final Logger LOG = Logger.getInstance(SimpleReference.class); // ��־��¼��
    // ����һ���ַ�����Ա�������ڴ洢��ֵ

    private final String key;


    // ���캯������ʼ�����úͼ�ֵ
    public SimpleReference(@NotNull SimpleIdentifierElement element, TextRange textRange) {
        super(element, textRange);
        key = element.getText();
    }

    // ��дmultiResolve���������ڽ���������ܵ����ý��
    @Override
    public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
        Project project = myElement.getProject();
        final List<SimpleIdentifierElement> identifiers = SimpleUtil.findIdentifiers(project, myElement.getName()); // �������ֵ��ص������б�
        List<ResolveResult> results = new ArrayList<>(); // ������������б�
        for (SimpleIdentifierElement identifier : identifiers) { // �����ҵ�������
            results.add(new PsiElementResolveResult(identifier)); // �����Է�װΪ�����������ӵ��б���
        }
        LOG.info("Total identifiers resolved: " + results.size()); // ��¼����������
        return results.toArray(new ResolveResult[0]); // ���б�ת��Ϊ���鲢����
    }

    @Nullable
    @Override
    public SimpleIdentifierElement resolve() {
        ResolveResult[] resolveResults = multiResolve(false);
        return resolveResults.length == 1 ? (SimpleIdentifierElement) resolveResults[0].getElement() : null;
    }


    // ��дgetVariants���������ڻ�ȡ���п��ܵ��Զ���ȫѡ��
    @Override
    public Object @NotNull [] getVariants() {
        Project project = myElement.getProject();
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
        LOG.info("Autocomplete variants count: " + variants.size()); // ��¼�Զ���ȫ��ѡ����
        return variants.toArray(); // ���б�ת��Ϊ���鲢����
    }

}