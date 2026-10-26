package com.magneticchen.daijishou.nav_fragments;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.application_data.BooleanPreference;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import com.magneticchen.daijishou.utils.Utils;
import com.magneticchen.daijishou.view_models.DaijishouLibraryModel;
import com.magneticchen.daijishou.view_models.DaijishouViewModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import com.magneticchen.daijishou.application_data.Constants;

/* INFO: compiled from: PlatformLibraryGridViewNavFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.nav_fragments.PlatformLibraryGridViewNavFragment$onCreateView$refreshPlayableItems$1", f = "PlatformLibraryGridViewNavFragment.kt", i = {0, 1, 2}, l = {581, 594, TypedValues.MotionType.TYPE_ANIMATE_CIRCLEANGLE_TO, 632}, m = "invokeSuspendImpl", n = {"playableItemsToBeAdded", "playableItemsToBeAdded", "playableItemsToBeAdded"}, s = {"L$0", "L$0", "L$0"})
final class PlatformLibraryGridViewNavFragment$onCreateView$refreshPlayableItems$1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    final /* synthetic */ SharedPreferences $platformLibrarySharedPreferences;
    final /* synthetic */ List<PlayableItemEntity> $playableItems;
    Object L$0;
    int label;
    final /* synthetic */ PlatformLibraryGridViewNavFragment this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    PlatformLibraryGridViewNavFragment$onCreateView$refreshPlayableItems$1(PlatformLibraryGridViewNavFragment platformLibraryGridViewNavFragment, List<PlayableItemEntity> list, SharedPreferences sharedPreferences, Continuation<?> continuation) {
        super(2, continuation);
        this.this$0 = platformLibraryGridViewNavFragment;
        this.$playableItems = list;
        this.$platformLibrarySharedPreferences = sharedPreferences;
    }


    public final Continuation create(Object obj, Continuation<?> continuation) {
        return new PlatformLibraryGridViewNavFragment$onCreateView$refreshPlayableItems$1(this.this$0, this.$playableItems, this.$platformLibrarySharedPreferences, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((PlatformLibraryGridViewNavFragment$onCreateView$refreshPlayableItems$1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }

    public final Object invokeSuspendImpl(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        List<PlayableItemEntity> playableItemsToBeAdded;
        if (i != 0) {
            if (i == 1 || i == 2 || i == 3) {
                playableItemsToBeAdded = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else if (i == 4) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            playableItemsToBeAdded = new ArrayList<>();
            PlatformLibraryGridViewNavFragment.onCreateView$refreshCountingButtons(this.this$0);
            int filterMode = this.this$0.filterMode;
            if (filterMode == 0) {
                List<PlayableItemEntity> items;
                if (this.this$0.getMergePlayableItemsPreference()) {
                    PlayableItemEntity[] array = (PlayableItemEntity[]) this.$playableItems.toArray(new PlayableItemEntity[0]);
                    items = this.this$0.getDaijishouLibrary().getMergedPlayableItems((PlayableItemEntity[]) Arrays.copyOf(array, array.length));
                } else {
                    items = this.$playableItems;
                }
                playableItemsToBeAdded.addAll(items);
            } else if (filterMode == 1) {
                List<PlayableItemEntity> items2;
                if (this.this$0.getMergePlayableItemsPreference()) {
                    PlayableItemEntity[] array2 = (PlayableItemEntity[]) this.$playableItems.toArray(new PlayableItemEntity[0]);
                    items2 = this.this$0.getDaijishouLibrary().getMergedPlayableItems((PlayableItemEntity[]) Arrays.copyOf(array2, array2.length));
                } else {
                    items2 = this.$playableItems;
                }
                ArrayList arrayList = new ArrayList();
                for (PlayableItemEntity playableItemEntity : items2) {
                    if (playableItemEntity.isFavorite()) {
                        arrayList.add(playableItemEntity);
                    }
                }
                playableItemsToBeAdded.addAll(arrayList);
                this.L$0 = playableItemsToBeAdded;
                this.label = 1;
                if (BuildersKt.withContext((CoroutineContext) Dispatchers.getMain(), new AnonymousClass2(this.this$0, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (filterMode == 2) {
                List<PlayableItemEntity> items3;
                if (this.this$0.getMergePlayableItemsPreference()) {
                    PlayableItemEntity[] array3 = (PlayableItemEntity[]) this.$playableItems.toArray(new PlayableItemEntity[0]);
                    items3 = this.this$0.getDaijishouLibrary().getMergedPlayableItems((PlayableItemEntity[]) Arrays.copyOf(array3, array3.length));
                } else {
                    items3 = this.$playableItems;
                }
                Date cutoff = new Date(System.currentTimeMillis() - com.magneticchen.daijishou.support.DaijishouValueSupport.durationInWholeMilliseconds(Constants.INSTANCE.m3492getRecentDurationDefinitionUwyO8pc()));
                ArrayList arrayList2 = new ArrayList();
                for (PlayableItemEntity playableItemEntity2 : items3) {
                    Date lastPlayedTimestamp = playableItemEntity2.getLastPlayedTimestamp();
                    if (lastPlayedTimestamp != null && lastPlayedTimestamp.compareTo(cutoff) > 0) {
                        arrayList2.add(playableItemEntity2);
                    }
                }
                playableItemsToBeAdded.addAll(arrayList2);
                this.L$0 = playableItemsToBeAdded;
                this.label = 2;
                if (BuildersKt.withContext((CoroutineContext) Dispatchers.getMain(), new AnonymousClass4(this.this$0, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (filterMode == 3) {
                List<PlayableItemEntity> items4;
                if (this.this$0.getMergePlayableItemsPreference()) {
                    PlayableItemEntity[] array4 = (PlayableItemEntity[]) this.$playableItems.toArray(new PlayableItemEntity[0]);
                    items4 = this.this$0.getDaijishouLibrary().getMergedPlayableItems((PlayableItemEntity[]) Arrays.copyOf(array4, array4.length));
                } else {
                    items4 = this.$playableItems;
                }
                Date cutoff2 = new Date(System.currentTimeMillis() - com.magneticchen.daijishou.support.DaijishouValueSupport.durationInWholeMilliseconds(Constants.INSTANCE.m3491getNewlyDurationDefinitionUwyO8pc()));
                ArrayList arrayList3 = new ArrayList();
                for (PlayableItemEntity playableItemEntity3 : items4) {
                    Date addedDateTimestamp = playableItemEntity3.getAddedDateTimestamp();
                    if (addedDateTimestamp != null && addedDateTimestamp.compareTo(cutoff2) > 0) {
                        arrayList3.add(playableItemEntity3);
                    }
                }
                playableItemsToBeAdded.addAll(arrayList3);
                this.L$0 = playableItemsToBeAdded;
                this.label = 3;
                if (BuildersKt.withContext((CoroutineContext) Dispatchers.getMain(), new AnonymousClass6(this.this$0, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (filterMode == 4) {
                String currentGenreId = this.this$0.getCurrentGenreId();
                if (currentGenreId != null) {
                    List<PlayableItemEntity> items5 = this.$playableItems;
                    if (this.this$0.getMergePlayableItemsPreference()) {
                        PlayableItemEntity[] array5 = (PlayableItemEntity[]) items5.toArray(new PlayableItemEntity[0]);
                        items5 = this.this$0.getDaijishouLibrary().getMergedPlayableItems((PlayableItemEntity[]) Arrays.copyOf(array5, array5.length));
                    }
                    playableItemsToBeAdded.addAll(items5);
                }
            }
        }
        this.L$0 = null;
        this.label = 4;
        if (BuildersKt.withContext((CoroutineContext) Dispatchers.getMain(), new AnonymousClass8(this.this$0, playableItemsToBeAdded, this.$platformLibrarySharedPreferences, null), this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: com.magneticchen.daijishou.nav_fragments.PlatformLibraryGridViewNavFragment$onCreateView$refreshPlayableItems$1$2, reason: invalid class name */
    /* INFO: compiled from: PlatformLibraryGridViewNavFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.nav_fragments.PlatformLibraryGridViewNavFragment$onCreateView$refreshPlayableItems$1$2", f = "PlatformLibraryGridViewNavFragment.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
    static final class AnonymousClass2 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        int label;
        final /* synthetic */ PlatformLibraryGridViewNavFragment this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(PlatformLibraryGridViewNavFragment platformLibraryGridViewNavFragment, Continuation<?> continuation) {
            super(2, continuation);
            this.this$0 = platformLibraryGridViewNavFragment;
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
                RecyclerView recyclerView = this.this$0.platformLibraryGridRecyclerView;
                Chip chip = null;
                if (recyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerView");
                    recyclerView = null;
                }
                Chip chip2 = this.this$0.favoriteButton;
                if (chip2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
                    chip2 = null;
                }
                recyclerView.setNextFocusUpId(chip2.getId());
                DaijishouViewModel model = this.this$0.getModel();
                String string = this.this$0.getString(R.string.favorite);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                DaijishouViewModel.setTips$default(model, string, false, 2, null);
                HorizontalScrollView horizontalScrollView = this.this$0.horizontalScrollView;
                if (horizontalScrollView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("horizontalScrollView");
                    horizontalScrollView = null;
                }
                Chip chip3 = this.this$0.favoriteButton;
                if (chip3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
                    chip3 = null;
                }
                horizontalScrollView.smoothScrollTo(Math.max(0, chip3.getLeft() - this.this$0.getDpToPxConverter().convert(32.0f)), 0);
                PlatformLibraryGridViewNavFragment platformLibraryGridViewNavFragment = this.this$0;
                Chip chip4 = platformLibraryGridViewNavFragment.favoriteButton;
                if (chip4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
                } else {
                    chip = chip4;
                }
                platformLibraryGridViewNavFragment.selectedChip = chip;
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.nav_fragments.PlatformLibraryGridViewNavFragment$onCreateView$refreshPlayableItems$1$4, reason: invalid class name */
    /* INFO: compiled from: PlatformLibraryGridViewNavFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.nav_fragments.PlatformLibraryGridViewNavFragment$onCreateView$refreshPlayableItems$1$4", f = "PlatformLibraryGridViewNavFragment.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
    static final class AnonymousClass4 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        int label;
        final /* synthetic */ PlatformLibraryGridViewNavFragment this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(PlatformLibraryGridViewNavFragment platformLibraryGridViewNavFragment, Continuation<?> continuation) {
            super(2, continuation);
            this.this$0 = platformLibraryGridViewNavFragment;
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass4(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                try {
                    return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
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
                RecyclerView recyclerView = this.this$0.platformLibraryGridRecyclerView;
                Chip chip = null;
                if (recyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerView");
                    recyclerView = null;
                }
                Chip chip2 = this.this$0.recentPlayedButton;
                if (chip2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recentPlayedButton");
                    chip2 = null;
                }
                recyclerView.setNextFocusUpId(chip2.getId());
                DaijishouViewModel model = this.this$0.getModel();
                String string = this.this$0.getString(R.string.recent);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                DaijishouViewModel.setTips$default(model, string, false, 2, null);
                HorizontalScrollView horizontalScrollView = this.this$0.horizontalScrollView;
                if (horizontalScrollView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("horizontalScrollView");
                    horizontalScrollView = null;
                }
                Chip chip3 = this.this$0.recentPlayedButton;
                if (chip3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recentPlayedButton");
                    chip3 = null;
                }
                horizontalScrollView.smoothScrollTo(Math.max(0, chip3.getLeft() - this.this$0.getDpToPxConverter().convert(32.0f)), 0);
                PlatformLibraryGridViewNavFragment platformLibraryGridViewNavFragment = this.this$0;
                Chip chip4 = platformLibraryGridViewNavFragment.recentPlayedButton;
                if (chip4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recentPlayedButton");
                } else {
                    chip = chip4;
                }
                platformLibraryGridViewNavFragment.selectedChip = chip;
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.nav_fragments.PlatformLibraryGridViewNavFragment$onCreateView$refreshPlayableItems$1$6, reason: invalid class name */
    /* INFO: compiled from: PlatformLibraryGridViewNavFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.nav_fragments.PlatformLibraryGridViewNavFragment$onCreateView$refreshPlayableItems$1$6", f = "PlatformLibraryGridViewNavFragment.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
    static final class AnonymousClass6 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        int label;
        final /* synthetic */ PlatformLibraryGridViewNavFragment this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(PlatformLibraryGridViewNavFragment platformLibraryGridViewNavFragment, Continuation<?> continuation) {
            super(2, continuation);
            this.this$0 = platformLibraryGridViewNavFragment;
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass6(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                try {
                    return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
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
                RecyclerView recyclerView = this.this$0.platformLibraryGridRecyclerView;
                Chip chip = null;
                if (recyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerView");
                    recyclerView = null;
                }
                Chip chip2 = this.this$0.newlyAddedButton;
                if (chip2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("newlyAddedButton");
                    chip2 = null;
                }
                recyclerView.setNextFocusUpId(chip2.getId());
                DaijishouViewModel model = this.this$0.getModel();
                String string = this.this$0.getString(R.string.newly);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                DaijishouViewModel.setTips$default(model, string, false, 2, null);
                HorizontalScrollView horizontalScrollView = this.this$0.horizontalScrollView;
                if (horizontalScrollView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("horizontalScrollView");
                    horizontalScrollView = null;
                }
                Chip chip3 = this.this$0.newlyAddedButton;
                if (chip3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("newlyAddedButton");
                    chip3 = null;
                }
                horizontalScrollView.smoothScrollTo(Math.max(0, chip3.getLeft() - this.this$0.getDpToPxConverter().convert(32.0f)), 0);
                PlatformLibraryGridViewNavFragment platformLibraryGridViewNavFragment = this.this$0;
                Chip chip4 = platformLibraryGridViewNavFragment.newlyAddedButton;
                if (chip4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("newlyAddedButton");
                } else {
                    chip = chip4;
                }
                platformLibraryGridViewNavFragment.selectedChip = chip;
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.nav_fragments.PlatformLibraryGridViewNavFragment$onCreateView$refreshPlayableItems$1$8, reason: invalid class name */
    /* INFO: compiled from: PlatformLibraryGridViewNavFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.nav_fragments.PlatformLibraryGridViewNavFragment$onCreateView$refreshPlayableItems$1$8", f = "PlatformLibraryGridViewNavFragment.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
    static final class AnonymousClass8 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        final /* synthetic */ SharedPreferences $platformLibrarySharedPreferences;
        final /* synthetic */ List<PlayableItemEntity> $playableItemsToBeAdded;
        int label;
        final /* synthetic */ PlatformLibraryGridViewNavFragment this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass8(PlatformLibraryGridViewNavFragment platformLibraryGridViewNavFragment, List<PlayableItemEntity> list, SharedPreferences sharedPreferences, Continuation<?> continuation) {
            super(2, continuation);
            this.this$0 = platformLibraryGridViewNavFragment;
            this.$playableItemsToBeAdded = list;
            this.$platformLibrarySharedPreferences = sharedPreferences;
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass8(this.this$0, this.$playableItemsToBeAdded, this.$platformLibrarySharedPreferences, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                try {
                    return ((AnonymousClass8) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                }
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
        }

        /* WARN: Multi-variable type inference failed */
        /* WARN: Type inference failed for: r8v10, types: [T, com.google.android.material.chip.Chip] */
        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.lastVisibleChipIndex = -1;
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                ChipGroup chipGroup = this.this$0.chipGroup;
                LinearLayout linearLayout = null;
                if (chipGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                    chipGroup = null;
                }
                ChipGroup chipGroup2 = chipGroup;
                PlatformLibraryGridViewNavFragment platformLibraryGridViewNavFragment = this.this$0;
                int childCount = chipGroup2.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = chipGroup2.getChildAt(i);
                    Chip chip = (Chip) objectRef.element;
                    if (chip != null) {
                        chip.setNextFocusRightId(childAt.getId());
                        childAt.setNextFocusLeftId(chip.getId());
                    }
                    childAt.setNextFocusRightId(-1);
                    if (childAt.getVisibility() == 0) {
                        platformLibraryGridViewNavFragment.lastVisibleChipIndex = i;
                    }
                    Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type com.google.android.material.chip.Chip");
                    objectRef.element = (Chip) childAt;
                }
                boolean z = this.this$0.getDefaultSharedPreferences().getBoolean(BooleanPreference.SHOW_GENRES_IN_PLATFORM_GRID_VIEW.getKey(), BooleanPreference.SHOW_GENRES_IN_PLATFORM_GRID_VIEW.getDefaultValue());
                if ((this.this$0.genreIds.isEmpty() || !z) && this.this$0.lastVisibleChipIndex >= 0) {
                    ChipGroup chipGroup3 = this.this$0.chipGroup;
                    if (chipGroup3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                        chipGroup3 = null;
                    }
                    View childAt2 = chipGroup3.getChildAt(this.this$0.lastVisibleChipIndex);
                    Chip chip2 = this.this$0.listViewButton;
                    if (chip2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("listViewButton");
                        chip2 = null;
                    }
                    childAt2.setNextFocusRightId(chip2.getId());
                }
                if (DaijishouLibraryModel.getGenreIdsByPlatformIdAndVisibilityStatically$default(this.this$0.getDaijishouLibrary(), this.this$0.platformId, false, 2, null).isEmpty()) {
                    ChipGroup chipGroup4 = this.this$0.chipGroup;
                    if (chipGroup4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                        chipGroup4 = null;
                    }
                    View childAt3 = chipGroup4.getChildAt(this.this$0.lastVisibleChipIndex);
                    Chip chip3 = this.this$0.listViewButton;
                    if (chip3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("listViewButton");
                        chip3 = null;
                    }
                    childAt3.setNextFocusRightId(chip3.getId());
                }
                PlatformLibraryGridViewNavFragment.PlatformLibraryGridAdapter platformLibraryGridAdapter = this.this$0.platformLibraryGridRecyclerViewAdapter;
                if (platformLibraryGridAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerViewAdapter");
                    platformLibraryGridAdapter = null;
                }
                platformLibraryGridAdapter.setDimensionRatio(this.this$0.boxArtAspectRatio);
                if (this.$playableItemsToBeAdded.size() != this.this$0.playableItemEntityList.size()) {
                    PlatformLibraryGridViewNavFragment.onCreateView$updateEntireList(this.this$0, this.$platformLibrarySharedPreferences, this.$playableItemsToBeAdded);
                } else {
                    for (PlayableItemEntity playableItemEntity : this.$playableItemsToBeAdded) {
                        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                        booleanRef.element = true;
                        List list = this.this$0.playableItemEntityList;
                        PlatformLibraryGridViewNavFragment platformLibraryGridViewNavFragment2 = this.this$0;
                        int i2 = 0;
                        for (Object obj2 : list) {
                            int i3 = i2 + 1;
                            if (i2 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            PlayableItemEntity playableItemEntity2 = (PlayableItemEntity) obj2;
                            if (playableItemEntity.getId() == playableItemEntity2.getId()) {
                                booleanRef.element = false;
                                if (!Intrinsics.areEqual(playableItemEntity, playableItemEntity2)) {
                                    String boxArtPath = Utils.INSTANCE.getBoxArtPath(playableItemEntity2);
                                    if (boxArtPath != null) {
                                        PlatformLibraryGridViewNavFragment.PlatformLibraryGridAdapter platformLibraryGridAdapter2 = platformLibraryGridViewNavFragment2.platformLibraryGridRecyclerViewAdapter;
                                        if (platformLibraryGridAdapter2 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerViewAdapter");
                                            platformLibraryGridAdapter2 = null;
                                        }
                                        platformLibraryGridAdapter2.getCachedBitmapLoader().remove(boxArtPath);
                                    }
                                    platformLibraryGridViewNavFragment2.playableItemEntityList.set(i2, playableItemEntity);
                                    PlatformLibraryGridViewNavFragment.PlatformLibraryGridAdapter platformLibraryGridAdapter3 = platformLibraryGridViewNavFragment2.platformLibraryGridRecyclerViewAdapter;
                                    if (platformLibraryGridAdapter3 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerViewAdapter");
                                        platformLibraryGridAdapter3 = null;
                                    }
                                    platformLibraryGridAdapter3.notifyItemChanged(i2);
                                }
                            }
                            i2 = i3;
                        }
                        if (booleanRef.element) {
                            PlatformLibraryGridViewNavFragment.onCreateView$updateEntireList(this.this$0, this.$platformLibrarySharedPreferences, this.$playableItemsToBeAdded);
                            break;
                        }
                    }
                }
                LinearLayout linearLayout2 = this.this$0.emptyLayout;
                if (linearLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("emptyLayout");
                } else {
                    linearLayout = linearLayout2;
                }
                linearLayout.setVisibility(this.this$0.playableItemEntityList.isEmpty() ? 0 : 8);
                this.this$0.lockToggleViewMode = false;
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
