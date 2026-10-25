package proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Timestamp;
import com.google.protobuf.TimestampOrBuilder;

/* JADX INFO: loaded from: classes6.dex */
public interface PopularityPrimitiveOrBuilder extends MessageOrBuilder {
    Timestamp getCalculatedAt();

    TimestampOrBuilder getCalculatedAtOrBuilder();

    String getChecksum();

    ByteString getChecksumBytes();

    Timestamp getCreatedAt();

    TimestampOrBuilder getCreatedAtOrBuilder();

    int getGameId();

    long getId();

    PopularitySourcePopularitySourceEnum getPopularitySource();

    int getPopularitySourceValue();

    PopularityType getPopularityType();

    PopularityTypeOrBuilder getPopularityTypeOrBuilder();

    Timestamp getUpdatedAt();

    TimestampOrBuilder getUpdatedAtOrBuilder();

    double getValue();

    boolean hasCalculatedAt();

    boolean hasCreatedAt();

    boolean hasPopularityType();

    boolean hasUpdatedAt();
}
