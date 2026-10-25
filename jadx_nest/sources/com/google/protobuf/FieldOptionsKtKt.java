package com.google.protobuf;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: FieldOptionsKt.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\t\u001a\u00020\n2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0010\u001a)\u0010\u0011\u001a\u00020\n*\u00020\n2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\u0086\bø\u0001\u0000\u001a)\u0010\u0011\u001a\u00020\u0012*\u00020\u00122\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\u0086\bø\u0001\u0000\u001a)\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\u0086\bø\u0001\u0000\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0015"}, d2 = {"featureSupportOrNull", "Lcom/google/protobuf/DescriptorProtos$FieldOptions$FeatureSupport;", "Lcom/google/protobuf/DescriptorProtos$FieldOptionsOrBuilder;", "getFeatureSupportOrNull", "(Lcom/google/protobuf/DescriptorProtos$FieldOptionsOrBuilder;)Lcom/google/protobuf/DescriptorProtos$FieldOptions$FeatureSupport;", "featuresOrNull", "Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "getFeaturesOrNull", "(Lcom/google/protobuf/DescriptorProtos$FieldOptionsOrBuilder;)Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "fieldOptions", "Lcom/google/protobuf/DescriptorProtos$FieldOptions;", "block", "Lkotlin/Function1;", "Lcom/google/protobuf/FieldOptionsKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializefieldOptions", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "Lcom/google/protobuf/DescriptorProtos$FieldOptions$EditionDefault;", "Lcom/google/protobuf/FieldOptionsKt$EditionDefaultKt$Dsl;", "Lcom/google/protobuf/FieldOptionsKt$FeatureSupportKt$Dsl;", "java_kotlin-well_known_protos_kotlin"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FieldOptionsKtKt {
    /* JADX INFO: renamed from: -initializefieldOptions, reason: not valid java name */
    public static final DescriptorProtos.FieldOptions m3410initializefieldOptions(Function1<? super FieldOptionsKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        FieldOptionsKt.Dsl.Companion companion = FieldOptionsKt.Dsl.INSTANCE;
        DescriptorProtos.FieldOptions.Builder builderNewBuilder = DescriptorProtos.FieldOptions.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        FieldOptionsKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final /* synthetic */ DescriptorProtos.FieldOptions copy(DescriptorProtos.FieldOptions fieldOptions, Function1<? super FieldOptionsKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(fieldOptions, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        FieldOptionsKt.Dsl.Companion companion = FieldOptionsKt.Dsl.INSTANCE;
        DescriptorProtos.FieldOptions.Builder builder = fieldOptions.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        FieldOptionsKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final /* synthetic */ DescriptorProtos.FieldOptions.EditionDefault copy(DescriptorProtos.FieldOptions.EditionDefault editionDefault, Function1<? super FieldOptionsKt.EditionDefaultKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(editionDefault, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        FieldOptionsKt.EditionDefaultKt.Dsl.Companion companion = FieldOptionsKt.EditionDefaultKt.Dsl.INSTANCE;
        DescriptorProtos.FieldOptions.EditionDefault.Builder builder = editionDefault.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        FieldOptionsKt.EditionDefaultKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final /* synthetic */ DescriptorProtos.FieldOptions.FeatureSupport copy(DescriptorProtos.FieldOptions.FeatureSupport featureSupport, Function1<? super FieldOptionsKt.FeatureSupportKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(featureSupport, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        FieldOptionsKt.FeatureSupportKt.Dsl.Companion companion = FieldOptionsKt.FeatureSupportKt.Dsl.INSTANCE;
        DescriptorProtos.FieldOptions.FeatureSupport.Builder builder = featureSupport.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        FieldOptionsKt.FeatureSupportKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final DescriptorProtos.FeatureSet getFeaturesOrNull(DescriptorProtos.FieldOptionsOrBuilder fieldOptionsOrBuilder) {
        Intrinsics.checkNotNullParameter(fieldOptionsOrBuilder, "<this>");
        if (fieldOptionsOrBuilder.hasFeatures()) {
            return fieldOptionsOrBuilder.getFeatures();
        }
        return null;
    }

    public static final DescriptorProtos.FieldOptions.FeatureSupport getFeatureSupportOrNull(DescriptorProtos.FieldOptionsOrBuilder fieldOptionsOrBuilder) {
        Intrinsics.checkNotNullParameter(fieldOptionsOrBuilder, "<this>");
        if (fieldOptionsOrBuilder.hasFeatureSupport()) {
            return fieldOptionsOrBuilder.getFeatureSupport();
        }
        return null;
    }
}
