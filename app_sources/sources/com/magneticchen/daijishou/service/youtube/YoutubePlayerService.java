package com.magneticchen.daijishou.service.youtube;

import android.content.SharedPreferences;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.magneticchen.daijishou.data.BooleanPreference;
import com.magneticchen.daijishou.data.db.entity.PlayableItemEntity;
import com.magneticchen.daijishou.data.live.SharedPreferenceBooleanLiveData;
import com.magneticchen.daijishou.ui.model.DaijishouLibraryModel;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: YoutubePlayerService.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/magneticchen/daijishou/service/youtube/YoutubePlayerService;", "", "daijishouLibrary", "Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;", "fragment", "Landroidx/fragment/app/Fragment;", "preferences", "Landroid/content/SharedPreferences;", "view", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/YouTubePlayerView;", "(Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;Landroidx/fragment/app/Fragment;Landroid/content/SharedPreferences;Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/YouTubePlayerView;)V", "manager", "Lcom/magneticchen/daijishou/service/youtube/YoutubePlayerManager;", "getManager", "()Lcom/magneticchen/daijishou/service/youtube/YoutubePlayerManager;", "getPreferences", "()Landroid/content/SharedPreferences;", "initialize", "entity", "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;", "initializeObservers", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class YoutubePlayerService {
    private final DaijishouLibraryModel daijishouLibrary;
    private final Fragment fragment;
    private final YoutubePlayerManager manager;
    private final SharedPreferences preferences;

    public YoutubePlayerService(DaijishouLibraryModel daijishouLibrary, Fragment fragment, SharedPreferences preferences, YouTubePlayerView view) {
        Intrinsics.checkNotNullParameter(daijishouLibrary, "daijishouLibrary");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        Intrinsics.checkNotNullParameter(view, "view");
        this.daijishouLibrary = daijishouLibrary;
        this.fragment = fragment;
        this.preferences = preferences;
        this.manager = new YoutubePlayerManager(fragment, view, true);
        initializeObservers();
    }

    public final SharedPreferences getPreferences() {
        return this.preferences;
    }

    public final YoutubePlayerManager getManager() {
        return this.manager;
    }

    private final void initializeObservers() {
        new SharedPreferenceBooleanLiveData(this.preferences, BooleanPreference.PLAY_PREVIEW_VIDEO.getKey(), BooleanPreference.PLAY_PREVIEW_VIDEO.getDefaultValue()).observe((LifecycleOwner) this.fragment, new YoutubePlayerService$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.service.youtube.YoutubePlayerService.initializeObservers.1
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                YoutubePlayerManager manager = YoutubePlayerService.this.getManager();
                Intrinsics.checkNotNull(bool);
                manager.enableVideoPlayback(bool.booleanValue());
            }
        }));
        new SharedPreferenceBooleanLiveData(this.preferences, "make_preview_video_sounds", true).observe((LifecycleOwner) this.fragment, new YoutubePlayerService$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.service.youtube.YoutubePlayerService.initializeObservers.2
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                YoutubePlayerService.this.getManager().mute(!bool.booleanValue());
            }
        }));
    }

    public final YoutubePlayerService initialize(PlayableItemEntity entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.fragment), Dispatchers.getIO(), (CoroutineStart) null, new YoutubePlayerService$initialize$1$1(this, entity, null), 2, (Object) null);
        return this;
    }
}
