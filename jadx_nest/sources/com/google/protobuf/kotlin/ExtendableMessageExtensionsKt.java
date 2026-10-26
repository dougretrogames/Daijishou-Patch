package com.google.protobuf.kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.google.protobuf.ExtensionLite;
import com.google.protobuf.GeneratedMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: ExtendableMessageExtensions.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aD\u0010\u0000\u001a\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u0005*\u0002H\u00042\u0010\u0010\u0006\u001a\f\u0012\u0004\u0012\u0002H\u0002\u0012\u0002\b\u00030\u0007H\u0086\u0002¢\u0006\u0002\u0010\b\u001aP\u0010\t\u001a\u0002H\n\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u0005\"\b\b\u0002\u0010\n*\u00020\u000b*\u0002H\u00042\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0007H\u0086\u0002¢\u0006\u0002\u0010\f\u001a^\u0010\r\u001a\u00020\u000e\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0014\b\u0001\u0010\u000f*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000f0\u0010\"\b\b\u0002\u0010\n*\u00020\u000b*\u0002H\u000f2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u00072\u0006\u0010\u0011\u001a\u0002H\nH\u0086\u0002¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"contains", "", "M", "Lcom/google/protobuf/GeneratedMessage$ExtendableMessage;", "MorBT", "Lcom/google/protobuf/GeneratedMessage$ExtendableMessageOrBuilder;", "extension", "Lcom/google/protobuf/ExtensionLite;", "(Lcom/google/protobuf/GeneratedMessage$ExtendableMessageOrBuilder;Lcom/google/protobuf/ExtensionLite;)Z", "get", ExifInterface.GPS_DIRECTION_TRUE, "", "(Lcom/google/protobuf/GeneratedMessage$ExtendableMessageOrBuilder;Lcom/google/protobuf/ExtensionLite;)Ljava/lang/Object;", "set", "", "B", "Lcom/google/protobuf/GeneratedMessage$ExtendableBuilder;", "value", "(Lcom/google/protobuf/GeneratedMessage$ExtendableBuilder;Lcom/google/protobuf/ExtensionLite;Ljava/lang/Object;)V", "java_kotlin-full_extensions"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ExtendableMessageExtensionsKt {
    public static final <M extends GeneratedMessage.ExtendableMessage<M>, B extends GeneratedMessage.ExtendableBuilder<M, B>, T> void set(B b, ExtensionLite<M, T> extension, T value) {
        Intrinsics.checkNotNullParameter(b, "<this>");
        Intrinsics.checkNotNullParameter(extension, "extension");
        Intrinsics.checkNotNullParameter(value, "value");
        b.setExtension(extension, value);
    }

    public static final <M extends GeneratedMessage.ExtendableMessage<M>, MorBT extends GeneratedMessage.ExtendableMessageOrBuilder<M>, T> T get(MorBT morbt, ExtensionLite<M, T> extension) {
        Intrinsics.checkNotNullParameter(morbt, "<this>");
        Intrinsics.checkNotNullParameter(extension, "extension");
        T t = (T) morbt.getExtension(extension);
        Intrinsics.checkNotNullExpressionValue(t, "getExtension(extension)");
        return t;
    }

    public static final <M extends GeneratedMessage.ExtendableMessage<M>, MorBT extends GeneratedMessage.ExtendableMessageOrBuilder<M>> boolean contains(MorBT morbt, ExtensionLite<M, ?> extension) {
        Intrinsics.checkNotNullParameter(morbt, "<this>");
        Intrinsics.checkNotNullParameter(extension, "extension");
        return morbt.hasExtension(extension);
    }
}
