package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface EventNetworkResultOrBuilder extends MessageOrBuilder {
    EventNetwork getEventnetworks(int i);

    int getEventnetworksCount();

    List<EventNetwork> getEventnetworksList();

    EventNetworkOrBuilder getEventnetworksOrBuilder(int i);

    List<? extends EventNetworkOrBuilder> getEventnetworksOrBuilderList();
}
