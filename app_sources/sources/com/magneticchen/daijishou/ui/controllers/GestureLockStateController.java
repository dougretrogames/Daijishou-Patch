package com.magneticchen.daijishou.ui.controllers;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.service.LauncherAccessibilityService;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GestureLockStateController.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001 B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/magneticchen/daijishou/ui/controllers/GestureLockStateController;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "parent", "Landroid/view/View;", "(Lcom/magneticchen/daijishou/DaijishouApplication;Landroid/view/View;)V", "getApplication", "()Lcom/magneticchen/daijishou/DaijishouApplication;", "doubleTapBarsDetector", "Landroid/view/GestureDetector;", "getDoubleTapBarsDetector", "()Landroid/view/GestureDetector;", "doubleTapBarsDetector$delegate", "Lkotlin/Lazy;", "key", "", "listener", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "getParent", "()Landroid/view/View;", "touchListener", "Landroid/view/View$OnTouchListener;", "lockScreenViaAccessibility", "", "context", "Landroid/content/Context;", "onConfigure", "onCreate", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onDestroy", "Configuration", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GestureLockStateController implements DefaultLifecycleObserver {
    private final DaijishouApplication application;
    private final Lazy doubleTapBarsDetector$delegate;
    private final String key;
    private final SharedPreferences.OnSharedPreferenceChangeListener listener;
    private final View parent;
    private final View.OnTouchListener touchListener;

    /* JADX INFO: compiled from: GestureLockStateController.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/ui/controllers/GestureLockStateController$Configuration;", "", "(Ljava/lang/String;I)V", "DISABLED", "TOP", "BOTTOM", "BOTH", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public enum Configuration {
        DISABLED,
        TOP,
        BOTTOM,
        BOTH;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<Configuration> getEntries() {
            return $ENTRIES;
        }
    }

    public GestureLockStateController(DaijishouApplication application, View parent) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.application = application;
        this.parent = parent;
        this.key = "lock_gesture_configuration";
        this.listener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.magneticchen.daijishou.ui.controllers.GestureLockStateController$$ExternalSyntheticLambda0
            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                GestureLockStateController.listener$lambda$0(this.f$0, sharedPreferences, str);
            }
        };
        this.doubleTapBarsDetector$delegate = LazyKt.lazy(new Function0<GestureDetector>() { // from class: com.magneticchen.daijishou.ui.controllers.GestureLockStateController$doubleTapBarsDetector$2
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GestureDetector invoke() {
                Context applicationContext = this.this$0.getApplication().getApplicationContext();
                final GestureLockStateController gestureLockStateController = this.this$0;
                return new GestureDetector(applicationContext, new GestureDetector.SimpleOnGestureListener() { // from class: com.magneticchen.daijishou.ui.controllers.GestureLockStateController$doubleTapBarsDetector$2.1
                    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                    public boolean onDoubleTap(MotionEvent e) {
                        Intrinsics.checkNotNullParameter(e, "e");
                        GestureLockStateController gestureLockStateController2 = gestureLockStateController;
                        Context applicationContext2 = gestureLockStateController2.getApplication().getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
                        gestureLockStateController2.lockScreenViaAccessibility(applicationContext2);
                        return true;
                    }
                });
            }
        });
        this.touchListener = new View.OnTouchListener() { // from class: com.magneticchen.daijishou.ui.controllers.GestureLockStateController$$ExternalSyntheticLambda1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return GestureLockStateController.touchListener$lambda$1(this.f$0, view, motionEvent);
            }
        };
    }

    public final DaijishouApplication getApplication() {
        return this.application;
    }

    public final View getParent() {
        return this.parent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listener$lambda$0(GestureLockStateController this$0, SharedPreferences sharedPreferences, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(str, this$0.key)) {
            this$0.onConfigure();
        }
    }

    private final GestureDetector getDoubleTapBarsDetector() {
        return (GestureDetector) this.doubleTapBarsDetector$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean touchListener$lambda$1(GestureLockStateController this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getDoubleTapBarsDetector().onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1) {
            view.performClick();
        }
        return true;
    }

    public void onCreate(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onCreate(owner);
        this.application.getDefaultSharedPreferences().registerOnSharedPreferenceChangeListener(this.listener);
        onConfigure();
    }

    public void onDestroy(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onDestroy(owner);
        this.application.getDefaultSharedPreferences().unregisterOnSharedPreferenceChangeListener(this.listener);
    }

    /* JADX WARN: Code duplicated, block: B:6:0x0020  */
    private final void onConfigure() {
        Configuration configurationValueOf;
        String string = this.application.getDefaultSharedPreferences().getString(this.key, null);
        if (string != null) {
            String upperCase = string.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            configurationValueOf = Configuration.valueOf(upperCase);
            if (configurationValueOf == null) {
                configurationValueOf = Configuration.DISABLED;
            }
        } else {
            configurationValueOf = Configuration.DISABLED;
        }
        View viewFindViewById = this.parent.findViewById(R.id.tab_layout);
        viewFindViewById.setOnTouchListener(null);
        View viewFindViewById2 = this.parent.findViewById(R.id.coordinatorLayout);
        viewFindViewById2.setOnTouchListener(null);
        if (configurationValueOf == Configuration.TOP || configurationValueOf == Configuration.BOTH) {
            viewFindViewById.setOnTouchListener(this.touchListener);
        }
        if (configurationValueOf == Configuration.BOTTOM || configurationValueOf == Configuration.BOTH) {
            viewFindViewById2.setOnTouchListener(this.touchListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void lockScreenViaAccessibility(final Context context) {
        LauncherAccessibilityService companion = LauncherAccessibilityService.Companion.getInstance();
        if (companion == null) {
            new AlertDialog.Builder((Context) this.application.getMainActivity()).setTitle("Accessibility permission required").setMessage("This app uses the Android Accessibility Service to enable the screen-lock feature.\n\nThis allows you to lock your device without pressing physical buttons, helping reduce hardware button wear.\n\nThe Accessibility Service is used only for this function. The app does not collect data, track activity, or access personal content.").setCancelable(false).setPositiveButton("Continue", new DialogInterface.OnClickListener() { // from class: com.magneticchen.daijishou.ui.controllers.GestureLockStateController$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    GestureLockStateController.lockScreenViaAccessibility$lambda$5(context, dialogInterface, i);
                }
            }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            if (companion.performGlobalAction(8)) {
                return;
            }
            Toast.makeText(context, "Lock screen action failed on this device", 0).show();
            Log.w("AccessibilityLock", "GLOBAL_ACTION_LOCK_SCREEN returned false");
            return;
        }
        Toast.makeText(context, "Lock screen requires Android 9+", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lockScreenViaAccessibility$lambda$5(Context context, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intent intent = new Intent("android.settings.ACCESSIBILITY_SETTINGS");
        intent.setFlags(268435456);
        context.startActivity(intent);
    }
}
