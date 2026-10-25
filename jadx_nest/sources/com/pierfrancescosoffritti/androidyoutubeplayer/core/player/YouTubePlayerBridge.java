package com.pierfrancescosoffritti.androidyoutubeplayer.core.player;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.exifinterface.media.ExifInterface;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: YouTubePlayerBridge.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0007\u0018\u0000 $2\u00020\u0001:\u0002$%B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nH\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nH\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\nH\u0007J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\nH\u0007J\b\u0010\u001a\u001a\u00020\u0015H\u0007J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\nH\u0007J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\nH\u0007J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\nH\u0007J\u0010\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\nH\u0007J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\nH\u0007J\b\u0010#\u001a\u00020\u0015H\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayerBridge;", "", "youTubePlayerOwner", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayerBridge$YouTubePlayerBridgeCallbacks;", "(Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayerBridge$YouTubePlayerBridgeCallbacks;)V", "mainThreadHandler", "Landroid/os/Handler;", "parsePlaybackQuality", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlaybackQuality;", "quality", "", "parsePlaybackRate", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlaybackRate;", "rate", "parsePlayerError", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerError;", "error", "parsePlayerState", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerState;", "state", "sendApiChange", "", "sendError", "", "sendPlaybackQualityChange", "sendPlaybackRateChange", "sendReady", "sendStateChange", "sendVideoCurrentTime", "seconds", "sendVideoDuration", "sendVideoId", "videoId", "sendVideoLoadedFraction", "fraction", "sendYouTubeIFrameAPIReady", "Companion", "YouTubePlayerBridgeCallbacks", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class YouTubePlayerBridge {
    private static final String ERROR_HTML_5_PLAYER = "5";
    private static final String ERROR_INVALID_PARAMETER_IN_REQUEST = "2";
    private static final String ERROR_VIDEO_NOT_FOUND = "100";
    private static final String ERROR_VIDEO_NOT_PLAYABLE_IN_EMBEDDED_PLAYER1 = "101";
    private static final String ERROR_VIDEO_NOT_PLAYABLE_IN_EMBEDDED_PLAYER2 = "150";
    private static final String QUALITY_DEFAULT = "default";
    private static final String QUALITY_HD1080 = "hd1080";
    private static final String QUALITY_HD720 = "hd720";
    private static final String QUALITY_HIGH_RES = "highres";
    private static final String QUALITY_LARGE = "large";
    private static final String QUALITY_MEDIUM = "medium";
    private static final String QUALITY_SMALL = "small";
    private static final String RATE_0_25 = "0.25";
    private static final String RATE_0_5 = "0.5";
    private static final String RATE_0_75 = "0.75";
    private static final String RATE_1 = "1";
    private static final String RATE_1_25 = "1.25";
    private static final String RATE_1_5 = "1.5";
    private static final String RATE_1_75 = "1.75";
    private static final String RATE_2 = "2";
    private static final String STATE_BUFFERING = "BUFFERING";
    private static final String STATE_CUED = "CUED";
    private static final String STATE_ENDED = "ENDED";
    private static final String STATE_PAUSED = "PAUSED";
    private static final String STATE_PLAYING = "PLAYING";
    private static final String STATE_UNSTARTED = "UNSTARTED";
    private final Handler mainThreadHandler;
    private final YouTubePlayerBridgeCallbacks youTubePlayerOwner;

    /* JADX INFO: compiled from: YouTubePlayerBridge.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayerBridge$YouTubePlayerBridgeCallbacks;", "", "listeners", "", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/YouTubePlayerListener;", "getListeners", "()Ljava/util/Collection;", "getInstance", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;", "onYouTubeIFrameAPIReady", "", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface YouTubePlayerBridgeCallbacks {
        YouTubePlayer getInstance();

        Collection<YouTubePlayerListener> getListeners();

        void onYouTubeIFrameAPIReady();
    }

    public YouTubePlayerBridge(YouTubePlayerBridgeCallbacks youTubePlayerOwner) {
        Intrinsics.checkNotNullParameter(youTubePlayerOwner, "youTubePlayerOwner");
        this.youTubePlayerOwner = youTubePlayerOwner;
        this.mainThreadHandler = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendYouTubeIFrameAPIReady$lambda$0(YouTubePlayerBridge this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.youTubePlayerOwner.onYouTubeIFrameAPIReady();
    }

    @JavascriptInterface
    public final boolean sendYouTubeIFrameAPIReady() {
        return this.mainThreadHandler.post(new YouTubePlayerBridge$$ExternalSyntheticLambda1(this));
    }

    @JavascriptInterface
    public final boolean sendReady() {
        return this.mainThreadHandler.post(new YouTubePlayerBridge$$ExternalSyntheticLambda7(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendReady$lambda$2(YouTubePlayerBridge this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator<T> it = this$0.youTubePlayerOwner.getListeners().iterator();
        while (it.hasNext()) {
            ((YouTubePlayerListener) it.next()).onReady(this$0.youTubePlayerOwner.getInstance());
        }
    }

    @JavascriptInterface
    public final void sendStateChange(String state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.mainThreadHandler.post(new YouTubePlayerBridge$$ExternalSyntheticLambda10(this, parsePlayerState(state)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendStateChange$lambda$4(YouTubePlayerBridge this$0, PlayerConstants.PlayerState playerState) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(playerState, "$playerState");
        Iterator<T> it = this$0.youTubePlayerOwner.getListeners().iterator();
        while (it.hasNext()) {
            ((YouTubePlayerListener) it.next()).onStateChange(this$0.youTubePlayerOwner.getInstance(), playerState);
        }
    }

    @JavascriptInterface
    public final void sendPlaybackQualityChange(String quality) {
        Intrinsics.checkNotNullParameter(quality, "quality");
        this.mainThreadHandler.post(new YouTubePlayerBridge$$ExternalSyntheticLambda2(this, parsePlaybackQuality(quality)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendPlaybackQualityChange$lambda$6(YouTubePlayerBridge this$0, PlayerConstants.PlaybackQuality playbackQuality) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(playbackQuality, "$playbackQuality");
        Iterator<T> it = this$0.youTubePlayerOwner.getListeners().iterator();
        while (it.hasNext()) {
            ((YouTubePlayerListener) it.next()).onPlaybackQualityChange(this$0.youTubePlayerOwner.getInstance(), playbackQuality);
        }
    }

    @JavascriptInterface
    public final void sendPlaybackRateChange(String rate) {
        Intrinsics.checkNotNullParameter(rate, "rate");
        this.mainThreadHandler.post(new YouTubePlayerBridge$$ExternalSyntheticLambda4(this, parsePlaybackRate(rate)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendPlaybackRateChange$lambda$8(YouTubePlayerBridge this$0, PlayerConstants.PlaybackRate playbackRate) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(playbackRate, "$playbackRate");
        Iterator<T> it = this$0.youTubePlayerOwner.getListeners().iterator();
        while (it.hasNext()) {
            ((YouTubePlayerListener) it.next()).onPlaybackRateChange(this$0.youTubePlayerOwner.getInstance(), playbackRate);
        }
    }

    @JavascriptInterface
    public final void sendError(String error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.mainThreadHandler.post(new YouTubePlayerBridge$$ExternalSyntheticLambda9(this, parsePlayerError(error)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendError$lambda$10(YouTubePlayerBridge this$0, PlayerConstants.PlayerError playerError) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(playerError, "$playerError");
        Iterator<T> it = this$0.youTubePlayerOwner.getListeners().iterator();
        while (it.hasNext()) {
            ((YouTubePlayerListener) it.next()).onError(this$0.youTubePlayerOwner.getInstance(), playerError);
        }
    }

    @JavascriptInterface
    public final boolean sendApiChange() {
        return this.mainThreadHandler.post(new YouTubePlayerBridge$$ExternalSyntheticLambda6(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendApiChange$lambda$12(YouTubePlayerBridge this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator<T> it = this$0.youTubePlayerOwner.getListeners().iterator();
        while (it.hasNext()) {
            ((YouTubePlayerListener) it.next()).onApiChange(this$0.youTubePlayerOwner.getInstance());
        }
    }

    @JavascriptInterface
    public final void sendVideoCurrentTime(String seconds) {
        Intrinsics.checkNotNullParameter(seconds, "seconds");
        try {
            this.mainThreadHandler.post(new YouTubePlayerBridge$$ExternalSyntheticLambda0(this, Float.parseFloat(seconds)));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendVideoCurrentTime$lambda$14(YouTubePlayerBridge this$0, float f) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator<T> it = this$0.youTubePlayerOwner.getListeners().iterator();
        while (it.hasNext()) {
            ((YouTubePlayerListener) it.next()).onCurrentSecond(this$0.youTubePlayerOwner.getInstance(), f);
        }
    }

    @JavascriptInterface
    public final void sendVideoDuration(String seconds) {
        Intrinsics.checkNotNullParameter(seconds, "seconds");
        try {
            if (TextUtils.isEmpty(seconds)) {
                seconds = "0";
            }
            this.mainThreadHandler.post(new YouTubePlayerBridge$$ExternalSyntheticLambda3(this, Float.parseFloat(seconds)));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendVideoDuration$lambda$16(YouTubePlayerBridge this$0, float f) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator<T> it = this$0.youTubePlayerOwner.getListeners().iterator();
        while (it.hasNext()) {
            ((YouTubePlayerListener) it.next()).onVideoDuration(this$0.youTubePlayerOwner.getInstance(), f);
        }
    }

    @JavascriptInterface
    public final void sendVideoLoadedFraction(String fraction) {
        Intrinsics.checkNotNullParameter(fraction, "fraction");
        try {
            this.mainThreadHandler.post(new YouTubePlayerBridge$$ExternalSyntheticLambda8(this, Float.parseFloat(fraction)));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendVideoLoadedFraction$lambda$18(YouTubePlayerBridge this$0, float f) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator<T> it = this$0.youTubePlayerOwner.getListeners().iterator();
        while (it.hasNext()) {
            ((YouTubePlayerListener) it.next()).onVideoLoadedFraction(this$0.youTubePlayerOwner.getInstance(), f);
        }
    }

    @JavascriptInterface
    public final boolean sendVideoId(String videoId) {
        Intrinsics.checkNotNullParameter(videoId, "videoId");
        return this.mainThreadHandler.post(new YouTubePlayerBridge$$ExternalSyntheticLambda5(this, videoId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendVideoId$lambda$20(YouTubePlayerBridge this$0, String videoId) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(videoId, "$videoId");
        Iterator<T> it = this$0.youTubePlayerOwner.getListeners().iterator();
        while (it.hasNext()) {
            ((YouTubePlayerListener) it.next()).onVideoId(this$0.youTubePlayerOwner.getInstance(), videoId);
        }
    }

    private final PlayerConstants.PlayerState parsePlayerState(String state) {
        if (StringsKt.equals(state, STATE_UNSTARTED, true)) {
            return PlayerConstants.PlayerState.UNSTARTED;
        }
        if (StringsKt.equals(state, STATE_ENDED, true)) {
            return PlayerConstants.PlayerState.ENDED;
        }
        if (StringsKt.equals(state, STATE_PLAYING, true)) {
            return PlayerConstants.PlayerState.PLAYING;
        }
        if (StringsKt.equals(state, STATE_PAUSED, true)) {
            return PlayerConstants.PlayerState.PAUSED;
        }
        if (StringsKt.equals(state, STATE_BUFFERING, true)) {
            return PlayerConstants.PlayerState.BUFFERING;
        }
        return StringsKt.equals(state, STATE_CUED, true) ? PlayerConstants.PlayerState.VIDEO_CUED : PlayerConstants.PlayerState.UNKNOWN;
    }

    private final PlayerConstants.PlaybackQuality parsePlaybackQuality(String quality) {
        if (StringsKt.equals(quality, QUALITY_SMALL, true)) {
            return PlayerConstants.PlaybackQuality.SMALL;
        }
        if (StringsKt.equals(quality, QUALITY_MEDIUM, true)) {
            return PlayerConstants.PlaybackQuality.MEDIUM;
        }
        if (StringsKt.equals(quality, QUALITY_LARGE, true)) {
            return PlayerConstants.PlaybackQuality.LARGE;
        }
        if (StringsKt.equals(quality, QUALITY_HD720, true)) {
            return PlayerConstants.PlaybackQuality.HD720;
        }
        if (StringsKt.equals(quality, QUALITY_HD1080, true)) {
            return PlayerConstants.PlaybackQuality.HD1080;
        }
        if (StringsKt.equals(quality, QUALITY_HIGH_RES, true)) {
            return PlayerConstants.PlaybackQuality.HIGH_RES;
        }
        return StringsKt.equals(quality, "default", true) ? PlayerConstants.PlaybackQuality.DEFAULT : PlayerConstants.PlaybackQuality.UNKNOWN;
    }

    private final PlayerConstants.PlaybackRate parsePlaybackRate(String rate) {
        if (StringsKt.equals(rate, RATE_0_25, true)) {
            return PlayerConstants.PlaybackRate.RATE_0_25;
        }
        if (StringsKt.equals(rate, RATE_0_5, true)) {
            return PlayerConstants.PlaybackRate.RATE_0_5;
        }
        if (StringsKt.equals(rate, RATE_0_75, true)) {
            return PlayerConstants.PlaybackRate.RATE_0_75;
        }
        if (StringsKt.equals(rate, RATE_1, true)) {
            return PlayerConstants.PlaybackRate.RATE_1;
        }
        if (StringsKt.equals(rate, RATE_1_25, true)) {
            return PlayerConstants.PlaybackRate.RATE_1_25;
        }
        if (StringsKt.equals(rate, RATE_1_5, true)) {
            return PlayerConstants.PlaybackRate.RATE_1_5;
        }
        if (StringsKt.equals(rate, RATE_1_75, true)) {
            return PlayerConstants.PlaybackRate.RATE_1_75;
        }
        return StringsKt.equals(rate, ExifInterface.GPS_MEASUREMENT_2D, true) ? PlayerConstants.PlaybackRate.RATE_2 : PlayerConstants.PlaybackRate.UNKNOWN;
    }

    private final PlayerConstants.PlayerError parsePlayerError(String error) {
        if (StringsKt.equals(error, ExifInterface.GPS_MEASUREMENT_2D, true)) {
            return PlayerConstants.PlayerError.INVALID_PARAMETER_IN_REQUEST;
        }
        if (StringsKt.equals(error, "5", true)) {
            return PlayerConstants.PlayerError.HTML_5_PLAYER;
        }
        if (StringsKt.equals(error, ERROR_VIDEO_NOT_FOUND, true)) {
            return PlayerConstants.PlayerError.VIDEO_NOT_FOUND;
        }
        if (!StringsKt.equals(error, ERROR_VIDEO_NOT_PLAYABLE_IN_EMBEDDED_PLAYER1, true) && !StringsKt.equals(error, ERROR_VIDEO_NOT_PLAYABLE_IN_EMBEDDED_PLAYER2, true)) {
            return PlayerConstants.PlayerError.UNKNOWN;
        }
        return PlayerConstants.PlayerError.VIDEO_NOT_PLAYABLE_IN_EMBEDDED_PLAYER;
    }
}
