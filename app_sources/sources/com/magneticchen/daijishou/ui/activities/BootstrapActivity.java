package com.magneticchen.daijishou.ui.activities;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.ui.activities.abstract_classes.DaijishouAppCompatActivity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: compiled from: BootstrapActivity.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0005H\u0014J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016R\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/magneticchen/daijishou/ui/activities/BootstrapActivity;", "Lcom/magneticchen/daijishou/ui/activities/abstract_classes/DaijishouAppCompatActivity;", "()V", "startForResult", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "startTimestamp", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "onWindowFocusChanged", "hasFocus", "", "startMainActivity", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class BootstrapActivity extends DaijishouAppCompatActivity {
    private final ActivityResultLauncher<Intent> startForResult;
    private long startTimestamp;

    public BootstrapActivity() {
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.magneticchen.daijishou.ui.activities.BootstrapActivity$$ExternalSyntheticLambda0
            public final void onActivityResult(Object obj) {
                BootstrapActivity.startForResult$lambda$1(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.startForResult = activityResultLauncherRegisterForActivityResult;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void startMainActivity() {
        Intent intent = new Intent((Context) this, (Class<?>) MainActivity.class);
        Bundle extras = intent.getExtras();
        if ((extras != null ? Boolean.valueOf(extras.getBoolean("android.intent.extra.FROM_HOME_KEY")) : null) != null) {
            intent.putExtra("android.intent.extra.FROM_HOME_KEY", true);
        }
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(268435456);
        startActivity(intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startForResult$lambda$1(BootstrapActivity this$0, ActivityResult result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        Application application = this$0.getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        DaijishouApplication daijishouApplication = (DaijishouApplication) application;
        daijishouApplication.setInitializing(false);
        if (result.getResultCode() == -1) {
            daijishouApplication.setInitialized(true);
            this$0.startMainActivity();
        } else {
            this$0.finish();
        }
    }

    @Override // com.magneticchen.daijishou.ui.activities.abstract_classes.DaijishouAppCompatActivity
    protected void onCreate(Bundle bundle) {
        this.startTimestamp = System.currentTimeMillis();
        Bundle extras = getIntent().getExtras();
        if ((extras != null ? Boolean.valueOf(extras.getBoolean("android.intent.extra.FROM_HOME_KEY")) : null) != null) {
            Application application = getApplication();
            Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
            DaijishouApplication daijishouApplication = (DaijishouApplication) application;
            daijishouApplication.setHomeKeyPressedCountSinceLeave(daijishouApplication.getHomeKeyPressedCountSinceLeave() + 1);
        }
        super.onCreate(bundle);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(null), 3, (Object) null);
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.activities.BootstrapActivity$onCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: BootstrapActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.activities.BootstrapActivity$onCreate$1", f = "BootstrapActivity.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BootstrapActivity.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.activities.BootstrapActivity$onCreate$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: BootstrapActivity.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.ui.activities.BootstrapActivity$onCreate$1$1", f = "BootstrapActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00061 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ BootstrapActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00061(BootstrapActivity bootstrapActivity, Continuation<? super C00061> continuation) {
                super(2, continuation);
                this.this$0 = bootstrapActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00061(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00061) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Application application = this.this$0.getApplication();
                Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
                DaijishouApplication daijishouApplication = (DaijishouApplication) application;
                if (daijishouApplication.isInitializing()) {
                    return Unit.INSTANCE;
                }
                if (daijishouApplication.getInitialized()) {
                    this.this$0.startMainActivity();
                } else {
                    Intent intent = new Intent((Context) this.this$0, (Class<?>) SplashScreenActivity.class);
                    daijishouApplication.setInitializing(true);
                    this.this$0.startForResult.launch(intent);
                }
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Lifecycle lifecycle = BootstrapActivity.this.getLifecycle();
                Intrinsics.checkNotNullExpressionValue(lifecycle, "<get-lifecycle>(...)");
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(lifecycle, Lifecycle.State.CREATED, new C00061(BootstrapActivity.this, null), this) == coroutine_suspended) {
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

    protected void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }
}
