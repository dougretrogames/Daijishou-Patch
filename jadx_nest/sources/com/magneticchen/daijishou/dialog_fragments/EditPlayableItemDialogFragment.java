package com.magneticchen.daijishou.dialog_fragments;

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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
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
import com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment;
import com.magneticchen.daijishou.application_data.Constants;
import com.magneticchen.daijishou.daijishou_library_db.Genre;
import com.magneticchen.daijishou.daijishou_library_db.Genres;
import com.magneticchen.daijishou.daijishou_library_db.PlatformEntity;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemPreviewMediaIndex;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairEntity;
import com.magneticchen.daijishou.daijishou_library_db.PlayerEntity;
import com.magneticchen.daijishou.utils.AutoCompleteAdapter;
import com.magneticchen.daijishou.view_models.DaijishouLibraryModel;
import com.magneticchen.daijishou.view_models.DaijishouSynchronizationModel;
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
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.io.IOUtils;

/* INFO: compiled from: EditPlayableItemDialogFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/magneticchen/daijishou/dialog_fragments/EditPlayableItemDialogFragment;", "Lcom/magneticchen/daijishou/abstract_fragment_classes/DaijishouDialogFragment;", "()V", "playableItemEntity", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "setBoxArtActivity", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "setSnapshotActivity", "setTitleActivity", "checkPreviewMediaDirectory", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class EditPlayableItemDialogFragment extends DaijishouDialogFragment {

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private PlayableItemEntity playableItemEntity;
    public ActivityResultLauncher<String> setBoxArtActivity;
    public ActivityResultLauncher<String> setSnapshotActivity;
    public ActivityResultLauncher<String> setTitleActivity;

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$25$lambda$24$lambda$23$lambda$16(DialogInterface dialogInterface, int i) {
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$25$lambda$24$lambda$23$lambda$18(DialogInterface dialogInterface, int i) {
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$25$lambda$24$lambda$23$lambda$19(DialogInterface dialogInterface, int i) {
    }

    public EditPlayableItemDialogFragment() {
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.GetContent(), new EditPlayableItemDialogFragment$$ExternalSyntheticLambda2(this));
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.setBoxArtActivity = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.GetContent(), new EditPlayableItemDialogFragment$$ExternalSyntheticLambda3(this));
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(...)");
        this.setSnapshotActivity = activityResultLauncherRegisterForActivityResult2;
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult3 = registerForActivityResult(new ActivityResultContracts.GetContent(), new EditPlayableItemDialogFragment$$ExternalSyntheticLambda4(this));
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult3, "registerForActivityResult(...)");
        this.setTitleActivity = activityResultLauncherRegisterForActivityResult3;
    }

    /* INFO: compiled from: EditPlayableItemDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/dialog_fragments/EditPlayableItemDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/dialog_fragments/EditPlayableItemDialogFragment;", "playableItemEntity", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    private final String checkPreviewMediaDirectory() {
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
            previewMediaPath = string + playableItemEntity2.getId() + InternalZipConstants.ZIP_FILE_SEPARATOR;
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
        Json jsonJson$default = JsonKt.Json$default(null, EditPlayableItemDialogFragment$checkPreviewMediaDirectory$jsonFormat$1.INSTANCE, 1, null);
        PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex = new PlayableItemPreviewMediaIndex((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
        jsonJson$default.getSerializersModule();
        String strEncodeToString = jsonJson$default.encodeToString(PlayableItemPreviewMediaIndex.INSTANCE.serializer(), playableItemPreviewMediaIndex);
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(str));
            outputStreamWriter.write(strEncodeToString);
            outputStreamWriter.close();
        } catch (java.io.IOException e) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(e);
        }
        return previewMediaPath;
    }

    /* INFO: Access modifiers changed from: private */
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
        PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex = (PlayableItemPreviewMediaIndex) Json.Default.decodeFromString(com.magneticchen.daijishou.daijishou_library_db.PlayableItemPreviewMediaIndex$$serializer.INSTANCE, string);
        BitmapFactory.decodeStream(this$0.requireActivity().getContentResolver().openInputStream(uri)).compress(Constants.INSTANCE.getScraperFormat(), 100, new FileOutputStream(str2));
        playableItemPreviewMediaIndex.setBoxArtPath(Constants.scraperBoxArtFileName);
        PlayableItemEntity playableItemEntity = null;
        Json jsonJson$default = JsonKt.Json$default(null, EditPlayableItemDialogFragment$setBoxArtActivity$1$jsonFormat$1.INSTANCE, 1, null);
        jsonJson$default.getSerializersModule();
        String strEncodeToString = jsonJson$default.encodeToString(PlayableItemPreviewMediaIndex.INSTANCE.serializer(), playableItemPreviewMediaIndex);
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

    /* INFO: Access modifiers changed from: private */
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
        PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex = (PlayableItemPreviewMediaIndex) Json.Default.decodeFromString(com.magneticchen.daijishou.daijishou_library_db.PlayableItemPreviewMediaIndex$$serializer.INSTANCE, string);
        BitmapFactory.decodeStream(this$0.requireActivity().getContentResolver().openInputStream(uri)).compress(Constants.INSTANCE.getScraperFormat(), 100, new FileOutputStream(str2));
        playableItemPreviewMediaIndex.setSnapshotPath(Constants.scraperSnapshotFileName);
        PlayableItemEntity playableItemEntity = null;
        Json jsonJson$default = JsonKt.Json$default(null, EditPlayableItemDialogFragment$setSnapshotActivity$1$jsonFormat$1.INSTANCE, 1, null);
        jsonJson$default.getSerializersModule();
        String strEncodeToString = jsonJson$default.encodeToString(PlayableItemPreviewMediaIndex.INSTANCE.serializer(), playableItemPreviewMediaIndex);
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

    /* INFO: Access modifiers changed from: private */
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
        PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex = (PlayableItemPreviewMediaIndex) Json.Default.decodeFromString(com.magneticchen.daijishou.daijishou_library_db.PlayableItemPreviewMediaIndex$$serializer.INSTANCE, string);
        BitmapFactory.decodeStream(this$0.requireActivity().getContentResolver().openInputStream(uri)).compress(Constants.INSTANCE.getScraperFormat(), 100, new FileOutputStream(str2));
        playableItemPreviewMediaIndex.setTitlePath(Constants.scraperTitleFileName);
        PlayableItemEntity playableItemEntity = null;
        Json jsonJson$default = JsonKt.Json$default(null, EditPlayableItemDialogFragment$setTitleActivity$1$jsonFormat$1.INSTANCE, 1, null);
        jsonJson$default.getSerializersModule();
        String strEncodeToString = jsonJson$default.encodeToString(PlayableItemPreviewMediaIndex.INSTANCE.serializer(), playableItemPreviewMediaIndex);
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

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (window != null) {
            window.setBackgroundDrawable(AppCompatResources.getDrawable(requireContext(), R.drawable.dialog_background));
        }
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex;
        TextInputEditText textInputEditText;
        String string;
        Bundle arguments = getArguments();
        AlertDialog alertDialogCreate = null;
        PlayableItemEntity playableItemEntity = arguments != null ? (PlayableItemEntity) arguments.getParcelable("playableItemEntity") : null;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Context context = getContext();
            if (context == null) {
                throw new IllegalStateException("Context cannot be null");
            }
            if (playableItemEntity != null) {
                this.playableItemEntity = playableItemEntity;
                String str = checkPreviewMediaDirectory() + "index.json";
                if (new File(str).exists()) {
                    String string2;
                    try {
                        string2 = IOUtils.toString(new FileInputStream(str), StandardCharsets.UTF_8);
                    } catch (java.io.IOException e) {
                        throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(e);
                    }
                    Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                    playableItemPreviewMediaIndex = (PlayableItemPreviewMediaIndex) Json.Default.decodeFromString(com.magneticchen.daijishou.daijishou_library_db.PlayableItemPreviewMediaIndex$$serializer.INSTANCE, string2);
                } else {
                    playableItemPreviewMediaIndex = new PlayableItemPreviewMediaIndex((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
                }
                View viewInflate = activity.getLayoutInflater().inflate(R.layout.form_edit_playable_item, (ViewGroup) null);
                DaijishouLibraryModel daijishouLibrary = getDaijishouLibrary();
                Long attachedPlatformId = playableItemEntity.getAttachedPlatformId();
                Intrinsics.checkNotNull(attachedPlatformId);
                PlatformEntity platformByIdStatically = daijishouLibrary.getPlatformByIdStatically(attachedPlatformId.longValue());
                Intrinsics.checkNotNull(platformByIdStatically);
                List<Long> playerIdList = platformByIdStatically.getPlayerIdList();
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
                ArrayList arrayList2 = arrayList;
                Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                EditText editText = (EditText) viewInflate.findViewById(R.id.playable_item_name_edit_text);
                CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.playable_item_visibility_check_box);
                SwitchMaterial switchMaterial = (SwitchMaterial) viewInflate.findViewById(R.id.playable_item_scrape_name_switch);
                Button button = (Button) viewInflate.findViewById(R.id.playable_item_select_wallpaper_button);
                TextInputEditText textInputEditText2 = (TextInputEditText) viewInflate.findViewById(R.id.playable_item_scraper_keyword_edit_text);
                SwitchMaterial switchMaterial2 = (SwitchMaterial) viewInflate.findViewById(R.id.playable_item_scrape_scraper_keywords_switch);
                Chip chip = (Chip) viewInflate.findViewById(R.id.playable_item_scraper_keyword_add_button);
                ChipGroup chipGroup = (ChipGroup) viewInflate.findViewById(R.id.playable_item_scraper_keywords_chip_group);
                Genres genres = Genres.INSTANCE;
                Context contextRequireContext = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                Pair<List<String>, List<String>> pairGenerateGenreIdsAndNames = genres.generateGenreIdsAndNames(contextRequireContext);
                List<String> listComponent1 = pairGenerateGenreIdsAndNames.component1();
                List<String> listComponent2 = pairGenerateGenreIdsAndNames.component2();
                AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(R.id.playable_item_genre_edit_text);
                Intrinsics.checkNotNull(context);
                autoCompleteTextView.setAdapter(new AutoCompleteAdapter(context, R.layout.list_item_dropdown_item, CollectionsKt.sorted(listComponent2)));
                Chip chip2 = (Chip) viewInflate.findViewById(R.id.playable_item_genre_add_button);
                ChipGroup chipGroup2 = (ChipGroup) viewInflate.findViewById(R.id.playable_item_genres_chip_group);
                chip2.setOnClickListener(new EditPlayableItemDialogFragment$$ExternalSyntheticLambda0(autoCompleteTextView, listComponent1, listComponent2, this, arrayList4, textInputEditText2, context, chipGroup2));
                SwitchMaterial switchMaterial3 = (SwitchMaterial) viewInflate.findViewById(R.id.playable_item_custom_player_switch);
                AutoCompleteTextView autoCompleteTextView2 = (AutoCompleteTextView) viewInflate.findViewById(R.id.playable_item_custom_player_select);
                Button button2 = (Button) viewInflate.findViewById(R.id.playable_item_reset_record_button);
                Button button3 = (Button) viewInflate.findViewById(R.id.playable_item_scrape_preview_media_button);
                TextView textView = (TextView) viewInflate.findViewById(R.id.playable_item_detail_text_view);
                button.setOnClickListener(new EditPlayableItemDialogFragment$$ExternalSyntheticLambda10(this, playableItemEntity, playableItemPreviewMediaIndex, str));
                EditPlayableItemDialogFragment$$ExternalSyntheticLambda11 editPlayableItemDialogFragment$$ExternalSyntheticLambda11 = new EditPlayableItemDialogFragment$$ExternalSyntheticLambda11(textInputEditText2, arrayList3, this, context, chipGroup);
                ChipGroup chipGroup3 = chipGroup;
                chip.setOnClickListener(editPlayableItemDialogFragment$$ExternalSyntheticLambda11);
                button2.setOnClickListener(new EditPlayableItemDialogFragment$$ExternalSyntheticLambda12(booleanRef, playableItemEntity, textView));
                Context context2 = context;
                PlayableItemEntity playableItemEntity2 = playableItemEntity;
                EditPlayableItemDialogFragment$$ExternalSyntheticLambda13 editPlayableItemDialogFragment$$ExternalSyntheticLambda13 = new EditPlayableItemDialogFragment$$ExternalSyntheticLambda13(this, playableItemEntity2, editText, checkBox, switchMaterial, switchMaterial2, switchMaterial3, autoCompleteTextView2, arrayList2, playerIdList, arrayList3, booleanRef, arrayList4);
                SwitchMaterial switchMaterial4 = switchMaterial3;
                EditText editText2 = editText;
                AutoCompleteTextView autoCompleteTextView3 = autoCompleteTextView2;
                button3.setOnClickListener(editPlayableItemDialogFragment$$ExternalSyntheticLambda13);
                autoCompleteTextView3.setAdapter(new AutoCompleteAdapter(context2, R.layout.list_item_dropdown_item, arrayList2));
                switchMaterial4.setOnCheckedChangeListener(new EditPlayableItemDialogFragment$$ExternalSyntheticLambda14(switchMaterial4, autoCompleteTextView3));
                editText2.setText(playableItemEntity2.getName());
                checkBox.setChecked(playableItemEntity2.isVisible());
                switchMaterial.setChecked(playableItemEntity2.getDoScrapeName());
                if (playableItemEntity2.getScraperKeywordList().isEmpty()) {
                    textInputEditText = textInputEditText2;
                } else {
                    textInputEditText = textInputEditText2;
                    textInputEditText.setText(playableItemEntity2.getScraperKeywordList().get(0));
                }
                Iterator it = playableItemEntity2.getScraperKeywordList().iterator();
                while (it.hasNext()) {
                    Context context3 = context2;
                    SwitchMaterial switchMaterial5 = switchMaterial4;
                    TextInputEditText textInputEditText3 = textInputEditText;
                    ChipGroup chipGroup4 = chipGroup3;
                    onCreateDialog$lambda$25$lambda$24$lambda$23$addScraperKeyword(textInputEditText3, arrayList3, context3, chipGroup4, this, (String) it.next(), false);
                    textInputEditText = textInputEditText3;
                    switchMaterial4 = switchMaterial5;
                    context2 = context3;
                    autoCompleteTextView3 = autoCompleteTextView3;
                    editText2 = editText2;
                    chipGroup3 = chipGroup4;
                }
                EditText editText3 = editText2;
                AutoCompleteTextView autoCompleteTextView4 = autoCompleteTextView3;
                Context context4 = context2;
                SwitchMaterial switchMaterial6 = switchMaterial4;
                TextInputEditText textInputEditText4 = textInputEditText;
                Iterator it2 = getDaijishouLibrary().getGenreIdsByPlayableItemIdStatically(playableItemEntity2.getId()).iterator();
                while (it2.hasNext()) {
                    onCreateDialog$lambda$25$lambda$24$lambda$23$addGenreId(textInputEditText4, arrayList4, context4, this, chipGroup2, (String) it2.next(), false);
                }
                switchMaterial2.setChecked(playableItemEntity2.getScrapeScraperKeywords());
                onCreateDialog$lambda$25$lambda$24$lambda$23$setUseCustomPlayer(switchMaterial6, autoCompleteTextView4, playableItemEntity2.getUseCustomPlayer());
                int iIndexOf = CollectionsKt.indexOf((List<? extends Long>) playerIdList, playableItemEntity2.getCustomPlayerId());
                if (iIndexOf != -1) {
                    autoCompleteTextView4.setText((CharSequence) arrayList2.get(iIndexOf), false);
                }
                textView.setText(Html.fromHtml("<b>Id:</b> " + playableItemEntity2.getId() + "<br><b>IsInSingletonDisjointSet:</b> " + playableItemEntity2.isInSingletonDisjointSet() + "<br><b>UseDisjointSetPrimaryPlayableItem:</b> " + playableItemEntity2.getUseDisjointSetPrimaryPlayableItem() + "<br><b>DisjointSetPrimaryPlayableItemId:</b> " + playableItemEntity2.getDisjointSetPrimaryPlayableItemId() + "<br><b>Lazy md5:</b> " + playableItemEntity2.getMd5() + "<br><b>Added date:</b> " + playableItemEntity2.getAddedDateTimestamp() + "<br><b>Sync tree:</b> " + playableItemEntity2.getSyncTreeUri().getPath() + "<br><b>Uri:</b> " + playableItemEntity2.getUri() + "<br><b>Uri path:</b> " + playableItemEntity2.getUri().getPath() + "<br><b>Preview media path:</b> " + playableItemEntity2.getPreviewMediaPath() + "<br><b>Played count:</b> " + playableItemEntity2.getPlayCount() + "<br><b>Last played:</b> " + playableItemEntity2.getLastPlayedTimestamp()));
                AlertDialog.Builder negativeButton = new AlertDialog.Builder(context4).setView(viewInflate).setTitle(getString(R.string.edit_the_playable_item)).setPositiveButton(getString(R.string.save), new EditPlayableItemDialogFragment$$ExternalSyntheticLambda15()).setNegativeButton(getString(R.string.cancel), new EditPlayableItemDialogFragment$$ExternalSyntheticLambda16());
                if (Intrinsics.areEqual(playableItemEntity2.getSyncTreeUri(), Uri.EMPTY) || Intrinsics.areEqual(playableItemEntity2.getUri(), Uri.EMPTY)) {
                    negativeButton.setNeutralButton(getString(R.string.delete), new EditPlayableItemDialogFragment$$ExternalSyntheticLambda17());
                } else {
                    negativeButton.setNeutralButton(getString(R.string.unlink_file), new EditPlayableItemDialogFragment$$ExternalSyntheticLambda1());
                }
                alertDialogCreate = negativeButton.create();
                Intrinsics.checkNotNull(alertDialogCreate);
                setupDaijishouDialog(alertDialogCreate);
                editText3.requestFocus();
                alertDialogCreate.setOnShowListener(new EditPlayableItemDialogFragment$$ExternalSyntheticLambda9(alertDialogCreate, context4, this, editText3, checkBox, switchMaterial, switchMaterial2, switchMaterial6, autoCompleteTextView4, arrayList2, playerIdList, playableItemEntity2, arrayList3, booleanRef, arrayList4));
            }
            if (alertDialogCreate != null) {
                return alertDialogCreate;
            }
            throw new IllegalStateException("playableItemEntity cannot be null");
        }
        throw new IllegalStateException("Activity cannot be null");
    }

    static /* synthetic */ void onCreateDialog$lambda$25$lambda$24$lambda$23$addScraperKeyword$default(TextInputEditText textInputEditText, List list, Context context, ChipGroup chipGroup, EditPlayableItemDialogFragment editPlayableItemDialogFragment, String str, boolean z, int i, Object obj) {
        if ((i & 64) != 0) {
            z = true;
        }
        onCreateDialog$lambda$25$lambda$24$lambda$23$addScraperKeyword(textInputEditText, list, context, chipGroup, editPlayableItemDialogFragment, str, z);
    }

    private static final void onCreateDialog$lambda$25$lambda$24$lambda$23$addScraperKeyword(TextInputEditText textInputEditText, List<String> list, Context context, ChipGroup chipGroup, EditPlayableItemDialogFragment editPlayableItemDialogFragment, String str, boolean z) {
        textInputEditText.setError(null);
        list.add(str);
        Chip chip = new Chip(context);
        chip.setId(View.generateViewId());
        chip.setText(str);
        chip.setCloseIconVisible(true);
        chip.setOnCloseIconClickListener(new EditPlayableItemDialogFragment$$ExternalSyntheticLambda8(list, str, chipGroup));
        Intrinsics.checkNotNull(chipGroup);
        ViewGroupKt.get(chipGroup, chipGroup.getChildCount() - 1).setNextFocusRightId(-1);
        chip.setNextFocusRightId(chip.getId());
        chipGroup.addView(chip);
        if (z) {
            Toast.makeText(editPlayableItemDialogFragment.requireContext(), editPlayableItemDialogFragment.getString(R.string.added_successfully), 0).show();
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$25$lambda$24$lambda$23$addScraperKeyword$lambda$4(List scraperKeywordList, String scraperKeywordText, ChipGroup chipGroup, View view) {
        Intrinsics.checkNotNullParameter(scraperKeywordList, "$scraperKeywordList");
        Intrinsics.checkNotNullParameter(scraperKeywordText, "$scraperKeywordText");
        scraperKeywordList.remove(scraperKeywordText);
        chipGroup.removeView(view);
    }

    static /* synthetic */ void onCreateDialog$lambda$25$lambda$24$lambda$23$addGenreId$default(TextInputEditText textInputEditText, List list, Context context, EditPlayableItemDialogFragment editPlayableItemDialogFragment, ChipGroup chipGroup, String str, boolean z, int i, Object obj) {
        if ((i & 64) != 0) {
            z = true;
        }
        onCreateDialog$lambda$25$lambda$24$lambda$23$addGenreId(textInputEditText, list, context, editPlayableItemDialogFragment, chipGroup, str, z);
    }

    private static final void onCreateDialog$lambda$25$lambda$24$lambda$23$addGenreId(TextInputEditText textInputEditText, List<String> list, Context context, EditPlayableItemDialogFragment editPlayableItemDialogFragment, ChipGroup chipGroup, String str, boolean z) {
        textInputEditText.setError(null);
        list.add(str);
        Chip chip = new Chip(context);
        chip.setId(View.generateViewId());
        Genre genre = Genres.INSTANCE.getGenres().get(str);
        Intrinsics.checkNotNull(genre);
        chip.setText(editPlayableItemDialogFragment.getString(genre.getNameStringId()));
        chip.setCloseIconVisible(true);
        chip.setOnCloseIconClickListener(new EditPlayableItemDialogFragment$$ExternalSyntheticLambda7(list, str, chipGroup));
        Intrinsics.checkNotNull(chipGroup);
        ViewGroupKt.get(chipGroup, chipGroup.getChildCount() - 1).setNextFocusRightId(-1);
        chip.setNextFocusRightId(chip.getId());
        chipGroup.addView(chip);
        if (z) {
            Toast.makeText(editPlayableItemDialogFragment.requireContext(), editPlayableItemDialogFragment.getString(R.string.added_successfully), 0).show();
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$25$lambda$24$lambda$23$addGenreId$lambda$5(List genreIdList, String genreId, ChipGroup chipGroup, View view) {
        Intrinsics.checkNotNullParameter(genreIdList, "$genreIdList");
        Intrinsics.checkNotNullParameter(genreId, "$genreId");
        genreIdList.remove(genreId);
        chipGroup.removeView(view);
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$25$lambda$24$lambda$23$lambda$7(AutoCompleteTextView autoCompleteTextView, List availableGenreIdList, List genreNamesList, EditPlayableItemDialogFragment this$0, List genreIdList, TextInputEditText textInputEditText, Context context, ChipGroup chipGroup, View view) {
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
            onCreateDialog$lambda$25$lambda$24$lambda$23$addGenreId$default(textInputEditText, genreIdList, context, this$0, chipGroup, str, false, 64, null);
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$25$lambda$24$lambda$23$setUseCustomPlayer(SwitchMaterial switchMaterial, AutoCompleteTextView autoCompleteTextView, boolean z) {
        switchMaterial.setChecked(z);
        autoCompleteTextView.setEnabled(z);
    }

    private static final boolean onCreateDialog$lambda$25$lambda$24$lambda$23$saveChanges(EditText editText, CheckBox checkBox, SwitchMaterial switchMaterial, SwitchMaterial switchMaterial2, SwitchMaterial switchMaterial3, AutoCompleteTextView autoCompleteTextView, EditPlayableItemDialogFragment editPlayableItemDialogFragment, List<String> list, List<Long> list2, PlayableItemEntity playableItemEntity, List<String> list3, Ref.BooleanRef booleanRef, List<String> list4) {
        Long l;
        String string = editText.getText().toString();
        boolean zIsChecked = checkBox.isChecked();
        boolean zIsChecked2 = switchMaterial.isChecked();
        boolean zIsChecked3 = switchMaterial2.isChecked();
        boolean zIsChecked4 = switchMaterial3.isChecked();
        Editable text = autoCompleteTextView.getText();
        if (string.length() == 0) {
            editText.setError(editPlayableItemDialogFragment.getString(R.string.please_enter_a_playable_item_name));
            return false;
        }
        int iIndexOf = list.indexOf(text.toString());
        if (!zIsChecked4) {
            l = null;
        } else {
            if (zIsChecked4 && iIndexOf == -1) {
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
        playableItemEntity.setScrapeScraperKeywords(zIsChecked3);
        playableItemEntity.setUseCustomPlayer(zIsChecked4);
        playableItemEntity.setCustomPlayerId(l);
        editPlayableItemDialogFragment.getDaijishouLibrary().updatePlayableItem(playableItemEntity);
        if (booleanRef.element) {
            editPlayableItemDialogFragment.getDaijishouLibrary().deleteAllEventsByPlayableItemId(playableItemEntity.getId());
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list4.iterator();
        while (it.hasNext()) {
            arrayList.add(new PlayableItemToGenrePairEntity(0L, playableItemEntity.getId(), (String) it.next(), null, 9, null));
        }
        editPlayableItemDialogFragment.getDaijishouLibrary().deletePlayableItemToGenrePairsByPlayableItemId(playableItemEntity.getId());
        DaijishouLibraryModel daijishouLibrary = editPlayableItemDialogFragment.getDaijishouLibrary();
        PlayableItemToGenrePairEntity[] playableItemToGenrePairEntityArr = (PlayableItemToGenrePairEntity[]) arrayList.toArray(new PlayableItemToGenrePairEntity[0]);
        daijishouLibrary.addPlayableItemToGenrePairs((PlayableItemToGenrePairEntity[]) Arrays.copyOf(playableItemToGenrePairEntityArr, playableItemToGenrePairEntityArr.length));
        return true;
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$25$lambda$24$lambda$23$lambda$9(EditPlayableItemDialogFragment this$0, PlayableItemEntity playableItemEntity, PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex, String indexPath, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(playableItemEntity, "$playableItemEntity");
        Intrinsics.checkNotNullParameter(playableItemPreviewMediaIndex, "$playableItemPreviewMediaIndex");
        Intrinsics.checkNotNullParameter(indexPath, "$indexPath");
        ListSelectDialogFragment.Companion companion = ListSelectDialogFragment.INSTANCE;
        String string = this$0.getString(R.string.preview_media_options_title);
        String string2 = this$0.getString(R.string.box_art);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = this$0.getString(R.string.snapshot);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = this$0.getString(R.string.title);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        ListSelectDialogFragment listSelectDialogFragmentNewInstance$default = ListSelectDialogFragment.Companion.newInstance$default(companion, string, CollectionsKt.arrayListOf(string2, string3, string4), null, false, 12, null);
        listSelectDialogFragmentNewInstance$default.setOnSelectListener(new EditPlayableItemDialogFragment$onCreateDialog$1$1$1$2$1(listSelectDialogFragmentNewInstance$default, this$0)).setOnLongSelectListener(new EditPlayableItemDialogFragment$onCreateDialog$1$1$1$2$2(listSelectDialogFragmentNewInstance$default, playableItemEntity, playableItemPreviewMediaIndex, this$0, indexPath)).show(this$0.getParentFragmentManager(), ListSelectDialogFragment.class.getName());
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$25$lambda$24$lambda$23$lambda$10(TextInputEditText textInputEditText, List scraperKeywordList, EditPlayableItemDialogFragment this$0, Context context, ChipGroup chipGroup, View view) {
        Intrinsics.checkNotNullParameter(scraperKeywordList, "$scraperKeywordList");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        String strValueOf = String.valueOf(textInputEditText.getText());
        if (scraperKeywordList.indexOf(strValueOf) != -1) {
            textInputEditText.setError(this$0.getString(R.string.item_has_been_added));
            textInputEditText.requestFocus();
        } else {
            onCreateDialog$lambda$25$lambda$24$lambda$23$addScraperKeyword$default(textInputEditText, scraperKeywordList, context, chipGroup, this$0, strValueOf, false, 64, null);
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$25$lambda$24$lambda$23$lambda$11(Ref.BooleanRef resetRecord, PlayableItemEntity playableItemEntity, TextView textView, View view) {
        Intrinsics.checkNotNullParameter(resetRecord, "$resetRecord");
        Intrinsics.checkNotNullParameter(playableItemEntity, "$playableItemEntity");
        resetRecord.element = true;
        playableItemEntity.setLastPlayedTimestamp(null);
        playableItemEntity.setPlayCount(0);
        textView.setText(Html.fromHtml("<b>Id:</b> " + playableItemEntity.getId() + "<br><b>IsInSingletonDisjointSet:</b> " + playableItemEntity.isInSingletonDisjointSet() + "<br><b>UseDisjointSetPrimaryPlayableItem:</b> " + playableItemEntity.getUseDisjointSetPrimaryPlayableItem() + "<br><b>DisjointSetPrimaryPlayableItemId:</b> " + playableItemEntity.getDisjointSetPrimaryPlayableItemId() + "<br><b>Lazy md5:</b> " + playableItemEntity.getMd5() + "<br><b>Added date:</b> " + playableItemEntity.getAddedDateTimestamp() + "<br><b>Sync tree:</b> " + playableItemEntity.getSyncTreeUri().getPath() + "<br><b>Uri:</b> " + playableItemEntity.getUri() + "<br><b>Uri path:</b> " + playableItemEntity.getUri().getPath() + "<br><b>Preview media path:</b> " + playableItemEntity.getPreviewMediaPath() + "<br><b>Played count:</b> " + playableItemEntity.getPlayCount() + "<br><b>Last played:</b> " + playableItemEntity.getLastPlayedTimestamp()));
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$25$lambda$24$lambda$23$lambda$12(EditPlayableItemDialogFragment this$0, PlayableItemEntity playableItemEntity, EditText editText, CheckBox checkBox, SwitchMaterial switchMaterial, SwitchMaterial switchMaterial2, SwitchMaterial switchMaterial3, AutoCompleteTextView autoCompleteTextView, List playerNameList, List playerIdList, List scraperKeywordList, Ref.BooleanRef resetRecord, List genreIdList, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(playableItemEntity, "$playableItemEntity");
        Intrinsics.checkNotNullParameter(playerNameList, "$playerNameList");
        Intrinsics.checkNotNullParameter(playerIdList, "$playerIdList");
        Intrinsics.checkNotNullParameter(scraperKeywordList, "$scraperKeywordList");
        Intrinsics.checkNotNullParameter(resetRecord, "$resetRecord");
        Intrinsics.checkNotNullParameter(genreIdList, "$genreIdList");
        if (onCreateDialog$lambda$25$lambda$24$lambda$23$saveChanges(editText, checkBox, switchMaterial, switchMaterial2, switchMaterial3, autoCompleteTextView, this$0, playerNameList, playerIdList, playableItemEntity, scraperKeywordList, resetRecord, genreIdList)) {
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

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$25$lambda$24$lambda$23$lambda$22(AlertDialog alertDialog, Context context, EditPlayableItemDialogFragment this$0, EditText editText, CheckBox checkBox, SwitchMaterial switchMaterial, SwitchMaterial switchMaterial2, SwitchMaterial switchMaterial3, AutoCompleteTextView autoCompleteTextView, List playerNameList, List playerIdList, PlayableItemEntity playableItemEntity, List scraperKeywordList, Ref.BooleanRef resetRecord, List genreIdList, DialogInterface dialogInterface) {
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
        button.setOnClickListener(new EditPlayableItemDialogFragment$$ExternalSyntheticLambda5(alertDialog, context, this$0, editText, checkBox, switchMaterial, switchMaterial2, switchMaterial3, autoCompleteTextView, playerNameList, playerIdList, playableItemEntity, scraperKeywordList, resetRecord, genreIdList));
        Button button2 = alertDialog.getButton(-3);
        Intrinsics.checkNotNullExpressionValue(button2, "getButton(...)");
        button2.setOnClickListener(new EditPlayableItemDialogFragment$$ExternalSyntheticLambda6(playableItemEntity, this$0, alertDialog, context, button2));
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$25$lambda$24$lambda$23$lambda$22$lambda$20(AlertDialog alertDialog, Context context, EditPlayableItemDialogFragment this$0, EditText editText, CheckBox checkBox, SwitchMaterial switchMaterial, SwitchMaterial switchMaterial2, SwitchMaterial switchMaterial3, AutoCompleteTextView autoCompleteTextView, List playerNameList, List playerIdList, PlayableItemEntity playableItemEntity, List scraperKeywordList, Ref.BooleanRef resetRecord, List genreIdList, View view) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(playerNameList, "$playerNameList");
        Intrinsics.checkNotNullParameter(playerIdList, "$playerIdList");
        Intrinsics.checkNotNullParameter(playableItemEntity, "$playableItemEntity");
        Intrinsics.checkNotNullParameter(scraperKeywordList, "$scraperKeywordList");
        Intrinsics.checkNotNullParameter(resetRecord, "$resetRecord");
        Intrinsics.checkNotNullParameter(genreIdList, "$genreIdList");
        if (onCreateDialog$lambda$25$lambda$24$lambda$23$saveChanges(editText, checkBox, switchMaterial, switchMaterial2, switchMaterial3, autoCompleteTextView, this$0, playerNameList, playerIdList, playableItemEntity, scraperKeywordList, resetRecord, genreIdList)) {
            alertDialog.dismiss();
            Toast.makeText(context, this$0.getString(R.string.edited_successfully), 0).show();
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$25$lambda$24$lambda$23$lambda$22$lambda$21(PlayableItemEntity playableItemEntity, EditPlayableItemDialogFragment this$0, AlertDialog alertDialog, Context context, Button neutralButton, View view) {
        Intrinsics.checkNotNullParameter(playableItemEntity, "$playableItemEntity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(neutralButton, "$neutralButton");
        if (Intrinsics.areEqual(playableItemEntity.getSyncTreeUri(), Uri.EMPTY) || Intrinsics.areEqual(playableItemEntity.getUri(), Uri.EMPTY)) {
            AcknowledgementDialogFragment.Companion.newInstance$default(AcknowledgementDialogFragment.INSTANCE, this$0.getString(R.string.are_you_sure), this$0.getString(R.string.delete_playable_item_warning), null, null, null, 28, null).setOnAcknowledgedListener(new EditPlayableItemDialogFragment$onCreateDialog$1$1$1$11$2$1(this$0, playableItemEntity, alertDialog, context)).show(this$0.getParentFragmentManager(), AcknowledgementDialogFragment.class.getName());
        } else {
            AcknowledgementDialogFragment.Companion.newInstance$default(AcknowledgementDialogFragment.INSTANCE, this$0.getString(R.string.are_you_sure), this$0.getString(R.string.detach_playable_item_uri_warning), null, null, null, 28, null).setOnAcknowledgedListener(new EditPlayableItemDialogFragment$onCreateDialog$1$1$1$11$2$2(playableItemEntity, this$0, neutralButton)).show(this$0.getParentFragmentManager(), AcknowledgementDialogFragment.class.getName());
        }
    }
}
