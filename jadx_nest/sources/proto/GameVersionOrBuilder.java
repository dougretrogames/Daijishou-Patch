package proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Timestamp;
import com.google.protobuf.TimestampOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface GameVersionOrBuilder extends MessageOrBuilder {
    String getChecksum();

    ByteString getChecksumBytes();

    Timestamp getCreatedAt();

    TimestampOrBuilder getCreatedAtOrBuilder();

    GameVersionFeature getFeatures(int i);

    int getFeaturesCount();

    List<GameVersionFeature> getFeaturesList();

    GameVersionFeatureOrBuilder getFeaturesOrBuilder(int i);

    List<? extends GameVersionFeatureOrBuilder> getFeaturesOrBuilderList();

    Game getGame();

    GameOrBuilder getGameOrBuilder();

    Game getGames(int i);

    int getGamesCount();

    List<Game> getGamesList();

    GameOrBuilder getGamesOrBuilder(int i);

    List<? extends GameOrBuilder> getGamesOrBuilderList();

    long getId();

    Timestamp getUpdatedAt();

    TimestampOrBuilder getUpdatedAtOrBuilder();

    String getUrl();

    ByteString getUrlBytes();

    boolean hasCreatedAt();

    boolean hasGame();

    boolean hasUpdatedAt();
}
