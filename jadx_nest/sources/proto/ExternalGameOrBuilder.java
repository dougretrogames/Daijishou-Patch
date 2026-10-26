package proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Timestamp;
import com.google.protobuf.TimestampOrBuilder;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public interface ExternalGameOrBuilder extends MessageOrBuilder {
    ExternalGameCategoryEnum getCategory();

    int getCategoryValue();

    String getChecksum();

    ByteString getChecksumBytes();

    int getCountries(int i);

    int getCountriesCount();

    List<Integer> getCountriesList();

    Timestamp getCreatedAt();

    TimestampOrBuilder getCreatedAtOrBuilder();

    Game getGame();

    GameOrBuilder getGameOrBuilder();

    long getId();

    ExternalGameMediaEnum getMedia();

    int getMediaValue();

    String getName();

    ByteString getNameBytes();

    Platform getPlatform();

    PlatformOrBuilder getPlatformOrBuilder();

    String getUid();

    ByteString getUidBytes();

    Timestamp getUpdatedAt();

    TimestampOrBuilder getUpdatedAtOrBuilder();

    String getUrl();

    ByteString getUrlBytes();

    int getYear();

    boolean hasCreatedAt();

    boolean hasGame();

    boolean hasPlatform();

    boolean hasUpdatedAt();
}
