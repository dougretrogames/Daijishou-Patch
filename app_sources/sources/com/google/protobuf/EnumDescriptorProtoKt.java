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

/* INFO: compiled from: EnumDescriptorProtoKt.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"Lcom/google/protobuf/EnumDescriptorProtoKt;", "", "()V", "enumReservedRange", "Lcom/google/protobuf/DescriptorProtos$EnumDescriptorProto$EnumReservedRange;", "block", "Lkotlin/Function1;", "Lcom/google/protobuf/EnumDescriptorProtoKt$EnumReservedRangeKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeenumReservedRange", "Dsl", "EnumReservedRangeKt", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EnumDescriptorProtoKt {
    public static final EnumDescriptorProtoKt INSTANCE = new EnumDescriptorProtoKt();

    /* INFO: compiled from: EnumDescriptorProtoKt.kt */
    @Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u001c\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u0000 D2\u00020\u0001:\u0004DEFGB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010!\u001a\u00020\"H\u0001J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020$J\u0006\u0010&\u001a\u00020'J\u0006\u0010(\u001a\u00020'J%\u0010)\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00132\u0006\u0010\u0005\u001a\u00020\u0018H\u0007¢\u0006\u0002\b*J%\u0010)\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u00132\u0006\u0010\u0005\u001a\u00020\u001bH\u0007¢\u0006\u0002\b+J%\u0010)\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\b,J+\u0010-\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00132\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00180/H\u0007¢\u0006\u0002\b0J+\u0010-\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u00132\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001b0/H\u0007¢\u0006\u0002\b1J+\u0010-\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00060/H\u0007¢\u0006\u0002\b2J\u001d\u00103\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0013H\u0007¢\u0006\u0002\b4J\u001d\u00103\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u0013H\u0007¢\u0006\u0002\b5J\u001d\u00103\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u0013H\u0007¢\u0006\u0002\b6J&\u00107\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00132\u0006\u0010\u0005\u001a\u00020\u0018H\u0087\n¢\u0006\u0002\b8J,\u00107\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00132\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00180/H\u0087\n¢\u0006\u0002\b9J&\u00107\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u00132\u0006\u0010\u0005\u001a\u00020\u001bH\u0087\n¢\u0006\u0002\b:J,\u00107\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u00132\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001b0/H\u0087\n¢\u0006\u0002\b;J&\u00107\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0005\u001a\u00020\u0006H\u0087\n¢\u0006\u0002\b<J,\u00107\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00060/H\u0087\n¢\u0006\u0002\b=J.\u0010>\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00132\u0006\u0010?\u001a\u00020@2\u0006\u0010\u0005\u001a\u00020\u0018H\u0087\u0002¢\u0006\u0002\bAJ.\u0010>\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u00132\u0006\u0010?\u001a\u00020@2\u0006\u0010\u0005\u001a\u00020\u001bH\u0087\u0002¢\u0006\u0002\bBJ.\u0010>\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010?\u001a\u00020@2\u0006\u0010\u0005\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\bCR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u00138F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00138F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u00138F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0016R\u0017\u0010\u001e\u001a\u0004\u0018\u00010\f*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006H"}, d2 = {"Lcom/google/protobuf/EnumDescriptorProtoKt$Dsl;", "", "_builder", "Lcom/google/protobuf/DescriptorProtos$EnumDescriptorProto$Builder;", "(Lcom/google/protobuf/DescriptorProtos$EnumDescriptorProto$Builder;)V", "value", "", "name", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "Lcom/google/protobuf/DescriptorProtos$EnumOptions;", "options", "getOptions", "()Lcom/google/protobuf/DescriptorProtos$EnumOptions;", "setOptions", "(Lcom/google/protobuf/DescriptorProtos$EnumOptions;)V", "reservedName", "Lcom/google/protobuf/kotlin/DslList;", "Lcom/google/protobuf/EnumDescriptorProtoKt$Dsl$ReservedNameProxy;", "getReservedName", "()Lcom/google/protobuf/kotlin/DslList;", "reservedRange", "Lcom/google/protobuf/DescriptorProtos$EnumDescriptorProto$EnumReservedRange;", "Lcom/google/protobuf/EnumDescriptorProtoKt$Dsl$ReservedRangeProxy;", "getReservedRange", "Lcom/google/protobuf/DescriptorProtos$EnumValueDescriptorProto;", "Lcom/google/protobuf/EnumDescriptorProtoKt$Dsl$ValueProxy;", "getValue", "optionsOrNull", "getOptionsOrNull", "(Lcom/google/protobuf/EnumDescriptorProtoKt$Dsl;)Lcom/google/protobuf/DescriptorProtos$EnumOptions;", "_build", "Lcom/google/protobuf/DescriptorProtos$EnumDescriptorProto;", "clearName", "", "clearOptions", "hasName", "", "hasOptions", "add", "addReservedRange", "addValue", "addReservedName", "addAll", "values", "", "addAllReservedRange", "addAllValue", "addAllReservedName", "clear", "clearReservedRange", "clearValue", "clearReservedName", "plusAssign", "plusAssignReservedRange", "plusAssignAllReservedRange", "plusAssignValue", "plusAssignAllValue", "plusAssignReservedName", "plusAssignAllReservedName", "set", ConfigConstants.CONFIG_INDEX_SECTION, "", "setReservedRange", "setValue", "setReservedName", "Companion", "ReservedNameProxy", "ReservedRangeProxy", "ValueProxy", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Dsl {

        /* INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final DescriptorProtos.EnumDescriptorProto.Builder _builder;

        public /* synthetic */ Dsl(DescriptorProtos.EnumDescriptorProto.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        private Dsl(DescriptorProtos.EnumDescriptorProto.Builder builder) {
            this._builder = builder;
        }

        /* INFO: compiled from: EnumDescriptorProtoKt.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/EnumDescriptorProtoKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/EnumDescriptorProtoKt$Dsl;", "builder", "Lcom/google/protobuf/DescriptorProtos$EnumDescriptorProto$Builder;", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final /* synthetic */ Dsl _create(DescriptorProtos.EnumDescriptorProto.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public final /* synthetic */ DescriptorProtos.EnumDescriptorProto _build() {
            DescriptorProtos.EnumDescriptorProto enumDescriptorProtoBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(enumDescriptorProtoBuild, "_builder.build()");
            return enumDescriptorProtoBuild;
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

        /* INFO: compiled from: EnumDescriptorProtoKt.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/EnumDescriptorProtoKt$Dsl$ValueProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class ValueProxy extends DslProxy {
            private ValueProxy() {
            }
        }

        public final /* synthetic */ DslList getValue() {
            List<DescriptorProtos.EnumValueDescriptorProto> valueList = this._builder.getValueList();
            Intrinsics.checkNotNullExpressionValue(valueList, "_builder.getValueList()");
            return new DslList(valueList);
        }

        public final /* synthetic */ void addValue(DslList dslList, DescriptorProtos.EnumValueDescriptorProto value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addValue(value);
        }

        public final /* synthetic */ void plusAssignValue(DslList<DescriptorProtos.EnumValueDescriptorProto, ValueProxy> dslList, DescriptorProtos.EnumValueDescriptorProto value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addValue(dslList, value);
        }

        public final /* synthetic */ void addAllValue(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllValue(values);
        }

        public final /* synthetic */ void plusAssignAllValue(DslList<DescriptorProtos.EnumValueDescriptorProto, ValueProxy> dslList, Iterable<DescriptorProtos.EnumValueDescriptorProto> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllValue(dslList, values);
        }

        public final /* synthetic */ void setValue(DslList dslList, int i, DescriptorProtos.EnumValueDescriptorProto value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setValue(i, value);
        }

        public final /* synthetic */ void clearValue(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearValue();
        }

        public final DescriptorProtos.EnumOptions getOptions() {
            DescriptorProtos.EnumOptions options = this._builder.getOptions();
            Intrinsics.checkNotNullExpressionValue(options, "_builder.getOptions()");
            return options;
        }

        public final void setOptions(DescriptorProtos.EnumOptions value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setOptions(value);
        }

        public final void clearOptions() {
            this._builder.clearOptions();
        }

        public final boolean hasOptions() {
            return this._builder.hasOptions();
        }

        public final DescriptorProtos.EnumOptions getOptionsOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return EnumDescriptorProtoKtKt.getOptionsOrNull(dsl._builder);
        }

        /* INFO: compiled from: EnumDescriptorProtoKt.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/EnumDescriptorProtoKt$Dsl$ReservedRangeProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class ReservedRangeProxy extends DslProxy {
            private ReservedRangeProxy() {
            }
        }

        public final /* synthetic */ DslList getReservedRange() {
            List<DescriptorProtos.EnumDescriptorProto.EnumReservedRange> reservedRangeList = this._builder.getReservedRangeList();
            Intrinsics.checkNotNullExpressionValue(reservedRangeList, "_builder.getReservedRangeList()");
            return new DslList(reservedRangeList);
        }

        public final /* synthetic */ void addReservedRange(DslList dslList, DescriptorProtos.EnumDescriptorProto.EnumReservedRange value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addReservedRange(value);
        }

        public final /* synthetic */ void plusAssignReservedRange(DslList<DescriptorProtos.EnumDescriptorProto.EnumReservedRange, ReservedRangeProxy> dslList, DescriptorProtos.EnumDescriptorProto.EnumReservedRange value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addReservedRange(dslList, value);
        }

        public final /* synthetic */ void addAllReservedRange(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllReservedRange(values);
        }

        public final /* synthetic */ void plusAssignAllReservedRange(DslList<DescriptorProtos.EnumDescriptorProto.EnumReservedRange, ReservedRangeProxy> dslList, Iterable<DescriptorProtos.EnumDescriptorProto.EnumReservedRange> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllReservedRange(dslList, values);
        }

        public final /* synthetic */ void setReservedRange(DslList dslList, int i, DescriptorProtos.EnumDescriptorProto.EnumReservedRange value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setReservedRange(i, value);
        }

        public final /* synthetic */ void clearReservedRange(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearReservedRange();
        }

        /* INFO: compiled from: EnumDescriptorProtoKt.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/EnumDescriptorProtoKt$Dsl$ReservedNameProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class ReservedNameProxy extends DslProxy {
            private ReservedNameProxy() {
            }
        }

        public final /* synthetic */ DslList getReservedName() {
            ProtocolStringList reservedNameList = this._builder.getReservedNameList();
            Intrinsics.checkNotNullExpressionValue(reservedNameList, "_builder.getReservedNameList()");
            return new DslList(reservedNameList);
        }

        public final /* synthetic */ void addReservedName(DslList dslList, String value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addReservedName(value);
        }

        public final /* synthetic */ void plusAssignReservedName(DslList<String, ReservedNameProxy> dslList, String value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addReservedName(dslList, value);
        }

        public final /* synthetic */ void addAllReservedName(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllReservedName(values);
        }

        public final /* synthetic */ void plusAssignAllReservedName(DslList<String, ReservedNameProxy> dslList, Iterable<String> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllReservedName(dslList, values);
        }

        public final /* synthetic */ void setReservedName(DslList dslList, int i, String value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setReservedName(i, value);
        }

        public final /* synthetic */ void clearReservedName(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearReservedName();
        }
    }

    private EnumDescriptorProtoKt() {
    }

    /* INFO: renamed from: -initializeenumReservedRange, reason: not valid java name */
    public final DescriptorProtos.EnumDescriptorProto.EnumReservedRange m3388initializeenumReservedRange(Function1<? super EnumReservedRangeKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        EnumReservedRangeKt.Dsl.Companion companion = EnumReservedRangeKt.Dsl.INSTANCE;
        DescriptorProtos.EnumDescriptorProto.EnumReservedRange.Builder builderNewBuilder = DescriptorProtos.EnumDescriptorProto.EnumReservedRange.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        EnumReservedRangeKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    /* INFO: compiled from: EnumDescriptorProtoKt.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/google/protobuf/EnumDescriptorProtoKt$EnumReservedRangeKt;", "", "()V", "Dsl", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class EnumReservedRangeKt {
        public static final EnumReservedRangeKt INSTANCE = new EnumReservedRangeKt();

        /* INFO: compiled from: EnumDescriptorProtoKt.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0001J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/google/protobuf/EnumDescriptorProtoKt$EnumReservedRangeKt$Dsl;", "", "_builder", "Lcom/google/protobuf/DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder;", "(Lcom/google/protobuf/DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder;)V", "value", "", "end", "getEnd", "()I", "setEnd", "(I)V", "start", "getStart", "setStart", "_build", "Lcom/google/protobuf/DescriptorProtos$EnumDescriptorProto$EnumReservedRange;", "clearEnd", "", "clearStart", "hasEnd", "", "hasStart", "Companion", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Dsl {

            /* INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final DescriptorProtos.EnumDescriptorProto.EnumReservedRange.Builder _builder;

            public /* synthetic */ Dsl(DescriptorProtos.EnumDescriptorProto.EnumReservedRange.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }

            private Dsl(DescriptorProtos.EnumDescriptorProto.EnumReservedRange.Builder builder) {
                this._builder = builder;
            }

            /* INFO: compiled from: EnumDescriptorProtoKt.kt */
            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/EnumDescriptorProtoKt$EnumReservedRangeKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/EnumDescriptorProtoKt$EnumReservedRangeKt$Dsl;", "builder", "Lcom/google/protobuf/DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder;", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final /* synthetic */ Dsl _create(DescriptorProtos.EnumDescriptorProto.EnumReservedRange.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, null);
                }
            }

            public final /* synthetic */ DescriptorProtos.EnumDescriptorProto.EnumReservedRange _build() {
                DescriptorProtos.EnumDescriptorProto.EnumReservedRange enumReservedRangeBuild = this._builder.build();
                Intrinsics.checkNotNullExpressionValue(enumReservedRangeBuild, "_builder.build()");
                return enumReservedRangeBuild;
            }

            public final int getStart() {
                return this._builder.getStart();
            }

            public final void setStart(int i) {
                this._builder.setStart(i);
            }

            public final void clearStart() {
                this._builder.clearStart();
            }

            public final boolean hasStart() {
                return this._builder.hasStart();
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
        }

        private EnumReservedRangeKt() {
        }
    }
}
