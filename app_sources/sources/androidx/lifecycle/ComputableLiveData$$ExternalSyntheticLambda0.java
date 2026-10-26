package androidx.lifecycle;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes.dex */
public final /* synthetic */ class ComputableLiveData$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ ComputableLiveData f$0;

    public /* synthetic */ ComputableLiveData$$ExternalSyntheticLambda0(ComputableLiveData computableLiveData) {
        this.f$0 = computableLiveData;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ComputableLiveData.refreshRunnable$lambda$0(this.f$0);
    }
}
