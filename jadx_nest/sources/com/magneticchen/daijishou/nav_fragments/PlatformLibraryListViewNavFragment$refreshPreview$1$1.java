package com.magneticchen.daijishou.nav_fragments;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.magneticchen.daijishou.cache.CachedBitmapLoader;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemPreviewMediaIndex;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.json.Json;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpStatus;

/* INFO: compiled from: PlatformLibraryListViewNavFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.nav_fragments.PlatformLibraryListViewNavFragment$refreshPreview$1$1", f = "PlatformLibraryListViewNavFragment.kt", i = {0}, l = {315, HttpStatus.SC_UNSUPPORTED_MEDIA_TYPE}, m = "invokeSuspendImpl", n = {"$this$launch"}, s = {"L$0"})
final class PlatformLibraryListViewNavFragment$refreshPreview$1$1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    final /* synthetic */ PlayableItemEntity $it;
    final /* synthetic */ PlayableItemEntity $loadingPlayableItemEntity;
    final /* synthetic */ int $previewMode;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PlatformLibraryListViewNavFragment this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    PlatformLibraryListViewNavFragment$refreshPreview$1$1(PlayableItemEntity playableItemEntity, PlayableItemEntity playableItemEntity2, PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment, int i, Continuation<?> continuation) {
        super(2, continuation);
        this.$it = playableItemEntity;
        this.$loadingPlayableItemEntity = playableItemEntity2;
        this.this$0 = platformLibraryListViewNavFragment;
        this.$previewMode = i;
    }


    public final Continuation create(Object obj, Continuation<?> continuation) {
        PlatformLibraryListViewNavFragment$refreshPreview$1$1 platformLibraryListViewNavFragment$refreshPreview$1$1 = new PlatformLibraryListViewNavFragment$refreshPreview$1$1(this.$it, this.$loadingPlayableItemEntity, this.this$0, this.$previewMode, continuation);
        platformLibraryListViewNavFragment$refreshPreview$1$1.L$0 = obj;
        return platformLibraryListViewNavFragment$refreshPreview$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((PlatformLibraryListViewNavFragment$refreshPreview$1$1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }

    public final Object invokeSuspendImpl(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            try {
                String str = this.$it.getPreviewMediaPath() + "index.json";
                String string = IOUtils.toString(new FileInputStream(str), StandardCharsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex = (PlayableItemPreviewMediaIndex) Json.Default.decodeFromString(PlayableItemPreviewMediaIndex.INSTANCE.serializer(), string);
                if (!Intrinsics.areEqual(this.$loadingPlayableItemEntity, this.this$0.selectedPlayableItemEntity)) {
                    return Unit.INSTANCE;
                }
                this.L$0 = coroutineScope;
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.$previewMode, playableItemPreviewMediaIndex, this.this$0, this.$it, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (Exception e) {
                this.this$0.getLogger().warn(coroutineScope, ExceptionsKt.stackTraceToString(e));
                this.L$0 = null;
                this.label = 2;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(this.this$0, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e2) {
                this.this$0.getLogger().warn(coroutineScope2, ExceptionsKt.stackTraceToString(e2));
                this.L$0 = null;
                this.label = 2;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(this.this$0, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: com.magneticchen.daijishou.nav_fragments.PlatformLibraryListViewNavFragment$refreshPreview$1$1$1, reason: invalid class name */
    /* INFO: compiled from: PlatformLibraryListViewNavFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.nav_fragments.PlatformLibraryListViewNavFragment$refreshPreview$1$1$1", f = "PlatformLibraryListViewNavFragment.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
    static final class AnonymousClass1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        final /* synthetic */ PlayableItemEntity $it;
        final /* synthetic */ PlayableItemPreviewMediaIndex $playableItemPreviewMediasIndex;
        final /* synthetic */ int $previewMode;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ PlatformLibraryListViewNavFragment this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i, PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex, PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment, PlayableItemEntity playableItemEntity, Continuation<?> continuation) {
            super(2, continuation);
            this.$previewMode = i;
            this.$playableItemPreviewMediasIndex = playableItemPreviewMediaIndex;
            this.this$0 = platformLibraryListViewNavFragment;
            this.$it = playableItemEntity;
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$previewMode, this.$playableItemPreviewMediasIndex, this.this$0, this.$it, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
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
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            int i = this.$previewMode;
            ImageView imageView = null;
            if (i == 0) {
                if (this.$playableItemPreviewMediasIndex.getBoxArtPath() == null) {
                    this.this$0.setThumbnail(null);
                } else {
                    CachedBitmapLoader.CachedBitmapLoaderTask cachedBitmapLoaderTaskLoad = this.this$0.getDaijishouLibrary().getCachedBoxArtBitmapLoader().with(this.this$0).setOnSucceedListener(new C00631(this.this$0)).setOnFailedListener(new AnonymousClass2(this.this$0, coroutineScope)).load(this.$it.getPreviewMediaPath() + this.$playableItemPreviewMediasIndex.getBoxArtPath());
                    ImageView imageView2 = this.this$0.thumbnailImageView;
                    if (imageView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("thumbnailImageView");
                        imageView2 = null;
                    }
                    cachedBitmapLoaderTaskLoad.into(imageView2);
                }
                if (this.$playableItemPreviewMediasIndex.getSnapshotPath() == null) {
                    this.this$0.setBackground(null);
                } else {
                    CachedBitmapLoader.CachedBitmapLoaderTask cachedBitmapLoaderTaskLoad2 = this.this$0.getDaijishouLibrary().getCachedSnapshotBitmapLoader().with(this.this$0).setOnSucceedListener(new AnonymousClass3(this.this$0)).setOnFailedListener(new AnonymousClass4(this.this$0, coroutineScope)).load(this.$it.getPreviewMediaPath() + this.$playableItemPreviewMediasIndex.getSnapshotPath());
                    ImageView imageView3 = this.this$0.backgroundImageView;
                    if (imageView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("backgroundImageView");
                    } else {
                        imageView = imageView3;
                    }
                    cachedBitmapLoaderTaskLoad2.into(imageView);
                }
            } else if (i == 1) {
                if (this.$playableItemPreviewMediasIndex.getSnapshotPath() == null) {
                    this.this$0.setThumbnail(null);
                } else {
                    CachedBitmapLoader.CachedBitmapLoaderTask cachedBitmapLoaderTaskLoad3 = this.this$0.getDaijishouLibrary().getCachedSnapshotBitmapLoader().with(this.this$0).setOnSucceedListener(new AnonymousClass5(this.this$0)).setOnFailedListener(new AnonymousClass6(this.this$0, coroutineScope)).load(this.$it.getPreviewMediaPath() + this.$playableItemPreviewMediasIndex.getSnapshotPath());
                    ImageView imageView4 = this.this$0.thumbnailImageView;
                    if (imageView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("thumbnailImageView");
                        imageView4 = null;
                    }
                    cachedBitmapLoaderTaskLoad3.into(imageView4);
                }
                if (this.$playableItemPreviewMediasIndex.getBoxArtPath() == null) {
                    this.this$0.setBackground(null);
                } else {
                    CachedBitmapLoader.CachedBitmapLoaderTask cachedBitmapLoaderTaskLoad4 = this.this$0.getDaijishouLibrary().getCachedBoxArtBitmapLoader().with(this.this$0).setOnSucceedListener(new AnonymousClass7(this.this$0)).setOnFailedListener(new AnonymousClass8(this.this$0, coroutineScope)).load(this.$it.getPreviewMediaPath() + this.$playableItemPreviewMediasIndex.getBoxArtPath());
                    ImageView imageView5 = this.this$0.backgroundImageView;
                    if (imageView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("backgroundImageView");
                    } else {
                        imageView = imageView5;
                    }
                    cachedBitmapLoaderTaskLoad4.into(imageView);
                }
            } else if (i == 2) {
                if (this.$playableItemPreviewMediasIndex.getTitlePath() == null) {
                    this.this$0.setThumbnail(null);
                } else {
                    CachedBitmapLoader.CachedBitmapLoaderTask cachedBitmapLoaderTaskLoad5 = this.this$0.getDaijishouLibrary().getCachedTitleBitmapLoader().with(this.this$0).setOnSucceedListener(new AnonymousClass9(this.this$0)).setOnFailedListener(new AnonymousClass10(this.this$0, coroutineScope)).load(this.$it.getPreviewMediaPath() + this.$playableItemPreviewMediasIndex.getTitlePath());
                    ImageView imageView6 = this.this$0.thumbnailImageView;
                    if (imageView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("thumbnailImageView");
                        imageView6 = null;
                    }
                    cachedBitmapLoaderTaskLoad5.into(imageView6);
                }
                if (this.$playableItemPreviewMediasIndex.getSnapshotPath() == null) {
                    this.this$0.setBackground(null);
                } else {
                    CachedBitmapLoader.CachedBitmapLoaderTask cachedBitmapLoaderTaskLoad6 = this.this$0.getDaijishouLibrary().getCachedSnapshotBitmapLoader().with(this.this$0).setOnSucceedListener(new AnonymousClass11(this.this$0)).setOnFailedListener(new AnonymousClass12(this.this$0, coroutineScope)).load(this.$it.getPreviewMediaPath() + this.$playableItemPreviewMediasIndex.getSnapshotPath());
                    ImageView imageView7 = this.this$0.backgroundImageView;
                    if (imageView7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("backgroundImageView");
                    } else {
                        imageView = imageView7;
                    }
                    cachedBitmapLoaderTaskLoad6.into(imageView);
                }
            }
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: com.magneticchen.daijishou.nav_fragments.PlatformLibraryListViewNavFragment$refreshPreview$1$1$1$1, reason: invalid class name and collision with other inner class name */
        /* INFO: compiled from: PlatformLibraryListViewNavFragment.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "bitmap", "Landroid/graphics/Bitmap;", "<anonymous parameter 1>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
        static final class C00631 extends Lambda<Unit> implements Function2<Bitmap, Boolean, Unit> {
            final /* synthetic */ PlatformLibraryListViewNavFragment this$0;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00631(PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment) {
                super(2);
                this.this$0 = platformLibraryListViewNavFragment;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap, Boolean bool) {
                invoke(bitmap, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Bitmap bitmap, boolean z) {
                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                this.this$0.setThumbnail(bitmap);
            }
        }

        /* INFO: renamed from: com.magneticchen.daijishou.nav_fragments.PlatformLibraryListViewNavFragment$refreshPreview$1$1$1$2, reason: invalid class name */
        /* INFO: compiled from: PlatformLibraryListViewNavFragment.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
        static final class AnonymousClass2 extends Lambda<Unit> implements Function1<Exception, Unit> {
            final /* synthetic */ CoroutineScope $$this$withContext;
            final /* synthetic */ PlatformLibraryListViewNavFragment this$0;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment, CoroutineScope coroutineScope) {
                super(1);
                this.this$0 = platformLibraryListViewNavFragment;
                this.$$this$withContext = coroutineScope;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                invoke2(exc);
                return Unit.INSTANCE;
            }

            /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Exception e) {
                Intrinsics.checkNotNullParameter(e, "e");
                this.this$0.getLogger().warn(this.$$this$withContext, ExceptionsKt.stackTraceToString(e));
                if (e instanceof CachedBitmapLoader.Companion.NewerBitmapLoadingException) {
                    return;
                }
                this.this$0.setThumbnail(null);
            }
        }

        /* INFO: renamed from: com.magneticchen.daijishou.nav_fragments.PlatformLibraryListViewNavFragment$refreshPreview$1$1$1$3, reason: invalid class name */
        /* INFO: compiled from: PlatformLibraryListViewNavFragment.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "bitmap", "Landroid/graphics/Bitmap;", "<anonymous parameter 1>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
        static final class AnonymousClass3 extends Lambda<Unit> implements Function2<Bitmap, Boolean, Unit> {
            final /* synthetic */ PlatformLibraryListViewNavFragment this$0;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment) {
                super(2);
                this.this$0 = platformLibraryListViewNavFragment;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap, Boolean bool) {
                invoke(bitmap, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Bitmap bitmap, boolean z) {
                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                this.this$0.setBackground(bitmap);
            }
        }

        /* INFO: renamed from: com.magneticchen.daijishou.nav_fragments.PlatformLibraryListViewNavFragment$refreshPreview$1$1$1$4, reason: invalid class name */
        /* INFO: compiled from: PlatformLibraryListViewNavFragment.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
        static final class AnonymousClass4 extends Lambda<Unit> implements Function1<Exception, Unit> {
            final /* synthetic */ CoroutineScope $$this$withContext;
            final /* synthetic */ PlatformLibraryListViewNavFragment this$0;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass4(PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment, CoroutineScope coroutineScope) {
                super(1);
                this.this$0 = platformLibraryListViewNavFragment;
                this.$$this$withContext = coroutineScope;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                invoke2(exc);
                return Unit.INSTANCE;
            }

            /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Exception e) {
                Intrinsics.checkNotNullParameter(e, "e");
                this.this$0.getLogger().warn(this.$$this$withContext, ExceptionsKt.stackTraceToString(e));
                if (e instanceof CachedBitmapLoader.Companion.NewerBitmapLoadingException) {
                    return;
                }
                this.this$0.setBackground(null);
            }
        }

        /* INFO: renamed from: com.magneticchen.daijishou.nav_fragments.PlatformLibraryListViewNavFragment$refreshPreview$1$1$1$5, reason: invalid class name */
        /* INFO: compiled from: PlatformLibraryListViewNavFragment.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "bitmap", "Landroid/graphics/Bitmap;", "<anonymous parameter 1>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
        static final class AnonymousClass5 extends Lambda<Unit> implements Function2<Bitmap, Boolean, Unit> {
            final /* synthetic */ PlatformLibraryListViewNavFragment this$0;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass5(PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment) {
                super(2);
                this.this$0 = platformLibraryListViewNavFragment;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap, Boolean bool) {
                invoke(bitmap, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Bitmap bitmap, boolean z) {
                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                this.this$0.setThumbnail(bitmap);
            }
        }

        /* INFO: renamed from: com.magneticchen.daijishou.nav_fragments.PlatformLibraryListViewNavFragment$refreshPreview$1$1$1$6, reason: invalid class name */
        /* INFO: compiled from: PlatformLibraryListViewNavFragment.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
        static final class AnonymousClass6 extends Lambda<Unit> implements Function1<Exception, Unit> {
            final /* synthetic */ CoroutineScope $$this$withContext;
            final /* synthetic */ PlatformLibraryListViewNavFragment this$0;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass6(PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment, CoroutineScope coroutineScope) {
                super(1);
                this.this$0 = platformLibraryListViewNavFragment;
                this.$$this$withContext = coroutineScope;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                invoke2(exc);
                return Unit.INSTANCE;
            }

            /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Exception e) {
                Intrinsics.checkNotNullParameter(e, "e");
                this.this$0.getLogger().warn(this.$$this$withContext, ExceptionsKt.stackTraceToString(e));
                if (e instanceof CachedBitmapLoader.Companion.NewerBitmapLoadingException) {
                    return;
                }
                this.this$0.setThumbnail(null);
            }
        }

        /* INFO: renamed from: com.magneticchen.daijishou.nav_fragments.PlatformLibraryListViewNavFragment$refreshPreview$1$1$1$7, reason: invalid class name */
        /* INFO: compiled from: PlatformLibraryListViewNavFragment.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "bitmap", "Landroid/graphics/Bitmap;", "<anonymous parameter 1>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
        static final class AnonymousClass7 extends Lambda<Unit> implements Function2<Bitmap, Boolean, Unit> {
            final /* synthetic */ PlatformLibraryListViewNavFragment this$0;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass7(PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment) {
                super(2);
                this.this$0 = platformLibraryListViewNavFragment;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap, Boolean bool) {
                invoke(bitmap, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Bitmap bitmap, boolean z) {
                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                this.this$0.setBackground(bitmap);
            }
        }

        /* INFO: renamed from: com.magneticchen.daijishou.nav_fragments.PlatformLibraryListViewNavFragment$refreshPreview$1$1$1$8, reason: invalid class name */
        /* INFO: compiled from: PlatformLibraryListViewNavFragment.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
        static final class AnonymousClass8 extends Lambda<Unit> implements Function1<Exception, Unit> {
            final /* synthetic */ CoroutineScope $$this$withContext;
            final /* synthetic */ PlatformLibraryListViewNavFragment this$0;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass8(PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment, CoroutineScope coroutineScope) {
                super(1);
                this.this$0 = platformLibraryListViewNavFragment;
                this.$$this$withContext = coroutineScope;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                invoke2(exc);
                return Unit.INSTANCE;
            }

            /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Exception e) {
                Intrinsics.checkNotNullParameter(e, "e");
                this.this$0.getLogger().warn(this.$$this$withContext, ExceptionsKt.stackTraceToString(e));
                if (e instanceof CachedBitmapLoader.Companion.NewerBitmapLoadingException) {
                    return;
                }
                this.this$0.setBackground(null);
            }
        }

        /* INFO: renamed from: com.magneticchen.daijishou.nav_fragments.PlatformLibraryListViewNavFragment$refreshPreview$1$1$1$9, reason: invalid class name */
        /* INFO: compiled from: PlatformLibraryListViewNavFragment.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "bitmap", "Landroid/graphics/Bitmap;", "<anonymous parameter 1>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
        static final class AnonymousClass9 extends Lambda<Unit> implements Function2<Bitmap, Boolean, Unit> {
            final /* synthetic */ PlatformLibraryListViewNavFragment this$0;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass9(PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment) {
                super(2);
                this.this$0 = platformLibraryListViewNavFragment;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap, Boolean bool) {
                invoke(bitmap, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Bitmap bitmap, boolean z) {
                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                this.this$0.setThumbnail(bitmap);
            }
        }

        /* INFO: renamed from: com.magneticchen.daijishou.nav_fragments.PlatformLibraryListViewNavFragment$refreshPreview$1$1$1$10, reason: invalid class name */
        /* INFO: compiled from: PlatformLibraryListViewNavFragment.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
        static final class AnonymousClass10 extends Lambda<Unit> implements Function1<Exception, Unit> {
            final /* synthetic */ CoroutineScope $$this$withContext;
            final /* synthetic */ PlatformLibraryListViewNavFragment this$0;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass10(PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment, CoroutineScope coroutineScope) {
                super(1);
                this.this$0 = platformLibraryListViewNavFragment;
                this.$$this$withContext = coroutineScope;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                invoke2(exc);
                return Unit.INSTANCE;
            }

            /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Exception e) {
                Intrinsics.checkNotNullParameter(e, "e");
                this.this$0.getLogger().warn(this.$$this$withContext, ExceptionsKt.stackTraceToString(e));
                if (e instanceof CachedBitmapLoader.Companion.NewerBitmapLoadingException) {
                    return;
                }
                this.this$0.setThumbnail(null);
            }
        }

        /* INFO: renamed from: com.magneticchen.daijishou.nav_fragments.PlatformLibraryListViewNavFragment$refreshPreview$1$1$1$11, reason: invalid class name */
        /* INFO: compiled from: PlatformLibraryListViewNavFragment.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "bitmap", "Landroid/graphics/Bitmap;", "<anonymous parameter 1>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
        static final class AnonymousClass11 extends Lambda<Unit> implements Function2<Bitmap, Boolean, Unit> {
            final /* synthetic */ PlatformLibraryListViewNavFragment this$0;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass11(PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment) {
                super(2);
                this.this$0 = platformLibraryListViewNavFragment;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap, Boolean bool) {
                invoke(bitmap, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Bitmap bitmap, boolean z) {
                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                this.this$0.setBackground(bitmap);
            }
        }

        /* INFO: renamed from: com.magneticchen.daijishou.nav_fragments.PlatformLibraryListViewNavFragment$refreshPreview$1$1$1$12, reason: invalid class name */
        /* INFO: compiled from: PlatformLibraryListViewNavFragment.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
        static final class AnonymousClass12 extends Lambda<Unit> implements Function1<Exception, Unit> {
            final /* synthetic */ CoroutineScope $$this$withContext;
            final /* synthetic */ PlatformLibraryListViewNavFragment this$0;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass12(PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment, CoroutineScope coroutineScope) {
                super(1);
                this.this$0 = platformLibraryListViewNavFragment;
                this.$$this$withContext = coroutineScope;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                invoke2(exc);
                return Unit.INSTANCE;
            }

            /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Exception e) {
                Intrinsics.checkNotNullParameter(e, "e");
                this.this$0.getLogger().warn(this.$$this$withContext, ExceptionsKt.stackTraceToString(e));
                if (e instanceof CachedBitmapLoader.Companion.NewerBitmapLoadingException) {
                    return;
                }
                this.this$0.setBackground(null);
            }
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.nav_fragments.PlatformLibraryListViewNavFragment$refreshPreview$1$1$2, reason: invalid class name */
    /* INFO: compiled from: PlatformLibraryListViewNavFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.nav_fragments.PlatformLibraryListViewNavFragment$refreshPreview$1$1$2", f = "PlatformLibraryListViewNavFragment.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
    static final class AnonymousClass2 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        int label;
        final /* synthetic */ PlatformLibraryListViewNavFragment this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment, Continuation<?> continuation) {
            super(2, continuation);
            this.this$0 = platformLibraryListViewNavFragment;
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, continuation);
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
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ImageView imageView = this.this$0.thumbnailImageView;
                ImageView imageView2 = null;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("thumbnailImageView");
                    imageView = null;
                }
                imageView.setImageBitmap(null);
                this.this$0.setBackground(null);
                ImageView imageView3 = this.this$0.backgroundGradientImageView;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("backgroundGradientImageView");
                } else {
                    imageView2 = imageView3;
                }
                imageView2.setVisibility(8);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
