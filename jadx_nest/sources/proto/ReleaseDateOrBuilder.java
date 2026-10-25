package proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Timestamp;
import com.google.protobuf.TimestampOrBuilder;

/* JADX INFO: loaded from: classes6.dex */
public interface ReleaseDateOrBuilder extends MessageOrBuilder {
    DateFormatChangeDateCategoryEnum getCategory();

    int getCategoryValue();

    String getChecksum();

    ByteString getChecksumBytes();

    Timestamp getCreatedAt();

    TimestampOrBuilder getCreatedAtOrBuilder();

    Timestamp getDate();

    TimestampOrBuilder getDateOrBuilder();

    Game getGame();

    GameOrBuilder getGameOrBuilder();

    String getHuman();

    ByteString getHumanBytes();

    long getId();

    int getM();

    Platform getPlatform();

    PlatformOrBuilder getPlatformOrBuilder();

    RegionRegionEnum getRegion();

    int getRegionValue();

    ReleaseDateStatus getStatus();

    ReleaseDateStatusOrBuilder getStatusOrBuilder();

    Timestamp getUpdatedAt();

    TimestampOrBuilder getUpdatedAtOrBuilder();

    int getY();

    boolean hasCreatedAt();

    boolean hasDate();

    boolean hasGame();

    boolean hasPlatform();

    boolean hasStatus();

    boolean hasUpdatedAt();
}
