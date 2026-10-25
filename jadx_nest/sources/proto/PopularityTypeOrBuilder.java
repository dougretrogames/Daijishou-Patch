package proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Timestamp;
import com.google.protobuf.TimestampOrBuilder;

/* JADX INFO: loaded from: classes6.dex */
public interface PopularityTypeOrBuilder extends MessageOrBuilder {
    String getChecksum();

    ByteString getChecksumBytes();

    Timestamp getCreatedAt();

    TimestampOrBuilder getCreatedAtOrBuilder();

    long getId();

    String getName();

    ByteString getNameBytes();

    PopularitySourcePopularitySourceEnum getPopularitySource();

    int getPopularitySourceValue();

    Timestamp getUpdatedAt();

    TimestampOrBuilder getUpdatedAtOrBuilder();

    boolean hasCreatedAt();

    boolean hasUpdatedAt();
}
