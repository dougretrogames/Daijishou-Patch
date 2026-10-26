package org.eclipse.jgit.hooks;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Collection;
import org.eclipse.jgit.api.errors.AbortedByHookException;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.RemoteRefUpdate;

/* INFO: loaded from: classes5.dex */
public class PrePushHook extends GitHook<String> {
    public static final String NAME = "pre-push";
    private boolean dryRun;
    private String refs;
    private String remoteLocation;
    private String remoteName;

    private boolean canRun() {
        return true;
    }

    protected PrePushHook(Repository repository, PrintStream printStream) {
        super(repository, printStream);
    }

    protected PrePushHook(Repository repository, PrintStream printStream, PrintStream printStream2) {
        super(repository, printStream, printStream2);
    }

    @Override // org.eclipse.jgit.hooks.GitHook
    protected String getStdinArgs() {
        return this.refs;
    }

    @Override // org.eclipse.jgit.hooks.GitHook, java.util.concurrent.Callable
    public String call() throws AbortedByHookException, IOException {
        if (canRun()) {
            doRun();
            return "";
        }
        return "";
    }

    @Override // org.eclipse.jgit.hooks.GitHook
    public String getHookName() {
        return NAME;
    }

    @Override // org.eclipse.jgit.hooks.GitHook
    protected String[] getParameters() {
        if (this.remoteName == null) {
            this.remoteName = this.remoteLocation;
        }
        return new String[]{this.remoteName, this.remoteLocation};
    }

    public void setRemoteName(String str) {
        this.remoteName = str;
    }

    protected String getRemoteName() {
        return this.remoteName;
    }

    public void setRemoteLocation(String str) {
        this.remoteLocation = str;
    }

    public void setDryRun(boolean z) {
        this.dryRun = z;
    }

    protected boolean isDryRun() {
        return this.dryRun;
    }

    public void setRefs(Collection<RemoteRefUpdate> collection) {
        String name;
        StringBuilder sb = new StringBuilder();
        for (RemoteRefUpdate remoteRefUpdate : collection) {
            sb.append(remoteRefUpdate.getSrcRef());
            sb.append(" ");
            sb.append(remoteRefUpdate.getNewObjectId().getName());
            sb.append(" ");
            sb.append(remoteRefUpdate.getRemoteName());
            sb.append(" ");
            ObjectId expectedOldObjectId = remoteRefUpdate.getExpectedOldObjectId();
            if (expectedOldObjectId == null) {
                name = ObjectId.zeroId().getName();
            } else {
                name = expectedOldObjectId.getName();
            }
            sb.append(name);
            sb.append("\n");
        }
        this.refs = sb.toString();
    }
}
