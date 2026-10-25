package com.magneticchen.daijishou.daijishou_widget.widget_db;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: WidgetInstanceData.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012¨\u0006 "}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widget_db/WidgetInstanceData;", "", "id", "", "widgetId", "", "widgetInstanceId", "addedDateTimestamp", "(JLjava/lang/String;Ljava/lang/String;J)V", "getAddedDateTimestamp", "()J", "setAddedDateTimestamp", "(J)V", "getId", "setId", "getWidgetId", "()Ljava/lang/String;", "setWidgetId", "(Ljava/lang/String;)V", "getWidgetInstanceId", "setWidgetInstanceId", "component1", "component2", "component3", "component4", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class WidgetInstanceData {
    private long addedDateTimestamp;
    private long id;
    private String widgetId;
    private String widgetInstanceId;

    public static /* synthetic */ WidgetInstanceData copy$default(WidgetInstanceData widgetInstanceData, long j, String str, String str2, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetInstanceData.id;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            str = widgetInstanceData.widgetId;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            str2 = widgetInstanceData.widgetInstanceId;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            j2 = widgetInstanceData.addedDateTimestamp;
        }
        return widgetInstanceData.copy(j3, str3, str4, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getWidgetId() {
        return this.widgetId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getWidgetInstanceId() {
        return this.widgetInstanceId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getAddedDateTimestamp() {
        return this.addedDateTimestamp;
    }

    public final WidgetInstanceData copy(long id2, String widgetId, String widgetInstanceId, long addedDateTimestamp) {
        Intrinsics.checkNotNullParameter(widgetId, "widgetId");
        Intrinsics.checkNotNullParameter(widgetInstanceId, "widgetInstanceId");
        return new WidgetInstanceData(id2, widgetId, widgetInstanceId, addedDateTimestamp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetInstanceData)) {
            return false;
        }
        WidgetInstanceData widgetInstanceData = (WidgetInstanceData) other;
        return this.id == widgetInstanceData.id && Intrinsics.areEqual(this.widgetId, widgetInstanceData.widgetId) && Intrinsics.areEqual(this.widgetInstanceId, widgetInstanceData.widgetInstanceId) && this.addedDateTimestamp == widgetInstanceData.addedDateTimestamp;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.id) * 31) + this.widgetId.hashCode()) * 31) + this.widgetInstanceId.hashCode()) * 31) + Long.hashCode(this.addedDateTimestamp);
    }

    public String toString() {
        return "WidgetInstanceData(id=" + this.id + ", widgetId=" + this.widgetId + ", widgetInstanceId=" + this.widgetInstanceId + ", addedDateTimestamp=" + this.addedDateTimestamp + ")";
    }

    public WidgetInstanceData(long j, String widgetId, String widgetInstanceId, long j2) {
        Intrinsics.checkNotNullParameter(widgetId, "widgetId");
        Intrinsics.checkNotNullParameter(widgetInstanceId, "widgetInstanceId");
        this.id = j;
        this.widgetId = widgetId;
        this.widgetInstanceId = widgetInstanceId;
        this.addedDateTimestamp = j2;
    }

    public /* synthetic */ WidgetInstanceData(long j, String str, String str2, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, str, str2, j2);
    }


    public final void setId(long j) {
        this.id = j;
    }


    public final void setWidgetId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.widgetId = str;
    }


    public final void setWidgetInstanceId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.widgetInstanceId = str;
    }


    public final void setAddedDateTimestamp(long j) {
        this.addedDateTimestamp = j;
    }
}
