package androidx.core.content;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes.dex */
public final /* synthetic */ class PackageManagerCompat$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ UnusedAppRestrictionsBackportServiceConnection f$0;

    public /* synthetic */ PackageManagerCompat$$ExternalSyntheticLambda0(UnusedAppRestrictionsBackportServiceConnection unusedAppRestrictionsBackportServiceConnection) {
        this.f$0 = unusedAppRestrictionsBackportServiceConnection;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.disconnectFromService();
    }
}
