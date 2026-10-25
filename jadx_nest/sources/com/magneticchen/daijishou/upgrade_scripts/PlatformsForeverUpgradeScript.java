package com.magneticchen.daijishou.upgrade_scripts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelLazy;
import com.magneticchen.daijishou.view_models.DaijishouSynchronizationModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: PlatformsForeverUpgradeScript.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\f0\u0010H\u0096@¢\u0006\u0002\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013²\u0006\n\u0010\u0014\u001a\u00020\u0015X\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/upgrade_scripts/PlatformsForeverUpgradeScript;", "Lcom/magneticchen/daijishou/upgrade_scripts/UpgradeScript;", "()V", "toVersion", "", "getToVersion", "()I", "upgradeDescription", "", "getUpgradeDescription", "()Ljava/lang/String;", "upgrade", "", "appCompatActivity", "Landroidx/appcompat/app/AppCompatActivity;", "callback", "Lkotlin/Function1;", "", "(Landroidx/appcompat/app/AppCompatActivity;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release", "daijishouSynchronization", "Lcom/magneticchen/daijishou/view_models/DaijishouSynchronizationModel;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PlatformsForeverUpgradeScript extends UpgradeScript {
    private final String upgradeDescription = "Updating platforms";
    private final int toVersion = 999999999;

    @Override // com.magneticchen.daijishou.upgrade_scripts.UpgradeScript
    public String getUpgradeDescription() {
        return this.upgradeDescription;
    }

    @Override // com.magneticchen.daijishou.upgrade_scripts.UpgradeScript
    public int getToVersion() {
        return this.toVersion;
    }

    private static final DaijishouSynchronizationModel upgrade$lambda$0(Lazy<DaijishouSynchronizationModel> lazy) {
        return lazy.getValue();
    }

    @Override // com.magneticchen.daijishou.upgrade_scripts.UpgradeScript
    public Object upgrade(AppCompatActivity appCompatActivity, Function1<? super Boolean, Unit> function1, Continuation<?> continuation) {
        AppCompatActivity appCompatActivity2 = appCompatActivity;
        try {
            upgrade$lambda$0(new ViewModelLazy(Reflection.getOrCreateKotlinClass(DaijishouSynchronizationModel.class), new PlatformsForeverUpgradeScript$upgrade$$inlined$viewModels$default$2(appCompatActivity2), new PlatformsForeverUpgradeScript$upgrade$$inlined$viewModels$default$1(appCompatActivity2), new PlatformsForeverUpgradeScript$upgrade$$inlined$viewModels$default$3(null, appCompatActivity2))).updatePlatformsFromGitHub(new AnonymousClass2(function1));
        } catch (Exception e) {
            e.printStackTrace();
            function1.invoke(Boxing.boxBoolean(true));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.upgrade_scripts.PlatformsForeverUpgradeScript$upgrade$2, reason: invalid class name */
    /* JADX INFO: compiled from: PlatformsForeverUpgradeScript.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass2 extends Lambda<Unit> implements Function1<Boolean, Unit> {
        final /* synthetic */ Function1<? super Boolean, Unit> $callback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Function1<? super Boolean, Unit> function1) {
            super(1);
            this.$callback = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean z) {
            this.$callback.invoke(true);
        }
    }
}
