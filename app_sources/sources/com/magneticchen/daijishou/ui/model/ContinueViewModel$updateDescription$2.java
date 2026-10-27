package com.magneticchen.daijishou.ui.model;

import android.app.Application;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.db.entity.PlatformEntity;
import com.magneticchen.daijishou.data.db.entity.PlayableItemEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ContinueViewModel.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.ui.model.ContinueViewModel$updateDescription$2", f = "ContinueViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ContinueViewModel$updateDescription$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Application $application;
    final /* synthetic */ Ref.LongRef $previousLoadedPlayableItemId;
    final /* synthetic */ PlayableItemEntity $recentPlayableItem;
    int label;
    final /* synthetic */ ContinueViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ContinueViewModel$updateDescription$2(PlayableItemEntity playableItemEntity, ContinueViewModel continueViewModel, Application application, Ref.LongRef longRef, Continuation<? super ContinueViewModel$updateDescription$2> continuation) {
        super(2, continuation);
        this.$recentPlayableItem = playableItemEntity;
        this.this$0 = continueViewModel;
        this.$application = application;
        this.$previousLoadedPlayableItemId = longRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ContinueViewModel$updateDescription$2(this.$recentPlayableItem, this.this$0, this.$application, this.$previousLoadedPlayableItemId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ContinueViewModel$updateDescription$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        try {
            Long attachedPlatformId = this.$recentPlayableItem.getAttachedPlatformId();
            if (attachedPlatformId != null) {
                ContinueViewModel continueViewModel = this.this$0;
                PlayableItemEntity playableItemEntity = this.$recentPlayableItem;
                Ref.LongRef longRef = this.$previousLoadedPlayableItemId;
                PlatformEntity platformByIdStatically = continueViewModel.daijishouLibraryRepository.getPlatformByIdStatically(attachedPlatformId.longValue());
                if (platformByIdStatically != null) {
                    String strScrapeDescriptionByPlatformNameAndKeywords = continueViewModel.getScraper().scrapeDescriptionByPlatformNameAndKeywords(platformByIdStatically.getScraperSourceList(), platformByIdStatically.getName(), playableItemEntity.getScraperKeywordList());
                    PlayableItemEntity playableItemByIdStatically = continueViewModel.daijishouLibraryRepository.getPlayableItemByIdStatically(playableItemEntity.getId());
                    if (playableItemByIdStatically != null) {
                        playableItemByIdStatically.setDescription(strScrapeDescriptionByPlatformNameAndKeywords);
                        continueViewModel.daijishouLibraryRepository.updatePlayableItem(playableItemByIdStatically);
                        continueViewModel.getRecentPlayableItemDescriptionLiveData().postValue(strScrapeDescriptionByPlatformNameAndKeywords);
                        longRef.element = playableItemEntity.getId();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.this$0.getRecentPlayableItemDescriptionLiveData().postValue("😥 " + this.$application.getString(R.string.item_description_error_prefix) + "<br>" + e.getMessage());
            String description = this.$recentPlayableItem.getDescription();
            if (description != null) {
                this.this$0.getRecentPlayableItemDescriptionLiveData().postValue(description);
            }
        }
        return Unit.INSTANCE;
    }
}
