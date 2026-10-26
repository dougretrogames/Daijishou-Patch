package com.magneticchen.daijishou.activities;

import android.app.Application;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.google_drive.GoogleDrive;
import com.magneticchen.daijishou.live_data.ConnectionLiveData;
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

/* INFO: compiled from: MainActivity.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.activities.MainActivity$setupConnection$1$1$1", f = "MainActivity.kt", i = {}, l = {936}, m = "invokeSuspendImpl", n = {}, s = {})
final class MainActivity$setupConnection$1$1$1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    final /* synthetic */ ImageView $connectionImageView;
    final /* synthetic */ ConnectionLiveData $connectionLiveData;
    final /* synthetic */ Drawable $connectionOnCellularDrawable;
    final /* synthetic */ Drawable $connectionOnDrawable;
    int label;
    final /* synthetic */ MainActivity this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    MainActivity$setupConnection$1$1$1(MainActivity mainActivity, ImageView imageView, ConnectionLiveData connectionLiveData, Drawable drawable, Drawable drawable2, Continuation<?> continuation) {
        super(2, continuation);
        this.this$0 = mainActivity;
        this.$connectionImageView = imageView;
        this.$connectionLiveData = connectionLiveData;
        this.$connectionOnCellularDrawable = drawable;
        this.$connectionOnDrawable = drawable2;
    }


    public final Continuation create(Object obj, Continuation<?> continuation) {
        return new MainActivity$setupConnection$1$1$1(this.this$0, this.$connectionImageView, this.$connectionLiveData, this.$connectionOnCellularDrawable, this.$connectionOnDrawable, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((MainActivity$setupConnection$1$1$1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }

    public final Object invokeSuspendImpl(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (GoogleSignIn.getLastSignedInAccount(this.this$0.getApplication()) != null) {
                Application application = this.this$0.getApplication();
                Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
                this.label = 1;
                if (GoogleDrive.requestSignIn$default(((DaijishouApplication) application).getGoogleDrive(), false, this, 1, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        ImageView imageView = this.$connectionImageView;
        Integer value = this.$connectionLiveData.getValue();
        imageView.setImageDrawable((value != null && value.intValue() == 3) ? this.$connectionOnCellularDrawable : this.$connectionOnDrawable);
        return Unit.INSTANCE;
    }
}
