package com.magneticchen.daijishou.settings_nav_fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import android.widget.Toast;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.application_data.Constants;
import com.magneticchen.daijishou.application_data.IntPreference;
import com.magneticchen.daijishou.scraper.ScraperUtilsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* INFO: compiled from: VideoAndSoundsSettingsNavFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.settings_nav_fragments.VideoAndSoundsSettingsNavFragment$setBackgroundMusicActivity$1$1", f = "VideoAndSoundsSettingsNavFragment.kt", i = {}, l = {61}, m = "invokeSuspendImpl", n = {}, s = {})
final class VideoAndSoundsSettingsNavFragment$setBackgroundMusicActivity$1$1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    final /* synthetic */ Uri $it;
    int label;
    final /* synthetic */ VideoAndSoundsSettingsNavFragment this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoAndSoundsSettingsNavFragment$setBackgroundMusicActivity$1$1(VideoAndSoundsSettingsNavFragment videoAndSoundsSettingsNavFragment, Uri uri, Continuation<?> continuation) {
        super(2, continuation);
        this.this$0 = videoAndSoundsSettingsNavFragment;
        this.$it = uri;
    }


    public final Continuation create(Object obj, Continuation<?> continuation) {
        return new VideoAndSoundsSettingsNavFragment$setBackgroundMusicActivity$1$1(this.this$0, this.$it, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((VideoAndSoundsSettingsNavFragment$setBackgroundMusicActivity$1$1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }

    public final Object invokeSuspendImpl(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MimeTypeMap.getSingleton().getExtensionFromMimeType(this.this$0.requireActivity().getContentResolver().getType(this.$it));
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(this.this$0.requireActivity().getContentResolver().openInputStream(this.$it));
            Intrinsics.checkNotNull(bitmapDecodeStream);
            Bitmap resizedBitmap = ScraperUtilsKt.getResizedBitmap(bitmapDecodeStream, 720);
            if (resizedBitmap == null) {
                resizedBitmap = bitmapDecodeStream;
            }
            resizedBitmap.compress(Constants.INSTANCE.getScraperFormat(), 100, this.this$0.requireContext().openFileOutput(Constants.wallpaperFilename, 0));
            this.this$0.getDefaultSharedPreferences().edit().putInt(IntPreference.BACKGROUND_MUSIC_HASH_CODE.getKey(), bitmapDecodeStream.hashCode()).apply();
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.this$0, null), this) == coroutine_suspended) {
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

    /* INFO: renamed from: com.magneticchen.daijishou.settings_nav_fragments.VideoAndSoundsSettingsNavFragment$setBackgroundMusicActivity$1$1$1, reason: invalid class name */
    /* INFO: compiled from: VideoAndSoundsSettingsNavFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.settings_nav_fragments.VideoAndSoundsSettingsNavFragment$setBackgroundMusicActivity$1$1$1", f = "VideoAndSoundsSettingsNavFragment.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
    static final class AnonymousClass1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        int label;
        final /* synthetic */ VideoAndSoundsSettingsNavFragment this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(VideoAndSoundsSettingsNavFragment videoAndSoundsSettingsNavFragment, Continuation<?> continuation) {
            super(2, continuation);
            this.this$0 = videoAndSoundsSettingsNavFragment;
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
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
            Toast.makeText(this.this$0.requireContext(), this.this$0.getString(R.string.wallpaper_set), 0).show();
            return Unit.INSTANCE;
        }
    }
}
