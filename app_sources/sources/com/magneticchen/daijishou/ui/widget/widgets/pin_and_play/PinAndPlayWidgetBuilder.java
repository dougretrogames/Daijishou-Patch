package com.magneticchen.daijishou.ui.widget.widgets.pin_and_play;

import android.graphics.drawable.Drawable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.db.entity.PinAndPlayWidgetInstanceEntity;
import com.magneticchen.daijishou.data.db.entity.WidgetId;
import com.magneticchen.daijishou.data.db.repositories.DaijishouWidgetRepository;
import com.magneticchen.daijishou.ui.widget.abstract_widget_classes.DataRemovalWidget;
import com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetBuilder;
import com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetInstance;
import com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetViewModel;
import java.util.Arrays;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PinAndPlayWidgetBuilder.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001.B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001eJ\u0014\u0010\"\u001a\u00020 2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001e0$J2\u0010%\u001a\u00020&2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010'\u001a\u0004\u0018\u00010(2\u0014\u0010)\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0012\u0004\u0012\u00020&0*H\u0016J.\u0010%\u001a\u00020&2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020&0*H\u0016J\b\u0010+\u001a\u00020&H\u0016J2\u0010,\u001a\u00020&2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010'\u001a\u0004\u0018\u00010(2\u0014\u0010-\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020 0*H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006/"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widgets/pin_and_play/PinAndPlayWidgetBuilder;", "Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetBuilder;", "Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/DataRemovalWidget;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "(Lcom/magneticchen/daijishou/DaijishouApplication;)V", "widgetDescriptionStringId", "", "getWidgetDescriptionStringId", "()I", "widgetIcon", "Landroid/graphics/drawable/Drawable;", "getWidgetIcon", "()Landroid/graphics/drawable/Drawable;", "widgetId", "", "getWidgetId", "()Ljava/lang/String;", "widgetNameStringId", "getWidgetNameStringId", "widgetViewModelClass", "Ljava/lang/Class;", "Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetViewModel;", "getWidgetViewModelClass", "()Ljava/lang/Class;", "acquireWidgetInstance", "Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetInstance;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "widgetInstanceId", "", "isPlayableItemIdInAPinAndPlayWidget", "", "playableItemId", "isPlayableItemIdsInAPinAndPlayWidget", "playableItemIds", "", "requestWidgetInstanceRemoval", "", "data", "", "callback", "Lkotlin/Function1;", "reset", "startWidgetInstanceCreation", "submitWidgetInstance", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PinAndPlayWidgetBuilder extends WidgetBuilder implements DataRemovalWidget {
    public static final Companion Companion = new Companion(null);
    public static final String IMAGES_DIRECTORY = "pin_and_play_widget_images";
    private final int widgetDescriptionStringId;
    private final Drawable widgetIcon;
    private final String widgetId;
    private final int widgetNameStringId;
    private final Class<WidgetViewModel> widgetViewModelClass;

    @Override // com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetBuilder
    public void reset() {
    }

    /* JADX INFO: compiled from: PinAndPlayWidgetBuilder.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widgets/pin_and_play/PinAndPlayWidgetBuilder$Companion;", "", "()V", "IMAGES_DIRECTORY", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PinAndPlayWidgetBuilder(DaijishouApplication application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        Drawable drawable = ContextCompat.getDrawable(application.getApplicationContext(), R.drawable.ic_round_play_arrow_24);
        Intrinsics.checkNotNull(drawable);
        this.widgetIcon = drawable;
        this.widgetNameStringId = R.string.pin_and_play_widget_name;
        this.widgetDescriptionStringId = R.string.pin_and_play_widget_description;
        this.widgetId = WidgetId.PIN_AND_PLAY.getId();
        this.widgetViewModelClass = PinAndPlayWidgetViewModel.class;
    }

    @Override // com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetBuilder
    public Drawable getWidgetIcon() {
        return this.widgetIcon;
    }

    @Override // com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetBuilder
    public int getWidgetNameStringId() {
        return this.widgetNameStringId;
    }

    @Override // com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetBuilder
    public int getWidgetDescriptionStringId() {
        return this.widgetDescriptionStringId;
    }

    @Override // com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetBuilder
    public String getWidgetId() {
        return this.widgetId;
    }

    @Override // com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetBuilder
    public Class<WidgetViewModel> getWidgetViewModelClass() {
        return this.widgetViewModelClass;
    }

    @Override // com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetBuilder
    public void startWidgetInstanceCreation(AppCompatActivity appCompatActivity, Object obj, Function1<? super WidgetInstance, Boolean> submitWidgetInstance) {
        Intrinsics.checkNotNullParameter(submitWidgetInstance, "submitWidgetInstance");
        long jAddPinAndPlayWidgetInstance = getDaijishouWidgetRepository().addPinAndPlayWidgetInstance(new PinAndPlayWidgetInstanceEntity(0L, null, null, null, 15, null));
        try {
            if (obj instanceof Long) {
                PinAndPlayWidgetInstanceEntity pinAndPlayWidgetInstanceByIdStatically = getDaijishouWidgetRepository().getPinAndPlayWidgetInstanceByIdStatically(jAddPinAndPlayWidgetInstance);
                Intrinsics.checkNotNull(pinAndPlayWidgetInstanceByIdStatically);
                pinAndPlayWidgetInstanceByIdStatically.setPlayableItemId((Long) obj);
                getDaijishouWidgetRepository().updatePinAndPlayWidgetInstance(pinAndPlayWidgetInstanceByIdStatically);
            }
            submitWidgetInstance.invoke(new PinAndPlayWidgetInstance(this, jAddPinAndPlayWidgetInstance));
        } catch (Exception e) {
            getLogger().warn(this, ExceptionsKt.stackTraceToString(e));
            getDaijishouWidgetRepository().removeWidgetInstanceById(jAddPinAndPlayWidgetInstance);
            submitWidgetInstance.invoke(null);
        }
    }

    @Override // com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetBuilder
    public WidgetInstance acquireWidgetInstance(AppCompatActivity appCompatActivity, long j) {
        if (getDaijishouWidgetRepository().getPinAndPlayWidgetInstanceByIdStatically(j) == null) {
            return null;
        }
        return new PinAndPlayWidgetInstance(this, j);
    }

    @Override // com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetBuilder
    public void requestWidgetInstanceRemoval(AppCompatActivity appCompatActivity, long j, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            getDaijishouWidgetRepository().removePinAndPlayWidgetInstanceById(j);
            callback.invoke(true);
        } catch (Exception e) {
            getLogger().warn(this, ExceptionsKt.stackTraceToString(e));
            callback.invoke(false);
        }
    }

    @Override // com.magneticchen.daijishou.ui.widget.abstract_widget_classes.DataRemovalWidget
    public void requestWidgetInstanceRemoval(AppCompatActivity appCompatActivity, Object obj, Function1<? super Long, Unit> callback) {
        PinAndPlayWidgetInstanceEntity pinAndPlayWidgetInstanceByIdStatically;
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            if (obj instanceof Long) {
                pinAndPlayWidgetInstanceByIdStatically = getDaijishouWidgetRepository().getPinAndPlayWidgetInstanceByIdStatically(((Long) obj).longValue());
                Intrinsics.checkNotNull(pinAndPlayWidgetInstanceByIdStatically);
            } else {
                DaijishouWidgetRepository daijishouWidgetRepository = getDaijishouWidgetRepository();
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Long>");
                long[] longArray = CollectionsKt.toLongArray((List) obj);
                pinAndPlayWidgetInstanceByIdStatically = (PinAndPlayWidgetInstanceEntity) CollectionsKt.first((List) daijishouWidgetRepository.getPinAndPlayWidgetInstanceByPlayableItemIdsStatically(Arrays.copyOf(longArray, longArray.length)));
            }
            getDaijishouWidgetRepository().removePinAndPlayWidgetInstanceById(pinAndPlayWidgetInstanceByIdStatically.getId());
            callback.invoke(Long.valueOf(pinAndPlayWidgetInstanceByIdStatically.getId()));
        } catch (Exception e) {
            getLogger().warn(this, ExceptionsKt.stackTraceToString(e));
            callback.invoke(null);
        }
    }

    public final boolean isPlayableItemIdInAPinAndPlayWidget(long j) {
        return getDaijishouWidgetRepository().getPinAndPlayWidgetInstanceByPlayableItemIdStatically(j) != null;
    }

    public final boolean isPlayableItemIdsInAPinAndPlayWidget(List<Long> playableItemIds) {
        Intrinsics.checkNotNullParameter(playableItemIds, "playableItemIds");
        DaijishouWidgetRepository daijishouWidgetRepository = getDaijishouWidgetRepository();
        long[] longArray = CollectionsKt.toLongArray(playableItemIds);
        return !daijishouWidgetRepository.getPinAndPlayWidgetInstanceByPlayableItemIdsStatically(Arrays.copyOf(longArray, longArray.length)).isEmpty();
    }
}
