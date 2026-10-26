package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public interface CollectionRelationResultOrBuilder extends MessageOrBuilder {
    CollectionRelation getCollectionrelations(int i);

    int getCollectionrelationsCount();

    List<CollectionRelation> getCollectionrelationsList();

    CollectionRelationOrBuilder getCollectionrelationsOrBuilder(int i);

    List<? extends CollectionRelationOrBuilder> getCollectionrelationsOrBuilderList();
}
