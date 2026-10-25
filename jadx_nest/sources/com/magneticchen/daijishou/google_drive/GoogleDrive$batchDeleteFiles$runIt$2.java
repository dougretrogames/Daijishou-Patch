package com.magneticchen.daijishou.google_drive;

import com.google.api.client.googleapis.batch.json.JsonBatchCallback;
import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.http.HttpHeaders;
import kotlin.Metadata;

/* JADX INFO: compiled from: GoogleDrive.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u000b"}, d2 = {"com/magneticchen/daijishou/google_drive/GoogleDrive$batchDeleteFiles$runIt$2", "Lcom/google/api/client/googleapis/batch/json/JsonBatchCallback;", "Ljava/lang/Void;", "onFailure", "", "e", "Lcom/google/api/client/googleapis/json/GoogleJsonError;", "httpHeaders", "Lcom/google/api/client/http/HttpHeaders;", "onSuccess", "aVoid", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GoogleDrive$batchDeleteFiles$runIt$2 extends JsonBatchCallback<Void> {
    final /* synthetic */ String $fileId;

    GoogleDrive$batchDeleteFiles$runIt$2(String str) {
        this.$fileId = str;
    }

    @Override // com.google.api.client.googleapis.batch.BatchCallback
    public void onSuccess(Void aVoid, HttpHeaders httpHeaders) {
        System.out.println((Object) ("Successfully deleted file with ID: " + this.$fileId));
    }

    @Override // com.google.api.client.googleapis.batch.json.JsonBatchCallback
    public void onFailure(GoogleJsonError e, HttpHeaders httpHeaders) {
        System.err.println("Failed to delete file with ID: " + this.$fileId);
    }
}
