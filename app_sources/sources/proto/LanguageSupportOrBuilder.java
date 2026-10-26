package proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Timestamp;
import com.google.protobuf.TimestampOrBuilder;

/* INFO: loaded from: classes6.dex */
public interface LanguageSupportOrBuilder extends MessageOrBuilder {
    String getChecksum();

    ByteString getChecksumBytes();

    Timestamp getCreatedAt();

    TimestampOrBuilder getCreatedAtOrBuilder();

    Game getGame();

    GameOrBuilder getGameOrBuilder();

    long getId();

    Language getLanguage();

    LanguageOrBuilder getLanguageOrBuilder();

    LanguageSupportType getLanguageSupportType();

    LanguageSupportTypeOrBuilder getLanguageSupportTypeOrBuilder();

    Timestamp getUpdatedAt();

    TimestampOrBuilder getUpdatedAtOrBuilder();

    boolean hasCreatedAt();

    boolean hasGame();

    boolean hasLanguage();

    boolean hasLanguageSupportType();

    boolean hasUpdatedAt();
}
