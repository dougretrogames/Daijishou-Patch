package proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Timestamp;
import com.google.protobuf.TimestampOrBuilder;

/* INFO: loaded from: classes6.dex */
public interface GameLocalizationOrBuilder extends MessageOrBuilder {
    String getChecksum();

    ByteString getChecksumBytes();

    Cover getCover();

    CoverOrBuilder getCoverOrBuilder();

    Timestamp getCreatedAt();

    TimestampOrBuilder getCreatedAtOrBuilder();

    Game getGame();

    GameOrBuilder getGameOrBuilder();

    long getId();

    String getName();

    ByteString getNameBytes();

    Region getRegion();

    RegionOrBuilder getRegionOrBuilder();

    Timestamp getUpdatedAt();

    TimestampOrBuilder getUpdatedAtOrBuilder();

    boolean hasCover();

    boolean hasCreatedAt();

    boolean hasGame();

    boolean hasRegion();

    boolean hasUpdatedAt();
}
