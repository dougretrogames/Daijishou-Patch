package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public interface NetworkTypeResultOrBuilder extends MessageOrBuilder {
    NetworkType getNetworktypes(int i);

    int getNetworktypesCount();

    List<NetworkType> getNetworktypesList();

    NetworkTypeOrBuilder getNetworktypesOrBuilder(int i);

    List<? extends NetworkTypeOrBuilder> getNetworktypesOrBuilderList();
}
