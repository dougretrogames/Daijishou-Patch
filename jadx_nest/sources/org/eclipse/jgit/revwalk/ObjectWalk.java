package org.eclipse.jgit.revwalk;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.eclipse.jgit.errors.CorruptObjectException;
import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.errors.LargeObjectException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.filter.ObjectFilter;
import org.eclipse.jgit.util.RawParseUtils;

/* INFO: loaded from: classes5.dex */
public class ObjectWalk extends RevWalk {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ID_SZ = 20;
    private static final int IN_PENDING = 8;
    public static final VisitationPolicy SIMPLE_VISITATION_POLICY = new AnonymousClass1();
    private static final int TYPE_FILE = 8;
    private static final int TYPE_GITLINK = 14;
    private static final int TYPE_SHIFT = 12;
    private static final int TYPE_SYMLINK = 10;
    private static final int TYPE_TREE = 4;
    private boolean boundary;
    private TreeVisit currVisit;
    private TreeVisit freeVisit;
    private ObjectFilter objectFilter;
    private byte[] pathBuf;
    private int pathLen;
    private BlockObjQueue pendingObjects;
    private List<RevObject> rootObjects;
    private VisitationPolicy visitationPolicy;

    public interface VisitationPolicy {
        boolean shouldVisit(RevObject revObject);

        void visited(RevObject revObject);
    }

    /* INFO: renamed from: org.eclipse.jgit.revwalk.ObjectWalk$1, reason: invalid class name */
    class AnonymousClass1 implements VisitationPolicy {
        AnonymousClass1() {
        }

        @Override // org.eclipse.jgit.revwalk.ObjectWalk.VisitationPolicy
        public boolean shouldVisit(RevObject revObject) {
            return (revObject.flags & 2) == 0;
        }

        @Override // org.eclipse.jgit.revwalk.ObjectWalk.VisitationPolicy
        public void visited(RevObject revObject) {
            revObject.flags |= 2;
        }
    }

    public ObjectWalk(Repository repository) {
        this(repository.newObjectReader(), true);
    }

    public ObjectWalk(ObjectReader objectReader) {
        this(objectReader, false);
    }

    private ObjectWalk(ObjectReader objectReader, boolean z) {
        super(objectReader, z);
        this.visitationPolicy = SIMPLE_VISITATION_POLICY;
        setRetainBody(false);
        this.rootObjects = new ArrayList();
        this.pendingObjects = new BlockObjQueue();
        this.objectFilter = ObjectFilter.ALL;
        this.pathBuf = new byte[256];
    }

    public void markStart(RevObject revObject) throws IOException {
        while (revObject instanceof RevTag) {
            addObject(revObject);
            revObject = ((RevTag) revObject).getObject();
            parseHeaders(revObject);
        }
        if (revObject instanceof RevCommit) {
            super.markStart((RevCommit) revObject);
        } else {
            addObject(revObject);
        }
    }

    public void markUninteresting(RevObject revObject) throws IOException {
        while (revObject instanceof RevTag) {
            revObject.flags |= 4;
            if (this.boundary) {
                addObject(revObject);
            }
            revObject = ((RevTag) revObject).getObject();
            parseHeaders(revObject);
        }
        if (revObject instanceof RevCommit) {
            super.markUninteresting((RevCommit) revObject);
        } else if (revObject instanceof RevTree) {
            markTreeUninteresting((RevTree) revObject);
        } else {
            revObject.flags |= 4;
        }
        if (revObject.getType() == 1 || !this.boundary) {
            return;
        }
        addObject(revObject);
    }

    @Override // org.eclipse.jgit.revwalk.RevWalk
    public void sort(RevSort revSort) {
        super.sort(revSort);
        this.boundary = hasRevSort(RevSort.BOUNDARY);
    }

    @Override // org.eclipse.jgit.revwalk.RevWalk
    public void sort(RevSort revSort, boolean z) {
        super.sort(revSort, z);
        this.boundary = hasRevSort(RevSort.BOUNDARY);
    }

    public ObjectFilter getObjectFilter() {
        return this.objectFilter;
    }

    public void setObjectFilter(ObjectFilter objectFilter) {
        assertNotStarted();
        if (objectFilter == null) {
            objectFilter = ObjectFilter.ALL;
        }
        this.objectFilter = objectFilter;
    }

    public void setVisitationPolicy(VisitationPolicy visitationPolicy) {
        assertNotStarted();
        this.visitationPolicy = (VisitationPolicy) Objects.requireNonNull(visitationPolicy);
    }

