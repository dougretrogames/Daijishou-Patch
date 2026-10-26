package com.magneticchen.daijishou.daijishou_debug_service.passive_protocol;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.activities.MainActivity;
import com.magneticchen.daijishou.daijishou_uri.DaijishouUriHandler;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* INFO: compiled from: ClientOperation.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH¦@¢\u0006\u0002\u0010\u001eJ\u0006\u0010\u001f\u001a\u00020\u0012J\u000e\u0010 \u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010!\u001a\u00020\"2\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010#\u001a\u00020$J\u0016\u0010%\u001a\u00020&2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R\u0015\u0010\u0014\u001a\u00060\u0015R\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006("}, d2 = {"Lcom/magneticchen/daijishou/daijishou_debug_service/passive_protocol/ClientOperation;", "", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "(Lcom/magneticchen/daijishou/DaijishouApplication;)V", "getApplication", "()Lcom/magneticchen/daijishou/DaijishouApplication;", "buffer32Bytes", "", "daijishouUriHandler", "Lcom/magneticchen/daijishou/daijishou_uri/DaijishouUriHandler;", "getDaijishouUriHandler", "()Lcom/magneticchen/daijishou/daijishou_uri/DaijishouUriHandler;", "headerByteCode", "", "getHeaderByteCode", "()B", "isMainActivityRequired", "", "()Z", "logger", "Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "getLogger", "()Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "handleDataStreams", "", "dataInputStream", "Ljava/io/DataInputStream;", "dataOutputStream", "Ljava/io/DataOutputStream;", "(Ljava/io/DataInputStream;Ljava/io/DataOutputStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isMainActivitySatisfied", "read32BytesFromDataInputStream", "readStringFromDataInputStream", "", "requireMainActivity", "Lcom/magneticchen/daijishou/activities/MainActivity;", "writeStringToDataOutputStream", "", TypedValues.Custom.S_STRING, "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class ClientOperation {
    private final DaijishouApplication application;
    private final byte[] buffer32Bytes;
    private final DaijishouUriHandler daijishouUriHandler;
    private final DaijishouApplication.WrappedLogger logger;

    public abstract byte getHeaderByteCode();

    public abstract Object handleDataStreams(DataInputStream dataInputStream, DataOutputStream dataOutputStream, Continuation<?> continuation);

    /* INFO: renamed from: isMainActivityRequired */
    public abstract boolean getIsMainActivityRequired();

    public ClientOperation(DaijishouApplication application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.application = application;
        this.logger = application.getLogger();
        this.buffer32Bytes = new byte[32];
        this.daijishouUriHandler = application.getDaijishouUriHandler();
    }

    public final DaijishouApplication getApplication() {
        return this.application;
    }

    public final DaijishouApplication.WrappedLogger getLogger() {
        return this.logger;
    }

    public final DaijishouUriHandler getDaijishouUriHandler() {
        return this.daijishouUriHandler;
    }

    public final MainActivity requireMainActivity() {
        MainActivity mainActivity = this.application.getMainActivity();
        Intrinsics.checkNotNull(mainActivity);
        return mainActivity;
    }

    public final String readStringFromDataInputStream(DataInputStream dataInputStream) throws IOException {
        Intrinsics.checkNotNullParameter(dataInputStream, "dataInputStream");
        int i = dataInputStream.readInt();
        if (i == 0) {
            return "";
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            i2 += dataInputStream.read(bArr, i2, i - i2);
        }
        return StringsKt.decodeToString(bArr);
    }

    public final int writeStringToDataOutputStream(DataOutputStream dataOutputStream, String string) {
        Intrinsics.checkNotNullParameter(dataOutputStream, "dataOutputStream");
        Intrinsics.checkNotNullParameter(string, "string");
        int length = string.length();
        try {
            dataOutputStream.write(ByteBuffer.allocate(4).putInt(length).array());
            if (length > 0) {
                dataOutputStream.write(StringsKt.encodeToByteArray(string));
            }
        } catch (java.io.IOException e) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(e);
        }
        return length + 4;
    }

    public final byte[] read32BytesFromDataInputStream(DataInputStream dataInputStream) {
        Intrinsics.checkNotNullParameter(dataInputStream, "dataInputStream");
        int i = 0;
        try {
            while (i < 32) {
                i += dataInputStream.read(this.buffer32Bytes, i, 32 - i);
            }
        } catch (java.io.IOException e) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(e);
        }
        byte[] bArr = this.buffer32Bytes;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    public final boolean isMainActivitySatisfied() {
        return (getIsMainActivityRequired() && this.application.getMainActivity() == null) ? false : true;
    }
}
