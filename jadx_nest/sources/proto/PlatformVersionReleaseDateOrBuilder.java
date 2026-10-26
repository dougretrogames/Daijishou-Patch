package proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Timestamp;
import com.google.protobuf.TimestampOrBuilder;

/* INFO: loaded from: classes6.dex */
public interface PlatformVersionReleaseDateOrBuilder extends MessageOrBuilder {
    DateFormatChangeDateCategoryEnum getCategory();

    int getCategoryValue();

    String getChecksum();

    ByteString getChecksumBytes();

    Timestamp getCreatedAt();

    TimestampOrBuilder getCreatedAtOrBuilder();

    Timestamp getDate();

    TimestampOrBuilder getDateOrBuilder();

    String getHuman();

    ByteString getHumanBytes();

    long getId();

    int getM();

    PlatformVersion getPlatformVersion();

    PlatformVersionOrBuilder getPlatformVersionOrBuilder();

    RegionRegionEnum getRegion();

    int getRegionValue();

    Timestamp getUpdatedAt();

    TimestampOrBuilder getUpdatedAtOrBuilder();

    int getY();

    boolean hasCreatedAt();

    boolean hasDate();

    boolean hasPlatformVersion();

    boolean hasUpdatedAt();
}
