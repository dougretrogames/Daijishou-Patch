package androidx.fragment.app.strictmode;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FragmentStrictMode$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ FragmentStrictMode.Policy f$0;
    public final /* synthetic */ Violation f$1;

    public /* synthetic */ FragmentStrictMode$$ExternalSyntheticLambda0(FragmentStrictMode.Policy policy, Violation violation) {
        this.f$0 = policy;
        this.f$1 = violation;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FragmentStrictMode.handlePolicyViolation$lambda$0(this.f$0, this.f$1);
    }
}
