package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface FranchiseResultOrBuilder extends MessageOrBuilder {
    Franchise getFranchises(int i);

    int getFranchisesCount();

    List<Franchise> getFranchisesList();

    FranchiseOrBuilder getFranchisesOrBuilder(int i);

    List<? extends FranchiseOrBuilder> getFranchisesOrBuilderList();
}
