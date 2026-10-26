package com.google.protobuf.compiler;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.RuntimeVersion;
import com.google.protobuf.SingleFieldBuilder;
import com.google.protobuf.UninitializedMessageException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* INFO: loaded from: classes4.dex */
public final class PluginProtos {
    private static Descriptors.FileDescriptor descriptor;
    private static final Descriptors.Descriptor internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor;
    private static final GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_compiler_CodeGeneratorRequest_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor;
    private static final GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor;
    private static final GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_compiler_CodeGeneratorResponse_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_google_protobuf_compiler_Version_descriptor;
    private static final GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_compiler_Version_fieldAccessorTable;

    public interface CodeGeneratorRequestOrBuilder extends MessageOrBuilder {
        Version getCompilerVersion();

        VersionOrBuilder getCompilerVersionOrBuilder();

        String getFileToGenerate(int index);

        ByteString getFileToGenerateBytes(int index);

        int getFileToGenerateCount();

        List<String> getFileToGenerateList();

        String getParameter();

        ByteString getParameterBytes();

        DescriptorProtos.FileDescriptorProto getProtoFile(int index);

        int getProtoFileCount();

        List<DescriptorProtos.FileDescriptorProto> getProtoFileList();

        DescriptorProtos.FileDescriptorProtoOrBuilder getProtoFileOrBuilder(int index);

        List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileOrBuilderList();

        DescriptorProtos.FileDescriptorProto getSourceFileDescriptors(int index);

        int getSourceFileDescriptorsCount();

        List<DescriptorProtos.FileDescriptorProto> getSourceFileDescriptorsList();

        DescriptorProtos.FileDescriptorProtoOrBuilder getSourceFileDescriptorsOrBuilder(int index);

        List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getSourceFileDescriptorsOrBuilderList();

        boolean hasCompilerVersion();

        boolean hasParameter();
    }

    public interface CodeGeneratorResponseOrBuilder extends MessageOrBuilder {
        String getError();

        ByteString getErrorBytes();

        CodeGeneratorResponse.File getFile(int index);

        int getFileCount();

        List<CodeGeneratorResponse.File> getFileList();

        CodeGeneratorResponse.FileOrBuilder getFileOrBuilder(int index);

        List<? extends CodeGeneratorResponse.FileOrBuilder> getFileOrBuilderList();

        int getMaximumEdition();

        int getMinimumEdition();

        long getSupportedFeatures();

        boolean hasError();

        boolean hasMaximumEdition();

        boolean hasMinimumEdition();

        boolean hasSupportedFeatures();
    }

    public interface VersionOrBuilder extends MessageOrBuilder {
        int getMajor();

        int getMinor();

        int getPatch();

        String getSuffix();

        ByteString getSuffixBytes();

        boolean hasMajor();

        boolean hasMinor();

        boolean hasPatch();

