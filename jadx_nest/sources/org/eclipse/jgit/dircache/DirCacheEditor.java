package org.eclipse.jgit.dircache;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.util.Paths;

/* JADX INFO: loaded from: classes5.dex */
public class DirCacheEditor extends BaseDirCacheEditor {
    private static final Comparator<PathEdit> EDIT_CMP = new DirCacheEditor$$ExternalSyntheticLambda0();
    private int editIdx;
    private final List<PathEdit> edits;

    @Override // org.eclipse.jgit.dircache.BaseDirCacheEditor
    public /* bridge */ /* synthetic */ DirCache getDirCache() {
        return super.getDirCache();
    }

    static /* synthetic */ int lambda$0(PathEdit pathEdit, PathEdit pathEdit2) {
        byte[] bArr = pathEdit.path;
        byte[] bArr2 = pathEdit2.path;
        return DirCache.cmp(bArr, bArr.length, bArr2, bArr2.length);
    }

    protected DirCacheEditor(DirCache dirCache, int i) {
        super(dirCache, i);
        this.edits = new ArrayList();
    }

    public void add(PathEdit pathEdit) {
        this.edits.add(pathEdit);
    }

    @Override // org.eclipse.jgit.dircache.BaseDirCacheEditor
    public boolean commit() throws IOException {
        if (this.edits.isEmpty()) {
            this.cache.unlock();
            return true;
        }
        return super.commit();
    }

    @Override // org.eclipse.jgit.dircache.BaseDirCacheEditor
    public void finish() {
        if (this.edits.isEmpty()) {
            return;
        }
        applyEdits();
        replace();
    }

    private void applyEdits() {
        int i;
        Collections.sort(this.edits, EDIT_CMP);
        this.editIdx = 0;
        int entryCount = this.cache.getEntryCount();
        int iNextEntry = 0;
        while (this.editIdx < this.edits.size()) {
            List<PathEdit> list = this.edits;
            int i2 = this.editIdx;
            this.editIdx = i2 + 1;
            PathEdit pathEdit = list.get(i2);
            int iFindEntry = this.cache.findEntry(iNextEntry, pathEdit.path, pathEdit.path.length);
            boolean z = iFindEntry < 0;
            if (iFindEntry < 0) {
                iFindEntry = -(iFindEntry + 1);
            }
            int iMin = Math.min(iFindEntry, entryCount) - iNextEntry;
            if (iMin > 0) {
                fastKeep(iNextEntry, iMin);
            }
            if (pathEdit instanceof DeletePath) {
                iNextEntry = z ? iFindEntry : this.cache.nextEntry(iFindEntry);
            } else if (pathEdit instanceof DeleteTree) {
                iNextEntry = this.cache.nextEntry(pathEdit.path, pathEdit.path.length, iFindEntry);
            } else if (z) {
                DirCacheEntry dirCacheEntry = new DirCacheEntry(pathEdit.path);
                pathEdit.apply(dirCacheEntry);
                if (dirCacheEntry.getRawMode() == 0) {
                    throw new IllegalArgumentException(MessageFormat.format(JGitText.get().fileModeNotSetForPath, dirCacheEntry.getPathString()));
                }
                int iDeleteOverlappingSubtree = pathEdit.replace ? deleteOverlappingSubtree(dirCacheEntry, iFindEntry) : iFindEntry;
                fastAdd(dirCacheEntry);
                iNextEntry = iDeleteOverlappingSubtree;
            } else {
                iNextEntry = this.cache.nextEntry(iFindEntry);
                if (iNextEntry > iFindEntry + 1) {
                    DirCacheEntry[] dirCacheEntryArr = new DirCacheEntry[iNextEntry - iFindEntry];
                    int i3 = 0;
                    while (true) {
                        if (iFindEntry >= iNextEntry) {
                            i = i3;
                            break;
                        }
                        DirCacheEntry entry = this.cache.getEntry(iFindEntry);
                        pathEdit.apply(entry);
                        if (entry.getStage() == 0) {
                            fastAdd(entry);
                            i = 0;
                            break;
                        } else {
                            dirCacheEntryArr[i3] = entry;
                            iFindEntry++;
                            i3++;
                        }
                    }
                    for (int i4 = 0; i4 < i; i4++) {
                        fastAdd(dirCacheEntryArr[i4]);
                    }
                } else {
                    DirCacheEntry entry2 = this.cache.getEntry(iFindEntry);
                    pathEdit.apply(entry2);
                    fastAdd(entry2);
                }
            }
        }
        int i5 = entryCount - iNextEntry;
        if (i5 > 0) {
            fastKeep(iNextEntry, i5);
        }
    }

