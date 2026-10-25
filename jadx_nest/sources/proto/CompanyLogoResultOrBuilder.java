package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface CompanyLogoResultOrBuilder extends MessageOrBuilder {
    CompanyLogo getCompanylogos(int i);

    int getCompanylogosCount();

    List<CompanyLogo> getCompanylogosList();

    CompanyLogoOrBuilder getCompanylogosOrBuilder(int i);

    List<? extends CompanyLogoOrBuilder> getCompanylogosOrBuilderList();
}
