package com.magneticchen.daijishou.view_models;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelLazy;
import com.magneticchen.daijishou.DaijishouApplication;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* INFO: compiled from: DaijishouConsoleViewModel.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u0010²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u008a\u0084\u0002²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u008a\u0084\u0002²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u008a\u0084\u0002²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u008a\u0084\u0002²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u008a\u0084\u0002"}, d2 = {"com/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$commands$2", "Lcom/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$Companion$Command;", "description", "", "getDescription", "()Ljava/lang/String;", "startWith", "getStartWith", "execute", "Lcom/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$Companion$CommandResult;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "command", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/magneticchen/daijishou/DaijishouApplication;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release", "daijishouSynchronizationModel", "Lcom/magneticchen/daijishou/view_models/DaijishouSynchronizationModel;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouConsoleViewModel$commands$2 extends DaijishouConsoleViewModel.Companion.Command {
    private final String startWith = "\\library ";
    private final String description = "Library command. Usages:\n> \\library clear all\n> \\library clear media\n> \\library clear events\n> \\library clear disjointed_events\n> \\library clear genres\n> \\library sync all\n> \\library sync backup\n> \\library show sync_status\n> \\library show sync_platform_count\n> \\library update_every_platform";

    DaijishouConsoleViewModel$commands$2() {
    }

    @Override // com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel.Companion.Command
    public String getStartWith() {
        return this.startWith;
    }

    @Override // com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel.Companion.Command
    public String getDescription() {
        return this.description;
    }

    /* WARN: Code duplicated, block: B:7:0x0014  */
    /* WARN: Code restructure failed: missing block: B:104:0x0337, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r11, r12, r1) == r2) goto L105;
     */
    /* WARN: Code restructure failed: missing block: B:65:0x01b1, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r12, r13, r1) == r2) goto L105;
     */
    /* WARN: Code restructure failed: missing block: B:76:0x0216, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r11, r12, r1) == r2) goto L105;
     */
    @Override // com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel.Companion.Command
    public Object execute(AppCompatActivity appCompatActivity, DaijishouApplication daijishouApplication, String str, Continuation<?> continuation) {
        DaijishouConsoleViewModel$commands$2$execute$1 daijishouConsoleViewModel$commands$2$execute$1;
        if (continuation instanceof DaijishouConsoleViewModel$commands$2$execute$1) {
            daijishouConsoleViewModel$commands$2$execute$1 = (DaijishouConsoleViewModel$commands$2$execute$1) continuation;
            if ((daijishouConsoleViewModel$commands$2$execute$1.label & Integer.MIN_VALUE) != 0) {
                daijishouConsoleViewModel$commands$2$execute$1.label -= Integer.MIN_VALUE;
            } else {
                daijishouConsoleViewModel$commands$2$execute$1 = new DaijishouConsoleViewModel$commands$2$execute$1(this, continuation);
            }
        } else {
            daijishouConsoleViewModel$commands$2$execute$1 = new DaijishouConsoleViewModel$commands$2$execute$1(this, continuation);
        }
        Object obj = daijishouConsoleViewModel$commands$2$execute$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = daijishouConsoleViewModel$commands$2$execute$1.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return new DaijishouConsoleViewModel.Companion.CommandResult("Synchronization started.", 0, null, false, 14, null);
            }
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return new DaijishouConsoleViewModel.Companion.CommandResult("Synchronization started.", 0, null, false, 14, null);
            }
            if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return new DaijishouConsoleViewModel.Companion.CommandResult("Scheduled to update every platform.", 0, null, false, 14, null);
        }
        ResultKt.throwOnFailure(obj);
        List listSplitCommandBySpaces = DaijishouConsoleViewModel.INSTANCE.splitCommandBySpaces(str);
        if (listSplitCommandBySpaces.size() == 3 && Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "clear") && Intrinsics.areEqual(listSplitCommandBySpaces.get(2), "all")) {
            daijishouApplication.getDaijishouLibraryRepository().clearAll();
            return new DaijishouConsoleViewModel.Companion.CommandResult("All cleared.", 0, null, false, 14, null);
        }
        if (listSplitCommandBySpaces.size() == 3 && Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "clear") && Intrinsics.areEqual(listSplitCommandBySpaces.get(2), "media")) {
            daijishouApplication.getDaijishouLibraryRepository().removeAllPlayableItemsPreviewMediaAndRelations();
            daijishouApplication.getDaijishouLibraryRepository().removeAllPlatformsPreviewMedia();
            return new DaijishouConsoleViewModel.Companion.CommandResult("All cleared.", 0, null, false, 14, null);
        }
        if (listSplitCommandBySpaces.size() == 3 && Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "clear") && Intrinsics.areEqual(listSplitCommandBySpaces.get(2), "events")) {
            daijishouApplication.getDaijishouLibraryRepository().deleteAllEvents();
            return new DaijishouConsoleViewModel.Companion.CommandResult("All cleared.", 0, null, false, 14, null);
        }
        if (listSplitCommandBySpaces.size() == 3 && Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "clear") && Intrinsics.areEqual(listSplitCommandBySpaces.get(2), "disjointed_events")) {
            return new DaijishouConsoleViewModel.Companion.CommandResult(daijishouApplication.getDaijishouLibraryRepository().removeDisjointedEvents() + " events cleared.", 0, null, false, 14, null);
        }
        if (listSplitCommandBySpaces.size() == 3 && Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "clear") && Intrinsics.areEqual(listSplitCommandBySpaces.get(2), "genres")) {
            daijishouApplication.getDaijishouLibraryRepository().deleteAllPlayableItemToGenrePairs();
            return new DaijishouConsoleViewModel.Companion.CommandResult("All cleared.", 0, null, false, 14, null);
        }
        if (listSplitCommandBySpaces.size() == 3 && Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "sync") && Intrinsics.areEqual(listSplitCommandBySpaces.get(2), "all")) {
            DaijishouConsoleViewModel$commands$2$execute$$inlined$viewModels$default$1 function0 = new DaijishouConsoleViewModel$commands$2$execute$$inlined$viewModels$default$1(appCompatActivity);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(DaijishouSynchronizationModel.class);
            DaijishouConsoleViewModel$commands$2$execute$$inlined$viewModels$default$2 function1 = new DaijishouConsoleViewModel$commands$2$execute$$inlined$viewModels$default$2(appCompatActivity);
            DaijishouConsoleViewModel$commands$2$execute$$inlined$viewModels$default$3 function2 = new DaijishouConsoleViewModel$commands$2$execute$$inlined$viewModels$default$3(null, appCompatActivity);
            ViewModelLazy viewModelLazy = new ViewModelLazy(orCreateKotlinClass, function1, function0, function2);
            MainCoroutineDispatcher main = Dispatchers.getMain();
            DaijishouConsoleViewModel$commands$2$execute$2 daijishouConsoleViewModel$commands$2$execute$2 = new DaijishouConsoleViewModel$commands$2$execute$2(appCompatActivity, viewModelLazy, null);
            daijishouConsoleViewModel$commands$2$execute$1.label = 1;
            Object withContextResult = BuildersKt.withContext(main, daijishouConsoleViewModel$commands$2$execute$2, daijishouConsoleViewModel$commands$2$execute$1);
            if (withContextResult == coroutine_suspended) {
                return coroutine_suspended;
            }
            return new DaijishouConsoleViewModel.Companion.CommandResult("Synchronization started.", 0, null, false, 14, null);
        }
        if (listSplitCommandBySpaces.size() == 3 && Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "sync") && Intrinsics.areEqual(listSplitCommandBySpaces.get(2), "backup")) {
            DaijishouConsoleViewModel$commands$2$execute$$inlined$viewModels$default$4 function4 = new DaijishouConsoleViewModel$commands$2$execute$$inlined$viewModels$default$4(appCompatActivity);
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(DaijishouSynchronizationModel.class);
            DaijishouConsoleViewModel$commands$2$execute$$inlined$viewModels$default$5 function5 = new DaijishouConsoleViewModel$commands$2$execute$$inlined$viewModels$default$5(appCompatActivity);
            DaijishouConsoleViewModel$commands$2$execute$$inlined$viewModels$default$6 function6 = new DaijishouConsoleViewModel$commands$2$execute$$inlined$viewModels$default$6(null, appCompatActivity);
            ViewModelLazy viewModelLazy2 = new ViewModelLazy(orCreateKotlinClass2, function5, function4, function6);
            MainCoroutineDispatcher main2 = Dispatchers.getMain();
            DaijishouConsoleViewModel$commands$2$execute$3 daijishouConsoleViewModel$commands$2$execute$3 = new DaijishouConsoleViewModel$commands$2$execute$3(viewModelLazy2, null);
            daijishouConsoleViewModel$commands$2$execute$1.label = 2;
            Object withContextResult2 = BuildersKt.withContext(main2, daijishouConsoleViewModel$commands$2$execute$3, daijishouConsoleViewModel$commands$2$execute$1);
            if (withContextResult2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            return new DaijishouConsoleViewModel.Companion.CommandResult("Synchronization started.", 0, null, false, 14, null);
        }
        if (listSplitCommandBySpaces.size() == 3 && Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "show") && Intrinsics.areEqual(listSplitCommandBySpaces.get(2), "sync_status")) {
            DaijishouConsoleViewModel$commands$2$execute$$inlined$viewModels$default$7 function7 = new DaijishouConsoleViewModel$commands$2$execute$$inlined$viewModels$default$7(appCompatActivity);
            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(DaijishouSynchronizationModel.class);
            DaijishouConsoleViewModel$commands$2$execute$$inlined$viewModels$default$8 function8 = new DaijishouConsoleViewModel$commands$2$execute$$inlined$viewModels$default$8(appCompatActivity);
            DaijishouConsoleViewModel$commands$2$execute$$inlined$viewModels$default$9 function9 = new DaijishouConsoleViewModel$commands$2$execute$$inlined$viewModels$default$9(null, appCompatActivity);
            return new DaijishouConsoleViewModel.Companion.CommandResult(String.valueOf(execute$lambda$2(new ViewModelLazy(orCreateKotlinClass3, function8, function7, function9)).getStatusLiveData().getValue()), 0, null, false, 14, null);
        }
        if (listSplitCommandBySpaces.size() == 3 && Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "show") && Intrinsics.areEqual(listSplitCommandBySpaces.get(2), "sync_platform_count")) {
            DaijishouConsoleViewModel$commands$2$execute$$inlined$viewModels$default$10 function10 = new DaijishouConsoleViewModel$commands$2$execute$$inlined$viewModels$default$10(appCompatActivity);
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(DaijishouSynchronizationModel.class);
            DaijishouConsoleViewModel$commands$2$execute$$inlined$viewModels$default$11 function11 = new DaijishouConsoleViewModel$commands$2$execute$$inlined$viewModels$default$11(appCompatActivity);
            DaijishouConsoleViewModel$commands$2$execute$$inlined$viewModels$default$12 function12 = new DaijishouConsoleViewModel$commands$2$execute$$inlined$viewModels$default$12(null, appCompatActivity);
            List<SynchronizationOfPlatform> value = execute$lambda$3(new ViewModelLazy(orCreateKotlinClass4, function11, function10, function12)).getSynchronizationOfPlatformListLiveData().getValue();
            return new DaijishouConsoleViewModel.Companion.CommandResult(String.valueOf(value != null ? Boxing.boxInt(value.size()) : null), 0, null, false, 14, null);
        }
        if (listSplitCommandBySpaces.size() == 2 && Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "update_every_platform")) {
            DaijishouConsoleViewModel$commands$2$execute$$inlined$viewModels$default$13 function13 = new DaijishouConsoleViewModel$commands$2$execute$$inlined$viewModels$default$13(appCompatActivity);
            KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(DaijishouSynchronizationModel.class);
            DaijishouConsoleViewModel$commands$2$execute$$inlined$viewModels$default$14 function14 = new DaijishouConsoleViewModel$commands$2$execute$$inlined$viewModels$default$14(appCompatActivity);
            DaijishouConsoleViewModel$commands$2$execute$$inlined$viewModels$default$15 function15 = new DaijishouConsoleViewModel$commands$2$execute$$inlined$viewModels$default$15(null, appCompatActivity);
            ViewModelLazy viewModelLazy3 = new ViewModelLazy(orCreateKotlinClass5, function14, function13, function15);
            MainCoroutineDispatcher main3 = Dispatchers.getMain();
            DaijishouConsoleViewModel$commands$2$execute$4 daijishouConsoleViewModel$commands$2$execute$4 = new DaijishouConsoleViewModel$commands$2$execute$4(viewModelLazy3, null);
            daijishouConsoleViewModel$commands$2$execute$1.label = 3;
            Object withContextResult3 = BuildersKt.withContext(main3, daijishouConsoleViewModel$commands$2$execute$4, daijishouConsoleViewModel$commands$2$execute$1);
            if (withContextResult3 == coroutine_suspended) {
                return coroutine_suspended;
            }
            return new DaijishouConsoleViewModel.Companion.CommandResult("Scheduled to update every platform.", 0, null, false, 14, null);
        }
        return DaijishouConsoleViewModel.INSTANCE.getUnsupportedCommandResult();
    }

    /* INFO: Access modifiers changed from: private */
    public static final DaijishouSynchronizationModel execute$lambda$0(Lazy<DaijishouSynchronizationModel> lazy) {
        return lazy.getValue();
    }

    /* INFO: Access modifiers changed from: private */
    public static final DaijishouSynchronizationModel execute$lambda$1(Lazy<DaijishouSynchronizationModel> lazy) {
        return lazy.getValue();
    }

    private static final DaijishouSynchronizationModel execute$lambda$2(Lazy<DaijishouSynchronizationModel> lazy) {
        return lazy.getValue();
    }

    private static final DaijishouSynchronizationModel execute$lambda$3(Lazy<DaijishouSynchronizationModel> lazy) {
        return lazy.getValue();
    }

    /* INFO: Access modifiers changed from: private */
    public static final DaijishouSynchronizationModel execute$lambda$4(Lazy<DaijishouSynchronizationModel> lazy) {
        return lazy.getValue();
    }
}
