package com.google.protobuf.compiler;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: VersionKt.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/google/protobuf/compiler/VersionKt;", "", "()V", "Dsl", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VersionKt {
    public static final VersionKt INSTANCE = new VersionKt();

    /* INFO: compiled from: VersionKt.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0018\u001a\u00020\u0019H\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001d\u001a\u00020\u001bJ\u0006\u0010\u001e\u001a\u00020\u001bJ\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020 J\u0006\u0010\"\u001a\u00020 J\u0006\u0010#\u001a\u00020 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR$\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/google/protobuf/compiler/VersionKt$Dsl;", "", "_builder", "Lcom/google/protobuf/compiler/PluginProtos$Version$Builder;", "(Lcom/google/protobuf/compiler/PluginProtos$Version$Builder;)V", "value", "", "major", "getMajor", "()I", "setMajor", "(I)V", "minor", "getMinor", "setMinor", "patch", "getPatch", "setPatch", "", "suffix", "getSuffix", "()Ljava/lang/String;", "setSuffix", "(Ljava/lang/String;)V", "_build", "Lcom/google/protobuf/compiler/PluginProtos$Version;", "clearMajor", "", "clearMinor", "clearPatch", "clearSuffix", "hasMajor", "", "hasMinor", "hasPatch", "hasSuffix", "Companion", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Dsl {

        /* INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final PluginProtos.Version.Builder _builder;

        public /* synthetic */ Dsl(PluginProtos.Version.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        private Dsl(PluginProtos.Version.Builder builder) {
            this._builder = builder;
        }

        /* INFO: compiled from: VersionKt.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/compiler/VersionKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/compiler/VersionKt$Dsl;", "builder", "Lcom/google/protobuf/compiler/PluginProtos$Version$Builder;", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final /* synthetic */ Dsl _create(PluginProtos.Version.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public final /* synthetic */ PluginProtos.Version _build() {
            PluginProtos.Version versionBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(versionBuild, "_builder.build()");
            return versionBuild;
        }

        public final int getMajor() {
            return this._builder.getMajor();
        }

        public final void setMajor(int i) {
            this._builder.setMajor(i);
        }

        public final void clearMajor() {
            this._builder.clearMajor();
        }

        public final boolean hasMajor() {
            return this._builder.hasMajor();
        }

        public final int getMinor() {
            return this._builder.getMinor();
        }

        public final void setMinor(int i) {
            this._builder.setMinor(i);
        }

        public final void clearMinor() {
            this._builder.clearMinor();
        }

        public final boolean hasMinor() {
            return this._builder.hasMinor();
        }

        public final int getPatch() {
            return this._builder.getPatch();
        }

        public final void setPatch(int i) {
            this._builder.setPatch(i);
        }

        public final void clearPatch() {
            this._builder.clearPatch();
        }

        public final boolean hasPatch() {
            return this._builder.hasPatch();
        }

        public final String getSuffix() {
            String suffix = this._builder.getSuffix();
            Intrinsics.checkNotNullExpressionValue(suffix, "_builder.getSuffix()");
            return suffix;
        }

        public final void setSuffix(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setSuffix(value);
        }

        public final void clearSuffix() {
            this._builder.clearSuffix();
        }

        public final boolean hasSuffix() {
            return this._builder.hasSuffix();
        }
    }

    private VersionKt() {
    }
}
