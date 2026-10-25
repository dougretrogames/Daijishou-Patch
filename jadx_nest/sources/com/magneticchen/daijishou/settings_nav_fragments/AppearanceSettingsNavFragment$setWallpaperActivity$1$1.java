package com.magneticchen.daijishou.settings_nav_fragments;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.widget.Toast;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.application_data.Constants;
import com.magneticchen.daijishou.application_data.IntPreference;
import com.magneticchen.daijishou.utils.Utils;
import java.io.FileOutputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: AppearanceSettingsNavFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.settings_nav_fragments.AppearanceSettingsNavFragment$setWallpaperActivity$1$1", f = "AppearanceSettingsNavFragment.kt", i = {}, l = {83}, m = "invokeSuspendImpl", n = {}, s = {})
final class AppearanceSettingsNavFragment$setWallpaperActivity$1$1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    final /* synthetic */ Uri $contentUri;
    int label;
    final /* synthetic */ AppearanceSettingsNavFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppearanceSettingsNavFragment$setWallpaperActivity$1$1(AppearanceSettingsNavFragment appearanceSettingsNavFragment, Uri uri, Continuation<?> continuation) {
        super(2, continuation);
        this.this$0 = appearanceSettingsNavFragment;
        this.$contentUri = uri;
    }


    public final Continuation create(Object obj, Continuation<?> continuation) {
        return new AppearanceSettingsNavFragment$setWallpaperActivity$1$1(this.this$0, this.$contentUri, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((AppearanceSettingsNavFragment$setWallpaperActivity$1$1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }

    public final Object invokeSuspendImpl(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            InputStream inputStreamOpenInputStream = this.this$0.requireActivity().getContentResolver().openInputStream(this.$contentUri);
            if (inputStreamOpenInputStream != null) {
                InputStream inputStream = inputStreamOpenInputStream;
                try {
                    InputStream inputStream2 = inputStream;
                    FileOutputStream fileOutputStreamOpenFileOutput = this.this$0.requireContext().openFileOutput(Constants.wallpaperFilename, 0);
                    try {
                        FileOutputStream fileOutputStream = fileOutputStreamOpenFileOutput;
                        Intrinsics.checkNotNull(fileOutputStream);
                        long jCopyTo$default = ByteStreamsKt.copyTo$default(inputStream2, fileOutputStream, 0, 2, null);
                        CloseableKt.closeFinally(fileOutputStreamOpenFileOutput, null);
                        Boxing.boxLong(jCopyTo$default);
                        CloseableKt.closeFinally(inputStream, null);
                    } catch (Throwable th) {
                                                    CloseableKt.closeFinally(fileOutputStreamOpenFileOutput, th);
                            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                    }
                } catch (Throwable th3) {
                                            CloseableKt.closeFinally(inputStream, th3);
                        throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th3);
                }
            }
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(this.this$0.requireActivity().getContentResolver().openInputStream(this.$contentUri));
            Utils utils = Utils.INSTANCE;
            Intrinsics.checkNotNull(bitmapDecodeStream);
            Triple bitmapThemeColors$default = Utils.getBitmapThemeColors$default(utils, bitmapDecodeStream, 0.0f, 2, null);
            SharedPreferences.Editor editorEdit = this.this$0.getDefaultSharedPreferences().edit();
            editorEdit.putInt(IntPreference.WALLPAPER_HASH_CODE.getKey(), bitmapDecodeStream.hashCode());
            editorEdit.putInt(IntPreference.WALLPAPER_COLOR_THEME.getKey(), ((Number) bitmapThemeColors$default.getFirst()).intValue());
            editorEdit.putInt(IntPreference.WALLPAPER_COLOR_ICON_THEME.getKey(), ((Number) bitmapThemeColors$default.getSecond()).intValue());
            editorEdit.putInt(IntPreference.WALLPAPER_COLOR_ON_THEME.getKey(), ((Number) bitmapThemeColors$default.getThird()).intValue());
            editorEdit.apply();
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass3(this.this$0, null), this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.magneticchen.daijishou.settings_nav_fragments.AppearanceSettingsNavFragment$setWallpaperActivity$1$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: AppearanceSettingsNavFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.settings_nav_fragments.AppearanceSettingsNavFragment$setWallpaperActivity$1$1$3", f = "AppearanceSettingsNavFragment.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
    static final class AnonymousClass3 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        int label;
        final /* synthetic */ AppearanceSettingsNavFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(AppearanceSettingsNavFragment appearanceSettingsNavFragment, Continuation<?> continuation) {
            super(2, continuation);
            this.this$0 = appearanceSettingsNavFragment;
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                try {
                    return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
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
            Toast.makeText(this.this$0.requireContext(), this.this$0.getString(R.string.wallpaper_set), 0).show();
            return Unit.INSTANCE;
        }
    }
}
