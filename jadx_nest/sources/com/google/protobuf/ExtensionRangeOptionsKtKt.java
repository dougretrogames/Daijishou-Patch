package com.google.protobuf;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: ExtensionRangeOptionsKt.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0087\bø\u0001\u0000¢\u0006\u0002\b\f\u001a)\u0010\r\u001a\u00020\u0006*\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001a)\u0010\r\u001a\u00020\u000e*\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, d2 = {"featuresOrNull", "Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "Lcom/google/protobuf/DescriptorProtos$ExtensionRangeOptionsOrBuilder;", "getFeaturesOrNull", "(Lcom/google/protobuf/DescriptorProtos$ExtensionRangeOptionsOrBuilder;)Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "extensionRangeOptions", "Lcom/google/protobuf/DescriptorProtos$ExtensionRangeOptions;", "block", "Lkotlin/Function1;", "Lcom/google/protobuf/ExtensionRangeOptionsKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeextensionRangeOptions", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "Lcom/google/protobuf/DescriptorProtos$ExtensionRangeOptions$Declaration;", "Lcom/google/protobuf/ExtensionRangeOptionsKt$DeclarationKt$Dsl;", "java_kotlin-well_known_protos_kotlin"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ExtensionRangeOptionsKtKt {
    /* JADX INFO: renamed from: -initializeextensionRangeOptions, reason: not valid java name */
    public static final DescriptorProtos.ExtensionRangeOptions m3399initializeextensionRangeOptions(Function1<? super ExtensionRangeOptionsKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ExtensionRangeOptionsKt.Dsl.Companion companion = ExtensionRangeOptionsKt.Dsl.INSTANCE;
        DescriptorProtos.ExtensionRangeOptions.Builder builderNewBuilder = DescriptorProtos.ExtensionRangeOptions.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        ExtensionRangeOptionsKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final /* synthetic */ DescriptorProtos.ExtensionRangeOptions copy(DescriptorProtos.ExtensionRangeOptions extensionRangeOptions, Function1<? super ExtensionRangeOptionsKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(extensionRangeOptions, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ExtensionRangeOptionsKt.Dsl.Companion companion = ExtensionRangeOptionsKt.Dsl.INSTANCE;
        DescriptorProtos.ExtensionRangeOptions.Builder builder = extensionRangeOptions.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        ExtensionRangeOptionsKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final /* synthetic */ DescriptorProtos.ExtensionRangeOptions.Declaration copy(DescriptorProtos.ExtensionRangeOptions.Declaration declaration, Function1<? super ExtensionRangeOptionsKt.DeclarationKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(declaration, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ExtensionRangeOptionsKt.DeclarationKt.Dsl.Companion companion = ExtensionRangeOptionsKt.DeclarationKt.Dsl.INSTANCE;
        DescriptorProtos.ExtensionRangeOptions.Declaration.Builder builder = declaration.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        ExtensionRangeOptionsKt.DeclarationKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final DescriptorProtos.FeatureSet getFeaturesOrNull(DescriptorProtos.ExtensionRangeOptionsOrBuilder extensionRangeOptionsOrBuilder) {
        Intrinsics.checkNotNullParameter(extensionRangeOptionsOrBuilder, "<this>");
        if (extensionRangeOptionsOrBuilder.hasFeatures()) {
            return extensionRangeOptionsOrBuilder.getFeatures();
        }
        return null;
    }
}
