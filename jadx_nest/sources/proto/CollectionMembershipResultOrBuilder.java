package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface CollectionMembershipResultOrBuilder extends MessageOrBuilder {
    CollectionMembership getCollectionmemberships(int i);

    int getCollectionmembershipsCount();

    List<CollectionMembership> getCollectionmembershipsList();

    CollectionMembershipOrBuilder getCollectionmembershipsOrBuilder(int i);

    List<? extends CollectionMembershipOrBuilder> getCollectionmembershipsOrBuilderList();
}
