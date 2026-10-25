package com.google.protobuf;

import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslProxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: FileDescriptorSetKt.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/google/protobuf/FileDescriptorSetKt;", "", "()V", "Dsl", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FileDescriptorSetKt {
    public static final FileDescriptorSetKt INSTANCE = new FileDescriptorSetKt();

    /* JADX INFO: compiled from: FileDescriptorSetKt.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0001J%\u0010\r\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000f\u001a\u00020\u0007H\u0007¢\u0006\u0002\b\u0010J+\u0010\u0011\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013H\u0007¢\u0006\u0002\b\u0014J\u001d\u0010\u0015\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0007¢\u0006\u0002\b\u0016J&\u0010\u0017\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000f\u001a\u00020\u0007H\u0087\n¢\u0006\u0002\b\u0018J,\u0010\u0017\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013H\u0087\n¢\u0006\u0002\b\u0019J.\u0010\u001a\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006 "}, d2 = {"Lcom/google/protobuf/FileDescriptorSetKt$Dsl;", "", "_builder", "Lcom/google/protobuf/DescriptorProtos$FileDescriptorSet$Builder;", "(Lcom/google/protobuf/DescriptorProtos$FileDescriptorSet$Builder;)V", "file", "Lcom/google/protobuf/kotlin/DslList;", "Lcom/google/protobuf/DescriptorProtos$FileDescriptorProto;", "Lcom/google/protobuf/FileDescriptorSetKt$Dsl$FileProxy;", "getFile", "()Lcom/google/protobuf/kotlin/DslList;", "_build", "Lcom/google/protobuf/DescriptorProtos$FileDescriptorSet;", "add", "", "value", "addFile", "addAll", "values", "", "addAllFile", "clear", "clearFile", "plusAssign", "plusAssignFile", "plusAssignAllFile", "set", ConfigConstants.CONFIG_INDEX_SECTION, "", "setFile", "Companion", "FileProxy", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Dsl {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final DescriptorProtos.FileDescriptorSet.Builder _builder;

        public /* synthetic */ Dsl(DescriptorProtos.FileDescriptorSet.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        private Dsl(DescriptorProtos.FileDescriptorSet.Builder builder) {
            this._builder = builder;
        }

        /* JADX INFO: compiled from: FileDescriptorSetKt.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/FileDescriptorSetKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/FileDescriptorSetKt$Dsl;", "builder", "Lcom/google/protobuf/DescriptorProtos$FileDescriptorSet$Builder;", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final /* synthetic */ Dsl _create(DescriptorProtos.FileDescriptorSet.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public final /* synthetic */ DescriptorProtos.FileDescriptorSet _build() {
            DescriptorProtos.FileDescriptorSet fileDescriptorSetBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(fileDescriptorSetBuild, "_builder.build()");
            return fileDescriptorSetBuild;
        }

        /* JADX INFO: compiled from: FileDescriptorSetKt.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/FileDescriptorSetKt$Dsl$FileProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class FileProxy extends DslProxy {
            private FileProxy() {
            }
        }

        public final /* synthetic */ DslList getFile() {
            List<DescriptorProtos.FileDescriptorProto> fileList = this._builder.getFileList();
            Intrinsics.checkNotNullExpressionValue(fileList, "_builder.getFileList()");
            return new DslList(fileList);
        }

        public final /* synthetic */ void addFile(DslList dslList, DescriptorProtos.FileDescriptorProto value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addFile(value);
        }

        public final /* synthetic */ void plusAssignFile(DslList<DescriptorProtos.FileDescriptorProto, FileProxy> dslList, DescriptorProtos.FileDescriptorProto value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addFile(dslList, value);
        }

        public final /* synthetic */ void addAllFile(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllFile(values);
        }

        public final /* synthetic */ void plusAssignAllFile(DslList<DescriptorProtos.FileDescriptorProto, FileProxy> dslList, Iterable<DescriptorProtos.FileDescriptorProto> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllFile(dslList, values);
        }

        public final /* synthetic */ void setFile(DslList dslList, int i, DescriptorProtos.FileDescriptorProto value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setFile(i, value);
        }

        public final /* synthetic */ void clearFile(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearFile();
        }
    }

    private FileDescriptorSetKt() {
    }
}
