package com.google.protobuf;

/* INFO: loaded from: classes4.dex */
public final class DurationProto {
    private static Descriptors.FileDescriptor descriptor;
    static final Descriptors.Descriptor internal_static_google_protobuf_Duration_descriptor;
    static final GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_Duration_fieldAccessorTable;

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private DurationProto() {
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", DurationProto.class.getName());
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001egoogle/protobuf/duration.proto\u0012\u000fgoogle.protobuf\":\n\bDuration\u0012\u0018\n\u0007seconds\u0018\u0001 \u0001(\u0003R\u0007seconds\u0012\u0014\n\u0005nanos\u0018\u0002 \u0001(\u0005R\u0005nanosB\u0083\u0001\n\u0013com.google.protobufB\rDurationProtoP\u0001Z1google.golang.org/protobuf/types/known/durationpbø\u0001\u0001¢\u0002\u0003GPBª\u0002\u001eGoogle.Protobuf.WellKnownTypesb\u0006proto3"}, new Descriptors.FileDescriptor[0]);
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_google_protobuf_Duration_descriptor = descriptor2;
        internal_static_google_protobuf_Duration_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(descriptor2, new String[]{"Seconds", "Nanos"});
        descriptor.resolveAllFeaturesImmutable();
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
