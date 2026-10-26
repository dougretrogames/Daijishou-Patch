package proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* INFO: loaded from: classes6.dex */
public interface PlatformFamilyOrBuilder extends MessageOrBuilder {
    String getChecksum();

    ByteString getChecksumBytes();

    long getId();

    String getName();

    ByteString getNameBytes();

    String getSlug();

    ByteString getSlugBytes();
}
