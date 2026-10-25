package org.eclipse.jgit.lib;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.util.IO;

/* JADX INFO: loaded from: classes5.dex */
public class ObjectIdSerializer {
    private static final byte NON_NULL_MARKER = 1;
    private static final byte NULL_MARKER = 0;

    public static void write(OutputStream outputStream, @Nullable AnyObjectId anyObjectId) throws IOException {
        if (anyObjectId != null) {
            outputStream.write(1);
            writeWithoutMarker(outputStream, anyObjectId);
        } else {
            outputStream.write(0);
        }
    }

    public static void writeWithoutMarker(OutputStream outputStream, AnyObjectId anyObjectId) throws IOException {
        anyObjectId.copyRawTo(outputStream);
    }

    @Nullable
    public static ObjectId read(InputStream inputStream) throws IOException {
        byte b = (byte) inputStream.read();
        if (b == 0) {
            return null;
        }
        if (b == 1) {
            return readWithoutMarker(inputStream);
        }
        throw new IOException("Invalid flag before ObjectId: " + ((int) b));
    }

    public static ObjectId readWithoutMarker(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[20];
        IO.readFully(inputStream, bArr, 0, 20);
        return ObjectId.fromRaw(bArr);
    }

    private ObjectIdSerializer() {
    }
}
