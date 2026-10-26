package com.google.protobuf.compiler;

import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslProxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: CodeGeneratorRequestKt.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/google/protobuf/compiler/CodeGeneratorRequestKt;", "", "()V", "Dsl", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CodeGeneratorRequestKt {
    public static final CodeGeneratorRequestKt INSTANCE = new CodeGeneratorRequestKt();

    /* INFO: compiled from: CodeGeneratorRequestKt.kt */
    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u001c\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u0000 D2\u00020\u0001:\u0004DEFGB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010!\u001a\u00020\"H\u0001J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020$J\u0006\u0010&\u001a\u00020'J\u0006\u0010(\u001a\u00020'J%\u0010)\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\r2\u0006\u0010\u0005\u001a\u00020\u0018H\u0007¢\u0006\u0002\b*J%\u0010)\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001c0\r2\u0006\u0010\u0005\u001a\u00020\u0018H\u0007¢\u0006\u0002\b+J%\u0010)\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u0005\u001a\u00020\u000eH\u0007¢\u0006\u0002\b,J+\u0010-\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\r2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00180/H\u0007¢\u0006\u0002\b0J+\u0010-\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001c0\r2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00180/H\u0007¢\u0006\u0002\b1J+\u0010-\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000e0/H\u0007¢\u0006\u0002\b2J\u001d\u00103\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\rH\u0007¢\u0006\u0002\b4J\u001d\u00103\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001c0\rH\u0007¢\u0006\u0002\b5J\u001d\u00103\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH\u0007¢\u0006\u0002\b6J&\u00107\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\r2\u0006\u0010\u0005\u001a\u00020\u0018H\u0087\n¢\u0006\u0002\b8J,\u00107\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\r2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00180/H\u0087\n¢\u0006\u0002\b9J&\u00107\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001c0\r2\u0006\u0010\u0005\u001a\u00020\u0018H\u0087\n¢\u0006\u0002\b:J,\u00107\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001c0\r2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00180/H\u0087\n¢\u0006\u0002\b;J&\u00107\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u0005\u001a\u00020\u000eH\u0087\n¢\u0006\u0002\b<J,\u00107\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000e0/H\u0087\n¢\u0006\u0002\b=J.\u0010>\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\r2\u0006\u0010?\u001a\u00020@2\u0006\u0010\u0005\u001a\u00020\u0018H\u0087\u0002¢\u0006\u0002\bAJ.\u0010>\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001c0\r2\u0006\u0010?\u001a\u00020@2\u0006\u0010\u0005\u001a\u00020\u0018H\u0087\u0002¢\u0006\u0002\bBJ.\u0010>\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010?\u001a\u00020@2\u0006\u0010\u0005\u001a\u00020\u000eH\u0087\u0002¢\u0006\u0002\bCR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000e8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\r8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0011R\u001d\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001c0\r8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0011R\u0017\u0010\u001e\u001a\u0004\u0018\u00010\u0006*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006H"}, d2 = {"Lcom/google/protobuf/compiler/CodeGeneratorRequestKt$Dsl;", "", "_builder", "Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest$Builder;", "(Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest$Builder;)V", "value", "Lcom/google/protobuf/compiler/PluginProtos$Version;", "compilerVersion", "getCompilerVersion", "()Lcom/google/protobuf/compiler/PluginProtos$Version;", "setCompilerVersion", "(Lcom/google/protobuf/compiler/PluginProtos$Version;)V", "fileToGenerate", "Lcom/google/protobuf/kotlin/DslList;", "", "Lcom/google/protobuf/compiler/CodeGeneratorRequestKt$Dsl$FileToGenerateProxy;", "getFileToGenerate", "()Lcom/google/protobuf/kotlin/DslList;", "parameter", "getParameter", "()Ljava/lang/String;", "setParameter", "(Ljava/lang/String;)V", "protoFile", "Lcom/google/protobuf/DescriptorProtos$FileDescriptorProto;", "Lcom/google/protobuf/compiler/CodeGeneratorRequestKt$Dsl$ProtoFileProxy;", "getProtoFile", "sourceFileDescriptors", "Lcom/google/protobuf/compiler/CodeGeneratorRequestKt$Dsl$SourceFileDescriptorsProxy;", "getSourceFileDescriptors", "compilerVersionOrNull", "getCompilerVersionOrNull", "(Lcom/google/protobuf/compiler/CodeGeneratorRequestKt$Dsl;)Lcom/google/protobuf/compiler/PluginProtos$Version;", "_build", "Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest;", "clearCompilerVersion", "", "clearParameter", "hasCompilerVersion", "", "hasParameter", "add", "addProtoFile", "addSourceFileDescriptors", "addFileToGenerate", "addAll", "values", "", "addAllProtoFile", "addAllSourceFileDescriptors", "addAllFileToGenerate", "clear", "clearProtoFile", "clearSourceFileDescriptors", "clearFileToGenerate", "plusAssign", "plusAssignProtoFile", "plusAssignAllProtoFile", "plusAssignSourceFileDescriptors", "plusAssignAllSourceFileDescriptors", "plusAssignFileToGenerate", "plusAssignAllFileToGenerate", "set", ConfigConstants.CONFIG_INDEX_SECTION, "", "setProtoFile", "setSourceFileDescriptors", "setFileToGenerate", "Companion", "FileToGenerateProxy", "ProtoFileProxy", "SourceFileDescriptorsProxy", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Dsl {

        /* INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final PluginProtos.CodeGeneratorRequest.Builder _builder;

        public /* synthetic */ Dsl(PluginProtos.CodeGeneratorRequest.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        private Dsl(PluginProtos.CodeGeneratorRequest.Builder builder) {
            this._builder = builder;
        }

        /* INFO: compiled from: CodeGeneratorRequestKt.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/compiler/CodeGeneratorRequestKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/compiler/CodeGeneratorRequestKt$Dsl;", "builder", "Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest$Builder;", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final /* synthetic */ Dsl _create(PluginProtos.CodeGeneratorRequest.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public final /* synthetic */ PluginProtos.CodeGeneratorRequest _build() {
            PluginProtos.CodeGeneratorRequest codeGeneratorRequestBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(codeGeneratorRequestBuild, "_builder.build()");
            return codeGeneratorRequestBuild;
        }

        /* INFO: compiled from: CodeGeneratorRequestKt.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/compiler/CodeGeneratorRequestKt$Dsl$FileToGenerateProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class FileToGenerateProxy extends DslProxy {
            private FileToGenerateProxy() {
            }
        }

        public final /* synthetic */ DslList getFileToGenerate() {
            ProtocolStringList fileToGenerateList = this._builder.getFileToGenerateList();
            Intrinsics.checkNotNullExpressionValue(fileToGenerateList, "_builder.getFileToGenerateList()");
            return new DslList(fileToGenerateList);
        }

        public final /* synthetic */ void addFileToGenerate(DslList dslList, String value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addFileToGenerate(value);
        }

        public final /* synthetic */ void plusAssignFileToGenerate(DslList<String, FileToGenerateProxy> dslList, String value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addFileToGenerate(dslList, value);
        }

        public final /* synthetic */ void addAllFileToGenerate(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllFileToGenerate(values);
        }

        public final /* synthetic */ void plusAssignAllFileToGenerate(DslList<String, FileToGenerateProxy> dslList, Iterable<String> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllFileToGenerate(dslList, values);
        }

        public final /* synthetic */ void setFileToGenerate(DslList dslList, int i, String value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setFileToGenerate(i, value);
        }

        public final /* synthetic */ void clearFileToGenerate(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearFileToGenerate();
        }

        public final String getParameter() {
            String parameter = this._builder.getParameter();
            Intrinsics.checkNotNullExpressionValue(parameter, "_builder.getParameter()");
            return parameter;
        }

        public final void setParameter(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setParameter(value);
        }

        public final void clearParameter() {
            this._builder.clearParameter();
        }

        public final boolean hasParameter() {
            return this._builder.hasParameter();
        }

        /* INFO: compiled from: CodeGeneratorRequestKt.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/compiler/CodeGeneratorRequestKt$Dsl$ProtoFileProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class ProtoFileProxy extends DslProxy {
            private ProtoFileProxy() {
            }
        }

        public final /* synthetic */ DslList getProtoFile() {
            List<DescriptorProtos.FileDescriptorProto> protoFileList = this._builder.getProtoFileList();
            Intrinsics.checkNotNullExpressionValue(protoFileList, "_builder.getProtoFileList()");
            return new DslList(protoFileList);
        }

        public final /* synthetic */ void addProtoFile(DslList dslList, DescriptorProtos.FileDescriptorProto value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addProtoFile(value);
        }

        public final /* synthetic */ void plusAssignProtoFile(DslList<DescriptorProtos.FileDescriptorProto, ProtoFileProxy> dslList, DescriptorProtos.FileDescriptorProto value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addProtoFile(dslList, value);
        }

        public final /* synthetic */ void addAllProtoFile(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllProtoFile(values);
        }

        public final /* synthetic */ void plusAssignAllProtoFile(DslList<DescriptorProtos.FileDescriptorProto, ProtoFileProxy> dslList, Iterable<DescriptorProtos.FileDescriptorProto> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllProtoFile(dslList, values);
        }

        public final /* synthetic */ void setProtoFile(DslList dslList, int i, DescriptorProtos.FileDescriptorProto value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setProtoFile(i, value);
        }

        public final /* synthetic */ void clearProtoFile(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearProtoFile();
        }

        /* INFO: compiled from: CodeGeneratorRequestKt.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/compiler/CodeGeneratorRequestKt$Dsl$SourceFileDescriptorsProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class SourceFileDescriptorsProxy extends DslProxy {
            private SourceFileDescriptorsProxy() {
            }
        }

        public final /* synthetic */ DslList getSourceFileDescriptors() {
            List<DescriptorProtos.FileDescriptorProto> sourceFileDescriptorsList = this._builder.getSourceFileDescriptorsList();
            Intrinsics.checkNotNullExpressionValue(sourceFileDescriptorsList, "_builder.getSourceFileDescriptorsList()");
            return new DslList(sourceFileDescriptorsList);
        }

        public final /* synthetic */ void addSourceFileDescriptors(DslList dslList, DescriptorProtos.FileDescriptorProto value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addSourceFileDescriptors(value);
        }

        public final /* synthetic */ void plusAssignSourceFileDescriptors(DslList<DescriptorProtos.FileDescriptorProto, SourceFileDescriptorsProxy> dslList, DescriptorProtos.FileDescriptorProto value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addSourceFileDescriptors(dslList, value);
        }

        public final /* synthetic */ void addAllSourceFileDescriptors(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllSourceFileDescriptors(values);
        }

        public final /* synthetic */ void plusAssignAllSourceFileDescriptors(DslList<DescriptorProtos.FileDescriptorProto, SourceFileDescriptorsProxy> dslList, Iterable<DescriptorProtos.FileDescriptorProto> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllSourceFileDescriptors(dslList, values);
        }

        public final /* synthetic */ void setSourceFileDescriptors(DslList dslList, int i, DescriptorProtos.FileDescriptorProto value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setSourceFileDescriptors(i, value);
        }

        public final /* synthetic */ void clearSourceFileDescriptors(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearSourceFileDescriptors();
        }

        public final PluginProtos.Version getCompilerVersion() {
            PluginProtos.Version compilerVersion = this._builder.getCompilerVersion();
            Intrinsics.checkNotNullExpressionValue(compilerVersion, "_builder.getCompilerVersion()");
            return compilerVersion;
        }

        public final void setCompilerVersion(PluginProtos.Version value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setCompilerVersion(value);
        }

        public final void clearCompilerVersion() {
            this._builder.clearCompilerVersion();
        }

        public final boolean hasCompilerVersion() {
            return this._builder.hasCompilerVersion();
        }

        public final PluginProtos.Version getCompilerVersionOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return CodeGeneratorRequestKtKt.getCompilerVersionOrNull(dsl._builder);
        }
    }

    private CodeGeneratorRequestKt() {
    }
}
