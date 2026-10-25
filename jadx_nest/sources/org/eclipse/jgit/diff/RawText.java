package org.eclipse.jgit.diff;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.jgit.errors.BinaryBlobException;
import org.eclipse.jgit.errors.LargeObjectException;
import org.eclipse.jgit.lib.ObjectLoader;
import org.eclipse.jgit.lib.ObjectStream;
import org.eclipse.jgit.util.IO;
import org.eclipse.jgit.util.IntList;
import org.eclipse.jgit.util.RawParseUtils;

/* JADX INFO: loaded from: classes5.dex */
public class RawText extends Sequence {
    private static final int FIRST_FEW_BYTES = 8192;
    protected final byte[] content;
    protected final IntList lines;
    public static final RawText EMPTY_TEXT = new RawText(new byte[0]);
    private static final AtomicInteger BUFFER_SIZE = new AtomicInteger(8192);

    public static boolean isBinary(byte b, byte b2) {
        if (b != 0) {
            return (b != 10 && b2 == 13) || b2 == 0;
        }
        return true;
    }

    static /* synthetic */ int lambda$0(int i, int i2) {
        return i;
    }

    public RawText(byte[] bArr) {
        this(bArr, RawParseUtils.lineMap(bArr, 0, bArr.length));
    }

    public RawText(byte[] bArr, IntList intList) {
        this.content = bArr;
        this.lines = intList;
    }

    public RawText(File file) throws IOException {
        this(IO.readFully(file));
    }

    public byte[] getRawContent() {
        return this.content;
    }

    @Override // org.eclipse.jgit.diff.Sequence
    public int size() {
        return this.lines.size() - 2;
    }

    public void writeLine(OutputStream outputStream, int i) throws IOException {
        int start = getStart(i);
        int end = getEnd(i);
        byte[] bArr = this.content;
        if (bArr[end - 1] == 10) {
            end--;
        }
        outputStream.write(bArr, start, end - start);
    }

    public boolean isMissingNewlineAtEnd() {
        IntList intList = this.lines;
        int i = intList.get(intList.size() - 1);
        return i == 0 || this.content[i - 1] != 10;
    }

    public String getString(int i) {
        return getString(i, i + 1, true);
    }

    public ByteBuffer getRawString(int i) {
        int start = getStart(i);
        int end = getEnd(i);
        if (end > 0 && this.content[end - 1] == 10) {
            end--;
        }
        return ByteBuffer.wrap(this.content, start, end - start);
    }

    public String getString(int i, int i2, boolean z) {
        if (i == i2) {
            return "";
        }
        int start = getStart(i);
        int end = getEnd(i2 - 1);
        if (z && this.content[end - 1] == 10) {
            end--;
        }
        return decode(start, end);
    }

    protected String decode(int i, int i2) {
        return RawParseUtils.decode(this.content, i, i2);
    }

    private int getStart(int i) {
        return this.lines.get(i + 1);
    }

    private int getEnd(int i) {
        return this.lines.get(i + 2);
    }

    public static int getBufferSize() {
        return BUFFER_SIZE.get();
    }

    public static int setBufferSize(int i) {
        return BUFFER_SIZE.updateAndGet(new RawText$$ExternalSyntheticLambda0(Math.max(8192, i)));
    }

    public static boolean isBinary(InputStream inputStream) throws IOException {
        int bufferSize = getBufferSize() + 1;
        byte[] bArr = new byte[bufferSize];
        int i = 0;
        while (i < bufferSize) {
            int i2 = inputStream.read(bArr, i, bufferSize - i);
            if (i2 == -1) {
                break;
            }
            i += i2;
        }
        return isBinary(bArr, i, i < bufferSize);
    }

    public static boolean isBinary(byte[] bArr) {
        return isBinary(bArr, bArr.length);
    }

    public static boolean isBinary(byte[] bArr, int i) {
        return isBinary(bArr, i, false);
    }

    public static boolean isBinary(byte[] bArr, int i, boolean z) {
        int bufferSize = getBufferSize();
        if (i > bufferSize) {
            i = bufferSize;
            z = false;
        }
        int i2 = -1;
        while (true) {
            int i3 = i - 2;
            if (i2 >= i3) {
                if (i2 != i3) {
                    return false;
                }
                byte b = bArr[i2 + 1];
                return b == 0 || (b == 13 && z);
            }
            int i4 = i2 + 1;
            byte b2 = bArr[i4];
            if (b2 != 0) {
                if (b2 == 13) {
                    i2 += 2;
                    if (bArr[i2] != 10) {
                    }
                } else {
                    i2 = i4;
                }
            }
            return true;
        }
    }