        boolean hasSuffix();
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private PluginProtos() {
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", PluginProtos.class.getName());
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n%google/protobuf/compiler/plugin.proto\u0012\u0018google.protobuf.compiler\u001a google/protobuf/descriptor.proto\"c\n\u0007Version\u0012\u0014\n\u0005major\u0018\u0001 \u0001(\u0005R\u0005major\u0012\u0014\n\u0005minor\u0018\u0002 \u0001(\u0005R\u0005minor\u0012\u0014\n\u0005patch\u0018\u0003 \u0001(\u0005R\u0005patch\u0012\u0016\n\u0006suffix\u0018\u0004 \u0001(\tR\u0006suffix\"Ï\u0002\n\u0014CodeGeneratorRequest\u0012(\n\u0010file_to_generate\u0018\u0001 \u0003(\tR\u000efileToGenerate\u0012\u001c\n\tparameter\u0018\u0002 \u0001(\tR\tparameter\u0012C\n\nproto_file\u0018\u000f \u0003(\u000b2$.google.protobuf.FileDescriptorProtoR\tprotoFile\u0012\\\n\u0017source_file_descriptors\u0018\u0011 \u0003(\u000b2$.google.protobuf.FileDescriptorProtoR\u0015sourceFileDescriptors\u0012L\n\u0010compiler_version\u0018\u0003 \u0001(\u000b2!.google.protobuf.compiler.VersionR\u000fcompilerVersion\"\u0085\u0004\n\u0015CodeGeneratorResponse\u0012\u0014\n\u0005error\u0018\u0001 \u0001(\tR\u0005error\u0012-\n\u0012supported_features\u0018\u0002 \u0001(\u0004R\u0011supportedFeatures\u0012'\n\u000fminimum_edition\u0018\u0003 \u0001(\u0005R\u000eminimumEdition\u0012'\n\u000fmaximum_edition\u0018\u0004 \u0001(\u0005R\u000emaximumEdition\u0012H\n\u0004file\u0018\u000f \u0003(\u000b24.google.protobuf.compiler.CodeGeneratorResponse.FileR\u0004file\u001a±\u0001\n\u0004File\u0012\u0012\n\u0004name\u0018\u0001 \u0001(\tR\u0004name\u0012'\n\u000finsertion_point\u0018\u0002 \u0001(\tR\u000einsertionPoint\u0012\u0018\n\u0007content\u0018\u000f \u0001(\tR\u0007content\u0012R\n\u0013generated_code_info\u0018\u0010 \u0001(\u000b2\".google.protobuf.GeneratedCodeInfoR\u0011generatedCodeInfo\"W\n\u0007Feature\u0012\u0010\n\fFEATURE_NONE\u0010\u0000\u0012\u001b\n\u0017FEATURE_PROTO3_OPTIONAL\u0010\u0001\u0012\u001d\n\u0019FEATURE_SUPPORTS_EDITIONS\u0010\u0002Br\n\u001ccom.google.protobuf.compilerB\fPluginProtosZ)google.golang.org/protobuf/types/pluginpbª\u0002\u0018Google.Protobuf.Compiler"}, new Descriptors.FileDescriptor[]{DescriptorProtos.getDescriptor()});
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_google_protobuf_compiler_Version_descriptor = descriptor2;
        internal_static_google_protobuf_compiler_Version_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(descriptor2, new String[]{"Major", "Minor", "Patch", "Suffix"});
        Descriptors.Descriptor descriptor3 = getDescriptor().getMessageTypes().get(1);
        internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor = descriptor3;
        internal_static_google_protobuf_compiler_CodeGeneratorRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(descriptor3, new String[]{"FileToGenerate", "Parameter", "ProtoFile", "SourceFileDescriptors", "CompilerVersion"});
        Descriptors.Descriptor descriptor4 = getDescriptor().getMessageTypes().get(2);
        internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor = descriptor4;
        internal_static_google_protobuf_compiler_CodeGeneratorResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(descriptor4, new String[]{"Error", "SupportedFeatures", "MinimumEdition", "MaximumEdition", "File"});
        Descriptors.Descriptor descriptor5 = descriptor4.getNestedTypes().get(0);
        internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor = descriptor5;
        internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(descriptor5, new String[]{"Name", "InsertionPoint", "Content", "GeneratedCodeInfo"});
        descriptor.resolveAllFeaturesImmutable();
        DescriptorProtos.getDescriptor();
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    public static final class Version extends GeneratedMessage implements VersionOrBuilder {
        private static final Version DEFAULT_INSTANCE;
        public static final int MAJOR_FIELD_NUMBER = 1;
        public static final int MINOR_FIELD_NUMBER = 2;
        private static final Parser<Version> PARSER;
        public static final int PATCH_FIELD_NUMBER = 3;
        public static final int SUFFIX_FIELD_NUMBER = 4;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int major_;
        private byte memoizedIsInitialized;
        private int minor_;
        private int patch_;
        private volatile Object suffix_;

        /* synthetic */ Version(GeneratedMessage.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        static /* synthetic */ int access$976(Version version, int i) {
            int i2 = i | version.bitField0_;
            version.bitField0_ = i2;
            return i2;
        }

        static {
            RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", Version.class.getName());
            DEFAULT_INSTANCE = new Version();
            PARSER = new AnonymousClass1();
        }

        private Version(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.major_ = 0;
            this.minor_ = 0;
            this.patch_ = 0;
            this.suffix_ = "";
            this.memoizedIsInitialized = (byte) -1;
        }

        private Version() {
            this.major_ = 0;
            this.minor_ = 0;
            this.patch_ = 0;
            this.suffix_ = "";
            this.memoizedIsInitialized = (byte) -1;
            this.suffix_ = "";
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PluginProtos.internal_static_google_protobuf_compiler_Version_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PluginProtos.internal_static_google_protobuf_compiler_Version_fieldAccessorTable.ensureFieldAccessorsInitialized(Version.class, Builder.class);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public boolean hasMajor() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public int getMajor() {
            return this.major_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public boolean hasMinor() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public int getMinor() {
            return this.minor_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public boolean hasPatch() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public int getPatch() {
            return this.patch_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public boolean hasSuffix() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public String getSuffix() {
            Object obj = this.suffix_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.suffix_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public ByteString getSuffixBytes() {
            Object obj = this.suffix_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.suffix_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream output) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                output.writeInt32(1, this.major_);
            }
            if ((this.bitField0_ & 2) != 0) {
                output.writeInt32(2, this.minor_);
            }
            if ((this.bitField0_ & 4) != 0) {
                output.writeInt32(3, this.patch_);
            }
            if ((this.bitField0_ & 8) != 0) {
                GeneratedMessage.writeString(output, 4, this.suffix_);
            }
            getUnknownFields().writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int iComputeInt32Size = (this.bitField0_ & 1) != 0 ? CodedOutputStream.computeInt32Size(1, this.major_) : 0;
            if ((this.bitField0_ & 2) != 0) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.minor_);
            }
            if ((this.bitField0_ & 4) != 0) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(3, this.patch_);
            }
            if ((this.bitField0_ & 8) != 0) {
                iComputeInt32Size += GeneratedMessage.computeStringSize(4, this.suffix_);
            }
            int serializedSize = iComputeInt32Size + getUnknownFields().getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(final Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Version)) {
                return super.equals(obj);
            }
            Version version = (Version) obj;
            if (hasMajor() != version.hasMajor()) {
                return false;
            }
            if ((hasMajor() && getMajor() != version.getMajor()) || hasMinor() != version.hasMinor()) {
                return false;
            }
            if ((hasMinor() && getMinor() != version.getMinor()) || hasPatch() != version.hasPatch()) {
                return false;
            }
            if ((!hasPatch() || getPatch() == version.getPatch()) && hasSuffix() == version.hasSuffix()) {
                return (!hasSuffix() || getSuffix().equals(version.getSuffix())) && getUnknownFields().equals(version.getUnknownFields());
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = 779 + getDescriptor().hashCode();
            if (hasMajor()) {
                iHashCode = (((iHashCode * 37) + 1) * 53) + getMajor();
            }
            if (hasMinor()) {
                iHashCode = (((iHashCode * 37) + 2) * 53) + getMinor();
            }
            if (hasPatch()) {
                iHashCode = (((iHashCode * 37) + 3) * 53) + getPatch();
            }
            if (hasSuffix()) {
                iHashCode = (((iHashCode * 37) + 4) * 53) + getSuffix().hashCode();
            }
            int iHashCode2 = (iHashCode * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = iHashCode2;
            return iHashCode2;
        }

        public static Version parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Version parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Version parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Version parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Version parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Version parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Version parseFrom(InputStream input) throws IOException {
            return (Version) GeneratedMessage.parseWithIOException(PARSER, input);
        }

        public static Version parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Version) GeneratedMessage.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static Version parseDelimitedFrom(InputStream input) throws IOException {
            return (Version) GeneratedMessage.parseDelimitedWithIOException(PARSER, input);
        }

        public static Version parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Version) GeneratedMessage.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static Version parseFrom(CodedInputStream input) throws IOException {
            return (Version) GeneratedMessage.parseWithIOException(PARSER, input);
        }

        public static Version parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Version) GeneratedMessage.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Version prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder((AnonymousClass1) null) : new Builder((AnonymousClass1) null).mergeFrom(this);
        }

        /* INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.AbstractMessage
        public Builder newBuilderForType(AbstractMessage.BuilderParent parent) {
            return new Builder(parent, null);
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements VersionOrBuilder {
            private int bitField0_;
            private int major_;
            private int minor_;
            private int patch_;
            private Object suffix_;

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, AnonymousClass1 anonymousClass1) {
                this(builderParent);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return PluginProtos.internal_static_google_protobuf_compiler_Version_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder
            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PluginProtos.internal_static_google_protobuf_compiler_Version_fieldAccessorTable.ensureFieldAccessorsInitialized(Version.class, Builder.class);
            }

            private Builder() {
                this.suffix_ = "";
            }

            private Builder(AbstractMessage.BuilderParent parent) {
                super(parent);
                this.suffix_ = "";
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.major_ = 0;
                this.minor_ = 0;
                this.patch_ = 0;
                this.suffix_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PluginProtos.internal_static_google_protobuf_compiler_Version_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Version getDefaultInstanceForType() {
                return Version.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Version build() {
                Version versionBuildPartial = buildPartial();
                if (versionBuildPartial.isInitialized()) {
                    return versionBuildPartial;
                }
                throw newUninitializedMessageException((Message) versionBuildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Version buildPartial() {
                Version version = new Version(this, null);
                if (this.bitField0_ != 0) {
                    buildPartial0(version);
                }
                onBuilt();
                return version;
            }

            private void buildPartial0(Version result) {
                int i;
                int i2 = this.bitField0_;
                if ((i2 & 1) != 0) {
                    result.major_ = this.major_;
                    i = 1;
                } else {
                    i = 0;
                }
                if ((i2 & 2) != 0) {
                    result.minor_ = this.minor_;
                    i |= 2;
                }
                if ((i2 & 4) != 0) {
                    result.patch_ = this.patch_;
                    i |= 4;
                }
                if ((i2 & 8) != 0) {
                    result.suffix_ = this.suffix_;
                    i |= 8;
                }
                Version.access$976(result, i);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message other) {
                if (other instanceof Version) {
                    return mergeFrom((Version) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Version other) {
                if (other == Version.getDefaultInstance()) {
                    return this;
                }
                if (other.hasMajor()) {
                    setMajor(other.getMajor());
                }
                if (other.hasMinor()) {
                    setMinor(other.getMinor());
                }
                if (other.hasPatch()) {
                    setPatch(other.getPatch());
                }
                if (other.hasSuffix()) {
                    this.suffix_ = other.suffix_;
                    this.bitField0_ |= 8;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                extensionRegistry.getClass();
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int tag = input.readTag();
                            if (tag != 0) {
                                if (tag == 8) {
                                    this.major_ = input.readInt32();
                                    this.bitField0_ |= 1;
                                } else if (tag == 16) {
                                    this.minor_ = input.readInt32();
                                    this.bitField0_ |= 2;
                                } else if (tag == 24) {
                                    this.patch_ = input.readInt32();
                                    this.bitField0_ |= 4;
                                } else if (tag == 34) {
                                    this.suffix_ = input.readBytes();
                                    this.bitField0_ |= 8;
                                } else if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw e.unwrapIOException();
                        }
                    } catch (Throwable th) {
                        onChanged();
                        throw th;
                    }
                }
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public boolean hasMajor() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public int getMajor() {
                return this.major_;
            }

            public Builder setMajor(int value) {
                this.major_ = value;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder clearMajor() {
                this.bitField0_ &= -2;
                this.major_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public boolean hasMinor() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public int getMinor() {
                return this.minor_;
            }

            public Builder setMinor(int value) {
                this.minor_ = value;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder clearMinor() {
                this.bitField0_ &= -3;
                this.minor_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public boolean hasPatch() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public int getPatch() {
                return this.patch_;
            }

            public Builder setPatch(int value) {
                this.patch_ = value;
                this.bitField0_ |= 4;
                onChanged();
                return this;
            }

            public Builder clearPatch() {
                this.bitField0_ &= -5;
                this.patch_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public boolean hasSuffix() {
                return (this.bitField0_ & 8) != 0;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public String getSuffix() {
                Object obj = this.suffix_;
                if (!(obj instanceof String)) {
                    ByteString byteString = (ByteString) obj;
                    String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.suffix_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public ByteString getSuffixBytes() {
                Object obj = this.suffix_;
                if (obj instanceof String) {
                    ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.suffix_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setSuffix(String value) {
                value.getClass();
                this.suffix_ = value;
                this.bitField0_ |= 8;
                onChanged();
                return this;
            }

            public Builder clearSuffix() {
                this.suffix_ = Version.getDefaultInstance().getSuffix();
                this.bitField0_ &= -9;
                onChanged();
                return this;
            }

            public Builder setSuffixBytes(ByteString value) {
                value.getClass();
                this.suffix_ = value;
                this.bitField0_ |= 8;
                onChanged();
                return this;
            }
        }

        public static Version getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* INFO: renamed from: com.google.protobuf.compiler.PluginProtos$Version$1, reason: invalid class name */
        class AnonymousClass1 extends AbstractParser<Version> {
            AnonymousClass1() {
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseDelimitedFrom(InputStream input) throws InvalidProtocolBufferException {
                return super.parseDelimitedFrom(input);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.parseDelimitedFrom(input, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return super.parseFrom(data);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.parseFrom(data, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(CodedInputStream input) throws InvalidProtocolBufferException {
                return super.parseFrom(input);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.parseFrom(input, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(InputStream input) throws InvalidProtocolBufferException {
                return super.parseFrom(input);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.parseFrom(input, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
                return super.parseFrom(data);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.parseFrom(data, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return super.parseFrom(data);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(byte[] data, int off, int len) throws InvalidProtocolBufferException {
                return super.parseFrom(data, off, len);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(byte[] data, int off, int len, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.parseFrom(data, off, len, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.parseFrom(data, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialDelimitedFrom(InputStream input) throws InvalidProtocolBufferException {
                return super.parsePartialDelimitedFrom(input);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.parsePartialDelimitedFrom(input, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(ByteString data) throws InvalidProtocolBufferException {
                return super.parsePartialFrom(data);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.parsePartialFrom(data, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream input) throws InvalidProtocolBufferException {
                return super.parsePartialFrom(input);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(InputStream input) throws InvalidProtocolBufferException {
                return super.parsePartialFrom(input);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.parsePartialFrom(input, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] data) throws InvalidProtocolBufferException {
                return super.parsePartialFrom(data);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] data, int off, int len) throws InvalidProtocolBufferException {
                return super.parsePartialFrom(data, off, len);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] data, int off, int len, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.parsePartialFrom(data, off, len, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.parsePartialFrom(data, extensionRegistry);
            }

            @Override // com.google.protobuf.Parser
            public Version parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                Builder builderNewBuilder = Version.newBuilder();
                try {
                    builderNewBuilder.mergeFrom(input, extensionRegistry);
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

        public static Parser<Version> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Version> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Version getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class CodeGeneratorRequest extends GeneratedMessage implements CodeGeneratorRequestOrBuilder {
        public static final int COMPILER_VERSION_FIELD_NUMBER = 3;
        private static final CodeGeneratorRequest DEFAULT_INSTANCE;
        public static final int FILE_TO_GENERATE_FIELD_NUMBER = 1;
        public static final int PARAMETER_FIELD_NUMBER = 2;
        private static final Parser<CodeGeneratorRequest> PARSER;
        public static final int PROTO_FILE_FIELD_NUMBER = 15;
        public static final int SOURCE_FILE_DESCRIPTORS_FIELD_NUMBER = 17;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private Version compilerVersion_;
        private LazyStringArrayList fileToGenerate_;
        private byte memoizedIsInitialized;
        private volatile Object parameter_;
        private List<DescriptorProtos.FileDescriptorProto> protoFile_;
        private List<DescriptorProtos.FileDescriptorProto> sourceFileDescriptors_;

        /* synthetic */ CodeGeneratorRequest(GeneratedMessage.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        static /* synthetic */ int access$2176(CodeGeneratorRequest codeGeneratorRequest, int i) {
            int i2 = i | codeGeneratorRequest.bitField0_;
            codeGeneratorRequest.bitField0_ = i2;
            return i2;
        }

        static {
            RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", CodeGeneratorRequest.class.getName());
            DEFAULT_INSTANCE = new CodeGeneratorRequest();
            PARSER = new AnonymousClass1();
        }

        private CodeGeneratorRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.fileToGenerate_ = LazyStringArrayList.emptyList();
            this.parameter_ = "";
            this.memoizedIsInitialized = (byte) -1;
        }

        private CodeGeneratorRequest() {
            this.fileToGenerate_ = LazyStringArrayList.emptyList();
            this.parameter_ = "";
            this.memoizedIsInitialized = (byte) -1;
            this.fileToGenerate_ = LazyStringArrayList.emptyList();
            this.parameter_ = "";
            this.protoFile_ = Collections.emptyList();
            this.sourceFileDescriptors_ = Collections.emptyList();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(CodeGeneratorRequest.class, Builder.class);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public ProtocolStringList getFileToGenerateList() {
            return this.fileToGenerate_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public int getFileToGenerateCount() {
            return this.fileToGenerate_.size();
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public String getFileToGenerate(int index) {
            return this.fileToGenerate_.get(index);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public ByteString getFileToGenerateBytes(int index) {
            return this.fileToGenerate_.getByteString(index);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public boolean hasParameter() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public String getParameter() {
            Object obj = this.parameter_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.parameter_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public ByteString getParameterBytes() {
            Object obj = this.parameter_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.parameter_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public List<DescriptorProtos.FileDescriptorProto> getProtoFileList() {
            return this.protoFile_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileOrBuilderList() {
            return this.protoFile_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public int getProtoFileCount() {
            return this.protoFile_.size();
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public DescriptorProtos.FileDescriptorProto getProtoFile(int index) {
            return this.protoFile_.get(index);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public DescriptorProtos.FileDescriptorProtoOrBuilder getProtoFileOrBuilder(int index) {
            return this.protoFile_.get(index);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public List<DescriptorProtos.FileDescriptorProto> getSourceFileDescriptorsList() {
            return this.sourceFileDescriptors_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getSourceFileDescriptorsOrBuilderList() {
            return this.sourceFileDescriptors_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public int getSourceFileDescriptorsCount() {
            return this.sourceFileDescriptors_.size();
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public DescriptorProtos.FileDescriptorProto getSourceFileDescriptors(int index) {
            return this.sourceFileDescriptors_.get(index);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public DescriptorProtos.FileDescriptorProtoOrBuilder getSourceFileDescriptorsOrBuilder(int index) {
            return this.sourceFileDescriptors_.get(index);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public boolean hasCompilerVersion() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public Version getCompilerVersion() {
            Version version = this.compilerVersion_;
            return version == null ? Version.getDefaultInstance() : version;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public VersionOrBuilder getCompilerVersionOrBuilder() {
            Version version = this.compilerVersion_;
            return version == null ? Version.getDefaultInstance() : version;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            for (int i = 0; i < getProtoFileCount(); i++) {
                if (!getProtoFile(i).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i2 = 0; i2 < getSourceFileDescriptorsCount(); i2++) {
                if (!getSourceFileDescriptors(i2).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream output) throws IOException {
            for (int i = 0; i < this.fileToGenerate_.size(); i++) {
                GeneratedMessage.writeString(output, 1, this.fileToGenerate_.getRaw(i));
            }
            if ((this.bitField0_ & 1) != 0) {
                GeneratedMessage.writeString(output, 2, this.parameter_);
            }
            if ((this.bitField0_ & 2) != 0) {
                output.writeMessage(3, getCompilerVersion());
            }
            for (int i2 = 0; i2 < this.protoFile_.size(); i2++) {
                output.writeMessage(15, this.protoFile_.get(i2));
            }
            for (int i3 = 0; i3 < this.sourceFileDescriptors_.size(); i3++) {
                output.writeMessage(17, this.sourceFileDescriptors_.get(i3));
            }
            getUnknownFields().writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int iComputeStringSizeNoTag = 0;
            for (int i2 = 0; i2 < this.fileToGenerate_.size(); i2++) {
                iComputeStringSizeNoTag += computeStringSizeNoTag(this.fileToGenerate_.getRaw(i2));
            }
            int size = iComputeStringSizeNoTag + getFileToGenerateList().size();
            if ((this.bitField0_ & 1) != 0) {
                size += GeneratedMessage.computeStringSize(2, this.parameter_);
            }
            if ((this.bitField0_ & 2) != 0) {
                size += CodedOutputStream.computeMessageSize(3, getCompilerVersion());
            }
            for (int i3 = 0; i3 < this.protoFile_.size(); i3++) {
                size += CodedOutputStream.computeMessageSize(15, this.protoFile_.get(i3));
            }
            for (int i4 = 0; i4 < this.sourceFileDescriptors_.size(); i4++) {
                size += CodedOutputStream.computeMessageSize(17, this.sourceFileDescriptors_.get(i4));
            }
            int serializedSize = size + getUnknownFields().getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(final Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CodeGeneratorRequest)) {
                return super.equals(obj);
            }
            CodeGeneratorRequest codeGeneratorRequest = (CodeGeneratorRequest) obj;
            if (!getFileToGenerateList().equals(codeGeneratorRequest.getFileToGenerateList()) || hasParameter() != codeGeneratorRequest.hasParameter()) {
                return false;
            }
            if ((!hasParameter() || getParameter().equals(codeGeneratorRequest.getParameter())) && getProtoFileList().equals(codeGeneratorRequest.getProtoFileList()) && getSourceFileDescriptorsList().equals(codeGeneratorRequest.getSourceFileDescriptorsList()) && hasCompilerVersion() == codeGeneratorRequest.hasCompilerVersion()) {
                return (!hasCompilerVersion() || getCompilerVersion().equals(codeGeneratorRequest.getCompilerVersion())) && getUnknownFields().equals(codeGeneratorRequest.getUnknownFields());
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = 779 + getDescriptor().hashCode();
            if (getFileToGenerateCount() > 0) {
                iHashCode = (((iHashCode * 37) + 1) * 53) + getFileToGenerateList().hashCode();
            }
            if (hasParameter()) {
                iHashCode = (((iHashCode * 37) + 2) * 53) + getParameter().hashCode();
            }
            if (getProtoFileCount() > 0) {
                iHashCode = (((iHashCode * 37) + 15) * 53) + getProtoFileList().hashCode();
            }
            if (getSourceFileDescriptorsCount() > 0) {
                iHashCode = (((iHashCode * 37) + 17) * 53) + getSourceFileDescriptorsList().hashCode();
            }
            if (hasCompilerVersion()) {
                iHashCode = (((iHashCode * 37) + 3) * 53) + getCompilerVersion().hashCode();
            }
            int iHashCode2 = (iHashCode * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = iHashCode2;
            return iHashCode2;
        }

        public static CodeGeneratorRequest parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CodeGeneratorRequest parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CodeGeneratorRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CodeGeneratorRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CodeGeneratorRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CodeGeneratorRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CodeGeneratorRequest parseFrom(InputStream input) throws IOException {
            return (CodeGeneratorRequest) GeneratedMessage.parseWithIOException(PARSER, input);
        }

        public static CodeGeneratorRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CodeGeneratorRequest) GeneratedMessage.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CodeGeneratorRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (CodeGeneratorRequest) GeneratedMessage.parseDelimitedWithIOException(PARSER, input);
        }

        public static CodeGeneratorRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CodeGeneratorRequest) GeneratedMessage.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CodeGeneratorRequest parseFrom(CodedInputStream input) throws IOException {
            return (CodeGeneratorRequest) GeneratedMessage.parseWithIOException(PARSER, input);
        }

        public static CodeGeneratorRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CodeGeneratorRequest) GeneratedMessage.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CodeGeneratorRequest prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder((AnonymousClass1) null) : new Builder((AnonymousClass1) null).mergeFrom(this);
        }

        /* INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.AbstractMessage
        public Builder newBuilderForType(AbstractMessage.BuilderParent parent) {
            return new Builder(parent, null);
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements CodeGeneratorRequestOrBuilder {
            private int bitField0_;
            private SingleFieldBuilder<Version, Version.Builder, VersionOrBuilder> compilerVersionBuilder_;
            private Version compilerVersion_;
            private LazyStringArrayList fileToGenerate_;
            private Object parameter_;
            private RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> protoFileBuilder_;
            private List<DescriptorProtos.FileDescriptorProto> protoFile_;
            private RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> sourceFileDescriptorsBuilder_;
            private List<DescriptorProtos.FileDescriptorProto> sourceFileDescriptors_;

            /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, AnonymousClass1 anonymousClass1) {
                this(builderParent);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder
            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(CodeGeneratorRequest.class, Builder.class);
            }

            private Builder() {
                this.fileToGenerate_ = LazyStringArrayList.emptyList();
                this.parameter_ = "";
                this.protoFile_ = Collections.emptyList();
                this.sourceFileDescriptors_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(AbstractMessage.BuilderParent parent) {
                super(parent);
                this.fileToGenerate_ = LazyStringArrayList.emptyList();
                this.parameter_ = "";
                this.protoFile_ = Collections.emptyList();
                this.sourceFileDescriptors_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CodeGeneratorRequest.alwaysUseFieldBuilders) {
                    getProtoFileFieldBuilder();
                    getSourceFileDescriptorsFieldBuilder();
                    getCompilerVersionFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.fileToGenerate_ = LazyStringArrayList.emptyList();
                this.parameter_ = "";
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilder = this.protoFileBuilder_;
                if (repeatedFieldBuilder == null) {
                    this.protoFile_ = Collections.emptyList();
                } else {
                    this.protoFile_ = null;
                    repeatedFieldBuilder.clear();
                }
                this.bitField0_ &= -5;
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilder2 = this.sourceFileDescriptorsBuilder_;
                if (repeatedFieldBuilder2 == null) {
                    this.sourceFileDescriptors_ = Collections.emptyList();
                } else {
                    this.sourceFileDescriptors_ = null;
                    repeatedFieldBuilder2.clear();
                }
                this.bitField0_ &= -9;
                this.compilerVersion_ = null;
                SingleFieldBuilder<Version, Version.Builder, VersionOrBuilder> singleFieldBuilder = this.compilerVersionBuilder_;
                if (singleFieldBuilder != null) {
                    singleFieldBuilder.dispose();
                    this.compilerVersionBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CodeGeneratorRequest getDefaultInstanceForType() {
                return CodeGeneratorRequest.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CodeGeneratorRequest build() {
                CodeGeneratorRequest codeGeneratorRequestBuildPartial = buildPartial();
                if (codeGeneratorRequestBuildPartial.isInitialized()) {
                    return codeGeneratorRequestBuildPartial;
                }
                throw newUninitializedMessageException((Message) codeGeneratorRequestBuildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CodeGeneratorRequest buildPartial() {
                CodeGeneratorRequest codeGeneratorRequest = new CodeGeneratorRequest(this, null);
                buildPartialRepeatedFields(codeGeneratorRequest);
                if (this.bitField0_ != 0) {
                    buildPartial0(codeGeneratorRequest);
                }
                onBuilt();
                return codeGeneratorRequest;
            }

            private void buildPartialRepeatedFields(CodeGeneratorRequest result) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilder = this.protoFileBuilder_;
                if (repeatedFieldBuilder != null) {
                    result.protoFile_ = repeatedFieldBuilder.build();
                } else {
                    if ((this.bitField0_ & 4) != 0) {
                        this.protoFile_ = Collections.unmodifiableList(this.protoFile_);
                        this.bitField0_ &= -5;
                    }
                    result.protoFile_ = this.protoFile_;
                }
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilder2 = this.sourceFileDescriptorsBuilder_;
                if (repeatedFieldBuilder2 != null) {
                    result.sourceFileDescriptors_ = repeatedFieldBuilder2.build();
                    return;
                }
                if ((this.bitField0_ & 8) != 0) {
                    this.sourceFileDescriptors_ = Collections.unmodifiableList(this.sourceFileDescriptors_);
                    this.bitField0_ &= -9;
                }
                result.sourceFileDescriptors_ = this.sourceFileDescriptors_;
            }

            private void buildPartial0(CodeGeneratorRequest result) {
                int i;
                Version version;
                int i2 = this.bitField0_;
                if ((i2 & 1) != 0) {
                    this.fileToGenerate_.makeImmutable();
                    result.fileToGenerate_ = this.fileToGenerate_;
                }
                if ((i2 & 2) != 0) {
                    result.parameter_ = this.parameter_;
                    i = 1;
                } else {
                    i = 0;
                }
                if ((i2 & 16) != 0) {
                    SingleFieldBuilder<Version, Version.Builder, VersionOrBuilder> singleFieldBuilder = this.compilerVersionBuilder_;
                    if (singleFieldBuilder == null) {
                        version = this.compilerVersion_;
                    } else {
                        version = (Version) singleFieldBuilder.build();
                    }
                    result.compilerVersion_ = version;
                    i |= 2;
                }
                CodeGeneratorRequest.access$2176(result, i);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message other) {
                if (other instanceof CodeGeneratorRequest) {
                    return mergeFrom((CodeGeneratorRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CodeGeneratorRequest other) {
                if (other == CodeGeneratorRequest.getDefaultInstance()) {
                    return this;
                }
                if (!other.fileToGenerate_.isEmpty()) {
                    if (this.fileToGenerate_.isEmpty()) {
                        this.fileToGenerate_ = other.fileToGenerate_;
                        this.bitField0_ |= 1;
                    } else {
                        ensureFileToGenerateIsMutable();
                        this.fileToGenerate_.addAll(other.fileToGenerate_);
                    }
                    onChanged();
                }
                if (other.hasParameter()) {
                    this.parameter_ = other.parameter_;
                    this.bitField0_ |= 2;
                    onChanged();
                }
                if (this.protoFileBuilder_ == null) {
                    if (!other.protoFile_.isEmpty()) {
                        if (this.protoFile_.isEmpty()) {
                            this.protoFile_ = other.protoFile_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureProtoFileIsMutable();
                            this.protoFile_.addAll(other.protoFile_);
                        }
                        onChanged();
                    }
                } else if (!other.protoFile_.isEmpty()) {
                    if (!this.protoFileBuilder_.isEmpty()) {
                        this.protoFileBuilder_.addAllMessages(other.protoFile_);
                    } else {
                        this.protoFileBuilder_.dispose();
                        this.protoFileBuilder_ = null;
                        this.protoFile_ = other.protoFile_;
                        this.bitField0_ &= -5;
                        this.protoFileBuilder_ = CodeGeneratorRequest.alwaysUseFieldBuilders ? getProtoFileFieldBuilder() : null;
                    }
                }
                if (this.sourceFileDescriptorsBuilder_ == null) {
                    if (!other.sourceFileDescriptors_.isEmpty()) {
                        if (this.sourceFileDescriptors_.isEmpty()) {
                            this.sourceFileDescriptors_ = other.sourceFileDescriptors_;
                            this.bitField0_ &= -9;
                        } else {
                            ensureSourceFileDescriptorsIsMutable();
                            this.sourceFileDescriptors_.addAll(other.sourceFileDescriptors_);
                        }
                        onChanged();
                    }
                } else if (!other.sourceFileDescriptors_.isEmpty()) {
                    if (!this.sourceFileDescriptorsBuilder_.isEmpty()) {
                        this.sourceFileDescriptorsBuilder_.addAllMessages(other.sourceFileDescriptors_);
                    } else {
                        this.sourceFileDescriptorsBuilder_.dispose();
                        this.sourceFileDescriptorsBuilder_ = null;
                        this.sourceFileDescriptors_ = other.sourceFileDescriptors_;
                        this.bitField0_ &= -9;
                        this.sourceFileDescriptorsBuilder_ = CodeGeneratorRequest.alwaysUseFieldBuilders ? getSourceFileDescriptorsFieldBuilder() : null;
                    }
                }
                if (other.hasCompilerVersion()) {
                    mergeCompilerVersion(other.getCompilerVersion());
                }
                mergeUnknownFields(other.getUnknownFields());
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                for (int i = 0; i < getProtoFileCount(); i++) {
                    if (!getProtoFile(i).isInitialized()) {
                        return false;
                    }
                }
                for (int i2 = 0; i2 < getSourceFileDescriptorsCount(); i2++) {
                    if (!getSourceFileDescriptors(i2).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                extensionRegistry.getClass();
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int tag = input.readTag();
                            if (tag != 0) {
                                if (tag == 10) {
                                    ByteString bytes = input.readBytes();
                                    ensureFileToGenerateIsMutable();
                                    this.fileToGenerate_.add(bytes);
                                } else if (tag == 18) {
                                    this.parameter_ = input.readBytes();
                                    this.bitField0_ |= 2;
                                } else if (tag == 26) {
                                    input.readMessage(getCompilerVersionFieldBuilder().getBuilder(), extensionRegistry);
                                    this.bitField0_ |= 16;
                                } else if (tag == 122) {
                                    DescriptorProtos.FileDescriptorProto fileDescriptorProto = (DescriptorProtos.FileDescriptorProto) input.readMessage(DescriptorProtos.FileDescriptorProto.parser(), extensionRegistry);
                                    RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilder = this.protoFileBuilder_;
                                    if (repeatedFieldBuilder == null) {
                                        ensureProtoFileIsMutable();
                                        this.protoFile_.add(fileDescriptorProto);
                                    } else {
                                        repeatedFieldBuilder.addMessage(fileDescriptorProto);
                                    }
                                } else if (tag == 138) {
                                    DescriptorProtos.FileDescriptorProto fileDescriptorProto2 = (DescriptorProtos.FileDescriptorProto) input.readMessage(DescriptorProtos.FileDescriptorProto.parser(), extensionRegistry);
                                    RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilder2 = this.sourceFileDescriptorsBuilder_;
                                    if (repeatedFieldBuilder2 == null) {
                                        ensureSourceFileDescriptorsIsMutable();
                                        this.sourceFileDescriptors_.add(fileDescriptorProto2);
                                    } else {
                                        repeatedFieldBuilder2.addMessage(fileDescriptorProto2);
                                    }
                                } else if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw e.unwrapIOException();
                        }
                    } catch (Throwable th) {
                        onChanged();
                        throw th;
                    }
                }
                onChanged();
                return this;
            }

            private void ensureFileToGenerateIsMutable() {
                if (!this.fileToGenerate_.isModifiable()) {
                    this.fileToGenerate_ = new LazyStringArrayList((LazyStringList) this.fileToGenerate_);
                }
                this.bitField0_ |= 1;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public ProtocolStringList getFileToGenerateList() {
                this.fileToGenerate_.makeImmutable();
                return this.fileToGenerate_;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public int getFileToGenerateCount() {
                return this.fileToGenerate_.size();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public String getFileToGenerate(int index) {
                return this.fileToGenerate_.get(index);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public ByteString getFileToGenerateBytes(int index) {
                return this.fileToGenerate_.getByteString(index);
            }

            public Builder setFileToGenerate(int index, String value) {
                value.getClass();
                ensureFileToGenerateIsMutable();
                this.fileToGenerate_.set(index, value);
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder addFileToGenerate(String value) {
                value.getClass();
                ensureFileToGenerateIsMutable();
                this.fileToGenerate_.add(value);
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder addAllFileToGenerate(Iterable<String> values) {
                ensureFileToGenerateIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.fileToGenerate_);
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder clearFileToGenerate() {
                this.fileToGenerate_ = LazyStringArrayList.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            public Builder addFileToGenerateBytes(ByteString value) {
                value.getClass();
                ensureFileToGenerateIsMutable();
                this.fileToGenerate_.add(value);
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public boolean hasParameter() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public String getParameter() {
                Object obj = this.parameter_;
                if (!(obj instanceof String)) {
                    ByteString byteString = (ByteString) obj;
                    String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.parameter_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public ByteString getParameterBytes() {
                Object obj = this.parameter_;
                if (obj instanceof String) {
                    ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.parameter_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setParameter(String value) {
                value.getClass();
                this.parameter_ = value;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder clearParameter() {
                this.parameter_ = CodeGeneratorRequest.getDefaultInstance().getParameter();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            public Builder setParameterBytes(ByteString value) {
                value.getClass();
                this.parameter_ = value;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            private void ensureProtoFileIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.protoFile_ = new ArrayList(this.protoFile_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public List<DescriptorProtos.FileDescriptorProto> getProtoFileList() {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilder = this.protoFileBuilder_;
                if (repeatedFieldBuilder == null) {
                    return Collections.unmodifiableList(this.protoFile_);
                }
                return repeatedFieldBuilder.getMessageList();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public int getProtoFileCount() {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilder = this.protoFileBuilder_;
                if (repeatedFieldBuilder == null) {
                    return this.protoFile_.size();
                }
                return repeatedFieldBuilder.getCount();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public DescriptorProtos.FileDescriptorProto getProtoFile(int index) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilder = this.protoFileBuilder_;
                if (repeatedFieldBuilder == null) {
                    return this.protoFile_.get(index);
                }
                return (DescriptorProtos.FileDescriptorProto) repeatedFieldBuilder.getMessage(index);
            }

            public Builder setProtoFile(int index, DescriptorProtos.FileDescriptorProto value) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilder = this.protoFileBuilder_;
                if (repeatedFieldBuilder == null) {
                    value.getClass();
                    ensureProtoFileIsMutable();
                    this.protoFile_.set(index, value);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilder.setMessage(index, value);
                return this;
            }

            public Builder setProtoFile(int index, DescriptorProtos.FileDescriptorProto.Builder builderForValue) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilder = this.protoFileBuilder_;
                if (repeatedFieldBuilder == null) {
                    ensureProtoFileIsMutable();
                    this.protoFile_.set(index, builderForValue.build());
                    onChanged();
                    return this;
                }
                repeatedFieldBuilder.setMessage(index, builderForValue.build());
                return this;
            }

            public Builder addProtoFile(DescriptorProtos.FileDescriptorProto value) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilder = this.protoFileBuilder_;
                if (repeatedFieldBuilder == null) {
                    value.getClass();
                    ensureProtoFileIsMutable();
                    this.protoFile_.add(value);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilder.addMessage(value);
                return this;
            }

            public Builder addProtoFile(int index, DescriptorProtos.FileDescriptorProto value) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilder = this.protoFileBuilder_;
                if (repeatedFieldBuilder == null) {
                    value.getClass();
                    ensureProtoFileIsMutable();
                    this.protoFile_.add(index, value);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilder.addMessage(index, value);
                return this;
            }

            public Builder addProtoFile(DescriptorProtos.FileDescriptorProto.Builder builderForValue) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilder = this.protoFileBuilder_;
                if (repeatedFieldBuilder == null) {
                    ensureProtoFileIsMutable();
                    this.protoFile_.add(builderForValue.build());
                    onChanged();
                    return this;
                }
                repeatedFieldBuilder.addMessage(builderForValue.build());
                return this;
            }

            public Builder addProtoFile(int index, DescriptorProtos.FileDescriptorProto.Builder builderForValue) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilder = this.protoFileBuilder_;
                if (repeatedFieldBuilder == null) {
                    ensureProtoFileIsMutable();
                    this.protoFile_.add(index, builderForValue.build());
                    onChanged();
                    return this;
                }
                repeatedFieldBuilder.addMessage(index, builderForValue.build());
                return this;
            }

            public Builder addAllProtoFile(Iterable<? extends DescriptorProtos.FileDescriptorProto> values) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilder = this.protoFileBuilder_;
                if (repeatedFieldBuilder == null) {
                    ensureProtoFileIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.protoFile_);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilder.addAllMessages(values);
                return this;
            }

            public Builder clearProtoFile() {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilder = this.protoFileBuilder_;
                if (repeatedFieldBuilder == null) {
                    this.protoFile_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                    return this;
                }
                repeatedFieldBuilder.clear();
                return this;
            }

            public Builder removeProtoFile(int index) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilder = this.protoFileBuilder_;
                if (repeatedFieldBuilder == null) {
                    ensureProtoFileIsMutable();
                    this.protoFile_.remove(index);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilder.remove(index);
                return this;
            }

            public DescriptorProtos.FileDescriptorProto.Builder getProtoFileBuilder(int index) {
                return (DescriptorProtos.FileDescriptorProto.Builder) getProtoFileFieldBuilder().getBuilder(index);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public DescriptorProtos.FileDescriptorProtoOrBuilder getProtoFileOrBuilder(int index) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilder = this.protoFileBuilder_;
                if (repeatedFieldBuilder == null) {
                    return this.protoFile_.get(index);
                }
                return (DescriptorProtos.FileDescriptorProtoOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(index);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileOrBuilderList() {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilder = this.protoFileBuilder_;
                if (repeatedFieldBuilder != null) {
                    return repeatedFieldBuilder.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.protoFile_);
            }

            public DescriptorProtos.FileDescriptorProto.Builder addProtoFileBuilder() {
                return (DescriptorProtos.FileDescriptorProto.Builder) getProtoFileFieldBuilder().addBuilder(DescriptorProtos.FileDescriptorProto.getDefaultInstance());
            }

            public DescriptorProtos.FileDescriptorProto.Builder addProtoFileBuilder(int index) {
                return (DescriptorProtos.FileDescriptorProto.Builder) getProtoFileFieldBuilder().addBuilder(index, DescriptorProtos.FileDescriptorProto.getDefaultInstance());
            }

            public List<DescriptorProtos.FileDescriptorProto.Builder> getProtoFileBuilderList() {
                return getProtoFileFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileFieldBuilder() {
                if (this.protoFileBuilder_ == null) {
                    this.protoFileBuilder_ = new RepeatedFieldBuilder<>(this.protoFile_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                    this.protoFile_ = null;
                }
                return this.protoFileBuilder_;
            }

            private void ensureSourceFileDescriptorsIsMutable() {
                if ((this.bitField0_ & 8) == 0) {
                    this.sourceFileDescriptors_ = new ArrayList(this.sourceFileDescriptors_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public List<DescriptorProtos.FileDescriptorProto> getSourceFileDescriptorsList() {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilder = this.sourceFileDescriptorsBuilder_;
                if (repeatedFieldBuilder == null) {
                    return Collections.unmodifiableList(this.sourceFileDescriptors_);
                }
                return repeatedFieldBuilder.getMessageList();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public int getSourceFileDescriptorsCount() {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilder = this.sourceFileDescriptorsBuilder_;
                if (repeatedFieldBuilder == null) {
                    return this.sourceFileDescriptors_.size();
                }
                return repeatedFieldBuilder.getCount();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public DescriptorProtos.FileDescriptorProto getSourceFileDescriptors(int index) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilder = this.sourceFileDescriptorsBuilder_;
                if (repeatedFieldBuilder == null) {
                    return this.sourceFileDescriptors_.get(index);
                }
                return (DescriptorProtos.FileDescriptorProto) repeatedFieldBuilder.getMessage(index);
            }

            public Builder setSourceFileDescriptors(int index, DescriptorProtos.FileDescriptorProto value) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilder = this.sourceFileDescriptorsBuilder_;
                if (repeatedFieldBuilder == null) {
                    value.getClass();
                    ensureSourceFileDescriptorsIsMutable();
                    this.sourceFileDescriptors_.set(index, value);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilder.setMessage(index, value);
                return this;
            }

            public Builder setSourceFileDescriptors(int index, DescriptorProtos.FileDescriptorProto.Builder builderForValue) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilder = this.sourceFileDescriptorsBuilder_;
                if (repeatedFieldBuilder == null) {
                    ensureSourceFileDescriptorsIsMutable();
                    this.sourceFileDescriptors_.set(index, builderForValue.build());
                    onChanged();
                    return this;
                }
                repeatedFieldBuilder.setMessage(index, builderForValue.build());
                return this;
            }

            public Builder addSourceFileDescriptors(DescriptorProtos.FileDescriptorProto value) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilder = this.sourceFileDescriptorsBuilder_;
                if (repeatedFieldBuilder == null) {
                    value.getClass();
                    ensureSourceFileDescriptorsIsMutable();
                    this.sourceFileDescriptors_.add(value);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilder.addMessage(value);
                return this;
            }

            public Builder addSourceFileDescriptors(int index, DescriptorProtos.FileDescriptorProto value) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilder = this.sourceFileDescriptorsBuilder_;
                if (repeatedFieldBuilder == null) {
                    value.getClass();
                    ensureSourceFileDescriptorsIsMutable();
                    this.sourceFileDescriptors_.add(index, value);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilder.addMessage(index, value);
                return this;
            }

            public Builder addSourceFileDescriptors(DescriptorProtos.FileDescriptorProto.Builder builderForValue) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilder = this.sourceFileDescriptorsBuilder_;
                if (repeatedFieldBuilder == null) {
                    ensureSourceFileDescriptorsIsMutable();
                    this.sourceFileDescriptors_.add(builderForValue.build());
                    onChanged();
                    return this;
                }
                repeatedFieldBuilder.addMessage(builderForValue.build());
                return this;
            }

            public Builder addSourceFileDescriptors(int index, DescriptorProtos.FileDescriptorProto.Builder builderForValue) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilder = this.sourceFileDescriptorsBuilder_;
                if (repeatedFieldBuilder == null) {
                    ensureSourceFileDescriptorsIsMutable();
                    this.sourceFileDescriptors_.add(index, builderForValue.build());
                    onChanged();
                    return this;
                }
                repeatedFieldBuilder.addMessage(index, builderForValue.build());
                return this;
            }

            public Builder addAllSourceFileDescriptors(Iterable<? extends DescriptorProtos.FileDescriptorProto> values) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilder = this.sourceFileDescriptorsBuilder_;
                if (repeatedFieldBuilder == null) {
                    ensureSourceFileDescriptorsIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.sourceFileDescriptors_);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilder.addAllMessages(values);
                return this;
            }

            public Builder clearSourceFileDescriptors() {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilder = this.sourceFileDescriptorsBuilder_;
                if (repeatedFieldBuilder == null) {
                    this.sourceFileDescriptors_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                    onChanged();
                    return this;
                }
                repeatedFieldBuilder.clear();
                return this;
            }

            public Builder removeSourceFileDescriptors(int index) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilder = this.sourceFileDescriptorsBuilder_;
                if (repeatedFieldBuilder == null) {
                    ensureSourceFileDescriptorsIsMutable();
                    this.sourceFileDescriptors_.remove(index);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilder.remove(index);
                return this;
            }

            public DescriptorProtos.FileDescriptorProto.Builder getSourceFileDescriptorsBuilder(int index) {
                return (DescriptorProtos.FileDescriptorProto.Builder) getSourceFileDescriptorsFieldBuilder().getBuilder(index);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public DescriptorProtos.FileDescriptorProtoOrBuilder getSourceFileDescriptorsOrBuilder(int index) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilder = this.sourceFileDescriptorsBuilder_;
                if (repeatedFieldBuilder == null) {
                    return this.sourceFileDescriptors_.get(index);
                }
                return (DescriptorProtos.FileDescriptorProtoOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(index);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getSourceFileDescriptorsOrBuilderList() {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilder = this.sourceFileDescriptorsBuilder_;
                if (repeatedFieldBuilder != null) {
                    return repeatedFieldBuilder.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.sourceFileDescriptors_);
            }

            public DescriptorProtos.FileDescriptorProto.Builder addSourceFileDescriptorsBuilder() {
                return (DescriptorProtos.FileDescriptorProto.Builder) getSourceFileDescriptorsFieldBuilder().addBuilder(DescriptorProtos.FileDescriptorProto.getDefaultInstance());
            }

            public DescriptorProtos.FileDescriptorProto.Builder addSourceFileDescriptorsBuilder(int index) {
                return (DescriptorProtos.FileDescriptorProto.Builder) getSourceFileDescriptorsFieldBuilder().addBuilder(index, DescriptorProtos.FileDescriptorProto.getDefaultInstance());
            }

            public List<DescriptorProtos.FileDescriptorProto.Builder> getSourceFileDescriptorsBuilderList() {
                return getSourceFileDescriptorsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> getSourceFileDescriptorsFieldBuilder() {
                if (this.sourceFileDescriptorsBuilder_ == null) {
                    this.sourceFileDescriptorsBuilder_ = new RepeatedFieldBuilder<>(this.sourceFileDescriptors_, (this.bitField0_ & 8) != 0, getParentForChildren(), isClean());
                    this.sourceFileDescriptors_ = null;
                }
                return this.sourceFileDescriptorsBuilder_;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public boolean hasCompilerVersion() {
                return (this.bitField0_ & 16) != 0;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public Version getCompilerVersion() {
                SingleFieldBuilder<Version, Version.Builder, VersionOrBuilder> singleFieldBuilder = this.compilerVersionBuilder_;
                if (singleFieldBuilder == null) {
                    Version version = this.compilerVersion_;
                    return version == null ? Version.getDefaultInstance() : version;
                }
                return (Version) singleFieldBuilder.getMessage();
            }

            public Builder setCompilerVersion(Version value) {
                SingleFieldBuilder<Version, Version.Builder, VersionOrBuilder> singleFieldBuilder = this.compilerVersionBuilder_;
                if (singleFieldBuilder == null) {
                    value.getClass();
                    this.compilerVersion_ = value;
                } else {
                    singleFieldBuilder.setMessage(value);
                }
                this.bitField0_ |= 16;
                onChanged();
                return this;
            }

            public Builder setCompilerVersion(Version.Builder builderForValue) {
                SingleFieldBuilder<Version, Version.Builder, VersionOrBuilder> singleFieldBuilder = this.compilerVersionBuilder_;
                if (singleFieldBuilder == null) {
                    this.compilerVersion_ = builderForValue.build();
                } else {
                    singleFieldBuilder.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 16;
                onChanged();
                return this;
            }

            public Builder mergeCompilerVersion(Version value) {
                Version version;
                SingleFieldBuilder<Version, Version.Builder, VersionOrBuilder> singleFieldBuilder = this.compilerVersionBuilder_;
                if (singleFieldBuilder == null) {
                    if ((this.bitField0_ & 16) != 0 && (version = this.compilerVersion_) != null && version != Version.getDefaultInstance()) {
                        getCompilerVersionBuilder().mergeFrom(value);
                    } else {
                        this.compilerVersion_ = value;
                    }
                } else {
                    singleFieldBuilder.mergeFrom(value);
                }
                if (this.compilerVersion_ != null) {
                    this.bitField0_ |= 16;
                    onChanged();
                }
                return this;
            }

            public Builder clearCompilerVersion() {
                this.bitField0_ &= -17;
                this.compilerVersion_ = null;
                SingleFieldBuilder<Version, Version.Builder, VersionOrBuilder> singleFieldBuilder = this.compilerVersionBuilder_;
                if (singleFieldBuilder != null) {
                    singleFieldBuilder.dispose();
                    this.compilerVersionBuilder_ = null;
                }
                onChanged();
                return this;
            }

            public Version.Builder getCompilerVersionBuilder() {
                this.bitField0_ |= 16;
                onChanged();
                return (Version.Builder) getCompilerVersionFieldBuilder().getBuilder();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public VersionOrBuilder getCompilerVersionOrBuilder() {
                SingleFieldBuilder<Version, Version.Builder, VersionOrBuilder> singleFieldBuilder = this.compilerVersionBuilder_;
                if (singleFieldBuilder != null) {
                    return (VersionOrBuilder) singleFieldBuilder.getMessageOrBuilder();
                }
                Version version = this.compilerVersion_;
                return version == null ? Version.getDefaultInstance() : version;
            }

            private SingleFieldBuilder<Version, Version.Builder, VersionOrBuilder> getCompilerVersionFieldBuilder() {
                if (this.compilerVersionBuilder_ == null) {
                    this.compilerVersionBuilder_ = new SingleFieldBuilder<>(getCompilerVersion(), getParentForChildren(), isClean());
                    this.compilerVersion_ = null;
                }
                return this.compilerVersionBuilder_;
            }
        }

        public static CodeGeneratorRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* INFO: renamed from: com.google.protobuf.compiler.PluginProtos$CodeGeneratorRequest$1, reason: invalid class name */
        class AnonymousClass1 extends AbstractParser<CodeGeneratorRequest> {
            AnonymousClass1() {
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseDelimitedFrom(InputStream input) throws InvalidProtocolBufferException {
                return super.parseDelimitedFrom(input);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.parseDelimitedFrom(input, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return super.parseFrom(data);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.parseFrom(data, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(CodedInputStream input) throws InvalidProtocolBufferException {
                return super.parseFrom(input);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.parseFrom(input, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(InputStream input) throws InvalidProtocolBufferException {
                return super.parseFrom(input);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.parseFrom(input, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
                return super.parseFrom(data);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.parseFrom(data, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return super.parseFrom(data);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(byte[] data, int off, int len) throws InvalidProtocolBufferException {
                return super.parseFrom(data, off, len);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(byte[] data, int off, int len, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.parseFrom(data, off, len, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.parseFrom(data, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialDelimitedFrom(InputStream input) throws InvalidProtocolBufferException {
                return super.parsePartialDelimitedFrom(input);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.parsePartialDelimitedFrom(input, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(ByteString data) throws InvalidProtocolBufferException {
                return super.parsePartialFrom(data);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.parsePartialFrom(data, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream input) throws InvalidProtocolBufferException {
                return super.parsePartialFrom(input);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(InputStream input) throws InvalidProtocolBufferException {
                return super.parsePartialFrom(input);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.parsePartialFrom(input, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] data) throws InvalidProtocolBufferException {
                return super.parsePartialFrom(data);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] data, int off, int len) throws InvalidProtocolBufferException {
                return super.parsePartialFrom(data, off, len);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] data, int off, int len, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.parsePartialFrom(data, off, len, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.parsePartialFrom(data, extensionRegistry);
            }

            @Override // com.google.protobuf.Parser
            public CodeGeneratorRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                Builder builderNewBuilder = CodeGeneratorRequest.newBuilder();
                try {
                    builderNewBuilder.mergeFrom(input, extensionRegistry);
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

        public static Parser<CodeGeneratorRequest> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CodeGeneratorRequest> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CodeGeneratorRequest getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class CodeGeneratorResponse extends GeneratedMessage implements CodeGeneratorResponseOrBuilder {
        private static final CodeGeneratorResponse DEFAULT_INSTANCE;
        public static final int ERROR_FIELD_NUMBER = 1;
        public static final int FILE_FIELD_NUMBER = 15;
        public static final int MAXIMUM_EDITION_FIELD_NUMBER = 4;
        public static final int MINIMUM_EDITION_FIELD_NUMBER = 3;
        private static final Parser<CodeGeneratorResponse> PARSER;
        public static final int SUPPORTED_FEATURES_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private volatile Object error_;
        private List<File> file_;
        private int maximumEdition_;
        private byte memoizedIsInitialized;
        private int minimumEdition_;
        private long supportedFeatures_;

        public interface FileOrBuilder extends MessageOrBuilder {
            String getContent();

            ByteString getContentBytes();

            DescriptorProtos.GeneratedCodeInfo getGeneratedCodeInfo();

            DescriptorProtos.GeneratedCodeInfoOrBuilder getGeneratedCodeInfoOrBuilder();

            String getInsertionPoint();

            ByteString getInsertionPointBytes();

            String getName();

            ByteString getNameBytes();

            boolean hasContent();

            boolean hasGeneratedCodeInfo();

            boolean hasInsertionPoint();

            boolean hasName();
        }

        /* synthetic */ CodeGeneratorResponse(GeneratedMessage.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        static /* synthetic */ int access$4576(CodeGeneratorResponse codeGeneratorResponse, int i) {
            int i2 = i | codeGeneratorResponse.bitField0_;
            codeGeneratorResponse.bitField0_ = i2;
            return i2;
        }

        static {
            RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", CodeGeneratorResponse.class.getName());
            DEFAULT_INSTANCE = new CodeGeneratorResponse();
            PARSER = new AnonymousClass1();
        }

        private CodeGeneratorResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.error_ = "";
            this.supportedFeatures_ = 0L;
            this.minimumEdition_ = 0;
            this.maximumEdition_ = 0;
            this.memoizedIsInitialized = (byte) -1;
        }

        private CodeGeneratorResponse() {
            this.error_ = "";
            this.supportedFeatures_ = 0L;
            this.minimumEdition_ = 0;
            this.maximumEdition_ = 0;
            this.memoizedIsInitialized = (byte) -1;
            this.error_ = "";
            this.file_ = Collections.emptyList();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(CodeGeneratorResponse.class, Builder.class);
        }

        public enum Feature implements ProtocolMessageEnum {
            FEATURE_NONE(0),
            FEATURE_PROTO3_OPTIONAL(1),
            FEATURE_SUPPORTS_EDITIONS(2);

            public static final int FEATURE_NONE_VALUE = 0;
            public static final int FEATURE_PROTO3_OPTIONAL_VALUE = 1;
            public static final int FEATURE_SUPPORTS_EDITIONS_VALUE = 2;
            private static final Feature[] VALUES;
            private static final Internal.EnumLiteMap<Feature> internalValueMap;
            private final int value;

            static {
                RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", Feature.class.getName());
                internalValueMap = new AnonymousClass1();
                VALUES = values();
            }

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static Feature valueOf(int value) {
                return forNumber(value);
            }

            public static Feature forNumber(int value) {
                if (value == 0) {
                    return FEATURE_NONE;
                }
                if (value == 1) {
                    return FEATURE_PROTO3_OPTIONAL;
                }
                if (value != 2) {
                    return null;
                }
                return FEATURE_SUPPORTS_EDITIONS;
            }

            public static Internal.EnumLiteMap<Feature> internalGetValueMap() {
                return internalValueMap;
            }

            /* INFO: renamed from: com.google.protobuf.compiler.PluginProtos$CodeGeneratorResponse$Feature$1, reason: invalid class name */
            class AnonymousClass1 implements Internal.EnumLiteMap<Feature> {
                AnonymousClass1() {
                }

                @Override // com.google.protobuf.Internal.EnumLiteMap
                public Feature findValueByNumber(int number) {
                    return Feature.forNumber(number);
                }
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumValueDescriptor getValueDescriptor() {
                return getDescriptor().getValues().get(ordinal());
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            public static final Descriptors.EnumDescriptor getDescriptor() {
                return CodeGeneratorResponse.getDescriptor().getEnumTypes().get(0);
            }

            public static Feature valueOf(Descriptors.EnumValueDescriptor desc) {
                if (desc.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                }
                return VALUES[desc.getIndex()];
            }

            Feature(int value) {
                this.value = value;
            }
        }

        public static final class File extends GeneratedMessage implements FileOrBuilder {
            public static final int CONTENT_FIELD_NUMBER = 15;
            private static final File DEFAULT_INSTANCE;
            public static final int GENERATED_CODE_INFO_FIELD_NUMBER = 16;
            public static final int INSERTION_POINT_FIELD_NUMBER = 2;
            public static final int NAME_FIELD_NUMBER = 1;
            private static final Parser<File> PARSER;
            private static final long serialVersionUID = 0;
            private int bitField0_;
            private volatile Object content_;
            private DescriptorProtos.GeneratedCodeInfo generatedCodeInfo_;
            private volatile Object insertionPoint_;
            private byte memoizedIsInitialized;
            private volatile Object name_;

            /* synthetic */ File(GeneratedMessage.Builder builder, AnonymousClass1 anonymousClass1) {
                this(builder);
            }

            static /* synthetic */ int access$3676(File file, int i) {
                int i2 = i | file.bitField0_;
                file.bitField0_ = i2;
                return i2;
            }

            static {
                RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", File.class.getName());
                DEFAULT_INSTANCE = new File();
                PARSER = new AnonymousClass1();
            }

            private File(GeneratedMessage.Builder<?> builder) {
                super(builder);
                this.name_ = "";
                this.insertionPoint_ = "";
                this.content_ = "";
                this.memoizedIsInitialized = (byte) -1;
            }

            private File() {
                this.name_ = "";
                this.insertionPoint_ = "";
                this.content_ = "";
                this.memoizedIsInitialized = (byte) -1;
                this.name_ = "";
                this.insertionPoint_ = "";
                this.content_ = "";
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessage
            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_fieldAccessorTable.ensureFieldAccessorsInitialized(File.class, Builder.class);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public boolean hasName() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public String getName() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.name_ = stringUtf8;
                }
                return stringUtf8;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public ByteString getNameBytes() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.name_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public boolean hasInsertionPoint() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public String getInsertionPoint() {
                Object obj = this.insertionPoint_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.insertionPoint_ = stringUtf8;
                }
                return stringUtf8;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public ByteString getInsertionPointBytes() {
                Object obj = this.insertionPoint_;
                if (obj instanceof String) {
                    ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.insertionPoint_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public boolean hasContent() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public String getContent() {
                Object obj = this.content_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.content_ = stringUtf8;
                }
                return stringUtf8;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public ByteString getContentBytes() {
                Object obj = this.content_;
                if (obj instanceof String) {
                    ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.content_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public boolean hasGeneratedCodeInfo() {
                return (this.bitField0_ & 8) != 0;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public DescriptorProtos.GeneratedCodeInfo getGeneratedCodeInfo() {
                DescriptorProtos.GeneratedCodeInfo generatedCodeInfo = this.generatedCodeInfo_;
                return generatedCodeInfo == null ? DescriptorProtos.GeneratedCodeInfo.getDefaultInstance() : generatedCodeInfo;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public DescriptorProtos.GeneratedCodeInfoOrBuilder getGeneratedCodeInfoOrBuilder() {
                DescriptorProtos.GeneratedCodeInfo generatedCodeInfo = this.generatedCodeInfo_;
                return generatedCodeInfo == null ? DescriptorProtos.GeneratedCodeInfo.getDefaultInstance() : generatedCodeInfo;
            }

            @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                byte b = this.memoizedIsInitialized;
                if (b == 1) {
                    return true;
                }
                if (b == 0) {
                    return false;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream output) throws IOException {
                if ((this.bitField0_ & 1) != 0) {
                    GeneratedMessage.writeString(output, 1, this.name_);
                }
                if ((this.bitField0_ & 2) != 0) {
                    GeneratedMessage.writeString(output, 2, this.insertionPoint_);
                }
                if ((this.bitField0_ & 4) != 0) {
                    GeneratedMessage.writeString(output, 15, this.content_);
                }
                if ((this.bitField0_ & 8) != 0) {
                    output.writeMessage(16, getGeneratedCodeInfo());
                }
                getUnknownFields().writeTo(output);
            }

            @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSize;
                if (i != -1) {
                    return i;
                }
                int iComputeStringSize = (this.bitField0_ & 1) != 0 ? GeneratedMessage.computeStringSize(1, this.name_) : 0;
                if ((this.bitField0_ & 2) != 0) {
                    iComputeStringSize += GeneratedMessage.computeStringSize(2, this.insertionPoint_);
                }
                if ((this.bitField0_ & 4) != 0) {
                    iComputeStringSize += GeneratedMessage.computeStringSize(15, this.content_);
                }
                if ((this.bitField0_ & 8) != 0) {
                    iComputeStringSize += CodedOutputStream.computeMessageSize(16, getGeneratedCodeInfo());
                }
                int serializedSize = iComputeStringSize + getUnknownFields().getSerializedSize();
                this.memoizedSize = serializedSize;
                return serializedSize;
            }

            @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
            public boolean equals(final Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof File)) {
                    return super.equals(obj);
                }
                File file = (File) obj;
                if (hasName() != file.hasName()) {
                    return false;
                }
                if ((hasName() && !getName().equals(file.getName())) || hasInsertionPoint() != file.hasInsertionPoint()) {
                    return false;
                }
                if ((hasInsertionPoint() && !getInsertionPoint().equals(file.getInsertionPoint())) || hasContent() != file.hasContent()) {
                    return false;
                }
                if ((!hasContent() || getContent().equals(file.getContent())) && hasGeneratedCodeInfo() == file.hasGeneratedCodeInfo()) {
                    return (!hasGeneratedCodeInfo() || getGeneratedCodeInfo().equals(file.getGeneratedCodeInfo())) && getUnknownFields().equals(file.getUnknownFields());
                }
                return false;
            }

            @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
            public int hashCode() {
                if (this.memoizedHashCode != 0) {
                    return this.memoizedHashCode;
                }
                int iHashCode = 779 + getDescriptor().hashCode();
                if (hasName()) {
                    iHashCode = (((iHashCode * 37) + 1) * 53) + getName().hashCode();
                }
                if (hasInsertionPoint()) {
                    iHashCode = (((iHashCode * 37) + 2) * 53) + getInsertionPoint().hashCode();
                }
                if (hasContent()) {
                    iHashCode = (((iHashCode * 37) + 15) * 53) + getContent().hashCode();
                }
                if (hasGeneratedCodeInfo()) {
                    iHashCode = (((iHashCode * 37) + 16) * 53) + getGeneratedCodeInfo().hashCode();
                }
                int iHashCode2 = (iHashCode * 29) + getUnknownFields().hashCode();
                this.memoizedHashCode = iHashCode2;
                return iHashCode2;
            }

            public static File parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static File parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static File parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static File parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static File parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static File parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static File parseFrom(InputStream input) throws IOException {
                return (File) GeneratedMessage.parseWithIOException(PARSER, input);
            }

            public static File parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (File) GeneratedMessage.parseWithIOException(PARSER, input, extensionRegistry);
            }

            public static File parseDelimitedFrom(InputStream input) throws IOException {
                return (File) GeneratedMessage.parseDelimitedWithIOException(PARSER, input);
            }

            public static File parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (File) GeneratedMessage.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
            }

            public static File parseFrom(CodedInputStream input) throws IOException {
                return (File) GeneratedMessage.parseWithIOException(PARSER, input);
            }

            public static File parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (File) GeneratedMessage.parseWithIOException(PARSER, input, extensionRegistry);
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(File prototype) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Builder toBuilder() {
                return this == DEFAULT_INSTANCE ? new Builder((AnonymousClass1) null) : new Builder((AnonymousClass1) null).mergeFrom(this);
            }

            /* INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.AbstractMessage
            public Builder newBuilderForType(AbstractMessage.BuilderParent parent) {
                return new Builder(parent, null);
            }

            public static final class Builder extends GeneratedMessage.Builder<Builder> implements FileOrBuilder {
                private int bitField0_;
                private Object content_;
                private SingleFieldBuilder<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> generatedCodeInfoBuilder_;
                private DescriptorProtos.GeneratedCodeInfo generatedCodeInfo_;
                private Object insertionPoint_;
                private Object name_;

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, AnonymousClass1 anonymousClass1) {
                    this(builderParent);
                }

                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                public static final Descriptors.Descriptor getDescriptor() {
                    return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor;
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder
                protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                    return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_fieldAccessorTable.ensureFieldAccessorsInitialized(File.class, Builder.class);
                }

                private Builder() {
                    this.name_ = "";
                    this.insertionPoint_ = "";
                    this.content_ = "";
                    maybeForceBuilderInitialization();
                }

                private Builder(AbstractMessage.BuilderParent parent) {
                    super(parent);
                    this.name_ = "";
                    this.insertionPoint_ = "";
                    this.content_ = "";
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    if (File.alwaysUseFieldBuilders) {
                        getGeneratedCodeInfoFieldBuilder();
                    }
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public Builder clear() {
                    super.clear();
                    this.bitField0_ = 0;
                    this.name_ = "";
                    this.insertionPoint_ = "";
                    this.content_ = "";
                    this.generatedCodeInfo_ = null;
                    SingleFieldBuilder<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> singleFieldBuilder = this.generatedCodeInfoBuilder_;
                    if (singleFieldBuilder != null) {
                        singleFieldBuilder.dispose();
                        this.generatedCodeInfoBuilder_ = null;
                    }
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor;
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
                public File getDefaultInstanceForType() {
                    return File.getDefaultInstance();
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public File build() {
                    File fileBuildPartial = buildPartial();
                    if (fileBuildPartial.isInitialized()) {
                        return fileBuildPartial;
                    }
                    throw newUninitializedMessageException((Message) fileBuildPartial);
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public File buildPartial() {
                    File file = new File(this, null);
                    if (this.bitField0_ != 0) {
                        buildPartial0(file);
                    }
                    onBuilt();
                    return file;
                }

                private void buildPartial0(File result) {
                    int i;
                    DescriptorProtos.GeneratedCodeInfo generatedCodeInfo;
                    int i2 = this.bitField0_;
                    if ((i2 & 1) != 0) {
                        result.name_ = this.name_;
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if ((i2 & 2) != 0) {
                        result.insertionPoint_ = this.insertionPoint_;
                        i |= 2;
                    }
                    if ((i2 & 4) != 0) {
                        result.content_ = this.content_;
                        i |= 4;
                    }
                    if ((i2 & 8) != 0) {
                        SingleFieldBuilder<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> singleFieldBuilder = this.generatedCodeInfoBuilder_;
                        if (singleFieldBuilder == null) {
                            generatedCodeInfo = this.generatedCodeInfo_;
                        } else {
                            generatedCodeInfo = (DescriptorProtos.GeneratedCodeInfo) singleFieldBuilder.build();
                        }
                        result.generatedCodeInfo_ = generatedCodeInfo;
                        i |= 8;
                    }
                    File.access$3676(result, i);
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
                public Builder mergeFrom(Message other) {
                    if (other instanceof File) {
                        return mergeFrom((File) other);
                    }
                    super.mergeFrom(other);
                    return this;
                }

                public Builder mergeFrom(File other) {
                    if (other == File.getDefaultInstance()) {
                        return this;
                    }
                    if (other.hasName()) {
                        this.name_ = other.name_;
                        this.bitField0_ |= 1;
                        onChanged();
                    }
                    if (other.hasInsertionPoint()) {
                        this.insertionPoint_ = other.insertionPoint_;
                        this.bitField0_ |= 2;
                        onChanged();
                    }
                    if (other.hasContent()) {
                        this.content_ = other.content_;
                        this.bitField0_ |= 4;
                        onChanged();
                    }
                    if (other.hasGeneratedCodeInfo()) {
                        mergeGeneratedCodeInfo(other.getGeneratedCodeInfo());
                    }
                    mergeUnknownFields(other.getUnknownFields());
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    extensionRegistry.getClass();
                    boolean z = false;
                    while (!z) {
                        try {
                            try {
                                int tag = input.readTag();
                                if (tag != 0) {
                                    if (tag == 10) {
                                        this.name_ = input.readBytes();
                                        this.bitField0_ |= 1;
                                    } else if (tag == 18) {
                                        this.insertionPoint_ = input.readBytes();
                                        this.bitField0_ |= 2;
                                    } else if (tag == 122) {
                                        this.content_ = input.readBytes();
                                        this.bitField0_ |= 4;
                                    } else if (tag == 130) {
                                        input.readMessage(getGeneratedCodeInfoFieldBuilder().getBuilder(), extensionRegistry);
                                        this.bitField0_ |= 8;
                                    } else if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                                    }
                                }
                                z = true;
                            } catch (InvalidProtocolBufferException e) {
                                throw e.unwrapIOException();
                            }
                        } catch (Throwable th) {
                            onChanged();
                            throw th;
                        }
                    }
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public boolean hasName() {
                    return (this.bitField0_ & 1) != 0;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public String getName() {
                    Object obj = this.name_;
                    if (!(obj instanceof String)) {
                        ByteString byteString = (ByteString) obj;
                        String stringUtf8 = byteString.toStringUtf8();
                        if (byteString.isValidUtf8()) {
                            this.name_ = stringUtf8;
                        }
                        return stringUtf8;
                    }
                    return (String) obj;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public ByteString getNameBytes() {
                    Object obj = this.name_;
                    if (obj instanceof String) {
                        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.name_ = byteStringCopyFromUtf8;
                        return byteStringCopyFromUtf8;
                    }
                    return (ByteString) obj;
                }

                public Builder setName(String value) {
                    value.getClass();
                    this.name_ = value;
                    this.bitField0_ |= 1;
                    onChanged();
                    return this;
                }

                public Builder clearName() {
                    this.name_ = File.getDefaultInstance().getName();
                    this.bitField0_ &= -2;
                    onChanged();
                    return this;
                }

                public Builder setNameBytes(ByteString value) {
                    value.getClass();
                    this.name_ = value;
                    this.bitField0_ |= 1;
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public boolean hasInsertionPoint() {
                    return (this.bitField0_ & 2) != 0;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public String getInsertionPoint() {
                    Object obj = this.insertionPoint_;
                    if (!(obj instanceof String)) {
                        ByteString byteString = (ByteString) obj;
                        String stringUtf8 = byteString.toStringUtf8();
                        if (byteString.isValidUtf8()) {
                            this.insertionPoint_ = stringUtf8;
                        }
                        return stringUtf8;
                    }
                    return (String) obj;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public ByteString getInsertionPointBytes() {
                    Object obj = this.insertionPoint_;
                    if (obj instanceof String) {
                        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.insertionPoint_ = byteStringCopyFromUtf8;
                        return byteStringCopyFromUtf8;
                    }
                    return (ByteString) obj;
                }

                public Builder setInsertionPoint(String value) {
                    value.getClass();
                    this.insertionPoint_ = value;
                    this.bitField0_ |= 2;
                    onChanged();
                    return this;
                }

                public Builder clearInsertionPoint() {
                    this.insertionPoint_ = File.getDefaultInstance().getInsertionPoint();
                    this.bitField0_ &= -3;
                    onChanged();
                    return this;
                }

                public Builder setInsertionPointBytes(ByteString value) {
                    value.getClass();
                    this.insertionPoint_ = value;
                    this.bitField0_ |= 2;
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public boolean hasContent() {
                    return (this.bitField0_ & 4) != 0;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public String getContent() {
                    Object obj = this.content_;
                    if (!(obj instanceof String)) {
                        ByteString byteString = (ByteString) obj;
                        String stringUtf8 = byteString.toStringUtf8();
                        if (byteString.isValidUtf8()) {
                            this.content_ = stringUtf8;
                        }
                        return stringUtf8;
                    }
                    return (String) obj;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public ByteString getContentBytes() {
                    Object obj = this.content_;
                    if (obj instanceof String) {
                        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.content_ = byteStringCopyFromUtf8;
                        return byteStringCopyFromUtf8;
                    }
                    return (ByteString) obj;
                }

                public Builder setContent(String value) {
                    value.getClass();
                    this.content_ = value;
                    this.bitField0_ |= 4;
                    onChanged();
                    return this;
                }

                public Builder clearContent() {
                    this.content_ = File.getDefaultInstance().getContent();
                    this.bitField0_ &= -5;
                    onChanged();
                    return this;
                }

                public Builder setContentBytes(ByteString value) {
                    value.getClass();
                    this.content_ = value;
                    this.bitField0_ |= 4;
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public boolean hasGeneratedCodeInfo() {
                    return (this.bitField0_ & 8) != 0;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public DescriptorProtos.GeneratedCodeInfo getGeneratedCodeInfo() {
                    SingleFieldBuilder<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> singleFieldBuilder = this.generatedCodeInfoBuilder_;
                    if (singleFieldBuilder == null) {
                        DescriptorProtos.GeneratedCodeInfo generatedCodeInfo = this.generatedCodeInfo_;
                        return generatedCodeInfo == null ? DescriptorProtos.GeneratedCodeInfo.getDefaultInstance() : generatedCodeInfo;
                    }
                    return (DescriptorProtos.GeneratedCodeInfo) singleFieldBuilder.getMessage();
                }

                public Builder setGeneratedCodeInfo(DescriptorProtos.GeneratedCodeInfo value) {
                    SingleFieldBuilder<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> singleFieldBuilder = this.generatedCodeInfoBuilder_;
                    if (singleFieldBuilder == null) {
                        value.getClass();
                        this.generatedCodeInfo_ = value;
                    } else {
                        singleFieldBuilder.setMessage(value);
                    }
                    this.bitField0_ |= 8;
                    onChanged();
                    return this;
                }

                public Builder setGeneratedCodeInfo(DescriptorProtos.GeneratedCodeInfo.Builder builderForValue) {
                    SingleFieldBuilder<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> singleFieldBuilder = this.generatedCodeInfoBuilder_;
                    if (singleFieldBuilder == null) {
                        this.generatedCodeInfo_ = builderForValue.build();
                    } else {
                        singleFieldBuilder.setMessage(builderForValue.build());
                    }
                    this.bitField0_ |= 8;
                    onChanged();
                    return this;
                }

                public Builder mergeGeneratedCodeInfo(DescriptorProtos.GeneratedCodeInfo value) {
                    DescriptorProtos.GeneratedCodeInfo generatedCodeInfo;
                    SingleFieldBuilder<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> singleFieldBuilder = this.generatedCodeInfoBuilder_;
                    if (singleFieldBuilder == null) {
                        if ((this.bitField0_ & 8) != 0 && (generatedCodeInfo = this.generatedCodeInfo_) != null && generatedCodeInfo != DescriptorProtos.GeneratedCodeInfo.getDefaultInstance()) {
                            getGeneratedCodeInfoBuilder().mergeFrom(value);
                        } else {
                            this.generatedCodeInfo_ = value;
                        }
                    } else {
                        singleFieldBuilder.mergeFrom(value);
                    }
                    if (this.generatedCodeInfo_ != null) {
                        this.bitField0_ |= 8;
                        onChanged();
                    }
                    return this;
                }

                public Builder clearGeneratedCodeInfo() {
                    this.bitField0_ &= -9;
                    this.generatedCodeInfo_ = null;
                    SingleFieldBuilder<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> singleFieldBuilder = this.generatedCodeInfoBuilder_;
                    if (singleFieldBuilder != null) {
                        singleFieldBuilder.dispose();
                        this.generatedCodeInfoBuilder_ = null;
                    }
                    onChanged();
                    return this;
                }

                public DescriptorProtos.GeneratedCodeInfo.Builder getGeneratedCodeInfoBuilder() {
                    this.bitField0_ |= 8;
                    onChanged();
                    return (DescriptorProtos.GeneratedCodeInfo.Builder) getGeneratedCodeInfoFieldBuilder().getBuilder();
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public DescriptorProtos.GeneratedCodeInfoOrBuilder getGeneratedCodeInfoOrBuilder() {
                    SingleFieldBuilder<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> singleFieldBuilder = this.generatedCodeInfoBuilder_;
                    if (singleFieldBuilder != null) {
                        return (DescriptorProtos.GeneratedCodeInfoOrBuilder) singleFieldBuilder.getMessageOrBuilder();
                    }
                    DescriptorProtos.GeneratedCodeInfo generatedCodeInfo = this.generatedCodeInfo_;
                    return generatedCodeInfo == null ? DescriptorProtos.GeneratedCodeInfo.getDefaultInstance() : generatedCodeInfo;
                }

                private SingleFieldBuilder<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> getGeneratedCodeInfoFieldBuilder() {
                    if (this.generatedCodeInfoBuilder_ == null) {
                        this.generatedCodeInfoBuilder_ = new SingleFieldBuilder<>(getGeneratedCodeInfo(), getParentForChildren(), isClean());
                        this.generatedCodeInfo_ = null;
                    }
                    return this.generatedCodeInfoBuilder_;
                }
            }

            public static File getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            /* INFO: renamed from: com.google.protobuf.compiler.PluginProtos$CodeGeneratorResponse$File$1, reason: invalid class name */
            class AnonymousClass1 extends AbstractParser<File> {
                AnonymousClass1() {
                }

                @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
                public /* bridge */ /* synthetic */ Object parseDelimitedFrom(InputStream input) throws InvalidProtocolBufferException {
                    return super.parseDelimitedFrom(input);
                }

                @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
                public /* bridge */ /* synthetic */ Object parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.parseDelimitedFrom(input, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
                public /* bridge */ /* synthetic */ Object parseFrom(ByteString data) throws InvalidProtocolBufferException {
                    return super.parseFrom(data);
                }

                @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
                public /* bridge */ /* synthetic */ Object parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.parseFrom(data, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
                public /* bridge */ /* synthetic */ Object parseFrom(CodedInputStream input) throws InvalidProtocolBufferException {
                    return super.parseFrom(input);
                }

                @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
                public /* bridge */ /* synthetic */ Object parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.parseFrom(input, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
                public /* bridge */ /* synthetic */ Object parseFrom(InputStream input) throws InvalidProtocolBufferException {
                    return super.parseFrom(input);
                }

                @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
                public /* bridge */ /* synthetic */ Object parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.parseFrom(input, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
                public /* bridge */ /* synthetic */ Object parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
                    return super.parseFrom(data);
                }

                @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
                public /* bridge */ /* synthetic */ Object parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.parseFrom(data, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
                public /* bridge */ /* synthetic */ Object parseFrom(byte[] data) throws InvalidProtocolBufferException {
                    return super.parseFrom(data);
                }

                @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
                public /* bridge */ /* synthetic */ Object parseFrom(byte[] data, int off, int len) throws InvalidProtocolBufferException {
                    return super.parseFrom(data, off, len);
                }

                @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
                public /* bridge */ /* synthetic */ Object parseFrom(byte[] data, int off, int len, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.parseFrom(data, off, len, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
                public /* bridge */ /* synthetic */ Object parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.parseFrom(data, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
                public /* bridge */ /* synthetic */ Object parsePartialDelimitedFrom(InputStream input) throws InvalidProtocolBufferException {
                    return super.parsePartialDelimitedFrom(input);
                }

                @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
                public /* bridge */ /* synthetic */ Object parsePartialDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.parsePartialDelimitedFrom(input, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
                public /* bridge */ /* synthetic */ Object parsePartialFrom(ByteString data) throws InvalidProtocolBufferException {
                    return super.parsePartialFrom(data);
                }

                @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
                public /* bridge */ /* synthetic */ Object parsePartialFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.parsePartialFrom(data, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
                public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream input) throws InvalidProtocolBufferException {
                    return super.parsePartialFrom(input);
                }

                @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
                public /* bridge */ /* synthetic */ Object parsePartialFrom(InputStream input) throws InvalidProtocolBufferException {
                    return super.parsePartialFrom(input);
                }

                @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
                public /* bridge */ /* synthetic */ Object parsePartialFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.parsePartialFrom(input, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
                public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] data) throws InvalidProtocolBufferException {
                    return super.parsePartialFrom(data);
                }

                @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
                public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] data, int off, int len) throws InvalidProtocolBufferException {
                    return super.parsePartialFrom(data, off, len);
                }

                @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
                public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] data, int off, int len, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.parsePartialFrom(data, off, len, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
                public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.parsePartialFrom(data, extensionRegistry);
                }

                @Override // com.google.protobuf.Parser
                public File parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    Builder builderNewBuilder = File.newBuilder();
                    try {
                        builderNewBuilder.mergeFrom(input, extensionRegistry);
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

            public static Parser<File> parser() {
                return PARSER;
            }

            @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Parser<File> getParserForType() {
                return PARSER;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public File getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public boolean hasError() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public String getError() {
            Object obj = this.error_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.error_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public ByteString getErrorBytes() {
            Object obj = this.error_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.error_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public boolean hasSupportedFeatures() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public long getSupportedFeatures() {
            return this.supportedFeatures_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public boolean hasMinimumEdition() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public int getMinimumEdition() {
            return this.minimumEdition_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public boolean hasMaximumEdition() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public int getMaximumEdition() {
            return this.maximumEdition_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public List<File> getFileList() {
            return this.file_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public List<? extends FileOrBuilder> getFileOrBuilderList() {
            return this.file_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public int getFileCount() {
            return this.file_.size();
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public File getFile(int index) {
            return this.file_.get(index);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public FileOrBuilder getFileOrBuilder(int index) {
            return this.file_.get(index);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream output) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                GeneratedMessage.writeString(output, 1, this.error_);
            }
            if ((this.bitField0_ & 2) != 0) {
                output.writeUInt64(2, this.supportedFeatures_);
            }
            if ((this.bitField0_ & 4) != 0) {
                output.writeInt32(3, this.minimumEdition_);
            }
            if ((this.bitField0_ & 8) != 0) {
                output.writeInt32(4, this.maximumEdition_);
            }
            for (int i = 0; i < this.file_.size(); i++) {
                output.writeMessage(15, this.file_.get(i));
            }
            getUnknownFields().writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int iComputeStringSize = (this.bitField0_ & 1) != 0 ? GeneratedMessage.computeStringSize(1, this.error_) : 0;
            if ((this.bitField0_ & 2) != 0) {
                iComputeStringSize += CodedOutputStream.computeUInt64Size(2, this.supportedFeatures_);
            }
            if ((this.bitField0_ & 4) != 0) {
                iComputeStringSize += CodedOutputStream.computeInt32Size(3, this.minimumEdition_);
            }
            if ((this.bitField0_ & 8) != 0) {
                iComputeStringSize += CodedOutputStream.computeInt32Size(4, this.maximumEdition_);
            }
            for (int i2 = 0; i2 < this.file_.size(); i2++) {
                iComputeStringSize += CodedOutputStream.computeMessageSize(15, this.file_.get(i2));
            }
            int serializedSize = iComputeStringSize + getUnknownFields().getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(final Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CodeGeneratorResponse)) {
                return super.equals(obj);
            }
            CodeGeneratorResponse codeGeneratorResponse = (CodeGeneratorResponse) obj;
            if (hasError() != codeGeneratorResponse.hasError()) {
                return false;
            }
            if ((hasError() && !getError().equals(codeGeneratorResponse.getError())) || hasSupportedFeatures() != codeGeneratorResponse.hasSupportedFeatures()) {
                return false;
            }
            if ((hasSupportedFeatures() && getSupportedFeatures() != codeGeneratorResponse.getSupportedFeatures()) || hasMinimumEdition() != codeGeneratorResponse.hasMinimumEdition()) {
                return false;
            }
            if ((!hasMinimumEdition() || getMinimumEdition() == codeGeneratorResponse.getMinimumEdition()) && hasMaximumEdition() == codeGeneratorResponse.hasMaximumEdition()) {
                return (!hasMaximumEdition() || getMaximumEdition() == codeGeneratorResponse.getMaximumEdition()) && getFileList().equals(codeGeneratorResponse.getFileList()) && getUnknownFields().equals(codeGeneratorResponse.getUnknownFields());
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = 779 + getDescriptor().hashCode();
            if (hasError()) {
                iHashCode = (((iHashCode * 37) + 1) * 53) + getError().hashCode();
            }
            if (hasSupportedFeatures()) {
                iHashCode = (((iHashCode * 37) + 2) * 53) + Internal.hashLong(getSupportedFeatures());
            }
            if (hasMinimumEdition()) {
                iHashCode = (((iHashCode * 37) + 3) * 53) + getMinimumEdition();
            }
            if (hasMaximumEdition()) {
                iHashCode = (((iHashCode * 37) + 4) * 53) + getMaximumEdition();
            }
            if (getFileCount() > 0) {
                iHashCode = (((iHashCode * 37) + 15) * 53) + getFileList().hashCode();
            }
            int iHashCode2 = (iHashCode * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = iHashCode2;
            return iHashCode2;
        }

        public static CodeGeneratorResponse parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CodeGeneratorResponse parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CodeGeneratorResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CodeGeneratorResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CodeGeneratorResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CodeGeneratorResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CodeGeneratorResponse parseFrom(InputStream input) throws IOException {
            return (CodeGeneratorResponse) GeneratedMessage.parseWithIOException(PARSER, input);
        }

        public static CodeGeneratorResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CodeGeneratorResponse) GeneratedMessage.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CodeGeneratorResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (CodeGeneratorResponse) GeneratedMessage.parseDelimitedWithIOException(PARSER, input);
        }

        public static CodeGeneratorResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CodeGeneratorResponse) GeneratedMessage.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CodeGeneratorResponse parseFrom(CodedInputStream input) throws IOException {
            return (CodeGeneratorResponse) GeneratedMessage.parseWithIOException(PARSER, input);
        }

        public static CodeGeneratorResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CodeGeneratorResponse) GeneratedMessage.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CodeGeneratorResponse prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder((AnonymousClass1) null) : new Builder((AnonymousClass1) null).mergeFrom(this);
        }

        /* INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.AbstractMessage
        public Builder newBuilderForType(AbstractMessage.BuilderParent parent) {
            return new Builder(parent, null);
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements CodeGeneratorResponseOrBuilder {
            private int bitField0_;
            private Object error_;
            private RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> fileBuilder_;
            private List<File> file_;
            private int maximumEdition_;
            private int minimumEdition_;
            private long supportedFeatures_;

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, AnonymousClass1 anonymousClass1) {
                this(builderParent);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder
            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(CodeGeneratorResponse.class, Builder.class);
            }

            private Builder() {
                this.error_ = "";
                this.file_ = Collections.emptyList();
            }

            private Builder(AbstractMessage.BuilderParent parent) {
                super(parent);
                this.error_ = "";
                this.file_ = Collections.emptyList();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.error_ = "";
                this.supportedFeatures_ = 0L;
                this.minimumEdition_ = 0;
                this.maximumEdition_ = 0;
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> repeatedFieldBuilder = this.fileBuilder_;
                if (repeatedFieldBuilder == null) {
                    this.file_ = Collections.emptyList();
                } else {
                    this.file_ = null;
                    repeatedFieldBuilder.clear();
                }
                this.bitField0_ &= -17;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CodeGeneratorResponse getDefaultInstanceForType() {
                return CodeGeneratorResponse.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CodeGeneratorResponse build() {
                CodeGeneratorResponse codeGeneratorResponseBuildPartial = buildPartial();
                if (codeGeneratorResponseBuildPartial.isInitialized()) {
                    return codeGeneratorResponseBuildPartial;
                }
                throw newUninitializedMessageException((Message) codeGeneratorResponseBuildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CodeGeneratorResponse buildPartial() {
                CodeGeneratorResponse codeGeneratorResponse = new CodeGeneratorResponse(this, null);
                buildPartialRepeatedFields(codeGeneratorResponse);
                if (this.bitField0_ != 0) {
                    buildPartial0(codeGeneratorResponse);
                }
                onBuilt();
                return codeGeneratorResponse;
            }

            private void buildPartialRepeatedFields(CodeGeneratorResponse result) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> repeatedFieldBuilder = this.fileBuilder_;
                if (repeatedFieldBuilder != null) {
                    result.file_ = repeatedFieldBuilder.build();
                    return;
                }
                if ((this.bitField0_ & 16) != 0) {
                    this.file_ = Collections.unmodifiableList(this.file_);
                    this.bitField0_ &= -17;
                }
                result.file_ = this.file_;
            }

            private void buildPartial0(CodeGeneratorResponse result) {
                int i;
                int i2 = this.bitField0_;
                if ((i2 & 1) != 0) {
                    result.error_ = this.error_;
                    i = 1;
                } else {
                    i = 0;
                }
                if ((i2 & 2) != 0) {
                    result.supportedFeatures_ = this.supportedFeatures_;
                    i |= 2;
                }
                if ((i2 & 4) != 0) {
                    result.minimumEdition_ = this.minimumEdition_;
                    i |= 4;
                }
                if ((i2 & 8) != 0) {
                    result.maximumEdition_ = this.maximumEdition_;
                    i |= 8;
                }
                CodeGeneratorResponse.access$4576(result, i);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message other) {
                if (other instanceof CodeGeneratorResponse) {
                    return mergeFrom((CodeGeneratorResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CodeGeneratorResponse other) {
                if (other == CodeGeneratorResponse.getDefaultInstance()) {
                    return this;
                }
                if (other.hasError()) {
                    this.error_ = other.error_;
                    this.bitField0_ |= 1;
                    onChanged();
                }
                if (other.hasSupportedFeatures()) {
                    setSupportedFeatures(other.getSupportedFeatures());
                }
                if (other.hasMinimumEdition()) {
                    setMinimumEdition(other.getMinimumEdition());
                }
                if (other.hasMaximumEdition()) {
                    setMaximumEdition(other.getMaximumEdition());
                }
                if (this.fileBuilder_ == null) {
                    if (!other.file_.isEmpty()) {
                        if (this.file_.isEmpty()) {
                            this.file_ = other.file_;
                            this.bitField0_ &= -17;
                        } else {
                            ensureFileIsMutable();
                            this.file_.addAll(other.file_);
                        }
                        onChanged();
                    }
                } else if (!other.file_.isEmpty()) {
                    if (!this.fileBuilder_.isEmpty()) {
                        this.fileBuilder_.addAllMessages(other.file_);
                    } else {
                        this.fileBuilder_.dispose();
                        this.fileBuilder_ = null;
                        this.file_ = other.file_;
                        this.bitField0_ &= -17;
                        this.fileBuilder_ = CodeGeneratorResponse.alwaysUseFieldBuilders ? getFileFieldBuilder() : null;
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                extensionRegistry.getClass();
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int tag = input.readTag();
                            if (tag != 0) {
                                if (tag == 10) {
                                    this.error_ = input.readBytes();
                                    this.bitField0_ |= 1;
                                } else if (tag == 16) {
                                    this.supportedFeatures_ = input.readUInt64();
                                    this.bitField0_ |= 2;
                                } else if (tag == 24) {
                                    this.minimumEdition_ = input.readInt32();
                                    this.bitField0_ |= 4;
                                } else if (tag == 32) {
                                    this.maximumEdition_ = input.readInt32();
                                    this.bitField0_ |= 8;
                                } else if (tag == 122) {
                                    File file = (File) input.readMessage(File.parser(), extensionRegistry);
                                    RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> repeatedFieldBuilder = this.fileBuilder_;
                                    if (repeatedFieldBuilder == null) {
                                        ensureFileIsMutable();
                                        this.file_.add(file);
                                    } else {
                                        repeatedFieldBuilder.addMessage(file);
                                    }
                                } else if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw e.unwrapIOException();
                        }
                    } catch (Throwable th) {
                        onChanged();
                        throw th;
                    }
                }
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public boolean hasError() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public String getError() {
                Object obj = this.error_;
                if (!(obj instanceof String)) {
                    ByteString byteString = (ByteString) obj;
                    String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.error_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public ByteString getErrorBytes() {
                Object obj = this.error_;
                if (obj instanceof String) {
                    ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.error_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setError(String value) {
                value.getClass();
                this.error_ = value;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder clearError() {
                this.error_ = CodeGeneratorResponse.getDefaultInstance().getError();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            public Builder setErrorBytes(ByteString value) {
                value.getClass();
                this.error_ = value;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public boolean hasSupportedFeatures() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public long getSupportedFeatures() {
                return this.supportedFeatures_;
            }

            public Builder setSupportedFeatures(long value) {
                this.supportedFeatures_ = value;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder clearSupportedFeatures() {
                this.bitField0_ &= -3;
                this.supportedFeatures_ = 0L;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public boolean hasMinimumEdition() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public int getMinimumEdition() {
                return this.minimumEdition_;
            }

            public Builder setMinimumEdition(int value) {
                this.minimumEdition_ = value;
                this.bitField0_ |= 4;
                onChanged();
                return this;
            }

            public Builder clearMinimumEdition() {
                this.bitField0_ &= -5;
                this.minimumEdition_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public boolean hasMaximumEdition() {
                return (this.bitField0_ & 8) != 0;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public int getMaximumEdition() {
                return this.maximumEdition_;
            }

            public Builder setMaximumEdition(int value) {
                this.maximumEdition_ = value;
                this.bitField0_ |= 8;
                onChanged();
                return this;
            }

            public Builder clearMaximumEdition() {
                this.bitField0_ &= -9;
                this.maximumEdition_ = 0;
                onChanged();
                return this;
            }

            private void ensureFileIsMutable() {
                if ((this.bitField0_ & 16) == 0) {
                    this.file_ = new ArrayList(this.file_);
                    this.bitField0_ |= 16;
                }
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public List<File> getFileList() {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> repeatedFieldBuilder = this.fileBuilder_;
                if (repeatedFieldBuilder == null) {
                    return Collections.unmodifiableList(this.file_);
                }
                return repeatedFieldBuilder.getMessageList();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public int getFileCount() {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> repeatedFieldBuilder = this.fileBuilder_;
                if (repeatedFieldBuilder == null) {
                    return this.file_.size();
                }
                return repeatedFieldBuilder.getCount();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public File getFile(int index) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> repeatedFieldBuilder = this.fileBuilder_;
                if (repeatedFieldBuilder == null) {
                    return this.file_.get(index);
                }
                return (File) repeatedFieldBuilder.getMessage(index);
            }

            public Builder setFile(int index, File value) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> repeatedFieldBuilder = this.fileBuilder_;
                if (repeatedFieldBuilder == null) {
                    value.getClass();
                    ensureFileIsMutable();
                    this.file_.set(index, value);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilder.setMessage(index, value);
                return this;
            }

            public Builder setFile(int index, File.Builder builderForValue) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> repeatedFieldBuilder = this.fileBuilder_;
                if (repeatedFieldBuilder == null) {
                    ensureFileIsMutable();
                    this.file_.set(index, builderForValue.build());
                    onChanged();
                    return this;
                }
                repeatedFieldBuilder.setMessage(index, builderForValue.build());
                return this;
            }

            public Builder addFile(File value) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> repeatedFieldBuilder = this.fileBuilder_;
                if (repeatedFieldBuilder == null) {
                    value.getClass();
                    ensureFileIsMutable();
                    this.file_.add(value);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilder.addMessage(value);
                return this;
            }

            public Builder addFile(int index, File value) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> repeatedFieldBuilder = this.fileBuilder_;
                if (repeatedFieldBuilder == null) {
                    value.getClass();
                    ensureFileIsMutable();
                    this.file_.add(index, value);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilder.addMessage(index, value);
                return this;
            }

            public Builder addFile(File.Builder builderForValue) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> repeatedFieldBuilder = this.fileBuilder_;
                if (repeatedFieldBuilder == null) {
                    ensureFileIsMutable();
                    this.file_.add(builderForValue.build());
                    onChanged();
                    return this;
                }
                repeatedFieldBuilder.addMessage(builderForValue.build());
                return this;
            }

            public Builder addFile(int index, File.Builder builderForValue) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> repeatedFieldBuilder = this.fileBuilder_;
                if (repeatedFieldBuilder == null) {
                    ensureFileIsMutable();
                    this.file_.add(index, builderForValue.build());
                    onChanged();
                    return this;
                }
                repeatedFieldBuilder.addMessage(index, builderForValue.build());
                return this;
            }

            public Builder addAllFile(Iterable<? extends File> values) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> repeatedFieldBuilder = this.fileBuilder_;
                if (repeatedFieldBuilder == null) {
                    ensureFileIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.file_);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilder.addAllMessages(values);
                return this;
            }

            public Builder clearFile() {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> repeatedFieldBuilder = this.fileBuilder_;
                if (repeatedFieldBuilder == null) {
                    this.file_ = Collections.emptyList();
                    this.bitField0_ &= -17;
                    onChanged();
                    return this;
                }
                repeatedFieldBuilder.clear();
                return this;
            }

            public Builder removeFile(int index) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> repeatedFieldBuilder = this.fileBuilder_;
                if (repeatedFieldBuilder == null) {
                    ensureFileIsMutable();
                    this.file_.remove(index);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilder.remove(index);
                return this;
            }

            public File.Builder getFileBuilder(int index) {
                return (File.Builder) getFileFieldBuilder().getBuilder(index);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public FileOrBuilder getFileOrBuilder(int index) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> repeatedFieldBuilder = this.fileBuilder_;
                if (repeatedFieldBuilder == null) {
                    return this.file_.get(index);
                }
                return (FileOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(index);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public List<? extends FileOrBuilder> getFileOrBuilderList() {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> repeatedFieldBuilder = this.fileBuilder_;
                if (repeatedFieldBuilder != null) {
                    return repeatedFieldBuilder.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.file_);
            }

            public File.Builder addFileBuilder() {
                return (File.Builder) getFileFieldBuilder().addBuilder(File.getDefaultInstance());
            }

            public File.Builder addFileBuilder(int index) {
                return (File.Builder) getFileFieldBuilder().addBuilder(index, File.getDefaultInstance());
            }

            public List<File.Builder> getFileBuilderList() {
                return getFileFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> getFileFieldBuilder() {
                if (this.fileBuilder_ == null) {
                    this.fileBuilder_ = new RepeatedFieldBuilder<>(this.file_, (this.bitField0_ & 16) != 0, getParentForChildren(), isClean());
                    this.file_ = null;
                }
                return this.fileBuilder_;
            }
        }

        public static CodeGeneratorResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* INFO: renamed from: com.google.protobuf.compiler.PluginProtos$CodeGeneratorResponse$1, reason: invalid class name */
        class AnonymousClass1 extends AbstractParser<CodeGeneratorResponse> {
            AnonymousClass1() {
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseDelimitedFrom(InputStream input) throws InvalidProtocolBufferException {
                return super.parseDelimitedFrom(input);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.parseDelimitedFrom(input, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return super.parseFrom(data);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.parseFrom(data, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(CodedInputStream input) throws InvalidProtocolBufferException {
                return super.parseFrom(input);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.parseFrom(input, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(InputStream input) throws InvalidProtocolBufferException {
                return super.parseFrom(input);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.parseFrom(input, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
                return super.parseFrom(data);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.parseFrom(data, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return super.parseFrom(data);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(byte[] data, int off, int len) throws InvalidProtocolBufferException {
                return super.parseFrom(data, off, len);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(byte[] data, int off, int len, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.parseFrom(data, off, len, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.parseFrom(data, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialDelimitedFrom(InputStream input) throws InvalidProtocolBufferException {
                return super.parsePartialDelimitedFrom(input);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.parsePartialDelimitedFrom(input, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(ByteString data) throws InvalidProtocolBufferException {
                return super.parsePartialFrom(data);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.parsePartialFrom(data, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream input) throws InvalidProtocolBufferException {
                return super.parsePartialFrom(input);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(InputStream input) throws InvalidProtocolBufferException {
                return super.parsePartialFrom(input);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.parsePartialFrom(input, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] data) throws InvalidProtocolBufferException {
                return super.parsePartialFrom(data);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] data, int off, int len) throws InvalidProtocolBufferException {
                return super.parsePartialFrom(data, off, len);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] data, int off, int len, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.parsePartialFrom(data, off, len, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.parsePartialFrom(data, extensionRegistry);
            }

            @Override // com.google.protobuf.Parser
            public CodeGeneratorResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                Builder builderNewBuilder = CodeGeneratorResponse.newBuilder();
                try {
                    builderNewBuilder.mergeFrom(input, extensionRegistry);
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

        public static Parser<CodeGeneratorResponse> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CodeGeneratorResponse> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CodeGeneratorResponse getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
