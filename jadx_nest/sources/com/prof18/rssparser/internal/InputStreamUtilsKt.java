package com.prof18.rssparser.internal;

import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: InputStreamUtils.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"closeQuietly", "", "Ljava/io/InputStream;", "rssparser_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class InputStreamUtilsKt {
    public static final void closeQuietly(InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        try {
            inputStream.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }
}
