package androidx.room;

import androidx.sqlite.db.SupportSQLiteQuery;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class QueryInterceptorDatabase$$ExternalSyntheticLambda11 implements Runnable {
    public final /* synthetic */ QueryInterceptorDatabase f$0;
    public final /* synthetic */ SupportSQLiteQuery f$1;
    public final /* synthetic */ QueryInterceptorProgram f$2;

    public /* synthetic */ QueryInterceptorDatabase$$ExternalSyntheticLambda11(QueryInterceptorDatabase queryInterceptorDatabase, SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram) {
        this.f$0 = queryInterceptorDatabase;
        this.f$1 = supportSQLiteQuery;
        this.f$2 = queryInterceptorProgram;
    }

    @Override // java.lang.Runnable
    public final void run() {
        QueryInterceptorDatabase.query$lambda$9(this.f$0, this.f$1, this.f$2);
    }
}
