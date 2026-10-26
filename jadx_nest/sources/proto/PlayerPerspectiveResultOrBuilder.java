package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public interface PlayerPerspectiveResultOrBuilder extends MessageOrBuilder {
    PlayerPerspective getPlayerperspectives(int i);

    int getPlayerperspectivesCount();

    List<PlayerPerspective> getPlayerperspectivesList();

    PlayerPerspectiveOrBuilder getPlayerperspectivesOrBuilder(int i);

    List<? extends PlayerPerspectiveOrBuilder> getPlayerperspectivesOrBuilderList();
}
