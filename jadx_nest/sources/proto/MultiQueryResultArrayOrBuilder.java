package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public interface MultiQueryResultArrayOrBuilder extends MessageOrBuilder {
    MultiQueryResult getResult(int i);

    int getResultCount();

    List<MultiQueryResult> getResultList();

    MultiQueryResultOrBuilder getResultOrBuilder(int i);

    List<? extends MultiQueryResultOrBuilder> getResultOrBuilderList();
}
