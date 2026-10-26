package org.eclipse.jgit.internal.storage.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.pack.PackIndexWriter;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.CoreConfig;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.storage.pack.PackConfig;
import org.eclipse.jgit.transport.PackLock;
import org.eclipse.jgit.transport.PackParser;
import org.eclipse.jgit.transport.PackedObjectInfo;
import org.eclipse.jgit.util.NB;

/* INFO: loaded from: classes5.dex */
public class ObjectDirectoryPackParser extends PackParser {
    private final CRC32 crc;
    private final FileObjectDatabase db;
    private Deflater def;
    private int indexVersion;
    private boolean keepEmpty;
    private Pack newPack;
    private long origEnd;
    private byte[] origHash;
    private RandomAccessFile out;
    private long packEnd;
    private byte[] packHash;
    private PackConfig pconfig;
    private final MessageDigest tailDigest;
    private File tmpIdx;
    private File tmpPack;

    @Override // org.eclipse.jgit.transport.PackParser
    protected void onInflatedObjectData(PackedObjectInfo packedObjectInfo, int i, byte[] bArr) throws IOException {
    }

    @Override // org.eclipse.jgit.transport.PackParser
    protected void onPackHeader(long j) throws IOException {
    }

    ObjectDirectoryPackParser(FileObjectDatabase fileObjectDatabase, InputStream inputStream) {
        super(fileObjectDatabase, inputStream);
        this.db = fileObjectDatabase;
        this.pconfig = new PackConfig(fileObjectDatabase.getConfig());
        this.crc = new CRC32();
        this.tailDigest = Constants.newMessageDigest();
        this.indexVersion = ((CoreConfig) fileObjectDatabase.getConfig().get(CoreConfig.KEY)).getPackIndexVersion();
    }

    public void setIndexVersion(int i) {
        this.indexVersion = i;
    }

    public void setKeepEmpty(boolean z) {
        this.keepEmpty = z;
    }

    public Pack getPack() {
        return this.newPack;
    }

    @Override // org.eclipse.jgit.transport.PackParser
    public long getPackSize() {
        Pack pack = this.newPack;
        if (pack == null) {
            return super.getPackSize();
        }
        PackFile packFile = pack.getPackFile();
        long length = packFile.length();
        String absolutePath = packFile.getAbsolutePath();
        File file = new File(absolutePath.substring(0, absolutePath.length() - ".pack".length()) + ".idx");
        return file.isFile() ? length + file.length() : length;
    }

    @Override // org.eclipse.jgit.transport.PackParser
    public PackLock parse(ProgressMonitor progressMonitor, ProgressMonitor progressMonitor2) throws IOException {
        this.tmpPack = File.createTempFile("incoming_", ".pack", this.db.getDirectory());
        this.tmpIdx = new File(this.db.getDirectory(), baseName(this.tmpPack) + ".idx");
        try {
            this.out = new RandomAccessFile(this.tmpPack, "rw");
            super.parse(progressMonitor, progressMonitor2);
            this.out.seek(this.packEnd);
            this.out.write(this.packHash);
            this.out.getChannel().force(true);
            this.out.close();
            writeIdx();
            this.tmpPack.setReadOnly();
            this.tmpIdx.setReadOnly();
            PackLock packLockRenameAndOpenPack = renameAndOpenPack(getLockMessage());
            Deflater deflater = this.def;
            if (deflater != null) {
                deflater.end();
            }
            return packLockRenameAndOpenPack;
        } finally {
            Deflater deflater2 = this.def;
            if (deflater2 != null) {
                deflater2.end();
            }
            try {
                RandomAccessFile randomAccessFile = this.out;
                if (randomAccessFile != null && randomAccessFile.getChannel().isOpen()) {
                    this.out.close();
                }
            } catch (IOException unused) {
            }
            cleanupTemporaryFiles();
        }
    }

    @Override // org.eclipse.jgit.transport.PackParser
    protected void onBeginWholeObject(long j, int i, long j2) throws IOException {
        this.crc.reset();
    }

