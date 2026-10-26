package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public interface AlternativeNameResultOrBuilder extends MessageOrBuilder {
    AlternativeName getAlternativenames(int i);

    int getAlternativenamesCount();

    List<AlternativeName> getAlternativenamesList();

    AlternativeNameOrBuilder getAlternativenamesOrBuilder(int i);

    List<? extends AlternativeNameOrBuilder> getAlternativenamesOrBuilderList();
}
