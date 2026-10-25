package org.eclipse.jgit.dircache;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Arrays;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.FileMode;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.treewalk.CanonicalTreeParser;

/* JADX INFO: loaded from: classes5.dex */
public class DirCacheBuilder extends BaseDirCacheEditor {
    private boolean sorted;

    @Override // org.eclipse.jgit.dircache.BaseDirCacheEditor
    public /* bridge */ /* synthetic */ boolean commit() throws IOException {
        return super.commit();
    }

    @Override // org.eclipse.jgit.dircache.BaseDirCacheEditor
    public /* bridge */ /* synthetic */ DirCache getDirCache() {
        return super.getDirCache();
    }

    protected DirCacheBuilder(DirCache dirCache, int i) {
        super(dirCache, i);
    }

    public void add(DirCacheEntry dirCacheEntry) {
        if (dirCacheEntry.getRawMode() == 0) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().fileModeNotSetForPath, dirCacheEntry.getPathString()));
        }
        beforeAdd(dirCacheEntry);
        fastAdd(dirCacheEntry);
    }

    public void keep(int i, int i2) {
        beforeAdd(this.cache.getEntry(i));
        fastKeep(i, i2);
    }

    public void addTree(byte[] bArr, int i, ObjectReader objectReader, AnyObjectId anyObjectId) throws IOException {
        CanonicalTreeParser canonicalTreeParserCreateTreeParser = createTreeParser(bArr, objectReader, anyObjectId);
        while (!canonicalTreeParserCreateTreeParser.eof()) {
            if (isTree(canonicalTreeParserCreateTreeParser)) {
                canonicalTreeParserCreateTreeParser = enterTree(canonicalTreeParserCreateTreeParser, objectReader);
            } else {
                DirCacheEntry entry = toEntry(i, canonicalTreeParserCreateTreeParser);
                beforeAdd(entry);
                fastAdd(entry);
                canonicalTreeParserCreateTreeParser = canonicalTreeParserCreateTreeParser.next();
                break;
            }
        }
        while (!canonicalTreeParserCreateTreeParser.eof()) {
            if (isTree(canonicalTreeParserCreateTreeParser)) {
                canonicalTreeParserCreateTreeParser = enterTree(canonicalTreeParserCreateTreeParser, objectReader);
            } else {
                fastAdd(toEntry(i, canonicalTreeParserCreateTreeParser));
                canonicalTreeParserCreateTreeParser = canonicalTreeParserCreateTreeParser.next();
            }
        }
    }

    private static CanonicalTreeParser createTreeParser(byte[] bArr, ObjectReader objectReader, AnyObjectId anyObjectId) throws IOException {
        return new CanonicalTreeParser(bArr, objectReader, anyObjectId);
    }

    private static boolean isTree(CanonicalTreeParser canonicalTreeParser) {
        return (canonicalTreeParser.getEntryRawMode() & FileMode.TYPE_MASK) == 16384;
    }

    private static CanonicalTreeParser enterTree(CanonicalTreeParser canonicalTreeParser, ObjectReader objectReader) throws IOException {
        CanonicalTreeParser canonicalTreeParserCreateSubtreeIterator = canonicalTreeParser.createSubtreeIterator(objectReader);
        return canonicalTreeParserCreateSubtreeIterator.eof() ? canonicalTreeParserCreateSubtreeIterator.next() : canonicalTreeParserCreateSubtreeIterator;
    }

    private static DirCacheEntry toEntry(int i, CanonicalTreeParser canonicalTreeParser) {
        byte[] entryPathBuffer = canonicalTreeParser.getEntryPathBuffer();
        int entryPathLength = canonicalTreeParser.getEntryPathLength();
        byte[] bArr = new byte[entryPathLength];
        System.arraycopy(entryPathBuffer, 0, bArr, 0, entryPathLength);
        DirCacheEntry dirCacheEntry = new DirCacheEntry(bArr, i);
        dirCacheEntry.setFileMode(canonicalTreeParser.getEntryRawMode());
        dirCacheEntry.setObjectIdFromRaw(canonicalTreeParser.idBuffer(), canonicalTreeParser.idOffset());
        return dirCacheEntry;
    }

    @Override // org.eclipse.jgit.dircache.BaseDirCacheEditor
    public void finish() {
        if (!this.sorted) {
            resort();
        }
        replace();
    }

    private void beforeAdd(DirCacheEntry dirCacheEntry) {
        if (!this.sorted || this.entryCnt <= 0) {
            return;
        }
        DirCacheEntry dirCacheEntry2 = this.entries[this.entryCnt - 1];
        int iCmp = DirCache.cmp(dirCacheEntry2, dirCacheEntry);
        if (iCmp > 0) {
            this.sorted = false;
            return;
        }
        if (iCmp == 0) {
            int stage = dirCacheEntry2.getStage();
            int stage2 = dirCacheEntry.getStage();
            if (stage == stage2) {
                throw bad(dirCacheEntry, JGitText.get().duplicateStagesNotAllowed);
            }
            if (stage == 0 || stage2 == 0) {
                throw bad(dirCacheEntry, JGitText.get().mixedStagesNotAllowed);
            }
            if (stage > stage2) {
                this.sorted = false;
            }
        }
    }

    private void resort() {
        Arrays.sort(this.entries, 0, this.entryCnt, DirCache.ENT_CMP);
        for (int i = 1; i < this.entryCnt; i++) {
            DirCacheEntry dirCacheEntry = this.entries[i - 1];
            DirCacheEntry dirCacheEntry2 = this.entries[i];
            if (DirCache.cmp(dirCacheEntry, dirCacheEntry2) == 0) {
                int stage = dirCacheEntry.getStage();
                int stage2 = dirCacheEntry2.getStage();
                if (stage == stage2) {
                    throw bad(dirCacheEntry2, JGitText.get().duplicateStagesNotAllowed);
                }
                if (stage == 0 || stage2 == 0) {
                    throw bad(dirCacheEntry2, JGitText.get().mixedStagesNotAllowed);
                }
            }
        }
        this.sorted = true;
    }

    private static IllegalStateException bad(DirCacheEntry dirCacheEntry, String str) {
        return new IllegalStateException(String.format("%s: %d %s", str, Integer.valueOf(dirCacheEntry.getStage()), dirCacheEntry.getPathString()));
    }
}
