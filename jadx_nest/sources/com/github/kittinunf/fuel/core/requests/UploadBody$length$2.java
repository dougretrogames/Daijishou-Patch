package com.github.kittinunf.fuel.core.requests;

import com.github.kittinunf.fuel.core.DataPart;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: UploadBody.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Long;"}, k = 3, mv = {1, 4, 0})
final class UploadBody$length$2 extends Lambda implements Function0<Long> {
    final /* synthetic */ UploadBody this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UploadBody$length$2(UploadBody uploadBody) {
        super(0);
        this.this$0 = uploadBody;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Long invoke() {
        Iterator<T> it = this.this$0.getRequest().getParameters().iterator();
        double dWriteParameter = 0.0d;
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            dWriteParameter += this.this$0.writeParameter(new ByteArrayOutputStream(), (String) pair.component1(), pair.component2());
        }
        Iterator<T> it2 = this.this$0.getRequest().getDataParts().iterator();
        double dWriteDataPartHeader = 0.0d;
        while (it2.hasNext()) {
            DataPart dataPart = (DataPart) ((Function1) it2.next()).invoke(this.this$0.getRequest());
            Long contentLength = dataPart.getContentLength();
            if (contentLength == null) {
                return null;
            }
            long jLongValue = contentLength.longValue();
            if (jLongValue != -1) {
                dWriteDataPartHeader += this.this$0.writeDataPartHeader(new ByteArrayOutputStream(), dataPart) + 0.0d + jLongValue + ((double) UploadBody.CRLF.length);
            } else {
                return -1L;
            }
        }
        double d = dWriteParameter + dWriteDataPartHeader;
        String str = "--" + this.this$0.getBoundary() + "--";
        Charset default_charset = UploadBody.INSTANCE.getDEFAULT_CHARSET();
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = str.getBytes(default_charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        return Long.valueOf((long) (d + ((double) bytes.length) + ((double) UploadBody.CRLF.length)));
    }
}
