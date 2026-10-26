package proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public interface AgeRatingOrBuilder extends MessageOrBuilder {
    AgeRatingCategoryEnum getCategory();

    int getCategoryValue();

    String getChecksum();

    ByteString getChecksumBytes();

    AgeRatingContentDescription getContentDescriptions(int i);

    int getContentDescriptionsCount();

    List<AgeRatingContentDescription> getContentDescriptionsList();

    AgeRatingContentDescriptionOrBuilder getContentDescriptionsOrBuilder(int i);

    List<? extends AgeRatingContentDescriptionOrBuilder> getContentDescriptionsOrBuilderList();

    long getId();

    AgeRatingRatingEnum getRating();

    String getRatingCoverUrl();

    ByteString getRatingCoverUrlBytes();

    int getRatingValue();

    String getSynopsis();

    ByteString getSynopsisBytes();
}
