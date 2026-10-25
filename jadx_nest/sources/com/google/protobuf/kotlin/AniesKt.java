package com.google.protobuf.kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.google.protobuf.Any;
import com.google.protobuf.Message;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Anies.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u0004H\u0086\b\u001a\u001e\u0010\u0005\u001a\u0002H\u0002\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u0004H\u0086\b¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"isA", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/google/protobuf/Message;", "Lcom/google/protobuf/Any;", "unpack", "(Lcom/google/protobuf/Any;)Lcom/google/protobuf/Message;", "java_kotlin-full_extensions"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AniesKt {
    public static final /* synthetic */ <T extends Message> boolean isA(Any any) {
        Intrinsics.checkNotNullParameter(any, "<this>");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return any.is(Message.class);
    }

    public static final /* synthetic */ <T extends Message> T unpack(Any any) {
        Intrinsics.checkNotNullParameter(any, "<this>");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        T t = (T) any.unpack(Message.class);
        Intrinsics.checkNotNullExpressionValue(t, "unpack(T::class.java)");
        return t;
    }
}
