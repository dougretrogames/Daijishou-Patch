package com.magneticchen.daijishou.ui.widget.widgets.random;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.db.entity.PlayableItemEntity;
import com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment;
import com.magneticchen.daijishou.ui.model.DaijishouLibraryModel;
import com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetFaceFragment;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RandomWidgetFaceFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R=\u0010\u0003\u001a.\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060\u0004j\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006`\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widgets/random/RandomWidgetFaceFragment;", "Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetFaceFragment;", "()V", "widgetInstanceIdToRandomFunction", "Ljava/util/HashMap;", "", "Lkotlin/Function0;", "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;", "Lkotlin/collections/HashMap;", "getWidgetInstanceIdToRandomFunction", "()Ljava/util/HashMap;", "onClick", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RandomWidgetFaceFragment extends WidgetFaceFragment {
    public static final Companion Companion = new Companion(null);
    private static final HashMap<Long, Integer> widgetInstanceIdToSubtitleStringId = MapsKt.hashMapOf(TuplesKt.to(0L, Integer.valueOf(R.string.widget_face_random_all_subtitle)), TuplesKt.to(1L, Integer.valueOf(R.string.widget_face_random_favorite_subtitle)), TuplesKt.to(2L, Integer.valueOf(R.string.widget_face_random_recent_subtitle)), TuplesKt.to(3L, Integer.valueOf(R.string.widget_face_random_newly_subtitle)));
    private final HashMap<Long, Function0<PlayableItemEntity>> widgetInstanceIdToRandomFunction = MapsKt.hashMapOf(TuplesKt.to(0L, new Function0<PlayableItemEntity>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.random.RandomWidgetFaceFragment$widgetInstanceIdToRandomFunction$1
        

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PlayableItemEntity invoke() {
            return DaijishouLibraryModel.getPlayableItemRandomlyByVisibility$default(this.this$0.getDaijishouLibrary(), false, 1, null);
        }
    }), TuplesKt.to(1L, new Function0<PlayableItemEntity>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.random.RandomWidgetFaceFragment$widgetInstanceIdToRandomFunction$2
        

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PlayableItemEntity invoke() {
            return DaijishouLibraryModel.getFavoritePlayableItemRandomlyByVisibility$default(this.this$0.getDaijishouLibrary(), false, 1, null);
        }
    }), TuplesKt.to(2L, new Function0<PlayableItemEntity>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.random.RandomWidgetFaceFragment$widgetInstanceIdToRandomFunction$3
        

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PlayableItemEntity invoke() {
            return DaijishouLibraryModel.getRecentPlayableItemRandomlyByVisibility$default(this.this$0.getDaijishouLibrary(), false, 1, null);
        }
    }), TuplesKt.to(3L, new Function0<PlayableItemEntity>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.random.RandomWidgetFaceFragment$widgetInstanceIdToRandomFunction$4
        

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PlayableItemEntity invoke() {
            return DaijishouLibraryModel.getNewlyPlayableItemRandomlyByVisibility$default(this.this$0.getDaijishouLibrary(), false, 1, null);
        }
    }));

    /* JADX INFO: compiled from: RandomWidgetFaceFragment.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005R-\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widgets/random/RandomWidgetFaceFragment$Companion;", "", "()V", "widgetInstanceIdToSubtitleStringId", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getWidgetInstanceIdToSubtitleStringId", "()Ljava/util/HashMap;", "newInstance", "Lcom/magneticchen/daijishou/ui/widget/widgets/random/RandomWidgetFaceFragment;", "widgetInstanceId", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RandomWidgetFaceFragment newInstance(long j) {
            RandomWidgetFaceFragment randomWidgetFaceFragment = new RandomWidgetFaceFragment();
            Bundle bundle = new Bundle();
            bundle.putLong("widgetInstanceId", j);
            randomWidgetFaceFragment.setArguments(bundle);
            return randomWidgetFaceFragment;
        }

        public final HashMap<Long, Integer> getWidgetInstanceIdToSubtitleStringId() {
            return RandomWidgetFaceFragment.widgetInstanceIdToSubtitleStringId;
        }
    }

    public final HashMap<Long, Function0<PlayableItemEntity>> getWidgetInstanceIdToRandomFunction() {
        return this.widgetInstanceIdToRandomFunction;
    }

    @Override // com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetFaceFragment
    public void onClick() {
        super.onClick();
        Function0<PlayableItemEntity> function0 = this.widgetInstanceIdToRandomFunction.get(Long.valueOf(requireArguments().getLong("widgetInstanceId")));
        PlayableItemEntity playableItemEntityInvoke = function0 != null ? function0.invoke() : null;
        if (playableItemEntityInvoke == null) {
            Toast.makeText(requireContext(), "No item.", 0).show();
        } else {
            PlayableItemDetailDialogFragment.Companion.newInstance(playableItemEntityInvoke).show(getParentFragmentManager(), PlayableItemDetailDialogFragment.class.getName());
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        long j = requireArguments().getLong("widgetInstanceId");
        View viewInflate = inflater.inflate(R.layout.widget_face_random, viewGroup, false);
        TextView textView = (TextView) viewInflate.findViewById(R.id.widget_face_random_widget_subtitle);
        Integer num = widgetInstanceIdToSubtitleStringId.get(Long.valueOf(j));
        Intrinsics.checkNotNull(num);
        textView.setText(getString(num.intValue()));
        return viewInflate;
    }
}
