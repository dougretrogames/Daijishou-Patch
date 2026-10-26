package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public interface GameEngineResultOrBuilder extends MessageOrBuilder {
    GameEngine getGameengines(int i);

    int getGameenginesCount();

    List<GameEngine> getGameenginesList();

    GameEngineOrBuilder getGameenginesOrBuilder(int i);

    List<? extends GameEngineOrBuilder> getGameenginesOrBuilderList();
}
