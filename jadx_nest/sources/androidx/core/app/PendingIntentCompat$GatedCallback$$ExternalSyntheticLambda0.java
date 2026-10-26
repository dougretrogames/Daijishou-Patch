package androidx.core.app;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes.dex */
public final /* synthetic */ class PendingIntentCompat$GatedCallback$$ExternalSyntheticLambda0 implements PendingIntent.OnFinished {
    public final /* synthetic */ PendingIntentCompat.GatedCallback f$0;

    public /* synthetic */ PendingIntentCompat$GatedCallback$$ExternalSyntheticLambda0(PendingIntentCompat.GatedCallback gatedCallback) {
        this.f$0 = gatedCallback;
    }

    @Override // android.app.PendingIntent.OnFinished
    public final void onSendFinished(PendingIntent pendingIntent, Intent intent, int i, String str, Bundle bundle) {
        this.f$0.onSendFinished(pendingIntent, intent, i, str, bundle);
    }
}
