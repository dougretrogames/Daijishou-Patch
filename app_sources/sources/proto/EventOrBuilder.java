package proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Timestamp;
import com.google.protobuf.TimestampOrBuilder;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public interface EventOrBuilder extends MessageOrBuilder {
    String getChecksum();

    ByteString getChecksumBytes();

    Timestamp getCreatedAt();

    TimestampOrBuilder getCreatedAtOrBuilder();

    String getDescription();

    ByteString getDescriptionBytes();

    Timestamp getEndTime();

    TimestampOrBuilder getEndTimeOrBuilder();

    EventLogo getEventLogo();

    EventLogoOrBuilder getEventLogoOrBuilder();

    EventNetwork getEventNetworks(int i);

    int getEventNetworksCount();

    List<EventNetwork> getEventNetworksList();

    EventNetworkOrBuilder getEventNetworksOrBuilder(int i);

    List<? extends EventNetworkOrBuilder> getEventNetworksOrBuilderList();

    Game getGames(int i);

    int getGamesCount();

    List<Game> getGamesList();

    GameOrBuilder getGamesOrBuilder(int i);

    List<? extends GameOrBuilder> getGamesOrBuilderList();

    long getId();

    String getLiveStreamUrl();

    ByteString getLiveStreamUrlBytes();

    String getName();

    ByteString getNameBytes();

    String getSlug();

    ByteString getSlugBytes();

    Timestamp getStartTime();

    TimestampOrBuilder getStartTimeOrBuilder();

    String getTimeZone();

    ByteString getTimeZoneBytes();

    Timestamp getUpdatedAt();

    TimestampOrBuilder getUpdatedAtOrBuilder();

    GameVideo getVideos(int i);

    int getVideosCount();

    List<GameVideo> getVideosList();

    GameVideoOrBuilder getVideosOrBuilder(int i);

    List<? extends GameVideoOrBuilder> getVideosOrBuilderList();

    boolean hasCreatedAt();

    boolean hasEndTime();

    boolean hasEventLogo();

    boolean hasStartTime();

    boolean hasUpdatedAt();
}
