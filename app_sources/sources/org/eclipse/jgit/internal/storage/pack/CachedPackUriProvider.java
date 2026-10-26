package org.eclipse.jgit.internal.storage.pack;

import java.io.IOException;
import java.util.Collection;
import org.eclipse.jgit.annotations.Nullable;

/* INFO: loaded from: classes5.dex */
public interface CachedPackUriProvider {
    @Nullable
    PackInfo getInfo(CachedPack cachedPack, Collection<String> collection) throws IOException;

    public static class PackInfo {
        private final String hash;
        private final long size;
        private final String uri;

        public PackInfo(String str, String str2, long j) {
            this.hash = str;
            this.uri = str2;
            this.size = j;
        }

        public String getHash() {
            return this.hash;
        }

        public String getUri() {
            return this.uri;
        }

        public long getSize() {
            return this.size;
        }
    }
}
