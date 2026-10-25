package org.eclipse.jgit.internal.storage.dfs;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Collections;
import org.eclipse.jgit.attributes.AttributesNode;
import org.eclipse.jgit.attributes.AttributesNodeProvider;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.RefUpdate;
import org.eclipse.jgit.lib.ReflogReader;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.StoredConfig;

/* JADX INFO: loaded from: classes5.dex */
public abstract class DfsRepository extends Repository {
    private final DfsConfig config;
    private final DfsRepositoryDescription description;

    @Override // org.eclipse.jgit.lib.Repository
    public abstract DfsObjDatabase getObjectDatabase();

    @Override // org.eclipse.jgit.lib.Repository
    public void notifyIndexChanged(boolean z) {
    }

    protected DfsRepository(DfsRepositoryBuilder dfsRepositoryBuilder) {
        super(dfsRepositoryBuilder);
        this.config = new DfsConfig();
        this.description = dfsRepositoryBuilder.getRepositoryDescription();
    }

    public DfsRepositoryDescription getDescription() {
        return this.description;
    }

    public boolean exists() throws IOException {
        if (getRefDatabase() instanceof DfsRefDatabase) {
            return ((DfsRefDatabase) getRefDatabase()).exists();
        }
        return true;
    }

    @Override // org.eclipse.jgit.lib.Repository
    public void create(boolean z) throws IOException {
        if (exists()) {
            throw new IOException(MessageFormat.format(JGitText.get().repositoryAlreadyExists, ""));
        }
        RefUpdate.Result resultLink = updateRef("HEAD", true).link("refs/heads/master");
        if (resultLink != RefUpdate.Result.NEW) {
            throw new IOException(resultLink.name());
        }
    }

    @Override // org.eclipse.jgit.lib.Repository
    public StoredConfig getConfig() {
        return this.config;
    }

    @Override // org.eclipse.jgit.lib.Repository
    public String getIdentifier() {
        return getDescription().getRepositoryName();
    }

    @Override // org.eclipse.jgit.lib.Repository
    public void scanForRepoChanges() throws IOException {
        getRefDatabase().refresh();
        getObjectDatabase().clearCache();
    }

    @Override // org.eclipse.jgit.lib.Repository
    public ReflogReader getReflogReader(String str) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // org.eclipse.jgit.lib.Repository
    public AttributesNodeProvider createAttributesNodeProvider() {
        return new EmptyAttributesNodeProvider(null);
    }

    private static class EmptyAttributesNodeProvider implements AttributesNodeProvider {
        private EmptyAttributesNode emptyAttributesNode;

        /* synthetic */ EmptyAttributesNodeProvider(DfsRepositoryIA dfsRepositoryIA) {
            this();
        }

        private EmptyAttributesNodeProvider() {
            this.emptyAttributesNode = new EmptyAttributesNode();
        }

        @Override // org.eclipse.jgit.attributes.AttributesNodeProvider
        public AttributesNode getInfoAttributesNode() throws IOException {
            return this.emptyAttributesNode;
        }

        @Override // org.eclipse.jgit.attributes.AttributesNodeProvider
        public AttributesNode getGlobalAttributesNode() throws IOException {
            return this.emptyAttributesNode;
        }

        private static class EmptyAttributesNode extends AttributesNode {
            @Override // org.eclipse.jgit.attributes.AttributesNode
            public void parse(InputStream inputStream) throws IOException {
            }

            public EmptyAttributesNode() {
                super(Collections.emptyList());
            }
        }
    }
}
