package org.eclipse.jgit.api;

import java.net.URISyntaxException;
import java.util.List;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.RemoteConfig;

/* JADX INFO: loaded from: classes5.dex */
public class RemoteListCommand extends GitCommand<List<RemoteConfig>> {
    protected RemoteListCommand(Repository repository) {
        super(repository);
    }

    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public List<RemoteConfig> call() throws GitAPIException {
        checkCallable();
        try {
            return RemoteConfig.getAllRemoteConfigs(this.repo.getConfig());
        } catch (URISyntaxException e) {
            throw new JGitInternalException(e.getMessage(), e);
        }
    }
}
