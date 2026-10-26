package com.magneticchen.daijishou;

import android.media.MediaPlayer;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class DaijishouApplication$$ExternalSyntheticLambda1 implements MediaPlayer.OnCompletionListener {
    public final /* synthetic */ DaijishouApplication f$0;

    public /* synthetic */ DaijishouApplication$$ExternalSyntheticLambda1(DaijishouApplication daijishouApplication) {
        this.f$0 = daijishouApplication;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        try {
            DaijishouApplication.playSfx$lambda$5$lambda$4(this.f$0, mediaPlayer);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
