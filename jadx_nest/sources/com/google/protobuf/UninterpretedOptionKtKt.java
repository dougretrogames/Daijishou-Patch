package com.google.protobuf;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: UninterpretedOptionKt.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0007\u001a)\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u001a)\u0010\b\u001a\u00020\t*\u00020\t2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000b"}, d2 = {"uninterpretedOption", "Lcom/google/protobuf/DescriptorProtos$UninterpretedOption;", "block", "Lkotlin/Function1;", "Lcom/google/protobuf/UninterpretedOptionKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeuninterpretedOption", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "Lcom/google/protobuf/DescriptorProtos$UninterpretedOption$NamePart;", "Lcom/google/protobuf/UninterpretedOptionKt$NamePartKt$Dsl;", "java_kotlin-well_known_protos_kotlin"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class UninterpretedOptionKtKt {
    /* JADX INFO: renamed from: -initializeuninterpretedOption, reason: not valid java name */
    public static final DescriptorProtos.UninterpretedOption m3447initializeuninterpretedOption(Function1<? super UninterpretedOptionKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        UninterpretedOptionKt.Dsl.Companion companion = UninterpretedOptionKt.Dsl.INSTANCE;
        DescriptorProtos.UninterpretedOption.Builder builderNewBuilder = DescriptorProtos.UninterpretedOption.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        UninterpretedOptionKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final /* synthetic */ DescriptorProtos.UninterpretedOption copy(DescriptorProtos.UninterpretedOption uninterpretedOption, Function1<? super UninterpretedOptionKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(uninterpretedOption, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        UninterpretedOptionKt.Dsl.Companion companion = UninterpretedOptionKt.Dsl.INSTANCE;
        DescriptorProtos.UninterpretedOption.Builder builder = uninterpretedOption.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        UninterpretedOptionKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final /* synthetic */ DescriptorProtos.UninterpretedOption.NamePart copy(DescriptorProtos.UninterpretedOption.NamePart namePart, Function1<? super UninterpretedOptionKt.NamePartKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(namePart, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        UninterpretedOptionKt.NamePartKt.Dsl.Companion companion = UninterpretedOptionKt.NamePartKt.Dsl.INSTANCE;
        DescriptorProtos.UninterpretedOption.NamePart.Builder builder = namePart.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        UninterpretedOptionKt.NamePartKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
