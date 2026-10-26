package com.magneticchen.daijishou.daijishou_widget.widgets.pin_and_play;

import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetBuilder;
import com.magneticchen.daijishou.daijishou_widget.widget_db.PinAndPlayWidgetInstanceEntity;
import com.magneticchen.daijishou.dialog_fragments.ChoosePlayableItemFromLibraryDialogFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: PinAndPlayWidgetInstance.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class PinAndPlayWidgetInstance$actions$2 extends Lambda<Unit> implements Function1<AppCompatActivity, Unit> {
    final /* synthetic */ WidgetBuilder $widgetBuilder;
    final /* synthetic */ PinAndPlayWidgetInstance this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    PinAndPlayWidgetInstance$actions$2(WidgetBuilder widgetBuilder, PinAndPlayWidgetInstance pinAndPlayWidgetInstance) {
        super(1);
        this.$widgetBuilder = widgetBuilder;
        this.this$0 = pinAndPlayWidgetInstance;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AppCompatActivity appCompatActivity) {
        invoke2(appCompatActivity);
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.pin_and_play.PinAndPlayWidgetInstance$actions$2$1, reason: invalid class name */
    /* INFO: compiled from: PinAndPlayWidgetInstance.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass1 extends Lambda<Unit> implements Function1<PlayableItemEntity, Unit> {
        final /* synthetic */ AppCompatActivity $activity;
        final /* synthetic */ ChoosePlayableItemFromLibraryDialogFragment $dialog;
        final /* synthetic */ WidgetBuilder $widgetBuilder;
        final /* synthetic */ PinAndPlayWidgetInstance this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AppCompatActivity appCompatActivity, WidgetBuilder widgetBuilder, PinAndPlayWidgetInstance pinAndPlayWidgetInstance, ChoosePlayableItemFromLibraryDialogFragment choosePlayableItemFromLibraryDialogFragment) {
            super(1);
            this.$activity = appCompatActivity;
            this.$widgetBuilder = widgetBuilder;
            this.this$0 = pinAndPlayWidgetInstance;
            this.$dialog = choosePlayableItemFromLibraryDialogFragment;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PlayableItemEntity playableItemEntity) {
            invoke2(playableItemEntity);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PlayableItemEntity it) {
            Intrinsics.checkNotNullParameter(it, "it");
            Toast.makeText(this.$activity.getApplicationContext(), it.getName(), 0).show();
            PinAndPlayWidgetInstanceEntity pinAndPlayWidgetInstanceByIdStatically = this.$widgetBuilder.getDaijishouWidgetRepository().getPinAndPlayWidgetInstanceByIdStatically(this.this$0.getWidgetInstanceId());
            Intrinsics.checkNotNull(pinAndPlayWidgetInstanceByIdStatically);
            pinAndPlayWidgetInstanceByIdStatically.setPlayableItemId(Long.valueOf(it.getId()));
            this.$widgetBuilder.getDaijishouWidgetRepository().deletePinAndPlayWidgetInstanceEntityImage(pinAndPlayWidgetInstanceByIdStatically);
            pinAndPlayWidgetInstanceByIdStatically.setAlternativeImagePath(null);
            this.$widgetBuilder.getDaijishouWidgetRepository().updatePinAndPlayWidgetInstance(pinAndPlayWidgetInstanceByIdStatically);
            this.$dialog.dismiss();
        }
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        ChoosePlayableItemFromLibraryDialogFragment choosePlayableItemFromLibraryDialogFragmentNewInstance$default = ChoosePlayableItemFromLibraryDialogFragment.Companion.newInstance$default(ChoosePlayableItemFromLibraryDialogFragment.INSTANCE, null, false, false, false, false, false, 63, null);
        choosePlayableItemFromLibraryDialogFragmentNewInstance$default.setOnClickListener(new AnonymousClass1(activity, this.$widgetBuilder, this.this$0, choosePlayableItemFromLibraryDialogFragmentNewInstance$default)).show(activity.getSupportFragmentManager(), ChoosePlayableItemFromLibraryDialogFragment.class.getName());
    }
}
