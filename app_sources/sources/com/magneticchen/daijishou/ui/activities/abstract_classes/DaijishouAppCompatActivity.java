package com.magneticchen.daijishou.ui.activities.abstract_classes;

import android.app.Application;
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
import androidx.lifecycle.LifecycleOwner;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.Constants;
import com.magneticchen.daijishou.data.StringPreference;
import com.magneticchen.daijishou.data.live.SharedPreferenceBooleanLiveData;
import com.magneticchen.daijishou.data.live.SharedPreferenceStringLiveData;
import com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DaijishouAppCompatActivity.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\u0012\u0010\u001a\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0015H\u0004J\b\u0010\u001e\u001a\u00020\u0015H\u0004J\b\u0010\u001f\u001a\u00020\u0015H\u0004J\b\u0010 \u001a\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001f\u0010\u000b\u001a\u00060\fR\u00020\r8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/magneticchen/daijishou/ui/activities/abstract_classes/DaijishouAppCompatActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "changeDarkModeListener", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "defaultSharedPreferences", "Landroid/content/SharedPreferences;", "getDefaultSharedPreferences", "()Landroid/content/SharedPreferences;", "defaultSharedPreferences$delegate", "Lkotlin/Lazy;", "logger", "Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "Lcom/magneticchen/daijishou/DaijishouApplication;", "getLogger", "()Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "logger$delegate", "themes", "", "", "initNotificationBarObservable", "", "initOrientationPrefObserver", "isMyLauncherDefault", "", "onBackPressedCallback", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onUpdateSystemBars", "setupDarkTheme", "setupTheme", "showNotificationBar", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class DaijishouAppCompatActivity extends AppCompatActivity {
    private final SharedPreferences.OnSharedPreferenceChangeListener changeDarkModeListener;
    private final Lazy defaultSharedPreferences$delegate;
    private final Lazy logger$delegate;
    private final List<Integer> themes;

    public void onBackPressedCallback() {
    }

    public DaijishouAppCompatActivity() {
        Integer numValueOf = Integer.valueOf(R.style.Theme_DaijishouPurpleMonotonic);
        Integer numValueOf2 = Integer.valueOf(R.style.Theme_DaijishouYellowMonotonic);
        Integer numValueOf3 = Integer.valueOf(R.style.Theme_DaijishouRedMonotonic);
        Integer numValueOf4 = Integer.valueOf(R.style.Theme_DaijishouBlueMonotonic);
        Integer numValueOf5 = Integer.valueOf(R.style.Theme_DaijishouPinkMonotonic);
        Integer numValueOf6 = Integer.valueOf(R.style.Theme_DaijishouBlueGreyMonotonic);
        this.themes = java.util.Arrays.asList(new Integer[]{numValueOf, numValueOf, numValueOf2, numValueOf2, numValueOf3, numValueOf3, numValueOf4, numValueOf4, numValueOf5, numValueOf5, numValueOf6, numValueOf6, Integer.valueOf(R.style.Theme_DaijishouGrey), Integer.valueOf(R.style.Theme_DaijishouGreyMonotonic), Integer.valueOf(R.style.Theme_DaijishouGreen), Integer.valueOf(R.style.Theme_DaijishouSuperGreen)});
        this.changeDarkModeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.magneticchen.daijishou.ui.activities.abstract_classes.DaijishouAppCompatActivity$$ExternalSyntheticLambda0
            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                DaijishouAppCompatActivity.changeDarkModeListener$lambda$0(DaijishouAppCompatActivity.this, sharedPreferences, str);
            }
        };
        this.defaultSharedPreferences$delegate = LazyKt.lazy(new Function0<SharedPreferences>() { // from class: com.magneticchen.daijishou.ui.activities.abstract_classes.DaijishouAppCompatActivity$defaultSharedPreferences$2
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPreferences invoke() {
                Application application = DaijishouAppCompatActivity.this.getApplication();
                Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
                return ((DaijishouApplication) application).getDefaultSharedPreferences();
            }
        });
        this.logger$delegate = LazyKt.lazy(new Function0<DaijishouApplication.WrappedLogger>() { // from class: com.magneticchen.daijishou.ui.activities.abstract_classes.DaijishouAppCompatActivity$logger$2
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DaijishouApplication.WrappedLogger invoke() {
                Application application = DaijishouAppCompatActivity.this.getApplication();
                Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
                return ((DaijishouApplication) application).getLogger();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: protected */
    public final SharedPreferences getDefaultSharedPreferences() {
        return (SharedPreferences) this.defaultSharedPreferences$delegate.getValue();
    }

    protected final DaijishouApplication.WrappedLogger getLogger() {
        return (DaijishouApplication.WrappedLogger) this.logger$delegate.getValue();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
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
                    if (string.equals("2")) {
                        AppCompatDelegate.setDefaultNightMode(1);
                        break;
                    }
                    break;
            }
        }
    }

    protected final void setupTheme() {
        final int iIntValue = this.themes.get(Constants.INSTANCE.getThemeIds().indexOf(Constants.defaultThemeId)).intValue();
        final String string = getDefaultSharedPreferences().getString(StringPreference.THEME_ID.getKey(), StringPreference.THEME_ID.getDefaultValue());
        int iIndexOf = CollectionsKt.indexOf((List<? extends String>) Constants.INSTANCE.getThemeIds(), string);
        setTheme(iIndexOf == -1 ? iIntValue : this.themes.get(iIndexOf).intValue());
        new SharedPreferenceStringLiveData(getDefaultSharedPreferences(), "theme_id", Constants.defaultThemeId).observe((LifecycleOwner) this, new DaijishouAppCompatActivity$sam$androidx_lifecycle_Observer$0(new Function1<String, Unit>() { // from class: com.magneticchen.daijishou.ui.activities.abstract_classes.DaijishouAppCompatActivity.setupTheme.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                int iIntValue2;
                if (Intrinsics.areEqual(str, string)) {
                    return;
                }
                int iIndexOf2 = Constants.INSTANCE.getThemeIds().indexOf(str);
                if (iIndexOf2 != -1) {
                    iIntValue2 = ((Number) DaijishouAppCompatActivity.this.themes.get(iIndexOf2)).intValue();
                } else {
                    iIntValue2 = iIntValue;
                }
                DaijishouAppCompatActivity.this.setTheme(iIntValue2);
                DaijishouAppCompatActivity.this.recreate();
            }
        }));
    }

    private final void initNotificationBarObservable() {
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), "show_notifications_bar", false).observe((LifecycleOwner) this, new DaijishouAppCompatActivity$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.activities.abstract_classes.DaijishouAppCompatActivity.initNotificationBarObservable.1
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                DaijishouAppCompatActivity.this.onUpdateSystemBars();
            }
        }));
    }

    private final void showNotificationBar() {
        if (Build.VERSION.SDK_INT >= 30) {
            WindowCompat.setDecorFitsSystemWindows(getWindow(), true);
            WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView()).show(WindowInsetsCompat.Type.statusBars());
        } else {
            getWindow().clearFlags(CategoryWidgetViewModel.LIMIT);
            getWindow().getDecorView().setSystemUiVisibility(4098);
        }
    }

    protected final void onUpdateSystemBars() {
        if (getDefaultSharedPreferences().getBoolean("show_notifications_bar", false)) {
            showNotificationBar();
            return;
        }
        if (Build.VERSION.SDK_INT <= 30) {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        }
        if (Build.VERSION.SDK_INT > 29) {
            WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
            final WindowInsetsControllerCompat insetsController = WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView());
            insetsController.setSystemBarsBehavior(2);
            getWindow().getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.magneticchen.daijishou.ui.activities.abstract_classes.DaijishouAppCompatActivity$$ExternalSyntheticLambda1
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return DaijishouAppCompatActivity.onUpdateSystemBars$lambda$1(insetsController, view, windowInsets);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets onUpdateSystemBars$lambda$1(WindowInsetsControllerCompat windowInsetsControllerCompat, View view, WindowInsets windowInsets) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.systemBars());
        return view.onApplyWindowInsets(windowInsets);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getDefaultSharedPreferences().registerOnSharedPreferenceChangeListener(this.changeDarkModeListener);
        getWindow().addFlags(CategoryWidgetViewModel.LIMIT);
        setupDarkTheme();
        setupTheme();
        initNotificationBarObservable();
        onUpdateSystemBars();
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        Intrinsics.checkNotNullExpressionValue(onBackPressedDispatcher, "<get-onBackPressedDispatcher>(...)");
        OnBackPressedDispatcherKt.addCallback$default(onBackPressedDispatcher, (LifecycleOwner) null, false, new Function1<OnBackPressedCallback, Unit>() { // from class: com.magneticchen.daijishou.ui.activities.abstract_classes.DaijishouAppCompatActivity.onCreate.1
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OnBackPressedCallback onBackPressedCallback) {
                invoke2(onBackPressedCallback);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(OnBackPressedCallback addCallback) {
                Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
                DaijishouAppCompatActivity.this.onBackPressedCallback();
            }
        }, 3, (Object) null);
        initOrientationPrefObserver();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initOrientationPrefObserver$onStateChanged(DaijishouAppCompatActivity daijishouAppCompatActivity) {
        daijishouAppCompatActivity.setRequestedOrientation(daijishouAppCompatActivity.getDefaultSharedPreferences().getBoolean("allow_portrait_mode", false) ? 2 : 11);
    }

    private final void initOrientationPrefObserver() {
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), "allow_portrait_mode", false).observe((LifecycleOwner) this, new DaijishouAppCompatActivity$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.activities.abstract_classes.DaijishouAppCompatActivity.initOrientationPrefObserver.1
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                DaijishouAppCompatActivity.initOrientationPrefObserver$onStateChanged(DaijishouAppCompatActivity.this);
            }
        }));
        initOrientationPrefObserver$onStateChanged(this);
    }
}
