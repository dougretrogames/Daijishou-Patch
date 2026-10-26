package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public interface InvolvedCompanyResultOrBuilder extends MessageOrBuilder {
    InvolvedCompany getInvolvedcompanies(int i);

    int getInvolvedcompaniesCount();

    List<InvolvedCompany> getInvolvedcompaniesList();

    InvolvedCompanyOrBuilder getInvolvedcompaniesOrBuilder(int i);

    List<? extends InvolvedCompanyOrBuilder> getInvolvedcompaniesOrBuilderList();
}
