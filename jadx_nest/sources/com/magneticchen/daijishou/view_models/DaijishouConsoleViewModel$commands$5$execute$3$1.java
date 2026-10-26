package com.magneticchen.daijishou.view_models;

import androidx.lifecycle.ViewModelKt;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.daijishou_library_db.PlatformEntity;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import com.magneticchen.daijishou.dialog_fragments.ChoosePlayableItemFromLibraryDialogFragment;
import com.magneticchen.daijishou.repositories.DaijishouLibraryRepository;
import com.magneticchen.daijishou.scraper.v2.impl.dsess.DSESS;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* INFO: compiled from: DaijishouConsoleViewModel.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class DaijishouConsoleViewModel$commands$5$execute$3$1 extends Lambda<Unit> implements Function1<PlayableItemEntity, Unit> {
    final /* synthetic */ DaijishouApplication $application;
    final /* synthetic */ Continuation<DaijishouConsoleViewModel.Companion.CommandResult> $continuation;
    final /* synthetic */ DSESS $dSESS;
    final /* synthetic */ ChoosePlayableItemFromLibraryDialogFragment $dialog;
    final /* synthetic */ Ref.BooleanRef $selected;
    final /* synthetic */ DaijishouConsoleViewModel this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* WARN: Multi-variable type inference failed */
    DaijishouConsoleViewModel$commands$5$execute$3$1(Ref.BooleanRef booleanRef, ChoosePlayableItemFromLibraryDialogFragment choosePlayableItemFromLibraryDialogFragment, DaijishouApplication daijishouApplication, DaijishouConsoleViewModel daijishouConsoleViewModel, DSESS dsess, Continuation<?> continuation) {
        super(1);
        this.$selected = booleanRef;
        this.$dialog = choosePlayableItemFromLibraryDialogFragment;
        this.$application = daijishouApplication;
        this.this$0 = daijishouConsoleViewModel;
        this.$dSESS = dsess;
        this.$continuation = (Continuation<DaijishouConsoleViewModel.Companion.CommandResult>) continuation;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PlayableItemEntity playableItemEntity) {
        invoke2(playableItemEntity);
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(PlayableItemEntity it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this.$selected.element = true;
        this.$dialog.dismiss();
        List<String> scraperKeywordList = it.getScraperKeywordList();
        String name = null;
        if (it.getAttachedPlatformId() != null) {
            DaijishouLibraryRepository daijishouLibraryRepository = this.$application.getDaijishouLibraryRepository();
            Long attachedPlatformId = it.getAttachedPlatformId();
            Intrinsics.checkNotNull(attachedPlatformId);
            PlatformEntity platformByIdStatically = daijishouLibraryRepository.getPlatformByIdStatically(attachedPlatformId.longValue());
            if (platformByIdStatically != null) {
                name = platformByIdStatically.getName();
            }
        }
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), Dispatchers.getIO(), null, new AnonymousClass1(scraperKeywordList, this.this$0, this.$dSESS, name, this.$continuation, null), 2, null);
    }

    /* INFO: renamed from: com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel$commands$5$execute$3$1$1, reason: invalid class name */
    /* INFO: compiled from: DaijishouConsoleViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel$commands$5$execute$3$1$1", f = "DaijishouConsoleViewModel.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
    static final class AnonymousClass1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        final /* synthetic */ Continuation<DaijishouConsoleViewModel.Companion.CommandResult> $continuation;
        final /* synthetic */ DSESS $dSESS;
        final /* synthetic */ String $platformName;
        final /* synthetic */ List<String> $scraperKeywordList;
        int label;
        final /* synthetic */ DaijishouConsoleViewModel this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* WARN: Multi-variable type inference failed */
        AnonymousClass1(List<String> list, DaijishouConsoleViewModel daijishouConsoleViewModel, DSESS dsess, String str, Continuation<?> continuation, Continuation<?> continuation2) {
            super(2, continuation2);
            this.$scraperKeywordList = list;
            this.this$0 = daijishouConsoleViewModel;
            this.$dSESS = dsess;
            this.$platformName = str;
            this.$continuation = (Continuation<DaijishouConsoleViewModel.Companion.CommandResult>) continuation;
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$scraperKeywordList, this.this$0, this.$dSESS, this.$platformName, this.$continuation, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                try {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                }
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
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
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String genericNameDSESS = daijishouConsoleViewModel.toGenericNameDSESS((String) it.next());
                String strScrape = dsess.scrape(genericNameDSESS, str, Locale.getDefault());
                if (strScrape != null) {
                    Result.Companion companion = Result.Companion;
                    continuation.resumeWith(com.magneticchen.daijishou.support.DaijishouValueSupport.resultConstructor(new DaijishouConsoleViewModel.Companion.CommandResult("DSESS result using keyword \"" + genericNameDSESS + "\":\n\n" + strScrape, 0, null, false, 14, null)));
                }
            }
            return Unit.INSTANCE;
        }
    }
}
