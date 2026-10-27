package com.magneticchen.daijishou.ui.fragments.dialog;

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
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.Constants;
import com.magneticchen.daijishou.data.db.entity.PlatformEntity;
import com.magneticchen.daijishou.data.db.entity.PlayerEntity;
import com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment;
import com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetViewModel;
import com.magneticchen.daijishou.utils.AutoCompleteAdapter;
import com.magneticchen.daijishou.utils.Utils;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: EditPlatformDialogFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u001eH\u0016J\b\u0010$\u001a\u00020\u001eH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlatformDialogFragment;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/DaijishouDialogFragment;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "importBoxArtsFromUriActivity", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/net/Uri;", "importDatFileFromUriActivity", "", "kotlin.jvm.PlatformType", "importSnapshotsFromUriActivity", "importTitlesFromUriActivity", "importXMLFileFromUriActivity", "job", "Lkotlinx/coroutines/Job;", "playerArrayAdapter", "Landroid/widget/ArrayAdapter;", "selectWallpaperActivity", "selectedWallpaperUriLiveData", "Landroidx/lifecycle/MutableLiveData;", "wallpaperDirectoryName", "deleteWallpaperOfPlatformEntity", "", "newPlatformEntity", "Lcom/magneticchen/daijishou/data/db/entity/PlatformEntity;", "ensureWallpaperDirectory", "", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onStart", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class EditPlatformDialogFragment extends DaijishouDialogFragment implements CoroutineScope {
    public static final Companion Companion = new Companion(null);
    private ActivityResultLauncher<Uri> importBoxArtsFromUriActivity;
    private ActivityResultLauncher<String> importDatFileFromUriActivity;
    private ActivityResultLauncher<Uri> importSnapshotsFromUriActivity;
    private ActivityResultLauncher<Uri> importTitlesFromUriActivity;
    private ActivityResultLauncher<String> importXMLFileFromUriActivity;
    private Job job = JobKt.Job$default((Job) null, 1, (Object) null);
    private ArrayAdapter<String> playerArrayAdapter;
    private ActivityResultLauncher<String> selectWallpaperActivity;
    private final MutableLiveData<Uri> selectedWallpaperUriLiveData;
    private final String wallpaperDirectoryName;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$48$lambda$47$lambda$40(DialogInterface dialogInterface, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$48$lambda$47$lambda$42(DialogInterface dialogInterface, int i) {
    }

    public EditPlatformDialogFragment() {
        ActivityResultLauncher<Uri> activityResultLauncherRegisterForActivityResult = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.OpenDocumentTree(), new ActivityResultCallback() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment$$ExternalSyntheticLambda19
            public final void onActivityResult(Object obj) {
                EditPlatformDialogFragment.importBoxArtsFromUriActivity$lambda$1(this.f$0, (Uri) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.importBoxArtsFromUriActivity = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<Uri> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.OpenDocumentTree(), new ActivityResultCallback() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment$$ExternalSyntheticLambda20
            public final void onActivityResult(Object obj) {
                EditPlatformDialogFragment.importSnapshotsFromUriActivity$lambda$3(this.f$0, (Uri) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(...)");
        this.importSnapshotsFromUriActivity = activityResultLauncherRegisterForActivityResult2;
        ActivityResultLauncher<Uri> activityResultLauncherRegisterForActivityResult3 = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.OpenDocumentTree(), new ActivityResultCallback() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment$$ExternalSyntheticLambda21
            public final void onActivityResult(Object obj) {
                EditPlatformDialogFragment.importTitlesFromUriActivity$lambda$5(this.f$0, (Uri) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult3, "registerForActivityResult(...)");
        this.importTitlesFromUriActivity = activityResultLauncherRegisterForActivityResult3;
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult4 = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.GetContent(), new ActivityResultCallback() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment$$ExternalSyntheticLambda22
            public final void onActivityResult(Object obj) {
                EditPlatformDialogFragment.importDatFileFromUriActivity$lambda$7(this.f$0, (Uri) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult4, "registerForActivityResult(...)");
        this.importDatFileFromUriActivity = activityResultLauncherRegisterForActivityResult4;
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult5 = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.GetContent(), new ActivityResultCallback() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment$$ExternalSyntheticLambda23
            public final void onActivityResult(Object obj) {
                EditPlatformDialogFragment.importXMLFileFromUriActivity$lambda$9(this.f$0, (Uri) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult5, "registerForActivityResult(...)");
        this.importXMLFileFromUriActivity = activityResultLauncherRegisterForActivityResult5;
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult6 = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.GetContent(), new ActivityResultCallback() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment$$ExternalSyntheticLambda24
            public final void onActivityResult(Object obj) {
                EditPlatformDialogFragment.selectWallpaperActivity$lambda$10(this.f$0, (Uri) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult6, "registerForActivityResult(...)");
        this.selectWallpaperActivity = activityResultLauncherRegisterForActivityResult6;
        this.selectedWallpaperUriLiveData = new MutableLiveData<>();
        this.wallpaperDirectoryName = Constants.platformWallpapersDirectory;
    }

    public CoroutineContext getCoroutineContext() {
        return Dispatchers.getMain().plus(this.job);
    }

    /* JADX INFO: compiled from: EditPlatformDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlatformDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlatformDialogFragment;", "platformEntity", "Lcom/magneticchen/daijishou/data/db/entity/PlatformEntity;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void importBoxArtsFromUriActivity$lambda$1(final EditPlatformDialogFragment this$0, Uri uri) {
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
        final ProgressDialogFragment progressDialogFragmentNewInstance$default = ProgressDialogFragment.Companion.newInstance$default(ProgressDialogFragment.Companion, null, null, 3, null);
        progressDialogFragmentNewInstance$default.show(this$0.getParentFragmentManager(), ProgressDialogFragment.class.getName());
        this$0.getDaijishouSynchronization().importBoxArtsFromUriForPlatformId(platformEntity.getId(), uri, true, new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment$importBoxArtsFromUriActivity$1$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                EditPlatformDialogFragment editPlatformDialogFragment;
                int i;
                Context contextRequireContext2 = this.this$0.requireContext();
                if (z) {
                    editPlatformDialogFragment = this.this$0;
                    i = R.string.added_successfully;
                } else {
                    editPlatformDialogFragment = this.this$0;
                    i = R.string.not_imported;
                }
                Toast.makeText(contextRequireContext2, editPlatformDialogFragment.getString(i), 0).show();
                progressDialogFragmentNewInstance$default.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void importSnapshotsFromUriActivity$lambda$3(final EditPlatformDialogFragment this$0, Uri uri) {
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
        final ProgressDialogFragment progressDialogFragmentNewInstance$default = ProgressDialogFragment.Companion.newInstance$default(ProgressDialogFragment.Companion, null, null, 3, null);
        progressDialogFragmentNewInstance$default.show(this$0.getParentFragmentManager(), ProgressDialogFragment.class.getName());
        this$0.getDaijishouSynchronization().importSnapshotsFromUriForPlatformId(platformEntity.getId(), uri, true, new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment$importSnapshotsFromUriActivity$1$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                EditPlatformDialogFragment editPlatformDialogFragment;
                int i;
                Context contextRequireContext2 = this.this$0.requireContext();
                if (z) {
                    editPlatformDialogFragment = this.this$0;
                    i = R.string.added_successfully;
                } else {
                    editPlatformDialogFragment = this.this$0;
                    i = R.string.not_imported;
                }
                Toast.makeText(contextRequireContext2, editPlatformDialogFragment.getString(i), 0).show();
                progressDialogFragmentNewInstance$default.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void importTitlesFromUriActivity$lambda$5(final EditPlatformDialogFragment this$0, Uri uri) {
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
        final ProgressDialogFragment progressDialogFragmentNewInstance$default = ProgressDialogFragment.Companion.newInstance$default(ProgressDialogFragment.Companion, null, null, 3, null);
        progressDialogFragmentNewInstance$default.show(this$0.getParentFragmentManager(), ProgressDialogFragment.class.getName());
        this$0.getDaijishouSynchronization().importTitlesFromUriForPlatformId(platformEntity.getId(), uri, true, new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment$importTitlesFromUriActivity$1$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                EditPlatformDialogFragment editPlatformDialogFragment;
                int i;
                Context contextRequireContext2 = this.this$0.requireContext();
                if (z) {
                    editPlatformDialogFragment = this.this$0;
                    i = R.string.added_successfully;
                } else {
                    editPlatformDialogFragment = this.this$0;
                    i = R.string.not_imported;
                }
                Toast.makeText(contextRequireContext2, editPlatformDialogFragment.getString(i), 0).show();
                progressDialogFragmentNewInstance$default.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void importDatFileFromUriActivity$lambda$7(final EditPlatformDialogFragment this$0, Uri uri) {
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
        final ProgressDialogFragment progressDialogFragmentNewInstance$default = ProgressDialogFragment.Companion.newInstance$default(ProgressDialogFragment.Companion, null, null, 3, null);
        progressDialogFragmentNewInstance$default.show(this$0.getParentFragmentManager(), ProgressDialogFragment.class.getName());
        this$0.getDaijishouSynchronization().importDatFilesFromUriForPlatformId(platformEntity.getId(), uri, true, new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment$importDatFileFromUriActivity$1$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                EditPlatformDialogFragment editPlatformDialogFragment;
                int i;
                Context contextRequireContext2 = this.this$0.requireContext();
                if (z) {
                    editPlatformDialogFragment = this.this$0;
                    i = R.string.added_successfully;
                } else {
                    editPlatformDialogFragment = this.this$0;
                    i = R.string.not_imported;
                }
                Toast.makeText(contextRequireContext2, editPlatformDialogFragment.getString(i), 0).show();
                progressDialogFragmentNewInstance$default.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void importXMLFileFromUriActivity$lambda$9(final EditPlatformDialogFragment this$0, Uri uri) {
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
        final ProgressDialogFragment progressDialogFragmentNewInstance$default = ProgressDialogFragment.Companion.newInstance$default(ProgressDialogFragment.Companion, null, null, 3, null);
        progressDialogFragmentNewInstance$default.show(this$0.getParentFragmentManager(), ProgressDialogFragment.class.getName());
        this$0.getDaijishouSynchronization().importXMLFilesFromUriForPlatformId(platformEntity.getId(), uri, true, new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment$importXMLFileFromUriActivity$1$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                EditPlatformDialogFragment editPlatformDialogFragment;
                int i;
                Context contextRequireContext2 = this.this$0.requireContext();
                if (z) {
                    editPlatformDialogFragment = this.this$0;
                    i = R.string.added_successfully;
                } else {
                    editPlatformDialogFragment = this.this$0;
                    i = R.string.not_imported;
                }
                Toast.makeText(contextRequireContext2, editPlatformDialogFragment.getString(i), 0).show();
                progressDialogFragmentNewInstance$default.dismiss();
            }
        });
    }

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
                window2.setFlags(CategoryWidgetViewModel.LIMIT, CategoryWidgetViewModel.LIMIT);
            }
            Window window3 = dialog.getWindow();
            if (window3 != null) {
                window3.setBackgroundDrawable(AppCompatResources.getDrawable(requireContext(), R.drawable.dialog_background));
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        Job.DefaultImpls.cancel$default(this.job, (CancellationException) null, 1, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void selectWallpaperActivity$lambda$10(EditPlatformDialogFragment this$0, Uri uri) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.selectedWallpaperUriLiveData.setValue(uri);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ensureWallpaperDirectory() {
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        File file = new File(contextRequireContext.getFilesDir() + "/" + this.wallpaperDirectoryName + "/");
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    private final boolean deleteWallpaperOfPlatformEntity(PlatformEntity platformEntity) {
        if (platformEntity.getWallpaperPath() != null) {
            File file = new File(new URI(platformEntity.getWallpaperPath()).getPath());
            return !file.exists() || file.delete();
        }
        return true;
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        final AlertDialog alertDialogCreate;
        CheckBox checkBox;
        final SwitchMaterial switchMaterial;
        EditText editText;
        ArrayList arrayList;
        ArrayList arrayList2;
        final ArrayList arrayList3;
        EditText editText2;
        final ArrayList arrayList4;
        AutoCompleteTextView autoCompleteTextView;
        ArrayList arrayList5;
        ArrayList arrayList6;
        String string;
        boolean z;
        Bundle arguments = getArguments();
        PlatformEntity platformEntity = arguments != null ? (PlatformEntity) arguments.getParcelable("platformEntity") : null;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            throw new IllegalStateException("Activity cannot be null");
        }
        final Context context = getContext();
        if (context != null) {
            View viewInflate = activity.getLayoutInflater().inflate(R.layout.form_edit_platform, (ViewGroup) null);
            int[] intArray = getResources().getIntArray(R.array.retro_achievements_console_id_array);
            Intrinsics.checkNotNullExpressionValue(intArray, "getIntArray(...)");
            ArrayList arrayList7 = new ArrayList(intArray.length);
            for (int i : intArray) {
                arrayList7.add(Long.valueOf(i));
            }
            final List list = CollectionsKt.toList(arrayList7);
            String[] stringArray = getResources().getStringArray(R.array.retro_achievements_console_id_description_array);
            Intrinsics.checkNotNullExpressionValue(stringArray, "getStringArray(...)");
            List list2 = ArraysKt.toList(stringArray);
            int size = list.size();
            ArrayList arrayList8 = new ArrayList(size);
            for (int i2 = 0; i2 < size; i2++) {
                arrayList8.add(list.get(i2) + " - " + list2.get(i2));
            }
            final ArrayList arrayList9 = arrayList8;
            String[] stringArray2 = getResources().getStringArray(R.array.scraper_source_array);
            Intrinsics.checkNotNullExpressionValue(stringArray2, "getStringArray(...)");
            final List list3 = ArraysKt.toList(stringArray2);
            String[] stringArray3 = getResources().getStringArray(R.array.box_art_aspect_ratio_array);
            Intrinsics.checkNotNullExpressionValue(stringArray3, "getStringArray(...)");
            List list4 = ArraysKt.toList(stringArray3);
            String[] stringArray4 = getResources().getStringArray(R.array.box_art_aspect_ratio_description_array);
            Intrinsics.checkNotNullExpressionValue(stringArray4, "getStringArray(...)");
            List list5 = ArraysKt.toList(stringArray4);
            int size2 = list4.size();
            ArrayList arrayList10 = new ArrayList(size2);
            int i3 = 0;
            while (i3 < size2) {
                arrayList10.add(list4.get(i3) + " - " + list5.get(i3));
                i3++;
                activity = activity;
                list4 = list4;
            }
            FragmentActivity fragmentActivity = activity;
            ArrayList arrayList11 = arrayList10;
            String[] stringArray5 = getResources().getStringArray(R.array.screen_aspect_ratio_array);
            Intrinsics.checkNotNullExpressionValue(stringArray5, "getStringArray(...)");
            List list6 = ArraysKt.toList(stringArray5);
            String[] stringArray6 = getResources().getStringArray(R.array.screen_aspect_ratio_description_array);
            Intrinsics.checkNotNullExpressionValue(stringArray6, "getStringArray(...)");
            List list7 = ArraysKt.toList(stringArray6);
            int size3 = list6.size();
            ArrayList arrayList12 = new ArrayList(size3);
            int i4 = 0;
            while (i4 < size3) {
                arrayList12.add(list6.get(i4) + " - " + list7.get(i4));
                i4++;
                list6 = list6;
            }
            ArrayList arrayList13 = arrayList12;
            final List mutableList = CollectionsKt.toMutableList((Collection) getDaijishouLibrary().getAllPlayersStatically());
            int size4 = mutableList.size();
            ArrayList arrayList14 = new ArrayList(size4);
            for (int i5 = 0; i5 < size4; i5++) {
                arrayList14.add(i5 + " - " + ((PlayerEntity) mutableList.get(i5)).getName());
            }
            final ArrayList arrayList15 = arrayList14;
            int size5 = mutableList.size();
            ArrayList arrayList16 = new ArrayList(size5);
            for (int i6 = 0; i6 < size5; i6++) {
                arrayList16.add(((PlayerEntity) mutableList.get(i6)).getName());
            }
            final ArrayList arrayList17 = arrayList16;
            int size6 = mutableList.size();
            ArrayList arrayList18 = new ArrayList(size6);
            for (int i7 = 0; i7 < size6; i7++) {
                arrayList18.add(Long.valueOf(((PlayerEntity) mutableList.get(i7)).getId()));
            }
            final ArrayList arrayList19 = arrayList18;
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            final ArrayList arrayList20 = new ArrayList();
            final ArrayList arrayList21 = new ArrayList();
            final ArrayList arrayList22 = new ArrayList();
            EditText editText3 = (EditText) viewInflate.findViewById(R.id.platform_name_edit_text);
            EditText editText4 = (EditText) viewInflate.findViewById(R.id.platform_shortname_edit_text);
            final EditText editText5 = (EditText) viewInflate.findViewById(R.id.platform_position_edit_text);
            editText5.setText(String.valueOf(platformEntity != null ? Integer.valueOf(platformEntity.getPosition()) : null));
            CheckBox checkBox2 = (CheckBox) viewInflate.findViewById(R.id.platform_visible_check_box);
            CheckBox checkBox3 = (CheckBox) viewInflate.findViewById(R.id.platform_scrape_preview_media_check_box);
            Button button = (Button) viewInflate.findViewById(R.id.playable_item_select_wallpaper_button);
            Button button2 = (Button) viewInflate.findViewById(R.id.platform_wallpaper_clear_wallpaper_button);
            final TextView textView = (TextView) viewInflate.findViewById(R.id.platform_is_wallpaper_selected_text_view);
            EditText editText6 = (EditText) viewInflate.findViewById(R.id.platform_accepted_filename_regex_edit_text);
            Button button3 = (Button) viewInflate.findViewById(R.id.playable_item_import_preview_media_button);
            Button button4 = (Button) viewInflate.findViewById(R.id.playable_item_import_dat_file_button);
            Button button5 = (Button) viewInflate.findViewById(R.id.playable_item_import_xml_file_button);
            final AutoCompleteTextView autoCompleteTextView2 = (AutoCompleteTextView) viewInflate.findViewById(R.id.platform_retro_achievements_console_id_search_text_view);
            Chip chipFindViewById = viewInflate.findViewById(R.id.platform_retro_achievements_console_id_add_button);
            final ChipGroup chipGroupFindViewById = viewInflate.findViewById(R.id.platform_retro_achievements_console_ids_chip_group);
            AutoCompleteTextView autoCompleteTextView3 = (AutoCompleteTextView) viewInflate.findViewById(R.id.platform_scraper_source_search_text_view);
            Chip chipFindViewById2 = viewInflate.findViewById(R.id.platform_scraper_source_add_button);
            final ChipGroup chipGroupFindViewById2 = viewInflate.findViewById(R.id.platform_scraper_sources_chip_group);
            final AutoCompleteTextView autoCompleteTextView4 = (AutoCompleteTextView) viewInflate.findViewById(R.id.platform_default_player_select);
            final AutoCompleteTextView autoCompleteTextView5 = (AutoCompleteTextView) viewInflate.findViewById(R.id.platform_player_search_text_view);
            Chip chipFindViewById3 = viewInflate.findViewById(R.id.platform_player_add_button);
            final ChipGroup chipGroupFindViewById3 = viewInflate.findViewById(R.id.platform_players_chip_group);
            SwitchMaterial switchMaterialFindViewById = viewInflate.findViewById(R.id.custom_box_art_aspect_ratio_switch);
            AutoCompleteTextView autoCompleteTextView6 = (AutoCompleteTextView) viewInflate.findViewById(R.id.platform_box_art_aspect_ratio_select);
            EditText editText7 = (EditText) viewInflate.findViewById(R.id.platform_custom_box_art_aspect_ratio_edit_text);
            SwitchMaterial switchMaterialFindViewById2 = viewInflate.findViewById(R.id.custom_screen_aspect_ratio_switch);
            final AutoCompleteTextView autoCompleteTextView7 = (AutoCompleteTextView) viewInflate.findViewById(R.id.platform_screen_aspect_ratio_select);
            final EditText editText8 = (EditText) viewInflate.findViewById(R.id.platform_custom_screen_aspect_ratio_edit_text);
            button.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment$$ExternalSyntheticLambda25
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EditPlatformDialogFragment.onCreateDialog$lambda$48$lambda$47$lambda$24(this.f$0, view);
                }
            });
            LifecycleOwner lifecycleOwner = (LifecycleOwner) fragmentActivity;
            final PlatformEntity platformEntity2 = platformEntity;
            EditText editText9 = editText6;
            final AutoCompleteTextView autoCompleteTextView8 = autoCompleteTextView3;
            CheckBox checkBox4 = checkBox2;
            this.selectedWallpaperUriLiveData.observe(lifecycleOwner, new EditPlatformDialogFragment$sam$androidx_lifecycle_Observer$0(new Function1<Uri, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment$onCreateDialog$1$1$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Uri uri) throws Throwable {
                    invoke2(uri);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Type inference failed for: r9v1, types: [T, java.io.File] */
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Uri uri) throws Throwable {
                    if (uri != null) {
                        EditPlatformDialogFragment editPlatformDialogFragment = this.this$0;
                        Context context2 = context;
                        Ref.ObjectRef<File> objectRef2 = objectRef;
                        TextView textView2 = textView;
                        Ref.BooleanRef booleanRef2 = booleanRef;
                        editPlatformDialogFragment.ensureWallpaperDirectory();
                        String str = context2.getFilesDir() + "/" + editPlatformDialogFragment.wallpaperDirectoryName + "/temp";
                        Utils utils = Utils.INSTANCE;
                        Intrinsics.checkNotNull(context2);
                        utils.copyFile(context2, uri, str);
                        objectRef2.element = new File(str);
                        textView2.setText(editPlatformDialogFragment.getString(R.string.selected));
                        booleanRef2.element = true;
                    }
                }
            }));
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EditPlatformDialogFragment.onCreateDialog$lambda$48$lambda$47$lambda$25(textView, this, booleanRef, view);
                }
            });
            Intrinsics.checkNotNull(context);
            autoCompleteTextView2.setAdapter(new AutoCompleteAdapter(context, R.layout.list_item_dropdown_item, arrayList9));
            EditText editText10 = editText3;
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EditPlatformDialogFragment.onCreateDialog$lambda$48$lambda$47$lambda$26(autoCompleteTextView2, arrayList9, this, list, arrayList21, context, chipGroupFindViewById, view);
                }
            };
            ArrayList arrayList23 = arrayList9;
            List list8 = list;
            ArrayList arrayList24 = arrayList21;
            chipFindViewById.setOnClickListener(onClickListener);
            autoCompleteTextView8.setAdapter(new AutoCompleteAdapter(context, R.layout.list_item_dropdown_item, list3));
            View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EditPlatformDialogFragment.onCreateDialog$lambda$48$lambda$47$lambda$27(autoCompleteTextView8, list3, this, arrayList20, context, chipGroupFindViewById2, view);
                }
            };
            ChipGroup chipGroup = chipGroupFindViewById2;
            chipFindViewById2.setOnClickListener(onClickListener2);
            List list9 = mutableList;
            ArrayList arrayList25 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list9, 10));
            int i8 = 0;
            for (Object obj : list9) {
                int i9 = i8 + 1;
                if (i8 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (!arrayList22.contains(Long.valueOf(((PlayerEntity) obj).getId()))) {
                    i8 = -1;
                }
                arrayList25.add(Integer.valueOf(i8));
                i8 = i9;
            }
            ArrayList arrayList26 = new ArrayList();
            for (Object obj2 : arrayList25) {
                if (((Number) obj2).intValue() >= 0) {
                    arrayList26.add(obj2);
                }
            }
            ArrayList arrayList27 = arrayList26;
            ArrayList arrayList28 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList27, 10));
            Iterator it = arrayList27.iterator();
            while (it.hasNext()) {
                arrayList28.add((String) arrayList15.get(((Number) it.next()).intValue()));
            }
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(context, R.layout.list_item_dropdown_item, arrayList28);
            this.playerArrayAdapter = arrayAdapter;
            autoCompleteTextView4.setAdapter(arrayAdapter);
            final AutoCompleteAdapter autoCompleteAdapter = new AutoCompleteAdapter(context, R.layout.list_item_dropdown_item, arrayList15);
            autoCompleteTextView5.setAdapter(autoCompleteAdapter);
            getDaijishouLibrary().getAllPlayers().observe(lifecycleOwner, new EditPlatformDialogFragment$sam$androidx_lifecycle_Observer$0(new Function1<List<? extends PlayerEntity>, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment$onCreateDialog$1$1$9
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends PlayerEntity> list10) {
                    invoke2((List<PlayerEntity>) list10);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<PlayerEntity> list10) {
                    mutableList.clear();
                    List<PlayerEntity> list11 = mutableList;
                    Intrinsics.checkNotNull(list10);
                    list11.addAll(list10);
                    arrayList15.clear();
                    List<String> list12 = arrayList15;
                    int size7 = list10.size();
                    ArrayList arrayList29 = new ArrayList(size7);
                    int i10 = 0;
                    for (int i11 = 0; i11 < size7; i11++) {
                        arrayList29.add(i11 + " - " + list10.get(i11).getName());
                    }
                    list12.addAll(arrayList29);
                    arrayList17.clear();
                    List<String> list13 = arrayList17;
                    int size8 = list10.size();
                    ArrayList arrayList30 = new ArrayList(size8);
                    for (int i12 = 0; i12 < size8; i12++) {
                        arrayList30.add(list10.get(i12).getName());
                    }
                    list13.addAll(arrayList30);
                    arrayList19.clear();
                    List<Long> list14 = arrayList19;
                    int size9 = list10.size();
                    ArrayList arrayList31 = new ArrayList(size9);
                    for (int i13 = 0; i13 < size9; i13++) {
                        arrayList31.add(Long.valueOf(list10.get(i13).getId()));
                    }
                    list14.addAll(arrayList31);
                    ArrayAdapter arrayAdapter2 = this.playerArrayAdapter;
                    Intrinsics.checkNotNull(arrayAdapter2);
                    arrayAdapter2.clear();
                    ArrayAdapter arrayAdapter3 = this.playerArrayAdapter;
                    Intrinsics.checkNotNull(arrayAdapter3);
                    List<PlayerEntity> list15 = mutableList;
                    List<Long> list16 = arrayList22;
                    ArrayList arrayList32 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list15, 10));
                    for (Object obj3 : list15) {
                        int i14 = i10 + 1;
                        if (i10 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (!list16.contains(Long.valueOf(((PlayerEntity) obj3).getId()))) {
                            i10 = -1;
                        }
                        arrayList32.add(Integer.valueOf(i10));
                        i10 = i14;
                    }
                    ArrayList arrayList33 = new ArrayList();
                    for (Object obj4 : arrayList32) {
                        if (((Number) obj4).intValue() >= 0) {
                            arrayList33.add(obj4);
                        }
                    }
                    ArrayList arrayList34 = arrayList33;
                    List<String> list17 = arrayList15;
                    ArrayList arrayList35 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList34, 10));
                    Iterator it2 = arrayList34.iterator();
                    while (it2.hasNext()) {
                        arrayList35.add(list17.get(((Number) it2.next()).intValue()));
                    }
                    arrayAdapter3.addAll(arrayList35);
                    autoCompleteAdapter.notifyDataSetChanged();
                }
            }));
            final EditPlatformDialogFragment editPlatformDialogFragment = this;
            View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EditPlatformDialogFragment.onCreateDialog$lambda$48$lambda$47$lambda$31(autoCompleteTextView5, arrayList15, editPlatformDialogFragment, arrayList19, arrayList22, context, chipGroupFindViewById3, view);
                }
            };
            ArrayList arrayList29 = arrayList22;
            Context context2 = context;
            ChipGroup chipGroup2 = chipGroupFindViewById3;
            chipFindViewById3.setOnClickListener(onClickListener3);
            final AutoCompleteTextView autoCompleteTextView9 = autoCompleteTextView6;
            autoCompleteTextView9.setAdapter(new AutoCompleteAdapter(context2, R.layout.list_item_dropdown_item, arrayList11));
            final SwitchMaterial switchMaterial2 = switchMaterialFindViewById;
            final EditText editText11 = editText7;
            switchMaterial2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment$$ExternalSyntheticLambda9
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                    EditPlatformDialogFragment.onCreateDialog$lambda$48$lambda$47$setUseCustomBoxArtAspectRatio(switchMaterial2, autoCompleteTextView9, editText11, z2);
                }
            });
            ArrayList arrayList30 = arrayList13;
            autoCompleteTextView7.setAdapter(new AutoCompleteAdapter(context2, R.layout.list_item_dropdown_item, arrayList30));
            final SwitchMaterial switchMaterial3 = switchMaterialFindViewById2;
            switchMaterial3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment$$ExternalSyntheticLambda10
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                    EditPlatformDialogFragment.onCreateDialog$lambda$48$lambda$47$setUseCustomScreenAspectRatio(switchMaterial3, autoCompleteTextView7, editText8, z2);
                }
            });
            button3.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment$$ExternalSyntheticLambda12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EditPlatformDialogFragment.onCreateDialog$lambda$48$lambda$47$lambda$34(this.f$0, view);
                }
            });
            button4.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment$$ExternalSyntheticLambda13
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EditPlatformDialogFragment.onCreateDialog$lambda$48$lambda$47$lambda$35(this.f$0, view);
                }
            });
            button5.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment$$ExternalSyntheticLambda14
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EditPlatformDialogFragment.onCreateDialog$lambda$48$lambda$47$lambda$36(this.f$0, view);
                }
            });
            if (platformEntity2 != null) {
                EditText editText12 = editText10;
                editText12.setText(platformEntity2.getName());
                EditText editText13 = editText4;
                editText13.setText(platformEntity2.getShortname());
                Iterator<T> it2 = platformEntity2.getRetroAchievementsConsoleIdList().iterator();
                while (it2.hasNext()) {
                    SwitchMaterial switchMaterial4 = switchMaterial2;
                    EditPlatformDialogFragment editPlatformDialogFragment2 = editPlatformDialogFragment;
                    ArrayList arrayList31 = arrayList23;
                    EditText editText14 = editText12;
                    ArrayList arrayList32 = arrayList24;
                    ArrayList arrayList33 = arrayList29;
                    AutoCompleteTextView autoCompleteTextView10 = autoCompleteTextView9;
                    List list10 = list8;
                    onCreateDialog$lambda$48$lambda$47$addRetroAchievementsConsoleId(autoCompleteTextView2, arrayList32, context2, arrayList31, list10, editPlatformDialogFragment2, chipGroupFindViewById, ((Number) it2.next()).longValue());
                    arrayList23 = arrayList31;
                    editPlatformDialogFragment = editPlatformDialogFragment2;
                    switchMaterial2 = switchMaterial4;
                    chipGroup = chipGroup;
                    editText11 = editText11;
                    autoCompleteTextView8 = autoCompleteTextView8;
                    arrayList30 = arrayList30;
                    editText13 = editText13;
                    switchMaterial3 = switchMaterial3;
                    list8 = list10;
                    autoCompleteTextView9 = autoCompleteTextView10;
                    arrayList29 = arrayList33;
                    arrayList24 = arrayList32;
                    editText12 = editText14;
                }
                editText10 = editText12;
                ArrayList arrayList34 = arrayList30;
                SwitchMaterial switchMaterial5 = switchMaterial3;
                editText2 = editText13;
                AutoCompleteTextView autoCompleteTextView11 = autoCompleteTextView8;
                arrayList4 = arrayList24;
                arrayList6 = arrayList11;
                editText = editText11;
                ArrayList arrayList35 = arrayList29;
                ChipGroup chipGroup3 = chipGroup;
                autoCompleteTextView = autoCompleteTextView9;
                switchMaterial = switchMaterial2;
                CheckBox checkBox5 = checkBox3;
                checkBox5.setChecked(platformEntity2.getScrapePreviewMedia());
                CheckBox checkBox6 = checkBox4;
                checkBox6.setChecked(platformEntity2.isVisible());
                textView.setText(editPlatformDialogFragment.getString(platformEntity2.getWallpaperPath() == null ? R.string.not_selected : R.string.selected));
                EditText editText15 = editText9;
                editText15.setText(platformEntity2.getAcceptedFilenameRegex());
                Iterator<T> it3 = platformEntity2.getScraperSourceList().iterator();
                while (it3.hasNext()) {
                    onCreateDialog$lambda$48$lambda$47$addScraperSource(autoCompleteTextView11, arrayList20, context2, editPlatformDialogFragment, chipGroup3, (String) it3.next());
                    editPlatformDialogFragment = this;
                    editText15 = editText15;
                }
                editText9 = editText15;
                Iterator<T> it4 = platformEntity2.getPlayerIdList().iterator();
                while (it4.hasNext()) {
                    Context context3 = context2;
                    ChipGroup chipGroup4 = chipGroup2;
                    ArrayList arrayList36 = arrayList19;
                    ArrayList arrayList37 = arrayList35;
                    AutoCompleteTextView autoCompleteTextView12 = autoCompleteTextView5;
                    onCreateDialog$lambda$48$lambda$47$addPlayer(this, autoCompleteTextView12, arrayList37, arrayList36, arrayList15, context3, chipGroup4, ((Number) it4.next()).longValue());
                    context2 = context3;
                    autoCompleteTextView5 = autoCompleteTextView12;
                    arrayList19 = arrayList36;
                    arrayList35 = arrayList37;
                    checkBox5 = checkBox5;
                    checkBox6 = checkBox6;
                    chipGroup2 = chipGroup4;
                }
                editPlatformDialogFragment = this;
                checkBox = checkBox5;
                checkBox4 = checkBox6;
                arrayList3 = arrayList19;
                arrayList2 = arrayList35;
                arrayList5 = arrayList15;
                int iIndexOf = arrayList3.indexOf(Long.valueOf(platformEntity2.getDefaultPlayerId()));
                if (iIndexOf != -1) {
                    z = false;
                    autoCompleteTextView4.setText((CharSequence) arrayList5.get(iIndexOf), false);
                    autoCompleteTextView4.setListSelection(iIndexOf);
                } else {
                    z = false;
                }
                onCreateDialog$lambda$48$lambda$47$setUseCustomBoxArtAspectRatio(switchMaterial, autoCompleteTextView, editText, platformEntity2.getUseCustomBoxArtAspectRatio());
                autoCompleteTextView.setText((CharSequence) arrayList6.get(platformEntity2.getBoxArtAspectRatioId()), z);
                editText.setText(platformEntity2.getCustomBoxArtAspectRatio());
                switchMaterial3 = switchMaterial5;
                onCreateDialog$lambda$48$lambda$47$setUseCustomScreenAspectRatio(switchMaterial3, autoCompleteTextView7, editText8, platformEntity2.getUseCustomScreenAspectRatio());
                arrayList = arrayList34;
                autoCompleteTextView7.setText((CharSequence) arrayList.get(platformEntity2.getScreenAspectRatioId()), z);
                editText8.setText(platformEntity2.getCustomScreenAspectRatio());
            } else {
                checkBox = checkBox3;
                switchMaterial = switchMaterial2;
                editText = editText11;
                arrayList = arrayList30;
                arrayList2 = arrayList29;
                arrayList3 = arrayList19;
                editText2 = editText4;
                arrayList4 = arrayList24;
                autoCompleteTextView = autoCompleteTextView9;
                arrayList5 = arrayList15;
                arrayList6 = arrayList11;
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
            AlertDialog.Builder negativeButton = view.setTitle(string).setPositiveButton(editPlatformDialogFragment.getString(R.string.save), new DialogInterface.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    EditPlatformDialogFragment.onCreateDialog$lambda$48$lambda$47$lambda$40(dialogInterface, i10);
                }
            }).setNegativeButton(editPlatformDialogFragment.getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    dialogInterface.cancel();
                }
            });
            if (platformEntity2 != null) {
                negativeButton = negativeButton.setNeutralButton(editPlatformDialogFragment.getString(R.string.delete), new DialogInterface.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment$$ExternalSyntheticLambda3
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i10) {
                        EditPlatformDialogFragment.onCreateDialog$lambda$48$lambda$47$lambda$42(dialogInterface, i10);
                    }
                });
            }
            alertDialogCreate = negativeButton.create();
            Intrinsics.checkNotNull(alertDialogCreate);
            editPlatformDialogFragment.setupDaijishouDialog(alertDialogCreate);
            editText10.requestFocus();
            final AutoCompleteTextView autoCompleteTextView13 = autoCompleteTextView;
            final ArrayList arrayList38 = arrayList2;
            final ArrayList arrayList39 = arrayList;
            final EditText editText16 = editText2;
            final EditText editText17 = editText10;
            final ArrayList arrayList40 = arrayList5;
            final EditText editText18 = editText;
            final Context context4 = context2;
            final EditText editText19 = editText9;
            final SwitchMaterial switchMaterial6 = switchMaterial3;
            final CheckBox checkBox7 = checkBox;
            final ArrayList arrayList41 = arrayList6;
            final CheckBox checkBox8 = checkBox4;
            alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment$$ExternalSyntheticLambda4
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    EditPlatformDialogFragment.onCreateDialog$lambda$48$lambda$47$lambda$46(alertDialogCreate, platformEntity2, editPlatformDialogFragment, context4, editText5, editText17, editText16, checkBox7, checkBox8, editText19, autoCompleteTextView4, switchMaterial, autoCompleteTextView13, arrayList41, editText18, switchMaterial6, autoCompleteTextView7, arrayList39, editText8, arrayList40, arrayList3, arrayList38, arrayList4, arrayList20, booleanRef, objectRef, dialogInterface);
                }
            });
        } else {
            alertDialogCreate = null;
        }
        if (alertDialogCreate != null) {
            return alertDialogCreate;
        }
        throw new IllegalStateException("Context cannot be null");
    }

    private static final void onCreateDialog$lambda$48$lambda$47$addRetroAchievementsConsoleId(AutoCompleteTextView autoCompleteTextView, final List<Long> list, Context context, List<String> list2, List<Long> list3, EditPlatformDialogFragment editPlatformDialogFragment, final ChipGroup chipGroup, final long j) {
        autoCompleteTextView.setError(null);
        list.add(Long.valueOf(j));
        autoCompleteTextView.setText((CharSequence) null);
        View chip = new Chip(context);
        chip.setId(View.generateViewId());
        chip.setText(list2.get(list3.indexOf(Long.valueOf(j))));
        chip.setMaxWidth(editPlatformDialogFragment.getDpToPxConverter().convert(400.0f));
        chip.setCloseIconVisible(true);
        chip.setOnCloseIconClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditPlatformDialogFragment.onCreateDialog$lambda$48$lambda$47$addRetroAchievementsConsoleId$lambda$18(list, j, chipGroup, view);
            }
        });
        Intrinsics.checkNotNull(chipGroup);
        ViewGroupKt.get((ViewGroup) chipGroup, chipGroup.getChildCount() - 1).setNextFocusRightId(-1);
        chip.setNextFocusRightId(chip.getId());
        chipGroup.addView(chip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$48$lambda$47$addRetroAchievementsConsoleId$lambda$18(List selectedRetroAchievementsConsoleIdList, long j, ChipGroup chipGroup, View view) {
        Intrinsics.checkNotNullParameter(selectedRetroAchievementsConsoleIdList, "$selectedRetroAchievementsConsoleIdList");
        selectedRetroAchievementsConsoleIdList.remove(Long.valueOf(j));
        chipGroup.removeView(view);
    }

    private static final void onCreateDialog$lambda$48$lambda$47$addScraperSource(AutoCompleteTextView autoCompleteTextView, final List<String> list, Context context, EditPlatformDialogFragment editPlatformDialogFragment, final ChipGroup chipGroup, final String str) {
        autoCompleteTextView.setError(null);
        list.add(str);
        autoCompleteTextView.setText((CharSequence) null);
        View chip = new Chip(context);
        chip.setId(View.generateViewId());
        chip.setText(str);
        chip.setMaxWidth(editPlatformDialogFragment.getDpToPxConverter().convert(400.0f));
        chip.setCloseIconVisible(true);
        chip.setOnCloseIconClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditPlatformDialogFragment.onCreateDialog$lambda$48$lambda$47$addScraperSource$lambda$19(list, str, chipGroup, view);
            }
        });
        Intrinsics.checkNotNull(chipGroup);
        ViewGroupKt.get((ViewGroup) chipGroup, chipGroup.getChildCount() - 1).setNextFocusRightId(-1);
        chip.setNextFocusRightId(chip.getId());
        chipGroup.addView(chip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$48$lambda$47$addScraperSource$lambda$19(List selectedScraperSourceList, String scraperSourceText, ChipGroup chipGroup, View view) {
        Intrinsics.checkNotNullParameter(selectedScraperSourceList, "$selectedScraperSourceList");
        Intrinsics.checkNotNullParameter(scraperSourceText, "$scraperSourceText");
        selectedScraperSourceList.remove(scraperSourceText);
        chipGroup.removeView(view);
    }

    private static final void onCreateDialog$lambda$48$lambda$47$addPlayer(final EditPlatformDialogFragment editPlatformDialogFragment, AutoCompleteTextView autoCompleteTextView, final List<Long> list, List<Long> list2, List<String> list3, Context context, final ChipGroup chipGroup, final long j) {
        PlayerEntity playerByIdStatically = editPlatformDialogFragment.getDaijishouLibrary().getPlayerByIdStatically(j);
        if (playerByIdStatically == null) {
            return;
        }
        String name = playerByIdStatically.getName();
        autoCompleteTextView.setError(null);
        list.add(Long.valueOf(j));
        final String str = (String) CollectionsKt.getOrNull(list3, list2.indexOf(Long.valueOf(j)));
        if (str != null) {
            ArrayAdapter<String> arrayAdapter = editPlatformDialogFragment.playerArrayAdapter;
            Intrinsics.checkNotNull(arrayAdapter);
            arrayAdapter.add(str);
        }
        autoCompleteTextView.setText((CharSequence) null);
        View chip = new Chip(context);
        chip.setId(View.generateViewId());
        chip.setText(name);
        chip.setCloseIconVisible(true);
        chip.setOnCloseIconClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditPlatformDialogFragment.onCreateDialog$lambda$48$lambda$47$addPlayer$lambda$22(list, j, str, chipGroup, editPlatformDialogFragment, view);
            }
        });
        chip.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditPlatformDialogFragment.onCreateDialog$lambda$48$lambda$47$addPlayer$lambda$23(this.f$0, j, view);
            }
        });
        Intrinsics.checkNotNull(chipGroup);
        ViewGroupKt.get((ViewGroup) chipGroup, chipGroup.getChildCount() - 1).setNextFocusRightId(-1);
        chip.setNextFocusRightId(chip.getId());
        chipGroup.addView(chip);
    }

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$48$lambda$47$addPlayer$lambda$23(EditPlatformDialogFragment this$0, long j, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EditPlayerDialogFragment.Companion.newInstance(this$0.getDaijishouLibrary().getPlayerByIdStatically(j)).show(this$0.getParentFragmentManager(), EditPlayerDialogFragment.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$48$lambda$47$lambda$24(EditPlatformDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        onCreateDialog$lambda$48$lambda$47$lambda$24$openFile(this$0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$48$lambda$47$lambda$25(TextView textView, EditPlatformDialogFragment this$0, Ref.BooleanRef updateWallpaper, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(updateWallpaper, "$updateWallpaper");
        textView.setText(this$0.getString(R.string.not_selected));
        updateWallpaper.element = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$48$lambda$47$lambda$34(final EditPlatformDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ListSelectDialogFragment.Companion companion = ListSelectDialogFragment.Companion;
        String string = this$0.getString(R.string.import_preview_media_for_platform);
        String string2 = this$0.getString(R.string.import_preview_media_for_box_art);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = this$0.getString(R.string.import_preview_media_for_snapshot);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = this$0.getString(R.string.import_preview_media_for_title);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        ListSelectDialogFragment.Companion.newInstance$default(companion, string, CollectionsKt.arrayListOf(string2, string3, string4), null, false, 12, null).setOnSelectListener(new Function1<Integer, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment$onCreateDialog$1$1$13$1
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                if (i == 0) {
                    this.this$0.importBoxArtsFromUriActivity.launch(Uri.parse("/storage/"));
                } else if (i == 1) {
                    this.this$0.importSnapshotsFromUriActivity.launch(Uri.parse("/storage/"));
                } else {
                    if (i != 2) {
                        return;
                    }
                    this.this$0.importTitlesFromUriActivity.launch(Uri.parse("/storage/"));
                }
            }
        }).setOnCancelListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment$onCreateDialog$1$1$13$2
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        }).show(this$0.getParentFragmentManager(), ListSelectDialogFragment.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$48$lambda$47$lambda$35(EditPlatformDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Build.VERSION.SDK_INT >= 29) {
            this$0.importDatFileFromUriActivity.launch("*/*");
        } else {
            this$0.importDatFileFromUriActivity.launch("*/*");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$48$lambda$47$lambda$36(EditPlatformDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Build.VERSION.SDK_INT >= 29) {
            this$0.importXMLFileFromUriActivity.launch("text/xml");
        } else {
            this$0.importXMLFileFromUriActivity.launch("*/*");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$48$lambda$47$lambda$46(final AlertDialog alertDialog, final PlatformEntity platformEntity, final EditPlatformDialogFragment this$0, final Context context, final EditText editText, final EditText editText2, final EditText editText3, final CheckBox checkBox, final CheckBox checkBox2, final EditText editText4, final AutoCompleteTextView autoCompleteTextView, final SwitchMaterial switchMaterial, final AutoCompleteTextView autoCompleteTextView2, final List boxArtAspectRatioTextList, final EditText editText5, final SwitchMaterial switchMaterial2, final AutoCompleteTextView autoCompleteTextView3, final List screenAspectRatioTextList, final EditText editText6, final List playerEntityNameListWithIndex, final List playerEntityIdList, final List selectedPlayerIdList, final List selectedRetroAchievementsConsoleIdList, final List selectedScraperSourceList, final Ref.BooleanRef updateWallpaper, final Ref.ObjectRef selectedWallpaperFile, DialogInterface dialogInterface) {
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
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditPlatformDialogFragment.onCreateDialog$lambda$48$lambda$47$lambda$46$lambda$44(platformEntity, this$0, context, alertDialog, view);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditPlatformDialogFragment.onCreateDialog$lambda$48$lambda$47$lambda$46$lambda$45(editText, editText2, editText3, checkBox, checkBox2, editText4, autoCompleteTextView, switchMaterial, autoCompleteTextView2, boxArtAspectRatioTextList, editText5, switchMaterial2, autoCompleteTextView3, screenAspectRatioTextList, editText6, this$0, playerEntityNameListWithIndex, playerEntityIdList, selectedPlayerIdList, platformEntity, selectedRetroAchievementsConsoleIdList, selectedScraperSourceList, updateWallpaper, selectedWallpaperFile, alertDialog, context, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$48$lambda$47$lambda$46$lambda$44(final PlatformEntity platformEntity, final EditPlatformDialogFragment this$0, final Context context, final AlertDialog alertDialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        if (platformEntity != null) {
            if (this$0.deleteWallpaperOfPlatformEntity(platformEntity)) {
                final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                AcknowledgementDialogFragment.Companion companion = AcknowledgementDialogFragment.Companion;
                String string = this$0.getString(R.string.delete_unused_players);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string2 = this$0.getString(R.string.delete_unused_players_warning_format);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                String str = String.format(string2, Arrays.copyOf(new Object[]{platformEntity.getName()}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                AcknowledgementDialogFragment.Companion.newInstance$default(companion, string, str, this$0.getString(R.string.yes_delete_all), this$0.getString(R.string.no), null, 16, null).setOnAcknowledgedListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment$onCreateDialog$1$1$20$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        booleanRef.element = true;
                        EditPlatformDialogFragment.onCreateDialog$lambda$48$lambda$47$lambda$46$lambda$44$lambda$43$confirmAction(this$0, platformEntity, alertDialog, booleanRef, context);
                    }
                }).setOnCanceledListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment$onCreateDialog$1$1$20$1$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        EditPlatformDialogFragment.onCreateDialog$lambda$48$lambda$47$lambda$46$lambda$44$lambda$43$confirmAction(this.this$0, platformEntity, alertDialog, booleanRef, context);
                    }
                }).show(this$0.getParentFragmentManager(), AcknowledgementDialogFragment.class.getName());
                return;
            }
            Toast.makeText(context, "Wallpaper unable to delete.", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$48$lambda$47$lambda$46$lambda$44$lambda$43$confirmAction(final EditPlatformDialogFragment editPlatformDialogFragment, final PlatformEntity platformEntity, final AlertDialog alertDialog, final Ref.BooleanRef booleanRef, final Context context) {
        AcknowledgementDialogFragment.Companion companion = AcknowledgementDialogFragment.Companion;
        String string = editPlatformDialogFragment.getString(R.string.delete_platform);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string2 = editPlatformDialogFragment.getString(R.string.delete_platform_warning_format);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String str = String.format(string2, Arrays.copyOf(new Object[]{platformEntity.getName()}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        AcknowledgementDialogFragment.Companion.newInstance$default(companion, string, str, null, null, null, 28, null).setOnAcknowledgedListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment$onCreateDialog$1$1$20$1$1$confirmAction$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                alertDialog.dismiss();
                editPlatformDialogFragment.getDaijishouLibrary().removePlatform(platformEntity, booleanRef.element);
                Toast.makeText(context, editPlatformDialogFragment.getString(R.string.deleted_successfully), 0).show();
            }
        }).setOnCanceledListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment$onCreateDialog$1$1$20$1$1$confirmAction$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Toast.makeText(context, editPlatformDialogFragment.getString(R.string.canceled_period), 0).show();
            }
        }).show(editPlatformDialogFragment.getParentFragmentManager(), AcknowledgementDialogFragment.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void onCreateDialog$lambda$48$lambda$47$lambda$46$lambda$45(EditText editText, EditText editText2, EditText editText3, CheckBox checkBox, CheckBox checkBox2, EditText editText4, AutoCompleteTextView autoCompleteTextView, SwitchMaterial switchMaterial, AutoCompleteTextView autoCompleteTextView2, List boxArtAspectRatioTextList, EditText editText5, SwitchMaterial switchMaterial2, AutoCompleteTextView autoCompleteTextView3, List screenAspectRatioTextList, EditText editText6, EditPlatformDialogFragment this$0, List playerEntityNameListWithIndex, List playerEntityIdList, List selectedPlayerIdList, PlatformEntity platformEntity, List selectedRetroAchievementsConsoleIdList, List selectedScraperSourceList, Ref.BooleanRef updateWallpaper, Ref.ObjectRef selectedWallpaperFile, AlertDialog alertDialog, Context context, View view) {
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
        Integer intOrNull = StringsKt.toIntOrNull(editText.getText().toString());
        String string = editText2.getText().toString();
        String string2 = editText3.getText().toString();
        boolean zIsChecked = checkBox.isChecked();
        boolean zIsChecked2 = checkBox2.isChecked();
        String string3 = editText4.getText().toString();
        String string4 = autoCompleteTextView.getText().toString();
        boolean zIsChecked3 = switchMaterial.isChecked();
        int iIndexOf = boxArtAspectRatioTextList.indexOf(autoCompleteTextView2.getText().toString());
        if (iIndexOf == -1) {
            iIndexOf = 0;
        }
        String string5 = editText5.getText().toString();
        int i = iIndexOf;
        boolean zIsChecked4 = switchMaterial2.isChecked();
        int iIndexOf2 = screenAspectRatioTextList.indexOf(autoCompleteTextView3.getText().toString());
        if (iIndexOf2 == -1) {
            iIndexOf2 = 0;
        }
        String string6 = editText6.getText().toString();
        if (intOrNull == null) {
            editText.setError(this$0.getString(R.string.please_enter_valid_position));
            editText.requestFocus();
            return;
        }
        if (string.length() == 0) {
            editText2.setError(this$0.getString(R.string.please_enter_a_player_name));
            editText2.requestFocus();
            return;
        }
        if (string2.length() == 0) {
            editText3.setError(this$0.getString(R.string.please_enter_a_player_shortname));
            editText3.requestFocus();
            return;
        }
        int i2 = iIndexOf2;
        if (!StringsKt.startsWith$default(string3, "^", false, 2, (Object) null) || !StringsKt.endsWith$default(string3, "$", false, 2, (Object) null)) {
            editText4.setError(this$0.getString(R.string.regex_constraint_warning));
            editText4.requestFocus();
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
                    editText5.setError(this$0.getString(R.string.bad_aspect_ratio_format));
                    editText5.requestFocus();
                    return;
                }
                string5 = null;
            } else if (!aspectRatioRegex.matches(string5)) {
                editText5.setError(this$0.getString(R.string.bad_aspect_ratio_format));
                editText5.requestFocus();
                return;
            }
            if (Intrinsics.areEqual(string6, "") || string6 == null) {
                string6 = null;
            } else if (!aspectRatioRegex.matches(string6)) {
                editText6.setError(this$0.getString(R.string.bad_aspect_ratio_format));
                editText6.requestFocus();
                return;
            }
            if (selectedPlayerIdList.indexOf(l) == -1) {
                selectedPlayerIdList.add(l);
            }
            PlatformEntity platformEntity2 = platformEntity == null ? new PlatformEntity(0L, null, null, null, null, false, false, null, null, null, null, null, 0L, null, null, 0, false, null, 0, false, null, null, null, 0, null, 33554431, null) : platformEntity;
            platformEntity2.setPosition(intOrNull.intValue());
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
                if (selectedWallpaperFile.element == 0) {
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
                T t = selectedWallpaperFile.element;
                Intrinsics.checkNotNull(t);
                this$0.ensureWallpaperDirectory();
                BuildersKt.launch$default(this$0, Dispatchers.getIO(), (CoroutineStart) null, new EditPlatformDialogFragment$onCreateDialog$1$1$20$2$1(context, this$0, jAddPlatform, (File) t, platformEntity2, alertDialog, platformEntity, null), 2, (Object) null);
                return;
            }
            onCreateDialog$lambda$48$lambda$47$lambda$46$lambda$45$dismiss(alertDialog, context, platformEntity, this$0);
        } catch (Exception unused) {
            editText4.setError(this$0.getString(R.string.bad_regex_detected));
            editText4.requestFocus();
        }
    }

    private static final void onCreateDialog$lambda$48$lambda$47$lambda$46$lambda$45$dismiss(AlertDialog alertDialog, Context context, PlatformEntity platformEntity, EditPlatformDialogFragment editPlatformDialogFragment) {
        alertDialog.dismiss();
        Toast.makeText(context, editPlatformDialogFragment.getString(platformEntity == null ? R.string.added_successfully : R.string.edited_successfully), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$48$lambda$47$lambda$46$lambda$45$saveAndDismiss(PlatformEntity platformEntity, long j, EditPlatformDialogFragment editPlatformDialogFragment, AlertDialog alertDialog, Context context, PlatformEntity platformEntity2) {
        platformEntity.setId(j);
        editPlatformDialogFragment.getDaijishouLibrary().addPlatform(platformEntity);
        onCreateDialog$lambda$48$lambda$47$lambda$46$lambda$45$dismiss(alertDialog, context, platformEntity2, editPlatformDialogFragment);
    }
}
