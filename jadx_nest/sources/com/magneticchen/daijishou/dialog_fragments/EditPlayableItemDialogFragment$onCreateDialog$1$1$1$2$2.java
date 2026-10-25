package com.magneticchen.daijishou.dialog_fragments;

import android.widget.Toast;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemPreviewMediaIndex;
import com.magneticchen.daijishou.scraper.ScraperUtilsKt;
import com.magneticchen.daijishou.view_models.DaijishouLibraryModel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;

/* JADX INFO: compiled from: EditPlayableItemDialogFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class EditPlayableItemDialogFragment$onCreateDialog$1$1$1$2$2 extends Lambda<Unit> implements Function1<Integer, Unit> {
    final /* synthetic */ ListSelectDialogFragment $dialog;
    final /* synthetic */ String $indexPath;
    final /* synthetic */ PlayableItemEntity $playableItemEntity;
    final /* synthetic */ PlayableItemPreviewMediaIndex $playableItemPreviewMediaIndex;
    final /* synthetic */ EditPlayableItemDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EditPlayableItemDialogFragment$onCreateDialog$1$1$1$2$2(ListSelectDialogFragment listSelectDialogFragment, PlayableItemEntity playableItemEntity, PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex, EditPlayableItemDialogFragment editPlayableItemDialogFragment, String str) {
        super(1);
        this.$dialog = listSelectDialogFragment;
        this.$playableItemEntity = playableItemEntity;
        this.$playableItemPreviewMediaIndex = playableItemPreviewMediaIndex;
        this.this$0 = editPlayableItemDialogFragment;
        this.$indexPath = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        try {
                invoke(num.intValue());
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
        return Unit.INSTANCE;
    }

    public final void invoke(int i) throws IOException {
        this.$dialog.dismiss();
        if (i == 0) {
            File file = new File(this.$playableItemEntity.getPreviewMediaPath() + this.$playableItemPreviewMediaIndex.getBoxArtPath());
            if (file.exists()) {
                file.delete();
            }
            if (file.exists()) {
                file.delete();
            }
            this.this$0.getDaijishouLibrary().getCachedBoxArtBitmapLoader().remove(this.$playableItemEntity.getPreviewMediaPath() + this.$playableItemPreviewMediaIndex.getBoxArtPath());
            this.$playableItemPreviewMediaIndex.setBoxArtPath(null);
            Toast.makeText(this.this$0.requireContext(), this.this$0.getString(R.string.box_art_removed), 0).show();
        } else if (i == 1) {
            File file2 = new File(this.$playableItemEntity.getPreviewMediaPath() + this.$playableItemPreviewMediaIndex.getSnapshotPath());
            if (file2.exists()) {
                file2.delete();
            }
            this.this$0.getDaijishouLibrary().getCachedSnapshotBitmapLoader().remove(this.$playableItemEntity.getPreviewMediaPath() + this.$playableItemPreviewMediaIndex.getSnapshotPath());
            this.$playableItemPreviewMediaIndex.setSnapshotPath(null);
            Toast.makeText(this.this$0.requireContext(), this.this$0.getString(R.string.snapshot_removed), 0).show();
        } else if (i == 2) {
            File file3 = new File(this.$playableItemEntity.getPreviewMediaPath() + this.$playableItemPreviewMediaIndex.getTitlePath());
            if (file3.exists()) {
                file3.delete();
            }
            this.this$0.getDaijishouLibrary().getCachedTitleBitmapLoader().remove(this.$playableItemEntity.getPreviewMediaPath() + this.$playableItemPreviewMediaIndex.getTitlePath());
            this.$playableItemPreviewMediaIndex.setTitlePath(null);
            Toast.makeText(this.this$0.requireContext(), this.this$0.getString(R.string.title_removed), 0).show();
        }
        if (ScraperUtilsKt.hasAnyMedia(this.$playableItemPreviewMediaIndex)) {
            Json jsonJson$default = JsonKt.Json$default(null, EditPlayableItemDialogFragment$onCreateDialog$1$1$1$2$2$jsonFormat$1.INSTANCE, 1, null);
            PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex = this.$playableItemPreviewMediaIndex;
            jsonJson$default.getSerializersModule();
            String strEncodeToString = jsonJson$default.encodeToString(PlayableItemPreviewMediaIndex.INSTANCE.serializer(), playableItemPreviewMediaIndex);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(this.$indexPath));
            outputStreamWriter.write(strEncodeToString);
            outputStreamWriter.close();
            DaijishouLibraryModel daijishouLibrary = this.this$0.getDaijishouLibrary();
            PlayableItemEntity playableItemByIdStatically = this.this$0.getDaijishouLibrary().getPlayableItemByIdStatically(this.$playableItemEntity.getId());
            Intrinsics.checkNotNull(playableItemByIdStatically);
            daijishouLibrary.updatePlayableItem(playableItemByIdStatically);
            return;
        }
        File file4 = new File(this.$indexPath);
        if (file4.exists()) {
            FilesKt.deleteRecursively(file4);
        }
        PlayableItemEntity playableItemByIdStatically2 = this.this$0.getDaijishouLibrary().getPlayableItemByIdStatically(this.$playableItemEntity.getId());
        Intrinsics.checkNotNull(playableItemByIdStatically2);
        playableItemByIdStatically2.setPreviewMediaPath(null);
        this.$playableItemEntity.setPreviewMediaPath(null);
        this.this$0.getDaijishouLibrary().updatePlayableItem(playableItemByIdStatically2);
    }
}
