package androidx.room;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class QueryInterceptorDatabase$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ QueryInterceptorDatabase f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ QueryInterceptorDatabase$$ExternalSyntheticLambda2(QueryInterceptorDatabase queryInterceptorDatabase, String str) {
        this.f$0 = queryInterceptorDatabase;
        this.f$1 = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        QueryInterceptorDatabase.query$lambda$6(this.f$0, this.f$1);
    }
}
