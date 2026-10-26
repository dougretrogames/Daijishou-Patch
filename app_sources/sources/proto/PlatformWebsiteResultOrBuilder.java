package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public interface PlatformWebsiteResultOrBuilder extends MessageOrBuilder {
    PlatformWebsite getPlatformwebsites(int i);

    int getPlatformwebsitesCount();

    List<PlatformWebsite> getPlatformwebsitesList();

    PlatformWebsiteOrBuilder getPlatformwebsitesOrBuilder(int i);

    List<? extends PlatformWebsiteOrBuilder> getPlatformwebsitesOrBuilderList();
}
