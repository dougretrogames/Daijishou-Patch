package proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Timestamp;
import com.google.protobuf.TimestampOrBuilder;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public interface GameEngineOrBuilder extends MessageOrBuilder {
    String getChecksum();

    ByteString getChecksumBytes();

    Company getCompanies(int i);

    int getCompaniesCount();

    List<Company> getCompaniesList();

    CompanyOrBuilder getCompaniesOrBuilder(int i);

    List<? extends CompanyOrBuilder> getCompaniesOrBuilderList();

    Timestamp getCreatedAt();

    TimestampOrBuilder getCreatedAtOrBuilder();

    String getDescription();

    ByteString getDescriptionBytes();

    long getId();

    GameEngineLogo getLogo();

    GameEngineLogoOrBuilder getLogoOrBuilder();

    String getName();

    ByteString getNameBytes();

    Platform getPlatforms(int i);

    int getPlatformsCount();

    List<Platform> getPlatformsList();

    PlatformOrBuilder getPlatformsOrBuilder(int i);

    List<? extends PlatformOrBuilder> getPlatformsOrBuilderList();

    String getSlug();

    ByteString getSlugBytes();

    Timestamp getUpdatedAt();

    TimestampOrBuilder getUpdatedAtOrBuilder();

    String getUrl();

    ByteString getUrlBytes();

    boolean hasCreatedAt();

    boolean hasLogo();

    boolean hasUpdatedAt();
}
