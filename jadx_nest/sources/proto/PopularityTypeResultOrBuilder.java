package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface PopularityTypeResultOrBuilder extends MessageOrBuilder {
    PopularityType getPopularitytypes(int i);

    int getPopularitytypesCount();

    List<PopularityType> getPopularitytypesList();

    PopularityTypeOrBuilder getPopularitytypesOrBuilder(int i);

    List<? extends PopularityTypeOrBuilder> getPopularitytypesOrBuilderList();
}
