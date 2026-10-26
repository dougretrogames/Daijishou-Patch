package com.google.protobuf;

import androidx.exifinterface.media.ExifInterface;
import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ExtensionList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: EnumOptionsKt.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/google/protobuf/EnumOptionsKt;", "", "()V", "Dsl", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EnumOptionsKt {
    public static final EnumOptionsKt INSTANCE = new EnumOptionsKt();

    /* INFO: compiled from: EnumOptionsKt.kt */
    @Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u001c\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u0000 P2\u00020\u0001:\u0002PQB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010#\u001a\u00020$H\u0001J\u0018\u0010%\u001a\u00020&2\u0010\u0010'\u001a\f\u0012\u0004\u0012\u00020$\u0012\u0002\b\u00030(J\u0006\u0010)\u001a\u00020&J\u0006\u0010*\u001a\u00020&J\u0006\u0010+\u001a\u00020&J\u0006\u0010,\u001a\u00020&J\u001b\u0010-\u001a\u00020\u00062\u0010\u0010'\u001a\f\u0012\u0004\u0012\u00020$\u0012\u0002\b\u00030(H\u0086\u0002J,\u0010.\u001a\u0002H/\"\b\b\u0000\u0010/*\u00020\u00012\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u0002H/0(H\u0086\u0002¢\u0006\u0002\u00100J>\u0010.\u001a\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020$01\"\b\b\u0000\u00102*\u00020\u00012\u0018\u0010'\u001a\u0014\u0012\u0004\u0012\u00020$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H2030(H\u0087\u0002¢\u0006\u0002\b4J\u0006\u00105\u001a\u00020\u0006J\u0006\u00106\u001a\u00020\u0006J\u0006\u00107\u001a\u00020\u0006J\u0006\u00108\u001a\u00020\u0006J4\u00109\u001a\u00020&\"\b\b\u0000\u0010/*\u00020:2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u0002H/0(2\u0006\u0010\u0005\u001a\u0002H/H\u0086\n¢\u0006\u0002\u0010;J:\u00109\u001a\u00020&\"\u000e\b\u0000\u0010/*\b\u0012\u0004\u0012\u0002H/0<2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u0002H/0(2\u0006\u0010\u0005\u001a\u0002H/H\u0086\n¢\u0006\u0002\u0010=J%\u00109\u001a\u00020&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020>0(2\u0006\u0010\u0005\u001a\u00020>H\u0086\nJ1\u0010?\u001a\u00020&\"\b\b\u0000\u0010/*\u00020\u00012\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u0002H/0(2\u0006\u0010\u0005\u001a\u0002H/¢\u0006\u0002\u0010@J%\u0010A\u001a\u00020&*\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b2\u0006\u0010\u0005\u001a\u00020\u001cH\u0007¢\u0006\u0002\bBJ-\u0010A\u001a\u00020&\"\b\b\u0000\u00102*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020$012\u0006\u0010\u0005\u001a\u0002H2¢\u0006\u0002\u0010CJ+\u0010D\u001a\u00020&*\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u001c0FH\u0007¢\u0006\u0002\bGJ.\u0010D\u001a\u00020&\"\b\b\u0000\u00102*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020$012\f\u0010E\u001a\b\u0012\u0004\u0012\u0002H20FJ\u001d\u0010%\u001a\u00020&*\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001bH\u0007¢\u0006\u0002\bHJ\u0017\u0010%\u001a\u00020&*\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020$01H\u0086\bJ&\u0010I\u001a\u00020&*\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b2\u0006\u0010\u0005\u001a\u00020\u001cH\u0087\n¢\u0006\u0002\bJJ,\u0010I\u001a\u00020&*\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u001c0FH\u0087\n¢\u0006\u0002\bKJ0\u0010I\u001a\u00020&\"\b\b\u0000\u00102*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020$012\u0006\u0010\u0005\u001a\u0002H2H\u0086\n¢\u0006\u0002\u0010CJ1\u0010I\u001a\u00020&\"\b\b\u0000\u00102*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020$012\f\u0010E\u001a\b\u0012\u0004\u0012\u0002H20FH\u0086\nJ.\u00109\u001a\u00020&*\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b2\u0006\u0010L\u001a\u00020M2\u0006\u0010\u0005\u001a\u00020\u001cH\u0087\u0002¢\u0006\u0002\bNJ8\u00109\u001a\u00020&\"\b\b\u0000\u00102*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020$012\u0006\u0010L\u001a\u00020M2\u0006\u0010\u0005\u001a\u0002H2H\u0086\u0002¢\u0006\u0002\u0010OR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR*\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u000bR$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00148G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010 \u001a\u0004\u0018\u00010\u0014*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006R"}, d2 = {"Lcom/google/protobuf/EnumOptionsKt$Dsl;", "", "_builder", "Lcom/google/protobuf/DescriptorProtos$EnumOptions$Builder;", "(Lcom/google/protobuf/DescriptorProtos$EnumOptions$Builder;)V", "value", "", "allowAlias", "getAllowAlias", "()Z", "setAllowAlias", "(Z)V", "deprecated", "getDeprecated", "setDeprecated", "deprecatedLegacyJsonFieldConflicts", "getDeprecatedLegacyJsonFieldConflicts$annotations", "()V", "getDeprecatedLegacyJsonFieldConflicts", "setDeprecatedLegacyJsonFieldConflicts", "Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "features", "getFeatures", "()Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "setFeatures", "(Lcom/google/protobuf/DescriptorProtos$FeatureSet;)V", "uninterpretedOption", "Lcom/google/protobuf/kotlin/DslList;", "Lcom/google/protobuf/DescriptorProtos$UninterpretedOption;", "Lcom/google/protobuf/EnumOptionsKt$Dsl$UninterpretedOptionProxy;", "getUninterpretedOption", "()Lcom/google/protobuf/kotlin/DslList;", "featuresOrNull", "getFeaturesOrNull", "(Lcom/google/protobuf/EnumOptionsKt$Dsl;)Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "_build", "Lcom/google/protobuf/DescriptorProtos$EnumOptions;", "clear", "", "extension", "Lcom/google/protobuf/ExtensionLite;", "clearAllowAlias", "clearDeprecated", "clearDeprecatedLegacyJsonFieldConflicts", "clearFeatures", "contains", "get", ExifInterface.GPS_DIRECTION_TRUE, "(Lcom/google/protobuf/ExtensionLite;)Ljava/lang/Object;", "Lcom/google/protobuf/kotlin/ExtensionList;", ExifInterface.LONGITUDE_EAST, "", "-getRepeatedExtension", "hasAllowAlias", "hasDeprecated", "hasDeprecatedLegacyJsonFieldConflicts", "hasFeatures", "set", "Lcom/google/protobuf/MessageLite;", "(Lcom/google/protobuf/ExtensionLite;Lcom/google/protobuf/MessageLite;)V", "", "(Lcom/google/protobuf/ExtensionLite;Ljava/lang/Comparable;)V", "Lcom/google/protobuf/ByteString;", "setExtension", "(Lcom/google/protobuf/ExtensionLite;Ljava/lang/Object;)V", "add", "addUninterpretedOption", "(Lcom/google/protobuf/kotlin/ExtensionList;Ljava/lang/Object;)V", "addAll", "values", "", "addAllUninterpretedOption", "clearUninterpretedOption", "plusAssign", "plusAssignUninterpretedOption", "plusAssignAllUninterpretedOption", ConfigConstants.CONFIG_INDEX_SECTION, "", "setUninterpretedOption", "(Lcom/google/protobuf/kotlin/ExtensionList;ILjava/lang/Object;)V", "Companion", "UninterpretedOptionProxy", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Dsl {

        /* INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final DescriptorProtos.EnumOptions.Builder _builder;

        public /* synthetic */ Dsl(DescriptorProtos.EnumOptions.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        @Deprecated(message = "Field deprecatedLegacyJsonFieldConflicts is deprecated")
        public static /* synthetic */ void getDeprecatedLegacyJsonFieldConflicts$annotations() {
        }

        private Dsl(DescriptorProtos.EnumOptions.Builder builder) {
            this._builder = builder;
        }

        /* INFO: compiled from: EnumOptionsKt.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/EnumOptionsKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/EnumOptionsKt$Dsl;", "builder", "Lcom/google/protobuf/DescriptorProtos$EnumOptions$Builder;", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final /* synthetic */ Dsl _create(DescriptorProtos.EnumOptions.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public final /* synthetic */ DescriptorProtos.EnumOptions _build() {
            DescriptorProtos.EnumOptions enumOptionsBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(enumOptionsBuild, "_builder.build()");
            return enumOptionsBuild;
        }

        public final boolean getAllowAlias() {
            return this._builder.getAllowAlias();
        }

        public final void setAllowAlias(boolean z) {
            this._builder.setAllowAlias(z);
        }

        public final void clearAllowAlias() {
            this._builder.clearAllowAlias();
        }

        public final boolean hasAllowAlias() {
            return this._builder.hasAllowAlias();
        }

        public final boolean getDeprecated() {
            return this._builder.getDeprecated();
        }

        public final void setDeprecated(boolean z) {
            this._builder.setDeprecated(z);
        }

        public final void clearDeprecated() {
            this._builder.clearDeprecated();
        }

        public final boolean hasDeprecated() {
            return this._builder.hasDeprecated();
        }

        public final boolean getDeprecatedLegacyJsonFieldConflicts() {
            return this._builder.getDeprecatedLegacyJsonFieldConflicts();
        }

        public final void setDeprecatedLegacyJsonFieldConflicts(boolean z) {
            this._builder.setDeprecatedLegacyJsonFieldConflicts(z);
        }

        public final void clearDeprecatedLegacyJsonFieldConflicts() {
            this._builder.clearDeprecatedLegacyJsonFieldConflicts();
        }

        public final boolean hasDeprecatedLegacyJsonFieldConflicts() {
            return this._builder.hasDeprecatedLegacyJsonFieldConflicts();
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
            return EnumOptionsKtKt.getFeaturesOrNull(dsl._builder);
        }

        /* INFO: compiled from: EnumOptionsKt.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/EnumOptionsKt$Dsl$UninterpretedOptionProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        public final /* synthetic */ Object get(ExtensionLite extension) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            if (extension.isRepeated()) {
                Object obj = get(extension);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of com.google.protobuf.EnumOptionsKt.Dsl.get");
                return obj;
            }
            Object extension2 = this._builder.getExtension(extension);
            Intrinsics.checkNotNullExpressionValue(extension2, "{\n        _builder.getExtension(extension)\n      }");
            return extension2;
        }

        /* INFO: renamed from: -getRepeatedExtension, reason: not valid java name */
        public final /* synthetic */ ExtensionList m3391getRepeatedExtension(ExtensionLite extension) {
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

        public final /* synthetic */ <T extends Comparable<? super T>> void set(ExtensionLite<DescriptorProtos.EnumOptions, T> extension, T value) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            Intrinsics.checkNotNullParameter(value, "value");
            setExtension(extension, value);
        }

        public final /* synthetic */ void set(ExtensionLite<DescriptorProtos.EnumOptions, ByteString> extension, ByteString value) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            Intrinsics.checkNotNullParameter(value, "value");
            setExtension(extension, value);
        }

        public final /* synthetic */ <T extends MessageLite> void set(ExtensionLite<DescriptorProtos.EnumOptions, T> extension, T value) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            Intrinsics.checkNotNullParameter(value, "value");
            setExtension(extension, value);
        }

        public final /* synthetic */ void add(ExtensionList extensionList, Object value) {
            Intrinsics.checkNotNullParameter(extensionList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addExtension(extensionList.getExtension(), value);
        }

        public final /* synthetic */ <E> void plusAssign(ExtensionList<E, DescriptorProtos.EnumOptions> extensionList, E value) {
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

        public final /* synthetic */ <E> void plusAssign(ExtensionList<E, DescriptorProtos.EnumOptions> extensionList, Iterable<? extends E> values) {
            Intrinsics.checkNotNullParameter(extensionList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAll(extensionList, values);
        }

        public final /* synthetic */ void set(ExtensionList extensionList, int i, Object value) {
            Intrinsics.checkNotNullParameter(extensionList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setExtension(extensionList.getExtension(), i, value);
        }

        public final /* synthetic */ void clear(ExtensionList<?, DescriptorProtos.EnumOptions> extensionList) {
            Intrinsics.checkNotNullParameter(extensionList, "<this>");
            clear(extensionList.getExtension());
        }
    }

    private EnumOptionsKt() {
    }
}
