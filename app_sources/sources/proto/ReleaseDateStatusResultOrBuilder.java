package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public interface ReleaseDateStatusResultOrBuilder extends MessageOrBuilder {
    ReleaseDateStatus getReleasedatestatuses(int i);

    int getReleasedatestatusesCount();

    List<ReleaseDateStatus> getReleasedatestatusesList();

    ReleaseDateStatusOrBuilder getReleasedatestatusesOrBuilder(int i);

    List<? extends ReleaseDateStatusOrBuilder> getReleasedatestatusesOrBuilderList();
}
