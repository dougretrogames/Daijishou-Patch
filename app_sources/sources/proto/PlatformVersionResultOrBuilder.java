package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public interface PlatformVersionResultOrBuilder extends MessageOrBuilder {
    PlatformVersion getPlatformversions(int i);

    int getPlatformversionsCount();

    List<PlatformVersion> getPlatformversionsList();

    PlatformVersionOrBuilder getPlatformversionsOrBuilder(int i);

    List<? extends PlatformVersionOrBuilder> getPlatformversionsOrBuilderList();
}
