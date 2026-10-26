package com.google.protobuf;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: FileDescriptorProtoKt.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\t\u001a\u00020\n2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0010\u001a)\u0010\u0011\u001a\u00020\n*\u00020\n2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\u0086\bø\u0001\u0000\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2 = {"optionsOrNull", "Lcom/google/protobuf/DescriptorProtos$FileOptions;", "Lcom/google/protobuf/DescriptorProtos$FileDescriptorProtoOrBuilder;", "getOptionsOrNull", "(Lcom/google/protobuf/DescriptorProtos$FileDescriptorProtoOrBuilder;)Lcom/google/protobuf/DescriptorProtos$FileOptions;", "sourceCodeInfoOrNull", "Lcom/google/protobuf/DescriptorProtos$SourceCodeInfo;", "getSourceCodeInfoOrNull", "(Lcom/google/protobuf/DescriptorProtos$FileDescriptorProtoOrBuilder;)Lcom/google/protobuf/DescriptorProtos$SourceCodeInfo;", "fileDescriptorProto", "Lcom/google/protobuf/DescriptorProtos$FileDescriptorProto;", "block", "Lkotlin/Function1;", "Lcom/google/protobuf/FileDescriptorProtoKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializefileDescriptorProto", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "java_kotlin-well_known_protos_kotlin"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FileDescriptorProtoKtKt {
    /* INFO: renamed from: -initializefileDescriptorProto, reason: not valid java name */
    public static final DescriptorProtos.FileDescriptorProto m3412initializefileDescriptorProto(Function1<? super FileDescriptorProtoKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        FileDescriptorProtoKt.Dsl.Companion companion = FileDescriptorProtoKt.Dsl.INSTANCE;
        DescriptorProtos.FileDescriptorProto.Builder builderNewBuilder = DescriptorProtos.FileDescriptorProto.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        FileDescriptorProtoKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final /* synthetic */ DescriptorProtos.FileDescriptorProto copy(DescriptorProtos.FileDescriptorProto fileDescriptorProto, Function1<? super FileDescriptorProtoKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(fileDescriptorProto, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        FileDescriptorProtoKt.Dsl.Companion companion = FileDescriptorProtoKt.Dsl.INSTANCE;
        DescriptorProtos.FileDescriptorProto.Builder builder = fileDescriptorProto.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        FileDescriptorProtoKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final DescriptorProtos.FileOptions getOptionsOrNull(DescriptorProtos.FileDescriptorProtoOrBuilder fileDescriptorProtoOrBuilder) {
        Intrinsics.checkNotNullParameter(fileDescriptorProtoOrBuilder, "<this>");
        if (fileDescriptorProtoOrBuilder.hasOptions()) {
            return fileDescriptorProtoOrBuilder.getOptions();
        }
        return null;
    }

    public static final DescriptorProtos.SourceCodeInfo getSourceCodeInfoOrNull(DescriptorProtos.FileDescriptorProtoOrBuilder fileDescriptorProtoOrBuilder) {
        Intrinsics.checkNotNullParameter(fileDescriptorProtoOrBuilder, "<this>");
        if (fileDescriptorProtoOrBuilder.hasSourceCodeInfo()) {
            return fileDescriptorProtoOrBuilder.getSourceCodeInfo();
        }
        return null;
    }
}
