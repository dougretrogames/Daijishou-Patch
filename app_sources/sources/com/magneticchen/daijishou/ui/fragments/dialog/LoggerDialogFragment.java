package com.magneticchen.daijishou.ui.fragments.dialog;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.PopupMenu;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.BooleanPreference;
import com.magneticchen.daijishou.data.IntPreference;
import com.magneticchen.daijishou.data.StringPreference;
import com.magneticchen.daijishou.data.live.SharedPreferenceBooleanLiveData;
import com.magneticchen.daijishou.logger.Logger;
import com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouLinearLayoutManager;
import com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView;
import com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment;
import com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel;
import com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: LoggerDialogFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\u0018\u0000 *2\u00020\u0001:\u0002*+B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001a\u001a\u00020\u0006J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J&\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020&H\u0002J\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00100)R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\fj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0006`\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000¨\u0006,²\u0006\n\u0010-\u001a\u00020.X\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/LoggerDialogFragment;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/DaijishouDialogFragment;", "()V", "backButtonLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "componentFilterStatus", "", "controlPanelButtonLayout", "filterButtonLayout", "filterStatus", "", "hashCodeToComponent", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "logs", "", "Lcom/magneticchen/daijishou/logger/Logger$LogRecord;", "[Lcom/magneticchen/daijishou/logger/Logger$LogRecord;", "popupMenu", "Landroidx/appcompat/widget/PopupMenu;", "recyclerView", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView;", "scrollingOnBackPressed", "", "searchEditTextInputLayout", "Lcom/google/android/material/textfield/TextInputLayout;", "getSearchHint", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "", "refreshComponentsInPopupMenu", "requireFilteredLogs", "", "Companion", "SearchRecyclerViewAdapter", "app_release", "console", "Lcom/magneticchen/daijishou/ui/model/DaijishouConsoleViewModel;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LoggerDialogFragment extends DaijishouDialogFragment {
    private ConstraintLayout backButtonLayout;
    private ConstraintLayout controlPanelButtonLayout;
    private ConstraintLayout filterButtonLayout;
    private PopupMenu popupMenu;
    private DaijishouRecyclerView recyclerView;
    private boolean scrollingOnBackPressed;
    private TextInputLayout searchEditTextInputLayout;
    public static final Companion Companion = new Companion(null);
    private static final int COMPONENT_FILTER = 99;
    private static final int NO_FILTER = -99;
    private static final String SEARCH_HINT = "Search your logs";
    private int filterStatus = NO_FILTER;
    private String componentFilterStatus = "";
    private Logger.LogRecord[] logs = new Logger.LogRecord[0];
    private final HashMap<Integer, String> hashCodeToComponent = new HashMap<>();

    /* JADX INFO: compiled from: LoggerDialogFragment.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eR\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\nX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/LoggerDialogFragment$Companion;", "", "()V", "COMPONENT_FILTER", "", "getCOMPONENT_FILTER", "()I", "NO_FILTER", "getNO_FILTER", "SEARCH_HINT", "", "getSEARCH_HINT", "()Ljava/lang/String;", "newInstance", "Lcom/magneticchen/daijishou/ui/fragments/dialog/LoggerDialogFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LoggerDialogFragment newInstance() {
            LoggerDialogFragment loggerDialogFragment = new LoggerDialogFragment();
            loggerDialogFragment.setArguments(new Bundle());
            return loggerDialogFragment;
        }

        public final int getCOMPONENT_FILTER() {
            return LoggerDialogFragment.COMPONENT_FILTER;
        }

        public final int getNO_FILTER() {
            return LoggerDialogFragment.NO_FILTER;
        }

        public final String getSEARCH_HINT() {
            return LoggerDialogFragment.SEARCH_HINT;
        }
    }

    /* JADX INFO: compiled from: LoggerDialogFragment.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\n0\u000bR\u00060\u0000R\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/LoggerDialogFragment$SearchRecyclerViewAdapter;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/logger/Logger$LogRecord;", "logs", "", "(Lcom/magneticchen/daijishou/ui/fragments/dialog/LoggerDialogFragment;Ljava/util/List;)V", "getItemId", "", "position", "", "onCreateViewHolder", "Lcom/magneticchen/daijishou/ui/fragments/dialog/LoggerDialogFragment$SearchRecyclerViewAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/fragments/dialog/LoggerDialogFragment;", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class SearchRecyclerViewAdapter extends DaijishouRecyclerView.Adapter<Logger.LogRecord> {
        private final List<Logger.LogRecord> logs;
        final /* synthetic */ LoggerDialogFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SearchRecyclerViewAdapter(LoggerDialogFragment loggerDialogFragment, List<Logger.LogRecord> logs) {
            super(logs, false, false, 6, null);
            Intrinsics.checkNotNullParameter(logs, "logs");
            this.this$0 = loggerDialogFragment;
            this.logs = logs;
        }

        public long getItemId(int i) {
            return this.logs.get(i).getTimestamp();
        }

        /* JADX INFO: compiled from: LoggerDialogFragment.kt */
        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0086\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \t*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \t*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \t*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \t*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/LoggerDialogFragment$SearchRecyclerViewAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/logger/Logger$LogRecord;", "itemView", "Landroid/view/View;", "(Lcom/magneticchen/daijishou/ui/fragments/dialog/LoggerDialogFragment$SearchRecyclerViewAdapter;Landroid/view/View;)V", "debugImageView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "errorImageView", "firstLine", "Landroid/widget/TextView;", "infoImageView", "secondLine", "thirdLine", "timestamp", "warnImageView", "onBind", "", "position", "", "item", "onFocus", "onFocusClear", "isAbsoluteAdapterPositionValid", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public final class ViewHolder extends DaijishouRecyclerView.Adapter<Logger.LogRecord>.ViewHolder {
            private final ImageView debugImageView;
            private final ImageView errorImageView;
            private final TextView firstLine;
            private final ImageView infoImageView;
            private final TextView secondLine;
            private final TextView thirdLine;
            final /* synthetic */ SearchRecyclerViewAdapter this$0;
            private final TextView timestamp;
            private final ImageView warnImageView;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(SearchRecyclerViewAdapter searchRecyclerViewAdapter, View itemView) {
                super(searchRecyclerViewAdapter, itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                this.this$0 = searchRecyclerViewAdapter;
                this.firstLine = (TextView) itemView.findViewById(R.id.list_item_log_record_first_line);
                this.secondLine = (TextView) itemView.findViewById(R.id.list_item_log_record_second_line);
                this.thirdLine = (TextView) itemView.findViewById(R.id.list_item_log_record_third_line);
                this.timestamp = (TextView) itemView.findViewById(R.id.list_item_log_record_timestamp);
                this.infoImageView = (ImageView) itemView.findViewById(R.id.list_item_log_record_info_image_view);
                this.debugImageView = (ImageView) itemView.findViewById(R.id.list_item_log_record_debug_image_view);
                this.warnImageView = (ImageView) itemView.findViewById(R.id.list_item_log_record_warn_image_view);
                this.errorImageView = (ImageView) itemView.findViewById(R.id.list_item_log_record_error_image_view);
            }

            @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onBind(int i, Logger.LogRecord item) {
                Intrinsics.checkNotNullParameter(item, "item");
                this.firstLine.setText(item.getFromComponent());
                int type = item.getType();
                if (type == -1) {
                    this.secondLine.setText("Logger");
                } else if (type == 0) {
                    this.secondLine.setText("Info");
                } else if (type == 1) {
                    this.secondLine.setText("Debug");
                } else if (type == 2) {
                    this.secondLine.setText("Warn");
                } else if (type == 3) {
                    this.secondLine.setText("Error");
                } else {
                    this.secondLine.setText("Logger");
                }
                this.thirdLine.setText(item.getMessage());
                this.timestamp.setText(new Date(item.getTimestamp()).toString());
                this.infoImageView.setVisibility(item.getType() == 0 ? 0 : 8);
                this.errorImageView.setVisibility(item.getType() == 3 ? 0 : 8);
                this.debugImageView.setVisibility(item.getType() == 1 ? 0 : 8);
                this.warnImageView.setVisibility(item.getType() != 2 ? 8 : 0);
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
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_log_record, viewGroup, false);
            Intrinsics.checkNotNull(viewInflate);
            return new ViewHolder(this, viewInflate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshComponentsInPopupMenu() {
        PopupMenu popupMenu = this.popupMenu;
        if (popupMenu == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popupMenu");
            popupMenu = null;
        }
        popupMenu.getMenu().removeGroup(1);
        this.hashCodeToComponent.clear();
        SortedSet<String> components = getLogger().getComponents();
        if (components != null) {
            int i = 0;
            for (Object obj : components) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String str = (String) obj;
                int iHashCode = str.hashCode();
                PopupMenu popupMenu2 = this.popupMenu;
                if (popupMenu2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popupMenu");
                    popupMenu2 = null;
                }
                popupMenu2.getMenu().add(1, iHashCode, i + 5, str);
                HashMap<Integer, String> map = this.hashCodeToComponent;
                Integer numValueOf = Integer.valueOf(str.hashCode());
                Intrinsics.checkNotNull(str);
                map.put(numValueOf, str);
                i = i2;
            }
        }
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        final FragmentActivity fragmentActivityRequireActivity = requireActivity();
        final int theme = getTheme();
        Dialog dialog = new Dialog(fragmentActivityRequireActivity, theme) { // from class: com.magneticchen.daijishou.ui.fragments.dialog.LoggerDialogFragment$onCreateDialog$dialog$1
            {
                super((Context) fragmentActivityRequireActivity, theme);
            }

            /* JADX WARN: Code duplicated, block: B:11:0x0027  */
            /* JADX WARN: Code duplicated, block: B:20:0x0045  */
            /* JADX WARN: Code duplicated, block: B:22:0x0053  */
            /* JADX WARN: Code duplicated, block: B:25:0x0064  */
            /* JADX WARN: Code duplicated, block: B:26:0x0068  */
            /* JADX WARN: Code duplicated, block: B:9:0x001f  */
            @Override // android.app.Dialog
            public void onBackPressed() {
                DaijishouRecyclerView daijishouRecyclerView;
                ConstraintLayout constraintLayout;
                DaijishouRecyclerView daijishouRecyclerView2;
                DaijishouRecyclerView daijishouRecyclerView3 = null;
                if (!this.this$0.scrollingOnBackPressed) {
                    daijishouRecyclerView = this.this$0.recyclerView;
                    if (daijishouRecyclerView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                        daijishouRecyclerView = null;
                    }
                    if (daijishouRecyclerView.computeVerticalScrollOffset() != 0) {
                        this.this$0.scrollingOnBackPressed = true;
                        constraintLayout = this.this$0.backButtonLayout;
                        if (constraintLayout == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("backButtonLayout");
                            constraintLayout = null;
                        }
                        constraintLayout.requestFocus();
                        daijishouRecyclerView2 = this.this$0.recyclerView;
                        if (daijishouRecyclerView2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                        } else {
                            daijishouRecyclerView3 = daijishouRecyclerView2;
                        }
                        daijishouRecyclerView3.smoothScrollToPosition(0);
                        return;
                    }
                } else {
                    DaijishouRecyclerView daijishouRecyclerView4 = this.this$0.recyclerView;
                    if (daijishouRecyclerView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                        daijishouRecyclerView4 = null;
                    }
                    if (daijishouRecyclerView4.getScrollState() != 2) {
                        daijishouRecyclerView = this.this$0.recyclerView;
                        if (daijishouRecyclerView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                            daijishouRecyclerView = null;
                        }
                        if (daijishouRecyclerView.computeVerticalScrollOffset() != 0) {
                            this.this$0.scrollingOnBackPressed = true;
                            constraintLayout = this.this$0.backButtonLayout;
                            if (constraintLayout == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("backButtonLayout");
                                constraintLayout = null;
                            }
                            constraintLayout.requestFocus();
                            daijishouRecyclerView2 = this.this$0.recyclerView;
                            if (daijishouRecyclerView2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                            } else {
                                daijishouRecyclerView3 = daijishouRecyclerView2;
                            }
                            daijishouRecyclerView3.smoothScrollToPosition(0);
                            return;
                        }
                    }
                }
                DaijishouRecyclerView daijishouRecyclerView5 = this.this$0.recyclerView;
                if (daijishouRecyclerView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                } else {
                    daijishouRecyclerView3 = daijishouRecyclerView5;
                }
                daijishouRecyclerView3.scrollToPosition(0);
                super.onBackPressed();
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

    public final String getSearchHint() {
        int i = this.filterStatus;
        if (i != COMPONENT_FILTER) {
            if (i == NO_FILTER) {
                return SEARCH_HINT;
            }
            if (i == -1) {
                return SEARCH_HINT + " < Logger >";
            }
            if (i == 1) {
                return SEARCH_HINT + " < Debug >";
            }
            if (i == 0) {
                return SEARCH_HINT + " < Info >";
            }
            if (i == 2) {
                return SEARCH_HINT + " < Warn >";
            }
            if (i == 3) {
                return SEARCH_HINT + " < Error >";
            }
            return SEARCH_HINT;
        }
        return SEARCH_HINT + " [" + this.componentFilterStatus + "]";
    }

    public final List<Logger.LogRecord> requireFilteredLogs() {
        ArrayList logs = getLogger().getLogs();
        if (logs == null) {
            logs = new ArrayList();
        }
        int i = this.filterStatus;
        if (i != COMPONENT_FILTER) {
            if (i == NO_FILTER) {
                return CollectionsKt.reversed(logs);
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : logs) {
                if (((Logger.LogRecord) obj).getType() == this.filterStatus) {
                    arrayList.add(obj);
                }
            }
            return CollectionsKt.reversed(arrayList);
        }
        getDefaultSharedPreferences().edit().putString(StringPreference.LOGGER_DIALOG_COMPONENT_FILTER_STATUS.getKey(), this.componentFilterStatus).apply();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : logs) {
            if (Intrinsics.areEqual(((Logger.LogRecord) obj2).getFromComponent(), this.componentFilterStatus)) {
                arrayList2.add(obj2);
            }
        }
        return CollectionsKt.reversed(arrayList2);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        final ArrayList arrayList = new ArrayList();
        View viewInflate = inflater.inflate(R.layout.fragment_logger_dialog, viewGroup, false);
        final Fragment fragment = (Fragment) this;
        final Function0 function0 = null;
        final Lazy lazyCreateViewModelLazy = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(DaijishouConsoleViewModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.LoggerDialogFragment$onCreateView$$inlined$activityViewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return fragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.LoggerDialogFragment$onCreateView$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? fragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.LoggerDialogFragment$onCreateView$$inlined$activityViewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return fragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
        this.filterStatus = getDefaultSharedPreferences().getInt(IntPreference.LOGGER_DIALOG_FILTER_STATUS.getKey(), IntPreference.LOGGER_DIALOG_FILTER_STATUS.getDefaultValue());
        String string = getDefaultSharedPreferences().getString(StringPreference.LOGGER_DIALOG_COMPONENT_FILTER_STATUS.getKey(), StringPreference.LOGGER_DIALOG_COMPONENT_FILTER_STATUS.getDefaultValue());
        if (string == null) {
            string = "";
        }
        this.componentFilterStatus = string;
        Object objFindViewById = viewInflate.findViewById(R.id.fragment_logger_dialog_recycler_view);
        Intrinsics.checkNotNullExpressionValue(objFindViewById, "findViewById(...)");
        this.recyclerView = (DaijishouRecyclerView) objFindViewById;
        final SearchRecyclerViewAdapter searchRecyclerViewAdapter = new SearchRecyclerViewAdapter(this, arrayList);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final RecyclerView.LayoutManager daijishouLinearLayoutManager = new DaijishouLinearLayoutManager(contextRequireContext, 1, false);
        DaijishouRecyclerView daijishouRecyclerView = this.recyclerView;
        if (daijishouRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            daijishouRecyclerView = null;
        }
        daijishouRecyclerView.setAdapter(searchRecyclerViewAdapter);
        DaijishouRecyclerView daijishouRecyclerView2 = this.recyclerView;
        if (daijishouRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            daijishouRecyclerView2 = null;
        }
        daijishouRecyclerView2.setLayoutManager(daijishouLinearLayoutManager);
        searchRecyclerViewAdapter.setOnItemClickListener(new Function4<View, Integer, Long, Logger.LogRecord, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.LoggerDialogFragment.onCreateView.1
            

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, Long l, Logger.LogRecord logRecord) {
                invoke(view, num.intValue(), l.longValue(), logRecord);
                return Unit.INSTANCE;
            }

            public final void invoke(View view, int i, long j, Logger.LogRecord item) {
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(item, "item");
                Object systemService = LoggerDialogFragment.this.requireActivity().getSystemService("clipboard");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("logger", item.getMessage()));
                Toast.makeText(LoggerDialogFragment.this.getContext(), "Copied to clipboard: " + item.getMessage(), 0).show();
            }
        });
        DaijishouRecyclerView daijishouRecyclerView3 = this.recyclerView;
        if (daijishouRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            daijishouRecyclerView3 = null;
        }
        daijishouRecyclerView3.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.LoggerDialogFragment.onCreateView.2
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                if (i == 0) {
                    LoggerDialogFragment.this.scrollingOnBackPressed = false;
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        });
        ConstraintLayout constraintLayoutFindViewById = viewInflate.findViewById(R.id.fragment_logger_dialog_control_panel_button);
        Intrinsics.checkNotNullExpressionValue(constraintLayoutFindViewById, "findViewById(...)");
        this.controlPanelButtonLayout = constraintLayoutFindViewById;
        ConstraintLayout constraintLayoutFindViewById2 = viewInflate.findViewById(R.id.fragment_logger_dialog_filter_button);
        Intrinsics.checkNotNullExpressionValue(constraintLayoutFindViewById2, "findViewById(...)");
        this.filterButtonLayout = constraintLayoutFindViewById2;
        ConstraintLayout constraintLayoutFindViewById3 = viewInflate.findViewById(R.id.fragment_logger_dialog_back_button);
        Intrinsics.checkNotNullExpressionValue(constraintLayoutFindViewById3, "findViewById(...)");
        ConstraintLayout constraintLayout = constraintLayoutFindViewById3;
        this.backButtonLayout = constraintLayout;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backButtonLayout");
            constraintLayout = null;
        }
        constraintLayout.requestFocus();
        ConstraintLayout constraintLayout2 = this.controlPanelButtonLayout;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("controlPanelButtonLayout");
            constraintLayout2 = null;
        }
        constraintLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.LoggerDialogFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoggerDialogFragment.onCreateView$lambda$7(this.f$0, view);
            }
        });
        Context contextRequireContext2 = requireContext();
        ConstraintLayout constraintLayout3 = this.filterButtonLayout;
        if (constraintLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterButtonLayout");
            constraintLayout3 = null;
        }
        PopupMenu popupMenu = new PopupMenu(contextRequireContext2, (View) constraintLayout3);
        this.popupMenu = popupMenu;
        popupMenu.getMenu().add(0, NO_FILTER, 0, "• All");
        PopupMenu popupMenu2 = this.popupMenu;
        if (popupMenu2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popupMenu");
            popupMenu2 = null;
        }
        popupMenu2.getMenu().add(0, -1, 1, "< Logger >");
        PopupMenu popupMenu3 = this.popupMenu;
        if (popupMenu3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popupMenu");
            popupMenu3 = null;
        }
        popupMenu3.getMenu().add(0, 1, 2, "< Debug >");
        PopupMenu popupMenu4 = this.popupMenu;
        if (popupMenu4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popupMenu");
            popupMenu4 = null;
        }
        popupMenu4.getMenu().add(0, 0, 3, "< Info >");
        PopupMenu popupMenu5 = this.popupMenu;
        if (popupMenu5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popupMenu");
            popupMenu5 = null;
        }
        popupMenu5.getMenu().add(0, 2, 4, "< Warn >");
        PopupMenu popupMenu6 = this.popupMenu;
        if (popupMenu6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popupMenu");
            popupMenu6 = null;
        }
        popupMenu6.getMenu().add(0, 3, 5, "< Error >");
        refreshComponentsInPopupMenu();
        if (!isKioskMode() && Build.VERSION.SDK_INT >= 28) {
            PopupMenu popupMenu7 = this.popupMenu;
            if (popupMenu7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popupMenu");
                popupMenu7 = null;
            }
            popupMenu7.getMenu().setGroupDividerEnabled(true);
        }
        PopupMenu popupMenu8 = this.popupMenu;
        if (popupMenu8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popupMenu");
            popupMenu8 = null;
        }
        popupMenu8.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.LoggerDialogFragment$$ExternalSyntheticLambda1
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return LoggerDialogFragment.onCreateView$lambda$8(this.f$0, arrayList, searchRecyclerViewAdapter, menuItem);
            }
        });
        ConstraintLayout constraintLayout4 = this.filterButtonLayout;
        if (constraintLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterButtonLayout");
            constraintLayout4 = null;
        }
        constraintLayout4.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.LoggerDialogFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoggerDialogFragment.onCreateView$lambda$9(this.f$0, view);
            }
        });
        ConstraintLayout constraintLayout5 = this.backButtonLayout;
        if (constraintLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backButtonLayout");
            constraintLayout5 = null;
        }
        constraintLayout5.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.LoggerDialogFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoggerDialogFragment.onCreateView$lambda$10(this.f$0, view);
            }
        });
        TextInputLayout textInputLayoutFindViewById = viewInflate.findViewById(R.id.fragment_logger_dialog_text_input_layout);
        Intrinsics.checkNotNullExpressionValue(textInputLayoutFindViewById, "findViewById(...)");
        TextInputLayout textInputLayout = textInputLayoutFindViewById;
        this.searchEditTextInputLayout = textInputLayout;
        if (textInputLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditTextInputLayout");
            textInputLayout = null;
        }
        textInputLayout.setHint(getSearchHint());
        arrayList.addAll(requireFilteredLogs());
        final TextInputEditText textInputEditTextFindViewById = viewInflate.findViewById(R.id.fragment_logger_dialog_edit_text);
        textInputEditTextFindViewById.addTextChangedListener(new TextWatcher() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.LoggerDialogFragment.onCreateView.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(LoggerDialogFragment.this), Dispatchers.getIO(), (CoroutineStart) null, new LoggerDialogFragment$onCreateView$7$onTextChanged$1(charSequence, LoggerDialogFragment.this, arrayList, searchRecyclerViewAdapter, null), 2, (Object) null);
            }
        });
        textInputEditTextFindViewById.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.LoggerDialogFragment$$ExternalSyntheticLambda4
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return LoggerDialogFragment.onCreateView$lambda$11(this.f$0, textInputEditTextFindViewById, lazyCreateViewModelLazy, textView, i, keyEvent);
            }
        });
        TextInputLayout textInputLayout2 = this.searchEditTextInputLayout;
        if (textInputLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditTextInputLayout");
            textInputLayout2 = null;
        }
        textInputLayout2.setEndIconOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.LoggerDialogFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoggerDialogFragment.onCreateView$lambda$12(textInputEditTextFindViewById, view);
            }
        });
        LiveData<Logger.LogRecord> latestLogRecordLiveData = getLogger().getLatestLogRecordLiveData();
        if (latestLogRecordLiveData == null) {
            Toast.makeText(requireContext(), "Logger is not properly setup.", 0).show();
        } else {
            latestLogRecordLiveData.observe((LifecycleOwner) this, new LoggerDialogFragment$sam$androidx_lifecycle_Observer$0(new Function1<Logger.LogRecord, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.LoggerDialogFragment.onCreateView.10
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Logger.LogRecord logRecord) {
                    invoke2(logRecord);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Logger.LogRecord logRecord) {
                    Set setSubtract;
                    if (logRecord == null) {
                        arrayList.clear();
                        this.refreshComponentsInPopupMenu();
                        return;
                    }
                    LoggerDialogFragment loggerDialogFragment = this;
                    List<Logger.LogRecord> logs = loggerDialogFragment.getLogger().getLogs();
                    DaijishouRecyclerView daijishouRecyclerView4 = null;
                    loggerDialogFragment.logs = logs != null ? (Logger.LogRecord[]) logs.toArray(new Logger.LogRecord[0]) : null;
                    SortedSet<String> components = this.getLogger().getComponents();
                    if (components != null) {
                        Collection collectionValues = this.hashCodeToComponent.values();
                        Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
                        setSubtract = CollectionsKt.subtract(components, CollectionsKt.toSet(collectionValues));
                    } else {
                        setSubtract = null;
                    }
                    if (setSubtract != null && !setSubtract.isEmpty()) {
                        this.refreshComponentsInPopupMenu();
                    }
                    if (this.logs == null) {
                        arrayList.clear();
                        ConstraintLayout constraintLayout6 = this.backButtonLayout;
                        if (constraintLayout6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("backButtonLayout");
                            constraintLayout6 = null;
                        }
                        constraintLayout6.requestFocus();
                        searchRecyclerViewAdapter.notifyDataSetChanged();
                        DaijishouRecyclerView daijishouRecyclerView5 = this.recyclerView;
                        if (daijishouRecyclerView5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                        } else {
                            daijishouRecyclerView4 = daijishouRecyclerView5;
                        }
                        daijishouRecyclerView4.scrollToPosition(0);
                        return;
                    }
                    List<Logger.LogRecord> listRequireFilteredLogs = this.requireFilteredLogs();
                    List<Logger.LogRecord> list = arrayList;
                    DaijishouLinearLayoutManager daijishouLinearLayoutManager2 = daijishouLinearLayoutManager;
                    SearchRecyclerViewAdapter searchRecyclerViewAdapter2 = searchRecyclerViewAdapter;
                    LoggerDialogFragment loggerDialogFragment2 = this;
                    for (Logger.LogRecord logRecord2 : listRequireFilteredLogs) {
                        if (!list.contains(logRecord2)) {
                            boolean z = daijishouLinearLayoutManager2.findFirstVisibleItemPosition() == 0;
                            list.add(0, logRecord2);
                            searchRecyclerViewAdapter2.notifyItemInserted(0);
                            if (z) {
                                DaijishouRecyclerView daijishouRecyclerView6 = loggerDialogFragment2.recyclerView;
                                if (daijishouRecyclerView6 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                                    daijishouRecyclerView6 = null;
                                }
                                daijishouRecyclerView6.scrollToPosition(0);
                            }
                        }
                    }
                }
            }));
        }
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), BooleanPreference.USE_DEBUG_MODE.getKey(), BooleanPreference.USE_DEBUG_MODE.getDefaultValue()).observe(getViewLifecycleOwner(), new LoggerDialogFragment$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.LoggerDialogFragment.onCreateView.11
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                ConstraintLayout constraintLayout6 = LoggerDialogFragment.this.controlPanelButtonLayout;
                if (constraintLayout6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("controlPanelButtonLayout");
                    constraintLayout6 = null;
                }
                Intrinsics.checkNotNull(bool);
                constraintLayout6.setVisibility(bool.booleanValue() ? 0 : 8);
            }
        }));
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DaijishouConsoleViewModel onCreateView$lambda$6(Lazy<DaijishouConsoleViewModel> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$7(LoggerDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DebugAndExperimentalDialogFragment.Companion.newInstance().show(this$0.getParentFragmentManager(), DebugAndExperimentalDialogFragment.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateView$lambda$8(LoggerDialogFragment this$0, List searchLogRecordList, SearchRecyclerViewAdapter recyclerViewAdapter, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(searchLogRecordList, "$searchLogRecordList");
        Intrinsics.checkNotNullParameter(recyclerViewAdapter, "$recyclerViewAdapter");
        DaijishouRecyclerView daijishouRecyclerView = null;
        if (this$0.filterStatus == menuItem.getItemId()) {
            DaijishouRecyclerView daijishouRecyclerView2 = this$0.recyclerView;
            if (daijishouRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                daijishouRecyclerView = daijishouRecyclerView2;
            }
            daijishouRecyclerView.smoothScrollToPosition(0);
        } else {
            menuItem.setTitle(String.valueOf(menuItem.getTitle()));
            DaijishouRecyclerView daijishouRecyclerView3 = this$0.recyclerView;
            if (daijishouRecyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                daijishouRecyclerView3 = null;
            }
            daijishouRecyclerView3.scrollToPosition(0);
            int itemId = menuItem.getGroupId() == 0 ? menuItem.getItemId() : COMPONENT_FILTER;
            this$0.filterStatus = itemId;
            if (itemId == COMPONENT_FILTER) {
                String str = this$0.hashCodeToComponent.get(Integer.valueOf(menuItem.getItemId()));
                Intrinsics.checkNotNull(str);
                this$0.componentFilterStatus = str;
            }
            this$0.getDefaultSharedPreferences().edit().putInt(IntPreference.LOGGER_DIALOG_FILTER_STATUS.getKey(), this$0.filterStatus).apply();
            searchLogRecordList.clear();
            searchLogRecordList.addAll(this$0.requireFilteredLogs());
            DaijishouRecyclerView daijishouRecyclerView4 = this$0.searchEditTextInputLayout;
            if (daijishouRecyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchEditTextInputLayout");
            } else {
                daijishouRecyclerView = daijishouRecyclerView4;
            }
            daijishouRecyclerView.setHint(this$0.getSearchHint());
            recyclerViewAdapter.notifyDataSetChanged();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$9(LoggerDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PopupMenu popupMenu = this$0.popupMenu;
        if (popupMenu == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popupMenu");
            popupMenu = null;
        }
        popupMenu.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$10(LoggerDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.requireDialog().onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateView$lambda$11(LoggerDialogFragment this$0, TextInputEditText textInputEditText, Lazy console$delegate, TextView textView, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(console$delegate, "$console$delegate");
        if (i != 3) {
            return false;
        }
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this$0), Dispatchers.getDefault(), (CoroutineStart) null, new LoggerDialogFragment$onCreateView$8$1(this$0, textInputEditText, console$delegate, null), 2, (Object) null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$12(TextInputEditText textInputEditText, View view) {
        Editable text = textInputEditText.getText();
        if (text != null) {
            text.clear();
        }
    }
}
