package proto;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.RuntimeVersion;
import com.google.protobuf.UninitializedMessageException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public final class TestDummyResult extends GeneratedMessage implements TestDummyResultOrBuilder {
    private static final TestDummyResult DEFAULT_INSTANCE;
    private static final Parser<TestDummyResult> PARSER;
    public static final int TESTDUMMIES_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private List<TestDummy> testdummies_;

    /* synthetic */ TestDummyResult(GeneratedMessage.Builder builder, TestDummyResultIA testDummyResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", TestDummyResult.class.getName());
        DEFAULT_INSTANCE = new TestDummyResult();
        PARSER = new AnonymousClass1();
    }

    private TestDummyResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private TestDummyResult() {
        this.testdummies_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_TestDummyResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_TestDummyResult_fieldAccessorTable.ensureFieldAccessorsInitialized(TestDummyResult.class, Builder.class);
    }

    @Override // proto.TestDummyResultOrBuilder
    public List<TestDummy> getTestdummiesList() {
        return this.testdummies_;
    }

    @Override // proto.TestDummyResultOrBuilder
    public List<? extends TestDummyOrBuilder> getTestdummiesOrBuilderList() {
        return this.testdummies_;
    }

    @Override // proto.TestDummyResultOrBuilder
    public int getTestdummiesCount() {
        return this.testdummies_.size();
    }

    @Override // proto.TestDummyResultOrBuilder
    public TestDummy getTestdummies(int i) {
        return this.testdummies_.get(i);
    }

    @Override // proto.TestDummyResultOrBuilder
    public TestDummyOrBuilder getTestdummiesOrBuilder(int i) {
        return this.testdummies_.get(i);
    }

    public static TestDummyResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static TestDummyResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static TestDummyResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static TestDummyResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static TestDummyResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static TestDummyResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static TestDummyResult parseFrom(InputStream inputStream) throws IOException {
        return (TestDummyResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static TestDummyResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TestDummyResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static TestDummyResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (TestDummyResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static TestDummyResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TestDummyResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static TestDummyResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (TestDummyResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static TestDummyResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TestDummyResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(TestDummyResult testDummyResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) testDummyResult);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((TestDummyResultIA) null) : (Builder) new Builder((TestDummyResultIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements TestDummyResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<TestDummy, TestDummy.Builder, TestDummyOrBuilder> testdummiesBuilder_;
        private List<TestDummy> testdummies_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, TestDummyResultIA testDummyResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(TestDummyResultIA testDummyResultIA) {
            this();
        }

        private void buildPartial0(TestDummyResult testDummyResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_TestDummyResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_TestDummyResult_fieldAccessorTable.ensureFieldAccessorsInitialized(TestDummyResult.class, Builder.class);
        }

        private Builder() {
            this.testdummies_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.testdummies_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<TestDummy, TestDummy.Builder, TestDummyOrBuilder> repeatedFieldBuilder = this.testdummiesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.testdummies_ = Collections.emptyList();
            } else {
                this.testdummies_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_TestDummyResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TestDummyResult getDefaultInstanceForType() {
            return TestDummyResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public TestDummyResult build() {
            TestDummyResult testDummyResultBuildPartial = buildPartial();
            if (testDummyResultBuildPartial.isInitialized()) {
                return testDummyResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) testDummyResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public TestDummyResult buildPartial() {
            TestDummyResult testDummyResult = new TestDummyResult(this, null);
            buildPartialRepeatedFields(testDummyResult);
            if (this.bitField0_ != 0) {
                buildPartial0(testDummyResult);
            }
            onBuilt();
            return testDummyResult;
        }

        private void buildPartialRepeatedFields(TestDummyResult testDummyResult) {
            RepeatedFieldBuilder<TestDummy, TestDummy.Builder, TestDummyOrBuilder> repeatedFieldBuilder = this.testdummiesBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.testdummies_ = Collections.unmodifiableList(this.testdummies_);
                    this.bitField0_ &= -2;
                }
                testDummyResult.testdummies_ = this.testdummies_;
                return;
            }
            testDummyResult.testdummies_ = repeatedFieldBuilder.build();
        }

        private void ensureTestdummiesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.testdummies_ = new ArrayList(this.testdummies_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.TestDummyResultOrBuilder
        public List<TestDummy> getTestdummiesList() {
            RepeatedFieldBuilder<TestDummy, TestDummy.Builder, TestDummyOrBuilder> repeatedFieldBuilder = this.testdummiesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.testdummies_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.TestDummyResultOrBuilder
        public int getTestdummiesCount() {
            RepeatedFieldBuilder<TestDummy, TestDummy.Builder, TestDummyOrBuilder> repeatedFieldBuilder = this.testdummiesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.testdummies_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.TestDummyResultOrBuilder
        public TestDummy getTestdummies(int i) {
            RepeatedFieldBuilder<TestDummy, TestDummy.Builder, TestDummyOrBuilder> repeatedFieldBuilder = this.testdummiesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.testdummies_.get(i);
            }
            return (TestDummy) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setTestdummies(int i, TestDummy testDummy) {
            RepeatedFieldBuilder<TestDummy, TestDummy.Builder, TestDummyOrBuilder> repeatedFieldBuilder = this.testdummiesBuilder_;
            if (repeatedFieldBuilder == null) {
                testDummy.getClass();
                ensureTestdummiesIsMutable();
                this.testdummies_.set(i, testDummy);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, testDummy);
            return this;
        }

        public Builder setTestdummies(int i, TestDummy.Builder builder) {
            RepeatedFieldBuilder<TestDummy, TestDummy.Builder, TestDummyOrBuilder> repeatedFieldBuilder = this.testdummiesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureTestdummiesIsMutable();
                this.testdummies_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addTestdummies(TestDummy testDummy) {
            RepeatedFieldBuilder<TestDummy, TestDummy.Builder, TestDummyOrBuilder> repeatedFieldBuilder = this.testdummiesBuilder_;
            if (repeatedFieldBuilder == null) {
                testDummy.getClass();
                ensureTestdummiesIsMutable();
                this.testdummies_.add(testDummy);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(testDummy);
            return this;
        }

        public Builder addTestdummies(int i, TestDummy testDummy) {
            RepeatedFieldBuilder<TestDummy, TestDummy.Builder, TestDummyOrBuilder> repeatedFieldBuilder = this.testdummiesBuilder_;
            if (repeatedFieldBuilder == null) {
                testDummy.getClass();
                ensureTestdummiesIsMutable();
                this.testdummies_.add(i, testDummy);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, testDummy);
            return this;
        }

        public Builder addTestdummies(TestDummy.Builder builder) {
            RepeatedFieldBuilder<TestDummy, TestDummy.Builder, TestDummyOrBuilder> repeatedFieldBuilder = this.testdummiesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureTestdummiesIsMutable();
                this.testdummies_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addTestdummies(int i, TestDummy.Builder builder) {
            RepeatedFieldBuilder<TestDummy, TestDummy.Builder, TestDummyOrBuilder> repeatedFieldBuilder = this.testdummiesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureTestdummiesIsMutable();
                this.testdummies_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllTestdummies(Iterable<? extends TestDummy> iterable) {
            RepeatedFieldBuilder<TestDummy, TestDummy.Builder, TestDummyOrBuilder> repeatedFieldBuilder = this.testdummiesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureTestdummiesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.testdummies_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearTestdummies() {
            RepeatedFieldBuilder<TestDummy, TestDummy.Builder, TestDummyOrBuilder> repeatedFieldBuilder = this.testdummiesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.testdummies_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeTestdummies(int i) {
            RepeatedFieldBuilder<TestDummy, TestDummy.Builder, TestDummyOrBuilder> repeatedFieldBuilder = this.testdummiesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureTestdummiesIsMutable();
                this.testdummies_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public TestDummy.Builder getTestdummiesBuilder(int i) {
            return (TestDummy.Builder) getTestdummiesFieldBuilder().getBuilder(i);
        }

        @Override // proto.TestDummyResultOrBuilder
        public TestDummyOrBuilder getTestdummiesOrBuilder(int i) {
            RepeatedFieldBuilder<TestDummy, TestDummy.Builder, TestDummyOrBuilder> repeatedFieldBuilder = this.testdummiesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.testdummies_.get(i);
            }
            return (TestDummyOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.TestDummyResultOrBuilder
        public List<? extends TestDummyOrBuilder> getTestdummiesOrBuilderList() {
            RepeatedFieldBuilder<TestDummy, TestDummy.Builder, TestDummyOrBuilder> repeatedFieldBuilder = this.testdummiesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.testdummies_);
        }

        public TestDummy.Builder addTestdummiesBuilder() {
            return (TestDummy.Builder) getTestdummiesFieldBuilder().addBuilder(TestDummy.getDefaultInstance());
        }

        public TestDummy.Builder addTestdummiesBuilder(int i) {
            return (TestDummy.Builder) getTestdummiesFieldBuilder().addBuilder(i, TestDummy.getDefaultInstance());
        }

        public List<TestDummy.Builder> getTestdummiesBuilderList() {
            return getTestdummiesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<TestDummy, TestDummy.Builder, TestDummyOrBuilder> getTestdummiesFieldBuilder() {
            if (this.testdummiesBuilder_ == null) {
                this.testdummiesBuilder_ = new RepeatedFieldBuilder<>(this.testdummies_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.testdummies_ = null;
            }
            return this.testdummiesBuilder_;
        }
    }

    public static TestDummyResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.TestDummyResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<TestDummyResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public TestDummyResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = TestDummyResult.newBuilder();
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

    public static Parser<TestDummyResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<TestDummyResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public TestDummyResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
