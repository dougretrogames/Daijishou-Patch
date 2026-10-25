package androidx.emoji2.text;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ConcurrencyHelpers$$ExternalSyntheticLambda1 implements ThreadFactory {
    public final /* synthetic */ String f$0;

    public /* synthetic */ ConcurrencyHelpers$$ExternalSyntheticLambda1(String str) {
        this.f$0 = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return ConcurrencyHelpers.lambda$createBackgroundPriorityExecutor$0(this.f$0, runnable);
    }
}
