package com.magneticchen.daijishou.view_models;

import android.app.ActivityManager;
import android.text.format.Formatter;
import androidx.appcompat.app.AppCompatActivity;
import com.magneticchen.daijishou.DaijishouApplication;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.Constants;

/* JADX INFO: compiled from: DaijishouConsoleViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u0010"}, d2 = {"com/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$commands$11", "Lcom/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$Companion$Command;", "description", "", "getDescription", "()Ljava/lang/String;", "startWith", "getStartWith", "execute", "Lcom/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$Companion$CommandResult;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "command", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/magneticchen/daijishou/DaijishouApplication;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouConsoleViewModel$commands$11 extends DaijishouConsoleViewModel.Companion.Command {
    private final String startWith = "\\app ";
    private final String description = "Daijishou Application related command. Usage:\n> \\app mem stats\n> \\app mem gc\n> \\app clear logs\n> \\app finish\n> \\app terminate\n> \\app show version";

    DaijishouConsoleViewModel$commands$11() {
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
        List listSplitCommandBySpaces = DaijishouConsoleViewModel.INSTANCE.splitCommandBySpaces(str);
        if (listSplitCommandBySpaces.size() == 3 && ((Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "mem") || Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "memory")) && Intrinsics.areEqual(listSplitCommandBySpaces.get(2), "stats"))) {
            Runtime runtime = Runtime.getRuntime();
            long jMaxMemory = runtime.maxMemory();
            long j = runtime.totalMemory();
            long jFreeMemory = runtime.freeMemory();
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            Object systemService = daijishouApplication.getSystemService("activity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
            long j2 = memoryInfo.totalMem;
            long j3 = memoryInfo.availMem;
            DaijishouApplication daijishouApplication2 = daijishouApplication;
            String fileSize = Formatter.formatFileSize(daijishouApplication2, jMaxMemory);
            String str2 = String.format("%,d", Arrays.copyOf(new Object[]{Boxing.boxLong(jMaxMemory)}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            String fileSize2 = Formatter.formatFileSize(daijishouApplication2, j);
            String str3 = String.format("%,d", Arrays.copyOf(new Object[]{Boxing.boxLong(j)}, 1));
            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
            String fileSize3 = Formatter.formatFileSize(daijishouApplication2, jFreeMemory);
            String str4 = String.format("%,d", Arrays.copyOf(new Object[]{Boxing.boxLong(jFreeMemory)}, 1));
            Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
            long j4 = jMaxMemory - jFreeMemory;
            String fileSize4 = Formatter.formatFileSize(daijishouApplication2, j4);
            String str5 = String.format("%,d", Arrays.copyOf(new Object[]{Boxing.boxLong(j4)}, 1));
            Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
            String fileSize5 = Formatter.formatFileSize(daijishouApplication2, j2);
            String str6 = String.format("%,d", Arrays.copyOf(new Object[]{Boxing.boxLong(j2)}, 1));
            Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
            String fileSize6 = Formatter.formatFileSize(daijishouApplication2, j3);
            String str7 = String.format("%,d", Arrays.copyOf(new Object[]{Boxing.boxLong(j3)}, 1));
            Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
            long j5 = j2 - j3;
            String fileSize7 = Formatter.formatFileSize(daijishouApplication2, j5);
            String str8 = String.format("%,d", Arrays.copyOf(new Object[]{Boxing.boxLong(j5)}, 1));
            Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
            return new DaijishouConsoleViewModel.Companion.CommandResult("Runtime max: " + fileSize + " (" + str2 + ").\nRuntime total: " + fileSize2 + " (" + str3 + ").\nRuntime free: " + fileSize3 + " (" + str4 + ").\nRuntime used: " + fileSize4 + " (" + str5 + ").\nNative heap: " + fileSize5 + " (" + str6 + ").\nNative heap free: " + fileSize6 + " (" + str7 + ").\nNative heap used: " + fileSize7 + " (" + str8 + ").", 0, null, false, 14, null);
        }
        if (listSplitCommandBySpaces.size() == 3 && ((Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "mem") || Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "memory")) && Intrinsics.areEqual(listSplitCommandBySpaces.get(2), ConfigConstants.CONFIG_GC_SECTION))) {
            Runtime.getRuntime().gc();
            return new DaijishouConsoleViewModel.Companion.CommandResult("Executed.", 0, null, false, 14, null);
        }
        if (listSplitCommandBySpaces.size() == 3 && Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "clear") && Intrinsics.areEqual(listSplitCommandBySpaces.get(2), Constants.LOGS)) {
            daijishouApplication.getLogger().clear();
            return new DaijishouConsoleViewModel.Companion.CommandResult("Logs cleared.", 0, null, false, 14, null);
        }
        if (listSplitCommandBySpaces.size() == 2 && Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "finish")) {
            appCompatActivity.finish();
            return new DaijishouConsoleViewModel.Companion.CommandResult("Activity finished.", 0, null, false, 14, null);
        }
        if (listSplitCommandBySpaces.size() == 2 && Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "terminate")) {
            appCompatActivity.finishAffinity();
            daijishouApplication.stopAllServices();
            System.exit(0);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }
        if (listSplitCommandBySpaces.size() == 3 && Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "show") && Intrinsics.areEqual(listSplitCommandBySpaces.get(2), "version")) {
            return new DaijishouConsoleViewModel.Companion.CommandResult("1.5.0 (416)", 0, null, false, 14, null);
        }
        return DaijishouConsoleViewModel.INSTANCE.getUnsupportedCommandResult();
    }
}
