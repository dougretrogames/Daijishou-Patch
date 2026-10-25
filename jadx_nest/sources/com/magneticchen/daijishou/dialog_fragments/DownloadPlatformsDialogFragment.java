package com.magneticchen.daijishou.dialog_fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment;
import com.magneticchen.daijishou.daijishou_library_db.portables.PlatformsIndexJson;
import com.magneticchen.daijishou.daijishou_library_db.portables.PlatformsIndexPlatformListItemJson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: DownloadPlatformsDialogFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/magneticchen/daijishou/dialog_fragments/DownloadPlatformsDialogFragment;", "Lcom/magneticchen/daijishou/abstract_fragment_classes/DaijishouDialogFragment;", "()V", "adapter", "Landroid/widget/ArrayAdapter;", "", "listView", "Landroid/widget/ListView;", "listViewItems", "", "platformsIndexJson", "Lcom/magneticchen/daijishou/daijishou_library_db/portables/PlatformsIndexJson;", "progressBar", "Landroid/widget/ProgressBar;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DownloadPlatformsDialogFragment extends DaijishouDialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public ArrayAdapter<String> adapter;
    public ListView listView;
    public final List<String> listViewItems = new ArrayList();
    PlatformsIndexJson platformsIndexJson;
    public ProgressBar progressBar;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$10$lambda$2(DialogInterface dialogInterface, int i) {
    }

    /* JADX INFO: compiled from: DownloadPlatformsDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/magneticchen/daijishou/dialog_fragments/DownloadPlatformsDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/dialog_fragments/DownloadPlatformsDialogFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DownloadPlatformsDialogFragment newInstance() {
            return new DownloadPlatformsDialogFragment();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        Dialog dialog = getDialog();
        if (dialog != null) {
            Window window = dialog.getWindow();
            if (window != null) {
                window.setLayout(-2, -2);
            }
            Window window2 = dialog.getWindow();
            if (window2 != null) {
                window2.setFlags(1024, 1024);
            }
            Window window3 = dialog.getWindow();
            if (window3 != null) {
                window3.setBackgroundDrawable(AppCompatResources.getDrawable(requireContext(), R.drawable.dialog_background));
            }
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new DownloadPlatformsDialogFragment$onStart$1$1(this, fragmentActivityRequireActivity, dialog, null), 2, null);
        }
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        FragmentActivity activity = getActivity();
        AlertDialog alertDialogCreate = null;
        if (activity != null) {
            View viewInflate = activity.getLayoutInflater().inflate(R.layout.fragment_list_view_with_progress_bar_dialog, (ViewGroup) null);
            this.progressBar = (ProgressBar) viewInflate.findViewById(R.id.fragment_list_view_with_progress_bar_dialog_progress_bar);
            ListView listView = (ListView) viewInflate.findViewById(R.id.fragment_list_view_with_progress_bar_dialog_list_view);
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_multiple_choice, android.R.id.text1, this.listViewItems);
            this.adapter = arrayAdapter;
            listView.setAdapter((ListAdapter) arrayAdapter);
            this.listView = listView;
            ProgressBar progressBar = this.progressBar;
            Intrinsics.checkNotNull(progressBar);
            progressBar.setIndeterminate(true);
            alertDialogCreate = new AlertDialog.Builder(getContext()).setView(viewInflate).setTitle(getString(R.string.select_platforms)).setNeutralButton("Index uri", new DownloadPlatformsDialogFragment$$ExternalSyntheticLambda1(this)).setPositiveButton(getString(R.string._import), new DownloadPlatformsDialogFragment$$ExternalSyntheticLambda2()).setNegativeButton(getString(R.string.cancel), new DownloadPlatformsDialogFragment$$ExternalSyntheticLambda3()).create();
            listView.setOnItemClickListener(new DownloadPlatformsDialogFragment$$ExternalSyntheticLambda4(alertDialogCreate, this, listView));
            Intrinsics.checkNotNull(alertDialogCreate);
            setupDaijishouDialog(alertDialogCreate);
            alertDialogCreate.setOnShowListener(new DownloadPlatformsDialogFragment$$ExternalSyntheticLambda5(alertDialogCreate, this, listView, activity));
        }
        if (alertDialogCreate != null) {
            return alertDialogCreate;
        }
        throw new IllegalStateException("Activity cannot be null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$10$lambda$1(DownloadPlatformsDialogFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EditIndexUriDialogFragment.INSTANCE.newInstance().show(this$0.getParentFragmentManager(), "edit_index_uri");
        this$0.requireDialog().dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$10$lambda$4(AlertDialog alertDialog, DownloadPlatformsDialogFragment this$0, ListView listView, AdapterView adapterView, View view, int i, long j) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = this$0.getString(R.string.select_platforms_format);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String str = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(listView.getCheckedItemCount()), Integer.valueOf(listView.getAdapter().getCount())}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        alertDialog.setTitle(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$10$lambda$9(AlertDialog alertDialog, DownloadPlatformsDialogFragment this$0, ListView listView, FragmentActivity activity, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNull(alertDialog, "null cannot be cast to non-null type android.app.AlertDialog");
        Button button = alertDialog.getButton(-1);
        Intrinsics.checkNotNullExpressionValue(button, "getButton(...)");
        Button button2 = alertDialog.getButton(-2);
        Intrinsics.checkNotNullExpressionValue(button2, "getButton(...)");
        Button button3 = alertDialog.getButton(-3);
        Intrinsics.checkNotNullExpressionValue(button3, "getButton(...)");
        button.setOnClickListener(new DownloadPlatformsDialogFragment$$ExternalSyntheticLambda0(alertDialog, this$0, button, button2, button3, listView, activity));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$10$lambda$9$lambda$8(AlertDialog alertDialog, DownloadPlatformsDialogFragment this$0, Button button, Button negativeButton, Button positiveButton, ListView listView, FragmentActivity activity, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(button, "$button");
        Intrinsics.checkNotNullParameter(negativeButton, "$negativeButton");
        Intrinsics.checkNotNullParameter(positiveButton, "$positiveButton");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        alertDialog.setTitle("Importing...");
        ProgressBar progressBar = this$0.progressBar;
        Intrinsics.checkNotNull(progressBar);
        progressBar.setIndeterminate(true);
        button.setEnabled(false);
        negativeButton.setEnabled(false);
        positiveButton.setEnabled(false);
        SparseBooleanArray checkedItemPositions = listView.getCheckedItemPositions();
        PlatformsIndexJson platformsIndexJson = this$0.platformsIndexJson;
        if (platformsIndexJson != null) {
            int i = 0;
            String baseUri = platformsIndexJson.getBaseUri();
            ArrayList arrayList = new ArrayList();
            for (Object obj : platformsIndexJson.getPlatformList()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                PlatformsIndexPlatformListItemJson platformsIndexPlatformListItemJson = (PlatformsIndexPlatformListItemJson) obj;
                if (checkedItemPositions.get(i)) {
                    arrayList.add(platformsIndexPlatformListItemJson);
                }
                i = i2;
            }
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), Dispatchers.getIO(), null, new DownloadPlatformsDialogFragment$onCreateDialog$1$2$1$1$1$2(arrayList, activity, baseUri, this$0, new Ref.IntRef(), alertDialog, null), 2, null);
        }
    }
}
