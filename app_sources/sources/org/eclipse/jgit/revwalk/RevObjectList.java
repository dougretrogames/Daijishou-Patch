package org.eclipse.jgit.revwalk;

import java.text.MessageFormat;
import java.util.AbstractList;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.revwalk.RevObject;

/* INFO: loaded from: classes5.dex */
public class RevObjectList<E extends RevObject> extends AbstractList<E> {
    static final int BLOCK_SHIFT = 8;
    static final int BLOCK_SIZE = 256;
    protected Block contents = new Block(0);
    protected int size = 0;

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, E e) {
        if (i != this.size) {
            throw new UnsupportedOperationException(MessageFormat.format(JGitText.get().unsupportedOperationNotAddAtEnd, Integer.valueOf(i)));
        }
        set(i, (RevObject) e);
        this.size++;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i, E e) {
        Block block = this.contents;
        while ((i >> block.shift) >= 256) {
            Block block2 = new Block(block.shift + 8);
            block2.contents[0] = this.contents;
            this.contents = block2;
            block = block2;
        }
        while (block.shift > 0) {
            int i2 = i >> block.shift;
            i -= i2 << block.shift;
            if (block.contents[i2] == null) {
                block.contents[i2] = new Block(block.shift - 8);
            }
            block = (Block) block.contents[i2];
        }
        Object obj = block.contents[i];
        block.contents[i] = e;
        return (E) obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        Block block = this.contents;
        if ((i >> block.shift) >= 1024) {
            return null;
        }
        while (block != null && block.shift > 0) {
            int i2 = i >> block.shift;
            i -= i2 << block.shift;
            block = (Block) block.contents[i2];
        }
        if (block != null) {
            return (E) block.contents[i];
        }
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.contents = new Block(0);
        this.size = 0;
    }

    protected static class Block {
        final Object[] contents = new Object[256];
        final int shift;

        Block(int i) {
            this.shift = i;
        }
    }
}
