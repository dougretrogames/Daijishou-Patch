package proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Timestamp;
import com.google.protobuf.TimestampOrBuilder;

/* JADX INFO: loaded from: classes6.dex */
public interface CollectionRelationOrBuilder extends MessageOrBuilder {
    String getChecksum();

    ByteString getChecksumBytes();

    Collection getChildCollection();

    CollectionOrBuilder getChildCollectionOrBuilder();

    Timestamp getCreatedAt();

    TimestampOrBuilder getCreatedAtOrBuilder();

    long getId();

    Collection getParentCollection();

    CollectionOrBuilder getParentCollectionOrBuilder();

    CollectionRelationType getType();

    CollectionRelationTypeOrBuilder getTypeOrBuilder();

    Timestamp getUpdatedAt();

    TimestampOrBuilder getUpdatedAtOrBuilder();

    boolean hasChildCollection();

    boolean hasCreatedAt();

    boolean hasParentCollection();

    boolean hasType();

    boolean hasUpdatedAt();
}
