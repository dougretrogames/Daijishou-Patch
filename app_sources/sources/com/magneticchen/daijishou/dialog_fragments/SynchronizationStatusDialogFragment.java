package com.magneticchen.daijishou.dialog_fragments;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.chip.Chip;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment;
import com.magneticchen.daijishou.activities.MainActivity;
import com.magneticchen.daijishou.daijishou_library_db.PlatformEntity;
import com.magneticchen.daijishou.daijishou_recycler_view.DaijishouLinearLayoutManager;
import com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView;
import com.magneticchen.daijishou.view_models.SynchronizationOfPlatform;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: SynchronizationStatusDialogFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0002%&B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\fH\u0016J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010!\u001a\u00020\u0018H\u0016J\b\u0010\"\u001a\u00020\u0018H\u0016J\u001a\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u001c2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00060\bR\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/magneticchen/daijishou/dialog_fragments/SynchronizationStatusDialogFragment;", "Lcom/magneticchen/daijishou/abstract_fragment_classes/DaijishouDialogFragment;", "()V", "progressBar", "Landroid/widget/ProgressBar;", "recyclerView", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView;", "recyclerViewAdapter", "Lcom/magneticchen/daijishou/dialog_fragments/SynchronizationStatusDialogFragment$SynchronizationOfPlatformListAdapter;", "root", "Landroidx/constraintlayout/widget/ConstraintLayout;", "scrollingOnBackPressed", "", "subtitleTextView", "Landroid/widget/TextView;", "syncChip", "Lcom/google/android/material/chip/Chip;", "synchronizationOfPlatformList", "", "Lcom/magneticchen/daijishou/view_models/SynchronizationOfPlatform;", "titleLayout", "titleTextView", "onBackPressed", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onResume", "onStart", "onViewCreated", "view", "Companion", "SynchronizationOfPlatformListAdapter", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SynchronizationStatusDialogFragment extends DaijishouDialogFragment {

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private ProgressBar progressBar;
    private DaijishouRecyclerView recyclerView;
    private SynchronizationOfPlatformListAdapter recyclerViewAdapter;
    private ConstraintLayout root;
    private boolean scrollingOnBackPressed;
    private TextView subtitleTextView;
    private Chip syncChip;
    private List<SynchronizationOfPlatform> synchronizationOfPlatformList = new ArrayList();
    private ConstraintLayout titleLayout;
    private TextView titleTextView;

    /* INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2() {
    }

    /* INFO: compiled from: SynchronizationStatusDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/magneticchen/daijishou/dialog_fragments/SynchronizationStatusDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/dialog_fragments/SynchronizationStatusDialogFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SynchronizationStatusDialogFragment newInstance() {
            SynchronizationStatusDialogFragment synchronizationStatusDialogFragment = new SynchronizationStatusDialogFragment();
            synchronizationStatusDialogFragment.setArguments(new Bundle());
            return synchronizationStatusDialogFragment;
        }
    }

    /* WARN: Code duplicated, block: B:11:0x001e  */
    /* WARN: Code duplicated, block: B:32:0x005c  */
    /* WARN: Code duplicated, block: B:34:0x0062  */
    /* WARN: Code duplicated, block: B:37:0x006d  */
    /* WARN: Code duplicated, block: B:38:0x0071  */
    /* WARN: Code duplicated, block: B:9:0x001a  */
    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment
    public boolean onBackPressed() {
        DaijishouRecyclerView daijishouRecyclerView;
        ConstraintLayout constraintLayout;
        DaijishouRecyclerView daijishouRecyclerView2;
        DaijishouRecyclerView daijishouRecyclerView3 = null;
        ConstraintLayout constraintLayout2 = null;
        if (this.scrollingOnBackPressed) {
            DaijishouRecyclerView daijishouRecyclerView4 = this.recyclerView;
            if (daijishouRecyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                daijishouRecyclerView4 = null;
            }
            if (daijishouRecyclerView4.getScrollState() != 2) {
                daijishouRecyclerView = this.recyclerView;
                if (daijishouRecyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    daijishouRecyclerView = null;
                }
                if (daijishouRecyclerView.computeVerticalScrollOffset() != 0) {
                    this.scrollingOnBackPressed = true;
                    constraintLayout = this.titleLayout;
                    if (constraintLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
                        constraintLayout = null;
                    }
                    constraintLayout.requestFocus();
                    daijishouRecyclerView2 = this.recyclerView;
                    if (daijishouRecyclerView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    } else {
                        daijishouRecyclerView3 = daijishouRecyclerView2;
                    }
                    daijishouRecyclerView3.smoothScrollToPosition(0);
                    return false;
                }
            }
        } else {
            daijishouRecyclerView = this.recyclerView;
            if (daijishouRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                daijishouRecyclerView = null;
            }
            if (daijishouRecyclerView.computeVerticalScrollOffset() != 0) {
                this.scrollingOnBackPressed = true;
                constraintLayout = this.titleLayout;
                if (constraintLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
                    constraintLayout = null;
                }
                constraintLayout.requestFocus();
                daijishouRecyclerView2 = this.recyclerView;
                if (daijishouRecyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                } else {
                    daijishouRecyclerView3 = daijishouRecyclerView2;
                }
                daijishouRecyclerView3.smoothScrollToPosition(0);
                return false;
            }
        }
        DaijishouRecyclerView daijishouRecyclerView5 = this.recyclerView;
        if (daijishouRecyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            daijishouRecyclerView5 = null;
        }
        daijishouRecyclerView5.scrollToPosition(0);
        ConstraintLayout constraintLayout3 = this.titleLayout;
        if (constraintLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
            constraintLayout3 = null;
        }
        if (constraintLayout3.isFocused()) {
            return true;
        }
        ConstraintLayout constraintLayout4 = this.titleLayout;
        if (constraintLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
            constraintLayout4 = null;
        }
        constraintLayout4.requestFocus();
        ConstraintLayout constraintLayout5 = this.titleLayout;
        if (constraintLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
        } else {
            constraintLayout2 = constraintLayout5;
        }
        return !constraintLayout2.isFocused();
    }

    /* INFO: compiled from: SynchronizationStatusDialogFragment.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\"\u0010\n\u001a\f0\u000bR\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/magneticchen/daijishou/dialog_fragments/SynchronizationStatusDialogFragment$SynchronizationOfPlatformListAdapter;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/view_models/SynchronizationOfPlatform;", "synchronizationOfPlatformList", "", "(Lcom/magneticchen/daijishou/dialog_fragments/SynchronizationStatusDialogFragment;Ljava/util/List;)V", "getItemId", "", "position", "", "onCreateViewHolder", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class SynchronizationOfPlatformListAdapter extends DaijishouRecyclerView.Adapter<SynchronizationOfPlatform> {
        private final List<SynchronizationOfPlatform> synchronizationOfPlatformList;
        final /* synthetic */ SynchronizationStatusDialogFragment this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SynchronizationOfPlatformListAdapter(SynchronizationStatusDialogFragment synchronizationStatusDialogFragment, List<SynchronizationOfPlatform> synchronizationOfPlatformList) {
            super(synchronizationOfPlatformList, false, false, 6, null);
            Intrinsics.checkNotNullParameter(synchronizationOfPlatformList, "synchronizationOfPlatformList");
            this.this$0 = synchronizationStatusDialogFragment;
            this.synchronizationOfPlatformList = synchronizationOfPlatformList;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int position) {
            return this.synchronizationOfPlatformList.get(position).getPlatformId();
        }

        /* INFO: compiled from: SynchronizationStatusDialogFragment.kt */
        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003H\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \t*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \t*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \t*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \t*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/magneticchen/daijishou/dialog_fragments/SynchronizationStatusDialogFragment$SynchronizationOfPlatformListAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/view_models/SynchronizationOfPlatform;", "itemView", "Landroid/view/View;", "(Lcom/magneticchen/daijishou/dialog_fragments/SynchronizationStatusDialogFragment$SynchronizationOfPlatformListAdapter;Landroid/view/View;)V", "addingToLibraryImageView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "completedImageView", "firstLine", "Landroid/widget/TextView;", "scrapingImageView", "secondLine", "syncingImageView", "thirdLine", "timestamp", "onBind", "", "position", "", "item", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public final class ViewHolder extends DaijishouRecyclerView.Adapter<SynchronizationOfPlatform>.ViewHolder {
            private final ImageView addingToLibraryImageView;
            private final ImageView completedImageView;
            private final TextView firstLine;
            private final ImageView scrapingImageView;
            private final TextView secondLine;
            private final ImageView syncingImageView;
            private final TextView thirdLine;
            final /* synthetic */ SynchronizationOfPlatformListAdapter this$0;
            private final TextView timestamp;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(SynchronizationOfPlatformListAdapter synchronizationOfPlatformListAdapter, View itemView) {
                super(synchronizationOfPlatformListAdapter, itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                this.this$0 = synchronizationOfPlatformListAdapter;
                this.firstLine = (TextView) itemView.findViewById(R.id.list_item_synchronization_status_first_line);
                this.secondLine = (TextView) itemView.findViewById(R.id.list_item_synchronization_status_second_line);
                this.thirdLine = (TextView) itemView.findViewById(R.id.list_item_synchronization_status_third_line);
                this.timestamp = (TextView) itemView.findViewById(R.id.list_item_synchronization_status_third_line);
                this.syncingImageView = (ImageView) itemView.findViewById(R.id.list_item_synchronization_status_syncing_image_view);
                this.completedImageView = (ImageView) itemView.findViewById(R.id.list_item_synchronization_status_completed_image_view);
                this.addingToLibraryImageView = (ImageView) itemView.findViewById(R.id.list_item_synchronization_status_adding_to_library_image_view);
                this.scrapingImageView = (ImageView) itemView.findViewById(R.id.list_item_synchronization_status_scraping_image_view);
            }

            @Override // com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onBind(int position, SynchronizationOfPlatform item) {
                String string;
                Intrinsics.checkNotNullParameter(item, "item");
                TextView textView = this.firstLine;
                PlatformEntity platformByIdStatically = this.this$0.this$0.getDaijishouLibrary().getPlatformByIdStatically(item.getPlatformId());
                if (platformByIdStatically == null || (string = platformByIdStatically.getName()) == null) {
                    string = this.this$0.this$0.getString(R.string.unknown_status);
                }
                textView.setText(string);
                int statusCode = item.getStatusCode();
                if (statusCode == 0) {
                    this.secondLine.setText(this.this$0.this$0.getString(R.string.not_syncing));
                } else if (statusCode == 1) {
                    this.secondLine.setText(this.this$0.this$0.getString(R.string.preparing_synchronization));
                } else if (statusCode == 2) {
                    this.secondLine.setText(this.this$0.this$0.getString(R.string.syncing_library));
                } else if (statusCode == 3) {
                    this.secondLine.setText(this.this$0.this$0.getString(R.string.aggregating));
                } else if (statusCode == 4) {
                    this.secondLine.setText(this.this$0.this$0.getString(R.string.scraping));
                } else {
                    this.secondLine.setText(this.this$0.this$0.getString(R.string.unknown_status));
                }
                this.thirdLine.setText(item.getStatusString());
                this.syncingImageView.setVisibility(item.getStatusCode() == 1 ? 0 : 8);
                this.completedImageView.setVisibility(8);
                this.addingToLibraryImageView.setVisibility((item.getStatusCode() == 2 || item.getStatusCode() == 3) ? 0 : 8);
                this.scrapingImageView.setVisibility(item.getStatusCode() != 4 ? 8 : 0);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public DaijishouRecyclerView.Adapter<SynchronizationOfPlatform>.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_synchronization_status, viewGroup, false);
            Intrinsics.checkNotNull(viewInflate);
            return new ViewHolder(this, viewInflate);
        }
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intrinsics.checkNotNullExpressionValue(requireContext(), "requireContext(...)");
        Intrinsics.checkNotNullExpressionValue(requireArguments(), "requireArguments(...)");
        Intrinsics.checkNotNullExpressionValue(requireActivity(), "requireActivity(...)");
        this.synchronizationOfPlatformList.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        Intrinsics.checkNotNullExpressionValue(requireContext(), "requireContext(...)");
        View viewInflate = inflater.inflate(R.layout.fragment_sychronization_status, container, false);
        View viewFindViewById = viewInflate.findViewById(R.id.fragment_synchronization_status_root);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.root = (ConstraintLayout) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.fragment_synchronization_status_recycler_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.recyclerView = (DaijishouRecyclerView) viewFindViewById2;
        this.recyclerViewAdapter = new SynchronizationOfPlatformListAdapter(this, this.synchronizationOfPlatformList);
        View viewFindViewById3 = viewInflate.findViewById(R.id.fragment_synchronization_status_progress_bar);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.progressBar = (ProgressBar) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(R.id.fragment_synchronization_status_sync_chip);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.syncChip = (Chip) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(R.id.fragment_synchronization_status_title_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.titleLayout = (ConstraintLayout) viewFindViewById5;
        View viewFindViewById6 = viewInflate.findViewById(R.id.fragment_synchronization_status_title);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.titleTextView = (TextView) viewFindViewById6;
        View viewFindViewById7 = viewInflate.findViewById(R.id.fragment_synchronization_status_subtitle);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.subtitleTextView = (TextView) viewFindViewById7;
        DaijishouRecyclerView daijishouRecyclerView = this.recyclerView;
        Chip chip = null;
        if (daijishouRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            daijishouRecyclerView = null;
        }
        SynchronizationOfPlatformListAdapter synchronizationOfPlatformListAdapter = this.recyclerViewAdapter;
        if (synchronizationOfPlatformListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
            synchronizationOfPlatformListAdapter = null;
        }
        daijishouRecyclerView.setAdapter(synchronizationOfPlatformListAdapter);
        DaijishouRecyclerView daijishouRecyclerView2 = this.recyclerView;
        if (daijishouRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            daijishouRecyclerView2 = null;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        daijishouRecyclerView2.setLayoutManager(new DaijishouLinearLayoutManager(contextRequireContext, 1, false));
        DaijishouRecyclerView daijishouRecyclerView3 = this.recyclerView;
        if (daijishouRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            daijishouRecyclerView3 = null;
        }
        daijishouRecyclerView3.setItemAnimator(null);
        DaijishouRecyclerView daijishouRecyclerView4 = this.recyclerView;
        if (daijishouRecyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            daijishouRecyclerView4 = null;
        }
        daijishouRecyclerView4.addOnScrollListener(new AnonymousClass1());
        ConstraintLayout constraintLayout = this.titleLayout;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
            constraintLayout = null;
        }
        constraintLayout.setOnClickListener(new SynchronizationStatusDialogFragment$$ExternalSyntheticLambda1(this));
        Chip chip2 = this.syncChip;
        if (chip2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("syncChip");
        } else {
            chip = chip2;
        }
        chip.setOnClickListener(new SynchronizationStatusDialogFragment$$ExternalSyntheticLambda2(this, fragmentActivityRequireActivity));
        SynchronizationStatusDialogFragment synchronizationStatusDialogFragment = this;
        getDaijishouSynchronization().getStatusLiveData().observe(synchronizationStatusDialogFragment, new SynchronizationStatusDialogFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass4()));
        getDaijishouSynchronization().getSynchronizationOfPlatformListLiveData().observe(synchronizationStatusDialogFragment, new SynchronizationStatusDialogFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass5()));
        return viewInflate;
    }

    /* INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.SynchronizationStatusDialogFragment$onCreateView$1, reason: invalid class name */
    /* INFO: compiled from: SynchronizationStatusDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/magneticchen/daijishou/dialog_fragments/SynchronizationStatusDialogFragment$onCreateView$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class AnonymousClass1 extends RecyclerView.OnScrollListener {
        AnonymousClass1() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0) {
                SynchronizationStatusDialogFragment.this.scrollingOnBackPressed = false;
            }
            super.onScrollStateChanged(recyclerView, newState);
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$0(SynchronizationStatusDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.requireDialog().onBackPressed();
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$1(SynchronizationStatusDialogFragment this$0, FragmentActivity activity, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        this$0.getDaijishouSynchronization().scheduleSynchronizationOfAllPlatforms((AppCompatActivity) activity);
    }

    /* INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.SynchronizationStatusDialogFragment$onCreateView$4, reason: invalid class name */
    /* INFO: compiled from: SynchronizationStatusDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass4 extends Lambda<Unit> implements Function1<Integer, Unit> {
        AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke2(num);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Integer num) {
            SynchronizationStatusDialogFragment synchronizationStatusDialogFragment;
            int i;
            Chip chip = null;
            if (num != null && num.intValue() == 0) {
                TextView textView = SynchronizationStatusDialogFragment.this.subtitleTextView;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("subtitleTextView");
                    textView = null;
                }
                textView.setText(SynchronizationStatusDialogFragment.this.getString(R.string.not_syncing));
            } else if (num != null && num.intValue() == 1) {
                TextView textView2 = SynchronizationStatusDialogFragment.this.subtitleTextView;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("subtitleTextView");
                    textView2 = null;
                }
                textView2.setText(SynchronizationStatusDialogFragment.this.getString(R.string.preparing_synchronization));
            } else if (num != null && num.intValue() == 2) {
                TextView textView3 = SynchronizationStatusDialogFragment.this.subtitleTextView;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("subtitleTextView");
                    textView3 = null;
                }
                textView3.setText(SynchronizationStatusDialogFragment.this.getString(R.string.updating_platforms));
            } else if (num != null && num.intValue() == 3) {
                TextView textView4 = SynchronizationStatusDialogFragment.this.subtitleTextView;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("subtitleTextView");
                    textView4 = null;
                }
                textView4.setText(SynchronizationStatusDialogFragment.this.getString(R.string.syncing_library));
            } else if (num != null && num.intValue() == 4) {
                TextView textView5 = SynchronizationStatusDialogFragment.this.subtitleTextView;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("subtitleTextView");
                    textView5 = null;
                }
                textView5.setText(SynchronizationStatusDialogFragment.this.getString(R.string.backing_up));
            } else if (num != null && num.intValue() == 5) {
                TextView textView6 = SynchronizationStatusDialogFragment.this.subtitleTextView;
                if (textView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("subtitleTextView");
                    textView6 = null;
                }
                textView6.setText(SynchronizationStatusDialogFragment.this.getString(R.string.generating_backup_data));
            } else if (num != null && num.intValue() == 6) {
                TextView textView7 = SynchronizationStatusDialogFragment.this.subtitleTextView;
                if (textView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("subtitleTextView");
                    textView7 = null;
                }
                textView7.setText(SynchronizationStatusDialogFragment.this.getString(R.string.uploading_backup_data));
            } else if (num != null && num.intValue() == 99) {
                TextView textView8 = SynchronizationStatusDialogFragment.this.subtitleTextView;
                if (textView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("subtitleTextView");
                    textView8 = null;
                }
                textView8.setText(SynchronizationStatusDialogFragment.this.getString(R.string.finishing));
            } else if (num != null && num.intValue() == 997) {
                TextView textView9 = SynchronizationStatusDialogFragment.this.subtitleTextView;
                if (textView9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("subtitleTextView");
                    textView9 = null;
                }
                textView9.setText(SynchronizationStatusDialogFragment.this.getString(R.string.restoring));
            } else if (num != null && num.intValue() == 998) {
                TextView textView10 = SynchronizationStatusDialogFragment.this.subtitleTextView;
                if (textView10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("subtitleTextView");
                    textView10 = null;
                }
                textView10.setText(SynchronizationStatusDialogFragment.this.getString(R.string.downloading_backup_data));
            } else if (num != null && num.intValue() == 999) {
                TextView textView11 = SynchronizationStatusDialogFragment.this.subtitleTextView;
                if (textView11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("subtitleTextView");
                    textView11 = null;
                }
                textView11.setText(SynchronizationStatusDialogFragment.this.getString(R.string.restoring_backup_data));
            } else {
                TextView textView12 = SynchronizationStatusDialogFragment.this.subtitleTextView;
                if (textView12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("subtitleTextView");
                    textView12 = null;
                }
                textView12.setText(SynchronizationStatusDialogFragment.this.getString(R.string.unknown_status));
            }
            ProgressBar progressBar = SynchronizationStatusDialogFragment.this.progressBar;
            if (progressBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                progressBar = null;
            }
            progressBar.setVisibility((num != null && num.intValue() == 0) ? 8 : 0);
            Chip chip2 = SynchronizationStatusDialogFragment.this.syncChip;
            if (chip2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("syncChip");
                chip2 = null;
            }
            if (num != null && num.intValue() == 0) {
                synchronizationStatusDialogFragment = SynchronizationStatusDialogFragment.this;
                i = R.string.sync;
            } else {
                synchronizationStatusDialogFragment = SynchronizationStatusDialogFragment.this;
                i = R.string.syncing;
            }
            chip2.setText(synchronizationStatusDialogFragment.getString(i));
            Chip chip3 = SynchronizationStatusDialogFragment.this.syncChip;
            if (chip3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("syncChip");
            } else {
                chip = chip3;
            }
            chip.setEnabled(num != null && num.intValue() == 0);
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.SynchronizationStatusDialogFragment$onCreateView$5, reason: invalid class name */
    /* INFO: compiled from: SynchronizationStatusDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "Lcom/magneticchen/daijishou/view_models/SynchronizationOfPlatform;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass5 extends Lambda<Unit> implements Function1<List<SynchronizationOfPlatform>, Unit> {
        AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<SynchronizationOfPlatform> list) {
            invoke2(list);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<SynchronizationOfPlatform> list) {
            Intrinsics.checkNotNull(list);
            List<SynchronizationOfPlatform> list2 = list;
            SynchronizationStatusDialogFragment synchronizationStatusDialogFragment = SynchronizationStatusDialogFragment.this;
            Iterator it = list2.iterator();
            while (true) {
                SynchronizationOfPlatformListAdapter synchronizationOfPlatformListAdapter = null;
                boolean z = false;
                if (!it.hasNext()) {
                    break;
                }
                SynchronizationOfPlatform synchronizationOfPlatform = (SynchronizationOfPlatform) it.next();
                int i = 0;
                for (Object obj : synchronizationStatusDialogFragment.synchronizationOfPlatformList) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    if (synchronizationOfPlatform.getPlatformId() == ((SynchronizationOfPlatform) obj).getPlatformId()) {
                        synchronizationStatusDialogFragment.synchronizationOfPlatformList.set(i, synchronizationOfPlatform);
                        SynchronizationOfPlatformListAdapter synchronizationOfPlatformListAdapter2 = synchronizationStatusDialogFragment.recyclerViewAdapter;
                        if (synchronizationOfPlatformListAdapter2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
                            synchronizationOfPlatformListAdapter2 = null;
                        }
                        synchronizationOfPlatformListAdapter2.notifyItemChanged(i);
                        z = true;
                    }
                    i = i2;
                }
                if (!z) {
                    synchronizationStatusDialogFragment.synchronizationOfPlatformList.add(synchronizationOfPlatform);
                    SynchronizationOfPlatformListAdapter synchronizationOfPlatformListAdapter3 = synchronizationStatusDialogFragment.recyclerViewAdapter;
                    if (synchronizationOfPlatformListAdapter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
                    } else {
                        synchronizationOfPlatformListAdapter = synchronizationOfPlatformListAdapter3;
                    }
                    synchronizationOfPlatformListAdapter.notifyItemInserted(synchronizationStatusDialogFragment.synchronizationOfPlatformList.size() - 1);
                }
            }
            ArrayList<SynchronizationOfPlatform> arrayList = new ArrayList();
            int i3 = 0;
            for (Object obj2 : SynchronizationStatusDialogFragment.this.synchronizationOfPlatformList) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                SynchronizationOfPlatform synchronizationOfPlatform2 = (SynchronizationOfPlatform) obj2;
                Iterator it2 = list2.iterator();
                boolean z2 = false;
                while (it2.hasNext()) {
                    if (synchronizationOfPlatform2.getPlatformId() == ((SynchronizationOfPlatform) it2.next()).getPlatformId()) {
                        z2 = true;
                    }
                }
                if (!z2) {
                    arrayList.add(synchronizationOfPlatform2);
                }
                i3 = i4;
            }
            SynchronizationStatusDialogFragment synchronizationStatusDialogFragment2 = SynchronizationStatusDialogFragment.this;
            for (SynchronizationOfPlatform synchronizationOfPlatform3 : arrayList) {
                int i5 = -1;
                int i6 = 0;
                for (Object obj3 : synchronizationStatusDialogFragment2.synchronizationOfPlatformList) {
                    int i7 = i6 + 1;
                    if (i6 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    if (synchronizationOfPlatform3.getPlatformId() == ((SynchronizationOfPlatform) obj3).getPlatformId()) {
                        i5 = i6;
                    }
                    i6 = i7;
                }
                if (i5 >= 0) {
                    synchronizationStatusDialogFragment2.synchronizationOfPlatformList.remove(i5);
                    SynchronizationOfPlatformListAdapter synchronizationOfPlatformListAdapter4 = synchronizationStatusDialogFragment2.recyclerViewAdapter;
                    if (synchronizationOfPlatformListAdapter4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
                        synchronizationOfPlatformListAdapter4 = null;
                    }
                    synchronizationOfPlatformListAdapter4.notifyItemRemoved(i5);
                }
            }
        }
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        Dialog dialogRequireDialog = requireDialog();
        Intrinsics.checkNotNullExpressionValue(dialogRequireDialog, "requireDialog(...)");
        super.onViewCreated(view, savedInstanceState);
        view.requestFocus();
        ConstraintLayout constraintLayout = this.root;
        ConstraintLayout constraintLayout2 = null;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            constraintLayout = null;
        }
        ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams).setMargins(getDpToPxConverter().convert(12.0f), getDpToPxConverter().convert(12.0f), getDpToPxConverter().convert(12.0f), getDpToPxConverter().convert(12.0f));
        ConstraintLayout constraintLayout3 = this.root;
        if (constraintLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
        } else {
            constraintLayout2 = constraintLayout3;
        }
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.roundest_full_screen_dialog, contextRequireContext.getTheme());
        Intrinsics.checkNotNull(drawable);
        constraintLayout2.setBackground(drawable);
        Window window = dialogRequireDialog.getWindow();
        Intrinsics.checkNotNull(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        Window window2 = dialogRequireDialog.getWindow();
        if (window2 != null) {
            window2.setWindowAnimations(R.style.FullScreenDialogAnimation);
        }
        new Handler(Looper.getMainLooper()).postDelayed(new SynchronizationStatusDialogFragment$$ExternalSyntheticLambda0(), getResources().getInteger(android.R.integer.config_shortAnimTime));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialogRequireDialog = requireDialog();
        Intrinsics.checkNotNullExpressionValue(dialogRequireDialog, "requireDialog(...)");
        Window window = dialogRequireDialog.getWindow();
        if (window != null) {
            window.setLayout(-1, -1);
        }
        Window window2 = dialogRequireDialog.getWindow();
        if (window2 != null) {
            window2.setFlags(1024, 1024);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Window window = requireDialog().getWindow();
        Intrinsics.checkNotNull(window);
        window.getWindowManager().updateViewLayout(window.getDecorView(), window.getAttributes());
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.magneticchen.daijishou.activities.MainActivity");
        ((MainActivity) activity).setAndroidPDialogFixStopKeyDispatching(false);
    }
}
