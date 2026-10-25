package androidx.navigation.ui;

import android.view.MenuItem;
import androidx.navigation.NavController;
import com.google.android.material.navigation.NavigationBarView;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class NavigationUI$$ExternalSyntheticLambda4 implements NavigationBarView.OnItemSelectedListener {
    public final /* synthetic */ NavController f$0;

    public /* synthetic */ NavigationUI$$ExternalSyntheticLambda4(NavController navController) {
        this.f$0 = navController;
    }

    @Override // com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
    public final boolean onNavigationItemSelected(MenuItem menuItem) {
        return NavigationUI.setupWithNavController$lambda$6(this.f$0, menuItem);
    }
}
