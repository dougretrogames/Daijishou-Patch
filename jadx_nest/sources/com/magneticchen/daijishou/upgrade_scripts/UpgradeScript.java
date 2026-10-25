package com.magneticchen.daijishou.upgrade_scripts;

import androidx.appcompat.app.AppCompatActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UpgradeScript.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0000H\u0096\u0002J*\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e0\u0012H¦@¢\u0006\u0002\u0010\u0014R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/magneticchen/daijishou/upgrade_scripts/UpgradeScript;", "", "()V", "toVersion", "", "getToVersion", "()I", "upgradeDescription", "", "getUpgradeDescription", "()Ljava/lang/String;", "compareTo", "other", "upgrade", "", "appCompatActivity", "Landroidx/appcompat/app/AppCompatActivity;", "callback", "Lkotlin/Function1;", "", "(Landroidx/appcompat/app/AppCompatActivity;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class UpgradeScript implements Comparable<UpgradeScript> {
    public abstract int getToVersion();

    public abstract String getUpgradeDescription();

    public abstract Object upgrade(AppCompatActivity appCompatActivity, Function1<? super Boolean, Unit> function1, Continuation<?> continuation);

    @Override // java.lang.Comparable
    public int compareTo(UpgradeScript other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return getToVersion() - other.getToVersion();
    }
}
