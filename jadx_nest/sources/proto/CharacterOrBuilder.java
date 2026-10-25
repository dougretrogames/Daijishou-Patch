package proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Timestamp;
import com.google.protobuf.TimestampOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface CharacterOrBuilder extends MessageOrBuilder {
    String getAkas(int i);

    ByteString getAkasBytes(int i);

    int getAkasCount();

    List<String> getAkasList();

    String getChecksum();

    ByteString getChecksumBytes();

    String getCountryName();

    ByteString getCountryNameBytes();

    Timestamp getCreatedAt();

    TimestampOrBuilder getCreatedAtOrBuilder();

    String getDescription();

    ByteString getDescriptionBytes();

    Game getGames(int i);

    int getGamesCount();

    List<Game> getGamesList();

    GameOrBuilder getGamesOrBuilder(int i);

    List<? extends GameOrBuilder> getGamesOrBuilderList();

    GenderGenderEnum getGender();

    int getGenderValue();

    long getId();

    CharacterMugShot getMugShot();

    CharacterMugShotOrBuilder getMugShotOrBuilder();

    String getName();

    ByteString getNameBytes();

    String getSlug();

    ByteString getSlugBytes();

    CharacterSpeciesEnum getSpecies();

    int getSpeciesValue();

    Timestamp getUpdatedAt();

    TimestampOrBuilder getUpdatedAtOrBuilder();

    String getUrl();

    ByteString getUrlBytes();

    boolean hasCreatedAt();

    boolean hasMugShot();

    boolean hasUpdatedAt();
}
