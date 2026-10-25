package org.eclipse.jgit.lib;

import org.eclipse.jgit.errors.CorruptObjectException;

/* JADX INFO: loaded from: classes5.dex */
public interface BlobObjectChecker {
    public static final BlobObjectChecker NULL_CHECKER = new AnonymousClass1();

    void endBlob(AnyObjectId anyObjectId) throws CorruptObjectException;

    void update(byte[] bArr, int i, int i2);

    /* JADX INFO: renamed from: org.eclipse.jgit.lib.BlobObjectChecker$1, reason: invalid class name */
    class AnonymousClass1 implements BlobObjectChecker {
        @Override // org.eclipse.jgit.lib.BlobObjectChecker
        public void endBlob(AnyObjectId anyObjectId) {
        }

        @Override // org.eclipse.jgit.lib.BlobObjectChecker
        public void update(byte[] bArr, int i, int i2) {
        }

        AnonymousClass1() {
        }
    }
}