    @Override // org.eclipse.jgit.transport.PackParser
    protected void onEndWholeObject(PackedObjectInfo packedObjectInfo) throws IOException {
        packedObjectInfo.setCRC((int) this.crc.getValue());
    }

    @Override // org.eclipse.jgit.transport.PackParser
    protected void onBeginOfsDelta(long j, long j2, long j3) throws IOException {
        this.crc.reset();
    }

    @Override // org.eclipse.jgit.transport.PackParser
    protected void onBeginRefDelta(long j, AnyObjectId anyObjectId, long j2) throws IOException {
        this.crc.reset();
    }

    @Override // org.eclipse.jgit.transport.PackParser
    protected PackParser.UnresolvedDelta onEndDelta() throws IOException {
        PackParser.UnresolvedDelta unresolvedDelta = new PackParser.UnresolvedDelta();
        unresolvedDelta.setCRC((int) this.crc.getValue());
        return unresolvedDelta;
    }

    @Override // org.eclipse.jgit.transport.PackParser
    protected void onObjectHeader(PackParser.Source source, byte[] bArr, int i, int i2) throws IOException {
        this.crc.update(bArr, i, i2);
    }

    @Override // org.eclipse.jgit.transport.PackParser
    protected void onObjectData(PackParser.Source source, byte[] bArr, int i, int i2) throws IOException {
        this.crc.update(bArr, i, i2);
    }

    @Override // org.eclipse.jgit.transport.PackParser
    protected void onStoreStream(byte[] bArr, int i, int i2) throws IOException {
        this.out.write(bArr, i, i2);
    }

    @Override // org.eclipse.jgit.transport.PackParser
    protected void onPackFooter(byte[] bArr) throws IOException {
        long filePointer = this.out.getFilePointer();
        this.packEnd = filePointer;
        this.origEnd = filePointer;
        this.origHash = bArr;
        this.packHash = bArr;
    }

    @Override // org.eclipse.jgit.transport.PackParser
    protected PackParser.ObjectTypeAndSize seekDatabase(PackParser.UnresolvedDelta unresolvedDelta, PackParser.ObjectTypeAndSize objectTypeAndSize) throws IOException {
        this.out.seek(unresolvedDelta.getOffset());
        this.crc.reset();
        return readObjectHeader(objectTypeAndSize);
    }

    @Override // org.eclipse.jgit.transport.PackParser
    protected PackParser.ObjectTypeAndSize seekDatabase(PackedObjectInfo packedObjectInfo, PackParser.ObjectTypeAndSize objectTypeAndSize) throws IOException {
        this.out.seek(packedObjectInfo.getOffset());
        this.crc.reset();
        return readObjectHeader(objectTypeAndSize);
    }

    @Override // org.eclipse.jgit.transport.PackParser
    protected int readDatabase(byte[] bArr, int i, int i2) throws IOException {
        return this.out.read(bArr, i, i2);
    }

    @Override // org.eclipse.jgit.transport.PackParser
    protected boolean checkCRC(int i) {
        return i == ((int) this.crc.getValue());
    }

    private static String baseName(File file) {
        String name = file.getName();
        return name.substring(0, name.lastIndexOf(46));
    }

    private void cleanupTemporaryFiles() {
        File file = this.tmpIdx;
        if (file != null && !file.delete() && this.tmpIdx.exists()) {
            this.tmpIdx.deleteOnExit();
        }
        File file2 = this.tmpPack;
        if (file2 == null || file2.delete() || !this.tmpPack.exists()) {
            return;
        }
        this.tmpPack.deleteOnExit();
    }

