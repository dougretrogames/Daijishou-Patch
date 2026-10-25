package proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes6.dex */
public interface AlternativeNameOrBuilder extends MessageOrBuilder {
    String getChecksum();

    ByteString getChecksumBytes();

    String getComment();

    ByteString getCommentBytes();

    Game getGame();

    GameOrBuilder getGameOrBuilder();

    long getId();

    String getName();

    ByteString getNameBytes();

    boolean hasGame();
}
