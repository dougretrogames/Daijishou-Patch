package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface GameLocalizationResultOrBuilder extends MessageOrBuilder {
    GameLocalization getGamelocalizations(int i);

    int getGamelocalizationsCount();

    List<GameLocalization> getGamelocalizationsList();

    GameLocalizationOrBuilder getGamelocalizationsOrBuilder(int i);

    List<? extends GameLocalizationOrBuilder> getGamelocalizationsOrBuilderList();
}
