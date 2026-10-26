package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public interface CollectionTypeResultOrBuilder extends MessageOrBuilder {
    CollectionType getCollectiontypes(int i);

    int getCollectiontypesCount();

    List<CollectionType> getCollectiontypesList();

    CollectionTypeOrBuilder getCollectiontypesOrBuilder(int i);

    List<? extends CollectionTypeOrBuilder> getCollectiontypesOrBuilderList();
}
