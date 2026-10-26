package androidx.room;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class QueryInterceptorDatabase$$ExternalSyntheticLambda4 implements Runnable {
    public final /* synthetic */ QueryInterceptorDatabase f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ QueryInterceptorDatabase$$ExternalSyntheticLambda4(QueryInterceptorDatabase queryInterceptorDatabase, String str) {
        this.f$0 = queryInterceptorDatabase;
        this.f$1 = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        QueryInterceptorDatabase.execSQL$lambda$10(this.f$0, this.f$1);
    }
}
