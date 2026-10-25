package com.magneticchen.daijishou.view_models;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.net.Uri;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.magneticchen.daijishou.application_data.BooleanPreference;
import com.magneticchen.daijishou.application_data.Constants;
import com.magneticchen.daijishou.application_data.LongPreference;
import com.magneticchen.daijishou.daijishou_library_db.PlatformEntity;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import com.magneticchen.daijishou.live_data.PairLiveData;
import com.magneticchen.daijishou.live_data.SharedPreferenceBooleanLiveData;
import com.magneticchen.daijishou.repositories.DaijishouLibraryRepository;
import com.magneticchen.daijishou.utils.Utils;
import com.magneticchen.daijishou.view_models.abstract_view_models.DaijishouAndroidViewModel;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.time.Duration;

/* JADX INFO: compiled from: LibraryViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 22\u00020\u0001:\u00012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u00110\u000bJ\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u0011J\u0006\u0010'\u001a\u00020\u0010J\u0006\u0010(\u001a\u00020\u0007J\u0016\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.J\u000e\u0010/\u001a\u00020*2\u0006\u00100\u001a\u00020\u0007J\u0006\u00101\u001a\u00020\u0010R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u001d\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00110!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u00063"}, d2 = {"Lcom/magneticchen/daijishou/view_models/LibraryViewModel;", "Lcom/magneticchen/daijishou/view_models/abstract_view_models/DaijishouAndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_selectedPlatformIdLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "daijishouLibraryRepository", "Lcom/magneticchen/daijishou/repositories/DaijishouLibraryRepository;", "oldFavoriteLiveData", "Landroidx/lifecycle/LiveData;", "oldNewlyLiveData", "oldRecentLiveData", "platformWallpaperColorsList", "Lcom/magneticchen/daijishou/utils/Utils$MaxSizeHashMap;", "", "", "Landroid/content/res/ColorStateList;", "getPlatformWallpaperColorsList", "()Lcom/magneticchen/daijishou/utils/Utils$MaxSizeHashMap;", "preferences", "Landroid/content/SharedPreferences;", "getPreferences", "()Landroid/content/SharedPreferences;", "previewMode", "selectedPlatformEntityLiveData", "Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;", "getSelectedPlatformEntityLiveData", "()Landroidx/lifecycle/LiveData;", "selectedPlatformIdLiveData", "getSelectedPlatformIdLiveData", "selectedPlatformStatistics", "Landroidx/lifecycle/MediatorLiveData;", "getSelectedPlatformStatistics", "()Landroidx/lifecycle/MediatorLiveData;", "getAllPlayableItems", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "getAllPlayableItemsStatically", "getPreviewAspectRatioMode", "getSelectedPlatformId", "removeSelectedPlatformSyncTreeUriSafely", "", "uri", "Landroid/net/Uri;", "keepRecords", "", "setSelectedPlatformId", "id", "togglePreviewAspectRatioMode", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LibraryViewModel extends DaijishouAndroidViewModel {
    public static final int DEFAULT_FILTER_MODE = 0;
    public static final int FAVORITE_FILTER_MODE = 1;
    public static final int GENRES_FILTER_MODE = 4;
    public static final int NEWLY_FILTER_MODE = 3;
    public static final int RECENT_FILTER_MODE = 2;
    private final MutableLiveData<Long> _selectedPlatformIdLiveData;
    public final DaijishouLibraryRepository daijishouLibraryRepository;
    private LiveData<Long> oldFavoriteLiveData;
    private LiveData<Long> oldNewlyLiveData;
    private LiveData<Long> oldRecentLiveData;
    private final Utils.MaxSizeHashMap<Integer, List<ColorStateList>> platformWallpaperColorsList;
    private final SharedPreferences preferences;
    private int previewMode;
    private final LiveData<PlatformEntity> selectedPlatformEntityLiveData;
    private final MediatorLiveData<List<Long>> selectedPlatformStatistics;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LibraryViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        SharedPreferences sharedPreferences = getApplication().getSharedPreferences("platform_library_view_model", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.preferences = sharedPreferences;
        this.previewMode = sharedPreferences.getInt("preview_mode", 0);
        this.daijishouLibraryRepository = new DaijishouLibraryRepository(application, null, null, 6, null);
        this.platformWallpaperColorsList = new Utils.MaxSizeHashMap<>(256);
        MutableLiveData<Long> mutableLiveData = new MutableLiveData<>();
        this._selectedPlatformIdLiveData = mutableLiveData;
        LiveData<PlatformEntity> liveDataSwitchMap = Transformations.switchMap(new PairLiveData(getSelectedPlatformIdLiveData(), new SharedPreferenceBooleanLiveData(getApplication().getDefaultSharedPreferences(), BooleanPreference.MERGE_PLAYABLE_ITEMS.getKey(), BooleanPreference.MERGE_PLAYABLE_ITEMS.getDefaultValue())), new LibraryViewModel$selectedPlatformEntityLiveData$1(this));
        this.selectedPlatformEntityLiveData = liveDataSwitchMap;
        MediatorLiveData<List<Long>> mediatorLiveData = new MediatorLiveData<>();
        this.selectedPlatformStatistics = mediatorLiveData;
        mutableLiveData.setValue(Long.valueOf(sharedPreferences.getLong(LongPreference.LIBRARY_SELECTED_PLATFORM_ID.getKey(), LongPreference.LIBRARY_SELECTED_PLATFORM_ID.getDefaultValue())));
        mediatorLiveData.addSource(liveDataSwitchMap, new LibraryViewModel$sam$androidx_lifecycle_Observer$0(new AnonymousClass1()));
    }

    public final SharedPreferences getPreferences() {
        return this.preferences;
    }

    public final Utils.MaxSizeHashMap<Integer, List<ColorStateList>> getPlatformWallpaperColorsList() {
        return this.platformWallpaperColorsList;
    }

    public final LiveData<Long> getSelectedPlatformIdLiveData() {
        return this._selectedPlatformIdLiveData;
    }

    public final LiveData<PlatformEntity> getSelectedPlatformEntityLiveData() {
        return this.selectedPlatformEntityLiveData;
    }

    public final MediatorLiveData<List<Long>> getSelectedPlatformStatistics() {
        return this.selectedPlatformStatistics;
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.view_models.LibraryViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: LibraryViewModel.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass1 extends Lambda<Unit> implements Function1<PlatformEntity, Unit> {
        AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PlatformEntity platformEntity) {
            invoke2(platformEntity);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PlatformEntity platformEntity) {
            if (platformEntity != null) {
                LibraryViewModel libraryViewModel = LibraryViewModel.this;
                long id2 = platformEntity.getId();
                Date date = new Date(System.currentTimeMillis() - com.magneticchen.daijishou.support.DaijishouValueSupport.durationInWholeMilliseconds(Constants.INSTANCE.m3492getRecentDurationDefinitionUwyO8pc()));
                Date date2 = new Date(System.currentTimeMillis() - com.magneticchen.daijishou.support.DaijishouValueSupport.durationInWholeMilliseconds(Constants.INSTANCE.m3491getNewlyDurationDefinitionUwyO8pc()));
                if (libraryViewModel.oldRecentLiveData != null) {
                    MediatorLiveData<List<Long>> selectedPlatformStatistics = libraryViewModel.getSelectedPlatformStatistics();
                    LiveData liveData = libraryViewModel.oldRecentLiveData;
                    Intrinsics.checkNotNull(liveData);
                    selectedPlatformStatistics.removeSource(liveData);
                    MediatorLiveData<List<Long>> selectedPlatformStatistics2 = libraryViewModel.getSelectedPlatformStatistics();
                    LiveData liveData2 = libraryViewModel.oldFavoriteLiveData;
                    Intrinsics.checkNotNull(liveData2);
                    selectedPlatformStatistics2.removeSource(liveData2);
                    MediatorLiveData<List<Long>> selectedPlatformStatistics3 = libraryViewModel.getSelectedPlatformStatistics();
                    LiveData liveData3 = libraryViewModel.oldNewlyLiveData;
                    Intrinsics.checkNotNull(liveData3);
                    selectedPlatformStatistics3.removeSource(liveData3);
                }
                if (libraryViewModel.getDefaultSharedPreferences().getBoolean(BooleanPreference.MERGE_PLAYABLE_ITEMS.getKey(), BooleanPreference.MERGE_PLAYABLE_ITEMS.getDefaultValue())) {
                    libraryViewModel.oldRecentLiveData = libraryViewModel.daijishouLibraryRepository.countRecentPlayableItemsByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemId(id2, date);
                    libraryViewModel.oldFavoriteLiveData = libraryViewModel.daijishouLibraryRepository.countFavoritePlayableItemsByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemId(id2);
                    libraryViewModel.oldNewlyLiveData = libraryViewModel.daijishouLibraryRepository.countNewlyPlayableItemsByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemId(id2, date2);
                } else {
                    libraryViewModel.oldRecentLiveData = libraryViewModel.daijishouLibraryRepository.countRecentPlayableItemsByAttachedPlatformId(id2, date);
                    libraryViewModel.oldFavoriteLiveData = libraryViewModel.daijishouLibraryRepository.countFavoritePlayableItemsByAttachedPlatformId(id2);
                    libraryViewModel.oldNewlyLiveData = libraryViewModel.daijishouLibraryRepository.countNewlyPlayableItemsByAttachedPlatformId(id2, date2);
                }
                MediatorLiveData<List<Long>> selectedPlatformStatistics4 = libraryViewModel.getSelectedPlatformStatistics();
                LiveData liveData4 = libraryViewModel.oldRecentLiveData;
                Intrinsics.checkNotNull(liveData4);
                selectedPlatformStatistics4.addSource(liveData4, new LibraryViewModel$sam$androidx_lifecycle_Observer$0(new LibraryViewModel$1$1$1(libraryViewModel, id2, date, date2)));
                MediatorLiveData<List<Long>> selectedPlatformStatistics5 = libraryViewModel.getSelectedPlatformStatistics();
                LiveData liveData5 = libraryViewModel.oldFavoriteLiveData;
                Intrinsics.checkNotNull(liveData5);
                selectedPlatformStatistics5.addSource(liveData5, new LibraryViewModel$sam$androidx_lifecycle_Observer$0(new LibraryViewModel$1$1$2(libraryViewModel, id2, date, date2)));
                MediatorLiveData<List<Long>> selectedPlatformStatistics6 = libraryViewModel.getSelectedPlatformStatistics();
                LiveData liveData6 = libraryViewModel.oldNewlyLiveData;
                Intrinsics.checkNotNull(liveData6);
                selectedPlatformStatistics6.addSource(liveData6, new LibraryViewModel$sam$androidx_lifecycle_Observer$0(new LibraryViewModel$1$1$3(libraryViewModel, id2, date, date2)));
            }
        }

    }

    public final int togglePreviewAspectRatioMode() {
        this.previewMode = (this.previewMode + 1) % 3;
        this.preferences.edit().putInt("preview_mode", this.previewMode).apply();
        return this.previewMode;
    }

    /* JADX INFO: renamed from: getPreviewAspectRatioMode, reason: from getter */
    public final int getPreviewMode() {
        return this.previewMode;
    }

    public final LiveData<List<PlayableItemEntity>> getAllPlayableItems() {
        return DaijishouLibraryRepository.getPlayableItemsByAttachedPlatformIdAndVisibility$default(this.daijishouLibraryRepository, getSelectedPlatformId(), false, 2, null);
    }

    public final List<PlayableItemEntity> getAllPlayableItemsStatically() {
        return DaijishouLibraryRepository.getPlayableItemsByAttachedPlatformIdAndVisibilityStatically$default(this.daijishouLibraryRepository, getSelectedPlatformId(), false, 2, null);
    }

    public final void setSelectedPlatformId(long id2) {
        this.preferences.edit().putLong(LongPreference.LIBRARY_SELECTED_PLATFORM_ID.getKey(), id2).apply();
        this._selectedPlatformIdLiveData.setValue(Long.valueOf(id2));
    }

    public final long getSelectedPlatformId() {
        return this.preferences.getLong(LongPreference.LIBRARY_SELECTED_PLATFORM_ID.getKey(), LongPreference.LIBRARY_SELECTED_PLATFORM_ID.getDefaultValue());
    }

    public final void removeSelectedPlatformSyncTreeUriSafely(Uri uri, boolean keepRecords) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Long value = getSelectedPlatformIdLiveData().getValue();
        if (value == null) {
            return;
        }
        PlatformEntity platformByIdStatically = this.daijishouLibraryRepository.getPlatformByIdStatically(value.longValue());
        if (platformByIdStatically != null) {
            this.daijishouLibraryRepository.removePlatformSyncTreeUri(platformByIdStatically, uri, keepRecords);
        }
    }

    public static final void invoke$lambda$0$refreshCurrentPlatformStatistics(LibraryViewModel libraryViewModel, long j, Date date, Date date2) {
        if (libraryViewModel.getDefaultSharedPreferences().getBoolean(BooleanPreference.MERGE_PLAYABLE_ITEMS.getKey(), BooleanPreference.MERGE_PLAYABLE_ITEMS.getDefaultValue())) {
            List<Long> listListOf = CollectionsKt.listOf(new Long[]{Long.valueOf(DaijishouLibraryRepository.countPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically$default(libraryViewModel.daijishouLibraryRepository, j, false, 2, null)), Long.valueOf(DaijishouLibraryRepository.countRecentPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically$default(libraryViewModel.daijishouLibraryRepository, libraryViewModel.getSelectedPlatformId(), date, false, 4, null)), Long.valueOf(DaijishouLibraryRepository.countFavoritePlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically$default(libraryViewModel.daijishouLibraryRepository, libraryViewModel.getSelectedPlatformId(), false, 2, null)), Long.valueOf(DaijishouLibraryRepository.countNewlyPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically$default(libraryViewModel.daijishouLibraryRepository, libraryViewModel.getSelectedPlatformId(), date2, false, 4, null))});
            if (Intrinsics.areEqual(libraryViewModel.getSelectedPlatformStatistics().getValue(), listListOf)) {
                return;
            }
            libraryViewModel.getSelectedPlatformStatistics().setValue(listListOf);
            return;
        }
        List<Long> listListOf2 = CollectionsKt.listOf(new Long[]{Long.valueOf(DaijishouLibraryRepository.countPlayableItemsByAttachedPlatformIdAndVisibilityStatically$default(libraryViewModel.daijishouLibraryRepository, j, false, 2, null)), Long.valueOf(DaijishouLibraryRepository.countRecentPlayableItemsByAttachedPlatformIdAndVisibilityStatically$default(libraryViewModel.daijishouLibraryRepository, libraryViewModel.getSelectedPlatformId(), date, false, 4, null)), Long.valueOf(DaijishouLibraryRepository.countFavoritePlayableItemsByAttachedPlatformIdAndVisibilityStatically$default(libraryViewModel.daijishouLibraryRepository, libraryViewModel.getSelectedPlatformId(), false, 2, null)), Long.valueOf(DaijishouLibraryRepository.countNewlyPlayableItemsByAttachedPlatformIdAndVisibilityStatically$default(libraryViewModel.daijishouLibraryRepository, libraryViewModel.getSelectedPlatformId(), date2, false, 4, null))});
        if (Intrinsics.areEqual(libraryViewModel.getSelectedPlatformStatistics().getValue(), listListOf2)) {
            return;
        }
        libraryViewModel.getSelectedPlatformStatistics().setValue(listListOf2);
    }

}
