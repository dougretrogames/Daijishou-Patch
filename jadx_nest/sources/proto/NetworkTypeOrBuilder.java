package proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Timestamp;
import com.google.protobuf.TimestampOrBuilder;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public interface NetworkTypeOrBuilder extends MessageOrBuilder {
    String getChecksum();

    ByteString getChecksumBytes();

    Timestamp getCreatedAt();

    TimestampOrBuilder getCreatedAtOrBuilder();

    EventNetwork getEventNetworks(int i);

    int getEventNetworksCount();

    List<EventNetwork> getEventNetworksList();

    EventNetworkOrBuilder getEventNetworksOrBuilder(int i);

    List<? extends EventNetworkOrBuilder> getEventNetworksOrBuilderList();

    long getId();

    String getName();

    ByteString getNameBytes();

    Timestamp getUpdatedAt();

    TimestampOrBuilder getUpdatedAtOrBuilder();

    boolean hasCreatedAt();

    boolean hasUpdatedAt();
}
