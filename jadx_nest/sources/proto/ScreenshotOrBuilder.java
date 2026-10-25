package proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes6.dex */
public interface ScreenshotOrBuilder extends MessageOrBuilder {
    boolean getAlphaChannel();

    boolean getAnimated();

    String getChecksum();

    ByteString getChecksumBytes();

    Game getGame();

    GameOrBuilder getGameOrBuilder();

    int getHeight();

    long getId();

    String getImageId();

    ByteString getImageIdBytes();

    String getUrl();

    ByteString getUrlBytes();

    int getWidth();

    boolean hasGame();
}
