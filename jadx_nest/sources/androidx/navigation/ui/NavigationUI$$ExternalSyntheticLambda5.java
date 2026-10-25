package androidx.navigation.ui;

import android.view.MenuItem;
import androidx.navigation.NavController;
import com.google.android.material.navigation.NavigationView;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class NavigationUI$$ExternalSyntheticLambda5 implements NavigationView.OnNavigationItemSelectedListener {
    public final /* synthetic */ NavController f$0;
    public final /* synthetic */ NavigationView f$1;

    public /* synthetic */ NavigationUI$$ExternalSyntheticLambda5(NavController navController, NavigationView navigationView) {
        this.f$0 = navController;
        this.f$1 = navigationView;
    }

    @Override // com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
    public final boolean onNavigationItemSelected(MenuItem menuItem) {
        return NavigationUI.setupWithNavController$lambda$3(this.f$0, this.f$1, menuItem);
    }
}
