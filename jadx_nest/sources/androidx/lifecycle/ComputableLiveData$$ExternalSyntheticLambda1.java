package androidx.lifecycle;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ComputableLiveData$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ ComputableLiveData f$0;

    public /* synthetic */ ComputableLiveData$$ExternalSyntheticLambda1(ComputableLiveData computableLiveData) {
        this.f$0 = computableLiveData;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ComputableLiveData.invalidationRunnable$lambda$1(this.f$0);
    }
}
