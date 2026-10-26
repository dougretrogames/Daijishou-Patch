package androidx.room;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class QueryInterceptorDatabase$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ QueryInterceptorDatabase f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ Object[] f$2;

    public /* synthetic */ QueryInterceptorDatabase$$ExternalSyntheticLambda3(QueryInterceptorDatabase queryInterceptorDatabase, String str, Object[] objArr) {
        this.f$0 = queryInterceptorDatabase;
        this.f$1 = str;
        this.f$2 = objArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        QueryInterceptorDatabase.query$lambda$7(this.f$0, this.f$1, this.f$2);
    }
}
