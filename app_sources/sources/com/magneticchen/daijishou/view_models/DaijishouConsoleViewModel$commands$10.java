package com.magneticchen.daijishou.view_models;

import androidx.appcompat.app.AppCompatActivity;
import com.magneticchen.daijishou.DaijishouApplication;
import java.io.File;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* INFO: compiled from: DaijishouConsoleViewModel.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u0010"}, d2 = {"com/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$commands$10", "Lcom/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$Companion$Command;", "description", "", "getDescription", "()Ljava/lang/String;", "startWith", "getStartWith", "execute", "Lcom/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$Companion$CommandResult;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "command", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/magneticchen/daijishou/DaijishouApplication;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouConsoleViewModel$commands$10 extends DaijishouConsoleViewModel.Companion.Command {
    private final String startWith = "\\db ";
    private final String description = "Database command. Usage:\n> \\db delete \"You Database code to be deleted\"";

    DaijishouConsoleViewModel$commands$10() {
    }

    @Override // com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel.Companion.Command
    public String getStartWith() {
        return this.startWith;
    }

    @Override // com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel.Companion.Command
    public String getDescription() {
        return this.description;
    }

    @Override // com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel.Companion.Command
    public Object execute(AppCompatActivity appCompatActivity, DaijishouApplication daijishouApplication, String str, Continuation<?> continuation) {
        String string;
        if (Intrinsics.areEqual(DaijishouConsoleViewModel.INSTANCE.splitCommandBySpaces(str).get(1), "delete")) {
            String str2 = (String) CollectionsKt.getOrNull(StringsKt.split$default((CharSequence) str, new String[]{"delete"}, false, 2, 2, (Object) null), 1);
            if (str2 == null || (string = StringsKt.trimStart((CharSequence) str2).toString()) == null) {
                return DaijishouConsoleViewModel.INSTANCE.getUnsupportedCommandResult();
            }
            daijishouApplication.deleteDatabase(string);
            File databasePath = daijishouApplication.getDatabasePath(string);
            File file = new File(databasePath.getPath() + "-shm");
            File file2 = new File(databasePath.getPath() + "-wal");
            File file3 = new File(databasePath.getPath() + "-bkp");
            if (databasePath.exists()) {
                databasePath.delete();
            }
            if (file.exists()) {
                file.delete();
            }
            if (file2.exists()) {
                file2.delete();
            }
            if (file3.exists()) {
                file3.delete();
            }
            return new DaijishouConsoleViewModel.Companion.CommandResult("Database \"" + string + "\" deletion executed. All connections have to be closed to be succeed.", 0, null, false, 14, null);
        }
        return DaijishouConsoleViewModel.INSTANCE.getUnsupportedCommandResult();
    }
}
