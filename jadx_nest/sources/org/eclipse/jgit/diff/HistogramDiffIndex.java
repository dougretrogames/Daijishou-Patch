package org.eclipse.jgit.diff;

import org.eclipse.jgit.diff.Sequence;
import org.eclipse.jgit.internal.JGitText;

/* JADX INFO: loaded from: classes5.dex */
final class HistogramDiffIndex<S extends Sequence> {
    private static final int MAX_CNT = 255;
    private static final int MAX_PTR = 268435455;
    private static final int REC_CNT_MASK = 255;
    private static final int REC_NEXT_SHIFT = 36;
    private static final int REC_PTR_MASK = 268435455;
    private static final int REC_PTR_SHIFT = 8;
    private final HashedSequence<S> a;
    private final HashedSequence<S> b;
    private final HashedSequenceComparator<S> cmp;
    private int cnt;
    private boolean hasCommon;
    private final int keyShift;
    private Edit lcs;
    private final int maxChainLength;
    private int[] next;
    private int ptrShift;
    private int recCnt;
    private int[] recIdx;
    private long[] recs;
    private final Edit region;
    private final int[] table;

    private static int recCnt(long j) {
        return ((int) j) & 255;
    }

    private static long recCreate(int i, int i2, int i3) {
        return (((long) i2) << 8) | (((long) i) << 36) | ((long) i3);
    }

    private static int recNext(long j) {
        return (int) (j >>> 36);
    }

    private static int recPtr(long j) {
        return ((int) (j >>> 8)) & 268435455;
    }

    HistogramDiffIndex(int i, HashedSequenceComparator<S> hashedSequenceComparator, HashedSequence<S> hashedSequence, HashedSequence<S> hashedSequence2, Edit edit) {
        this.maxChainLength = i;
        this.cmp = hashedSequenceComparator;
        this.a = hashedSequence;
        this.b = hashedSequence2;
        this.region = edit;
        if (edit.endA >= 268435455) {
            throw new IllegalArgumentException(JGitText.get().sequenceTooLargeForDiffAlgorithm);
        }
        int lengthA = edit.getLengthA();
        int iTableBits = tableBits(lengthA);
        this.table = new int[1 << iTableBits];
        this.keyShift = 32 - iTableBits;
        this.ptrShift = edit.beginA;
        this.recs = new long[Math.max(4, lengthA >>> 3)];
        this.next = new int[lengthA];
        this.recIdx = new int[lengthA];
    }

    Edit findLongestCommonSequence() {
        if (!scanA()) {
            return null;
        }
        this.lcs = new Edit(0, 0);
        this.cnt = this.maxChainLength + 1;
        int iTryLongestCommonSequence = this.region.beginB;
        while (iTryLongestCommonSequence < this.region.endB) {
            iTryLongestCommonSequence = tryLongestCommonSequence(iTryLongestCommonSequence);
        }
        if (!this.hasCommon || this.maxChainLength >= this.cnt) {
            return this.lcs;
        }
        return null;
    }

    private boolean scanA() {
        for (int i = this.region.endA - 1; this.region.beginA <= i; i--) {
            int iHash = hash(this.a, i);
            int iRecNext = this.table[iHash];
            int i2 = 0;
            while (true) {
                if (iRecNext != 0) {
                    long j = this.recs[iRecNext];
                    if (this.cmp.equals((HashedSequence) this.a, recPtr(j), (HashedSequence) this.a, i)) {
                        int iRecCnt = recCnt(j) + 1;
                        if (255 < iRecCnt) {
                            iRecCnt = 255;
                        }
                        this.recs[iRecNext] = recCreate(recNext(j), i, iRecCnt);
                        this.next[i - this.ptrShift] = recPtr(j);
                        this.recIdx[i - this.ptrShift] = iRecNext;
                        break;
                    }
                    iRecNext = recNext(j);
                    i2++;
                } else {
                    if (i2 != this.maxChainLength) {
                        int i3 = this.recCnt + 1;
                        this.recCnt = i3;
                        long[] jArr = this.recs;
                        if (i3 == jArr.length) {
                            long[] jArr2 = new long[Math.min(jArr.length << 1, this.region.getLengthA() + 1)];
                            long[] jArr3 = this.recs;
                            System.arraycopy(jArr3, 0, jArr2, 0, jArr3.length);
                            this.recs = jArr2;
                        }
                        this.recs[i3] = recCreate(this.table[iHash], i, 1);
                        this.recIdx[i - this.ptrShift] = i3;
                        this.table[iHash] = i3;
                        break;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private int tryLongestCommonSequence(int i) {
        int i2 = i + 1;
        int iRecNext = this.table[hash(this.b, i)];
        int i3 = i2;
        while (iRecNext != 0) {
            long j = this.recs[iRecNext];
            if (recCnt(j) > this.cnt) {
                if (!this.hasCommon) {
                    this.hasCommon = this.cmp.equals((HashedSequence) this.a, recPtr(j), (HashedSequence) this.b, i);
                }
            } else {
                int iRecPtr = recPtr(j);
                if (this.cmp.equals((HashedSequence) this.a, iRecPtr, (HashedSequence) this.b, i)) {
                    this.hasCommon = true;
                    while (true) {
                        int i4 = this.next[iRecPtr - this.ptrShift];
                        int i5 = iRecPtr + 1;
                        int iRecCnt = recCnt(j);
                        int i6 = i;
                        while (this.region.beginA < iRecPtr && this.region.beginB < i6 && this.cmp.equals((HashedSequence) this.a, iRecPtr - 1, (HashedSequence) this.b, i6 - 1)) {
                            iRecPtr--;
                            i6--;
                            if (1 < iRecCnt) {
                                iRecCnt = Math.min(iRecCnt, recCnt(this.recs[this.recIdx[iRecPtr - this.ptrShift]]));
                            }
                        }
                        int i7 = i2;
                        while (i5 < this.region.endA && i7 < this.region.endB && this.cmp.equals((HashedSequence) this.a, i5, (HashedSequence) this.b, i7)) {
                            if (1 < iRecCnt) {
                                iRecCnt = Math.min(iRecCnt, recCnt(this.recs[this.recIdx[i5 - this.ptrShift]]));
                            }
                            i5++;
                            i7++;
                        }
                        if (i3 < i7) {
                            i3 = i7;
                        }
                        if (this.lcs.getLengthA() < i5 - iRecPtr || iRecCnt < this.cnt) {
                            this.lcs.beginA = iRecPtr;
                            this.lcs.beginB = i6;
                            this.lcs.endA = i5;
                            this.lcs.endB = i7;
                            this.cnt = iRecCnt;
                        }
                        if (i4 == 0) {
                            break;
                        }
                        iRecPtr = i4;
                        while (iRecPtr < i5) {
                            iRecPtr = this.next[iRecPtr - this.ptrShift];
                            if (iRecPtr == 0) {
                                break;
                            }
                        }
                    }
                }
            }
            iRecNext = recNext(j);
        }
        return i3;
    }

    private int hash(HashedSequence<S> hashedSequence, int i) {
        return (this.cmp.hash((HashedSequence) hashedSequence, i) * (-1640562687)) >>> this.keyShift;
    }

    private static int tableBits(int i) {
        int iNumberOfLeadingZeros = 31 - Integer.numberOfLeadingZeros(i);
        if (iNumberOfLeadingZeros == 0) {
            iNumberOfLeadingZeros = 1;
        }
        return (1 << iNumberOfLeadingZeros) < i ? iNumberOfLeadingZeros + 1 : iNumberOfLeadingZeros;
    }
}
