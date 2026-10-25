package com.magneticchen.daijishou.daijishou_widget.widgets.playlist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetFaceFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: PlaylistWidgetFaceFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\f²\u0006\n\u0010\r\u001a\u00020\u000eX\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widgets/playlist/PlaylistWidgetFaceFragment;", "Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetFaceFragment;", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_release", "widgetModel", "Lcom/magneticchen/daijishou/daijishou_widget/widgets/playlist/PlaylistWidgetViewModel;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PlaylistWidgetFaceFragment extends WidgetFaceFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: PlaylistWidgetFaceFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widgets/playlist/PlaylistWidgetFaceFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/daijishou_widget/widgets/playlist/PlaylistWidgetFaceFragment;", "widgetInstanceId", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PlaylistWidgetFaceFragment newInstance(long widgetInstanceId) {
            PlaylistWidgetFaceFragment playlistWidgetFaceFragment = new PlaylistWidgetFaceFragment();
            Bundle bundle = new Bundle();
            bundle.putLong("widgetInstanceId", widgetInstanceId);
            playlistWidgetFaceFragment.setArguments(bundle);
            return playlistWidgetFaceFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        PlaylistWidgetFaceFragment playlistWidgetFaceFragment = this;
        FragmentViewModelLazyKt.createViewModelLazy(playlistWidgetFaceFragment, Reflection.getOrCreateKotlinClass(PlaylistWidgetViewModel.class), new PlaylistWidgetFaceFragment$onCreateView$$inlined$activityViewModels$default$1(playlistWidgetFaceFragment), new PlaylistWidgetFaceFragment$onCreateView$$inlined$activityViewModels$default$2(null, playlistWidgetFaceFragment), new PlaylistWidgetFaceFragment$onCreateView$$inlined$activityViewModels$default$3(playlistWidgetFaceFragment));
        requireArguments().getLong("widgetInstanceId");
        return inflater.inflate(R.layout.widget_face_playlist, container, false);
    }
}
