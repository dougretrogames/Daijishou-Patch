package proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Timestamp;
import com.google.protobuf.TimestampOrBuilder;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public interface PlatformOrBuilder extends MessageOrBuilder {
    String getAbbreviation();

    ByteString getAbbreviationBytes();

    String getAlternativeName();

    ByteString getAlternativeNameBytes();

    PlatformCategoryEnum getCategory();

    int getCategoryValue();

    String getChecksum();

    ByteString getChecksumBytes();

    Timestamp getCreatedAt();

    TimestampOrBuilder getCreatedAtOrBuilder();

    int getGeneration();

    long getId();

    String getName();

    ByteString getNameBytes();

    PlatformFamily getPlatformFamily();

    PlatformFamilyOrBuilder getPlatformFamilyOrBuilder();

    PlatformLogo getPlatformLogo();

    PlatformLogoOrBuilder getPlatformLogoOrBuilder();

    String getSlug();

    ByteString getSlugBytes();

    String getSummary();

    ByteString getSummaryBytes();

    Timestamp getUpdatedAt();

    TimestampOrBuilder getUpdatedAtOrBuilder();

    String getUrl();

    ByteString getUrlBytes();

    PlatformVersion getVersions(int i);

    int getVersionsCount();

    List<PlatformVersion> getVersionsList();

    PlatformVersionOrBuilder getVersionsOrBuilder(int i);

    List<? extends PlatformVersionOrBuilder> getVersionsOrBuilderList();

    PlatformWebsite getWebsites(int i);

    int getWebsitesCount();

    List<PlatformWebsite> getWebsitesList();

    PlatformWebsiteOrBuilder getWebsitesOrBuilder(int i);

    List<? extends PlatformWebsiteOrBuilder> getWebsitesOrBuilderList();

    boolean hasCreatedAt();

    boolean hasPlatformFamily();

    boolean hasPlatformLogo();

    boolean hasUpdatedAt();
}
