package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface EventResultOrBuilder extends MessageOrBuilder {
    Event getEvents(int i);

    int getEventsCount();

    List<Event> getEventsList();

    EventOrBuilder getEventsOrBuilder(int i);

    List<? extends EventOrBuilder> getEventsOrBuilderList();
}
