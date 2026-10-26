package com.google.protobuf.gradle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.gradle.api.artifacts.Configuration;
import org.gradle.api.artifacts.ConfigurationContainer;
import org.gradle.api.artifacts.dsl.DependencyHandler;

/* INFO: compiled from: ProtobufDependencyConfiguration.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001f\u0010\u0000\u001a\u00020\u0005*\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0003\u0010\u0007\"\u0015\u0010\n\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0004\"\u001f\u0010\n\u001a\u00020\u0005*\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007¨\u0006\r"}, d2 = {"protobuf", "Lorg/gradle/api/artifacts/Configuration;", "Lorg/gradle/api/artifacts/ConfigurationContainer;", "getProtobuf", "(Lorg/gradle/api/artifacts/ConfigurationContainer;)Lorg/gradle/api/artifacts/Configuration;", "Lcom/google/protobuf/gradle/ProtobufDependencyHelper;", "Lorg/gradle/api/artifacts/dsl/DependencyHandler;", "(Lorg/gradle/api/artifacts/dsl/DependencyHandler;)Lcom/google/protobuf/gradle/ProtobufDependencyHelper;", "protobuf$delegate", "Lcom/google/protobuf/gradle/ProtobufDependencyHelper$Companion;", "testProtobuf", "getTestProtobuf", "testProtobuf$delegate", "protobuf-gradle-plugin"}, k = 2, mv = {1, 1, 18})
public final class ProtobufDependencyConfigurationKt {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinPackage(ProtobufDependencyConfigurationKt.class, "protobuf-gradle-plugin"), "protobuf", "getProtobuf(Lorg/gradle/api/artifacts/dsl/DependencyHandler;)Lcom/google/protobuf/gradle/ProtobufDependencyHelper;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinPackage(ProtobufDependencyConfigurationKt.class, "protobuf-gradle-plugin"), "testProtobuf", "getTestProtobuf(Lorg/gradle/api/artifacts/dsl/DependencyHandler;)Lcom/google/protobuf/gradle/ProtobufDependencyHelper;"))};
    private static final ProtobufDependencyHelper.Companion protobuf$delegate = ProtobufDependencyHelper.INSTANCE;
    private static final ProtobufDependencyHelper.Companion testProtobuf$delegate = ProtobufDependencyHelper.INSTANCE;

    public static final ProtobufDependencyHelper getProtobuf(DependencyHandler protobuf) {
        Intrinsics.checkParameterIsNotNull(protobuf, "$this$protobuf");
        return protobuf$delegate.getValue2(protobuf, $$delegatedProperties[0]);
    }

    public static final ProtobufDependencyHelper getTestProtobuf(DependencyHandler testProtobuf) {
        Intrinsics.checkParameterIsNotNull(testProtobuf, "$this$testProtobuf");
        return testProtobuf$delegate.getValue2(testProtobuf, $$delegatedProperties[1]);
    }

    public static final Configuration getProtobuf(ConfigurationContainer protobuf) {
        Intrinsics.checkParameterIsNotNull(protobuf, "$this$protobuf");
        Configuration byName = protobuf.getByName("protobuf");
        Intrinsics.checkExpressionValueIsNotNull(byName, "getByName(\"protobuf\")");
        return byName;
    }

    public static final Configuration getTestProtobuf(ConfigurationContainer testProtobuf) {
        Intrinsics.checkParameterIsNotNull(testProtobuf, "$this$testProtobuf");
        Configuration byName = testProtobuf.getByName("testProtobuf");
        Intrinsics.checkExpressionValueIsNotNull(byName, "getByName(\"testProtobuf\")");
        return byName;
    }
}
