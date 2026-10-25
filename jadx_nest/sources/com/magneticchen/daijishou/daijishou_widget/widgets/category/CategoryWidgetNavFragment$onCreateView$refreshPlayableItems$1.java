package com.magneticchen.daijishou.daijishou_widget.widgets.category;

import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.magneticchen.daijishou.application_data.BooleanPreference;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import com.magneticchen.daijishou.daijishou_recycler_view.DaijishouGridLayoutManager;
import com.magneticchen.daijishou.utils.Utils;
import com.magneticchen.daijishou.view_models.DaijishouLibraryModel;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.apache.commons.collections4.CollectionUtils;

/* JADX INFO: compiled from: CategoryWidgetNavFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.daijishou_widget.widgets.category.CategoryWidgetNavFragment$onCreateView$refreshPlayableItems$1", f = "CategoryWidgetNavFragment.kt", i = {}, l = {629}, m = "invokeSuspendImpl", n = {}, s = {})
final class CategoryWidgetNavFragment$onCreateView$refreshPlayableItems$1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    final /* synthetic */ List<PlayableItemEntity> $playableItems;
    int label;
    final /* synthetic */ CategoryWidgetNavFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CategoryWidgetNavFragment$onCreateView$refreshPlayableItems$1(CategoryWidgetNavFragment categoryWidgetNavFragment, List<PlayableItemEntity> list, Continuation<?> continuation) {
        super(2, continuation);
        this.this$0 = categoryWidgetNavFragment;
        this.$playableItems = list;
    }


    public final Continuation create(Object obj, Continuation<?> continuation) {
        return new CategoryWidgetNavFragment$onCreateView$refreshPlayableItems$1(this.this$0, this.$playableItems, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((CategoryWidgetNavFragment$onCreateView$refreshPlayableItems$1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }

    public final Object invokeSuspendImpl(Object obj) throws Throwable {
        List<PlayableItemEntity> mergedPlayableItems;
        int filterMode;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.this$0.getDefaultSharedPreferences().getBoolean(BooleanPreference.MERGE_PLAYABLE_ITEMS.getKey(), BooleanPreference.MERGE_PLAYABLE_ITEMS.getDefaultValue())) {
                DaijishouLibraryModel daijishouLibrary = this.this$0.getDaijishouLibrary();
                PlayableItemEntity[] playableItemEntityArr = (PlayableItemEntity[]) this.$playableItems.toArray(new PlayableItemEntity[0]);
                mergedPlayableItems = daijishouLibrary.getMergedPlayableItems((PlayableItemEntity[]) Arrays.copyOf(playableItemEntityArr, playableItemEntityArr.length));
            } else {
                mergedPlayableItems = this.$playableItems;
            }
            List mutableList = CollectionsKt.toMutableList((Collection) mergedPlayableItems);
            if (this.this$0.getDefaultSharedPreferences().getBoolean(BooleanPreference.MERGE_PLAYABLE_ITEMS.getKey(), BooleanPreference.MERGE_PLAYABLE_ITEMS.getDefaultValue()) && (filterMode = this.this$0.getCategoryWidgetViewModel().getFilterMode()) != 0) {
                if (filterMode != 1) {
                    if (filterMode != 2) {
                        if (filterMode == 3) {
                            if (mutableList.size() > 1) {
                                CollectionsKt.sortWith(mutableList, new CategoryWidgetNavFragment$onCreateView$refreshPlayableItems$1$invokeSuspendImpl$$inlined$sortByDescending$3());
                            }
                        } else if (mutableList.size() > 1) {
                            CollectionsKt.sortWith(mutableList, new CategoryWidgetNavFragment$onCreateView$refreshPlayableItems$1$invokeSuspendImpl$$inlined$sortByDescending$4());
                        }
                    } else if (mutableList.size() > 1) {
                        CollectionsKt.sortWith(mutableList, new CategoryWidgetNavFragment$onCreateView$refreshPlayableItems$1$invokeSuspendImpl$$inlined$sortByDescending$2());
                    }
                } else if (mutableList.size() > 1) {
                    CollectionsKt.sortWith(mutableList, new CategoryWidgetNavFragment$onCreateView$refreshPlayableItems$1$invokeSuspendImpl$$inlined$sortByDescending$1());
                }
            }
            CategoryWidgetNavFragment.CategoryWidgetRecyclerViewAdapter categoryWidgetRecyclerViewAdapter = this.this$0.recyclerViewAdapter;
            if (categoryWidgetRecyclerViewAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
                categoryWidgetRecyclerViewAdapter = null;
            }
            List listSplit$default = StringsKt.split$default((CharSequence) categoryWidgetRecyclerViewAdapter.getDimensionRatio(), new String[]{CollectionUtils.COLON}, false, 0, 6, (Object) null);
            float fMax = Math.max((Float.parseFloat((String) listSplit$default.get(0)) * 120.0f) / Float.parseFloat((String) listSplit$default.get(1)), 120.0f);
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass5(this.this$0, fMax, mutableList, null), this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.category.CategoryWidgetNavFragment$onCreateView$refreshPlayableItems$1$5, reason: invalid class name */
    /* JADX INFO: compiled from: CategoryWidgetNavFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.daijishou_widget.widgets.category.CategoryWidgetNavFragment$onCreateView$refreshPlayableItems$1$5", f = "CategoryWidgetNavFragment.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
    static final class AnonymousClass5 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        final /* synthetic */ List<PlayableItemEntity> $playableItems;
        final /* synthetic */ float $targetWidth;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ CategoryWidgetNavFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(CategoryWidgetNavFragment categoryWidgetNavFragment, float f, List<PlayableItemEntity> list, Continuation<?> continuation) {
            super(2, continuation);
            this.this$0 = categoryWidgetNavFragment;
            this.$targetWidth = f;
            this.$playableItems = list;
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            AnonymousClass5 anonymousClass5 = new AnonymousClass5(this.this$0, this.$targetWidth, this.$playableItems, continuation);
            anonymousClass5.L$0 = obj;
            return anonymousClass5;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                try {
                    return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                }
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r15v2, types: [T, com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity] */
        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                DaijishouGridLayoutManager daijishouGridLayoutManager = this.this$0.gridLayoutManager;
                String lowerCase = null;
                if (daijishouGridLayoutManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
                    daijishouGridLayoutManager = null;
                }
                daijishouGridLayoutManager.updateTargetWidthDp(this.$targetWidth);
                CategoryWidgetNavFragment.CategoryWidgetRecyclerViewAdapter categoryWidgetRecyclerViewAdapter = this.this$0.recyclerViewAdapter;
                if (categoryWidgetRecyclerViewAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
                    categoryWidgetRecyclerViewAdapter = null;
                }
                if (categoryWidgetRecyclerViewAdapter.getDimensionRatioHasChanged() || this.$playableItems.size() != this.this$0.playableItemEntityList.size()) {
                    invokeSuspendImpl$updateAll(this.this$0, this.$playableItems);
                    CategoryWidgetNavFragment.CategoryWidgetRecyclerViewAdapter categoryWidgetRecyclerViewAdapter2 = this.this$0.recyclerViewAdapter;
                    if (categoryWidgetRecyclerViewAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
                        categoryWidgetRecyclerViewAdapter2 = null;
                    }
                    categoryWidgetRecyclerViewAdapter2.setDimensionRatioHasChanged(false);
                } else {
                    List<PlayableItemEntity> list = this.$playableItems;
                    CategoryWidgetNavFragment categoryWidgetNavFragment = this.this$0;
                    int i = 0;
                    for (Object obj2 : list) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        PlayableItemEntity playableItemEntity = (PlayableItemEntity) obj2;
                        Ref.IntRef intRef = new Ref.IntRef();
                        intRef.element = -1;
                        Ref.ObjectRef objectRef = new Ref.ObjectRef();
                        boolean z = true;
                        int i3 = 0;
                        for (Object obj3 : categoryWidgetNavFragment.playableItemEntityList) {
                            int i4 = i3 + 1;
                            if (i3 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            PlayableItemEntity r15 = (PlayableItemEntity) obj3;
                            if (playableItemEntity.getId() == r15.getId()) {
                                intRef.element = i3;
                                objectRef.element = r15;
                                z = false;
                            }
                            i3 = i4;
                        }
                        if (z) {
                            invokeSuspendImpl$updateAll(categoryWidgetNavFragment, list);
                            break;
                        }
                        Object t = objectRef.element;
                        Intrinsics.checkNotNull(t);
                        if (!Intrinsics.areEqual(playableItemEntity, t)) {
                            Utils utils = Utils.INSTANCE;
                            Object t2 = objectRef.element;
                            Intrinsics.checkNotNull(t2);
                            String boxArtPath = utils.getBoxArtPath((PlayableItemEntity) t2);
                            if (boxArtPath != null) {
                                CategoryWidgetNavFragment.CategoryWidgetRecyclerViewAdapter categoryWidgetRecyclerViewAdapter3 = categoryWidgetNavFragment.recyclerViewAdapter;
                                if (categoryWidgetRecyclerViewAdapter3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
                                    categoryWidgetRecyclerViewAdapter3 = null;
                                }
                                categoryWidgetRecyclerViewAdapter3.getCachedBitmapLoader().remove(boxArtPath);
                            }
                            categoryWidgetNavFragment.playableItemEntityList.set(intRef.element, playableItemEntity);
                            CategoryWidgetNavFragment.CategoryWidgetRecyclerViewAdapter categoryWidgetRecyclerViewAdapter4 = categoryWidgetNavFragment.recyclerViewAdapter;
                            if (categoryWidgetRecyclerViewAdapter4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
                                categoryWidgetRecyclerViewAdapter4 = null;
                            }
                            categoryWidgetRecyclerViewAdapter4.notifyItemChanged(intRef.element);
                        }
                        i = i2;
                    }
                }
                LinearLayout linearLayout = this.this$0.emptyLayout;
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("emptyLayout");
                    linearLayout = null;
                }
                linearLayout.setVisibility(this.this$0.playableItemEntityList.isEmpty() ? 0 : 8);
                TextView textView = this.this$0.emptyTextView;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("emptyTextView");
                    textView = null;
                }
                if (this.this$0.getCategoryWidgetViewModel().getFilterMode() == 0) {
                    String str = this.this$0.noItemsString;
                    if (str == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("noItemsString");
                    } else {
                        lowerCase = str;
                    }
                } else {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String str2 = this.this$0.noItemsFormatString;
                    if (str2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("noItemsFormatString");
                        str2 = null;
                    }
                    HashMap map = this.this$0.filterModeTitleStringHashMap;
                    if (map == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("filterModeTitleStringHashMap");
                        map = null;
                    }
                    String str3 = (String) map.get(Boxing.boxInt(this.this$0.getCategoryWidgetViewModel().getFilterMode()));
                    if (str3 != null) {
                        lowerCase = str3.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    }
                    lowerCase = String.format(str2, Arrays.copyOf(new Object[]{lowerCase}, 1));
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "format(...)");
                }
                textView.setText(lowerCase);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        private static final void invokeSuspendImpl$updateAll(CategoryWidgetNavFragment categoryWidgetNavFragment, List<PlayableItemEntity> list) {
            RecyclerView recyclerView = categoryWidgetNavFragment.recyclerView;
            CategoryWidgetNavFragment.CategoryWidgetRecyclerViewAdapter categoryWidgetRecyclerViewAdapter = null;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView = null;
            }
            recyclerView.scrollToPosition(0);
            categoryWidgetNavFragment.playableItemEntityList.clear();
            categoryWidgetNavFragment.playableItemEntityList.addAll(list);
            RecyclerView recyclerView2 = categoryWidgetNavFragment.recyclerView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView2 = null;
            }
            recyclerView2.clearFocus();
            CategoryWidgetNavFragment.CategoryWidgetRecyclerViewAdapter categoryWidgetRecyclerViewAdapter2 = categoryWidgetNavFragment.recyclerViewAdapter;
            if (categoryWidgetRecyclerViewAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
            } else {
                categoryWidgetRecyclerViewAdapter = categoryWidgetRecyclerViewAdapter2;
            }
            categoryWidgetRecyclerViewAdapter.notifyDataSetChanged();
        }
    }
}
