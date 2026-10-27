package com.magneticchen.daijishou.ui.fragments.nav;

import com.google.android.material.chip.Chip;
import com.magneticchen.daijishou.ui.model.DaijishouLibraryModel;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: PlatformLibraryGridViewNavFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryGridViewNavFragment$onCreateView$refreshCountingButtons$1", f = "PlatformLibraryGridViewNavFragment.kt", i = {}, l = {514}, m = "invokeSuspend", n = {}, s = {})
final class PlatformLibraryGridViewNavFragment$onCreateView$refreshCountingButtons$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PlatformLibraryGridViewNavFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PlatformLibraryGridViewNavFragment$onCreateView$refreshCountingButtons$1(PlatformLibraryGridViewNavFragment platformLibraryGridViewNavFragment, Continuation<? super PlatformLibraryGridViewNavFragment$onCreateView$refreshCountingButtons$1> continuation) {
        super(2, continuation);
        this.this$0 = platformLibraryGridViewNavFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlatformLibraryGridViewNavFragment$onCreateView$refreshCountingButtons$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PlatformLibraryGridViewNavFragment$onCreateView$refreshCountingButtons$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            long jCountPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically$default = this.this$0.getMergePlayableItemsPreference() ? DaijishouLibraryModel.countPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically$default(this.this$0.getDaijishouLibrary(), this.this$0.platformId, false, 2, null) : DaijishouLibraryModel.countPlayableItemsByAttachedPlatformIdAndVisibilityStatically$default(this.this$0.getDaijishouLibrary(), this.this$0.platformId, false, 2, null);
            long jCountRecentPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically$default = this.this$0.getMergePlayableItemsPreference() ? DaijishouLibraryModel.countRecentPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically$default(this.this$0.getDaijishouLibrary(), this.this$0.platformId, false, 2, null) : DaijishouLibraryModel.countRecentPlayableItemsByAttachedPlatformIdAndVisibilityStatically$default(this.this$0.getDaijishouLibrary(), this.this$0.platformId, false, 2, null);
            long jCountFavoritePlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically$default = this.this$0.getMergePlayableItemsPreference() ? DaijishouLibraryModel.countFavoritePlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically$default(this.this$0.getDaijishouLibrary(), this.this$0.platformId, false, 2, null) : DaijishouLibraryModel.countFavoritePlayableItemsByAttachedPlatformIdAndVisibilityStatically$default(this.this$0.getDaijishouLibrary(), this.this$0.platformId, false, 2, null);
            long jCountNewlyPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically$default = this.this$0.getMergePlayableItemsPreference() ? DaijishouLibraryModel.countNewlyPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically$default(this.this$0.getDaijishouLibrary(), this.this$0.platformId, false, 2, null) : DaijishouLibraryModel.countNewlyPlayableItemsByAttachedPlatformIdAndVisibilityStatically$default(this.this$0.getDaijishouLibrary(), this.this$0.platformId, false, 2, null);
            CoroutineContext main = Dispatchers.getMain();
            PlatformLibraryGridViewNavFragment platformLibraryGridViewNavFragment = this.this$0;
            this.label = 1;
            if (BuildersKt.withContext(main, new AnonymousClass1(platformLibraryGridViewNavFragment, jCountPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically$default, jCountRecentPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically$default, jCountFavoritePlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically$default, jCountNewlyPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically$default, null), this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryGridViewNavFragment$onCreateView$refreshCountingButtons$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: PlatformLibraryGridViewNavFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryGridViewNavFragment$onCreateView$refreshCountingButtons$1$1", f = "PlatformLibraryGridViewNavFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $favoriteCount;
        final /* synthetic */ long $itemsCount;
        final /* synthetic */ long $newlyCount;
        final /* synthetic */ long $recentCount;
        int label;
        final /* synthetic */ PlatformLibraryGridViewNavFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PlatformLibraryGridViewNavFragment platformLibraryGridViewNavFragment, long j, long j2, long j3, long j4, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = platformLibraryGridViewNavFragment;
            this.$itemsCount = j;
            this.$recentCount = j2;
            this.$favoriteCount = j3;
            this.$newlyCount = j4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$itemsCount, this.$recentCount, this.$favoriteCount, this.$newlyCount, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Chip chip = this.this$0.itemCountButton;
                Chip chip2 = null;
                if (chip == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("itemCountButton");
                    chip = null;
                }
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = this.this$0.itemCountFormatString;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("itemCountFormatString");
                    str = null;
                }
                String str2 = String.format(str, Arrays.copyOf(new Object[]{Boxing.boxLong(this.$itemsCount)}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                chip.setText(str2);
                Chip chip3 = this.this$0.recentPlayedButton;
                if (chip3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recentPlayedButton");
                    chip3 = null;
                }
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String str3 = this.this$0.recentFormatString;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recentFormatString");
                    str3 = null;
                }
                String str4 = String.format(str3, Arrays.copyOf(new Object[]{Boxing.boxLong(this.$recentCount)}, 1));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                chip3.setText(str4);
                Chip chip4 = this.this$0.favoriteButton;
                if (chip4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
                    chip4 = null;
                }
                StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                String str5 = this.this$0.favoriteFormatString;
                if (str5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("favoriteFormatString");
                    str5 = null;
                }
                String str6 = String.format(str5, Arrays.copyOf(new Object[]{Boxing.boxLong(this.$favoriteCount)}, 1));
                Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                chip4.setText(str6);
                Chip chip5 = this.this$0.newlyAddedButton;
                if (chip5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("newlyAddedButton");
                    chip5 = null;
                }
                StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
                String str7 = this.this$0.newFormatString;
                if (str7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("newFormatString");
                    str7 = null;
                }
                String str8 = String.format(str7, Arrays.copyOf(new Object[]{Boxing.boxLong(this.$newlyCount)}, 1));
                Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
                chip5.setText(str8);
                Chip chip6 = this.this$0.recentPlayedButton;
                if (chip6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recentPlayedButton");
                    chip6 = null;
                }
                chip6.setVisibility(this.$recentCount > 0 ? 0 : 8);
                Chip chip7 = this.this$0.favoriteButton;
                if (chip7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
                    chip7 = null;
                }
                chip7.setVisibility(this.$favoriteCount > 0 ? 0 : 8);
                Chip chip8 = this.this$0.newlyAddedButton;
                if (chip8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("newlyAddedButton");
                } else {
                    chip2 = chip8;
                }
                chip2.setVisibility(this.$newlyCount <= 0 ? 8 : 0);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
