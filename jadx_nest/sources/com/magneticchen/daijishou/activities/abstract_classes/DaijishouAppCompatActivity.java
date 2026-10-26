package com.magneticchen.daijishou.activities.abstract_classes;

import android.content.ComponentName;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.exifinterface.media.ExifInterface;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.application_data.Constants;
import com.magneticchen.daijishou.application_data.StringPreference;
import com.magneticchen.daijishou.live_data.SharedPreferenceStringLiveData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: DaijishouAppCompatActivity.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0004J\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\u0012\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0012H\u0004J\b\u0010\u001a\u001a\u00020\u0012H\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001f\u0010\u000b\u001a\u00060\fR\u00020\r8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/magneticchen/daijishou/activities/abstract_classes/DaijishouAppCompatActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "changeDarkModeListener", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "defaultSharedPreferences", "Landroid/content/SharedPreferences;", "getDefaultSharedPreferences", "()Landroid/content/SharedPreferences;", "defaultSharedPreferences$delegate", "Lkotlin/Lazy;", "logger", "Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "Lcom/magneticchen/daijishou/DaijishouApplication;", "getLogger", "()Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "logger$delegate", "hideSystemBars", "", "isMyLauncherDefault", "", "onBackPressedCallback", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupDarkTheme", "setupTheme", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class DaijishouAppCompatActivity extends AppCompatActivity {
    private final SharedPreferences.OnSharedPreferenceChangeListener changeDarkModeListener = new DaijishouAppCompatActivity$$ExternalSyntheticLambda1(this);

    /* INFO: renamed from: defaultSharedPreferences$delegate, reason: from kotlin metadata */
    private final Lazy defaultSharedPreferences = LazyKt.lazy(new DaijishouAppCompatActivity$defaultSharedPreferences$2(this));

    /* INFO: renamed from: logger$delegate, reason: from kotlin metadata */
    private final Lazy logger = LazyKt.lazy(new DaijishouAppCompatActivity$logger$2(this));

    public void onBackPressedCallback() {
    }

    /* INFO: Access modifiers changed from: private */
    public static final void changeDarkModeListener$lambda$0(DaijishouAppCompatActivity this$0, SharedPreferences sharedPreferences, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(str, StringPreference.USE_DARK_THEME.getKey())) {
            this$0.setupDarkTheme();
        }
    }

    public final boolean isMyLauncherDefault() {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.MAIN");
        intentFilter.addCategory("android.intent.category.HOME");
        ArrayList arrayList = new ArrayList();
        arrayList.add(intentFilter);
        String packageName = getPackageName();
        ArrayList arrayList2 = new ArrayList();
        PackageManager packageManager = getPackageManager();
        Intrinsics.checkNotNull(packageManager, "null cannot be cast to non-null type android.content.pm.PackageManager");
        packageManager.getPreferredActivities(arrayList, arrayList2, null);
        Iterator<ComponentName> it = arrayList2.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(packageName, it.next().getPackageName())) {
                return true;
            }
        }
        return false;
    }

    /* INFO: Access modifiers changed from: protected */
    public final SharedPreferences getDefaultSharedPreferences() {
        return (SharedPreferences) this.defaultSharedPreferences.getValue();
    }

    protected final DaijishouApplication.WrappedLogger getLogger() {
        return (DaijishouApplication.WrappedLogger) this.logger.getValue();
    }

    /* WARN: Failed to restore switch over string. Please report as a decompilation issue */
    protected final void setupDarkTheme() {
        String string = getDefaultSharedPreferences().getString(StringPreference.USE_DARK_THEME.getKey(), StringPreference.USE_DARK_THEME.getDefaultValue());
        if (string != null) {
            switch (string.hashCode()) {
                case 48:
                    if (string.equals("0")) {
                        AppCompatDelegate.setDefaultNightMode(-1);
                        break;
                    }
                    break;
                case 49:
                    if (string.equals("1")) {
                        AppCompatDelegate.setDefaultNightMode(2);
                        break;
                    }
                    break;
                case 50:
                    if (string.equals(ExifInterface.GPS_MEASUREMENT_2D)) {
                        AppCompatDelegate.setDefaultNightMode(1);
                        break;
                    }
                    break;
            }
        }
    }

    protected final void setupTheme() {
        int iIntValue = Constants.INSTANCE.getThemes().get(Constants.INSTANCE.getThemeIds().indexOf(Constants.defaultThemeId)).intValue();
        String string = getDefaultSharedPreferences().getString(StringPreference.THEME_ID.getKey(), StringPreference.THEME_ID.getDefaultValue());
        int iIndexOf = CollectionsKt.indexOf((List<? extends String>) Constants.INSTANCE.getThemeIds(), string);
        setTheme(iIndexOf == -1 ? iIntValue : Constants.INSTANCE.getThemes().get(iIndexOf).intValue());
        new SharedPreferenceStringLiveData(getDefaultSharedPreferences(), "theme_id", Constants.defaultThemeId).observe(this, new DaijishouAppCompatActivity$sam$androidx_lifecycle_Observer$0(new C02081(string, iIntValue, this)));
    }

    /* INFO: renamed from: com.magneticchen.daijishou.activities.abstract_classes.DaijishouAppCompatActivity$setupTheme$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: DaijishouAppCompatActivity.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "themeId2", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class C02081 extends Lambda<Unit> implements Function1<String, Unit> {
        final /* synthetic */ int $defaultTheme;
        final /* synthetic */ String $themeId;
        final /* synthetic */ DaijishouAppCompatActivity this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02081(String str, int i, DaijishouAppCompatActivity daijishouAppCompatActivity) {
            super(1);
            this.$themeId = str;
            this.$defaultTheme = i;
            this.this$0 = daijishouAppCompatActivity;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            if (Intrinsics.areEqual(str, this.$themeId)) {
                return;
            }
            int iIndexOf = Constants.INSTANCE.getThemeIds().indexOf(str);
            this.this$0.setTheme(iIndexOf == -1 ? this.$defaultTheme : Constants.INSTANCE.getThemes().get(iIndexOf).intValue());
            this.this$0.recreate();
        }
    }

    protected final void hideSystemBars() {
        if (Build.VERSION.SDK_INT <= 30) {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        }
        if (Build.VERSION.SDK_INT > 29) {
            WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
            WindowInsetsControllerCompat insetsController = WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView());
            insetsController.setSystemBarsBehavior(2);
            getWindow().getDecorView().setOnApplyWindowInsetsListener(new DaijishouAppCompatActivity$$ExternalSyntheticLambda0(insetsController));
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static final WindowInsets hideSystemBars$lambda$1(WindowInsetsControllerCompat windowInsetsControllerCompat, View view, WindowInsets windowInsets) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.systemBars());
        return view.onApplyWindowInsets(windowInsets);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDefaultSharedPreferences().registerOnSharedPreferenceChangeListener(this.changeDarkModeListener);
        getWindow().addFlags(1024);
        setupDarkTheme();
        setupTheme();
        hideSystemBars();
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        Intrinsics.checkNotNullExpressionValue(onBackPressedDispatcher, "<get-onBackPressedDispatcher>(...)");
        OnBackPressedDispatcherKt.addCallback$default(onBackPressedDispatcher, null, false, new AnonymousClass1(), 3, null);
    }

    /* INFO: renamed from: com.magneticchen.daijishou.activities.abstract_classes.DaijishouAppCompatActivity$onCreate$1, reason: invalid class name */
    /* INFO: compiled from: DaijishouAppCompatActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/activity/OnBackPressedCallback;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass1 extends Lambda<Unit> implements Function1<OnBackPressedCallback, Unit> {
        AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(OnBackPressedCallback onBackPressedCallback) {
            invoke2(onBackPressedCallback);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(OnBackPressedCallback addCallback) {
            Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
            DaijishouAppCompatActivity.this.onBackPressedCallback();
        }
    }
}
