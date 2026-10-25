package com.magneticchen.daijishou.daijishou_widget.widgets.playlist;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import com.magneticchen.daijishou.daijishou_widget.widget_db.PlaylistWidgetInstanceEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlaylistLiveData.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u000eH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widgets/playlist/PlaylistLiveData;", "Landroidx/lifecycle/LiveData;", "", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "playlistWidgetInstanceEntityLiveData", "Lcom/magneticchen/daijishou/daijishou_widget/widget_db/PlaylistWidgetInstanceEntity;", "(Lcom/magneticchen/daijishou/DaijishouApplication;Landroidx/lifecycle/LiveData;)V", "playlist", "", "playlistWidgetInstanceEntityLiveDataObserver", "Landroidx/lifecycle/Observer;", "onActive", "", "onInactive", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PlaylistLiveData extends LiveData<List<? extends PlayableItemEntity>> {
    private final DaijishouApplication application;
    private final List<PlayableItemEntity> playlist;
    private final LiveData<PlaylistWidgetInstanceEntity> playlistWidgetInstanceEntityLiveData;
    private Observer<PlaylistWidgetInstanceEntity> playlistWidgetInstanceEntityLiveDataObserver;

    public PlaylistLiveData(DaijishouApplication application, LiveData<PlaylistWidgetInstanceEntity> playlistWidgetInstanceEntityLiveData) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(playlistWidgetInstanceEntityLiveData, "playlistWidgetInstanceEntityLiveData");
        this.application = application;
        this.playlistWidgetInstanceEntityLiveData = playlistWidgetInstanceEntityLiveData;
        this.playlist = new ArrayList();
    }

    @Override // androidx.lifecycle.LiveData
    public void onActive() {
        super.onActive();
        PlaylistLiveData$$ExternalSyntheticLambda0 playlistLiveData$$ExternalSyntheticLambda0 = new PlaylistLiveData$$ExternalSyntheticLambda0();
        this.playlistWidgetInstanceEntityLiveDataObserver = playlistLiveData$$ExternalSyntheticLambda0;
        LiveData<PlaylistWidgetInstanceEntity> liveData = this.playlistWidgetInstanceEntityLiveData;
        Intrinsics.checkNotNull(playlistLiveData$$ExternalSyntheticLambda0);
        liveData.observeForever(playlistLiveData$$ExternalSyntheticLambda0);
    }

    @Override // androidx.lifecycle.LiveData
    public void onInactive() {
        super.onInactive();
        Observer<PlaylistWidgetInstanceEntity> observer = this.playlistWidgetInstanceEntityLiveDataObserver;
        if (observer != null) {
            this.playlistWidgetInstanceEntityLiveData.removeObserver(observer);
            this.playlistWidgetInstanceEntityLiveDataObserver = null;
        }
    }
}
