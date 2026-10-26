package org.eclipse.jgit.lib;

import org.eclipse.jgit.annotations.Nullable;

/* INFO: loaded from: classes5.dex */
public class SymbolicRef implements Ref {
    private final String name;
    private final Ref target;
    private final long updateIndex;

    @Override // org.eclipse.jgit.lib.Ref
    public boolean isSymbolic() {
        return true;
    }

    public SymbolicRef(String str, Ref ref) {
        this.name = str;
        this.target = ref;
        this.updateIndex = -1L;
    }

    public SymbolicRef(String str, Ref ref, long j) {
        this.name = str;
        this.target = ref;
        this.updateIndex = j;
    }

    @Override // org.eclipse.jgit.lib.Ref
    public String getName() {
        return this.name;
    }

    @Override // org.eclipse.jgit.lib.Ref
    public Ref getLeaf() {
        Ref target = getTarget();
        while (target.isSymbolic()) {
            target = target.getTarget();
        }
        return target;
    }

    @Override // org.eclipse.jgit.lib.Ref
    public Ref getTarget() {
        return this.target;
    }

    @Override // org.eclipse.jgit.lib.Ref
    @Nullable
    public ObjectId getObjectId() {
        return getLeaf().getObjectId();
    }

    @Override // org.eclipse.jgit.lib.Ref
    public Ref.Storage getStorage() {
        return Ref.Storage.LOOSE;
    }

    @Override // org.eclipse.jgit.lib.Ref
    @Nullable
    public ObjectId getPeeledObjectId() {
        return getLeaf().getPeeledObjectId();
    }

    @Override // org.eclipse.jgit.lib.Ref
    public boolean isPeeled() {
        return getLeaf().isPeeled();
    }

    @Override // org.eclipse.jgit.lib.Ref
    public long getUpdateIndex() {
        long j = this.updateIndex;
        if (j != -1) {
            return j;
        }
        throw new UnsupportedOperationException();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SymbolicRef[");
        Ref target = this;
        while (target.isSymbolic()) {
            sb.append(target.getName());
            sb.append(" -> ");
            target = target.getTarget();
        }
        sb.append(target.getName());
        sb.append('=');
        sb.append(ObjectId.toString(target.getObjectId()));
        sb.append("(");
        sb.append(this.updateIndex);
        sb.append(")]");
        return sb.toString();
    }
}
