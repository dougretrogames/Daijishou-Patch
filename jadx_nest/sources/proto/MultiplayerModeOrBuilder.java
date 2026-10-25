package proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes6.dex */
public interface MultiplayerModeOrBuilder extends MessageOrBuilder {
    boolean getCampaigncoop();

    String getChecksum();

    ByteString getChecksumBytes();

    boolean getDropin();

    Game getGame();

    GameOrBuilder getGameOrBuilder();

    long getId();

    boolean getLancoop();

    boolean getOfflinecoop();

    int getOfflinecoopmax();

    int getOfflinemax();

    boolean getOnlinecoop();

    int getOnlinecoopmax();

    int getOnlinemax();

    Platform getPlatform();

    PlatformOrBuilder getPlatformOrBuilder();

    boolean getSplitscreen();

    boolean getSplitscreenonline();

    boolean hasGame();

    boolean hasPlatform();
}
