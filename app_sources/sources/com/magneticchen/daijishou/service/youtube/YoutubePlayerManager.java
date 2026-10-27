package com.magneticchen.daijishou.service.youtube;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.magneticchen.daijishou.data.live.ConnectionLiveData;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.skydoves.balloon.internals.DefinitionKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: YoutubePlayerManager.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u0007J\b\u0010,\u001a\u00020\u0013H\u0002J\u000e\u0010-\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u000fJ\u000e\u0010.\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u0007J\u0018\u0010/\u001a\u00020\u00132\u0006\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020\u001dH\u0016J)\u00102\u001a\u00020\u00002!\u00103\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\u000eJ\u0014\u00104\u001a\u00020\u00002\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00130\u001bJ\u0010\u00105\u001a\u00020\u00132\u0006\u00100\u001a\u00020)H\u0016J\u0018\u00106\u001a\u00020\u00132\u0006\u00100\u001a\u00020)2\u0006\u00107\u001a\u000208H\u0016J\u0014\u00109\u001a\u00020\u00002\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00130\u001bJ\u0018\u0010:\u001a\u00020\u00132\u0006\u00100\u001a\u00020)2\u0006\u0010;\u001a\u00020\u001dH\u0016J\u0006\u0010<\u001a\u00020\u0013R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR)\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00130\u001bX\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\"\u0010%\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020)X\u0082.¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/magneticchen/daijishou/service/youtube/YoutubePlayerManager;", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/AbstractYouTubePlayerListener;", "fragment", "Landroidx/fragment/app/Fragment;", "view", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/YouTubePlayerView;", "playbackEnabled", "", "(Landroidx/fragment/app/Fragment;Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/YouTubePlayerView;Z)V", "connectionType", "", "getFragment", "()Landroidx/fragment/app/Fragment;", "linkReadyCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "id", "", "loadedToSeek", "muted", "getPlaybackEnabled", "()Z", "setPlaybackEnabled", "(Z)V", "playingCallback", "Lkotlin/Function0;", "startAtSeek", "", "stoppedCallback", "<set-?>", "trackSeconds", "getTrackSeconds", "()F", "getView", "()Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/YouTubePlayerView;", "youtubeId", "getYoutubeId", "()Ljava/lang/String;", "youtubePlayer", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;", "enableVideoPlayback", "enable", "initializeConnectionObserver", "loadVideo", "mute", "onCurrentSecond", "youTubePlayer", "second", "onLinkReady", "callback", "onPlaying", "onReady", "onStateChange", "state", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerState;", "onStopped", "onVideoDuration", "duration", "stop", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class YoutubePlayerManager extends AbstractYouTubePlayerListener {
    private int connectionType;
    private final Fragment fragment;
    private Function1<? super String, Unit> linkReadyCallback;
    private boolean loadedToSeek;
    private boolean muted;
    private boolean playbackEnabled;
    private Function0<Unit> playingCallback;
    private float startAtSeek;
    private Function0<Unit> stoppedCallback;
    private float trackSeconds;
    private final YouTubePlayerView view;
    private volatile String youtubeId;
    private YouTubePlayer youtubePlayer;

    /* JADX INFO: compiled from: YoutubePlayerManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PlayerConstants.PlayerState.values().length];
            try {
                iArr[PlayerConstants.PlayerState.ENDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PlayerConstants.PlayerState.PLAYING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ YoutubePlayerManager(Fragment fragment, YouTubePlayerView youTubePlayerView, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragment, youTubePlayerView, (i & 4) != 0 ? true : z);
    }

    public final Fragment getFragment() {
        return this.fragment;
    }

    public final YouTubePlayerView getView() {
        return this.view;
    }

    public final boolean getPlaybackEnabled() {
        return this.playbackEnabled;
    }

    public final void setPlaybackEnabled(boolean z) {
        this.playbackEnabled = z;
    }

    public YoutubePlayerManager(Fragment fragment, YouTubePlayerView view, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(view, "view");
        this.fragment = fragment;
        this.view = view;
        this.playbackEnabled = z;
        this.startAtSeek = 90.0f;
        this.trackSeconds = -1.0f;
        YoutubePlayerManager youtubePlayerManager = this;
        view.initialize(youtubePlayerManager, new IFramePlayerOptions.Builder().origin("https://daijishou.magneticchen.com").controls(0).build());
        view.addYouTubePlayerListener(youtubePlayerManager);
        view.setClipToOutline(true);
        fragment.getLifecycle().addObserver((LifecycleObserver) view);
        initializeConnectionObserver();
    }

    public final String getYoutubeId() {
        return this.youtubeId;
    }

    public final float getTrackSeconds() {
        return this.trackSeconds;
    }

    private final void initializeConnectionObserver() {
        Context contextRequireContext = this.fragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        new ConnectionLiveData(contextRequireContext).observe((LifecycleOwner) this.fragment, new YoutubePlayerManager$sam$androidx_lifecycle_Observer$0(new Function1<Integer, Unit>() { // from class: com.magneticchen.daijishou.service.youtube.YoutubePlayerManager.initializeConnectionObserver.1
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                int i = YoutubePlayerManager.this.connectionType;
                if (num != null && i == num.intValue()) {
                    return;
                }
                YoutubePlayerManager youtubePlayerManager = YoutubePlayerManager.this;
                Intrinsics.checkNotNull(num);
                youtubePlayerManager.connectionType = num.intValue();
                if (num.intValue() != -1) {
                    String youtubeId = YoutubePlayerManager.this.getYoutubeId();
                    if (youtubeId != null) {
                        YoutubePlayerManager.this.loadVideo(youtubeId);
                        return;
                    }
                    return;
                }
                YoutubePlayerManager.this.stop();
            }
        }));
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener, com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onReady(YouTubePlayer youTubePlayer) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        this.youtubePlayer = youTubePlayer;
        mute(this.muted);
        String str = this.youtubeId;
        if (str != null) {
            loadVideo(str);
        }
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener, com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onVideoDuration(YouTubePlayer youTubePlayer, float f) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        if (this.loadedToSeek) {
            return;
        }
        this.loadedToSeek = true;
        if (this.startAtSeek > f) {
            youTubePlayer.seekTo(f / 2.0f);
        }
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener, com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onStateChange(YouTubePlayer youTubePlayer, PlayerConstants.PlayerState state) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        Intrinsics.checkNotNullParameter(state, "state");
        int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        Function0<Unit> function0 = null;
        if (i == 1) {
            stop();
            if (this.playingCallback != null) {
                Function0<Unit> function1 = this.stoppedCallback;
                if (function1 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("stoppedCallback");
                } else {
                    function0 = function1;
                }
                function0.invoke();
                return;
            }
            return;
        }
        if (i != 2) {
            return;
        }
        YouTubePlayerView youTubePlayerView = this.view;
        float alpha = youTubePlayerView.getAlpha();
        youTubePlayerView.setAlpha(DefinitionKt.NO_Float_VALUE);
        youTubePlayerView.setVisibility(0);
        youTubePlayerView.animate().alpha(alpha).setDuration(1000L).start();
        Function0<Unit> function2 = this.playingCallback;
        if (function2 != null) {
            if (function2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playingCallback");
            } else {
                function0 = function2;
            }
            function0.invoke();
        }
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener, com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onCurrentSecond(YouTubePlayer youTubePlayer, float f) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        this.trackSeconds = f;
    }

    public final void loadVideo(String id2) {
        YouTubePlayer youTubePlayer;
        Intrinsics.checkNotNullParameter(id2, "id");
        this.youtubeId = id2;
        Function1<? super String, Unit> function1 = this.linkReadyCallback;
        YouTubePlayer youTubePlayer2 = null;
        if (function1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linkReadyCallback");
            function1 = null;
        }
        function1.invoke(id2);
        if (this.playbackEnabled && (youTubePlayer = this.youtubePlayer) != null) {
            if (youTubePlayer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("youtubePlayer");
            } else {
                youTubePlayer2 = youTubePlayer;
            }
            youTubePlayer2.loadVideo(id2, this.startAtSeek);
        }
    }

    public final void stop() {
        YouTubePlayer youTubePlayer = this.youtubePlayer;
        if (youTubePlayer != null) {
            if (youTubePlayer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("youtubePlayer");
                youTubePlayer = null;
            }
            youTubePlayer.pause();
        }
        this.view.setVisibility(8);
        this.loadedToSeek = false;
        this.trackSeconds = DefinitionKt.NO_Float_VALUE;
    }

    public final YoutubePlayerManager mute(boolean z) {
        this.muted = z;
        YouTubePlayer youTubePlayer = this.youtubePlayer;
        if (youTubePlayer != null) {
            if (z) {
                if (youTubePlayer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("youtubePlayer");
                    youTubePlayer = null;
                }
                youTubePlayer.mute();
                return this;
            }
            if (youTubePlayer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("youtubePlayer");
                youTubePlayer = null;
            }
            youTubePlayer.unMute();
        }
        return this;
    }

    public final YoutubePlayerManager enableVideoPlayback(boolean z) {
        this.playbackEnabled = z;
        String str = this.youtubeId;
        if (str != null) {
            loadVideo(str);
        }
        return this;
    }

    public final YoutubePlayerManager onPlaying(Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.playingCallback = callback;
        return this;
    }

    public final YoutubePlayerManager onStopped(Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.stoppedCallback = callback;
        return this;
    }

    public final YoutubePlayerManager onLinkReady(Function1<? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.linkReadyCallback = callback;
        return this;
    }
}
