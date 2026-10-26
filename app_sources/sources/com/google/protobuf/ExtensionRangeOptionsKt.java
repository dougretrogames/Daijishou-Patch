package com.google.protobuf;

import androidx.exifinterface.media.ExifInterface;
import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ExtensionList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: ExtensionRangeOptionsKt.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"Lcom/google/protobuf/ExtensionRangeOptionsKt;", "", "()V", "declaration", "Lcom/google/protobuf/DescriptorProtos$ExtensionRangeOptions$Declaration;", "block", "Lkotlin/Function1;", "Lcom/google/protobuf/ExtensionRangeOptionsKt$DeclarationKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializedeclaration", "DeclarationKt", "Dsl", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ExtensionRangeOptionsKt {
    public static final ExtensionRangeOptionsKt INSTANCE = new ExtensionRangeOptionsKt();

    /* INFO: compiled from: ExtensionRangeOptionsKt.kt */
    @Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u001c\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u0000 O2\u00020\u0001:\u0003OPQB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001f\u001a\u00020 H\u0001J\u0018\u0010!\u001a\u00020\"2\u0010\u0010#\u001a\f\u0012\u0004\u0012\u00020 \u0012\u0002\b\u00030$J\u0006\u0010%\u001a\u00020\"J\u0006\u0010&\u001a\u00020\"J\u001b\u0010'\u001a\u00020(2\u0010\u0010#\u001a\f\u0012\u0004\u0012\u00020 \u0012\u0002\b\u00030$H\u0086\u0002J,\u0010)\u001a\u0002H*\"\b\b\u0000\u0010**\u00020\u00012\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u0002H*0$H\u0086\u0002¢\u0006\u0002\u0010+J>\u0010)\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020 0,\"\b\b\u0000\u0010-*\u00020\u00012\u0018\u0010#\u001a\u0014\u0012\u0004\u0012\u00020 \u0012\n\u0012\b\u0012\u0004\u0012\u0002H-0.0$H\u0087\u0002¢\u0006\u0002\b/J\u0006\u00100\u001a\u00020(J\u0006\u00101\u001a\u00020(J4\u00102\u001a\u00020\"\"\b\b\u0000\u0010**\u0002032\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u0002H*0$2\u0006\u0010\u000b\u001a\u0002H*H\u0086\n¢\u0006\u0002\u00104J:\u00102\u001a\u00020\"\"\u000e\b\u0000\u0010**\b\u0012\u0004\u0012\u0002H*052\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u0002H*0$2\u0006\u0010\u000b\u001a\u0002H*H\u0086\n¢\u0006\u0002\u00106J%\u00102\u001a\u00020\"2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u0002070$2\u0006\u0010\u000b\u001a\u000207H\u0086\nJ1\u00108\u001a\u00020\"\"\b\b\u0000\u0010**\u00020\u00012\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u0002H*0$2\u0006\u0010\u000b\u001a\u0002H*¢\u0006\u0002\u00109J%\u0010:\u001a\u00020\"*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\u0007H\u0007¢\u0006\u0002\b;J%\u0010:\u001a\u00020\"*\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00062\u0006\u0010\u000b\u001a\u00020\u0013H\u0007¢\u0006\u0002\b<J-\u0010:\u001a\u00020\"\"\b\b\u0000\u0010-*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020 0,2\u0006\u0010\u000b\u001a\u0002H-¢\u0006\u0002\u0010=J+\u0010>\u001a\u00020\"*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00070@H\u0007¢\u0006\u0002\bAJ+\u0010>\u001a\u00020\"*\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00062\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00130@H\u0007¢\u0006\u0002\bBJ.\u0010>\u001a\u00020\"\"\b\b\u0000\u0010-*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020 0,2\f\u0010?\u001a\b\u0012\u0004\u0012\u0002H-0@J\u001d\u0010!\u001a\u00020\"*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0007¢\u0006\u0002\bCJ\u001d\u0010!\u001a\u00020\"*\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0006H\u0007¢\u0006\u0002\bDJ\u0017\u0010!\u001a\u00020\"*\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020 0,H\u0086\bJ&\u0010E\u001a\u00020\"*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\u0007H\u0087\n¢\u0006\u0002\bFJ,\u0010E\u001a\u00020\"*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00070@H\u0087\n¢\u0006\u0002\bGJ&\u0010E\u001a\u00020\"*\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00062\u0006\u0010\u000b\u001a\u00020\u0013H\u0087\n¢\u0006\u0002\bHJ,\u0010E\u001a\u00020\"*\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00062\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00130@H\u0087\n¢\u0006\u0002\bIJ0\u0010E\u001a\u00020\"\"\b\b\u0000\u0010-*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020 0,2\u0006\u0010\u000b\u001a\u0002H-H\u0086\n¢\u0006\u0002\u0010=J1\u0010E\u001a\u00020\"\"\b\b\u0000\u0010-*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020 0,2\f\u0010?\u001a\b\u0012\u0004\u0012\u0002H-0@H\u0086\nJ.\u00102\u001a\u00020\"*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010J\u001a\u00020K2\u0006\u0010\u000b\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\bLJ.\u00102\u001a\u00020\"*\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00062\u0006\u0010J\u001a\u00020K2\u0006\u0010\u000b\u001a\u00020\u0013H\u0087\u0002¢\u0006\u0002\bMJ8\u00102\u001a\u00020\"\"\b\b\u0000\u0010-*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020 0,2\u0006\u0010J\u001a\u00020K2\u0006\u0010\u000b\u001a\u0002H-H\u0086\u0002¢\u0006\u0002\u0010NR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00068F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\nR$\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\u00168G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\u0004\u0018\u00010\f*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006R"}, d2 = {"Lcom/google/protobuf/ExtensionRangeOptionsKt$Dsl;", "", "_builder", "Lcom/google/protobuf/DescriptorProtos$ExtensionRangeOptions$Builder;", "(Lcom/google/protobuf/DescriptorProtos$ExtensionRangeOptions$Builder;)V", "declaration", "Lcom/google/protobuf/kotlin/DslList;", "Lcom/google/protobuf/DescriptorProtos$ExtensionRangeOptions$Declaration;", "Lcom/google/protobuf/ExtensionRangeOptionsKt$Dsl$DeclarationProxy;", "getDeclaration", "()Lcom/google/protobuf/kotlin/DslList;", "value", "Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "features", "getFeatures", "()Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "setFeatures", "(Lcom/google/protobuf/DescriptorProtos$FeatureSet;)V", "uninterpretedOption", "Lcom/google/protobuf/DescriptorProtos$UninterpretedOption;", "Lcom/google/protobuf/ExtensionRangeOptionsKt$Dsl$UninterpretedOptionProxy;", "getUninterpretedOption", "Lcom/google/protobuf/DescriptorProtos$ExtensionRangeOptions$VerificationState;", "verification", "getVerification", "()Lcom/google/protobuf/DescriptorProtos$ExtensionRangeOptions$VerificationState;", "setVerification", "(Lcom/google/protobuf/DescriptorProtos$ExtensionRangeOptions$VerificationState;)V", "featuresOrNull", "getFeaturesOrNull", "(Lcom/google/protobuf/ExtensionRangeOptionsKt$Dsl;)Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "_build", "Lcom/google/protobuf/DescriptorProtos$ExtensionRangeOptions;", "clear", "", "extension", "Lcom/google/protobuf/ExtensionLite;", "clearFeatures", "clearVerification", "contains", "", "get", ExifInterface.GPS_DIRECTION_TRUE, "(Lcom/google/protobuf/ExtensionLite;)Ljava/lang/Object;", "Lcom/google/protobuf/kotlin/ExtensionList;", ExifInterface.LONGITUDE_EAST, "", "-getRepeatedExtension", "hasFeatures", "hasVerification", "set", "Lcom/google/protobuf/MessageLite;", "(Lcom/google/protobuf/ExtensionLite;Lcom/google/protobuf/MessageLite;)V", "", "(Lcom/google/protobuf/ExtensionLite;Ljava/lang/Comparable;)V", "Lcom/google/protobuf/ByteString;", "setExtension", "(Lcom/google/protobuf/ExtensionLite;Ljava/lang/Object;)V", "add", "addDeclaration", "addUninterpretedOption", "(Lcom/google/protobuf/kotlin/ExtensionList;Ljava/lang/Object;)V", "addAll", "values", "", "addAllDeclaration", "addAllUninterpretedOption", "clearDeclaration", "clearUninterpretedOption", "plusAssign", "plusAssignDeclaration", "plusAssignAllDeclaration", "plusAssignUninterpretedOption", "plusAssignAllUninterpretedOption", ConfigConstants.CONFIG_INDEX_SECTION, "", "setDeclaration", "setUninterpretedOption", "(Lcom/google/protobuf/kotlin/ExtensionList;ILjava/lang/Object;)V", "Companion", "DeclarationProxy", "UninterpretedOptionProxy", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Dsl {

        /* INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final DescriptorProtos.ExtensionRangeOptions.Builder _builder;

        public /* synthetic */ Dsl(DescriptorProtos.ExtensionRangeOptions.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        private Dsl(DescriptorProtos.ExtensionRangeOptions.Builder builder) {
            this._builder = builder;
        }

        /* INFO: compiled from: ExtensionRangeOptionsKt.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/ExtensionRangeOptionsKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/ExtensionRangeOptionsKt$Dsl;", "builder", "Lcom/google/protobuf/DescriptorProtos$ExtensionRangeOptions$Builder;", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final /* synthetic */ Dsl _create(DescriptorProtos.ExtensionRangeOptions.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public final /* synthetic */ DescriptorProtos.ExtensionRangeOptions _build() {
            DescriptorProtos.ExtensionRangeOptions extensionRangeOptionsBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(extensionRangeOptionsBuild, "_builder.build()");
            return extensionRangeOptionsBuild;
        }

        /* INFO: compiled from: ExtensionRangeOptionsKt.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/ExtensionRangeOptionsKt$Dsl$UninterpretedOptionProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class UninterpretedOptionProxy extends DslProxy {
            private UninterpretedOptionProxy() {
            }
        }

        public final /* synthetic */ DslList getUninterpretedOption() {
            List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = this._builder.getUninterpretedOptionList();
            Intrinsics.checkNotNullExpressionValue(uninterpretedOptionList, "_builder.getUninterpretedOptionList()");
            return new DslList(uninterpretedOptionList);
        }

        public final /* synthetic */ void addUninterpretedOption(DslList dslList, DescriptorProtos.UninterpretedOption value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addUninterpretedOption(value);
        }

        public final /* synthetic */ void plusAssignUninterpretedOption(DslList<DescriptorProtos.UninterpretedOption, UninterpretedOptionProxy> dslList, DescriptorProtos.UninterpretedOption value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addUninterpretedOption(dslList, value);
        }

        public final /* synthetic */ void addAllUninterpretedOption(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllUninterpretedOption(values);
        }

        public final /* synthetic */ void plusAssignAllUninterpretedOption(DslList<DescriptorProtos.UninterpretedOption, UninterpretedOptionProxy> dslList, Iterable<DescriptorProtos.UninterpretedOption> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllUninterpretedOption(dslList, values);
        }

        public final /* synthetic */ void setUninterpretedOption(DslList dslList, int i, DescriptorProtos.UninterpretedOption value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setUninterpretedOption(i, value);
        }

        public final /* synthetic */ void clearUninterpretedOption(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearUninterpretedOption();
        }

        /* INFO: compiled from: ExtensionRangeOptionsKt.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/ExtensionRangeOptionsKt$Dsl$DeclarationProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class DeclarationProxy extends DslProxy {
            private DeclarationProxy() {
            }
        }

        public final /* synthetic */ DslList getDeclaration() {
            List<DescriptorProtos.ExtensionRangeOptions.Declaration> declarationList = this._builder.getDeclarationList();
            Intrinsics.checkNotNullExpressionValue(declarationList, "_builder.getDeclarationList()");
            return new DslList(declarationList);
        }

        public final /* synthetic */ void addDeclaration(DslList dslList, DescriptorProtos.ExtensionRangeOptions.Declaration value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addDeclaration(value);
        }

        public final /* synthetic */ void plusAssignDeclaration(DslList<DescriptorProtos.ExtensionRangeOptions.Declaration, DeclarationProxy> dslList, DescriptorProtos.ExtensionRangeOptions.Declaration value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addDeclaration(dslList, value);
        }

        public final /* synthetic */ void addAllDeclaration(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllDeclaration(values);
        }

        public final /* synthetic */ void plusAssignAllDeclaration(DslList<DescriptorProtos.ExtensionRangeOptions.Declaration, DeclarationProxy> dslList, Iterable<DescriptorProtos.ExtensionRangeOptions.Declaration> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllDeclaration(dslList, values);
        }

        public final /* synthetic */ void setDeclaration(DslList dslList, int i, DescriptorProtos.ExtensionRangeOptions.Declaration value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setDeclaration(i, value);
        }

        public final /* synthetic */ void clearDeclaration(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearDeclaration();
        }

        public final DescriptorProtos.FeatureSet getFeatures() {
            DescriptorProtos.FeatureSet features = this._builder.getFeatures();
            Intrinsics.checkNotNullExpressionValue(features, "_builder.getFeatures()");
            return features;
        }

        public final void setFeatures(DescriptorProtos.FeatureSet value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setFeatures(value);
        }

        public final void clearFeatures() {
            this._builder.clearFeatures();
        }

        public final boolean hasFeatures() {
            return this._builder.hasFeatures();
        }

        public final DescriptorProtos.FeatureSet getFeaturesOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return ExtensionRangeOptionsKtKt.getFeaturesOrNull(dsl._builder);
        }

        public final DescriptorProtos.ExtensionRangeOptions.VerificationState getVerification() {
            DescriptorProtos.ExtensionRangeOptions.VerificationState verification = this._builder.getVerification();
            Intrinsics.checkNotNullExpressionValue(verification, "_builder.getVerification()");
            return verification;
        }

        public final void setVerification(DescriptorProtos.ExtensionRangeOptions.VerificationState value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setVerification(value);
        }

        public final void clearVerification() {
            this._builder.clearVerification();
        }

        public final boolean hasVerification() {
            return this._builder.hasVerification();
        }

        public final /* synthetic */ Object get(ExtensionLite extension) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            if (extension.isRepeated()) {
                Object obj = get(extension);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of com.google.protobuf.ExtensionRangeOptionsKt.Dsl.get");
                return obj;
            }
            Object extension2 = this._builder.getExtension(extension);
            Intrinsics.checkNotNullExpressionValue(extension2, "{\n        _builder.getExtension(extension)\n      }");
            return extension2;
        }

        /* INFO: renamed from: -getRepeatedExtension, reason: not valid java name */
        public final /* synthetic */ ExtensionList m3398getRepeatedExtension(ExtensionLite extension) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            Object extension2 = this._builder.getExtension(extension);
            Intrinsics.checkNotNullExpressionValue(extension2, "_builder.getExtension(extension)");
            return new ExtensionList(extension, (List) extension2);
        }

        public final /* synthetic */ boolean contains(ExtensionLite extension) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            return this._builder.hasExtension(extension);
        }

        public final /* synthetic */ void clear(ExtensionLite extension) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            this._builder.clearExtension(extension);
        }

        public final /* synthetic */ void setExtension(ExtensionLite extension, Object value) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setExtension(extension, value);
        }

        public final /* synthetic */ <T extends Comparable<? super T>> void set(ExtensionLite<DescriptorProtos.ExtensionRangeOptions, T> extension, T value) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            Intrinsics.checkNotNullParameter(value, "value");
            setExtension(extension, value);
        }

        public final /* synthetic */ void set(ExtensionLite<DescriptorProtos.ExtensionRangeOptions, ByteString> extension, ByteString value) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            Intrinsics.checkNotNullParameter(value, "value");
            setExtension(extension, value);
        }

        public final /* synthetic */ <T extends MessageLite> void set(ExtensionLite<DescriptorProtos.ExtensionRangeOptions, T> extension, T value) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            Intrinsics.checkNotNullParameter(value, "value");
            setExtension(extension, value);
        }

        public final /* synthetic */ void add(ExtensionList extensionList, Object value) {
            Intrinsics.checkNotNullParameter(extensionList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addExtension(extensionList.getExtension(), value);
        }

        public final /* synthetic */ <E> void plusAssign(ExtensionList<E, DescriptorProtos.ExtensionRangeOptions> extensionList, E value) {
            Intrinsics.checkNotNullParameter(extensionList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            add(extensionList, value);
        }

        public final /* synthetic */ void addAll(ExtensionList extensionList, Iterable values) {
            Intrinsics.checkNotNullParameter(extensionList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            Iterator it = values.iterator();
            while (it.hasNext()) {
                add(extensionList, it.next());
            }
        }

        public final /* synthetic */ <E> void plusAssign(ExtensionList<E, DescriptorProtos.ExtensionRangeOptions> extensionList, Iterable<? extends E> values) {
            Intrinsics.checkNotNullParameter(extensionList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAll(extensionList, values);
        }

        public final /* synthetic */ void set(ExtensionList extensionList, int i, Object value) {
            Intrinsics.checkNotNullParameter(extensionList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setExtension(extensionList.getExtension(), i, value);
        }

        public final /* synthetic */ void clear(ExtensionList<?, DescriptorProtos.ExtensionRangeOptions> extensionList) {
            Intrinsics.checkNotNullParameter(extensionList, "<this>");
            clear(extensionList.getExtension());
        }
    }

    private ExtensionRangeOptionsKt() {
    }

    /* INFO: renamed from: -initializedeclaration, reason: not valid java name */
    public final DescriptorProtos.ExtensionRangeOptions.Declaration m3397initializedeclaration(Function1<? super DeclarationKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        DeclarationKt.Dsl.Companion companion = DeclarationKt.Dsl.INSTANCE;
        DescriptorProtos.ExtensionRangeOptions.Declaration.Builder builderNewBuilder = DescriptorProtos.ExtensionRangeOptions.Declaration.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        DeclarationKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    /* INFO: compiled from: ExtensionRangeOptionsKt.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/google/protobuf/ExtensionRangeOptionsKt$DeclarationKt;", "", "()V", "Dsl", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class DeclarationKt {
        public static final DeclarationKt INSTANCE = new DeclarationKt();

        /* INFO: compiled from: ExtensionRangeOptionsKt.kt */
        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001e\u001a\u00020\u001fH\u0001J\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020!J\u0006\u0010#\u001a\u00020!J\u0006\u0010$\u001a\u00020!J\u0006\u0010%\u001a\u00020!J\u0006\u0010&\u001a\u00020\u0012J\u0006\u0010'\u001a\u00020\u0012J\u0006\u0010(\u001a\u00020\u0012J\u0006\u0010)\u001a\u00020\u0012J\u0006\u0010*\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R$\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u000b¨\u0006,"}, d2 = {"Lcom/google/protobuf/ExtensionRangeOptionsKt$DeclarationKt$Dsl;", "", "_builder", "Lcom/google/protobuf/DescriptorProtos$ExtensionRangeOptions$Declaration$Builder;", "(Lcom/google/protobuf/DescriptorProtos$ExtensionRangeOptions$Declaration$Builder;)V", "value", "", "fullName", "getFullName", "()Ljava/lang/String;", "setFullName", "(Ljava/lang/String;)V", "", "number", "getNumber", "()I", "setNumber", "(I)V", "", "repeated", "getRepeated", "()Z", "setRepeated", "(Z)V", "reserved", "getReserved", "setReserved", "type", "getType", "setType", "_build", "Lcom/google/protobuf/DescriptorProtos$ExtensionRangeOptions$Declaration;", "clearFullName", "", "clearNumber", "clearRepeated", "clearReserved", "clearType", "hasFullName", "hasNumber", "hasRepeated", "hasReserved", "hasType", "Companion", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Dsl {

            /* INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final DescriptorProtos.ExtensionRangeOptions.Declaration.Builder _builder;

            public /* synthetic */ Dsl(DescriptorProtos.ExtensionRangeOptions.Declaration.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }

            private Dsl(DescriptorProtos.ExtensionRangeOptions.Declaration.Builder builder) {
                this._builder = builder;
            }

            /* INFO: compiled from: ExtensionRangeOptionsKt.kt */
            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/ExtensionRangeOptionsKt$DeclarationKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/ExtensionRangeOptionsKt$DeclarationKt$Dsl;", "builder", "Lcom/google/protobuf/DescriptorProtos$ExtensionRangeOptions$Declaration$Builder;", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final /* synthetic */ Dsl _create(DescriptorProtos.ExtensionRangeOptions.Declaration.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, null);
                }
            }

            public final /* synthetic */ DescriptorProtos.ExtensionRangeOptions.Declaration _build() {
                DescriptorProtos.ExtensionRangeOptions.Declaration declarationBuild = this._builder.build();
                Intrinsics.checkNotNullExpressionValue(declarationBuild, "_builder.build()");
                return declarationBuild;
            }

            public final int getNumber() {
                return this._builder.getNumber();
            }

            public final void setNumber(int i) {
                this._builder.setNumber(i);
            }

            public final void clearNumber() {
                this._builder.clearNumber();
            }

            public final boolean hasNumber() {
                return this._builder.hasNumber();
            }

            public final String getFullName() {
                String fullName = this._builder.getFullName();
                Intrinsics.checkNotNullExpressionValue(fullName, "_builder.getFullName()");
                return fullName;
            }

            public final void setFullName(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setFullName(value);
            }

            public final void clearFullName() {
                this._builder.clearFullName();
            }

            public final boolean hasFullName() {
                return this._builder.hasFullName();
            }

            public final String getType() {
                String type = this._builder.getType();
                Intrinsics.checkNotNullExpressionValue(type, "_builder.getType()");
                return type;
            }

            public final void setType(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setType(value);
            }

            public final void clearType() {
                this._builder.clearType();
            }

            public final boolean hasType() {
                return this._builder.hasType();
            }

            public final boolean getReserved() {
                return this._builder.getReserved();
            }

            public final void setReserved(boolean z) {
                this._builder.setReserved(z);
            }

            public final void clearReserved() {
                this._builder.clearReserved();
            }

            public final boolean hasReserved() {
                return this._builder.hasReserved();
            }

            public final boolean getRepeated() {
                return this._builder.getRepeated();
            }

            public final void setRepeated(boolean z) {
                this._builder.setRepeated(z);
            }

            public final void clearRepeated() {
                this._builder.clearRepeated();
            }

            public final boolean hasRepeated() {
                return this._builder.hasRepeated();
            }
        }

        private DeclarationKt() {
        }
    }
}
