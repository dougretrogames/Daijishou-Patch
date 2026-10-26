package proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public interface PlatformVersionOrBuilder extends MessageOrBuilder {
    String getChecksum();

    ByteString getChecksumBytes();

    PlatformVersionCompany getCompanies(int i);

    int getCompaniesCount();

    List<PlatformVersionCompany> getCompaniesList();

    PlatformVersionCompanyOrBuilder getCompaniesOrBuilder(int i);

    List<? extends PlatformVersionCompanyOrBuilder> getCompaniesOrBuilderList();

    String getConnectivity();

    ByteString getConnectivityBytes();

    String getCpu();

    ByteString getCpuBytes();

    String getGraphics();

    ByteString getGraphicsBytes();

    long getId();

    PlatformVersionCompany getMainManufacturer();

    PlatformVersionCompanyOrBuilder getMainManufacturerOrBuilder();

    String getMedia();

    ByteString getMediaBytes();

    String getMemory();

    ByteString getMemoryBytes();

    String getName();

    ByteString getNameBytes();

    String getOnline();

    ByteString getOnlineBytes();

    String getOs();

    ByteString getOsBytes();

    String getOutput();

    ByteString getOutputBytes();

    PlatformLogo getPlatformLogo();

    PlatformLogoOrBuilder getPlatformLogoOrBuilder();

    PlatformVersionReleaseDate getPlatformVersionReleaseDates(int i);

    int getPlatformVersionReleaseDatesCount();

    List<PlatformVersionReleaseDate> getPlatformVersionReleaseDatesList();

    PlatformVersionReleaseDateOrBuilder getPlatformVersionReleaseDatesOrBuilder(int i);

    List<? extends PlatformVersionReleaseDateOrBuilder> getPlatformVersionReleaseDatesOrBuilderList();

    String getResolutions();

    ByteString getResolutionsBytes();

    String getSlug();

    ByteString getSlugBytes();

    String getSound();

    ByteString getSoundBytes();

    String getStorage();

    ByteString getStorageBytes();

    String getSummary();

    ByteString getSummaryBytes();

    String getUrl();

    ByteString getUrlBytes();

    boolean hasMainManufacturer();

    boolean hasPlatformLogo();
}
