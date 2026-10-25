package com.google.protobuf.gradle;

import androidx.exifinterface.media.ExifInterface;
import com.android.build.gradle.api.AndroidSourceSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.gradle.api.Action;
import org.gradle.api.NamedDomainObjectCollection;
import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.file.SourceDirectorySet;
import org.gradle.api.plugins.ExtensionAware;
import org.gradle.api.plugins.ExtensionContainer;
import org.gradle.api.tasks.SourceSet;
import org.gradle.kotlin.dsl.NamedDomainObjectCollectionExtensionsKt;

/* JADX INFO: compiled from: ProtobufConfiguratorExts.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a?\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0000\u001a\u00020\u00052\u001b\b\u0002\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b\u001a#\u0010\t\u001a\u00020\u0001*\u00020\n2\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\b\u001a#\u0010\t\u001a\u00020\u0001*\u00020\f2\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\b\u001a#\u0010\t\u001a\u00020\u0001*\u00020\r2\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\b\u001a\"\u0010\u000e\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0000\u001a\u00020\u0005¨\u0006\u000f"}, d2 = {"id", "", ExifInterface.GPS_DIRECTION_TRUE, "", "Lorg/gradle/api/NamedDomainObjectContainer;", "", "action", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "proto", "Lcom/android/build/api/dsl/AndroidSourceSet;", "Lorg/gradle/api/file/SourceDirectorySet;", "Lcom/android/build/gradle/api/AndroidSourceSet;", "Lorg/gradle/api/tasks/SourceSet;", "remove", "protobuf-gradle-plugin"}, k = 2, mv = {1, 1, 18})
public final class ProtobufConfiguratorExtsKt {
    public static final void proto(SourceSet proto2, Function1<? super SourceDirectorySet, Unit> action) {
        ExtensionContainer extensions;
        Object byName;
        Intrinsics.checkParameterIsNotNull(proto2, "$this$proto");
        Intrinsics.checkParameterIsNotNull(action, "action");
        if (!(proto2 instanceof ExtensionAware)) {
            proto2 = null;
        }
        ExtensionAware extensionAware = (ExtensionAware) proto2;
        if (extensionAware == null || (extensions = extensionAware.getExtensions()) == null || (byName = extensions.getByName("proto")) == null) {
            return;
        }
        SourceDirectorySet sourceDirectorySet = (SourceDirectorySet) (byName instanceof SourceDirectorySet ? byName : null);
        if (sourceDirectorySet != null) {
            action.invoke(sourceDirectorySet);
        }
    }

    public static final void proto(AndroidSourceSet proto2, Function1<? super SourceDirectorySet, Unit> action) {
        ExtensionContainer extensions;
        Object byName;
        Intrinsics.checkParameterIsNotNull(proto2, "$this$proto");
        Intrinsics.checkParameterIsNotNull(action, "action");
        if (!(proto2 instanceof ExtensionAware)) {
            proto2 = null;
        }
        ExtensionAware extensionAware = (ExtensionAware) proto2;
        if (extensionAware == null || (extensions = extensionAware.getExtensions()) == null || (byName = extensions.getByName("proto")) == null) {
            return;
        }
        SourceDirectorySet sourceDirectorySet = (SourceDirectorySet) (byName instanceof SourceDirectorySet ? byName : null);
        if (sourceDirectorySet != null) {
            action.invoke(sourceDirectorySet);
        }
    }

    public static final void proto(com.android.build.api.dsl.AndroidSourceSet proto2, Function1<? super SourceDirectorySet, Unit> action) {
        ExtensionContainer extensions;
        Object byName;
        Intrinsics.checkParameterIsNotNull(proto2, "$this$proto");
        Intrinsics.checkParameterIsNotNull(action, "action");
        if (!(proto2 instanceof ExtensionAware)) {
            proto2 = null;
        }
        ExtensionAware extensionAware = (ExtensionAware) proto2;
        if (extensionAware == null || (extensions = extensionAware.getExtensions()) == null || (byName = extensions.getByName("proto")) == null) {
            return;
        }
        SourceDirectorySet sourceDirectorySet = (SourceDirectorySet) (byName instanceof SourceDirectorySet ? byName : null);
        if (sourceDirectorySet != null) {
            action.invoke(sourceDirectorySet);
        }
    }

    public static /* synthetic */ void id$default(NamedDomainObjectContainer namedDomainObjectContainer, String str, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        id(namedDomainObjectContainer, str, function1);
    }

    public static final <T> void id(NamedDomainObjectContainer<T> id2, String id3, Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(id2, "$this$id");
        Intrinsics.checkParameterIsNotNull(id3, "id");
        if (function1 != null) {
            if (function1 != null) {
                function1 = (Function1<? super T, Unit>) new ProtobufConfiguratorExtsKt$sam$i$org_gradle_api_Action$0(function1);
            }
            if (id2.create(id3, (Action) function1) != null) {
                return;
            }
        }
        id2.create(id3);
    }

    public static final <T> void remove(NamedDomainObjectContainer<T> remove, String id2) {
        Intrinsics.checkParameterIsNotNull(remove, "$this$remove");
        Intrinsics.checkParameterIsNotNull(id2, "id");
        remove.remove(NamedDomainObjectCollectionExtensionsKt.get((NamedDomainObjectCollection) remove, id2));
    }
}
