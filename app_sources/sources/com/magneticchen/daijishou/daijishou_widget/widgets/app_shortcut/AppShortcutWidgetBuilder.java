package com.magneticchen.daijishou.daijishou_widget.widgets.app_shortcut;

import android.graphics.drawable.Drawable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetBuilder;
import com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetInstance;
import com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetViewModel;
import com.magneticchen.daijishou.daijishou_widget.widget_db.AppShortcutWidgetInstanceEntity;
import com.magneticchen.daijishou.daijishou_widget.widget_db.WidgetId;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: AppShortcutWidgetBuilder.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 (2\u00020\u0001:\u0001(B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J.\u0010\u001e\u001a\u00020\u001f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001f0!H\u0016J\b\u0010#\u001a\u00020\u001fH\u0016J2\u0010$\u001a\u00020\u001f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010%\u001a\u0004\u0018\u00010&2\u0014\u0010'\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\"0!H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006)"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widgets/app_shortcut/AppShortcutWidgetBuilder;", "Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetBuilder;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "(Lcom/magneticchen/daijishou/DaijishouApplication;)V", "widgetDescriptionStringId", "", "getWidgetDescriptionStringId", "()I", "widgetIcon", "Landroid/graphics/drawable/Drawable;", "getWidgetIcon", "()Landroid/graphics/drawable/Drawable;", "widgetId", "", "getWidgetId", "()Ljava/lang/String;", "widgetNameStringId", "getWidgetNameStringId", "widgetViewModelClass", "Ljava/lang/Class;", "Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetViewModel;", "getWidgetViewModelClass", "()Ljava/lang/Class;", "acquireWidgetInstance", "Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetInstance;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "widgetInstanceId", "", "requestWidgetInstanceRemoval", "", "callback", "Lkotlin/Function1;", "", "reset", "startWidgetInstanceCreation", "data", "", "submitWidgetInstance", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppShortcutWidgetBuilder extends WidgetBuilder {
    public static final String IMAGES_DIRECTORY = "app_shortcut_widget_images";
    private final int widgetDescriptionStringId;
    private final Drawable widgetIcon;
    private final String widgetId;
    private final int widgetNameStringId;
    private final Class<WidgetViewModel> widgetViewModelClass;

    @Override // com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetBuilder
    public void reset() {
    }

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppShortcutWidgetBuilder(DaijishouApplication application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        Drawable drawable = ContextCompat.getDrawable(application.getApplicationContext(), R.drawable.ic_round_play_arrow_24);
        Intrinsics.checkNotNull(drawable);
        this.widgetIcon = drawable;
        this.widgetNameStringId = R.string.app_shortcut_widget_name;
        this.widgetDescriptionStringId = R.string.app_shortcut_widget_description;
        this.widgetId = WidgetId.APP_SHORTCUT.getId();
        this.widgetViewModelClass = (Class<com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetViewModel>) (Class<?>) AppShortcutWidgetViewModel.class;
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetBuilder
    public Drawable getWidgetIcon() {
        return this.widgetIcon;
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetBuilder
    public int getWidgetNameStringId() {
        return this.widgetNameStringId;
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetBuilder
    public int getWidgetDescriptionStringId() {
        return this.widgetDescriptionStringId;
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetBuilder
    public String getWidgetId() {
        return this.widgetId;
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetBuilder
    public Class<WidgetViewModel> getWidgetViewModelClass() {
        return this.widgetViewModelClass;
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetBuilder
    public void startWidgetInstanceCreation(AppCompatActivity activity, Object data, Function1<? super WidgetInstance, Boolean> submitWidgetInstance) {
        Intrinsics.checkNotNullParameter(submitWidgetInstance, "submitWidgetInstance");
        long jAddAppShortcutWidgetInstance = getDaijishouWidgetRepository().addAppShortcutWidgetInstance(new AppShortcutWidgetInstanceEntity(0L, null, null, null, 15, null));
        try {
            if (data instanceof String) {
                AppShortcutWidgetInstanceEntity appShortcutWidgetInstanceByIdStatically = getDaijishouWidgetRepository().getAppShortcutWidgetInstanceByIdStatically(jAddAppShortcutWidgetInstance);
                Intrinsics.checkNotNull(appShortcutWidgetInstanceByIdStatically);
                appShortcutWidgetInstanceByIdStatically.setResolveInfoStringId((String) data);
                getDaijishouWidgetRepository().deleteAppShortcutWidgetInstanceEntityImage(appShortcutWidgetInstanceByIdStatically);
                appShortcutWidgetInstanceByIdStatically.setAlternativeImagePath(null);
                getDaijishouWidgetRepository().updateAppShortcutWidgetInstance(appShortcutWidgetInstanceByIdStatically);
            }
            submitWidgetInstance.invoke(new AppShortcutWidgetInstance(this, jAddAppShortcutWidgetInstance));
        } catch (Exception e) {
            getLogger().warn(this, ExceptionsKt.stackTraceToString(e));
            getDaijishouWidgetRepository().removeWidgetInstanceById(jAddAppShortcutWidgetInstance);
            submitWidgetInstance.invoke(null);
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetBuilder
    public WidgetInstance acquireWidgetInstance(AppCompatActivity activity, long widgetInstanceId) {
        if (getDaijishouWidgetRepository().getAppShortcutWidgetInstanceByIdStatically(widgetInstanceId) == null) {
            return null;
        }
        return new AppShortcutWidgetInstance(this, widgetInstanceId);
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetBuilder
    public void requestWidgetInstanceRemoval(AppCompatActivity activity, long widgetInstanceId, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            getDaijishouWidgetRepository().removeAppShortcutWidgetInstanceById(widgetInstanceId);
            callback.invoke(true);
        } catch (Exception e) {
            getLogger().warn(this, ExceptionsKt.stackTraceToString(e));
            callback.invoke(false);
        }
    }
}
