package com.magneticchen.daijishou.view_models;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModelKt;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.daijishou_library_db.PlatformEntity;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import com.magneticchen.daijishou.live_data.ConnectionLiveData;
import com.magneticchen.daijishou.repositories.DaijishouLibraryRepository;
import com.magneticchen.daijishou.scraper.ScraperManager;
import com.magneticchen.daijishou.view_models.abstract_view_models.DaijishouAndroidViewModel;
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
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: PlayableItemDetailViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u00162\u0006\u0010!\u001a\u00020\u001fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u000b\u001a\u00060\fR\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0018\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/magneticchen/daijishou/view_models/PlayableItemDetailViewModel;", "Lcom/magneticchen/daijishou/view_models/abstract_view_models/DaijishouAndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "connectionLiveData", "Lcom/magneticchen/daijishou/live_data/ConnectionLiveData;", "connectionType", "", "daijishouLibraryRepository", "Lcom/magneticchen/daijishou/repositories/DaijishouLibraryRepository;", "logger", "Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "Lcom/magneticchen/daijishou/DaijishouApplication;", "getLogger", "()Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "platformEntityLiveData", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;", "getPlatformEntityLiveData", "()Landroidx/lifecycle/MediatorLiveData;", "platformLiveDataSource", "Landroidx/lifecycle/LiveData;", "scraper", "Lcom/magneticchen/daijishou/scraper/ScraperManager;", "getScraper", "()Lcom/magneticchen/daijishou/scraper/ScraperManager;", "selectedPlayableItemDescriptionLiveData", "", "getSelectedPlayableItemDescriptionLiveData", "selectedPlayableItemLiveDataSource", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "selectedPlayableItem", "selectedPlayableItemEntity", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
        this.platformEntityLiveData = new MediatorLiveData<>();
        MediatorLiveData<String> mediatorLiveData = new MediatorLiveData<>();
        this.selectedPlayableItemDescriptionLiveData = mediatorLiveData;
        this.scraper = getApplication().getScraperManager();
        this.logger = getApplication().getLogger();
        mediatorLiveData.addSource(connectionLiveData, new PlayableItemDetailViewModel$sam$androidx_lifecycle_Observer$0(new AnonymousClass1()));
    }

    public final MediatorLiveData<PlatformEntity> getPlatformEntityLiveData() {
        return this.platformEntityLiveData;
    }

    public final MediatorLiveData<String> getSelectedPlayableItemDescriptionLiveData() {
        return this.selectedPlayableItemDescriptionLiveData;
    }

    public final ScraperManager getScraper() {
        return this.scraper;
    }

    public final DaijishouApplication.WrappedLogger getLogger() {
        return this.logger;
    }

    public final LiveData<PlayableItemEntity> selectedPlayableItem(PlayableItemEntity selectedPlayableItemEntity) {
        Intrinsics.checkNotNullParameter(selectedPlayableItemEntity, "selectedPlayableItemEntity");
        LiveData<PlayableItemEntity> playableItemById = this.daijishouLibraryRepository.getPlayableItemById(selectedPlayableItemEntity.getId());
        Long attachedPlatformId = selectedPlayableItemEntity.getAttachedPlatformId();
        LiveData<PlatformEntity> liveData = this.platformLiveDataSource;
        if (liveData != null) {
            this.platformEntityLiveData.removeSource(liveData);
        }
        if (attachedPlatformId != null) {
            LiveData<PlatformEntity> platformById = this.daijishouLibraryRepository.getPlatformById(attachedPlatformId.longValue());
            this.platformLiveDataSource = platformById;
            if (platformById != null) {
                this.platformEntityLiveData.addSource(platformById, new PlayableItemDetailViewModel$sam$androidx_lifecycle_Observer$0(new PlayableItemDetailViewModel$selectedPlayableItem$2$1$1(this)));
            }
        }
        Ref.LongRef longRef = new Ref.LongRef();
        LiveData<PlayableItemEntity> liveData2 = this.selectedPlayableItemLiveDataSource;
        if (liveData2 != null) {
            this.selectedPlayableItemDescriptionLiveData.removeSource(liveData2);
        }
        this.selectedPlayableItemLiveDataSource = playableItemById;
        this.selectedPlayableItemDescriptionLiveData.addSource(playableItemById, new PlayableItemDetailViewModel$sam$androidx_lifecycle_Observer$0(new AnonymousClass4(longRef, selectedPlayableItemEntity, this, attachedPlatformId)));
        return playableItemById;
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.view_models.PlayableItemDetailViewModel$selectedPlayableItem$4, reason: invalid class name */
    /* JADX INFO: compiled from: PlayableItemDetailViewModel.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass4 extends Lambda<Unit> implements Function1<PlayableItemEntity, Unit> {
        final /* synthetic */ Long $attachPlatformId;
        final /* synthetic */ Ref.LongRef $previousLoadedPlayableItemId;
        final /* synthetic */ PlayableItemEntity $selectedPlayableItemEntity;
        final /* synthetic */ PlayableItemDetailViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(Ref.LongRef longRef, PlayableItemEntity playableItemEntity, PlayableItemDetailViewModel playableItemDetailViewModel, Long l) {
            super(1);
            this.$previousLoadedPlayableItemId = longRef;
            this.$selectedPlayableItemEntity = playableItemEntity;
            this.this$0 = playableItemDetailViewModel;
            this.$attachPlatformId = l;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PlayableItemEntity playableItemEntity) {
            invoke2(playableItemEntity);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PlayableItemEntity playableItemEntity) {
            if (this.$previousLoadedPlayableItemId.element == this.$selectedPlayableItemEntity.getId()) {
                return;
            }
            if (this.this$0.connectionType != -1) {
                this.this$0.getSelectedPlayableItemDescriptionLiveData().postValue(this.this$0.getApplication().getString(R.string.loading) + "...");
                String description = this.$selectedPlayableItemEntity.getDescription();
                if (description != null) {
                    this.this$0.getSelectedPlayableItemDescriptionLiveData().postValue(description);
                }
                BuildersKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), Dispatchers.getIO(), null, new AnonymousClass2(this.$attachPlatformId, this.this$0, this.$selectedPlayableItemEntity, this.$previousLoadedPlayableItemId, null), 2, null);
                return;
            }
            if (this.$selectedPlayableItemEntity.getDescription() != null) {
                String description2 = this.$selectedPlayableItemEntity.getDescription();
                if (description2 != null) {
                    this.this$0.getSelectedPlayableItemDescriptionLiveData().postValue(description2);
                    return;
                }
                return;
            }
            this.this$0.getSelectedPlayableItemDescriptionLiveData().postValue(this.this$0.getApplication().getString(R.string.no_internet_connection));
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.view_models.PlayableItemDetailViewModel$selectedPlayableItem$4$2, reason: invalid class name */
        /* JADX INFO: compiled from: PlayableItemDetailViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.view_models.PlayableItemDetailViewModel$selectedPlayableItem$4$2", f = "PlayableItemDetailViewModel.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
        static final class AnonymousClass2 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
            final /* synthetic */ Long $attachPlatformId;
            final /* synthetic */ Ref.LongRef $previousLoadedPlayableItemId;
            final /* synthetic */ PlayableItemEntity $selectedPlayableItemEntity;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ PlayableItemDetailViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(Long l, PlayableItemDetailViewModel playableItemDetailViewModel, PlayableItemEntity playableItemEntity, Ref.LongRef longRef, Continuation<?> continuation) {
                super(2, continuation);
                this.$attachPlatformId = l;
                this.this$0 = playableItemDetailViewModel;
                this.$selectedPlayableItemEntity = playableItemEntity;
                this.$previousLoadedPlayableItemId = longRef;
            }


            public final Continuation create(Object obj, Continuation<?> continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$attachPlatformId, this.this$0, this.$selectedPlayableItemEntity, this.$previousLoadedPlayableItemId, continuation);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
                try {
                    try {
                        return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
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
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                try {
                    Long l = this.$attachPlatformId;
                    if (l != null) {
                        PlayableItemDetailViewModel playableItemDetailViewModel = this.this$0;
                        PlayableItemEntity playableItemEntity = this.$selectedPlayableItemEntity;
                        Ref.LongRef longRef = this.$previousLoadedPlayableItemId;
                        PlatformEntity platformByIdStatically = playableItemDetailViewModel.daijishouLibraryRepository.getPlatformByIdStatically(l.longValue());
                        if (platformByIdStatically != null) {
                            String strScrapeDescriptionByPlatformNameAndKeywords = playableItemDetailViewModel.getScraper().scrapeDescriptionByPlatformNameAndKeywords(platformByIdStatically.getScraperSourceList(), platformByIdStatically.getName(), playableItemEntity.getScraperKeywordList());
                            PlayableItemEntity playableItemByIdStatically = playableItemDetailViewModel.daijishouLibraryRepository.getPlayableItemByIdStatically(playableItemEntity.getId());
                            if (playableItemByIdStatically != null) {
                                playableItemByIdStatically.setDescription(strScrapeDescriptionByPlatformNameAndKeywords);
                                playableItemDetailViewModel.daijishouLibraryRepository.updatePlayableItem(playableItemByIdStatically);
                                playableItemDetailViewModel.getSelectedPlayableItemDescriptionLiveData().postValue(strScrapeDescriptionByPlatformNameAndKeywords);
                                longRef.element = playableItemEntity.getId();
                            }
                        }
                    }
                } catch (Exception e) {
                    this.this$0.getLogger().warn(coroutineScope, ExceptionsKt.stackTraceToString(e));
                    this.this$0.getSelectedPlayableItemDescriptionLiveData().postValue("😥 " + this.this$0.getApplication().getString(R.string.item_description_error_prefix) + "<br>" + e.getMessage());
                    String description = this.$selectedPlayableItemEntity.getDescription();
                    if (description != null) {
                        this.this$0.getSelectedPlayableItemDescriptionLiveData().postValue(description);
                    }
                }
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.view_models.PlayableItemDetailViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: PlayableItemDetailViewModel.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass1 extends Lambda<Unit> implements Function1<Integer, Unit> {
        AnonymousClass1() {
            super(1);
        }

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
    }
}
