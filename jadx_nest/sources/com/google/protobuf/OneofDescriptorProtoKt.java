package com.google.protobuf;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OneofDescriptorProtoKt.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/google/protobuf/OneofDescriptorProtoKt;", "", "()V", "Dsl", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OneofDescriptorProtoKt {
    public static final OneofDescriptorProtoKt INSTANCE = new OneofDescriptorProtoKt();

    /* JADX INFO: compiled from: OneofDescriptorProtoKt.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0001J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\u0004\u0018\u00010\f*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/google/protobuf/OneofDescriptorProtoKt$Dsl;", "", "_builder", "Lcom/google/protobuf/DescriptorProtos$OneofDescriptorProto$Builder;", "(Lcom/google/protobuf/DescriptorProtos$OneofDescriptorProto$Builder;)V", "value", "", "name", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "Lcom/google/protobuf/DescriptorProtos$OneofOptions;", "options", "getOptions", "()Lcom/google/protobuf/DescriptorProtos$OneofOptions;", "setOptions", "(Lcom/google/protobuf/DescriptorProtos$OneofOptions;)V", "optionsOrNull", "getOptionsOrNull", "(Lcom/google/protobuf/OneofDescriptorProtoKt$Dsl;)Lcom/google/protobuf/DescriptorProtos$OneofOptions;", "_build", "Lcom/google/protobuf/DescriptorProtos$OneofDescriptorProto;", "clearName", "", "clearOptions", "hasName", "", "hasOptions", "Companion", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Dsl {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final DescriptorProtos.OneofDescriptorProto.Builder _builder;

        public /* synthetic */ Dsl(DescriptorProtos.OneofDescriptorProto.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        private Dsl(DescriptorProtos.OneofDescriptorProto.Builder builder) {
            this._builder = builder;
        }

        /* JADX INFO: compiled from: OneofDescriptorProtoKt.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/OneofDescriptorProtoKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/OneofDescriptorProtoKt$Dsl;", "builder", "Lcom/google/protobuf/DescriptorProtos$OneofDescriptorProto$Builder;", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final /* synthetic */ Dsl _create(DescriptorProtos.OneofDescriptorProto.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public final /* synthetic */ DescriptorProtos.OneofDescriptorProto _build() {
            DescriptorProtos.OneofDescriptorProto oneofDescriptorProtoBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(oneofDescriptorProtoBuild, "_builder.build()");
            return oneofDescriptorProtoBuild;
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

        public final DescriptorProtos.OneofOptions getOptions() {
            DescriptorProtos.OneofOptions options = this._builder.getOptions();
            Intrinsics.checkNotNullExpressionValue(options, "_builder.getOptions()");
            return options;
        }

        public final void setOptions(DescriptorProtos.OneofOptions value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setOptions(value);
        }

        public final void clearOptions() {
            this._builder.clearOptions();
        }

        public final boolean hasOptions() {
            return this._builder.hasOptions();
        }

        public final DescriptorProtos.OneofOptions getOptionsOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return OneofDescriptorProtoKtKt.getOptionsOrNull(dsl._builder);
        }
    }

    private OneofDescriptorProtoKt() {
    }
}
