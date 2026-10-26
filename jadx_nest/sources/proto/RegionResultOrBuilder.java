package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public interface RegionResultOrBuilder extends MessageOrBuilder {
    Region getRegions(int i);

    int getRegionsCount();

    List<Region> getRegionsList();

    RegionOrBuilder getRegionsOrBuilder(int i);

    List<? extends RegionOrBuilder> getRegionsOrBuilderList();
}
