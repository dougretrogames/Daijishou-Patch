package com.magneticchen.daijishou.daijishou_widget.widgets.random;

import android.graphics.drawable.Drawable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetBuilder;
import com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetInstance;
import com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetViewModel;
import com.magneticchen.daijishou.daijishou_widget.widget_db.WidgetId;
import com.magneticchen.daijishou.dialog_fragments.ListSelectDialogFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: RandomWidgetBuilder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 *2\u00020\u0001:\u0001*B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u0007H\u0016J.\u0010 \u001a\u00020!2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u00072\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020!0#H\u0016J\b\u0010%\u001a\u00020!H\u0016J2\u0010&\u001a\u00020!2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010'\u001a\u0004\u0018\u00010(2\u0014\u0010)\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0004\u0012\u00020$0#H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000bR\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006+"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widgets/random/RandomWidgetBuilder;", "Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetBuilder;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "(Lcom/magneticchen/daijishou/DaijishouApplication;)V", "createdWidgetInstanceIdList", "", "", "widgetDescriptionStringId", "", "getWidgetDescriptionStringId", "()I", "widgetIcon", "Landroid/graphics/drawable/Drawable;", "getWidgetIcon", "()Landroid/graphics/drawable/Drawable;", "widgetId", "", "getWidgetId", "()Ljava/lang/String;", "widgetNameStringId", "getWidgetNameStringId", "widgetViewModelClass", "Ljava/lang/Class;", "Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetViewModel;", "getWidgetViewModelClass", "()Ljava/lang/Class;", "acquireWidgetInstance", "Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetInstance;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "widgetInstanceId", "requestWidgetInstanceRemoval", "", "callback", "Lkotlin/Function1;", "", "reset", "startWidgetInstanceCreation", "data", "", "submitWidgetInstance", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RandomWidgetBuilder extends WidgetBuilder {
    public static final long RANDOM_ALL_ID = 0;
    public static final long RANDOM_FAVORITE_ID = 1;
    public static final long RANDOM_NEWLY_ID = 3;
    public static final long RANDOM_RECENT_ID = 2;
    private final List<Long> createdWidgetInstanceIdList;
    private final int widgetDescriptionStringId;
    private final Drawable widgetIcon;
    private final String widgetId;
    private final int widgetNameStringId;
    private final Class<WidgetViewModel> widgetViewModelClass;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<Long> widgetInstanceIdList = CollectionsKt.listOf(new Long[]{0L, 1L, 2L, 3L});

    @Override // com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetBuilder
    public void reset() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RandomWidgetBuilder(DaijishouApplication application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        Drawable drawable = ContextCompat.getDrawable(application.getApplicationContext(), R.drawable.ic_dice);
        Intrinsics.checkNotNull(drawable);
        this.widgetIcon = drawable;
        this.widgetNameStringId = R.string.random_widget_name;
        this.widgetDescriptionStringId = R.string.random_widget_description;
        this.widgetId = WidgetId.RANDOM.getId();
        this.widgetViewModelClass = (Class<com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetViewModel>) (Class<?>) RandomWidgetViewModel.class;
        this.createdWidgetInstanceIdList = new ArrayList();
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

    /* JADX INFO: compiled from: RandomWidgetBuilder.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widgets/random/RandomWidgetBuilder$Companion;", "", "()V", "RANDOM_ALL_ID", "", "RANDOM_FAVORITE_ID", "RANDOM_NEWLY_ID", "RANDOM_RECENT_ID", "widgetInstanceIdList", "", "getWidgetInstanceIdList", "()Ljava/util/List;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<Long> getWidgetInstanceIdList() {
            return RandomWidgetBuilder.widgetInstanceIdList;
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetBuilder
    public void startWidgetInstanceCreation(AppCompatActivity activity, Object data, Function1<? super WidgetInstance, Boolean> submitWidgetInstance) {
        Intrinsics.checkNotNullParameter(submitWidgetInstance, "submitWidgetInstance");
        ListSelectDialogFragment.Companion companion = ListSelectDialogFragment.INSTANCE;
        String string = getApplication().getString(R.string.widget_face_random_options_title);
        String string2 = getApplication().getString(R.string.widget_face_random_all_option);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = getApplication().getString(R.string.widget_face_random_favorite_option);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = getApplication().getString(R.string.widget_face_random_recent_option);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        String string5 = getApplication().getString(R.string.widget_face_random_newly_option);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        ListSelectDialogFragment onCancelListener = ListSelectDialogFragment.Companion.newInstance$default(companion, string, CollectionsKt.arrayListOf(string2, string3, string4, string5), null, true, 4, null).setOnSelectListener(new AnonymousClass1(submitWidgetInstance)).setOnCancelListener(new AnonymousClass2(submitWidgetInstance));
        Intrinsics.checkNotNull(activity);
        onCancelListener.show(activity.getSupportFragmentManager(), ListSelectDialogFragment.class.getName());
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.random.RandomWidgetBuilder$startWidgetInstanceCreation$1, reason: invalid class name */
    /* JADX INFO: compiled from: RandomWidgetBuilder.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass1 extends Lambda<Unit> implements Function1<Integer, Unit> {
        final /* synthetic */ Function1<? super WidgetInstance, Boolean> $submitWidgetInstance;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function1<? super WidgetInstance, Boolean> function1) {
            super(1);
            this.$submitWidgetInstance = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            try {
                invoke(num.intValue());
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
            return Unit.INSTANCE;
        }

        public final void invoke(int i) {
            long jLongValue = RandomWidgetBuilder.INSTANCE.getWidgetInstanceIdList().get(i).longValue();
            if (!RandomWidgetBuilder.this.createdWidgetInstanceIdList.contains(Long.valueOf(jLongValue))) {
                RandomWidgetBuilder.this.createdWidgetInstanceIdList.add(Long.valueOf(jLongValue));
                if (this.$submitWidgetInstance.invoke(new RandomWidgetInstance(RandomWidgetBuilder.this, jLongValue)).booleanValue()) {
                    return;
                }
                RandomWidgetBuilder.this.createdWidgetInstanceIdList.remove(Long.valueOf(jLongValue));
                return;
            }
            this.$submitWidgetInstance.invoke(null);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.random.RandomWidgetBuilder$startWidgetInstanceCreation$2, reason: invalid class name */
    /* JADX INFO: compiled from: RandomWidgetBuilder.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass2 extends Lambda<Unit> implements Function0<Unit> {
        final /* synthetic */ Function1<? super WidgetInstance, Boolean> $submitWidgetInstance;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Function1<? super WidgetInstance, Boolean> function1) {
            super(0);
            this.$submitWidgetInstance = function1;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$submitWidgetInstance.invoke(null);
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetBuilder
    public WidgetInstance acquireWidgetInstance(AppCompatActivity activity, long widgetInstanceId) {
        if (!widgetInstanceIdList.contains(Long.valueOf(widgetInstanceId))) {
            return null;
        }
        if (this.createdWidgetInstanceIdList.contains(Long.valueOf(widgetInstanceId))) {
            return new RandomWidgetInstance(this, widgetInstanceId);
        }
        this.createdWidgetInstanceIdList.add(Long.valueOf(widgetInstanceId));
        return new RandomWidgetInstance(this, widgetInstanceId);
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetBuilder
    public void requestWidgetInstanceRemoval(AppCompatActivity activity, long widgetInstanceId, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.createdWidgetInstanceIdList.contains(Long.valueOf(widgetInstanceId))) {
            this.createdWidgetInstanceIdList.remove(Long.valueOf(widgetInstanceId));
            callback.invoke(true);
        } else {
            callback.invoke(false);
        }
    }
}
