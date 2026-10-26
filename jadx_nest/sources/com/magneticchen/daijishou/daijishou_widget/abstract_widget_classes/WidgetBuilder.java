package com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes;

import android.graphics.drawable.Drawable;
import androidx.appcompat.app.AppCompatActivity;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.repositories.DaijishouWidgetRepository;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: WidgetBuilder.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'H&J.\u0010(\u001a\u00020)2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020)0+H&J\b\u0010-\u001a\u00020)H&J2\u0010.\u001a\u00020)2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010/\u001a\u0004\u0018\u00010\u00012\u0014\u00100\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010#\u0012\u0004\u0012\u00020,0+H&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u000b\u001a\u00060\fR\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0012\u0010\u001b\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0012R\u0018\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u00061"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetBuilder;", "", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "(Lcom/magneticchen/daijishou/DaijishouApplication;)V", "getApplication", "()Lcom/magneticchen/daijishou/DaijishouApplication;", "daijishouWidgetRepository", "Lcom/magneticchen/daijishou/repositories/DaijishouWidgetRepository;", "getDaijishouWidgetRepository", "()Lcom/magneticchen/daijishou/repositories/DaijishouWidgetRepository;", "logger", "Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "getLogger", "()Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "widgetDescriptionStringId", "", "getWidgetDescriptionStringId", "()I", "widgetIcon", "Landroid/graphics/drawable/Drawable;", "getWidgetIcon", "()Landroid/graphics/drawable/Drawable;", "widgetId", "", "getWidgetId", "()Ljava/lang/String;", "widgetNameStringId", "getWidgetNameStringId", "widgetViewModelClass", "Ljava/lang/Class;", "Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetViewModel;", "getWidgetViewModelClass", "()Ljava/lang/Class;", "acquireWidgetInstance", "Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetInstance;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "widgetInstanceId", "", "requestWidgetInstanceRemoval", "", "callback", "Lkotlin/Function1;", "", "reset", "startWidgetInstanceCreation", "data", "submitWidgetInstance", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class WidgetBuilder {
    private final DaijishouApplication application;
    private final DaijishouWidgetRepository daijishouWidgetRepository;
    private final DaijishouApplication.WrappedLogger logger;

    public abstract WidgetInstance acquireWidgetInstance(AppCompatActivity activity, long widgetInstanceId);

    public abstract int getWidgetDescriptionStringId();

    public abstract Drawable getWidgetIcon();

    public abstract String getWidgetId();

    public abstract int getWidgetNameStringId();

    public abstract Class<WidgetViewModel> getWidgetViewModelClass();

    public abstract void requestWidgetInstanceRemoval(AppCompatActivity activity, long widgetInstanceId, Function1<? super Boolean, Unit> callback);

    public abstract void reset();

    public abstract void startWidgetInstanceCreation(AppCompatActivity activity, Object data, Function1<? super WidgetInstance, Boolean> submitWidgetInstance);

    public WidgetBuilder(DaijishouApplication application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.application = application;
        this.daijishouWidgetRepository = application.getDaijishouWidgetRepository();
        this.logger = application.getLogger();
    }

    public final DaijishouApplication getApplication() {
        return this.application;
    }

    public final DaijishouWidgetRepository getDaijishouWidgetRepository() {
        return this.daijishouWidgetRepository;
    }

    public final DaijishouApplication.WrappedLogger getLogger() {
        return this.logger;
    }
}
