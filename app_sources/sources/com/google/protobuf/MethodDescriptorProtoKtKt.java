package com.google.protobuf;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: MethodDescriptorProtoKt.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0087\bø\u0001\u0000¢\u0006\u0002\b\f\u001a)\u0010\r\u001a\u00020\u0006*\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000e"}, d2 = {"optionsOrNull", "Lcom/google/protobuf/DescriptorProtos$MethodOptions;", "Lcom/google/protobuf/DescriptorProtos$MethodDescriptorProtoOrBuilder;", "getOptionsOrNull", "(Lcom/google/protobuf/DescriptorProtos$MethodDescriptorProtoOrBuilder;)Lcom/google/protobuf/DescriptorProtos$MethodOptions;", "methodDescriptorProto", "Lcom/google/protobuf/DescriptorProtos$MethodDescriptorProto;", "block", "Lkotlin/Function1;", "Lcom/google/protobuf/MethodDescriptorProtoKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializemethodDescriptorProto", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "java_kotlin-well_known_protos_kotlin"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MethodDescriptorProtoKtKt {
    /* INFO: renamed from: -initializemethodDescriptorProto, reason: not valid java name */
    public static final DescriptorProtos.MethodDescriptorProto m3425initializemethodDescriptorProto(Function1<? super MethodDescriptorProtoKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        MethodDescriptorProtoKt.Dsl.Companion companion = MethodDescriptorProtoKt.Dsl.INSTANCE;
        DescriptorProtos.MethodDescriptorProto.Builder builderNewBuilder = DescriptorProtos.MethodDescriptorProto.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        MethodDescriptorProtoKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final /* synthetic */ DescriptorProtos.MethodDescriptorProto copy(DescriptorProtos.MethodDescriptorProto methodDescriptorProto, Function1<? super MethodDescriptorProtoKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(methodDescriptorProto, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        MethodDescriptorProtoKt.Dsl.Companion companion = MethodDescriptorProtoKt.Dsl.INSTANCE;
        DescriptorProtos.MethodDescriptorProto.Builder builder = methodDescriptorProto.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        MethodDescriptorProtoKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final DescriptorProtos.MethodOptions getOptionsOrNull(DescriptorProtos.MethodDescriptorProtoOrBuilder methodDescriptorProtoOrBuilder) {
        Intrinsics.checkNotNullParameter(methodDescriptorProtoOrBuilder, "<this>");
        if (methodDescriptorProtoOrBuilder.hasOptions()) {
            return methodDescriptorProtoOrBuilder.getOptions();
        }
        return null;
    }
}
