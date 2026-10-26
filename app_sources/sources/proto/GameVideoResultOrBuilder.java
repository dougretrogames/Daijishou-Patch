package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public interface GameVideoResultOrBuilder extends MessageOrBuilder {
    GameVideo getGamevideos(int i);

    int getGamevideosCount();

    List<GameVideo> getGamevideosList();

    GameVideoOrBuilder getGamevideosOrBuilder(int i);

    List<? extends GameVideoOrBuilder> getGamevideosOrBuilderList();
}
