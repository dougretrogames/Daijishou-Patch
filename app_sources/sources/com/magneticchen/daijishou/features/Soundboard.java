package com.magneticchen.daijishou.features;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.live.SharedPreferenceBooleanLiveData;
import com.skydoves.balloon.internals.DefinitionKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Soundboard.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0011\u001a\u00020\u0010J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/magneticchen/daijishou/features/Soundboard;", "", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "(Lcom/magneticchen/daijishou/DaijishouApplication;)V", "getApplication", "()Lcom/magneticchen/daijishou/DaijishouApplication;", "defaultSharedPreferences", "Landroid/content/SharedPreferences;", "forcingSingleSfxSound", "", "makeButtonSound", "makeButtonSoundPreferenceLiveData", "Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;", "makeButtonSoundPreferenceLiveDataObserver", "Lkotlin/Function1;", "", "onDestroy", "play", "sound", "Lcom/magneticchen/daijishou/features/Soundboard$Sound;", "force", "Sound", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Soundboard {
    private final DaijishouApplication application;
    private final SharedPreferences defaultSharedPreferences;
    private boolean forcingSingleSfxSound;
    private boolean makeButtonSound;
    private final SharedPreferenceBooleanLiveData makeButtonSoundPreferenceLiveData;
    private final Function1<Boolean, Unit> makeButtonSoundPreferenceLiveDataObserver;

    public Soundboard(DaijishouApplication application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.application = application;
        SharedPreferences defaultSharedPreferences = application.getDefaultSharedPreferences();
        this.defaultSharedPreferences = defaultSharedPreferences;
        Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.features.Soundboard$makeButtonSoundPreferenceLiveDataObserver$1
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                Soundboard.this.makeButtonSound = z;
            }
        };
        this.makeButtonSoundPreferenceLiveDataObserver = function1;
        SharedPreferenceBooleanLiveData sharedPreferenceBooleanLiveData = new SharedPreferenceBooleanLiveData(defaultSharedPreferences, "make_button_sound", true);
        sharedPreferenceBooleanLiveData.observeForever(new Soundboard$sam$androidx_lifecycle_Observer$0(function1));
        this.makeButtonSoundPreferenceLiveData = sharedPreferenceBooleanLiveData;
    }

    public final DaijishouApplication getApplication() {
        return this.application;
    }

    public final void onDestroy() {
        this.makeButtonSoundPreferenceLiveData.removeObserver(new Soundboard$sam$androidx_lifecycle_Observer$0(this.makeButtonSoundPreferenceLiveDataObserver));
    }

    public static /* synthetic */ void play$default(Soundboard soundboard, Sound sound, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        soundboard.play(sound, z);
    }

    public final void play(Sound sound, boolean z) {
        Intrinsics.checkNotNullParameter(sound, "sound");
        if (this.forcingSingleSfxSound) {
            return;
        }
        if (z) {
            this.forcingSingleSfxSound = true;
            Iterator<Sound> it = Sound.getEntries().iterator();
            while (it.hasNext()) {
                it.next().getMediaPlayer(this.application).setVolume(DefinitionKt.NO_Float_VALUE, DefinitionKt.NO_Float_VALUE);
            }
        }
        if (this.makeButtonSound) {
            MediaPlayer mediaPlayer = sound.getMediaPlayer(this.application);
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.magneticchen.daijishou.features.Soundboard$$ExternalSyntheticLambda0
                @Override // android.media.MediaPlayer.OnCompletionListener
                public final void onCompletion(MediaPlayer mediaPlayer2) {
                    Soundboard.play$lambda$2(Soundboard.this, mediaPlayer2);
                }
            });
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
            }
            mediaPlayer.seekTo(0);
            mediaPlayer.setVolume(1.0f, 1.0f);
            mediaPlayer.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void play$lambda$2(Soundboard this$0, MediaPlayer mediaPlayer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.forcingSingleSfxSound = false;
    }

    /* JADX INFO: compiled from: Soundboard.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/magneticchen/daijishou/features/Soundboard$Sound;", "", "resId", "", "(Ljava/lang/String;II)V", "player", "Landroid/media/MediaPlayer;", "getResId", "()I", "getMediaPlayer", "context", "Landroid/content/Context;", "NAVIGATION", "REACH_BOUND", "BACK", "TOGGLE", "POPUP", "PLAY", "SEARCH", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public enum Sound {
        NAVIGATION(R.raw.navigation),
        REACH_BOUND(R.raw.back),
        BACK(R.raw.back),
        TOGGLE(R.raw.accept),
        POPUP(R.raw.wooden),
        PLAY(R.raw.play),
        SEARCH(R.raw.accept);

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        private MediaPlayer player;
        private final int resId;

        public static EnumEntries<Sound> getEntries() {
            return $ENTRIES;
        }

        Sound(int i) {
            this.resId = i;
        }

        public final int getResId() {
            return this.resId;
        }

        public final MediaPlayer getMediaPlayer(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (this.player == null) {
                this.player = MediaPlayer.create(context, this.resId);
            }
            MediaPlayer mediaPlayer = this.player;
            Intrinsics.checkNotNull(mediaPlayer);
            return mediaPlayer;
        }
    }
}
