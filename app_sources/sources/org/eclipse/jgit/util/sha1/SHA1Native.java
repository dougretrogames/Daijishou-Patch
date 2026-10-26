package org.eclipse.jgit.util.sha1;

import java.security.MessageDigest;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.MutableObjectId;
import org.eclipse.jgit.lib.ObjectId;

/* INFO: loaded from: classes5.dex */
class SHA1Native extends SHA1 {
    private final MessageDigest md = Constants.newMessageDigest();

    @Override // org.eclipse.jgit.util.sha1.SHA1
    public boolean hasCollision() {
        return false;
    }

    @Override // org.eclipse.jgit.util.sha1.SHA1
    public SHA1 setDetectCollision(boolean z) {
        return this;
    }

    SHA1Native() {
    }

    @Override // org.eclipse.jgit.util.sha1.SHA1
    public void update(byte b) {
        this.md.update(b);
    }

    @Override // org.eclipse.jgit.util.sha1.SHA1
    public void update(byte[] bArr) {
        this.md.update(bArr);
    }

    @Override // org.eclipse.jgit.util.sha1.SHA1
    public void update(byte[] bArr, int i, int i2) {
        this.md.update(bArr, i, i2);
    }

    @Override // org.eclipse.jgit.util.sha1.SHA1
    public byte[] digest() throws Sha1CollisionException {
        return this.md.digest();
    }

    @Override // org.eclipse.jgit.util.sha1.SHA1
    public ObjectId toObjectId() throws Sha1CollisionException {
        return ObjectId.fromRaw(this.md.digest());
    }

    @Override // org.eclipse.jgit.util.sha1.SHA1
    public void digest(MutableObjectId mutableObjectId) throws Sha1CollisionException {
        mutableObjectId.fromRaw(this.md.digest());
    }

    @Override // org.eclipse.jgit.util.sha1.SHA1
    public SHA1 reset() {
        this.md.reset();
        return this;
    }
}
