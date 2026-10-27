package com.magneticchen.daijishou.ui.fragments.settings;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.db.entity.PlatformEntity;
import com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouLinearLayoutManager;
import com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView;
import com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment;
import com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouPreferenceFragment;
import com.magneticchen.daijishou.ui.model.SettingsViewModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: PlatformListSettingsNavFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\u0018\u0000 #2\u00020\u0001:\u0002#$B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0015H\u0016J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\"\u001a\u00020\u0019H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00060\u000fR\u00020\u0000X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006%²\u0006\n\u0010&\u001a\u00020'X\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/settings/PlatformListSettingsNavFragment;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/DaijishouPreferenceFragment;", "()V", "arrayItems", "", "Lcom/magneticchen/daijishou/data/db/entity/PlatformEntity;", "platformDescriptionFormatString", "", "recyclerView", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView;", "getRecyclerView", "()Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView;", "setRecyclerView", "(Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView;)V", "recyclerViewAdapter", "Lcom/magneticchen/daijishou/ui/fragments/settings/PlatformListSettingsNavFragment$DaijishouRecyclerViewAdapter;", "getRecyclerViewAdapter", "()Lcom/magneticchen/daijishou/ui/fragments/settings/PlatformListSettingsNavFragment$DaijishouRecyclerViewAdapter;", "setRecyclerViewAdapter", "(Lcom/magneticchen/daijishou/ui/fragments/settings/PlatformListSettingsNavFragment$DaijishouRecyclerViewAdapter;)V", "scrollingOnBackPressed", "", "titleString", "onBackPressed", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "Companion", "DaijishouRecyclerViewAdapter", "app_release", "settingsModel", "Lcom/magneticchen/daijishou/ui/model/SettingsViewModel;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PlatformListSettingsNavFragment extends DaijishouPreferenceFragment {
    public static final Companion Companion = new Companion(null);
    private final List<PlatformEntity> arrayItems = new ArrayList();
    private String platformDescriptionFormatString;
    public DaijishouRecyclerView recyclerView;
    public DaijishouRecyclerViewAdapter recyclerViewAdapter;
    private boolean scrollingOnBackPressed;
    private String titleString;

    /* JADX INFO: compiled from: PlatformListSettingsNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/settings/PlatformListSettingsNavFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/ui/fragments/settings/PlatformListSettingsNavFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment
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
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\n0\u000bR\u00060\u0000R\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/settings/PlatformListSettingsNavFragment$DaijishouRecyclerViewAdapter;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/data/db/entity/PlatformEntity;", "platformEntityList", "", "(Lcom/magneticchen/daijishou/ui/fragments/settings/PlatformListSettingsNavFragment;Ljava/util/List;)V", "getItemId", "", "position", "", "onCreateViewHolder", "Lcom/magneticchen/daijishou/ui/fragments/settings/PlatformListSettingsNavFragment$DaijishouRecyclerViewAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/fragments/settings/PlatformListSettingsNavFragment;", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_platform, parent, false);
            Intrinsics.checkNotNull(viewInflate);
            return new ViewHolder(this, viewInflate);
        }

        public long getItemId(int i) {
            return this.platformEntityList.get(i).getId();
        }

        /* JADX INFO: compiled from: PlatformListSettingsNavFragment.kt */
        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/settings/PlatformListSettingsNavFragment$DaijishouRecyclerViewAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/data/db/entity/PlatformEntity;", "itemView", "Landroid/view/View;", "(Lcom/magneticchen/daijishou/ui/fragments/settings/PlatformListSettingsNavFragment$DaijishouRecyclerViewAdapter;Landroid/view/View;)V", "text1", "Landroid/widget/TextView;", "text2", "visibleImageView", "Landroid/widget/ImageView;", "onBind", "", "position", "", "item", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

            @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onBind(int i, PlatformEntity item) {
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

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = getString(R.string.platform_list_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.titleString = string;
        String string2 = getString(R.string.platform_description_format);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        this.platformDescriptionFormatString = string2;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.fragment_settings_list_view, viewGroup, false);
        Object objFindViewById = viewInflate.findViewById(R.id.fragment_settings_recycler_view);
        Intrinsics.checkNotNullExpressionValue(objFindViewById, "findViewById(...)");
        setRecyclerView((DaijishouRecyclerView) objFindViewById);
        setRecyclerViewAdapter(new DaijishouRecyclerViewAdapter(this, this.arrayItems));
        getRecyclerView().setAdapter(getRecyclerViewAdapter());
        DaijishouRecyclerView recyclerView = getRecyclerView();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        recyclerView.setLayoutManager((RecyclerView.LayoutManager) new DaijishouLinearLayoutManager(contextRequireContext, 1, false));
        getRecyclerViewAdapter().setOnItemClickListener(new Function4<View, Integer, Long, PlatformEntity, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.PlatformListSettingsNavFragment.onCreateView.1
            

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, Long l, PlatformEntity platformEntity) {
                invoke(view, num.intValue(), l.longValue(), platformEntity);
                return Unit.INSTANCE;
            }

            public final void invoke(View view, int i, long j, PlatformEntity platformEntity) {
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(platformEntity, "platformEntity");
                EditPlatformDialogFragment.Companion.newInstance(platformEntity).show(PlatformListSettingsNavFragment.this.getChildFragmentManager(), EditPlatformDialogFragment.class.getName());
            }
        });
        getRecyclerView().addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.magneticchen.daijishou.ui.fragments.settings.PlatformListSettingsNavFragment.onCreateView.2
            public void onScrollStateChanged(RecyclerView recyclerView2, int i) {
                View view;
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                super.onScrollStateChanged(recyclerView2, i);
                if (i == 0) {
                    PlatformListSettingsNavFragment.this.scrollingOnBackPressed = false;
                    LinearLayoutManager layoutManager = recyclerView2.getLayoutManager();
                    Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                    RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = recyclerView2.findViewHolderForAdapterPosition(layoutManager.findFirstVisibleItemPosition());
                    if (viewHolderFindViewHolderForAdapterPosition != null && (view = viewHolderFindViewHolderForAdapterPosition.itemView) != null) {
                        view.requestFocus();
                    }
                    recyclerView2.removeOnScrollListener(this);
                }
            }
        });
        getDaijishouLibrary().getAllPlatforms().observe(getViewLifecycleOwner(), new PlatformListSettingsNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<List<? extends PlatformEntity>, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.PlatformListSettingsNavFragment.onCreateView.3
            

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
        }));
        return viewInflate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onStart() {
        super.onStart();
        final PlatformListSettingsNavFragment platformListSettingsNavFragment = this;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(SettingsViewModel.class);
        Function0<ViewModelStore> function0 = new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.PlatformListSettingsNavFragment$onStart$$inlined$activityViewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return platformListSettingsNavFragment.requireActivity().getViewModelStore();
            }
        };
        String str = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        SettingsViewModel settingsViewModelOnStart$lambda$0 = onStart$lambda$0(FragmentViewModelLazyKt.createViewModelLazy(platformListSettingsNavFragment, orCreateKotlinClass, function0, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.PlatformListSettingsNavFragment$onStart$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = objArr;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? platformListSettingsNavFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.PlatformListSettingsNavFragment$onStart$$inlined$activityViewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return platformListSettingsNavFragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        }));
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
