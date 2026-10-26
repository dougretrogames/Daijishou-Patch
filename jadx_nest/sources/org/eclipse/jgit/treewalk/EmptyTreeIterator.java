package org.eclipse.jgit.treewalk;

import java.io.IOException;
import org.eclipse.jgit.errors.CorruptObjectException;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectReader;

/* INFO: loaded from: classes5.dex */
public class EmptyTreeIterator extends AbstractTreeIterator {
    @Override // org.eclipse.jgit.treewalk.AbstractTreeIterator
    public void back(int i) throws CorruptObjectException {
    }

    @Override // org.eclipse.jgit.treewalk.AbstractTreeIterator
    public boolean eof() {
        return true;
    }

    @Override // org.eclipse.jgit.treewalk.AbstractTreeIterator
    public boolean first() {
        return true;
    }

    @Override // org.eclipse.jgit.treewalk.AbstractTreeIterator
    public boolean hasId() {
        return false;
    }

    @Override // org.eclipse.jgit.treewalk.AbstractTreeIterator
    public int idOffset() {
        return 0;
    }

    @Override // org.eclipse.jgit.treewalk.AbstractTreeIterator
    public void next(int i) throws CorruptObjectException {
    }

    @Override // org.eclipse.jgit.treewalk.AbstractTreeIterator
    public void reset() {
    }

    public EmptyTreeIterator() {
    }

    EmptyTreeIterator(AbstractTreeIterator abstractTreeIterator) {
        super(abstractTreeIterator);
        this.pathLen = this.pathOffset;
    }

    public EmptyTreeIterator(AbstractTreeIterator abstractTreeIterator, byte[] bArr, int i) {
        super(abstractTreeIterator, bArr, i);
        this.pathLen = i - 1;
    }

    @Override // org.eclipse.jgit.treewalk.AbstractTreeIterator
    public AbstractTreeIterator createSubtreeIterator(ObjectReader objectReader) throws IOException {
        return new EmptyTreeIterator(this);
    }

    @Override // org.eclipse.jgit.treewalk.AbstractTreeIterator
    public ObjectId getEntryObjectId() {
        return ObjectId.zeroId();
    }

    @Override // org.eclipse.jgit.treewalk.AbstractTreeIterator
    public byte[] idBuffer() {
        return zeroid;
    }

    @Override // org.eclipse.jgit.treewalk.AbstractTreeIterator
    public void stopWalk() {
        if (this.parent != null) {
            this.parent.stopWalk();
        }
    }

    @Override // org.eclipse.jgit.treewalk.AbstractTreeIterator
    protected boolean needsStopWalk() {
        return this.parent != null && this.parent.needsStopWalk();
    }
}
