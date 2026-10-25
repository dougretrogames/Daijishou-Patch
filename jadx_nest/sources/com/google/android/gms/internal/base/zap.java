package com.google.android.gms.internal.base;

import android.os.Build;
import com.google.api.client.googleapis.media.MediaHttpDownloader;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zap {
    public static final int zaa;

    static {
        zaa = Build.VERSION.SDK_INT >= 31 ? MediaHttpDownloader.MAXIMUM_CHUNK_SIZE : 0;
    }
}
