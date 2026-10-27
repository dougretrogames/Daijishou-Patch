package com.magneticchen.daijishou.ui.widget.widgets.random;

import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.db.entity.PlayableItemEntity;
import com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment;
import com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetBuilder;
import com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetFaceFragment;
import com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetInstance;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RandomWidgetInstance.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R2\u0010\u0007\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widgets/random/RandomWidgetInstance;", "Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetInstance;", "widgetBuilder", "Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetBuilder;", "widgetInstanceId", "", "(Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetBuilder;J)V", "actions", "", "Lkotlin/Pair;", "", "Lkotlin/Function1;", "Landroidx/appcompat/app/AppCompatActivity;", "", "getActions", "()Ljava/util/List;", "widgetFaceFragment", "Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetFaceFragment;", "getWidgetFaceFragment", "()Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetFaceFragment;", "getWidgetInstanceId", "()J", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RandomWidgetInstance extends WidgetInstance {
    public static final Companion Companion = new Companion(null);
    private static final HashMap<Long, Integer> widgetInstanceIdToActionTitleStringId = MapsKt.hashMapOf(TuplesKt.to(0L, Integer.valueOf(R.string.random_widget_random_all_action)), TuplesKt.to(1L, Integer.valueOf(R.string.random_widget_favorite_action)), TuplesKt.to(2L, Integer.valueOf(R.string.random_widget_recent_action)), TuplesKt.to(3L, Integer.valueOf(R.string.random_widget_newly_action)));
    private final List<Pair<Integer, Function1<AppCompatActivity, Unit>>> actions;
    private final WidgetFaceFragment widgetFaceFragment;
    private final long widgetInstanceId;

    /* JADX INFO: compiled from: RandomWidgetInstance.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R-\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widgets/random/RandomWidgetInstance$Companion;", "", "()V", "widgetInstanceIdToActionTitleStringId", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getWidgetInstanceIdToActionTitleStringId", "()Ljava/util/HashMap;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HashMap<Long, Integer> getWidgetInstanceIdToActionTitleStringId() {
            return RandomWidgetInstance.widgetInstanceIdToActionTitleStringId;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RandomWidgetInstance(WidgetBuilder widgetBuilder, long j) {
        super(widgetBuilder);
        Intrinsics.checkNotNullParameter(widgetBuilder, "widgetBuilder");
        this.widgetInstanceId = j;
        this.widgetFaceFragment = RandomWidgetFaceFragment.Companion.newInstance(j);
        int size = RandomWidgetFaceFragment.Companion.getWidgetInstanceIdToSubtitleStringId().size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            WidgetFaceFragment widgetFaceFragment = getWidgetFaceFragment();
            Intrinsics.checkNotNull(widgetFaceFragment, "null cannot be cast to non-null type com.magneticchen.daijishou.ui.widget.widgets.random.RandomWidgetFaceFragment");
            Set<Long> setKeySet = RandomWidgetFaceFragment.Companion.getWidgetInstanceIdToSubtitleStringId().keySet();
            Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
            Long l = ((Long[]) setKeySet.toArray(new Long[0]))[i];
            Intrinsics.checkNotNullExpressionValue(l, "get(...)");
            long jLongValue = l.longValue();
            final Function0<PlayableItemEntity> function0 = ((RandomWidgetFaceFragment) widgetFaceFragment).getWidgetInstanceIdToRandomFunction().get(Long.valueOf(jLongValue));
            Integer num = widgetInstanceIdToActionTitleStringId.get(Long.valueOf(jLongValue));
            Intrinsics.checkNotNull(num);
            arrayList.add(new Pair(num, new Function1<AppCompatActivity, Unit>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.random.RandomWidgetInstance$actions$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AppCompatActivity appCompatActivity) {
                    invoke2(appCompatActivity);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AppCompatActivity activity) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    Function0<PlayableItemEntity> function1 = function0;
                    PlayableItemEntity playableItemEntityInvoke = function1 != null ? function1.invoke() : null;
                    if (playableItemEntityInvoke == null) {
                        Toast.makeText(activity.getApplicationContext(), activity.getString(R.string.no_items_period), 0).show();
                    } else {
                        PlayableItemDetailDialogFragment.Companion.newInstance(playableItemEntityInvoke).show(activity.getSupportFragmentManager(), PlayableItemDetailDialogFragment.class.getName());
                    }
                }
            }));
        }
        this.actions = arrayList;
    }

    @Override // com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetInstance
    public long getWidgetInstanceId() {
        return this.widgetInstanceId;
    }

    @Override // com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetInstance
    public WidgetFaceFragment getWidgetFaceFragment() {
        return this.widgetFaceFragment;
    }

    @Override // com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetInstance
    public List<Pair<Integer, Function1<AppCompatActivity, Unit>>> getActions() {
        return this.actions;
    }
}
