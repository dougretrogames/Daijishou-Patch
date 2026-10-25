package org.eclipse.jgit.internal.storage.file;

import java.io.DataInput;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.security.DigestInputStream;
import java.text.MessageFormat;
import java.util.Arrays;
import org.eclipse.jgit.errors.CorruptObjectException;
import org.eclipse.jgit.errors.PackMismatchException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.pack.PackExt;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.util.Hex;
import org.eclipse.jgit.util.IO;

/* JADX INFO: loaded from: classes5.dex */
final class PackReverseIndexV1 implements PackReverseIndex {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int OID_VERSION_SHA1 = 1;
    static final int OID_VERSION_SHA256 = 2;
    private static final int SHA1_BYTES = 20;
    private final DataInput dataIn;
    private int[] indexPositionsSortedByOffset;
    private final DigestInputStream inputStream;
    private int objectCount;
    private byte[] packChecksum;
    private PackIndex packIndex;
    private final PackBitmapIndex.SupplierWithIOException<PackIndex> packIndexSupplier;

    PackReverseIndexV1(DigestInputStream digestInputStream, long j, PackBitmapIndex.SupplierWithIOException<PackIndex> supplierWithIOException) throws IOException {
        try {
            this.objectCount = Math.toIntExact(j);
            this.inputStream = digestInputStream;
            SimpleDataInput simpleDataInput = new SimpleDataInput(digestInputStream);
            this.dataIn = simpleDataInput;
            int i = simpleDataInput.readInt();
            if (i != 1) {
                if (i == 2) {
                    throw new IOException(MessageFormat.format(JGitText.get().unsupportedObjectIdVersion, "SHA256"));
                }
                throw new IOException(MessageFormat.format(JGitText.get().unsupportedObjectIdVersion, String.valueOf(i)));
            }
            this.indexPositionsSortedByOffset = new int[this.objectCount];
            this.packIndexSupplier = supplierWithIOException;
            parseBody();
            parseChecksums();
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException(JGitText.get().hugeIndexesAreNotSupportedByJgitYet, e);
        }
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackReverseIndex
    public void verifyPackChecksum(String str) throws PackMismatchException {
        if (!Arrays.equals(this.packChecksum, getPackIndex().getChecksum())) {
            throw new PackMismatchException(MessageFormat.format(JGitText.get().packChecksumMismatch, str, PackExt.INDEX.getExtension(), Hex.toHexString(getPackIndex().getChecksum()), PackExt.REVERSE_INDEX.getExtension(), Hex.toHexString(this.packChecksum)));
        }
    }

    private void parseBody() throws IOException {
        for (int i = 0; i < this.objectCount; i++) {
            this.indexPositionsSortedByOffset[i] = this.dataIn.readInt();
        }
    }

    private void parseChecksums() throws IOException {
        byte[] bArr = new byte[20];
        this.packChecksum = bArr;
        IO.readFully(this.inputStream, bArr);
        byte[] bArrDigest = this.inputStream.getMessageDigest().digest();
        byte[] bArr2 = new byte[20];
        IO.readFully(this.inputStream, bArr2);
        if (!Arrays.equals(bArr2, bArrDigest)) {
            throw new CorruptObjectException(MessageFormat.format(JGitText.get().corruptReverseIndexChecksumIncorrect, Hex.toHexString(bArr2), Hex.toHexString(bArrDigest)));
        }
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackReverseIndex
    public ObjectId findObject(long j) {
        int iFindPosition = findPosition(j);
        if (iFindPosition < 0) {
            return null;
        }
        return getPackIndex().getObjectId(findForwardPositionByReversePosition(iFindPosition));
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackReverseIndex
    public long findNextOffset(long j, long j2) throws CorruptObjectException {
        int iFindPosition = findPosition(j);
        if (iFindPosition < 0) {
            throw new CorruptObjectException(MessageFormat.format(JGitText.get().cantFindObjectInReversePackIndexForTheSpecifiedOffset, Long.valueOf(j)));
        }
        int i = iFindPosition + 1;
        return i == this.objectCount ? j2 : findOffsetByReversePosition(i);
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackReverseIndex
    public int findPosition(long j) {
        return binarySearchByOffset(j);
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackReverseIndex
    public ObjectId findObjectByPosition(int i) {
        return getPackIndex().getObjectId(findForwardPositionByReversePosition(i));
    }

    private long findOffsetByReversePosition(int i) {
        return getPackIndex().getOffset(findForwardPositionByReversePosition(i));
    }

    private int findForwardPositionByReversePosition(int i) {
        return this.indexPositionsSortedByOffset[i];
    }

    private int binarySearchByOffset(long j) {
        int i = this.objectCount - 1;
        int i2 = 0;
        while (i2 <= i) {
            int i3 = (i2 + i) >>> 1;
            long jFindOffsetByReversePosition = findOffsetByReversePosition(i3);
            if (jFindOffsetByReversePosition == j) {
                return i3;
            }
            if (jFindOffsetByReversePosition > j) {
                i = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private PackIndex getPackIndex() {
        if (this.packIndex == null) {
            try {
                this.packIndex = this.packIndexSupplier.get();
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }
        return this.packIndex;
    }
}
