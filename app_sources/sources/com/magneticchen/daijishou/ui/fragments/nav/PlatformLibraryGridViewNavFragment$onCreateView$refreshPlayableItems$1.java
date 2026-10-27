package com.magneticchen.daijishou.ui.fragments.nav;

import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.BooleanPreference;
import com.magneticchen.daijishou.data.db.entity.PlayableItemEntity;
import com.magneticchen.daijishou.ui.model.DaijishouLibraryModel;
import com.magneticchen.daijishou.ui.model.DaijishouViewModel;
import com.magneticchen.daijishou.utils.Utils;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PlatformLibraryGridViewNavFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryGridViewNavFragment$onCreateView$refreshPlayableItems$1", f = "PlatformLibraryGridViewNavFragment.kt", i = {0, 1, 2}, l = {571, 584, 596, 613}, m = "invokeSuspend", n = {"playableItemsToBeAdded", "playableItemsToBeAdded", "playableItemsToBeAdded"}, s = {"L$0", "L$0", "L$0"})
final class PlatformLibraryGridViewNavFragment$onCreateView$refreshPlayableItems$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SharedPreferences $platformLibrarySharedPreferences;
    final /* synthetic */ List<PlayableItemEntity> $playableItems;
    Object L$0;
    int label;
    final /* synthetic */ PlatformLibraryGridViewNavFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PlatformLibraryGridViewNavFragment$onCreateView$refreshPlayableItems$1(PlatformLibraryGridViewNavFragment platformLibraryGridViewNavFragment, List<PlayableItemEntity> list, SharedPreferences sharedPreferences, Continuation<? super PlatformLibraryGridViewNavFragment$onCreateView$refreshPlayableItems$1> continuation) {
        super(2, continuation);
        this.this$0 = platformLibraryGridViewNavFragment;
        this.$playableItems = list;
        this.$platformLibrarySharedPreferences = sharedPreferences;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlatformLibraryGridViewNavFragment$onCreateView$refreshPlayableItems$1(this.this$0, this.$playableItems, this.$platformLibrarySharedPreferences, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PlatformLibraryGridViewNavFragment$onCreateView$refreshPlayableItems$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x026e, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryGridViewNavFragment$onCreateView$refreshPlayableItems$1.AnonymousClass8(r11.this$0, r1, r11.$platformLibrarySharedPreferences, null), r11) == r0) goto L76;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            Method dump skipped, instruction units count: 628
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryGridViewNavFragment$onCreateView$refreshPlayableItems$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryGridViewNavFragment$onCreateView$refreshPlayableItems$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: PlatformLibraryGridViewNavFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryGridViewNavFragment$onCreateView$refreshPlayableItems$1$2", f = "PlatformLibraryGridViewNavFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PlatformLibraryGridViewNavFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(PlatformLibraryGridViewNavFragment platformLibraryGridViewNavFragment, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = platformLibraryGridViewNavFragment;
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

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryGridViewNavFragment$onCreateView$refreshPlayableItems$1$4, reason: invalid class name */
    /* JADX INFO: compiled from: PlatformLibraryGridViewNavFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryGridViewNavFragment$onCreateView$refreshPlayableItems$1$4", f = "PlatformLibraryGridViewNavFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PlatformLibraryGridViewNavFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(PlatformLibraryGridViewNavFragment platformLibraryGridViewNavFragment, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.this$0 = platformLibraryGridViewNavFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass4(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
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

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryGridViewNavFragment$onCreateView$refreshPlayableItems$1$6, reason: invalid class name */
    /* JADX INFO: compiled from: PlatformLibraryGridViewNavFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryGridViewNavFragment$onCreateView$refreshPlayableItems$1$6", f = "PlatformLibraryGridViewNavFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PlatformLibraryGridViewNavFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(PlatformLibraryGridViewNavFragment platformLibraryGridViewNavFragment, Continuation<? super AnonymousClass6> continuation) {
            super(2, continuation);
            this.this$0 = platformLibraryGridViewNavFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass6(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
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

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryGridViewNavFragment$onCreateView$refreshPlayableItems$1$8, reason: invalid class name */
    /* JADX INFO: compiled from: PlatformLibraryGridViewNavFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryGridViewNavFragment$onCreateView$refreshPlayableItems$1$8", f = "PlatformLibraryGridViewNavFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SharedPreferences $platformLibrarySharedPreferences;
        final /* synthetic */ List<PlayableItemEntity> $playableItemsToBeAdded;
        int label;
        final /* synthetic */ PlatformLibraryGridViewNavFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass8(PlatformLibraryGridViewNavFragment platformLibraryGridViewNavFragment, List<PlayableItemEntity> list, SharedPreferences sharedPreferences, Continuation<? super AnonymousClass8> continuation) {
            super(2, continuation);
            this.this$0 = platformLibraryGridViewNavFragment;
            this.$playableItemsToBeAdded = list;
            this.$platformLibrarySharedPreferences = sharedPreferences;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass8(this.this$0, this.$playableItemsToBeAdded, this.$platformLibrarySharedPreferences, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass8) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r8v10, types: [T, com.google.android.material.chip.Chip] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
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
                ViewGroup viewGroup = (ViewGroup) chipGroup;
                PlatformLibraryGridViewNavFragment platformLibraryGridViewNavFragment = this.this$0;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
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
                    ChipGroup chipGroup2 = this.this$0.chipGroup;
                    if (chipGroup2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                        chipGroup2 = null;
                    }
                    View childAt2 = chipGroup2.getChildAt(this.this$0.lastVisibleChipIndex);
                    Chip chip2 = this.this$0.listViewButton;
                    if (chip2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("listViewButton");
                        chip2 = null;
                    }
                    childAt2.setNextFocusRightId(chip2.getId());
                }
                if (DaijishouLibraryModel.getGenreIdsByPlatformIdAndVisibilityStatically$default(this.this$0.getDaijishouLibrary(), this.this$0.platformId, false, 2, null).isEmpty()) {
                    ChipGroup chipGroup3 = this.this$0.chipGroup;
                    if (chipGroup3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                        chipGroup3 = null;
                    }
                    View childAt3 = chipGroup3.getChildAt(this.this$0.lastVisibleChipIndex);
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
