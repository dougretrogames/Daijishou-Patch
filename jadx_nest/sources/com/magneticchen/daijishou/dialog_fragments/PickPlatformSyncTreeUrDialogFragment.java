package com.magneticchen.daijishou.dialog_fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment;
import com.magneticchen.daijishou.daijishou_library_db.PlatformEntity;
import com.magneticchen.daijishou.utils.FileUtils;
import com.magneticchen.daijishou.view_models.DaijishouLibraryModel;
import com.magneticchen.daijishou.view_models.DaijishouSynchronizationModel;
import com.magneticchen.daijishou.view_models.LibraryViewModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;

/* INFO: compiled from: PickPlatformSyncTreeUrDialogFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a²\u0006\n\u0010\u0006\u001a\u00020\u0007X\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/dialog_fragments/PickPlatformSyncTreeUrDialogFragment;", "Lcom/magneticchen/daijishou/abstract_fragment_classes/DaijishouDialogFragment;", "()V", "arrayItems", "", "Landroid/net/Uri;", "libraryViewModel", "Lcom/magneticchen/daijishou/view_models/LibraryViewModel;", "platformEntity", "Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;", "getPlatformEntity", "()Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;", "setPlatformEntity", "(Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;)V", "selectSyncTreeUriActivity", "Landroidx/activity/result/ActivityResultLauncher;", "waitForUri", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onStart", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PickPlatformSyncTreeUrDialogFragment extends DaijishouDialogFragment {

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public final List<Uri> arrayItems;
    public LibraryViewModel libraryViewModel;
    public PlatformEntity platformEntity;
    private ActivityResultLauncher<Uri> selectSyncTreeUriActivity;
    private boolean waitForUri;

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$11$lambda$10$lambda$3(DialogInterface dialogInterface, int i) {
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$11$lambda$10$lambda$4(DialogInterface dialogInterface, int i) {
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$11$lambda$10$lambda$5(DialogInterface dialogInterface, int i) {
    }

    public PickPlatformSyncTreeUrDialogFragment() {
        ActivityResultLauncher<Uri> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.OpenDocumentTree(), new PickPlatformSyncTreeUrDialogFragment$$ExternalSyntheticLambda8(this));
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.selectSyncTreeUriActivity = activityResultLauncherRegisterForActivityResult;
        this.arrayItems = new ArrayList();
    }

    public final PlatformEntity getPlatformEntity() {
        PlatformEntity platformEntity = this.platformEntity;
        if (platformEntity != null) {
            return platformEntity;
        }
        Intrinsics.throwUninitializedPropertyAccessException("platformEntity");
        return null;
    }

    public final void setPlatformEntity(PlatformEntity platformEntity) {
        Intrinsics.checkNotNullParameter(platformEntity, "<set-?>");
        this.platformEntity = platformEntity;
    }

    /* INFO: Access modifiers changed from: private */
    public static final void selectSyncTreeUriActivity$lambda$0(PickPlatformSyncTreeUrDialogFragment this$0, Uri uri) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context contextRequireContext = this$0.requireContext();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = this$0.getString(R.string.selected_uri_format);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String str = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(uri != null ? uri.getPath() : null)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        Toast.makeText(contextRequireContext, str, 0).show();
        if (uri != null && FileUtils.INSTANCE.isDownloadsDocument(uri)) {
            Toast.makeText(this$0.requireContext(), this$0.getString(R.string.download_folder_is_not_supported), 0).show();
            return;
        }
        if (uri == null) {
            Toast.makeText(this$0.requireContext(), this$0.getString(R.string.selected_uri_is_null), 0).show();
            return;
        }
        if (this$0.getPlatformEntity().getItemsSyncTreeUriList().indexOf(uri) == -1) {
            this$0.requireActivity().getContentResolver().takePersistableUriPermission(uri, 1);
            this$0.requireActivity().getContentResolver().takePersistableUriPermission(uri, 2);
            this$0.getPlatformEntity().getItemsSyncTreeUriList().add(uri);
            this$0.getDaijishouLibrary().updatePlatform(this$0.getPlatformEntity());
        } else {
            Toast.makeText(this$0.getContext(), this$0.getString(R.string.this_path_has_already_added), 0).show();
        }
        this$0.waitForUri = false;
    }

    /* INFO: compiled from: PickPlatformSyncTreeUrDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/dialog_fragments/PickPlatformSyncTreeUrDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/dialog_fragments/PickPlatformSyncTreeUrDialogFragment;", "platformEntity", "Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PickPlatformSyncTreeUrDialogFragment newInstance(PlatformEntity platformEntity) {
            Intrinsics.checkNotNullParameter(platformEntity, "platformEntity");
            PickPlatformSyncTreeUrDialogFragment pickPlatformSyncTreeUrDialogFragment = new PickPlatformSyncTreeUrDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putLong("platformEntityId", platformEntity.getId());
            pickPlatformSyncTreeUrDialogFragment.setArguments(bundle);
            return pickPlatformSyncTreeUrDialogFragment;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (window != null) {
            window.setBackgroundDrawable(AppCompatResources.getDrawable(requireContext(), R.drawable.dialog_background));
        }
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PickPlatformSyncTreeUrDialogFragment pickPlatformSyncTreeUrDialogFragment = this;
        this.libraryViewModel = onCreate$lambda$1((Lazy<LibraryViewModel>) FragmentViewModelLazyKt.createViewModelLazy(pickPlatformSyncTreeUrDialogFragment, Reflection.getOrCreateKotlinClass(LibraryViewModel.class), new PickPlatformSyncTreeUrDialogFragment$onCreate$$inlined$activityViewModels$default$1(pickPlatformSyncTreeUrDialogFragment), new PickPlatformSyncTreeUrDialogFragment$onCreate$$inlined$activityViewModels$default$2(null, pickPlatformSyncTreeUrDialogFragment), new PickPlatformSyncTreeUrDialogFragment$onCreate$$inlined$activityViewModels$default$3(pickPlatformSyncTreeUrDialogFragment)));
    }

    private static final LibraryViewModel onCreate$lambda$1(Lazy<LibraryViewModel> lazy) {
        return lazy.getValue();
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        DaijishouLibraryModel daijishouLibrary = getDaijishouLibrary();
        Bundle arguments = getArguments();
        AlertDialog alertDialogCreate = null;
        Long lValueOf = arguments != null ? Long.valueOf(arguments.getLong("platformEntityId")) : null;
        Intrinsics.checkNotNull(lValueOf);
        PlatformEntity platformByIdStatically = daijishouLibrary.getPlatformByIdStatically(lValueOf.longValue());
        Intrinsics.checkNotNull(platformByIdStatically);
        setPlatformEntity(platformByIdStatically);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Context context = getContext();
            if (context != null) {
                View viewInflate = activity.getLayoutInflater().inflate(R.layout.fragment_platform_sync_paths, (ViewGroup) null);
                ListView listView = (ListView) viewInflate.findViewById(R.id.platform_sync_paths_list_view);
                PickPlatformSyncTreeUrDialogFragment$onCreateDialog$1$1$adapter$1 pickPlatformSyncTreeUrDialogFragment$onCreateDialog$1$1$adapter$1 = new PickPlatformSyncTreeUrDialogFragment$onCreateDialog$1$1$adapter$1(context, this, this.arrayItems);
                listView.setAdapter((ListAdapter) pickPlatformSyncTreeUrDialogFragment$onCreateDialog$1$1$adapter$1);
                listView.setOnItemClickListener(new PickPlatformSyncTreeUrDialogFragment$$ExternalSyntheticLambda3(this));
                getDaijishouLibrary().getPlatformById(getPlatformEntity().getId()).observe(this, new PickPlatformSyncTreeUrDialogFragment$sam$androidx_lifecycle_Observer$0(new PickPlatformSyncTreeUrDialogFragment$onCreateDialog$1$1$2(this, pickPlatformSyncTreeUrDialogFragment$onCreateDialog$1$1$adapter$1)));
                alertDialogCreate = new AlertDialog.Builder(context).setView(viewInflate).setTitle(getString(R.string.synchronization_paths_title)).setPositiveButton(getString(R.string.sync), new PickPlatformSyncTreeUrDialogFragment$$ExternalSyntheticLambda4()).setNegativeButton(getString(R.string.finish), new PickPlatformSyncTreeUrDialogFragment$$ExternalSyntheticLambda5()).setNeutralButton(getString(R.string.add_more), new PickPlatformSyncTreeUrDialogFragment$$ExternalSyntheticLambda6()).create();
                Intrinsics.checkNotNull(alertDialogCreate);
                setupDaijishouDialog(alertDialogCreate);
                alertDialogCreate.setOnShowListener(new PickPlatformSyncTreeUrDialogFragment$$ExternalSyntheticLambda7(alertDialogCreate, this));
            }
            if (alertDialogCreate != null) {
                return alertDialogCreate;
            }
            throw new IllegalStateException("Context cannot be null");
        }
        throw new IllegalStateException("Activity cannot be null");
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$11$lambda$10$lambda$2$removeSyncTreeUri(PickPlatformSyncTreeUrDialogFragment pickPlatformSyncTreeUrDialogFragment, int i, boolean z) {
        AcknowledgementDialogFragment.Companion.newInstance$default(AcknowledgementDialogFragment.INSTANCE, pickPlatformSyncTreeUrDialogFragment.getString(R.string.are_you_sure), pickPlatformSyncTreeUrDialogFragment.getString(R.string.delete_uri_warning), null, null, null, 28, null).setOnAcknowledgedListener(new PickPlatformSyncTreeUrDialogFragment$onCreateDialog$1$1$1$removeSyncTreeUri$1(i, pickPlatformSyncTreeUrDialogFragment, z)).setOnCanceledListener(new PickPlatformSyncTreeUrDialogFragment$onCreateDialog$1$1$1$removeSyncTreeUri$2(pickPlatformSyncTreeUrDialogFragment)).show(pickPlatformSyncTreeUrDialogFragment.getParentFragmentManager(), AcknowledgementDialogFragment.class.getName());
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$11$lambda$10$lambda$2(PickPlatformSyncTreeUrDialogFragment this$0, AdapterView adapterView, View view, int i, long j) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AcknowledgementDialogFragment.Companion.newInstance$default(AcknowledgementDialogFragment.INSTANCE, this$0.getString(R.string.keep_records_warning_title), this$0.getString(R.string.keep_records_warning), this$0.getString(R.string.keep_records), this$0.getString(R.string.remove), null, 16, null).setOnAcknowledgedListener(new PickPlatformSyncTreeUrDialogFragment$onCreateDialog$1$1$1$1(this$0, i)).setOnCanceledListener(new PickPlatformSyncTreeUrDialogFragment$onCreateDialog$1$1$1$2(this$0, i)).show(this$0.getParentFragmentManager(), AcknowledgementDialogFragment.class.getName());
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$11$lambda$10$lambda$9(AlertDialog alertDialog, PickPlatformSyncTreeUrDialogFragment this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(alertDialog, "null cannot be cast to non-null type android.app.AlertDialog");
        Button button = alertDialog.getButton(-3);
        Intrinsics.checkNotNullExpressionValue(button, "getButton(...)");
        button.setOnClickListener(new PickPlatformSyncTreeUrDialogFragment$$ExternalSyntheticLambda0(this$0));
        Button button2 = alertDialog.getButton(-1);
        Intrinsics.checkNotNullExpressionValue(button2, "getButton(...)");
        button2.setOnClickListener(new PickPlatformSyncTreeUrDialogFragment$$ExternalSyntheticLambda1(this$0, alertDialog));
        Button button3 = alertDialog.getButton(-2);
        Intrinsics.checkNotNullExpressionValue(button3, "getButton(...)");
        button3.setOnClickListener(new PickPlatformSyncTreeUrDialogFragment$$ExternalSyntheticLambda2(this$0, alertDialog));
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$11$lambda$10$lambda$9$lambda$6(PickPlatformSyncTreeUrDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.waitForUri = true;
        this$0.selectSyncTreeUriActivity.launch(Uri.parse("/storage/"));
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$11$lambda$10$lambda$9$lambda$7(PickPlatformSyncTreeUrDialogFragment this$0, AlertDialog alertDialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.waitForUri) {
            return;
        }
        DaijishouSynchronizationModel daijishouSynchronization = this$0.getDaijishouSynchronization();
        FragmentActivity fragmentActivityRequireActivity = this$0.requireActivity();
        Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        daijishouSynchronization.scheduleSynchronizationOfPlatformByPlatformId((AppCompatActivity) fragmentActivityRequireActivity, this$0.getPlatformEntity().getId());
        alertDialog.dismiss();
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$11$lambda$10$lambda$9$lambda$8(PickPlatformSyncTreeUrDialogFragment this$0, AlertDialog alertDialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.waitForUri) {
            return;
        }
        alertDialog.dismiss();
    }
}
