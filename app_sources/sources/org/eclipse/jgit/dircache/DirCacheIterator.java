package org.eclipse.jgit.dircache;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import org.eclipse.jgit.attributes.AttributesNode;
import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.FileMode;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectLoader;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.ObjectStream;
import org.eclipse.jgit.treewalk.AbstractTreeIterator;
import org.eclipse.jgit.treewalk.EmptyTreeIterator;
import org.eclipse.jgit.util.RawParseUtils;

/* INFO: loaded from: classes5.dex */
public class DirCacheIterator extends AbstractTreeIterator {
    private static final byte[] DOT_GIT_ATTRIBUTES_BYTES = Constants.DOT_GIT_ATTRIBUTES.getBytes(StandardCharsets.UTF_8);
    protected final DirCache cache;
    protected DirCacheEntry currentEntry;
    protected DirCacheTree currentSubtree;
    private int nextSubtreePos;
    protected int ptr;
    private final byte[] subtreeId;
    private final DirCacheTree tree;
    private final int treeEnd;
    private final int treeStart;

    public DirCacheIterator(DirCache dirCache) {
        this.cache = dirCache;
        DirCacheTree cacheTree = dirCache.getCacheTree(true);
        this.tree = cacheTree;
        this.treeStart = 0;
        this.treeEnd = cacheTree.getEntrySpan();
        this.subtreeId = new byte[20];
        if (eof()) {
            return;
        }
        parseEntry();
    }

    DirCacheIterator(DirCacheIterator dirCacheIterator, DirCacheTree dirCacheTree) {
        super(dirCacheIterator, dirCacheIterator.path, dirCacheIterator.pathLen + 1);
        this.cache = dirCacheIterator.cache;
        this.tree = dirCacheTree;
        int i = dirCacheIterator.ptr;
        this.treeStart = i;
        this.treeEnd = i + dirCacheTree.getEntrySpan();
        this.subtreeId = dirCacheIterator.subtreeId;
        this.ptr = dirCacheIterator.ptr;
        parseEntry();
    }

    @Override // org.eclipse.jgit.treewalk.AbstractTreeIterator
    public AbstractTreeIterator createSubtreeIterator(ObjectReader objectReader) throws IOException {
        DirCacheTree dirCacheTree = this.currentSubtree;
        if (dirCacheTree == null) {
            throw new IncorrectObjectTypeException(getEntryObjectId(), Constants.TYPE_TREE);
        }
        return new DirCacheIterator(this, dirCacheTree);
    }

    @Override // org.eclipse.jgit.treewalk.AbstractTreeIterator
    public EmptyTreeIterator createEmptyTreeIterator() {
        byte[] bArr = new byte[Math.max(this.pathLen + 1, 128)];
        System.arraycopy(this.path, 0, bArr, 0, this.pathLen);
        bArr[this.pathLen] = 47;
        return new EmptyTreeIterator(this, bArr, this.pathLen + 1);
    }

    @Override // org.eclipse.jgit.treewalk.AbstractTreeIterator
    public boolean hasId() {
        DirCacheTree dirCacheTree = this.currentSubtree;
        if (dirCacheTree != null) {
            return dirCacheTree.isValid();
        }
        return this.currentEntry != null;
    }

    @Override // org.eclipse.jgit.treewalk.AbstractTreeIterator
    public byte[] idBuffer() {
        DirCacheTree dirCacheTree = this.currentSubtree;
        if (dirCacheTree != null) {
            return dirCacheTree.isValid() ? this.subtreeId : zeroid;
        }
        DirCacheEntry dirCacheEntry = this.currentEntry;
        if (dirCacheEntry != null) {
            return dirCacheEntry.idBuffer();
        }
        return zeroid;
    }

    @Override // org.eclipse.jgit.treewalk.AbstractTreeIterator
    public int idOffset() {
        DirCacheEntry dirCacheEntry;
        if (this.currentSubtree == null && (dirCacheEntry = this.currentEntry) != null) {
            return dirCacheEntry.idOffset();
        }
        return 0;
    }

    @Override // org.eclipse.jgit.treewalk.AbstractTreeIterator
    public void reset() {
        if (first()) {
            return;
        }
        this.ptr = this.treeStart;
        this.nextSubtreePos = 0;
        this.currentEntry = null;
        this.currentSubtree = null;
        if (eof()) {
            return;
        }
        parseEntry();
    }

    @Override // org.eclipse.jgit.treewalk.AbstractTreeIterator
    public boolean first() {
        return this.ptr == this.treeStart;
    }

