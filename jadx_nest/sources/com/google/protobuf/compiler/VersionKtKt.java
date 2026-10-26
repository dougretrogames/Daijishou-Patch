package com.google.protobuf.compiler;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: VersionKt.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0007\u001a)\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"version", "Lcom/google/protobuf/compiler/PluginProtos$Version;", "block", "Lkotlin/Function1;", "Lcom/google/protobuf/compiler/VersionKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeversion", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "java_kotlin-well_known_protos_kotlin"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class VersionKtKt {
    /* INFO: renamed from: -initializeversion, reason: not valid java name */
    public static final PluginProtos.Version m3454initializeversion(Function1<? super VersionKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        VersionKt.Dsl.Companion companion = VersionKt.Dsl.INSTANCE;
        PluginProtos.Version.Builder builderNewBuilder = PluginProtos.Version.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        VersionKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final /* synthetic */ PluginProtos.Version copy(PluginProtos.Version version, Function1<? super VersionKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(version, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        VersionKt.Dsl.Companion companion = VersionKt.Dsl.INSTANCE;
        PluginProtos.Version.Builder builder = version.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        VersionKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
