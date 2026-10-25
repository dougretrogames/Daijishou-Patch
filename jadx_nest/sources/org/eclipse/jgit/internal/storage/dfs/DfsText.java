package org.eclipse.jgit.internal.storage.dfs;

import org.eclipse.jgit.nls.NLS;
import org.eclipse.jgit.nls.TranslationBundle;

/* JADX INFO: loaded from: classes5.dex */
public class DfsText extends TranslationBundle {
    public String cannotReadCommitGraph;
    public String cannotReadIndex;
    public String shortReadOfBlock;
    public String shortReadOfIndex;
    public String willNotStoreEmptyPack;

    public static DfsText get() {
        return (DfsText) NLS.getBundleFor(DfsText.class);
    }
}
