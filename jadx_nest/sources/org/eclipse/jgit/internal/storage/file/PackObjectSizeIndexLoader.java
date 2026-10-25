package org.eclipse.jgit.internal.storage.file;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Arrays;
import org.eclipse.jgit.internal.JGitText;

/* JADX INFO: loaded from: classes5.dex */
public class PackObjectSizeIndexLoader {
    public static PackObjectSizeIndex load(InputStream inputStream) throws IOException {
        byte[] nBytes = inputStream.readNBytes(4);
        if (!Arrays.equals(nBytes, PackObjectSizeIndexWriter.HEADER)) {
            throw new IOException(MessageFormat.format(JGitText.get().unreadableObjectSizeIndex, Integer.valueOf(nBytes.length), Arrays.toString(nBytes)));
        }
        byte b = inputStream.readNBytes(1)[0];
        if (b != 1) {
            throw new IOException(MessageFormat.format(JGitText.get().unsupportedObjectSizeIndexVersion, Integer.valueOf(b)));
        }
        return PackObjectSizeIndexV1.parse(inputStream);
    }
}
