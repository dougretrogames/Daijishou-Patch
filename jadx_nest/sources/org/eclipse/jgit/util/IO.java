package org.eclipse.jgit.util;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.util.io.SilentFileInputStream;

/* JADX INFO: loaded from: classes5.dex */
public class IO {
    public static final byte[] readFully(File file) throws IOException {
        return readFully(file, Integer.MAX_VALUE);
    }

    public static final byte[] readSome(File file, int i) throws IOException {
        Throwable th = null;
        try {
            SilentFileInputStream silentFileInputStream = new SilentFileInputStream(file);
            try {
                return silentFileInputStream.readNBytes(i);
            } finally {
                silentFileInputStream.close();
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null != th2) {
                th.addSuppressed(th2);
            }
            throw null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Throwable] */
    public static final byte[] readFully(File file, int i) throws IOException {
        ?? r0 = 0;
        r0 = 0;
        try {
            SilentFileInputStream silentFileInputStream = new SilentFileInputStream(file);
            try {
                byte[] nBytes = silentFileInputStream.readNBytes(i);
                if (silentFileInputStream.read() == -1) {
                    return nBytes;
                }
                r0 = JGitText.get().fileIsTooLarge;
                throw new IOException(MessageFormat.format(r0, file));
            } finally {
                silentFileInputStream.close();
            }
        } catch (Throwable th) {
            if (r0 == 0) {
                throw th;
            }
            if (r0 != th) {
                r0.addSuppressed(th);
            }
            throw r0;
        }
    }

    public static ByteBuffer readWholeStream(InputStream inputStream, int i) throws IOException {
        return ByteBuffer.wrap(inputStream.readAllBytes());
    }

    public static void readFully(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        if (inputStream.readNBytes(bArr, i, i2) != i2) {
            throw new EOFException(JGitText.get().shortReadOfBlock);
        }
    }

    public static void readFully(InputStream inputStream, byte[] bArr) throws IOException {
        readFully(inputStream, bArr, 0, bArr.length);
    }

    public static int read(ReadableByteChannel readableByteChannel, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        if (i2 == 0) {
            return 0;
        }
        while (i2 > 0) {
            int i4 = readableByteChannel.read(ByteBuffer.wrap(bArr, i, i2));
            if (i4 <= 0) {
                break;
            }
            i += i4;
            i2 -= i4;
            i3 += i4;
        }
        if (i3 != 0) {
            return i3;
        }
        return -1;
    }

    public static int readFully(InputStream inputStream, byte[] bArr, int i) throws IOException {
        return inputStream.readNBytes(bArr, i, bArr.length - i);
    }

    public static void skipFully(InputStream inputStream, long j) throws IOException {
        while (j > 0) {
            long jSkip = inputStream.skip(j);
            if (jSkip <= 0) {
                throw new EOFException(JGitText.get().shortSkipOfBlock);
            }
            j -= jSkip;
        }
    }

    public static List<String> readLines(String str) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\n') {
                arrayList.add(sb.toString());
                sb.setLength(0);
            } else if (cCharAt == '\r') {
                i++;
                if (i < str.length()) {
                    char cCharAt2 = str.charAt(i);
                    arrayList.add(sb.toString());
                    sb.setLength(0);
                    if (cCharAt2 != '\n') {
                        sb.append(cCharAt2);
                    }
                } else {
                    arrayList.add(sb.toString());
                    break;
                }
            } else {
                sb.append(cCharAt);
            }
            i++;
        }
        arrayList.add(sb.toString());
        return arrayList;
    }

    public static String readLine(Reader reader, int i) throws IOException {
        StringBuilder sb;
        char c;
        if (reader.markSupported()) {
            if (i <= 0) {
                i = 1024;
            }
            int i2 = i;
            StringBuilder sb2 = new StringBuilder(i2);
            char[] cArr = new char[i2];
            while (true) {
                reader.mark(i2);
                int i3 = reader.read(cArr);
                if (i3 < 0) {
                    reader.reset();
                    return sb2.toString();
                }
                for (int i4 = 0; i4 < i3; i4++) {
                    if (cArr[i4] == '\n') {
                        int i5 = i4 + 1;
                        resetAndSkipFully(reader, i5);
                        sb2.append(cArr, 0, i5);
                        return sb2.toString();
                    }
                }
                if (i3 > 0) {
                    sb2.append(cArr, 0, i3);
                }
                resetAndSkipFully(reader, i3);
            }
        } else {
            if (i > 0) {
                sb = new StringBuilder(i);
            } else {
                sb = new StringBuilder();
            }
            do {
                int i6 = reader.read();
                if (i6 == -1) {
                    break;
                }
                c = (char) i6;
                sb.append(c);
            } while (c != '\n');
            return sb.toString();
        }
    }

    private static void resetAndSkipFully(Reader reader, long j) throws IOException {
        reader.reset();
        while (j > 0) {
            long jSkip = reader.skip(j);
            if (jSkip <= 0) {
                throw new EOFException(JGitText.get().shortSkipOfBlock);
            }
            j -= jSkip;
        }
    }

    private IO() {
    }
}
