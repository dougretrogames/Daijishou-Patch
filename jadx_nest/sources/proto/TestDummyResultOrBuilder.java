package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface TestDummyResultOrBuilder extends MessageOrBuilder {
    TestDummy getTestdummies(int i);

    int getTestdummiesCount();

    List<TestDummy> getTestdummiesList();

    TestDummyOrBuilder getTestdummiesOrBuilder(int i);

    List<? extends TestDummyOrBuilder> getTestdummiesOrBuilderList();
}
