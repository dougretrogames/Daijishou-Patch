package proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Timestamp;
import com.google.protobuf.TimestampOrBuilder;

/* JADX INFO: loaded from: classes6.dex */
public interface InvolvedCompanyOrBuilder extends MessageOrBuilder {
    String getChecksum();

    ByteString getChecksumBytes();

    Company getCompany();

    CompanyOrBuilder getCompanyOrBuilder();

    Timestamp getCreatedAt();

    TimestampOrBuilder getCreatedAtOrBuilder();

    boolean getDeveloper();

    Game getGame();

    GameOrBuilder getGameOrBuilder();

    long getId();

    boolean getPorting();

    boolean getPublisher();

    boolean getSupporting();

    Timestamp getUpdatedAt();

    TimestampOrBuilder getUpdatedAtOrBuilder();

    boolean hasCompany();

    boolean hasCreatedAt();

    boolean hasGame();

    boolean hasUpdatedAt();
}
