package com.magneticchen.daijishou.nav_fragments;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.content.FileProvider;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: LibraryCollectionWallpaperViewNavFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\u001a\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0010H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/magneticchen/daijishou/nav_fragments/ShareFileContract;", "Landroidx/activity/result/contract/ActivityResultContract;", "Ljava/io/File;", "()V", "file", "getFile", "()Ljava/io/File;", "setFile", "(Ljava/io/File;)V", "sharedFileDescription", "", "getSharedFileDescription", "()Ljava/lang/String;", "setSharedFileDescription", "(Ljava/lang/String;)V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ShareFileContract extends ActivityResultContract<File, File> {
    private File file;
    private String sharedFileDescription = "shared file.";

    public final String getSharedFileDescription() {
        return this.sharedFileDescription;
    }

    public final void setSharedFileDescription(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sharedFileDescription = str;
    }

    public final File getFile() {
        return this.file;
    }

    public final void setFile(File file) {
        this.file = file;
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    public Intent createIntent(Context context, File input) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        this.file = input;
        Uri uriForFile = FileProvider.getUriForFile(context, context.getApplicationContext().getPackageName() + ".provider", input);
        Intent intent = new Intent("android.intent.action.SEND");
        intent.addFlags(1);
        intent.setType("*/*");
        intent.setClipData(new ClipData(this.sharedFileDescription, new String[]{"*/*"}, new ClipData.Item(uriForFile)));
        intent.putExtra("android.intent.extra.STREAM", uriForFile);
        intent.putExtra("android.intent.extra.SUBJECT", this.sharedFileDescription);
        Intent intentCreateChooser = Intent.createChooser(intent, "Share file");
        Intrinsics.checkNotNullExpressionValue(intentCreateChooser, "createChooser(...)");
        return intentCreateChooser;
    }

    /* WARN: Can't rename method to resolve collision */
    @Override // androidx.activity.result.contract.ActivityResultContract
    public File parseResult(int resultCode, Intent intent) {
        File file = this.file;
        Intrinsics.checkNotNull(file);
        return file;
    }
}
