package com.google.protobuf.compiler;

import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslProxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: CodeGeneratorResponseKt.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"Lcom/google/protobuf/compiler/CodeGeneratorResponseKt;", "", "()V", "file", "Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File;", "block", "Lkotlin/Function1;", "Lcom/google/protobuf/compiler/CodeGeneratorResponseKt$FileKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializefile", "Dsl", "FileKt", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CodeGeneratorResponseKt {
    public static final CodeGeneratorResponseKt INSTANCE = new CodeGeneratorResponseKt();

    /* INFO: compiled from: CodeGeneratorResponseKt.kt */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u001c\n\u0002\b\f\b\u0007\u0018\u0000 ;2\u00020\u0001:\u0002;<B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010!\u001a\u00020\"H\u0001J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020$J\u0006\u0010&\u001a\u00020$J\u0006\u0010'\u001a\u00020$J\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020)J\u0006\u0010+\u001a\u00020)J\u0006\u0010,\u001a\u00020)J%\u0010-\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u0005\u001a\u00020\u000eH\u0007¢\u0006\u0002\b.J+\u0010/\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000e01H\u0007¢\u0006\u0002\b2J\u001d\u00103\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH\u0007¢\u0006\u0002\b4J&\u00105\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u0005\u001a\u00020\u000eH\u0087\n¢\u0006\u0002\b6J,\u00105\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000e01H\u0087\n¢\u0006\u0002\b7J.\u00108\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u00109\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u000eH\u0087\u0002¢\u0006\u0002\b:R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R$\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u001b8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006="}, d2 = {"Lcom/google/protobuf/compiler/CodeGeneratorResponseKt$Dsl;", "", "_builder", "Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$Builder;", "(Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$Builder;)V", "value", "", "error", "getError", "()Ljava/lang/String;", "setError", "(Ljava/lang/String;)V", "file", "Lcom/google/protobuf/kotlin/DslList;", "Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File;", "Lcom/google/protobuf/compiler/CodeGeneratorResponseKt$Dsl$FileProxy;", "getFile", "()Lcom/google/protobuf/kotlin/DslList;", "", "maximumEdition", "getMaximumEdition", "()I", "setMaximumEdition", "(I)V", "minimumEdition", "getMinimumEdition", "setMinimumEdition", "", "supportedFeatures", "getSupportedFeatures", "()J", "setSupportedFeatures", "(J)V", "_build", "Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse;", "clearError", "", "clearMaximumEdition", "clearMinimumEdition", "clearSupportedFeatures", "hasError", "", "hasMaximumEdition", "hasMinimumEdition", "hasSupportedFeatures", "add", "addFile", "addAll", "values", "", "addAllFile", "clear", "clearFile", "plusAssign", "plusAssignFile", "plusAssignAllFile", "set", ConfigConstants.CONFIG_INDEX_SECTION, "setFile", "Companion", "FileProxy", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Dsl {

        /* INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final PluginProtos.CodeGeneratorResponse.Builder _builder;

        public /* synthetic */ Dsl(PluginProtos.CodeGeneratorResponse.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        private Dsl(PluginProtos.CodeGeneratorResponse.Builder builder) {
            this._builder = builder;
        }

        /* INFO: compiled from: CodeGeneratorResponseKt.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/compiler/CodeGeneratorResponseKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/compiler/CodeGeneratorResponseKt$Dsl;", "builder", "Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$Builder;", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final /* synthetic */ Dsl _create(PluginProtos.CodeGeneratorResponse.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public final /* synthetic */ PluginProtos.CodeGeneratorResponse _build() {
            PluginProtos.CodeGeneratorResponse codeGeneratorResponseBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(codeGeneratorResponseBuild, "_builder.build()");
            return codeGeneratorResponseBuild;
        }

        public final String getError() {
            String error = this._builder.getError();
            Intrinsics.checkNotNullExpressionValue(error, "_builder.getError()");
            return error;
        }

        public final void setError(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setError(value);
        }

        public final void clearError() {
            this._builder.clearError();
        }

        public final boolean hasError() {
            return this._builder.hasError();
        }

        public final long getSupportedFeatures() {
            return this._builder.getSupportedFeatures();
        }

        public final void setSupportedFeatures(long j) {
            this._builder.setSupportedFeatures(j);
        }

        public final void clearSupportedFeatures() {
            this._builder.clearSupportedFeatures();
        }

        public final boolean hasSupportedFeatures() {
            return this._builder.hasSupportedFeatures();
        }

        public final int getMinimumEdition() {
            return this._builder.getMinimumEdition();
        }

        public final void setMinimumEdition(int i) {
            this._builder.setMinimumEdition(i);
        }

        public final void clearMinimumEdition() {
            this._builder.clearMinimumEdition();
        }

        public final boolean hasMinimumEdition() {
            return this._builder.hasMinimumEdition();
        }

        public final int getMaximumEdition() {
            return this._builder.getMaximumEdition();
        }

        public final void setMaximumEdition(int i) {
            this._builder.setMaximumEdition(i);
        }

        public final void clearMaximumEdition() {
            this._builder.clearMaximumEdition();
        }

        public final boolean hasMaximumEdition() {
            return this._builder.hasMaximumEdition();
        }

        /* INFO: compiled from: CodeGeneratorResponseKt.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/compiler/CodeGeneratorResponseKt$Dsl$FileProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class FileProxy extends DslProxy {
            private FileProxy() {
            }
        }

        public final /* synthetic */ DslList getFile() {
            List<PluginProtos.CodeGeneratorResponse.File> fileList = this._builder.getFileList();
            Intrinsics.checkNotNullExpressionValue(fileList, "_builder.getFileList()");
            return new DslList(fileList);
        }

        public final /* synthetic */ void addFile(DslList dslList, PluginProtos.CodeGeneratorResponse.File value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addFile(value);
        }

        public final /* synthetic */ void plusAssignFile(DslList<PluginProtos.CodeGeneratorResponse.File, FileProxy> dslList, PluginProtos.CodeGeneratorResponse.File value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addFile(dslList, value);
        }

        public final /* synthetic */ void addAllFile(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllFile(values);
        }

        public final /* synthetic */ void plusAssignAllFile(DslList<PluginProtos.CodeGeneratorResponse.File, FileProxy> dslList, Iterable<PluginProtos.CodeGeneratorResponse.File> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllFile(dslList, values);
        }

        public final /* synthetic */ void setFile(DslList dslList, int i, PluginProtos.CodeGeneratorResponse.File value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setFile(i, value);
        }

        public final /* synthetic */ void clearFile(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearFile();
        }
    }

    private CodeGeneratorResponseKt() {
    }

    /* INFO: renamed from: -initializefile, reason: not valid java name */
    public final PluginProtos.CodeGeneratorResponse.File m3452initializefile(Function1<? super FileKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        FileKt.Dsl.Companion companion = FileKt.Dsl.INSTANCE;
        PluginProtos.CodeGeneratorResponse.File.Builder builderNewBuilder = PluginProtos.CodeGeneratorResponse.File.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        FileKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    /* INFO: compiled from: CodeGeneratorResponseKt.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/google/protobuf/compiler/CodeGeneratorResponseKt$FileKt;", "", "()V", "Dsl", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class FileKt {
        public static final FileKt INSTANCE = new FileKt();

        /* INFO: compiled from: CodeGeneratorResponseKt.kt */
        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001b\u001a\u00020\u001cH\u0001J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001eJ\u0006\u0010 \u001a\u00020\u001eJ\u0006\u0010!\u001a\u00020\u001eJ\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020#J\u0006\u0010%\u001a\u00020#J\u0006\u0010&\u001a\u00020#R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR$\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR\u0017\u0010\u0018\u001a\u0004\u0018\u00010\f*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006("}, d2 = {"Lcom/google/protobuf/compiler/CodeGeneratorResponseKt$FileKt$Dsl;", "", "_builder", "Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File$Builder;", "(Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File$Builder;)V", "value", "", "content", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "Lcom/google/protobuf/DescriptorProtos$GeneratedCodeInfo;", "generatedCodeInfo", "getGeneratedCodeInfo", "()Lcom/google/protobuf/DescriptorProtos$GeneratedCodeInfo;", "setGeneratedCodeInfo", "(Lcom/google/protobuf/DescriptorProtos$GeneratedCodeInfo;)V", "insertionPoint", "getInsertionPoint", "setInsertionPoint", "name", "getName", "setName", "generatedCodeInfoOrNull", "getGeneratedCodeInfoOrNull", "(Lcom/google/protobuf/compiler/CodeGeneratorResponseKt$FileKt$Dsl;)Lcom/google/protobuf/DescriptorProtos$GeneratedCodeInfo;", "_build", "Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File;", "clearContent", "", "clearGeneratedCodeInfo", "clearInsertionPoint", "clearName", "hasContent", "", "hasGeneratedCodeInfo", "hasInsertionPoint", "hasName", "Companion", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Dsl {

            /* INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final PluginProtos.CodeGeneratorResponse.File.Builder _builder;

            public /* synthetic */ Dsl(PluginProtos.CodeGeneratorResponse.File.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }

            private Dsl(PluginProtos.CodeGeneratorResponse.File.Builder builder) {
                this._builder = builder;
            }

            /* INFO: compiled from: CodeGeneratorResponseKt.kt */
            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/compiler/CodeGeneratorResponseKt$FileKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/compiler/CodeGeneratorResponseKt$FileKt$Dsl;", "builder", "Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File$Builder;", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final /* synthetic */ Dsl _create(PluginProtos.CodeGeneratorResponse.File.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, null);
                }
            }

            public final /* synthetic */ PluginProtos.CodeGeneratorResponse.File _build() {
                PluginProtos.CodeGeneratorResponse.File fileBuild = this._builder.build();
                Intrinsics.checkNotNullExpressionValue(fileBuild, "_builder.build()");
                return fileBuild;
            }

            public final String getName() {
                String name = this._builder.getName();
                Intrinsics.checkNotNullExpressionValue(name, "_builder.getName()");
                return name;
            }

            public final void setName(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setName(value);
            }

            public final void clearName() {
                this._builder.clearName();
            }

            public final boolean hasName() {
                return this._builder.hasName();
            }

            public final String getInsertionPoint() {
                String insertionPoint = this._builder.getInsertionPoint();
                Intrinsics.checkNotNullExpressionValue(insertionPoint, "_builder.getInsertionPoint()");
                return insertionPoint;
            }

            public final void setInsertionPoint(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setInsertionPoint(value);
            }

            public final void clearInsertionPoint() {
                this._builder.clearInsertionPoint();
            }

            public final boolean hasInsertionPoint() {
                return this._builder.hasInsertionPoint();
            }

            public final String getContent() {
                String content = this._builder.getContent();
                Intrinsics.checkNotNullExpressionValue(content, "_builder.getContent()");
                return content;
            }

            public final void setContent(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setContent(value);
            }

            public final void clearContent() {
                this._builder.clearContent();
            }

            public final boolean hasContent() {
                return this._builder.hasContent();
            }

            public final DescriptorProtos.GeneratedCodeInfo getGeneratedCodeInfo() {
                DescriptorProtos.GeneratedCodeInfo generatedCodeInfo = this._builder.getGeneratedCodeInfo();
                Intrinsics.checkNotNullExpressionValue(generatedCodeInfo, "_builder.getGeneratedCodeInfo()");
                return generatedCodeInfo;
            }

            public final void setGeneratedCodeInfo(DescriptorProtos.GeneratedCodeInfo value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setGeneratedCodeInfo(value);
            }

            public final void clearGeneratedCodeInfo() {
                this._builder.clearGeneratedCodeInfo();
            }

            public final boolean hasGeneratedCodeInfo() {
                return this._builder.hasGeneratedCodeInfo();
            }

            public final DescriptorProtos.GeneratedCodeInfo getGeneratedCodeInfoOrNull(Dsl dsl) {
                Intrinsics.checkNotNullParameter(dsl, "<this>");
                return CodeGeneratorResponseKtKt.getGeneratedCodeInfoOrNull(dsl._builder);
            }
        }

        private FileKt() {
        }
    }
}
