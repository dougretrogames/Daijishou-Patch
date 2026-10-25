package org.eclipse.jgit.internal.storage.commitgraph;

import java.text.MessageFormat;
import org.eclipse.jgit.internal.JGitText;

/* JADX INFO: loaded from: classes5.dex */
class CommitGraphBuilder {
    private byte[] bloomFilterData;
    private byte[] bloomFilterIndex;
    private byte[] commitData;
    private byte[] extraList;
    private final int hashLength;
    private byte[] oidFanout;
    private byte[] oidLookup;

    static CommitGraphBuilder builder() {
        return new CommitGraphBuilder(20);
    }

    private CommitGraphBuilder(int i) {
        this.hashLength = i;
    }

    CommitGraphBuilder addOidFanout(byte[] bArr) throws CommitGraphFormatException {
        assertChunkNotSeenYet(this.oidFanout, 1330201670);
        this.oidFanout = bArr;
        return this;
    }

    CommitGraphBuilder addOidLookUp(byte[] bArr) throws CommitGraphFormatException {
        assertChunkNotSeenYet(this.oidLookup, 1330201676);
        this.oidLookup = bArr;
        return this;
    }

    CommitGraphBuilder addCommitData(byte[] bArr) throws CommitGraphFormatException {
        assertChunkNotSeenYet(this.commitData, 1128546644);
        this.commitData = bArr;
        return this;
    }

    CommitGraphBuilder addExtraList(byte[] bArr) throws CommitGraphFormatException {
        assertChunkNotSeenYet(this.extraList, 1162102597);
        this.extraList = bArr;
        return this;
    }

    CommitGraphBuilder addBloomFilterIndex(byte[] bArr) throws CommitGraphFormatException {
        assertChunkNotSeenYet(this.bloomFilterIndex, 1112097880);
        this.bloomFilterIndex = bArr;
        return this;
    }

    CommitGraphBuilder addBloomFilterData(byte[] bArr) throws CommitGraphFormatException {
        assertChunkNotSeenYet(this.bloomFilterData, 1111769428);
        this.bloomFilterData = bArr;
        return this;
    }

    CommitGraph build() throws CommitGraphFormatException {
        assertChunkNotNull(this.oidFanout, 1330201670);
        assertChunkNotNull(this.oidLookup, 1330201676);
        assertChunkNotNull(this.commitData, 1128546644);
        return new CommitGraphV1(new GraphObjectIndex(this.hashLength, this.oidFanout, this.oidLookup), new GraphCommitData(this.hashLength, this.commitData, this.extraList), new GraphChangedPathFilterData(this.bloomFilterIndex, this.bloomFilterData));
    }

    private void assertChunkNotNull(Object obj, int i) throws CommitGraphFormatException {
        if (obj == null) {
            throw new CommitGraphFormatException(MessageFormat.format(JGitText.get().commitGraphChunkNeeded, Integer.toHexString(i)));
        }
    }

    private void assertChunkNotSeenYet(Object obj, int i) throws CommitGraphFormatException {
        if (obj != null) {
            throw new CommitGraphFormatException(MessageFormat.format(JGitText.get().commitGraphChunkRepeated, Integer.toHexString(i)));
        }
    }
}
