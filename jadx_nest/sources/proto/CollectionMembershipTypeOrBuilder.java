package proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Timestamp;
import com.google.protobuf.TimestampOrBuilder;

/* JADX INFO: loaded from: classes6.dex */
public interface CollectionMembershipTypeOrBuilder extends MessageOrBuilder {
    CollectionType getAllowedCollectionType();

    CollectionTypeOrBuilder getAllowedCollectionTypeOrBuilder();

    String getChecksum();

    ByteString getChecksumBytes();

    Timestamp getCreatedAt();

    TimestampOrBuilder getCreatedAtOrBuilder();

    String getDescription();

    ByteString getDescriptionBytes();

    long getId();

    String getName();

    ByteString getNameBytes();

    Timestamp getUpdatedAt();

    TimestampOrBuilder getUpdatedAtOrBuilder();

    boolean hasAllowedCollectionType();

    boolean hasCreatedAt();

    boolean hasUpdatedAt();
}
