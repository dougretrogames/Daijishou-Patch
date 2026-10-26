package com.magneticchen.daijishou.dialog_fragments;

import android.app.Application;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.application_data.StringPreference;
import com.magneticchen.daijishou.daijishou_library_db.portables.PlatformsIndexJson;
import com.magneticchen.daijishou.utils.Utils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.json.Json;

/* INFO: compiled from: DownloadPlatformsDialogFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.dialog_fragments.DownloadPlatformsDialogFragment$onStart$1$1", f = "DownloadPlatformsDialogFragment.kt", i = {}, l = {75, 93}, m = "invokeSuspendImpl", n = {}, s = {})
final class DownloadPlatformsDialogFragment$onStart$1$1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ Dialog $dialog;
    int label;
    final /* synthetic */ DownloadPlatformsDialogFragment this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadPlatformsDialogFragment$onStart$1$1(DownloadPlatformsDialogFragment downloadPlatformsDialogFragment, FragmentActivity fragmentActivity, Dialog dialog, Continuation<?> continuation) {
        super(2, continuation);
        this.this$0 = downloadPlatformsDialogFragment;
        this.$activity = fragmentActivity;
        this.$dialog = dialog;
    }

    public final Continuation create(Object obj, Continuation<?> continuation) {
        return new DownloadPlatformsDialogFragment$onStart$1$1(this.this$0, this.$activity, this.$dialog, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((DownloadPlatformsDialogFragment$onStart$1$1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }

    public final Object invokeSuspendImpl(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                DownloadPlatformsDialogFragment downloadPlatformsDialogFragment = this.this$0;
                FragmentActivity activity = this.$activity;
                Application application = activity.getApplication();
                Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
                DaijishouApplication daijishouApplication = (DaijishouApplication) application;
                Json weakJson = daijishouApplication.getWeakJson();
                PlatformsIndexJson.Companion companion = PlatformsIndexJson.INSTANCE;
                KSerializer serializer = companion.serializer();
                Utils utils = Utils.INSTANCE;
                DownloadPlatformsDialogFragment fragment = this.this$0;
                SharedPreferences defaultSharedPreferences = fragment.getDefaultSharedPreferences();
                StringPreference stringPreference = StringPreference.INDEX_URI;
                String key = stringPreference.getKey();
                String defaultValue = stringPreference.getDefaultValue();
                String string = defaultSharedPreferences.getString(key, defaultValue);
                Intrinsics.checkNotNull(string);
                String readEntireTextFromURL = utils.readEntireTextFromURL(string);
                PlatformsIndexJson platformsIndexJson = (PlatformsIndexJson) weakJson.decodeFromString(serializer, readEntireTextFromURL);
                downloadPlatformsDialogFragment.platformsIndexJson = platformsIndexJson;
                PlatformsIndexJson platformsIndexJson2 = this.this$0.platformsIndexJson;
                if (platformsIndexJson2 != null) {
                    DownloadPlatformsDialogFragment fragment2 = this.this$0;
                    Dialog dialog = this.$dialog;
                    CoroutineContext mainContext = (CoroutineContext) Dispatchers.getMain();
                    DownloadPlatformsDialogFragment$onStart$1$1$1$1 action = new DownloadPlatformsDialogFragment$onStart$1$1$1$1(fragment2, dialog, platformsIndexJson2, null);
                    this.label = 1;
                    if (BuildersKt.withContext(mainContext, action, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } catch (Exception e) {
                CoroutineContext mainContext2 = (CoroutineContext) Dispatchers.getMain();
                AnonymousClass2 action2 = new AnonymousClass2(this.this$0, e, null);
                this.label = 2;
                if (BuildersKt.withContext(mainContext2, action2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (r1 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e) {
                CoroutineContext mainContext2 = (CoroutineContext) Dispatchers.getMain();
                AnonymousClass2 action2 = new AnonymousClass2(this.this$0, e, null);
                this.label = 2;
                if (BuildersKt.withContext(mainContext2, action2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (r1 == 2) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.DownloadPlatformsDialogFragment$onStart$1$1$2, reason: invalid class name */
    /* INFO: compiled from: DownloadPlatformsDialogFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.dialog_fragments.DownloadPlatformsDialogFragment$onStart$1$1$2", f = "DownloadPlatformsDialogFragment.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
    static final class AnonymousClass2 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        final /* synthetic */ Exception $e;
        int label;
        final /* synthetic */ DownloadPlatformsDialogFragment this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(DownloadPlatformsDialogFragment downloadPlatformsDialogFragment, Exception exc, Continuation<?> continuation) {
            super(2, continuation);
            this.this$0 = downloadPlatformsDialogFragment;
            this.$e = exc;
        }

        public final Continuation create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, this.$e, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
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
            Toast.makeText(this.this$0.getContext(), this.$e.toString(), 0).show();
            return Unit.INSTANCE;
        }
    }
}
