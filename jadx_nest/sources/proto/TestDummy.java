package proto;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.RuntimeVersion;
import com.google.protobuf.SingleFieldBuilder;
import com.google.protobuf.Timestamp;
import com.google.protobuf.TimestampOrBuilder;
import com.google.protobuf.UninitializedMessageException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public final class TestDummy extends GeneratedMessage implements TestDummyOrBuilder {
    public static final int BOOL_VALUE_FIELD_NUMBER = 2;
    public static final int CHECKSUM_FIELD_NUMBER = 18;
    public static final int CREATED_AT_FIELD_NUMBER = 3;
    private static final TestDummy DEFAULT_INSTANCE;
    public static final int ENUM_TEST_FIELD_NUMBER = 4;
    public static final int FLOAT_VALUE_FIELD_NUMBER = 5;
    public static final int GAME_FIELD_NUMBER = 6;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int INTEGER_ARRAY_FIELD_NUMBER = 7;
    public static final int INTEGER_VALUE_FIELD_NUMBER = 8;
    public static final int NAME_FIELD_NUMBER = 9;
    public static final int NEW_INTEGER_VALUE_FIELD_NUMBER = 10;
    private static final Parser<TestDummy> PARSER;
    public static final int PRIVATE_FIELD_NUMBER = 11;
    public static final int SLUG_FIELD_NUMBER = 12;
    public static final int STRING_ARRAY_FIELD_NUMBER = 13;
    public static final int TEST_DUMMIES_FIELD_NUMBER = 14;
    public static final int TEST_DUMMY_FIELD_NUMBER = 15;
    public static final int UPDATED_AT_FIELD_NUMBER = 16;
    public static final int URL_FIELD_NUMBER = 17;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private boolean boolValue_;
    private volatile Object checksum_;
    private Timestamp createdAt_;
    private int enumTest_;
    private double floatValue_;
    private Game game_;
    private long id_;
    private int integerArrayMemoizedSerializedSize;
    private Internal.IntList integerArray_;
    private int integerValue_;
    private volatile Object name_;
    private int newIntegerValue_;
    private boolean private_;
    private volatile Object slug_;
    private LazyStringArrayList stringArray_;
    private List<TestDummy> testDummies_;
    private TestDummy testDummy_;
    private Timestamp updatedAt_;
    private volatile Object url_;

    /* synthetic */ TestDummy(GeneratedMessage.Builder builder, TestDummyIA testDummyIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", TestDummy.class.getName());
        DEFAULT_INSTANCE = new TestDummy();
        PARSER = new AnonymousClass1();
    }

    private TestDummy(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.id_ = 0L;
        this.boolValue_ = false;
        this.enumTest_ = 0;
        this.floatValue_ = 0.0d;
        this.integerArray_ = emptyIntList();
        this.integerArrayMemoizedSerializedSize = -1;
        this.integerValue_ = 0;
        this.name_ = "";
        this.newIntegerValue_ = 0;
        this.private_ = false;
        this.slug_ = "";
        this.stringArray_ = LazyStringArrayList.emptyList();
        this.url_ = "";
        this.checksum_ = "";
    }

    private TestDummy() {
        this.id_ = 0L;
        this.boolValue_ = false;
        this.enumTest_ = 0;
        this.floatValue_ = 0.0d;
        this.integerArray_ = emptyIntList();
        this.integerArrayMemoizedSerializedSize = -1;
        this.integerValue_ = 0;
        this.name_ = "";
        this.newIntegerValue_ = 0;
        this.private_ = false;
        this.slug_ = "";
        this.stringArray_ = LazyStringArrayList.emptyList();
        this.url_ = "";
        this.checksum_ = "";
        this.enumTest_ = 0;
        this.integerArray_ = emptyIntList();
        this.name_ = "";
        this.slug_ = "";
        this.stringArray_ = LazyStringArrayList.emptyList();
        this.testDummies_ = Collections.emptyList();
        this.url_ = "";
        this.checksum_ = "";
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_TestDummy_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_TestDummy_fieldAccessorTable.ensureFieldAccessorsInitialized(TestDummy.class, Builder.class);
    }

    @Override // proto.TestDummyOrBuilder
    public long getId() {
        return this.id_;
    }

    @Override // proto.TestDummyOrBuilder
    public boolean getBoolValue() {
        return this.boolValue_;
    }

    @Override // proto.TestDummyOrBuilder
    public boolean hasCreatedAt() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // proto.TestDummyOrBuilder
    public Timestamp getCreatedAt() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.TestDummyOrBuilder
    public TimestampOrBuilder getCreatedAtOrBuilder() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.TestDummyOrBuilder
    public int getEnumTestValue() {
        return this.enumTest_;
    }

    @Override // proto.TestDummyOrBuilder
    public TestDummyEnumTestEnum getEnumTest() {
        TestDummyEnumTestEnum testDummyEnumTestEnumForNumber = TestDummyEnumTestEnum.forNumber(this.enumTest_);
        return testDummyEnumTestEnumForNumber == null ? TestDummyEnumTestEnum.UNRECOGNIZED : testDummyEnumTestEnumForNumber;
    }

    @Override // proto.TestDummyOrBuilder
    public double getFloatValue() {
        return this.floatValue_;
    }

    @Override // proto.TestDummyOrBuilder
    public boolean hasGame() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // proto.TestDummyOrBuilder
    public Game getGame() {
        Game game = this.game_;
        return game == null ? Game.getDefaultInstance() : game;
    }

    @Override // proto.TestDummyOrBuilder
    public GameOrBuilder getGameOrBuilder() {
        Game game = this.game_;
        return game == null ? Game.getDefaultInstance() : game;
    }

    @Override // proto.TestDummyOrBuilder
    public List<Integer> getIntegerArrayList() {
        return this.integerArray_;
    }

    @Override // proto.TestDummyOrBuilder
    public int getIntegerArrayCount() {
        return this.integerArray_.size();
    }

    @Override // proto.TestDummyOrBuilder
    public int getIntegerArray(int i) {
        return this.integerArray_.getInt(i);
    }

    @Override // proto.TestDummyOrBuilder
    public int getIntegerValue() {
        return this.integerValue_;
    }

    @Override // proto.TestDummyOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.TestDummyOrBuilder
    public ByteString getNameBytes() {
        Object obj = this.name_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.TestDummyOrBuilder
    public int getNewIntegerValue() {
        return this.newIntegerValue_;
    }

    @Override // proto.TestDummyOrBuilder
    public boolean getPrivate() {
        return this.private_;
    }

    @Override // proto.TestDummyOrBuilder
    public String getSlug() {
        Object obj = this.slug_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.slug_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.TestDummyOrBuilder
    public ByteString getSlugBytes() {
        Object obj = this.slug_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.slug_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.TestDummyOrBuilder
    public ProtocolStringList getStringArrayList() {
        return this.stringArray_;
    }

    @Override // proto.TestDummyOrBuilder
    public int getStringArrayCount() {
        return this.stringArray_.size();
    }

    @Override // proto.TestDummyOrBuilder
    public String getStringArray(int i) {
        return this.stringArray_.get(i);
    }

    @Override // proto.TestDummyOrBuilder
    public ByteString getStringArrayBytes(int i) {
        return this.stringArray_.getByteString(i);
    }

    @Override // proto.TestDummyOrBuilder
    public List<TestDummy> getTestDummiesList() {
        return this.testDummies_;
    }

    @Override // proto.TestDummyOrBuilder
    public List<? extends TestDummyOrBuilder> getTestDummiesOrBuilderList() {
        return this.testDummies_;
    }

    @Override // proto.TestDummyOrBuilder
    public int getTestDummiesCount() {
        return this.testDummies_.size();
    }

    @Override // proto.TestDummyOrBuilder
    public TestDummy getTestDummies(int i) {
        return this.testDummies_.get(i);
    }

    @Override // proto.TestDummyOrBuilder
    public TestDummyOrBuilder getTestDummiesOrBuilder(int i) {
        return this.testDummies_.get(i);
    }

    @Override // proto.TestDummyOrBuilder
    public boolean hasTestDummy() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // proto.TestDummyOrBuilder
    public TestDummy getTestDummy() {
        TestDummy testDummy = this.testDummy_;
        return testDummy == null ? getDefaultInstance() : testDummy;
    }

    @Override // proto.TestDummyOrBuilder
    public TestDummyOrBuilder getTestDummyOrBuilder() {
        TestDummy testDummy = this.testDummy_;
        return testDummy == null ? getDefaultInstance() : testDummy;
    }

    @Override // proto.TestDummyOrBuilder
    public boolean hasUpdatedAt() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // proto.TestDummyOrBuilder
    public Timestamp getUpdatedAt() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.TestDummyOrBuilder
    public TimestampOrBuilder getUpdatedAtOrBuilder() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.TestDummyOrBuilder
    public String getUrl() {
        Object obj = this.url_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.url_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.TestDummyOrBuilder
    public ByteString getUrlBytes() {
        Object obj = this.url_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.url_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.TestDummyOrBuilder
    public String getChecksum() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.checksum_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.TestDummyOrBuilder
    public ByteString getChecksumBytes() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.checksum_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    public static TestDummy parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static TestDummy parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static TestDummy parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static TestDummy parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static TestDummy parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static TestDummy parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static TestDummy parseFrom(InputStream inputStream) throws IOException {
        return (TestDummy) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static TestDummy parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TestDummy) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static TestDummy parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (TestDummy) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static TestDummy parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TestDummy) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static TestDummy parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (TestDummy) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static TestDummy parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TestDummy) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(TestDummy testDummy) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) testDummy);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((TestDummyIA) null) : (Builder) new Builder((TestDummyIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements TestDummyOrBuilder {
        private int bitField0_;
        private boolean boolValue_;
        private Object checksum_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> createdAtBuilder_;
        private Timestamp createdAt_;
        private int enumTest_;
        private double floatValue_;
        private SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> gameBuilder_;
        private Game game_;
        private long id_;
        private Internal.IntList integerArray_;
        private int integerValue_;
        private Object name_;
        private int newIntegerValue_;
        private boolean private_;
        private Object slug_;
        private LazyStringArrayList stringArray_;
        private RepeatedFieldBuilder<TestDummy, Builder, TestDummyOrBuilder> testDummiesBuilder_;
        private List<TestDummy> testDummies_;
        private SingleFieldBuilder<TestDummy, Builder, TestDummyOrBuilder> testDummyBuilder_;
        private TestDummy testDummy_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> updatedAtBuilder_;
        private Timestamp updatedAt_;
        private Object url_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, TestDummyIA testDummyIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(TestDummyIA testDummyIA) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_TestDummy_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_TestDummy_fieldAccessorTable.ensureFieldAccessorsInitialized(TestDummy.class, Builder.class);
        }

        private Builder() {
            this.enumTest_ = 0;
            this.integerArray_ = TestDummy.emptyIntList();
            this.name_ = "";
            this.slug_ = "";
            this.stringArray_ = LazyStringArrayList.emptyList();
            this.testDummies_ = Collections.emptyList();
            this.url_ = "";
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.enumTest_ = 0;
            this.integerArray_ = TestDummy.emptyIntList();
            this.name_ = "";
            this.slug_ = "";
            this.stringArray_ = LazyStringArrayList.emptyList();
            this.testDummies_ = Collections.emptyList();
            this.url_ = "";
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (TestDummy.alwaysUseFieldBuilders) {
                getCreatedAtFieldBuilder();
                getGameFieldBuilder();
                getTestDummiesFieldBuilder();
                getTestDummyFieldBuilder();
                getUpdatedAtFieldBuilder();
            }
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.id_ = 0L;
            this.boolValue_ = false;
            this.createdAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.createdAtBuilder_ = null;
            }
            this.enumTest_ = 0;
            this.floatValue_ = 0.0d;
            this.game_ = null;
            SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder2 = this.gameBuilder_;
            if (singleFieldBuilder2 != null) {
                singleFieldBuilder2.dispose();
                this.gameBuilder_ = null;
            }
            this.integerArray_ = TestDummy.emptyIntList();
            this.integerValue_ = 0;
            this.name_ = "";
            this.newIntegerValue_ = 0;
            this.private_ = false;
            this.slug_ = "";
            this.stringArray_ = LazyStringArrayList.emptyList();
            RepeatedFieldBuilder<TestDummy, Builder, TestDummyOrBuilder> repeatedFieldBuilder = this.testDummiesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.testDummies_ = Collections.emptyList();
            } else {
                this.testDummies_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -8193;
            this.testDummy_ = null;
            SingleFieldBuilder<TestDummy, Builder, TestDummyOrBuilder> singleFieldBuilder3 = this.testDummyBuilder_;
            if (singleFieldBuilder3 != null) {
                singleFieldBuilder3.dispose();
                this.testDummyBuilder_ = null;
            }
            this.updatedAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder4 = this.updatedAtBuilder_;
            if (singleFieldBuilder4 != null) {
                singleFieldBuilder4.dispose();
                this.updatedAtBuilder_ = null;
            }
            this.url_ = "";
            this.checksum_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_TestDummy_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TestDummy getDefaultInstanceForType() {
            return TestDummy.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public TestDummy build() {
            TestDummy testDummyBuildPartial = buildPartial();
            if (testDummyBuildPartial.isInitialized()) {
                return testDummyBuildPartial;
            }
            throw newUninitializedMessageException((Message) testDummyBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public TestDummy buildPartial() {
            TestDummy testDummy = new TestDummy(this, null);
            buildPartialRepeatedFields(testDummy);
            if (this.bitField0_ != 0) {
                buildPartial0(testDummy);
            }
            onBuilt();
            return testDummy;
        }

        private void buildPartialRepeatedFields(TestDummy testDummy) {
            RepeatedFieldBuilder<TestDummy, Builder, TestDummyOrBuilder> repeatedFieldBuilder = this.testDummiesBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 8192) != 0) {
                    this.testDummies_ = Collections.unmodifiableList(this.testDummies_);
                    this.bitField0_ &= -8193;
                }
                testDummy.testDummies_ = this.testDummies_;
                return;
            }
            testDummy.testDummies_ = repeatedFieldBuilder.build();
        }

        private void buildPartial0(TestDummy testDummy) {
            int i;
            Timestamp timestamp;
            TestDummy testDummy2;
            Game game;
            Timestamp timestamp2;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                testDummy.id_ = this.id_;
            }
            if ((i2 & 2) != 0) {
                testDummy.boolValue_ = this.boolValue_;
            }
            if ((i2 & 4) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
                if (singleFieldBuilder == null) {
                    timestamp2 = this.createdAt_;
                } else {
                    timestamp2 = (Timestamp) singleFieldBuilder.build();
                }
                testDummy.createdAt_ = timestamp2;
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 8) != 0) {
                testDummy.enumTest_ = this.enumTest_;
            }
            if ((i2 & 16) != 0) {
                testDummy.floatValue_ = this.floatValue_;
            }
            if ((i2 & 32) != 0) {
                SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder2 = this.gameBuilder_;
                if (singleFieldBuilder2 == null) {
                    game = this.game_;
                } else {
                    game = (Game) singleFieldBuilder2.build();
                }
                testDummy.game_ = game;
                i |= 2;
            }
            if ((i2 & 64) != 0) {
                this.integerArray_.makeImmutable();
                testDummy.integerArray_ = this.integerArray_;
            }
            if ((i2 & 128) != 0) {
                testDummy.integerValue_ = this.integerValue_;
            }
            if ((i2 & 256) != 0) {
                testDummy.name_ = this.name_;
            }
            if ((i2 & 512) != 0) {
                testDummy.newIntegerValue_ = this.newIntegerValue_;
            }
            if ((i2 & 1024) != 0) {
                testDummy.private_ = this.private_;
            }
            if ((i2 & 2048) != 0) {
                testDummy.slug_ = this.slug_;
            }
            if ((i2 & 4096) != 0) {
                this.stringArray_.makeImmutable();
                testDummy.stringArray_ = this.stringArray_;
            }
            if ((i2 & 16384) != 0) {
                SingleFieldBuilder<TestDummy, Builder, TestDummyOrBuilder> singleFieldBuilder3 = this.testDummyBuilder_;
                if (singleFieldBuilder3 == null) {
                    testDummy2 = this.testDummy_;
                } else {
                    testDummy2 = (TestDummy) singleFieldBuilder3.build();
                }
                testDummy.testDummy_ = testDummy2;
                i |= 4;
            }
            if ((32768 & i2) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder4 = this.updatedAtBuilder_;
                if (singleFieldBuilder4 == null) {
                    timestamp = this.updatedAt_;
                } else {
                    timestamp = (Timestamp) singleFieldBuilder4.build();
                }
                testDummy.updatedAt_ = timestamp;
                i |= 8;
            }
            if ((65536 & i2) != 0) {
                testDummy.url_ = this.url_;
            }
            if ((i2 & 131072) != 0) {
                testDummy.checksum_ = this.checksum_;
            }
            testDummy.bitField0_ |= i;
        }

        @Override // proto.TestDummyOrBuilder
        public long getId() {
            return this.id_;
        }

        public Builder setId(long j) {
            this.id_ = j;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder clearId() {
            this.bitField0_ &= -2;
            this.id_ = 0L;
            onChanged();
            return this;
        }

        @Override // proto.TestDummyOrBuilder
        public boolean getBoolValue() {
            return this.boolValue_;
        }

        public Builder setBoolValue(boolean z) {
            this.boolValue_ = z;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder clearBoolValue() {
            this.bitField0_ &= -3;
            this.boolValue_ = false;
            onChanged();
            return this;
        }

        @Override // proto.TestDummyOrBuilder
        public boolean hasCreatedAt() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // proto.TestDummyOrBuilder
        public Timestamp getCreatedAt() {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder == null) {
                Timestamp timestamp = this.createdAt_;
                return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
            }
            return (Timestamp) singleFieldBuilder.getMessage();
        }

        public Builder setCreatedAt(Timestamp timestamp) {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder == null) {
                timestamp.getClass();
                this.createdAt_ = timestamp;
            } else {
                singleFieldBuilder.setMessage(timestamp);
            }
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setCreatedAt(Timestamp.Builder builder) {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder == null) {
                this.createdAt_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder mergeCreatedAt(Timestamp timestamp) {
            Timestamp timestamp2;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 4) != 0 && (timestamp2 = this.createdAt_) != null && timestamp2 != Timestamp.getDefaultInstance()) {
                    getCreatedAtBuilder().mergeFrom(timestamp);
                } else {
                    this.createdAt_ = timestamp;
                }
            } else {
                singleFieldBuilder.mergeFrom(timestamp);
            }
            if (this.createdAt_ != null) {
                this.bitField0_ |= 4;
                onChanged();
            }
            return this;
        }

        public Builder clearCreatedAt() {
            this.bitField0_ &= -5;
            this.createdAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.createdAtBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Timestamp.Builder getCreatedAtBuilder() {
            this.bitField0_ |= 4;
            onChanged();
            return (Timestamp.Builder) getCreatedAtFieldBuilder().getBuilder();
        }

        @Override // proto.TestDummyOrBuilder
        public TimestampOrBuilder getCreatedAtOrBuilder() {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder != null) {
                return (TimestampOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Timestamp timestamp = this.createdAt_;
            return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
        }

        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> getCreatedAtFieldBuilder() {
            if (this.createdAtBuilder_ == null) {
                this.createdAtBuilder_ = new SingleFieldBuilder<>(getCreatedAt(), getParentForChildren(), isClean());
                this.createdAt_ = null;
            }
            return this.createdAtBuilder_;
        }

        @Override // proto.TestDummyOrBuilder
        public int getEnumTestValue() {
            return this.enumTest_;
        }

        public Builder setEnumTestValue(int i) {
            this.enumTest_ = i;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        @Override // proto.TestDummyOrBuilder
        public TestDummyEnumTestEnum getEnumTest() {
            TestDummyEnumTestEnum testDummyEnumTestEnumForNumber = TestDummyEnumTestEnum.forNumber(this.enumTest_);
            return testDummyEnumTestEnumForNumber == null ? TestDummyEnumTestEnum.UNRECOGNIZED : testDummyEnumTestEnumForNumber;
        }

        public Builder setEnumTest(TestDummyEnumTestEnum testDummyEnumTestEnum) {
            testDummyEnumTestEnum.getClass();
            this.bitField0_ |= 8;
            this.enumTest_ = testDummyEnumTestEnum.getNumber();
            onChanged();
            return this;
        }

        public Builder clearEnumTest() {
            this.bitField0_ &= -9;
            this.enumTest_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.TestDummyOrBuilder
        public double getFloatValue() {
            return this.floatValue_;
        }

        public Builder setFloatValue(double d) {
            this.floatValue_ = d;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder clearFloatValue() {
            this.bitField0_ &= -17;
            this.floatValue_ = 0.0d;
            onChanged();
            return this;
        }

        @Override // proto.TestDummyOrBuilder
        public boolean hasGame() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // proto.TestDummyOrBuilder
        public Game getGame() {
            SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder = this.gameBuilder_;
            if (singleFieldBuilder == null) {
                Game game = this.game_;
                return game == null ? Game.getDefaultInstance() : game;
            }
            return (Game) singleFieldBuilder.getMessage();
        }

        public Builder setGame(Game game) {
            SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder = this.gameBuilder_;
            if (singleFieldBuilder == null) {
                game.getClass();
                this.game_ = game;
            } else {
                singleFieldBuilder.setMessage(game);
            }
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder setGame(Game.Builder builder) {
            SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder = this.gameBuilder_;
            if (singleFieldBuilder == null) {
                this.game_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder mergeGame(Game game) {
            Game game2;
            SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder = this.gameBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 32) != 0 && (game2 = this.game_) != null && game2 != Game.getDefaultInstance()) {
                    getGameBuilder().mergeFrom((Message) game);
                } else {
                    this.game_ = game;
                }
            } else {
                singleFieldBuilder.mergeFrom(game);
            }
            if (this.game_ != null) {
                this.bitField0_ |= 32;
                onChanged();
            }
            return this;
        }

        public Builder clearGame() {
            this.bitField0_ &= -33;
            this.game_ = null;
            SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder = this.gameBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.gameBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Game.Builder getGameBuilder() {
            this.bitField0_ |= 32;
            onChanged();
            return (Game.Builder) getGameFieldBuilder().getBuilder();
        }

        @Override // proto.TestDummyOrBuilder
        public GameOrBuilder getGameOrBuilder() {
            SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder = this.gameBuilder_;
            if (singleFieldBuilder != null) {
                return (GameOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Game game = this.game_;
            return game == null ? Game.getDefaultInstance() : game;
        }

        private SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> getGameFieldBuilder() {
            if (this.gameBuilder_ == null) {
                this.gameBuilder_ = new SingleFieldBuilder<>(getGame(), getParentForChildren(), isClean());
                this.game_ = null;
            }
            return this.gameBuilder_;
        }

        private void ensureIntegerArrayIsMutable() {
            if (!this.integerArray_.isModifiable()) {
                this.integerArray_ = (Internal.IntList) TestDummy.makeMutableCopy(this.integerArray_);
            }
            this.bitField0_ |= 64;
        }

        @Override // proto.TestDummyOrBuilder
        public List<Integer> getIntegerArrayList() {
            this.integerArray_.makeImmutable();
            return this.integerArray_;
        }

        @Override // proto.TestDummyOrBuilder
        public int getIntegerArrayCount() {
            return this.integerArray_.size();
        }

        @Override // proto.TestDummyOrBuilder
        public int getIntegerArray(int i) {
            return this.integerArray_.getInt(i);
        }

        public Builder setIntegerArray(int i, int i2) {
            ensureIntegerArrayIsMutable();
            this.integerArray_.setInt(i, i2);
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder addIntegerArray(int i) {
            ensureIntegerArrayIsMutable();
            this.integerArray_.addInt(i);
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder addAllIntegerArray(Iterable<? extends Integer> iterable) {
            ensureIntegerArrayIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.integerArray_);
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder clearIntegerArray() {
            this.integerArray_ = TestDummy.emptyIntList();
            this.bitField0_ &= -65;
            onChanged();
            return this;
        }

        @Override // proto.TestDummyOrBuilder
        public int getIntegerValue() {
            return this.integerValue_;
        }

        public Builder setIntegerValue(int i) {
            this.integerValue_ = i;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        public Builder clearIntegerValue() {
            this.bitField0_ &= -129;
            this.integerValue_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.TestDummyOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.TestDummyOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setName(String str) {
            str.getClass();
            this.name_ = str;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = TestDummy.getDefaultInstance().getName();
            this.bitField0_ &= -257;
            onChanged();
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            byteString.getClass();
            TestDummy.checkByteStringIsUtf8(byteString);
            this.name_ = byteString;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        @Override // proto.TestDummyOrBuilder
        public int getNewIntegerValue() {
            return this.newIntegerValue_;
        }

        public Builder setNewIntegerValue(int i) {
            this.newIntegerValue_ = i;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        public Builder clearNewIntegerValue() {
            this.bitField0_ &= -513;
            this.newIntegerValue_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.TestDummyOrBuilder
        public boolean getPrivate() {
            return this.private_;
        }

        public Builder setPrivate(boolean z) {
            this.private_ = z;
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        }

        public Builder clearPrivate() {
            this.bitField0_ &= -1025;
            this.private_ = false;
            onChanged();
            return this;
        }

        @Override // proto.TestDummyOrBuilder
        public String getSlug() {
            Object obj = this.slug_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.slug_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.TestDummyOrBuilder
        public ByteString getSlugBytes() {
            Object obj = this.slug_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.slug_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setSlug(String str) {
            str.getClass();
            this.slug_ = str;
            this.bitField0_ |= 2048;
            onChanged();
            return this;
        }

        public Builder clearSlug() {
            this.slug_ = TestDummy.getDefaultInstance().getSlug();
            this.bitField0_ &= -2049;
            onChanged();
            return this;
        }

        public Builder setSlugBytes(ByteString byteString) {
            byteString.getClass();
            TestDummy.checkByteStringIsUtf8(byteString);
            this.slug_ = byteString;
            this.bitField0_ |= 2048;
            onChanged();
            return this;
        }

        private void ensureStringArrayIsMutable() {
            if (!this.stringArray_.isModifiable()) {
                this.stringArray_ = new LazyStringArrayList((LazyStringList) this.stringArray_);
            }
            this.bitField0_ |= 4096;
        }

        @Override // proto.TestDummyOrBuilder
        public ProtocolStringList getStringArrayList() {
            this.stringArray_.makeImmutable();
            return this.stringArray_;
        }

        @Override // proto.TestDummyOrBuilder
        public int getStringArrayCount() {
            return this.stringArray_.size();
        }

        @Override // proto.TestDummyOrBuilder
        public String getStringArray(int i) {
            return this.stringArray_.get(i);
        }

        @Override // proto.TestDummyOrBuilder
        public ByteString getStringArrayBytes(int i) {
            return this.stringArray_.getByteString(i);
        }

        public Builder setStringArray(int i, String str) {
            str.getClass();
            ensureStringArrayIsMutable();
            this.stringArray_.set(i, str);
            this.bitField0_ |= 4096;
            onChanged();
            return this;
        }

        public Builder addStringArray(String str) {
            str.getClass();
            ensureStringArrayIsMutable();
            this.stringArray_.add(str);
            this.bitField0_ |= 4096;
            onChanged();
            return this;
        }

        public Builder addAllStringArray(Iterable<String> iterable) {
            ensureStringArrayIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.stringArray_);
            this.bitField0_ |= 4096;
            onChanged();
            return this;
        }

        public Builder clearStringArray() {
            this.stringArray_ = LazyStringArrayList.emptyList();
            this.bitField0_ &= -4097;
            onChanged();
            return this;
        }

        public Builder addStringArrayBytes(ByteString byteString) {
            byteString.getClass();
            TestDummy.checkByteStringIsUtf8(byteString);
            ensureStringArrayIsMutable();
            this.stringArray_.add(byteString);
            this.bitField0_ |= 4096;
            onChanged();
            return this;
        }

        private void ensureTestDummiesIsMutable() {
            if ((this.bitField0_ & 8192) == 0) {
                this.testDummies_ = new ArrayList(this.testDummies_);
                this.bitField0_ |= 8192;
            }
        }

        @Override // proto.TestDummyOrBuilder
        public List<TestDummy> getTestDummiesList() {
            RepeatedFieldBuilder<TestDummy, Builder, TestDummyOrBuilder> repeatedFieldBuilder = this.testDummiesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.testDummies_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.TestDummyOrBuilder
        public int getTestDummiesCount() {
            RepeatedFieldBuilder<TestDummy, Builder, TestDummyOrBuilder> repeatedFieldBuilder = this.testDummiesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.testDummies_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.TestDummyOrBuilder
        public TestDummy getTestDummies(int i) {
            RepeatedFieldBuilder<TestDummy, Builder, TestDummyOrBuilder> repeatedFieldBuilder = this.testDummiesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.testDummies_.get(i);
            }
            return (TestDummy) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setTestDummies(int i, TestDummy testDummy) {
            RepeatedFieldBuilder<TestDummy, Builder, TestDummyOrBuilder> repeatedFieldBuilder = this.testDummiesBuilder_;
            if (repeatedFieldBuilder == null) {
                testDummy.getClass();
                ensureTestDummiesIsMutable();
                this.testDummies_.set(i, testDummy);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, testDummy);
            return this;
        }

        public Builder setTestDummies(int i, Builder builder) {
            RepeatedFieldBuilder<TestDummy, Builder, TestDummyOrBuilder> repeatedFieldBuilder = this.testDummiesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureTestDummiesIsMutable();
                this.testDummies_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addTestDummies(TestDummy testDummy) {
            RepeatedFieldBuilder<TestDummy, Builder, TestDummyOrBuilder> repeatedFieldBuilder = this.testDummiesBuilder_;
            if (repeatedFieldBuilder == null) {
                testDummy.getClass();
                ensureTestDummiesIsMutable();
                this.testDummies_.add(testDummy);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(testDummy);
            return this;
        }

        public Builder addTestDummies(int i, TestDummy testDummy) {
            RepeatedFieldBuilder<TestDummy, Builder, TestDummyOrBuilder> repeatedFieldBuilder = this.testDummiesBuilder_;
            if (repeatedFieldBuilder == null) {
                testDummy.getClass();
                ensureTestDummiesIsMutable();
                this.testDummies_.add(i, testDummy);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, testDummy);
            return this;
        }

        public Builder addTestDummies(Builder builder) {
            RepeatedFieldBuilder<TestDummy, Builder, TestDummyOrBuilder> repeatedFieldBuilder = this.testDummiesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureTestDummiesIsMutable();
                this.testDummies_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addTestDummies(int i, Builder builder) {
            RepeatedFieldBuilder<TestDummy, Builder, TestDummyOrBuilder> repeatedFieldBuilder = this.testDummiesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureTestDummiesIsMutable();
                this.testDummies_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllTestDummies(Iterable<? extends TestDummy> iterable) {
            RepeatedFieldBuilder<TestDummy, Builder, TestDummyOrBuilder> repeatedFieldBuilder = this.testDummiesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureTestDummiesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.testDummies_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearTestDummies() {
            RepeatedFieldBuilder<TestDummy, Builder, TestDummyOrBuilder> repeatedFieldBuilder = this.testDummiesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.testDummies_ = Collections.emptyList();
                this.bitField0_ &= -8193;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeTestDummies(int i) {
            RepeatedFieldBuilder<TestDummy, Builder, TestDummyOrBuilder> repeatedFieldBuilder = this.testDummiesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureTestDummiesIsMutable();
                this.testDummies_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Builder getTestDummiesBuilder(int i) {
            return (Builder) getTestDummiesFieldBuilder().getBuilder(i);
        }

        @Override // proto.TestDummyOrBuilder
        public TestDummyOrBuilder getTestDummiesOrBuilder(int i) {
            RepeatedFieldBuilder<TestDummy, Builder, TestDummyOrBuilder> repeatedFieldBuilder = this.testDummiesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.testDummies_.get(i);
            }
            return (TestDummyOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.TestDummyOrBuilder
        public List<? extends TestDummyOrBuilder> getTestDummiesOrBuilderList() {
            RepeatedFieldBuilder<TestDummy, Builder, TestDummyOrBuilder> repeatedFieldBuilder = this.testDummiesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.testDummies_);
        }

        public Builder addTestDummiesBuilder() {
            return (Builder) getTestDummiesFieldBuilder().addBuilder(TestDummy.getDefaultInstance());
        }

        public Builder addTestDummiesBuilder(int i) {
            return (Builder) getTestDummiesFieldBuilder().addBuilder(i, TestDummy.getDefaultInstance());
        }

        public List<Builder> getTestDummiesBuilderList() {
            return getTestDummiesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<TestDummy, Builder, TestDummyOrBuilder> getTestDummiesFieldBuilder() {
            if (this.testDummiesBuilder_ == null) {
                this.testDummiesBuilder_ = new RepeatedFieldBuilder<>(this.testDummies_, (this.bitField0_ & 8192) != 0, getParentForChildren(), isClean());
                this.testDummies_ = null;
            }
            return this.testDummiesBuilder_;
        }

        @Override // proto.TestDummyOrBuilder
        public boolean hasTestDummy() {
            return (this.bitField0_ & 16384) != 0;
        }

        @Override // proto.TestDummyOrBuilder
        public TestDummy getTestDummy() {
            SingleFieldBuilder<TestDummy, Builder, TestDummyOrBuilder> singleFieldBuilder = this.testDummyBuilder_;
            if (singleFieldBuilder == null) {
                TestDummy testDummy = this.testDummy_;
                return testDummy == null ? TestDummy.getDefaultInstance() : testDummy;
            }
            return (TestDummy) singleFieldBuilder.getMessage();
        }

        public Builder setTestDummy(TestDummy testDummy) {
            SingleFieldBuilder<TestDummy, Builder, TestDummyOrBuilder> singleFieldBuilder = this.testDummyBuilder_;
            if (singleFieldBuilder == null) {
                testDummy.getClass();
                this.testDummy_ = testDummy;
            } else {
                singleFieldBuilder.setMessage(testDummy);
            }
            this.bitField0_ |= 16384;
            onChanged();
            return this;
        }

        public Builder setTestDummy(Builder builder) {
            SingleFieldBuilder<TestDummy, Builder, TestDummyOrBuilder> singleFieldBuilder = this.testDummyBuilder_;
            if (singleFieldBuilder == null) {
                this.testDummy_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 16384;
            onChanged();
            return this;
        }

        public Builder mergeTestDummy(TestDummy testDummy) {
            TestDummy testDummy2;
            SingleFieldBuilder<TestDummy, Builder, TestDummyOrBuilder> singleFieldBuilder = this.testDummyBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 16384) != 0 && (testDummy2 = this.testDummy_) != null && testDummy2 != TestDummy.getDefaultInstance()) {
                    getTestDummyBuilder().mergeFrom((Message) testDummy);
                } else {
                    this.testDummy_ = testDummy;
                }
            } else {
                singleFieldBuilder.mergeFrom(testDummy);
            }
            if (this.testDummy_ != null) {
                this.bitField0_ |= 16384;
                onChanged();
            }
            return this;
        }

        public Builder clearTestDummy() {
            this.bitField0_ &= -16385;
            this.testDummy_ = null;
            SingleFieldBuilder<TestDummy, Builder, TestDummyOrBuilder> singleFieldBuilder = this.testDummyBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.testDummyBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Builder getTestDummyBuilder() {
            this.bitField0_ |= 16384;
            onChanged();
            return (Builder) getTestDummyFieldBuilder().getBuilder();
        }

        @Override // proto.TestDummyOrBuilder
        public TestDummyOrBuilder getTestDummyOrBuilder() {
            SingleFieldBuilder<TestDummy, Builder, TestDummyOrBuilder> singleFieldBuilder = this.testDummyBuilder_;
            if (singleFieldBuilder != null) {
                return (TestDummyOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            TestDummy testDummy = this.testDummy_;
            return testDummy == null ? TestDummy.getDefaultInstance() : testDummy;
        }

        private SingleFieldBuilder<TestDummy, Builder, TestDummyOrBuilder> getTestDummyFieldBuilder() {
            if (this.testDummyBuilder_ == null) {
                this.testDummyBuilder_ = new SingleFieldBuilder<>(getTestDummy(), getParentForChildren(), isClean());
                this.testDummy_ = null;
            }
            return this.testDummyBuilder_;
        }

        @Override // proto.TestDummyOrBuilder
        public boolean hasUpdatedAt() {
            return (this.bitField0_ & 32768) != 0;
        }

        @Override // proto.TestDummyOrBuilder
        public Timestamp getUpdatedAt() {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
            if (singleFieldBuilder == null) {
                Timestamp timestamp = this.updatedAt_;
                return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
            }
            return (Timestamp) singleFieldBuilder.getMessage();
        }

        public Builder setUpdatedAt(Timestamp timestamp) {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
            if (singleFieldBuilder == null) {
                timestamp.getClass();
                this.updatedAt_ = timestamp;
            } else {
                singleFieldBuilder.setMessage(timestamp);
            }
            this.bitField0_ |= 32768;
            onChanged();
            return this;
        }

        public Builder setUpdatedAt(Timestamp.Builder builder) {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
            if (singleFieldBuilder == null) {
                this.updatedAt_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 32768;
            onChanged();
            return this;
        }

        public Builder mergeUpdatedAt(Timestamp timestamp) {
            Timestamp timestamp2;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 32768) != 0 && (timestamp2 = this.updatedAt_) != null && timestamp2 != Timestamp.getDefaultInstance()) {
                    getUpdatedAtBuilder().mergeFrom(timestamp);
                } else {
                    this.updatedAt_ = timestamp;
                }
            } else {
                singleFieldBuilder.mergeFrom(timestamp);
            }
            if (this.updatedAt_ != null) {
                this.bitField0_ |= 32768;
                onChanged();
            }
            return this;
        }

        public Builder clearUpdatedAt() {
            this.bitField0_ &= -32769;
            this.updatedAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.updatedAtBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Timestamp.Builder getUpdatedAtBuilder() {
            this.bitField0_ |= 32768;
            onChanged();
            return (Timestamp.Builder) getUpdatedAtFieldBuilder().getBuilder();
        }

        @Override // proto.TestDummyOrBuilder
        public TimestampOrBuilder getUpdatedAtOrBuilder() {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
            if (singleFieldBuilder != null) {
                return (TimestampOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Timestamp timestamp = this.updatedAt_;
            return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
        }

        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> getUpdatedAtFieldBuilder() {
            if (this.updatedAtBuilder_ == null) {
                this.updatedAtBuilder_ = new SingleFieldBuilder<>(getUpdatedAt(), getParentForChildren(), isClean());
                this.updatedAt_ = null;
            }
            return this.updatedAtBuilder_;
        }

        @Override // proto.TestDummyOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.url_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.TestDummyOrBuilder
        public ByteString getUrlBytes() {
            Object obj = this.url_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.url_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setUrl(String str) {
            str.getClass();
            this.url_ = str;
            this.bitField0_ |= 65536;
            onChanged();
            return this;
        }

        public Builder clearUrl() {
            this.url_ = TestDummy.getDefaultInstance().getUrl();
            this.bitField0_ &= -65537;
            onChanged();
            return this;
        }

        public Builder setUrlBytes(ByteString byteString) {
            byteString.getClass();
            TestDummy.checkByteStringIsUtf8(byteString);
            this.url_ = byteString;
            this.bitField0_ |= 65536;
            onChanged();
            return this;
        }

        @Override // proto.TestDummyOrBuilder
        public String getChecksum() {
            Object obj = this.checksum_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.checksum_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.TestDummyOrBuilder
        public ByteString getChecksumBytes() {
            Object obj = this.checksum_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.checksum_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setChecksum(String str) {
            str.getClass();
            this.checksum_ = str;
            this.bitField0_ |= 131072;
            onChanged();
            return this;
        }

        public Builder clearChecksum() {
            this.checksum_ = TestDummy.getDefaultInstance().getChecksum();
            this.bitField0_ &= -131073;
            onChanged();
            return this;
        }

        public Builder setChecksumBytes(ByteString byteString) {
            byteString.getClass();
            TestDummy.checkByteStringIsUtf8(byteString);
            this.checksum_ = byteString;
            this.bitField0_ |= 131072;
            onChanged();
            return this;
        }
    }

    public static TestDummy getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.TestDummy$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<TestDummy> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public TestDummy parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = TestDummy.newBuilder();
            try {
                builderNewBuilder.mergeFrom(codedInputStream, extensionRegistryLite);
                return builderNewBuilder.buildPartial();
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(builderNewBuilder.buildPartial());
            } catch (UninitializedMessageException e2) {
                throw e2.asInvalidProtocolBufferException().setUnfinishedMessage(builderNewBuilder.buildPartial());
            } catch (IOException e3) {
                throw new InvalidProtocolBufferException(e3).setUnfinishedMessage(builderNewBuilder.buildPartial());
            }
        }
    }

    public static Parser<TestDummy> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<TestDummy> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public TestDummy getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
