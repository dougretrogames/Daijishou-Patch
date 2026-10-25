package androidx.room;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class QueryInterceptorStatement$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ QueryInterceptorStatement f$0;

    public /* synthetic */ QueryInterceptorStatement$$ExternalSyntheticLambda1(QueryInterceptorStatement queryInterceptorStatement) {
        this.f$0 = queryInterceptorStatement;
    }

    @Override // java.lang.Runnable
    public final void run() {
        QueryInterceptorStatement.executeInsert$lambda$2(this.f$0);
    }
}
