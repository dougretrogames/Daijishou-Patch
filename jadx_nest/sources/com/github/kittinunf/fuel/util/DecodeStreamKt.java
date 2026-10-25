package com.github.kittinunf.fuel.util;

import java.io.InputStream;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DecodeStream.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\u0002\u001a2\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00032\u001e\b\u0002\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u0004\u001a8\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u001e\b\u0002\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u0004\"$\u0010\u0000\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u0004X\u0082\u0004¢\u0006\u0002\n\u0000*0\b\u0002\u0010\n\"\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u000b"}, d2 = {"UNSUPPORTED_DECODE_ENCODING", "Lkotlin/Function2;", "Ljava/io/InputStream;", "", "Lcom/github/kittinunf/fuel/util/DecodeFallbackCallback;", "decode", "encoding", "unsupported", "encodings", "", "DecodeFallbackCallback", "fuel"}, k = 2, mv = {1, 4, 0})
public final class DecodeStreamKt {
    private static final Function2<InputStream, String, InputStream> UNSUPPORTED_DECODE_ENCODING = DecodeStreamKt$UNSUPPORTED_DECODE_ENCODING$1.INSTANCE;

    public static /* synthetic */ InputStream decode$default(InputStream inputStream, String str, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = UNSUPPORTED_DECODE_ENCODING;
        }
        return decode(inputStream, str, (Function2<? super InputStream, ? super String, ? extends InputStream>) function2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0056, code lost:
    
        if (r0.equals(org.apache.http.protocol.HTTP.CHUNK_CODING) != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006f, code lost:
    
        if (r0.equals("") != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0078, code lost:
    
        if (r0.equals(org.apache.http.protocol.HTTP.IDENTITY_CODING) != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007a, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.io.InputStream decode(java.io.InputStream r3, java.lang.String r4, kotlin.jvm.functions.Function2<? super java.io.InputStream, ? super java.lang.String, ? extends java.io.InputStream> r5) {
        /*
            java.lang.String r0 = "$this$decode"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "encoding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "unsupported"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = r4
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.CharSequence r0 = kotlin.text.StringsKt.trim(r0)
            java.lang.String r0 = r0.toString()
            if (r0 == 0) goto L82
            java.lang.String r0 = r0.toLowerCase()
            java.lang.String r1 = "(this as java.lang.String).toLowerCase()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            int r1 = r0.hashCode()
            r2 = -135761730(0xfffffffff7e870be, float:-9.428903E33)
            if (r1 == r2) goto L72
            if (r1 == 0) goto L69
            r2 = 3189082(0x30a95a, float:4.468856E-39)
            if (r1 == r2) goto L59
            r2 = 757417932(0x2d2547cc, float:9.395106E-12)
            if (r1 == r2) goto L50
            r2 = 1545112619(0x5c188c2b, float:1.7175325E17)
            if (r1 == r2) goto L40
            goto L7b
        L40:
            java.lang.String r1 = "deflate"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L7b
            java.util.zip.InflaterInputStream r4 = new java.util.zip.InflaterInputStream
            r4.<init>(r3)
            java.io.InputStream r4 = (java.io.InputStream) r4
            return r4
        L50:
            java.lang.String r1 = "chunked"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L7b
            goto L7a
        L59:
            java.lang.String r1 = "gzip"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L7b
            java.util.zip.GZIPInputStream r4 = new java.util.zip.GZIPInputStream
            r4.<init>(r3)
            java.io.InputStream r4 = (java.io.InputStream) r4
            return r4
        L69:
            java.lang.String r1 = ""
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L7b
            goto L7a
        L72:
            java.lang.String r1 = "identity"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L7b
        L7a:
            return r3
        L7b:
            java.lang.Object r3 = r5.invoke(r3, r4)
            java.io.InputStream r3 = (java.io.InputStream) r3
            return r3
        L82:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r4 = "null cannot be cast to non-null type java.lang.String"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.kittinunf.fuel.util.DecodeStreamKt.decode(java.io.InputStream, java.lang.String, kotlin.jvm.functions.Function2):java.io.InputStream");
    }

    public static /* synthetic */ InputStream decode$default(InputStream inputStream, Iterable iterable, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = UNSUPPORTED_DECODE_ENCODING;
        }
        return decode(inputStream, (Iterable<String>) iterable, (Function2<? super InputStream, ? super String, ? extends InputStream>) function2);
    }

    public static final InputStream decode(InputStream decode, Iterable<String> encodings, Function2<? super InputStream, ? super String, ? extends InputStream> unsupported) {
        Intrinsics.checkNotNullParameter(decode, "$this$decode");
        Intrinsics.checkNotNullParameter(encodings, "encodings");
        Intrinsics.checkNotNullParameter(unsupported, "unsupported");
        Iterator<String> it = encodings.iterator();
        while (it.hasNext()) {
            decode = decode(decode, it.next(), unsupported);
        }
        return decode;
    }
}
