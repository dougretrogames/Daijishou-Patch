package proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Timestamp;
import com.google.protobuf.TimestampOrBuilder;

/* INFO: loaded from: classes6.dex */
public interface LanguageOrBuilder extends MessageOrBuilder {
    String getChecksum();

    ByteString getChecksumBytes();

    Timestamp getCreatedAt();

    TimestampOrBuilder getCreatedAtOrBuilder();

    long getId();

    String getLocale();

    ByteString getLocaleBytes();

    String getName();

    ByteString getNameBytes();

    String getNativeName();

    ByteString getNativeNameBytes();

    Timestamp getUpdatedAt();

    TimestampOrBuilder getUpdatedAtOrBuilder();

    boolean hasCreatedAt();

    boolean hasUpdatedAt();
}
