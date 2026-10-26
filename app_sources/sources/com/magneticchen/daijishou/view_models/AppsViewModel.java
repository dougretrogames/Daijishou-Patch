package com.magneticchen.daijishou.view_models;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import androidx.core.graphics.drawable.DrawableKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.google.api.client.googleapis.media.MediaHttpDownloader;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.application_data.AppsStateJson;
import com.magneticchen.daijishou.application_data.AppsStateJson$$serializer;
import com.magneticchen.daijishou.application_data.Constants;
import com.magneticchen.daijishou.application_data.IntPreference;
import com.magneticchen.daijishou.application_data.StringPreference;
import com.magneticchen.daijishou.live_data.LauncherIntentResolveInfoListLiveData;
import com.magneticchen.daijishou.utils.Utils;
import com.magneticchen.daijishou.view_models.abstract_view_models.DaijishouAndroidViewModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.json.Json;
import net.lingala.zip4j.util.InternalZipConstants;

/* INFO: compiled from: AppsViewModel.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 ?2\u00020\u0001:\u0001?B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010+\u001a\u00020\fJ\u0006\u0010,\u001a\u00020\fJ\u000e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u001fJ\u000e\u00100\u001a\u00020.2\u0006\u0010/\u001a\u00020\u001fJ\u0016\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\bJ\u000e\u00106\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\bJ\u0010\u00107\u001a\u0002022\u0006\u00108\u001a\u00020\fH\u0002J\u0010\u00109\u001a\u0002022\u0006\u0010:\u001a\u00020\fH\u0002J\u0006\u0010;\u001a\u000202J\u0006\u0010<\u001a\u000202J\u000e\u0010=\u001a\u0002022\u0006\u0010/\u001a\u00020\u001fJ\b\u0010>\u001a\u000202H\u0002R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00060\u0015R\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R-\u0010#\u001a\u001e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f0$j\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f`%¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R-\u0010(\u001a\u001e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\b0$j\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\b`%¢\u0006\b\n\u0000\u001a\u0004\b)\u0010'R\u000e\u0010*\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/magneticchen/daijishou/view_models/AppsViewModel;", "Lcom/magneticchen/daijishou/view_models/abstract_view_models/DaijishouAndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_packageResolveInfoListLiveData", "Landroidx/lifecycle/MediatorLiveData;", "", "Landroid/content/pm/ResolveInfo;", "appsStateJson", "Lcom/magneticchen/daijishou/application_data/AppsStateJson;", "itemsMode", "", "launcherIntentResolveInfoList", "getLauncherIntentResolveInfoList", "()Ljava/util/List;", "setLauncherIntentResolveInfoList", "(Ljava/util/List;)V", "launcherIntentResolveInfoListLiveData", "Lcom/magneticchen/daijishou/live_data/LauncherIntentResolveInfoListLiveData;", "logger", "Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "Lcom/magneticchen/daijishou/DaijishouApplication;", "packageManager", "Landroid/content/pm/PackageManager;", "packageResolveInfoListLiveData", "Landroidx/lifecycle/LiveData;", "getPackageResolveInfoListLiveData", "()Landroidx/lifecycle/LiveData;", "resolveInfoStringIdToBitmapCache", "Lcom/magneticchen/daijishou/utils/Utils$MaxSizeHashMap;", "", "Landroid/graphics/Bitmap;", "getResolveInfoStringIdToBitmapCache", "()Lcom/magneticchen/daijishou/utils/Utils$MaxSizeHashMap;", "resolveInfoStringIdToLabelCache", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getResolveInfoStringIdToLabelCache", "()Ljava/util/HashMap;", "resolveInfoStringIdToResolveInfo", "getResolveInfoStringIdToResolveInfo", "sortingMode", "getItemsMode", "getSortingMode", "isResolveInfoStringIdFlagAsGame", "", "resolveInfoStringId", "isResolveInfoStringIdFlagAsGameNatively", "launchAppByResolveInfo", "", "activity", "Landroid/app/Activity;", "resolveInfo", "resolveInfoToResolveInfoStringId", "setItemsMode", "newItemsMode", "setSortingMode", "newSortingMode", "toggleNextItemsMode", "toggleNextSortingMode", "toggleResolveInfoStringIdFlagAsGame", "updatePackageResolveInfoList", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppsViewModel extends DaijishouAndroidViewModel {

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int appIconResolutionPx = 128;
    private final MediatorLiveData<List<ResolveInfo>> _packageResolveInfoListLiveData;
    private final AppsStateJson appsStateJson;
    private int itemsMode;
    private List<ResolveInfo> launcherIntentResolveInfoList;
    private final LauncherIntentResolveInfoListLiveData launcherIntentResolveInfoListLiveData;
    private final DaijishouApplication.WrappedLogger logger;
    private final PackageManager packageManager;
    private final Utils.MaxSizeHashMap<String, Bitmap> resolveInfoStringIdToBitmapCache;
    private final HashMap<String, String> resolveInfoStringIdToLabelCache;
    private final HashMap<String, ResolveInfo> resolveInfoStringIdToResolveInfo;
    private int sortingMode;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppsViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        LauncherIntentResolveInfoListLiveData launcherIntentResolveInfoListLiveData = new LauncherIntentResolveInfoListLiveData(application);
        this.launcherIntentResolveInfoListLiveData = launcherIntentResolveInfoListLiveData;
        MediatorLiveData<List<ResolveInfo>> mediatorLiveData = new MediatorLiveData<>();
        mediatorLiveData.setValue(new ArrayList());
        this._packageResolveInfoListLiveData = mediatorLiveData;
        mediatorLiveData.addSource(launcherIntentResolveInfoListLiveData, new AppsViewModel$sam$androidx_lifecycle_Observer$0(new AnonymousClass1()));
        PackageManager packageManager = application.getPackageManager();
        Intrinsics.checkNotNullExpressionValue(packageManager, "getPackageManager(...)");
        this.packageManager = packageManager;
        this.logger = ((DaijishouApplication) application).getLogger();
        this.itemsMode = Math.min(getDefaultSharedPreferences().getInt(IntPreference.APPS_ITEMS_MODE.getKey(), IntPreference.APPS_ITEMS_MODE.getDefaultValue()), 1);
        this.sortingMode = getDefaultSharedPreferences().getInt(IntPreference.APPS_SORTING_MODE.getKey(), IntPreference.APPS_SORTING_MODE.getDefaultValue());
        this.launcherIntentResolveInfoList = new ArrayList();
        this.resolveInfoStringIdToBitmapCache = new Utils.MaxSizeHashMap<>(Constants.appIconsCacheSize);
        this.resolveInfoStringIdToLabelCache = new HashMap<>();
        this.resolveInfoStringIdToResolveInfo = new HashMap<>();
        String string = getDefaultSharedPreferences().getString(StringPreference.APP_STATE.getKey(), StringPreference.APP_STATE.getDefaultValue());
        AppsStateJson appsStateJson;
        if (string != null) {
            appsStateJson = (AppsStateJson) getWeakJson().decodeFromString(AppsStateJson.INSTANCE.serializer(), string);
        } else {
            appsStateJson = new AppsStateJson((List) null, (List) null, (HashMap) null, 7, (DefaultConstructorMarker) null);
        }
        this.appsStateJson = appsStateJson;
    }

    /* INFO: compiled from: AppsViewModel.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/magneticchen/daijishou/view_models/AppsViewModel$Companion;", "", "()V", "appIconResolutionPx", "", "launcherIntent", "Landroid/content/Intent;", "getLauncherIntent", "()Landroid/content/Intent;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final Intent getLauncherIntent() {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            return intent;
        }
    }

    public final LiveData<List<ResolveInfo>> getPackageResolveInfoListLiveData() {
        return this._packageResolveInfoListLiveData;
    }

    /* INFO: renamed from: com.magneticchen.daijishou.view_models.AppsViewModel$1, reason: invalid class name */
    /* INFO: compiled from: AppsViewModel.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "newerLauncherIntentResolveInfoList", "", "Landroid/content/pm/ResolveInfo;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass1 extends Lambda<Unit> implements Function1<List<? extends ResolveInfo>, Unit> {
        AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ResolveInfo> list) {
            invoke2(list);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends ResolveInfo> list) {
            AppsViewModel.this.getLauncherIntentResolveInfoList().clear();
            List<ResolveInfo> launcherIntentResolveInfoList = AppsViewModel.this.getLauncherIntentResolveInfoList();
            Intrinsics.checkNotNull(list);
            launcherIntentResolveInfoList.addAll(list);
            ArrayList arrayList = new ArrayList();
            List<ResolveInfo> launcherIntentResolveInfoList2 = AppsViewModel.this.getLauncherIntentResolveInfoList();
            AppsViewModel appsViewModel = AppsViewModel.this;
            for (ResolveInfo resolveInfo : launcherIntentResolveInfoList2) {
                String strResolveInfoToResolveInfoStringId = appsViewModel.resolveInfoToResolveInfoStringId(resolveInfo);
                arrayList.add(strResolveInfoToResolveInfoStringId);
                if (!appsViewModel.getResolveInfoStringIdToBitmapCache().containsKey(strResolveInfoToResolveInfoStringId)) {
                    if (appsViewModel.getResolveInfoStringIdToBitmapCache().size() < 384) {
                        Drawable drawableLoadIcon = resolveInfo.activityInfo.loadIcon(appsViewModel.packageManager);
                        Intrinsics.checkNotNullExpressionValue(drawableLoadIcon, "loadIcon(...)");
                        appsViewModel.getResolveInfoStringIdToBitmapCache().put(strResolveInfoToResolveInfoStringId, DrawableKt.toBitmap$default(drawableLoadIcon, 128, 128, null, 4, null));
                    }
                }
                appsViewModel.getResolveInfoStringIdToLabelCache().put(strResolveInfoToResolveInfoStringId, resolveInfo.loadLabel(appsViewModel.packageManager).toString());
                appsViewModel.getResolveInfoStringIdToResolveInfo().put(strResolveInfoToResolveInfoStringId, resolveInfo);
            }
            ArrayList<String> arrayList2 = new ArrayList();
            Set<String> setKeySet = AppsViewModel.this.getResolveInfoStringIdToLabelCache().keySet();
            Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
            for (String str : setKeySet) {
                if (!arrayList.contains(str)) {
                    Intrinsics.checkNotNull(str);
                    arrayList2.add(str);
                }
            }
            AppsViewModel appsViewModel2 = AppsViewModel.this;
            for (String str2 : arrayList2) {
                appsViewModel2.getResolveInfoStringIdToBitmapCache().remove(str2);
                appsViewModel2.getResolveInfoStringIdToLabelCache().remove(str2);
            }
            AppsViewModel.this.updatePackageResolveInfoList();
        }
    }

    public final List<ResolveInfo> getLauncherIntentResolveInfoList() {
        return this.launcherIntentResolveInfoList;
    }

    public final void setLauncherIntentResolveInfoList(List<ResolveInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.launcherIntentResolveInfoList = list;
    }

    public final Utils.MaxSizeHashMap<String, Bitmap> getResolveInfoStringIdToBitmapCache() {
        return this.resolveInfoStringIdToBitmapCache;
    }

    public final HashMap<String, String> getResolveInfoStringIdToLabelCache() {
        return this.resolveInfoStringIdToLabelCache;
    }

    public final HashMap<String, ResolveInfo> getResolveInfoStringIdToResolveInfo() {
        return this.resolveInfoStringIdToResolveInfo;
    }

    public final boolean isResolveInfoStringIdFlagAsGameNatively(String resolveInfoStringId) {
        Intrinsics.checkNotNullParameter(resolveInfoStringId, "resolveInfoStringId");
        ResolveInfo resolveInfo = this.resolveInfoStringIdToResolveInfo.get(resolveInfoStringId);
        boolean z = false;
        if (resolveInfo == null) {
            return false;
        }
        try {
            ApplicationInfo applicationInfo = this.packageManager.getApplicationInfo(resolveInfo.activityInfo.packageName, 0);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
            boolean z2 = applicationInfo.category == 0;
            if (z2) {
                return z2;
            }
            try {
                return (applicationInfo.flags & MediaHttpDownloader.MAXIMUM_CHUNK_SIZE) == 33554432;
            } catch (Exception e) {
                e = e;
                z = z2;
                this.logger.warn(this, ExceptionsKt.stackTraceToString(e));
                return z;
            }
        } catch (Exception e2) {
            Exception e = null;
            e = e2;
        }
        return false;
    }

    public final boolean isResolveInfoStringIdFlagAsGame(String resolveInfoStringId) {
        Intrinsics.checkNotNullParameter(resolveInfoStringId, "resolveInfoStringId");
        if (isResolveInfoStringIdFlagAsGameNatively(resolveInfoStringId)) {
            return !this.appsStateJson.getResolveInfoFlagAsNotGameStringIds().contains(resolveInfoStringId);
        }
        return this.appsStateJson.getResolveInfoFlagAsGameStringIds().contains(resolveInfoStringId);
    }

    /* INFO: Access modifiers changed from: private */
    public final void updatePackageResolveInfoList() {
        List<ResolveInfo> value = this._packageResolveInfoListLiveData.getValue();
        Intrinsics.checkNotNull(value);
        List<ResolveInfo> list = value;
        list.clear();
        int i = this.itemsMode;
        if (i == 0) {
            list.addAll(this.launcherIntentResolveInfoList);
        } else if (i == 1) {
            for (ResolveInfo resolveInfo : this.launcherIntentResolveInfoList) {
                if (isResolveInfoStringIdFlagAsGame(resolveInfoToResolveInfoStringId(resolveInfo))) {
                    list.add(resolveInfo);
                }
            }
        }
        int i2 = this.sortingMode;
        if (i2 == 0) {
            Collections.sort(list, new ResolveInfo.DisplayNameComparator(this.packageManager));
        } else if (i2 == 1) {
            Collections.sort(list, new ResolveInfo.DisplayNameComparator(this.packageManager).reversed());
        } else if (i2 == 2) {
            Set<Map.Entry<String, Long>> setEntrySet = this.appsStateJson.getResolveInfoStringIdToLastOpenedTimestamp().entrySet();
            Intrinsics.checkNotNullExpressionValue(setEntrySet, "<get-entries>(...)");
            List<Map.Entry> listSortedWith = CollectionsKt.sortedWith(setEntrySet, new AppsViewModel$updatePackageResolveInfoList$$inlined$sortedBy$1());
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listSortedWith, 10)), 16));
            for (Map.Entry entry : listSortedWith) {
                Intrinsics.checkNotNull(entry);
                Pair pair = new Pair(entry.getKey(), entry.getValue());
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            Set setKeySet = linkedHashMap.keySet();
            int size = setKeySet.size();
            ResolveInfo[] resolveInfoArr = new ResolveInfo[size];
            for (int i3 = 0; i3 < size; i3++) {
                resolveInfoArr[i3] = null;
            }
            Collections.sort(list, new ResolveInfo.DisplayNameComparator(this.packageManager));
            for (ResolveInfo resolveInfo2 : list) {
                int iIndexOf = CollectionsKt.indexOf(setKeySet, resolveInfoToResolveInfoStringId(resolveInfo2));
                if (iIndexOf >= 0) {
                    resolveInfoArr[iIndexOf] = resolveInfo2;
                }
            }
            for (int i4 = 0; i4 < size; i4++) {
                ResolveInfo resolveInfo3 = resolveInfoArr[i4];
                if (resolveInfo3 != null) {
                    list.remove(resolveInfo3);
                    list.add(0, resolveInfo3);
                }
            }
        }
        this._packageResolveInfoListLiveData.setValue(list);
    }

    public final void toggleNextItemsMode() {
        setItemsMode((this.itemsMode + 1) % 2);
    }

    private final void setItemsMode(int newItemsMode) {
        if (this.itemsMode == newItemsMode) {
            return;
        }
        this.itemsMode = newItemsMode;
        getDefaultSharedPreferences().edit().putInt(IntPreference.APPS_ITEMS_MODE.getKey(), this.itemsMode).apply();
        updatePackageResolveInfoList();
    }

    public final int getItemsMode() {
        return this.itemsMode;
    }

    public final void toggleNextSortingMode() {
        setSortingMode((this.sortingMode + 1) % 3);
    }

    private final void setSortingMode(int newSortingMode) {
        if (this.sortingMode == newSortingMode) {
            return;
        }
        this.sortingMode = newSortingMode;
        getDefaultSharedPreferences().edit().putInt(IntPreference.APPS_SORTING_MODE.getKey(), this.sortingMode).apply();
        updatePackageResolveInfoList();
    }

    public final int getSortingMode() {
        return this.sortingMode;
    }

    public final void toggleResolveInfoStringIdFlagAsGame(String resolveInfoStringId) {
        Intrinsics.checkNotNullParameter(resolveInfoStringId, "resolveInfoStringId");
        boolean zIsResolveInfoStringIdFlagAsGameNatively = isResolveInfoStringIdFlagAsGameNatively(resolveInfoStringId);
        if (isResolveInfoStringIdFlagAsGame(resolveInfoStringId)) {
            if (zIsResolveInfoStringIdFlagAsGameNatively) {
                this.appsStateJson.getResolveInfoFlagAsNotGameStringIds().add(resolveInfoStringId);
            } else {
                this.appsStateJson.getResolveInfoFlagAsGameStringIds().remove(resolveInfoStringId);
            }
        } else if (zIsResolveInfoStringIdFlagAsGameNatively) {
            this.appsStateJson.getResolveInfoFlagAsNotGameStringIds().remove(resolveInfoStringId);
        } else {
            this.appsStateJson.getResolveInfoFlagAsGameStringIds().add(resolveInfoStringId);
        }
        getDefaultSharedPreferences().edit().putString(StringPreference.APP_STATE.getKey(), Json.Default.encodeToString(AppsStateJson$$serializer.INSTANCE, this.appsStateJson)).apply();
        updatePackageResolveInfoList();
    }

    public final String resolveInfoToResolveInfoStringId(ResolveInfo resolveInfo) {
        Intrinsics.checkNotNullParameter(resolveInfo, "resolveInfo");
        return resolveInfo.activityInfo.packageName + InternalZipConstants.ZIP_FILE_SEPARATOR + resolveInfo.activityInfo.name;
    }

    public final void launchAppByResolveInfo(Activity activity, ResolveInfo resolveInfo) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(resolveInfo, "resolveInfo");
        new Handler(Looper.getMainLooper()).postDelayed(new AppsViewModel$$ExternalSyntheticLambda0(resolveInfo, activity, this), 150L);
    }

    /* INFO: Access modifiers changed from: private */
    public static final void launchAppByResolveInfo$lambda$7(ResolveInfo resolveInfo, Activity activity, AppsViewModel this$0) {
        Intrinsics.checkNotNullParameter(resolveInfo, "$resolveInfo");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            Intrinsics.checkNotNullExpressionValue(activityInfo, "activityInfo");
            ComponentName componentName = new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name);
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setFlags(270532608);
            intent.setComponent(componentName);
            activity.startActivity(intent);
            this$0.appsStateJson.getResolveInfoStringIdToLastOpenedTimestamp().put(this$0.resolveInfoToResolveInfoStringId(resolveInfo), Long.valueOf(System.currentTimeMillis()));
            this$0.getDefaultSharedPreferences().edit().putString(StringPreference.APP_STATE.getKey(), Json.Default.encodeToString(AppsStateJson$$serializer.INSTANCE, this$0.appsStateJson)).apply();
            this$0.updatePackageResolveInfoList();
        } catch (Exception e) {
            Toast.makeText(activity.getApplicationContext(), e.getMessage(), 0).show();
            this$0.logger.warn(this$0, ExceptionsKt.stackTraceToString(e));
        }
    }
}
