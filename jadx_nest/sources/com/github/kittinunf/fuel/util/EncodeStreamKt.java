package com.github.kittinunf.fuel.util;

import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: EncodeStream.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u001a\b\u0002\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005¨\u0006\u0006"}, d2 = {"encode", "Ljava/io/OutputStream;", "encoding", "", "unsupported", "Lkotlin/Function2;", "fuel"}, k = 2, mv = {1, 4, 0})
public final class EncodeStreamKt {

    /* INFO: renamed from: com.github.kittinunf.fuel.util.EncodeStreamKt$encode$1, reason: invalid class name */
    /* INFO: compiled from: EncodeStream.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Ljava/io/OutputStream;", "<anonymous parameter 1>", "", "invoke"}, k = 3, mv = {1, 4, 0})
    static final class AnonymousClass1 extends Lambda implements Function2 {
        final /* synthetic */ String $encoding;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str) {
            super(2);
            this.$encoding = str;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Void invoke(OutputStream outputStream, String str) {
            Intrinsics.checkNotNullParameter(outputStream, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
            throw new UnsupportedOperationException("Encoding " + this.$encoding + " is not supported. Expected one of gzip, deflate, identity.");
        }
    }

    public static /* synthetic */ OutputStream encode$default(OutputStream outputStream, String str, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = new AnonymousClass1(str);
        }
        return encode(outputStream, str, function2);
    }

    /* WARN: Code restructure failed: missing block: B:22:0x0059, code lost:
    
        if (r0.equals(org.apache.http.protocol.HTTP.CHUNK_CODING) != false) goto L33;
     */
    /* WARN: Code restructure failed: missing block: B:29:0x0072, code lost:
    
        if (r0.equals("") != false) goto L33;
     */
    /* WARN: Code restructure failed: missing block: B:32:0x007b, code lost:
    
        if (r0.equals(org.apache.http.protocol.HTTP.IDENTITY_CODING) != false) goto L33;
     */
    /* WARN: Code restructure failed: missing block: B:33:0x007d, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.io.OutputStream encode(java.io.OutputStream r3, java.lang.String r4, kotlin.jvm.functions.Function2<? super java.io.OutputStream, ? super java.lang.String, ? extends java.io.OutputStream> r5) {
        /*
            java.lang.String r0 = "$this$encode"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "encoding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "unsupported"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = r4
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.CharSequence r0 = kotlin.text.StringsKt.trim(r0)
            java.lang.String r0 = r0.toString()
            int r1 = r0.hashCode()
            r2 = -135761730(0xfffffffff7e870be, float:-9.428903E33)
            if (r1 == r2) goto L75
            if (r1 == 0) goto L6c
            r2 = 3189082(0x30a95a, float:4.468856E-39)
            if (r1 == r2) goto L5c
            r2 = 757417932(0x2d2547cc, float:9.395106E-12)
            if (r1 == r2) goto L53
            r2 = 1545112619(0x5c188c2b, float:1.7175325E17)
            if (r1 == r2) goto L43
            r2 = 1945326087(0x73f35207, float:3.855566E31)
            if (r1 == r2) goto L3a
            goto L7e
        L3a:
            java.lang.String r1 = "inflate"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L7e
            goto L4b
        L43:
            java.lang.String r1 = "deflate"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L7e
        L4b:
            java.util.zip.DeflaterOutputStream r4 = new java.util.zip.DeflaterOutputStream
            r4.<init>(r3)
            java.io.OutputStream r4 = (java.io.OutputStream) r4
            return r4
        L53:
            java.lang.String r1 = "chunked"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L7e
            goto L7d
        L5c:
            java.lang.String r1 = "gzip"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L7e
            java.util.zip.GZIPOutputStream r4 = new java.util.zip.GZIPOutputStream
            r4.<init>(r3)
            java.io.OutputStream r4 = (java.io.OutputStream) r4
            return r4
        L6c:
            java.lang.String r1 = ""
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L7e
            goto L7d
        L75:
            java.lang.String r1 = "identity"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L7e
        L7d:
            return r3
        L7e:
            java.lang.Object r3 = r5.invoke(r3, r4)
            java.io.OutputStream r3 = (java.io.OutputStream) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.kittinunf.fuel.util.EncodeStreamKt.encode(java.io.OutputStream, java.lang.String, kotlin.jvm.functions.Function2):java.io.OutputStream");
    }
}
