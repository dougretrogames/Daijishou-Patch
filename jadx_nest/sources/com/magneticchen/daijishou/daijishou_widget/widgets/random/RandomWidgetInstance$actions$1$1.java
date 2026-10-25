package com.magneticchen.daijishou.daijishou_widget.widgets.random;

import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: RandomWidgetInstance.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class RandomWidgetInstance$actions$1$1 extends Lambda<Unit> implements Function1<AppCompatActivity, Unit> {
    final /* synthetic */ Function0<PlayableItemEntity> $randomFunction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RandomWidgetInstance$actions$1$1(Function0<PlayableItemEntity> function0) {
        super(1);
        this.$randomFunction = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AppCompatActivity appCompatActivity) {
        invoke2(appCompatActivity);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Function0<PlayableItemEntity> function0 = this.$randomFunction;
        PlayableItemEntity playableItemEntityInvoke = function0 != null ? function0.invoke() : null;
        if (playableItemEntityInvoke == null) {
            Toast.makeText(activity.getApplicationContext(), activity.getString(R.string.no_items_period), 0).show();
        } else {
            PlayableItemDetailDialogFragment.INSTANCE.newInstance(playableItemEntityInvoke).show(activity.getSupportFragmentManager(), PlayableItemDetailDialogFragment.class.getName());
        }
    }
}
