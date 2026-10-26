package com.magneticchen.daijishou.activities;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.lifecycle.LifecycleOwnerKt;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.activities.abstract_classes.DaijishouAppCompatActivity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* INFO: compiled from: BootstrapActivity.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0005H\u0014J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016R\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/magneticchen/daijishou/activities/BootstrapActivity;", "Lcom/magneticchen/daijishou/activities/abstract_classes/DaijishouAppCompatActivity;", "()V", "startForResult", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "startTimestamp", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "onWindowFocusChanged", "hasFocus", "", "startMainActivity", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class BootstrapActivity extends DaijishouAppCompatActivity {
    private final ActivityResultLauncher<Intent> startForResult;
    private long startTimestamp;

    public BootstrapActivity() {
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new BootstrapActivity$$ExternalSyntheticLambda0(this));
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.startForResult = activityResultLauncherRegisterForActivityResult;
    }

    public void startMainActivity() {
        Intent intent = new Intent(this, (Class<?>) MainActivity.class);
        Bundle extras = getIntent().getExtras();
        if ((extras != null ? extras.get("android.intent.extra.FROM_HOME_KEY") : null) != null) {
            intent.putExtra("android.intent.extra.FROM_HOME_KEY", true);
        }
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(268435456);
        startActivity(intent);
        finish();
    }

    /* INFO: Access modifiers changed from: private */
    public static final void startForResult$lambda$0(BootstrapActivity this$0, ActivityResult result) {
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

    @Override // com.magneticchen.daijishou.activities.abstract_classes.DaijishouAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        Bundle extras = getIntent().getExtras();
        if ((extras != null ? extras.get("android.intent.extra.FROM_HOME_KEY") : null) != null) {
            Application application = getApplication();
            Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
            DaijishouApplication daijishouApplication = (DaijishouApplication) application;
            daijishouApplication.setHomeKeyPressedCountSinceLeave(daijishouApplication.getHomeKeyPressedCountSinceLeave() + 1);
        }
        Application application2 = getApplication();
        Intrinsics.checkNotNull(application2, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        this.startTimestamp = System.currentTimeMillis();
        super.onCreate(savedInstanceState);
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenCreated(new AnonymousClass1((DaijishouApplication) application2, this, null));
    }

    /* INFO: renamed from: com.magneticchen.daijishou.activities.BootstrapActivity$onCreate$1, reason: invalid class name */
    /* INFO: compiled from: BootstrapActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.activities.BootstrapActivity$onCreate$1", f = "BootstrapActivity.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
    static final class AnonymousClass1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        final /* synthetic */ DaijishouApplication $daijishouApplication;
        int label;
        final /* synthetic */ BootstrapActivity this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(DaijishouApplication daijishouApplication, BootstrapActivity bootstrapActivity, Continuation<?> continuation) {
            super(2, continuation);
            this.$daijishouApplication = daijishouApplication;
            this.this$0 = bootstrapActivity;
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$daijishouApplication, this.this$0, continuation);
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

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (this.$daijishouApplication.getIsInitializing()) {
                return Unit.INSTANCE;
            }
            if (this.$daijishouApplication.getInitialized()) {
                this.this$0.startMainActivity();
            } else {
                Intent intent = new Intent(this.this$0, (Class<?>) SplashScreenActivity.class);
                this.$daijishouApplication.setInitializing(true);
                this.this$0.startForResult.launch(intent);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }
}
