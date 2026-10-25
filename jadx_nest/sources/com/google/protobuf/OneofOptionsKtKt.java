package com.google.protobuf;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: OneofOptionsKt.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0087\bø\u0001\u0000¢\u0006\u0002\b\f\u001a)\u0010\r\u001a\u00020\u0006*\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000e"}, d2 = {"featuresOrNull", "Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "Lcom/google/protobuf/DescriptorProtos$OneofOptionsOrBuilder;", "getFeaturesOrNull", "(Lcom/google/protobuf/DescriptorProtos$OneofOptionsOrBuilder;)Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "oneofOptions", "Lcom/google/protobuf/DescriptorProtos$OneofOptions;", "block", "Lkotlin/Function1;", "Lcom/google/protobuf/OneofOptionsKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeoneofOptions", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "java_kotlin-well_known_protos_kotlin"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class OneofOptionsKtKt {
    /* JADX INFO: renamed from: -initializeoneofOptions, reason: not valid java name */
    public static final DescriptorProtos.OneofOptions m3432initializeoneofOptions(Function1<? super OneofOptionsKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        OneofOptionsKt.Dsl.Companion companion = OneofOptionsKt.Dsl.INSTANCE;
        DescriptorProtos.OneofOptions.Builder builderNewBuilder = DescriptorProtos.OneofOptions.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        OneofOptionsKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final /* synthetic */ DescriptorProtos.OneofOptions copy(DescriptorProtos.OneofOptions oneofOptions, Function1<? super OneofOptionsKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(oneofOptions, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        OneofOptionsKt.Dsl.Companion companion = OneofOptionsKt.Dsl.INSTANCE;
        DescriptorProtos.OneofOptions.Builder builder = oneofOptions.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        OneofOptionsKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final DescriptorProtos.FeatureSet getFeaturesOrNull(DescriptorProtos.OneofOptionsOrBuilder oneofOptionsOrBuilder) {
        Intrinsics.checkNotNullParameter(oneofOptionsOrBuilder, "<this>");
        if (oneofOptionsOrBuilder.hasFeatures()) {
            return oneofOptionsOrBuilder.getFeatures();
        }
        return null;
    }
}
