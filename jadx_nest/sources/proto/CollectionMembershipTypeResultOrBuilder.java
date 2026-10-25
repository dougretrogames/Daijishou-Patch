package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface CollectionMembershipTypeResultOrBuilder extends MessageOrBuilder {
    CollectionMembershipType getCollectionmembershiptypes(int i);

    int getCollectionmembershiptypesCount();

    List<CollectionMembershipType> getCollectionmembershiptypesList();

    CollectionMembershipTypeOrBuilder getCollectionmembershiptypesOrBuilder(int i);

    List<? extends CollectionMembershipTypeOrBuilder> getCollectionmembershiptypesOrBuilderList();
}