    @Override // org.eclipse.jgit.revwalk.RevWalk
    public RevCommit next() throws IOException {
        RevCommit next;
        do {
            next = super.next();
            if (next != null) {
                RevTree tree = next.getTree();
                if ((next.flags & 4) != 0) {
                    if (this.objectFilter.include(this, tree)) {
                        markTreeUninteresting(tree);
                    }
                } else {
                    if (!this.objectFilter.include(this, tree)) {
                        break;
                    }
                    this.pendingObjects.add(tree);
                    break;
                }
            } else {
                return null;
            }
        } while (!this.boundary);
        return next;
    }

    public void skipTree() {
        TreeVisit treeVisit = this.currVisit;
        if (treeVisit != null) {
            treeVisit.ptr = treeVisit.buf.length;
        }
    }

    public RevObject nextObject() throws IOException {
        RevObject revObject;
        this.pathLen = 0;
        TreeVisit treeVisit = this.currVisit;
        while (treeVisit != null) {
            byte[] bArr = treeVisit.buf;
            int i = treeVisit.ptr;
            while (i < bArr.length) {
                int iFindObjectId = findObjectId(bArr, i);
                this.idBuffer.fromRaw(bArr, iFindObjectId);
                int i2 = iFindObjectId + 20;
                if (this.objectFilter.include(this, this.idBuffer) && ((revObject = (RevObject) this.objects.get(this.idBuffer)) == null || this.visitationPolicy.shouldVisit(revObject))) {
                    int mode = parseMode(bArr, i, i2, treeVisit);
                    int i3 = mode >>> 12;
                    if (i3 != 4) {
                        if (i3 == 8 || i3 == 10) {
                            if (revObject == null) {
                                RevBlob revBlob = new RevBlob(this.idBuffer);
                                this.visitationPolicy.visited(revBlob);
                                this.objects.add(revBlob);
                                return revBlob;
                            }
                            if (!(revObject instanceof RevBlob)) {
                                throw new IncorrectObjectTypeException(revObject, 3);
                            }
                            this.visitationPolicy.visited(revObject);
                            if ((revObject.flags & 4) == 0 || this.boundary) {
                                return revObject;
                            }
                        } else if (i3 != 14) {
                            throw new CorruptObjectException(MessageFormat.format(JGitText.get().corruptObjectInvalidMode3, String.format("%o", Integer.valueOf(mode)), this.idBuffer.name(), RawParseUtils.decode(bArr, treeVisit.namePtr, treeVisit.nameEnd), treeVisit.obj));
                        }
                    } else {
                        if (revObject == null) {
                            RevTree revTree = new RevTree(this.idBuffer);
                            this.visitationPolicy.visited(revTree);
                            this.objects.add(revTree);
                            return pushTree(revTree);
                        }
                        if (!(revObject instanceof RevTree)) {
                            throw new IncorrectObjectTypeException(revObject, 2);
                        }
                        this.visitationPolicy.visited(revObject);
                        if ((revObject.flags & 4) == 0) {
                            return pushTree(revObject);
                        }
                        if (this.boundary) {
                            return pushTree(revObject);
                        }
                    }
                }
                i = i2;
            }
            this.currVisit = treeVisit.parent;
            releaseTreeVisit(treeVisit);
            treeVisit = this.currVisit;
        }
        while (true) {
            RevObject next = this.pendingObjects.next();
            if (next == null) {
                return null;
            }
            if (this.visitationPolicy.shouldVisit(next)) {
                this.visitationPolicy.visited(next);
                if ((next.flags & 4) == 0 || this.boundary) {
                    if (next instanceof RevTree) {
                        pushTree(next);
                    }
                    return next;
                }
            }
        }
    }

    private static int findObjectId(byte[] bArr, int i) {
        while (bArr[i + 1] != 0) {
            if (bArr[i + 2] == 0) {
                return i + 3;
            }
            if (bArr[i + 3] == 0) {
                return i + 4;
            }
            if (bArr[i + 4] == 0) {
                return i + 5;
            }
            if (bArr[i + 5] == 0) {
                return i + 6;
            }
            if (bArr[i + 6] == 0) {
                return i + 7;
            }
            if (bArr[i + 7] == 0) {
                return i + 8;
            }
            if (bArr[i + 8] == 0) {
                return i + 9;
            }
            if (bArr[i + 9] == 0) {
                return i + 10;
            }
            if (bArr[i + 10] == 0) {
                return i + 11;
            }
            if (bArr[i + 11] == 0) {
                return i + 12;
            }
            if (bArr[i + 12] == 0) {
                return i + 13;
            }
            if (bArr[i + 13] == 0) {
                return i + 14;
            }
            if (bArr[i + 14] == 0) {
                return i + 15;
            }
            if (bArr[i + 15] == 0) {
                return i + 16;
            }
            int i2 = i + 16;
            if (bArr[i2] == 0) {
                return i + 17;
            }
            i = i2;
        }
        return i + 2;
    }

