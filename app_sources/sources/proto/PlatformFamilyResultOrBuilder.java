package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public interface PlatformFamilyResultOrBuilder extends MessageOrBuilder {
    PlatformFamily getPlatformfamilies(int i);

    int getPlatformfamiliesCount();

    List<PlatformFamily> getPlatformfamiliesList();

    PlatformFamilyOrBuilder getPlatformfamiliesOrBuilder(int i);

    List<? extends PlatformFamilyOrBuilder> getPlatformfamiliesOrBuilderList();
}
