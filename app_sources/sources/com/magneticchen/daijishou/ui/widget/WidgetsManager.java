package com.magneticchen.daijishou.ui.widget;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.ui.widget.abstract_widget_classes.DataRemovalWidget;
import com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetBuilder;
import com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetInstance;
import com.magneticchen.daijishou.data.db.entity.WidgetInstanceEntity;
import com.magneticchen.daijishou.ui.widget.widgets.activity.ActivityWidgetBuilder;
import com.magneticchen.daijishou.ui.widget.widgets.app_shortcut.AppShortcutWidgetBuilder;
import com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetBuilder;
import com.magneticchen.daijishou.ui.widget.widgets.image_block.ImageBlockWidgetBuilder;
import com.magneticchen.daijishou.ui.widget.widgets.pin_and_play.PinAndPlayWidgetBuilder;
import com.magneticchen.daijishou.ui.widget.widgets.random.RandomWidgetBuilder;
import com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsWidgetBuilder;
import com.magneticchen.daijishou.ui.widget.widgets.rss.RSSWidgetBuilder;
import com.magneticchen.daijishou.data.db.repositories.DaijishouWidgetRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* INFO: compiled from: WidgetsManager.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#J<\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020'2\u000e\u0010(\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f2\b\u0010)\u001a\u0004\u0018\u00010\u00012\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020!0+J,\u0010,\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010-\u001a\u00020\u00162\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020!0+J>\u0010,\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010'2\u000e\u0010(\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f2\b\u0010)\u001a\u0004\u0018\u00010\u00012\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020!0+J\u0006\u0010.\u001a\u00020!R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\t\u001a\u00060\nR\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR=\u0010\r\u001a.\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f\u0012\u0004\u0012\u00020\u00100\u000ej\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f\u0012\u0004\u0012\u00020\u0010`\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R'\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u001b0\u001a8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001d¨\u0006/"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/WidgetsManager;", "", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "unlockExperimental", "", "(Lcom/magneticchen/daijishou/DaijishouApplication;Z)V", "daijishouWidgetRepository", "Lcom/magneticchen/daijishou/repositories/DaijishouWidgetRepository;", "logger", "Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "getLogger", "()Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "widgetBuilders", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetBuilder;", "Lkotlin/collections/HashMap;", "getWidgetBuilders", "()Ljava/util/HashMap;", "widgetInstanceList", "", "Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetInstance;", "getWidgetInstanceList", "()Ljava/util/List;", "widgetInstancesLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "getWidgetInstancesLiveData", "()Landroidx/lifecycle/MutableLiveData;", "widgetInstancesLiveData$delegate", "Lkotlin/Lazy;", "moveWidgetInstancePosition", "", "fromPosition", "", "toPosition", "requestWidgetInstanceCreation", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "widgetBuilderClass", "data", "callback", "Lkotlin/Function1;", "requestWidgetInstanceRemoval", "widgetInstance", "resetAndInitialize", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WidgetsManager {
    private final DaijishouApplication application;
    public final DaijishouWidgetRepository daijishouWidgetRepository;
    private final DaijishouApplication.WrappedLogger logger;
    private final HashMap<Class<? extends WidgetBuilder>, WidgetBuilder> widgetBuilders;
    private final List<WidgetInstance> widgetInstanceList;

    /* INFO: renamed from: widgetInstancesLiveData$delegate, reason: from kotlin metadata */
    private final Lazy widgetInstancesLiveData;

    public WidgetsManager(DaijishouApplication application) { this(application, false); }
    public WidgetsManager(DaijishouApplication application, boolean z) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.application = application;
        this.logger = application.getLogger();
        this.daijishouWidgetRepository = application.getDaijishouWidgetRepository();
        this.widgetBuilders = MapsKt.hashMapOf(TuplesKt.to(ActivityWidgetBuilder.class, new ActivityWidgetBuilder(application)), TuplesKt.to(CategoryWidgetBuilder.class, new CategoryWidgetBuilder(application)), TuplesKt.to(PinAndPlayWidgetBuilder.class, new PinAndPlayWidgetBuilder(application)), TuplesKt.to(RandomWidgetBuilder.class, new RandomWidgetBuilder(application)), TuplesKt.to(RSSWidgetBuilder.class, new RSSWidgetBuilder(application)), TuplesKt.to(ImageBlockWidgetBuilder.class, new ImageBlockWidgetBuilder(application)), TuplesKt.to(RetroAchievementsWidgetBuilder.class, new RetroAchievementsWidgetBuilder(application)), TuplesKt.to(AppShortcutWidgetBuilder.class, new AppShortcutWidgetBuilder(application)));
        this.widgetInstanceList = new ArrayList();
        this.widgetInstancesLiveData = LazyKt.lazy(WidgetsManager$widgetInstancesLiveData$2.INSTANCE);
        resetAndInitialize();
    }

    public /* synthetic */ WidgetsManager(DaijishouApplication daijishouApplication, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(daijishouApplication, (i & 2) != 0 ? false : z);
    }

    public final DaijishouApplication.WrappedLogger getLogger() {
        return this.logger;
    }

    public final HashMap<Class<? extends WidgetBuilder>, WidgetBuilder> getWidgetBuilders() {
        return this.widgetBuilders;
    }

    public final List<WidgetInstance> getWidgetInstanceList() {
        return this.widgetInstanceList;
    }

    public final MutableLiveData<List<WidgetInstance>> getWidgetInstancesLiveData() {
        return (MutableLiveData) this.widgetInstancesLiveData.getValue();
    }

    public final void resetAndInitialize() {
        Ref.IntRef intRef = new Ref.IntRef();
        if (!this.widgetInstanceList.isEmpty()) {
            this.widgetInstanceList.clear();
            getWidgetInstancesLiveData().setValue(this.widgetInstanceList);
            this.widgetBuilders.forEach(new WidgetsManager$$ExternalSyntheticLambda0(C02121.INSTANCE));
        }
        for (WidgetInstanceEntity widgetInstanceEntity : this.daijishouWidgetRepository.getAllWidgetInstancesStatically()) {
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            this.widgetBuilders.forEach(new WidgetsManager$$ExternalSyntheticLambda1(new WidgetsManager$resetAndInitialize$2$1(widgetInstanceEntity, this, booleanRef, intRef)));
            if (!booleanRef.element) {
                this.daijishouWidgetRepository.removeWidgetInstance(widgetInstanceEntity);
                this.logger.warn(this, "Widget instance unable to initialize:\n" + widgetInstanceEntity);
            }
        }
        getWidgetInstancesLiveData().setValue(this.widgetInstanceList);
    }

    /* INFO: renamed from: com.magneticchen.daijishou.ui.widget.WidgetsManager$resetAndInitialize$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: WidgetsManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Ljava/lang/Class;", "Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetBuilder;", "it", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class C02121 extends Lambda<Unit> implements Function2<Class<? extends WidgetBuilder>, WidgetBuilder, Unit> {
        public static final C02121 INSTANCE = new C02121();

        C02121() { super(2); }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Class<? extends WidgetBuilder> cls, WidgetBuilder widgetBuilder) {
            invoke2(cls, widgetBuilder);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Class<? extends WidgetBuilder> cls, WidgetBuilder it) {
            Intrinsics.checkNotNullParameter(cls, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(it, "it");
            it.reset();
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static final void resetAndInitialize$lambda$0(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj, obj2);
    }

    /* INFO: Access modifiers changed from: private */
    public static final void resetAndInitialize$lambda$2$lambda$1(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj, obj2);
    }

    public final void moveWidgetInstancePosition(int fromPosition, int toPosition) {
        WidgetInstance widgetInstance = this.widgetInstanceList.get(fromPosition);
        this.daijishouWidgetRepository.movePosition(widgetInstance.getWidgetInstanceDatabaseId(), fromPosition, toPosition);
        this.widgetInstanceList.remove(fromPosition);
        this.widgetInstanceList.add(toPosition, widgetInstance);
        getWidgetInstancesLiveData().setValue(this.widgetInstanceList);
    }

    public final void requestWidgetInstanceCreation(AppCompatActivity activity, Class<? extends WidgetBuilder> widgetBuilderClass, Object data, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(widgetBuilderClass, "widgetBuilderClass");
        Intrinsics.checkNotNullParameter(callback, "callback");
        WidgetBuilder widgetBuilder = this.widgetBuilders.get(widgetBuilderClass);
        Intrinsics.checkNotNull(widgetBuilder);
        WidgetBuilder widgetBuilder2 = widgetBuilder;
        widgetBuilder2.startWidgetInstanceCreation(activity, data, new AnonymousClass1(callback, this, widgetBuilder2));
    }

    /* INFO: renamed from: com.magneticchen.daijishou.ui.widget.WidgetsManager$requestWidgetInstanceCreation$1, reason: invalid class name */
    /* INFO: compiled from: WidgetsManager.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "widgetInstance", "Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetInstance;", "invoke", "(Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetInstance;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass1 extends Lambda<Boolean> implements Function1<WidgetInstance, Boolean> {
        final /* synthetic */ Function1<? super Boolean, Unit> $callback;
        final /* synthetic */ WidgetBuilder $widget;
        final /* synthetic */ WidgetsManager this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* WARN: Multi-variable type inference failed */
        AnonymousClass1(Function1<? super Boolean, Unit> function1, WidgetsManager widgetsManager, WidgetBuilder widgetBuilder) {
            super(1);
            this.$callback = function1;
            this.this$0 = widgetsManager;
            this.$widget = widgetBuilder;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(WidgetInstance widgetInstance) {
            if (widgetInstance == null) {
                try {
                    this.$callback.invoke(false);
                } catch (Exception e) {
                    this.this$0.getLogger().warn(this.this$0, ExceptionsKt.stackTraceToString(e));
                }
                return false;
            }
            try {
                widgetInstance.initialize(this.this$0.daijishouWidgetRepository.addWidgetInstance(new WidgetInstanceEntity(0L, this.$widget.getWidgetId(), widgetInstance.getWidgetInstanceId(), null, 0, 25, null)));
                this.this$0.getWidgetInstanceList().add(widgetInstance);
                this.this$0.getWidgetInstancesLiveData().setValue(this.this$0.getWidgetInstanceList());
                this.$callback.invoke(true);
                return true;
            } catch (Exception e2) {
                this.this$0.getLogger().warn(this.this$0, ExceptionsKt.stackTraceToString(e2));
                return false;
            }
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.ui.widget.WidgetsManager$requestWidgetInstanceRemoval$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: WidgetsManager.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "removed", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class C02111 extends Lambda<Unit> implements Function1<Boolean, Unit> {
        final /* synthetic */ Function1<? super Boolean, Unit> $callback;
        final /* synthetic */ WidgetInstance $widgetInstance;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* WARN: Multi-variable type inference failed */
        C02111(WidgetInstance widgetInstance, Function1<? super Boolean, Unit> function1) {
            super(1);
            this.$widgetInstance = widgetInstance;
            this.$callback = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean z) {
            if (z) {
                WidgetsManager.this.daijishouWidgetRepository.removeWidgetInstanceById(this.$widgetInstance.getWidgetInstanceDatabaseId());
                WidgetsManager.this.getWidgetInstanceList().remove(this.$widgetInstance);
                WidgetsManager.this.getWidgetInstancesLiveData().setValue(WidgetsManager.this.getWidgetInstanceList());
            }
            this.$callback.invoke(Boolean.valueOf(z));
        }
    }

    public final void requestWidgetInstanceRemoval(AppCompatActivity activity, WidgetInstance widgetInstance, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(widgetInstance, "widgetInstance");
        Intrinsics.checkNotNullParameter(callback, "callback");
        widgetInstance.requestRemoval(activity, new C02111(widgetInstance, callback));
    }

    public final void requestWidgetInstanceRemoval(AppCompatActivity activity, Class<? extends WidgetBuilder> widgetBuilderClass, Object data, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(widgetBuilderClass, "widgetBuilderClass");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Object obj = this.widgetBuilders.get(widgetBuilderClass);
        Intrinsics.checkNotNull(obj);
        DataRemovalWidget dataRemovalWidget = (DataRemovalWidget) obj;
        try {
            dataRemovalWidget.requestWidgetInstanceRemoval(activity, data, new AnonymousClass2(dataRemovalWidget));
            callback.invoke(true);
        } catch (Exception e) {
            this.logger.warn(this, "Widget instance unable to remove by data:\n" + ExceptionsKt.stackTraceToString(e));
            callback.invoke(false);
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.ui.widget.WidgetsManager$requestWidgetInstanceRemoval$2, reason: invalid class name */
    /* INFO: compiled from: WidgetsManager.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "widgetInstanceId", "", "invoke", "(Ljava/lang/Long;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass2 extends Lambda<Unit> implements Function1<Long, Unit> {
        final /* synthetic */ DataRemovalWidget $widget;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(DataRemovalWidget dataRemovalWidget) {
            super(1);
            this.$widget = dataRemovalWidget;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            DaijishouWidgetRepository daijishouWidgetRepository = WidgetsManager.this.daijishouWidgetRepository;
            Object obj = this.$widget;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetBuilder");
            String widgetId = ((WidgetBuilder) obj).getWidgetId();
            Intrinsics.checkNotNull(l);
            WidgetInstanceEntity widgetInstanceByWidgetIdAndWidgetInstanceIdStatically = daijishouWidgetRepository.getWidgetInstanceByWidgetIdAndWidgetInstanceIdStatically(widgetId, l.longValue());
            Intrinsics.checkNotNull(widgetInstanceByWidgetIdAndWidgetInstanceIdStatically);
            WidgetsManager.this.daijishouWidgetRepository.removeWidgetInstanceById(widgetInstanceByWidgetIdAndWidgetInstanceIdStatically.getId());
            List<WidgetInstance> widgetInstanceList = WidgetsManager.this.getWidgetInstanceList();
            List<WidgetInstance> widgetInstanceList2 = WidgetsManager.this.getWidgetInstanceList();
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : widgetInstanceList2) {
                if (((WidgetInstance) obj2).getWidgetInstanceDatabaseId() == widgetInstanceByWidgetIdAndWidgetInstanceIdStatically.getId()) {
                    arrayList.add(obj2);
                }
            }
            widgetInstanceList.removeAll(arrayList);
            WidgetsManager.this.getWidgetInstancesLiveData().setValue(WidgetsManager.this.getWidgetInstanceList());
        }
    }
}
