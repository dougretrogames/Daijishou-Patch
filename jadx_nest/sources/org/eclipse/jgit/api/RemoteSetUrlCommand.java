package org.eclipse.jgit.api;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.StoredConfig;
import org.eclipse.jgit.transport.RemoteConfig;
import org.eclipse.jgit.transport.URIish;

/* JADX INFO: loaded from: classes5.dex */
public class RemoteSetUrlCommand extends GitCommand<RemoteConfig> {
    private String remoteName;
    private URIish remoteUri;
    private UriType type;

    public enum UriType {
        FETCH,
        PUSH;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static UriType[] valuesCustom() {
            UriType[] uriTypeArrValuesCustom = values();
            int length = uriTypeArrValuesCustom.length;
            UriType[] uriTypeArr = new UriType[length];
            System.arraycopy(uriTypeArrValuesCustom, 0, uriTypeArr, 0, length);
            return uriTypeArr;
        }
    }

    protected RemoteSetUrlCommand(Repository repository) {
        super(repository);
    }

    public RemoteSetUrlCommand setRemoteName(String str) {
        this.remoteName = str;
        return this;
    }

    public RemoteSetUrlCommand setRemoteUri(URIish uRIish) {
        this.remoteUri = uRIish;
        return this;
    }

    public RemoteSetUrlCommand setUriType(UriType uriType) {
        this.type = uriType;
        return this;
    }

    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public RemoteConfig call() throws GitAPIException {
        checkCallable();
        try {
            StoredConfig config = this.repo.getConfig();
            RemoteConfig remoteConfig = new RemoteConfig(config, this.remoteName);
            if (this.type == UriType.PUSH) {
                List<URIish> pushURIs = remoteConfig.getPushURIs();
                if (pushURIs.size() > 1) {
                    throw new JGitInternalException("remote.newtest.pushurl has multiple values");
                }
                if (pushURIs.size() == 1) {
                    remoteConfig.removePushURI(pushURIs.get(0));
                }
                remoteConfig.addPushURI(this.remoteUri);
            } else {
                List<URIish> uRIs = remoteConfig.getURIs();
                if (uRIs.size() > 1) {
                    throw new JGitInternalException("remote.newtest.url has multiple values");
                }
                if (uRIs.size() == 1) {
                    remoteConfig.removeURI(uRIs.get(0));
                }
                remoteConfig.addURI(this.remoteUri);
            }
            remoteConfig.update(config);
            config.save();
            return remoteConfig;
        } catch (IOException | URISyntaxException e) {
            throw new JGitInternalException(e.getMessage(), e);
        }
    }
}
