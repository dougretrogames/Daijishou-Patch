package com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes;

import androidx.appcompat.app.AppCompatActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: WidgetInstance.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010)\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eJ$\u0010*\u001a\u00020\u000b2\b\u0010+\u001a\u0004\u0018\u00010\n2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u000b0\tR2\u0010\u0005\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t0\u00070\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0014X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0012\u0010\u0019\u001a\u00020\u001aX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0012\u0010#\u001a\u00020\u001eX¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010 R\u0016\u0010%\u001a\u0004\u0018\u00010&X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u0006."}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetInstance;", "", "widgetBuilder", "Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetBuilder;", "(Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetBuilder;)V", "actions", "", "Lkotlin/Pair;", "", "Lkotlin/Function1;", "Landroidx/appcompat/app/AppCompatActivity;", "", "getActions", "()Ljava/util/List;", "tipsStringId", "getTipsStringId", "()I", "setTipsStringId", "(I)V", "title", "", "getTitle", "()Ljava/lang/String;", "getWidgetBuilder", "()Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetBuilder;", "widgetFaceFragment", "Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetFaceFragment;", "getWidgetFaceFragment", "()Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetFaceFragment;", "widgetInstanceDatabaseId", "", "getWidgetInstanceDatabaseId", "()J", "setWidgetInstanceDatabaseId", "(J)V", "widgetInstanceId", "getWidgetInstanceId", "widgetNavFragment", "Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetNavFragment;", "getWidgetNavFragment", "()Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetNavFragment;", "initialize", "requestRemoval", "activity", "callback", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class WidgetInstance {
    private final List<Pair<Integer, Function1<AppCompatActivity, Unit>>> actions;
    private int tipsStringId;
    private final String title;
    private final WidgetBuilder widgetBuilder;
    private long widgetInstanceDatabaseId;
    private WidgetNavFragment widgetNavFragment = null;

    public abstract WidgetFaceFragment getWidgetFaceFragment();

    public abstract long getWidgetInstanceId();

    public WidgetInstance(WidgetBuilder widgetBuilder) {
        Intrinsics.checkNotNullParameter(widgetBuilder, "widgetBuilder");
        this.widgetBuilder = widgetBuilder;
        this.widgetInstanceDatabaseId = -1L;
        this.title = "Widget";
        this.actions = CollectionsKt.emptyList();
    }

    public final WidgetBuilder getWidgetBuilder() {
        return this.widgetBuilder;
    }

    public final long getWidgetInstanceDatabaseId() {
        return this.widgetInstanceDatabaseId;
    }

    public final void setWidgetInstanceDatabaseId(long j) {
        this.widgetInstanceDatabaseId = j;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getTipsStringId() {
        return this.tipsStringId;
    }

    public final void setTipsStringId(int i) {
        this.tipsStringId = i;
    }

    public WidgetNavFragment getWidgetNavFragment() {
        return this.widgetNavFragment;
    }

    public List<Pair<Integer, Function1<AppCompatActivity, Unit>>> getActions() {
        return this.actions;
    }

    public final void requestRemoval(AppCompatActivity activity, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.widgetBuilder.requestWidgetInstanceRemoval(activity, getWidgetInstanceId(), callback);
    }

    public final void initialize(long widgetInstanceDatabaseId) {
        this.widgetInstanceDatabaseId = widgetInstanceDatabaseId;
        getWidgetFaceFragment().setWidgetInstance(this);
        getWidgetFaceFragment().initWidgetFaceDaijishouApplicationObjects(this.widgetBuilder.getApplication());
        getWidgetFaceFragment().onPreload();
        if (this.tipsStringId == 0) {
            this.tipsStringId = this.widgetBuilder.getWidgetDescriptionStringId();
        }
    }
}
