package com.google.protobuf;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: FieldDescriptorProtoKt.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0087\bø\u0001\u0000¢\u0006\u0002\b\f\u001a)\u0010\r\u001a\u00020\u0006*\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000e"}, d2 = {"optionsOrNull", "Lcom/google/protobuf/DescriptorProtos$FieldOptions;", "Lcom/google/protobuf/DescriptorProtos$FieldDescriptorProtoOrBuilder;", "getOptionsOrNull", "(Lcom/google/protobuf/DescriptorProtos$FieldDescriptorProtoOrBuilder;)Lcom/google/protobuf/DescriptorProtos$FieldOptions;", "fieldDescriptorProto", "Lcom/google/protobuf/DescriptorProtos$FieldDescriptorProto;", "block", "Lkotlin/Function1;", "Lcom/google/protobuf/FieldDescriptorProtoKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializefieldDescriptorProto", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "java_kotlin-well_known_protos_kotlin"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FieldDescriptorProtoKtKt {
    /* INFO: renamed from: -initializefieldDescriptorProto, reason: not valid java name */
    public static final DescriptorProtos.FieldDescriptorProto m3404initializefieldDescriptorProto(Function1<? super FieldDescriptorProtoKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        FieldDescriptorProtoKt.Dsl.Companion companion = FieldDescriptorProtoKt.Dsl.INSTANCE;
        DescriptorProtos.FieldDescriptorProto.Builder builderNewBuilder = DescriptorProtos.FieldDescriptorProto.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        FieldDescriptorProtoKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final /* synthetic */ DescriptorProtos.FieldDescriptorProto copy(DescriptorProtos.FieldDescriptorProto fieldDescriptorProto, Function1<? super FieldDescriptorProtoKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(fieldDescriptorProto, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        FieldDescriptorProtoKt.Dsl.Companion companion = FieldDescriptorProtoKt.Dsl.INSTANCE;
        DescriptorProtos.FieldDescriptorProto.Builder builder = fieldDescriptorProto.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        FieldDescriptorProtoKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final DescriptorProtos.FieldOptions getOptionsOrNull(DescriptorProtos.FieldDescriptorProtoOrBuilder fieldDescriptorProtoOrBuilder) {
        Intrinsics.checkNotNullParameter(fieldDescriptorProtoOrBuilder, "<this>");
        if (fieldDescriptorProtoOrBuilder.hasOptions()) {
            return fieldDescriptorProtoOrBuilder.getOptions();
        }
        return null;
    }
}
