package org.eclipse.jgit.revwalk;

import java.io.IOException;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.filter.RevFilter;

/* INFO: loaded from: classes5.dex */
public class RevCommitList<E extends RevCommit> extends RevObjectList<E> {
    private RevWalk walker;

    protected void enter(int i, E e) {
    }

    @Override // org.eclipse.jgit.revwalk.RevObjectList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        super.clear();
        this.walker = null;
    }

    public void applyFlag(RevFilter revFilter, RevFlag revFlag) throws IOException {
        applyFlag(revFilter, revFlag, 0, size());
    }

    public void applyFlag(RevFilter revFilter, RevFlag revFlag, int i, int i2) throws IOException {
        int i3;
        RevWalk revWalk = revFlag.getRevWalk();
        int iMin = Math.min(i2, size());
        while (i < iMin) {
            RevObjectList.Block block = this.contents;
            int i4 = i;
            while (block.shift > 0) {
                int i5 = i4 >> block.shift;
                i4 -= i5 << block.shift;
                block = (RevObjectList.Block) block.contents[i5];
            }
            while (true) {
                i3 = i + 1;
                if (i >= iMin || i4 >= 256) {
                    break;
                }
                int i6 = i4 + 1;
                RevCommit revCommit = (RevCommit) block.contents[i4];
                if (revFilter.include(revWalk, revCommit)) {
                    revCommit.add(revFlag);
                } else {
                    revCommit.remove(revFlag);
                }
                i = i3;
                i4 = i6;
            }
            i = i3;
        }
    }

    public void clearFlag(RevFlag revFlag) {
        clearFlag(revFlag, 0, size());
    }

    public void clearFlag(RevFlag revFlag, int i, int i2) {
        try {
            applyFlag(RevFilter.NONE, revFlag, i, i2);
        } catch (IOException unused) {
        }
    }

    public int indexOf(RevFlag revFlag, int i) {
        int i2;
        while (i < size()) {
            RevObjectList.Block block = this.contents;
            int i3 = i;
            while (block.shift > 0) {
                int i4 = i3 >> block.shift;
                i3 -= i4 << block.shift;
                block = (RevObjectList.Block) block.contents[i4];
            }
            while (true) {
                i2 = i + 1;
                if (i >= size() || i3 >= 256) {
                    break;
                }
                int i5 = i3 + 1;
                if (((RevCommit) block.contents[i3]).has(revFlag)) {
                    return i2;
                }
                i = i2;
                i3 = i5;
            }
            i = i2;
        }
        return -1;
    }

    public int lastIndexOf(RevFlag revFlag, int i) {
        int i2;
        int iMin = Math.min(i, size() - 1);
        while (iMin >= 0) {
            RevObjectList.Block block = this.contents;
            int i3 = iMin;
            while (block.shift > 0) {
                int i4 = i3 >> block.shift;
                i3 -= i4 << block.shift;
                block = (RevObjectList.Block) block.contents[i4];
            }
            while (true) {
                i2 = iMin - 1;
                if (iMin < 0 || i3 < 0) {
                    break;
                }
                int i5 = i3 - 1;
                if (((RevCommit) block.contents[i3]).has(revFlag)) {
                    return i2;
                }
                iMin = i2;
                i3 = i5;
            }
            iMin = i2;
        }
        return -1;
    }

    public void source(RevWalk revWalk) {
        this.walker = revWalk;
    }

    public boolean isPending() {
        return this.walker != null;
    }

    public void fillTo(int i) throws IOException {
        if (this.walker == null || this.size > i) {
            return;
        }
        RevCommit next = this.walker.next();
        if (next == null) {
            this.walker = null;
            return;
        }
        enter(this.size, next);
        add(next);
        while (this.size <= i) {
            int i2 = this.size;
            RevObjectList.Block block = this.contents;
            while ((i2 >> block.shift) >= 256) {
                RevObjectList.Block block2 = new RevObjectList.Block(block.shift + 8);
                block2.contents[0] = this.contents;
                this.contents = block2;
                block = block2;
            }
            while (block.shift > 0) {
                int i3 = i2 >> block.shift;
                i2 -= i3 << block.shift;
                if (block.contents[i3] == null) {
                    block.contents[i3] = new RevObjectList.Block(block.shift - 8);
                }
                block = (RevObjectList.Block) block.contents[i3];
            }
            Object[] objArr = block.contents;
            while (this.size <= i && i2 < 256) {
                RevCommit next2 = this.walker.next();
                if (next2 == null) {
                    this.walker = null;
                    return;
                }
                int i4 = this.size;
                this.size = i4 + 1;
                enter(i4, next2);
                objArr[i2] = next2;
                i2++;
            }
        }
    }

    public void fillTo(RevCommit revCommit, int i) throws IOException {
        if (this.walker == null || revCommit == null) {
            return;
        }
        if (i > 0 && this.size > i) {
            return;
        }
        RevCommit next = this.walker.next();
        if (next == null) {
            this.walker = null;
            return;
        }
        enter(this.size, next);
        add(next);
        while (true) {
            if ((i != 0 && this.size > i) || next.equals((AnyObjectId) revCommit)) {
                return;
            }
            int i2 = this.size;
            RevObjectList.Block block = this.contents;
            while ((i2 >> block.shift) >= 256) {
                RevObjectList.Block block2 = new RevObjectList.Block(block.shift + 8);
                block2.contents[0] = this.contents;
                this.contents = block2;
                block = block2;
            }
            while (block.shift > 0) {
                int i3 = i2 >> block.shift;
                i2 -= i3 << block.shift;
                if (block.contents[i3] == null) {
                    block.contents[i3] = new RevObjectList.Block(block.shift - 8);
                }
                block = (RevObjectList.Block) block.contents[i3];
            }
            Object[] objArr = block.contents;
            while (true) {
                if ((i != 0 && this.size > i) || i2 >= 256 || next.equals((AnyObjectId) revCommit)) {
                    break;
                }
                next = this.walker.next();
                if (next == null) {
                    this.walker = null;
                    return;
                }
                int i4 = this.size;
                this.size = i4 + 1;
                enter(i4, next);
                objArr[i2] = next;
                i2++;
            }
        }
    }
}
