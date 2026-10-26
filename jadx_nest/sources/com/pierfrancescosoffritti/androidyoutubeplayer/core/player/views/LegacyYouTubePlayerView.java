package com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.FullscreenListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerCallback;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.NetworkObserver;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.PlaybackResumer;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: LegacyYouTubePlayerView.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\rJ\u000e\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\"J\u0010\u0010'\u001a\u00020(2\b\b\u0001\u0010)\u001a\u00020\nJ\u000e\u0010\u0011\u001a\u00020\u00132\u0006\u0010*\u001a\u00020+J\u0016\u0010\u0011\u001a\u00020\u00132\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\rJ\u001e\u0010\u0011\u001a\u00020\u00132\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020.J(\u0010\u0011\u001a\u00020\u00132\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100J\r\u00101\u001a\u00020\rH\u0000¢\u0006\u0002\b2J\r\u00103\u001a\u00020\u0013H\u0000¢\u0006\u0002\b4J\r\u00105\u001a\u00020\u0013H\u0000¢\u0006\u0002\b6J\u0006\u00107\u001a\u00020\u0013J\u000e\u00108\u001a\u00020\u00132\u0006\u00109\u001a\u00020(R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u001dX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/LegacyYouTubePlayerView;", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/SixteenByNineFrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/FullscreenListener;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/FullscreenListener;Landroid/util/AttributeSet;I)V", "<set-?>", "", "canPlay", "getCanPlay$core_release", "()Z", "initialize", "Lkotlin/Function0;", "", "isYouTubePlayerReady", "isYouTubePlayerReady$core_release", "setYouTubePlayerReady$core_release", "(Z)V", "networkObserver", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/utils/NetworkObserver;", "playbackResumer", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/utils/PlaybackResumer;", "webViewYouTubePlayer", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/WebViewYouTubePlayer;", "getWebViewYouTubePlayer$core_release", "()Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/WebViewYouTubePlayer;", "youTubePlayerCallbacks", "", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/YouTubePlayerCallback;", "enableBackgroundPlayback", "enable", "getYouTubePlayerWhenReady", "youTubePlayerCallback", "inflateCustomPlayerUi", "Landroid/view/View;", "layoutId", "youTubePlayerListener", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/YouTubePlayerListener;", "handleNetworkEvents", "playerOptions", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/options/IFramePlayerOptions;", "videoId", "", "isEligibleForPlayback", "isEligibleForPlayback$core_release", "onResume", "onResume$core_release", "onStop", "onStop$core_release", "release", "setCustomPlayerUi", "view", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LegacyYouTubePlayerView extends SixteenByNineFrameLayout {
    private boolean canPlay;
    private Function0<Unit> initialize;
    private boolean isYouTubePlayerReady;
    private final NetworkObserver networkObserver;
    private final PlaybackResumer playbackResumer;
    private final WebViewYouTubePlayer webViewYouTubePlayer;
    private final Set<YouTubePlayerCallback> youTubePlayerCallbacks;

    public /* synthetic */ LegacyYouTubePlayerView(Context context, FullscreenListener fullscreenListener, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, fullscreenListener, (i2 & 4) != 0 ? null : attributeSet, (i2 & 8) != 0 ? 0 : i);
    }

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LegacyYouTubePlayerView(Context context, FullscreenListener listener, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        WebViewYouTubePlayer webViewYouTubePlayer = new WebViewYouTubePlayer(context, listener, null, 0, 12, null);
        this.webViewYouTubePlayer = webViewYouTubePlayer;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        NetworkObserver networkObserver = new NetworkObserver(applicationContext);
        this.networkObserver = networkObserver;
        PlaybackResumer playbackResumer = new PlaybackResumer();
        this.playbackResumer = playbackResumer;
        this.initialize = C02931.INSTANCE;
        this.youTubePlayerCallbacks = new LinkedHashSet();
        this.canPlay = true;
        addView(webViewYouTubePlayer, new FrameLayout.LayoutParams(-1, -1));
        webViewYouTubePlayer.addListener(playbackResumer);
        webViewYouTubePlayer.addListener(new AnonymousClass1());
        webViewYouTubePlayer.addListener(new AnonymousClass2());
        networkObserver.getListeners().add(new AnonymousClass3());
    }

    /* WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LegacyYouTubePlayerView(Context context) {
        this(context, FakeWebViewYouTubeListener.INSTANCE, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* INFO: renamed from: getWebViewYouTubePlayer$core_release, reason: from getter */
    public final WebViewYouTubePlayer getWebViewYouTubePlayer() {
        return this.webViewYouTubePlayer;
    }

    /* INFO: renamed from: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.LegacyYouTubePlayerView$initialize$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: LegacyYouTubePlayerView.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C02931 extends Lambda implements Function0<Unit> {
        public static final C02931 INSTANCE = new C02931();

        C02931() {
            super(0);
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    /* INFO: renamed from: isYouTubePlayerReady$core_release, reason: from getter */
    public final boolean getIsYouTubePlayerReady() {
        return this.isYouTubePlayerReady;
    }

    public final void setYouTubePlayerReady$core_release(boolean z) {
        this.isYouTubePlayerReady = z;
    }

    /* INFO: renamed from: getCanPlay$core_release, reason: from getter */
    public final boolean getCanPlay() {
        return this.canPlay;
    }

    /* INFO: renamed from: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.LegacyYouTubePlayerView$1, reason: invalid class name */
    /* INFO: compiled from: LegacyYouTubePlayerView.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/LegacyYouTubePlayerView$1", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/AbstractYouTubePlayerListener;", "onStateChange", "", "youTubePlayer", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;", "state", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerState;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass1 extends AbstractYouTubePlayerListener {
        AnonymousClass1() {
        }

        @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener, com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
        public void onStateChange(YouTubePlayer youTubePlayer, PlayerConstants.PlayerState state) {
            Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
            Intrinsics.checkNotNullParameter(state, "state");
            if (state != PlayerConstants.PlayerState.PLAYING || LegacyYouTubePlayerView.this.isEligibleForPlayback$core_release()) {
                return;
            }
            youTubePlayer.pause();
        }
    }

    /* INFO: renamed from: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.LegacyYouTubePlayerView$2, reason: invalid class name */
    /* INFO: compiled from: LegacyYouTubePlayerView.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/LegacyYouTubePlayerView$2", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/AbstractYouTubePlayerListener;", "onReady", "", "youTubePlayer", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass2 extends AbstractYouTubePlayerListener {
        AnonymousClass2() {
        }

        @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener, com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
        public void onReady(YouTubePlayer youTubePlayer) {
            Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
            LegacyYouTubePlayerView.this.setYouTubePlayerReady$core_release(true);
            Iterator it = LegacyYouTubePlayerView.this.youTubePlayerCallbacks.iterator();
            while (it.hasNext()) {
                ((YouTubePlayerCallback) it.next()).onYouTubePlayer(youTubePlayer);
            }
            LegacyYouTubePlayerView.this.youTubePlayerCallbacks.clear();
            youTubePlayer.removeListener(this);
        }
    }

    /* INFO: renamed from: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.LegacyYouTubePlayerView$3, reason: invalid class name */
    /* INFO: compiled from: LegacyYouTubePlayerView.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/LegacyYouTubePlayerView$3", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/utils/NetworkObserver$Listener;", "onNetworkAvailable", "", "onNetworkUnavailable", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass3 implements NetworkObserver.Listener {
        @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.NetworkObserver.Listener
        public void onNetworkUnavailable() {
        }

        AnonymousClass3() {
        }

        @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.NetworkObserver.Listener
        public void onNetworkAvailable() {
            if (!LegacyYouTubePlayerView.this.getIsYouTubePlayerReady()) {
                LegacyYouTubePlayerView.this.initialize.invoke();
            } else {
                LegacyYouTubePlayerView.this.playbackResumer.resume(LegacyYouTubePlayerView.this.getWebViewYouTubePlayer().getYoutubePlayer$core_release());
            }
        }
    }

    public final void initialize(YouTubePlayerListener youTubePlayerListener, boolean handleNetworkEvents, IFramePlayerOptions playerOptions, String videoId) {
        Intrinsics.checkNotNullParameter(youTubePlayerListener, "youTubePlayerListener");
        Intrinsics.checkNotNullParameter(playerOptions, "playerOptions");
        if (this.isYouTubePlayerReady) {
            throw new IllegalStateException("This YouTubePlayerView has already been initialized.");
        }
        if (handleNetworkEvents) {
            this.networkObserver.observeNetwork();
        }
        C02942 c02942 = new C02942(playerOptions, videoId, youTubePlayerListener);
        this.initialize = c02942;
        if (handleNetworkEvents) {
            return;
        }
        c02942.invoke();
    }

    /* INFO: renamed from: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.LegacyYouTubePlayerView$initialize$2, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: LegacyYouTubePlayerView.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C02942 extends Lambda implements Function0<Unit> {
        final /* synthetic */ IFramePlayerOptions $playerOptions;
        final /* synthetic */ String $videoId;
        final /* synthetic */ YouTubePlayerListener $youTubePlayerListener;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02942(IFramePlayerOptions iFramePlayerOptions, String str, YouTubePlayerListener youTubePlayerListener) {
            super(0);
            this.$playerOptions = iFramePlayerOptions;
            this.$videoId = str;
            this.$youTubePlayerListener = youTubePlayerListener;
        }

        /* INFO: renamed from: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.LegacyYouTubePlayerView$initialize$2$1, reason: invalid class name */
        /* INFO: compiled from: LegacyYouTubePlayerView.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
        static final class AnonymousClass1 extends Lambda implements Function1<YouTubePlayer, Unit> {
            final /* synthetic */ YouTubePlayerListener $youTubePlayerListener;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(YouTubePlayerListener youTubePlayerListener) {
                super(1);
                this.$youTubePlayerListener = youTubePlayerListener;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(YouTubePlayer youTubePlayer) {
                invoke2(youTubePlayer);
                return Unit.INSTANCE;
            }

            /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(YouTubePlayer it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.addListener(this.$youTubePlayerListener);
            }
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            LegacyYouTubePlayerView.this.getWebViewYouTubePlayer().initialize$core_release(new AnonymousClass1(this.$youTubePlayerListener), this.$playerOptions, this.$videoId);
        }
    }

    public final void initialize(YouTubePlayerListener youTubePlayerListener, boolean handleNetworkEvents, IFramePlayerOptions playerOptions) {
        Intrinsics.checkNotNullParameter(youTubePlayerListener, "youTubePlayerListener");
        Intrinsics.checkNotNullParameter(playerOptions, "playerOptions");
        initialize(youTubePlayerListener, handleNetworkEvents, playerOptions, null);
    }

    public final void initialize(YouTubePlayerListener youTubePlayerListener, boolean handleNetworkEvents) {
        Intrinsics.checkNotNullParameter(youTubePlayerListener, "youTubePlayerListener");
        initialize(youTubePlayerListener, handleNetworkEvents, IFramePlayerOptions.INSTANCE.getDefault());
    }

    public final void initialize(YouTubePlayerListener youTubePlayerListener) {
        Intrinsics.checkNotNullParameter(youTubePlayerListener, "youTubePlayerListener");
        initialize(youTubePlayerListener, true);
    }

    public final void getYouTubePlayerWhenReady(YouTubePlayerCallback youTubePlayerCallback) {
        Intrinsics.checkNotNullParameter(youTubePlayerCallback, "youTubePlayerCallback");
        if (this.isYouTubePlayerReady) {
            youTubePlayerCallback.onYouTubePlayer(this.webViewYouTubePlayer.getYoutubePlayer$core_release());
        } else {
            this.youTubePlayerCallbacks.add(youTubePlayerCallback);
        }
    }

    public final View inflateCustomPlayerUi(int layoutId) {
        removeViews(1, getChildCount() - 1);
        View viewInflate = View.inflate(getContext(), layoutId, this);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(context, layoutId, this)");
        return viewInflate;
    }

    public final void setCustomPlayerUi(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        removeViews(1, getChildCount() - 1);
        addView(view);
    }

    public final void release() {
        this.networkObserver.destroy();
        removeView(this.webViewYouTubePlayer);
        this.webViewYouTubePlayer.removeAllViews();
        this.webViewYouTubePlayer.destroy();
    }

    public final void onResume$core_release() {
        this.playbackResumer.onLifecycleResume();
        this.canPlay = true;
    }

    public final void onStop$core_release() {
        this.webViewYouTubePlayer.getYoutubePlayer$core_release().pause();
        this.playbackResumer.onLifecycleStop();
        this.canPlay = false;
    }

    public final boolean isEligibleForPlayback$core_release() {
        return this.canPlay || this.webViewYouTubePlayer.getIsBackgroundPlaybackEnabled();
    }

    public final void enableBackgroundPlayback(boolean enable) {
        this.webViewYouTubePlayer.setBackgroundPlaybackEnabled$core_release(enable);
    }
}
