package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes4.dex */
public abstract class GeneratedMessage extends AbstractMessage implements Serializable {
    protected static boolean alwaysUseFieldBuilders = false;
    private static final long serialVersionUID = 1;
    protected UnknownFieldSet unknownFields;

    public interface ExtendableMessageOrBuilder<MessageT extends ExtendableMessage<MessageT>> extends MessageOrBuilder {
        @Override // com.google.protobuf.MessageOrBuilder, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        Message getDefaultInstanceForType();

        <T> T getExtension(ExtensionLite<MessageT, T> extension);

        <T> T getExtension(ExtensionLite<MessageT, List<T>> extension, int index);

        <T> int getExtensionCount(ExtensionLite<MessageT, List<T>> extension);

        <T> boolean hasExtension(ExtensionLite<MessageT, T> extension);
    }

    interface ExtensionDescriptorRetriever {
        Descriptors.FieldDescriptor getDescriptor();
    }

    protected abstract FieldAccessorTable internalGetFieldAccessorTable();

    protected GeneratedMessage() {
        this.unknownFields = UnknownFieldSet.getDefaultInstance();
    }

    protected GeneratedMessage(Builder<?> builder) {
        this.unknownFields = builder.getUnknownFields();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<? extends GeneratedMessage> getParserForType() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    static void enableAlwaysUseFieldBuildersForTesting() {
        setAlwaysUseFieldBuildersForTesting(true);
    }

    static void setAlwaysUseFieldBuildersForTesting(boolean useBuilders) {
        alwaysUseFieldBuilders = useBuilders;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Descriptors.Descriptor getDescriptorForType() {
        return internalGetFieldAccessorTable().descriptor;
    }

    @Deprecated
    protected void mergeFromAndMakeImmutableInternal(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        Schema schemaSchemaFor = Protobuf.getInstance().schemaFor(this);
        try {
            schemaSchemaFor.mergeFrom(this, CodedInputStreamReader.forCodedInput(input), extensionRegistry);
            schemaSchemaFor.makeImmutable(this);
        } catch (InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(this);
        } catch (IOException e2) {
            throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:23:0x0066  */
    public Map<Descriptors.FieldDescriptor, Object> getAllFieldsMutable(boolean getBytesForString) {
        TreeMap treeMap = new TreeMap();
        List<Descriptors.FieldDescriptor> fields = internalGetFieldAccessorTable().descriptor.getFields();
        int fieldCount = 0;
        while (fieldCount < fields.size()) {
            Descriptors.FieldDescriptor oneofFieldDescriptor = fields.get(fieldCount);
            Descriptors.OneofDescriptor containingOneof = oneofFieldDescriptor.getContainingOneof();
            if (containingOneof != null) {
                fieldCount += containingOneof.getFieldCount() - 1;
                if (hasOneof(containingOneof)) {
                    oneofFieldDescriptor = getOneofFieldDescriptor(containingOneof);
                    if (!getBytesForString && oneofFieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.STRING) {
                        treeMap.put(oneofFieldDescriptor, getFieldRaw(oneofFieldDescriptor));
                    } else {
                        treeMap.put(oneofFieldDescriptor, getField(oneofFieldDescriptor));
                    }
                }
            } else if (oneofFieldDescriptor.isRepeated()) {
                List list = (List) getField(oneofFieldDescriptor);
                if (!list.isEmpty()) {
                    treeMap.put(oneofFieldDescriptor, list);
                }
            } else if (hasField(oneofFieldDescriptor)) {
                if (!getBytesForString) {
                    treeMap.put(oneofFieldDescriptor, getField(oneofFieldDescriptor));
                } else {
                    treeMap.put(oneofFieldDescriptor, getField(oneofFieldDescriptor));
                }
            }
            fieldCount++;
        }
        return treeMap;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public boolean isInitialized() {
        for (Descriptors.FieldDescriptor fieldDescriptor : getDescriptorForType().getFields()) {
            if (fieldDescriptor.isRequired() && !hasField(fieldDescriptor)) {
                return false;
            }
            if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                if (fieldDescriptor.isRepeated()) {
                    Iterator it = ((List) getField(fieldDescriptor)).iterator();
                    while (it.hasNext()) {
                        if (!((Message) it.next()).isInitialized()) {
                            return false;
                        }
                    }
                } else if (hasField(fieldDescriptor) && !((Message) getField(fieldDescriptor)).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
        return Collections.unmodifiableMap(getAllFieldsMutable(false));
    }

    Map<Descriptors.FieldDescriptor, Object> getAllFieldsRaw() {
        return Collections.unmodifiableMap(getAllFieldsMutable(true));
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageOrBuilder
    public boolean hasOneof(final Descriptors.OneofDescriptor oneof) {
        return internalGetFieldAccessorTable().getOneof(oneof).has(this);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageOrBuilder
    public Descriptors.FieldDescriptor getOneofFieldDescriptor(final Descriptors.OneofDescriptor oneof) {
        return internalGetFieldAccessorTable().getOneof(oneof).get(this);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public boolean hasField(final Descriptors.FieldDescriptor field) {
        return internalGetFieldAccessorTable().getField(field).has(this);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Object getField(final Descriptors.FieldDescriptor field) {
        return internalGetFieldAccessorTable().getField(field).get(this);
    }

    Object getFieldRaw(final Descriptors.FieldDescriptor field) {
        return internalGetFieldAccessorTable().getField(field).getRaw(this);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public int getRepeatedFieldCount(final Descriptors.FieldDescriptor field) {
        return internalGetFieldAccessorTable().getField(field).getRepeatedCount(this);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Object getRepeatedField(final Descriptors.FieldDescriptor field, final int index) {
        return internalGetFieldAccessorTable().getField(field).getRepeated(this, index);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    void setUnknownFields(UnknownFieldSet unknownFields) {
        this.unknownFields = unknownFields;
    }

    protected boolean parseUnknownField(CodedInputStream input, UnknownFieldSet.Builder unknownFields, ExtensionRegistryLite extensionRegistry, int tag) throws IOException {
        if (input.shouldDiscardUnknownFields()) {
            return input.skipField(tag);
        }
        return unknownFields.mergeFieldFrom(tag, input);
    }

    protected boolean parseUnknownFieldProto3(CodedInputStream input, UnknownFieldSet.Builder unknownFields, ExtensionRegistryLite extensionRegistry, int tag) throws IOException {
        return parseUnknownField(input, unknownFields, extensionRegistry, tag);
    }

    protected static <M extends Message> M parseWithIOException(Parser<M> parser, InputStream input) throws IOException {
        try {
            return parser.parseFrom(input);
        } catch (InvalidProtocolBufferException e) {
            throw e.unwrapIOException();
        }
    }

    protected static <M extends Message> M parseWithIOException(Parser<M> parser, InputStream input, ExtensionRegistryLite extensions) throws IOException {
        try {
            return parser.parseFrom(input, extensions);
        } catch (InvalidProtocolBufferException e) {
            throw e.unwrapIOException();
        }
    }

    protected static <M extends Message> M parseWithIOException(Parser<M> parser, CodedInputStream input) throws IOException {
        try {
            return parser.parseFrom(input);
        } catch (InvalidProtocolBufferException e) {
            throw e.unwrapIOException();
        }
    }

    protected static <M extends Message> M parseWithIOException(Parser<M> parser, CodedInputStream input, ExtensionRegistryLite extensions) throws IOException {
        try {
            return parser.parseFrom(input, extensions);
        } catch (InvalidProtocolBufferException e) {
            throw e.unwrapIOException();
        }
    }

    protected static <M extends Message> M parseDelimitedWithIOException(Parser<M> parser, InputStream input) throws IOException {
        try {
            return parser.parseDelimitedFrom(input);
        } catch (InvalidProtocolBufferException e) {
            throw e.unwrapIOException();
        }
    }

    protected static <M extends Message> M parseDelimitedWithIOException(Parser<M> parser, InputStream input, ExtensionRegistryLite extensions) throws IOException {
        try {
            return parser.parseDelimitedFrom(input, extensions);
        } catch (InvalidProtocolBufferException e) {
            throw e.unwrapIOException();
        }
    }

    protected static boolean canUseUnsafe() {
        return UnsafeUtil.hasUnsafeArrayOperations() && UnsafeUtil.hasUnsafeByteBufferOperations();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Internal.IntList emptyIntList() {
        return IntArrayList.emptyList();
    }

    protected static Internal.LongList emptyLongList() {
        return LongArrayList.emptyList();
    }

    protected static Internal.FloatList emptyFloatList() {
        return FloatArrayList.emptyList();
    }

    protected static Internal.DoubleList emptyDoubleList() {
        return DoubleArrayList.emptyList();
    }

    protected static Internal.BooleanList emptyBooleanList() {
        return BooleanArrayList.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <ListT extends Internal.ProtobufList<?>> ListT makeMutableCopy(ListT listt) {
        return (ListT) makeMutableCopy(listt, 0);
    }

    protected static <ListT extends Internal.ProtobufList<?>> ListT makeMutableCopy(ListT listt, int i) {
        int size = listt.size();
        if (i <= size) {
            i = size * 2;
        }
        if (i <= 0) {
            i = 10;
        }
        return (ListT) listt.mutableCopyWithCapacity2(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T> Internal.ProtobufList<T> emptyList(Class<T> elementType) {
        return ProtobufArrayList.emptyList();
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(final CodedOutputStream output) throws IOException {
        MessageReflection.writeMessageTo(this, getAllFieldsRaw(), output, false);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        this.memoizedSize = MessageReflection.getSerializedSize(this, getAllFieldsRaw());
        return this.memoizedSize;
    }

    protected static final class UnusedPrivateParameter {
        static final UnusedPrivateParameter INSTANCE = new UnusedPrivateParameter();

        private UnusedPrivateParameter() {
        }
    }

    protected Object newInstance(UnusedPrivateParameter unused) {
        throw new UnsupportedOperationException("This method must be overridden by the subclass.");
    }

    public static abstract class Builder<BuilderT extends Builder<BuilderT>> extends AbstractMessage.Builder<BuilderT> {
        private AbstractMessage.BuilderParent builderParent;
        private boolean isClean;
        private Builder<BuilderT>.BuilderParentImpl meAsParent;
        private Object unknownFieldsOrBuilder;

        protected abstract FieldAccessorTable internalGetFieldAccessorTable();

        protected Builder() {
            this(null);
        }

        protected Builder(AbstractMessage.BuilderParent builderParent) {
            this.unknownFieldsOrBuilder = UnknownFieldSet.getDefaultInstance();
            this.builderParent = builderParent;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder
        void dispose() {
            this.builderParent = null;
        }

        protected void onBuilt() {
            if (this.builderParent != null) {
                markClean();
            }
        }

        @Override // com.google.protobuf.AbstractMessage.Builder
        protected void markClean() {
            this.isClean = true;
        }

        protected boolean isClean() {
            return this.isClean;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public BuilderT mo3377clone() {
            BuilderT buildert = (BuilderT) getDefaultInstanceForType().newBuilderForType();
            buildert.mergeFrom(buildPartial());
            return buildert;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderT clear() {
            this.unknownFieldsOrBuilder = UnknownFieldSet.getDefaultInstance();
            onChanged();
            return this;
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return internalGetFieldAccessorTable().descriptor;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            return Collections.unmodifiableMap(getAllFieldsMutable());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<Descriptors.FieldDescriptor, Object> getAllFieldsMutable() {
            TreeMap treeMap = new TreeMap();
            List<Descriptors.FieldDescriptor> fields = internalGetFieldAccessorTable().descriptor.getFields();
            int fieldCount = 0;
            while (fieldCount < fields.size()) {
                Descriptors.FieldDescriptor oneofFieldDescriptor = fields.get(fieldCount);
                Descriptors.OneofDescriptor containingOneof = oneofFieldDescriptor.getContainingOneof();
                if (containingOneof != null) {
                    fieldCount += containingOneof.getFieldCount() - 1;
                    if (hasOneof(containingOneof)) {
                        oneofFieldDescriptor = getOneofFieldDescriptor(containingOneof);
                        treeMap.put(oneofFieldDescriptor, getField(oneofFieldDescriptor));
                    }
                } else if (oneofFieldDescriptor.isRepeated()) {
                    List list = (List) getField(oneofFieldDescriptor);
                    if (!list.isEmpty()) {
                        treeMap.put(oneofFieldDescriptor, list);
                    }
                } else if (hasField(oneofFieldDescriptor)) {
                    treeMap.put(oneofFieldDescriptor, getField(oneofFieldDescriptor));
                }
                fieldCount++;
            }
            return treeMap;
        }

        @Override // com.google.protobuf.Message.Builder
        public Message.Builder newBuilderForField(final Descriptors.FieldDescriptor field) {
            return internalGetFieldAccessorTable().getField(field).newBuilder();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Message.Builder getFieldBuilder(final Descriptors.FieldDescriptor field) {
            return internalGetFieldAccessorTable().getField(field).getBuilder(this);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Message.Builder getRepeatedFieldBuilder(final Descriptors.FieldDescriptor field, int index) {
            return internalGetFieldAccessorTable().getField(field).getRepeatedBuilder(this, index);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageOrBuilder
        public boolean hasOneof(final Descriptors.OneofDescriptor oneof) {
            return internalGetFieldAccessorTable().getOneof(oneof).has((Builder<?>) this);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.FieldDescriptor getOneofFieldDescriptor(final Descriptors.OneofDescriptor oneof) {
            return internalGetFieldAccessorTable().getOneof(oneof).get((Builder<?>) this);
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public boolean hasField(final Descriptors.FieldDescriptor field) {
            return internalGetFieldAccessorTable().getField(field).has((Builder<?>) this);
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Object getField(final Descriptors.FieldDescriptor field) {
            Object obj = internalGetFieldAccessorTable().getField(field).get((Builder<?>) this);
            return field.isRepeated() ? Collections.unmodifiableList((List) obj) : obj;
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderT setField(final Descriptors.FieldDescriptor field, final Object value) {
            internalGetFieldAccessorTable().getField(field).set(this, value);
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderT clearField(final Descriptors.FieldDescriptor field) {
            internalGetFieldAccessorTable().getField(field).clear(this);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderT clearOneof(final Descriptors.OneofDescriptor oneof) {
            internalGetFieldAccessorTable().getOneof(oneof).clear(this);
            return this;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(final Descriptors.FieldDescriptor field) {
            return internalGetFieldAccessorTable().getField(field).getRepeatedCount((Builder<?>) this);
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Object getRepeatedField(final Descriptors.FieldDescriptor field, final int index) {
            return internalGetFieldAccessorTable().getField(field).getRepeated((Builder<?>) this, index);
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderT setRepeatedField(final Descriptors.FieldDescriptor field, final int index, final Object value) {
            internalGetFieldAccessorTable().getField(field).setRepeated(this, index, value);
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderT addRepeatedField(final Descriptors.FieldDescriptor field, final Object value) {
            internalGetFieldAccessorTable().getField(field).addRepeated(this, value);
            return this;
        }

        private BuilderT setUnknownFieldsInternal(final UnknownFieldSet unknownFields) {
            this.unknownFieldsOrBuilder = unknownFields;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderT setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (BuilderT) setUnknownFieldsInternal(unknownFieldSet);
        }

        protected BuilderT setUnknownFieldsProto3(UnknownFieldSet unknownFieldSet) {
            return (BuilderT) setUnknownFieldsInternal(unknownFieldSet);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderT mergeUnknownFields(final UnknownFieldSet unknownFields) {
            if (UnknownFieldSet.getDefaultInstance().equals(unknownFields)) {
                return this;
            }
            if (UnknownFieldSet.getDefaultInstance().equals(this.unknownFieldsOrBuilder)) {
                this.unknownFieldsOrBuilder = unknownFields;
                onChanged();
                return this;
            }
            getUnknownFieldSetBuilder().mergeFrom(unknownFields);
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            for (Descriptors.FieldDescriptor fieldDescriptor : getDescriptorForType().getFields()) {
                if (fieldDescriptor.isRequired() && !hasField(fieldDescriptor)) {
                    return false;
                }
                if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    if (fieldDescriptor.isRepeated()) {
                        Iterator it = ((List) getField(fieldDescriptor)).iterator();
                        while (it.hasNext()) {
                            if (!((Message) it.next()).isInitialized()) {
                                return false;
                            }
                        }
                    } else if (hasField(fieldDescriptor) && !((Message) getField(fieldDescriptor)).isInitialized()) {
                        return false;
                    }
                }
            }
            return true;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            Object obj = this.unknownFieldsOrBuilder;
            if (obj instanceof UnknownFieldSet) {
                return (UnknownFieldSet) obj;
            }
            return ((UnknownFieldSet.Builder) obj).buildPartial();
        }

        protected boolean parseUnknownField(CodedInputStream input, ExtensionRegistryLite extensionRegistry, int tag) throws IOException {
            if (input.shouldDiscardUnknownFields()) {
                return input.skipField(tag);
            }
            return getUnknownFieldSetBuilder().mergeFieldFrom(tag, input);
        }

        protected final void mergeUnknownLengthDelimitedField(int number, ByteString bytes) {
            getUnknownFieldSetBuilder().mergeLengthDelimitedField(number, bytes);
        }

        protected final void mergeUnknownVarintField(int number, int value) {
            getUnknownFieldSetBuilder().mergeVarintField(number, value);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder
        protected UnknownFieldSet.Builder getUnknownFieldSetBuilder() {
            Object obj = this.unknownFieldsOrBuilder;
            if (obj instanceof UnknownFieldSet) {
                this.unknownFieldsOrBuilder = ((UnknownFieldSet) obj).toBuilder();
            }
            onChanged();
            return (UnknownFieldSet.Builder) this.unknownFieldsOrBuilder;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder
        protected void setUnknownFieldSetBuilder(UnknownFieldSet.Builder builder) {
            this.unknownFieldsOrBuilder = builder;
            onChanged();
        }

        private class BuilderParentImpl implements AbstractMessage.BuilderParent {
            private BuilderParentImpl() {
            }

            /* synthetic */ BuilderParentImpl(Builder builder, AnonymousClass1 anonymousClass1) {
                this();
            }

            @Override // com.google.protobuf.AbstractMessage.BuilderParent
            public void markDirty() {
                Builder.this.onChanged();
            }
        }

        protected AbstractMessage.BuilderParent getParentForChildren() {
            if (this.meAsParent == null) {
                this.meAsParent = new BuilderParentImpl(this, null);
            }
            return this.meAsParent;
        }

        protected final void onChanged() {
            AbstractMessage.BuilderParent builderParent;
            if (!this.isClean || (builderParent = this.builderParent) == null) {
                return;
            }
            builderParent.markDirty();
            this.isClean = false;
        }

        protected MapFieldReflectionAccessor internalGetMapFieldReflection(int fieldNumber) {
            return internalGetMapField(fieldNumber);
        }

        @Deprecated
        protected MapField internalGetMapField(int fieldNumber) {
            throw new IllegalArgumentException("No map fields found in " + getClass().getName());
        }

        protected MapFieldReflectionAccessor internalGetMutableMapFieldReflection(int fieldNumber) {
            return internalGetMutableMapField(fieldNumber);
        }

        @Deprecated
        protected MapField internalGetMutableMapField(int fieldNumber) {
            throw new IllegalArgumentException("No map fields found in " + getClass().getName());
        }
    }

    public static abstract class ExtendableMessage<MessageT extends ExtendableMessage<MessageT>> extends GeneratedMessage implements ExtendableMessageOrBuilder<MessageT> {
        private static final long serialVersionUID = 1;
        private final FieldSet<Descriptors.FieldDescriptor> extensions;

        protected ExtendableMessage() {
            this.extensions = FieldSet.newFieldSet();
        }

        protected ExtendableMessage(ExtendableBuilder<MessageT, ?> builder) {
            super(builder);
            this.extensions = builder.buildExtensions();
        }

        private void verifyExtensionContainingType(final Extension<MessageT, ?> extension) {
            if (extension.getDescriptor().getContainingType() != getDescriptorForType()) {
                throw new IllegalArgumentException("Extension is for type \"" + extension.getDescriptor().getContainingType().getFullName() + "\" which does not match message type \"" + getDescriptorForType().getFullName() + "\".");
            }
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <T> boolean hasExtension(final ExtensionLite<MessageT, T> extensionLite) {
            Extension<MessageT, ?> extensionCheckNotLite = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            return this.extensions.hasField(extensionCheckNotLite.getDescriptor());
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <T> int getExtensionCount(final ExtensionLite<MessageT, List<T>> extensionLite) {
            Extension<MessageT, ?> extensionCheckNotLite = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            return this.extensions.getRepeatedFieldCount(extensionCheckNotLite.getDescriptor());
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <T> T getExtension(ExtensionLite<MessageT, T> extensionLite) {
            Extension<MessageT, ?> extensionCheckNotLite = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            Descriptors.FieldDescriptor descriptor = extensionCheckNotLite.getDescriptor();
            Object field = this.extensions.getField(descriptor);
            if (field == null) {
                if (descriptor.isRepeated()) {
                    return (T) Collections.emptyList();
                }
                if (descriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    return (T) extensionCheckNotLite.getMessageDefaultInstance();
                }
                return (T) extensionCheckNotLite.fromReflectionType(descriptor.getDefaultValue());
            }
            return (T) extensionCheckNotLite.fromReflectionType(field);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <T> T getExtension(ExtensionLite<MessageT, List<T>> extensionLite, int i) {
            Extension<MessageT, ?> extensionCheckNotLite = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            return (T) extensionCheckNotLite.singularFromReflectionType(this.extensions.getRepeatedField(extensionCheckNotLite.getDescriptor(), i));
        }

        protected boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            return super.isInitialized() && extensionsAreInitialized();
        }

        protected class ExtensionWriter {
            private final Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> iter;
            private final boolean messageSetWireFormat;
            private Map.Entry<Descriptors.FieldDescriptor, Object> next;

            /* synthetic */ ExtensionWriter(ExtendableMessage extendableMessage, boolean z, AnonymousClass1 anonymousClass1) {
                this(z);
            }

            private ExtensionWriter(final boolean messageSetWireFormat) {
                Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> it = ExtendableMessage.this.extensions.iterator();
                this.iter = it;
                if (it.hasNext()) {
                    this.next = it.next();
                }
                this.messageSetWireFormat = messageSetWireFormat;
            }

            public void writeUntil(final int end, final CodedOutputStream output) throws IOException {
                while (true) {
                    Map.Entry<Descriptors.FieldDescriptor, Object> entry = this.next;
                    if (entry == null || entry.getKey().getNumber() >= end) {
                        return;
                    }
                    Descriptors.FieldDescriptor key = this.next.getKey();
                    if (this.messageSetWireFormat && key.getLiteJavaType() == WireFormat.JavaType.MESSAGE && !key.isRepeated()) {
                        if (this.next instanceof LazyField.LazyEntry) {
                            output.writeRawMessageSetExtension(key.getNumber(), ((LazyField.LazyEntry) this.next).getField().toByteString());
                        } else {
                            output.writeMessageSetExtension(key.getNumber(), (Message) this.next.getValue());
                        }
                    } else {
                        FieldSet.writeField(key, this.next.getValue(), output);
                    }
                    if (this.iter.hasNext()) {
                        this.next = this.iter.next();
                    } else {
                        this.next = null;
                    }
                }
            }
        }

        protected ExtendableMessage<MessageT>.ExtensionWriter newExtensionWriter() {
            return new ExtensionWriter(this, false, null);
        }

        protected ExtendableMessage<MessageT>.ExtensionWriter newMessageSetExtensionWriter() {
            return new ExtensionWriter(this, true, null);
        }

        protected int extensionsSerializedSize() {
            return this.extensions.getSerializedSize();
        }

        protected int extensionsSerializedSizeAsMessageSet() {
            return this.extensions.getMessageSetSerializedSize();
        }

        protected Map<Descriptors.FieldDescriptor, Object> getExtensionFields() {
            return this.extensions.getAllFields();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            Map allFieldsMutable = getAllFieldsMutable(false);
            allFieldsMutable.putAll(getExtensionFields());
            return Collections.unmodifiableMap(allFieldsMutable);
        }

        @Override // com.google.protobuf.GeneratedMessage
        public Map<Descriptors.FieldDescriptor, Object> getAllFieldsRaw() {
            Map allFieldsMutable = getAllFieldsMutable(false);
            allFieldsMutable.putAll(getExtensionFields());
            return Collections.unmodifiableMap(allFieldsMutable);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public boolean hasField(final Descriptors.FieldDescriptor field) {
            if (field.isExtension()) {
                verifyContainingType(field);
                return this.extensions.hasField(field);
            }
            return super.hasField(field);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public Object getField(final Descriptors.FieldDescriptor field) {
            if (field.isExtension()) {
                verifyContainingType(field);
                Object field2 = this.extensions.getField(field);
                if (field2 != null) {
                    return field2;
                }
                if (field.isRepeated()) {
                    return Collections.emptyList();
                }
                if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    return DynamicMessage.getDefaultInstance(field.getMessageType());
                }
                return field.getDefaultValue();
            }
            return super.getField(field);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(final Descriptors.FieldDescriptor field) {
            if (field.isExtension()) {
                verifyContainingType(field);
                return this.extensions.getRepeatedFieldCount(field);
            }
            return super.getRepeatedFieldCount(field);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public Object getRepeatedField(final Descriptors.FieldDescriptor field, final int index) {
            if (field.isExtension()) {
                verifyContainingType(field);
                return this.extensions.getRepeatedField(field, index);
            }
            return super.getRepeatedField(field, index);
        }

        private void verifyContainingType(final Descriptors.FieldDescriptor field) {
            if (field.getContainingType() != getDescriptorForType()) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }
    }

    public static abstract class ExtendableBuilder<MessageT extends ExtendableMessage<MessageT>, BuilderT extends ExtendableBuilder<MessageT, BuilderT>> extends Builder<BuilderT> implements ExtendableMessageOrBuilder<MessageT> {
        private FieldSet.Builder<Descriptors.FieldDescriptor> extensions;

        protected ExtendableBuilder() {
        }

        protected ExtendableBuilder(AbstractMessage.BuilderParent parent) {
            super(parent);
        }

        void internalSetExtensionSet(FieldSet<Descriptors.FieldDescriptor> extensions) {
            this.extensions = FieldSet.Builder.fromFieldSet(extensions);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderT clear() {
            this.extensions = null;
            return (BuilderT) super.clear();
        }

        private void ensureExtensionsIsMutable() {
            if (this.extensions == null) {
                this.extensions = FieldSet.newBuilder();
            }
        }

        private void verifyExtensionContainingType(final Extension<MessageT, ?> extension) {
            if (extension.getDescriptor().getContainingType() != getDescriptorForType()) {
                throw new IllegalArgumentException("Extension is for type \"" + extension.getDescriptor().getContainingType().getFullName() + "\" which does not match message type \"" + getDescriptorForType().getFullName() + "\".");
            }
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <T> boolean hasExtension(final ExtensionLite<MessageT, T> extensionLite) {
            Extension<MessageT, ?> extensionCheckNotLite = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            FieldSet.Builder<Descriptors.FieldDescriptor> builder = this.extensions;
            return builder != null && builder.hasField(extensionCheckNotLite.getDescriptor());
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <T> int getExtensionCount(final ExtensionLite<MessageT, List<T>> extensionLite) {
            Extension<MessageT, ?> extensionCheckNotLite = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            Descriptors.FieldDescriptor descriptor = extensionCheckNotLite.getDescriptor();
            FieldSet.Builder<Descriptors.FieldDescriptor> builder = this.extensions;
            if (builder == null) {
                return 0;
            }
            return builder.getRepeatedFieldCount(descriptor);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <T> T getExtension(ExtensionLite<MessageT, T> extensionLite) {
            Extension<MessageT, ?> extensionCheckNotLite = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            Descriptors.FieldDescriptor descriptor = extensionCheckNotLite.getDescriptor();
            FieldSet.Builder<Descriptors.FieldDescriptor> builder = this.extensions;
            Object field = builder == null ? null : builder.getField(descriptor);
            if (field == null) {
                if (descriptor.isRepeated()) {
                    return (T) Collections.emptyList();
                }
                if (descriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    return (T) extensionCheckNotLite.getMessageDefaultInstance();
                }
                return (T) extensionCheckNotLite.fromReflectionType(descriptor.getDefaultValue());
            }
            return (T) extensionCheckNotLite.fromReflectionType(field);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <T> T getExtension(ExtensionLite<MessageT, List<T>> extensionLite, int i) {
            Extension<MessageT, ?> extensionCheckNotLite = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            Descriptors.FieldDescriptor descriptor = extensionCheckNotLite.getDescriptor();
            FieldSet.Builder<Descriptors.FieldDescriptor> builder = this.extensions;
            if (builder == null) {
                throw new IndexOutOfBoundsException();
            }
            return (T) extensionCheckNotLite.singularFromReflectionType(builder.getRepeatedField(descriptor, i));
        }

        public final <T> BuilderT setExtension(final ExtensionLite<MessageT, T> extensionLite, final T value) {
            Extension<MessageT, ?> extensionCheckNotLite = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            ensureExtensionsIsMutable();
            this.extensions.setField(extensionCheckNotLite.getDescriptor(), extensionCheckNotLite.toReflectionType(value));
            onChanged();
            return this;
        }

        public final <T> BuilderT setExtension(final ExtensionLite<MessageT, List<T>> extensionLite, final int index, final T value) {
            Extension<MessageT, ?> extensionCheckNotLite = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            ensureExtensionsIsMutable();
            this.extensions.setRepeatedField(extensionCheckNotLite.getDescriptor(), index, extensionCheckNotLite.singularToReflectionType(value));
            onChanged();
            return this;
        }

        public final <T> BuilderT addExtension(final ExtensionLite<MessageT, List<T>> extensionLite, final T value) {
            Extension<MessageT, ?> extensionCheckNotLite = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            ensureExtensionsIsMutable();
            this.extensions.addRepeatedField(extensionCheckNotLite.getDescriptor(), extensionCheckNotLite.singularToReflectionType(value));
            onChanged();
            return this;
        }

        public final <T> BuilderT clearExtension(final ExtensionLite<MessageT, T> extensionLite) {
            Extension<MessageT, ?> extensionCheckNotLite = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            ensureExtensionsIsMutable();
            this.extensions.clearField(extensionCheckNotLite.getDescriptor());
            onChanged();
            return this;
        }

        protected boolean extensionsAreInitialized() {
            FieldSet.Builder<Descriptors.FieldDescriptor> builder = this.extensions;
            return builder == null || builder.isInitialized();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public FieldSet<Descriptors.FieldDescriptor> buildExtensions() {
            FieldSet.Builder<Descriptors.FieldDescriptor> builder = this.extensions;
            if (builder == null) {
                return FieldSet.emptySet();
            }
            return builder.buildPartial();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            return super.isInitialized() && extensionsAreInitialized();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            Map allFieldsMutable = getAllFieldsMutable();
            FieldSet.Builder<Descriptors.FieldDescriptor> builder = this.extensions;
            if (builder != null) {
                allFieldsMutable.putAll(builder.getAllFields());
            }
            return Collections.unmodifiableMap(allFieldsMutable);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public Object getField(final Descriptors.FieldDescriptor field) {
            if (field.isExtension()) {
                verifyContainingType(field);
                FieldSet.Builder<Descriptors.FieldDescriptor> builder = this.extensions;
                Object field2 = builder == null ? null : builder.getField(field);
                if (field2 != null) {
                    return field2;
                }
                if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    return DynamicMessage.getDefaultInstance(field.getMessageType());
                }
                return field.getDefaultValue();
            }
            return super.getField(field);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Message.Builder getFieldBuilder(final Descriptors.FieldDescriptor field) {
            if (field.isExtension()) {
                verifyContainingType(field);
                if (field.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
                }
                ensureExtensionsIsMutable();
                Object fieldAllowBuilders = this.extensions.getFieldAllowBuilders(field);
                if (fieldAllowBuilders == null) {
                    DynamicMessage.Builder builderNewBuilder = DynamicMessage.newBuilder(field.getMessageType());
                    this.extensions.setField(field, builderNewBuilder);
                    onChanged();
                    return builderNewBuilder;
                }
                if (fieldAllowBuilders instanceof Message.Builder) {
                    return (Message.Builder) fieldAllowBuilders;
                }
                if (fieldAllowBuilders instanceof Message) {
                    Message.Builder builder = ((Message) fieldAllowBuilders).toBuilder();
                    this.extensions.setField(field, builder);
                    onChanged();
                    return builder;
                }
                throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
            }
            return super.getFieldBuilder(field);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(final Descriptors.FieldDescriptor field) {
            if (field.isExtension()) {
                verifyContainingType(field);
                FieldSet.Builder<Descriptors.FieldDescriptor> builder = this.extensions;
                if (builder == null) {
                    return 0;
                }
                return builder.getRepeatedFieldCount(field);
            }
            return super.getRepeatedFieldCount(field);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public Object getRepeatedField(final Descriptors.FieldDescriptor field, final int index) {
            if (field.isExtension()) {
                verifyContainingType(field);
                FieldSet.Builder<Descriptors.FieldDescriptor> builder = this.extensions;
                if (builder == null) {
                    throw new IndexOutOfBoundsException();
                }
                return builder.getRepeatedField(field, index);
            }
            return super.getRepeatedField(field, index);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Message.Builder getRepeatedFieldBuilder(final Descriptors.FieldDescriptor field, final int index) {
            if (field.isExtension()) {
                verifyContainingType(field);
                ensureExtensionsIsMutable();
                if (field.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
                }
                Object repeatedFieldAllowBuilders = this.extensions.getRepeatedFieldAllowBuilders(field, index);
                if (repeatedFieldAllowBuilders instanceof Message.Builder) {
                    return (Message.Builder) repeatedFieldAllowBuilders;
                }
                if (repeatedFieldAllowBuilders instanceof Message) {
                    Message.Builder builder = ((Message) repeatedFieldAllowBuilders).toBuilder();
                    this.extensions.setRepeatedField(field, index, builder);
                    onChanged();
                    return builder;
                }
                throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
            }
            return super.getRepeatedFieldBuilder(field, index);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public boolean hasField(final Descriptors.FieldDescriptor field) {
            if (field.isExtension()) {
                verifyContainingType(field);
                FieldSet.Builder<Descriptors.FieldDescriptor> builder = this.extensions;
                return builder != null && builder.hasField(field);
            }
            return super.hasField(field);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderT setField(final Descriptors.FieldDescriptor field, final Object value) {
            if (field.isExtension()) {
                verifyContainingType(field);
                ensureExtensionsIsMutable();
                this.extensions.setField(field, value);
                onChanged();
                return this;
            }
            return (BuilderT) super.setField(field, value);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderT clearField(final Descriptors.FieldDescriptor field) {
            if (field.isExtension()) {
                verifyContainingType(field);
                ensureExtensionsIsMutable();
                this.extensions.clearField(field);
                onChanged();
                return this;
            }
            return (BuilderT) super.clearField(field);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderT setRepeatedField(final Descriptors.FieldDescriptor field, final int index, final Object value) {
            if (field.isExtension()) {
                verifyContainingType(field);
                ensureExtensionsIsMutable();
                this.extensions.setRepeatedField(field, index, value);
                onChanged();
                return this;
            }
            return (BuilderT) super.setRepeatedField(field, index, value);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderT addRepeatedField(final Descriptors.FieldDescriptor field, final Object value) {
            if (field.isExtension()) {
                verifyContainingType(field);
                ensureExtensionsIsMutable();
                this.extensions.addRepeatedField(field, value);
                onChanged();
                return this;
            }
            return (BuilderT) super.addRepeatedField(field, value);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public Message.Builder newBuilderForField(final Descriptors.FieldDescriptor field) {
            if (field.isExtension()) {
                return DynamicMessage.newBuilder(field.getMessageType());
            }
            return super.newBuilderForField(field);
        }

        protected final void mergeExtensionFields(final ExtendableMessage<?> other) {
            if (((ExtendableMessage) other).extensions != null) {
                ensureExtensionsIsMutable();
                this.extensions.mergeFrom(((ExtendableMessage) other).extensions);
                onChanged();
            }
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected boolean parseUnknownField(CodedInputStream input, ExtensionRegistryLite extensionRegistry, int tag) throws IOException {
            ensureExtensionsIsMutable();
            return MessageReflection.mergeFieldFrom(input, input.shouldDiscardUnknownFields() ? null : getUnknownFieldSetBuilder(), extensionRegistry, getDescriptorForType(), new MessageReflection.ExtensionBuilderAdapter(this.extensions), tag);
        }

        private void verifyContainingType(final Descriptors.FieldDescriptor field) {
            if (field.getContainingType() != getDescriptorForType()) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.GeneratedMessage$1, reason: invalid class name */
    class AnonymousClass1 extends CachedDescriptorRetriever {
        final /* synthetic */ int val$descriptorIndex;
        final /* synthetic */ Message val$scope;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(final Message val$scope, final int val$descriptorIndex) {
            super(null);
            this.val$scope = val$scope;
            this.val$descriptorIndex = val$descriptorIndex;
        }

        @Override // com.google.protobuf.GeneratedMessage.CachedDescriptorRetriever
        public Descriptors.FieldDescriptor loadDescriptor() {
            return this.val$scope.getDescriptorForType().getExtensions().get(this.val$descriptorIndex);
        }
    }

    public static <ContainingT extends Message, T> GeneratedExtension<ContainingT, T> newMessageScopedGeneratedExtension(final Message scope, final int descriptorIndex, final Class<?> singularType, final Message defaultInstance) {
        return new GeneratedExtension<>(new AnonymousClass1(scope, descriptorIndex), singularType, defaultInstance, Extension.ExtensionType.IMMUTABLE);
    }

    public static <ContainingT extends Message, T> GeneratedExtension<ContainingT, T> newFileScopedGeneratedExtension(final Class<?> singularType, final Message defaultInstance) {
        return new GeneratedExtension<>(null, singularType, defaultInstance, Extension.ExtensionType.IMMUTABLE);
    }

    private static abstract class CachedDescriptorRetriever implements ExtensionDescriptorRetriever {
        private volatile Descriptors.FieldDescriptor descriptor;

        protected abstract Descriptors.FieldDescriptor loadDescriptor();

        private CachedDescriptorRetriever() {
        }

        /* synthetic */ CachedDescriptorRetriever(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtensionDescriptorRetriever
        public Descriptors.FieldDescriptor getDescriptor() {
            if (this.descriptor == null) {
                Descriptors.FieldDescriptor fieldDescriptorLoadDescriptor = loadDescriptor();
                synchronized (this) {
                    if (this.descriptor == null) {
                        this.descriptor = fieldDescriptorLoadDescriptor;
                    }
                }
            }
            return this.descriptor;
        }
    }

    public static class GeneratedExtension<ContainingT extends Message, T> extends Extension<ContainingT, T> {
        private ExtensionDescriptorRetriever descriptorRetriever;
        private final java.lang.reflect.Method enumGetValueDescriptor;
        private final java.lang.reflect.Method enumValueOf;
        private final Extension.ExtensionType extensionType;
        private final Message messageDefaultInstance;
        private final Class<?> singularType;

        GeneratedExtension(ExtensionDescriptorRetriever descriptorRetriever, Class<?> singularType, Message messageDefaultInstance, Extension.ExtensionType extensionType) {
            if (Message.class.isAssignableFrom(singularType) && !singularType.isInstance(messageDefaultInstance)) {
                throw new IllegalArgumentException("Bad messageDefaultInstance for " + singularType.getName());
            }
            this.descriptorRetriever = descriptorRetriever;
            this.singularType = singularType;
            this.messageDefaultInstance = messageDefaultInstance;
            if (ProtocolMessageEnum.class.isAssignableFrom(singularType)) {
                this.enumValueOf = GeneratedMessage.getMethodOrDie(singularType, "valueOf", Descriptors.EnumValueDescriptor.class);
                this.enumGetValueDescriptor = GeneratedMessage.getMethodOrDie(singularType, "getValueDescriptor", new Class[0]);
            } else {
                this.enumValueOf = null;
                this.enumGetValueDescriptor = null;
            }
            this.extensionType = extensionType;
        }

        public void internalInit(final Descriptors.FieldDescriptor descriptor) {
            if (this.descriptorRetriever != null) {
                throw new IllegalStateException("Already initialized.");
            }
            this.descriptorRetriever = new AnonymousClass1(descriptor);
        }

        /* JADX INFO: renamed from: com.google.protobuf.GeneratedMessage$GeneratedExtension$1, reason: invalid class name */
        class AnonymousClass1 implements ExtensionDescriptorRetriever {
            final /* synthetic */ Descriptors.FieldDescriptor val$descriptor;

            AnonymousClass1(final Descriptors.FieldDescriptor val$descriptor) {
                this.val$descriptor = val$descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessage.ExtensionDescriptorRetriever
            public Descriptors.FieldDescriptor getDescriptor() {
                return this.val$descriptor;
            }
        }

        @Override // com.google.protobuf.Extension
        public Descriptors.FieldDescriptor getDescriptor() {
            ExtensionDescriptorRetriever extensionDescriptorRetriever = this.descriptorRetriever;
            if (extensionDescriptorRetriever == null) {
                throw new IllegalStateException("getDescriptor() called before internalInit()");
            }
            return extensionDescriptorRetriever.getDescriptor();
        }

        @Override // com.google.protobuf.Extension, com.google.protobuf.ExtensionLite
        public Message getMessageDefaultInstance() {
            return this.messageDefaultInstance;
        }

        @Override // com.google.protobuf.Extension
        protected Extension.ExtensionType getExtensionType() {
            return this.extensionType;
        }

        @Override // com.google.protobuf.Extension
        protected Object fromReflectionType(final Object value) {
            Descriptors.FieldDescriptor descriptor = getDescriptor();
            if (descriptor.isRepeated()) {
                if (descriptor.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE && descriptor.getJavaType() != Descriptors.FieldDescriptor.JavaType.ENUM) {
                    return value;
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = ((List) value).iterator();
                while (it.hasNext()) {
                    arrayList.add(singularFromReflectionType(it.next()));
                }
                return arrayList;
            }
            return singularFromReflectionType(value);
        }

        @Override // com.google.protobuf.Extension
        protected Object singularFromReflectionType(final Object value) {
            int i = AnonymousClass2.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[getDescriptor().getJavaType().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return GeneratedMessage.invokeOrDie(this.enumValueOf, null, value);
                }
            } else if (!this.singularType.isInstance(value)) {
                return this.messageDefaultInstance.newBuilderForType().mergeFrom((Message) value).build();
            }
            return value;
        }

        @Override // com.google.protobuf.Extension
        protected Object toReflectionType(final Object value) {
            Descriptors.FieldDescriptor descriptor = getDescriptor();
            if (descriptor.isRepeated()) {
                if (descriptor.getJavaType() != Descriptors.FieldDescriptor.JavaType.ENUM) {
                    return value;
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = ((List) value).iterator();
                while (it.hasNext()) {
                    arrayList.add(singularToReflectionType(it.next()));
                }
                return arrayList;
            }
            return singularToReflectionType(value);
        }

        @Override // com.google.protobuf.Extension
        protected Object singularToReflectionType(final Object value) {
            return AnonymousClass2.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[getDescriptor().getJavaType().ordinal()] != 2 ? value : GeneratedMessage.invokeOrDie(this.enumGetValueDescriptor, value, new Object[0]);
        }

        @Override // com.google.protobuf.ExtensionLite
        public int getNumber() {
            return getDescriptor().getNumber();
        }

        @Override // com.google.protobuf.ExtensionLite
        public WireFormat.FieldType getLiteType() {
            return getDescriptor().getLiteType();
        }

        @Override // com.google.protobuf.ExtensionLite
        public boolean isRepeated() {
            return getDescriptor().isRepeated();
        }

        @Override // com.google.protobuf.ExtensionLite
        public T getDefaultValue() {
            if (isRepeated()) {
                return (T) Collections.emptyList();
            }
            if (getDescriptor().getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                return (T) this.messageDefaultInstance;
            }
            return (T) singularFromReflectionType(getDescriptor().getDefaultValue());
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.GeneratedMessage$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType;

        static {
            int[] iArr = new int[Descriptors.FieldDescriptor.JavaType.values().length];
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType = iArr;
            try {
                iArr[Descriptors.FieldDescriptor.JavaType.MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[Descriptors.FieldDescriptor.JavaType.ENUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.reflect.Method getMethodOrDie(final Class<?> clazz, final String name, final Class<?>... params) {
        try {
            return clazz.getMethod(name, params);
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException("Generated message class \"" + clazz.getName() + "\" missing method \"" + name + "\".", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object invokeOrDie(final java.lang.reflect.Method method, final Object object, final Object... params) {
        try {
            return method.invoke(object, params);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new IllegalStateException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected MapFieldReflectionAccessor internalGetMapFieldReflection(int fieldNumber) {
        return internalGetMapField(fieldNumber);
    }

    @Deprecated
    protected MapField internalGetMapField(int fieldNumber) {
        throw new IllegalArgumentException("No map fields found in " + getClass().getName());
    }

    public static final class FieldAccessorTable {
        private String[] camelCaseNames;
        private final Descriptors.Descriptor descriptor;
        private final FieldAccessor[] fields;
        private volatile boolean initialized;
        private final OneofAccessor[] oneofs;

        private interface FieldAccessor {
            void addRepeated(Builder<?> builder, Object value);

            void clear(Builder<?> builder);

            Object get(Builder<?> builder);

            Object get(GeneratedMessage message);

            Message.Builder getBuilder(Builder<?> builder);

            Object getRaw(GeneratedMessage message);

            Object getRepeated(Builder<?> builder, int index);

            Object getRepeated(GeneratedMessage message, int index);

            Message.Builder getRepeatedBuilder(Builder<?> builder, int index);

            int getRepeatedCount(Builder<?> builder);

            int getRepeatedCount(GeneratedMessage message);

            boolean has(Builder<?> builder);

            boolean has(GeneratedMessage message);

            Message.Builder newBuilder();

            void set(Builder<?> builder, Object value);

            void setRepeated(Builder<?> builder, int index, Object value);
        }

        private interface OneofAccessor {
            void clear(final Builder<?> builder);

            Descriptors.FieldDescriptor get(Builder<?> builder);

            Descriptors.FieldDescriptor get(final GeneratedMessage message);

            boolean has(Builder<?> builder);

            boolean has(final GeneratedMessage message);
        }

        public FieldAccessorTable(final Descriptors.Descriptor descriptor, final String[] camelCaseNames, final Class<? extends GeneratedMessage> messageClass, final Class<? extends Builder<?>> builderClass) {
            this(descriptor, camelCaseNames);
            ensureFieldAccessorsInitialized(messageClass, builderClass);
        }

        public FieldAccessorTable(final Descriptors.Descriptor descriptor, final String[] camelCaseNames) {
            this.descriptor = descriptor;
            this.camelCaseNames = camelCaseNames;
            this.fields = new FieldAccessor[descriptor.getFields().size()];
            this.oneofs = new OneofAccessor[descriptor.getOneofs().size()];
            this.initialized = false;
        }

        public FieldAccessorTable ensureFieldAccessorsInitialized(Class<? extends GeneratedMessage> messageClass, Class<? extends Builder<?>> builderClass) {
            if (this.initialized) {
                return this;
            }
            synchronized (this) {
                if (this.initialized) {
                    return this;
                }
                int length = this.fields.length;
                int i = 0;
                while (true) {
                    String str = null;
                    if (i >= length) {
                        break;
                    }
                    Descriptors.FieldDescriptor fieldDescriptor = this.descriptor.getFields().get(i);
                    if (fieldDescriptor.getContainingOneof() != null) {
                        int index = fieldDescriptor.getContainingOneof().getIndex() + length;
                        String[] strArr = this.camelCaseNames;
                        if (index < strArr.length) {
                            str = strArr[index];
                        }
                    }
                    String str2 = str;
                    if (fieldDescriptor.isRepeated()) {
                        if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                            if (fieldDescriptor.isMapField()) {
                                this.fields[i] = new MapFieldAccessor(fieldDescriptor, messageClass);
                            } else {
                                this.fields[i] = new RepeatedMessageFieldAccessor(fieldDescriptor, this.camelCaseNames[i], messageClass, builderClass);
                            }
                        } else if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.ENUM) {
                            this.fields[i] = new RepeatedEnumFieldAccessor(fieldDescriptor, this.camelCaseNames[i], messageClass, builderClass);
                        } else {
                            this.fields[i] = new RepeatedFieldAccessor(fieldDescriptor, this.camelCaseNames[i], messageClass, builderClass);
                        }
                    } else if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                        this.fields[i] = new SingularMessageFieldAccessor(fieldDescriptor, this.camelCaseNames[i], messageClass, builderClass, str2);
                    } else if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.ENUM) {
                        this.fields[i] = new SingularEnumFieldAccessor(fieldDescriptor, this.camelCaseNames[i], messageClass, builderClass, str2);
                    } else if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.STRING) {
                        this.fields[i] = new SingularStringFieldAccessor(fieldDescriptor, this.camelCaseNames[i], messageClass, builderClass, str2);
                    } else {
                        this.fields[i] = new SingularFieldAccessor(fieldDescriptor, this.camelCaseNames[i], messageClass, builderClass, str2);
                    }
                    i++;
                }
                for (int i2 = 0; i2 < this.descriptor.getOneofs().size(); i2++) {
                    if (i2 < this.descriptor.getRealOneofs().size()) {
                        this.oneofs[i2] = new RealOneofAccessor(this.descriptor, i2, this.camelCaseNames[i2 + length], messageClass, builderClass);
                    } else {
                        this.oneofs[i2] = new SyntheticOneofAccessor(this.descriptor, i2);
                    }
                }
                this.initialized = true;
                this.camelCaseNames = null;
                return this;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public FieldAccessor getField(final Descriptors.FieldDescriptor field) {
            if (field.getContainingType() != this.descriptor) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
            if (field.isExtension()) {
                throw new IllegalArgumentException("This type does not have extensions.");
            }
            return this.fields[field.getIndex()];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public OneofAccessor getOneof(final Descriptors.OneofDescriptor oneof) {
            if (oneof.getContainingType() != this.descriptor) {
                throw new IllegalArgumentException("OneofDescriptor does not match message type.");
            }
            return this.oneofs[oneof.getIndex()];
        }

        private static class RealOneofAccessor implements OneofAccessor {
            private final java.lang.reflect.Method caseMethod;
            private final java.lang.reflect.Method caseMethodBuilder;
            private final java.lang.reflect.Method clearMethod;
            private final Descriptors.Descriptor descriptor;

            RealOneofAccessor(final Descriptors.Descriptor descriptor, final int oneofIndex, final String camelCaseName, final Class<? extends GeneratedMessage> messageClass, final Class<? extends Builder<?>> builderClass) {
                this.descriptor = descriptor;
                this.caseMethod = GeneratedMessage.getMethodOrDie(messageClass, "get" + camelCaseName + "Case", new Class[0]);
                this.caseMethodBuilder = GeneratedMessage.getMethodOrDie(builderClass, "get" + camelCaseName + "Case", new Class[0]);
                this.clearMethod = GeneratedMessage.getMethodOrDie(builderClass, "clear" + camelCaseName, new Class[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public boolean has(final GeneratedMessage message) {
                return ((Internal.EnumLite) GeneratedMessage.invokeOrDie(this.caseMethod, message, new Object[0])).getNumber() != 0;
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public boolean has(Builder<?> builder) {
                return ((Internal.EnumLite) GeneratedMessage.invokeOrDie(this.caseMethodBuilder, builder, new Object[0])).getNumber() != 0;
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public Descriptors.FieldDescriptor get(final GeneratedMessage message) {
                int number = ((Internal.EnumLite) GeneratedMessage.invokeOrDie(this.caseMethod, message, new Object[0])).getNumber();
                if (number > 0) {
                    return this.descriptor.findFieldByNumber(number);
                }
                return null;
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public Descriptors.FieldDescriptor get(Builder<?> builder) {
                int number = ((Internal.EnumLite) GeneratedMessage.invokeOrDie(this.caseMethodBuilder, builder, new Object[0])).getNumber();
                if (number > 0) {
                    return this.descriptor.findFieldByNumber(number);
                }
                return null;
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public void clear(final Builder<?> builder) {
                GeneratedMessage.invokeOrDie(this.clearMethod, builder, new Object[0]);
            }
        }

        private static class SyntheticOneofAccessor implements OneofAccessor {
            private final Descriptors.FieldDescriptor fieldDescriptor;

            SyntheticOneofAccessor(final Descriptors.Descriptor descriptor, final int oneofIndex) {
                this.fieldDescriptor = descriptor.getOneofs().get(oneofIndex).getFields().get(0);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public boolean has(final GeneratedMessage message) {
                return message.hasField(this.fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public boolean has(Builder<?> builder) {
                return builder.hasField(this.fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public Descriptors.FieldDescriptor get(final GeneratedMessage message) {
                if (message.hasField(this.fieldDescriptor)) {
                    return this.fieldDescriptor;
                }
                return null;
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public Descriptors.FieldDescriptor get(Builder<?> builder) {
                if (builder.hasField(this.fieldDescriptor)) {
                    return this.fieldDescriptor;
                }
                return null;
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public void clear(final Builder<?> builder) {
                builder.clearField(this.fieldDescriptor);
            }
        }

        private static class SingularFieldAccessor implements FieldAccessor {
            protected final Descriptors.FieldDescriptor field;
            protected final boolean hasHasMethod;
            protected final MethodInvoker invoker;
            protected final boolean isOneofField;
            protected final Class<?> type;

            private interface MethodInvoker {
                void clear(final Builder<?> builder);

                Object get(Builder<?> builder);

                Object get(final GeneratedMessage message);

                int getOneofFieldNumber(final Builder<?> builder);

                int getOneofFieldNumber(final GeneratedMessage message);

                boolean has(Builder<?> builder);

                boolean has(final GeneratedMessage message);

                void set(final Builder<?> builder, final Object value);
            }

            static MethodInvoker getMethodInvoker(ReflectionInvoker accessor) {
                return accessor;
            }

            private static final class ReflectionInvoker implements MethodInvoker {
                private final java.lang.reflect.Method caseMethod;
                private final java.lang.reflect.Method caseMethodBuilder;
                private final java.lang.reflect.Method clearMethod;
                private final java.lang.reflect.Method getMethod;
                private final java.lang.reflect.Method getMethodBuilder;
                private final java.lang.reflect.Method hasMethod;
                private final java.lang.reflect.Method hasMethodBuilder;
                private final java.lang.reflect.Method setMethod;

                ReflectionInvoker(final Descriptors.FieldDescriptor descriptor, final String camelCaseName, final Class<? extends GeneratedMessage> messageClass, final Class<? extends Builder<?>> builderClass, final String containingOneofCamelCaseName, boolean isOneofField, boolean hasHasMethod) {
                    java.lang.reflect.Method methodOrDie = GeneratedMessage.getMethodOrDie(messageClass, "get" + camelCaseName, new Class[0]);
                    this.getMethod = methodOrDie;
                    this.getMethodBuilder = GeneratedMessage.getMethodOrDie(builderClass, "get" + camelCaseName, new Class[0]);
                    this.setMethod = GeneratedMessage.getMethodOrDie(builderClass, "set" + camelCaseName, methodOrDie.getReturnType());
                    this.hasMethod = hasHasMethod ? GeneratedMessage.getMethodOrDie(messageClass, "has" + camelCaseName, new Class[0]) : null;
                    this.hasMethodBuilder = hasHasMethod ? GeneratedMessage.getMethodOrDie(builderClass, "has" + camelCaseName, new Class[0]) : null;
                    this.clearMethod = GeneratedMessage.getMethodOrDie(builderClass, "clear" + camelCaseName, new Class[0]);
                    this.caseMethod = isOneofField ? GeneratedMessage.getMethodOrDie(messageClass, "get" + containingOneofCamelCaseName + "Case", new Class[0]) : null;
                    this.caseMethodBuilder = isOneofField ? GeneratedMessage.getMethodOrDie(builderClass, "get" + containingOneofCamelCaseName + "Case", new Class[0]) : null;
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public Object get(final GeneratedMessage message) {
                    return GeneratedMessage.invokeOrDie(this.getMethod, message, new Object[0]);
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public Object get(Builder<?> builder) {
                    return GeneratedMessage.invokeOrDie(this.getMethodBuilder, builder, new Object[0]);
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public int getOneofFieldNumber(final GeneratedMessage message) {
                    return ((Internal.EnumLite) GeneratedMessage.invokeOrDie(this.caseMethod, message, new Object[0])).getNumber();
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public int getOneofFieldNumber(final Builder<?> builder) {
                    return ((Internal.EnumLite) GeneratedMessage.invokeOrDie(this.caseMethodBuilder, builder, new Object[0])).getNumber();
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public void set(final Builder<?> builder, final Object value) {
                    GeneratedMessage.invokeOrDie(this.setMethod, builder, value);
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public boolean has(final GeneratedMessage message) {
                    return ((Boolean) GeneratedMessage.invokeOrDie(this.hasMethod, message, new Object[0])).booleanValue();
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public boolean has(Builder<?> builder) {
                    return ((Boolean) GeneratedMessage.invokeOrDie(this.hasMethodBuilder, builder, new Object[0])).booleanValue();
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public void clear(final Builder<?> builder) {
                    GeneratedMessage.invokeOrDie(this.clearMethod, builder, new Object[0]);
                }
            }

            SingularFieldAccessor(final Descriptors.FieldDescriptor descriptor, final String camelCaseName, final Class<? extends GeneratedMessage> messageClass, final Class<? extends Builder<?>> builderClass, final String containingOneofCamelCaseName) {
                boolean z = descriptor.getRealContainingOneof() != null;
                this.isOneofField = z;
                boolean zHasPresence = descriptor.hasPresence();
                this.hasHasMethod = zHasPresence;
                ReflectionInvoker reflectionInvoker = new ReflectionInvoker(descriptor, camelCaseName, messageClass, builderClass, containingOneofCamelCaseName, z, zHasPresence);
                this.field = descriptor;
                this.type = reflectionInvoker.getMethod.getReturnType();
                this.invoker = getMethodInvoker(reflectionInvoker);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(final GeneratedMessage message) {
                return this.invoker.get(message);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(Builder<?> builder) {
                return this.invoker.get(builder);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRaw(final GeneratedMessage message) {
                return get(message);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(final Builder<?> builder, final Object value) {
                this.invoker.set(builder, value);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(final GeneratedMessage message, final int index) {
                throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(Builder<?> builder, int index) {
                throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(final Builder<?> builder, final int index, final Object value) {
                throw new UnsupportedOperationException("setRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(final Builder<?> builder, final Object value) {
                throw new UnsupportedOperationException("addRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(final GeneratedMessage message) {
                if (!this.hasHasMethod) {
                    if (this.isOneofField) {
                        return this.invoker.getOneofFieldNumber(message) == this.field.getNumber();
                    }
                    return !get(message).equals(this.field.getDefaultValue());
                }
                return this.invoker.has(message);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(Builder<?> builder) {
                if (!this.hasHasMethod) {
                    if (this.isOneofField) {
                        return this.invoker.getOneofFieldNumber(builder) == this.field.getNumber();
                    }
                    return !get(builder).equals(this.field.getDefaultValue());
                }
                return this.invoker.has(builder);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(final GeneratedMessage message) {
                throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(Builder<?> builder) {
                throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void clear(final Builder<?> builder) {
                this.invoker.clear(builder);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getBuilder(Builder<?> builder) {
                throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getRepeatedBuilder(Builder<?> builder, int index) {
                throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
            }
        }

        private static class RepeatedFieldAccessor implements FieldAccessor {
            protected final MethodInvoker invoker;
            protected final Class<?> type;

            interface MethodInvoker {
                void addRepeated(final Builder<?> builder, final Object value);

                void clear(final Builder<?> builder);

                Object get(Builder<?> builder);

                Object get(final GeneratedMessage message);

                Object getRepeated(Builder<?> builder, int index);

                Object getRepeated(final GeneratedMessage message, final int index);

                int getRepeatedCount(Builder<?> builder);

                int getRepeatedCount(final GeneratedMessage message);

                void setRepeated(final Builder<?> builder, final int index, final Object value);
            }

            static MethodInvoker getMethodInvoker(ReflectionInvoker accessor) {
                return accessor;
            }

            private static final class ReflectionInvoker implements MethodInvoker {
                private final java.lang.reflect.Method addRepeatedMethod;
                private final java.lang.reflect.Method clearMethod;
                private final java.lang.reflect.Method getCountMethod;
                private final java.lang.reflect.Method getCountMethodBuilder;
                private final java.lang.reflect.Method getMethod;
                private final java.lang.reflect.Method getMethodBuilder;
                private final java.lang.reflect.Method getRepeatedMethod;
                private final java.lang.reflect.Method getRepeatedMethodBuilder;
                private final java.lang.reflect.Method setRepeatedMethod;

                ReflectionInvoker(final Descriptors.FieldDescriptor descriptor, final String camelCaseName, final Class<? extends GeneratedMessage> messageClass, final Class<? extends Builder<?>> builderClass) {
                    this.getMethod = GeneratedMessage.getMethodOrDie(messageClass, "get" + camelCaseName + "List", new Class[0]);
                    this.getMethodBuilder = GeneratedMessage.getMethodOrDie(builderClass, "get" + camelCaseName + "List", new Class[0]);
                    java.lang.reflect.Method methodOrDie = GeneratedMessage.getMethodOrDie(messageClass, "get" + camelCaseName, Integer.TYPE);
                    this.getRepeatedMethod = methodOrDie;
                    this.getRepeatedMethodBuilder = GeneratedMessage.getMethodOrDie(builderClass, "get" + camelCaseName, Integer.TYPE);
                    Class<?> returnType = methodOrDie.getReturnType();
                    this.setRepeatedMethod = GeneratedMessage.getMethodOrDie(builderClass, "set" + camelCaseName, Integer.TYPE, returnType);
                    this.addRepeatedMethod = GeneratedMessage.getMethodOrDie(builderClass, "add" + camelCaseName, returnType);
                    this.getCountMethod = GeneratedMessage.getMethodOrDie(messageClass, "get" + camelCaseName + "Count", new Class[0]);
                    this.getCountMethodBuilder = GeneratedMessage.getMethodOrDie(builderClass, "get" + camelCaseName + "Count", new Class[0]);
                    this.clearMethod = GeneratedMessage.getMethodOrDie(builderClass, "clear" + camelCaseName, new Class[0]);
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public Object get(final GeneratedMessage message) {
                    return GeneratedMessage.invokeOrDie(this.getMethod, message, new Object[0]);
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public Object get(Builder<?> builder) {
                    return GeneratedMessage.invokeOrDie(this.getMethodBuilder, builder, new Object[0]);
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public Object getRepeated(final GeneratedMessage message, final int index) {
                    return GeneratedMessage.invokeOrDie(this.getRepeatedMethod, message, Integer.valueOf(index));
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public Object getRepeated(Builder<?> builder, int index) {
                    return GeneratedMessage.invokeOrDie(this.getRepeatedMethodBuilder, builder, Integer.valueOf(index));
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public void setRepeated(final Builder<?> builder, final int index, final Object value) {
                    GeneratedMessage.invokeOrDie(this.setRepeatedMethod, builder, Integer.valueOf(index), value);
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public void addRepeated(final Builder<?> builder, final Object value) {
                    GeneratedMessage.invokeOrDie(this.addRepeatedMethod, builder, value);
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public int getRepeatedCount(final GeneratedMessage message) {
                    return ((Integer) GeneratedMessage.invokeOrDie(this.getCountMethod, message, new Object[0])).intValue();
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public int getRepeatedCount(Builder<?> builder) {
                    return ((Integer) GeneratedMessage.invokeOrDie(this.getCountMethodBuilder, builder, new Object[0])).intValue();
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public void clear(final Builder<?> builder) {
                    GeneratedMessage.invokeOrDie(this.clearMethod, builder, new Object[0]);
                }
            }

            RepeatedFieldAccessor(final Descriptors.FieldDescriptor descriptor, final String camelCaseName, final Class<? extends GeneratedMessage> messageClass, final Class<? extends Builder<?>> builderClass) {
                ReflectionInvoker reflectionInvoker = new ReflectionInvoker(descriptor, camelCaseName, messageClass, builderClass);
                this.type = reflectionInvoker.getRepeatedMethod.getReturnType();
                this.invoker = getMethodInvoker(reflectionInvoker);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(final GeneratedMessage message) {
                return this.invoker.get(message);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(Builder<?> builder) {
                return this.invoker.get(builder);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRaw(final GeneratedMessage message) {
                return get(message);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(final Builder<?> builder, final Object value) {
                clear(builder);
                Iterator it = ((List) value).iterator();
                while (it.hasNext()) {
                    addRepeated(builder, it.next());
                }
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(final GeneratedMessage message, final int index) {
                return this.invoker.getRepeated(message, index);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(Builder<?> builder, int index) {
                return this.invoker.getRepeated(builder, index);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(final Builder<?> builder, final int index, final Object value) {
                this.invoker.setRepeated(builder, index, value);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(final Builder<?> builder, final Object value) {
                this.invoker.addRepeated(builder, value);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(final GeneratedMessage message) {
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(Builder<?> builder) {
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(final GeneratedMessage message) {
                return this.invoker.getRepeatedCount(message);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(Builder<?> builder) {
                return this.invoker.getRepeatedCount(builder);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void clear(final Builder<?> builder) {
                this.invoker.clear(builder);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getBuilder(Builder<?> builder) {
                throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getRepeatedBuilder(Builder<?> builder, int index) {
                throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
            }
        }

        private static class MapFieldAccessor implements FieldAccessor {
            private final Descriptors.FieldDescriptor field;
            private final Message mapEntryMessageDefaultInstance;

            MapFieldAccessor(final Descriptors.FieldDescriptor descriptor, final Class<? extends GeneratedMessage> messageClass) {
                this.field = descriptor;
                this.mapEntryMessageDefaultInstance = getMapField((GeneratedMessage) GeneratedMessage.invokeOrDie(GeneratedMessage.getMethodOrDie(messageClass, "getDefaultInstance", new Class[0]), null, new Object[0])).getMapEntryMessageDefaultInstance();
            }

            private MapFieldReflectionAccessor getMapField(GeneratedMessage message) {
                return message.internalGetMapFieldReflection(this.field.getNumber());
            }

            private MapFieldReflectionAccessor getMapField(Builder<?> builder) {
                return builder.internalGetMapFieldReflection(this.field.getNumber());
            }

            private MapFieldReflectionAccessor getMutableMapField(Builder<?> builder) {
                return builder.internalGetMutableMapFieldReflection(this.field.getNumber());
            }

            private Message coerceType(Message value) {
                if (value == null) {
                    return null;
                }
                return this.mapEntryMessageDefaultInstance.getClass().isInstance(value) ? value : this.mapEntryMessageDefaultInstance.toBuilder().mergeFrom(value).build();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(GeneratedMessage message) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < getRepeatedCount(message); i++) {
                    arrayList.add(getRepeated(message, i));
                }
                return Collections.unmodifiableList(arrayList);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(Builder<?> builder) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < getRepeatedCount(builder); i++) {
                    arrayList.add(getRepeated(builder, i));
                }
                return Collections.unmodifiableList(arrayList);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRaw(GeneratedMessage message) {
                return get(message);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder<?> builder, Object value) {
                clear(builder);
                Iterator it = ((List) value).iterator();
                while (it.hasNext()) {
                    addRepeated(builder, it.next());
                }
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(GeneratedMessage message, int index) {
                return getMapField(message).getList().get(index);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(Builder<?> builder, int index) {
                return getMapField(builder).getList().get(index);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(Builder<?> builder, int index, Object value) {
                getMutableMapField(builder).getMutableList().set(index, coerceType((Message) value));
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(Builder<?> builder, Object value) {
                getMutableMapField(builder).getMutableList().add(coerceType((Message) value));
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(GeneratedMessage message) {
                throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(Builder<?> builder) {
                throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(GeneratedMessage message) {
                return getMapField(message).getList().size();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(Builder<?> builder) {
                return getMapField(builder).getList().size();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void clear(Builder<?> builder) {
                getMutableMapField(builder).getMutableList().clear();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                return this.mapEntryMessageDefaultInstance.newBuilderForType();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getBuilder(Builder<?> builder) {
                throw new UnsupportedOperationException("Nested builder not supported for map fields.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getRepeatedBuilder(Builder<?> builder, int index) {
                throw new UnsupportedOperationException("Map fields cannot be repeated");
            }
        }

        private static final class SingularEnumFieldAccessor extends SingularFieldAccessor {
            private final Descriptors.EnumDescriptor enumDescriptor;
            private final java.lang.reflect.Method getValueDescriptorMethod;
            private java.lang.reflect.Method getValueMethod;
            private java.lang.reflect.Method getValueMethodBuilder;
            private java.lang.reflect.Method setValueMethod;
            private final boolean supportUnknownEnumValue;
            private final java.lang.reflect.Method valueOfMethod;

            SingularEnumFieldAccessor(final Descriptors.FieldDescriptor descriptor, final String camelCaseName, final Class<? extends GeneratedMessage> messageClass, final Class<? extends Builder<?>> builderClass, final String containingOneofCamelCaseName) {
                super(descriptor, camelCaseName, messageClass, builderClass, containingOneofCamelCaseName);
                this.enumDescriptor = descriptor.getEnumType();
                this.valueOfMethod = GeneratedMessage.getMethodOrDie(this.type, "valueOf", Descriptors.EnumValueDescriptor.class);
                this.getValueDescriptorMethod = GeneratedMessage.getMethodOrDie(this.type, "getValueDescriptor", new Class[0]);
                boolean zLegacyEnumFieldTreatedAsClosed = descriptor.legacyEnumFieldTreatedAsClosed();
                this.supportUnknownEnumValue = !zLegacyEnumFieldTreatedAsClosed;
                if (zLegacyEnumFieldTreatedAsClosed) {
                    return;
                }
                this.getValueMethod = GeneratedMessage.getMethodOrDie(messageClass, "get" + camelCaseName + "Value", new Class[0]);
                this.getValueMethodBuilder = GeneratedMessage.getMethodOrDie(builderClass, "get" + camelCaseName + "Value", new Class[0]);
                this.setValueMethod = GeneratedMessage.getMethodOrDie(builderClass, "set" + camelCaseName + "Value", Integer.TYPE);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(final GeneratedMessage message) {
                if (this.supportUnknownEnumValue) {
                    return this.enumDescriptor.findValueByNumberCreatingIfUnknown(((Integer) GeneratedMessage.invokeOrDie(this.getValueMethod, message, new Object[0])).intValue());
                }
                return GeneratedMessage.invokeOrDie(this.getValueDescriptorMethod, super.get(message), new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(final Builder<?> builder) {
                if (this.supportUnknownEnumValue) {
                    return this.enumDescriptor.findValueByNumberCreatingIfUnknown(((Integer) GeneratedMessage.invokeOrDie(this.getValueMethodBuilder, builder, new Object[0])).intValue());
                }
                return GeneratedMessage.invokeOrDie(this.getValueDescriptorMethod, super.get(builder), new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(final Builder<?> builder, final Object value) {
                if (this.supportUnknownEnumValue) {
                    GeneratedMessage.invokeOrDie(this.setValueMethod, builder, Integer.valueOf(((Descriptors.EnumValueDescriptor) value).getNumber()));
                } else {
                    super.set(builder, GeneratedMessage.invokeOrDie(this.valueOfMethod, null, value));
                }
            }
        }

        private static final class RepeatedEnumFieldAccessor extends RepeatedFieldAccessor {
            private java.lang.reflect.Method addRepeatedValueMethod;
            private final Descriptors.EnumDescriptor enumDescriptor;
            private java.lang.reflect.Method getRepeatedValueMethod;
            private java.lang.reflect.Method getRepeatedValueMethodBuilder;
            private final java.lang.reflect.Method getValueDescriptorMethod;
            private java.lang.reflect.Method setRepeatedValueMethod;
            private final boolean supportUnknownEnumValue;
            private final java.lang.reflect.Method valueOfMethod;

            RepeatedEnumFieldAccessor(final Descriptors.FieldDescriptor descriptor, final String camelCaseName, final Class<? extends GeneratedMessage> messageClass, final Class<? extends Builder<?>> builderClass) {
                super(descriptor, camelCaseName, messageClass, builderClass);
                this.enumDescriptor = descriptor.getEnumType();
                this.valueOfMethod = GeneratedMessage.getMethodOrDie(this.type, "valueOf", Descriptors.EnumValueDescriptor.class);
                this.getValueDescriptorMethod = GeneratedMessage.getMethodOrDie(this.type, "getValueDescriptor", new Class[0]);
                boolean zLegacyEnumFieldTreatedAsClosed = descriptor.legacyEnumFieldTreatedAsClosed();
                this.supportUnknownEnumValue = !zLegacyEnumFieldTreatedAsClosed;
                if (zLegacyEnumFieldTreatedAsClosed) {
                    return;
                }
                this.getRepeatedValueMethod = GeneratedMessage.getMethodOrDie(messageClass, "get" + camelCaseName + "Value", Integer.TYPE);
                this.getRepeatedValueMethodBuilder = GeneratedMessage.getMethodOrDie(builderClass, "get" + camelCaseName + "Value", Integer.TYPE);
                this.setRepeatedValueMethod = GeneratedMessage.getMethodOrDie(builderClass, "set" + camelCaseName + "Value", Integer.TYPE, Integer.TYPE);
                this.addRepeatedValueMethod = GeneratedMessage.getMethodOrDie(builderClass, "add" + camelCaseName + "Value", Integer.TYPE);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(final GeneratedMessage message) {
                ArrayList arrayList = new ArrayList();
                int repeatedCount = getRepeatedCount(message);
                for (int i = 0; i < repeatedCount; i++) {
                    arrayList.add(getRepeated(message, i));
                }
                return Collections.unmodifiableList(arrayList);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(final Builder<?> builder) {
                ArrayList arrayList = new ArrayList();
                int repeatedCount = getRepeatedCount(builder);
                for (int i = 0; i < repeatedCount; i++) {
                    arrayList.add(getRepeated(builder, i));
                }
                return Collections.unmodifiableList(arrayList);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(final GeneratedMessage message, final int index) {
                if (this.supportUnknownEnumValue) {
                    return this.enumDescriptor.findValueByNumberCreatingIfUnknown(((Integer) GeneratedMessage.invokeOrDie(this.getRepeatedValueMethod, message, Integer.valueOf(index))).intValue());
                }
                return GeneratedMessage.invokeOrDie(this.getValueDescriptorMethod, super.getRepeated(message, index), new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(final Builder<?> builder, final int index) {
                if (this.supportUnknownEnumValue) {
                    return this.enumDescriptor.findValueByNumberCreatingIfUnknown(((Integer) GeneratedMessage.invokeOrDie(this.getRepeatedValueMethodBuilder, builder, Integer.valueOf(index))).intValue());
                }
                return GeneratedMessage.invokeOrDie(this.getValueDescriptorMethod, super.getRepeated(builder, index), new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(final Builder<?> builder, final int index, final Object value) {
                if (this.supportUnknownEnumValue) {
                    GeneratedMessage.invokeOrDie(this.setRepeatedValueMethod, builder, Integer.valueOf(index), Integer.valueOf(((Descriptors.EnumValueDescriptor) value).getNumber()));
                } else {
                    super.setRepeated(builder, index, GeneratedMessage.invokeOrDie(this.valueOfMethod, null, value));
                }
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(final Builder<?> builder, final Object value) {
                if (this.supportUnknownEnumValue) {
                    GeneratedMessage.invokeOrDie(this.addRepeatedValueMethod, builder, Integer.valueOf(((Descriptors.EnumValueDescriptor) value).getNumber()));
                } else {
                    super.addRepeated(builder, GeneratedMessage.invokeOrDie(this.valueOfMethod, null, value));
                }
            }
        }

        private static final class SingularStringFieldAccessor extends SingularFieldAccessor {
            private final java.lang.reflect.Method getBytesMethod;
            private final java.lang.reflect.Method setBytesMethodBuilder;

            SingularStringFieldAccessor(final Descriptors.FieldDescriptor descriptor, final String camelCaseName, final Class<? extends GeneratedMessage> messageClass, final Class<? extends Builder<?>> builderClass, final String containingOneofCamelCaseName) {
                super(descriptor, camelCaseName, messageClass, builderClass, containingOneofCamelCaseName);
                this.getBytesMethod = GeneratedMessage.getMethodOrDie(messageClass, "get" + camelCaseName + "Bytes", new Class[0]);
                this.setBytesMethodBuilder = GeneratedMessage.getMethodOrDie(builderClass, "set" + camelCaseName + "Bytes", ByteString.class);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRaw(final GeneratedMessage message) {
                return GeneratedMessage.invokeOrDie(this.getBytesMethod, message, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder<?> builder, Object value) {
                if (value instanceof ByteString) {
                    GeneratedMessage.invokeOrDie(this.setBytesMethodBuilder, builder, value);
                } else {
                    super.set(builder, value);
                }
            }
        }

        private static final class SingularMessageFieldAccessor extends SingularFieldAccessor {
            private final java.lang.reflect.Method getBuilderMethodBuilder;
            private final java.lang.reflect.Method newBuilderMethod;

            SingularMessageFieldAccessor(final Descriptors.FieldDescriptor descriptor, final String camelCaseName, final Class<? extends GeneratedMessage> messageClass, final Class<? extends Builder<?>> builderClass, final String containingOneofCamelCaseName) {
                super(descriptor, camelCaseName, messageClass, builderClass, containingOneofCamelCaseName);
                this.newBuilderMethod = GeneratedMessage.getMethodOrDie(this.type, "newBuilder", new Class[0]);
                this.getBuilderMethodBuilder = GeneratedMessage.getMethodOrDie(builderClass, "get" + camelCaseName + "Builder", new Class[0]);
            }

            private Object coerceType(final Object value) {
                return this.type.isInstance(value) ? value : ((Message.Builder) GeneratedMessage.invokeOrDie(this.newBuilderMethod, null, new Object[0])).mergeFrom((Message) value).buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(final Builder<?> builder, final Object value) {
                super.set(builder, coerceType(value));
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                return (Message.Builder) GeneratedMessage.invokeOrDie(this.newBuilderMethod, null, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getBuilder(Builder<?> builder) {
                return (Message.Builder) GeneratedMessage.invokeOrDie(this.getBuilderMethodBuilder, builder, new Object[0]);
            }
        }

        private static final class RepeatedMessageFieldAccessor extends RepeatedFieldAccessor {
            private final java.lang.reflect.Method getBuilderMethodBuilder;
            private final java.lang.reflect.Method newBuilderMethod;

            RepeatedMessageFieldAccessor(final Descriptors.FieldDescriptor descriptor, final String camelCaseName, final Class<? extends GeneratedMessage> messageClass, final Class<? extends Builder<?>> builderClass) {
                super(descriptor, camelCaseName, messageClass, builderClass);
                this.newBuilderMethod = GeneratedMessage.getMethodOrDie(this.type, "newBuilder", new Class[0]);
                this.getBuilderMethodBuilder = GeneratedMessage.getMethodOrDie(builderClass, "get" + camelCaseName + "Builder", Integer.TYPE);
            }

            private Object coerceType(final Object value) {
                return this.type.isInstance(value) ? value : ((Message.Builder) GeneratedMessage.invokeOrDie(this.newBuilderMethod, null, new Object[0])).mergeFrom((Message) value).build();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(final Builder<?> builder, final int index, final Object value) {
                super.setRepeated(builder, index, coerceType(value));
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(final Builder<?> builder, final Object value) {
                super.addRepeated(builder, coerceType(value));
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                return (Message.Builder) GeneratedMessage.invokeOrDie(this.newBuilderMethod, null, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getRepeatedBuilder(final Builder<?> builder, final int index) {
                return (Message.Builder) GeneratedMessage.invokeOrDie(this.getBuilderMethodBuilder, builder, Integer.valueOf(index));
            }
        }
    }

    protected Object writeReplace() throws ObjectStreamException {
        return new GeneratedMessageLite.SerializedForm(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <MessageT extends ExtendableMessage<MessageT>, T> Extension<MessageT, T> checkNotLite(ExtensionLite<MessageT, T> extension) {
        if (extension.isLite()) {
            throw new IllegalArgumentException("Expected non-lite extension.");
        }
        return (Extension) extension;
    }

    protected static boolean isStringEmpty(final Object value) {
        if (value instanceof String) {
            return ((String) value).isEmpty();
        }
        return ((ByteString) value).isEmpty();
    }

    protected static int computeStringSize(final int fieldNumber, final Object value) {
        if (value instanceof String) {
            return CodedOutputStream.computeStringSize(fieldNumber, (String) value);
        }
        return CodedOutputStream.computeBytesSize(fieldNumber, (ByteString) value);
    }

    protected static int computeStringSizeNoTag(final Object value) {
        if (value instanceof String) {
            return CodedOutputStream.computeStringSizeNoTag((String) value);
        }
        return CodedOutputStream.computeBytesSizeNoTag((ByteString) value);
    }

    protected static void writeString(CodedOutputStream output, final int fieldNumber, final Object value) throws IOException {
        if (value instanceof String) {
            output.writeString(fieldNumber, (String) value);
        } else {
            output.writeBytes(fieldNumber, (ByteString) value);
        }
    }

    protected static void writeStringNoTag(CodedOutputStream output, final Object value) throws IOException {
        if (value instanceof String) {
            output.writeStringNoTag((String) value);
        } else {
            output.writeBytesNoTag((ByteString) value);
        }
    }

    protected static <V> void serializeIntegerMapTo(CodedOutputStream out, MapField<Integer, V> field, MapEntry<Integer, V> defaultEntry, int fieldNumber) throws IOException {
        Map<Integer, V> map = field.getMap();
        if (!out.isSerializationDeterministic()) {
            serializeMapTo(out, map, defaultEntry, fieldNumber);
            return;
        }
        int size = map.size();
        int[] iArr = new int[size];
        Iterator<Integer> it = map.keySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = it.next().intValue();
            i++;
        }
        Arrays.sort(iArr);
        for (int i2 = 0; i2 < size; i2++) {
            int i3 = iArr[i2];
            out.writeMessage(fieldNumber, defaultEntry.newBuilderForType().setKey(Integer.valueOf(i3)).setValue(map.get(Integer.valueOf(i3))).build());
        }
    }

    protected static <V> void serializeLongMapTo(CodedOutputStream out, MapField<Long, V> field, MapEntry<Long, V> defaultEntry, int fieldNumber) throws IOException {
        Map<Long, V> map = field.getMap();
        if (!out.isSerializationDeterministic()) {
            serializeMapTo(out, map, defaultEntry, fieldNumber);
            return;
        }
        int size = map.size();
        long[] jArr = new long[size];
        Iterator<Long> it = map.keySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            jArr[i] = it.next().longValue();
            i++;
        }
        Arrays.sort(jArr);
        for (int i2 = 0; i2 < size; i2++) {
            long j = jArr[i2];
            out.writeMessage(fieldNumber, defaultEntry.newBuilderForType().setKey(Long.valueOf(j)).setValue(map.get(Long.valueOf(j))).build());
        }
    }

    protected static <V> void serializeStringMapTo(CodedOutputStream out, MapField<String, V> field, MapEntry<String, V> defaultEntry, int fieldNumber) throws IOException {
        Map<String, V> map = field.getMap();
        if (!out.isSerializationDeterministic()) {
            serializeMapTo(out, map, defaultEntry, fieldNumber);
            return;
        }
        String[] strArr = (String[]) map.keySet().toArray(new String[map.size()]);
        Arrays.sort(strArr);
        for (String str : strArr) {
            out.writeMessage(fieldNumber, defaultEntry.newBuilderForType().setKey(str).setValue(map.get(str)).build());
        }
    }

    protected static <V> void serializeBooleanMapTo(CodedOutputStream out, MapField<Boolean, V> field, MapEntry<Boolean, V> defaultEntry, int fieldNumber) throws IOException {
        Map<Boolean, V> map = field.getMap();
        if (!out.isSerializationDeterministic()) {
            serializeMapTo(out, map, defaultEntry, fieldNumber);
        } else {
            maybeSerializeBooleanEntryTo(out, map, defaultEntry, fieldNumber, false);
            maybeSerializeBooleanEntryTo(out, map, defaultEntry, fieldNumber, true);
        }
    }

    private static <V> void maybeSerializeBooleanEntryTo(CodedOutputStream out, Map<Boolean, V> m, MapEntry<Boolean, V> defaultEntry, int fieldNumber, boolean key) throws IOException {
        if (m.containsKey(Boolean.valueOf(key))) {
            out.writeMessage(fieldNumber, defaultEntry.newBuilderForType().setKey(Boolean.valueOf(key)).setValue(m.get(Boolean.valueOf(key))).build());
        }
    }

    private static <K, V> void serializeMapTo(CodedOutputStream out, Map<K, V> m, MapEntry<K, V> defaultEntry, int fieldNumber) throws IOException {
        for (Map.Entry<K, V> entry : m.entrySet()) {
            out.writeMessage(fieldNumber, defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
        }
    }
}
