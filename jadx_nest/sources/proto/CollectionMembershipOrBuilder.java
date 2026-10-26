package proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Timestamp;
import com.google.protobuf.TimestampOrBuilder;

/* INFO: loaded from: classes6.dex */
public interface CollectionMembershipOrBuilder extends MessageOrBuilder {
    String getChecksum();

    ByteString getChecksumBytes();

    Collection getCollection();

    CollectionOrBuilder getCollectionOrBuilder();

    Timestamp getCreatedAt();

    TimestampOrBuilder getCreatedAtOrBuilder();

    Game getGame();

    GameOrBuilder getGameOrBuilder();

    long getId();

    CollectionMembershipType getType();

    CollectionMembershipTypeOrBuilder getTypeOrBuilder();

    Timestamp getUpdatedAt();

    TimestampOrBuilder getUpdatedAtOrBuilder();

    boolean hasCollection();

    boolean hasCreatedAt();

    boolean hasGame();

    boolean hasType();

    boolean hasUpdatedAt();
}
