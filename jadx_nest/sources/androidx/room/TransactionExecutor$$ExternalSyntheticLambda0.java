package androidx.room;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class TransactionExecutor$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ Runnable f$0;
    public final /* synthetic */ TransactionExecutor f$1;

    public /* synthetic */ TransactionExecutor$$ExternalSyntheticLambda0(Runnable runnable, TransactionExecutor transactionExecutor) {
        this.f$0 = runnable;
        this.f$1 = transactionExecutor;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TransactionExecutor.execute$lambda$1$lambda$0(this.f$0, this.f$1);
    }
}
