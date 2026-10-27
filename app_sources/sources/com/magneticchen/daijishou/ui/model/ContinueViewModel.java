package com.magneticchen.daijishou.ui.model;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.Constants;
import com.magneticchen.daijishou.data.db.entity.ExtensionRepositoryExtensionToCategoryPairEntity;
import com.magneticchen.daijishou.data.db.entity.PlatformEntity;
import com.magneticchen.daijishou.data.db.entity.PlayableItemEntity;
import com.magneticchen.daijishou.data.db.repositories.DaijishouLibraryRepository;
import com.magneticchen.daijishou.data.live.ConnectionLiveData;
import com.magneticchen.daijishou.data.scraper.ScraperManager;
import com.magneticchen.daijishou.ui.model.abstract_view_models.DaijishouAndroidViewModel;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: ContinueViewModel.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u001d\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/magneticchen/daijishou/ui/model/ContinueViewModel;", "Lcom/magneticchen/daijishou/ui/model/abstract_view_models/DaijishouAndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "connectionLiveData", "Lcom/magneticchen/daijishou/data/live/ConnectionLiveData;", "connectionType", "", "daijishouLibraryRepository", "Lcom/magneticchen/daijishou/data/db/repositories/DaijishouLibraryRepository;", "platformEntityLiveData", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/magneticchen/daijishou/data/db/entity/PlatformEntity;", "getPlatformEntityLiveData", "()Landroidx/lifecycle/MediatorLiveData;", "platformLiveDataSource", "Landroidx/lifecycle/LiveData;", "recentDate", "Ljava/util/Date;", "recentPlayableItemDescriptionLiveData", "", "getRecentPlayableItemDescriptionLiveData", "recentPlayableItemLiveData", "", "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;", "getRecentPlayableItemLiveData", "()Landroidx/lifecycle/LiveData;", ExtensionRepositoryExtensionToCategoryPairEntity.SCRAPER_CATEGORY, "Lcom/magneticchen/daijishou/data/scraper/ScraperManager;", "getScraper", "()Lcom/magneticchen/daijishou/data/scraper/ScraperManager;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ContinueViewModel extends DaijishouAndroidViewModel {
    private final ConnectionLiveData connectionLiveData;
    private int connectionType;
    private final DaijishouLibraryRepository daijishouLibraryRepository;
    private final MediatorLiveData<PlatformEntity> platformEntityLiveData;
    private LiveData<PlatformEntity> platformLiveDataSource;
    private final Date recentDate;
    private final MediatorLiveData<String> recentPlayableItemDescriptionLiveData;
    private final LiveData<List<PlayableItemEntity>> recentPlayableItemLiveData;
    private final ScraperManager scraper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r5v5, types: [T, java.util.List] */
    public ContinueViewModel(final Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        DaijishouLibraryRepository daijishouLibraryRepository = getApplication().getDaijishouLibraryRepository();
        this.daijishouLibraryRepository = daijishouLibraryRepository;
        Context applicationContext = application.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        ConnectionLiveData connectionLiveData = new ConnectionLiveData(applicationContext);
        this.connectionLiveData = connectionLiveData;
        Date date = new Date(System.currentTimeMillis() - Duration.m1822getInWholeMillisecondsimpl(Constants.INSTANCE.m143getRecentDurationDefinitionUwyO8pc()));
        this.recentDate = date;
        LiveData<List<PlayableItemEntity>> recentPlayableItems = daijishouLibraryRepository.getRecentPlayableItems(date, 1);
        this.recentPlayableItemLiveData = recentPlayableItems;
        MediatorLiveData<PlatformEntity> mediatorLiveData = new MediatorLiveData<>();
        this.platformEntityLiveData = mediatorLiveData;
        MediatorLiveData<String> mediatorLiveData2 = new MediatorLiveData<>();
        this.recentPlayableItemDescriptionLiveData = mediatorLiveData2;
        this.scraper = getApplication().getScraperManager();
        mediatorLiveData.addSource(recentPlayableItems, new ContinueViewModel$sam$androidx_lifecycle_Observer$0(new Function1<List<? extends PlayableItemEntity>, Unit>() { // from class: com.magneticchen.daijishou.ui.model.ContinueViewModel.1
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends PlayableItemEntity> list) {
                invoke2((List<PlayableItemEntity>) list);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<PlayableItemEntity> list) {
                Intrinsics.checkNotNull(list);
                if (list.isEmpty()) {
                    return;
                }
                Long attachedPlatformId = list.get(0).getAttachedPlatformId();
                LiveData liveData = ContinueViewModel.this.platformLiveDataSource;
                if (liveData != null) {
                    ContinueViewModel.this.getPlatformEntityLiveData().removeSource(liveData);
                }
                if (attachedPlatformId != null) {
                    final ContinueViewModel continueViewModel = ContinueViewModel.this;
                    continueViewModel.platformLiveDataSource = continueViewModel.daijishouLibraryRepository.getPlatformById(attachedPlatformId.longValue());
                    LiveData liveData2 = continueViewModel.platformLiveDataSource;
                    if (liveData2 != null) {
                        continueViewModel.getPlatformEntityLiveData().addSource(liveData2, new ContinueViewModel$sam$androidx_lifecycle_Observer$0(new Function1<PlatformEntity, Unit>() { // from class: com.magneticchen.daijishou.ui.model.ContinueViewModel$1$2$1$1
                            

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(PlatformEntity platformEntity) {
                                invoke2(platformEntity);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(PlatformEntity platformEntity) {
                                continueViewModel.getPlatformEntityLiveData().postValue(platformEntity);
                            }
                        }));
                    }
                }
            }
        }));
        final Ref.LongRef longRef = new Ref.LongRef();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = CollectionsKt.emptyList();
        mediatorLiveData2.addSource(connectionLiveData, new ContinueViewModel$sam$androidx_lifecycle_Observer$0(new Function1<Integer, Unit>() { // from class: com.magneticchen.daijishou.ui.model.ContinueViewModel.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                ContinueViewModel continueViewModel = ContinueViewModel.this;
                Intrinsics.checkNotNull(num);
                continueViewModel.connectionType = num.intValue();
                ContinueViewModel._init_$updateDescription(objectRef, longRef, ContinueViewModel.this, application);
            }
        }));
        mediatorLiveData2.addSource(recentPlayableItems, new ContinueViewModel$sam$androidx_lifecycle_Observer$0(new Function1<List<? extends PlayableItemEntity>, Unit>() { // from class: com.magneticchen.daijishou.ui.model.ContinueViewModel.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends PlayableItemEntity> list) {
                invoke2((List<PlayableItemEntity>) list);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<PlayableItemEntity> list) {
                Ref.ObjectRef<List<PlayableItemEntity>> objectRef2 = objectRef;
                Intrinsics.checkNotNull(list);
                objectRef2.element = list;
                ContinueViewModel._init_$updateDescription(objectRef, longRef, this, application);
            }
        }));
    }

    public final LiveData<List<PlayableItemEntity>> getRecentPlayableItemLiveData() {
        return this.recentPlayableItemLiveData;
    }

    public final MediatorLiveData<PlatformEntity> getPlatformEntityLiveData() {
        return this.platformEntityLiveData;
    }

    public final MediatorLiveData<String> getRecentPlayableItemDescriptionLiveData() {
        return this.recentPlayableItemDescriptionLiveData;
    }

    public final ScraperManager getScraper() {
        return this.scraper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$updateDescription(Ref.ObjectRef<List<PlayableItemEntity>> objectRef, Ref.LongRef longRef, ContinueViewModel continueViewModel, Application application) {
        if (objectRef.element.isEmpty()) {
            return;
        }
        PlayableItemEntity playableItemEntity = objectRef.element.get(0);
        if (longRef.element == playableItemEntity.getId()) {
            return;
        }
        if (continueViewModel.connectionType != -1) {
            continueViewModel.recentPlayableItemDescriptionLiveData.postValue(application.getString(R.string.loading) + "...");
            String description = playableItemEntity.getDescription();
            if (description != null) {
                continueViewModel.recentPlayableItemDescriptionLiveData.postValue(description);
            }
            BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) continueViewModel), Dispatchers.getIO(), (CoroutineStart) null, new ContinueViewModel$updateDescription$2(playableItemEntity, continueViewModel, application, longRef, null), 2, (Object) null);
            return;
        }
        if (playableItemEntity.getDescription() != null) {
            String description2 = playableItemEntity.getDescription();
            if (description2 != null) {
                continueViewModel.recentPlayableItemDescriptionLiveData.postValue(description2);
                return;
            }
            return;
        }
        continueViewModel.recentPlayableItemDescriptionLiveData.postValue(application.getString(R.string.no_internet_connection));
    }
}
