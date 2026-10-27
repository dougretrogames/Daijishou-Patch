package com.magneticchen.daijishou.data.migration;

import android.app.Application;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.magneticchen.daijishou.data.db.DaijishouDatabase;
import com.magneticchen.daijishou.ui.fragments.dialog.AcknowledgementDialogFragment;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UpgradeScript64.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\f0\u0010H\u0096@¢\u0006\u0002\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/magneticchen/daijishou/data/migration/UpgradeScript64;", "Lcom/magneticchen/daijishou/data/migration/UpgradeScript;", "()V", "toVersion", "", "getToVersion", "()I", "upgradeDescription", "", "getUpgradeDescription", "()Ljava/lang/String;", "upgrade", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "callback", "Lkotlin/Function1;", "", "(Landroidx/appcompat/app/AppCompatActivity;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class UpgradeScript64 extends UpgradeScript {
    private final String upgradeDescription = "Upgrade implementations for preview media.";
    private final int toVersion = 64;

    @Override // com.magneticchen.daijishou.data.migration.UpgradeScript
    public String getUpgradeDescription() {
        return this.upgradeDescription;
    }

    @Override // com.magneticchen.daijishou.data.migration.UpgradeScript
    public int getToVersion() {
        return this.toVersion;
    }

    @Override // com.magneticchen.daijishou.data.migration.UpgradeScript
    public Object upgrade(final AppCompatActivity appCompatActivity, final Function1<? super Boolean, Unit> function1, Continuation<? super Unit> continuation) {
        AcknowledgementDialogFragment.Companion.newInstance$default(AcknowledgementDialogFragment.Companion, "Upgrade to version 64", "Upgrading to version 64 will make your preview media removed. You will need to re-sync your items.", null, null, null, 28, null).setOnAcknowledgedListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.data.migration.UpgradeScript64.upgrade.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                File file = new File(appCompatActivity.getApplicationContext().getFilesDir() + "/preview_medias/");
                DaijishouDatabase.Companion companion = DaijishouDatabase.Companion;
                Application application = appCompatActivity.getApplication();
                Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
                DaijishouDatabase instance$default = DaijishouDatabase.Companion.getInstance$default(companion, application, null, 2, null);
                Log.d("daijishou_debug", appCompatActivity.getApplicationContext().getFilesDir() + "/preview_media/");
                FilesKt.deleteRecursively(file);
                instance$default.playableItemDAO().updatePreviewMediaPathAll(null);
                function1.invoke(true);
            }
        }).setOnCanceledListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.data.migration.UpgradeScript64.upgrade.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                function1.invoke(false);
            }
        }).show(appCompatActivity.getSupportFragmentManager(), "upgrade_script_64");
        return Unit.INSTANCE;
    }
}
