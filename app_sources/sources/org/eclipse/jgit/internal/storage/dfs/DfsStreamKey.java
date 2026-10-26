package org.eclipse.jgit.internal.storage.dfs;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.internal.storage.pack.PackExt;

/* INFO: loaded from: classes5.dex */
public abstract class DfsStreamKey {
    final int hash;
    final int packExtPos;

    public abstract boolean equals(Object obj);

    public static DfsStreamKey of(DfsRepositoryDescription dfsRepositoryDescription, String str, @Nullable PackExt packExt) {
        return new ByteArrayDfsStreamKey(dfsRepositoryDescription, str.getBytes(StandardCharsets.UTF_8), packExt);
    }

    protected DfsStreamKey(int i, @Nullable PackExt packExt) {
        this.hash = i * 31;
        this.packExtPos = packExt == null ? 0 : packExt.getPosition();
    }

    public int hashCode() {
        return this.hash;
    }

    public String toString() {
        return String.format("DfsStreamKey[hash=%08x]", Integer.valueOf(this.hash));
    }

    private static final class ByteArrayDfsStreamKey extends DfsStreamKey {
        private final byte[] name;
        private final DfsRepositoryDescription repo;

        ByteArrayDfsStreamKey(DfsRepositoryDescription dfsRepositoryDescription, byte[] bArr, @Nullable PackExt packExt) {
            super((dfsRepositoryDescription.hashCode() * 31) + Arrays.hashCode(bArr), packExt);
            this.repo = dfsRepositoryDescription;
            this.name = bArr;
        }

        @Override // org.eclipse.jgit.internal.storage.dfs.DfsStreamKey
        public boolean equals(Object obj) {
            if (obj instanceof ByteArrayDfsStreamKey) {
                ByteArrayDfsStreamKey byteArrayDfsStreamKey = (ByteArrayDfsStreamKey) obj;
                if (this.hash == byteArrayDfsStreamKey.hash && this.repo.equals(byteArrayDfsStreamKey.repo) && Arrays.equals(this.name, byteArrayDfsStreamKey.name)) {
                    return true;
                }
            }
            return false;
        }
    }
}
