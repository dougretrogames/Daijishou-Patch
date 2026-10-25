package org.eclipse.jgit.errors;

import java.io.IOException;
import java.text.MessageFormat;
import org.eclipse.jgit.dircache.DirCacheEntry;
import org.eclipse.jgit.internal.JGitText;

/* JADX INFO: loaded from: classes5.dex */
public class UnmergedPathException extends IOException {
    private static final long serialVersionUID = 1;
    private final DirCacheEntry entry;

    public UnmergedPathException(DirCacheEntry dirCacheEntry) {
        super(MessageFormat.format(JGitText.get().unmergedPath, dirCacheEntry.getPathString()));
        this.entry = dirCacheEntry;
    }

    public DirCacheEntry getDirCacheEntry() {
        return this.entry;
    }
}
