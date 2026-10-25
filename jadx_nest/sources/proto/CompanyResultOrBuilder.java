package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface CompanyResultOrBuilder extends MessageOrBuilder {
    Company getCompanies(int i);

    int getCompaniesCount();

    List<Company> getCompaniesList();

    CompanyOrBuilder getCompaniesOrBuilder(int i);

    List<? extends CompanyOrBuilder> getCompaniesOrBuilderList();
}
