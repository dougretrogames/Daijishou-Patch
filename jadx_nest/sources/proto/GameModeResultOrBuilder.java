package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface GameModeResultOrBuilder extends MessageOrBuilder {
    GameMode getGamemodes(int i);

    int getGamemodesCount();

    List<GameMode> getGamemodesList();

    GameModeOrBuilder getGamemodesOrBuilder(int i);

    List<? extends GameModeOrBuilder> getGamemodesOrBuilderList();
}
