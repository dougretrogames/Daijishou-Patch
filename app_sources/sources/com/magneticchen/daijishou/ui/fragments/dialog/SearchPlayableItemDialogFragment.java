package com.magneticchen.daijishou.ui.fragments.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textfield.TextInputEditText;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.BooleanPreference;
import com.magneticchen.daijishou.data.Constants;
import com.magneticchen.daijishou.data.Genre;
import com.magneticchen.daijishou.data.Genres;
import com.magneticchen.daijishou.data.db.entity.PlatformEntity;
import com.magneticchen.daijishou.data.db.entity.PlayableItemEntity;
import com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouLinearLayoutManager;
import com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView;
import com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment;
import com.magneticchen.daijishou.ui.model.DaijishouLibraryModel;
import com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetViewModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: SearchPlayableItemDialogFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/SearchPlayableItemDialogFragment;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/DaijishouDialogFragment;", "()V", "backButtonLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getBackButtonLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setBackButtonLayout", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "recyclerView", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView;", "getRecyclerView", "()Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView;", "setRecyclerView", "(Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView;)V", "scrollingOnBackPressed", "", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "", "Companion", "SearchRecyclerViewAdapter", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SearchPlayableItemDialogFragment extends DaijishouDialogFragment {
    public static final Companion Companion = new Companion(null);
    public ConstraintLayout backButtonLayout;
    public DaijishouRecyclerView recyclerView;
    private boolean scrollingOnBackPressed;

    /* JADX INFO: compiled from: SearchPlayableItemDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/SearchPlayableItemDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/ui/fragments/dialog/SearchPlayableItemDialogFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SearchPlayableItemDialogFragment newInstance() {
            SearchPlayableItemDialogFragment searchPlayableItemDialogFragment = new SearchPlayableItemDialogFragment();
            searchPlayableItemDialogFragment.setArguments(new Bundle());
            return searchPlayableItemDialogFragment;
        }
    }

    public final DaijishouRecyclerView getRecyclerView() {
        DaijishouRecyclerView daijishouRecyclerView = this.recyclerView;
        if (daijishouRecyclerView != null) {
            return daijishouRecyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        return null;
    }

    public final void setRecyclerView(DaijishouRecyclerView daijishouRecyclerView) {
        Intrinsics.checkNotNullParameter(daijishouRecyclerView, "<set-?>");
        this.recyclerView = daijishouRecyclerView;
    }

    public final ConstraintLayout getBackButtonLayout() {
        ConstraintLayout constraintLayout = this.backButtonLayout;
        if (constraintLayout != null) {
            return constraintLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("backButtonLayout");
        return null;
    }

    public final void setBackButtonLayout(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.backButtonLayout = constraintLayout;
    }

    /* JADX INFO: compiled from: SearchPlayableItemDialogFragment.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\n0\u000bR\u00060\u0000R\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/SearchPlayableItemDialogFragment$SearchRecyclerViewAdapter;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;", "playableItemEntityList", "", "(Lcom/magneticchen/daijishou/ui/fragments/dialog/SearchPlayableItemDialogFragment;Ljava/util/List;)V", "getItemId", "", "position", "", "onCreateViewHolder", "Lcom/magneticchen/daijishou/ui/fragments/dialog/SearchPlayableItemDialogFragment$SearchRecyclerViewAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/fragments/dialog/SearchPlayableItemDialogFragment;", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class SearchRecyclerViewAdapter extends DaijishouRecyclerView.Adapter<PlayableItemEntity> {
        private final List<PlayableItemEntity> playableItemEntityList;
        final /* synthetic */ SearchPlayableItemDialogFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SearchRecyclerViewAdapter(SearchPlayableItemDialogFragment searchPlayableItemDialogFragment, List<PlayableItemEntity> playableItemEntityList) {
            super(playableItemEntityList, false, false, 6, null);
            Intrinsics.checkNotNullParameter(playableItemEntityList, "playableItemEntityList");
            this.this$0 = searchPlayableItemDialogFragment;
            this.playableItemEntityList = playableItemEntityList;
        }

        public long getItemId(int i) {
            return this.playableItemEntityList.get(i).getId();
        }

        /* JADX INFO: compiled from: SearchPlayableItemDialogFragment.kt */
        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0086\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \t*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \t*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \t*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/SearchPlayableItemDialogFragment$SearchRecyclerViewAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;", "itemView", "Landroid/view/View;", "(Lcom/magneticchen/daijishou/ui/fragments/dialog/SearchPlayableItemDialogFragment$SearchRecyclerViewAdapter;Landroid/view/View;)V", "favoriteImageView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "firstLine", "Landroid/widget/TextView;", "genresTextView", "newlyImageView", "recentImageView", "secondLine", "onBind", "", "position", "", "item", "onFocus", "onFocusClear", "isAbsoluteAdapterPositionValid", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public final class ViewHolder extends DaijishouRecyclerView.Adapter<PlayableItemEntity>.ViewHolder {
            private final ImageView favoriteImageView;
            private final TextView firstLine;
            private final TextView genresTextView;
            private final ImageView newlyImageView;
            private final ImageView recentImageView;
            private final TextView secondLine;
            final /* synthetic */ SearchRecyclerViewAdapter this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(SearchRecyclerViewAdapter searchRecyclerViewAdapter, View itemView) {
                super(searchRecyclerViewAdapter, itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                this.this$0 = searchRecyclerViewAdapter;
                this.firstLine = (TextView) itemView.findViewById(R.id.list_item_log_record_first_line);
                this.secondLine = (TextView) itemView.findViewById(R.id.list_item_log_record_second_line);
                this.genresTextView = (TextView) itemView.findViewById(R.id.list_item_log_record_genres_text_view);
                this.recentImageView = (ImageView) itemView.findViewById(R.id.list_item_search_playable_item_recent_image_view);
                this.newlyImageView = (ImageView) itemView.findViewById(R.id.list_item_search_playable_item_newly_image_view);
                this.favoriteImageView = (ImageView) itemView.findViewById(R.id.list_item_search_playable_item_favorite_image_view);
            }

            @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onBind(int i, PlayableItemEntity item) {
                String name;
                Intrinsics.checkNotNullParameter(item, "item");
                this.firstLine.setText(this.this$0.this$0.getDaijishouLibrary().prettifyTitleWithPreferences(item.getName()));
                Long attachedPlatformId = item.getAttachedPlatformId();
                if (attachedPlatformId != null) {
                    PlatformEntity platformByIdStatically = this.this$0.this$0.getDaijishouLibrary().getPlatformByIdStatically(attachedPlatformId.longValue());
                    if (platformByIdStatically != null) {
                        TextView textView = this.secondLine;
                        if (platformByIdStatically.getName().length() > 18) {
                            String shortname = platformByIdStatically.getShortname();
                            Locale ROOT = Locale.ROOT;
                            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                            name = shortname.toUpperCase(ROOT);
                            Intrinsics.checkNotNullExpressionValue(name, "toUpperCase(...)");
                        } else {
                            name = platformByIdStatically.getName();
                        }
                        textView.setText(name);
                    }
                }
                List<String> genreIdsByPlayableItemIdStatically = this.this$0.this$0.getDaijishouLibrary().getGenreIdsByPlayableItemIdStatically(item.getId());
                if (!genreIdsByPlayableItemIdStatically.isEmpty()) {
                    TextView textView2 = this.genresTextView;
                    int size = genreIdsByPlayableItemIdStatically.size();
                    SearchPlayableItemDialogFragment searchPlayableItemDialogFragment = this.this$0.this$0;
                    ArrayList arrayList = new ArrayList(size);
                    for (int i2 = 0; i2 < size; i2++) {
                        Genre genre = Genres.INSTANCE.getGenres().get(genreIdsByPlayableItemIdStatically.get(i2));
                        arrayList.add(searchPlayableItemDialogFragment.getString(genre != null ? genre.getNameStringId() : R.string.unknown_genre_name));
                    }
                    textView2.setText(CollectionsKt.joinToString$default(arrayList, " • ", null, null, 0, null, null, 62, null));
                } else {
                    this.genresTextView.setText((CharSequence) null);
                }
                long jCurrentTimeMillis = System.currentTimeMillis() - Duration.m1822getInWholeMillisecondsimpl(Constants.INSTANCE.m143getRecentDurationDefinitionUwyO8pc());
                long jCurrentTimeMillis2 = System.currentTimeMillis() - Duration.m1822getInWholeMillisecondsimpl(Constants.INSTANCE.m142getNewlyDurationDefinitionUwyO8pc());
                Date lastPlayedTimestamp = item.getLastPlayedTimestamp();
                Long lValueOf = lastPlayedTimestamp != null ? Long.valueOf(lastPlayedTimestamp.getTime()) : null;
                long time = item.getAddedDateTimestamp().getTime();
                this.favoriteImageView.setVisibility(item.isFavorite() ? 0 : 8);
                this.recentImageView.setVisibility((lValueOf == null || lValueOf.longValue() <= jCurrentTimeMillis) ? 8 : 0);
                this.newlyImageView.setVisibility(time <= jCurrentTimeMillis2 ? 8 : 0);
            }

            @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onFocus() {
                super.onFocus();
                this.secondLine.setSelected(true);
            }

            @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onFocusClear(boolean z) {
                super.onFocusClear(z);
                this.secondLine.setSelected(false);
            }
        }

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_search_playable_item, viewGroup, false);
            Intrinsics.checkNotNull(viewInflate);
            return new ViewHolder(this, viewInflate);
        }
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        final FragmentActivity fragmentActivityRequireActivity = requireActivity();
        final int theme = getTheme();
        Dialog dialog = new Dialog(fragmentActivityRequireActivity, theme) { // from class: com.magneticchen.daijishou.ui.fragments.dialog.SearchPlayableItemDialogFragment$onCreateDialog$dialog$1
            {
                super((Context) fragmentActivityRequireActivity, theme);
            }

            @Override // android.app.Dialog
            public void onBackPressed() {
                if ((!this.this$0.scrollingOnBackPressed || this.this$0.getRecyclerView().getScrollState() != 2) && this.this$0.getRecyclerView().computeVerticalScrollOffset() != 0) {
                    this.this$0.scrollingOnBackPressed = true;
                    this.this$0.getBackButtonLayout().requestFocus();
                    this.this$0.getRecyclerView().smoothScrollToPosition(0);
                } else {
                    this.this$0.getRecyclerView().scrollToPosition(0);
                    super.onBackPressed();
                }
            }
        };
        setupDaijishouDialog(dialog);
        return dialog;
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            Window window = dialog.getWindow();
            View decorView = window != null ? window.getDecorView() : null;
            Intrinsics.checkNotNull(decorView);
            decorView.setBackground(null);
            Window window2 = dialog.getWindow();
            if (window2 != null) {
                window2.setLayout(-1, -1);
            }
            Window window3 = dialog.getWindow();
            if (window3 != null) {
                window3.setFlags(CategoryWidgetViewModel.LIMIT, CategoryWidgetViewModel.LIMIT);
            }
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        List<PlayableItemEntity> listFindPlayableItemsWithNameDescriptionAndVisibilityStatically$default;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        final ArrayList arrayList = new ArrayList();
        View viewInflate = inflater.inflate(R.layout.fragment_search_dialog, viewGroup, false);
        Object objFindViewById = viewInflate.findViewById(R.id.fragment_search_dialog_recycler_view);
        Intrinsics.checkNotNullExpressionValue(objFindViewById, "findViewById(...)");
        setRecyclerView((DaijishouRecyclerView) objFindViewById);
        if (getDefaultSharedPreferences().getBoolean(BooleanPreference.MERGE_PLAYABLE_ITEMS.getKey(), BooleanPreference.MERGE_PLAYABLE_ITEMS.getDefaultValue())) {
            DaijishouLibraryModel daijishouLibrary = getDaijishouLibrary();
            PlayableItemEntity[] playableItemEntityArr = (PlayableItemEntity[]) DaijishouLibraryModel.findPlayableItemsWithNameDescriptionAndVisibilityStatically$default(getDaijishouLibrary(), "", 128, false, 4, null).toArray(new PlayableItemEntity[0]);
            listFindPlayableItemsWithNameDescriptionAndVisibilityStatically$default = daijishouLibrary.getMergedPlayableItems((PlayableItemEntity[]) Arrays.copyOf(playableItemEntityArr, playableItemEntityArr.length));
        } else {
            listFindPlayableItemsWithNameDescriptionAndVisibilityStatically$default = DaijishouLibraryModel.findPlayableItemsWithNameDescriptionAndVisibilityStatically$default(getDaijishouLibrary(), "", 64, false, 4, null);
        }
        arrayList.addAll(listFindPlayableItemsWithNameDescriptionAndVisibilityStatically$default);
        final SearchRecyclerViewAdapter searchRecyclerViewAdapter = new SearchRecyclerViewAdapter(this, arrayList);
        getRecyclerView().setAdapter(searchRecyclerViewAdapter);
        DaijishouRecyclerView recyclerView = getRecyclerView();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        recyclerView.setLayoutManager((RecyclerView.LayoutManager) new DaijishouLinearLayoutManager(contextRequireContext, 1, false));
        getRecyclerView().addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.SearchPlayableItemDialogFragment.onCreateView.1
            public void onScrollStateChanged(RecyclerView recyclerView2, int i) {
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                if (i == 0) {
                    SearchPlayableItemDialogFragment.this.scrollingOnBackPressed = false;
                }
                super.onScrollStateChanged(recyclerView2, i);
            }
        });
        searchRecyclerViewAdapter.setOnItemClickListener(new Function4<View, Integer, Long, PlayableItemEntity, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.SearchPlayableItemDialogFragment.onCreateView.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, Long l, PlayableItemEntity playableItemEntity) {
                invoke(view, num.intValue(), l.longValue(), playableItemEntity);
                return Unit.INSTANCE;
            }

            public final void invoke(View view, int i, long j, PlayableItemEntity playableItemEntity) {
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(playableItemEntity, "<anonymous parameter 3>");
                PlayableItemEntity playableItemEntity2 = arrayList.get(i);
                if (!this.getDefaultSharedPreferences().getBoolean(BooleanPreference.DETAIL_VIEW_ON_CLICK.getKey(), BooleanPreference.DETAIL_VIEW_ON_CLICK.getDefaultValue())) {
                    DaijishouLibraryModel daijishouLibrary2 = this.getDaijishouLibrary();
                    Activity activityRequireActivity = this.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(activityRequireActivity, "requireActivity(...)");
                    DaijishouLibraryModel.play$default(daijishouLibrary2, activityRequireActivity, playableItemEntity2, null, 4, null);
                    return;
                }
                PlayableItemDetailDialogFragment.Companion.newInstance(playableItemEntity2).show(this.getParentFragmentManager(), PlayableItemDetailDialogFragment.class.getName());
            }
        });
        View viewFindViewById = viewInflate.findViewById(R.id.fragment_search_dialog_back_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        setBackButtonLayout((ConstraintLayout) viewFindViewById);
        getBackButtonLayout().requestFocus();
        getBackButtonLayout().setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.SearchPlayableItemDialogFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchPlayableItemDialogFragment.onCreateView$lambda$0(this.f$0, view);
            }
        });
        final TextInputEditText textInputEditTextFindViewById = viewInflate.findViewById(R.id.fragment_search_dialog_edit_text);
        textInputEditTextFindViewById.addTextChangedListener(new TextWatcher() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.SearchPlayableItemDialogFragment.onCreateView.4
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(SearchPlayableItemDialogFragment.this), Dispatchers.getIO(), (CoroutineStart) null, new SearchPlayableItemDialogFragment$onCreateView$4$onTextChanged$1(charSequence, SearchPlayableItemDialogFragment.this, arrayList, searchRecyclerViewAdapter, null), 2, (Object) null);
            }
        });
        viewInflate.findViewById(R.id.fragment_search_dialog_text_input_layout).setEndIconOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.SearchPlayableItemDialogFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchPlayableItemDialogFragment.onCreateView$lambda$1(textInputEditTextFindViewById, view);
            }
        });
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$0(SearchPlayableItemDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.requireDialog().onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$1(TextInputEditText textInputEditText, View view) {
        Editable text = textInputEditText.getText();
        if (text != null) {
            text.clear();
        }
    }
}
