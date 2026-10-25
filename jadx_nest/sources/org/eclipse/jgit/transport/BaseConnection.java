package org.eclipse.jgit.transport;

import java.io.StringWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.eclipse.jgit.errors.TransportException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Ref;

/* JADX INFO: loaded from: classes5.dex */
public abstract class BaseConnection implements Connection {
    private Map<String, Ref> advertisedRefs = Collections.emptyMap();
    private Writer messageWriter;
    private String peerUserAgent;
    private boolean startedOperation;

    @Override // org.eclipse.jgit.transport.Connection, java.lang.AutoCloseable
    public abstract void close();

    @Override // org.eclipse.jgit.transport.Connection
    public Map<String, Ref> getRefsMap() {
        return this.advertisedRefs;
    }

    @Override // org.eclipse.jgit.transport.Connection
    public final Collection<Ref> getRefs() {
        return this.advertisedRefs.values();
    }

    @Override // org.eclipse.jgit.transport.Connection
    public final Ref getRef(String str) {
        return this.advertisedRefs.get(str);
    }

    @Override // org.eclipse.jgit.transport.Connection
    public String getMessages() {
        Writer writer = this.messageWriter;
        return writer != null ? writer.toString() : "";
    }

    @Override // org.eclipse.jgit.transport.Connection
    public String getPeerUserAgent() {
        return this.peerUserAgent;
    }

    protected void setPeerUserAgent(String str) {
        this.peerUserAgent = str;
    }

    protected void available(Map<String, Ref> map) {
        this.advertisedRefs = Collections.unmodifiableMap(map);
    }

    protected void markStartedOperation() throws TransportException {
        if (this.startedOperation) {
            throw new TransportException(JGitText.get().onlyOneOperationCallPerConnectionIsSupported);
        }
        this.startedOperation = true;
    }

    protected Writer getMessageWriter() {
        if (this.messageWriter == null) {
            setMessageWriter(new StringWriter());
        }
        return this.messageWriter;
    }

    protected void setMessageWriter(Writer writer) {
        if (this.messageWriter != null) {
            throw new IllegalStateException(JGitText.get().writerAlreadyInitialized);
        }
        this.messageWriter = writer;
    }
}
