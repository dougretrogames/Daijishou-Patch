package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface WebsiteResultOrBuilder extends MessageOrBuilder {
    Website getWebsites(int i);

    int getWebsitesCount();

    List<Website> getWebsitesList();

    WebsiteOrBuilder getWebsitesOrBuilder(int i);

    List<? extends WebsiteOrBuilder> getWebsitesOrBuilderList();
}
