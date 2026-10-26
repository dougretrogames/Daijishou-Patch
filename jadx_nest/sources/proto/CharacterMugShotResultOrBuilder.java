package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public interface CharacterMugShotResultOrBuilder extends MessageOrBuilder {
    CharacterMugShot getCharactermugshots(int i);

    int getCharactermugshotsCount();

    List<CharacterMugShot> getCharactermugshotsList();

    CharacterMugShotOrBuilder getCharactermugshotsOrBuilder(int i);

    List<? extends CharacterMugShotOrBuilder> getCharactermugshotsOrBuilderList();
}
