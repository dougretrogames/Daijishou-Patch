package proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes6.dex */
public interface AgeRatingContentDescriptionOrBuilder extends MessageOrBuilder {
    AgeRatingContentDescriptionCategoryEnum getCategory();

    int getCategoryValue();

    String getChecksum();

    ByteString getChecksumBytes();

    String getDescription();

    ByteString getDescriptionBytes();

    long getId();
}