    private int deleteOverlappingSubtree(DirCacheEntry dirCacheEntry, int i) {
        byte[] bArr = dirCacheEntry.path;
        int length = bArr.length;
        for (int iPdir = pdir(bArr, length); iPdir > 0; iPdir = pdir(bArr, iPdir)) {
            int iFindEntry = findEntry(bArr, iPdir);
            if (iFindEntry >= 0) {
                int i2 = this.entryCnt - 1;
                this.entryCnt = i2;
                System.arraycopy(this.entries, iFindEntry + 1, this.entries, iFindEntry, i2 - iFindEntry);
                break;
            }
            int i3 = -(iFindEntry + 1);
            if (i3 < this.entryCnt && inDir(this.entries[i3], bArr, iPdir)) {
                break;
            }
        }
        int entryCount = this.cache.getEntryCount();
        if (i >= entryCount) {
            return entryCount;
        }
        DirCacheEntry entry = this.cache.getEntry(i);
        if (Paths.compare(entry.path, 0, entry.path.length, 0, bArr, 0, length, 16384) < 0) {
            insertEdit(new DeleteTree(bArr));
            return i;
        }
        while (i < entryCount && inDir(this.cache.getEntry(i), bArr, length)) {
            i++;
        }
        return i;
    }

    private int findEntry(byte[] bArr, int i) {
        int i2 = this.entryCnt;
        int i3 = 0;
        while (i3 < i2) {
            int i4 = (i3 + i2) >>> 1;
            int iCmp = DirCache.cmp(bArr, i, this.entries[i4]);
            if (iCmp < 0) {
                i2 = i4;
            } else {
                if (iCmp == 0) {
                    while (i4 > 0 && DirCache.cmp(bArr, i, this.entries[i4 - 1]) == 0) {
                        i4--;
                    }
                    return i4;
                }
                i3 = i4 + 1;
            }
        }
        return -(i3 + 1);
    }

    private void insertEdit(DeleteTree deleteTree) {
        for (int i = this.editIdx; i < this.edits.size(); i++) {
            int iCompare = EDIT_CMP.compare(deleteTree, this.edits.get(i));
            if (iCompare < 0) {
                this.edits.add(i, deleteTree);
                return;
            } else {
                if (iCompare == 0) {
                    return;
                }
            }
        }
        this.edits.add(deleteTree);
    }

    private static boolean inDir(DirCacheEntry dirCacheEntry, byte[] bArr, int i) {
        return dirCacheEntry.path.length > i && dirCacheEntry.path[i] == 47 && DirCacheTree.peq(bArr, dirCacheEntry.path, i);
    }

    private static int pdir(byte[] bArr, int i) {
        do {
            i--;
            if (i <= 0) {
                return 0;
            }
        } while (bArr[i] != 47);
        return i;
    }

    public static abstract class PathEdit {
        final byte[] path;
        boolean replace = true;

        public abstract void apply(DirCacheEntry dirCacheEntry);

        public PathEdit(String str) {
            this.path = Constants.encode(str);
        }

        PathEdit(byte[] bArr) {
            this.path = bArr;
        }

        public PathEdit(DirCacheEntry dirCacheEntry) {
            this.path = dirCacheEntry.path;
        }

        public PathEdit setReplace(boolean z) {
            this.replace = z;
            return this;
        }

        public String toString() {
            return getClass().getSimpleName() + CollectionUtils.DEFAULT_TOSTRING_PREFIX + DirCacheEntry.toString(this.path) + CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
        }
    }

    public static final class DeletePath extends PathEdit {
        public DeletePath(String str) {
            super(str);
        }

        public DeletePath(DirCacheEntry dirCacheEntry) {
            super(dirCacheEntry);
        }

        @Override // org.eclipse.jgit.dircache.DirCacheEditor.PathEdit
        public void apply(DirCacheEntry dirCacheEntry) {
            throw new UnsupportedOperationException(JGitText.get().noApplyInDelete);
        }
    }

    public static final class DeleteTree extends PathEdit {
        /* JADX WARN: Illegal instructions before constructor call */
        public DeleteTree(String str) {
            if (!str.isEmpty() && str.charAt(str.length() - 1) != '/') {
                str = str + InternalZipConstants.ZIP_FILE_SEPARATOR;
            }
            super(str);
        }

        DeleteTree(byte[] bArr) {
            super(appendSlash(bArr));
        }

        private static byte[] appendSlash(byte[] bArr) {
            int length = bArr.length;
            if (length <= 0 || bArr[length - 1] == 47) {
                return bArr;
            }
            byte[] bArr2 = new byte[length + 1];
            System.arraycopy(bArr, 0, bArr2, 0, length);
            bArr2[length] = 47;
            return bArr2;
        }

        @Override // org.eclipse.jgit.dircache.DirCacheEditor.PathEdit
        public void apply(DirCacheEntry dirCacheEntry) {
            throw new UnsupportedOperationException(JGitText.get().noApplyInDelete);
        }
    }
}
