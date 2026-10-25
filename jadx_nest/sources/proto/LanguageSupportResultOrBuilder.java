package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface LanguageSupportResultOrBuilder extends MessageOrBuilder {
    LanguageSupport getLanguagesupports(int i);

    int getLanguagesupportsCount();

    List<LanguageSupport> getLanguagesupportsList();

    LanguageSupportOrBuilder getLanguagesupportsOrBuilder(int i);

    List<? extends LanguageSupportOrBuilder> getLanguagesupportsOrBuilderList();
}
