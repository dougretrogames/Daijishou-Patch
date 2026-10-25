package androidx.room;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class QueryInterceptorDatabase$$ExternalSyntheticLambda6 implements Runnable {
    public final /* synthetic */ QueryInterceptorDatabase f$0;

    public /* synthetic */ QueryInterceptorDatabase$$ExternalSyntheticLambda6(QueryInterceptorDatabase queryInterceptorDatabase) {
        this.f$0 = queryInterceptorDatabase;
    }

    @Override // java.lang.Runnable
    public final void run() {
        QueryInterceptorDatabase.setTransactionSuccessful$lambda$5(this.f$0);
    }
}
