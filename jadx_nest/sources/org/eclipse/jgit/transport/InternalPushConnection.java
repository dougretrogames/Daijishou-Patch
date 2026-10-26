package org.eclipse.jgit.transport;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.UncheckedIOException;
import org.eclipse.jgit.errors.TransportException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.resolver.ReceivePackFactory;
import org.eclipse.jgit.transport.resolver.ServiceNotAuthorizedException;
import org.eclipse.jgit.transport.resolver.ServiceNotEnabledException;

/* INFO: loaded from: classes5.dex */
class InternalPushConnection<C> extends BasePackPushConnection {
    private Thread worker;

    public InternalPushConnection(PackTransport packTransport, ReceivePackFactory<C> receivePackFactory, C c, Repository repository) throws TransportException {
        super(packTransport);
        try {
            PipedInputStream pipedInputStream = new PipedInputStream();
            PipedOutputStream pipedOutputStream = new PipedOutputStream(pipedInputStream);
            PipedInputStream pipedInputStream2 = new PipedInputStream();
            PipedOutputStream pipedOutputStream2 = new PipedOutputStream(pipedInputStream2);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1("JGit-Receive-Pack", pipedInputStream2, pipedOutputStream, repository, receivePackFactory, c);
            this.worker = anonymousClass1;
            anonymousClass1.start();
            init(pipedInputStream, pipedOutputStream2);
            readAdvertisedRefs();
        } catch (IOException e) {
            repository.close();
            throw new TransportException(this.uri, JGitText.get().cannotConnectPipes, e);
        }
    }

    /* INFO: renamed from: org.eclipse.jgit.transport.InternalPushConnection$1, reason: invalid class name */
    class AnonymousClass1 extends Thread {
        private final /* synthetic */ PipedOutputStream val$in_w;
        private final /* synthetic */ PipedInputStream val$out_r;
        private final /* synthetic */ ReceivePackFactory val$receivePackFactory;
        private final /* synthetic */ Repository val$remote;
        private final /* synthetic */ Object val$req;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, PipedInputStream pipedInputStream, PipedOutputStream pipedOutputStream, Repository repository, ReceivePackFactory receivePackFactory, Object obj) {
            super(str);
            this.val$out_r = pipedInputStream;
            this.val$in_w = pipedOutputStream;
            this.val$remote = repository;
            this.val$receivePackFactory = receivePackFactory;
            this.val$req = obj;
        }

        /* WARN: Multi-variable type inference failed */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            PipedOutputStream pipedOutputStream;
            try {
                try {
                    try {
                        try {
                            this.val$receivePackFactory.create(this.val$req, this.val$remote).receive(this.val$out_r, this.val$in_w, System.err);
                            try {
                                this.val$out_r.close();
                            } catch (IOException unused) {
                            }
                            pipedOutputStream = this.val$in_w;
                        } catch (IOException unused2) {
                            pipedOutputStream = this.val$in_w;
                        }
                    } catch (Throwable th) {
                        try {
                            this.val$out_r.close();
                        } catch (IOException unused3) {
                        }
                        try {
                            this.val$in_w.close();
                        } catch (IOException unused4) {
                        }
                        this.val$remote.close();
                        throw th;
                    }
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                } catch (ServiceNotAuthorizedException | ServiceNotEnabledException unused5) {
                    this.val$out_r.close();
                    pipedOutputStream = this.val$in_w;
                    pipedOutputStream.close();
                    this.val$remote.close();
                }
                pipedOutputStream.close();
            } catch (IOException unused6) {
            }
            this.val$remote.close();
        }
    }

    @Override // org.eclipse.jgit.transport.BasePackPushConnection, org.eclipse.jgit.transport.BasePackConnection, org.eclipse.jgit.transport.BaseConnection, org.eclipse.jgit.transport.Connection, java.lang.AutoCloseable
    public void close() {
        super.close();
        Thread thread = this.worker;
        if (thread != null) {
            try {
                thread.join();
            } catch (InterruptedException unused) {
            } finally {
                this.worker = null;
            }
        }
    }
}
