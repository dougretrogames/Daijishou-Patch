package proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* INFO: loaded from: classes6.dex */
public interface WebsiteOrBuilder extends MessageOrBuilder {
    WebsiteCategoryEnum getCategory();

    int getCategoryValue();

    String getChecksum();

    ByteString getChecksumBytes();

    Game getGame();

    GameOrBuilder getGameOrBuilder();

    long getId();

    boolean getTrusted();

    String getUrl();

    ByteString getUrlBytes();

    boolean hasGame();
}
