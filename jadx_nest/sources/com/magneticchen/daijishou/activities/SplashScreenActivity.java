package com.magneticchen.daijishou.activities;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.activities.abstract_classes.DaijishouAppCompatActivity;
import com.magneticchen.daijishou.application_data.BooleanPreference;
import com.magneticchen.daijishou.application_data.Constants;
import com.magneticchen.daijishou.application_data.IntPreference;
import com.magneticchen.daijishou.dialog_fragments.AcknowledgementDialogFragment;
import com.magneticchen.daijishou.utils.PlaidColorUtils;
import com.magneticchen.daijishou.view_models.DaijishouSynchronizationModel;
import java.util.Arrays;
import java.util.Calendar;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: compiled from: SplashScreenActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0012\u0010\u0012\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\fH\u0014R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/magneticchen/daijishou/activities/SplashScreenActivity;", "Lcom/magneticchen/daijishou/activities/abstract_classes/DaijishouAppCompatActivity;", "()V", "daijishouLibrarySynchronization", "Lcom/magneticchen/daijishou/view_models/DaijishouSynchronizationModel;", "getDaijishouLibrarySynchronization", "()Lcom/magneticchen/daijishou/view_models/DaijishouSynchronizationModel;", "daijishouLibrarySynchronization$delegate", "Lkotlin/Lazy;", "startTimestamp", "", "finishWithDelay", "", "isFirstInstall", "", "context", "Landroid/content/Context;", "isInstallFromUpdate", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SplashScreenActivity extends DaijishouAppCompatActivity {

    /* JADX INFO: renamed from: daijishouLibrarySynchronization$delegate, reason: from kotlin metadata */
    private final Lazy daijishouLibrarySynchronization;
    private long startTimestamp;

    public SplashScreenActivity() {
        SplashScreenActivity splashScreenActivity = this;
        this.daijishouLibrarySynchronization = new ViewModelLazy(Reflection.getOrCreateKotlinClass(DaijishouSynchronizationModel.class), new SplashScreenActivity$special$$inlined$viewModels$default$2(splashScreenActivity), new SplashScreenActivity$special$$inlined$viewModels$default$1(splashScreenActivity), new SplashScreenActivity$special$$inlined$viewModels$default$3(null, splashScreenActivity));
    }

    private final boolean isFirstInstall(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime == context.getPackageManager().getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return true;
        }
    }

    public final boolean isInstallFromUpdate(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime != context.getPackageManager().getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public final DaijishouSynchronizationModel getDaijishouLibrarySynchronization() {
        return (DaijishouSynchronizationModel) this.daijishouLibrarySynchronization.getValue();
    }

    @Override // com.magneticchen.daijishou.activities.abstract_classes.DaijishouAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        this.startTimestamp = System.currentTimeMillis();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.activity_splash_screen_root);
        TextView textView = (TextView) findViewById(R.id.splash_screen_version);
        TextView textView2 = (TextView) findViewById(R.id.splash_screen_description);
        TextView textView3 = (TextView) findViewById(R.id.about_this_app_copyright);
        textView.setText("Version: 1.5.0");
        String string = getString(R.string.copyright_statement);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String str = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(Calendar.getInstance().get(1))}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        if (getDefaultSharedPreferences().getBoolean(BooleanPreference.USE_DEBUG_MODE.getKey(), BooleanPreference.USE_DEBUG_MODE.getDefaultValue())) {
            str = str + " (Debug mode)";
        }
        textView3.setText(str);
        if (getDefaultSharedPreferences().getBoolean(BooleanPreference.USE_PURE_DARK_THEME.getKey(), BooleanPreference.USE_PURE_DARK_THEME.getDefaultValue())) {
            PlaidColorUtils plaidColorUtils = PlaidColorUtils.INSTANCE;
            Context baseContext = getBaseContext();
            Intrinsics.checkNotNullExpressionValue(baseContext, "getBaseContext(...)");
            if (plaidColorUtils.isDarkTheme(baseContext)) {
                constraintLayout.setBackgroundColor(Color.rgb(0, 0, 0));
            }
        }
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenStarted(new AnonymousClass1(textView2, this, this, null));
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.activities.SplashScreenActivity$onCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: SplashScreenActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.activities.SplashScreenActivity$onCreate$1", f = "SplashScreenActivity.kt", i = {}, l = {116, 119}, m = "invokeSuspendImpl", n = {}, s = {})
    static final class AnonymousClass1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        final /* synthetic */ SplashScreenActivity $activity;
        final /* synthetic */ TextView $descriptionTextView;
        int label;
        final /* synthetic */ SplashScreenActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TextView textView, SplashScreenActivity splashScreenActivity, SplashScreenActivity splashScreenActivity2, Continuation<?> continuation) {
            super(2, continuation);
            this.$descriptionTextView = textView;
            this.this$0 = splashScreenActivity;
            this.$activity = splashScreenActivity2;
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$descriptionTextView, this.this$0, this.$activity, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                try {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                }
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.activities.SplashScreenActivity$onCreate$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: SplashScreenActivity.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.activities.SplashScreenActivity$onCreate$1$1", f = "SplashScreenActivity.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
        static final class C00531 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
            final /* synthetic */ TextView $descriptionTextView;
            int label;
            final /* synthetic */ SplashScreenActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00531(TextView textView, SplashScreenActivity splashScreenActivity, Continuation<?> continuation) {
                super(2, continuation);
                this.$descriptionTextView = textView;
                this.this$0 = splashScreenActivity;
            }


            public final Continuation create(Object obj, Continuation<?> continuation) {
                return new C00531(this.$descriptionTextView, this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
                try {
                    try {
                        return ((C00531) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
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
                this.$descriptionTextView.setText(this.this$0.getString(R.string.checking_for_upgrade_scripts));
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x005b, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getDefault(), new com.magneticchen.daijishou.activities.SplashScreenActivity.AnonymousClass1.AnonymousClass2(r7.this$0, r7.$activity, r7.$descriptionTextView, null), r7) == r0) goto L15;
         */

        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspendImpl(java.lang.Object r8) throws java.lang.Throwable {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                r2 = 0
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L1f
                if (r1 == r4) goto L1b
                if (r1 != r3) goto L13
                kotlin.ResultKt.throwOnFailure(r8)
                goto L5e
            L13:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1b:
                kotlin.ResultKt.throwOnFailure(r8)
                goto L3f
            L1f:
                kotlin.ResultKt.throwOnFailure(r8)
                kotlinx.coroutines.MainCoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.getMain()
                kotlin.coroutines.CoroutineContext r8 = (kotlin.coroutines.CoroutineContext) r8
                com.magneticchen.daijishou.activities.SplashScreenActivity$onCreate$1$1 r1 = new com.magneticchen.daijishou.activities.SplashScreenActivity$onCreate$1$1
                android.widget.TextView r5 = r7.$descriptionTextView
                com.magneticchen.daijishou.activities.SplashScreenActivity r6 = r7.this$0
                r1.<init>(r5, r6, r2)
                kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
                r5 = r7
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                r7.label = r4
                java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r1, r5)
                if (r8 != r0) goto L3f
                goto L5d
            L3f:
                kotlinx.coroutines.CoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.getDefault()
                kotlin.coroutines.CoroutineContext r8 = (kotlin.coroutines.CoroutineContext) r8
                com.magneticchen.daijishou.activities.SplashScreenActivity$onCreate$1$2 r1 = new com.magneticchen.daijishou.activities.SplashScreenActivity$onCreate$1$2
                com.magneticchen.daijishou.activities.SplashScreenActivity r4 = r7.this$0
                com.magneticchen.daijishou.activities.SplashScreenActivity r5 = r7.$activity
                android.widget.TextView r6 = r7.$descriptionTextView
                r1.<init>(r4, r5, r6, r2)
                kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
                r2 = r7
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                r7.label = r3
                java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r1, r2)
                if (r8 != r0) goto L5e
            L5d:
                return r0
            L5e:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.activities.SplashScreenActivity.AnonymousClass1.invokeSuspendImpl(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.activities.SplashScreenActivity$onCreate$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: SplashScreenActivity.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.activities.SplashScreenActivity$onCreate$1$2", f = "SplashScreenActivity.kt", i = {}, l = {198}, m = "invokeSuspendImpl", n = {}, s = {})
        static final class AnonymousClass2 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
            final /* synthetic */ SplashScreenActivity $activity;
            final /* synthetic */ TextView $descriptionTextView;
            int label;
            final /* synthetic */ SplashScreenActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(SplashScreenActivity splashScreenActivity, SplashScreenActivity splashScreenActivity2, TextView textView, Continuation<?> continuation) {
                super(2, continuation);
                this.this$0 = splashScreenActivity;
                this.$activity = splashScreenActivity2;
                this.$descriptionTextView = textView;
            }


            public final Continuation create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, this.$activity, this.$descriptionTextView, continuation);
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
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CollectionsKt.sort(Constants.INSTANCE.getUpgradeScripts());
                    int i2 = this.this$0.getDefaultSharedPreferences().getInt(IntPreference.UPGRADED_VERSION.getKey(), IntPreference.UPGRADED_VERSION.getDefaultValue());
                    this.label = 1;
                    if (invokeSuspendImpl$nextUpgrade(new Ref.IntRef(), i2, this.$activity, this.this$0, this.$descriptionTextView, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Code duplicated, block: B:7:0x0014  */
            public static final Object invokeSuspendImpl$finalize(SplashScreenActivity splashScreenActivity, TextView textView, Continuation<?> continuation) throws Throwable {
                SplashScreenActivity$onCreate$1$2$finalize$1 splashScreenActivity$onCreate$1$2$finalize$1;
                if (continuation instanceof SplashScreenActivity$onCreate$1$2$finalize$1) {
                    splashScreenActivity$onCreate$1$2$finalize$1 = (SplashScreenActivity$onCreate$1$2$finalize$1) continuation;
                    if ((splashScreenActivity$onCreate$1$2$finalize$1.label & Integer.MIN_VALUE) != 0) {
                        splashScreenActivity$onCreate$1$2$finalize$1.label -= Integer.MIN_VALUE;
                    } else {
                        splashScreenActivity$onCreate$1$2$finalize$1 = new SplashScreenActivity$onCreate$1$2$finalize$1(continuation);
                    }
                } else {
                    splashScreenActivity$onCreate$1$2$finalize$1 = new SplashScreenActivity$onCreate$1$2$finalize$1(continuation);
                }
                Object obj = splashScreenActivity$onCreate$1$2$finalize$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = splashScreenActivity$onCreate$1$2$finalize$1.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    MainCoroutineDispatcher main = Dispatchers.getMain();
                    SplashScreenActivity$onCreate$1$2$finalize$2 splashScreenActivity$onCreate$1$2$finalize$2 = new SplashScreenActivity$onCreate$1$2$finalize$2(splashScreenActivity, textView, null);
                    splashScreenActivity$onCreate$1$2$finalize$1.L$0 = splashScreenActivity;
                    splashScreenActivity$onCreate$1$2$finalize$1.label = 1;
                    if (BuildersKt.withContext(main, splashScreenActivity$onCreate$1$2$finalize$2, splashScreenActivity$onCreate$1$2$finalize$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    splashScreenActivity = (SplashScreenActivity) splashScreenActivity$onCreate$1$2$finalize$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                splashScreenActivity.getDefaultSharedPreferences().edit().putInt(IntPreference.UPGRADED_VERSION.getKey(), 416).apply();
                if (Build.VERSION.SDK_INT < 30 && splashScreenActivity.getDefaultSharedPreferences().getString("preview_medias_path", null) != null && ContextCompat.checkSelfPermission(splashScreenActivity.getApplicationContext(), "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                    AcknowledgementDialogFragment.Companion.newInstance$default(AcknowledgementDialogFragment.INSTANCE, "Permission not granted", "Please make sure storage permission granted for " + splashScreenActivity.getResources().getString(R.string.app_name) + ". You can set it in the settings app. You can still use the app but might occur errors.", null, null, null, 28, null).setOnAcknowledgedListener(new SplashScreenActivity$onCreate$1$2$finalize$3(splashScreenActivity)).setOnCanceledListener(new SplashScreenActivity$onCreate$1$2$finalize$4(splashScreenActivity)).show(splashScreenActivity.getSupportFragmentManager(), "preview_medias_path");
                } else {
                    invokeSuspendImpl$finalize$launch(splashScreenActivity);
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void invokeSuspendImpl$finalize$launch(SplashScreenActivity splashScreenActivity) {
                splashScreenActivity.setResult(-1);
                splashScreenActivity.finishWithDelay();
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Code duplicated, block: B:7:0x001a  */
            /* JADX WARN: Code restructure failed: missing block: B:27:0x0088, code lost:
            
                if (invokeSuspendImpl$finalize(r4, r5, r3) == r6) goto L50;
             */
            /* JADX WARN: Code restructure failed: missing block: B:42:0x00f7, code lost:
            
                if (r2.upgrade(r0, r7, r3) == r6) goto L50;
             */
            /* JADX WARN: Code restructure failed: missing block: B:49:0x011d, code lost:
            
                if (kotlinx.coroutines.BuildersKt.withContext(r2, r4, r3) == r6) goto L50;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public static final java.lang.Object invokeSuspendImpl$nextUpgrade(kotlin.jvm.internal.Ref.IntRef r14, int r15, com.magneticchen.daijishou.activities.SplashScreenActivity r16, com.magneticchen.daijishou.activities.SplashScreenActivity r17, android.widget.TextView r18, kotlin.coroutines.Continuation<?> r19) throws java.lang.Throwable {
                /*
                    Method dump skipped, instruction units count: 336
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.activities.SplashScreenActivity.AnonymousClass1.AnonymousClass2.invokeSuspendImpl$nextUpgrade(kotlin.jvm.internal.Ref$IntRef, int, com.magneticchen.daijishou.activities.SplashScreenActivity, com.magneticchen.daijishou.activities.SplashScreenActivity, android.widget.TextView, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        Application application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        ((DaijishouApplication) application).notifyServicesUpgradeChance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishWithDelay() {
        long jCurrentTimeMillis = ((long) 1500) - (System.currentTimeMillis() - this.startTimestamp);
        if (jCurrentTimeMillis > 0) {
            new Handler(Looper.getMainLooper()).postDelayed(new SplashScreenActivity$$ExternalSyntheticLambda0(this), jCurrentTimeMillis);
        } else {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void finishWithDelay$lambda$0(SplashScreenActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }
}
