package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface SearchResultOrBuilder extends MessageOrBuilder {
    Search getSearches(int i);

    int getSearchesCount();

    List<Search> getSearchesList();

    SearchOrBuilder getSearchesOrBuilder(int i);

    List<? extends SearchOrBuilder> getSearchesOrBuilderList();
}
