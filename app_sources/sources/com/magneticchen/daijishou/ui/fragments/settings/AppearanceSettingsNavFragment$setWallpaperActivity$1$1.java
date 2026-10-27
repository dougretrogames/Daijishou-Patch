package com.magneticchen.daijishou.ui.fragments.settings;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.widget.Toast;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.Constants;
import com.magneticchen.daijishou.data.IntPreference;
import com.magneticchen.daijishou.utils.Utils;
import com.skydoves.balloon.internals.DefinitionKt;
import java.io.FileNotFoundException;
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
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.settings.AppearanceSettingsNavFragment$setWallpaperActivity$1$1", f = "AppearanceSettingsNavFragment.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, s = {})
final class AppearanceSettingsNavFragment$setWallpaperActivity$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Uri $contentUri;
    int label;
    final /* synthetic */ AppearanceSettingsNavFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppearanceSettingsNavFragment$setWallpaperActivity$1$1(AppearanceSettingsNavFragment appearanceSettingsNavFragment, Uri uri, Continuation<? super AppearanceSettingsNavFragment$setWallpaperActivity$1$1> continuation) {
        super(2, continuation);
        this.this$0 = appearanceSettingsNavFragment;
        this.$contentUri = uri;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppearanceSettingsNavFragment$setWallpaperActivity$1$1(this.this$0, this.$contentUri, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AppearanceSettingsNavFragment$setWallpaperActivity$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws FileNotFoundException {
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
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(fileOutputStreamOpenFileOutput, th);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        CloseableKt.closeFinally(inputStream, th3);
                        throw th4;
                    }
                }
            }
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(this.this$0.requireActivity().getContentResolver().openInputStream(this.$contentUri));
            Utils utils = Utils.INSTANCE;
            Intrinsics.checkNotNull(bitmapDecodeStream);
            Triple bitmapThemeColors$default = Utils.getBitmapThemeColors$default(utils, bitmapDecodeStream, DefinitionKt.NO_Float_VALUE, 2, null);
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

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.fragments.settings.AppearanceSettingsNavFragment$setWallpaperActivity$1$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: AppearanceSettingsNavFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.settings.AppearanceSettingsNavFragment$setWallpaperActivity$1$1$3", f = "AppearanceSettingsNavFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AppearanceSettingsNavFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(AppearanceSettingsNavFragment appearanceSettingsNavFragment, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.this$0 = appearanceSettingsNavFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
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
