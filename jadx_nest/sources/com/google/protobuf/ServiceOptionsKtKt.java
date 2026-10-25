package com.google.protobuf;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: ServiceOptionsKt.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0087\bø\u0001\u0000¢\u0006\u0002\b\f\u001a)\u0010\r\u001a\u00020\u0006*\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000e"}, d2 = {"featuresOrNull", "Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "Lcom/google/protobuf/DescriptorProtos$ServiceOptionsOrBuilder;", "getFeaturesOrNull", "(Lcom/google/protobuf/DescriptorProtos$ServiceOptionsOrBuilder;)Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "serviceOptions", "Lcom/google/protobuf/DescriptorProtos$ServiceOptions;", "block", "Lkotlin/Function1;", "Lcom/google/protobuf/ServiceOptionsKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeserviceOptions", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "java_kotlin-well_known_protos_kotlin"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ServiceOptionsKtKt {
    /* JADX INFO: renamed from: -initializeserviceOptions, reason: not valid java name */
    public static final DescriptorProtos.ServiceOptions m3436initializeserviceOptions(Function1<? super ServiceOptionsKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ServiceOptionsKt.Dsl.Companion companion = ServiceOptionsKt.Dsl.INSTANCE;
        DescriptorProtos.ServiceOptions.Builder builderNewBuilder = DescriptorProtos.ServiceOptions.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        ServiceOptionsKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final /* synthetic */ DescriptorProtos.ServiceOptions copy(DescriptorProtos.ServiceOptions serviceOptions, Function1<? super ServiceOptionsKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(serviceOptions, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ServiceOptionsKt.Dsl.Companion companion = ServiceOptionsKt.Dsl.INSTANCE;
        DescriptorProtos.ServiceOptions.Builder builder = serviceOptions.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        ServiceOptionsKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final DescriptorProtos.FeatureSet getFeaturesOrNull(DescriptorProtos.ServiceOptionsOrBuilder serviceOptionsOrBuilder) {
        Intrinsics.checkNotNullParameter(serviceOptionsOrBuilder, "<this>");
        if (serviceOptionsOrBuilder.hasFeatures()) {
            return serviceOptionsOrBuilder.getFeatures();
        }
        return null;
    }
}
