package proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes6.dex */
public interface GameVideoOrBuilder extends MessageOrBuilder {
    String getChecksum();

    ByteString getChecksumBytes();

    Game getGame();

    GameOrBuilder getGameOrBuilder();

    long getId();

    String getName();

    ByteString getNameBytes();

    String getVideoId();

    ByteString getVideoIdBytes();

    boolean hasGame();
}
