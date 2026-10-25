package proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Timestamp;
import com.google.protobuf.TimestampOrBuilder;

/* JADX INFO: loaded from: classes6.dex */
public interface RegionOrBuilder extends MessageOrBuilder {
    String getCategory();

    ByteString getCategoryBytes();

    String getChecksum();

    ByteString getChecksumBytes();

    Timestamp getCreatedAt();

    TimestampOrBuilder getCreatedAtOrBuilder();

    long getId();

    String getIdentifier();

    ByteString getIdentifierBytes();

    String getName();

    ByteString getNameBytes();

    Timestamp getUpdatedAt();

    TimestampOrBuilder getUpdatedAtOrBuilder();

    boolean hasCreatedAt();

    boolean hasUpdatedAt();
}
