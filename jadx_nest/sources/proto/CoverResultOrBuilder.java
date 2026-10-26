package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public interface CoverResultOrBuilder extends MessageOrBuilder {
    Cover getCovers(int i);

    int getCoversCount();

    List<Cover> getCoversList();

    CoverOrBuilder getCoversOrBuilder(int i);

    List<? extends CoverOrBuilder> getCoversOrBuilderList();
}
