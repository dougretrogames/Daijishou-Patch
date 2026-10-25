package com.magneticchen.daijishou.dialog_fragments;

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
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment;
import com.magneticchen.daijishou.application_data.BooleanPreference;
import com.magneticchen.daijishou.application_data.IntPreference;
import com.magneticchen.daijishou.application_data.StringPreference;
import com.magneticchen.daijishou.daijishou_recycler_view.DaijishouLinearLayoutManager;
import com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView;
import com.magneticchen.daijishou.live_data.SharedPreferenceBooleanLiveData;
import com.magneticchen.daijishou.logger.Logger;
import com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.lib.Constants;

/* JADX INFO: compiled from: LoggerDialogFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\u0018\u0000 *2\u00020\u0001:\u0002*+B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001a\u001a\u00020\u0006J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J&\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020&H\u0002J\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00100)R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\fj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0006`\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000¨\u0006,²\u0006\n\u0010-\u001a\u00020.X\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/dialog_fragments/LoggerDialogFragment;", "Lcom/magneticchen/daijishou/abstract_fragment_classes/DaijishouDialogFragment;", "()V", "backButtonLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "componentFilterStatus", "", "controlPanelButtonLayout", "filterButtonLayout", "filterStatus", "", "hashCodeToComponent", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", Constants.LOGS, "", "Lcom/magneticchen/daijishou/logger/Logger$LogRecord;", "[Lcom/magneticchen/daijishou/logger/Logger$LogRecord;", "popupMenu", "Landroidx/appcompat/widget/PopupMenu;", "recyclerView", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView;", "scrollingOnBackPressed", "", "searchEditTextInputLayout", "Lcom/google/android/material/textfield/TextInputLayout;", "getSearchHint", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "", "refreshComponentsInPopupMenu", "requireFilteredLogs", "", "Companion", "SearchRecyclerViewAdapter", "app_release", "console", "Lcom/magneticchen/daijishou/view_models/DaijishouConsoleViewModel;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LoggerDialogFragment extends DaijishouDialogFragment {
    public ConstraintLayout backButtonLayout;
    private ConstraintLayout controlPanelButtonLayout;
    private ConstraintLayout filterButtonLayout;
    private PopupMenu popupMenu;
    public DaijishouRecyclerView recyclerView;
    public boolean scrollingOnBackPressed;
    public TextInputLayout searchEditTextInputLayout;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int COMPONENT_FILTER = 99;
    private static final int NO_FILTER = -99;
    private static final String SEARCH_HINT = "Search your logs";
    private int filterStatus = NO_FILTER;
    private String componentFilterStatus = "";
    private Logger.LogRecord[] logs = new Logger.LogRecord[0];
    private final HashMap<Integer, String> hashCodeToComponent = new HashMap<>();

    /* JADX INFO: compiled from: LoggerDialogFragment.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eR\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\nX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/magneticchen/daijishou/dialog_fragments/LoggerDialogFragment$Companion;", "", "()V", "COMPONENT_FILTER", "", "getCOMPONENT_FILTER", "()I", "NO_FILTER", "getNO_FILTER", "SEARCH_HINT", "", "getSEARCH_HINT", "()Ljava/lang/String;", "newInstance", "Lcom/magneticchen/daijishou/dialog_fragments/LoggerDialogFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\n0\u000bR\u00060\u0000R\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/magneticchen/daijishou/dialog_fragments/LoggerDialogFragment$SearchRecyclerViewAdapter;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/logger/Logger$LogRecord;", Constants.LOGS, "", "(Lcom/magneticchen/daijishou/dialog_fragments/LoggerDialogFragment;Ljava/util/List;)V", "getItemId", "", "position", "", "onCreateViewHolder", "Lcom/magneticchen/daijishou/dialog_fragments/LoggerDialogFragment$SearchRecyclerViewAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/dialog_fragments/LoggerDialogFragment;", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int position) {
            return this.logs.get(position).getTimestamp();
        }

        /* JADX INFO: compiled from: LoggerDialogFragment.kt */
        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0086\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \t*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \t*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \t*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \t*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/magneticchen/daijishou/dialog_fragments/LoggerDialogFragment$SearchRecyclerViewAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/logger/Logger$LogRecord;", "itemView", "Landroid/view/View;", "(Lcom/magneticchen/daijishou/dialog_fragments/LoggerDialogFragment$SearchRecyclerViewAdapter;Landroid/view/View;)V", "debugImageView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "errorImageView", "firstLine", "Landroid/widget/TextView;", "infoImageView", "secondLine", "thirdLine", "timestamp", "warnImageView", "onBind", "", "position", "", "item", "onFocus", "onFocusClear", "isAbsoluteAdapterPositionValid", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

            @Override // com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onBind(int position, Logger.LogRecord item) {
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

            @Override // com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onFocus() {
                super.onFocus();
                this.secondLine.setSelected(true);
            }

            @Override // com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onFocusClear(boolean isAbsoluteAdapterPositionValid) {
                super.onFocusClear(isAbsoluteAdapterPositionValid);
                this.secondLine.setSelected(false);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
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

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LoggerDialogFragment$onCreateDialog$dialog$1 loggerDialogFragment$onCreateDialog$dialog$1 = new LoggerDialogFragment$onCreateDialog$dialog$1(this, requireActivity(), getTheme());
        setupDaijishouDialog(loggerDialogFragment$onCreateDialog$dialog$1);
        return loggerDialogFragment$onCreateDialog$dialog$1;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
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
                window3.setFlags(1024, 1024);
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
        return SEARCH_HINT + " [" + this.componentFilterStatus + CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
    }

    public final List<Logger.LogRecord> requireFilteredLogs() {
        List<Logger.LogRecord> logs = getLogger().getLogs();
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

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        ArrayList arrayList = new ArrayList();
        View viewInflate = inflater.inflate(R.layout.fragment_logger_dialog, container, false);
        LoggerDialogFragment loggerDialogFragment = this;
        Lazy lazyCreateViewModelLazy = FragmentViewModelLazyKt.createViewModelLazy(loggerDialogFragment, Reflection.getOrCreateKotlinClass(DaijishouConsoleViewModel.class), new LoggerDialogFragment$onCreateView$$inlined$activityViewModels$default$1(loggerDialogFragment), new LoggerDialogFragment$onCreateView$$inlined$activityViewModels$default$2(null, loggerDialogFragment), new LoggerDialogFragment$onCreateView$$inlined$activityViewModels$default$3(loggerDialogFragment));
        this.filterStatus = getDefaultSharedPreferences().getInt(IntPreference.LOGGER_DIALOG_FILTER_STATUS.getKey(), IntPreference.LOGGER_DIALOG_FILTER_STATUS.getDefaultValue());
        String string = getDefaultSharedPreferences().getString(StringPreference.LOGGER_DIALOG_COMPONENT_FILTER_STATUS.getKey(), StringPreference.LOGGER_DIALOG_COMPONENT_FILTER_STATUS.getDefaultValue());
        if (string == null) {
            string = "";
        }
        this.componentFilterStatus = string;
        View viewFindViewById = viewInflate.findViewById(R.id.fragment_logger_dialog_recycler_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.recyclerView = (DaijishouRecyclerView) viewFindViewById;
        SearchRecyclerViewAdapter searchRecyclerViewAdapter = new SearchRecyclerViewAdapter(this, arrayList);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        DaijishouLinearLayoutManager daijishouLinearLayoutManager = new DaijishouLinearLayoutManager(contextRequireContext, 1, false);
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
        searchRecyclerViewAdapter.setOnItemClickListener(new AnonymousClass1());
        DaijishouRecyclerView daijishouRecyclerView3 = this.recyclerView;
        if (daijishouRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            daijishouRecyclerView3 = null;
        }
        daijishouRecyclerView3.addOnScrollListener(new AnonymousClass2());
        View viewFindViewById2 = viewInflate.findViewById(R.id.fragment_logger_dialog_control_panel_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.controlPanelButtonLayout = (ConstraintLayout) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(R.id.fragment_logger_dialog_filter_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.filterButtonLayout = (ConstraintLayout) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(R.id.fragment_logger_dialog_back_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById4;
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
        constraintLayout2.setOnClickListener(new LoggerDialogFragment$$ExternalSyntheticLambda0(this));
        Context contextRequireContext2 = requireContext();
        ConstraintLayout constraintLayout3 = this.filterButtonLayout;
        if (constraintLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterButtonLayout");
            constraintLayout3 = null;
        }
        PopupMenu popupMenu = new PopupMenu(contextRequireContext2, constraintLayout3);
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
        if (!getIsKioskMode() && Build.VERSION.SDK_INT >= 28) {
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
        popupMenu8.setOnMenuItemClickListener(new LoggerDialogFragment$$ExternalSyntheticLambda1(this, arrayList, searchRecyclerViewAdapter));
        ConstraintLayout constraintLayout4 = this.filterButtonLayout;
        if (constraintLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterButtonLayout");
            constraintLayout4 = null;
        }
        constraintLayout4.setOnClickListener(new LoggerDialogFragment$$ExternalSyntheticLambda2(this));
        ConstraintLayout constraintLayout5 = this.backButtonLayout;
        if (constraintLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backButtonLayout");
            constraintLayout5 = null;
        }
        constraintLayout5.setOnClickListener(new LoggerDialogFragment$$ExternalSyntheticLambda3(this));
        View viewFindViewById5 = viewInflate.findViewById(R.id.fragment_logger_dialog_text_input_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        TextInputLayout textInputLayout = (TextInputLayout) viewFindViewById5;
        this.searchEditTextInputLayout = textInputLayout;
        if (textInputLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditTextInputLayout");
            textInputLayout = null;
        }
        textInputLayout.setHint(getSearchHint());
        arrayList.addAll(requireFilteredLogs());
        TextInputEditText textInputEditText = (TextInputEditText) viewInflate.findViewById(R.id.fragment_logger_dialog_edit_text);
        textInputEditText.addTextChangedListener(new AnonymousClass7(arrayList, searchRecyclerViewAdapter));
        textInputEditText.setOnEditorActionListener(new LoggerDialogFragment$$ExternalSyntheticLambda4(this, textInputEditText, lazyCreateViewModelLazy));
        TextInputLayout textInputLayout2 = this.searchEditTextInputLayout;
        if (textInputLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditTextInputLayout");
            textInputLayout2 = null;
        }
        textInputLayout2.setEndIconOnClickListener(new LoggerDialogFragment$$ExternalSyntheticLambda5(textInputEditText));
        LiveData<Logger.LogRecord> latestLogRecordLiveData = getLogger().getLatestLogRecordLiveData();
        if (latestLogRecordLiveData == null) {
            Toast.makeText(requireContext(), "Logger is not properly setup.", 0).show();
        } else {
            latestLogRecordLiveData.observe(this, new LoggerDialogFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass10(arrayList, this, searchRecyclerViewAdapter, daijishouLinearLayoutManager)));
        }
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), BooleanPreference.USE_DEBUG_MODE.getKey(), BooleanPreference.USE_DEBUG_MODE.getDefaultValue()).observe(getViewLifecycleOwner(), new LoggerDialogFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass11()));
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DaijishouConsoleViewModel onCreateView$lambda$6(Lazy<DaijishouConsoleViewModel> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.LoggerDialogFragment$onCreateView$1, reason: invalid class name */
    /* JADX INFO: compiled from: LoggerDialogFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "i", "", "<anonymous parameter 2>", "", "item", "Lcom/magneticchen/daijishou/logger/Logger$LogRecord;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass1 extends Lambda<Unit> implements Function4<View, Integer, Long, Logger.LogRecord, Unit> {
        AnonymousClass1() {
            super(4);
        }

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
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.LoggerDialogFragment$onCreateView$2, reason: invalid class name */
    /* JADX INFO: compiled from: LoggerDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/magneticchen/daijishou/dialog_fragments/LoggerDialogFragment$onCreateView$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class AnonymousClass2 extends RecyclerView.OnScrollListener {
        AnonymousClass2() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0) {
                LoggerDialogFragment.this.scrollingOnBackPressed = false;
            }
            super.onScrollStateChanged(recyclerView, newState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$7(LoggerDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DebugAndExperimentalDialogFragment.INSTANCE.newInstance().show(this$0.getParentFragmentManager(), DebugAndExperimentalDialogFragment.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateView$lambda$8(LoggerDialogFragment this$0, List searchLogRecordList, SearchRecyclerViewAdapter recyclerViewAdapter, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(searchLogRecordList, "$searchLogRecordList");
        Intrinsics.checkNotNullParameter(recyclerViewAdapter, "$recyclerViewAdapter");
        TextInputLayout textInputLayout = null;
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
            TextInputLayout textInputLayout2 = this$0.searchEditTextInputLayout;
            if (textInputLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchEditTextInputLayout");
            } else {
                textInputLayout = textInputLayout2;
            }
            textInputLayout.setHint(this$0.getSearchHint());
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

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.LoggerDialogFragment$onCreateView$7, reason: invalid class name */
    /* JADX INFO: compiled from: LoggerDialogFragment.kt */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"com/magneticchen/daijishou/dialog_fragments/LoggerDialogFragment$onCreateView$7", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class AnonymousClass7 implements TextWatcher {
        final /* synthetic */ SearchRecyclerViewAdapter $recyclerViewAdapter;
        final /* synthetic */ List<Logger.LogRecord> $searchLogRecordList;

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        AnonymousClass7(List<Logger.LogRecord> list, SearchRecyclerViewAdapter searchRecyclerViewAdapter) {
            this.$searchLogRecordList = list;
            this.$recyclerViewAdapter = searchRecyclerViewAdapter;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(LoggerDialogFragment.this), Dispatchers.getIO(), null, new LoggerDialogFragment$onCreateView$7$onTextChanged$1(s, LoggerDialogFragment.this, this.$searchLogRecordList, this.$recyclerViewAdapter, null), 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateView$lambda$11(LoggerDialogFragment this$0, TextInputEditText textInputEditText, Lazy console$delegate, TextView textView, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(console$delegate, "$console$delegate");
        if (i != 3) {
            return false;
        }
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), Dispatchers.getDefault(), null, new LoggerDialogFragment$onCreateView$8$1(this$0, textInputEditText, console$delegate, null), 2, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$12(TextInputEditText textInputEditText, View view) {
        Editable text = textInputEditText.getText();
        if (text != null) {
            text.clear();
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.LoggerDialogFragment$onCreateView$10, reason: invalid class name */
    /* JADX INFO: compiled from: LoggerDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/magneticchen/daijishou/logger/Logger$LogRecord;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass10 extends Lambda<Unit> implements Function1<Logger.LogRecord, Unit> {
        final /* synthetic */ SearchRecyclerViewAdapter $recyclerViewAdapter;
        final /* synthetic */ DaijishouLinearLayoutManager $recyclerViewLayoutManager;
        final /* synthetic */ List<Logger.LogRecord> $searchLogRecordList;
        final /* synthetic */ LoggerDialogFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass10(List<Logger.LogRecord> list, LoggerDialogFragment loggerDialogFragment, SearchRecyclerViewAdapter searchRecyclerViewAdapter, DaijishouLinearLayoutManager daijishouLinearLayoutManager) {
            super(1);
            this.$searchLogRecordList = list;
            this.this$0 = loggerDialogFragment;
            this.$recyclerViewAdapter = searchRecyclerViewAdapter;
            this.$recyclerViewLayoutManager = daijishouLinearLayoutManager;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Logger.LogRecord logRecord) {
            invoke2(logRecord);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Logger.LogRecord logRecord) {
            Set setSubtract;
            if (logRecord == null) {
                this.$searchLogRecordList.clear();
                this.this$0.refreshComponentsInPopupMenu();
                return;
            }
            LoggerDialogFragment loggerDialogFragment = this.this$0;
            List<Logger.LogRecord> logs = loggerDialogFragment.getLogger().getLogs();
            DaijishouRecyclerView daijishouRecyclerView = null;
            loggerDialogFragment.logs = logs != null ? (Logger.LogRecord[]) logs.toArray(new Logger.LogRecord[0]) : null;
            SortedSet<String> components = this.this$0.getLogger().getComponents();
            if (components != null) {
                Collection collectionValues = this.this$0.hashCodeToComponent.values();
                Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
                setSubtract = CollectionsKt.subtract(components, CollectionsKt.toSet(collectionValues));
            } else {
                setSubtract = null;
            }
            if (setSubtract != null && !setSubtract.isEmpty()) {
                this.this$0.refreshComponentsInPopupMenu();
            }
            if (this.this$0.logs == null) {
                this.$searchLogRecordList.clear();
                ConstraintLayout constraintLayout = this.this$0.backButtonLayout;
                if (constraintLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("backButtonLayout");
                    constraintLayout = null;
                }
                constraintLayout.requestFocus();
                this.$recyclerViewAdapter.notifyDataSetChanged();
                DaijishouRecyclerView daijishouRecyclerView2 = this.this$0.recyclerView;
                if (daijishouRecyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                } else {
                    daijishouRecyclerView = daijishouRecyclerView2;
                }
                daijishouRecyclerView.scrollToPosition(0);
                return;
            }
            List<Logger.LogRecord> listRequireFilteredLogs = this.this$0.requireFilteredLogs();
            List<Logger.LogRecord> list = this.$searchLogRecordList;
            DaijishouLinearLayoutManager daijishouLinearLayoutManager = this.$recyclerViewLayoutManager;
            SearchRecyclerViewAdapter searchRecyclerViewAdapter = this.$recyclerViewAdapter;
            LoggerDialogFragment loggerDialogFragment2 = this.this$0;
            for (Logger.LogRecord logRecord2 : listRequireFilteredLogs) {
                if (!list.contains(logRecord2)) {
                    boolean z = daijishouLinearLayoutManager.findFirstVisibleItemPosition() == 0;
                    list.add(0, logRecord2);
                    searchRecyclerViewAdapter.notifyItemInserted(0);
                    if (z) {
                        DaijishouRecyclerView daijishouRecyclerView3 = loggerDialogFragment2.recyclerView;
                        if (daijishouRecyclerView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                            daijishouRecyclerView3 = null;
                        }
                        daijishouRecyclerView3.scrollToPosition(0);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.LoggerDialogFragment$onCreateView$11, reason: invalid class name */
    /* JADX INFO: compiled from: LoggerDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass11 extends Lambda<Unit> implements Function1<Boolean, Unit> {
        AnonymousClass11() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            ConstraintLayout constraintLayout = LoggerDialogFragment.this.controlPanelButtonLayout;
            if (constraintLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("controlPanelButtonLayout");
                constraintLayout = null;
            }
            Intrinsics.checkNotNull(bool);
            constraintLayout.setVisibility(bool.booleanValue() ? 0 : 8);
        }
    }
}
