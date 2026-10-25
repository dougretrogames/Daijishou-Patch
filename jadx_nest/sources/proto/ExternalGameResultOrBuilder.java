package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface ExternalGameResultOrBuilder extends MessageOrBuilder {
    ExternalGame getExternalgames(int i);

    int getExternalgamesCount();

    List<ExternalGame> getExternalgamesList();

    ExternalGameOrBuilder getExternalgamesOrBuilder(int i);

    List<? extends ExternalGameOrBuilder> getExternalgamesOrBuilderList();
}
