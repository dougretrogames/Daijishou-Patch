package androidx.navigation.ui;

import android.view.MenuItem;
import androidx.navigation.NavController;
import com.google.android.material.navigation.NavigationBarView;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class NavigationUI$$ExternalSyntheticLambda0 implements NavigationBarView.OnItemSelectedListener {
    public final /* synthetic */ NavController f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ NavigationUI$$ExternalSyntheticLambda0(NavController navController, boolean z) {
        this.f$0 = navController;
        this.f$1 = z;
    }

    @Override // com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
    public final boolean onNavigationItemSelected(MenuItem menuItem) {
        return NavigationUI.setupWithNavController$lambda$8(this.f$0, this.f$1, menuItem);
    }
}
