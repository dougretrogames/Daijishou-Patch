package com.google.protobuf;

import androidx.exifinterface.media.ExifInterface;
import com.google.protobuf.kotlin.ExtensionList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: FeatureSetKt.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/google/protobuf/FeatureSetKt;", "", "()V", "Dsl", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FeatureSetKt {
    public static final FeatureSetKt INSTANCE = new FeatureSetKt();

    /* INFO: compiled from: FeatureSetKt.kt */
    @Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 V2\u00020\u0001:\u0001VB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010*\u001a\u00020+H\u0001J\u0018\u0010,\u001a\u00020-2\u0010\u0010.\u001a\f\u0012\u0004\u0012\u00020+\u0012\u0002\b\u00030/J\u0006\u00100\u001a\u00020-J\u0006\u00101\u001a\u00020-J\u0006\u00102\u001a\u00020-J\u0006\u00103\u001a\u00020-J\u0006\u00104\u001a\u00020-J\u0006\u00105\u001a\u00020-J\u001b\u00106\u001a\u0002072\u0010\u0010.\u001a\f\u0012\u0004\u0012\u00020+\u0012\u0002\b\u00030/H\u0086\u0002J,\u00108\u001a\u0002H9\"\b\b\u0000\u00109*\u00020\u00012\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u0002H90/H\u0086\u0002¢\u0006\u0002\u0010:J>\u00108\u001a\u000e\u0012\u0004\u0012\u0002H<\u0012\u0004\u0012\u00020+0;\"\b\b\u0000\u0010<*\u00020\u00012\u0018\u0010.\u001a\u0014\u0012\u0004\u0012\u00020+\u0012\n\u0012\b\u0012\u0004\u0012\u0002H<0=0/H\u0087\u0002¢\u0006\u0002\b>J\u0006\u0010?\u001a\u000207J\u0006\u0010@\u001a\u000207J\u0006\u0010A\u001a\u000207J\u0006\u0010B\u001a\u000207J\u0006\u0010C\u001a\u000207J\u0006\u0010D\u001a\u000207J4\u0010E\u001a\u00020-\"\b\b\u0000\u00109*\u00020F2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u0002H90/2\u0006\u0010\u0005\u001a\u0002H9H\u0086\n¢\u0006\u0002\u0010GJ:\u0010E\u001a\u00020-\"\u000e\b\u0000\u00109*\b\u0012\u0004\u0012\u0002H90H2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u0002H90/2\u0006\u0010\u0005\u001a\u0002H9H\u0086\n¢\u0006\u0002\u0010IJ%\u0010E\u001a\u00020-2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020J0/2\u0006\u0010\u0005\u001a\u00020JH\u0086\nJ1\u0010K\u001a\u00020-\"\b\b\u0000\u00109*\u00020\u00012\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u0002H90/2\u0006\u0010\u0005\u001a\u0002H9¢\u0006\u0002\u0010LJ-\u0010M\u001a\u00020-\"\b\b\u0000\u0010<*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002H<\u0012\u0004\u0012\u00020+0;2\u0006\u0010\u0005\u001a\u0002H<¢\u0006\u0002\u0010NJ.\u0010O\u001a\u00020-\"\b\b\u0000\u0010<*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002H<\u0012\u0004\u0012\u00020+0;2\f\u0010P\u001a\b\u0012\u0004\u0012\u0002H<0QJ\u0017\u0010,\u001a\u00020-*\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020+0;H\u0086\bJ0\u0010R\u001a\u00020-\"\b\b\u0000\u0010<*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002H<\u0012\u0004\u0012\u00020+0;2\u0006\u0010\u0005\u001a\u0002H<H\u0086\n¢\u0006\u0002\u0010NJ1\u0010R\u001a\u00020-\"\b\b\u0000\u0010<*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002H<\u0012\u0004\u0012\u00020+0;2\f\u0010P\u001a\b\u0012\u0004\u0012\u0002H<0QH\u0086\nJ8\u0010E\u001a\u00020-\"\b\b\u0000\u0010<*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002H<\u0012\u0004\u0012\u00020+0;2\u0006\u0010S\u001a\u00020T2\u0006\u0010\u0005\u001a\u0002H<H\u0086\u0002¢\u0006\u0002\u0010UR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00188G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u001e8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010%\u001a\u00020$2\u0006\u0010\u0005\u001a\u00020$8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006W"}, d2 = {"Lcom/google/protobuf/FeatureSetKt$Dsl;", "", "_builder", "Lcom/google/protobuf/DescriptorProtos$FeatureSet$Builder;", "(Lcom/google/protobuf/DescriptorProtos$FeatureSet$Builder;)V", "value", "Lcom/google/protobuf/DescriptorProtos$FeatureSet$EnumType;", "enumType", "getEnumType", "()Lcom/google/protobuf/DescriptorProtos$FeatureSet$EnumType;", "setEnumType", "(Lcom/google/protobuf/DescriptorProtos$FeatureSet$EnumType;)V", "Lcom/google/protobuf/DescriptorProtos$FeatureSet$FieldPresence;", "fieldPresence", "getFieldPresence", "()Lcom/google/protobuf/DescriptorProtos$FeatureSet$FieldPresence;", "setFieldPresence", "(Lcom/google/protobuf/DescriptorProtos$FeatureSet$FieldPresence;)V", "Lcom/google/protobuf/DescriptorProtos$FeatureSet$JsonFormat;", "jsonFormat", "getJsonFormat", "()Lcom/google/protobuf/DescriptorProtos$FeatureSet$JsonFormat;", "setJsonFormat", "(Lcom/google/protobuf/DescriptorProtos$FeatureSet$JsonFormat;)V", "Lcom/google/protobuf/DescriptorProtos$FeatureSet$MessageEncoding;", "messageEncoding", "getMessageEncoding", "()Lcom/google/protobuf/DescriptorProtos$FeatureSet$MessageEncoding;", "setMessageEncoding", "(Lcom/google/protobuf/DescriptorProtos$FeatureSet$MessageEncoding;)V", "Lcom/google/protobuf/DescriptorProtos$FeatureSet$RepeatedFieldEncoding;", "repeatedFieldEncoding", "getRepeatedFieldEncoding", "()Lcom/google/protobuf/DescriptorProtos$FeatureSet$RepeatedFieldEncoding;", "setRepeatedFieldEncoding", "(Lcom/google/protobuf/DescriptorProtos$FeatureSet$RepeatedFieldEncoding;)V", "Lcom/google/protobuf/DescriptorProtos$FeatureSet$Utf8Validation;", "utf8Validation", "getUtf8Validation", "()Lcom/google/protobuf/DescriptorProtos$FeatureSet$Utf8Validation;", "setUtf8Validation", "(Lcom/google/protobuf/DescriptorProtos$FeatureSet$Utf8Validation;)V", "_build", "Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "clear", "", "extension", "Lcom/google/protobuf/ExtensionLite;", "clearEnumType", "clearFieldPresence", "clearJsonFormat", "clearMessageEncoding", "clearRepeatedFieldEncoding", "clearUtf8Validation", "contains", "", "get", ExifInterface.GPS_DIRECTION_TRUE, "(Lcom/google/protobuf/ExtensionLite;)Ljava/lang/Object;", "Lcom/google/protobuf/kotlin/ExtensionList;", ExifInterface.LONGITUDE_EAST, "", "-getRepeatedExtension", "hasEnumType", "hasFieldPresence", "hasJsonFormat", "hasMessageEncoding", "hasRepeatedFieldEncoding", "hasUtf8Validation", "set", "Lcom/google/protobuf/MessageLite;", "(Lcom/google/protobuf/ExtensionLite;Lcom/google/protobuf/MessageLite;)V", "", "(Lcom/google/protobuf/ExtensionLite;Ljava/lang/Comparable;)V", "Lcom/google/protobuf/ByteString;", "setExtension", "(Lcom/google/protobuf/ExtensionLite;Ljava/lang/Object;)V", "add", "(Lcom/google/protobuf/kotlin/ExtensionList;Ljava/lang/Object;)V", "addAll", "values", "", "plusAssign", ConfigConstants.CONFIG_INDEX_SECTION, "", "(Lcom/google/protobuf/kotlin/ExtensionList;ILjava/lang/Object;)V", "Companion", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Dsl {

        /* INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final DescriptorProtos.FeatureSet.Builder _builder;

        public /* synthetic */ Dsl(DescriptorProtos.FeatureSet.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        private Dsl(DescriptorProtos.FeatureSet.Builder builder) {
            this._builder = builder;
        }

        /* INFO: compiled from: FeatureSetKt.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/FeatureSetKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/FeatureSetKt$Dsl;", "builder", "Lcom/google/protobuf/DescriptorProtos$FeatureSet$Builder;", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final /* synthetic */ Dsl _create(DescriptorProtos.FeatureSet.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public final /* synthetic */ DescriptorProtos.FeatureSet _build() {
            DescriptorProtos.FeatureSet featureSetBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(featureSetBuild, "_builder.build()");
            return featureSetBuild;
        }

        public final DescriptorProtos.FeatureSet.FieldPresence getFieldPresence() {
            DescriptorProtos.FeatureSet.FieldPresence fieldPresence = this._builder.getFieldPresence();
            Intrinsics.checkNotNullExpressionValue(fieldPresence, "_builder.getFieldPresence()");
            return fieldPresence;
        }

        public final void setFieldPresence(DescriptorProtos.FeatureSet.FieldPresence value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setFieldPresence(value);
        }

        public final void clearFieldPresence() {
            this._builder.clearFieldPresence();
        }

        public final boolean hasFieldPresence() {
            return this._builder.hasFieldPresence();
        }

        public final DescriptorProtos.FeatureSet.EnumType getEnumType() {
            DescriptorProtos.FeatureSet.EnumType enumType = this._builder.getEnumType();
            Intrinsics.checkNotNullExpressionValue(enumType, "_builder.getEnumType()");
            return enumType;
        }

        public final void setEnumType(DescriptorProtos.FeatureSet.EnumType value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setEnumType(value);
        }

        public final void clearEnumType() {
            this._builder.clearEnumType();
        }

        public final boolean hasEnumType() {
            return this._builder.hasEnumType();
        }

        public final DescriptorProtos.FeatureSet.RepeatedFieldEncoding getRepeatedFieldEncoding() {
            DescriptorProtos.FeatureSet.RepeatedFieldEncoding repeatedFieldEncoding = this._builder.getRepeatedFieldEncoding();
            Intrinsics.checkNotNullExpressionValue(repeatedFieldEncoding, "_builder.getRepeatedFieldEncoding()");
            return repeatedFieldEncoding;
        }

        public final void setRepeatedFieldEncoding(DescriptorProtos.FeatureSet.RepeatedFieldEncoding value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setRepeatedFieldEncoding(value);
        }

        public final void clearRepeatedFieldEncoding() {
            this._builder.clearRepeatedFieldEncoding();
        }

        public final boolean hasRepeatedFieldEncoding() {
            return this._builder.hasRepeatedFieldEncoding();
        }

        public final DescriptorProtos.FeatureSet.Utf8Validation getUtf8Validation() {
            DescriptorProtos.FeatureSet.Utf8Validation utf8Validation = this._builder.getUtf8Validation();
            Intrinsics.checkNotNullExpressionValue(utf8Validation, "_builder.getUtf8Validation()");
            return utf8Validation;
        }

        public final void setUtf8Validation(DescriptorProtos.FeatureSet.Utf8Validation value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setUtf8Validation(value);
        }

        public final void clearUtf8Validation() {
            this._builder.clearUtf8Validation();
        }

        public final boolean hasUtf8Validation() {
            return this._builder.hasUtf8Validation();
        }

        public final DescriptorProtos.FeatureSet.MessageEncoding getMessageEncoding() {
            DescriptorProtos.FeatureSet.MessageEncoding messageEncoding = this._builder.getMessageEncoding();
            Intrinsics.checkNotNullExpressionValue(messageEncoding, "_builder.getMessageEncoding()");
            return messageEncoding;
        }

        public final void setMessageEncoding(DescriptorProtos.FeatureSet.MessageEncoding value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setMessageEncoding(value);
        }

        public final void clearMessageEncoding() {
            this._builder.clearMessageEncoding();
        }

        public final boolean hasMessageEncoding() {
            return this._builder.hasMessageEncoding();
        }

        public final DescriptorProtos.FeatureSet.JsonFormat getJsonFormat() {
            DescriptorProtos.FeatureSet.JsonFormat jsonFormat = this._builder.getJsonFormat();
            Intrinsics.checkNotNullExpressionValue(jsonFormat, "_builder.getJsonFormat()");
            return jsonFormat;
        }

        public final void setJsonFormat(DescriptorProtos.FeatureSet.JsonFormat value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setJsonFormat(value);
        }

        public final void clearJsonFormat() {
            this._builder.clearJsonFormat();
        }

        public final boolean hasJsonFormat() {
            return this._builder.hasJsonFormat();
        }

        public final /* synthetic */ Object get(ExtensionLite extension) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            if (extension.isRepeated()) {
                Object obj = get(extension);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of com.google.protobuf.FeatureSetKt.Dsl.get");
                return obj;
            }
            Object extension2 = this._builder.getExtension(extension);
            Intrinsics.checkNotNullExpressionValue(extension2, "{\n        _builder.getExtension(extension)\n      }");
            return extension2;
        }

        /* INFO: renamed from: -getRepeatedExtension, reason: not valid java name */
        public final /* synthetic */ ExtensionList m3402getRepeatedExtension(ExtensionLite extension) {
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

        public final /* synthetic */ <T extends Comparable<? super T>> void set(ExtensionLite<DescriptorProtos.FeatureSet, T> extension, T value) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            Intrinsics.checkNotNullParameter(value, "value");
            setExtension(extension, value);
        }

        public final /* synthetic */ void set(ExtensionLite<DescriptorProtos.FeatureSet, ByteString> extension, ByteString value) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            Intrinsics.checkNotNullParameter(value, "value");
            setExtension(extension, value);
        }

        public final /* synthetic */ <T extends MessageLite> void set(ExtensionLite<DescriptorProtos.FeatureSet, T> extension, T value) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            Intrinsics.checkNotNullParameter(value, "value");
            setExtension(extension, value);
        }

        public final /* synthetic */ void add(ExtensionList extensionList, Object value) {
            Intrinsics.checkNotNullParameter(extensionList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addExtension(extensionList.getExtension(), value);
        }

        public final /* synthetic */ <E> void plusAssign(ExtensionList<E, DescriptorProtos.FeatureSet> extensionList, E value) {
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

        public final /* synthetic */ <E> void plusAssign(ExtensionList<E, DescriptorProtos.FeatureSet> extensionList, Iterable<? extends E> values) {
            Intrinsics.checkNotNullParameter(extensionList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAll(extensionList, values);
        }

        public final /* synthetic */ void set(ExtensionList extensionList, int i, Object value) {
            Intrinsics.checkNotNullParameter(extensionList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setExtension(extensionList.getExtension(), i, value);
        }

        public final /* synthetic */ void clear(ExtensionList<?, DescriptorProtos.FeatureSet> extensionList) {
            Intrinsics.checkNotNullParameter(extensionList, "<this>");
            clear(extensionList.getExtension());
        }
    }

    private FeatureSetKt() {
    }
}
