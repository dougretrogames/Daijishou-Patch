package com.magneticchen.daijishou.ui.widget.widgets.rss;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.android.material.chip.Chip;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.Constants;
import com.magneticchen.daijishou.data.db.entity.RSSWidgetInstanceEntity;
import com.magneticchen.daijishou.data.db.repositories.DaijishouWidgetRepository;
import com.magneticchen.daijishou.ui.activities.MainActivity;
import com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouLinearLayoutManager;
import com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetNavFragment;
import com.prof18.rssparser.RssParser;
import com.prof18.rssparser.RssParserBuilderKt;
import com.prof18.rssparser.model.RssChannel;
import com.prof18.rssparser.model.RssItem;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: RSSWidgetNavFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 *2\u00020\u0001:\u0002*+B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001f\u001a\u00020\u001aH\u0016J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J&\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00060\u0017R\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widgets/rss/RSSWidgetNavFragment;", "Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetNavFragment;", "()V", "articleList", "", "Lcom/prof18/rssparser/model/RssItem;", "articlesCountButton", "Lcom/google/android/material/chip/Chip;", "articlesFormatString", "", "channel", "Lcom/prof18/rssparser/model/RssChannel;", "daijishouWidgetRepository", "Lcom/magneticchen/daijishou/data/db/repositories/DaijishouWidgetRepository;", "noTitleString", "parser", "Lcom/prof18/rssparser/RssParser;", "progressbar", "Lcom/google/android/material/progressindicator/LinearProgressIndicator;", "rSSFeedString", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerViewAdapter", "Lcom/magneticchen/daijishou/ui/widget/widgets/rss/RSSWidgetNavFragment$RSSArticleListAdapter;", "refreshButton", "scrollingOnBackPressed", "", "titleLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "titleTextView", "Landroid/widget/TextView;", "onBackPressed", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "Companion", "RSSArticleListAdapter", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RSSWidgetNavFragment extends WidgetNavFragment {
    public static final Companion Companion = new Companion(null);
    private static final Typeface typeface;
    private Chip articlesCountButton;
    private String articlesFormatString;
    private RssChannel channel;
    private DaijishouWidgetRepository daijishouWidgetRepository;
    private String noTitleString;
    private LinearProgressIndicator progressbar;
    private String rSSFeedString;
    private RecyclerView recyclerView;
    private RSSArticleListAdapter recyclerViewAdapter;
    private Chip refreshButton;
    private boolean scrollingOnBackPressed;
    private ConstraintLayout titleLayout;
    private TextView titleTextView;
    private final RssParser parser = RssParserBuilderKt.RssParser();
    private final List<RssItem> articleList = new ArrayList();

    /* JADX INFO: compiled from: RSSWidgetNavFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widgets/rss/RSSWidgetNavFragment$Companion;", "", "()V", "typeface", "Landroid/graphics/Typeface;", "getTypeface", "()Landroid/graphics/Typeface;", "newInstance", "Lcom/magneticchen/daijishou/ui/widget/widgets/rss/RSSWidgetNavFragment;", "widgetInstanceId", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RSSWidgetNavFragment newInstance(long j) {
            RSSWidgetNavFragment rSSWidgetNavFragment = new RSSWidgetNavFragment();
            Bundle bundle = new Bundle();
            bundle.putLong("widgetInstanceId", j);
            rSSWidgetNavFragment.setArguments(bundle);
            return rSSWidgetNavFragment;
        }

        public final Typeface getTypeface() {
            return RSSWidgetNavFragment.typeface;
        }
    }

    static {
        Typeface typefaceDefaultFromStyle;
        String str;
        if (Build.VERSION.SDK_INT >= 28) {
            typefaceDefaultFromStyle = Typeface.create(null, Constants.semiBolderWeight, false);
            str = "create(...)";
        } else {
            typefaceDefaultFromStyle = Typeface.defaultFromStyle(1);
            str = "defaultFromStyle(...)";
        }
        Intrinsics.checkNotNullExpressionValue(typefaceDefaultFromStyle, str);
        typeface = typefaceDefaultFromStyle;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001f  */
    /* JADX WARN: Code duplicated, block: B:20:0x0036  */
    /* JADX WARN: Code duplicated, block: B:22:0x003c  */
    /* JADX WARN: Code duplicated, block: B:25:0x0049  */
    /* JADX WARN: Code duplicated, block: B:26:0x004d  */
    /* JADX WARN: Code duplicated, block: B:9:0x001b  */
    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment
    public boolean onBackPressed() {
        RecyclerView recyclerView;
        ConstraintLayout constraintLayout;
        RecyclerView recyclerView2;
        super.onBackPressed();
        RecyclerView recyclerView3 = null;
        if (this.scrollingOnBackPressed) {
            RecyclerView recyclerView4 = this.recyclerView;
            if (recyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView4 = null;
            }
            if (recyclerView4.getScrollState() != 2) {
                recyclerView = this.recyclerView;
                if (recyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    recyclerView = null;
                }
                if (recyclerView.computeVerticalScrollOffset() != 0) {
                    this.scrollingOnBackPressed = true;
                    constraintLayout = this.titleLayout;
                    if (constraintLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
                        constraintLayout = null;
                    }
                    constraintLayout.requestFocus();
                    recyclerView2 = this.recyclerView;
                    if (recyclerView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    } else {
                        recyclerView3 = recyclerView2;
                    }
                    recyclerView3.smoothScrollToPosition(0);
                    return false;
                }
            }
        } else {
            recyclerView = this.recyclerView;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView = null;
            }
            if (recyclerView.computeVerticalScrollOffset() != 0) {
                this.scrollingOnBackPressed = true;
                constraintLayout = this.titleLayout;
                if (constraintLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
                    constraintLayout = null;
                }
                constraintLayout.requestFocus();
                recyclerView2 = this.recyclerView;
                if (recyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                } else {
                    recyclerView3 = recyclerView2;
                }
                recyclerView3.smoothScrollToPosition(0);
                return false;
            }
        }
        RecyclerView recyclerView5 = this.recyclerView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView3 = recyclerView5;
        }
        recyclerView3.scrollToPosition(0);
        return true;
    }

    /* JADX INFO: compiled from: RSSWidgetNavFragment.kt */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u001fB\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J \u0010\u0018\u001a\u00020\f2\u000e\u0010\u0019\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J \u0010\u001a\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0010H\u0016J\u001a\u0010\u001e\u001a\u00020\f2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R1\u0010\u000e\u001a%\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widgets/rss/RSSWidgetNavFragment$RSSArticleListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/magneticchen/daijishou/ui/widget/widgets/rss/RSSWidgetNavFragment$RSSArticleListAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/widget/widgets/rss/RSSWidgetNavFragment;", "context", "Landroid/content/Context;", "values", "", "Lcom/prof18/rssparser/model/RssItem;", "(Lcom/magneticchen/daijishou/ui/widget/widgets/rss/RSSWidgetNavFragment;Landroid/content/Context;Ljava/util/List;)V", "onItemClickedListener", "Lkotlin/Function1;", "", "onItemLongClickedListener", "onItemSelectedListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "getItemCount", "getItemId", "", "pos", "onBindViewHolder", "viewHolder", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "setOnItemClicked", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class RSSArticleListAdapter extends RecyclerView.Adapter<RSSArticleListAdapter.ViewHolder> {
        private final Context context;
        private Function1<? super RssItem, Unit> onItemClickedListener;
        private Function1<? super RssItem, Unit> onItemLongClickedListener;
        private Function2<? super Integer, ? super RssItem, Unit> onItemSelectedListener;
        final /* synthetic */ RSSWidgetNavFragment this$0;
        private final List<RssItem> values;

        public RSSArticleListAdapter(RSSWidgetNavFragment rSSWidgetNavFragment, Context context, List<RssItem> values) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(values, "values");
            this.this$0 = rSSWidgetNavFragment;
            this.context = context;
            this.values = values;
        }

        /* JADX INFO: compiled from: RSSWidgetNavFragment.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widgets/rss/RSSWidgetNavFragment$RSSArticleListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/magneticchen/daijishou/ui/widget/widgets/rss/RSSWidgetNavFragment$RSSArticleListAdapter;Landroid/view/View;)V", "content", "Landroid/widget/TextView;", "getContent", "()Landroid/widget/TextView;", "date", "getDate", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "title", "getTitle", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public final class ViewHolder extends RecyclerView.ViewHolder {
            private final TextView content;
            private final TextView date;
            private final ImageView imageView;
            final /* synthetic */ RSSArticleListAdapter this$0;
            private final TextView title;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(final RSSArticleListAdapter rSSArticleListAdapter, View view) {
                super(view);
                Intrinsics.checkNotNullParameter(view, "view");
                this.this$0 = rSSArticleListAdapter;
                View viewFindViewById = view.findViewById(R.id.grid_item_rss_article_image_view);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
                this.imageView = (ImageView) viewFindViewById;
                View viewFindViewById2 = view.findViewById(R.id.grid_item_rss_article_title_text_view);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
                this.title = (TextView) viewFindViewById2;
                View viewFindViewById3 = view.findViewById(R.id.grid_item_rss_article_content_text_view);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
                this.content = (TextView) viewFindViewById3;
                View viewFindViewById4 = view.findViewById(R.id.grid_item_rss_article_date_text_view);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
                this.date = (TextView) viewFindViewById4;
                this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.widget.widgets.rss.RSSWidgetNavFragment$RSSArticleListAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        RSSWidgetNavFragment.RSSArticleListAdapter.ViewHolder._init_$lambda$1(rSSArticleListAdapter, this, view2);
                    }
                });
                this.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.magneticchen.daijishou.ui.widget.widgets.rss.RSSWidgetNavFragment$RSSArticleListAdapter$ViewHolder$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view2) {
                        return RSSWidgetNavFragment.RSSArticleListAdapter.ViewHolder._init_$lambda$3(rSSArticleListAdapter, this, view2);
                    }
                });
                this.itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.magneticchen.daijishou.ui.widget.widgets.rss.RSSWidgetNavFragment$RSSArticleListAdapter$ViewHolder$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnFocusChangeListener
                    public final void onFocusChange(View view2, boolean z) {
                        RSSWidgetNavFragment.RSSArticleListAdapter.ViewHolder._init_$lambda$5(rSSArticleListAdapter, this, view2, z);
                    }
                });
            }

            public final ImageView getImageView() {
                return this.imageView;
            }

            public final TextView getTitle() {
                return this.title;
            }

            public final TextView getContent() {
                return this.content;
            }

            public final TextView getDate() {
                return this.date;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void _init_$lambda$1(RSSArticleListAdapter this$0, ViewHolder this$1, View view) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Intrinsics.checkNotNullParameter(this$1, "this$1");
                Function1 function1 = this$0.onItemClickedListener;
                if (function1 != null) {
                    function1.invoke(this$0.values.get(this$1.getAbsoluteAdapterPosition()));
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final boolean _init_$lambda$3(RSSArticleListAdapter this$0, ViewHolder this$1, View view) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Intrinsics.checkNotNullParameter(this$1, "this$1");
                Function1 function1 = this$0.onItemLongClickedListener;
                if (function1 == null) {
                    return true;
                }
                function1.invoke(this$0.values.get(this$1.getAbsoluteAdapterPosition()));
                return true;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void _init_$lambda$5(RSSArticleListAdapter this$0, ViewHolder this$1, View view, boolean z) {
                Function2 function2;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Intrinsics.checkNotNullParameter(this$1, "this$1");
                if (!z || (function2 = this$0.onItemSelectedListener) == null) {
                    return;
                }
                function2.invoke(Integer.valueOf(this$1.getAbsoluteAdapterPosition()), this$0.values.get(this$1.getAbsoluteAdapterPosition()));
            }
        }

        public final void setOnItemClicked(Function1<? super RssItem, Unit> onItemClickedListener) {
            Intrinsics.checkNotNullParameter(onItemClickedListener, "onItemClickedListener");
            this.onItemClickedListener = onItemClickedListener;
        }

        public int getItemCount() {
            return this.values.size();
        }

        public long getItemId(int i) {
            return this.values.get(i).getGuid() == null ? i : UUID.fromString(this.values.get(i).getGuid()).getMostSignificantBits() & LongCompanionObject.MAX_VALUE;
        }

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_item_rss_article, viewGroup, false);
            Intrinsics.checkNotNull(viewInflate);
            return new ViewHolder(this, viewInflate);
        }

        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            RssItem rssItem = this.values.get(i);
            viewHolder.getTitle().setText(rssItem.getTitle());
            TextView content = viewHolder.getContent();
            String content2 = rssItem.getContent();
            if (content2 == null && (content2 = rssItem.getDescription()) == null && (content2 = rssItem.getTitle()) == null) {
                content2 = "";
            }
            Spanned spannedFromHtml = Html.fromHtml(new Regex("<img.+?>").replace(content2, ""), 63);
            Intrinsics.checkNotNullExpressionValue(spannedFromHtml, "fromHtml(...)");
            content.setText(StringsKt.trimEnd(StringsKt.trimStart(spannedFromHtml)));
            viewHolder.getDate().setText(rssItem.getPubDate());
            if (rssItem.getImage() == null) {
                Glide.with(this.this$0).clear(viewHolder.getImageView());
            } else {
                Glide.with(this.this$0).load(rssItem.getImage()).transition(DrawableTransitionOptions.withCrossFade()).into(viewHolder.getImageView());
            }
        }
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = getString(R.string.widget_nav_rss_rss_feed);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.rSSFeedString = string;
        String string2 = getString(R.string.widget_nav_rss_to_title);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        this.noTitleString = string2;
        String string3 = getString(R.string.widget_nav_rss_articles_format);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        this.articlesFormatString = string3;
        Application application = requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        this.daijishouWidgetRepository = ((DaijishouApplication) application).getDaijishouWidgetRepository();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        long j = requireArguments().getLong("widgetInstanceId");
        View viewInflate = inflater.inflate(R.layout.widget_nav_fragment_rss, viewGroup, false);
        ConstraintLayout constraintLayoutFindViewById = viewInflate.findViewById(R.id.widget_nav_fragment_rss_title_layout);
        Intrinsics.checkNotNullExpressionValue(constraintLayoutFindViewById, "findViewById(...)");
        this.titleLayout = constraintLayoutFindViewById;
        View viewFindViewById = viewInflate.findViewById(R.id.widget_nav_fragment_rss_title_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.titleTextView = (TextView) viewFindViewById;
        Chip chipFindViewById = viewInflate.findViewById(R.id.widget_nav_fragment_rss_refresh_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById, "findViewById(...)");
        this.refreshButton = chipFindViewById;
        Chip chipFindViewById2 = viewInflate.findViewById(R.id.widget_nav_fragment_rss_articles_count_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById2, "findViewById(...)");
        this.articlesCountButton = chipFindViewById2;
        LinearProgressIndicator linearProgressIndicatorFindViewById = viewInflate.findViewById(R.id.widget_nav_fragment_rss_progressbar);
        Intrinsics.checkNotNullExpressionValue(linearProgressIndicatorFindViewById, "findViewById(...)");
        this.progressbar = linearProgressIndicatorFindViewById;
        RecyclerView recyclerViewFindViewById = viewInflate.findViewById(R.id.widget_nav_fragment_rss_recycler_view);
        Intrinsics.checkNotNullExpressionValue(recyclerViewFindViewById, "findViewById(...)");
        RecyclerView recyclerView = recyclerViewFindViewById;
        this.recyclerView = recyclerView;
        DaijishouWidgetRepository daijishouWidgetRepository = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        recyclerView.setLayoutManager(new DaijishouLinearLayoutManager(contextRequireContext, 1, false));
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        this.recyclerViewAdapter = new RSSArticleListAdapter(this, contextRequireContext2, this.articleList);
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        RSSArticleListAdapter rSSArticleListAdapter = this.recyclerViewAdapter;
        if (rSSArticleListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
            rSSArticleListAdapter = null;
        }
        recyclerView2.setAdapter(rSSArticleListAdapter);
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        recyclerView3.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.magneticchen.daijishou.ui.widget.widgets.rss.RSSWidgetNavFragment.onCreateView.1
            public void onScrollStateChanged(RecyclerView recyclerView4, int i) {
                Intrinsics.checkNotNullParameter(recyclerView4, "recyclerView");
                if (i == 0) {
                    RSSWidgetNavFragment.this.scrollingOnBackPressed = false;
                }
                super.onScrollStateChanged(recyclerView4, i);
            }
        });
        Chip chip = this.refreshButton;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshButton");
            chip = null;
        }
        chip.setTypeface(typeface);
        Chip chip2 = this.articlesCountButton;
        if (chip2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("articlesCountButton");
            chip2 = null;
        }
        chip2.setTypeface((Typeface) null, 1);
        ConstraintLayout constraintLayout = this.titleLayout;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
            constraintLayout = null;
        }
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.widget.widgets.rss.RSSWidgetNavFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RSSWidgetNavFragment.onCreateView$lambda$0(this.f$0, view);
            }
        });
        RSSArticleListAdapter rSSArticleListAdapter2 = this.recyclerViewAdapter;
        if (rSSArticleListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
            rSSArticleListAdapter2 = null;
        }
        rSSArticleListAdapter2.setOnItemClicked(new Function1<RssItem, Unit>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.rss.RSSWidgetNavFragment.onCreateView.3
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RssItem rssItem) {
                invoke2(rssItem);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RssItem it) {
                Intrinsics.checkNotNullParameter(it, "it");
                String sourceUrl = it.getSourceUrl();
                if (sourceUrl == null) {
                    sourceUrl = it.getLink();
                }
                if (sourceUrl != null) {
                    RSSWidgetNavFragment rSSWidgetNavFragment = RSSWidgetNavFragment.this;
                    try {
                        RssChannel rssChannel = null;
                        if (StringsKt.startsWith$default(sourceUrl, "/", false, 2, (Object) null)) {
                            RssChannel rssChannel2 = rSSWidgetNavFragment.channel;
                            if (rssChannel2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("channel");
                            } else {
                                rssChannel = rssChannel2;
                            }
                            sourceUrl = rssChannel.getLink() + sourceUrl;
                        }
                        rSSWidgetNavFragment.requireActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(sourceUrl)));
                    } catch (Exception e) {
                        rSSWidgetNavFragment.getLogger().warn(rSSWidgetNavFragment, ExceptionsKt.stackTraceToString(e));
                        Toast.makeText(rSSWidgetNavFragment.requireContext(), e.getMessage(), 0).show();
                    }
                }
            }
        });
        DaijishouWidgetRepository daijishouWidgetRepository2 = this.daijishouWidgetRepository;
        if (daijishouWidgetRepository2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("daijishouWidgetRepository");
        } else {
            daijishouWidgetRepository = daijishouWidgetRepository2;
        }
        daijishouWidgetRepository.getRSSWidgetInstanceById(j).observe(getViewLifecycleOwner(), new RSSWidgetNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass4()));
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$0(RSSWidgetNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainActivity mainActivityRequireActivity = this$0.requireActivity();
        Intrinsics.checkNotNull(mainActivityRequireActivity, "null cannot be cast to non-null type com.magneticchen.daijishou.ui.activities.MainActivity");
        mainActivityRequireActivity.onBackPressedCallback();
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.widget.widgets.rss.RSSWidgetNavFragment$onCreateView$4, reason: invalid class name */
    /* JADX INFO: compiled from: RSSWidgetNavFragment.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "rssWidgetInstanceEntity", "Lcom/magneticchen/daijishou/data/db/entity/RSSWidgetInstanceEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass4 extends Lambda implements Function1<RSSWidgetInstanceEntity, Unit> {
        AnonymousClass4() {}
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RSSWidgetInstanceEntity rSSWidgetInstanceEntity) {
            invoke2(rSSWidgetInstanceEntity);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(final RSSWidgetInstanceEntity rSSWidgetInstanceEntity) {
            if (rSSWidgetInstanceEntity != null) {
                final LifecycleOwner lifecycleOwner = RSSWidgetNavFragment.this;
                String url = rSSWidgetInstanceEntity.getUrl();
                RSSArticleListAdapter rSSArticleListAdapter = null;
                if (url == null) {
                    TextView textView = ((RSSWidgetNavFragment) lifecycleOwner).titleTextView;
                    if (textView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
                        textView = null;
                    }
                    String str = ((RSSWidgetNavFragment) lifecycleOwner).rSSFeedString;
                    if (str == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("rSSFeedString");
                        str = null;
                    }
                    textView.setText(str);
                    LinearProgressIndicator linearProgressIndicator = ((RSSWidgetNavFragment) lifecycleOwner).progressbar;
                    if (linearProgressIndicator == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("progressbar");
                        linearProgressIndicator = null;
                    }
                    linearProgressIndicator.setIndeterminate(false);
                    LinearProgressIndicator linearProgressIndicator2 = ((RSSWidgetNavFragment) lifecycleOwner).progressbar;
                    if (linearProgressIndicator2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("progressbar");
                        linearProgressIndicator2 = null;
                    }
                    linearProgressIndicator2.setVisibility(8);
                    ((RSSWidgetNavFragment) lifecycleOwner).articleList.clear();
                    RSSArticleListAdapter rSSArticleListAdapter2 = ((RSSWidgetNavFragment) lifecycleOwner).recyclerViewAdapter;
                    if (rSSArticleListAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
                    } else {
                        rSSArticleListAdapter = rSSArticleListAdapter2;
                    }
                    rSSArticleListAdapter.notifyDataSetChanged();
                    return;
                }
                Chip chip = ((RSSWidgetNavFragment) lifecycleOwner).refreshButton;
                if (chip == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("refreshButton");
                    chip = null;
                }
                chip.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.widget.widgets.rss.RSSWidgetNavFragment$onCreateView$4$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        RSSWidgetNavFragment.AnonymousClass4.invoke$lambda$1$lambda$0(lifecycleOwner, rSSWidgetInstanceEntity, view);
                    }
                });
                LinearProgressIndicator linearProgressIndicator3 = ((RSSWidgetNavFragment) lifecycleOwner).progressbar;
                if (linearProgressIndicator3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("progressbar");
                    linearProgressIndicator3 = null;
                }
                linearProgressIndicator3.setIndeterminate(true);
                LinearProgressIndicator linearProgressIndicator4 = ((RSSWidgetNavFragment) lifecycleOwner).progressbar;
                if (linearProgressIndicator4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("progressbar");
                    linearProgressIndicator4 = null;
                }
                linearProgressIndicator4.setVisibility(0);
                BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), Dispatchers.getIO(), (CoroutineStart) null, new RSSWidgetNavFragment$onCreateView$4$1$2(lifecycleOwner, url, null), 2, (Object) null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$1$lambda$0(RSSWidgetNavFragment this$0, RSSWidgetInstanceEntity rSSWidgetInstanceEntity, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this$0), Dispatchers.getIO(), (CoroutineStart) null, new RSSWidgetNavFragment$onCreateView$4$1$1$1(this$0, rSSWidgetInstanceEntity, null), 2, (Object) null);
        }
    }
}
