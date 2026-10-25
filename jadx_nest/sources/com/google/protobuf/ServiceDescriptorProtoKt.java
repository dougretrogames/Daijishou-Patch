package com.google.protobuf;

import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslProxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: ServiceDescriptorProtoKt.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/google/protobuf/ServiceDescriptorProtoKt;", "", "()V", "Dsl", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ServiceDescriptorProtoKt {
    public static final ServiceDescriptorProtoKt INSTANCE = new ServiceDescriptorProtoKt();

    /* JADX INFO: compiled from: ServiceDescriptorProtoKt.kt */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 22\u00020\u0001:\u000223B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001b\u001a\u00020\u001cH\u0001J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001eJ\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020!J%\u0010#\u001a\u00020\u001e*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\u0007H\u0007¢\u0006\u0002\b$J+\u0010%\u001a\u00020\u001e*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00070'H\u0007¢\u0006\u0002\b(J\u001d\u0010)\u001a\u00020\u001e*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0007¢\u0006\u0002\b*J&\u0010+\u001a\u00020\u001e*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\u0007H\u0087\n¢\u0006\u0002\b,J,\u0010+\u001a\u00020\u001e*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00070'H\u0087\n¢\u0006\u0002\b-J.\u0010.\u001a\u00020\u001e*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010/\u001a\u0002002\u0006\u0010\u000b\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b1R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\u0004\u0018\u00010\u0012*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u00064"}, d2 = {"Lcom/google/protobuf/ServiceDescriptorProtoKt$Dsl;", "", "_builder", "Lcom/google/protobuf/DescriptorProtos$ServiceDescriptorProto$Builder;", "(Lcom/google/protobuf/DescriptorProtos$ServiceDescriptorProto$Builder;)V", "method", "Lcom/google/protobuf/kotlin/DslList;", "Lcom/google/protobuf/DescriptorProtos$MethodDescriptorProto;", "Lcom/google/protobuf/ServiceDescriptorProtoKt$Dsl$MethodProxy;", "getMethod", "()Lcom/google/protobuf/kotlin/DslList;", "value", "", "name", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "Lcom/google/protobuf/DescriptorProtos$ServiceOptions;", "options", "getOptions", "()Lcom/google/protobuf/DescriptorProtos$ServiceOptions;", "setOptions", "(Lcom/google/protobuf/DescriptorProtos$ServiceOptions;)V", "optionsOrNull", "getOptionsOrNull", "(Lcom/google/protobuf/ServiceDescriptorProtoKt$Dsl;)Lcom/google/protobuf/DescriptorProtos$ServiceOptions;", "_build", "Lcom/google/protobuf/DescriptorProtos$ServiceDescriptorProto;", "clearName", "", "clearOptions", "hasName", "", "hasOptions", "add", "addMethod", "addAll", "values", "", "addAllMethod", "clear", "clearMethod", "plusAssign", "plusAssignMethod", "plusAssignAllMethod", "set", ConfigConstants.CONFIG_INDEX_SECTION, "", "setMethod", "Companion", "MethodProxy", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Dsl {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final DescriptorProtos.ServiceDescriptorProto.Builder _builder;

        public /* synthetic */ Dsl(DescriptorProtos.ServiceDescriptorProto.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        private Dsl(DescriptorProtos.ServiceDescriptorProto.Builder builder) {
            this._builder = builder;
        }

        /* JADX INFO: compiled from: ServiceDescriptorProtoKt.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/ServiceDescriptorProtoKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/ServiceDescriptorProtoKt$Dsl;", "builder", "Lcom/google/protobuf/DescriptorProtos$ServiceDescriptorProto$Builder;", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final /* synthetic */ Dsl _create(DescriptorProtos.ServiceDescriptorProto.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public final /* synthetic */ DescriptorProtos.ServiceDescriptorProto _build() {
            DescriptorProtos.ServiceDescriptorProto serviceDescriptorProtoBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(serviceDescriptorProtoBuild, "_builder.build()");
            return serviceDescriptorProtoBuild;
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

        /* JADX INFO: compiled from: ServiceDescriptorProtoKt.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/ServiceDescriptorProtoKt$Dsl$MethodProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class MethodProxy extends DslProxy {
            private MethodProxy() {
            }
        }

        public final /* synthetic */ DslList getMethod() {
            List<DescriptorProtos.MethodDescriptorProto> methodList = this._builder.getMethodList();
            Intrinsics.checkNotNullExpressionValue(methodList, "_builder.getMethodList()");
            return new DslList(methodList);
        }

        public final /* synthetic */ void addMethod(DslList dslList, DescriptorProtos.MethodDescriptorProto value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addMethod(value);
        }

        public final /* synthetic */ void plusAssignMethod(DslList<DescriptorProtos.MethodDescriptorProto, MethodProxy> dslList, DescriptorProtos.MethodDescriptorProto value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addMethod(dslList, value);
        }

        public final /* synthetic */ void addAllMethod(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllMethod(values);
        }

        public final /* synthetic */ void plusAssignAllMethod(DslList<DescriptorProtos.MethodDescriptorProto, MethodProxy> dslList, Iterable<DescriptorProtos.MethodDescriptorProto> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllMethod(dslList, values);
        }

        public final /* synthetic */ void setMethod(DslList dslList, int i, DescriptorProtos.MethodDescriptorProto value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setMethod(i, value);
        }

        public final /* synthetic */ void clearMethod(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearMethod();
        }

        public final DescriptorProtos.ServiceOptions getOptions() {
            DescriptorProtos.ServiceOptions options = this._builder.getOptions();
            Intrinsics.checkNotNullExpressionValue(options, "_builder.getOptions()");
            return options;
        }

        public final void setOptions(DescriptorProtos.ServiceOptions value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setOptions(value);
        }

        public final void clearOptions() {
            this._builder.clearOptions();
        }

        public final boolean hasOptions() {
            return this._builder.hasOptions();
        }

        public final DescriptorProtos.ServiceOptions getOptionsOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return ServiceDescriptorProtoKtKt.getOptionsOrNull(dsl._builder);
        }
    }

    private ServiceDescriptorProtoKt() {
    }
}
