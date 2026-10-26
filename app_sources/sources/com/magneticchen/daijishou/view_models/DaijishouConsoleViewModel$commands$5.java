package com.magneticchen.daijishou.view_models;

import androidx.appcompat.app.AppCompatActivity;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.dialog_fragments.ChoosePlayableItemFromLibraryDialogFragment;
import com.magneticchen.daijishou.scraper.v2.impl.dsess.DSESS;
import com.magneticchen.daijishou.scraper.v2.impl.dsess.DSESSScraper;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* INFO: compiled from: DaijishouConsoleViewModel.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u0010"}, d2 = {"com/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$commands$5", "Lcom/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$Companion$Command;", "description", "", "getDescription", "()Ljava/lang/String;", "startWith", "getStartWith", "execute", "Lcom/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$Companion$CommandResult;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "command", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/magneticchen/daijishou/DaijishouApplication;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouConsoleViewModel$commands$5 extends DaijishouConsoleViewModel.Companion.Command {
    final /* synthetic */ DaijishouConsoleViewModel this$0;
    private final String startWith = "\\dsess ";
    private final String description = "DSESS command. A item picker prompt will show up after command.\nIn order to fill in required fields. Usage:\n> \\dsess \"Your DSESS String\"";

    DaijishouConsoleViewModel$commands$5(DaijishouConsoleViewModel daijishouConsoleViewModel) {
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

    /* WARN: Code duplicated, block: B:7:0x001a  */
    @Override // com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel.Companion.Command
    public Object execute(AppCompatActivity appCompatActivity, DaijishouApplication daijishouApplication, String str, Continuation<?> continuation) {
        DaijishouConsoleViewModel$commands$5$execute$1 daijishouConsoleViewModel$commands$5$execute$1;
        ChoosePlayableItemFromLibraryDialogFragment choosePlayableItemFromLibraryDialogFragmentNewInstance$default;
        AppCompatActivity appCompatActivity2;
        DaijishouApplication daijishouApplication2;
        DaijishouConsoleViewModel$commands$5 daijishouConsoleViewModel$commands$5;
        DSESS dsess;
        Ref.BooleanRef booleanRef;
        if (continuation instanceof DaijishouConsoleViewModel$commands$5$execute$1) {
            daijishouConsoleViewModel$commands$5$execute$1 = (DaijishouConsoleViewModel$commands$5$execute$1) continuation;
            if ((daijishouConsoleViewModel$commands$5$execute$1.label & Integer.MIN_VALUE) != 0) {
                daijishouConsoleViewModel$commands$5$execute$1.label -= Integer.MIN_VALUE;
            } else {
                daijishouConsoleViewModel$commands$5$execute$1 = new DaijishouConsoleViewModel$commands$5$execute$1(this, continuation);
            }
        } else {
            daijishouConsoleViewModel$commands$5$execute$1 = new DaijishouConsoleViewModel$commands$5$execute$1(this, continuation);
        }
        Object obj = daijishouConsoleViewModel$commands$5$execute$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = daijishouConsoleViewModel$commands$5$execute$1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                List listSplitCommandBySpaces = DaijishouConsoleViewModel.INSTANCE.splitCommandBySpaces(str);
                DSESSScraper dSESSScraper = daijishouApplication.getScraperManager().getDSESSScraper();
                if (listSplitCommandBySpaces.size() >= 2) {
                    DSESS dSESSFromDSESSString = dSESSScraper.getDSESSFromDSESSString((String) listSplitCommandBySpaces.get(1));
                    if (dSESSFromDSESSString.getDsessParts().getTemplateTags().isEmpty()) {
                        return new DaijishouConsoleViewModel.Companion.CommandResult("This DSESS has empty template tag list.", DaijishouConsoleViewModel.Companion.CommandResult.INSTANCE.getFAILED_STATUS_CODE(), null, false, 12, null);
                    }
                    choosePlayableItemFromLibraryDialogFragmentNewInstance$default = ChoosePlayableItemFromLibraryDialogFragment.Companion.newInstance$default(ChoosePlayableItemFromLibraryDialogFragment.INSTANCE, null, false, false, false, false, false, 63, null);
                    Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                    MainCoroutineDispatcher main = Dispatchers.getMain();
                    DaijishouConsoleViewModel$commands$5$execute$2 daijishouConsoleViewModel$commands$5$execute$2 = new DaijishouConsoleViewModel$commands$5$execute$2(daijishouApplication, null);
                    daijishouConsoleViewModel$commands$5$execute$1.L$0 = this;
                    appCompatActivity2 = appCompatActivity;
                    daijishouConsoleViewModel$commands$5$execute$1.L$1 = appCompatActivity2;
                    daijishouConsoleViewModel$commands$5$execute$1.L$2 = daijishouApplication;
                    daijishouConsoleViewModel$commands$5$execute$1.L$3 = dSESSFromDSESSString;
                    daijishouConsoleViewModel$commands$5$execute$1.L$4 = choosePlayableItemFromLibraryDialogFragmentNewInstance$default;
                    daijishouConsoleViewModel$commands$5$execute$1.L$5 = booleanRef2;
                    daijishouConsoleViewModel$commands$5$execute$1.label = 1;
                    if (BuildersKt.withContext(main, daijishouConsoleViewModel$commands$5$execute$2, daijishouConsoleViewModel$commands$5$execute$1) != coroutine_suspended) {
                        daijishouApplication2 = daijishouApplication;
                        daijishouConsoleViewModel$commands$5 = this;
                        dsess = dSESSFromDSESSString;
                        booleanRef = booleanRef2;
                    }
                }
                return DaijishouConsoleViewModel.INSTANCE.getUnsupportedCommandResult();
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            Ref.BooleanRef booleanRef3 = (Ref.BooleanRef) daijishouConsoleViewModel$commands$5$execute$1.L$5;
            choosePlayableItemFromLibraryDialogFragmentNewInstance$default = (ChoosePlayableItemFromLibraryDialogFragment) daijishouConsoleViewModel$commands$5$execute$1.L$4;
            dsess = (DSESS) daijishouConsoleViewModel$commands$5$execute$1.L$3;
            DaijishouApplication daijishouApplication3 = (DaijishouApplication) daijishouConsoleViewModel$commands$5$execute$1.L$2;
            AppCompatActivity appCompatActivity3 = (AppCompatActivity) daijishouConsoleViewModel$commands$5$execute$1.L$1;
            daijishouConsoleViewModel$commands$5 = (DaijishouConsoleViewModel$commands$5) daijishouConsoleViewModel$commands$5$execute$1.L$0;
            ResultKt.throwOnFailure(obj);
            booleanRef = booleanRef3;
            daijishouApplication2 = daijishouApplication3;
            appCompatActivity2 = appCompatActivity3;
            ChoosePlayableItemFromLibraryDialogFragment choosePlayableItemFromLibraryDialogFragment = choosePlayableItemFromLibraryDialogFragmentNewInstance$default;
            DaijishouConsoleViewModel daijishouConsoleViewModel = daijishouConsoleViewModel$commands$5.this$0;
            daijishouConsoleViewModel$commands$5$execute$1.L$0 = appCompatActivity2;
            daijishouConsoleViewModel$commands$5$execute$1.L$1 = daijishouApplication2;
            daijishouConsoleViewModel$commands$5$execute$1.L$2 = dsess;
            daijishouConsoleViewModel$commands$5$execute$1.L$3 = choosePlayableItemFromLibraryDialogFragment;
            daijishouConsoleViewModel$commands$5$execute$1.L$4 = booleanRef;
            daijishouConsoleViewModel$commands$5$execute$1.L$5 = daijishouConsoleViewModel;
            daijishouConsoleViewModel$commands$5$execute$1.label = 2;
            SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(daijishouConsoleViewModel$commands$5$execute$1));
            SafeContinuation safeContinuation2 = safeContinuation;
            choosePlayableItemFromLibraryDialogFragment.setOnClickListener(new DaijishouConsoleViewModel$commands$5$execute$3$1(booleanRef, choosePlayableItemFromLibraryDialogFragment, daijishouApplication2, daijishouConsoleViewModel, dsess, safeContinuation2)).setOnDialogDismissedListener(new DaijishouConsoleViewModel$commands$5$execute$3$2(booleanRef, safeContinuation2)).show(appCompatActivity2.getSupportFragmentManager(), ChoosePlayableItemFromLibraryDialogFragment.class.getName());
            Object orThrow = safeContinuation.getOrThrow();
            if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(daijishouConsoleViewModel$commands$5$execute$1);
            }
            return orThrow == coroutine_suspended ? coroutine_suspended : orThrow;
        } catch (Exception e) {
            String message = e.getMessage();
            if (message == null) {
                message = ExceptionsKt.stackTraceToString(e);
            }
            return new DaijishouConsoleViewModel.Companion.CommandResult(message, DaijishouConsoleViewModel.Companion.CommandResult.INSTANCE.getFAILED_STATUS_CODE(), e, false, 8, null);
        }
    }
}
