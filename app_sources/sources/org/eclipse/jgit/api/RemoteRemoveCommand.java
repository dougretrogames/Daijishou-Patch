package org.eclipse.jgit.api;

import java.io.IOException;
import java.net.URISyntaxException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.StoredConfig;
import org.eclipse.jgit.transport.RemoteConfig;

/* INFO: loaded from: classes5.dex */
public class RemoteRemoveCommand extends GitCommand<RemoteConfig> {
    private String remoteName;

    protected RemoteRemoveCommand(Repository repository) {
        super(repository);
    }

    public RemoteRemoveCommand setRemoteName(String str) {
        this.remoteName = str;
        return this;
    }

    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public RemoteConfig call() throws GitAPIException {
        checkCallable();
        try {
            StoredConfig config = this.repo.getConfig();
            RemoteConfig remoteConfig = new RemoteConfig(config, this.remoteName);
            config.unsetSection("remote", this.remoteName);
            config.save();
            return remoteConfig;
        } catch (IOException | URISyntaxException e) {
            throw new JGitInternalException(e.getMessage(), e);
        }
    }
}
