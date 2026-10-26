package org.eclipse.jgit.revwalk;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* INFO: loaded from: classes5.dex */
public class RevFlagSet extends AbstractSet<RevFlag> {
    private final List<RevFlag> active;
    int mask;

    public RevFlagSet() {
        this.active = new ArrayList();
    }

    public RevFlagSet(RevFlagSet revFlagSet) {
        this.mask = revFlagSet.mask;
        this.active = new ArrayList(revFlagSet.active);
    }

    public RevFlagSet(Collection<RevFlag> collection) {
        this();
        addAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (obj instanceof RevFlag) {
            if ((((RevFlag) obj).mask & this.mask) != 0) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        if (collection instanceof RevFlagSet) {
            int i = ((RevFlagSet) collection).mask;
            return (this.mask & i) == i;
        }
        return super.containsAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(RevFlag revFlag) {
        int i = 0;
        if ((this.mask & revFlag.mask) != 0) {
            return false;
        }
        this.mask |= revFlag.mask;
        while (i < this.active.size() && this.active.get(i).mask < revFlag.mask) {
            i++;
        }
        this.active.add(i, revFlag);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        RevFlag revFlag = (RevFlag) obj;
        if ((this.mask & revFlag.mask) == 0) {
            return false;
        }
        this.mask &= ~revFlag.mask;
        for (int i = 0; i < this.active.size(); i++) {
            if (this.active.get(i).mask == revFlag.mask) {
                this.active.remove(i);
            }
        }
        return true;
    }

    /* INFO: renamed from: org.eclipse.jgit.revwalk.RevFlagSet$1, reason: invalid class name */
    class AnonymousClass1 implements Iterator<RevFlag> {
        private RevFlag current;
        private final /* synthetic */ Iterator val$i;

        AnonymousClass1(Iterator it) {
            this.val$i = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.val$i.hasNext();
        }

        @Override // java.util.Iterator
        public RevFlag next() {
            RevFlag revFlag = (RevFlag) this.val$i.next();
            this.current = revFlag;
            return revFlag;
        }

        @Override // java.util.Iterator
        public void remove() {
            RevFlagSet.this.mask &= ~this.current.mask;
            this.val$i.remove();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<RevFlag> iterator() {
        return new AnonymousClass1(this.active.iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.active.size();
    }
}