    private static int parseMode(byte[] bArr, int i, int i2, TreeVisit treeVisit) {
        int i3;
        int i4 = bArr[i] - 48;
        while (true) {
            i3 = i + 1;
            byte b = bArr[i3];
            if (32 == b) {
                break;
            }
            i4 = (i4 << 3) + (b - 48);
            i3 = i + 2;
            byte b2 = bArr[i3];
            if (32 == b2) {
                break;
            }
            i4 = (i4 << 3) + (b2 - 48);
            i3 = i + 3;
            byte b3 = bArr[i3];
            if (32 == b3) {
                break;
            }
            i4 = (i4 << 3) + (b3 - 48);
            i3 = i + 4;
            byte b4 = bArr[i3];
            if (32 == b4) {
                break;
            }
            i4 = (i4 << 3) + (b4 - 48);
            i3 = i + 5;
            byte b5 = bArr[i3];
            if (32 == b5) {
                break;
            }
            i4 = (i4 << 3) + (b5 - 48);
            i3 = i + 6;
            byte b6 = bArr[i3];
            if (32 == b6) {
                break;
            }
            i4 = (i4 << 3) + (b6 - 48);
            i += 7;
            byte b7 = bArr[i];
            if (32 == b7) {
                i3 = i;
                break;
            }
            i4 = (i4 << 3) + (b7 - 48);
        }
        treeVisit.ptr = i2;
        treeVisit.namePtr = i3 + 1;
        treeVisit.nameEnd = i2 - 21;
        return i4;
    }

    public void checkConnectivity() throws IOException {
        while (next() != null) {
        }
        while (true) {
            RevObject revObjectNextObject = nextObject();
            if (revObjectNextObject == null) {
                return;
            }
            if ((revObjectNextObject instanceof RevBlob) && !this.reader.has(revObjectNextObject)) {
                throw new MissingObjectException(revObjectNextObject, 3);
            }
        }
    }

    public String getPathString() {
        if (this.pathLen == 0) {
            int iUpdatePathBuf = updatePathBuf(this.currVisit);
            this.pathLen = iUpdatePathBuf;
            if (iUpdatePathBuf == 0) {
                return null;
            }
        }
        return RawParseUtils.decode(this.pathBuf, 0, this.pathLen);
    }

    public int getTreeDepth() {
        TreeVisit treeVisit = this.currVisit;
        if (treeVisit == null) {
            return 0;
        }
        return treeVisit.depth;
    }

    public int getPathHashCode() {
        byte[] bArr;
        int iMax;
        TreeVisit treeVisit = this.currVisit;
        int i = 0;
        if (treeVisit == null) {
            return 0;
        }
        int i2 = treeVisit.nameEnd;
        if (i2 == 0) {
            treeVisit = treeVisit.parent;
            if (treeVisit == null) {
                return 0;
            }
            i2 = treeVisit.nameEnd;
        }
        if (16 <= i2 - treeVisit.namePtr) {
            bArr = treeVisit.buf;
            iMax = i2 - 16;
        } else {
            int iUpdatePathBuf = this.pathLen;
            if (iUpdatePathBuf == 0) {
                iUpdatePathBuf = updatePathBuf(this.currVisit);
                this.pathLen = iUpdatePathBuf;
            }
            i2 = iUpdatePathBuf;
            bArr = this.pathBuf;
            iMax = Math.max(0, i2 - 16);
        }
        while (iMax < i2) {
            byte b = bArr[iMax];
            if (b != 32) {
                i = (i >>> 2) + (b << Ascii.CAN);
            }
            iMax++;
        }
        return i;
    }

    public byte[] getPathBuffer() {
        if (this.pathLen == 0) {
            this.pathLen = updatePathBuf(this.currVisit);
        }
        return this.pathBuf;
    }

    public int getPathLength() {
        if (this.pathLen == 0) {
            this.pathLen = updatePathBuf(this.currVisit);
        }
        return this.pathLen;
    }

