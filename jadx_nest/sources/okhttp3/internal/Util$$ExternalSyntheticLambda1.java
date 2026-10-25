package okhttp3.internal;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class Util$$ExternalSyntheticLambda1 implements ThreadFactory {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ Util$$ExternalSyntheticLambda1(String str, boolean z) {
        this.f$0 = str;
        this.f$1 = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return Util.threadFactory$lambda$1(this.f$0, this.f$1, runnable);
    }
}
