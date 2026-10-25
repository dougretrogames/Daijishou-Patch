package org.eclipse.jgit.internal.storage.file;

import java.io.IOException;
import org.eclipse.jgit.internal.storage.pack.StoredObjectRepresentation;
import org.eclipse.jgit.lib.ObjectId;

/* JADX INFO: loaded from: classes5.dex */
class LocalObjectRepresentation extends StoredObjectRepresentation {
    private ObjectId baseId;
    private long baseOffset;
    long length;
    long offset;
    Pack pack;

    LocalObjectRepresentation() {
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.internal.storage.file.LocalObjectRepresentation$1, reason: invalid class name */
    class AnonymousClass1 extends LocalObjectRepresentation {
        @Override // org.eclipse.jgit.internal.storage.pack.StoredObjectRepresentation
        public int getFormat() {
            return 1;
        }

        AnonymousClass1() {
        }
    }

    static LocalObjectRepresentation newWhole(Pack pack, long j, long j2) {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        anonymousClass1.pack = pack;
        anonymousClass1.offset = j;
        anonymousClass1.length = j2;
        return anonymousClass1;
    }

    static LocalObjectRepresentation newDelta(Pack pack, long j, long j2, ObjectId objectId) {
        Delta delta = new Delta(null);
        delta.pack = pack;
        delta.offset = j;
        delta.length = j2;
        ((LocalObjectRepresentation) delta).baseId = objectId;
        return delta;
    }

    static LocalObjectRepresentation newDelta(Pack pack, long j, long j2, long j3) {
        Delta delta = new Delta(null);
        delta.pack = pack;
        delta.offset = j;
        delta.length = j2;
        ((LocalObjectRepresentation) delta).baseOffset = j3;
        return delta;
    }

    @Override // org.eclipse.jgit.internal.storage.pack.StoredObjectRepresentation
    public int getWeight() {
        return (int) Math.min(this.length, 2147483647L);
    }

    @Override // org.eclipse.jgit.internal.storage.pack.StoredObjectRepresentation
    public ObjectId getDeltaBase() {
        if (this.baseId == null && getFormat() == 0) {
            try {
                this.baseId = this.pack.findObjectForOffset(this.baseOffset);
            } catch (IOException unused) {
                return null;
            }
        }
        return this.baseId;
    }

    private static final class Delta extends LocalObjectRepresentation {
        /* synthetic */ Delta(LocalObjectRepresentationIA localObjectRepresentationIA) {
            this();
        }

        @Override // org.eclipse.jgit.internal.storage.pack.StoredObjectRepresentation
        public int getFormat() {
            return 0;
        }

        private Delta() {
        }
    }
}