    public static boolean isCrLfText(byte[] bArr) {
        return isCrLfText(bArr, bArr.length);
    }

    public static boolean isCrLfText(InputStream inputStream) throws IOException {
        int bufferSize = getBufferSize();
        byte[] bArr = new byte[bufferSize];
        int i = 0;
        while (i < bufferSize) {
            int i2 = inputStream.read(bArr, i, bufferSize - i);
            if (i2 == -1) {
                break;
            }
            i += i2;
        }
        return isCrLfText(bArr, i);
    }

    public static boolean isCrLfText(byte[] bArr, int i) {
        return isCrLfText(bArr, i, false);
    }

    public static boolean isCrLfText(byte[] bArr, int i, boolean z) {
        byte b;
        int i2 = -1;
        boolean z2 = false;
        while (true) {
            int i3 = i - 2;
            if (i2 >= i3) {
                if (i2 == i3 && ((b = bArr[i2 + 1]) == 0 || (b == 13 && z))) {
                    return false;
                }
                return z2;
            }
            int i4 = i2 + 1;
            byte b2 = bArr[i4];
            if (b2 == 0) {
                return false;
            }
            if (b2 == 13) {
                i2 += 2;
                if (bArr[i2] != 10) {
                    return false;
                }
                z2 = true;
            } else {
                i2 = i4;
            }
        }
    }

    public String getLineDelimiter() {
        if (size() == 0) {
            return null;
        }
        int end = getEnd(0);
        byte[] bArr = this.content;
        if (bArr[end - 1] != 10) {
            return null;
        }
        if (bArr.length > 1 && end > 1 && bArr[end - 2] == 13) {
            return "\r\n";
        }
        return "\n";
    }

    public static RawText load(ObjectLoader objectLoader, int i) throws IOException, BinaryBlobException {
        long size = objectLoader.getSize();
        if (size > i) {
            throw new BinaryBlobException();
        }
        int bufferSize = getBufferSize();
        if (size <= bufferSize) {
            byte[] cachedBytes = objectLoader.getCachedBytes(bufferSize);
            if (isBinary(cachedBytes, cachedBytes.length, true)) {
                throw new BinaryBlobException();
            }
            return new RawText(cachedBytes);
        }
        byte[] bArr = new byte[bufferSize];
        Throwable th = null;
        try {
            ObjectStream objectStreamOpenStream = objectLoader.openStream();
            byte b = 120;
            int i2 = bufferSize;
            int i3 = 0;
            while (i2 > 0) {
                try {
                    int i4 = objectStreamOpenStream.read(bArr, i3, i2);
                    if (i4 < 0) {
                        throw new EOFException();
                    }
                    i2 -= i4;
                    while (i4 > 0) {
                        byte b2 = bArr[i3];
                        if (isBinary(b2, b)) {
                            throw new BinaryBlobException();
                        }
                        i3++;
                        i4--;
                        b = b2;
                    }
                } catch (Throwable th2) {
                    if (objectStreamOpenStream == null) {
                        throw th2;
                    }
                    objectStreamOpenStream.close();
                    throw th2;
                }
            }
            int i5 = (int) size;
            try {
                byte[] bArr2 = new byte[i5];
                System.arraycopy(bArr, 0, bArr2, 0, bufferSize);
                IO.readFully(objectStreamOpenStream, bArr2, i3, (int) (size - ((long) i3)));
                RawText rawText = new RawText(bArr2, RawParseUtils.lineMapOrBinary(bArr2, 0, i5));
                if (objectStreamOpenStream != null) {
                    objectStreamOpenStream.close();
                }
                return rawText;
            } catch (OutOfMemoryError e) {
                throw new LargeObjectException.OutOfMemory(e);
            }
        } catch (Throwable th3) {
            if (0 == 0) {
                throw th3;
            }
            if (null != th3) {
                th.addSuppressed(th3);
            }
            throw null;
        }
    }
}
