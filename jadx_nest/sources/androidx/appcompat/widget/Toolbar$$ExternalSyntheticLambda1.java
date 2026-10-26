package androidx.appcompat.widget;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes.dex */
public final /* synthetic */ class Toolbar$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ Toolbar f$0;

    public /* synthetic */ Toolbar$$ExternalSyntheticLambda1(Toolbar toolbar) {
        this.f$0 = toolbar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.invalidateMenu();
    }
}
