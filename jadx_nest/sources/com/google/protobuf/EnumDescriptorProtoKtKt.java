package com.google.protobuf;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: EnumDescriptorProtoKt.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0087\bø\u0001\u0000¢\u0006\u0002\b\f\u001a)\u0010\r\u001a\u00020\u0006*\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001a)\u0010\r\u001a\u00020\u000e*\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, d2 = {"optionsOrNull", "Lcom/google/protobuf/DescriptorProtos$EnumOptions;", "Lcom/google/protobuf/DescriptorProtos$EnumDescriptorProtoOrBuilder;", "getOptionsOrNull", "(Lcom/google/protobuf/DescriptorProtos$EnumDescriptorProtoOrBuilder;)Lcom/google/protobuf/DescriptorProtos$EnumOptions;", "enumDescriptorProto", "Lcom/google/protobuf/DescriptorProtos$EnumDescriptorProto;", "block", "Lkotlin/Function1;", "Lcom/google/protobuf/EnumDescriptorProtoKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeenumDescriptorProto", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "Lcom/google/protobuf/DescriptorProtos$EnumDescriptorProto$EnumReservedRange;", "Lcom/google/protobuf/EnumDescriptorProtoKt$EnumReservedRangeKt$Dsl;", "java_kotlin-well_known_protos_kotlin"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class EnumDescriptorProtoKtKt {
    /* JADX INFO: renamed from: -initializeenumDescriptorProto, reason: not valid java name */
    public static final DescriptorProtos.EnumDescriptorProto m3389initializeenumDescriptorProto(Function1<? super EnumDescriptorProtoKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        EnumDescriptorProtoKt.Dsl.Companion companion = EnumDescriptorProtoKt.Dsl.INSTANCE;
        DescriptorProtos.EnumDescriptorProto.Builder builderNewBuilder = DescriptorProtos.EnumDescriptorProto.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        EnumDescriptorProtoKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final /* synthetic */ DescriptorProtos.EnumDescriptorProto copy(DescriptorProtos.EnumDescriptorProto enumDescriptorProto, Function1<? super EnumDescriptorProtoKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(enumDescriptorProto, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        EnumDescriptorProtoKt.Dsl.Companion companion = EnumDescriptorProtoKt.Dsl.INSTANCE;
        DescriptorProtos.EnumDescriptorProto.Builder builder = enumDescriptorProto.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        EnumDescriptorProtoKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final /* synthetic */ DescriptorProtos.EnumDescriptorProto.EnumReservedRange copy(DescriptorProtos.EnumDescriptorProto.EnumReservedRange enumReservedRange, Function1<? super EnumDescriptorProtoKt.EnumReservedRangeKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(enumReservedRange, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        EnumDescriptorProtoKt.EnumReservedRangeKt.Dsl.Companion companion = EnumDescriptorProtoKt.EnumReservedRangeKt.Dsl.INSTANCE;
        DescriptorProtos.EnumDescriptorProto.EnumReservedRange.Builder builder = enumReservedRange.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        EnumDescriptorProtoKt.EnumReservedRangeKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final DescriptorProtos.EnumOptions getOptionsOrNull(DescriptorProtos.EnumDescriptorProtoOrBuilder enumDescriptorProtoOrBuilder) {
        Intrinsics.checkNotNullParameter(enumDescriptorProtoOrBuilder, "<this>");
        if (enumDescriptorProtoOrBuilder.hasOptions()) {
            return enumDescriptorProtoOrBuilder.getOptions();
        }
        return null;
    }
}
