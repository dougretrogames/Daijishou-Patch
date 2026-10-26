package com.google.protobuf;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: EnumValueDescriptorProtoKt.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/google/protobuf/EnumValueDescriptorProtoKt;", "", "()V", "Dsl", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EnumValueDescriptorProtoKt {
    public static final EnumValueDescriptorProtoKt INSTANCE = new EnumValueDescriptorProtoKt();

    /* INFO: compiled from: EnumValueDescriptorProtoKt.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001b\u001a\u00020\u001cH\u0001J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001eJ\u0006\u0010 \u001a\u00020\u001eJ\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\"J\u0006\u0010$\u001a\u00020\"R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\u0004\u0018\u00010\u0012*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006&"}, d2 = {"Lcom/google/protobuf/EnumValueDescriptorProtoKt$Dsl;", "", "_builder", "Lcom/google/protobuf/DescriptorProtos$EnumValueDescriptorProto$Builder;", "(Lcom/google/protobuf/DescriptorProtos$EnumValueDescriptorProto$Builder;)V", "value", "", "name", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "", "number", "getNumber", "()I", "setNumber", "(I)V", "Lcom/google/protobuf/DescriptorProtos$EnumValueOptions;", "options", "getOptions", "()Lcom/google/protobuf/DescriptorProtos$EnumValueOptions;", "setOptions", "(Lcom/google/protobuf/DescriptorProtos$EnumValueOptions;)V", "optionsOrNull", "getOptionsOrNull", "(Lcom/google/protobuf/EnumValueDescriptorProtoKt$Dsl;)Lcom/google/protobuf/DescriptorProtos$EnumValueOptions;", "_build", "Lcom/google/protobuf/DescriptorProtos$EnumValueDescriptorProto;", "clearName", "", "clearNumber", "clearOptions", "hasName", "", "hasNumber", "hasOptions", "Companion", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Dsl {

        /* INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final DescriptorProtos.EnumValueDescriptorProto.Builder _builder;

        public /* synthetic */ Dsl(DescriptorProtos.EnumValueDescriptorProto.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        private Dsl(DescriptorProtos.EnumValueDescriptorProto.Builder builder) {
            this._builder = builder;
        }

        /* INFO: compiled from: EnumValueDescriptorProtoKt.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/EnumValueDescriptorProtoKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/EnumValueDescriptorProtoKt$Dsl;", "builder", "Lcom/google/protobuf/DescriptorProtos$EnumValueDescriptorProto$Builder;", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final /* synthetic */ Dsl _create(DescriptorProtos.EnumValueDescriptorProto.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public final /* synthetic */ DescriptorProtos.EnumValueDescriptorProto _build() {
            DescriptorProtos.EnumValueDescriptorProto enumValueDescriptorProtoBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(enumValueDescriptorProtoBuild, "_builder.build()");
            return enumValueDescriptorProtoBuild;
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

        public final DescriptorProtos.EnumValueOptions getOptions() {
            DescriptorProtos.EnumValueOptions options = this._builder.getOptions();
            Intrinsics.checkNotNullExpressionValue(options, "_builder.getOptions()");
            return options;
        }

        public final void setOptions(DescriptorProtos.EnumValueOptions value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setOptions(value);
        }

        public final void clearOptions() {
            this._builder.clearOptions();
        }

        public final boolean hasOptions() {
            return this._builder.hasOptions();
        }

        public final DescriptorProtos.EnumValueOptions getOptionsOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return EnumValueDescriptorProtoKtKt.getOptionsOrNull(dsl._builder);
        }
    }

    private EnumValueDescriptorProtoKt() {
    }
}
