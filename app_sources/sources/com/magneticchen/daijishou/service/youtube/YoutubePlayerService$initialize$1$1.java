package com.magneticchen.daijishou.service.youtube;

import com.magneticchen.daijishou.data.db.entity.PlatformEntity;
import com.magneticchen.daijishou.data.db.entity.PlayableItemEntity;
import com.magneticchen.daijishou.ui.model.DaijishouLibraryModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: YoutubePlayerService.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.service.youtube.YoutubePlayerService$initialize$1$1", f = "YoutubePlayerService.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
final class YoutubePlayerService$initialize$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PlayableItemEntity $entity;
    final /* synthetic */ YoutubePlayerService $this_apply;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    YoutubePlayerService$initialize$1$1(YoutubePlayerService youtubePlayerService, PlayableItemEntity playableItemEntity, Continuation<? super YoutubePlayerService$initialize$1$1> continuation) {
        super(2, continuation);
        this.$this_apply = youtubePlayerService;
        this.$entity = playableItemEntity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new YoutubePlayerService$initialize$1$1(this.$this_apply, this.$entity, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((YoutubePlayerService$initialize$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List<String> scraperSourceList;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ArrayList arrayList = new ArrayList();
            DaijishouLibraryModel daijishouLibraryModel = this.$this_apply.daijishouLibrary;
            Long attachedPlatformId = this.$entity.getAttachedPlatformId();
            PlatformEntity platformByIdStatically = daijishouLibraryModel.getPlatformByIdStatically(attachedPlatformId != null ? attachedPlatformId.longValue() : -1L);
            if (platformByIdStatically != null && (scraperSourceList = platformByIdStatically.getScraperSourceList()) != null) {
                Boxing.boxBoolean(arrayList.addAll(scraperSourceList));
            }
            String strScrapeYoutubeVideoIdByKeywords = this.$this_apply.daijishouLibrary.getScraper().scrapeYoutubeVideoIdByKeywords(arrayList, platformByIdStatically != null ? platformByIdStatically.getName() : null, this.$entity.getScraperKeywordList());
            if (strScrapeYoutubeVideoIdByKeywords != null) {
                YoutubePlayerService youtubePlayerService = this.$this_apply;
                CoroutineContext main = Dispatchers.getMain();
                YoutubePlayerService$initialize$1$1$2$1 youtubePlayerService$initialize$1$1$2$1 = new YoutubePlayerService$initialize$1$1$2$1(youtubePlayerService, strScrapeYoutubeVideoIdByKeywords, null);
                this.label = 1;
                if (BuildersKt.withContext(main, youtubePlayerService$initialize$1$1$2$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
