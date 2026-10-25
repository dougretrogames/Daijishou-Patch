package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface CharacterResultOrBuilder extends MessageOrBuilder {
    Character getCharacters(int i);

    int getCharactersCount();

    List<Character> getCharactersList();

    CharacterOrBuilder getCharactersOrBuilder(int i);

    List<? extends CharacterOrBuilder> getCharactersOrBuilderList();
}
