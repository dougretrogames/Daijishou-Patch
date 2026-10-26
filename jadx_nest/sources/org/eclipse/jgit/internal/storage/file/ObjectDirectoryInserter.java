package org.eclipse.jgit.internal.storage.file;

import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.text.MessageFormat;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import org.eclipse.jgit.errors.ObjectWritingException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectInserter;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.transport.PackParser;
import org.eclipse.jgit.util.FileUtils;
import org.eclipse.jgit.util.IO;
import org.eclipse.jgit.util.sha1.SHA1;

/* INFO: loaded from: classes5.dex */
class ObjectDirectoryInserter extends ObjectInserter {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$internal$storage$file$FileObjectDatabase$InsertLooseObjectResult;
    private final WriteConfig config;
    private final FileObjectDatabase db;
    private Deflater deflate;

    @Override // org.eclipse.jgit.lib.ObjectInserter
    public void flush() throws IOException {
    }

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$internal$storage$file$FileObjectDatabase$InsertLooseObjectResult() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$internal$storage$file$FileObjectDatabase$InsertLooseObjectResult;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[FileObjectDatabase.InsertLooseObjectResult.valuesCustom().length];
        try {
            iArr2[FileObjectDatabase.InsertLooseObjectResult.EXISTS_LOOSE.ordinal()] = 3;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[FileObjectDatabase.InsertLooseObjectResult.EXISTS_PACKED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[FileObjectDatabase.InsertLooseObjectResult.FAILURE.ordinal()] = 4;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[FileObjectDatabase.InsertLooseObjectResult.INSERTED.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$internal$storage$file$FileObjectDatabase$InsertLooseObjectResult = iArr2;
        return iArr2;
    }

    ObjectDirectoryInserter(FileObjectDatabase fileObjectDatabase, Config config) {
        this.db = fileObjectDatabase;
        this.config = (WriteConfig) config.get(WriteConfig.KEY);
    }

    @Override // org.eclipse.jgit.lib.ObjectInserter
    public ObjectId insert(int i, byte[] bArr, int i2, int i3) throws IOException {
        return insert(i, bArr, i2, i3, false);
    }

    private ObjectId insert(int i, byte[] bArr, int i2, int i3, boolean z) throws IOException {
        ObjectId objectIdIdFor = idFor(i, bArr, i2, i3);
        return (z || !this.db.has(objectIdIdFor)) ? insertOneObject(toTemp(i, bArr, i2, i3), objectIdIdFor, z) : objectIdIdFor;
    }

    @Override // org.eclipse.jgit.lib.ObjectInserter
    public ObjectId insert(int i, long j, InputStream inputStream) throws IOException {
        return insert(i, j, inputStream, false);
    }

    ObjectId insert(int i, long j, InputStream inputStream, boolean z) throws IOException {
        if (j <= buffer().length) {
            byte[] bArrBuffer = buffer();
            return insert(i, bArrBuffer, 0, IO.readFully(inputStream, bArrBuffer, 0), z);
        }
        SHA1 sha1Digest = digest();
        return insertOneObject(toTemp(sha1Digest, i, j, inputStream), sha1Digest.toObjectId(), z);
    }

    private ObjectId insertOneObject(File file, ObjectId objectId, boolean z) throws IOException {
        int i = $SWITCH_TABLE$org$eclipse$jgit$internal$storage$file$FileObjectDatabase$InsertLooseObjectResult()[this.db.insertUnpackedObject(file, objectId, z).ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return objectId;
        }
        throw new ObjectWritingException(MessageFormat.format(JGitText.get().unableToCreateNewObject, this.db.fileFor(objectId)));
    }

    @Override // org.eclipse.jgit.lib.ObjectInserter
    public PackParser newPackParser(InputStream inputStream) throws IOException {
        return new ObjectDirectoryPackParser(this.db, inputStream);
    }

    @Override // org.eclipse.jgit.lib.ObjectInserter
    public ObjectReader newReader() {
        return new WindowCursor(this.db, this);
    }

    @Override // org.eclipse.jgit.lib.ObjectInserter, java.lang.AutoCloseable
    public void close() {
        Deflater deflater = this.deflate;
        if (deflater != null) {
            try {
                deflater.end();
            } finally {
                this.deflate = null;
            }
        }
    }

    private File toTemp(SHA1 sha1, int i, long j, InputStream inputStream) throws Throwable {
        FileOutputStream fileOutputStream;
        File fileNewTempFile = newTempFile();
        boolean z = true;
        Throwable th = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(fileNewTempFile);
                try {
                    DeflaterOutputStream deflaterOutputStreamCompress = compress(this.config.getFSyncObjectFiles() ? Channels.newOutputStream(fileOutputStream.getChannel()) : fileOutputStream);
                    SHA1OutputStream sHA1OutputStream = new SHA1OutputStream(deflaterOutputStreamCompress, sha1);
                    writeHeader(sHA1OutputStream, i, j);
                    byte[] bArrBuffer = buffer();
                    while (j > 0) {
                        int i2 = inputStream.read(bArrBuffer, 0, (int) Math.min(j, bArrBuffer.length));
                        if (i2 <= 0) {
                            throw shortInput(j);
                        }
                        sHA1OutputStream.write(bArrBuffer, 0, i2);
                        j -= (long) i2;
                    }
                    sHA1OutputStream.flush();
                    deflaterOutputStreamCompress.finish();
                    if (this.config.getFSyncObjectFiles()) {
                        fileOutputStream.getChannel().force(true);
                    }
                    try {
                        fileOutputStream.close();
                        return fileNewTempFile;
                    } catch (Throwable th2) {
                        th = th2;
                        z = false;
                        if (0 == 0) {
                            throw th;
                        }
                        if (null != th) {
                            try {
                                th.addSuppressed(th);
                            } catch (Throwable th3) {
                                if (z) {
                                    FileUtils.delete(fileNewTempFile, 6);
                                }
                                throw th3;
                            }
                        }
                        throw null;
                    }
                } catch (Throwable th4) {
                    if (this.config.getFSyncObjectFiles()) {
                        fileOutputStream.getChannel().force(true);
                    }
                    throw th4;
                }
            } catch (Throwable th5) {
                fileOutputStream.close();
                throw th5;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private File toTemp(int i, byte[] bArr, int i2, int i3) throws Throwable {
        File fileNewTempFile = newTempFile();
        boolean z = true;
        Throwable th = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileNewTempFile);
            try {
                try {
                    DeflaterOutputStream deflaterOutputStreamCompress = compress(this.config.getFSyncObjectFiles() ? Channels.newOutputStream(fileOutputStream.getChannel()) : fileOutputStream);
                    writeHeader(deflaterOutputStreamCompress, i, i3);
                    deflaterOutputStreamCompress.write(bArr, i2, i3);
                    deflaterOutputStreamCompress.finish();
                    if (this.config.getFSyncObjectFiles()) {
                        fileOutputStream.getChannel().force(true);
                    }
                    try {
                        fileOutputStream.close();
                        return fileNewTempFile;
                    } catch (Throwable th2) {
                        th = th2;
                        z = false;
                        if (0 == 0) {
                            throw th;
                        }
                        if (null != th) {
                            try {
                                th.addSuppressed(th);
                            } catch (Throwable th3) {
                                if (z) {
                                    FileUtils.delete(fileNewTempFile, 6);
                                }
                                throw th3;
                            }
                        }
                        throw null;
                    }
                } catch (Throwable th4) {
                    if (this.config.getFSyncObjectFiles()) {
                        fileOutputStream.getChannel().force(true);
                    }
                    throw th4;
                }
            } catch (Throwable th5) {
                fileOutputStream.close();
                throw th5;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    void writeHeader(OutputStream outputStream, int i, long j) throws IOException {
        outputStream.write(Constants.encodedTypeString(i));
        outputStream.write(32);
        outputStream.write(Constants.encodeASCII(j));
        outputStream.write(0);
    }

    File newTempFile() throws IOException {
        return File.createTempFile("noz", null, this.db.getDirectory());
    }

    DeflaterOutputStream compress(OutputStream outputStream) {
        Deflater deflater = this.deflate;
        if (deflater == null) {
            this.deflate = new Deflater(this.config.getCompression());
        } else {
            deflater.reset();
        }
        return new DeflaterOutputStream(outputStream, this.deflate, 8192);
    }

    private static EOFException shortInput(long j) {
        return new EOFException(MessageFormat.format(JGitText.get().inputDidntMatchLength, Long.valueOf(j)));
    }

    private static class SHA1OutputStream extends FilterOutputStream {
        private final SHA1 md;

        SHA1OutputStream(OutputStream outputStream, SHA1 sha1) {
            super(outputStream);
            this.md = sha1;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) throws IOException {
            this.md.update((byte) i);
            this.out.write(i);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.md.update(bArr, i, i2);
            this.out.write(bArr, i, i2);
        }
    }
}
