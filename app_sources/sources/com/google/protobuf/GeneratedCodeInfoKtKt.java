package com.google.protobuf;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: GeneratedCodeInfoKt.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0007\u001a)\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u001a)\u0010\b\u001a\u00020\t*\u00020\t2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000b"}, d2 = {"generatedCodeInfo", "Lcom/google/protobuf/DescriptorProtos$GeneratedCodeInfo;", "block", "Lkotlin/Function1;", "Lcom/google/protobuf/GeneratedCodeInfoKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializegeneratedCodeInfo", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "Lcom/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation;", "Lcom/google/protobuf/GeneratedCodeInfoKt$AnnotationKt$Dsl;", "java_kotlin-well_known_protos_kotlin"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class GeneratedCodeInfoKtKt {
    /* INFO: renamed from: -initializegeneratedCodeInfo, reason: not valid java name */
    public static final DescriptorProtos.GeneratedCodeInfo m3418initializegeneratedCodeInfo(Function1<? super GeneratedCodeInfoKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        GeneratedCodeInfoKt.Dsl.Companion companion = GeneratedCodeInfoKt.Dsl.INSTANCE;
        DescriptorProtos.GeneratedCodeInfo.Builder builderNewBuilder = DescriptorProtos.GeneratedCodeInfo.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        GeneratedCodeInfoKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final /* synthetic */ DescriptorProtos.GeneratedCodeInfo copy(DescriptorProtos.GeneratedCodeInfo generatedCodeInfo, Function1<? super GeneratedCodeInfoKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(generatedCodeInfo, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        GeneratedCodeInfoKt.Dsl.Companion companion = GeneratedCodeInfoKt.Dsl.INSTANCE;
        DescriptorProtos.GeneratedCodeInfo.Builder builder = generatedCodeInfo.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        GeneratedCodeInfoKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final /* synthetic */ DescriptorProtos.GeneratedCodeInfo.Annotation copy(DescriptorProtos.GeneratedCodeInfo.Annotation annotation, Function1<? super GeneratedCodeInfoKt.AnnotationKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(annotation, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        GeneratedCodeInfoKt.AnnotationKt.Dsl.Companion companion = GeneratedCodeInfoKt.AnnotationKt.Dsl.INSTANCE;
        DescriptorProtos.GeneratedCodeInfo.Annotation.Builder builder = annotation.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        GeneratedCodeInfoKt.AnnotationKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
