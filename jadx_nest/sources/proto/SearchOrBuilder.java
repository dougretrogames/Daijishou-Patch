package proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Timestamp;
import com.google.protobuf.TimestampOrBuilder;

/* JADX INFO: loaded from: classes6.dex */
public interface SearchOrBuilder extends MessageOrBuilder {
    String getAlternativeName();

    ByteString getAlternativeNameBytes();

    Character getCharacter();

    CharacterOrBuilder getCharacterOrBuilder();

    String getChecksum();

    ByteString getChecksumBytes();

    Collection getCollection();

    CollectionOrBuilder getCollectionOrBuilder();

    Company getCompany();

    CompanyOrBuilder getCompanyOrBuilder();

    String getDescription();

    ByteString getDescriptionBytes();

    Game getGame();

    GameOrBuilder getGameOrBuilder();

    long getId();

    String getName();

    ByteString getNameBytes();

    Platform getPlatform();

    PlatformOrBuilder getPlatformOrBuilder();

    Timestamp getPublishedAt();

    TimestampOrBuilder getPublishedAtOrBuilder();

    TestDummy getTestDummy();

    TestDummyOrBuilder getTestDummyOrBuilder();

    Theme getTheme();

    ThemeOrBuilder getThemeOrBuilder();

    boolean hasCharacter();

    boolean hasCollection();

    boolean hasCompany();

    boolean hasGame();

    boolean hasPlatform();

    boolean hasPublishedAt();

    boolean hasTestDummy();

    boolean hasTheme();
}
