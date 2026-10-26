package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public interface GameVersionResultOrBuilder extends MessageOrBuilder {
    GameVersion getGameversions(int i);

    int getGameversionsCount();

    List<GameVersion> getGameversionsList();

    GameVersionOrBuilder getGameversionsOrBuilder(int i);

    List<? extends GameVersionOrBuilder> getGameversionsOrBuilderList();
}
