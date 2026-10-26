package com.google.protobuf;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: JavaFeaturesKt.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/google/protobuf/JavaFeaturesKt;", "", "()V", "Dsl", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class JavaFeaturesKt {
    public static final JavaFeaturesKt INSTANCE = new JavaFeaturesKt();

    /* INFO: compiled from: JavaFeaturesKt.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0001J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0017\u001a\u00020\u0006J\u0006\u0010\u0018\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/google/protobuf/JavaFeaturesKt$Dsl;", "", "_builder", "Lcom/google/protobuf/JavaFeaturesProto$JavaFeatures$Builder;", "(Lcom/google/protobuf/JavaFeaturesProto$JavaFeatures$Builder;)V", "value", "", "legacyClosedEnum", "getLegacyClosedEnum", "()Z", "setLegacyClosedEnum", "(Z)V", "Lcom/google/protobuf/JavaFeaturesProto$JavaFeatures$Utf8Validation;", "utf8Validation", "getUtf8Validation", "()Lcom/google/protobuf/JavaFeaturesProto$JavaFeatures$Utf8Validation;", "setUtf8Validation", "(Lcom/google/protobuf/JavaFeaturesProto$JavaFeatures$Utf8Validation;)V", "_build", "Lcom/google/protobuf/JavaFeaturesProto$JavaFeatures;", "clearLegacyClosedEnum", "", "clearUtf8Validation", "hasLegacyClosedEnum", "hasUtf8Validation", "Companion", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Dsl {

        /* INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final JavaFeaturesProto.JavaFeatures.Builder _builder;

        public /* synthetic */ Dsl(JavaFeaturesProto.JavaFeatures.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        private Dsl(JavaFeaturesProto.JavaFeatures.Builder builder) {
            this._builder = builder;
        }

        /* INFO: compiled from: JavaFeaturesKt.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/JavaFeaturesKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/JavaFeaturesKt$Dsl;", "builder", "Lcom/google/protobuf/JavaFeaturesProto$JavaFeatures$Builder;", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final /* synthetic */ Dsl _create(JavaFeaturesProto.JavaFeatures.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public final /* synthetic */ JavaFeaturesProto.JavaFeatures _build() {
            JavaFeaturesProto.JavaFeatures javaFeaturesBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(javaFeaturesBuild, "_builder.build()");
            return javaFeaturesBuild;
        }

        public final boolean getLegacyClosedEnum() {
            return this._builder.getLegacyClosedEnum();
        }

        public final void setLegacyClosedEnum(boolean z) {
            this._builder.setLegacyClosedEnum(z);
        }

        public final void clearLegacyClosedEnum() {
            this._builder.clearLegacyClosedEnum();
        }

        public final boolean hasLegacyClosedEnum() {
            return this._builder.hasLegacyClosedEnum();
        }

        public final JavaFeaturesProto.JavaFeatures.Utf8Validation getUtf8Validation() {
            JavaFeaturesProto.JavaFeatures.Utf8Validation utf8Validation = this._builder.getUtf8Validation();
            Intrinsics.checkNotNullExpressionValue(utf8Validation, "_builder.getUtf8Validation()");
            return utf8Validation;
        }

        public final void setUtf8Validation(JavaFeaturesProto.JavaFeatures.Utf8Validation value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setUtf8Validation(value);
        }

        public final void clearUtf8Validation() {
            this._builder.clearUtf8Validation();
        }

        public final boolean hasUtf8Validation() {
            return this._builder.hasUtf8Validation();
        }
    }

    private JavaFeaturesKt() {
    }
}
