package com.magneticchen.daijishou.view_models;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.application_data.BooleanPreference;
import com.magneticchen.daijishou.application_data.IntPreference;
import com.magneticchen.daijishou.daijishou_library_db.Genre;
import com.magneticchen.daijishou.daijishou_library_db.Genres;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import com.magneticchen.daijishou.repositories.DaijishouLibraryRepository;
import com.magneticchen.daijishou.utils.Utils;
import com.magneticchen.daijishou.view_models.abstract_view_models.DaijishouAndroidViewModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* INFO: compiled from: DaijishouViewModel.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u000bJ\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u0016J\u0006\u0010\u001d\u001a\u00020\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/magneticchen/daijishou/view_models/DaijishouViewModel;", "Lcom/magneticchen/daijishou/view_models/abstract_view_models/DaijishouAndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_tipsLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "daijishouLibraryRepository", "Lcom/magneticchen/daijishou/repositories/DaijishouLibraryRepository;", "isNewVersion", "", "tipsLiveData", "Landroidx/lifecycle/LiveData;", "getTipsLiveData", "()Landroidx/lifecycle/LiveData;", "tipsOn", "tipsString", "getCurrentVersion", "", "getPreviousVersion", "setTips", "", "newTips", "fullWidth", "setTipsForPlayableItem", "playableItemEntity", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "turnOffTips", "turnOnTips", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouViewModel extends DaijishouAndroidViewModel {
    private static final SimpleDateFormat tipsDateFormat = new SimpleDateFormat("EEEE • MMM dd", Locale.getDefault());
    private final MutableLiveData<String> _tipsLiveData;
    private final DaijishouLibraryRepository daijishouLibraryRepository;
    private final boolean isNewVersion;
    private boolean tipsOn;
    private String tipsString;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DaijishouViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.daijishouLibraryRepository = getApplication().getDaijishouLibraryRepository();
        this.isNewVersion = getDefaultSharedPreferences().getInt(IntPreference.CURRENT_VERSION.getKey(), IntPreference.CURRENT_VERSION.getDefaultValue()) < 416;
        this._tipsLiveData = new MutableLiveData<>();
        this.tipsString = "";
        this.tipsOn = true;
        if (getIsNewVersion()) {
            getDefaultSharedPreferences().edit().putInt(IntPreference.PREVIOUS_VERSION.getKey(), getDefaultSharedPreferences().getInt("current_version", 0)).putInt(IntPreference.CURRENT_VERSION.getKey(), 416).apply();
        }
    }

    public final LiveData<String> getTipsLiveData() {
        return this._tipsLiveData;
    }

    /* INFO: renamed from: isNewVersion, reason: from getter */
    private final boolean getIsNewVersion() {
        return this.isNewVersion;
    }

    public final int getCurrentVersion() {
        return getDefaultSharedPreferences().getInt(IntPreference.CURRENT_VERSION.getKey(), IntPreference.CURRENT_VERSION.getDefaultValue());
    }

    public final int getPreviousVersion() {
        return getDefaultSharedPreferences().getInt(IntPreference.PREVIOUS_VERSION.getKey(), IntPreference.PREVIOUS_VERSION.getDefaultValue());
    }

    public static /* synthetic */ void setTips$default(DaijishouViewModel daijishouViewModel, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        daijishouViewModel.setTips(str, z);
    }

    public final void setTips(String newTips, boolean fullWidth) {
        Intrinsics.checkNotNullParameter(newTips, "newTips");
        String string = getApplication().getString(R.string.app_name);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        if (fullWidth) {
            this.tipsString = newTips;
            if (this.tipsOn) {
                this._tipsLiveData.setValue(newTips);
                return;
            }
            return;
        }
        String str = tipsDateFormat.format(new Date()) + " • " + string + " • " + newTips;
        this.tipsString = str;
        if (this.tipsOn) {
            this._tipsLiveData.setValue(str);
        }
    }

    public final void setTipsForPlayableItem(PlayableItemEntity playableItemEntity) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
        List<String> genreIdsByPlayableItemIdStatically = this.daijishouLibraryRepository.getGenreIdsByPlayableItemIdStatically(playableItemEntity.getId());
        int size = genreIdsByPlayableItemIdStatically.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            DaijishouApplication application = getApplication();
            Genre genre = Genres.INSTANCE.getGenres().get(genreIdsByPlayableItemIdStatically.get(i));
            arrayList.add(application.getString(genre != null ? genre.getNameStringId() : R.string.unknown_genre_name));
        }
        ArrayList arrayList2 = arrayList;
        String str3 = getApplication().getString(R.string.playable_item_subtitle_format) + (playableItemEntity.isFavorite() ? " ❤️" : "");
        String str4 = getApplication().getString(R.string.playable_item_subtitle_with_genres_format) + (playableItemEntity.isFavorite() ? " ❤️" : "");
        String string = getApplication().getString(R.string.none_lowercase);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        if (getDefaultSharedPreferences().getBoolean(BooleanPreference.MERGE_PLAYABLE_ITEMS.getKey(), BooleanPreference.MERGE_PLAYABLE_ITEMS.getDefaultValue())) {
            if (genreIdsByPlayableItemIdStatically.isEmpty()) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                if (playableItemEntity.getMergedInfo().getMergedLastPlayedTimestamp() != null) {
                    Utils utils = Utils.INSTANCE;
                    Date mergedLastPlayedTimestamp = playableItemEntity.getMergedInfo().getMergedLastPlayedTimestamp();
                    Intrinsics.checkNotNull(mergedLastPlayedTimestamp);
                    String relativeTimeString = utils.getRelativeTimeString(mergedLastPlayedTimestamp.getTime());
                    Locale locale = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                    string = StringsKt.decapitalize(relativeTimeString, locale);
                }
                str2 = String.format(str3, Arrays.copyOf(new Object[]{string, Integer.valueOf(playableItemEntity.getMergedInfo().getMergedPlayedCount())}, 2));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            } else {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String strJoinToString$default = CollectionsKt.joinToString$default(arrayList2, ", ", null, null, 0, null, null, 62, null);
                if (playableItemEntity.getMergedInfo().getMergedLastPlayedTimestamp() != null) {
                    Utils utils2 = Utils.INSTANCE;
                    Date mergedLastPlayedTimestamp2 = playableItemEntity.getMergedInfo().getMergedLastPlayedTimestamp();
                    Intrinsics.checkNotNull(mergedLastPlayedTimestamp2);
                    String relativeTimeString2 = utils2.getRelativeTimeString(mergedLastPlayedTimestamp2.getTime());
                    Locale locale2 = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale2, "getDefault(...)");
                    string = StringsKt.decapitalize(relativeTimeString2, locale2);
                }
                str2 = String.format(str4, Arrays.copyOf(new Object[]{strJoinToString$default, string, Integer.valueOf(playableItemEntity.getMergedInfo().getMergedPlayedCount())}, 3));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            }
            setTips(DaijishouApplication.prettifyTitle$default(getApplication(), playableItemEntity.getMergedInfo().getMergedName(), false, 2, null) + " • " + str2, true);
            return;
        }
        if (genreIdsByPlayableItemIdStatically.isEmpty()) {
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            if (playableItemEntity.getLastPlayedTimestamp() != null) {
                Utils utils3 = Utils.INSTANCE;
                Date lastPlayedTimestamp = playableItemEntity.getLastPlayedTimestamp();
                Intrinsics.checkNotNull(lastPlayedTimestamp);
                String relativeTimeString3 = utils3.getRelativeTimeString(lastPlayedTimestamp.getTime());
                Locale locale3 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale3, "getDefault(...)");
                string = StringsKt.decapitalize(relativeTimeString3, locale3);
            }
            str = String.format(str3, Arrays.copyOf(new Object[]{string, Integer.valueOf(playableItemEntity.getPlayCount())}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        } else {
            StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
            String strJoinToString$default2 = CollectionsKt.joinToString$default(arrayList2, ", ", null, null, 0, null, null, 62, null);
            if (playableItemEntity.getLastPlayedTimestamp() != null) {
                Utils utils4 = Utils.INSTANCE;
                Date lastPlayedTimestamp2 = playableItemEntity.getLastPlayedTimestamp();
                Intrinsics.checkNotNull(lastPlayedTimestamp2);
                String relativeTimeString4 = utils4.getRelativeTimeString(lastPlayedTimestamp2.getTime());
                Locale locale4 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale4, "getDefault(...)");
                string = StringsKt.decapitalize(relativeTimeString4, locale4);
            }
            str = String.format(str4, Arrays.copyOf(new Object[]{strJoinToString$default2, string, Integer.valueOf(playableItemEntity.getPlayCount())}, 3));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        }
        setTips(DaijishouApplication.prettifyTitle$default(getApplication(), playableItemEntity.getName(), false, 2, null) + " • " + str, true);
    }

    public final void turnOnTips() {
        this.tipsOn = true;
        this._tipsLiveData.setValue(this.tipsString);
    }

    public final void turnOffTips() {
        this.tipsOn = false;
        String string = getApplication().getString(R.string.app_name);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this._tipsLiveData.setValue(tipsDateFormat.format(new Date()) + " • " + string);
    }
}
