package com.magneticchen.daijishou.ui.activities;

import android.app.Application;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.data.live.ConnectionLiveData;
import com.magneticchen.daijishou.features.GoogleDrive;
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

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.ui.activities.MainActivity$initConnectionObserver$1$1$1", f = "MainActivity.kt", i = {}, l = {1137}, m = "invokeSuspend", n = {}, s = {})
final class MainActivity$initConnectionObserver$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ImageView $connectionImageView;
    final /* synthetic */ ConnectionLiveData $connectionLiveData;
    final /* synthetic */ Drawable $connectionOnCellularDrawable;
    final /* synthetic */ Drawable $connectionOnDrawable;
    int label;
    final /* synthetic */ MainActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MainActivity$initConnectionObserver$1$1$1(MainActivity mainActivity, ImageView imageView, ConnectionLiveData connectionLiveData, Drawable drawable, Drawable drawable2, Continuation<? super MainActivity$initConnectionObserver$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = mainActivity;
        this.$connectionImageView = imageView;
        this.$connectionLiveData = connectionLiveData;
        this.$connectionOnCellularDrawable = drawable;
        this.$connectionOnDrawable = drawable2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivity$initConnectionObserver$1$1$1(this.this$0, this.$connectionImageView, this.$connectionLiveData, this.$connectionOnCellularDrawable, this.$connectionOnDrawable, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainActivity$initConnectionObserver$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
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
        Integer num = (Integer) this.$connectionLiveData.getValue();
        imageView.setImageDrawable((num != null && num.intValue() == 3) ? this.$connectionOnCellularDrawable : this.$connectionOnDrawable);
        return Unit.INSTANCE;
    }
}
