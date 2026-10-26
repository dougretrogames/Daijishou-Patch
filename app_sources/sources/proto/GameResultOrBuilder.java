package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public interface GameResultOrBuilder extends MessageOrBuilder {
    Game getGames(int i);

    int getGamesCount();

    List<Game> getGamesList();

    GameOrBuilder getGamesOrBuilder(int i);

    List<? extends GameOrBuilder> getGamesOrBuilderList();
}
