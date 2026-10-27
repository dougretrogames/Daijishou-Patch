package com.magneticchen.daijishou.ui.activities;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.magneticchen.daijishou.BuildConfig;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.BooleanPreference;
import com.magneticchen.daijishou.data.Constants;
import com.magneticchen.daijishou.data.IntPreference;
import com.magneticchen.daijishou.ui.activities.abstract_classes.DaijishouAppCompatActivity;
import com.magneticchen.daijishou.ui.fragments.dialog.AcknowledgementDialogFragment;
import com.magneticchen.daijishou.utils.PlaidColorUtils;
import java.util.Arrays;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: SplashScreenActivity.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\f\u001a\u00020\bH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/magneticchen/daijishou/ui/activities/SplashScreenActivity;", "Lcom/magneticchen/daijishou/ui/activities/abstract_classes/DaijishouAppCompatActivity;", "()V", "startTimestamp", "", "createCopyrightMessage", "", "finishWithDelay", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SplashScreenActivity extends DaijishouAppCompatActivity {
    private long startTimestamp;

    @Override // com.magneticchen.daijishou.ui.activities.abstract_classes.DaijishouAppCompatActivity
    protected void onCreate(Bundle bundle) {
        this.startTimestamp = System.currentTimeMillis();
        super.onCreate(bundle);
        setContentView(R.layout.activity_splash_screen);
        ((TextView) findViewById(R.id.splash_screen_version)).setText("Version: 1.8.1");
        ((TextView) findViewById(R.id.about_this_app_copyright)).setText(createCopyrightMessage());
        ConstraintLayout constraintLayoutFindViewById = findViewById(R.id.activity_splash_screen_root);
        if (getDefaultSharedPreferences().getBoolean(BooleanPreference.USE_PURE_DARK_THEME.getKey(), BooleanPreference.USE_PURE_DARK_THEME.getDefaultValue())) {
            PlaidColorUtils plaidColorUtils = PlaidColorUtils.INSTANCE;
            Context baseContext = getBaseContext();
            Intrinsics.checkNotNullExpressionValue(baseContext, "getBaseContext(...)");
            if (plaidColorUtils.isDarkTheme(baseContext)) {
                constraintLayoutFindViewById.setBackgroundColor(Color.rgb(0, 0, 0));
            }
        }
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((TextView) findViewById(R.id.splash_screen_description), null), 3, (Object) null);
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.activities.SplashScreenActivity$onCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: SplashScreenActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.activities.SplashScreenActivity$onCreate$1", f = "SplashScreenActivity.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TextView $descriptionTextView;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TextView textView, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$descriptionTextView = textView;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SplashScreenActivity.this.new AnonymousClass1(this.$descriptionTextView, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.activities.SplashScreenActivity$onCreate$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: SplashScreenActivity.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.ui.activities.SplashScreenActivity$onCreate$1$1", f = "SplashScreenActivity.kt", i = {}, l = {81, 85}, m = "invokeSuspend", n = {}, s = {})
        static final class C00091 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ TextView $descriptionTextView;
            int label;
            final /* synthetic */ SplashScreenActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00091(TextView textView, SplashScreenActivity splashScreenActivity, Continuation<? super C00091> continuation) {
                super(2, continuation);
                this.$descriptionTextView = textView;
                this.this$0 = splashScreenActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00091(this.$descriptionTextView, this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00091) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code restructure failed: missing block: B:14:0x0059, code lost:
            
                if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getDefault(), new com.magneticchen.daijishou.ui.activities.SplashScreenActivity.AnonymousClass1.C00091.AnonymousClass2(r7.this$0, r7.$descriptionTextView, null), r7) == r0) goto L15;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r8) {
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
                    goto L5c
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
                    com.magneticchen.daijishou.ui.activities.SplashScreenActivity$onCreate$1$1$1 r1 = new com.magneticchen.daijishou.ui.activities.SplashScreenActivity$onCreate$1$1$1
                    android.widget.TextView r5 = r7.$descriptionTextView
                    com.magneticchen.daijishou.ui.activities.SplashScreenActivity r6 = r7.this$0
                    r1.<init>(r5, r6, r2)
                    kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
                    r5 = r7
                    kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                    r7.label = r4
                    java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r1, r5)
                    if (r8 != r0) goto L3f
                    goto L5b
                L3f:
                    kotlinx.coroutines.CoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.getDefault()
                    kotlin.coroutines.CoroutineContext r8 = (kotlin.coroutines.CoroutineContext) r8
                    com.magneticchen.daijishou.ui.activities.SplashScreenActivity$onCreate$1$1$2 r1 = new com.magneticchen.daijishou.ui.activities.SplashScreenActivity$onCreate$1$1$2
                    com.magneticchen.daijishou.ui.activities.SplashScreenActivity r4 = r7.this$0
                    android.widget.TextView r5 = r7.$descriptionTextView
                    r1.<init>(r4, r5, r2)
                    kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
                    r2 = r7
                    kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                    r7.label = r3
                    java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r1, r2)
                    if (r8 != r0) goto L5c
                L5b:
                    return r0
                L5c:
                    kotlin.Unit r8 = kotlin.Unit.INSTANCE
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.ui.activities.SplashScreenActivity.AnonymousClass1.C00091.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.activities.SplashScreenActivity$onCreate$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: SplashScreenActivity.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "com.magneticchen.daijishou.ui.activities.SplashScreenActivity$onCreate$1$1$1", f = "SplashScreenActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            static final class C00101 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ TextView $descriptionTextView;
                int label;
                final /* synthetic */ SplashScreenActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00101(TextView textView, SplashScreenActivity splashScreenActivity, Continuation<? super C00101> continuation) {
                    super(2, continuation);
                    this.$descriptionTextView = textView;
                    this.this$0 = splashScreenActivity;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C00101(this.$descriptionTextView, this.this$0, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C00101) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this.$descriptionTextView.setText(this.this$0.getString(R.string.checking_for_upgrade_scripts));
                    return Unit.INSTANCE;
                }
            }

            /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.activities.SplashScreenActivity$onCreate$1$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: SplashScreenActivity.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "com.magneticchen.daijishou.ui.activities.SplashScreenActivity$onCreate$1$1$2", f = "SplashScreenActivity.kt", i = {}, l = {171}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ TextView $descriptionTextView;
                int label;
                final /* synthetic */ SplashScreenActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(SplashScreenActivity splashScreenActivity, TextView textView, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.this$0 = splashScreenActivity;
                    this.$descriptionTextView = textView;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass2(this.this$0, this.$descriptionTextView, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        CollectionsKt.sort(Constants.INSTANCE.getUpgradeScripts());
                        int i2 = this.this$0.getDefaultSharedPreferences().getInt(IntPreference.UPGRADED_VERSION.getKey(), IntPreference.UPGRADED_VERSION.getDefaultValue());
                        this.label = 1;
                        if (invokeSuspend$nextUpgrade(new Ref.IntRef(), i2, this.this$0, this.$descriptionTextView, this) == coroutine_suspended) {
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
                public static final Object invokeSuspend$finalize(final SplashScreenActivity splashScreenActivity, TextView textView, Continuation<? super Unit> continuation) {
                    SplashScreenActivity$onCreate$1$1$2$finalize$1 splashScreenActivity$onCreate$1$1$2$finalize$1;
                    if (continuation instanceof SplashScreenActivity$onCreate$1$1$2$finalize$1) {
                        splashScreenActivity$onCreate$1$1$2$finalize$1 = (SplashScreenActivity$onCreate$1$1$2$finalize$1) continuation;
                        if ((splashScreenActivity$onCreate$1$1$2$finalize$1.label & Integer.MIN_VALUE) != 0) {
                            splashScreenActivity$onCreate$1$1$2$finalize$1.label -= Integer.MIN_VALUE;
                        } else {
                            splashScreenActivity$onCreate$1$1$2$finalize$1 = new SplashScreenActivity$onCreate$1$1$2$finalize$1(continuation);
                        }
                    } else {
                        splashScreenActivity$onCreate$1$1$2$finalize$1 = new SplashScreenActivity$onCreate$1$1$2$finalize$1(continuation);
                    }
                    Object obj = splashScreenActivity$onCreate$1$1$2$finalize$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = splashScreenActivity$onCreate$1$1$2$finalize$1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        CoroutineContext main = Dispatchers.getMain();
                        SplashScreenActivity$onCreate$1$1$2$finalize$2 splashScreenActivity$onCreate$1$1$2$finalize$2 = new SplashScreenActivity$onCreate$1$1$2$finalize$2(textView, splashScreenActivity, null);
                        splashScreenActivity$onCreate$1$1$2$finalize$1.L$0 = splashScreenActivity;
                        splashScreenActivity$onCreate$1$1$2$finalize$1.label = 1;
                        if (BuildersKt.withContext(main, splashScreenActivity$onCreate$1$1$2$finalize$2, splashScreenActivity$onCreate$1$1$2$finalize$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        splashScreenActivity = (SplashScreenActivity) splashScreenActivity$onCreate$1$1$2$finalize$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    SharedPreferences.Editor editorEdit = splashScreenActivity.getDefaultSharedPreferences().edit();
                    editorEdit.putInt(IntPreference.UPGRADED_VERSION.getKey(), BuildConfig.VERSION_CODE);
                    editorEdit.apply();
                    if (Build.VERSION.SDK_INT < 30 && splashScreenActivity.getDefaultSharedPreferences().getString("preview_medias_path", null) != null && ContextCompat.checkSelfPermission(splashScreenActivity.getApplicationContext(), "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                        AcknowledgementDialogFragment.Companion.newInstance$default(AcknowledgementDialogFragment.Companion, "Permission not granted", "Please make sure storage permission granted for " + splashScreenActivity.getResources().getString(R.string.app_name) + ". You can set it in the settings app. You can still use the app but might occur errors.", null, null, null, 28, null).setOnAcknowledgedListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.activities.SplashScreenActivity$onCreate$1$1$2$finalize$4
                            

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                SplashScreenActivity.AnonymousClass1.C00091.AnonymousClass2.invokeSuspend$finalize$launch(splashScreenActivity);
                            }
                        }).setOnCanceledListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.activities.SplashScreenActivity$onCreate$1$1$2$finalize$5
                            

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                SplashScreenActivity.AnonymousClass1.C00091.AnonymousClass2.invokeSuspend$finalize$launch(splashScreenActivity);
                            }
                        }).show(splashScreenActivity.getSupportFragmentManager(), "preview_medias_path");
                    } else {
                        invokeSuspend$finalize$launch(splashScreenActivity);
                    }
                    return Unit.INSTANCE;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void invokeSuspend$finalize$launch(SplashScreenActivity splashScreenActivity) {
                    splashScreenActivity.setResult(-1);
                    splashScreenActivity.finishWithDelay();
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                /* JADX WARN: Code restructure failed: missing block: B:27:0x007d, code lost:
                
                    if (invokeSuspend$finalize(r10, r11, r12) == r1) goto L44;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:38:0x00d7, code lost:
                
                    if (r8.upgrade(r10, r5, r12) == r1) goto L44;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:43:0x00f8, code lost:
                
                    if (kotlinx.coroutines.BuildersKt.withContext(r10, r11, r12) == r1) goto L44;
                 */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public static final java.lang.Object invokeSuspend$nextUpgrade(kotlin.jvm.internal.Ref.IntRef r8, final int r9, final com.magneticchen.daijishou.ui.activities.SplashScreenActivity r10, final android.widget.TextView r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
                    /*
                        Method dump skipped, instruction units count: 289
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.ui.activities.SplashScreenActivity.AnonymousClass1.C00091.AnonymousClass2.invokeSuspend$nextUpgrade(kotlin.jvm.internal.Ref$IntRef, int, com.magneticchen.daijishou.ui.activities.SplashScreenActivity, android.widget.TextView, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(SplashScreenActivity.this, Lifecycle.State.CREATED, new C00091(this.$descriptionTextView, SplashScreenActivity.this, null), this) == coroutine_suspended) {
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
    }

    protected void onStart() {
        super.onStart();
        Application application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        ((DaijishouApplication) application).notifyServicesUpgradeChance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishWithDelay() {
        long jCurrentTimeMillis = ((long) Constants.guaranteeSplashScreenMs) - (System.currentTimeMillis() - this.startTimestamp);
        if (jCurrentTimeMillis > 0) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.magneticchen.daijishou.ui.activities.SplashScreenActivity$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    SplashScreenActivity.finishWithDelay$lambda$0(this.f$0);
                }
            }, jCurrentTimeMillis);
        } else {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void finishWithDelay$lambda$0(SplashScreenActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    private final String createCopyrightMessage() {
        String string = getString(R.string.copyright_statement);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String str = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(Calendar.getInstance().get(1))}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return getDefaultSharedPreferences().getBoolean(BooleanPreference.USE_DEBUG_MODE.getKey(), BooleanPreference.USE_DEBUG_MODE.getDefaultValue()) ? str + " (Debug mode)" : str;
    }
}
