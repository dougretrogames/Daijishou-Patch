package com.magneticchen.daijishou.daijishou_widget.widgets.category;

import android.app.Application;
import android.content.SharedPreferences;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.application_data.Constants;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetViewModel;
import com.magneticchen.daijishou.repositories.DaijishouLibraryRepository;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;

/* JADX INFO: compiled from: CategoryWidgetViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 (2\u00020\u0001:\u0001(B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010!\u001a\u0004\u0018\u00010\u0019J\b\u0010\"\u001a\u00020#H\u0002J\u0015\u0010\u0012\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0007H\u0007¢\u0006\u0002\b%J\u0010\u0010&\u001a\u00020#2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0006\u0010'\u001a\u00020#R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widgets/category/CategoryWidgetViewModel;", "Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_filterModeLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "app", "Lcom/magneticchen/daijishou/DaijishouApplication;", "categoryWidgetSharedPreferences", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "daijishouLibraryRepository", "Lcom/magneticchen/daijishou/repositories/DaijishouLibraryRepository;", "filterMode", "getFilterMode", "()I", "setFilterMode", "(I)V", "filterModeLiveData", "Landroidx/lifecycle/LiveData;", "getFilterModeLiveData", "()Landroidx/lifecycle/LiveData;", "genreId", "", "genresWidgetPlayableItemsLiveData", "Landroidx/lifecycle/MediatorLiveData;", "", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "getGenresWidgetPlayableItemsLiveData", "()Landroidx/lifecycle/MediatorLiveData;", "genresWidgetPlayableItemsLiveDataSource", "getSelectedGenreId", "refreshHighlightPlayableItemsLiveDataSource", "", "mode", "setMode1", "setSelectedGenreId", "toggleFilterMode", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CategoryWidgetViewModel extends WidgetViewModel {
    public static final int DEFAULT_FILTER_MODE = 0;
    public static final int FAVORITE_FILTER_MODE = 1;
    public static final int LIMIT = 1024;
    public static final int NEWLY_FILTER_MODE = 3;
    public static final int RECENT_FILTER_MODE = 2;
    private final MutableLiveData<Integer> _filterModeLiveData;
    private final DaijishouApplication app;
    private final SharedPreferences categoryWidgetSharedPreferences;
    private final DaijishouLibraryRepository daijishouLibraryRepository;
    private int filterMode;
    private String genreId;
    private final MediatorLiveData<List<PlayableItemEntity>> genresWidgetPlayableItemsLiveData;
    private LiveData<List<PlayableItemEntity>> genresWidgetPlayableItemsLiveDataSource;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CategoryWidgetViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        DaijishouApplication daijishouApplication = (DaijishouApplication) application;
        this.app = daijishouApplication;
        SharedPreferences sharedPreferences = daijishouApplication.getSharedPreferences("category_widget_view_model", 0);
        this.categoryWidgetSharedPreferences = sharedPreferences;
        this.daijishouLibraryRepository = daijishouApplication.getDaijishouLibraryRepository();
        this.filterMode = sharedPreferences.getInt("filter_mode", 0);
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();
        this._filterModeLiveData = mutableLiveData;
        this.genresWidgetPlayableItemsLiveData = new MediatorLiveData<>();
        mutableLiveData.setValue(Integer.valueOf(sharedPreferences.getInt("filter_mode", 0)));
    }

    public final int getFilterMode() {
        return this.filterMode;
    }

    public final void setFilterMode(int i) {
        this.filterMode = i;
    }

    public final LiveData<Integer> getFilterModeLiveData() {
        return this._filterModeLiveData;
    }

    public final MediatorLiveData<List<PlayableItemEntity>> getGenresWidgetPlayableItemsLiveData() {
        return this.genresWidgetPlayableItemsLiveData;
    }

    public final void setMode1(int mode) {
        this.filterMode = mode;
        this._filterModeLiveData.setValue(Integer.valueOf(mode));
        refreshHighlightPlayableItemsLiveDataSource();
        this.categoryWidgetSharedPreferences.edit().putInt("filter_mode", mode).apply();
    }

    public final void toggleFilterMode() {
        int i = (this.filterMode + 1) % 4;
        this.filterMode = i;
        this._filterModeLiveData.setValue(Integer.valueOf(i));
        refreshHighlightPlayableItemsLiveDataSource();
        this.categoryWidgetSharedPreferences.edit().putInt("filter_mode", this.filterMode).apply();
    }

    private final void refreshHighlightPlayableItemsLiveDataSource() {
        LiveData<List<PlayableItemEntity>> liveData = this.genresWidgetPlayableItemsLiveDataSource;
        if (liveData != null) {
            this.genresWidgetPlayableItemsLiveData.removeSource(liveData);
        }
        String str = this.genreId;
        if (str != null) {
            int i = this.filterMode;
            if (i == 0) {
                DaijishouLibraryRepository daijishouLibraryRepository = this.daijishouLibraryRepository;
                Intrinsics.checkNotNull(str);
                this.genresWidgetPlayableItemsLiveDataSource = DaijishouLibraryRepository.getPlayableItemsByGenreIdAndVisibility$default(daijishouLibraryRepository, str, 1024, false, 4, null);
            } else if (i == 1) {
                DaijishouLibraryRepository daijishouLibraryRepository2 = this.daijishouLibraryRepository;
                Intrinsics.checkNotNull(str);
                this.genresWidgetPlayableItemsLiveDataSource = DaijishouLibraryRepository.getFavoritePlayableItemsByGenreIdAndVisibility$default(daijishouLibraryRepository2, str, 1024, false, 4, null);
            } else if (i == 2) {
                Date date = new Date(System.currentTimeMillis() - com.magneticchen.daijishou.support.DaijishouValueSupport.durationInWholeMilliseconds(Constants.INSTANCE.m3492getRecentDurationDefinitionUwyO8pc()));
                DaijishouLibraryRepository daijishouLibraryRepository3 = this.daijishouLibraryRepository;
                String str2 = this.genreId;
                Intrinsics.checkNotNull(str2);
                this.genresWidgetPlayableItemsLiveDataSource = DaijishouLibraryRepository.getRecentPlayableItemsByGenreIdAndVisibility$default(daijishouLibraryRepository3, str2, date, 1024, false, 8, null);
            } else if (i == 3) {
                Date date2 = new Date(System.currentTimeMillis() - com.magneticchen.daijishou.support.DaijishouValueSupport.durationInWholeMilliseconds(Constants.INSTANCE.m3491getNewlyDurationDefinitionUwyO8pc()));
                DaijishouLibraryRepository daijishouLibraryRepository4 = this.daijishouLibraryRepository;
                String str3 = this.genreId;
                Intrinsics.checkNotNull(str3);
                this.genresWidgetPlayableItemsLiveDataSource = DaijishouLibraryRepository.getNewlyPlayableItemsByGenreIdAndVisibility$default(daijishouLibraryRepository4, str3, date2, 1024, false, 8, null);
            }
        } else {
            int i2 = this.filterMode;
            if (i2 == 0) {
                this.genresWidgetPlayableItemsLiveDataSource = DaijishouLibraryRepository.getFavoriteRecentOrNewlyPlayableItemsByVisibility$default(this.daijishouLibraryRepository, new Date(System.currentTimeMillis() - com.magneticchen.daijishou.support.DaijishouValueSupport.durationInWholeMilliseconds(Constants.INSTANCE.m3492getRecentDurationDefinitionUwyO8pc())), new Date(System.currentTimeMillis() - com.magneticchen.daijishou.support.DaijishouValueSupport.durationInWholeMilliseconds(Constants.INSTANCE.m3491getNewlyDurationDefinitionUwyO8pc())), 0, false, 12, null);
            } else if (i2 == 1) {
                this.genresWidgetPlayableItemsLiveDataSource = DaijishouLibraryRepository.getFavoritePlayableItemsByVisibility$default(this.daijishouLibraryRepository, 0, false, 3, null);
            } else if (i2 == 2) {
                this.genresWidgetPlayableItemsLiveDataSource = DaijishouLibraryRepository.getRecentPlayableItemsByVisibility$default(this.daijishouLibraryRepository, new Date(System.currentTimeMillis() - com.magneticchen.daijishou.support.DaijishouValueSupport.durationInWholeMilliseconds(Constants.INSTANCE.m3492getRecentDurationDefinitionUwyO8pc())), 0, false, 6, null);
            } else if (i2 == 3) {
                this.genresWidgetPlayableItemsLiveDataSource = DaijishouLibraryRepository.getNewlyPlayableItemsByVisibility$default(this.daijishouLibraryRepository, new Date(System.currentTimeMillis() - com.magneticchen.daijishou.support.DaijishouValueSupport.durationInWholeMilliseconds(Constants.INSTANCE.m3491getNewlyDurationDefinitionUwyO8pc())), 0, false, 6, null);
            }
        }
        LiveData<List<PlayableItemEntity>> liveData2 = this.genresWidgetPlayableItemsLiveDataSource;
        if (liveData2 != null) {
            this.genresWidgetPlayableItemsLiveData.addSource(liveData2, new CategoryWidgetViewModel$sam$androidx_lifecycle_Observer$0(new CategoryWidgetViewModel$refreshHighlightPlayableItemsLiveDataSource$2$1(this)));
        }
    }

    public final String getSelectedGenreId() {
        return this.categoryWidgetSharedPreferences.getString("selected_genre_id", null);
    }

    public final void setSelectedGenreId(String genreId) {
        if (this.genresWidgetPlayableItemsLiveDataSource == null || !Intrinsics.areEqual(this.genreId, genreId)) {
            this.genreId = genreId;
            refreshHighlightPlayableItemsLiveDataSource();
            this.categoryWidgetSharedPreferences.edit().putString("selected_genre_id", genreId).apply();
        }
    }
}
