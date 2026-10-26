package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public interface PlatformResultOrBuilder extends MessageOrBuilder {
    Platform getPlatforms(int i);

    int getPlatformsCount();

    List<Platform> getPlatformsList();

    PlatformOrBuilder getPlatformsOrBuilder(int i);

    List<? extends PlatformOrBuilder> getPlatformsOrBuilderList();
}
