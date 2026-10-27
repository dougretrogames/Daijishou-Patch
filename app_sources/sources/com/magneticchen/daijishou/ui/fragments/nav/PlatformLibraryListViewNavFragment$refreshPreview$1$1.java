package com.magneticchen.daijishou.ui.fragments.nav;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.magneticchen.daijishou.cache.CachedBitmapLoader;
import com.magneticchen.daijishou.data.PlayableItemPreviewMediaIndex;
import com.magneticchen.daijishou.data.db.entity.PlayableItemEntity;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PlatformLibraryListViewNavFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment$refreshPreview$1$1", f = "PlatformLibraryListViewNavFragment.kt", i = {0}, l = {307, 407}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class PlatformLibraryListViewNavFragment$refreshPreview$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PlayableItemEntity $it;
    final /* synthetic */ PlayableItemEntity $loadingPlayableItemEntity;
    final /* synthetic */ int $previewMode;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PlatformLibraryListViewNavFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PlatformLibraryListViewNavFragment$refreshPreview$1$1(PlayableItemEntity playableItemEntity, PlayableItemEntity playableItemEntity2, PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment, int i, Continuation<? super PlatformLibraryListViewNavFragment$refreshPreview$1$1> continuation) {
        super(2, continuation);
        this.$it = playableItemEntity;
        this.$loadingPlayableItemEntity = playableItemEntity2;
        this.this$0 = platformLibraryListViewNavFragment;
        this.$previewMode = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PlatformLibraryListViewNavFragment$refreshPreview$1$1 platformLibraryListViewNavFragment$refreshPreview$1$1 = new PlatformLibraryListViewNavFragment$refreshPreview$1$1(this.$it, this.$loadingPlayableItemEntity, this.this$0, this.$previewMode, continuation);
        platformLibraryListViewNavFragment$refreshPreview$1$1.L$0 = obj;
        return platformLibraryListViewNavFragment$refreshPreview$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PlatformLibraryListViewNavFragment$refreshPreview$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x009b, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment$refreshPreview$1$1.AnonymousClass1(r10.$previewMode, r6, r10.this$0, r10.$it, null), r10) == r1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00cb, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment$refreshPreview$1$1.AnonymousClass2(r10.this$0, null), r10) == r1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00cd, code lost:
    
        return r1;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            Method dump skipped, instruction units count: 209
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment$refreshPreview$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment$refreshPreview$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: PlatformLibraryListViewNavFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment$refreshPreview$1$1$1", f = "PlatformLibraryListViewNavFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PlayableItemEntity $it;
        final /* synthetic */ PlayableItemPreviewMediaIndex $playableItemPreviewMediasIndex;
        final /* synthetic */ int $previewMode;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ PlatformLibraryListViewNavFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i, PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex, PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment, PlayableItemEntity playableItemEntity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$previewMode = i;
            this.$playableItemPreviewMediasIndex = playableItemPreviewMediaIndex;
            this.this$0 = platformLibraryListViewNavFragment;
            this.$it = playableItemEntity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$previewMode, this.$playableItemPreviewMediasIndex, this.this$0, this.$it, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            int i = this.$previewMode;
            ImageView imageView = null;
            if (i == 0) {
                if (this.$playableItemPreviewMediasIndex.getBoxArtPath() == null) {
                    this.this$0.setThumbnail(null);
                } else {
                    CachedBitmapLoader.CachedBitmapLoaderTask cachedBitmapLoaderTaskWith = this.this$0.getDaijishouLibrary().getCachedBoxArtBitmapLoader().with(this.this$0);
                    final PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment = this.this$0;
                    CachedBitmapLoader.CachedBitmapLoaderTask onSucceedListener = cachedBitmapLoaderTaskWith.setOnSucceedListener(new Function2<Bitmap, Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment.refreshPreview.1.1.1.1
                        

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap, Boolean bool) {
                            invoke(bitmap, bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Bitmap bitmap, boolean z) {
                            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                            platformLibraryListViewNavFragment.setThumbnail(bitmap);
                        }
                    });
                    final PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment2 = this.this$0;
                    CachedBitmapLoader.CachedBitmapLoaderTask cachedBitmapLoaderTaskLoad$default = CachedBitmapLoader.CachedBitmapLoaderTask.load$default(onSucceedListener.setOnFailedListener(new Function1<Exception, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment.refreshPreview.1.1.1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                            invoke2(exc);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Exception e) {
                            Intrinsics.checkNotNullParameter(e, "e");
                            platformLibraryListViewNavFragment2.getLogger().warn(coroutineScope, ExceptionsKt.stackTraceToString(e));
                            if (e instanceof CachedBitmapLoader.NewerBitmapLoadingException) {
                                return;
                            }
                            platformLibraryListViewNavFragment2.setThumbnail(null);
                        }
                    }), this.$it.getPreviewMediaPath() + this.$playableItemPreviewMediasIndex.getBoxArtPath(), false, 2, null);
                    ImageView imageView2 = this.this$0.thumbnailImageView;
                    if (imageView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("thumbnailImageView");
                        imageView2 = null;
                    }
                    cachedBitmapLoaderTaskLoad$default.into(imageView2);
                }
                if (this.$playableItemPreviewMediasIndex.getSnapshotPath() == null) {
                    this.this$0.setBackground(null);
                } else {
                    CachedBitmapLoader.CachedBitmapLoaderTask cachedBitmapLoaderTaskWith2 = this.this$0.getDaijishouLibrary().getCachedSnapshotBitmapLoader().with(this.this$0);
                    final PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment3 = this.this$0;
                    CachedBitmapLoader.CachedBitmapLoaderTask onSucceedListener2 = cachedBitmapLoaderTaskWith2.setOnSucceedListener(new Function2<Bitmap, Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment.refreshPreview.1.1.1.3
                        

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap, Boolean bool) {
                            invoke(bitmap, bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Bitmap bitmap, boolean z) {
                            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                            platformLibraryListViewNavFragment3.setBackground(bitmap);
                        }
                    });
                    final PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment4 = this.this$0;
                    CachedBitmapLoader.CachedBitmapLoaderTask cachedBitmapLoaderTaskLoad$default2 = CachedBitmapLoader.CachedBitmapLoaderTask.load$default(onSucceedListener2.setOnFailedListener(new Function1<Exception, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment.refreshPreview.1.1.1.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                            invoke2(exc);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Exception e) {
                            Intrinsics.checkNotNullParameter(e, "e");
                            platformLibraryListViewNavFragment4.getLogger().warn(coroutineScope, ExceptionsKt.stackTraceToString(e));
                            if (e instanceof CachedBitmapLoader.NewerBitmapLoadingException) {
                                return;
                            }
                            platformLibraryListViewNavFragment4.setBackground(null);
                        }
                    }), this.$it.getPreviewMediaPath() + this.$playableItemPreviewMediasIndex.getSnapshotPath(), false, 2, null);
                    ImageView imageView3 = this.this$0.backgroundImageView;
                    if (imageView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("backgroundImageView");
                    } else {
                        imageView = imageView3;
                    }
                    cachedBitmapLoaderTaskLoad$default2.into(imageView);
                }
            } else if (i == 1) {
                if (this.$playableItemPreviewMediasIndex.getSnapshotPath() == null) {
                    this.this$0.setThumbnail(null);
                } else {
                    CachedBitmapLoader.CachedBitmapLoaderTask cachedBitmapLoaderTaskWith3 = this.this$0.getDaijishouLibrary().getCachedSnapshotBitmapLoader().with(this.this$0);
                    final PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment5 = this.this$0;
                    CachedBitmapLoader.CachedBitmapLoaderTask onSucceedListener3 = cachedBitmapLoaderTaskWith3.setOnSucceedListener(new Function2<Bitmap, Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment.refreshPreview.1.1.1.5
                        

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap, Boolean bool) {
                            invoke(bitmap, bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Bitmap bitmap, boolean z) {
                            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                            platformLibraryListViewNavFragment5.setThumbnail(bitmap);
                        }
                    });
                    final PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment6 = this.this$0;
                    CachedBitmapLoader.CachedBitmapLoaderTask cachedBitmapLoaderTaskLoad$default3 = CachedBitmapLoader.CachedBitmapLoaderTask.load$default(onSucceedListener3.setOnFailedListener(new Function1<Exception, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment.refreshPreview.1.1.1.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                            invoke2(exc);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Exception e) {
                            Intrinsics.checkNotNullParameter(e, "e");
                            platformLibraryListViewNavFragment6.getLogger().warn(coroutineScope, ExceptionsKt.stackTraceToString(e));
                            if (e instanceof CachedBitmapLoader.NewerBitmapLoadingException) {
                                return;
                            }
                            platformLibraryListViewNavFragment6.setThumbnail(null);
                        }
                    }), this.$it.getPreviewMediaPath() + this.$playableItemPreviewMediasIndex.getSnapshotPath(), false, 2, null);
                    ImageView imageView4 = this.this$0.thumbnailImageView;
                    if (imageView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("thumbnailImageView");
                        imageView4 = null;
                    }
                    cachedBitmapLoaderTaskLoad$default3.into(imageView4);
                }
                if (this.$playableItemPreviewMediasIndex.getBoxArtPath() == null) {
                    this.this$0.setBackground(null);
                } else {
                    CachedBitmapLoader.CachedBitmapLoaderTask cachedBitmapLoaderTaskWith4 = this.this$0.getDaijishouLibrary().getCachedBoxArtBitmapLoader().with(this.this$0);
                    final PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment7 = this.this$0;
                    CachedBitmapLoader.CachedBitmapLoaderTask onSucceedListener4 = cachedBitmapLoaderTaskWith4.setOnSucceedListener(new Function2<Bitmap, Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment.refreshPreview.1.1.1.7
                        

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap, Boolean bool) {
                            invoke(bitmap, bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Bitmap bitmap, boolean z) {
                            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                            platformLibraryListViewNavFragment7.setBackground(bitmap);
                        }
                    });
                    final PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment8 = this.this$0;
                    CachedBitmapLoader.CachedBitmapLoaderTask cachedBitmapLoaderTaskLoad$default4 = CachedBitmapLoader.CachedBitmapLoaderTask.load$default(onSucceedListener4.setOnFailedListener(new Function1<Exception, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment.refreshPreview.1.1.1.8
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                            invoke2(exc);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Exception e) {
                            Intrinsics.checkNotNullParameter(e, "e");
                            platformLibraryListViewNavFragment8.getLogger().warn(coroutineScope, ExceptionsKt.stackTraceToString(e));
                            if (e instanceof CachedBitmapLoader.NewerBitmapLoadingException) {
                                return;
                            }
                            platformLibraryListViewNavFragment8.setBackground(null);
                        }
                    }), this.$it.getPreviewMediaPath() + this.$playableItemPreviewMediasIndex.getBoxArtPath(), false, 2, null);
                    ImageView imageView5 = this.this$0.backgroundImageView;
                    if (imageView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("backgroundImageView");
                    } else {
                        imageView = imageView5;
                    }
                    cachedBitmapLoaderTaskLoad$default4.into(imageView);
                }
            } else if (i == 2) {
                if (this.$playableItemPreviewMediasIndex.getTitlePath() == null) {
                    this.this$0.setThumbnail(null);
                } else {
                    CachedBitmapLoader.CachedBitmapLoaderTask cachedBitmapLoaderTaskWith5 = this.this$0.getDaijishouLibrary().getCachedTitleBitmapLoader().with(this.this$0);
                    final PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment9 = this.this$0;
                    CachedBitmapLoader.CachedBitmapLoaderTask onSucceedListener5 = cachedBitmapLoaderTaskWith5.setOnSucceedListener(new Function2<Bitmap, Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment.refreshPreview.1.1.1.9
                        

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap, Boolean bool) {
                            invoke(bitmap, bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Bitmap bitmap, boolean z) {
                            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                            platformLibraryListViewNavFragment9.setThumbnail(bitmap);
                        }
                    });
                    final PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment10 = this.this$0;
                    CachedBitmapLoader.CachedBitmapLoaderTask cachedBitmapLoaderTaskLoad$default5 = CachedBitmapLoader.CachedBitmapLoaderTask.load$default(onSucceedListener5.setOnFailedListener(new Function1<Exception, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment.refreshPreview.1.1.1.10
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                            invoke2(exc);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Exception e) {
                            Intrinsics.checkNotNullParameter(e, "e");
                            platformLibraryListViewNavFragment10.getLogger().warn(coroutineScope, ExceptionsKt.stackTraceToString(e));
                            if (e instanceof CachedBitmapLoader.NewerBitmapLoadingException) {
                                return;
                            }
                            platformLibraryListViewNavFragment10.setThumbnail(null);
                        }
                    }), this.$it.getPreviewMediaPath() + this.$playableItemPreviewMediasIndex.getTitlePath(), false, 2, null);
                    ImageView imageView6 = this.this$0.thumbnailImageView;
                    if (imageView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("thumbnailImageView");
                        imageView6 = null;
                    }
                    cachedBitmapLoaderTaskLoad$default5.into(imageView6);
                }
                if (this.$playableItemPreviewMediasIndex.getSnapshotPath() == null) {
                    this.this$0.setBackground(null);
                } else {
                    CachedBitmapLoader.CachedBitmapLoaderTask cachedBitmapLoaderTaskWith6 = this.this$0.getDaijishouLibrary().getCachedSnapshotBitmapLoader().with(this.this$0);
                    final PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment11 = this.this$0;
                    CachedBitmapLoader.CachedBitmapLoaderTask onSucceedListener6 = cachedBitmapLoaderTaskWith6.setOnSucceedListener(new Function2<Bitmap, Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment.refreshPreview.1.1.1.11
                        

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap, Boolean bool) {
                            invoke(bitmap, bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Bitmap bitmap, boolean z) {
                            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                            platformLibraryListViewNavFragment11.setBackground(bitmap);
                        }
                    });
                    final PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment12 = this.this$0;
                    CachedBitmapLoader.CachedBitmapLoaderTask cachedBitmapLoaderTaskLoad$default6 = CachedBitmapLoader.CachedBitmapLoaderTask.load$default(onSucceedListener6.setOnFailedListener(new Function1<Exception, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment.refreshPreview.1.1.1.12
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                            invoke2(exc);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Exception e) {
                            Intrinsics.checkNotNullParameter(e, "e");
                            platformLibraryListViewNavFragment12.getLogger().warn(coroutineScope, ExceptionsKt.stackTraceToString(e));
                            if (e instanceof CachedBitmapLoader.NewerBitmapLoadingException) {
                                return;
                            }
                            platformLibraryListViewNavFragment12.setBackground(null);
                        }
                    }), this.$it.getPreviewMediaPath() + this.$playableItemPreviewMediasIndex.getSnapshotPath(), false, 2, null);
                    ImageView imageView7 = this.this$0.backgroundImageView;
                    if (imageView7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("backgroundImageView");
                    } else {
                        imageView = imageView7;
                    }
                    cachedBitmapLoaderTaskLoad$default6.into(imageView);
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment$refreshPreview$1$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: PlatformLibraryListViewNavFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment$refreshPreview$1$1$2", f = "PlatformLibraryListViewNavFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PlatformLibraryListViewNavFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = platformLibraryListViewNavFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
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
