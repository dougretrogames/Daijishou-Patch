package org.eclipse.jgit.internal.storage.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.text.MessageFormat;
import java.util.Arrays;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.util.IO;
import org.eclipse.jgit.util.io.SilentFileInputStream;

/* JADX INFO: loaded from: classes5.dex */
public final class PackReverseIndexFactory {
    static PackReverseIndex openOrCompute(File file, long j, PackBitmapIndex.SupplierWithIOException<PackIndex> supplierWithIOException) throws IOException {
        Throwable th = null;
        try {
            SilentFileInputStream silentFileInputStream = new SilentFileInputStream(file);
            try {
                return readFromFile(silentFileInputStream, j, supplierWithIOException);
            } finally {
                silentFileInputStream.close();
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null != th2) {
                try {
                    th.addSuppressed(th2);
                } catch (FileNotFoundException unused) {
                    return computeFromIndex(supplierWithIOException.get());
                } catch (IOException e) {
                    throw new IOException(MessageFormat.format(JGitText.get().unreadablePackIndex, file.getAbsolutePath()), e);
                }
            }
            throw null;
        }
    }

    public static PackReverseIndex computeFromIndex(PackIndex packIndex) {
        return new PackReverseIndexComputed(packIndex);
    }

    static PackReverseIndex readFromFile(InputStream inputStream, long j, PackBitmapIndex.SupplierWithIOException<PackIndex> supplierWithIOException) throws IOException {
        DigestInputStream digestInputStream = new DigestInputStream(inputStream, Constants.newMessageDigest());
        byte[] bArr = new byte[PackReverseIndex.MAGIC.length];
        IO.readFully(digestInputStream, bArr);
        if (!Arrays.equals(bArr, PackReverseIndex.MAGIC)) {
            throw new IOException(MessageFormat.format(JGitText.get().expectedGot, Arrays.toString(PackReverseIndex.MAGIC), Arrays.toString(bArr)));
        }
        int i = new SimpleDataInput(digestInputStream).readInt();
        if (i == 1) {
            return new PackReverseIndexV1(digestInputStream, j, supplierWithIOException);
        }
        throw new IOException(MessageFormat.format(JGitText.get().unsupportedPackReverseIndexVersion, String.valueOf(i)));
    }
}
