package proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes6.dex */
public interface CoverOrBuilder extends MessageOrBuilder {
    boolean getAlphaChannel();

    boolean getAnimated();

    String getChecksum();

    ByteString getChecksumBytes();

    Game getGame();

    GameLocalization getGameLocalization();

    GameLocalizationOrBuilder getGameLocalizationOrBuilder();

    GameOrBuilder getGameOrBuilder();

    int getHeight();

    long getId();

    String getImageId();

    ByteString getImageIdBytes();

    String getUrl();

    ByteString getUrlBytes();

    int getWidth();

    boolean hasGame();

    boolean hasGameLocalization();
}
