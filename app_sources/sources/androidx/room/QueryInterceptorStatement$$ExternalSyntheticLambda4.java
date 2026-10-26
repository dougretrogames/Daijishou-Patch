package androidx.room;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class QueryInterceptorStatement$$ExternalSyntheticLambda4 implements Runnable {
    public final /* synthetic */ QueryInterceptorStatement f$0;

    public /* synthetic */ QueryInterceptorStatement$$ExternalSyntheticLambda4(QueryInterceptorStatement queryInterceptorStatement) {
        this.f$0 = queryInterceptorStatement;
    }

    @Override // java.lang.Runnable
    public final void run() {
        QueryInterceptorStatement.executeUpdateDelete$lambda$1(this.f$0);
    }
}
