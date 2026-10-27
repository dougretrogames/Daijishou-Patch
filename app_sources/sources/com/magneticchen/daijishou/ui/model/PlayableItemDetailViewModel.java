package com.magneticchen.daijishou.ui.model;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.db.entity.ExtensionRepositoryExtensionToCategoryPairEntity;
import com.magneticchen.daijishou.data.db.entity.PlatformEntity;
import com.magneticchen.daijishou.data.db.entity.PlayableItemEntity;
import com.magneticchen.daijishou.data.db.repositories.DaijishouLibraryRepository;
import com.magneticchen.daijishou.data.live.ConnectionLiveData;
import com.magneticchen.daijishou.data.scraper.ScraperManager;
import com.magneticchen.daijishou.ui.model.abstract_view_models.DaijishouAndroidViewModel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: PlayableItemDetailViewModel.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u00142\u0006\u0010\u001d\u001a\u00020\u001bJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u001bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00060\fR\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0016\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0014X\u0082.¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/magneticchen/daijishou/ui/model/PlayableItemDetailViewModel;", "Lcom/magneticchen/daijishou/ui/model/abstract_view_models/DaijishouAndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "connectionLiveData", "Lcom/magneticchen/daijishou/data/live/ConnectionLiveData;", "connectionType", "", "daijishouLibraryRepository", "Lcom/magneticchen/daijishou/data/db/repositories/DaijishouLibraryRepository;", "logger", "Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "Lcom/magneticchen/daijishou/DaijishouApplication;", "platformEntityLiveData", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/magneticchen/daijishou/data/db/entity/PlatformEntity;", "getPlatformEntityLiveData", "()Landroidx/lifecycle/MediatorLiveData;", "platformLiveDataSource", "Landroidx/lifecycle/LiveData;", ExtensionRepositoryExtensionToCategoryPairEntity.SCRAPER_CATEGORY, "Lcom/magneticchen/daijishou/data/scraper/ScraperManager;", "selectedPlayableItemDescriptionLiveData", "", "getSelectedPlayableItemDescriptionLiveData", "selectedPlayableItemLiveDataSource", "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;", "onPlayableItem", "item", "scrapeLatestDetails", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PlayableItemDetailViewModel extends DaijishouAndroidViewModel {
    private final ConnectionLiveData connectionLiveData;
    private int connectionType;
    private final DaijishouLibraryRepository daijishouLibraryRepository;
    private final DaijishouApplication.WrappedLogger logger;
    private final MediatorLiveData<PlatformEntity> platformEntityLiveData;
    private LiveData<PlatformEntity> platformLiveDataSource;
    private final ScraperManager scraper;
    private final MediatorLiveData<String> selectedPlayableItemDescriptionLiveData;
    private LiveData<PlayableItemEntity> selectedPlayableItemLiveDataSource;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayableItemDetailViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.daijishouLibraryRepository = getApplication().getDaijishouLibraryRepository();
        Context applicationContext = application.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        ConnectionLiveData connectionLiveData = new ConnectionLiveData(applicationContext);
        this.connectionLiveData = connectionLiveData;
        this.scraper = getApplication().getScraperManager();
        this.logger = getApplication().getLogger();
        this.platformEntityLiveData = new MediatorLiveData<>();
        MediatorLiveData<String> mediatorLiveData = new MediatorLiveData<>();
        this.selectedPlayableItemDescriptionLiveData = mediatorLiveData;
        mediatorLiveData.addSource(connectionLiveData, new PlayableItemDetailViewModel$sam$androidx_lifecycle_Observer$0(new Function1<Integer, Unit>() { // from class: com.magneticchen.daijishou.ui.model.PlayableItemDetailViewModel.1
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                PlayableItemDetailViewModel playableItemDetailViewModel = PlayableItemDetailViewModel.this;
                Intrinsics.checkNotNull(num);
                playableItemDetailViewModel.connectionType = num.intValue();
            }
        }));
    }

    public final MediatorLiveData<PlatformEntity> getPlatformEntityLiveData() {
        return this.platformEntityLiveData;
    }

    public final MediatorLiveData<String> getSelectedPlayableItemDescriptionLiveData() {
        return this.selectedPlayableItemDescriptionLiveData;
    }

    public final LiveData<PlayableItemEntity> onPlayableItem(final PlayableItemEntity item) {
        Intrinsics.checkNotNullParameter(item, "item");
        LiveData<PlayableItemEntity> playableItemById = this.daijishouLibraryRepository.getPlayableItemById(item.getId());
        Long attachedPlatformId = item.getAttachedPlatformId();
        LiveData<PlatformEntity> liveData = this.platformLiveDataSource;
        LiveData<PlatformEntity> liveData2 = null;
        if (liveData != null) {
            MediatorLiveData<PlatformEntity> mediatorLiveData = this.platformEntityLiveData;
            if (liveData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("platformLiveDataSource");
                liveData = null;
            }
            mediatorLiveData.removeSource(liveData);
        }
        if (attachedPlatformId != null) {
            LiveData<PlatformEntity> platformById = this.daijishouLibraryRepository.getPlatformById(attachedPlatformId.longValue());
            this.platformLiveDataSource = platformById;
            if (platformById != null) {
                MediatorLiveData<PlatformEntity> mediatorLiveData2 = this.platformEntityLiveData;
                if (platformById == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("platformLiveDataSource");
                } else {
                    liveData2 = platformById;
                }
                mediatorLiveData2.addSource(liveData2, new PlayableItemDetailViewModel$sam$androidx_lifecycle_Observer$0(new Function1<PlatformEntity, Unit>() { // from class: com.magneticchen.daijishou.ui.model.PlayableItemDetailViewModel.onPlayableItem.1
                    

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(PlatformEntity platformEntity) {
                        invoke2(platformEntity);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(PlatformEntity platformEntity) {
                        MediatorLiveData<PlatformEntity> platformEntityLiveData = PlayableItemDetailViewModel.this.getPlatformEntityLiveData();
                        Intrinsics.checkNotNull(platformEntity);
                        platformEntityLiveData.postValue(platformEntity);
                    }
                }));
            }
        }
        if (this.selectedPlayableItemLiveDataSource != null) {
            LiveData liveData3 = this.selectedPlayableItemDescriptionLiveData;
            liveData3.removeSource(liveData3);
        }
        this.selectedPlayableItemLiveDataSource = playableItemById;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        this.selectedPlayableItemDescriptionLiveData.addSource(playableItemById, new PlayableItemDetailViewModel$sam$androidx_lifecycle_Observer$0(new Function1<PlayableItemEntity, Unit>() { // from class: com.magneticchen.daijishou.ui.model.PlayableItemDetailViewModel.onPlayableItem.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PlayableItemEntity playableItemEntity) {
                invoke2(playableItemEntity);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r0v1, types: [T, com.magneticchen.daijishou.data.db.entity.PlayableItemEntity] */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PlayableItemEntity playableItemEntity) {
                if (Intrinsics.areEqual(objectRef.element, item)) {
                    return;
                }
                objectRef.element = item;
                String description = item.getDescription();
                if (description == null || description.length() == 0) {
                    if (this.connectionType != -1) {
                        this.scrapeLatestDetails(item);
                        return;
                    } else {
                        this.getSelectedPlayableItemDescriptionLiveData().postValue(this.getApplication().getString(R.string.no_internet_connection));
                        return;
                    }
                }
                MediatorLiveData<String> selectedPlayableItemDescriptionLiveData = this.getSelectedPlayableItemDescriptionLiveData();
                String description2 = item.getDescription();
                Intrinsics.checkNotNull(description2);
                selectedPlayableItemDescriptionLiveData.postValue(description2);
            }
        }));
        return playableItemById;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scrapeLatestDetails(PlayableItemEntity playableItemEntity) {
        this.selectedPlayableItemDescriptionLiveData.postValue(getApplication().getString(R.string.loading) + "...");
        Long attachedPlatformId = playableItemEntity.getAttachedPlatformId();
        if (attachedPlatformId != null) {
            BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), Dispatchers.getIO(), (CoroutineStart) null, new C01371(attachedPlatformId, playableItemEntity, null), 2, (Object) null);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.model.PlayableItemDetailViewModel$scrapeLatestDetails$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PlayableItemDetailViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.model.PlayableItemDetailViewModel$scrapeLatestDetails$1", f = "PlayableItemDetailViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C01371 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Long $attachPlatformId;
        final /* synthetic */ PlayableItemEntity $item;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01371(Long l, PlayableItemEntity playableItemEntity, Continuation<? super C01371> continuation) {
            super(2, continuation);
            this.$attachPlatformId = l;
            this.$item = playableItemEntity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C01371 c01371 = PlayableItemDetailViewModel.this.new C01371(this.$attachPlatformId, this.$item, continuation);
            c01371.L$0 = obj;
            return c01371;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C01371) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                try {
                    PlatformEntity platformByIdStatically = PlayableItemDetailViewModel.this.daijishouLibraryRepository.getPlatformByIdStatically(this.$attachPlatformId.longValue());
                    if (platformByIdStatically != null) {
                        String strScrapeDescriptionByPlatformNameAndKeywords = PlayableItemDetailViewModel.this.scraper.scrapeDescriptionByPlatformNameAndKeywords(platformByIdStatically.getScraperSourceList(), platformByIdStatically.getName(), this.$item.getScraperKeywordList());
                        PlayableItemEntity playableItemByIdStatically = PlayableItemDetailViewModel.this.daijishouLibraryRepository.getPlayableItemByIdStatically(this.$item.getId());
                        if (playableItemByIdStatically != null) {
                            playableItemByIdStatically.setDescription(strScrapeDescriptionByPlatformNameAndKeywords);
                            PlayableItemDetailViewModel.this.daijishouLibraryRepository.updatePlayableItem(playableItemByIdStatically);
                            PlayableItemDetailViewModel.this.getSelectedPlayableItemDescriptionLiveData().postValue(strScrapeDescriptionByPlatformNameAndKeywords);
                        }
                    }
                } catch (Exception e) {
                    PlayableItemDetailViewModel.this.logger.warn(coroutineScope, ExceptionsKt.stackTraceToString(e));
                    if (this.$item.getDescription() != null) {
                        MediatorLiveData<String> selectedPlayableItemDescriptionLiveData = PlayableItemDetailViewModel.this.getSelectedPlayableItemDescriptionLiveData();
                        String description = this.$item.getDescription();
                        Intrinsics.checkNotNull(description);
                        selectedPlayableItemDescriptionLiveData.postValue(description);
                    } else {
                        PlayableItemDetailViewModel.this.getSelectedPlayableItemDescriptionLiveData().postValue("😥 " + PlayableItemDetailViewModel.this.getApplication().getString(R.string.item_description_error_prefix) + "<br>" + e.getMessage());
                    }
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
