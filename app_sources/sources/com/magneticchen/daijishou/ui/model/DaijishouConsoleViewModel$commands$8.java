package com.magneticchen.daijishou.ui.model;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.data.db.entity.PlayableItemEntity;
import com.magneticchen.daijishou.ui.fragments.dialog.ChoosePlayableItemFromLibraryDialogFragment;
import com.magneticchen.daijishou.utils.FileUtils;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: DaijishouConsoleViewModel.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u0010"}, d2 = {"com/magneticchen/daijishou/ui/model/DaijishouConsoleViewModel$commands$8", "Lcom/magneticchen/daijishou/ui/model/DaijishouConsoleViewModel$Companion$Command;", "description", "", "getDescription", "()Ljava/lang/String;", "startWith", "getStartWith", "execute", "Lcom/magneticchen/daijishou/ui/model/DaijishouConsoleViewModel$Companion$CommandResult;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "command", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/magneticchen/daijishou/DaijishouApplication;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouConsoleViewModel$commands$8 extends DaijishouConsoleViewModel.Companion.Command {
    private final String startWith = "\\files ";
    private final String description = "Files command. Usage:\n> \\files list mounted_paths \n> \\files show app_data_dir \n> \\files show app_files_dir \n> \\files show app_cache_dir \n> \\files show item_path";

    DaijishouConsoleViewModel$commands$8() {
    }

    @Override // com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel.Companion.Command
    public String getStartWith() {
        return this.startWith;
    }

    @Override // com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel.Companion.Command
    public String getDescription() {
        return this.description;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Override // com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel.Companion.Command
    public Object execute(AppCompatActivity appCompatActivity, DaijishouApplication daijishouApplication, String str, Continuation<? super DaijishouConsoleViewModel.Companion.CommandResult> continuation) throws Throwable {
        DaijishouConsoleViewModel$commands$8$execute$1 daijishouConsoleViewModel$commands$8$execute$1;
        final ChoosePlayableItemFromLibraryDialogFragment choosePlayableItemFromLibraryDialogFragmentNewInstance$default;
        final Ref.BooleanRef booleanRef;
        final AppCompatActivity appCompatActivity2 = appCompatActivity;
        if (continuation instanceof DaijishouConsoleViewModel$commands$8$execute$1) {
            daijishouConsoleViewModel$commands$8$execute$1 = (DaijishouConsoleViewModel$commands$8$execute$1) continuation;
            if ((daijishouConsoleViewModel$commands$8$execute$1.label & Integer.MIN_VALUE) != 0) {
                daijishouConsoleViewModel$commands$8$execute$1.label -= Integer.MIN_VALUE;
            } else {
                daijishouConsoleViewModel$commands$8$execute$1 = new DaijishouConsoleViewModel$commands$8$execute$1(this, continuation);
            }
        } else {
            daijishouConsoleViewModel$commands$8$execute$1 = new DaijishouConsoleViewModel$commands$8$execute$1(this, continuation);
        }
        Object obj = daijishouConsoleViewModel$commands$8$execute$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = daijishouConsoleViewModel$commands$8$execute$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            List listSplitCommandBySpaces = DaijishouConsoleViewModel.Companion.splitCommandBySpaces(str);
            if (listSplitCommandBySpaces.size() == 3 && Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "list") && Intrinsics.areEqual(listSplitCommandBySpaces.get(2), "mounted_paths")) {
                return new DaijishouConsoleViewModel.Companion.CommandResult("Results:\n" + ArraysKt.joinToString$default(FileUtils.INSTANCE.getMountedPaths((Context) appCompatActivity2), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), 0, null, false, 14, null);
            }
            if (listSplitCommandBySpaces.size() == 3 && Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "show") && Intrinsics.areEqual(listSplitCommandBySpaces.get(2), "app_data_dir")) {
                return new DaijishouConsoleViewModel.Companion.CommandResult(String.valueOf(daijishouApplication.getDataDir()), 0, null, false, 14, null);
            }
            if (listSplitCommandBySpaces.size() == 3 && Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "show") && Intrinsics.areEqual(listSplitCommandBySpaces.get(2), "app_files_dir")) {
                return new DaijishouConsoleViewModel.Companion.CommandResult(String.valueOf(daijishouApplication.getFilesDir()), 0, null, false, 14, null);
            }
            if (listSplitCommandBySpaces.size() == 3 && Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "show") && Intrinsics.areEqual(listSplitCommandBySpaces.get(2), "app_cache_dir")) {
                return new DaijishouConsoleViewModel.Companion.CommandResult(String.valueOf(daijishouApplication.getCacheDir()), 0, null, false, 14, null);
            }
            if (listSplitCommandBySpaces.size() == 3 && Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "show") && Intrinsics.areEqual(listSplitCommandBySpaces.get(2), "item_path")) {
                choosePlayableItemFromLibraryDialogFragmentNewInstance$default = ChoosePlayableItemFromLibraryDialogFragment.Companion.newInstance$default(ChoosePlayableItemFromLibraryDialogFragment.Companion, null, false, false, false, false, false, 63, null);
                booleanRef = new Ref.BooleanRef();
                CoroutineContext main = Dispatchers.getMain();
                DaijishouConsoleViewModel$commands$8$execute$2 daijishouConsoleViewModel$commands$8$execute$2 = new DaijishouConsoleViewModel$commands$8$execute$2(daijishouApplication, null);
                daijishouConsoleViewModel$commands$8$execute$1.L$0 = appCompatActivity2;
                daijishouConsoleViewModel$commands$8$execute$1.L$1 = choosePlayableItemFromLibraryDialogFragmentNewInstance$default;
                daijishouConsoleViewModel$commands$8$execute$1.L$2 = booleanRef;
                daijishouConsoleViewModel$commands$8$execute$1.label = 1;
                if (BuildersKt.withContext(main, daijishouConsoleViewModel$commands$8$execute$2, daijishouConsoleViewModel$commands$8$execute$1) != coroutine_suspended) {
                }
            }
            return DaijishouConsoleViewModel.Companion.getUnsupportedCommandResult();
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        Ref.BooleanRef booleanRef2 = (Ref.BooleanRef) daijishouConsoleViewModel$commands$8$execute$1.L$2;
        choosePlayableItemFromLibraryDialogFragmentNewInstance$default = (ChoosePlayableItemFromLibraryDialogFragment) daijishouConsoleViewModel$commands$8$execute$1.L$1;
        AppCompatActivity appCompatActivity3 = (AppCompatActivity) daijishouConsoleViewModel$commands$8$execute$1.L$0;
        ResultKt.throwOnFailure(obj);
        booleanRef = booleanRef2;
        appCompatActivity2 = appCompatActivity3;
        daijishouConsoleViewModel$commands$8$execute$1.L$0 = appCompatActivity2;
        daijishouConsoleViewModel$commands$8$execute$1.L$1 = choosePlayableItemFromLibraryDialogFragmentNewInstance$default;
        daijishouConsoleViewModel$commands$8$execute$1.L$2 = booleanRef;
        daijishouConsoleViewModel$commands$8$execute$1.label = 2;
        DaijishouConsoleViewModel$commands$8$execute$1 daijishouConsoleViewModel$commands$8$execute$3 = daijishouConsoleViewModel$commands$8$execute$1;
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(daijishouConsoleViewModel$commands$8$execute$3));
        final SafeContinuation safeContinuation2 = safeContinuation;
        choosePlayableItemFromLibraryDialogFragmentNewInstance$default.setOnClickListener(new Function1<PlayableItemEntity, Unit>() { // from class: com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel$commands$8$execute$3$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PlayableItemEntity playableItemEntity) {
                invoke2(playableItemEntity);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PlayableItemEntity it) {
                Intrinsics.checkNotNullParameter(it, "it");
                booleanRef.element = true;
                try {
                    Continuation<DaijishouConsoleViewModel.Companion.CommandResult> continuation2 = safeContinuation2;
                    Result.Companion companion = Result.Companion;
                    continuation2.resumeWith(Result.m478constructorimpl(new DaijishouConsoleViewModel.Companion.CommandResult("Results:\n" + FileUtils.INSTANCE.getFilePath((Context) appCompatActivity2, it.getUri()), 0, null, false, 14, null)));
                } catch (Exception e) {
                    Continuation<DaijishouConsoleViewModel.Companion.CommandResult> continuation3 = safeContinuation2;
                    Result.Companion companion2 = Result.Companion;
                    continuation3.resumeWith(Result.m478constructorimpl(new DaijishouConsoleViewModel.Companion.CommandResult("Results:\n" + ExceptionsKt.stackTraceToString(e), 0, null, false, 14, null)));
                }
                choosePlayableItemFromLibraryDialogFragmentNewInstance$default.dismiss();
            }
        }).setOnDialogDismissedListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel$commands$8$execute$3$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CancellationException cancellationException = new CancellationException("Aborted.");
                if (booleanRef.element) {
                    return;
                }
                Continuation<DaijishouConsoleViewModel.Companion.CommandResult> continuation2 = safeContinuation2;
                String message = cancellationException.getMessage();
                if (message == null) {
                    message = ExceptionsKt.stackTraceToString(cancellationException);
                }
                DaijishouConsoleViewModel.Companion.CommandResult commandResult = new DaijishouConsoleViewModel.Companion.CommandResult(message, DaijishouConsoleViewModel.Companion.CommandResult.Companion.getFAILED_STATUS_CODE(), cancellationException, false, 8, null);
                Result.Companion companion = Result.Companion;
                continuation2.resumeWith(Result.m478constructorimpl(commandResult));
            }
        }).show(appCompatActivity2.getSupportFragmentManager(), ChoosePlayableItemFromLibraryDialogFragment.class.getName());
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(daijishouConsoleViewModel$commands$8$execute$3);
        }
        return orThrow == coroutine_suspended ? coroutine_suspended : orThrow;
    }
}
