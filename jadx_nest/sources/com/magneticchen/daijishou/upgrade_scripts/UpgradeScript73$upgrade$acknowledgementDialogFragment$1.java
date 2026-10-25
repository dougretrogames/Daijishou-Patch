package com.magneticchen.daijishou.upgrade_scripts;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.magneticchen.daijishou.daijishou_library_db.DaijishouDatabase;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: UpgradeScript73.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class UpgradeScript73$upgrade$acknowledgementDialogFragment$1 extends Lambda<Unit> implements Function0<Unit> {
    final /* synthetic */ AppCompatActivity $activity;
    final /* synthetic */ Function1<? super Boolean, Unit> $callback;
    final /* synthetic */ SharedPreferences $defaultPrefs;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    UpgradeScript73$upgrade$acknowledgementDialogFragment$1(AppCompatActivity appCompatActivity, SharedPreferences sharedPreferences, Function1<? super Boolean, Unit> function1) {
        super(0);
        this.$activity = appCompatActivity;
        this.$defaultPrefs = sharedPreferences;
        this.$callback = function1;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        new File(this.$activity.getApplicationContext().getFilesDir() + "/preview_medias/");
        DaijishouDatabase.Companion companion = DaijishouDatabase.INSTANCE;
        Application application = this.$activity.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
        DaijishouDatabase instance$default = DaijishouDatabase.INSTANCE.getInstance$default(companion, application, null, 2, null);
        Log.d("daijishou_debug", this.$activity.getApplicationContext().getFilesDir() + "/preview_media/");
        instance$default.playableItemDAO().updatePreviewMediaPathAll(null);
        this.$defaultPrefs.edit().putString("preview_media_path", this.$activity.getApplicationContext().getFilesDir() + "/preview_media/").commit();
        this.$callback.invoke(true);
    }
}
