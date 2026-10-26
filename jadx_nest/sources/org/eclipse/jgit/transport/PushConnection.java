package org.eclipse.jgit.transport;

import java.io.OutputStream;
import java.util.Map;
import org.eclipse.jgit.errors.TransportException;
import org.eclipse.jgit.lib.ProgressMonitor;

/* INFO: loaded from: classes5.dex */
public interface PushConnection extends Connection {
    void push(ProgressMonitor progressMonitor, Map<String, RemoteRefUpdate> map) throws TransportException;

    void push(ProgressMonitor progressMonitor, Map<String, RemoteRefUpdate> map, OutputStream outputStream) throws TransportException;
}
