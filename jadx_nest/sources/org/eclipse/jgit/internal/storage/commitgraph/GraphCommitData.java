package org.eclipse.jgit.internal.storage.commitgraph;

import java.text.MessageFormat;
import java.util.Arrays;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.util.NB;

/* INFO: loaded from: classes5.dex */
class GraphCommitData {
    private static final int[] NO_PARENTS = new int[0];
    private final int commitDataLength;
    private final byte[] data;
    private final byte[] extraList;
    private final int hashLength;

    GraphCommitData(int i, byte[] bArr, byte[] bArr2) {
        this.data = bArr;
        this.extraList = bArr2;
        this.hashLength = i;
        this.commitDataLength = i + 16;
    }

    CommitGraph.CommitData getCommitData(int i) {
        int i2 = this.commitDataLength * i;
        ObjectId objectIdFromRaw = ObjectId.fromRaw(this.data, i2);
        long jDecodeUInt32 = ((NB.decodeUInt32(this.data, (this.hashLength + i2) + 8) & 3) << 32) | NB.decodeUInt32(this.data, this.hashLength + i2 + 12);
        int iDecodeInt32 = NB.decodeInt32(this.data, (this.hashLength + i2) + 8) >> 2;
        int iDecodeInt33 = NB.decodeInt32(this.data, this.hashLength + i2);
        if (iDecodeInt33 == 1879048192) {
            return new CommitDataImpl(objectIdFromRaw, NO_PARENTS, jDecodeUInt32, iDecodeInt32);
        }
        int iDecodeInt34 = NB.decodeInt32(this.data, i2 + this.hashLength + 4);
        if (iDecodeInt34 == 1879048192) {
            return new CommitDataImpl(objectIdFromRaw, new int[]{iDecodeInt33}, jDecodeUInt32, iDecodeInt32);
        }
        if ((Integer.MIN_VALUE & iDecodeInt34) == 0) {
            return new CommitDataImpl(objectIdFromRaw, new int[]{iDecodeInt33, iDecodeInt34}, jDecodeUInt32, iDecodeInt32);
        }
        return new CommitDataImpl(objectIdFromRaw, findParentsForOctopusMerge(iDecodeInt33, iDecodeInt34 & Integer.MAX_VALUE), jDecodeUInt32, iDecodeInt32);
    }

    private int[] findParentsForOctopusMerge(int i, int i2) {
        int length = this.extraList.length - 4;
        int i3 = i2 * 4;
        if (i3 < 0 || i3 > length) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().invalidExtraEdgeListPosition, Integer.valueOf(i2)));
        }
        int[] iArrCopyOf = new int[32];
        iArrCopyOf[0] = i;
        int i4 = 1;
        while (i3 <= length) {
            if (i4 >= iArrCopyOf.length) {
                iArrCopyOf = Arrays.copyOf(iArrCopyOf, iArrCopyOf.length + 32);
            }
            int iDecodeInt32 = NB.decodeInt32(this.extraList, i3);
            if ((Integer.MIN_VALUE & iDecodeInt32) != 0) {
                iArrCopyOf[i4] = Integer.MAX_VALUE & iDecodeInt32;
                i4++;
                break;
            }
            iArrCopyOf[i4] = iDecodeInt32;
            i3 += 4;
            i4++;
        }
        return Arrays.copyOf(iArrCopyOf, i4);
    }

    private static class CommitDataImpl implements CommitGraph.CommitData {
        private final long commitTime;
        private final int generation;
        private final int[] parents;
        private final ObjectId tree;

        public CommitDataImpl(ObjectId objectId, int[] iArr, long j, int i) {
            this.tree = objectId;
            this.parents = iArr;
            this.commitTime = j;
            this.generation = i;
        }

        @Override // org.eclipse.jgit.internal.storage.commitgraph.CommitGraph.CommitData
        public ObjectId getTree() {
            return this.tree;
        }

        @Override // org.eclipse.jgit.internal.storage.commitgraph.CommitGraph.CommitData
        public int[] getParents() {
            return this.parents;
        }

        @Override // org.eclipse.jgit.internal.storage.commitgraph.CommitGraph.CommitData
        public long getCommitTime() {
            return this.commitTime;
        }

        @Override // org.eclipse.jgit.internal.storage.commitgraph.CommitGraph.CommitData
        public int getGeneration() {
            return this.generation;
        }
    }
}
