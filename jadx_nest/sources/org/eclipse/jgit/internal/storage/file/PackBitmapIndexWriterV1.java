package org.eclipse.jgit.internal.storage.file;

import com.googlecode.javaewah.EWAHCompressedBitmap;
import java.io.BufferedOutputStream;
import java.io.DataOutput;
import java.io.IOException;
import java.io.OutputStream;
import java.security.DigestOutputStream;
import java.text.MessageFormat;
import java.util.Iterator;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.pack.PackBitmapIndexWriter;
import org.eclipse.jgit.lib.Constants;

/* JADX INFO: loaded from: classes5.dex */
public class PackBitmapIndexWriterV1 implements PackBitmapIndexWriter {
    private final DataOutput dataOutput;
    private final DigestOutputStream out;

    public PackBitmapIndexWriterV1(OutputStream outputStream) {
        DigestOutputStream digestOutputStream = new DigestOutputStream(outputStream instanceof BufferedOutputStream ? outputStream : new BufferedOutputStream(outputStream), Constants.newMessageDigest());
        this.out = digestOutputStream;
        this.dataOutput = new SimpleDataOutput(digestOutputStream);
    }

    @Override // org.eclipse.jgit.internal.storage.pack.PackBitmapIndexWriter
    public void write(PackBitmapIndexBuilder packBitmapIndexBuilder, byte[] bArr) throws IOException {
        if (packBitmapIndexBuilder == null || bArr.length != 20) {
            throw new IllegalStateException();
        }
        writeHeader(packBitmapIndexBuilder.getOptions(), packBitmapIndexBuilder.getBitmapCount(), bArr);
        writeBody(packBitmapIndexBuilder);
        writeFooter();
        this.out.flush();
    }

    private void writeHeader(int i, int i2, byte[] bArr) throws IOException {
        this.out.write(PackBitmapIndexV1.MAGIC);
        this.dataOutput.writeShort(1);
        this.dataOutput.writeShort(i);
        this.dataOutput.writeInt(i2);
        this.out.write(bArr);
    }

    private void writeBody(PackBitmapIndexBuilder packBitmapIndexBuilder) throws IOException {
        writeBitmap(packBitmapIndexBuilder.getCommits());
        writeBitmap(packBitmapIndexBuilder.getTrees());
        writeBitmap(packBitmapIndexBuilder.getBlobs());
        writeBitmap(packBitmapIndexBuilder.getTags());
        writeBitmaps(packBitmapIndexBuilder);
    }

    private void writeBitmap(EWAHCompressedBitmap eWAHCompressedBitmap) throws IOException {
        eWAHCompressedBitmap.serialize(this.dataOutput);
    }

    private void writeBitmaps(PackBitmapIndexBuilder packBitmapIndexBuilder) throws IOException {
        Iterator<PackBitmapIndexBuilder.StoredEntry> it = packBitmapIndexBuilder.getCompressedBitmaps().iterator();
        int i = 0;
        while (it.hasNext()) {
            writeBitmapEntry(it.next());
            i++;
        }
        int bitmapCount = packBitmapIndexBuilder.getBitmapCount();
        if (bitmapCount != i) {
            throw new IOException(MessageFormat.format(JGitText.get().expectedGot, String.valueOf(bitmapCount), String.valueOf(i)));
        }
    }

    private void writeBitmapEntry(PackBitmapIndexBuilder.StoredEntry storedEntry) throws IOException {
        this.dataOutput.writeInt((int) storedEntry.getIdxPosition());
        this.out.write(storedEntry.getXorOffset());
        this.out.write(storedEntry.getFlags());
        writeBitmap(storedEntry.getBitmap());
    }

    private void writeFooter() throws IOException {
        this.out.on(false);
        DigestOutputStream digestOutputStream = this.out;
        digestOutputStream.write(digestOutputStream.getMessageDigest().digest());
    }
}
