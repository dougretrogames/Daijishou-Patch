package org.eclipse.jgit.treewalk.filter;

import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;
import org.eclipse.jgit.errors.StopWalkException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.treewalk.TreeWalk;
import org.eclipse.jgit.util.RawParseUtils;

/* JADX INFO: loaded from: classes5.dex */
public class PathFilterGroup {
    public static TreeFilter createFromStrings(Collection<String> collection) {
        if (collection.isEmpty()) {
            throw new IllegalArgumentException(JGitText.get().atLeastOnePathIsRequired);
        }
        PathFilter[] pathFilterArr = new PathFilter[collection.size()];
        Iterator<String> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            pathFilterArr[i] = PathFilter.create(it.next());
            i++;
        }
        return create(pathFilterArr);
    }

    public static TreeFilter createFromStrings(String... strArr) {
        if (strArr.length == 0) {
            throw new IllegalArgumentException(JGitText.get().atLeastOnePathIsRequired);
        }
        int length = strArr.length;
        PathFilter[] pathFilterArr = new PathFilter[length];
        for (int i = 0; i < length; i++) {
            pathFilterArr[i] = PathFilter.create(strArr[i]);
        }
        return create(pathFilterArr);
    }

    public static TreeFilter create(Collection<PathFilter> collection) {
        if (collection.isEmpty()) {
            throw new IllegalArgumentException(JGitText.get().atLeastOnePathIsRequired);
        }
        PathFilter[] pathFilterArr = new PathFilter[collection.size()];
        collection.toArray(pathFilterArr);
        return create(pathFilterArr);
    }

    private static TreeFilter create(PathFilter[] pathFilterArr) {
        if (pathFilterArr.length == 1) {
            return new Single(pathFilterArr[0], null);
        }
        return new Group(pathFilterArr, null);
    }

    static class Single extends TreeFilter {
        private final PathFilter path;
        private final byte[] raw;

        /* synthetic */ Single(PathFilter pathFilter, PathFilterGroupIA pathFilterGroupIA) {
            this(pathFilter);
        }

        @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
        public TreeFilter clone() {
            return this;
        }

        private Single(PathFilter pathFilter) {
            this.path = pathFilter;
            this.raw = pathFilter.pathRaw;
        }

        @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
        public boolean include(TreeWalk treeWalk) {
            byte[] bArr = this.raw;
            int iIsPathPrefix = treeWalk.isPathPrefix(bArr, bArr.length);
            if (iIsPathPrefix <= 0) {
                return iIsPathPrefix == 0;
            }
            throw StopWalkException.INSTANCE;
        }

        @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
        public boolean shouldBeRecursive() {
            return this.path.shouldBeRecursive();
        }

        @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
        public String toString() {
            return "FAST_" + this.path.toString();
        }
    }

    static class Group extends TreeFilter {
        private ByteArraySet fullpaths;
        private byte[] max;
        private ByteArraySet prefixes;

        /* synthetic */ Group(PathFilter[] pathFilterArr, PathFilterGroupIA pathFilterGroupIA) {
            this(pathFilterArr);
        }

        @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
        public TreeFilter clone() {
            return this;
        }

        private Group(PathFilter[] pathFilterArr) {
            this.fullpaths = new ByteArraySet(pathFilterArr.length);
            this.prefixes = new ByteArraySet(pathFilterArr.length / 5);
            int i = 0;
            this.max = pathFilterArr[0].pathRaw;
            ByteArraySet.Hasher hasher = new ByteArraySet.Hasher(null, 0);
            for (PathFilter pathFilter : pathFilterArr) {
                hasher.init(pathFilter.pathRaw, pathFilter.pathRaw.length);
                while (hasher.hasNext()) {
                    int iNextHash = hasher.nextHash();
                    if (hasher.hasNext()) {
                        this.prefixes.addIfAbsent(pathFilter.pathRaw, hasher.length(), iNextHash);
                    }
                }
                this.fullpaths.addIfAbsent(pathFilter.pathRaw, pathFilter.pathRaw.length, hasher.getHash());
                if (compare(this.max, pathFilter.pathRaw) < 0) {
                    this.max = pathFilter.pathRaw;
                }
            }
            int length = this.max.length;
            byte[] bArr = new byte[length + 1];
            while (true) {
                byte[] bArr2 = this.max;
                if (i < bArr2.length) {
                    byte b = bArr2[i];
                    if ((b & 255) < 47) {
                        bArr[i] = 47;
                    } else {
                        bArr[i] = b;
                    }
                    i++;
                } else {
                    bArr[length] = 47;
                    this.max = bArr;
                    return;
                }
            }
        }

        private static int compare(byte[] bArr, byte[] bArr2) {
            for (int i = 0; i < bArr.length && i < bArr2.length; i++) {
                int i2 = (bArr[i] & 255) - (bArr2[i] & 255);
                if (i2 != 0) {
                    return i2;
                }
            }
            return bArr.length - bArr2.length;
        }

        @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
        public boolean include(TreeWalk treeWalk) {
            byte[] rawPath = treeWalk.getRawPath();
            ByteArraySet.Hasher hasher = new ByteArraySet.Hasher(rawPath, treeWalk.getPathLength());
            while (hasher.hasNext()) {
                int iNextHash = hasher.nextHash();
                if (this.fullpaths.contains(rawPath, hasher.length(), iNextHash)) {
                    return true;
                }
                if (!hasher.hasNext() && treeWalk.isSubtree() && this.prefixes.contains(rawPath, hasher.length(), iNextHash)) {
                    return true;
                }
            }
            byte[] bArr = this.max;
            if (treeWalk.isPathPrefix(bArr, bArr.length) <= 0) {
                return false;
            }
            throw StopWalkException.INSTANCE;
        }

        @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
        public boolean shouldBeRecursive() {
            return !this.prefixes.isEmpty();
        }

        @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
        public Optional<Set<byte[]>> getPathsBestEffort() {
            Set<byte[]> set = this.fullpaths.toSet();
            if (set.isEmpty()) {
                return Optional.empty();
            }
            return Optional.of(set);
        }

        @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
        public String toString() {
            StringBuilder sb = new StringBuilder("FAST(");
            byte[][] array = this.fullpaths.toArray();
            int length = array.length;
            boolean z = true;
            int i = 0;
            while (i < length) {
                byte[] bArr = array[i];
                if (!z) {
                    sb.append(" OR ");
                }
                sb.append(RawParseUtils.decode(bArr));
                i++;
                z = false;
            }
            sb.append(")");
            return sb.toString();
        }
    }
}
