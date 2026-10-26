package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public interface ReleaseDateResultOrBuilder extends MessageOrBuilder {
    ReleaseDate getReleasedates(int i);

    int getReleasedatesCount();

    List<ReleaseDate> getReleasedatesList();

    ReleaseDateOrBuilder getReleasedatesOrBuilder(int i);

    List<? extends ReleaseDateOrBuilder> getReleasedatesOrBuilderList();
}
