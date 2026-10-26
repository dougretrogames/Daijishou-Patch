package org.eclipse.jgit.dircache;

import java.io.IOException;
import org.eclipse.jgit.errors.DirCacheNameConflictException;
import org.eclipse.jgit.util.Paths;

/* INFO: loaded from: classes5.dex */
abstract class BaseDirCacheEditor {
    protected DirCache cache;
    protected DirCacheEntry[] entries;
    protected int entryCnt;

    public abstract void finish();

    protected BaseDirCacheEditor(DirCache dirCache, int i) {
        this.cache = dirCache;
        this.entries = new DirCacheEntry[i];
    }

    public DirCache getDirCache() {
        return this.cache;
    }

    protected void fastAdd(DirCacheEntry dirCacheEntry) {
        DirCacheEntry[] dirCacheEntryArr = this.entries;
        int length = dirCacheEntryArr.length;
        int i = this.entryCnt;
        if (length == i) {
            DirCacheEntry[] dirCacheEntryArr2 = new DirCacheEntry[((i + 16) * 3) / 2];
            System.arraycopy(dirCacheEntryArr, 0, dirCacheEntryArr2, 0, i);
            this.entries = dirCacheEntryArr2;
        }
        DirCacheEntry[] dirCacheEntryArr3 = this.entries;
        int i2 = this.entryCnt;
        this.entryCnt = i2 + 1;
        dirCacheEntryArr3[i2] = dirCacheEntry;
    }

    protected void fastKeep(int i, int i2) {
        int i3 = this.entryCnt;
        if (i3 + i2 > this.entries.length) {
            DirCacheEntry[] dirCacheEntryArr = new DirCacheEntry[Math.max(((i3 + 16) * 3) / 2, i3 + i2)];
            System.arraycopy(this.entries, 0, dirCacheEntryArr, 0, this.entryCnt);
            this.entries = dirCacheEntryArr;
        }
        this.cache.toArray(i, this.entries, this.entryCnt, i2);
        this.entryCnt += i2;
    }

    protected void replace() {
        checkNameConflicts();
        int i = this.entryCnt;
        DirCacheEntry[] dirCacheEntryArr = this.entries;
        if (i < dirCacheEntryArr.length / 2) {
            DirCacheEntry[] dirCacheEntryArr2 = new DirCacheEntry[i];
            System.arraycopy(dirCacheEntryArr, 0, dirCacheEntryArr2, 0, i);
            this.entries = dirCacheEntryArr2;
        }
        this.cache.replace(this.entries, this.entryCnt);
    }

    private void checkNameConflicts() {
        int i = this.entryCnt - 1;
        for (int i2 = 0; i2 < i; i2++) {
            DirCacheEntry dirCacheEntry = this.entries[i2];
            if (dirCacheEntry.getStage() == 0) {
                byte[] bArr = dirCacheEntry.path;
                int iLastSlash = lastSlash(bArr) + 1;
                for (int i3 = i2 + 1; i3 < this.entryCnt; i3++) {
                    DirCacheEntry dirCacheEntry2 = this.entries[i3];
                    if (dirCacheEntry2.getStage() == 0) {
                        byte[] bArr2 = dirCacheEntry2.path;
                        if (!startsWith(bArr, bArr2, iLastSlash)) {
                            break;
                        }
                        int iNextSlash = nextSlash(bArr2, iLastSlash);
                        int iCompareSameName = Paths.compareSameName(bArr, iLastSlash, bArr.length, bArr2, iLastSlash, iNextSlash, iNextSlash < bArr2.length ? 16384 : dirCacheEntry2.getRawMode());
                        if (iCompareSameName < 0) {
                            break;
                        } else if (iCompareSameName == 0) {
                            throw new DirCacheNameConflictException(dirCacheEntry.getPathString(), dirCacheEntry2.getPathString());
                        }
                    }
                }
            }
        }
    }

    private static int lastSlash(byte[] bArr) {
        for (int length = bArr.length - 1; length >= 0; length--) {
            if (bArr[length] == 47) {
                return length;
            }
        }
        return -1;
    }

    private static int nextSlash(byte[] bArr, int i) {
        int length = bArr.length;
        while (i < length) {
            if (bArr[i] == 47) {
                return i;
            }
            i++;
        }
        return length;
    }

    private static boolean startsWith(byte[] bArr, byte[] bArr2, int i) {
        if (bArr2.length < i) {
            return false;
        }
        do {
            i--;
            if (i < 0) {
                return true;
            }
        } while (bArr[i] == bArr2[i]);
        return false;
    }

    public boolean commit() throws IOException {
        finish();
        this.cache.write();
        return this.cache.commit();
    }
}
