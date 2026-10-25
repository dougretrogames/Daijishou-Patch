package androidx.navigation;

import android.view.View;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class Navigation$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ NavDirections f$0;

    public /* synthetic */ Navigation$$ExternalSyntheticLambda0(NavDirections navDirections) {
        this.f$0 = navDirections;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Navigation.createNavigateOnClickListener$lambda$1(this.f$0, view);
    }
}
