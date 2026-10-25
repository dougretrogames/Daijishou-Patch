package androidx.navigation;

import android.os.Bundle;
import android.view.View;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class Navigation$$ExternalSyntheticLambda1 implements View.OnClickListener {
    public final /* synthetic */ int f$0;
    public final /* synthetic */ Bundle f$1;

    public /* synthetic */ Navigation$$ExternalSyntheticLambda1(int i, Bundle bundle) {
        this.f$0 = i;
        this.f$1 = bundle;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Navigation.createNavigateOnClickListener$lambda$0(this.f$0, this.f$1, view);
    }
}
