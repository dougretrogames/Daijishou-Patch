package com.magneticchen.daijishou.view_models;

import androidx.appcompat.app.AppCompatActivity;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* INFO: compiled from: DaijishouConsoleViewModel.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u0010"}, d2 = {"com/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$commands$3", "Lcom/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$Companion$Command;", "description", "", "getDescription", "()Ljava/lang/String;", "startWith", "getStartWith", "execute", "Lcom/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$Companion$CommandResult;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "command", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/magneticchen/daijishou/DaijishouApplication;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouConsoleViewModel$commands$3 extends DaijishouConsoleViewModel.Companion.Command {
    private final String startWith = "\\ra ";
    private final String description = "RetroAchievements command. Usages:\n> \\ra clear all\n> \\ra show version\n> \\ra show user_id\n> \\ra show user_profile\n> \\ra show game \"RetroAchievements Game Id\"";

    DaijishouConsoleViewModel$commands$3() {
    }

    @Override // com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel.Companion.Command
    public String getStartWith() {
        return this.startWith;
    }

    @Override // com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel.Companion.Command
    public String getDescription() {
        return this.description;
    }

    /* WARN: Code duplicated, block: B:7:0x001a  */
    @Override // com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel.Companion.Command
    public Object execute(AppCompatActivity appCompatActivity, DaijishouApplication daijishouApplication, String str, Continuation<?> continuation) {
        try {
            DaijishouConsoleViewModel$commands$3$execute$1 daijishouConsoleViewModel$commands$3$execute$1;
            String str2;
            RetroAchievementsManager retroAchievementsManager;
            long j;
            if (continuation instanceof DaijishouConsoleViewModel$commands$3$execute$1) {
                daijishouConsoleViewModel$commands$3$execute$1 = (DaijishouConsoleViewModel$commands$3$execute$1) continuation;
                if ((daijishouConsoleViewModel$commands$3$execute$1.label & Integer.MIN_VALUE) != 0) {
                    daijishouConsoleViewModel$commands$3$execute$1.label -= Integer.MIN_VALUE;
                } else {
                    daijishouConsoleViewModel$commands$3$execute$1 = new DaijishouConsoleViewModel$commands$3$execute$1(this, continuation);
                }
            } else {
                daijishouConsoleViewModel$commands$3$execute$1 = new DaijishouConsoleViewModel$commands$3$execute$1(this, continuation);
            }
            Object obj = daijishouConsoleViewModel$commands$3$execute$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = daijishouConsoleViewModel$commands$3$execute$1.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                List listSplitCommandBySpaces = DaijishouConsoleViewModel.INSTANCE.splitCommandBySpaces(str);
                RetroAchievementsManager retroAchievementsManager2 = daijishouApplication.getRetroAchievementsManager();
                if (listSplitCommandBySpaces.size() == 3 && Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "clear") && Intrinsics.areEqual(listSplitCommandBySpaces.get(2), "all")) {
                    daijishouApplication.getRetroAchievementsRepository().clearAll();
                    return new DaijishouConsoleViewModel.Companion.CommandResult("All cleared.", 0, null, false, 14, null);
                }
                if (listSplitCommandBySpaces.size() == 3 && Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "show") && Intrinsics.areEqual(listSplitCommandBySpaces.get(2), "version")) {
                    return new DaijishouConsoleViewModel.Companion.CommandResult("Kotlin API version: 2.0.0", 0, null, false, 14, null);
                }
                if (listSplitCommandBySpaces.size() == 3 && Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "show") && Intrinsics.areEqual(listSplitCommandBySpaces.get(2), "user_id")) {
                    return new DaijishouConsoleViewModel.Companion.CommandResult(String.valueOf(retroAchievementsManager2.getMyUsernameLiveData().getValue()), 0, null, false, 14, null);
                }
                if (listSplitCommandBySpaces.size() == 3 && Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "show") && Intrinsics.areEqual(listSplitCommandBySpaces.get(2), "user_profile")) {
                    String value = retroAchievementsManager2.getMyUsernameLiveData().getValue();
                    return value == null ? new DaijishouConsoleViewModel.Companion.CommandResult(null, 0, null, false, 14, null) : new DaijishouConsoleViewModel.Companion.CommandResult(String.valueOf(retroAchievementsManager2.getRetroAchievementsRepository().getRetroAchievementsUserProfileByIdStatically(value)), 0, null, false, 14, null);
                }
                if (listSplitCommandBySpaces.size() > 3 && Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "show") && Intrinsics.areEqual(listSplitCommandBySpaces.get(2), "game")) {
                    String value2 = retroAchievementsManager2.getMyUsernameLiveData().getValue();
                    if (value2 == null) {
                        return new DaijishouConsoleViewModel.Companion.CommandResult(null, 0, null, false, 14, null);
                    }
                    long j2 = Long.parseLong((String) StringsKt.split$default((CharSequence) str, new String[]{"game "}, false, 0, 6, (Object) null).get(1));
                    daijishouConsoleViewModel$commands$3$execute$1.L$0 = retroAchievementsManager2;
                    daijishouConsoleViewModel$commands$3$execute$1.L$1 = value2;
                    daijishouConsoleViewModel$commands$3$execute$1.J$0 = j2;
                    daijishouConsoleViewModel$commands$3$execute$1.label = 1;
                    if (retroAchievementsManager2.refreshMyRetroAchievementsGameRecordByGameId(j2, daijishouConsoleViewModel$commands$3$execute$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str2 = value2;
                    retroAchievementsManager = retroAchievementsManager2;
                    j = j2;
                } else {
                    return DaijishouConsoleViewModel.INSTANCE.getUnsupportedCommandResult();
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = daijishouConsoleViewModel$commands$3$execute$1.J$0;
                str2 = (String) daijishouConsoleViewModel$commands$3$execute$1.L$1;
                retroAchievementsManager = (RetroAchievementsManager) daijishouConsoleViewModel$commands$3$execute$1.L$0;
                ResultKt.throwOnFailure(obj);
            }
            return new DaijishouConsoleViewModel.Companion.CommandResult(String.valueOf(CollectionsKt.getOrNull(retroAchievementsManager.getRetroAchievementsRepository().getRetroAchievementsGameRecordsByUserIdAndGameIdsStatically(str2, j), 0)), 0, null, false, 14, null);
    
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
