package com.google.protobuf.gradle;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.gradle.api.artifacts.Dependency;
import org.gradle.api.artifacts.ExternalModuleDependency;
import org.gradle.api.artifacts.ModuleDependency;
import org.gradle.api.artifacts.dsl.DependencyHandler;
import org.gradle.kotlin.dsl.DependencyHandlerExtensionsKt;

/* INFO: compiled from: ProtobufDependencyConfiguration.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J9\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\t2\u0006\u0010\n\u001a\u0002H\b2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\b\u000eH\u0086\u0002¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0001H\u0086\u0002JI\u0010\u0007\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u0086\u0002Jb\u0010\u0007\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\b\u000eH\u0086\u0002J*\u0010\u0007\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00032\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\b\u000eH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/google/protobuf/gradle/ProtobufDependencyHelper;", "", "configurationName", "", "dependencyHandler", "Lorg/gradle/api/artifacts/dsl/DependencyHandler;", "(Ljava/lang/String;Lorg/gradle/api/artifacts/dsl/DependencyHandler;)V", "invoke", ExifInterface.GPS_DIRECTION_TRUE, "Lorg/gradle/api/artifacts/ModuleDependency;", "dependency", "dependencyConfiguration", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lorg/gradle/api/artifacts/ModuleDependency;Lkotlin/jvm/functions/Function1;)Lorg/gradle/api/artifacts/ModuleDependency;", "Lorg/gradle/api/artifacts/Dependency;", "dependencyNotation", "Lorg/gradle/api/artifacts/ExternalModuleDependency;", "group", "name", "version", "configuration", "classifier", "ext", "Companion", "protobuf-gradle-plugin"}, k = 1, mv = {1, 1, 18})
public final class ProtobufDependencyHelper {

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String configurationName;
    private final DependencyHandler dependencyHandler;

    public ProtobufDependencyHelper(String configurationName, DependencyHandler dependencyHandler) {
        Intrinsics.checkParameterIsNotNull(configurationName, "configurationName");
        Intrinsics.checkParameterIsNotNull(dependencyHandler, "dependencyHandler");
        this.configurationName = configurationName;
        this.dependencyHandler = dependencyHandler;
    }

    public final Dependency invoke(Object dependencyNotation) {
        Intrinsics.checkParameterIsNotNull(dependencyNotation, "dependencyNotation");
        return this.dependencyHandler.add(this.configurationName, dependencyNotation);
    }

    public final ExternalModuleDependency invoke(String dependencyNotation, Function1<? super ExternalModuleDependency, Unit> dependencyConfiguration) {
        Intrinsics.checkParameterIsNotNull(dependencyNotation, "dependencyNotation");
        Intrinsics.checkParameterIsNotNull(dependencyConfiguration, "dependencyConfiguration");
        DependencyHandler dependencyHandler = this.dependencyHandler;
        String str = this.configurationName;
        ExternalModuleDependency externalModuleDependencyCreate = dependencyHandler.create(dependencyNotation);
        if (externalModuleDependencyCreate == null) {
            throw new NullPointerException("null cannot be cast to non-null type org.gradle.api.artifacts.ExternalModuleDependency");
        }
        ExternalModuleDependency externalModuleDependency = (ModuleDependency) externalModuleDependencyCreate;
        dependencyConfiguration.invoke(externalModuleDependency);
        dependencyHandler.add(str, externalModuleDependency);
        return externalModuleDependency;
    }

    public static /* synthetic */ ExternalModuleDependency invoke$default(ProtobufDependencyHelper protobufDependencyHelper, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        String str7;
        String str8;
        String str9;
        String str10;
        if ((i & 4) != 0) {
            str7 = null;
        } else {
            str7 = str3;
        }
        if ((i & 8) != 0) {
            str8 = null;
        } else {
            str8 = str4;
        }
        if ((i & 16) != 0) {
            str9 = null;
        } else {
            str9 = str5;
        }
        if ((i & 32) != 0) {
            str10 = null;
        } else {
            str10 = str6;
        }
        return protobufDependencyHelper.invoke(str, str2, str7, str8, str9, str10);
    }

    public final ExternalModuleDependency invoke(String group, String name, String version, String configuration, String classifier, String ext) {
        Intrinsics.checkParameterIsNotNull(group, "group");
        Intrinsics.checkParameterIsNotNull(name, "name");
        DependencyHandler dependencyHandler = this.dependencyHandler;
        ExternalModuleDependency externalModuleDependencyCreate = DependencyHandlerExtensionsKt.create(dependencyHandler, group, name, version, configuration, classifier, ext);
        dependencyHandler.add(this.configurationName, externalModuleDependencyCreate);
        return externalModuleDependencyCreate;
    }

    public static /* synthetic */ ExternalModuleDependency invoke$default(ProtobufDependencyHelper protobufDependencyHelper, String str, String str2, String str3, String str4, String str5, String str6, Function1 function1, int i, Object obj) {
        String str7;
        String str8;
        String str9;
        String str10;
        if ((i & 4) != 0) {
            str7 = null;
        } else {
            str7 = str3;
        }
        if ((i & 8) != 0) {
            str8 = null;
        } else {
            str8 = str4;
        }
        if ((i & 16) != 0) {
            str9 = null;
        } else {
            str9 = str5;
        }
        if ((i & 32) != 0) {
            str10 = null;
        } else {
            str10 = str6;
        }
        return protobufDependencyHelper.invoke(str, str2, str7, str8, str9, str10, function1);
    }

    public final ExternalModuleDependency invoke(String group, String name, String version, String configuration, String classifier, String ext, Function1<? super ExternalModuleDependency, Unit> dependencyConfiguration) {
        Intrinsics.checkParameterIsNotNull(group, "group");
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(dependencyConfiguration, "dependencyConfiguration");
        DependencyHandler dependencyHandler = this.dependencyHandler;
        ExternalModuleDependency externalModuleDependencyCreate = DependencyHandlerExtensionsKt.create(dependencyHandler, group, name, version, configuration, classifier, ext);
        String str = this.configurationName;
        ExternalModuleDependency externalModuleDependency = (ModuleDependency) externalModuleDependencyCreate;
        dependencyConfiguration.invoke(externalModuleDependency);
        dependencyHandler.add(str, externalModuleDependency);
        return externalModuleDependency;
    }

    public final <T extends ModuleDependency> T invoke(T dependency, Function1<? super T, Unit> dependencyConfiguration) {
        Intrinsics.checkParameterIsNotNull(dependency, "dependency");
        Intrinsics.checkParameterIsNotNull(dependencyConfiguration, "dependencyConfiguration");
        DependencyHandler dependencyHandler = this.dependencyHandler;
        String str = this.configurationName;
        dependencyConfiguration.invoke(dependency);
        dependencyHandler.add(str, dependency);
        return dependency;
    }

    /* INFO: compiled from: ProtobufDependencyConfiguration.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u001d\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00022\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0096\u0002¨\u0006\t"}, d2 = {"Lcom/google/protobuf/gradle/ProtobufDependencyHelper$Companion;", "Lkotlin/properties/ReadOnlyProperty;", "Lorg/gradle/api/artifacts/dsl/DependencyHandler;", "Lcom/google/protobuf/gradle/ProtobufDependencyHelper;", "()V", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "protobuf-gradle-plugin"}, k = 1, mv = {1, 1, 18})
    public static final class Companion implements ReadOnlyProperty<DependencyHandler, ProtobufDependencyHelper> {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // kotlin.properties.ReadOnlyProperty
        public /* bridge */ /* synthetic */ ProtobufDependencyHelper getValue(DependencyHandler dependencyHandler, KProperty kProperty) {
            return getValue2(dependencyHandler, (KProperty<?>) kProperty);
        }

        /* INFO: renamed from: getValue, reason: avoid collision after fix types in other method */
        public ProtobufDependencyHelper getValue2(DependencyHandler thisRef, KProperty<?> property) {
            Intrinsics.checkParameterIsNotNull(thisRef, "thisRef");
            Intrinsics.checkParameterIsNotNull(property, "property");
            return new ProtobufDependencyHelper(property.getName(), thisRef);
        }
    }
}
