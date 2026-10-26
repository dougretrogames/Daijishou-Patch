package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public interface MultiplayerModeResultOrBuilder extends MessageOrBuilder {
    MultiplayerMode getMultiplayermodes(int i);

    int getMultiplayermodesCount();

    List<MultiplayerMode> getMultiplayermodesList();

    MultiplayerModeOrBuilder getMultiplayermodesOrBuilder(int i);

    List<? extends MultiplayerModeOrBuilder> getMultiplayermodesOrBuilderList();
}
