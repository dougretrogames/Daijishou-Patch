package com.magneticchen.daijishou.settings_nav_fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.abstract_fragment_classes.DaijishouPreferenceFragment;
import com.magneticchen.daijishou.daijishou_library_db.PlatformEntity;
import com.magneticchen.daijishou.daijishou_recycler_view.DaijishouLinearLayoutManager;
import com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView;
import com.magneticchen.daijishou.dialog_fragments.EditPlatformDialogFragment;
import com.magneticchen.daijishou.view_models.SettingsViewModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: PlatformListSettingsNavFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\u0018\u0000 #2\u00020\u0001:\u0002#$B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0015H\u0016J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\"\u001a\u00020\u0019H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00060\u000fR\u00020\u0000X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006%²\u0006\n\u0010&\u001a\u00020'X\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/settings_nav_fragments/PlatformListSettingsNavFragment;", "Lcom/magneticchen/daijishou/abstract_fragment_classes/DaijishouPreferenceFragment;", "()V", "arrayItems", "", "Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;", "platformDescriptionFormatString", "", "recyclerView", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView;", "getRecyclerView", "()Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView;", "setRecyclerView", "(Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView;)V", "recyclerViewAdapter", "Lcom/magneticchen/daijishou/settings_nav_fragments/PlatformListSettingsNavFragment$DaijishouRecyclerViewAdapter;", "getRecyclerViewAdapter", "()Lcom/magneticchen/daijishou/settings_nav_fragments/PlatformListSettingsNavFragment$DaijishouRecyclerViewAdapter;", "setRecyclerViewAdapter", "(Lcom/magneticchen/daijishou/settings_nav_fragments/PlatformListSettingsNavFragment$DaijishouRecyclerViewAdapter;)V", "scrollingOnBackPressed", "", "titleString", "onBackPressed", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "Companion", "DaijishouRecyclerViewAdapter", "app_release", "settingsModel", "Lcom/magneticchen/daijishou/view_models/SettingsViewModel;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PlatformListSettingsNavFragment extends DaijishouPreferenceFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<PlatformEntity> arrayItems = new ArrayList();
    private String platformDescriptionFormatString;
    public DaijishouRecyclerView recyclerView;
    public DaijishouRecyclerViewAdapter recyclerViewAdapter;
    private boolean scrollingOnBackPressed;
    private String titleString;

    /* JADX INFO: compiled from: PlatformListSettingsNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/magneticchen/daijishou/settings_nav_fragments/PlatformListSettingsNavFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/settings_nav_fragments/PlatformListSettingsNavFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PlatformListSettingsNavFragment newInstance() {
            return new PlatformListSettingsNavFragment();
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

    public final DaijishouRecyclerViewAdapter getRecyclerViewAdapter() {
        DaijishouRecyclerViewAdapter daijishouRecyclerViewAdapter = this.recyclerViewAdapter;
        if (daijishouRecyclerViewAdapter != null) {
            return daijishouRecyclerViewAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
        return null;
    }

    public final void setRecyclerViewAdapter(DaijishouRecyclerViewAdapter daijishouRecyclerViewAdapter) {
        Intrinsics.checkNotNullParameter(daijishouRecyclerViewAdapter, "<set-?>");
        this.recyclerViewAdapter = daijishouRecyclerViewAdapter;
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment
    public boolean onBackPressed() {
        if ((this.scrollingOnBackPressed && getRecyclerView().getScrollState() == 2) || getRecyclerView().computeVerticalScrollOffset() == 0) {
            getRecyclerView().scrollToPosition(0);
            return true;
        }
        this.scrollingOnBackPressed = true;
        getRecyclerView().smoothScrollToPosition(0);
        return false;
    }

    /* JADX INFO: compiled from: PlatformListSettingsNavFragment.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\n0\u000bR\u00060\u0000R\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/magneticchen/daijishou/settings_nav_fragments/PlatformListSettingsNavFragment$DaijishouRecyclerViewAdapter;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;", "platformEntityList", "", "(Lcom/magneticchen/daijishou/settings_nav_fragments/PlatformListSettingsNavFragment;Ljava/util/List;)V", "getItemId", "", "position", "", "onCreateViewHolder", "Lcom/magneticchen/daijishou/settings_nav_fragments/PlatformListSettingsNavFragment$DaijishouRecyclerViewAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/settings_nav_fragments/PlatformListSettingsNavFragment;", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class DaijishouRecyclerViewAdapter extends DaijishouRecyclerView.Adapter<PlatformEntity> {
        private final List<PlatformEntity> platformEntityList;
        final /* synthetic */ PlatformListSettingsNavFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DaijishouRecyclerViewAdapter(PlatformListSettingsNavFragment platformListSettingsNavFragment, List<PlatformEntity> platformEntityList) {
            super(platformEntityList, false, false, 6, null);
            Intrinsics.checkNotNullParameter(platformEntityList, "platformEntityList");
            this.this$0 = platformListSettingsNavFragment;
            this.platformEntityList = platformEntityList;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_platform, parent, false);
            Intrinsics.checkNotNull(viewInflate);
            return new ViewHolder(this, viewInflate);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int position) {
            return this.platformEntityList.get(position).getId();
        }

        /* JADX INFO: compiled from: PlatformListSettingsNavFragment.kt */
        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/magneticchen/daijishou/settings_nav_fragments/PlatformListSettingsNavFragment$DaijishouRecyclerViewAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;", "itemView", "Landroid/view/View;", "(Lcom/magneticchen/daijishou/settings_nav_fragments/PlatformListSettingsNavFragment$DaijishouRecyclerViewAdapter;Landroid/view/View;)V", "text1", "Landroid/widget/TextView;", "text2", "visibleImageView", "Landroid/widget/ImageView;", "onBind", "", "position", "", "item", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public final class ViewHolder extends DaijishouRecyclerView.Adapter<PlatformEntity>.ViewHolder {
            private final TextView text1;
            private final TextView text2;
            final /* synthetic */ DaijishouRecyclerViewAdapter this$0;
            private final ImageView visibleImageView;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(DaijishouRecyclerViewAdapter daijishouRecyclerViewAdapter, View itemView) {
                super(daijishouRecyclerViewAdapter, itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                this.this$0 = daijishouRecyclerViewAdapter;
                View viewFindViewById = itemView.findViewById(R.id.list_item_platform_first_line);
                Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
                this.text1 = (TextView) viewFindViewById;
                View viewFindViewById2 = itemView.findViewById(R.id.list_item_platform_second_line);
                Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.TextView");
                this.text2 = (TextView) viewFindViewById2;
                View viewFindViewById3 = itemView.findViewById(R.id.list_item_platform_visible_image_view);
                Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.ImageView");
                this.visibleImageView = (ImageView) viewFindViewById3;
            }

            @Override // com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onBind(int position, PlatformEntity item) {
                Intrinsics.checkNotNullParameter(item, "item");
                this.text1.setText(item.getName());
                TextView textView = this.text2;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = this.this$0.this$0.platformDescriptionFormatString;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("platformDescriptionFormatString");
                    str = null;
                }
                String shortname = item.getShortname();
                Locale ROOT = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                String upperCase = shortname.toUpperCase(ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                String str2 = String.format(str, Arrays.copyOf(new Object[]{upperCase, Integer.valueOf(item.getPlayerIdList().size())}, 2));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                textView.setText(str2);
                this.visibleImageView.setVisibility(item.isVisible() ? 0 : 8);
            }
        }
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String string = getString(R.string.platform_list_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.titleString = string;
        String string2 = getString(R.string.platform_description_format);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        this.platformDescriptionFormatString = string2;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.fragment_settings_list_view, container, false);
        View viewFindViewById = viewInflate.findViewById(R.id.fragment_settings_recycler_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        setRecyclerView((DaijishouRecyclerView) viewFindViewById);
        setRecyclerViewAdapter(new DaijishouRecyclerViewAdapter(this, this.arrayItems));
        getRecyclerView().setAdapter(getRecyclerViewAdapter());
        DaijishouRecyclerView recyclerView = getRecyclerView();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        recyclerView.setLayoutManager(new DaijishouLinearLayoutManager(contextRequireContext, 1, false));
        getRecyclerViewAdapter().setOnItemClickListener(new AnonymousClass1());
        getRecyclerView().addOnScrollListener(new AnonymousClass2());
        getDaijishouLibrary().getAllPlatforms().observe(getViewLifecycleOwner(), new PlatformListSettingsNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass3()));
        return viewInflate;
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.settings_nav_fragments.PlatformListSettingsNavFragment$onCreateView$1, reason: invalid class name */
    /* JADX INFO: compiled from: PlatformListSettingsNavFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", "platformEntity", "Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass1 extends Lambda<Unit> implements Function4<View, Integer, Long, PlatformEntity, Unit> {
        AnonymousClass1() {
            super(4);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, Long l, PlatformEntity platformEntity) {
            invoke(view, num.intValue(), l.longValue(), platformEntity);
            return Unit.INSTANCE;
        }

        public final void invoke(View view, int i, long j, PlatformEntity platformEntity) {
            Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(platformEntity, "platformEntity");
            EditPlatformDialogFragment.INSTANCE.newInstance(platformEntity).show(PlatformListSettingsNavFragment.this.getChildFragmentManager(), EditPlatformDialogFragment.class.getName());
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.settings_nav_fragments.PlatformListSettingsNavFragment$onCreateView$2, reason: invalid class name */
    /* JADX INFO: compiled from: PlatformListSettingsNavFragment.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/magneticchen/daijishou/settings_nav_fragments/PlatformListSettingsNavFragment$onCreateView$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class AnonymousClass2 extends RecyclerView.OnScrollListener {
        AnonymousClass2() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            View view;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                PlatformListSettingsNavFragment.this.scrollingOnBackPressed = false;
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition());
                if (viewHolderFindViewHolderForAdapterPosition != null && (view = viewHolderFindViewHolderForAdapterPosition.itemView) != null) {
                    view.requestFocus();
                }
                recyclerView.removeOnScrollListener(this);
            }
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.settings_nav_fragments.PlatformListSettingsNavFragment$onCreateView$3, reason: invalid class name */
    /* JADX INFO: compiled from: PlatformListSettingsNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "platformEntityList", "", "Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass3 extends Lambda<Unit> implements Function1<List<? extends PlatformEntity>, Unit> {
        AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends PlatformEntity> list) {
            invoke2((List<PlatformEntity>) list);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<PlatformEntity> list) {
            PlatformListSettingsNavFragment.this.arrayItems.clear();
            List list2 = PlatformListSettingsNavFragment.this.arrayItems;
            Intrinsics.checkNotNull(list);
            list2.addAll(list);
            PlatformListSettingsNavFragment.this.getRecyclerViewAdapter().notifyDataSetChanged();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        PlatformListSettingsNavFragment platformListSettingsNavFragment = this;
        String str = null;
        SettingsViewModel settingsViewModelOnStart$lambda$0 = onStart$lambda$0(FragmentViewModelLazyKt.createViewModelLazy(platformListSettingsNavFragment, Reflection.getOrCreateKotlinClass(SettingsViewModel.class), new PlatformListSettingsNavFragment$onStart$$inlined$activityViewModels$default$1(platformListSettingsNavFragment), new PlatformListSettingsNavFragment$onStart$$inlined$activityViewModels$default$2(null, platformListSettingsNavFragment), new PlatformListSettingsNavFragment$onStart$$inlined$activityViewModels$default$3(platformListSettingsNavFragment)));
        String str2 = this.titleString;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleString");
        } else {
            str = str2;
        }
        settingsViewModelOnStart$lambda$0.setTitle(str);
        getRecyclerView().requestFocus();
    }

    private static final SettingsViewModel onStart$lambda$0(Lazy<SettingsViewModel> lazy) {
        return lazy.getValue();
    }
}
