package com.magneticchen.daijishou.upgrade_scripts;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.application_data.BooleanPreference;
import com.magneticchen.daijishou.application_data.StringPreference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: UpdateEveryPlatformUpgradeScript.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\f0\u0010H\u0096@¢\u0006\u0002\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/magneticchen/daijishou/upgrade_scripts/UpdateEveryPlatformUpgradeScript;", "Lcom/magneticchen/daijishou/upgrade_scripts/UpgradeScript;", "()V", "toVersion", "", "getToVersion", "()I", "upgradeDescription", "", "getUpgradeDescription", "()Ljava/lang/String;", "upgrade", "", "appCompatActivity", "Landroidx/appcompat/app/AppCompatActivity;", "callback", "Lkotlin/Function1;", "", "(Landroidx/appcompat/app/AppCompatActivity;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class UpdateEveryPlatformUpgradeScript extends UpgradeScript {
    private final String upgradeDescription = "Scheduling every platform update on start";
    private final int toVersion = 405;

    @Override // com.magneticchen.daijishou.upgrade_scripts.UpgradeScript
    public String getUpgradeDescription() {
        return this.upgradeDescription;
    }

    @Override // com.magneticchen.daijishou.upgrade_scripts.UpgradeScript
    public int getToVersion() {
        return this.toVersion;
    }

    @Override // com.magneticchen.daijishou.upgrade_scripts.UpgradeScript
    public Object upgrade(AppCompatActivity appCompatActivity, Function1<? super Boolean, Unit> function1, Continuation<?> continuation) {
        Context applicationContext = appCompatActivity.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        ((DaijishouApplication) applicationContext).getDefaultSharedPreferences().edit().putBoolean(BooleanPreference.UPDATE_EVERY_PLATFORM_ON_START.getKey(), true).putString(StringPreference.UPDATE_EVERY_PLATFORM_ON_START_HINT.getKey(), appCompatActivity.getString(R.string.daijishou_upgrade_update_every_platform_hint)).putString(StringPreference.UPDATE_EVERY_PLATFORM_ON_START_CANCEL_HINT.getKey(), appCompatActivity.getString(R.string.daijishou_upgrade_update_every_platform_cancel_hint)).apply();
        function1.invoke(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    }
}
