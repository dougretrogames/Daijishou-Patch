package com.magneticchen.daijishou.ui.fragments.dialog;

import androidx.recyclerview.widget.DiffUtil;
import com.magneticchen.daijishou.data.BooleanPreference;
import com.magneticchen.daijishou.data.Constants;
import com.magneticchen.daijishou.data.db.entity.PlayableItemEntity;
import com.magneticchen.daijishou.ui.model.DaijishouLibraryModel;
import java.util.Arrays;
import java.util.List;
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

/* JADX INFO: compiled from: SearchPlayableItemDialogFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.dialog.SearchPlayableItemDialogFragment$onCreateView$4$onTextChanged$1", f = "SearchPlayableItemDialogFragment.kt", i = {}, l = {229}, m = "invokeSuspend", n = {}, s = {})
final class SearchPlayableItemDialogFragment$onCreateView$4$onTextChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SearchPlayableItemDialogFragment.SearchRecyclerViewAdapter $recyclerViewAdapter;
    final /* synthetic */ CharSequence $s;
    final /* synthetic */ List<PlayableItemEntity> $searchPlayableItemList;
    int label;
    final /* synthetic */ SearchPlayableItemDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SearchPlayableItemDialogFragment$onCreateView$4$onTextChanged$1(CharSequence charSequence, SearchPlayableItemDialogFragment searchPlayableItemDialogFragment, List<PlayableItemEntity> list, SearchPlayableItemDialogFragment.SearchRecyclerViewAdapter searchRecyclerViewAdapter, Continuation<? super SearchPlayableItemDialogFragment$onCreateView$4$onTextChanged$1> continuation) {
        super(2, continuation);
        this.$s = charSequence;
        this.this$0 = searchPlayableItemDialogFragment;
        this.$searchPlayableItemList = list;
        this.$recyclerViewAdapter = searchRecyclerViewAdapter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SearchPlayableItemDialogFragment$onCreateView$4$onTextChanged$1(this.$s, this.this$0, this.$searchPlayableItemList, this.$recyclerViewAdapter, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SearchPlayableItemDialogFragment$onCreateView$4$onTextChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List<PlayableItemEntity> listSearchPlayableItemsByKeyword$default;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String strValueOf = String.valueOf(this.$s);
            if (this.this$0.getDefaultSharedPreferences().getBoolean(BooleanPreference.MERGE_PLAYABLE_ITEMS.getKey(), BooleanPreference.MERGE_PLAYABLE_ITEMS.getDefaultValue())) {
                DaijishouLibraryModel daijishouLibrary = this.this$0.getDaijishouLibrary();
                PlayableItemEntity[] playableItemEntityArr = (PlayableItemEntity[]) DaijishouLibraryModel.searchPlayableItemsByKeyword$default(this.this$0.getDaijishouLibrary(), strValueOf, 128, false, true, false, 20, null).toArray(new PlayableItemEntity[0]);
                listSearchPlayableItemsByKeyword$default = daijishouLibrary.getMergedPlayableItems((PlayableItemEntity[]) Arrays.copyOf(playableItemEntityArr, playableItemEntityArr.length));
            } else {
                listSearchPlayableItemsByKeyword$default = DaijishouLibraryModel.searchPlayableItemsByKeyword$default(this.this$0.getDaijishouLibrary(), strValueOf, 64, false, true, false, 20, null);
            }
            List<PlayableItemEntity> list = listSearchPlayableItemsByKeyword$default;
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(strValueOf, this.this$0, this.$searchPlayableItemList, list, this.$recyclerViewAdapter, null), this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.fragments.dialog.SearchPlayableItemDialogFragment$onCreateView$4$onTextChanged$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchPlayableItemDialogFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.dialog.SearchPlayableItemDialogFragment$onCreateView$4$onTextChanged$1$1", f = "SearchPlayableItemDialogFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $keyword;
        final /* synthetic */ SearchPlayableItemDialogFragment.SearchRecyclerViewAdapter $recyclerViewAdapter;
        final /* synthetic */ List<PlayableItemEntity> $searchList;
        final /* synthetic */ List<PlayableItemEntity> $searchPlayableItemList;
        int label;
        final /* synthetic */ SearchPlayableItemDialogFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, SearchPlayableItemDialogFragment searchPlayableItemDialogFragment, List<PlayableItemEntity> list, List<PlayableItemEntity> list2, SearchPlayableItemDialogFragment.SearchRecyclerViewAdapter searchRecyclerViewAdapter, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$keyword = str;
            this.this$0 = searchPlayableItemDialogFragment;
            this.$searchPlayableItemList = list;
            this.$searchList = list2;
            this.$recyclerViewAdapter = searchRecyclerViewAdapter;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$keyword, this.this$0, this.$searchPlayableItemList, this.$searchList, this.$recyclerViewAdapter, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Exception {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            String str = this.$keyword;
            switch (str.hashCode()) {
                case -2003638802:
                    if (str.equals(Constants.debugOnSecretKeyword)) {
                        this.this$0.getDefaultSharedPreferences().edit().putBoolean(BooleanPreference.USE_DEBUG_MODE.getKey(), true).apply();
                        return Unit.INSTANCE;
                    }
                    break;
                case -1983267134:
                    if (str.equals(Constants.debugOffSecretKeyword)) {
                        this.this$0.getDefaultSharedPreferences().edit().putBoolean(BooleanPreference.USE_DEBUG_MODE.getKey(), false).apply();
                        return Unit.INSTANCE;
                    }
                    break;
                case -1393530574:
                    if (str.equals(Constants.secretKeyword)) {
                        DebugAndExperimentalDialogFragment.Companion.newInstance().show(this.this$0.getParentFragmentManager(), DebugAndExperimentalDialogFragment.class.getName());
                        return Unit.INSTANCE;
                    }
                    break;
                case -1284326656:
                    if (str.equals(Constants.crashSecretKeyword)) {
                        throw new Exception(Constants.crashSecretKeyword);
                    }
                    break;
            }
            DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new PlayableItemEntityDiffUtilCallback(this.$searchPlayableItemList, this.$searchList));
            Intrinsics.checkNotNullExpressionValue(diffResultCalculateDiff, "calculateDiff(...)");
            this.$searchPlayableItemList.clear();
            this.$searchPlayableItemList.addAll(this.$searchList);
            diffResultCalculateDiff.dispatchUpdatesTo(this.$recyclerViewAdapter);
            this.this$0.getRecyclerView().scrollToPosition(0);
            return Unit.INSTANCE;
        }
    }
}
