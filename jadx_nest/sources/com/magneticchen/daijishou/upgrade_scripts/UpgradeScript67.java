package com.magneticchen.daijishou.upgrade_scripts;

import android.app.Application;
import android.content.SharedPreferences;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;
import com.magneticchen.daijishou.daijishou_library_db.DaijishouDatabase;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemDAO;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import net.lingala.zip4j.util.InternalZipConstants;

/* INFO: compiled from: UpgradeScript67.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\f0\u0010H\u0096@¢\u0006\u0002\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/magneticchen/daijishou/upgrade_scripts/UpgradeScript67;", "Lcom/magneticchen/daijishou/upgrade_scripts/UpgradeScript;", "()V", "toVersion", "", "getToVersion", "()I", "upgradeDescription", "", "getUpgradeDescription", "()Ljava/lang/String;", "upgrade", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "callback", "Lkotlin/Function1;", "", "(Landroidx/appcompat/app/AppCompatActivity;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class UpgradeScript67 extends UpgradeScript {
    private final String upgradeDescription = "Upgrade implementations for preview media.";
    private final int toVersion = 67;

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
        String str = appCompatActivity.getApplicationContext().getFilesDir() + "/preview_media/";
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(appCompatActivity.getApplicationContext());
        String string = defaultSharedPreferences.getString("preview_media_path", str);
        String str2 = string + "preview_media/";
        if (!Intrinsics.areEqual(string, str)) {
            defaultSharedPreferences.edit().putString("preview_media_path", str2).commit();
            DaijishouDatabase.Companion companion = DaijishouDatabase.INSTANCE;
            Application application = appCompatActivity.getApplication();
            Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
            DaijishouDatabase instance$default = DaijishouDatabase.INSTANCE.getInstance$default(companion, application, null, 2, null);
            File file = new File(string + InternalZipConstants.ZIP_FILE_SEPARATOR);
            new File(str2).mkdirs();
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    try {
                        String name = file2.getName();
                        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                        if (new Regex("-?\\d+").matches(name)) {
                            File file3 = new File(str2 + file2.getName() + InternalZipConstants.ZIP_FILE_SEPARATOR);
                            PlayableItemDAO playableItemDAO = instance$default.playableItemDAO();
                            String name2 = file2.getName();
                            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                            PlayableItemEntity playableItemEntitySelectByIdStatically = playableItemDAO.selectByIdStatically(Long.parseLong(name2));
                            if (playableItemEntitySelectByIdStatically != null) {
                                playableItemEntitySelectByIdStatically.setPreviewMediaPath(str2 + file2.getName() + InternalZipConstants.ZIP_FILE_SEPARATOR);
                                instance$default.playableItemDAO().update(playableItemEntitySelectByIdStatically);
                                Intrinsics.checkNotNull(file2);
                                FilesKt.copyRecursively$default(file2, file3, false, null, 6, null);
                                Boxing.boxBoolean(FilesKt.deleteRecursively(file2));
                            }
                        }
                    } catch (Exception e) {
                        Toast.makeText(appCompatActivity.getApplicationContext(), e.toString(), 0).show();
                    }
                }
            }
            function1.invoke(Boxing.boxBoolean(true));
            return Unit.INSTANCE;
        }
        function1.invoke(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    }
}
