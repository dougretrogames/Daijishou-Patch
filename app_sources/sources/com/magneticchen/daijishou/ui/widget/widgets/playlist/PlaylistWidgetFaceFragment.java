package com.magneticchen.daijishou.ui.widget.widgets.playlist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetFaceFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlaylistWidgetFaceFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\f"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widgets/playlist/PlaylistWidgetFaceFragment;", "Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetFaceFragment;", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PlaylistWidgetFaceFragment extends WidgetFaceFragment {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: PlaylistWidgetFaceFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widgets/playlist/PlaylistWidgetFaceFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/ui/widget/widgets/playlist/PlaylistWidgetFaceFragment;", "widgetInstanceId", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PlaylistWidgetFaceFragment newInstance(long j) {
            PlaylistWidgetFaceFragment playlistWidgetFaceFragment = new PlaylistWidgetFaceFragment();
            Bundle bundle = new Bundle();
            bundle.putLong("widgetInstanceId", j);
            playlistWidgetFaceFragment.setArguments(bundle);
            return playlistWidgetFaceFragment;
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.widget_face_playlist, viewGroup, false);
    }
}
