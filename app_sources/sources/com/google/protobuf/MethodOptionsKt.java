package com.google.protobuf;

import androidx.exifinterface.media.ExifInterface;
import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ExtensionList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: MethodOptionsKt.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/google/protobuf/MethodOptionsKt;", "", "()V", "Dsl", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MethodOptionsKt {
    public static final MethodOptionsKt INSTANCE = new MethodOptionsKt();

    /* INFO: compiled from: MethodOptionsKt.kt */
    @Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u001c\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u0000 L2\u00020\u0001:\u0002LMB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010!\u001a\u00020\"H\u0001J\u0018\u0010#\u001a\u00020$2\u0010\u0010%\u001a\f\u0012\u0004\u0012\u00020\"\u0012\u0002\b\u00030&J\u0006\u0010'\u001a\u00020$J\u0006\u0010(\u001a\u00020$J\u0006\u0010)\u001a\u00020$J\u001b\u0010*\u001a\u00020\u00062\u0010\u0010%\u001a\f\u0012\u0004\u0012\u00020\"\u0012\u0002\b\u00030&H\u0086\u0002J,\u0010+\u001a\u0002H,\"\b\b\u0000\u0010,*\u00020\u00012\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u0002H,0&H\u0086\u0002¢\u0006\u0002\u0010-J>\u0010+\u001a\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020\"0.\"\b\b\u0000\u0010/*\u00020\u00012\u0018\u0010%\u001a\u0014\u0012\u0004\u0012\u00020\"\u0012\n\u0012\b\u0012\u0004\u0012\u0002H/000&H\u0087\u0002¢\u0006\u0002\b1J\u0006\u00102\u001a\u00020\u0006J\u0006\u00103\u001a\u00020\u0006J\u0006\u00104\u001a\u00020\u0006J4\u00105\u001a\u00020$\"\b\b\u0000\u0010,*\u0002062\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u0002H,0&2\u0006\u0010\u0005\u001a\u0002H,H\u0086\n¢\u0006\u0002\u00107J:\u00105\u001a\u00020$\"\u000e\b\u0000\u0010,*\b\u0012\u0004\u0012\u0002H,082\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u0002H,0&2\u0006\u0010\u0005\u001a\u0002H,H\u0086\n¢\u0006\u0002\u00109J%\u00105\u001a\u00020$2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020:0&2\u0006\u0010\u0005\u001a\u00020:H\u0086\nJ1\u0010;\u001a\u00020$\"\b\b\u0000\u0010,*\u00020\u00012\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u0002H,0&2\u0006\u0010\u0005\u001a\u0002H,¢\u0006\u0002\u0010<J%\u0010=\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010\u0005\u001a\u00020\u001aH\u0007¢\u0006\u0002\b>J-\u0010=\u001a\u00020$\"\b\b\u0000\u0010/*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020\"0.2\u0006\u0010\u0005\u001a\u0002H/¢\u0006\u0002\u0010?J+\u0010@\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u001a0BH\u0007¢\u0006\u0002\bCJ.\u0010@\u001a\u00020$\"\b\b\u0000\u0010/*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020\"0.2\f\u0010A\u001a\b\u0012\u0004\u0012\u0002H/0BJ\u001d\u0010#\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019H\u0007¢\u0006\u0002\bDJ\u0017\u0010#\u001a\u00020$*\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\"0.H\u0086\bJ&\u0010E\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010\u0005\u001a\u00020\u001aH\u0087\n¢\u0006\u0002\bFJ,\u0010E\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u001a0BH\u0087\n¢\u0006\u0002\bGJ0\u0010E\u001a\u00020$\"\b\b\u0000\u0010/*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020\"0.2\u0006\u0010\u0005\u001a\u0002H/H\u0086\n¢\u0006\u0002\u0010?J1\u0010E\u001a\u00020$\"\b\b\u0000\u0010/*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020\"0.2\f\u0010A\u001a\b\u0012\u0004\u0012\u0002H/0BH\u0086\nJ.\u00105\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010H\u001a\u00020I2\u0006\u0010\u0005\u001a\u00020\u001aH\u0087\u0002¢\u0006\u0002\bJJ8\u00105\u001a\u00020$\"\b\b\u0000\u0010/*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020\"0.2\u0006\u0010H\u001a\u00020I2\u0006\u0010\u0005\u001a\u0002H/H\u0086\u0002¢\u0006\u0002\u0010KR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00198F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001e\u001a\u0004\u0018\u00010\f*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006N"}, d2 = {"Lcom/google/protobuf/MethodOptionsKt$Dsl;", "", "_builder", "Lcom/google/protobuf/DescriptorProtos$MethodOptions$Builder;", "(Lcom/google/protobuf/DescriptorProtos$MethodOptions$Builder;)V", "value", "", "deprecated", "getDeprecated", "()Z", "setDeprecated", "(Z)V", "Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "features", "getFeatures", "()Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "setFeatures", "(Lcom/google/protobuf/DescriptorProtos$FeatureSet;)V", "Lcom/google/protobuf/DescriptorProtos$MethodOptions$IdempotencyLevel;", "idempotencyLevel", "getIdempotencyLevel", "()Lcom/google/protobuf/DescriptorProtos$MethodOptions$IdempotencyLevel;", "setIdempotencyLevel", "(Lcom/google/protobuf/DescriptorProtos$MethodOptions$IdempotencyLevel;)V", "uninterpretedOption", "Lcom/google/protobuf/kotlin/DslList;", "Lcom/google/protobuf/DescriptorProtos$UninterpretedOption;", "Lcom/google/protobuf/MethodOptionsKt$Dsl$UninterpretedOptionProxy;", "getUninterpretedOption", "()Lcom/google/protobuf/kotlin/DslList;", "featuresOrNull", "getFeaturesOrNull", "(Lcom/google/protobuf/MethodOptionsKt$Dsl;)Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "_build", "Lcom/google/protobuf/DescriptorProtos$MethodOptions;", "clear", "", "extension", "Lcom/google/protobuf/ExtensionLite;", "clearDeprecated", "clearFeatures", "clearIdempotencyLevel", "contains", "get", ExifInterface.GPS_DIRECTION_TRUE, "(Lcom/google/protobuf/ExtensionLite;)Ljava/lang/Object;", "Lcom/google/protobuf/kotlin/ExtensionList;", ExifInterface.LONGITUDE_EAST, "", "-getRepeatedExtension", "hasDeprecated", "hasFeatures", "hasIdempotencyLevel", "set", "Lcom/google/protobuf/MessageLite;", "(Lcom/google/protobuf/ExtensionLite;Lcom/google/protobuf/MessageLite;)V", "", "(Lcom/google/protobuf/ExtensionLite;Ljava/lang/Comparable;)V", "Lcom/google/protobuf/ByteString;", "setExtension", "(Lcom/google/protobuf/ExtensionLite;Ljava/lang/Object;)V", "add", "addUninterpretedOption", "(Lcom/google/protobuf/kotlin/ExtensionList;Ljava/lang/Object;)V", "addAll", "values", "", "addAllUninterpretedOption", "clearUninterpretedOption", "plusAssign", "plusAssignUninterpretedOption", "plusAssignAllUninterpretedOption", ConfigConstants.CONFIG_INDEX_SECTION, "", "setUninterpretedOption", "(Lcom/google/protobuf/kotlin/ExtensionList;ILjava/lang/Object;)V", "Companion", "UninterpretedOptionProxy", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Dsl {

        /* INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final DescriptorProtos.MethodOptions.Builder _builder;

        public /* synthetic */ Dsl(DescriptorProtos.MethodOptions.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        private Dsl(DescriptorProtos.MethodOptions.Builder builder) {
            this._builder = builder;
        }

        /* INFO: compiled from: MethodOptionsKt.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/MethodOptionsKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/MethodOptionsKt$Dsl;", "builder", "Lcom/google/protobuf/DescriptorProtos$MethodOptions$Builder;", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final /* synthetic */ Dsl _create(DescriptorProtos.MethodOptions.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public final /* synthetic */ DescriptorProtos.MethodOptions _build() {
            DescriptorProtos.MethodOptions methodOptionsBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(methodOptionsBuild, "_builder.build()");
            return methodOptionsBuild;
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

        public final DescriptorProtos.MethodOptions.IdempotencyLevel getIdempotencyLevel() {
            DescriptorProtos.MethodOptions.IdempotencyLevel idempotencyLevel = this._builder.getIdempotencyLevel();
            Intrinsics.checkNotNullExpressionValue(idempotencyLevel, "_builder.getIdempotencyLevel()");
            return idempotencyLevel;
        }

        public final void setIdempotencyLevel(DescriptorProtos.MethodOptions.IdempotencyLevel value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setIdempotencyLevel(value);
        }

        public final void clearIdempotencyLevel() {
            this._builder.clearIdempotencyLevel();
        }

        public final boolean hasIdempotencyLevel() {
            return this._builder.hasIdempotencyLevel();
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
            return MethodOptionsKtKt.getFeaturesOrNull(dsl._builder);
        }

        /* INFO: compiled from: MethodOptionsKt.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/MethodOptionsKt$Dsl$UninterpretedOptionProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of com.google.protobuf.MethodOptionsKt.Dsl.get");
                return obj;
            }
            Object extension2 = this._builder.getExtension(extension);
            Intrinsics.checkNotNullExpressionValue(extension2, "{\n        _builder.getExtension(extension)\n      }");
            return extension2;
        }

        /* INFO: renamed from: -getRepeatedExtension, reason: not valid java name */
        public final /* synthetic */ ExtensionList m3427getRepeatedExtension(ExtensionLite extension) {
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

        public final /* synthetic */ <T extends Comparable<? super T>> void set(ExtensionLite<DescriptorProtos.MethodOptions, T> extension, T value) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            Intrinsics.checkNotNullParameter(value, "value");
            setExtension(extension, value);
        }

        public final /* synthetic */ void set(ExtensionLite<DescriptorProtos.MethodOptions, ByteString> extension, ByteString value) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            Intrinsics.checkNotNullParameter(value, "value");
            setExtension(extension, value);
        }

        public final /* synthetic */ <T extends MessageLite> void set(ExtensionLite<DescriptorProtos.MethodOptions, T> extension, T value) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            Intrinsics.checkNotNullParameter(value, "value");
            setExtension(extension, value);
        }

        public final /* synthetic */ void add(ExtensionList extensionList, Object value) {
            Intrinsics.checkNotNullParameter(extensionList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addExtension(extensionList.getExtension(), value);
        }

        public final /* synthetic */ <E> void plusAssign(ExtensionList<E, DescriptorProtos.MethodOptions> extensionList, E value) {
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

        public final /* synthetic */ <E> void plusAssign(ExtensionList<E, DescriptorProtos.MethodOptions> extensionList, Iterable<? extends E> values) {
            Intrinsics.checkNotNullParameter(extensionList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAll(extensionList, values);
        }

        public final /* synthetic */ void set(ExtensionList extensionList, int i, Object value) {
            Intrinsics.checkNotNullParameter(extensionList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setExtension(extensionList.getExtension(), i, value);
        }

        public final /* synthetic */ void clear(ExtensionList<?, DescriptorProtos.MethodOptions> extensionList) {
            Intrinsics.checkNotNullParameter(extensionList, "<this>");
            clear(extensionList.getExtension());
        }
    }

    private MethodOptionsKt() {
    }
}
