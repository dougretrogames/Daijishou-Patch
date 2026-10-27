package com.magneticchen.daijishou.ui.fragments.dialog;

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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.db.entity.PlatformEntity;
import com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment;
import com.magneticchen.daijishou.ui.model.DaijishouLibraryModel;
import com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel;
import com.magneticchen.daijishou.ui.model.LibraryViewModel;
import com.magneticchen.daijishou.utils.FileUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: PickPlatformSyncTreeUrDialogFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a²\u0006\n\u0010\u0006\u001a\u00020\u0007X\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/PickPlatformSyncTreeUrDialogFragment;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/DaijishouDialogFragment;", "()V", "arrayItems", "", "Landroid/net/Uri;", "libraryViewModel", "Lcom/magneticchen/daijishou/ui/model/LibraryViewModel;", "platformEntity", "Lcom/magneticchen/daijishou/data/db/entity/PlatformEntity;", "getPlatformEntity", "()Lcom/magneticchen/daijishou/data/db/entity/PlatformEntity;", "setPlatformEntity", "(Lcom/magneticchen/daijishou/data/db/entity/PlatformEntity;)V", "selectSyncTreeUriActivity", "Landroidx/activity/result/ActivityResultLauncher;", "waitForUri", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onStart", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PickPlatformSyncTreeUrDialogFragment extends DaijishouDialogFragment {
    public static final Companion Companion = new Companion(null);
    private final List<Uri> arrayItems;
    private LibraryViewModel libraryViewModel;
    public PlatformEntity platformEntity;
    private ActivityResultLauncher<Uri> selectSyncTreeUriActivity;
    private boolean waitForUri;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$11$lambda$10$lambda$3(DialogInterface dialogInterface, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$11$lambda$10$lambda$4(DialogInterface dialogInterface, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$11$lambda$10$lambda$5(DialogInterface dialogInterface, int i) {
    }

    public PickPlatformSyncTreeUrDialogFragment() {
        ActivityResultLauncher<Uri> activityResultLauncherRegisterForActivityResult = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.OpenDocumentTree(), new ActivityResultCallback() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PickPlatformSyncTreeUrDialogFragment$$ExternalSyntheticLambda8
            public final void onActivityResult(Object obj) {
                PickPlatformSyncTreeUrDialogFragment.selectSyncTreeUriActivity$lambda$0(this.f$0, (Uri) obj);
            }
        });
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

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: compiled from: PickPlatformSyncTreeUrDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/PickPlatformSyncTreeUrDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/ui/fragments/dialog/PickPlatformSyncTreeUrDialogFragment;", "platformEntity", "Lcom/magneticchen/daijishou/data/db/entity/PlatformEntity;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    public void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (window != null) {
            window.setBackgroundDrawable(AppCompatResources.getDrawable(requireContext(), R.drawable.dialog_background));
        }
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        final Fragment fragment = (Fragment) this;
        final Function0 function0 = null;
        this.libraryViewModel = onCreate$lambda$1((Lazy<LibraryViewModel>) FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(LibraryViewModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PickPlatformSyncTreeUrDialogFragment$onCreate$$inlined$activityViewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return fragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PickPlatformSyncTreeUrDialogFragment$onCreate$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? fragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PickPlatformSyncTreeUrDialogFragment$onCreate$$inlined$activityViewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return fragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        }));
    }

    private static final LibraryViewModel onCreate$lambda$1(Lazy<LibraryViewModel> lazy) {
        return lazy.getValue();
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        DaijishouLibraryModel daijishouLibrary = getDaijishouLibrary();
        Bundle arguments = getArguments();
        final AlertDialog alertDialogCreate = null;
        Long lValueOf = arguments != null ? Long.valueOf(arguments.getLong("platformEntityId")) : null;
        Intrinsics.checkNotNull(lValueOf);
        PlatformEntity platformByIdStatically = daijishouLibrary.getPlatformByIdStatically(lValueOf.longValue());
        Intrinsics.checkNotNull(platformByIdStatically);
        setPlatformEntity(platformByIdStatically);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            final Context context = getContext();
            if (context != null) {
                View viewInflate = activity.getLayoutInflater().inflate(R.layout.fragment_platform_sync_paths, (ViewGroup) null);
                ListView listView = (ListView) viewInflate.findViewById(R.id.platform_sync_paths_list_view);
                final List<Uri> list = this.arrayItems;
                final ArrayAdapter<Uri> arrayAdapter = new ArrayAdapter<Uri>(context, list) { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PickPlatformSyncTreeUrDialogFragment$onCreateDialog$1$1$adapter$1
                    @Override // android.widget.ArrayAdapter, android.widget.Adapter
                    public View getView(int i, View view, ViewGroup parent) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        View view2 = super.getView(i, view, parent);
                        Intrinsics.checkNotNullExpressionValue(view2, "getView(...)");
                        View viewFindViewById = view2.findViewById(R.id.list_item_theme_pack_choice_title);
                        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
                        ((TextView) viewFindViewById).setText(String.valueOf(((Uri) this.arrayItems.get(i)).getPath()));
                        return view2;
                    }
                };
                listView.setAdapter((ListAdapter) arrayAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PickPlatformSyncTreeUrDialogFragment$$ExternalSyntheticLambda0
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                        PickPlatformSyncTreeUrDialogFragment.onCreateDialog$lambda$11$lambda$10$lambda$2(this.f$0, adapterView, view, i, j);
                    }
                });
                getDaijishouLibrary().getPlatformById(getPlatformEntity().getId()).observe((LifecycleOwner) this, new PickPlatformSyncTreeUrDialogFragment$sam$androidx_lifecycle_Observer$0(new Function1<PlatformEntity, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PickPlatformSyncTreeUrDialogFragment$onCreateDialog$1$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(PlatformEntity platformEntity) {
                        invoke2(platformEntity);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(PlatformEntity platformEntity) {
                        if (platformEntity != null) {
                            PickPlatformSyncTreeUrDialogFragment pickPlatformSyncTreeUrDialogFragment = this.this$0;
                            ArrayAdapter<?> arrayAdapter2 = arrayAdapter;
                            pickPlatformSyncTreeUrDialogFragment.setPlatformEntity(platformEntity);
                            pickPlatformSyncTreeUrDialogFragment.arrayItems.clear();
                            pickPlatformSyncTreeUrDialogFragment.arrayItems.addAll(platformEntity.getItemsSyncTreeUriList());
                            arrayAdapter2.notifyDataSetChanged();
                        }
                    }
                }));
                alertDialogCreate = new AlertDialog.Builder(context).setView(viewInflate).setTitle(getString(R.string.synchronization_paths_title)).setPositiveButton(getString(R.string.sync), new DialogInterface.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PickPlatformSyncTreeUrDialogFragment$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        PickPlatformSyncTreeUrDialogFragment.onCreateDialog$lambda$11$lambda$10$lambda$3(dialogInterface, i);
                    }
                }).setNegativeButton(getString(R.string.finish), new DialogInterface.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PickPlatformSyncTreeUrDialogFragment$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        PickPlatformSyncTreeUrDialogFragment.onCreateDialog$lambda$11$lambda$10$lambda$4(dialogInterface, i);
                    }
                }).setNeutralButton(getString(R.string.add_more), new DialogInterface.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PickPlatformSyncTreeUrDialogFragment$$ExternalSyntheticLambda3
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        PickPlatformSyncTreeUrDialogFragment.onCreateDialog$lambda$11$lambda$10$lambda$5(dialogInterface, i);
                    }
                }).create();
                Intrinsics.checkNotNull(alertDialogCreate);
                setupDaijishouDialog(alertDialogCreate);
                alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PickPlatformSyncTreeUrDialogFragment$$ExternalSyntheticLambda4
                    @Override // android.content.DialogInterface.OnShowListener
                    public final void onShow(DialogInterface dialogInterface) {
                        PickPlatformSyncTreeUrDialogFragment.onCreateDialog$lambda$11$lambda$10$lambda$9(alertDialogCreate, this, dialogInterface);
                    }
                });
            }
            if (alertDialogCreate != null) {
                return alertDialogCreate;
            }
            throw new IllegalStateException("Context cannot be null");
        }
        throw new IllegalStateException("Activity cannot be null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$11$lambda$10$lambda$2$removeSyncTreeUri(final PickPlatformSyncTreeUrDialogFragment pickPlatformSyncTreeUrDialogFragment, final int i, final boolean z) {
        AcknowledgementDialogFragment.Companion.newInstance$default(AcknowledgementDialogFragment.Companion, pickPlatformSyncTreeUrDialogFragment.getString(R.string.are_you_sure), pickPlatformSyncTreeUrDialogFragment.getString(R.string.delete_uri_warning), null, null, null, 28, null).setOnAcknowledgedListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PickPlatformSyncTreeUrDialogFragment$onCreateDialog$1$1$1$removeSyncTreeUri$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (i >= pickPlatformSyncTreeUrDialogFragment.getPlatformEntity().getItemsSyncTreeUriList().size()) {
                    return;
                }
                LibraryViewModel libraryViewModel = pickPlatformSyncTreeUrDialogFragment.libraryViewModel;
                if (libraryViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("libraryViewModel");
                    libraryViewModel = null;
                }
                libraryViewModel.removeSelectedPlatformSyncTreeUriSafely(pickPlatformSyncTreeUrDialogFragment.getPlatformEntity().getItemsSyncTreeUriList().get(i), z);
            }
        }).setOnCanceledListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PickPlatformSyncTreeUrDialogFragment$onCreateDialog$1$1$1$removeSyncTreeUri$2
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Toast.makeText(this.this$0.requireContext(), this.this$0.getString(R.string.aborted_period), 0).show();
            }
        }).show(pickPlatformSyncTreeUrDialogFragment.getParentFragmentManager(), AcknowledgementDialogFragment.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$11$lambda$10$lambda$2(final PickPlatformSyncTreeUrDialogFragment this$0, AdapterView adapterView, View view, final int i, long j) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AcknowledgementDialogFragment.Companion.newInstance$default(AcknowledgementDialogFragment.Companion, this$0.getString(R.string.keep_records_warning_title), this$0.getString(R.string.keep_records_warning), this$0.getString(R.string.keep_records), this$0.getString(R.string.remove), null, 16, null).setOnAcknowledgedListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PickPlatformSyncTreeUrDialogFragment$onCreateDialog$1$1$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PickPlatformSyncTreeUrDialogFragment.onCreateDialog$lambda$11$lambda$10$lambda$2$removeSyncTreeUri(this.this$0, i, true);
            }
        }).setOnCanceledListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PickPlatformSyncTreeUrDialogFragment$onCreateDialog$1$1$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PickPlatformSyncTreeUrDialogFragment.onCreateDialog$lambda$11$lambda$10$lambda$2$removeSyncTreeUri(this.this$0, i, false);
            }
        }).show(this$0.getParentFragmentManager(), AcknowledgementDialogFragment.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$11$lambda$10$lambda$9(final AlertDialog alertDialog, final PickPlatformSyncTreeUrDialogFragment this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(alertDialog, "null cannot be cast to non-null type android.app.AlertDialog");
        Button button = alertDialog.getButton(-3);
        Intrinsics.checkNotNullExpressionValue(button, "getButton(...)");
        button.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PickPlatformSyncTreeUrDialogFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PickPlatformSyncTreeUrDialogFragment.onCreateDialog$lambda$11$lambda$10$lambda$9$lambda$6(this.f$0, view);
            }
        });
        Button button2 = alertDialog.getButton(-1);
        Intrinsics.checkNotNullExpressionValue(button2, "getButton(...)");
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PickPlatformSyncTreeUrDialogFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PickPlatformSyncTreeUrDialogFragment.onCreateDialog$lambda$11$lambda$10$lambda$9$lambda$7(this.f$0, alertDialog, view);
            }
        });
        Button button3 = alertDialog.getButton(-2);
        Intrinsics.checkNotNullExpressionValue(button3, "getButton(...)");
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PickPlatformSyncTreeUrDialogFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PickPlatformSyncTreeUrDialogFragment.onCreateDialog$lambda$11$lambda$10$lambda$9$lambda$8(this.f$0, alertDialog, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$11$lambda$10$lambda$9$lambda$6(PickPlatformSyncTreeUrDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.waitForUri = true;
        this$0.selectSyncTreeUriActivity.launch(Uri.parse("/storage/"));
    }

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$11$lambda$10$lambda$9$lambda$8(PickPlatformSyncTreeUrDialogFragment this$0, AlertDialog alertDialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.waitForUri) {
            return;
        }
        alertDialog.dismiss();
    }
}
