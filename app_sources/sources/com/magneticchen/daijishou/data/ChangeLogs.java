package com.magneticchen.daijishou.data;

import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: ChangeLogs.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0003\u001d\u001e\u001fB)\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\nJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u0019\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J&\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bHÁ\u0001¢\u0006\u0002\b\u001cR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006 "}, d2 = {"Lcom/magneticchen/daijishou/data/ChangeLogs;", "", "seen1", "", "changes", "", "Lcom/magneticchen/daijishou/data/ChangeLogs$Change;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/List;)V", "getChanges", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Change", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
public final class ChangeLogs {
    private final List<Change> changes;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(ChangeLogs$Change$$serializer.INSTANCE)};

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChangeLogs copy$default(ChangeLogs changeLogs, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = changeLogs.changes;
        }
        return changeLogs.copy(list);
    }

    public final List<Change> component1() {
        return this.changes;
    }

    public final ChangeLogs copy(List<Change> changes) {
        Intrinsics.checkNotNullParameter(changes, "changes");
        return new ChangeLogs(changes);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChangeLogs) && Intrinsics.areEqual(this.changes, ((ChangeLogs) obj).changes);
    }

    public int hashCode() {
        return this.changes.hashCode();
    }

    public String toString() {
        return "ChangeLogs(changes=" + this.changes + ")";
    }

    /* JADX INFO: compiled from: ChangeLogs.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/magneticchen/daijishou/data/ChangeLogs$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/magneticchen/daijishou/data/ChangeLogs;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ChangeLogs> serializer() {
            return ChangeLogs$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ ChangeLogs(int i, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, ChangeLogs$$serializer.INSTANCE.getDescriptor());
        }
        this.changes = list;
    }

    public ChangeLogs(List<Change> changes) {
        Intrinsics.checkNotNullParameter(changes, "changes");
        this.changes = changes;
    }

    /* JADX INFO: compiled from: ChangeLogs.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002$%B;\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB#\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\u0010\fJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\bHÆ\u0003J-\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J&\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"HÁ\u0001¢\u0006\u0002\b#R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006&"}, d2 = {"Lcom/magneticchen/daijishou/data/ChangeLogs$Change;", "", "seen1", "", "version", "title", "", "changes", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(ILjava/lang/String;Ljava/util/List;)V", "getChanges", "()Ljava/util/List;", "getTitle", "()Ljava/lang/String;", "getVersion", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @Serializable
    public static final class Change {
        private final List<String> changes;
        private final String title;
        private final int version;
        public static final Companion Companion = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, null, new ArrayListSerializer(StringSerializer.INSTANCE)};

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Change copy$default(Change change, int i, String str, List list, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = change.version;
            }
            if ((i2 & 2) != 0) {
                str = change.title;
            }
            if ((i2 & 4) != 0) {
                list = change.changes;
            }
            return change.copy(i, str, list);
        }

        public final int component1() {
            return this.version;
        }

        public final String component2() {
            return this.title;
        }

        public final List<String> component3() {
            return this.changes;
        }

        public final Change copy(int i, String title, List<String> changes) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(changes, "changes");
            return new Change(i, title, changes);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Change)) {
                return false;
            }
            Change change = (Change) obj;
            return this.version == change.version && Intrinsics.areEqual(this.title, change.title) && Intrinsics.areEqual(this.changes, change.changes);
        }

        public int hashCode() {
            return (((Integer.hashCode(this.version) * 31) + this.title.hashCode()) * 31) + this.changes.hashCode();
        }

        public String toString() {
            return "Change(version=" + this.version + ", title=" + this.title + ", changes=" + this.changes + ")";
        }

        /* JADX INFO: compiled from: ChangeLogs.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/magneticchen/daijishou/data/ChangeLogs$Change$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/magneticchen/daijishou/data/ChangeLogs$Change;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Change> serializer() {
                return ChangeLogs$Change$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ Change(int i, int i2, String str, List list, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i, 7, ChangeLogs$Change$$serializer.INSTANCE.getDescriptor());
            }
            this.version = i2;
            this.title = str;
            this.changes = list;
        }

        public Change(int i, String title, List<String> changes) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(changes, "changes");
            this.version = i;
            this.title = title;
            this.changes = changes;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$app_release(Change change, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            SerializationStrategy[] serializationStrategyArr = $childSerializers;
            compositeEncoder.encodeIntElement(serialDescriptor, 0, change.version);
            compositeEncoder.encodeStringElement(serialDescriptor, 1, change.title);
            compositeEncoder.encodeSerializableElement(serialDescriptor, 2, serializationStrategyArr[2], change.changes);
        }

        public final int getVersion() {
            return this.version;
        }

        public final String getTitle() {
            return this.title;
        }

        public final List<String> getChanges() {
            return this.changes;
        }
    }

    public final List<Change> getChanges() {
        return this.changes;
    }
}
