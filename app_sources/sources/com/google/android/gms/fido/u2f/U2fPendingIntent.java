package com.google.android.gms.fido.u2f;

import android.app.Activity;
import android.content.IntentSender;

/* INFO: compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
/* INFO: loaded from: classes3.dex */
@Deprecated
public interface U2fPendingIntent {
    boolean hasPendingIntent();

    void launchPendingIntent(Activity activity, int i) throws IntentSender.SendIntentException;
}