    @Override // org.eclipse.jgit.transport.PackParser
    protected boolean onAppendBase(int i, byte[] bArr, PackedObjectInfo packedObjectInfo) throws IOException {
        packedObjectInfo.setOffset(this.packEnd);
        byte[] bArrBuffer = buffer();
        int length = bArr.length;
        bArrBuffer[0] = (byte) ((i << 4) | (length & 15));
        int i2 = length >>> 4;
        int i3 = 1;
        while (i2 > 0) {
            int i4 = i3 - 1;
            bArrBuffer[i4] = (byte) (bArrBuffer[i4] | (-128));
            bArrBuffer[i3] = (byte) (i2 & 127);
            i2 >>>= 7;
            i3++;
        }
        this.tailDigest.update(bArrBuffer, 0, i3);
        this.crc.reset();
        this.crc.update(bArrBuffer, 0, i3);
        this.out.seek(this.packEnd);
        this.out.write(bArrBuffer, 0, i3);
        this.packEnd += (long) i3;
        Deflater deflater = this.def;
        if (deflater == null) {
            this.def = new Deflater(-1, false);
        } else {
            deflater.reset();
        }
        this.def.setInput(bArr);
        this.def.finish();
        while (!this.def.finished()) {
            int iDeflate = this.def.deflate(bArrBuffer);
            this.tailDigest.update(bArrBuffer, 0, iDeflate);
            this.crc.update(bArrBuffer, 0, iDeflate);
            this.out.write(bArrBuffer, 0, iDeflate);
            this.packEnd += (long) iDeflate;
        }
        packedObjectInfo.setCRC((int) this.crc.getValue());
        return true;
    }

    @Override // org.eclipse.jgit.transport.PackParser
    protected void onEndThinPack() throws IOException {
        byte[] bArrBuffer = buffer();
        MessageDigest messageDigestNewMessageDigest = Constants.newMessageDigest();
        MessageDigest messageDigestNewMessageDigest2 = Constants.newMessageDigest();
        MessageDigest messageDigestNewMessageDigest3 = Constants.newMessageDigest();
        long j = this.origEnd;
        this.out.seek(0L);
        this.out.readFully(bArrBuffer, 0, 12);
        messageDigestNewMessageDigest.update(bArrBuffer, 0, 12);
        long j2 = j - 12;
        NB.encodeInt32(bArrBuffer, 8, getObjectCount());
        this.out.seek(0L);
        this.out.write(bArrBuffer, 0, 12);
        messageDigestNewMessageDigest3.update(bArrBuffer, 0, 12);
        while (true) {
            int i = this.out.read(bArrBuffer);
            if (i < 0) {
                break;
            }
            if (j2 != 0) {
                int iMin = (int) Math.min(i, j2);
                messageDigestNewMessageDigest.update(bArrBuffer, 0, iMin);
                j2 -= (long) iMin;
                if (j2 == 0) {
                    messageDigestNewMessageDigest2.update(bArrBuffer, iMin, i - iMin);
                }
            } else {
                messageDigestNewMessageDigest2.update(bArrBuffer, 0, i);
            }
            messageDigestNewMessageDigest3.update(bArrBuffer, 0, i);
        }
        if (!Arrays.equals(messageDigestNewMessageDigest.digest(), this.origHash) || !Arrays.equals(messageDigestNewMessageDigest2.digest(), this.tailDigest.digest())) {
            throw new IOException(JGitText.get().packCorruptedWhileWritingToFilesystem);
        }
        this.packHash = messageDigestNewMessageDigest3.digest();
    }

    private void writeIdx() throws IOException {
        PackIndexWriter packIndexWriterCreateVersion;
        Throwable th = null;
        List<PackedObjectInfo> sortedObjectList = getSortedObjectList(null);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(this.tmpIdx);
            try {
                int i = this.indexVersion;
                if (i <= 0) {
                    packIndexWriterCreateVersion = BasePackIndexWriter.createOldestPossible(fileOutputStream, sortedObjectList);
                } else {
                    packIndexWriterCreateVersion = BasePackIndexWriter.createVersion(fileOutputStream, i);
                }
                packIndexWriterCreateVersion.write(sortedObjectList, this.packHash);
                fileOutputStream.getChannel().force(true);
            } finally {
                fileOutputStream.close();
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null == th2) {
                throw null;
            }
            th.addSuppressed(th2);
        }
    }

    /* WARN: Bottom block not found for handler: all -> 0x00e7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private org.eclipse.jgit.transport.PackLock renameAndOpenPack(java.lang.String r11) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 343
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jgit.internal.storage.file.ObjectDirectoryPackParser.renameAndOpenPack(java.lang.String):org.eclipse.jgit.transport.PackLock");
    }
}
