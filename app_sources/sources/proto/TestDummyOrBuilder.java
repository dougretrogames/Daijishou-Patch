package proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Timestamp;
import com.google.protobuf.TimestampOrBuilder;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public interface TestDummyOrBuilder extends MessageOrBuilder {
    boolean getBoolValue();

    String getChecksum();

    ByteString getChecksumBytes();

    Timestamp getCreatedAt();

    TimestampOrBuilder getCreatedAtOrBuilder();

    TestDummyEnumTestEnum getEnumTest();

    int getEnumTestValue();

    double getFloatValue();

    Game getGame();

    GameOrBuilder getGameOrBuilder();

    long getId();

    int getIntegerArray(int i);

    int getIntegerArrayCount();

    List<Integer> getIntegerArrayList();

    int getIntegerValue();

    String getName();

    ByteString getNameBytes();

    int getNewIntegerValue();

    boolean getPrivate();

    String getSlug();

    ByteString getSlugBytes();

    String getStringArray(int i);

    ByteString getStringArrayBytes(int i);

    int getStringArrayCount();

    List<String> getStringArrayList();

    TestDummy getTestDummies(int i);

    int getTestDummiesCount();

    List<TestDummy> getTestDummiesList();

    TestDummyOrBuilder getTestDummiesOrBuilder(int i);

    List<? extends TestDummyOrBuilder> getTestDummiesOrBuilderList();

    TestDummy getTestDummy();

    TestDummyOrBuilder getTestDummyOrBuilder();

    Timestamp getUpdatedAt();

    TimestampOrBuilder getUpdatedAtOrBuilder();

    String getUrl();

    ByteString getUrlBytes();

    boolean hasCreatedAt();

    boolean hasGame();

    boolean hasTestDummy();

    boolean hasUpdatedAt();
}
