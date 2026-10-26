package org.eclipse.jgit.internal.storage.file;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.AbbreviatedObjectId;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.util.IO;
import org.eclipse.jgit.util.NB;

/* INFO: loaded from: classes5.dex */
class PackIndexV1 implements PackIndex {
    private static final int IDX_HDR_LEN = 1024;
    private static final int RECORD_SIZE = 24;
    private final long[] idxHeader;
    byte[][] idxdata;
    private long objectCnt;
    protected byte[] packChecksum;

    private static int idOffset(int i) {
        return (i * 24) + 4;
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackIndex
    public boolean hasCRC32Support() {
        return false;
    }

    PackIndexV1(InputStream inputStream, byte[] bArr) throws IOException {
        long[] jArr;
        long j;
        byte[] bArr2 = new byte[1024];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        IO.readFully(inputStream, bArr2, bArr.length, 1024 - bArr.length);
        this.idxHeader = new long[256];
        int i = 0;
        while (true) {
            jArr = this.idxHeader;
            if (i >= jArr.length) {
                break;
            }
            jArr[i] = NB.decodeUInt32(bArr2, i * 4);
            i++;
        }
        this.idxdata = new byte[jArr.length][];
        int i2 = 0;
        while (true) {
            long[] jArr2 = this.idxHeader;
            if (i2 >= jArr2.length) {
                this.objectCnt = jArr2[255];
                byte[] bArr3 = new byte[20];
                this.packChecksum = bArr3;
                IO.readFully(inputStream, bArr3, 0, bArr3.length);
                return;
            }
            if (i2 == 0) {
                j = jArr2[i2];
            } else {
                j = jArr2[i2] - jArr2[i2 - 1];
            }
            if (j > 0) {
                long j2 = j * 24;
                if (j2 > 2147483639) {
                    throw new IOException(JGitText.get().indexFileIsTooLargeForJgit);
                }
                byte[] bArr4 = new byte[(int) j2];
                this.idxdata[i2] = bArr4;
                IO.readFully(inputStream, bArr4, 0, bArr4.length);
            }
            i2++;
        }
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackIndex
    public long getObjectCount() {
        return this.objectCnt;
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackIndex
    public long getOffset64Count() {
        Iterator<PackIndex.MutableEntry> it = iterator();
        long j = 0;
        while (it.hasNext()) {
            if (it.next().getOffset() >= 2147483647L) {
                j++;
            }
        }
        return j;
    }

    private int findLevelOne(long j) {
        int iBinarySearch = Arrays.binarySearch(this.idxHeader, j + 1);
        if (iBinarySearch < 0) {
            return -(iBinarySearch + 1);
        }
        long j2 = this.idxHeader[iBinarySearch];
        while (iBinarySearch > 0 && j2 == this.idxHeader[iBinarySearch - 1]) {
            iBinarySearch--;
        }
        return iBinarySearch;
    }

    private int getLevelTwo(long j, int i) {
        return (int) (j - (i > 0 ? this.idxHeader[i - 1] : 0L));
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackIndex
    public ObjectId getObjectId(long j) {
        int iFindLevelOne = findLevelOne(j);
        return ObjectId.fromRaw(this.idxdata[iFindLevelOne], idOffset(getLevelTwo(j, iFindLevelOne)));
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackIndex
    public long getOffset(long j) {
        int iFindLevelOne = findLevelOne(j);
        return NB.decodeUInt32(this.idxdata[iFindLevelOne], getLevelTwo(j, iFindLevelOne) * 24);
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackIndex
    public long findOffset(AnyObjectId anyObjectId) {
        byte[] bArr = this.idxdata[anyObjectId.getFirstByte()];
        int iLevelTwoPosition = levelTwoPosition(anyObjectId, bArr);
        if (iLevelTwoPosition < 0) {
            return -1L;
        }
        return (((long) (bArr[iLevelTwoPosition - 4] & 255)) << 24) | ((long) ((bArr[iLevelTwoPosition - 3] & 255) << 16)) | ((long) ((bArr[iLevelTwoPosition - 2] & 255) << 8)) | ((long) (bArr[iLevelTwoPosition - 1] & 255));
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackIndex
    public int findPosition(AnyObjectId anyObjectId) {
        int firstByte = anyObjectId.getFirstByte();
        int iLevelTwoPosition = levelTwoPosition(anyObjectId, this.idxdata[firstByte]);
        if (iLevelTwoPosition < 0) {
            return -1;
        }
        return ((int) (firstByte == 0 ? 0L : this.idxHeader[firstByte - 1])) + ((iLevelTwoPosition - 4) / 24);
    }

    private int levelTwoPosition(AnyObjectId anyObjectId, byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            int length = bArr.length / 24;
            int i = 0;
            do {
                int i2 = (i + length) >>> 1;
                int iIdOffset = idOffset(i2);
                int iCompareTo = anyObjectId.compareTo(bArr, iIdOffset);
                if (iCompareTo < 0) {
                    length = i2;
                } else {
                    if (iCompareTo == 0) {
                        return iIdOffset;
                    }
                    i = i2 + 1;
                }
            } while (i < length);
        }
        return -1;
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackIndex
    public long findCRC32(AnyObjectId anyObjectId) {
        throw new UnsupportedOperationException();
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackIndex, java.lang.Iterable
    public Iterator<PackIndex.MutableEntry> iterator() {
        return new EntriesIteratorV1(this, null);
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackIndex
    public void resolve(Set<ObjectId> set, AbbreviatedObjectId abbreviatedObjectId, int i) throws IOException {
        byte[] bArr = this.idxdata[abbreviatedObjectId.getFirstByte()];
        if (bArr == null) {
            return;
        }
        int length = bArr.length / 24;
        int i2 = 0;
        int i3 = length;
        do {
            int i4 = (i2 + i3) >>> 1;
            int iPrefixCompare = abbreviatedObjectId.prefixCompare(bArr, idOffset(i4));
            if (iPrefixCompare < 0) {
                i3 = i4;
            } else {
                if (iPrefixCompare == 0) {
                    while (i4 > 0 && abbreviatedObjectId.prefixCompare(bArr, idOffset(i4 - 1)) == 0) {
                        i4--;
                    }
                    while (i4 < length && abbreviatedObjectId.prefixCompare(bArr, idOffset(i4)) == 0) {
                        set.add(ObjectId.fromRaw(bArr, idOffset(i4)));
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

    @Override // org.eclipse.jgit.internal.storage.file.PackIndex
    public byte[] getChecksum() {
        return this.packChecksum;
    }

    private static class EntriesIteratorV1 extends PackIndex.EntriesIterator {
        private int levelOne;
        private int levelTwo;
        private final PackIndexV1 packIndex;

        /* synthetic */ EntriesIteratorV1(PackIndexV1 packIndexV1, PackIndexV1IA packIndexV1IA) {
            this(packIndexV1);
        }

        private EntriesIteratorV1(PackIndexV1 packIndexV1) {
            super(packIndexV1.objectCnt);
            this.packIndex = packIndexV1;
        }

        @Override // org.eclipse.jgit.internal.storage.file.PackIndex.EntriesIterator
        protected void readNext() {
            while (this.levelOne < this.packIndex.idxdata.length) {
                if (this.packIndex.idxdata[this.levelOne] != null) {
                    if (this.levelTwo < this.packIndex.idxdata[this.levelOne].length) {
                        super.setOffset(NB.decodeUInt32(this.packIndex.idxdata[this.levelOne], this.levelTwo));
                        this.levelTwo += 24;
                        super.setIdBuffer(this.packIndex.idxdata[this.levelOne], this.levelTwo - 20);
                        return;
                    }
                    this.levelTwo = 0;
                }
                this.levelOne++;
            }
            throw new NoSuchElementException();
        }
    }
}
