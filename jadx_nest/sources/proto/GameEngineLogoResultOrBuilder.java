package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface GameEngineLogoResultOrBuilder extends MessageOrBuilder {
    GameEngineLogo getGameenginelogos(int i);

    int getGameenginelogosCount();

    List<GameEngineLogo> getGameenginelogosList();

    GameEngineLogoOrBuilder getGameenginelogosOrBuilder(int i);

    List<? extends GameEngineLogoOrBuilder> getGameenginelogosOrBuilderList();
}