    private int updatePathBuf(TreeVisit treeVisit) {
        if (treeVisit == null) {
            return 0;
        }
        int i = treeVisit.nameEnd;
        if (i == 0) {
            return updatePathBuf(treeVisit.parent);
        }
        int iUpdatePathBuf = treeVisit.pathLen;
        if (iUpdatePathBuf == 0) {
            iUpdatePathBuf = updatePathBuf(treeVisit.parent);
            if (iUpdatePathBuf == this.pathBuf.length) {
                growPathBuf(iUpdatePathBuf);
            }
            if (iUpdatePathBuf != 0) {
                this.pathBuf[iUpdatePathBuf] = 47;
                iUpdatePathBuf++;
            }
            treeVisit.pathLen = iUpdatePathBuf;
        }
        int i2 = treeVisit.namePtr;
        int i3 = i - i2;
        int i4 = iUpdatePathBuf + i3;
        while (this.pathBuf.length < i4) {
            growPathBuf(iUpdatePathBuf);
        }
        System.arraycopy(treeVisit.buf, i2, this.pathBuf, iUpdatePathBuf, i3);
        return i4;
    }

    private void growPathBuf(int i) {
        byte[] bArr = this.pathBuf;
        byte[] bArr2 = new byte[bArr.length << 1];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        this.pathBuf = bArr2;
    }

    @Override // org.eclipse.jgit.revwalk.RevWalk
    public void dispose() {
        super.dispose();
        this.pendingObjects = new BlockObjQueue();
        this.currVisit = null;
        this.freeVisit = null;
    }

    @Override // org.eclipse.jgit.revwalk.RevWalk
    protected void reset(int i) {
        super.reset(i);
        Iterator<RevObject> it = this.rootObjects.iterator();
        while (it.hasNext()) {
            it.next().flags &= -9;
        }
        this.rootObjects = new ArrayList();
        this.pendingObjects = new BlockObjQueue();
        this.currVisit = null;
        this.freeVisit = null;
    }

    private void addObject(RevObject revObject) {
        if ((revObject.flags & 8) == 0) {
            revObject.flags |= 8;
            this.rootObjects.add(revObject);
            this.pendingObjects.add(revObject);
        }
    }

    private void markTreeUninteresting(RevTree revTree) throws IOException {
        if ((revTree.flags & 4) != 0) {
            return;
        }
        revTree.flags |= 4;
        byte[] cachedBytes = this.reader.open(revTree, 2).getCachedBytes();
        int i = 0;
        while (i < cachedBytes.length) {
            int i2 = cachedBytes[i] - 48;
            while (true) {
                i++;
                byte b = cachedBytes[i];
                if (32 == b) {
                    break;
                } else {
                    i2 = (i2 << 3) + (b - 48);
                }
            }
            while (true) {
                int i3 = i + 1;
                if (cachedBytes[i3] == 0) {
                    break;
                } else {
                    i = i3;
                }
            }
            int i4 = i + 2;
            int i5 = i2 >>> 12;
            if (i5 == 4) {
                this.idBuffer.fromRaw(cachedBytes, i4);
                markTreeUninteresting(lookupTree(this.idBuffer));
            } else if (i5 == 8 || i5 == 10) {
                this.idBuffer.fromRaw(cachedBytes, i4);
                lookupBlob(this.idBuffer).flags |= 4;
            } else if (i5 != 14) {
                this.idBuffer.fromRaw(cachedBytes, i4);
                throw new CorruptObjectException(MessageFormat.format(JGitText.get().corruptObjectInvalidMode3, String.format("%o", Integer.valueOf(i2)), this.idBuffer.name(), "", revTree));
            }
            i += 22;
        }
    }

    private RevObject pushTree(RevObject revObject) throws LargeObjectException, IOException {
        TreeVisit treeVisit = this.freeVisit;
        if (treeVisit != null) {
            this.freeVisit = treeVisit.parent;
            treeVisit.ptr = 0;
            treeVisit.namePtr = 0;
            treeVisit.nameEnd = 0;
            treeVisit.pathLen = 0;
        } else {
            treeVisit = new TreeVisit(null);
        }
        treeVisit.obj = revObject;
        treeVisit.buf = this.reader.open(revObject, 2).getCachedBytes();
        treeVisit.parent = this.currVisit;
        this.currVisit = treeVisit;
        if (treeVisit.parent == null) {
            treeVisit.depth = 1;
            return revObject;
        }
        treeVisit.depth = treeVisit.parent.depth + 1;
        return revObject;
    }

    private void releaseTreeVisit(TreeVisit treeVisit) {
        treeVisit.buf = null;
        treeVisit.parent = this.freeVisit;
        this.freeVisit = treeVisit;
    }

    private static class TreeVisit {
        byte[] buf;
        int depth;
        int nameEnd;
        int namePtr;
        RevObject obj;
        TreeVisit parent;
        int pathLen;
        int ptr;

        /* synthetic */ TreeVisit(ObjectWalkIA objectWalkIA) {
            this();
        }

        private TreeVisit() {
        }
    }
}
