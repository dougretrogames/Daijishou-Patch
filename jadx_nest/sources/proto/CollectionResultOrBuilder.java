package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface CollectionResultOrBuilder extends MessageOrBuilder {
    Collection getCollections(int i);

    int getCollectionsCount();

    List<Collection> getCollectionsList();

    CollectionOrBuilder getCollectionsOrBuilder(int i);

    List<? extends CollectionOrBuilder> getCollectionsOrBuilderList();
}
