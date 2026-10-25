package proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes6.dex */
public interface GameVersionFeatureValueOrBuilder extends MessageOrBuilder {
    String getChecksum();

    ByteString getChecksumBytes();

    Game getGame();

    GameVersionFeature getGameFeature();

    GameVersionFeatureOrBuilder getGameFeatureOrBuilder();

    GameOrBuilder getGameOrBuilder();

    long getId();

    GameVersionFeatureValueIncludedFeatureEnum getIncludedFeature();

    int getIncludedFeatureValue();

    String getNote();

    ByteString getNoteBytes();

    boolean hasGame();

    boolean hasGameFeature();
}
