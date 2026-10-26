package proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Timestamp;
import com.google.protobuf.TimestampOrBuilder;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public interface CompanyOrBuilder extends MessageOrBuilder {
    Timestamp getChangeDate();

    DateFormatChangeDateCategoryEnum getChangeDateCategory();

    int getChangeDateCategoryValue();

    TimestampOrBuilder getChangeDateOrBuilder();

    Company getChangedCompanyId();

    CompanyOrBuilder getChangedCompanyIdOrBuilder();

    String getChecksum();

    ByteString getChecksumBytes();

    int getCountry();

    Timestamp getCreatedAt();

    TimestampOrBuilder getCreatedAtOrBuilder();

    String getDescription();

    ByteString getDescriptionBytes();

    Game getDeveloped(int i);

    int getDevelopedCount();

    List<Game> getDevelopedList();

    GameOrBuilder getDevelopedOrBuilder(int i);

    List<? extends GameOrBuilder> getDevelopedOrBuilderList();

    long getId();

    CompanyLogo getLogo();

    CompanyLogoOrBuilder getLogoOrBuilder();

    String getName();

    ByteString getNameBytes();

    Company getParent();

    CompanyOrBuilder getParentOrBuilder();

    Game getPublished(int i);

    int getPublishedCount();

    List<Game> getPublishedList();

    GameOrBuilder getPublishedOrBuilder(int i);

    List<? extends GameOrBuilder> getPublishedOrBuilderList();

    String getSlug();

    ByteString getSlugBytes();

    Timestamp getStartDate();

    DateFormatChangeDateCategoryEnum getStartDateCategory();

    int getStartDateCategoryValue();

    TimestampOrBuilder getStartDateOrBuilder();

    Timestamp getUpdatedAt();

    TimestampOrBuilder getUpdatedAtOrBuilder();

    String getUrl();

    ByteString getUrlBytes();

    CompanyWebsite getWebsites(int i);

    int getWebsitesCount();

    List<CompanyWebsite> getWebsitesList();

    CompanyWebsiteOrBuilder getWebsitesOrBuilder(int i);

    List<? extends CompanyWebsiteOrBuilder> getWebsitesOrBuilderList();

    boolean hasChangeDate();

    boolean hasChangedCompanyId();

    boolean hasCreatedAt();

    boolean hasLogo();

    boolean hasParent();

    boolean hasStartDate();

    boolean hasUpdatedAt();
}
