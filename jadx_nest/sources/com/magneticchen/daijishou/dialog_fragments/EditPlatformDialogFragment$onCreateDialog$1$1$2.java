package com.magneticchen.daijishou.dialog_fragments;

import android.content.Context;
import android.net.Uri;
import android.widget.TextView;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.utils.Utils;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import net.lingala.zip4j.util.InternalZipConstants;

/* INFO: compiled from: EditPlatformDialogFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/net/Uri;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class EditPlatformDialogFragment$onCreateDialog$1$1$2 extends Lambda<Unit> implements Function1<Uri, Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ TextView $isWallpaperSelectedTextView;
    final /* synthetic */ Ref.ObjectRef<File> $selectedWallpaperFile;
    final /* synthetic */ Ref.BooleanRef $updateWallpaper;
    final /* synthetic */ EditPlatformDialogFragment this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    EditPlatformDialogFragment$onCreateDialog$1$1$2(EditPlatformDialogFragment editPlatformDialogFragment, Context context, Ref.ObjectRef<File> objectRef, TextView textView, Ref.BooleanRef booleanRef) {
        super(1);
        this.this$0 = editPlatformDialogFragment;
        this.$context = context;
        this.$selectedWallpaperFile = objectRef;
        this.$isWallpaperSelectedTextView = textView;
        this.$updateWallpaper = booleanRef;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Uri uri) {
        try {
            invoke2(uri);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
        return Unit.INSTANCE;
    }

    /* WARN: Type inference failed for: r9v1, types: [T, java.io.File] */
    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Uri uri) throws Throwable {
        if (uri != null) {
            EditPlatformDialogFragment editPlatformDialogFragment = this.this$0;
            Context context = this.$context;
            Ref.ObjectRef<File> objectRef = this.$selectedWallpaperFile;
            TextView textView = this.$isWallpaperSelectedTextView;
            Ref.BooleanRef booleanRef = this.$updateWallpaper;
            editPlatformDialogFragment.ensureWallpaperDirectory();
            String str = context.getFilesDir() + InternalZipConstants.ZIP_FILE_SEPARATOR + editPlatformDialogFragment.wallpaperDirectoryName + "/temp";
            Utils utils = Utils.INSTANCE;
            Intrinsics.checkNotNull(context);
            utils.copyFile(context, uri, str);
            objectRef.element = new File(str);
            textView.setText(editPlatformDialogFragment.getString(R.string.selected));
            booleanRef.element = true;
        }
    }
}
