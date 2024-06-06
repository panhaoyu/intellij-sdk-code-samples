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
import org.intellij.sdk.language.psi.SimpleTkIdentifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

// ����SimpleReference�࣬����PsiReferenceBase�����࣬ʵ����PsiPolyVariantReference�ӿ�
public final class SimpleReference extends PsiReferenceBase<SimpleTkIdentifier> implements PsiPolyVariantReference {

    private static final Logger LOG = Logger.getInstance(SimpleReference.class); // ��־��¼��
    // ����һ���ַ�����Ա�������ڴ洢��ֵ


    // ���캯������ʼ�����úͼ�ֵ
    public SimpleReference(@NotNull SimpleTkIdentifier element, TextRange textRange) {
        super(element, textRange);
    }

    // ��дmultiResolve���������ڽ���������ܵ����ý��
    @Override
    public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
        Project project = myElement.getProject();
        String name = myElement.getName();
        if (name == null) {
            return ResolveResult.EMPTY_ARRAY;
        }
        final List<SimpleTkIdentifier> identifiers = SimpleUtil.findIdentifiers(project, name); // �������ֵ��ص������б�
        List<ResolveResult> results = new ArrayList<>(); // ������������б�
        for (SimpleTkIdentifier identifier : identifiers) { // �����ҵ�������
            results.add(new PsiElementResolveResult(identifier)); // �����Է�װΪ�����������ӵ��б���
        }
        LOG.debug("Total identifiers resolved: " + results.size());
        return results.toArray(ResolveResult[]::new); // ���б�ת��Ϊ���鲢����
    }

    @Nullable
    @Override
    public SimpleTkIdentifier resolve() {
        ResolveResult[] resolveResults = multiResolve(false);
        return resolveResults.length == 1 ? (SimpleTkIdentifier) resolveResults[0].getElement() : null;
    }


    // ��дgetVariants���������ڻ�ȡ���п��ܵ��Զ���ȫѡ��
    @Override
    public Object @NotNull [] getVariants() {
        Project project = myElement.getProject();
        List<SimpleTkIdentifier> identifiers = SimpleUtil.findIdentifiers(project); // ��ȡ��������
        List<LookupElement> variants = new ArrayList<>(); // �����Զ���ȫѡ���б�
        for (final SimpleTkIdentifier identifier : identifiers) { // ������������
            String name = identifier.getName();
            if (name != null && !name.isEmpty()) { // ������Եļ���Ϊ��
                variants.add(LookupElementBuilder // �����Զ���ȫѡ��
                        .create(identifier).withIcon(SimpleIcons.FILE) // ����ͼ��
                        .withTypeText(identifier.getContainingFile().getName()) // ���������ı�Ϊ�ļ���
                );
            }
        }
        LOG.debug("Autocomplete variants count: " + variants.size());
        return variants.toArray(); // ���б�ת��Ϊ���鲢����
    }

}