package com.magneticchen.daijishou.ui.model;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelKt;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.data.db.entity.PlatformEntity;
import com.magneticchen.daijishou.data.db.entity.PlayableItemEntity;
import com.magneticchen.daijishou.data.db.repositories.DaijishouLibraryRepository;
import com.magneticchen.daijishou.data.scraper.v2.impl.dsess.DSESS;
import com.magneticchen.daijishou.data.scraper.v2.impl.dsess.DSESSScraper;
import com.magneticchen.daijishou.ui.fragments.dialog.ChoosePlayableItemFromLibraryDialogFragment;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: DaijishouConsoleViewModel.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u0010"}, d2 = {"com/magneticchen/daijishou/ui/model/DaijishouConsoleViewModel$commands$5", "Lcom/magneticchen/daijishou/ui/model/DaijishouConsoleViewModel$Companion$Command;", "description", "", "getDescription", "()Ljava/lang/String;", "startWith", "getStartWith", "execute", "Lcom/magneticchen/daijishou/ui/model/DaijishouConsoleViewModel$Companion$CommandResult;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "command", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/magneticchen/daijishou/DaijishouApplication;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouConsoleViewModel$commands$5 extends DaijishouConsoleViewModel.Companion.Command {
    final /* synthetic */ DaijishouConsoleViewModel this$0;
    private final String startWith = "\\dsess ";
    private final String description = "DSESS command. A item picker prompt will show up after command.\nIn order to fill in required fields. Usage:\n> \\dsess \"Your DSESS String\"";

    DaijishouConsoleViewModel$commands$5(DaijishouConsoleViewModel daijishouConsoleViewModel) {
        this.this$0 = daijishouConsoleViewModel;
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
        DaijishouConsoleViewModel$commands$5$execute$1 daijishouConsoleViewModel$commands$5$execute$1;
        ChoosePlayableItemFromLibraryDialogFragment choosePlayableItemFromLibraryDialogFragmentNewInstance$default;
        AppCompatActivity appCompatActivity2;
        final DaijishouApplication daijishouApplication2;
        DaijishouConsoleViewModel$commands$5 daijishouConsoleViewModel$commands$5;
        DSESS dsess;
        final Ref.BooleanRef booleanRef;
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
                List listSplitCommandBySpaces = DaijishouConsoleViewModel.Companion.splitCommandBySpaces(str);
                DSESSScraper dSESSScraper = daijishouApplication.getScraperManager().getDSESSScraper();
                if (listSplitCommandBySpaces.size() >= 2) {
                    DSESS dSESSFromDSESSString = dSESSScraper.getDSESSFromDSESSString((String) listSplitCommandBySpaces.get(1));
                    if (dSESSFromDSESSString.getDsessParts().getTemplateTags().isEmpty()) {
                        return new DaijishouConsoleViewModel.Companion.CommandResult("This DSESS has empty template tag list.", DaijishouConsoleViewModel.Companion.CommandResult.Companion.getFAILED_STATUS_CODE(), null, false, 12, null);
                    }
                    choosePlayableItemFromLibraryDialogFragmentNewInstance$default = ChoosePlayableItemFromLibraryDialogFragment.Companion.newInstance$default(ChoosePlayableItemFromLibraryDialogFragment.Companion, null, false, false, false, false, false, 63, null);
                    Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                    CoroutineContext main = Dispatchers.getMain();
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
                return DaijishouConsoleViewModel.Companion.getUnsupportedCommandResult();
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
            final ChoosePlayableItemFromLibraryDialogFragment choosePlayableItemFromLibraryDialogFragment = choosePlayableItemFromLibraryDialogFragmentNewInstance$default;
            final DaijishouConsoleViewModel daijishouConsoleViewModel = daijishouConsoleViewModel$commands$5.this$0;
            daijishouConsoleViewModel$commands$5$execute$1.L$0 = appCompatActivity2;
            daijishouConsoleViewModel$commands$5$execute$1.L$1 = daijishouApplication2;
            daijishouConsoleViewModel$commands$5$execute$1.L$2 = dsess;
            daijishouConsoleViewModel$commands$5$execute$1.L$3 = choosePlayableItemFromLibraryDialogFragment;
            daijishouConsoleViewModel$commands$5$execute$1.L$4 = booleanRef;
            daijishouConsoleViewModel$commands$5$execute$1.L$5 = daijishouConsoleViewModel;
            daijishouConsoleViewModel$commands$5$execute$1.label = 2;
            SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(daijishouConsoleViewModel$commands$5$execute$1));
            final SafeContinuation safeContinuation2 = safeContinuation;
            final DSESS dsess2 = dsess;
            choosePlayableItemFromLibraryDialogFragment.setOnClickListener(new Function1<PlayableItemEntity, Unit>() { // from class: com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel$commands$5$execute$3$1
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
                    choosePlayableItemFromLibraryDialogFragment.dismiss();
                    List<String> scraperKeywordList = it.getScraperKeywordList();
                    String name = null;
                    if (it.getAttachedPlatformId() != null) {
                        DaijishouLibraryRepository daijishouLibraryRepository = daijishouApplication2.getDaijishouLibraryRepository();
                        Long attachedPlatformId = it.getAttachedPlatformId();
                        Intrinsics.checkNotNull(attachedPlatformId);
                        PlatformEntity platformByIdStatically = daijishouLibraryRepository.getPlatformByIdStatically(attachedPlatformId.longValue());
                        if (platformByIdStatically != null) {
                            name = platformByIdStatically.getName();
                        }
                    }
                    BuildersKt.launch$default(ViewModelKt.getViewModelScope(daijishouConsoleViewModel), Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass1(scraperKeywordList, daijishouConsoleViewModel, dsess2, name, safeContinuation2, null), 2, (Object) null);
                }

                /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel$commands$5$execute$3$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: DaijishouConsoleViewModel.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel$commands$5$execute$3$1$1", f = "DaijishouConsoleViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Continuation<DaijishouConsoleViewModel.Companion.CommandResult> $continuation;
                    final /* synthetic */ DSESS $dSESS;
                    final /* synthetic */ String $platformName;
                    final /* synthetic */ List<String> $scraperKeywordList;
                    int label;
                    final /* synthetic */ DaijishouConsoleViewModel this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    AnonymousClass1(List<String> list, DaijishouConsoleViewModel daijishouConsoleViewModel, DSESS dsess, String str, Continuation<? super DaijishouConsoleViewModel.Companion.CommandResult> continuation, Continuation<? super AnonymousClass1> continuation2) {
                        super(2, continuation2);
                        this.$scraperKeywordList = list;
                        this.this$0 = daijishouConsoleViewModel;
                        this.$dSESS = dsess;
                        this.$platformName = str;
                        this.$continuation = continuation;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$scraperKeywordList, this.this$0, this.$dSESS, this.$platformName, this.$continuation, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws UnsupportedEncodingException {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        List<String> list = this.$scraperKeywordList;
                        DaijishouConsoleViewModel daijishouConsoleViewModel = this.this$0;
                        DSESS dsess = this.$dSESS;
                        String str = this.$platformName;
                        Continuation<DaijishouConsoleViewModel.Companion.CommandResult> continuation = this.$continuation;
                        Iterator<T> it = list.iterator();
                        while (it.hasNext()) {
                            String genericNameDSESS = daijishouConsoleViewModel.toGenericNameDSESS((String) it.next());
                            String strScrape = dsess.scrape(genericNameDSESS, str, Locale.getDefault());
                            if (strScrape != null) {
                                Result.Companion companion = Result.Companion;
                                continuation.resumeWith(Result.m478constructorimpl(new DaijishouConsoleViewModel.Companion.CommandResult("DSESS result using keyword \"" + genericNameDSESS + "\":\n\n" + strScrape, 0, null, false, 14, null)));
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }
            }).setOnDialogDismissedListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel$commands$5$execute$3$2
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
                DebugProbesKt.probeCoroutineSuspended(daijishouConsoleViewModel$commands$5$execute$1);
            }
            return orThrow == coroutine_suspended ? coroutine_suspended : orThrow;
        } catch (Exception e) {
            String message = e.getMessage();
            if (message == null) {
                message = ExceptionsKt.stackTraceToString(e);
            }
            return new DaijishouConsoleViewModel.Companion.CommandResult(message, DaijishouConsoleViewModel.Companion.CommandResult.Companion.getFAILED_STATUS_CODE(), e, false, 8, null);
        }
    }
}
