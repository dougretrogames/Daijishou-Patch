package proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* INFO: loaded from: classes6.dex */
public interface PlatformVersionCompanyOrBuilder extends MessageOrBuilder {
    String getChecksum();

    ByteString getChecksumBytes();

    String getComment();

    ByteString getCommentBytes();

    Company getCompany();

    CompanyOrBuilder getCompanyOrBuilder();

    boolean getDeveloper();

    long getId();

    boolean getManufacturer();

    boolean hasCompany();
}
