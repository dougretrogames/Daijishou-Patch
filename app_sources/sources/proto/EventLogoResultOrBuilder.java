package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public interface EventLogoResultOrBuilder extends MessageOrBuilder {
    EventLogo getEventlogos(int i);

    int getEventlogosCount();

    List<EventLogo> getEventlogosList();

    EventLogoOrBuilder getEventlogosOrBuilder(int i);

    List<? extends EventLogoOrBuilder> getEventlogosOrBuilderList();
}
