package proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface MultiQueryResultOrBuilder extends MessageOrBuilder {
    long getCount();

    String getName();

    ByteString getNameBytes();

    ByteString getResults(int i);

    int getResultsCount();

    List<ByteString> getResultsList();
}
