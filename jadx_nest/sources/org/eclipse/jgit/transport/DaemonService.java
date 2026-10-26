package org.eclipse.jgit.transport;

import java.io.IOException;
import java.util.Collection;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.resolver.ServiceNotAuthorizedException;
import org.eclipse.jgit.transport.resolver.ServiceNotEnabledException;

/* INFO: loaded from: classes5.dex */
public abstract class DaemonService {
    private final String command;
    private final Config.SectionParser<ServiceConfig> configKey;
    private boolean enabled;
    private boolean overridable;

    abstract void execute(DaemonClient daemonClient, Repository repository, @Nullable Collection<String> collection) throws ServiceNotEnabledException, IOException, ServiceNotAuthorizedException;

    DaemonService(String str, String str2) {
        this.command = str.startsWith("git-") ? str : "git-" + str;
        this.configKey = new DaemonService$$ExternalSyntheticLambda0(this, str2);
        this.overridable = true;
    }

    /* INFO: renamed from: lambda$0$org-eclipse-jgit-transport-DaemonService, reason: not valid java name */
    /* synthetic */ ServiceConfig m5806lambda$0$orgeclipsejgittransportDaemonService(String str, Config config) {
        return new ServiceConfig(this, config, str);
    }

    /* INFO: Access modifiers changed from: private */
    static class ServiceConfig {
        final boolean enabled;

        ServiceConfig(DaemonService daemonService, Config config, String str) {
            this.enabled = config.getBoolean("daemon", str, daemonService.isEnabled());
        }
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    public boolean isOverridable() {
        return this.overridable;
    }

    public void setOverridable(boolean z) {
        this.overridable = z;
    }

    public String getCommandName() {
        return this.command;
    }

    public boolean handles(String str) {
        return this.command.length() + 1 < str.length() && str.charAt(this.command.length()) == ' ' && str.startsWith(this.command);
    }

    void execute(DaemonClient daemonClient, String str, @Nullable Collection<String> collection) throws ServiceNotEnabledException, IOException, ServiceNotAuthorizedException {
        Throwable th = null;
        try {
            Repository repositoryOpenRepository = daemonClient.getDaemon().openRepository(daemonClient, str.substring(this.command.length() + 1));
            try {
                if (isEnabledFor(repositoryOpenRepository)) {
                    execute(daemonClient, repositoryOpenRepository, collection);
                }
            } finally {
                if (repositoryOpenRepository != null) {
                    repositoryOpenRepository.close();
                }
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null != th2) {
                try {
                    th.addSuppressed(th2);
                } catch (ServiceMayNotContinueException e) {
                    new PacketLineOut(daemonClient.getOutputStream()).writeString(GitProtocolConstants.PACKET_ERR + e.getMessage() + "\n");
                    return;
                }
            }
            throw null;
        }
    }

    private boolean isEnabledFor(Repository repository) {
        if (isOverridable()) {
            return ((ServiceConfig) repository.getConfig().get(this.configKey)).enabled;
        }
        return isEnabled();
    }
}
