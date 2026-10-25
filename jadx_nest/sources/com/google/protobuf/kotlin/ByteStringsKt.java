package com.google.protobuf.kotlin;

import com.google.protobuf.ByteString;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: ByteStrings.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\u0002\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0002\u001a\u0015\u0010\u0007\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0086\u0002\u001a\n\u0010\t\u001a\u00020\u0002*\u00020\n\u001a\n\u0010\t\u001a\u00020\u0002*\u00020\u000b\u001a\n\u0010\f\u001a\u00020\u0002*\u00020\r¨\u0006\u000e"}, d2 = {"get", "", "Lcom/google/protobuf/ByteString;", ConfigConstants.CONFIG_INDEX_SECTION, "", "isNotEmpty", "", "plus", "other", "toByteString", "Ljava/nio/ByteBuffer;", "", "toByteStringUtf8", "", "java_kotlin-bytestring_lib"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ByteStringsKt {
    public static final ByteString toByteStringUtf8(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8(str);
        Intrinsics.checkNotNullExpressionValue(byteStringCopyFromUtf8, "copyFromUtf8(this)");
        return byteStringCopyFromUtf8;
    }

    public static final ByteString plus(ByteString byteString, ByteString other) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        ByteString byteStringConcat = byteString.concat(other);
        Intrinsics.checkNotNullExpressionValue(byteStringConcat, "concat(other)");
        return byteStringConcat;
    }

    public static final byte get(ByteString byteString, int i) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return byteString.byteAt(i);
    }

    public static final boolean isNotEmpty(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return !byteString.isEmpty();
    }

    public static final ByteString toByteString(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        ByteString byteStringCopyFrom = ByteString.copyFrom(bArr);
        Intrinsics.checkNotNullExpressionValue(byteStringCopyFrom, "copyFrom(this)");
        return byteStringCopyFrom;
    }

    public static final ByteString toByteString(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        ByteString byteStringCopyFrom = ByteString.copyFrom(byteBuffer);
        Intrinsics.checkNotNullExpressionValue(byteStringCopyFrom, "copyFrom(this)");
        return byteStringCopyFrom;
    }
}
