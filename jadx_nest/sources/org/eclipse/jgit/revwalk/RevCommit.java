package org.eclipse.jgit.revwalk;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.text.Typography;
import org.apache.http.message.TokenParser;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.internal.storage.commitgraph.ChangedPathFilter;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.MutableObjectId;
import org.eclipse.jgit.lib.ObjectInserter;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.util.RawParseUtils;
import org.eclipse.jgit.util.StringUtils;

/* INFO: loaded from: classes5.dex */
public class RevCommit extends RevObject {
    static final RevCommit[] NO_PARENTS = new RevCommit[0];
    private static final int STACK_DEPTH = 500;
    protected byte[] buffer;
    int commitTime;
    int inDegree;
    protected RevCommit[] parents;
    protected RevTree tree;

    public ChangedPathFilter getChangedPathFilter(RevWalk revWalk) {
        return null;
    }

    int getGeneration() {
        return Integer.MAX_VALUE;
    }

    @Override // org.eclipse.jgit.revwalk.RevObject
    public final int getType() {
        return 1;
    }

    public static RevCommit parse(byte[] bArr) {
        try {
            return parse(new RevWalk((ObjectReader) null), bArr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static RevCommit parse(RevWalk revWalk, byte[] bArr) throws IOException {
        Throwable th = null;
        try {
            ObjectInserter.Formatter formatter = new ObjectInserter.Formatter();
            try {
                RevCommit revCommitLookupCommit = revWalk.lookupCommit(formatter.idFor(1, bArr));
                revCommitLookupCommit.parseCanonical(revWalk, bArr);
                revCommitLookupCommit.buffer = bArr;
                return revCommitLookupCommit;
            } finally {
                formatter.close();
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null != th2) {
                th.addSuppressed(th2);
            }
            throw null;
        }
    }

    protected RevCommit(AnyObjectId anyObjectId) {
        super(anyObjectId);
    }

    @Override // org.eclipse.jgit.revwalk.RevObject
    void parseHeaders(RevWalk revWalk) throws IOException {
        parseCanonical(revWalk, revWalk.getCachedBytes(this));
    }

    @Override // org.eclipse.jgit.revwalk.RevObject
    void parseBody(RevWalk revWalk) throws IOException {
        if (this.buffer == null) {
            this.buffer = revWalk.getCachedBytes(this);
            if ((this.flags & 1) == 0) {
                parseCanonical(revWalk, this.buffer);
            }
        }
    }

    void parseCanonical(RevWalk revWalk, byte[] bArr) throws IOException {
        int i;
        if (!revWalk.shallowCommitsInitialized) {
            revWalk.initializeShallowCommits(this);
        }
        MutableObjectId mutableObjectId = revWalk.idBuffer;
        mutableObjectId.fromString(bArr, 5);
        this.tree = revWalk.lookupTree(mutableObjectId);
        int i2 = 46;
        if (getParents() == null) {
            RevCommit[] revCommitArr = new RevCommit[1];
            int i3 = 0;
            while (bArr[i2] == 112) {
                mutableObjectId.fromString(bArr, i2 + 7);
                RevCommit revCommitLookupCommit = revWalk.lookupCommit(mutableObjectId);
                if (i3 != 0) {
                    if (i3 == 1) {
                        i3 = 2;
                        revCommitArr = new RevCommit[]{revCommitArr[0], revCommitLookupCommit};
                    } else {
                        if (revCommitArr.length <= i3) {
                            RevCommit[] revCommitArr2 = new RevCommit[revCommitArr.length + 32];
                            System.arraycopy(revCommitArr, 0, revCommitArr2, 0, i3);
                            revCommitArr = revCommitArr2;
                        }
                        i = i3 + 1;
                        revCommitArr[i3] = revCommitLookupCommit;
                    }
                    i2 += 48;
                } else {
                    i = i3 + 1;
                    revCommitArr[i3] = revCommitLookupCommit;
                }
                i3 = i;
                i2 += 48;
            }
            if (i3 != revCommitArr.length) {
                RevCommit[] revCommitArr3 = new RevCommit[i3];
                System.arraycopy(revCommitArr, 0, revCommitArr3, 0, i3);
                revCommitArr = revCommitArr3;
            }
            this.parents = revCommitArr;
        }
        int iCommitter = RawParseUtils.committer(bArr, i2);
        if (iCommitter > 0) {
            this.commitTime = RawParseUtils.parseBase10(bArr, RawParseUtils.nextLF(bArr, iCommitter, Typography.greater), null);
        }
        if (revWalk.isRetainBody()) {
            this.buffer = bArr;
        }
        this.flags |= 1;
    }

    static void carryFlags(RevCommit revCommit, int i) {
        FIFORevQueue fIFORevQueueCarryFlags1 = carryFlags1(revCommit, i, 0);
        if (fIFORevQueueCarryFlags1 != null) {
            slowCarryFlags(fIFORevQueueCarryFlags1, i);
        }
    }

    private static FIFORevQueue carryFlags1(RevCommit revCommit, int i, int i2) {
        while (true) {
            RevCommit[] parents = revCommit.getParents();
            if (parents == null || parents.length == 0) {
                break;
            }
            if (parents.length != 1) {
                if (i2 == 500) {
                    return defer(revCommit);
                }
                for (int i3 = 1; i3 < parents.length; i3++) {
                    RevCommit revCommit2 = parents[i3];
                    if ((revCommit2.flags & i) != i) {
                        revCommit2.flags |= i;
                        FIFORevQueue fIFORevQueueCarryFlags1 = carryFlags1(revCommit2, i, i2 + 1);
                        if (fIFORevQueueCarryFlags1 != null) {
                            return defer(fIFORevQueueCarryFlags1, i, parents, i3 + 1);
                        }
                    }
                }
            }
            revCommit = parents[0];
            if ((revCommit.flags & i) == i) {
                return null;
            }
            revCommit.flags |= i;
        }
        return null;
    }

    private static FIFORevQueue defer(RevCommit revCommit) {
        FIFORevQueue fIFORevQueue = new FIFORevQueue();
        fIFORevQueue.add(revCommit);
        return fIFORevQueue;
    }

    private static FIFORevQueue defer(FIFORevQueue fIFORevQueue, int i, RevCommit[] revCommitArr, int i2) {
        carryOneStep(fIFORevQueue, i, revCommitArr[0]);
        while (i2 < revCommitArr.length) {
            carryOneStep(fIFORevQueue, i, revCommitArr[i2]);
            i2++;
        }
        return fIFORevQueue;
    }

    private static void slowCarryFlags(FIFORevQueue fIFORevQueue, int i) {
        while (true) {
            RevCommit next = fIFORevQueue.next();
            if (next == null) {
                return;
            }
            for (RevCommit revCommit : next.getParents()) {
                carryOneStep(fIFORevQueue, i, revCommit);
            }
        }
    }

    private static void carryOneStep(FIFORevQueue fIFORevQueue, int i, RevCommit revCommit) {
        if ((revCommit.flags & i) != i) {
            revCommit.flags = i | revCommit.flags;
            if (revCommit.getParents() != null) {
                fIFORevQueue.add(revCommit);
            }
        }
    }

    public void carry(RevFlag revFlag) {
        int i = revFlag.mask & this.flags;
        if (i != 0) {
            carryFlags(this, i);
        }
    }

    public final int getCommitTime() {
        return this.commitTime;
    }

    public final RevTree getTree() {
        return this.tree;
    }

    public int getParentCount() {
        RevCommit[] revCommitArr = this.parents;
        if (revCommitArr == null) {
            return 0;
        }
        return revCommitArr.length;
    }

    public RevCommit getParent(int i) {
        return this.parents[i];
    }

    public RevCommit[] getParents() {
        return this.parents;
    }

    public final byte[] getRawBuffer() {
        return this.buffer;
    }

    public final byte[] getRawGpgSignature() {
        byte[] bArr = this.buffer;
        int iHeaderStart = RawParseUtils.headerStart(new byte[]{103, 112, 103, 115, 105, 103}, bArr, 0);
        if (iHeaderStart < 0) {
            return null;
        }
        return RawParseUtils.headerValue(bArr, iHeaderStart, RawParseUtils.headerEnd(bArr, iHeaderStart));
    }

    public final PersonIdent getAuthorIdent() {
        byte[] bArr = this.buffer;
        int iAuthor = RawParseUtils.author(bArr, 0);
        if (iAuthor < 0) {
            return null;
        }
        return RawParseUtils.parsePersonIdent(bArr, iAuthor);
    }

    public final PersonIdent getCommitterIdent() {
        byte[] bArr = this.buffer;
        int iCommitter = RawParseUtils.committer(bArr, 0);
        if (iCommitter < 0) {
            return null;
        }
        return RawParseUtils.parsePersonIdent(bArr, iCommitter);
    }

    public final String getFullMessage() {
        byte[] bArr = this.buffer;
        int iCommitMessage = RawParseUtils.commitMessage(bArr, 0);
        if (iCommitMessage < 0) {
            return "";
        }
        return RawParseUtils.decode(RawParseUtils.guessEncoding(this.buffer), bArr, iCommitMessage, bArr.length);
    }

    public final String getShortMessage() {
        byte[] bArr = this.buffer;
        int iCommitMessage = RawParseUtils.commitMessage(bArr, 0);
        if (iCommitMessage < 0) {
            return "";
        }
        int iEndOfParagraph = RawParseUtils.endOfParagraph(bArr, iCommitMessage);
        String strDecode = RawParseUtils.decode(RawParseUtils.guessEncoding(this.buffer), bArr, iCommitMessage, iEndOfParagraph);
        return hasLF(bArr, iCommitMessage, iEndOfParagraph) ? StringUtils.replaceLineBreaksWithSpace(strDecode) : strDecode;
    }

    static boolean hasLF(byte[] bArr, int i, int i2) {
        while (i < i2) {
            int i3 = i + 1;
            if (bArr[i] == 10) {
                return true;
            }
            i = i3;
        }
        return false;
    }

    @Nullable
    public final String getEncodingName() {
        return RawParseUtils.parseEncodingName(this.buffer);
    }

    public final Charset getEncoding() {
        return RawParseUtils.parseEncoding(this.buffer);
    }

    public final List<FooterLine> getFooterLines() {
        return FooterLine.fromMessage(this.buffer);
    }

    public final List<String> getFooterLines(String str) {
        return FooterLine.getValues(getFooterLines(), str);
    }

    public final List<String> getFooterLines(FooterKey footerKey) {
        return FooterLine.getValues(getFooterLines(), footerKey);
    }

    public void reset() {
        this.inDegree = 0;
    }

    public final void disposeBody() {
        this.buffer = null;
    }

    @Override // org.eclipse.jgit.revwalk.RevObject, org.eclipse.jgit.lib.AnyObjectId
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Constants.typeString(getType()));
        sb.append(TokenParser.SP);
        sb.append(name());
        sb.append(TokenParser.SP);
        sb.append(this.commitTime);
        sb.append(TokenParser.SP);
        appendCoreFlags(sb);
        return sb.toString();
    }
}
