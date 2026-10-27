package com.magneticchen.daijishou.ui.fragments.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
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
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.PreferenceManager;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputEditText;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.Constants;
import com.magneticchen.daijishou.data.Genre;
import com.magneticchen.daijishou.data.Genres;
import com.magneticchen.daijishou.data.PlayableItemPreviewMediaIndex;
import com.magneticchen.daijishou.data.db.entity.PlatformEntity;
import com.magneticchen.daijishou.data.db.entity.PlayableItemEntity;
import com.magneticchen.daijishou.data.db.entity.PlayableItemToGenrePairEntity;
import com.magneticchen.daijishou.data.db.entity.PlayerEntity;
import com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment;
import com.magneticchen.daijishou.ui.model.DaijishouLibraryModel;
import com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel;
import com.magneticchen.daijishou.utils.AutoCompleteAdapter;
import com.magneticchen.daijishou.utils.ScraperUtilsKt;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: EditPlayableItemDialogFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/DaijishouDialogFragment;", "()V", "playableItemEntity", "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;", "setBoxArtActivity", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "setSnapshotActivity", "setTitleActivity", "checkPreviewMediaDirectory", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class EditPlayableItemDialogFragment extends DaijishouDialogFragment {
    public static final Companion Companion = new Companion(null);
    private PlayableItemEntity playableItemEntity;
    private ActivityResultLauncher<String> setBoxArtActivity;
    private ActivityResultLauncher<String> setSnapshotActivity;
    private ActivityResultLauncher<String> setTitleActivity;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$17(DialogInterface dialogInterface, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$19(DialogInterface dialogInterface, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$20(DialogInterface dialogInterface, int i) {
    }

    public EditPlayableItemDialogFragment() {
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.GetContent(), new ActivityResultCallback() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlayableItemDialogFragment$$ExternalSyntheticLambda4
            public final void onActivityResult(Object obj) throws IOException {
                EditPlayableItemDialogFragment.setBoxArtActivity$lambda$0(this.f$0, (Uri) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.setBoxArtActivity = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.GetContent(), new ActivityResultCallback() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlayableItemDialogFragment$$ExternalSyntheticLambda5
            public final void onActivityResult(Object obj) throws IOException {
                EditPlayableItemDialogFragment.setSnapshotActivity$lambda$1(this.f$0, (Uri) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(...)");
        this.setSnapshotActivity = activityResultLauncherRegisterForActivityResult2;
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult3 = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.GetContent(), new ActivityResultCallback() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlayableItemDialogFragment$$ExternalSyntheticLambda6
            public final void onActivityResult(Object obj) throws IOException {
                EditPlayableItemDialogFragment.setTitleActivity$lambda$2(this.f$0, (Uri) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult3, "registerForActivityResult(...)");
        this.setTitleActivity = activityResultLauncherRegisterForActivityResult3;
    }

    /* JADX INFO: compiled from: EditPlayableItemDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;", "playableItemEntity", "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EditPlayableItemDialogFragment newInstance(PlayableItemEntity playableItemEntity) {
            Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
            EditPlayableItemDialogFragment editPlayableItemDialogFragment = new EditPlayableItemDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("playableItemEntity", playableItemEntity);
            editPlayableItemDialogFragment.setArguments(bundle);
            return editPlayableItemDialogFragment;
        }
    }

    private final String checkPreviewMediaDirectory() throws IOException {
        String previewMediaPath;
        String string = PreferenceManager.getDefaultSharedPreferences(requireContext()).getString("preview_media_path", requireContext().getApplicationContext().getFilesDir() + "/preview_media/");
        PlayableItemEntity playableItemEntity = this.playableItemEntity;
        if (playableItemEntity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
            playableItemEntity = null;
        }
        if (playableItemEntity.getPreviewMediaPath() == null) {
            PlayableItemEntity playableItemEntity2 = this.playableItemEntity;
            if (playableItemEntity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
                playableItemEntity2 = null;
            }
            previewMediaPath = string + playableItemEntity2.getId() + "/";
        } else {
            PlayableItemEntity playableItemEntity3 = this.playableItemEntity;
            if (playableItemEntity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
                playableItemEntity3 = null;
            }
            previewMediaPath = playableItemEntity3.getPreviewMediaPath();
        }
        Intrinsics.checkNotNull(previewMediaPath);
        String str = previewMediaPath + "index.json";
        if (new File(str).exists()) {
            return previewMediaPath;
        }
        File file = new File(previewMediaPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        StringFormat stringFormatJson$default = JsonKt.Json$default((Json) null, new Function1<JsonBuilder, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlayableItemDialogFragment$checkPreviewMediaDirectory$jsonFormat$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
                invoke2(jsonBuilder);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JsonBuilder Json) {
                Intrinsics.checkNotNullParameter(Json, "$this$Json");
                Json.setPrettyPrint(true);
                Json.setEncodeDefaults(true);
            }
        }, 1, (Object) null);
        PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex = new PlayableItemPreviewMediaIndex((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
        stringFormatJson$default.getSerializersModule();
        String strEncodeToString = stringFormatJson$default.encodeToString(PlayableItemPreviewMediaIndex.Companion.serializer(), playableItemPreviewMediaIndex);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(str));
        outputStreamWriter.write(strEncodeToString);
        outputStreamWriter.close();
        return previewMediaPath;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setBoxArtActivity$lambda$0(EditPlayableItemDialogFragment this$0, Uri uri) throws IOException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(uri, Uri.EMPTY) || uri == null) {
            Toast.makeText(this$0.requireContext(), this$0.getString(R.string.aborted_period), 0).show();
            return;
        }
        String strCheckPreviewMediaDirectory = this$0.checkPreviewMediaDirectory();
        String str = strCheckPreviewMediaDirectory + "index.json";
        String str2 = strCheckPreviewMediaDirectory + Constants.scraperBoxArtFileName;
        String string = IOUtils.toString(new FileInputStream(str), StandardCharsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex = (PlayableItemPreviewMediaIndex) Json.Default.decodeFromString(PlayableItemPreviewMediaIndex.Companion.serializer(), string);
        BitmapFactory.decodeStream(this$0.requireActivity().getContentResolver().openInputStream(uri)).compress(Constants.INSTANCE.getScraperFormat(), 100, new FileOutputStream(str2));
        playableItemPreviewMediaIndex.setBoxArtPath(Constants.scraperBoxArtFileName);
        PlayableItemEntity playableItemEntity = null;
        StringFormat stringFormatJson$default = JsonKt.Json$default((Json) null, new Function1<JsonBuilder, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlayableItemDialogFragment$setBoxArtActivity$1$jsonFormat$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
                invoke2(jsonBuilder);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JsonBuilder Json) {
                Intrinsics.checkNotNullParameter(Json, "$this$Json");
                Json.setPrettyPrint(true);
                Json.setEncodeDefaults(true);
            }
        }, 1, (Object) null);
        stringFormatJson$default.getSerializersModule();
        String strEncodeToString = stringFormatJson$default.encodeToString(PlayableItemPreviewMediaIndex.Companion.serializer(), playableItemPreviewMediaIndex);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(str));
        outputStreamWriter.write(strEncodeToString);
        outputStreamWriter.close();
        PlayableItemEntity playableItemEntity2 = this$0.playableItemEntity;
        if (playableItemEntity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
            playableItemEntity2 = null;
        }
        playableItemEntity2.setPreviewMediaPath(strCheckPreviewMediaDirectory);
        this$0.getDaijishouLibrary().getCachedBoxArtBitmapLoader().remove(str2);
        DaijishouLibraryModel daijishouLibrary = this$0.getDaijishouLibrary();
        PlayableItemEntity playableItemEntity3 = this$0.playableItemEntity;
        if (playableItemEntity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
        } else {
            playableItemEntity = playableItemEntity3;
        }
        daijishouLibrary.updatePlayableItem(playableItemEntity);
        Toast.makeText(this$0.requireContext(), this$0.getString(R.string.box_art_saved), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSnapshotActivity$lambda$1(EditPlayableItemDialogFragment this$0, Uri uri) throws IOException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(uri, Uri.EMPTY) || uri == null) {
            Toast.makeText(this$0.requireContext(), this$0.getString(R.string.aborted_period), 0).show();
            return;
        }
        String strCheckPreviewMediaDirectory = this$0.checkPreviewMediaDirectory();
        String str = strCheckPreviewMediaDirectory + "index.json";
        String str2 = strCheckPreviewMediaDirectory + Constants.scraperSnapshotFileName;
        String string = IOUtils.toString(new FileInputStream(str), StandardCharsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex = (PlayableItemPreviewMediaIndex) Json.Default.decodeFromString(PlayableItemPreviewMediaIndex.Companion.serializer(), string);
        BitmapFactory.decodeStream(this$0.requireActivity().getContentResolver().openInputStream(uri)).compress(Constants.INSTANCE.getScraperFormat(), 100, new FileOutputStream(str2));
        playableItemPreviewMediaIndex.setSnapshotPath(Constants.scraperSnapshotFileName);
        PlayableItemEntity playableItemEntity = null;
        StringFormat stringFormatJson$default = JsonKt.Json$default((Json) null, new Function1<JsonBuilder, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlayableItemDialogFragment$setSnapshotActivity$1$jsonFormat$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
                invoke2(jsonBuilder);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JsonBuilder Json) {
                Intrinsics.checkNotNullParameter(Json, "$this$Json");
                Json.setPrettyPrint(true);
                Json.setEncodeDefaults(true);
            }
        }, 1, (Object) null);
        stringFormatJson$default.getSerializersModule();
        String strEncodeToString = stringFormatJson$default.encodeToString(PlayableItemPreviewMediaIndex.Companion.serializer(), playableItemPreviewMediaIndex);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(str));
        outputStreamWriter.write(strEncodeToString);
        outputStreamWriter.close();
        PlayableItemEntity playableItemEntity2 = this$0.playableItemEntity;
        if (playableItemEntity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
            playableItemEntity2 = null;
        }
        playableItemEntity2.setPreviewMediaPath(strCheckPreviewMediaDirectory);
        this$0.getDaijishouLibrary().getCachedSnapshotBitmapLoader().remove(str2);
        DaijishouLibraryModel daijishouLibrary = this$0.getDaijishouLibrary();
        PlayableItemEntity playableItemEntity3 = this$0.playableItemEntity;
        if (playableItemEntity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
        } else {
            playableItemEntity = playableItemEntity3;
        }
        daijishouLibrary.updatePlayableItem(playableItemEntity);
        Toast.makeText(this$0.requireContext(), this$0.getString(R.string.snapshot_saved), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTitleActivity$lambda$2(EditPlayableItemDialogFragment this$0, Uri uri) throws IOException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(uri, Uri.EMPTY) || uri == null) {
            Toast.makeText(this$0.requireContext(), this$0.getString(R.string.aborted_period), 0).show();
            return;
        }
        String strCheckPreviewMediaDirectory = this$0.checkPreviewMediaDirectory();
        String str = strCheckPreviewMediaDirectory + "index.json";
        String str2 = strCheckPreviewMediaDirectory + Constants.scraperTitleFileName;
        String string = IOUtils.toString(new FileInputStream(str), StandardCharsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex = (PlayableItemPreviewMediaIndex) Json.Default.decodeFromString(PlayableItemPreviewMediaIndex.Companion.serializer(), string);
        BitmapFactory.decodeStream(this$0.requireActivity().getContentResolver().openInputStream(uri)).compress(Constants.INSTANCE.getScraperFormat(), 100, new FileOutputStream(str2));
        playableItemPreviewMediaIndex.setTitlePath(Constants.scraperTitleFileName);
        PlayableItemEntity playableItemEntity = null;
        StringFormat stringFormatJson$default = JsonKt.Json$default((Json) null, new Function1<JsonBuilder, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlayableItemDialogFragment$setTitleActivity$1$jsonFormat$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
                invoke2(jsonBuilder);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JsonBuilder Json) {
                Intrinsics.checkNotNullParameter(Json, "$this$Json");
                Json.setPrettyPrint(true);
                Json.setEncodeDefaults(true);
            }
        }, 1, (Object) null);
        stringFormatJson$default.getSerializersModule();
        String strEncodeToString = stringFormatJson$default.encodeToString(PlayableItemPreviewMediaIndex.Companion.serializer(), playableItemPreviewMediaIndex);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(str));
        outputStreamWriter.write(strEncodeToString);
        outputStreamWriter.close();
        PlayableItemEntity playableItemEntity2 = this$0.playableItemEntity;
        if (playableItemEntity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
            playableItemEntity2 = null;
        }
        playableItemEntity2.setPreviewMediaPath(strCheckPreviewMediaDirectory);
        this$0.getDaijishouLibrary().getCachedTitleBitmapLoader().remove(str2);
        DaijishouLibraryModel daijishouLibrary = this$0.getDaijishouLibrary();
        PlayableItemEntity playableItemEntity3 = this$0.playableItemEntity;
        if (playableItemEntity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
        } else {
            playableItemEntity = playableItemEntity3;
        }
        daijishouLibrary.updatePlayableItem(playableItemEntity);
        Toast.makeText(this$0.requireContext(), this$0.getString(R.string.title_saved), 0).show();
    }

    public void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (window != null) {
            window.setBackgroundDrawable(AppCompatResources.getDrawable(requireContext(), R.drawable.dialog_background));
        }
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        final PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex;
        TextInputEditText textInputEditText;
        String string;
        Bundle arguments = getArguments();
        final AlertDialog alertDialogCreate = null;
        final PlayableItemEntity playableItemEntity = arguments != null ? (PlayableItemEntity) arguments.getParcelable("playableItemEntity") : null;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            final Context context = getContext();
            if (context == null) {
                throw new IllegalStateException("Context cannot be null");
            }
            if (playableItemEntity != null) {
                this.playableItemEntity = playableItemEntity;
                final String str = checkPreviewMediaDirectory() + "index.json";
                if (new File(str).exists()) {
                    String string2 = IOUtils.toString(new FileInputStream(str), StandardCharsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                    playableItemPreviewMediaIndex = (PlayableItemPreviewMediaIndex) Json.Default.decodeFromString(PlayableItemPreviewMediaIndex.Companion.serializer(), string2);
                } else {
                    playableItemPreviewMediaIndex = new PlayableItemPreviewMediaIndex((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
                }
                View viewInflate = activity.getLayoutInflater().inflate(R.layout.form_edit_playable_item, (ViewGroup) null);
                DaijishouLibraryModel daijishouLibrary = getDaijishouLibrary();
                Long attachedPlatformId = playableItemEntity.getAttachedPlatformId();
                Intrinsics.checkNotNull(attachedPlatformId);
                PlatformEntity platformByIdStatically = daijishouLibrary.getPlatformByIdStatically(attachedPlatformId.longValue());
                Intrinsics.checkNotNull(platformByIdStatically);
                final List<Long> playerIdList = platformByIdStatically.getPlayerIdList();
                int size = playerIdList.size();
                ArrayList arrayList = new ArrayList(size);
                for (int i = 0; i < size; i++) {
                    PlayerEntity playerByIdStatically = getDaijishouLibrary().getPlayerByIdStatically(playerIdList.get(i).longValue());
                    if (playerByIdStatically != null) {
                        string = playerByIdStatically.getName();
                    } else {
                        string = getString(R.string.unknown_player);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    }
                    arrayList.add(string);
                }
                final ArrayList arrayList2 = arrayList;
                final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                final ArrayList arrayList3 = new ArrayList();
                final ArrayList arrayList4 = new ArrayList();
                final EditText editText = (EditText) viewInflate.findViewById(R.id.playable_item_name_edit_text);
                final CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.playable_item_visibility_check_box);
                final SwitchMaterial switchMaterialFindViewById = viewInflate.findViewById(R.id.playable_item_scrape_name_switch);
                final SwitchMaterial switchMaterialFindViewById2 = viewInflate.findViewById(R.id.playable_item_do_not_prettify);
                switchMaterialFindViewById2.setChecked(playableItemEntity.getDoNotPrettify());
                Button button = (Button) viewInflate.findViewById(R.id.playable_item_select_wallpaper_button);
                final TextInputEditText textInputEditTextFindViewById = viewInflate.findViewById(R.id.playable_item_scraper_keyword_edit_text);
                final SwitchMaterial switchMaterialFindViewById3 = viewInflate.findViewById(R.id.playable_item_scrape_scraper_keywords_switch);
                Chip chipFindViewById = viewInflate.findViewById(R.id.playable_item_scraper_keyword_add_button);
                final ChipGroup chipGroupFindViewById = viewInflate.findViewById(R.id.playable_item_scraper_keywords_chip_group);
                Genres genres = Genres.INSTANCE;
                Context contextRequireContext = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                Pair<List<String>, List<String>> pairGenerateGenreIdsAndNames = genres.generateGenreIdsAndNames(contextRequireContext);
                final List<String> listComponent1 = pairGenerateGenreIdsAndNames.component1();
                final List<String> listComponent2 = pairGenerateGenreIdsAndNames.component2();
                final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(R.id.playable_item_genre_edit_text);
                Intrinsics.checkNotNull(context);
                autoCompleteTextView.setAdapter(new AutoCompleteAdapter(context, R.layout.list_item_dropdown_item, CollectionsKt.sorted(listComponent2)));
                Chip chipFindViewById2 = viewInflate.findViewById(R.id.playable_item_genre_add_button);
                final ChipGroup chipGroupFindViewById2 = viewInflate.findViewById(R.id.playable_item_genres_chip_group);
                chipFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlayableItemDialogFragment$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        EditPlayableItemDialogFragment.onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$8(autoCompleteTextView, listComponent1, listComponent2, this, arrayList4, textInputEditTextFindViewById, context, chipGroupFindViewById2, view);
                    }
                });
                final SwitchMaterial switchMaterialFindViewById4 = viewInflate.findViewById(R.id.playable_item_custom_player_switch);
                final AutoCompleteTextView autoCompleteTextView2 = (AutoCompleteTextView) viewInflate.findViewById(R.id.playable_item_custom_player_select);
                Button button2 = (Button) viewInflate.findViewById(R.id.playable_item_reset_record_button);
                Button button3 = (Button) viewInflate.findViewById(R.id.playable_item_scrape_preview_media_button);
                final TextView textView = (TextView) viewInflate.findViewById(R.id.playable_item_detail_text_view);
                button.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlayableItemDialogFragment$$ExternalSyntheticLambda10
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        EditPlayableItemDialogFragment.onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$10(this.f$0, playableItemEntity, playableItemPreviewMediaIndex, str, view);
                    }
                });
                View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlayableItemDialogFragment$$ExternalSyntheticLambda11
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        EditPlayableItemDialogFragment.onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$11(textInputEditTextFindViewById, arrayList3, this, context, chipGroupFindViewById, view);
                    }
                };
                ChipGroup chipGroup = chipGroupFindViewById;
                chipFindViewById.setOnClickListener(onClickListener);
                button2.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlayableItemDialogFragment$$ExternalSyntheticLambda12
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        EditPlayableItemDialogFragment.onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$12(booleanRef, playableItemEntity, textView, view);
                    }
                });
                final PlayableItemEntity playableItemEntity2 = playableItemEntity;
                View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlayableItemDialogFragment$$ExternalSyntheticLambda13
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        EditPlayableItemDialogFragment.onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$13(this.f$0, playableItemEntity2, editText, checkBox, switchMaterialFindViewById, switchMaterialFindViewById2, switchMaterialFindViewById3, switchMaterialFindViewById4, autoCompleteTextView2, arrayList2, playerIdList, arrayList3, booleanRef, arrayList4, view);
                    }
                };
                SwitchMaterial switchMaterial = switchMaterialFindViewById3;
                final SwitchMaterial switchMaterial2 = switchMaterialFindViewById4;
                final AutoCompleteTextView autoCompleteTextView3 = autoCompleteTextView2;
                ArrayList arrayList5 = arrayList3;
                SwitchMaterial switchMaterial3 = switchMaterialFindViewById;
                button3.setOnClickListener(onClickListener2);
                Context context2 = context;
                autoCompleteTextView3.setAdapter(new AutoCompleteAdapter(context2, R.layout.list_item_dropdown_item, arrayList2));
                switchMaterial2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlayableItemDialogFragment$$ExternalSyntheticLambda14
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        EditPlayableItemDialogFragment.onCreateDialog$lambda$26$lambda$25$lambda$24$setUseCustomPlayer(switchMaterial2, autoCompleteTextView3, z);
                    }
                });
                editText.setText(playableItemEntity2.getName());
                checkBox.setChecked(playableItemEntity2.isVisible());
                switchMaterial3.setChecked(playableItemEntity2.getDoScrapeName());
                if (playableItemEntity2.getScraperKeywordList().isEmpty()) {
                    textInputEditText = textInputEditTextFindViewById;
                } else {
                    textInputEditText = textInputEditTextFindViewById;
                    textInputEditText.setText(playableItemEntity2.getScraperKeywordList().get(0));
                }
                Iterator<T> it = playableItemEntity2.getScraperKeywordList().iterator();
                while (it.hasNext()) {
                    TextInputEditText textInputEditText2 = textInputEditText;
                    AutoCompleteTextView autoCompleteTextView4 = autoCompleteTextView3;
                    Context context3 = context2;
                    ChipGroup chipGroup2 = chipGroup;
                    SwitchMaterial switchMaterial4 = switchMaterial3;
                    SwitchMaterial switchMaterial5 = switchMaterial2;
                    ArrayList arrayList6 = arrayList5;
                    onCreateDialog$lambda$26$lambda$25$lambda$24$addScraperKeyword(textInputEditText2, arrayList6, context3, chipGroup2, this, (String) it.next(), false);
                    textInputEditText = textInputEditText2;
                    context2 = context3;
                    switchMaterial = switchMaterial;
                    autoCompleteTextView3 = autoCompleteTextView4;
                    arrayList5 = arrayList6;
                    switchMaterial2 = switchMaterial5;
                    switchMaterial3 = switchMaterial4;
                    chipGroup = chipGroup2;
                }
                final AutoCompleteTextView autoCompleteTextView5 = autoCompleteTextView3;
                final Context context4 = context2;
                final SwitchMaterial switchMaterial6 = switchMaterial3;
                final ArrayList arrayList7 = arrayList5;
                final SwitchMaterial switchMaterial7 = switchMaterial;
                final SwitchMaterial switchMaterial8 = switchMaterial2;
                TextInputEditText textInputEditText3 = textInputEditText;
                Iterator<T> it2 = getDaijishouLibrary().getGenreIdsByPlayableItemIdStatically(playableItemEntity2.getId()).iterator();
                while (it2.hasNext()) {
                    onCreateDialog$lambda$26$lambda$25$lambda$24$addGenreId(textInputEditText3, arrayList4, context4, this, chipGroupFindViewById2, (String) it2.next(), false);
                }
                switchMaterial7.setChecked(playableItemEntity2.getScrapeScraperKeywords());
                onCreateDialog$lambda$26$lambda$25$lambda$24$setUseCustomPlayer(switchMaterial8, autoCompleteTextView5, playableItemEntity2.getUseCustomPlayer());
                int iIndexOf = CollectionsKt.indexOf((List<? extends Long>) playerIdList, playableItemEntity2.getCustomPlayerId());
                if (iIndexOf != -1) {
                    autoCompleteTextView5.setText((CharSequence) arrayList2.get(iIndexOf), false);
                }
                textView.setText(Html.fromHtml("<b>Id:</b> " + playableItemEntity2.getId() + "<br><b>IsInSingletonDisjointSet:</b> " + playableItemEntity2.isInSingletonDisjointSet() + "<br><b>UseDisjointSetPrimaryPlayableItem:</b> " + playableItemEntity2.getUseDisjointSetPrimaryPlayableItem() + "<br><b>DisjointSetPrimaryPlayableItemId:</b> " + playableItemEntity2.getDisjointSetPrimaryPlayableItemId() + "<br><b>Lazy md5:</b> " + playableItemEntity2.getMd5() + "<br><b>Added date:</b> " + playableItemEntity2.getAddedDateTimestamp() + "<br><b>Sync tree:</b> " + playableItemEntity2.getSyncTreeUri().getPath() + "<br><b>Uri:</b> " + playableItemEntity2.getUri() + "<br><b>Uri path:</b> " + playableItemEntity2.getUri().getPath() + "<br><b>Preview media path:</b> " + playableItemEntity2.getPreviewMediaPath() + "<br><b>Played count:</b> " + playableItemEntity2.getPlayCount() + "<br><b>Last played:</b> " + playableItemEntity2.getLastPlayedTimestamp()));
                AlertDialog.Builder negativeButton = new AlertDialog.Builder(context4).setView(viewInflate).setTitle(getString(R.string.edit_the_playable_item)).setPositiveButton(getString(R.string.save), new DialogInterface.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlayableItemDialogFragment$$ExternalSyntheticLambda15
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        EditPlayableItemDialogFragment.onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$17(dialogInterface, i2);
                    }
                }).setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlayableItemDialogFragment$$ExternalSyntheticLambda16
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        dialogInterface.cancel();
                    }
                });
                if (Intrinsics.areEqual(playableItemEntity2.getSyncTreeUri(), Uri.EMPTY) || Intrinsics.areEqual(playableItemEntity2.getUri(), Uri.EMPTY)) {
                    negativeButton.setNeutralButton(getString(R.string.delete), new DialogInterface.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlayableItemDialogFragment$$ExternalSyntheticLambda17
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            EditPlayableItemDialogFragment.onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$19(dialogInterface, i2);
                        }
                    });
                } else {
                    negativeButton.setNeutralButton(getString(R.string.unlink_file), new DialogInterface.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlayableItemDialogFragment$$ExternalSyntheticLambda1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            EditPlayableItemDialogFragment.onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$20(dialogInterface, i2);
                        }
                    });
                }
                alertDialogCreate = negativeButton.create();
                Intrinsics.checkNotNull(alertDialogCreate);
                setupDaijishouDialog(alertDialogCreate);
                editText.requestFocus();
                alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlayableItemDialogFragment$$ExternalSyntheticLambda9
                    @Override // android.content.DialogInterface.OnShowListener
                    public final void onShow(DialogInterface dialogInterface) {
                        EditPlayableItemDialogFragment.onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$23(alertDialogCreate, context4, this, editText, checkBox, switchMaterial6, switchMaterialFindViewById2, switchMaterial7, switchMaterial8, autoCompleteTextView5, arrayList2, playerIdList, playableItemEntity2, arrayList7, booleanRef, arrayList4, dialogInterface);
                    }
                });
            }
            if (alertDialogCreate != null) {
                return alertDialogCreate;
            }
            throw new IllegalStateException("playableItemEntity cannot be null");
        }
        throw new IllegalStateException("Activity cannot be null");
    }

    static /* synthetic */ void onCreateDialog$lambda$26$lambda$25$lambda$24$addScraperKeyword$default(TextInputEditText textInputEditText, List list, Context context, ChipGroup chipGroup, EditPlayableItemDialogFragment editPlayableItemDialogFragment, String str, boolean z, int i, Object obj) {
        if ((i & 64) != 0) {
            z = true;
        }
        onCreateDialog$lambda$26$lambda$25$lambda$24$addScraperKeyword(textInputEditText, list, context, chipGroup, editPlayableItemDialogFragment, str, z);
    }

    private static final void onCreateDialog$lambda$26$lambda$25$lambda$24$addScraperKeyword(TextInputEditText textInputEditText, final List<String> list, Context context, final ChipGroup chipGroup, EditPlayableItemDialogFragment editPlayableItemDialogFragment, final String str, boolean z) {
        textInputEditText.setError((CharSequence) null);
        list.add(str);
        View chip = new Chip(context);
        chip.setId(View.generateViewId());
        chip.setText(str);
        chip.setCloseIconVisible(true);
        chip.setOnCloseIconClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlayableItemDialogFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditPlayableItemDialogFragment.onCreateDialog$lambda$26$lambda$25$lambda$24$addScraperKeyword$lambda$5(list, str, chipGroup, view);
            }
        });
        Intrinsics.checkNotNull(chipGroup);
        ViewGroupKt.get((ViewGroup) chipGroup, chipGroup.getChildCount() - 1).setNextFocusRightId(-1);
        chip.setNextFocusRightId(chip.getId());
        chipGroup.addView(chip);
        if (z) {
            Toast.makeText(editPlayableItemDialogFragment.requireContext(), editPlayableItemDialogFragment.getString(R.string.added_successfully), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$26$lambda$25$lambda$24$addScraperKeyword$lambda$5(List scraperKeywordList, String scraperKeywordText, ChipGroup chipGroup, View view) {
        Intrinsics.checkNotNullParameter(scraperKeywordList, "$scraperKeywordList");
        Intrinsics.checkNotNullParameter(scraperKeywordText, "$scraperKeywordText");
        scraperKeywordList.remove(scraperKeywordText);
        chipGroup.removeView(view);
    }

    static /* synthetic */ void onCreateDialog$lambda$26$lambda$25$lambda$24$addGenreId$default(TextInputEditText textInputEditText, List list, Context context, EditPlayableItemDialogFragment editPlayableItemDialogFragment, ChipGroup chipGroup, String str, boolean z, int i, Object obj) {
        if ((i & 64) != 0) {
            z = true;
        }
        onCreateDialog$lambda$26$lambda$25$lambda$24$addGenreId(textInputEditText, list, context, editPlayableItemDialogFragment, chipGroup, str, z);
    }

    private static final void onCreateDialog$lambda$26$lambda$25$lambda$24$addGenreId(TextInputEditText textInputEditText, final List<String> list, Context context, EditPlayableItemDialogFragment editPlayableItemDialogFragment, final ChipGroup chipGroup, final String str, boolean z) {
        textInputEditText.setError((CharSequence) null);
        list.add(str);
        View chip = new Chip(context);
        chip.setId(View.generateViewId());
        Genre genre = Genres.INSTANCE.getGenres().get(str);
        Intrinsics.checkNotNull(genre);
        chip.setText(editPlayableItemDialogFragment.getString(genre.getNameStringId()));
        chip.setCloseIconVisible(true);
        chip.setOnCloseIconClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlayableItemDialogFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditPlayableItemDialogFragment.onCreateDialog$lambda$26$lambda$25$lambda$24$addGenreId$lambda$6(list, str, chipGroup, view);
            }
        });
        Intrinsics.checkNotNull(chipGroup);
        ViewGroupKt.get((ViewGroup) chipGroup, chipGroup.getChildCount() - 1).setNextFocusRightId(-1);
        chip.setNextFocusRightId(chip.getId());
        chipGroup.addView(chip);
        if (z) {
            Toast.makeText(editPlayableItemDialogFragment.requireContext(), editPlayableItemDialogFragment.getString(R.string.added_successfully), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$26$lambda$25$lambda$24$addGenreId$lambda$6(List genreIdList, String genreId, ChipGroup chipGroup, View view) {
        Intrinsics.checkNotNullParameter(genreIdList, "$genreIdList");
        Intrinsics.checkNotNullParameter(genreId, "$genreId");
        genreIdList.remove(genreId);
        chipGroup.removeView(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$8(AutoCompleteTextView autoCompleteTextView, List availableGenreIdList, List genreNamesList, EditPlayableItemDialogFragment this$0, List genreIdList, TextInputEditText textInputEditText, Context context, ChipGroup chipGroup, View view) {
        Intrinsics.checkNotNullParameter(availableGenreIdList, "$availableGenreIdList");
        Intrinsics.checkNotNullParameter(genreNamesList, "$genreNamesList");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(genreIdList, "$genreIdList");
        Intrinsics.checkNotNullParameter(context, "$context");
        String str = (String) CollectionsKt.getOrNull(availableGenreIdList, genreNamesList.indexOf(autoCompleteTextView.getText().toString()));
        if (CollectionsKt.indexOf((List<? extends String>) availableGenreIdList, str) == -1) {
            autoCompleteTextView.setError(this$0.getString(R.string.please_select_from_the_list));
            autoCompleteTextView.requestFocus();
        } else if (CollectionsKt.indexOf((List<? extends String>) genreIdList, str) != -1) {
            autoCompleteTextView.setError(this$0.getString(R.string.item_has_been_selected));
            autoCompleteTextView.requestFocus();
        } else if (str != null) {
            autoCompleteTextView.setText((CharSequence) null);
            onCreateDialog$lambda$26$lambda$25$lambda$24$addGenreId$default(textInputEditText, genreIdList, context, this$0, chipGroup, str, false, 64, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$26$lambda$25$lambda$24$setUseCustomPlayer(SwitchMaterial switchMaterial, AutoCompleteTextView autoCompleteTextView, boolean z) {
        switchMaterial.setChecked(z);
        autoCompleteTextView.setEnabled(z);
    }

    private static final boolean onCreateDialog$lambda$26$lambda$25$lambda$24$saveChanges(EditText editText, CheckBox checkBox, SwitchMaterial switchMaterial, SwitchMaterial switchMaterial2, SwitchMaterial switchMaterial3, SwitchMaterial switchMaterial4, AutoCompleteTextView autoCompleteTextView, EditPlayableItemDialogFragment editPlayableItemDialogFragment, List<String> list, List<Long> list2, PlayableItemEntity playableItemEntity, List<String> list3, Ref.BooleanRef booleanRef, List<String> list4) {
        Long l;
        String string = editText.getText().toString();
        boolean zIsChecked = checkBox.isChecked();
        boolean zIsChecked2 = switchMaterial.isChecked();
        boolean zIsChecked3 = switchMaterial2.isChecked();
        boolean zIsChecked4 = switchMaterial3.isChecked();
        boolean zIsChecked5 = switchMaterial4.isChecked();
        Editable text = autoCompleteTextView.getText();
        if (string.length() == 0) {
            editText.setError(editPlayableItemDialogFragment.getString(R.string.please_enter_a_playable_item_name));
            return false;
        }
        int iIndexOf = list.indexOf(text.toString());
        if (!zIsChecked5) {
            l = null;
        } else {
            if (zIsChecked5 && iIndexOf == -1) {
                autoCompleteTextView.setError(editPlayableItemDialogFragment.getString(R.string.please_select_a_player));
                autoCompleteTextView.requestFocus();
                return false;
            }
            l = list2.get(iIndexOf);
        }
        playableItemEntity.setName(string);
        playableItemEntity.setVisible(zIsChecked);
        playableItemEntity.setDoScrapeName(zIsChecked2);
        playableItemEntity.setScraperKeywordList(list3);
        playableItemEntity.setScrapeScraperKeywords(zIsChecked4);
        playableItemEntity.setUseCustomPlayer(zIsChecked5);
        playableItemEntity.setCustomPlayerId(l);
        playableItemEntity.setDoNotPrettify(zIsChecked3);
        editPlayableItemDialogFragment.getDaijishouLibrary().updatePlayableItem(playableItemEntity);
        if (booleanRef.element) {
            editPlayableItemDialogFragment.getDaijishouLibrary().deleteAllEventsByPlayableItemId(playableItemEntity.getId());
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list4.iterator();
        while (it.hasNext()) {
            arrayList.add(new PlayableItemToGenrePairEntity(0L, playableItemEntity.getId(), (String) it.next(), null, 9, null));
        }
        editPlayableItemDialogFragment.getDaijishouLibrary().deletePlayableItemToGenrePairsByPlayableItemId(playableItemEntity.getId());
        DaijishouLibraryModel daijishouLibrary = editPlayableItemDialogFragment.getDaijishouLibrary();
        PlayableItemToGenrePairEntity[] playableItemToGenrePairEntityArr = (PlayableItemToGenrePairEntity[]) arrayList.toArray(new PlayableItemToGenrePairEntity[0]);
        daijishouLibrary.addPlayableItemToGenrePairs((PlayableItemToGenrePairEntity[]) Arrays.copyOf(playableItemToGenrePairEntityArr, playableItemToGenrePairEntityArr.length));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$10(final EditPlayableItemDialogFragment this$0, final PlayableItemEntity playableItemEntity, final PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex, final String indexPath, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(playableItemEntity, "$playableItemEntity");
        Intrinsics.checkNotNullParameter(playableItemPreviewMediaIndex, "$playableItemPreviewMediaIndex");
        Intrinsics.checkNotNullParameter(indexPath, "$indexPath");
        ListSelectDialogFragment.Companion companion = ListSelectDialogFragment.Companion;
        String string = this$0.getString(R.string.preview_media_options_title);
        String string2 = this$0.getString(R.string.box_art);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = this$0.getString(R.string.snapshot);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = this$0.getString(R.string.title);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        final ListSelectDialogFragment listSelectDialogFragmentNewInstance$default = ListSelectDialogFragment.Companion.newInstance$default(companion, string, CollectionsKt.arrayListOf(string2, string3, string4), null, false, 12, null);
        listSelectDialogFragmentNewInstance$default.setOnSelectListener(new Function1<Integer, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlayableItemDialogFragment$onCreateDialog$1$1$1$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                listSelectDialogFragmentNewInstance$default.dismiss();
                if (i == 0) {
                    this$0.setBoxArtActivity.launch("image/*");
                } else if (i == 1) {
                    this$0.setSnapshotActivity.launch("image/*");
                } else {
                    if (i != 2) {
                        return;
                    }
                    this$0.setTitleActivity.launch("image/*");
                }
            }
        }).setOnLongSelectListener(new Function1<Integer, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlayableItemDialogFragment$onCreateDialog$1$1$1$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) throws IOException {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) throws IOException {
                listSelectDialogFragmentNewInstance$default.dismiss();
                if (i == 0) {
                    File file = new File(playableItemEntity.getPreviewMediaPath() + playableItemPreviewMediaIndex.getBoxArtPath());
                    if (file.exists()) {
                        file.delete();
                    }
                    if (file.exists()) {
                        file.delete();
                    }
                    this$0.getDaijishouLibrary().getCachedBoxArtBitmapLoader().remove(playableItemEntity.getPreviewMediaPath() + playableItemPreviewMediaIndex.getBoxArtPath());
                    playableItemPreviewMediaIndex.setBoxArtPath(null);
                    Toast.makeText(this$0.requireContext(), this$0.getString(R.string.box_art_removed), 0).show();
                } else if (i == 1) {
                    File file2 = new File(playableItemEntity.getPreviewMediaPath() + playableItemPreviewMediaIndex.getSnapshotPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    this$0.getDaijishouLibrary().getCachedSnapshotBitmapLoader().remove(playableItemEntity.getPreviewMediaPath() + playableItemPreviewMediaIndex.getSnapshotPath());
                    playableItemPreviewMediaIndex.setSnapshotPath(null);
                    Toast.makeText(this$0.requireContext(), this$0.getString(R.string.snapshot_removed), 0).show();
                } else if (i == 2) {
                    File file3 = new File(playableItemEntity.getPreviewMediaPath() + playableItemPreviewMediaIndex.getTitlePath());
                    if (file3.exists()) {
                        file3.delete();
                    }
                    this$0.getDaijishouLibrary().getCachedTitleBitmapLoader().remove(playableItemEntity.getPreviewMediaPath() + playableItemPreviewMediaIndex.getTitlePath());
                    playableItemPreviewMediaIndex.setTitlePath(null);
                    Toast.makeText(this$0.requireContext(), this$0.getString(R.string.title_removed), 0).show();
                }
                if (ScraperUtilsKt.hasAnyMedia(playableItemPreviewMediaIndex)) {
                    StringFormat stringFormatJson$default = JsonKt.Json$default((Json) null, new Function1<JsonBuilder, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlayableItemDialogFragment$onCreateDialog$1$1$1$2$2$jsonFormat$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
                            invoke2(jsonBuilder);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(JsonBuilder Json) {
                            Intrinsics.checkNotNullParameter(Json, "$this$Json");
                            Json.setPrettyPrint(true);
                            Json.setEncodeDefaults(true);
                        }
                    }, 1, (Object) null);
                    PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex2 = playableItemPreviewMediaIndex;
                    stringFormatJson$default.getSerializersModule();
                    String strEncodeToString = stringFormatJson$default.encodeToString(PlayableItemPreviewMediaIndex.Companion.serializer(), playableItemPreviewMediaIndex2);
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(indexPath));
                    outputStreamWriter.write(strEncodeToString);
                    outputStreamWriter.close();
                    DaijishouLibraryModel daijishouLibrary = this$0.getDaijishouLibrary();
                    PlayableItemEntity playableItemByIdStatically = this$0.getDaijishouLibrary().getPlayableItemByIdStatically(playableItemEntity.getId());
                    Intrinsics.checkNotNull(playableItemByIdStatically);
                    daijishouLibrary.updatePlayableItem(playableItemByIdStatically);
                    return;
                }
                File file4 = new File(indexPath);
                if (file4.exists()) {
                    FilesKt.deleteRecursively(file4);
                }
                PlayableItemEntity playableItemByIdStatically2 = this$0.getDaijishouLibrary().getPlayableItemByIdStatically(playableItemEntity.getId());
                Intrinsics.checkNotNull(playableItemByIdStatically2);
                playableItemByIdStatically2.setPreviewMediaPath(null);
                playableItemEntity.setPreviewMediaPath(null);
                this$0.getDaijishouLibrary().updatePlayableItem(playableItemByIdStatically2);
            }
        }).show(this$0.getParentFragmentManager(), ListSelectDialogFragment.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$11(TextInputEditText textInputEditText, List scraperKeywordList, EditPlayableItemDialogFragment this$0, Context context, ChipGroup chipGroup, View view) {
        Intrinsics.checkNotNullParameter(scraperKeywordList, "$scraperKeywordList");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        String strValueOf = String.valueOf(textInputEditText.getText());
        if (scraperKeywordList.indexOf(strValueOf) != -1) {
            textInputEditText.setError(this$0.getString(R.string.item_has_been_added));
            textInputEditText.requestFocus();
        } else {
            onCreateDialog$lambda$26$lambda$25$lambda$24$addScraperKeyword$default(textInputEditText, scraperKeywordList, context, chipGroup, this$0, strValueOf, false, 64, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$12(Ref.BooleanRef resetRecord, PlayableItemEntity playableItemEntity, TextView textView, View view) {
        Intrinsics.checkNotNullParameter(resetRecord, "$resetRecord");
        Intrinsics.checkNotNullParameter(playableItemEntity, "$playableItemEntity");
        resetRecord.element = true;
        playableItemEntity.setLastPlayedTimestamp(null);
        playableItemEntity.setPlayCount(0);
        textView.setText(Html.fromHtml("<b>Id:</b> " + playableItemEntity.getId() + "<br><b>IsInSingletonDisjointSet:</b> " + playableItemEntity.isInSingletonDisjointSet() + "<br><b>UseDisjointSetPrimaryPlayableItem:</b> " + playableItemEntity.getUseDisjointSetPrimaryPlayableItem() + "<br><b>DisjointSetPrimaryPlayableItemId:</b> " + playableItemEntity.getDisjointSetPrimaryPlayableItemId() + "<br><b>Lazy md5:</b> " + playableItemEntity.getMd5() + "<br><b>Added date:</b> " + playableItemEntity.getAddedDateTimestamp() + "<br><b>Sync tree:</b> " + playableItemEntity.getSyncTreeUri().getPath() + "<br><b>Uri:</b> " + playableItemEntity.getUri() + "<br><b>Uri path:</b> " + playableItemEntity.getUri().getPath() + "<br><b>Preview media path:</b> " + playableItemEntity.getPreviewMediaPath() + "<br><b>Played count:</b> " + playableItemEntity.getPlayCount() + "<br><b>Last played:</b> " + playableItemEntity.getLastPlayedTimestamp()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$13(EditPlayableItemDialogFragment this$0, PlayableItemEntity playableItemEntity, EditText editText, CheckBox checkBox, SwitchMaterial switchMaterial, SwitchMaterial switchMaterial2, SwitchMaterial switchMaterial3, SwitchMaterial switchMaterial4, AutoCompleteTextView autoCompleteTextView, List playerNameList, List playerIdList, List scraperKeywordList, Ref.BooleanRef resetRecord, List genreIdList, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(playableItemEntity, "$playableItemEntity");
        Intrinsics.checkNotNullParameter(playerNameList, "$playerNameList");
        Intrinsics.checkNotNullParameter(playerIdList, "$playerIdList");
        Intrinsics.checkNotNullParameter(scraperKeywordList, "$scraperKeywordList");
        Intrinsics.checkNotNullParameter(resetRecord, "$resetRecord");
        Intrinsics.checkNotNullParameter(genreIdList, "$genreIdList");
        if (onCreateDialog$lambda$26$lambda$25$lambda$24$saveChanges(editText, checkBox, switchMaterial, switchMaterial2, switchMaterial3, switchMaterial4, autoCompleteTextView, this$0, playerNameList, playerIdList, playableItemEntity, scraperKeywordList, resetRecord, genreIdList)) {
            Dialog dialog = this$0.getDialog();
            if (dialog != null) {
                dialog.dismiss();
            }
            DaijishouSynchronizationModel daijishouSynchronization = this$0.getDaijishouSynchronization();
            FragmentActivity fragmentActivityRequireActivity = this$0.requireActivity();
            Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            daijishouSynchronization.scheduleScrapingOfPlayableItem((AppCompatActivity) fragmentActivityRequireActivity, playableItemEntity);
            Toast.makeText(this$0.requireContext(), this$0.getString(R.string.scraping), 0).show();
            return;
        }
        Toast.makeText(this$0.requireContext(), this$0.getString(R.string.aborted_period), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$23(final AlertDialog alertDialog, final Context context, final EditPlayableItemDialogFragment this$0, final EditText editText, final CheckBox checkBox, final SwitchMaterial switchMaterial, final SwitchMaterial switchMaterial2, final SwitchMaterial switchMaterial3, final SwitchMaterial switchMaterial4, final AutoCompleteTextView autoCompleteTextView, final List playerNameList, final List playerIdList, final PlayableItemEntity playableItemEntity, final List scraperKeywordList, final Ref.BooleanRef resetRecord, final List genreIdList, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(playerNameList, "$playerNameList");
        Intrinsics.checkNotNullParameter(playerIdList, "$playerIdList");
        Intrinsics.checkNotNullParameter(playableItemEntity, "$playableItemEntity");
        Intrinsics.checkNotNullParameter(scraperKeywordList, "$scraperKeywordList");
        Intrinsics.checkNotNullParameter(resetRecord, "$resetRecord");
        Intrinsics.checkNotNullParameter(genreIdList, "$genreIdList");
        Intrinsics.checkNotNull(alertDialog, "null cannot be cast to non-null type android.app.AlertDialog");
        Button button = alertDialog.getButton(-1);
        Intrinsics.checkNotNullExpressionValue(button, "getButton(...)");
        button.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlayableItemDialogFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditPlayableItemDialogFragment.onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$23$lambda$21(alertDialog, context, this$0, editText, checkBox, switchMaterial, switchMaterial2, switchMaterial3, switchMaterial4, autoCompleteTextView, playerNameList, playerIdList, playableItemEntity, scraperKeywordList, resetRecord, genreIdList, view);
            }
        });
        final Button button2 = alertDialog.getButton(-3);
        Intrinsics.checkNotNullExpressionValue(button2, "getButton(...)");
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlayableItemDialogFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditPlayableItemDialogFragment.onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$23$lambda$22(playableItemEntity, this$0, alertDialog, context, button2, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$23$lambda$21(AlertDialog alertDialog, Context context, EditPlayableItemDialogFragment this$0, EditText editText, CheckBox checkBox, SwitchMaterial switchMaterial, SwitchMaterial switchMaterial2, SwitchMaterial switchMaterial3, SwitchMaterial switchMaterial4, AutoCompleteTextView autoCompleteTextView, List playerNameList, List playerIdList, PlayableItemEntity playableItemEntity, List scraperKeywordList, Ref.BooleanRef resetRecord, List genreIdList, View view) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(playerNameList, "$playerNameList");
        Intrinsics.checkNotNullParameter(playerIdList, "$playerIdList");
        Intrinsics.checkNotNullParameter(playableItemEntity, "$playableItemEntity");
        Intrinsics.checkNotNullParameter(scraperKeywordList, "$scraperKeywordList");
        Intrinsics.checkNotNullParameter(resetRecord, "$resetRecord");
        Intrinsics.checkNotNullParameter(genreIdList, "$genreIdList");
        if (onCreateDialog$lambda$26$lambda$25$lambda$24$saveChanges(editText, checkBox, switchMaterial, switchMaterial2, switchMaterial3, switchMaterial4, autoCompleteTextView, this$0, playerNameList, playerIdList, playableItemEntity, scraperKeywordList, resetRecord, genreIdList)) {
            alertDialog.dismiss();
            Toast.makeText(context, this$0.getString(R.string.edited_successfully), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$23$lambda$22(final PlayableItemEntity playableItemEntity, final EditPlayableItemDialogFragment this$0, final AlertDialog alertDialog, final Context context, final Button neutralButton, View view) {
        Intrinsics.checkNotNullParameter(playableItemEntity, "$playableItemEntity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(neutralButton, "$neutralButton");
        if (Intrinsics.areEqual(playableItemEntity.getSyncTreeUri(), Uri.EMPTY) || Intrinsics.areEqual(playableItemEntity.getUri(), Uri.EMPTY)) {
            AcknowledgementDialogFragment.Companion.newInstance$default(AcknowledgementDialogFragment.Companion, this$0.getString(R.string.are_you_sure), this$0.getString(R.string.delete_playable_item_warning), null, null, null, 28, null).setOnAcknowledgedListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlayableItemDialogFragment$onCreateDialog$1$1$1$11$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    this.this$0.getDaijishouLibrary().removePlayableItem(playableItemEntity);
                    alertDialog.dismiss();
                    Toast.makeText(context, this.this$0.getString(R.string.deleted_successfully), 0).show();
                }
            }).show(this$0.getParentFragmentManager(), AcknowledgementDialogFragment.class.getName());
        } else {
            AcknowledgementDialogFragment.Companion.newInstance$default(AcknowledgementDialogFragment.Companion, this$0.getString(R.string.are_you_sure), this$0.getString(R.string.detach_playable_item_uri_warning), null, null, null, 28, null).setOnAcknowledgedListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlayableItemDialogFragment$onCreateDialog$1$1$1$11$2$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    PlayableItemEntity playableItemEntity2 = playableItemEntity;
                    Uri EMPTY = Uri.EMPTY;
                    Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
                    playableItemEntity2.setSyncTreeUri(EMPTY);
                    PlayableItemEntity playableItemEntity3 = playableItemEntity;
                    Uri EMPTY2 = Uri.EMPTY;
                    Intrinsics.checkNotNullExpressionValue(EMPTY2, "EMPTY");
                    playableItemEntity3.setUri(EMPTY2);
                    this$0.getDaijishouLibrary().updatePlayableItem(playableItemEntity);
                    neutralButton.setText(this$0.getString(R.string.delete));
                }
            }).show(this$0.getParentFragmentManager(), AcknowledgementDialogFragment.class.getName());
        }
    }
}
