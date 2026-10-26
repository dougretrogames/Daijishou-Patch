package org.eclipse.jgit.api;

import org.eclipse.jgit.api.GitCommand;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.Transport;

/* INFO: loaded from: classes5.dex */
public abstract class TransportCommand<C extends GitCommand, T> extends GitCommand<T> {
    protected CredentialsProvider credentialsProvider;
    protected int timeout;
    protected TransportConfigCallback transportConfigCallback;

    protected final C self() {
        return this;
    }

    protected TransportCommand(Repository repository) {
        super(repository);
        setCredentialsProvider(CredentialsProvider.getDefault());
    }

    public C setCredentialsProvider(CredentialsProvider credentialsProvider) {
        this.credentialsProvider = credentialsProvider;
        return (C) self();
    }

    public C setTimeout(int i) {
        this.timeout = i;
        return (C) self();
    }

    public C setTransportConfigCallback(TransportConfigCallback transportConfigCallback) {
        this.transportConfigCallback = transportConfigCallback;
        return (C) self();
    }

    protected C configure(Transport transport) {
        CredentialsProvider credentialsProvider = this.credentialsProvider;
        if (credentialsProvider != null) {
            transport.setCredentialsProvider(credentialsProvider);
        }
        transport.setTimeout(this.timeout);
        TransportConfigCallback transportConfigCallback = this.transportConfigCallback;
        if (transportConfigCallback != null) {
            transportConfigCallback.configure(transport);
        }
        return (C) self();
    }

    protected C configure(TransportCommand transportCommand) {
        transportCommand.setCredentialsProvider(this.credentialsProvider);
        transportCommand.setTimeout(this.timeout);
        transportCommand.setTransportConfigCallback(this.transportConfigCallback);
        return (C) self();
    }
}
