package com.google.protobuf.compiler;

import com.google.protobuf.DescriptorProtos;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: CodeGeneratorResponseKt.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0087\bø\u0001\u0000¢\u0006\u0002\b\f\u001a)\u0010\r\u001a\u00020\u0006*\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001a)\u0010\r\u001a\u00020\u000e*\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, d2 = {"generatedCodeInfoOrNull", "Lcom/google/protobuf/DescriptorProtos$GeneratedCodeInfo;", "Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$FileOrBuilder;", "getGeneratedCodeInfoOrNull", "(Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$FileOrBuilder;)Lcom/google/protobuf/DescriptorProtos$GeneratedCodeInfo;", "codeGeneratorResponse", "Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse;", "block", "Lkotlin/Function1;", "Lcom/google/protobuf/compiler/CodeGeneratorResponseKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializecodeGeneratorResponse", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File;", "Lcom/google/protobuf/compiler/CodeGeneratorResponseKt$FileKt$Dsl;", "java_kotlin-well_known_protos_kotlin"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CodeGeneratorResponseKtKt {
    /* INFO: renamed from: -initializecodeGeneratorResponse, reason: not valid java name */
    public static final PluginProtos.CodeGeneratorResponse m3453initializecodeGeneratorResponse(Function1<? super CodeGeneratorResponseKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        CodeGeneratorResponseKt.Dsl.Companion companion = CodeGeneratorResponseKt.Dsl.INSTANCE;
        PluginProtos.CodeGeneratorResponse.Builder builderNewBuilder = PluginProtos.CodeGeneratorResponse.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        CodeGeneratorResponseKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final /* synthetic */ PluginProtos.CodeGeneratorResponse copy(PluginProtos.CodeGeneratorResponse codeGeneratorResponse, Function1<? super CodeGeneratorResponseKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(codeGeneratorResponse, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        CodeGeneratorResponseKt.Dsl.Companion companion = CodeGeneratorResponseKt.Dsl.INSTANCE;
        PluginProtos.CodeGeneratorResponse.Builder builder = codeGeneratorResponse.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        CodeGeneratorResponseKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final /* synthetic */ PluginProtos.CodeGeneratorResponse.File copy(PluginProtos.CodeGeneratorResponse.File file, Function1<? super CodeGeneratorResponseKt.FileKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        CodeGeneratorResponseKt.FileKt.Dsl.Companion companion = CodeGeneratorResponseKt.FileKt.Dsl.INSTANCE;
        PluginProtos.CodeGeneratorResponse.File.Builder builder = file.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        CodeGeneratorResponseKt.FileKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final DescriptorProtos.GeneratedCodeInfo getGeneratedCodeInfoOrNull(PluginProtos.CodeGeneratorResponse.FileOrBuilder fileOrBuilder) {
        Intrinsics.checkNotNullParameter(fileOrBuilder, "<this>");
        if (fileOrBuilder.hasGeneratedCodeInfo()) {
            return fileOrBuilder.getGeneratedCodeInfo();
        }
        return null;
    }
}
