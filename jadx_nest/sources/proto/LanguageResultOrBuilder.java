package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface LanguageResultOrBuilder extends MessageOrBuilder {
    Language getLanguages(int i);

    int getLanguagesCount();

    List<Language> getLanguagesList();

    LanguageOrBuilder getLanguagesOrBuilder(int i);

    List<? extends LanguageOrBuilder> getLanguagesOrBuilderList();
}
