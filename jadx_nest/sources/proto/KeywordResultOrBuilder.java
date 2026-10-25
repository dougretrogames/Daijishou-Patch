package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface KeywordResultOrBuilder extends MessageOrBuilder {
    Keyword getKeywords(int i);

    int getKeywordsCount();

    List<Keyword> getKeywordsList();

    KeywordOrBuilder getKeywordsOrBuilder(int i);

    List<? extends KeywordOrBuilder> getKeywordsOrBuilderList();
}
