package com.magneticchen.daijishou.nav_fragments;

import android.content.Context;
import android.widget.Toast;
import androidx.activity.result.contract.ActivityResultContract;
import com.magneticchen.daijishou.daijishou_library_db.PlatformEntity;
import com.magneticchen.daijishou.daijishou_library_db.portables.FavoriteItemsShareable;
import com.magneticchen.daijishou.daijishou_library_db.portables.PlatformSharable;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Regex;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;

/* INFO: compiled from: LibraryCollectionWallpaperViewNavFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "pos", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class LibraryCollectionWallpaperViewNavFragment$onCreateView$23$1$1 extends Lambda<Unit> implements Function1<Integer, Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ PlatformEntity $platformEntity;
    final /* synthetic */ LibraryCollectionWallpaperViewNavFragment this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    LibraryCollectionWallpaperViewNavFragment$onCreateView$23$1$1(LibraryCollectionWallpaperViewNavFragment libraryCollectionWallpaperViewNavFragment, PlatformEntity platformEntity, Context context) {
        super(1);
        this.this$0 = libraryCollectionWallpaperViewNavFragment;
        this.$platformEntity = platformEntity;
        this.$context = context;
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

    public final void invoke(int i) {
        if (i == 0) {
            PlatformSharable platformSharableExportPlatform = this.this$0.getDaijishouLibrary().exportPlatform(this.$platformEntity);
            Json jsonJson$default = JsonKt.Json$default(null, LibraryCollectionWallpaperViewNavFragment$onCreateView$23$1$1$jsonFormat$1.INSTANCE, 1, null);
            jsonJson$default.getSerializersModule();
            String strEncodeToString = jsonJson$default.encodeToString(PlatformSharable.INSTANCE.serializer(), platformSharableExportPlatform);
            try {
                String strReplace = new Regex("\\W+").replace(this.$platformEntity.getName(), "");
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.$context.openFileOutput(strReplace + ".json", 0));
                outputStreamWriter.write(strEncodeToString);
                outputStreamWriter.close();
                File file = new File(this.$context.getFilesDir(), strReplace + ".json");
                ActivityResultContract contract = this.this$0.shareFileActivity.getContract();
                Intrinsics.checkNotNull(contract, "null cannot be cast to non-null type com.magneticchen.daijishou.nav_fragments.ShareFileContract");
                ((ShareFileContract) contract).setSharedFileDescription(this.$platformEntity.getName() + " platform settings.");
                this.this$0.shareFileActivity.launch(file);
                return;
            } catch (IOException unused) {
                Toast.makeText(this.$context, "IO Exception.", 0).show();
                return;
            }
        }
        if (i != 1) {
            return;
        }
        FavoriteItemsShareable favoriteItemsShareableExportPlatformFavoriteItems = this.this$0.getDaijishouLibrary().exportPlatformFavoriteItems(this.$platformEntity);
        Json jsonJson$default2 = JsonKt.Json$default(null, LibraryCollectionWallpaperViewNavFragment$onCreateView$23$1$1$jsonFormat$2.INSTANCE, 1, null);
        jsonJson$default2.getSerializersModule();
        String strEncodeToString2 = jsonJson$default2.encodeToString(FavoriteItemsShareable.INSTANCE.serializer(), favoriteItemsShareableExportPlatformFavoriteItems);
        try {
            String strReplace2 = new Regex("\\W+").replace(this.$platformEntity.getName(), "");
            OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(this.$context.openFileOutput(strReplace2 + "FavoriteItems.json", 0));
            outputStreamWriter2.write(strEncodeToString2);
            outputStreamWriter2.close();
            File file2 = new File(this.$context.getFilesDir(), strReplace2 + "FavoriteItems.json");
            ActivityResultContract contract2 = this.this$0.shareFileActivity.getContract();
            Intrinsics.checkNotNull(contract2, "null cannot be cast to non-null type com.magneticchen.daijishou.nav_fragments.ShareFileContract");
            ((ShareFileContract) contract2).setSharedFileDescription(this.$platformEntity.getName() + " favorite items.");
            this.this$0.shareFileActivity.launch(file2);
        } catch (IOException unused2) {
            Toast.makeText(this.$context, "IO Exception.", 0).show();
        }
    }
}
