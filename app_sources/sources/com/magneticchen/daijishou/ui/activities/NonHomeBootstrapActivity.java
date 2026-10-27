package com.magneticchen.daijishou.ui.activities;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.magneticchen.daijishou.DaijishouApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NonHomeBootstrapActivity.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/magneticchen/daijishou/ui/activities/NonHomeBootstrapActivity;", "Lcom/magneticchen/daijishou/ui/activities/BootstrapActivity;", "()V", "startMainActivity", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NonHomeBootstrapActivity extends BootstrapActivity {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.magneticchen.daijishou.ui.activities.BootstrapActivity
    public void startMainActivity() {
        Intent intent = new Intent((Context) this, (Class<?>) MainActivity.class);
        Bundle extras = intent.getExtras();
        if ((extras != null ? Boolean.valueOf(extras.getBoolean("android.intent.extra.FROM_HOME_KEY")) : null) != null) {
            intent.putExtra("android.intent.extra.FROM_HOME_KEY", true);
        }
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(268435456);
        Application application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        ((DaijishouApplication) application).getLogger().debug(this, "Started from non home bootstrap.");
        Toast.makeText(getApplicationContext(), "A non home activity started.", 0).show();
        startActivity(intent);
        finish();
    }
}
