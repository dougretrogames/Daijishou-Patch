package proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Timestamp;
import com.google.protobuf.TimestampOrBuilder;

/* JADX INFO: loaded from: classes6.dex */
public interface EventLogoOrBuilder extends MessageOrBuilder {
    boolean getAlphaChannel();

    boolean getAnimated();

    String getChecksum();

    ByteString getChecksumBytes();

    Timestamp getCreatedAt();

    TimestampOrBuilder getCreatedAtOrBuilder();

    Event getEvent();

    EventOrBuilder getEventOrBuilder();

    int getHeight();

    long getId();

    String getImageId();

    ByteString getImageIdBytes();

    Timestamp getUpdatedAt();

    TimestampOrBuilder getUpdatedAtOrBuilder();

    String getUrl();

    ByteString getUrlBytes();

    int getWidth();

    boolean hasCreatedAt();

    boolean hasEvent();

    boolean hasUpdatedAt();
}
