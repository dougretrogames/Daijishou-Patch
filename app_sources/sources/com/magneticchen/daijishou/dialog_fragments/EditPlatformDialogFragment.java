package com.magneticchen.daijishou.dialog_fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment;
import com.magneticchen.daijishou.application_data.Constants;
import com.magneticchen.daijishou.daijishou_library_db.PlatformEntity;
import com.magneticchen.daijishou.daijishou_library_db.PlayerEntity;
import com.magneticchen.daijishou.utils.AutoCompleteAdapter;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import net.lingala.zip4j.util.InternalZipConstants;

/* INFO: compiled from: EditPlatformDialogFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u001eH\u0016J\b\u0010$\u001a\u00020\u001eH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/magneticchen/daijishou/dialog_fragments/EditPlatformDialogFragment;", "Lcom/magneticchen/daijishou/abstract_fragment_classes/DaijishouDialogFragment;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "importBoxArtsFromUriActivity", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/net/Uri;", "importDatFileFromUriActivity", "", "kotlin.jvm.PlatformType", "importSnapshotsFromUriActivity", "importTitlesFromUriActivity", "importXMLFileFromUriActivity", "job", "Lkotlinx/coroutines/Job;", "playerArrayAdapter", "Landroid/widget/ArrayAdapter;", "selectWallpaperActivity", "selectedWallpaperUriLiveData", "Landroidx/lifecycle/MutableLiveData;", "wallpaperDirectoryName", "deleteWallpaperOfPlatformEntity", "", "newPlatformEntity", "Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;", "ensureWallpaperDirectory", "", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onStart", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class EditPlatformDialogFragment extends DaijishouDialogFragment implements CoroutineScope {

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public ActivityResultLauncher<Uri> importBoxArtsFromUriActivity;
    private ActivityResultLauncher<String> importDatFileFromUriActivity;
    public ActivityResultLauncher<Uri> importSnapshotsFromUriActivity;
    public ActivityResultLauncher<Uri> importTitlesFromUriActivity;
    private ActivityResultLauncher<String> importXMLFileFromUriActivity;
    private Job job = JobKt.Job$default((Job) null, 1, (Object) null);
    public ArrayAdapter<String> playerArrayAdapter;
    private ActivityResultLauncher<String> selectWallpaperActivity;
    private final MutableLiveData<Uri> selectedWallpaperUriLiveData;
    public final String wallpaperDirectoryName;

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$48$lambda$47$lambda$40(DialogInterface dialogInterface, int i) {
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$48$lambda$47$lambda$42(DialogInterface dialogInterface, int i) {
    }

    public EditPlatformDialogFragment() {
        ActivityResultLauncher<Uri> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.OpenDocumentTree(), new EditPlatformDialogFragment$$ExternalSyntheticLambda18(this));
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.importBoxArtsFromUriActivity = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<Uri> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.OpenDocumentTree(), new EditPlatformDialogFragment$$ExternalSyntheticLambda19(this));
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(...)");
        this.importSnapshotsFromUriActivity = activityResultLauncherRegisterForActivityResult2;
        ActivityResultLauncher<Uri> activityResultLauncherRegisterForActivityResult3 = registerForActivityResult(new ActivityResultContracts.OpenDocumentTree(), new EditPlatformDialogFragment$$ExternalSyntheticLambda20(this));
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult3, "registerForActivityResult(...)");
        this.importTitlesFromUriActivity = activityResultLauncherRegisterForActivityResult3;
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult4 = registerForActivityResult(new ActivityResultContracts.GetContent(), new EditPlatformDialogFragment$$ExternalSyntheticLambda21(this));
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult4, "registerForActivityResult(...)");
        this.importDatFileFromUriActivity = activityResultLauncherRegisterForActivityResult4;
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult5 = registerForActivityResult(new ActivityResultContracts.GetContent(), new EditPlatformDialogFragment$$ExternalSyntheticLambda22(this));
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult5, "registerForActivityResult(...)");
        this.importXMLFileFromUriActivity = activityResultLauncherRegisterForActivityResult5;
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult6 = registerForActivityResult(new ActivityResultContracts.GetContent(), new EditPlatformDialogFragment$$ExternalSyntheticLambda23(this));
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult6, "registerForActivityResult(...)");
        this.selectWallpaperActivity = activityResultLauncherRegisterForActivityResult6;
        this.selectedWallpaperUriLiveData = new MutableLiveData<>();
        this.wallpaperDirectoryName = Constants.platformWallpapersDirectory;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return Dispatchers.getMain().plus(this.job);
    }

    /* INFO: compiled from: EditPlatformDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/dialog_fragments/EditPlatformDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/dialog_fragments/EditPlatformDialogFragment;", "platformEntity", "Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EditPlatformDialogFragment newInstance(PlatformEntity platformEntity) {
            EditPlatformDialogFragment editPlatformDialogFragment = new EditPlatformDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("platformEntity", platformEntity);
            editPlatformDialogFragment.setArguments(bundle);
            return editPlatformDialogFragment;
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static final void importBoxArtsFromUriActivity$lambda$1(EditPlatformDialogFragment this$0, Uri uri) {
        PlatformEntity platformEntity;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context contextRequireContext = this$0.requireContext();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = this$0.getString(R.string.selected_uri_format);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String str = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(uri != null ? uri.getPath() : null)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        Toast.makeText(contextRequireContext, str, 0).show();
        if (uri == null) {
            Toast.makeText(this$0.requireContext(), this$0.getString(R.string.selected_uri_is_null), 0).show();
            return;
        }
        Bundle arguments = this$0.getArguments();
        if (arguments == null || (platformEntity = (PlatformEntity) arguments.getParcelable("platformEntity")) == null) {
            return;
        }
        ProgressDialogFragment progressDialogFragmentNewInstance$default = ProgressDialogFragment.Companion.newInstance$default(ProgressDialogFragment.INSTANCE, null, null, 3, null);
        progressDialogFragmentNewInstance$default.show(this$0.getParentFragmentManager(), ProgressDialogFragment.class.getName());
        this$0.getDaijishouSynchronization().importBoxArtsFromUriForPlatformId(platformEntity.getId(), uri, true, new EditPlatformDialogFragment$importBoxArtsFromUriActivity$1$1$1(this$0, progressDialogFragmentNewInstance$default));
    }

    /* INFO: Access modifiers changed from: private */
    public static final void importSnapshotsFromUriActivity$lambda$3(EditPlatformDialogFragment this$0, Uri uri) {
        PlatformEntity platformEntity;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context contextRequireContext = this$0.requireContext();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = this$0.getString(R.string.selected_uri_format);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String str = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(uri != null ? uri.getPath() : null)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        Toast.makeText(contextRequireContext, str, 0).show();
        if (uri == null) {
            Toast.makeText(this$0.requireContext(), this$0.getString(R.string.selected_uri_is_null), 0).show();
            return;
        }
        Bundle arguments = this$0.getArguments();
        if (arguments == null || (platformEntity = (PlatformEntity) arguments.getParcelable("platformEntity")) == null) {
            return;
        }
        ProgressDialogFragment progressDialogFragmentNewInstance$default = ProgressDialogFragment.Companion.newInstance$default(ProgressDialogFragment.INSTANCE, null, null, 3, null);
        progressDialogFragmentNewInstance$default.show(this$0.getParentFragmentManager(), ProgressDialogFragment.class.getName());
        this$0.getDaijishouSynchronization().importSnapshotsFromUriForPlatformId(platformEntity.getId(), uri, true, new EditPlatformDialogFragment$importSnapshotsFromUriActivity$1$1$1(this$0, progressDialogFragmentNewInstance$default));
    }

    /* INFO: Access modifiers changed from: private */
    public static final void importTitlesFromUriActivity$lambda$5(EditPlatformDialogFragment this$0, Uri uri) {
        PlatformEntity platformEntity;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context contextRequireContext = this$0.requireContext();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = this$0.getString(R.string.selected_uri_format);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String str = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(uri != null ? uri.getPath() : null)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        Toast.makeText(contextRequireContext, str, 0).show();
        if (uri == null) {
            Toast.makeText(this$0.requireContext(), this$0.getString(R.string.selected_uri_is_null), 0).show();
            return;
        }
        Bundle arguments = this$0.getArguments();
        if (arguments == null || (platformEntity = (PlatformEntity) arguments.getParcelable("platformEntity")) == null) {
            return;
        }
        ProgressDialogFragment progressDialogFragmentNewInstance$default = ProgressDialogFragment.Companion.newInstance$default(ProgressDialogFragment.INSTANCE, null, null, 3, null);
        progressDialogFragmentNewInstance$default.show(this$0.getParentFragmentManager(), ProgressDialogFragment.class.getName());
        this$0.getDaijishouSynchronization().importTitlesFromUriForPlatformId(platformEntity.getId(), uri, true, new EditPlatformDialogFragment$importTitlesFromUriActivity$1$1$1(this$0, progressDialogFragmentNewInstance$default));
    }

    /* INFO: Access modifiers changed from: private */
    public static final void importDatFileFromUriActivity$lambda$7(EditPlatformDialogFragment this$0, Uri uri) {
        PlatformEntity platformEntity;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context contextRequireContext = this$0.requireContext();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = this$0.getString(R.string.selected_uri_format);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String str = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(uri != null ? uri.getPath() : null)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        Toast.makeText(contextRequireContext, str, 0).show();
        if (uri == null) {
            Toast.makeText(this$0.requireContext(), this$0.getString(R.string.selected_uri_is_null), 0).show();
            return;
        }
        Bundle arguments = this$0.getArguments();
        if (arguments == null || (platformEntity = (PlatformEntity) arguments.getParcelable("platformEntity")) == null) {
            return;
        }
        ProgressDialogFragment progressDialogFragmentNewInstance$default = ProgressDialogFragment.Companion.newInstance$default(ProgressDialogFragment.INSTANCE, null, null, 3, null);
        progressDialogFragmentNewInstance$default.show(this$0.getParentFragmentManager(), ProgressDialogFragment.class.getName());
        this$0.getDaijishouSynchronization().importDatFilesFromUriForPlatformId(platformEntity.getId(), uri, true, new EditPlatformDialogFragment$importDatFileFromUriActivity$1$1$1(this$0, progressDialogFragmentNewInstance$default));
    }

    /* INFO: Access modifiers changed from: private */
    public static final void importXMLFileFromUriActivity$lambda$9(EditPlatformDialogFragment this$0, Uri uri) {
        PlatformEntity platformEntity;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context contextRequireContext = this$0.requireContext();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = this$0.getString(R.string.selected_uri_format);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String str = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(uri != null ? uri.getPath() : null)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        Toast.makeText(contextRequireContext, str, 0).show();
        if (uri == null) {
            Toast.makeText(this$0.requireContext(), this$0.getString(R.string.selected_uri_is_null), 0).show();
            return;
        }
        Bundle arguments = this$0.getArguments();
        if (arguments == null || (platformEntity = (PlatformEntity) arguments.getParcelable("platformEntity")) == null) {
            return;
        }
        ProgressDialogFragment progressDialogFragmentNewInstance$default = ProgressDialogFragment.Companion.newInstance$default(ProgressDialogFragment.INSTANCE, null, null, 3, null);
        progressDialogFragmentNewInstance$default.show(this$0.getParentFragmentManager(), ProgressDialogFragment.class.getName());
        this$0.getDaijishouSynchronization().importXMLFilesFromUriForPlatformId(platformEntity.getId(), uri, true, new EditPlatformDialogFragment$importXMLFileFromUriActivity$1$1$1(this$0, progressDialogFragmentNewInstance$default));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            Window window = dialog.getWindow();
            if (window != null) {
                window.setLayout(-1, -1);
            }
            Window window2 = dialog.getWindow();
            if (window2 != null) {
                window2.setFlags(1024, 1024);
            }
            Window window3 = dialog.getWindow();
            if (window3 != null) {
                window3.setBackgroundDrawable(AppCompatResources.getDrawable(requireContext(), R.drawable.dialog_background));
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Job.DefaultImpls.cancel$default(this.job, (CancellationException) null, 1, (Object) null);
    }

    /* INFO: Access modifiers changed from: private */
    public static final void selectWallpaperActivity$lambda$10(EditPlatformDialogFragment this$0, Uri uri) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.selectedWallpaperUriLiveData.setValue(uri);
    }

    /* INFO: Access modifiers changed from: private */
    public final void ensureWallpaperDirectory() {
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        File file = new File(contextRequireContext.getFilesDir() + InternalZipConstants.ZIP_FILE_SEPARATOR + this.wallpaperDirectoryName + InternalZipConstants.ZIP_FILE_SEPARATOR);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    private final boolean deleteWallpaperOfPlatformEntity(PlatformEntity newPlatformEntity) {
        if (newPlatformEntity.getWallpaperPath() != null) {
            try {
                File file = new File(new URI(newPlatformEntity.getWallpaperPath()).getPath());
                return !file.exists() || file.delete();
            } catch (java.net.URISyntaxException e) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(e);
            }
        }
        return true;
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AutoCompleteTextView autoCompleteTextView;
        SwitchMaterial switchMaterial;
        ArrayList arrayList;
        ArrayList arrayList2;
        EditText editText;
        ArrayList arrayList3;
        ArrayList arrayList4;
        SwitchMaterial switchMaterial2;
        CheckBox checkBox;
        String string;
        boolean z;
        Bundle arguments = getArguments();
        AlertDialog alertDialogCreate = null;
        PlatformEntity platformEntity = arguments != null ? (PlatformEntity) arguments.getParcelable("platformEntity") : null;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            throw new IllegalStateException("Activity cannot be null");
        }
        Context context = getContext();
        if (context != null) {
            View viewInflate = activity.getLayoutInflater().inflate(R.layout.form_edit_platform, (ViewGroup) null);
            int[] intArray = getResources().getIntArray(R.array.retro_achievements_console_id_array);
            Intrinsics.checkNotNullExpressionValue(intArray, "getIntArray(...)");
            ArrayList arrayList5 = new ArrayList(intArray.length);
            for (int i : intArray) {
                arrayList5.add(Long.valueOf(i));
            }
            List list = CollectionsKt.toList(arrayList5);
            String[] stringArray = getResources().getStringArray(R.array.retro_achievements_console_id_description_array);
            Intrinsics.checkNotNullExpressionValue(stringArray, "getStringArray(...)");
            List list2 = ArraysKt.toList(stringArray);
            int size = list.size();
            ArrayList arrayList6 = new ArrayList(size);
            for (int i2 = 0; i2 < size; i2++) {
                arrayList6.add(list.get(i2) + " - " + list2.get(i2));
            }
            ArrayList arrayList7 = arrayList6;
            String[] stringArray2 = getResources().getStringArray(R.array.scraper_source_array);
            Intrinsics.checkNotNullExpressionValue(stringArray2, "getStringArray(...)");
            List list3 = ArraysKt.toList(stringArray2);
            String[] stringArray3 = getResources().getStringArray(R.array.box_art_aspect_ratio_array);
            Intrinsics.checkNotNullExpressionValue(stringArray3, "getStringArray(...)");
            List list4 = ArraysKt.toList(stringArray3);
            String[] stringArray4 = getResources().getStringArray(R.array.box_art_aspect_ratio_description_array);
            Intrinsics.checkNotNullExpressionValue(stringArray4, "getStringArray(...)");
            List list5 = ArraysKt.toList(stringArray4);
            int size2 = list4.size();
            ArrayList arrayList8 = new ArrayList(size2);
            int i3 = 0;
            while (i3 < size2) {
                arrayList8.add(list4.get(i3) + " - " + list5.get(i3));
                i3++;
                activity = activity;
                list4 = list4;
            }
            FragmentActivity fragmentActivity = activity;
            ArrayList arrayList9 = arrayList8;
            String[] stringArray5 = getResources().getStringArray(R.array.screen_aspect_ratio_array);
            Intrinsics.checkNotNullExpressionValue(stringArray5, "getStringArray(...)");
            List list6 = ArraysKt.toList(stringArray5);
            String[] stringArray6 = getResources().getStringArray(R.array.screen_aspect_ratio_description_array);
            Intrinsics.checkNotNullExpressionValue(stringArray6, "getStringArray(...)");
            List list7 = ArraysKt.toList(stringArray6);
            int size3 = list6.size();
            ArrayList arrayList10 = new ArrayList(size3);
            int i4 = 0;
            while (i4 < size3) {
                arrayList10.add(list6.get(i4) + " - " + list7.get(i4));
                i4++;
                list6 = list6;
            }
            ArrayList arrayList11 = arrayList10;
            List mutableList = CollectionsKt.toMutableList((Collection) getDaijishouLibrary().getAllPlayersStatically());
            int size4 = mutableList.size();
            ArrayList arrayList12 = new ArrayList(size4);
            for (int i5 = 0; i5 < size4; i5++) {
                arrayList12.add(i5 + " - " + ((PlayerEntity) mutableList.get(i5)).getName());
            }
            ArrayList arrayList13 = arrayList12;
            int size5 = mutableList.size();
            ArrayList arrayList14 = new ArrayList(size5);
            for (int i6 = 0; i6 < size5; i6++) {
                arrayList14.add(((PlayerEntity) mutableList.get(i6)).getName());
            }
            ArrayList arrayList15 = arrayList14;
            int size6 = mutableList.size();
            ArrayList arrayList16 = new ArrayList(size6);
            for (int i7 = 0; i7 < size6; i7++) {
                arrayList16.add(Long.valueOf(((PlayerEntity) mutableList.get(i7)).getId()));
            }
            ArrayList arrayList17 = arrayList16;
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ArrayList arrayList18 = new ArrayList();
            ArrayList arrayList19 = new ArrayList();
            ArrayList arrayList20 = new ArrayList();
            EditText editText2 = (EditText) viewInflate.findViewById(R.id.platform_name_edit_text);
            EditText editText3 = (EditText) viewInflate.findViewById(R.id.platform_shortname_edit_text);
            CheckBox checkBox2 = (CheckBox) viewInflate.findViewById(R.id.platform_visible_check_box);
            CheckBox checkBox3 = (CheckBox) viewInflate.findViewById(R.id.platform_scrape_preview_media_check_box);
            Button button = (Button) viewInflate.findViewById(R.id.playable_item_select_wallpaper_button);
            Button button2 = (Button) viewInflate.findViewById(R.id.platform_wallpaper_clear_wallpaper_button);
            TextView textView = (TextView) viewInflate.findViewById(R.id.platform_is_wallpaper_selected_text_view);
            EditText editText4 = (EditText) viewInflate.findViewById(R.id.platform_accepted_filename_regex_edit_text);
            Button button3 = (Button) viewInflate.findViewById(R.id.playable_item_import_preview_media_button);
            Button button4 = (Button) viewInflate.findViewById(R.id.playable_item_import_dat_file_button);
            Button button5 = (Button) viewInflate.findViewById(R.id.playable_item_import_xml_file_button);
            AutoCompleteTextView autoCompleteTextView2 = (AutoCompleteTextView) viewInflate.findViewById(R.id.platform_retro_achievements_console_id_search_text_view);
            Chip chip = (Chip) viewInflate.findViewById(R.id.platform_retro_achievements_console_id_add_button);
            ChipGroup chipGroup = (ChipGroup) viewInflate.findViewById(R.id.platform_retro_achievements_console_ids_chip_group);
            AutoCompleteTextView autoCompleteTextView3 = (AutoCompleteTextView) viewInflate.findViewById(R.id.platform_scraper_source_search_text_view);
            Chip chip2 = (Chip) viewInflate.findViewById(R.id.platform_scraper_source_add_button);
            ChipGroup chipGroup2 = (ChipGroup) viewInflate.findViewById(R.id.platform_scraper_sources_chip_group);
            AutoCompleteTextView autoCompleteTextView4 = (AutoCompleteTextView) viewInflate.findViewById(R.id.platform_default_player_select);
            AutoCompleteTextView autoCompleteTextView5 = (AutoCompleteTextView) viewInflate.findViewById(R.id.platform_player_search_text_view);
            Chip chip3 = (Chip) viewInflate.findViewById(R.id.platform_player_add_button);
            ChipGroup chipGroup3 = (ChipGroup) viewInflate.findViewById(R.id.platform_players_chip_group);
            SwitchMaterial switchMaterial3 = (SwitchMaterial) viewInflate.findViewById(R.id.custom_box_art_aspect_ratio_switch);
            AutoCompleteTextView autoCompleteTextView6 = (AutoCompleteTextView) viewInflate.findViewById(R.id.platform_box_art_aspect_ratio_select);
            EditText editText5 = (EditText) viewInflate.findViewById(R.id.platform_custom_box_art_aspect_ratio_edit_text);
            SwitchMaterial switchMaterial4 = (SwitchMaterial) viewInflate.findViewById(R.id.custom_screen_aspect_ratio_switch);
            AutoCompleteTextView autoCompleteTextView7 = (AutoCompleteTextView) viewInflate.findViewById(R.id.platform_screen_aspect_ratio_select);
            EditText editText6 = (EditText) viewInflate.findViewById(R.id.platform_custom_screen_aspect_ratio_edit_text);
            button.setOnClickListener(new EditPlatformDialogFragment$$ExternalSyntheticLambda25(this));
            FragmentActivity fragmentActivity2 = fragmentActivity;
            CheckBox checkBox4 = checkBox2;
            PlatformEntity platformEntity2 = platformEntity;
            EditText editText7 = editText4;
            AutoCompleteTextView autoCompleteTextView8 = autoCompleteTextView5;
            List list8 = list;
            EditText editText8 = editText3;
            this.selectedWallpaperUriLiveData.observe(fragmentActivity2, new EditPlatformDialogFragment$sam$androidx_lifecycle_Observer$0(new EditPlatformDialogFragment$onCreateDialog$1$1$2(this, context, objectRef, textView, booleanRef)));
            button2.setOnClickListener(new EditPlatformDialogFragment$$ExternalSyntheticLambda5(textView, this, booleanRef));
            Intrinsics.checkNotNull(context);
            autoCompleteTextView2.setAdapter(new AutoCompleteAdapter(context, R.layout.list_item_dropdown_item, arrayList7));
            EditPlatformDialogFragment$$ExternalSyntheticLambda6 editPlatformDialogFragment$$ExternalSyntheticLambda6 = new EditPlatformDialogFragment$$ExternalSyntheticLambda6(autoCompleteTextView2, arrayList7, this, list8, arrayList19, context, chipGroup);
            ArrayList arrayList21 = arrayList7;
            chip.setOnClickListener(editPlatformDialogFragment$$ExternalSyntheticLambda6);
            autoCompleteTextView3.setAdapter(new AutoCompleteAdapter(context, R.layout.list_item_dropdown_item, list3));
            ChipGroup chipGroup4 = chipGroup2;
            chip2.setOnClickListener(new EditPlatformDialogFragment$$ExternalSyntheticLambda7(autoCompleteTextView3, list3, this, arrayList18, context, chipGroup2));
            List list9 = mutableList;
            ArrayList arrayList22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list9, 10));
            int i8 = 0;
            for (Object obj : list9) {
                int i9 = i8 + 1;
                if (i8 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (!arrayList20.contains(Long.valueOf(((PlayerEntity) obj).getId()))) {
                    i8 = -1;
                }
                arrayList22.add(Integer.valueOf(i8));
                i8 = i9;
            }
            ArrayList arrayList23 = new ArrayList();
            for (Object obj2 : arrayList22) {
                if (((Number) obj2).intValue() >= 0) {
                    arrayList23.add(obj2);
                }
            }
            ArrayList arrayList24 = arrayList23;
            ArrayList arrayList25 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList24, 10));
            Iterator it = arrayList24.iterator();
            while (it.hasNext()) {
                arrayList25.add((String) arrayList13.get(((Number) it.next()).intValue()));
            }
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(context, R.layout.list_item_dropdown_item, arrayList25);
            this.playerArrayAdapter = arrayAdapter;
            autoCompleteTextView4.setAdapter(arrayAdapter);
            AutoCompleteAdapter autoCompleteAdapter = new AutoCompleteAdapter(context, R.layout.list_item_dropdown_item, arrayList13);
            autoCompleteTextView8.setAdapter(autoCompleteAdapter);
            getDaijishouLibrary().getAllPlayers().observe(fragmentActivity2, new EditPlatformDialogFragment$sam$androidx_lifecycle_Observer$0(new EditPlatformDialogFragment$onCreateDialog$1$1$9(mutableList, arrayList13, arrayList15, arrayList17, this, autoCompleteAdapter, arrayList20)));
            EditPlatformDialogFragment editPlatformDialogFragment = this;
            EditPlatformDialogFragment$$ExternalSyntheticLambda8 editPlatformDialogFragment$$ExternalSyntheticLambda8 = new EditPlatformDialogFragment$$ExternalSyntheticLambda8(autoCompleteTextView8, arrayList13, editPlatformDialogFragment, arrayList17, arrayList20, context, chipGroup3);
            ArrayList arrayList26 = arrayList20;
            Context context2 = context;
            ChipGroup chipGroup5 = chipGroup3;
            chip3.setOnClickListener(editPlatformDialogFragment$$ExternalSyntheticLambda8);
            AutoCompleteTextView autoCompleteTextView9 = autoCompleteTextView6;
            autoCompleteTextView9.setAdapter(new AutoCompleteAdapter(context2, R.layout.list_item_dropdown_item, arrayList9));
            SwitchMaterial switchMaterial5 = switchMaterial3;
            switchMaterial5.setOnCheckedChangeListener(new EditPlatformDialogFragment$$ExternalSyntheticLambda9(switchMaterial5, autoCompleteTextView9, editText5));
            ArrayList arrayList27 = arrayList11;
            autoCompleteTextView7.setAdapter(new AutoCompleteAdapter(context2, R.layout.list_item_dropdown_item, arrayList27));
            SwitchMaterial switchMaterial6 = switchMaterial4;
            EditText editText9 = editText6;
            switchMaterial6.setOnCheckedChangeListener(new EditPlatformDialogFragment$$ExternalSyntheticLambda10(switchMaterial6, autoCompleteTextView7, editText9));
            button3.setOnClickListener(new EditPlatformDialogFragment$$ExternalSyntheticLambda12(editPlatformDialogFragment));
            button4.setOnClickListener(new EditPlatformDialogFragment$$ExternalSyntheticLambda13(editPlatformDialogFragment));
            button5.setOnClickListener(new EditPlatformDialogFragment$$ExternalSyntheticLambda14(editPlatformDialogFragment));
            if (platformEntity2 != null) {
                EditText editText10 = editText2;
                editText10.setText(platformEntity2.getName());
                EditText editText11 = editText8;
                editText11.setText(platformEntity2.getShortname());
                Iterator it2 = platformEntity2.getRetroAchievementsConsoleIdList().iterator();
                while (it2.hasNext()) {
                    ArrayList arrayList28 = arrayList21;
                    SwitchMaterial switchMaterial7 = switchMaterial5;
                    EditPlatformDialogFragment editPlatformDialogFragment2 = editPlatformDialogFragment;
                    ChipGroup chipGroup6 = chipGroup4;
                    AutoCompleteTextView autoCompleteTextView10 = autoCompleteTextView9;
                    List list10 = list8;
                    onCreateDialog$lambda$48$lambda$47$addRetroAchievementsConsoleId(autoCompleteTextView2, arrayList19, context2, arrayList28, list10, editPlatformDialogFragment2, chipGroup, ((Number) it2.next()).longValue());
                    switchMaterial6 = switchMaterial6;
                    arrayList26 = arrayList26;
                    editText10 = editText10;
                    arrayList27 = arrayList27;
                    editText11 = editText11;
                    editText9 = editText9;
                    arrayList21 = arrayList28;
                    list8 = list10;
                    editPlatformDialogFragment = editPlatformDialogFragment2;
                    switchMaterial5 = switchMaterial7;
                    autoCompleteTextView9 = autoCompleteTextView10;
                    chipGroup5 = chipGroup5;
                    chipGroup4 = chipGroup6;
                }
                editText = editText10;
                ArrayList arrayList29 = arrayList27;
                EditText editText12 = editText9;
                editText8 = editText11;
                ArrayList arrayList30 = arrayList26;
                ChipGroup chipGroup7 = chipGroup5;
                ChipGroup chipGroup8 = chipGroup4;
                arrayList3 = arrayList9;
                autoCompleteTextView = autoCompleteTextView9;
                switchMaterial = switchMaterial5;
                switchMaterial2 = switchMaterial6;
                CheckBox checkBox5 = checkBox3;
                checkBox5.setChecked(platformEntity2.getScrapePreviewMedia());
                CheckBox checkBox6 = checkBox4;
                checkBox6.setChecked(platformEntity2.isVisible());
                textView.setText(editPlatformDialogFragment.getString(platformEntity2.getWallpaperPath() == null ? R.string.not_selected : R.string.selected));
                EditText editText13 = editText7;
                editText13.setText(platformEntity2.getAcceptedFilenameRegex());
                Iterator it3 = platformEntity2.getScraperSourceList().iterator();
                while (it3.hasNext()) {
                    onCreateDialog$lambda$48$lambda$47$addScraperSource(autoCompleteTextView3, arrayList18, context2, editPlatformDialogFragment, chipGroup8, (String) it3.next());
                    editPlatformDialogFragment = this;
                }
                Iterator it4 = platformEntity2.getPlayerIdList().iterator();
                while (it4.hasNext()) {
                    Context context3 = context2;
                    ArrayList arrayList31 = arrayList17;
                    ArrayList arrayList32 = arrayList30;
                    AutoCompleteTextView autoCompleteTextView11 = autoCompleteTextView8;
                    onCreateDialog$lambda$48$lambda$47$addPlayer(this, autoCompleteTextView11, arrayList32, arrayList31, arrayList13, context3, chipGroup7, ((Number) it4.next()).longValue());
                    context2 = context3;
                    autoCompleteTextView8 = autoCompleteTextView11;
                    arrayList30 = arrayList32;
                    checkBox6 = checkBox6;
                    checkBox5 = checkBox5;
                    editText13 = editText13;
                    arrayList17 = arrayList31;
                }
                editPlatformDialogFragment = this;
                checkBox4 = checkBox6;
                editText7 = editText13;
                arrayList2 = arrayList17;
                arrayList = arrayList30;
                arrayList4 = arrayList13;
                checkBox = checkBox5;
                int iIndexOf = arrayList2.indexOf(Long.valueOf(platformEntity2.getDefaultPlayerId()));
                if (iIndexOf != -1) {
                    z = false;
                    autoCompleteTextView4.setText((CharSequence) arrayList4.get(iIndexOf), false);
                    autoCompleteTextView4.setListSelection(iIndexOf);
                } else {
                    z = false;
                }
                onCreateDialog$lambda$48$lambda$47$setUseCustomBoxArtAspectRatio(switchMaterial, autoCompleteTextView, editText5, platformEntity2.getUseCustomBoxArtAspectRatio());
                autoCompleteTextView.setText((CharSequence) arrayList3.get(platformEntity2.getBoxArtAspectRatioId()), z);
                editText5.setText(platformEntity2.getCustomBoxArtAspectRatio());
                editText9 = editText12;
                onCreateDialog$lambda$48$lambda$47$setUseCustomScreenAspectRatio(switchMaterial2, autoCompleteTextView7, editText9, platformEntity2.getUseCustomScreenAspectRatio());
                arrayList27 = arrayList29;
                autoCompleteTextView7.setText((CharSequence) arrayList27.get(platformEntity2.getScreenAspectRatioId()), z);
                editText9.setText(platformEntity2.getCustomScreenAspectRatio());
            } else {
                autoCompleteTextView = autoCompleteTextView9;
                switchMaterial = switchMaterial5;
                arrayList = arrayList26;
                arrayList2 = arrayList17;
                editText = editText2;
                arrayList3 = arrayList9;
                arrayList4 = arrayList13;
                switchMaterial2 = switchMaterial6;
                checkBox = checkBox3;
            }
            AlertDialog.Builder view = new AlertDialog.Builder(context2).setView(viewInflate);
            if (platformEntity2 == null) {
                string = editPlatformDialogFragment.getString(R.string.new_platform);
            } else {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string2 = editPlatformDialogFragment.getString(R.string.edit_the_platform_format);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                string = String.format(string2, Arrays.copyOf(new Object[]{platformEntity2.getName()}, 1));
                Intrinsics.checkNotNullExpressionValue(string, "format(...)");
            }
            AlertDialog.Builder negativeButton = view.setTitle(string).setPositiveButton(editPlatformDialogFragment.getString(R.string.save), new EditPlatformDialogFragment$$ExternalSyntheticLambda1()).setNegativeButton(editPlatformDialogFragment.getString(R.string.cancel), new EditPlatformDialogFragment$$ExternalSyntheticLambda2());
            if (platformEntity2 != null) {
                negativeButton = negativeButton.setNeutralButton(editPlatformDialogFragment.getString(R.string.delete), new EditPlatformDialogFragment$$ExternalSyntheticLambda3());
            }
            alertDialogCreate = negativeButton.create();
            Intrinsics.checkNotNull(alertDialogCreate);
            editPlatformDialogFragment.setupDaijishouDialog(alertDialogCreate);
            editText.requestFocus();
            ArrayList arrayList33 = arrayList;
            EditText editText14 = editText;
            Context context4 = context2;
            ArrayList arrayList34 = arrayList27;
            EditText editText15 = editText8;
            alertDialogCreate.setOnShowListener(new EditPlatformDialogFragment$$ExternalSyntheticLambda4(alertDialogCreate, platformEntity2, editPlatformDialogFragment, context4, editText14, editText15, checkBox, checkBox4, editText7, autoCompleteTextView4, switchMaterial, autoCompleteTextView, arrayList3, editText5, switchMaterial2, autoCompleteTextView7, arrayList34, editText9, arrayList4, arrayList2, arrayList33, arrayList19, arrayList18, booleanRef, objectRef));
        }
        if (alertDialogCreate != null) {
            return alertDialogCreate;
        }
        throw new IllegalStateException("Context cannot be null");
    }

    private static final void onCreateDialog$lambda$48$lambda$47$addRetroAchievementsConsoleId(AutoCompleteTextView autoCompleteTextView, List<Long> list, Context context, List<String> list2, List<Long> list3, EditPlatformDialogFragment editPlatformDialogFragment, ChipGroup chipGroup, long j) {
        autoCompleteTextView.setError(null);
        list.add(Long.valueOf(j));
        autoCompleteTextView.setText((CharSequence) null);
        Chip chip = new Chip(context);
        chip.setId(View.generateViewId());
        chip.setText(list2.get(list3.indexOf(Long.valueOf(j))));
        chip.setMaxWidth(editPlatformDialogFragment.getDpToPxConverter().convert(400.0f));
        chip.setCloseIconVisible(true);
        chip.setOnCloseIconClickListener(new EditPlatformDialogFragment$$ExternalSyntheticLambda24(list, j, chipGroup));
        Intrinsics.checkNotNull(chipGroup);
        ViewGroupKt.get(chipGroup, chipGroup.getChildCount() - 1).setNextFocusRightId(-1);
        chip.setNextFocusRightId(chip.getId());
        chipGroup.addView(chip);
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$48$lambda$47$addRetroAchievementsConsoleId$lambda$18(List selectedRetroAchievementsConsoleIdList, long j, ChipGroup chipGroup, View view) {
        Intrinsics.checkNotNullParameter(selectedRetroAchievementsConsoleIdList, "$selectedRetroAchievementsConsoleIdList");
        selectedRetroAchievementsConsoleIdList.remove(Long.valueOf(j));
        chipGroup.removeView(view);
    }

    private static final void onCreateDialog$lambda$48$lambda$47$addScraperSource(AutoCompleteTextView autoCompleteTextView, List<String> list, Context context, EditPlatformDialogFragment editPlatformDialogFragment, ChipGroup chipGroup, String str) {
        autoCompleteTextView.setError(null);
        list.add(str);
        autoCompleteTextView.setText((CharSequence) null);
        Chip chip = new Chip(context);
        chip.setId(View.generateViewId());
        chip.setText(str);
        chip.setMaxWidth(editPlatformDialogFragment.getDpToPxConverter().convert(400.0f));
        chip.setCloseIconVisible(true);
        chip.setOnCloseIconClickListener(new EditPlatformDialogFragment$$ExternalSyntheticLambda17(list, str, chipGroup));
        Intrinsics.checkNotNull(chipGroup);
        ViewGroupKt.get(chipGroup, chipGroup.getChildCount() - 1).setNextFocusRightId(-1);
        chip.setNextFocusRightId(chip.getId());
        chipGroup.addView(chip);
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$48$lambda$47$addScraperSource$lambda$19(List selectedScraperSourceList, String scraperSourceText, ChipGroup chipGroup, View view) {
        Intrinsics.checkNotNullParameter(selectedScraperSourceList, "$selectedScraperSourceList");
        Intrinsics.checkNotNullParameter(scraperSourceText, "$scraperSourceText");
        selectedScraperSourceList.remove(scraperSourceText);
        chipGroup.removeView(view);
    }

    private static final void onCreateDialog$lambda$48$lambda$47$addPlayer(EditPlatformDialogFragment editPlatformDialogFragment, AutoCompleteTextView autoCompleteTextView, List<Long> list, List<Long> list2, List<String> list3, Context context, ChipGroup chipGroup, long j) {
        PlayerEntity playerByIdStatically = editPlatformDialogFragment.getDaijishouLibrary().getPlayerByIdStatically(j);
        if (playerByIdStatically == null) {
            return;
        }
        String name = playerByIdStatically.getName();
        autoCompleteTextView.setError(null);
        list.add(Long.valueOf(j));
        String str = (String) CollectionsKt.getOrNull(list3, list2.indexOf(Long.valueOf(j)));
        if (str != null) {
            ArrayAdapter<String> arrayAdapter = editPlatformDialogFragment.playerArrayAdapter;
            Intrinsics.checkNotNull(arrayAdapter);
            arrayAdapter.add(str);
        }
        autoCompleteTextView.setText((CharSequence) null);
        Chip chip = new Chip(context);
        chip.setId(View.generateViewId());
        chip.setText(name);
        chip.setCloseIconVisible(true);
        chip.setOnCloseIconClickListener(new EditPlatformDialogFragment$$ExternalSyntheticLambda0(list, j, str, chipGroup, editPlatformDialogFragment));
        chip.setOnClickListener(new EditPlatformDialogFragment$$ExternalSyntheticLambda11(editPlatformDialogFragment, j));
        Intrinsics.checkNotNull(chipGroup);
        ViewGroupKt.get(chipGroup, chipGroup.getChildCount() - 1).setNextFocusRightId(-1);
        chip.setNextFocusRightId(chip.getId());
        chipGroup.addView(chip);
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$48$lambda$47$addPlayer$lambda$22(List selectedPlayerIdList, long j, String str, ChipGroup chipGroup, EditPlatformDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(selectedPlayerIdList, "$selectedPlayerIdList");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        selectedPlayerIdList.remove(Long.valueOf(j));
        if (str != null) {
            ArrayAdapter<String> arrayAdapter = this$0.playerArrayAdapter;
            Intrinsics.checkNotNull(arrayAdapter);
            arrayAdapter.remove(str);
        }
        chipGroup.removeView(view);
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$48$lambda$47$addPlayer$lambda$23(EditPlatformDialogFragment this$0, long j, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EditPlayerDialogFragment.INSTANCE.newInstance(this$0.getDaijishouLibrary().getPlayerByIdStatically(j)).show(this$0.getParentFragmentManager(), EditPlayerDialogFragment.class.getName());
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$48$lambda$47$setUseCustomBoxArtAspectRatio(SwitchMaterial switchMaterial, AutoCompleteTextView autoCompleteTextView, EditText editText, boolean z) {
        switchMaterial.setChecked(z);
        if (z) {
            autoCompleteTextView.setEnabled(false);
            editText.setEnabled(true);
        } else {
            autoCompleteTextView.setEnabled(true);
            editText.setEnabled(false);
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$48$lambda$47$setUseCustomScreenAspectRatio(SwitchMaterial switchMaterial, AutoCompleteTextView autoCompleteTextView, EditText editText, boolean z) {
        switchMaterial.setChecked(z);
        if (z) {
            autoCompleteTextView.setEnabled(false);
            editText.setEnabled(true);
        } else {
            autoCompleteTextView.setEnabled(true);
            editText.setEnabled(false);
        }
    }

    private static final void onCreateDialog$lambda$48$lambda$47$lambda$24$openFile(EditPlatformDialogFragment editPlatformDialogFragment) {
        editPlatformDialogFragment.selectWallpaperActivity.launch("image/*");
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$48$lambda$47$lambda$24(EditPlatformDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        onCreateDialog$lambda$48$lambda$47$lambda$24$openFile(this$0);
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$48$lambda$47$lambda$25(TextView textView, EditPlatformDialogFragment this$0, Ref.BooleanRef updateWallpaper, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(updateWallpaper, "$updateWallpaper");
        textView.setText(this$0.getString(R.string.not_selected));
        updateWallpaper.element = true;
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$48$lambda$47$lambda$26(AutoCompleteTextView autoCompleteTextView, List retroAchievementsConsoleIdTextList, EditPlatformDialogFragment this$0, List retroAchievementsConsoleIdList, List selectedRetroAchievementsConsoleIdList, Context context, ChipGroup chipGroup, View view) {
        Intrinsics.checkNotNullParameter(retroAchievementsConsoleIdTextList, "$retroAchievementsConsoleIdTextList");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(retroAchievementsConsoleIdList, "$retroAchievementsConsoleIdList");
        Intrinsics.checkNotNullParameter(selectedRetroAchievementsConsoleIdList, "$selectedRetroAchievementsConsoleIdList");
        Intrinsics.checkNotNullParameter(context, "$context");
        String string = autoCompleteTextView.getText().toString();
        if (retroAchievementsConsoleIdTextList.indexOf(string) == -1) {
            autoCompleteTextView.setError(this$0.getString(R.string.please_select_from_the_list));
            autoCompleteTextView.requestFocus();
            return;
        }
        long jLongValue = ((Number) retroAchievementsConsoleIdList.get(retroAchievementsConsoleIdTextList.indexOf(string))).longValue();
        if (selectedRetroAchievementsConsoleIdList.indexOf(Long.valueOf(jLongValue)) != -1) {
            autoCompleteTextView.setError(this$0.getString(R.string.item_has_been_selected));
            autoCompleteTextView.requestFocus();
        } else {
            onCreateDialog$lambda$48$lambda$47$addRetroAchievementsConsoleId(autoCompleteTextView, selectedRetroAchievementsConsoleIdList, context, retroAchievementsConsoleIdTextList, retroAchievementsConsoleIdList, this$0, chipGroup, jLongValue);
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$48$lambda$47$lambda$27(AutoCompleteTextView autoCompleteTextView, List scraperSourceList, EditPlatformDialogFragment this$0, List selectedScraperSourceList, Context context, ChipGroup chipGroup, View view) {
        Intrinsics.checkNotNullParameter(scraperSourceList, "$scraperSourceList");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(selectedScraperSourceList, "$selectedScraperSourceList");
        Intrinsics.checkNotNullParameter(context, "$context");
        String string = autoCompleteTextView.getText().toString();
        if (!StringsKt.startsWith$default(string, "IGDB:", false, 2, (Object) null) && !StringsKt.startsWith$default(string, "DSESS:", false, 2, (Object) null) && scraperSourceList.indexOf(string) == -1) {
            autoCompleteTextView.setError(this$0.getString(R.string.please_select_from_the_list));
            autoCompleteTextView.requestFocus();
        } else if (selectedScraperSourceList.indexOf(string) != -1) {
            autoCompleteTextView.setError(this$0.getString(R.string.item_has_been_selected));
            autoCompleteTextView.requestFocus();
        } else {
            onCreateDialog$lambda$48$lambda$47$addScraperSource(autoCompleteTextView, selectedScraperSourceList, context, this$0, chipGroup, string);
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$48$lambda$47$lambda$31(AutoCompleteTextView autoCompleteTextView, List playerEntityNameListWithIndex, EditPlatformDialogFragment this$0, List playerEntityIdList, List selectedPlayerIdList, Context context, ChipGroup chipGroup, View view) {
        Intrinsics.checkNotNullParameter(playerEntityNameListWithIndex, "$playerEntityNameListWithIndex");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(playerEntityIdList, "$playerEntityIdList");
        Intrinsics.checkNotNullParameter(selectedPlayerIdList, "$selectedPlayerIdList");
        Intrinsics.checkNotNullParameter(context, "$context");
        String string = autoCompleteTextView.getText().toString();
        if (playerEntityNameListWithIndex.indexOf(string) == -1) {
            autoCompleteTextView.setError(this$0.getString(R.string.please_select_from_the_list));
            autoCompleteTextView.requestFocus();
            return;
        }
        long jLongValue = ((Number) playerEntityIdList.get(playerEntityNameListWithIndex.indexOf(string))).longValue();
        if (selectedPlayerIdList.indexOf(Long.valueOf(jLongValue)) != -1) {
            autoCompleteTextView.setError(this$0.getString(R.string.item_has_been_selected));
            autoCompleteTextView.requestFocus();
        } else {
            onCreateDialog$lambda$48$lambda$47$addPlayer(this$0, autoCompleteTextView, selectedPlayerIdList, playerEntityIdList, playerEntityNameListWithIndex, context, chipGroup, jLongValue);
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$48$lambda$47$lambda$34(EditPlatformDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ListSelectDialogFragment.Companion companion = ListSelectDialogFragment.INSTANCE;
        String string = this$0.getString(R.string.import_preview_media_for_platform);
        String string2 = this$0.getString(R.string.import_preview_media_for_box_art);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = this$0.getString(R.string.import_preview_media_for_snapshot);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = this$0.getString(R.string.import_preview_media_for_title);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        ListSelectDialogFragment.Companion.newInstance$default(companion, string, CollectionsKt.arrayListOf(string2, string3, string4), null, false, 12, null).setOnSelectListener(new EditPlatformDialogFragment$onCreateDialog$1$1$13$1(this$0)).setOnCancelListener(EditPlatformDialogFragment$onCreateDialog$1$1$13$2.INSTANCE).show(this$0.getParentFragmentManager(), ListSelectDialogFragment.class.getName());
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$48$lambda$47$lambda$35(EditPlatformDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Build.VERSION.SDK_INT >= 29) {
            this$0.importDatFileFromUriActivity.launch("*/*");
        } else {
            this$0.importDatFileFromUriActivity.launch("*/*");
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$48$lambda$47$lambda$36(EditPlatformDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Build.VERSION.SDK_INT >= 29) {
            this$0.importXMLFileFromUriActivity.launch("text/xml");
        } else {
            this$0.importXMLFileFromUriActivity.launch("*/*");
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$48$lambda$47$lambda$46(AlertDialog alertDialog, PlatformEntity platformEntity, EditPlatformDialogFragment this$0, Context context, EditText editText, EditText editText2, CheckBox checkBox, CheckBox checkBox2, EditText editText3, AutoCompleteTextView autoCompleteTextView, SwitchMaterial switchMaterial, AutoCompleteTextView autoCompleteTextView2, List boxArtAspectRatioTextList, EditText editText4, SwitchMaterial switchMaterial2, AutoCompleteTextView autoCompleteTextView3, List screenAspectRatioTextList, EditText editText5, List playerEntityNameListWithIndex, List playerEntityIdList, List selectedPlayerIdList, List selectedRetroAchievementsConsoleIdList, List selectedScraperSourceList, Ref.BooleanRef updateWallpaper, Ref.ObjectRef selectedWallpaperFile, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(boxArtAspectRatioTextList, "$boxArtAspectRatioTextList");
        Intrinsics.checkNotNullParameter(screenAspectRatioTextList, "$screenAspectRatioTextList");
        Intrinsics.checkNotNullParameter(playerEntityNameListWithIndex, "$playerEntityNameListWithIndex");
        Intrinsics.checkNotNullParameter(playerEntityIdList, "$playerEntityIdList");
        Intrinsics.checkNotNullParameter(selectedPlayerIdList, "$selectedPlayerIdList");
        Intrinsics.checkNotNullParameter(selectedRetroAchievementsConsoleIdList, "$selectedRetroAchievementsConsoleIdList");
        Intrinsics.checkNotNullParameter(selectedScraperSourceList, "$selectedScraperSourceList");
        Intrinsics.checkNotNullParameter(updateWallpaper, "$updateWallpaper");
        Intrinsics.checkNotNullParameter(selectedWallpaperFile, "$selectedWallpaperFile");
        Intrinsics.checkNotNull(alertDialog, "null cannot be cast to non-null type android.app.AlertDialog");
        Button button = alertDialog.getButton(-1);
        Intrinsics.checkNotNullExpressionValue(button, "getButton(...)");
        Button button2 = alertDialog.getButton(-3);
        Intrinsics.checkNotNullExpressionValue(button2, "getButton(...)");
        button2.setOnClickListener(new EditPlatformDialogFragment$$ExternalSyntheticLambda15(platformEntity, this$0, context, alertDialog));
        button.setOnClickListener(new EditPlatformDialogFragment$$ExternalSyntheticLambda16(editText, editText2, checkBox, checkBox2, editText3, autoCompleteTextView, switchMaterial, autoCompleteTextView2, boxArtAspectRatioTextList, editText4, switchMaterial2, autoCompleteTextView3, screenAspectRatioTextList, editText5, this$0, playerEntityNameListWithIndex, playerEntityIdList, selectedPlayerIdList, platformEntity, selectedRetroAchievementsConsoleIdList, selectedScraperSourceList, updateWallpaper, selectedWallpaperFile, alertDialog, context));
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$48$lambda$47$lambda$46$lambda$44(PlatformEntity platformEntity, EditPlatformDialogFragment this$0, Context context, AlertDialog alertDialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        if (platformEntity != null) {
            if (this$0.deleteWallpaperOfPlatformEntity(platformEntity)) {
                Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                AcknowledgementDialogFragment.Companion companion = AcknowledgementDialogFragment.INSTANCE;
                String string = this$0.getString(R.string.delete_unused_players);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string2 = this$0.getString(R.string.delete_unused_players_warning_format);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                String str = String.format(string2, Arrays.copyOf(new Object[]{platformEntity.getName()}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                AcknowledgementDialogFragment.Companion.newInstance$default(companion, string, str, this$0.getString(R.string.yes_delete_all), this$0.getString(R.string.no), null, 16, null).setOnAcknowledgedListener(new EditPlatformDialogFragment$onCreateDialog$1$1$20$1$1$1(booleanRef, this$0, platformEntity, alertDialog, context)).setOnCanceledListener(new EditPlatformDialogFragment$onCreateDialog$1$1$20$1$1$2(this$0, platformEntity, alertDialog, booleanRef, context)).show(this$0.getParentFragmentManager(), AcknowledgementDialogFragment.class.getName());
                return;
            }
            Toast.makeText(context, "Wallpaper unable to delete.", 0).show();
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$48$lambda$47$lambda$46$lambda$44$lambda$43$confirmAction(EditPlatformDialogFragment editPlatformDialogFragment, PlatformEntity platformEntity, AlertDialog alertDialog, Ref.BooleanRef booleanRef, Context context) {
        AcknowledgementDialogFragment.Companion companion = AcknowledgementDialogFragment.INSTANCE;
        String string = editPlatformDialogFragment.getString(R.string.delete_platform);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string2 = editPlatformDialogFragment.getString(R.string.delete_platform_warning_format);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String str = String.format(string2, Arrays.copyOf(new Object[]{platformEntity.getName()}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        AcknowledgementDialogFragment.Companion.newInstance$default(companion, string, str, null, null, null, 28, null).setOnAcknowledgedListener(new EditPlatformDialogFragment$onCreateDialog$1$1$20$1$1$confirmAction$1(alertDialog, editPlatformDialogFragment, platformEntity, booleanRef, context)).setOnCanceledListener(new EditPlatformDialogFragment$onCreateDialog$1$1$20$1$1$confirmAction$2(context, editPlatformDialogFragment)).show(editPlatformDialogFragment.getParentFragmentManager(), AcknowledgementDialogFragment.class.getName());
    }

    /* INFO: Access modifiers changed from: private */
    /* WARN: Multi-variable type inference failed */
    public static final void onCreateDialog$lambda$48$lambda$47$lambda$46$lambda$45(EditText editText, EditText editText2, CheckBox checkBox, CheckBox checkBox2, EditText editText3, AutoCompleteTextView autoCompleteTextView, SwitchMaterial switchMaterial, AutoCompleteTextView autoCompleteTextView2, List boxArtAspectRatioTextList, EditText editText4, SwitchMaterial switchMaterial2, AutoCompleteTextView autoCompleteTextView3, List screenAspectRatioTextList, EditText editText5, EditPlatformDialogFragment this$0, List playerEntityNameListWithIndex, List playerEntityIdList, List selectedPlayerIdList, PlatformEntity platformEntity, List selectedRetroAchievementsConsoleIdList, List selectedScraperSourceList, Ref.BooleanRef updateWallpaper, Ref.ObjectRef selectedWallpaperFile, AlertDialog alertDialog, Context context, View view) {
        Intrinsics.checkNotNullParameter(boxArtAspectRatioTextList, "$boxArtAspectRatioTextList");
        Intrinsics.checkNotNullParameter(screenAspectRatioTextList, "$screenAspectRatioTextList");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(playerEntityNameListWithIndex, "$playerEntityNameListWithIndex");
        Intrinsics.checkNotNullParameter(playerEntityIdList, "$playerEntityIdList");
        Intrinsics.checkNotNullParameter(selectedPlayerIdList, "$selectedPlayerIdList");
        Intrinsics.checkNotNullParameter(selectedRetroAchievementsConsoleIdList, "$selectedRetroAchievementsConsoleIdList");
        Intrinsics.checkNotNullParameter(selectedScraperSourceList, "$selectedScraperSourceList");
        Intrinsics.checkNotNullParameter(updateWallpaper, "$updateWallpaper");
        Intrinsics.checkNotNullParameter(selectedWallpaperFile, "$selectedWallpaperFile");
        Intrinsics.checkNotNullParameter(context, "$context");
        String string = editText.getText().toString();
        String string2 = editText2.getText().toString();
        boolean zIsChecked = checkBox.isChecked();
        boolean zIsChecked2 = checkBox2.isChecked();
        String string3 = editText3.getText().toString();
        String string4 = autoCompleteTextView.getText().toString();
        boolean zIsChecked3 = switchMaterial.isChecked();
        int iIndexOf = boxArtAspectRatioTextList.indexOf(autoCompleteTextView2.getText().toString());
        if (iIndexOf == -1) {
            iIndexOf = 0;
        }
        String string5 = editText4.getText().toString();
        int i = iIndexOf;
        boolean zIsChecked4 = switchMaterial2.isChecked();
        int iIndexOf2 = screenAspectRatioTextList.indexOf(autoCompleteTextView3.getText().toString());
        if (iIndexOf2 == -1) {
            iIndexOf2 = 0;
        }
        String string6 = editText5.getText().toString();
        if (string.length() == 0) {
            editText.setError(this$0.getString(R.string.please_enter_a_player_name));
            editText.requestFocus();
            return;
        }
        if (string2.length() == 0) {
            editText2.setError(this$0.getString(R.string.please_enter_a_player_shortname));
            editText2.requestFocus();
            return;
        }
        int i2 = iIndexOf2;
        if (!StringsKt.startsWith$default(string3, "^", false, 2, (Object) null) || !StringsKt.endsWith$default(string3, "$", false, 2, (Object) null)) {
            editText3.setError(this$0.getString(R.string.regex_constraint_warning));
            editText3.requestFocus();
            return;
        }
        try {
            new Regex(string3);
            int iIndexOf3 = playerEntityNameListWithIndex.indexOf(string4);
            if (iIndexOf3 == -1) {
                autoCompleteTextView.setError(this$0.getString(R.string.please_select_from_the_list));
                autoCompleteTextView.requestFocus();
                return;
            }
            Long l = (Long) playerEntityIdList.get(iIndexOf3);
            Regex aspectRatioRegex = Constants.INSTANCE.getAspectRatioRegex();
            if (Intrinsics.areEqual(string5, "") || string5 == null) {
                if (zIsChecked3) {
                    editText4.setError(this$0.getString(R.string.bad_aspect_ratio_format));
                    editText4.requestFocus();
                    return;
                }
                string5 = null;
            } else if (!aspectRatioRegex.matches(string5)) {
                editText4.setError(this$0.getString(R.string.bad_aspect_ratio_format));
                editText4.requestFocus();
                return;
            }
            if (Intrinsics.areEqual(string6, "") || string6 == null) {
                string6 = null;
            } else if (!aspectRatioRegex.matches(string6)) {
                editText5.setError(this$0.getString(R.string.bad_aspect_ratio_format));
                editText5.requestFocus();
                return;
            }
            if (selectedPlayerIdList.indexOf(l) == -1) {
                selectedPlayerIdList.add(l);
            }
            PlatformEntity platformEntity2 = platformEntity == null ? new PlatformEntity(0L, null, null, null, null, false, false, null, null, null, null, null, 0L, null, null, 0, false, null, 0, false, null, null, null, null, ViewCompat.MEASURED_SIZE_MASK, null) : platformEntity;
            platformEntity2.setName(string);
            platformEntity2.setShortname(string2);
            platformEntity2.setScrapePreviewMedia(zIsChecked);
            platformEntity2.setVisible(zIsChecked2);
            platformEntity2.setAcceptedFilenameRegex(string3);
            platformEntity2.setDefaultPlayerId(l.longValue());
            platformEntity2.setPlayerIdList(selectedPlayerIdList);
            platformEntity2.setRetroAchievementsConsoleIdList(selectedRetroAchievementsConsoleIdList);
            platformEntity2.setScraperSourceList(selectedScraperSourceList);
            platformEntity2.setBoxArtAspectRatioId(i);
            platformEntity2.setUseCustomBoxArtAspectRatio(zIsChecked3);
            platformEntity2.setCustomBoxArtAspectRatio(string5);
            platformEntity2.setScreenAspectRatioId(i2);
            platformEntity2.setUseCustomScreenAspectRatio(zIsChecked4);
            platformEntity2.setCustomScreenAspectRatio(string6);
            long jAddPlatform = this$0.getDaijishouLibrary().addPlatform(platformEntity2);
            if (updateWallpaper.element) {
                if (selectedWallpaperFile.element == null) {
                    if (!this$0.deleteWallpaperOfPlatformEntity(platformEntity2)) {
                        alertDialog.dismiss();
                        Toast.makeText(context, "Finished without adding wallpaper.", 0).show();
                        return;
                    } else {
                        platformEntity2.setWallpaperPath(null);
                        onCreateDialog$lambda$48$lambda$47$lambda$46$lambda$45$saveAndDismiss(platformEntity2, jAddPlatform, this$0, alertDialog, context, platformEntity);
                        return;
                    }
                }
                File t = (File) selectedWallpaperFile.element;
                Intrinsics.checkNotNull(t);
                this$0.ensureWallpaperDirectory();
                BuildersKt.launch$default(this$0, Dispatchers.getIO(), null, new EditPlatformDialogFragment$onCreateDialog$1$1$20$2$1(context, this$0, jAddPlatform, (File) t, platformEntity2, alertDialog, platformEntity, null), 2, null);
                return;
            }
            onCreateDialog$lambda$48$lambda$47$lambda$46$lambda$45$dismiss(alertDialog, context, platformEntity, this$0);
        } catch (Exception unused) {
            editText3.setError(this$0.getString(R.string.bad_regex_detected));
            editText3.requestFocus();
        }
    }

    private static final void onCreateDialog$lambda$48$lambda$47$lambda$46$lambda$45$dismiss(AlertDialog alertDialog, Context context, PlatformEntity platformEntity, EditPlatformDialogFragment editPlatformDialogFragment) {
        alertDialog.dismiss();
        Toast.makeText(context, editPlatformDialogFragment.getString(platformEntity == null ? R.string.added_successfully : R.string.edited_successfully), 0).show();
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$48$lambda$47$lambda$46$lambda$45$saveAndDismiss(PlatformEntity platformEntity, long j, EditPlatformDialogFragment editPlatformDialogFragment, AlertDialog alertDialog, Context context, PlatformEntity platformEntity2) {
        platformEntity.setId(j);
        editPlatformDialogFragment.getDaijishouLibrary().addPlatform(platformEntity);
        onCreateDialog$lambda$48$lambda$47$lambda$46$lambda$45$dismiss(alertDialog, context, platformEntity2, editPlatformDialogFragment);
    }
}