    @Override // org.eclipse.jgit.treewalk.AbstractTreeIterator
    public boolean eof() {
        return this.ptr == this.treeEnd;
    }

    @Override // org.eclipse.jgit.treewalk.AbstractTreeIterator
    public void next(int i) {
        while (true) {
            i--;
            if (i < 0) {
                return;
            }
            DirCacheTree dirCacheTree = this.currentSubtree;
            if (dirCacheTree != null) {
                this.ptr += dirCacheTree.getEntrySpan();
            } else {
                this.ptr++;
            }
            if (eof()) {
                return;
            } else {
                parseEntry();
            }
        }
    }

    @Override // org.eclipse.jgit.treewalk.AbstractTreeIterator
    public void back(int i) {
        while (true) {
            i--;
            if (i < 0) {
                return;
            }
            if (this.currentSubtree != null) {
                this.nextSubtreePos--;
            }
            this.ptr--;
            parseEntry(false);
            DirCacheTree dirCacheTree = this.currentSubtree;
            if (dirCacheTree != null) {
                this.ptr -= dirCacheTree.getEntrySpan() - 1;
            }
        }
    }

    private void parseEntry() {
        parseEntry(true);
    }

    private void parseEntry(boolean z) {
        int i;
        DirCacheEntry entry = this.cache.getEntry(this.ptr);
        this.currentEntry = entry;
        byte[] bArr = entry.path;
        if (!z && (i = this.nextSubtreePos) > 0) {
            DirCacheTree child = this.tree.getChild(i - 1);
            if (child.contains(bArr, this.pathOffset, bArr.length)) {
                this.nextSubtreePos--;
                this.currentSubtree = child;
            }
        }
        if (this.nextSubtreePos != this.tree.getChildCount()) {
            DirCacheTree child2 = this.tree.getChild(this.nextSubtreePos);
            if (child2.contains(bArr, this.pathOffset, bArr.length)) {
                this.currentSubtree = child2;
                this.nextSubtreePos++;
                if (child2.isValid()) {
                    child2.getObjectId().copyRawTo(this.subtreeId, 0);
                }
                this.mode = FileMode.TREE.getBits();
                this.path = bArr;
                this.pathLen = this.pathOffset + child2.nameLength();
                return;
            }
        }
        this.mode = this.currentEntry.getRawMode();
        this.path = bArr;
        this.pathLen = bArr.length;
        this.currentSubtree = null;
        if (RawParseUtils.match(this.path, this.pathOffset, DOT_GIT_ATTRIBUTES_BYTES) == this.path.length) {
            this.attributesNode = new LazyLoadingAttributesNode(this.currentEntry.getObjectId());
        }
    }

    public DirCacheEntry getDirCacheEntry() {
        if (this.currentSubtree == null) {
            return this.currentEntry;
        }
        return null;
    }

    public AttributesNode getEntryAttributesNode(ObjectReader objectReader) throws IOException {
        if (this.attributesNode instanceof LazyLoadingAttributesNode) {
            this.attributesNode = ((LazyLoadingAttributesNode) this.attributesNode).load(objectReader);
        }
        return this.attributesNode;
    }

    private static class LazyLoadingAttributesNode extends AttributesNode {
        final ObjectId objectId;

        LazyLoadingAttributesNode(ObjectId objectId) {
            super(Collections.emptyList());
            this.objectId = objectId;
        }

        AttributesNode load(ObjectReader objectReader) throws IOException {
            AttributesNode attributesNode = new AttributesNode();
            ObjectLoader objectLoaderOpen = objectReader.open(this.objectId);
            Throwable th = null;
            if (objectLoaderOpen != null) {
                try {
                    ObjectStream objectStreamOpenStream = objectLoaderOpen.openStream();
                    try {
                        attributesNode.parse(objectStreamOpenStream);
                        if (objectStreamOpenStream != null) {
                            objectStreamOpenStream.close();
                        }
                    } catch (Throwable th2) {
                        if (objectStreamOpenStream != null) {
                            objectStreamOpenStream.close();
                        }
                        throw th2;
                    }
                } catch (Throwable th3) {
                    if (0 == 0) {
                        throw th3;
                    }
                    if (null != th3) {
                        th.addSuppressed(th3);
                    }
                    throw null;
                }
            }
            if (attributesNode.getRules().isEmpty()) {
                return null;
            }
            return attributesNode;
        }
    }
}
