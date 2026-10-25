package androidx.navigation.ui;

import android.view.View;
import androidx.navigation.NavController;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class NavigationUI$$ExternalSyntheticLambda3 implements View.OnClickListener {
    public final /* synthetic */ NavController f$0;
    public final /* synthetic */ AppBarConfiguration f$1;

    public /* synthetic */ NavigationUI$$ExternalSyntheticLambda3(NavController navController, AppBarConfiguration appBarConfiguration) {
        this.f$0 = navController;
        this.f$1 = appBarConfiguration;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        NavigationUI.setupWithNavController$lambda$2(this.f$0, this.f$1, view);
    }
}
