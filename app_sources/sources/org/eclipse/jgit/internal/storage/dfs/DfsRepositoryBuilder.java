package org.eclipse.jgit.internal.storage.dfs;

import java.io.File;
import java.io.IOException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.dfs.DfsRepository;
import org.eclipse.jgit.internal.storage.dfs.DfsRepositoryBuilder;
import org.eclipse.jgit.lib.BaseRepositoryBuilder;

/* INFO: loaded from: classes5.dex */
public abstract class DfsRepositoryBuilder<B extends DfsRepositoryBuilder, R extends DfsRepository> extends BaseRepositoryBuilder<B, R> {
    private DfsReaderOptions readerOptions;
    private DfsRepositoryDescription repoDesc;

    @Override // org.eclipse.jgit.lib.BaseRepositoryBuilder
    public abstract R build() throws IOException;

    public DfsReaderOptions getReaderOptions() {
        return this.readerOptions;
    }

    public B setReaderOptions(DfsReaderOptions dfsReaderOptions) {
        this.readerOptions = dfsReaderOptions;
        return self();
    }

    public DfsRepositoryDescription getRepositoryDescription() {
        return this.repoDesc;
    }

    public B setRepositoryDescription(DfsRepositoryDescription dfsRepositoryDescription) {
        this.repoDesc = dfsRepositoryDescription;
        return self();
    }

    @Override // org.eclipse.jgit.lib.BaseRepositoryBuilder
    public B setup() throws IOException, IllegalArgumentException {
        super.setup();
        if (getReaderOptions() == null) {
            setReaderOptions(new DfsReaderOptions());
        }
        if (getRepositoryDescription() == null) {
            setRepositoryDescription(new DfsRepositoryDescription());
        }
        return self();
    }

    @Override // org.eclipse.jgit.lib.BaseRepositoryBuilder
    public B setGitDir(File file) {
        if (file != null) {
            throw new IllegalArgumentException();
        }
        return self();
    }

    @Override // org.eclipse.jgit.lib.BaseRepositoryBuilder
    public B setObjectDirectory(File file) {
        if (file != null) {
            throw new IllegalArgumentException();
        }
        return self();
    }

    @Override // org.eclipse.jgit.lib.BaseRepositoryBuilder
    public B addAlternateObjectDirectory(File file) {
        throw new UnsupportedOperationException(JGitText.get().unsupportedAlternates);
    }

    @Override // org.eclipse.jgit.lib.BaseRepositoryBuilder
    public B setWorkTree(File file) {
        if (file != null) {
            throw new IllegalArgumentException();
        }
        return self();
    }

    @Override // org.eclipse.jgit.lib.BaseRepositoryBuilder
    public B setIndexFile(File file) {
        if (file != null) {
            throw new IllegalArgumentException();
        }
        return self();
    }
}
