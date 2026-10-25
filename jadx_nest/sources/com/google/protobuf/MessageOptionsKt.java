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

/* JADX INFO: compiled from: MessageOptionsKt.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/google/protobuf/MessageOptionsKt;", "", "()V", "Dsl", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MessageOptionsKt {
    public static final MessageOptionsKt INSTANCE = new MessageOptionsKt();

    /* JADX INFO: compiled from: MessageOptionsKt.kt */
    @Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u001c\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u0000 Z2\u00020\u0001:\u0002Z[B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010)\u001a\u00020*H\u0001J\u0018\u0010+\u001a\u00020,2\u0010\u0010-\u001a\f\u0012\u0004\u0012\u00020*\u0012\u0002\b\u00030.J\u0006\u0010/\u001a\u00020,J\u0006\u00100\u001a\u00020,J\u0006\u00101\u001a\u00020,J\u0006\u00102\u001a\u00020,J\u0006\u00103\u001a\u00020,J\u0006\u00104\u001a\u00020,J\u001b\u00105\u001a\u00020\u00062\u0010\u0010-\u001a\f\u0012\u0004\u0012\u00020*\u0012\u0002\b\u00030.H\u0086\u0002J,\u00106\u001a\u0002H7\"\b\b\u0000\u00107*\u00020\u00012\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u0002H70.H\u0086\u0002¢\u0006\u0002\u00108J>\u00106\u001a\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020*09\"\b\b\u0000\u0010:*\u00020\u00012\u0018\u0010-\u001a\u0014\u0012\u0004\u0012\u00020*\u0012\n\u0012\b\u0012\u0004\u0012\u0002H:0;0.H\u0087\u0002¢\u0006\u0002\b<J\u0006\u0010=\u001a\u00020\u0006J\u0006\u0010>\u001a\u00020\u0006J\u0006\u0010?\u001a\u00020\u0006J\u0006\u0010@\u001a\u00020\u0006J\u0006\u0010A\u001a\u00020\u0006J\u0006\u0010B\u001a\u00020\u0006J4\u0010C\u001a\u00020,\"\b\b\u0000\u00107*\u00020D2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u0002H70.2\u0006\u0010\u0005\u001a\u0002H7H\u0086\n¢\u0006\u0002\u0010EJ:\u0010C\u001a\u00020,\"\u000e\b\u0000\u00107*\b\u0012\u0004\u0012\u0002H70F2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u0002H70.2\u0006\u0010\u0005\u001a\u0002H7H\u0086\n¢\u0006\u0002\u0010GJ%\u0010C\u001a\u00020,2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020H0.2\u0006\u0010\u0005\u001a\u00020HH\u0086\nJ1\u0010I\u001a\u00020,\"\b\b\u0000\u00107*\u00020\u00012\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u0002H70.2\u0006\u0010\u0005\u001a\u0002H7¢\u0006\u0002\u0010JJ%\u0010K\u001a\u00020,*\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0!2\u0006\u0010\u0005\u001a\u00020\"H\u0007¢\u0006\u0002\bLJ-\u0010K\u001a\u00020,\"\b\b\u0000\u0010:*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020*092\u0006\u0010\u0005\u001a\u0002H:¢\u0006\u0002\u0010MJ+\u0010N\u001a\u00020,*\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0!2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020\"0PH\u0007¢\u0006\u0002\bQJ.\u0010N\u001a\u00020,\"\b\b\u0000\u0010:*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020*092\f\u0010O\u001a\b\u0012\u0004\u0012\u0002H:0PJ\u001d\u0010+\u001a\u00020,*\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0!H\u0007¢\u0006\u0002\bRJ\u0017\u0010+\u001a\u00020,*\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020*09H\u0086\bJ&\u0010S\u001a\u00020,*\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0!2\u0006\u0010\u0005\u001a\u00020\"H\u0087\n¢\u0006\u0002\bTJ,\u0010S\u001a\u00020,*\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0!2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020\"0PH\u0087\n¢\u0006\u0002\bUJ0\u0010S\u001a\u00020,\"\b\b\u0000\u0010:*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020*092\u0006\u0010\u0005\u001a\u0002H:H\u0086\n¢\u0006\u0002\u0010MJ1\u0010S\u001a\u00020,\"\b\b\u0000\u0010:*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020*092\f\u0010O\u001a\b\u0012\u0004\u0012\u0002H:0PH\u0086\nJ.\u0010C\u001a\u00020,*\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0!2\u0006\u0010V\u001a\u00020W2\u0006\u0010\u0005\u001a\u00020\"H\u0087\u0002¢\u0006\u0002\bXJ8\u0010C\u001a\u00020,\"\b\b\u0000\u0010:*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020*092\u0006\u0010V\u001a\u00020W2\u0006\u0010\u0005\u001a\u0002H:H\u0086\u0002¢\u0006\u0002\u0010YR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR*\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000bR$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00118G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\t\"\u0004\b\u0019\u0010\u000bR$\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\t\"\u0004\b\u001c\u0010\u000bR$\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\t\"\u0004\b\u001f\u0010\u000bR\u001d\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0!8F¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0017\u0010&\u001a\u0004\u0018\u00010\u0011*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006\\"}, d2 = {"Lcom/google/protobuf/MessageOptionsKt$Dsl;", "", "_builder", "Lcom/google/protobuf/DescriptorProtos$MessageOptions$Builder;", "(Lcom/google/protobuf/DescriptorProtos$MessageOptions$Builder;)V", "value", "", "deprecated", "getDeprecated", "()Z", "setDeprecated", "(Z)V", "deprecatedLegacyJsonFieldConflicts", "getDeprecatedLegacyJsonFieldConflicts$annotations", "()V", "getDeprecatedLegacyJsonFieldConflicts", "setDeprecatedLegacyJsonFieldConflicts", "Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "features", "getFeatures", "()Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "setFeatures", "(Lcom/google/protobuf/DescriptorProtos$FeatureSet;)V", "mapEntry", "getMapEntry", "setMapEntry", "messageSetWireFormat", "getMessageSetWireFormat", "setMessageSetWireFormat", "noStandardDescriptorAccessor", "getNoStandardDescriptorAccessor", "setNoStandardDescriptorAccessor", "uninterpretedOption", "Lcom/google/protobuf/kotlin/DslList;", "Lcom/google/protobuf/DescriptorProtos$UninterpretedOption;", "Lcom/google/protobuf/MessageOptionsKt$Dsl$UninterpretedOptionProxy;", "getUninterpretedOption", "()Lcom/google/protobuf/kotlin/DslList;", "featuresOrNull", "getFeaturesOrNull", "(Lcom/google/protobuf/MessageOptionsKt$Dsl;)Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "_build", "Lcom/google/protobuf/DescriptorProtos$MessageOptions;", "clear", "", "extension", "Lcom/google/protobuf/ExtensionLite;", "clearDeprecated", "clearDeprecatedLegacyJsonFieldConflicts", "clearFeatures", "clearMapEntry", "clearMessageSetWireFormat", "clearNoStandardDescriptorAccessor", "contains", "get", ExifInterface.GPS_DIRECTION_TRUE, "(Lcom/google/protobuf/ExtensionLite;)Ljava/lang/Object;", "Lcom/google/protobuf/kotlin/ExtensionList;", ExifInterface.LONGITUDE_EAST, "", "-getRepeatedExtension", "hasDeprecated", "hasDeprecatedLegacyJsonFieldConflicts", "hasFeatures", "hasMapEntry", "hasMessageSetWireFormat", "hasNoStandardDescriptorAccessor", "set", "Lcom/google/protobuf/MessageLite;", "(Lcom/google/protobuf/ExtensionLite;Lcom/google/protobuf/MessageLite;)V", "", "(Lcom/google/protobuf/ExtensionLite;Ljava/lang/Comparable;)V", "Lcom/google/protobuf/ByteString;", "setExtension", "(Lcom/google/protobuf/ExtensionLite;Ljava/lang/Object;)V", "add", "addUninterpretedOption", "(Lcom/google/protobuf/kotlin/ExtensionList;Ljava/lang/Object;)V", "addAll", "values", "", "addAllUninterpretedOption", "clearUninterpretedOption", "plusAssign", "plusAssignUninterpretedOption", "plusAssignAllUninterpretedOption", ConfigConstants.CONFIG_INDEX_SECTION, "", "setUninterpretedOption", "(Lcom/google/protobuf/kotlin/ExtensionList;ILjava/lang/Object;)V", "Companion", "UninterpretedOptionProxy", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Dsl {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final DescriptorProtos.MessageOptions.Builder _builder;

        public /* synthetic */ Dsl(DescriptorProtos.MessageOptions.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        @Deprecated(message = "Field deprecatedLegacyJsonFieldConflicts is deprecated")
        public static /* synthetic */ void getDeprecatedLegacyJsonFieldConflicts$annotations() {
        }

        private Dsl(DescriptorProtos.MessageOptions.Builder builder) {
            this._builder = builder;
        }

        /* JADX INFO: compiled from: MessageOptionsKt.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/MessageOptionsKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/MessageOptionsKt$Dsl;", "builder", "Lcom/google/protobuf/DescriptorProtos$MessageOptions$Builder;", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final /* synthetic */ Dsl _create(DescriptorProtos.MessageOptions.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public final /* synthetic */ DescriptorProtos.MessageOptions _build() {
            DescriptorProtos.MessageOptions messageOptionsBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(messageOptionsBuild, "_builder.build()");
            return messageOptionsBuild;
        }

        public final boolean getMessageSetWireFormat() {
            return this._builder.getMessageSetWireFormat();
        }

        public final void setMessageSetWireFormat(boolean z) {
            this._builder.setMessageSetWireFormat(z);
        }

        public final void clearMessageSetWireFormat() {
            this._builder.clearMessageSetWireFormat();
        }

        public final boolean hasMessageSetWireFormat() {
            return this._builder.hasMessageSetWireFormat();
        }

        public final boolean getNoStandardDescriptorAccessor() {
            return this._builder.getNoStandardDescriptorAccessor();
        }

        public final void setNoStandardDescriptorAccessor(boolean z) {
            this._builder.setNoStandardDescriptorAccessor(z);
        }

        public final void clearNoStandardDescriptorAccessor() {
            this._builder.clearNoStandardDescriptorAccessor();
        }

        public final boolean hasNoStandardDescriptorAccessor() {
            return this._builder.hasNoStandardDescriptorAccessor();
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

        public final boolean getMapEntry() {
            return this._builder.getMapEntry();
        }

        public final void setMapEntry(boolean z) {
            this._builder.setMapEntry(z);
        }

        public final void clearMapEntry() {
            this._builder.clearMapEntry();
        }

        public final boolean hasMapEntry() {
            return this._builder.hasMapEntry();
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
            return MessageOptionsKtKt.getFeaturesOrNull(dsl._builder);
        }

        /* JADX INFO: compiled from: MessageOptionsKt.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/MessageOptionsKt$Dsl$UninterpretedOptionProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of com.google.protobuf.MessageOptionsKt.Dsl.get");
                return obj;
            }
            Object extension2 = this._builder.getExtension(extension);
            Intrinsics.checkNotNullExpressionValue(extension2, "{\n        _builder.getExtension(extension)\n      }");
            return extension2;
        }

        /* JADX INFO: renamed from: -getRepeatedExtension, reason: not valid java name */
        public final /* synthetic */ ExtensionList m3423getRepeatedExtension(ExtensionLite extension) {
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

        public final /* synthetic */ <T extends Comparable<? super T>> void set(ExtensionLite<DescriptorProtos.MessageOptions, T> extension, T value) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            Intrinsics.checkNotNullParameter(value, "value");
            setExtension(extension, value);
        }

        public final /* synthetic */ void set(ExtensionLite<DescriptorProtos.MessageOptions, ByteString> extension, ByteString value) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            Intrinsics.checkNotNullParameter(value, "value");
            setExtension(extension, value);
        }

        public final /* synthetic */ <T extends MessageLite> void set(ExtensionLite<DescriptorProtos.MessageOptions, T> extension, T value) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            Intrinsics.checkNotNullParameter(value, "value");
            setExtension(extension, value);
        }

        public final /* synthetic */ void add(ExtensionList extensionList, Object value) {
            Intrinsics.checkNotNullParameter(extensionList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addExtension(extensionList.getExtension(), value);
        }

        public final /* synthetic */ <E> void plusAssign(ExtensionList<E, DescriptorProtos.MessageOptions> extensionList, E value) {
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

        public final /* synthetic */ <E> void plusAssign(ExtensionList<E, DescriptorProtos.MessageOptions> extensionList, Iterable<? extends E> values) {
            Intrinsics.checkNotNullParameter(extensionList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAll(extensionList, values);
        }

        public final /* synthetic */ void set(ExtensionList extensionList, int i, Object value) {
            Intrinsics.checkNotNullParameter(extensionList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setExtension(extensionList.getExtension(), i, value);
        }

        public final /* synthetic */ void clear(ExtensionList<?, DescriptorProtos.MessageOptions> extensionList) {
            Intrinsics.checkNotNullParameter(extensionList, "<this>");
            clear(extensionList.getExtension());
        }
    }

    private MessageOptionsKt() {
    }
}
