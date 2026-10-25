package org.eclipse.jgit.internal.storage.file;

import androidx.core.os.EnvironmentCompat;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.AbbreviatedObjectId;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.util.IO;
import org.eclipse.jgit.util.NB;

/* JADX INFO: loaded from: classes5.dex */
class PackIndexV2 implements PackIndex {
    private static final int FANOUT = 256;
    private static final long IS_O64 = 2147483648L;
    private byte[][] crc32;
    private final long[] fanoutTable;
    int[][] names;
    private long objectCnt;
    byte[][] offset32;
    byte[] offset64;
    protected byte[] packChecksum;
    private static final int[] NO_INTS = new int[0];
    private static final byte[] NO_BYTES = new byte[0];

    private static int idOffset(int i) {
        return (i << 2) + i;
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackIndex
    public boolean hasCRC32Support() {
        return true;
    }

    PackIndexV2(InputStream inputStream) throws IOException {
        long j;
        byte[] bArr = new byte[1024];
        IO.readFully(inputStream, bArr, 0, 1024);
        this.fanoutTable = new long[256];
        for (int i = 0; i < 256; i++) {
            this.fanoutTable[i] = NB.decodeUInt32(bArr, i * 4);
        }
        this.objectCnt = this.fanoutTable[255];
        this.names = new int[256][];
        this.offset32 = new byte[256][];
        this.crc32 = new byte[256][];
        for (int i2 = 0; i2 < 256; i2++) {
            if (i2 == 0) {
                j = this.fanoutTable[i2];
            } else {
                long[] jArr = this.fanoutTable;
                j = jArr[i2] - jArr[i2 - 1];
            }
            if (j == 0) {
                this.names[i2] = NO_INTS;
                byte[][] bArr2 = this.offset32;
                byte[] bArr3 = NO_BYTES;
                bArr2[i2] = bArr3;
                this.crc32[i2] = bArr3;
            } else {
                if (j < 0) {
                    throw new IOException(MessageFormat.format(JGitText.get().indexFileCorruptedNegativeBucketCount, Long.valueOf(j)));
                }
                long j2 = 20 * j;
                if (j2 > 2147483639) {
                    throw new IOException(JGitText.get().indexFileIsTooLargeForJgit);
                }
                int i3 = (int) j2;
                byte[] bArr4 = new byte[i3];
                int i4 = i3 >>> 2;
                int[] iArr = new int[i4];
                IO.readFully(inputStream, bArr4, 0, i3);
                for (int i5 = 0; i5 < i4; i5++) {
                    iArr[i5] = NB.decodeInt32(bArr4, i5 << 2);
                }
                this.names[i2] = iArr;
                int i6 = (int) (j * 4);
                this.offset32[i2] = new byte[i6];
                this.crc32[i2] = new byte[i6];
            }
        }
        for (int i7 = 0; i7 < 256; i7++) {
            byte[] bArr5 = this.crc32[i7];
            IO.readFully(inputStream, bArr5, 0, bArr5.length);
        }
        int i8 = 0;
        for (int i9 = 0; i9 < 256; i9++) {
            byte[] bArr6 = this.offset32[i9];
            IO.readFully(inputStream, bArr6, 0, bArr6.length);
            for (int i10 = 0; i10 < bArr6.length; i10 += 4) {
                if (bArr6[i10] < 0) {
                    i8++;
                }
            }
        }
        if (i8 > 0) {
            byte[] bArr7 = new byte[i8 * 8];
            this.offset64 = bArr7;
            IO.readFully(inputStream, bArr7, 0, bArr7.length);
        } else {
            this.offset64 = NO_BYTES;
        }
        byte[] bArr8 = new byte[20];
        this.packChecksum = bArr8;
        IO.readFully(inputStream, bArr8, 0, bArr8.length);
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackIndex
    public long getObjectCount() {
        return this.objectCnt;
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackIndex
    public long getOffset64Count() {
        return this.offset64.length / 8;
    }

    private int findLevelOne(long j) {
        int iBinarySearch = Arrays.binarySearch(this.fanoutTable, j + 1);
        if (iBinarySearch < 0) {
            return -(iBinarySearch + 1);
        }
        long j2 = this.fanoutTable[iBinarySearch];
        while (iBinarySearch > 0 && j2 == this.fanoutTable[iBinarySearch - 1]) {
            iBinarySearch--;
        }
        return iBinarySearch;
    }

    private int getLevelTwo(long j, int i) {
        return (int) (j - (i > 0 ? this.fanoutTable[i - 1] : 0L));
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackIndex
    public ObjectId getObjectId(long j) {
        int iFindLevelOne = findLevelOne(j);
        int levelTwo = getLevelTwo(j, iFindLevelOne);
        return ObjectId.fromRaw(this.names[iFindLevelOne], (levelTwo << 2) + levelTwo);
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackIndex
    public long getOffset(long j) {
        int iFindLevelOne = findLevelOne(j);
        return getOffset(iFindLevelOne, getLevelTwo(j, iFindLevelOne));
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackIndex
    public long findOffset(AnyObjectId anyObjectId) {
        int firstByte = anyObjectId.getFirstByte();
        int iBinarySearchLevelTwo = binarySearchLevelTwo(anyObjectId, firstByte);
        if (iBinarySearchLevelTwo == -1) {
            return -1L;
        }
        return getOffset(firstByte, iBinarySearchLevelTwo);
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackIndex
    public int findPosition(AnyObjectId anyObjectId) {
        int firstByte = anyObjectId.getFirstByte();
        int iBinarySearchLevelTwo = binarySearchLevelTwo(anyObjectId, firstByte);
        if (iBinarySearchLevelTwo < 0) {
            return -1;
        }
        return ((int) (firstByte == 0 ? 0L : this.fanoutTable[firstByte - 1])) + iBinarySearchLevelTwo;
    }

    private long getOffset(int i, int i2) {
        long jDecodeUInt32 = NB.decodeUInt32(this.offset32[i], i2 << 2);
        return (IS_O64 & jDecodeUInt32) != 0 ? NB.decodeUInt64(this.offset64, ((int) (jDecodeUInt32 & (-2147483649L))) * 8) : jDecodeUInt32;
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackIndex
    public long findCRC32(AnyObjectId anyObjectId) throws MissingObjectException {
        int firstByte = anyObjectId.getFirstByte();
        int iBinarySearchLevelTwo = binarySearchLevelTwo(anyObjectId, firstByte);
        if (iBinarySearchLevelTwo == -1) {
            throw new MissingObjectException(anyObjectId.copy(), EnvironmentCompat.MEDIA_UNKNOWN);
        }
        return NB.decodeUInt32(this.crc32[firstByte], iBinarySearchLevelTwo << 2);
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackIndex, java.lang.Iterable
    public Iterator<PackIndex.MutableEntry> iterator() {
        return new EntriesIteratorV2(this, null);
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackIndex
    public void resolve(Set<ObjectId> set, AbbreviatedObjectId abbreviatedObjectId, int i) throws IOException {
        int[] iArr = this.names[abbreviatedObjectId.getFirstByte()];
        int length = this.offset32[abbreviatedObjectId.getFirstByte()].length >>> 2;
        if (length == 0) {
            return;
        }
        int i2 = 0;
        int i3 = length;
        do {
            int i4 = (i2 + i3) >>> 1;
            int iPrefixCompare = abbreviatedObjectId.prefixCompare(iArr, idOffset(i4));
            if (iPrefixCompare < 0) {
                i3 = i4;
            } else {
                if (iPrefixCompare == 0) {
                    while (i4 > 0 && abbreviatedObjectId.prefixCompare(iArr, idOffset(i4 - 1)) == 0) {
                        i4--;
                    }
                    while (i4 < length && abbreviatedObjectId.prefixCompare(iArr, idOffset(i4)) == 0) {
                        set.add(ObjectId.fromRaw(iArr, idOffset(i4)));
                        if (set.size() > i) {
                            return;
                        } else {
                            i4++;
                        }
                    }
                    return;
                }
                i2 = i4 + 1;
            }
        } while (i2 < i3);
    }

    private int binarySearchLevelTwo(AnyObjectId anyObjectId, int i) {
        int[] iArr = this.names[i];
        int length = this.offset32[i].length >>> 2;
        if (length == 0) {
            return -1;
        }
        int i2 = 0;
        do {
            int i3 = (i2 + length) >>> 1;
            int iCompareTo = anyObjectId.compareTo(iArr, (i3 << 2) + i3);
            if (iCompareTo < 0) {
                length = i3;
            } else {
                if (iCompareTo == 0) {
                    return i3;
                }
                i2 = i3 + 1;
            }
        } while (i2 < length);
        return -1;
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackIndex
    public byte[] getChecksum() {
        return this.packChecksum;
    }

    private static class EntriesIteratorV2 extends PackIndex.EntriesIterator {
        private int levelOne;
        private int levelTwo;
        private final PackIndexV2 packIndex;

        /* synthetic */ EntriesIteratorV2(PackIndexV2 packIndexV2, PackIndexV2IA packIndexV2IA) {
            this(packIndexV2);
        }

        private EntriesIteratorV2(PackIndexV2 packIndexV2) {
            super(packIndexV2.objectCnt);
            this.levelOne = 0;
            this.levelTwo = 0;
            this.packIndex = packIndexV2;
        }

        @Override // org.eclipse.jgit.internal.storage.file.PackIndex.EntriesIterator
        protected void readNext() {
            while (this.levelOne < this.packIndex.names.length) {
                int i = this.levelTwo;
                int[][] iArr = this.packIndex.names;
                int i2 = this.levelOne;
                if (i < iArr[i2].length) {
                    long jDecodeUInt32 = NB.decodeUInt32(this.packIndex.offset32[this.levelOne], (this.levelTwo / 5) * 4);
                    if ((PackIndexV2.IS_O64 & jDecodeUInt32) != 0) {
                        jDecodeUInt32 = NB.decodeUInt64(this.packIndex.offset64, ((int) (jDecodeUInt32 & (-2147483649L))) * 8);
                    }
                    super.setOffset(jDecodeUInt32);
                    this.levelTwo += 5;
                    super.setIdBuffer(this.packIndex.names[this.levelOne], this.levelTwo - 5);
                    return;
                }
                this.levelTwo = 0;
                this.levelOne = i2 + 1;
            }
            throw new NoSuchElementException();
        }
    }
}
