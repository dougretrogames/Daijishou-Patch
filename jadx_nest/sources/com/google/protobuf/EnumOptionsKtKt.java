package com.google.protobuf;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: EnumOptionsKt.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0087\bø\u0001\u0000¢\u0006\u0002\b\f\u001a)\u0010\r\u001a\u00020\u0006*\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000e"}, d2 = {"featuresOrNull", "Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "Lcom/google/protobuf/DescriptorProtos$EnumOptionsOrBuilder;", "getFeaturesOrNull", "(Lcom/google/protobuf/DescriptorProtos$EnumOptionsOrBuilder;)Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "enumOptions", "Lcom/google/protobuf/DescriptorProtos$EnumOptions;", "block", "Lkotlin/Function1;", "Lcom/google/protobuf/EnumOptionsKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeenumOptions", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "java_kotlin-well_known_protos_kotlin"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class EnumOptionsKtKt {
    /* INFO: renamed from: -initializeenumOptions, reason: not valid java name */
    public static final DescriptorProtos.EnumOptions m3392initializeenumOptions(Function1<? super EnumOptionsKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        EnumOptionsKt.Dsl.Companion companion = EnumOptionsKt.Dsl.INSTANCE;
        DescriptorProtos.EnumOptions.Builder builderNewBuilder = DescriptorProtos.EnumOptions.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        EnumOptionsKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final /* synthetic */ DescriptorProtos.EnumOptions copy(DescriptorProtos.EnumOptions enumOptions, Function1<? super EnumOptionsKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(enumOptions, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        EnumOptionsKt.Dsl.Companion companion = EnumOptionsKt.Dsl.INSTANCE;
        DescriptorProtos.EnumOptions.Builder builder = enumOptions.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        EnumOptionsKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final DescriptorProtos.FeatureSet getFeaturesOrNull(DescriptorProtos.EnumOptionsOrBuilder enumOptionsOrBuilder) {
        Intrinsics.checkNotNullParameter(enumOptionsOrBuilder, "<this>");
        if (enumOptionsOrBuilder.hasFeatures()) {
            return enumOptionsOrBuilder.getFeatures();
        }
        return null;
    }
}
