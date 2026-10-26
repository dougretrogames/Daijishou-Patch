package com.magneticchen.daijishou.view_models;

import androidx.appcompat.app.AppCompatActivity;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.google_drive.GoogleDrive;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* INFO: compiled from: DaijishouConsoleViewModel.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u0010"}, d2 = {"com/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$commands$6", "Lcom/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$Companion$Command;", "description", "", "getDescription", "()Ljava/lang/String;", "startWith", "getStartWith", "execute", "Lcom/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$Companion$CommandResult;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "command", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/magneticchen/daijishou/DaijishouApplication;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouConsoleViewModel$commands$6 extends DaijishouConsoleViewModel.Companion.Command {
    final /* synthetic */ DaijishouConsoleViewModel this$0;
    private final String startWith = "\\drive ";
    private final String description = "Google Drive command. Usage:\n> \\drive list all\n> \\drive delete all";

    DaijishouConsoleViewModel$commands$6(DaijishouConsoleViewModel daijishouConsoleViewModel) {
        this.this$0 = daijishouConsoleViewModel;
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
        DaijishouConsoleViewModel$commands$6$execute$1 daijishouConsoleViewModel$commands$6$execute$1;
        if (continuation instanceof DaijishouConsoleViewModel$commands$6$execute$1) {
            daijishouConsoleViewModel$commands$6$execute$1 = (DaijishouConsoleViewModel$commands$6$execute$1) continuation;
            if ((daijishouConsoleViewModel$commands$6$execute$1.label & Integer.MIN_VALUE) != 0) {
                daijishouConsoleViewModel$commands$6$execute$1.label -= Integer.MIN_VALUE;
            } else {
                daijishouConsoleViewModel$commands$6$execute$1 = new DaijishouConsoleViewModel$commands$6$execute$1(this, continuation);
            }
        } else {
            daijishouConsoleViewModel$commands$6$execute$1 = new DaijishouConsoleViewModel$commands$6$execute$1(this, continuation);
        }
        Object obj = daijishouConsoleViewModel$commands$6$execute$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = daijishouConsoleViewModel$commands$6$execute$1.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return new DaijishouConsoleViewModel.Companion.CommandResult("Results printed in the logger.", 0, null, false, 14, null);
            }
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        List listSplitCommandBySpaces = DaijishouConsoleViewModel.INSTANCE.splitCommandBySpaces(str);
        if (listSplitCommandBySpaces.size() == 3 && Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "list") && Intrinsics.areEqual(listSplitCommandBySpaces.get(2), "all")) {
            daijishouConsoleViewModel$commands$6$execute$1.label = 1;
            try {
                if (GoogleDrive.logAllFiles$default(daijishouApplication.getGoogleDrive(), false, daijishouConsoleViewModel$commands$6$execute$1, 1, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
            return new DaijishouConsoleViewModel.Companion.CommandResult("Results printed in the logger.", 0, null, false, 14, null);
        }
        if (listSplitCommandBySpaces.size() == 3 && Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "delete") && Intrinsics.areEqual(listSplitCommandBySpaces.get(2), "all")) {
            DaijishouConsoleViewModel.logCommand$default(this.this$0, str, "Executed. This can take a while. Please wait...", false, 4, null);
            daijishouConsoleViewModel$commands$6$execute$1.label = 2;
            Object withContextResult = BuildersKt.withContext(Dispatchers.getIO(), new DaijishouConsoleViewModel$commands$6$execute$2(daijishouApplication, null), daijishouConsoleViewModel$commands$6$execute$1);
            if (withContextResult == coroutine_suspended) {
                return coroutine_suspended;
            }
            return withContextResult;
        }
        return DaijishouConsoleViewModel.INSTANCE.getUnsupportedCommandResult();
    }
}
