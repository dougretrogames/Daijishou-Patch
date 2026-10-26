package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public interface CompanyWebsiteResultOrBuilder extends MessageOrBuilder {
    CompanyWebsite getCompanywebsites(int i);

    int getCompanywebsitesCount();

    List<CompanyWebsite> getCompanywebsitesList();

    CompanyWebsiteOrBuilder getCompanywebsitesOrBuilder(int i);

    List<? extends CompanyWebsiteOrBuilder> getCompanywebsitesOrBuilderList();
}
