package com.github.kittinunf.fuel.core.requests;

import com.github.kittinunf.fuel.core.Request;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DownloadRequest.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002*\u0016\u0010\u0003\"\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0012\u0004\u0012\u00020\u00050\u0004*.\u0010\u0006\"\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u00072\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0007*.\u0010\n\"\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\u00072\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\u0007*P\u0010\f\" \u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u0002`\u000f0\r0\u00072*\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0002\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u000f0\r0\u0007¨\u0006\u0010"}, d2 = {"download", "Lcom/github/kittinunf/fuel/core/requests/DownloadRequest;", "Lcom/github/kittinunf/fuel/core/Request;", "DestinationAsStreamCallback", "Lkotlin/Function0;", "Ljava/io/InputStream;", "FileDestinationCallback", "Lkotlin/Function2;", "Lcom/github/kittinunf/fuel/core/Response;", "Ljava/io/File;", "LegacyDestinationCallback", "Ljava/net/URL;", "StreamDestinationCallback", "Lkotlin/Pair;", "Ljava/io/OutputStream;", "Lcom/github/kittinunf/fuel/core/requests/DestinationAsStreamCallback;", "fuel"}, k = 2, mv = {1, 4, 0})
public final class DownloadRequestKt {
    public static final DownloadRequest download(Request download) {
        Intrinsics.checkNotNullParameter(download, "$this$download");
        return DownloadRequest.INSTANCE.enableFor(download);
    }
}
