package com.google.protobuf;

import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslProxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: GeneratedCodeInfoKt.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"Lcom/google/protobuf/GeneratedCodeInfoKt;", "", "()V", "annotation", "Lcom/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation;", "block", "Lkotlin/Function1;", "Lcom/google/protobuf/GeneratedCodeInfoKt$AnnotationKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeannotation", "AnnotationKt", "Dsl", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GeneratedCodeInfoKt {
    public static final GeneratedCodeInfoKt INSTANCE = new GeneratedCodeInfoKt();

    /* JADX INFO: compiled from: GeneratedCodeInfoKt.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0001J%\u0010\r\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000f\u001a\u00020\u0007H\u0007¢\u0006\u0002\b\u0010J+\u0010\u0011\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013H\u0007¢\u0006\u0002\b\u0014J\u001d\u0010\u0015\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0007¢\u0006\u0002\b\u0016J&\u0010\u0017\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000f\u001a\u00020\u0007H\u0087\n¢\u0006\u0002\b\u0018J,\u0010\u0017\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013H\u0087\n¢\u0006\u0002\b\u0019J.\u0010\u001a\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006 "}, d2 = {"Lcom/google/protobuf/GeneratedCodeInfoKt$Dsl;", "", "_builder", "Lcom/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Builder;", "(Lcom/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Builder;)V", "annotation", "Lcom/google/protobuf/kotlin/DslList;", "Lcom/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation;", "Lcom/google/protobuf/GeneratedCodeInfoKt$Dsl$AnnotationProxy;", "getAnnotation", "()Lcom/google/protobuf/kotlin/DslList;", "_build", "Lcom/google/protobuf/DescriptorProtos$GeneratedCodeInfo;", "add", "", "value", "addAnnotation", "addAll", "values", "", "addAllAnnotation", "clear", "clearAnnotation", "plusAssign", "plusAssignAnnotation", "plusAssignAllAnnotation", "set", ConfigConstants.CONFIG_INDEX_SECTION, "", "setAnnotation", "AnnotationProxy", "Companion", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Dsl {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final DescriptorProtos.GeneratedCodeInfo.Builder _builder;

        public /* synthetic */ Dsl(DescriptorProtos.GeneratedCodeInfo.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        private Dsl(DescriptorProtos.GeneratedCodeInfo.Builder builder) {
            this._builder = builder;
        }

        /* JADX INFO: compiled from: GeneratedCodeInfoKt.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/GeneratedCodeInfoKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/GeneratedCodeInfoKt$Dsl;", "builder", "Lcom/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Builder;", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final /* synthetic */ Dsl _create(DescriptorProtos.GeneratedCodeInfo.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public final /* synthetic */ DescriptorProtos.GeneratedCodeInfo _build() {
            DescriptorProtos.GeneratedCodeInfo generatedCodeInfoBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(generatedCodeInfoBuild, "_builder.build()");
            return generatedCodeInfoBuild;
        }

        /* JADX INFO: compiled from: GeneratedCodeInfoKt.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/GeneratedCodeInfoKt$Dsl$AnnotationProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class AnnotationProxy extends DslProxy {
            private AnnotationProxy() {
            }
        }

        public final /* synthetic */ DslList getAnnotation() {
            List<DescriptorProtos.GeneratedCodeInfo.Annotation> annotationList = this._builder.getAnnotationList();
            Intrinsics.checkNotNullExpressionValue(annotationList, "_builder.getAnnotationList()");
            return new DslList(annotationList);
        }

        public final /* synthetic */ void addAnnotation(DslList dslList, DescriptorProtos.GeneratedCodeInfo.Annotation value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addAnnotation(value);
        }

        public final /* synthetic */ void plusAssignAnnotation(DslList<DescriptorProtos.GeneratedCodeInfo.Annotation, AnnotationProxy> dslList, DescriptorProtos.GeneratedCodeInfo.Annotation value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addAnnotation(dslList, value);
        }

        public final /* synthetic */ void addAllAnnotation(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllAnnotation(values);
        }

        public final /* synthetic */ void plusAssignAllAnnotation(DslList<DescriptorProtos.GeneratedCodeInfo.Annotation, AnnotationProxy> dslList, Iterable<DescriptorProtos.GeneratedCodeInfo.Annotation> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllAnnotation(dslList, values);
        }

        public final /* synthetic */ void setAnnotation(DslList dslList, int i, DescriptorProtos.GeneratedCodeInfo.Annotation value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setAnnotation(i, value);
        }

        public final /* synthetic */ void clearAnnotation(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearAnnotation();
        }
    }

    private GeneratedCodeInfoKt() {
    }

    /* JADX INFO: renamed from: -initializeannotation, reason: not valid java name */
    public final DescriptorProtos.GeneratedCodeInfo.Annotation m3417initializeannotation(Function1<? super AnnotationKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        AnnotationKt.Dsl.Companion companion = AnnotationKt.Dsl.INSTANCE;
        DescriptorProtos.GeneratedCodeInfo.Annotation.Builder builderNewBuilder = DescriptorProtos.GeneratedCodeInfo.Annotation.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        AnnotationKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    /* JADX INFO: compiled from: GeneratedCodeInfoKt.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/google/protobuf/GeneratedCodeInfoKt$AnnotationKt;", "", "()V", "Dsl", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnnotationKt {
        public static final AnnotationKt INSTANCE = new AnnotationKt();

        /* JADX INFO: compiled from: GeneratedCodeInfoKt.kt */
        @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u001c\n\u0002\b\f\b\u0007\u0018\u0000 :2\u00020\u0001:\u0002:;B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010 \u001a\u00020!H\u0001J\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020#J\u0006\u0010%\u001a\u00020#J\u0006\u0010&\u001a\u00020#J\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020(J\u0006\u0010*\u001a\u00020(J\u0006\u0010+\u001a\u00020(J%\u0010,\u001a\u00020#*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\b-J+\u0010.\u001a\u00020#*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000600H\u0007¢\u0006\u0002\b1J\u001d\u00102\u001a\u00020#*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00110\u0010H\u0007¢\u0006\u0002\b3J&\u00104\u001a\u00020#*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0087\n¢\u0006\u0002\b5J,\u00104\u001a\u00020#*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000600H\u0087\n¢\u0006\u0002\b6J.\u00107\u001a\u00020#*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u00108\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b9R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00110\u00108F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00148G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u001a8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006<"}, d2 = {"Lcom/google/protobuf/GeneratedCodeInfoKt$AnnotationKt$Dsl;", "", "_builder", "Lcom/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation$Builder;", "(Lcom/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation$Builder;)V", "value", "", "begin", "getBegin", "()I", "setBegin", "(I)V", "end", "getEnd", "setEnd", "path", "Lcom/google/protobuf/kotlin/DslList;", "Lcom/google/protobuf/GeneratedCodeInfoKt$AnnotationKt$Dsl$PathProxy;", "getPath", "()Lcom/google/protobuf/kotlin/DslList;", "Lcom/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation$Semantic;", "semantic", "getSemantic", "()Lcom/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation$Semantic;", "setSemantic", "(Lcom/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation$Semantic;)V", "", "sourceFile", "getSourceFile", "()Ljava/lang/String;", "setSourceFile", "(Ljava/lang/String;)V", "_build", "Lcom/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation;", "clearBegin", "", "clearEnd", "clearSemantic", "clearSourceFile", "hasBegin", "", "hasEnd", "hasSemantic", "hasSourceFile", "add", "addPath", "addAll", "values", "", "addAllPath", "clear", "clearPath", "plusAssign", "plusAssignPath", "plusAssignAllPath", "set", ConfigConstants.CONFIG_INDEX_SECTION, "setPath", "Companion", "PathProxy", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Dsl {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final DescriptorProtos.GeneratedCodeInfo.Annotation.Builder _builder;

            public /* synthetic */ Dsl(DescriptorProtos.GeneratedCodeInfo.Annotation.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }

            private Dsl(DescriptorProtos.GeneratedCodeInfo.Annotation.Builder builder) {
                this._builder = builder;
            }

            /* JADX INFO: compiled from: GeneratedCodeInfoKt.kt */
            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/GeneratedCodeInfoKt$AnnotationKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/GeneratedCodeInfoKt$AnnotationKt$Dsl;", "builder", "Lcom/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation$Builder;", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final /* synthetic */ Dsl _create(DescriptorProtos.GeneratedCodeInfo.Annotation.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, null);
                }
            }

            public final /* synthetic */ DescriptorProtos.GeneratedCodeInfo.Annotation _build() {
                DescriptorProtos.GeneratedCodeInfo.Annotation annotationBuild = this._builder.build();
                Intrinsics.checkNotNullExpressionValue(annotationBuild, "_builder.build()");
                return annotationBuild;
            }

            /* JADX INFO: compiled from: GeneratedCodeInfoKt.kt */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/GeneratedCodeInfoKt$AnnotationKt$Dsl$PathProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class PathProxy extends DslProxy {
                private PathProxy() {
                }
            }

            public final /* synthetic */ DslList getPath() {
                List<Integer> pathList = this._builder.getPathList();
                Intrinsics.checkNotNullExpressionValue(pathList, "_builder.getPathList()");
                return new DslList(pathList);
            }

            public final /* synthetic */ void addPath(DslList dslList, int i) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                this._builder.addPath(i);
            }

            public final /* synthetic */ void plusAssignPath(DslList<Integer, PathProxy> dslList, int i) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                addPath(dslList, i);
            }

            public final /* synthetic */ void addAllPath(DslList dslList, Iterable values) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(values, "values");
                this._builder.addAllPath(values);
            }

            public final /* synthetic */ void plusAssignAllPath(DslList<Integer, PathProxy> dslList, Iterable<Integer> values) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(values, "values");
                addAllPath(dslList, values);
            }

            public final /* synthetic */ void setPath(DslList dslList, int i, int i2) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                this._builder.setPath(i, i2);
            }

            public final /* synthetic */ void clearPath(DslList dslList) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                this._builder.clearPath();
            }

            public final String getSourceFile() {
                String sourceFile = this._builder.getSourceFile();
                Intrinsics.checkNotNullExpressionValue(sourceFile, "_builder.getSourceFile()");
                return sourceFile;
            }

            public final void setSourceFile(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setSourceFile(value);
            }

            public final void clearSourceFile() {
                this._builder.clearSourceFile();
            }

            public final boolean hasSourceFile() {
                return this._builder.hasSourceFile();
            }

            public final int getBegin() {
                return this._builder.getBegin();
            }

            public final void setBegin(int i) {
                this._builder.setBegin(i);
            }

            public final void clearBegin() {
                this._builder.clearBegin();
            }

            public final boolean hasBegin() {
                return this._builder.hasBegin();
            }

            public final int getEnd() {
                return this._builder.getEnd();
            }

            public final void setEnd(int i) {
                this._builder.setEnd(i);
            }

            public final void clearEnd() {
                this._builder.clearEnd();
            }

            public final boolean hasEnd() {
                return this._builder.hasEnd();
            }

            public final DescriptorProtos.GeneratedCodeInfo.Annotation.Semantic getSemantic() {
                DescriptorProtos.GeneratedCodeInfo.Annotation.Semantic semantic = this._builder.getSemantic();
                Intrinsics.checkNotNullExpressionValue(semantic, "_builder.getSemantic()");
                return semantic;
            }

            public final void setSemantic(DescriptorProtos.GeneratedCodeInfo.Annotation.Semantic value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setSemantic(value);
            }

            public final void clearSemantic() {
                this._builder.clearSemantic();
            }

            public final boolean hasSemantic() {
                return this._builder.hasSemantic();
            }
        }

        private AnnotationKt() {
        }
    }
}
