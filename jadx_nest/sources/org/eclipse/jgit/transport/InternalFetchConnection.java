package org.eclipse.jgit.transport;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import org.eclipse.jgit.errors.TransportException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.resolver.ServiceNotAuthorizedException;
import org.eclipse.jgit.transport.resolver.ServiceNotEnabledException;
import org.eclipse.jgit.transport.resolver.UploadPackFactory;

/* JADX INFO: loaded from: classes5.dex */
class InternalFetchConnection<C> extends BasePackFetchConnection {
    private Thread worker;

    public InternalFetchConnection(PackTransport packTransport, UploadPackFactory<C> uploadPackFactory, C c, Repository repository) throws TransportException {
        super(packTransport);
        try {
            PipedInputStream pipedInputStream = new PipedInputStream();
            PipedOutputStream pipedOutputStream = new PipedOutputStream(pipedInputStream);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1();
            PipedOutputStream pipedOutputStream2 = new PipedOutputStream(anonymousClass1);
            AnonymousClass2 anonymousClass2 = new AnonymousClass2("JGit-Upload-Pack", anonymousClass1, pipedOutputStream, repository, uploadPackFactory, c);
            this.worker = anonymousClass2;
            anonymousClass2.start();
            init(pipedInputStream, pipedOutputStream2);
            readAdvertisedRefs();
        } catch (IOException e) {
            repository.close();
            throw new TransportException(this.uri, JGitText.get().cannotConnectPipes, e);
        }
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.transport.InternalFetchConnection$1, reason: invalid class name */
    class AnonymousClass1 extends PipedInputStream {
        AnonymousClass1() {
            this.buffer = new byte[2952];
        }
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.transport.InternalFetchConnection$2, reason: invalid class name */
    class AnonymousClass2 extends Thread {
        private final /* synthetic */ PipedOutputStream val$in_w;
        private final /* synthetic */ PipedInputStream val$out_r;
        private final /* synthetic */ Repository val$remote;
        private final /* synthetic */ Object val$req;
        private final /* synthetic */ UploadPackFactory val$uploadPackFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, PipedInputStream pipedInputStream, PipedOutputStream pipedOutputStream, Repository repository, UploadPackFactory uploadPackFactory, Object obj) {
            super(str);
            this.val$out_r = pipedInputStream;
            this.val$in_w = pipedOutputStream;
            this.val$remote = repository;
            this.val$uploadPackFactory = uploadPackFactory;
            this.val$req = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            PipedOutputStream pipedOutputStream;
            try {
                try {
                    try {
                        try {
                            this.val$uploadPackFactory.create(this.val$req, this.val$remote).upload(this.val$out_r, this.val$in_w, null);
                            try {
                                this.val$out_r.close();
                            } catch (IOException unused) {
                            }
                            pipedOutputStream = this.val$in_w;
                        } catch (IOException unused2) {
                        }
                    } catch (IOException unused3) {
                        pipedOutputStream = this.val$in_w;
                    }
                } catch (IOException e) {
                    e = e;
                    e.printStackTrace();
                    try {
                        this.val$out_r.close();
                    } catch (IOException unused4) {
                    }
                    pipedOutputStream = this.val$in_w;
                } catch (RuntimeException e2) {
                    e = e2;
                    e.printStackTrace();
                    this.val$out_r.close();
                    pipedOutputStream = this.val$in_w;
                } catch (ServiceNotAuthorizedException | ServiceNotEnabledException unused5) {
                    this.val$out_r.close();
                    pipedOutputStream = this.val$in_w;
                    pipedOutputStream.close();
                }
                pipedOutputStream.close();
            } finally {
                try {
                    this.val$out_r.close();
                } catch (IOException unused6) {
                }
                try {
                    this.val$in_w.close();
                } catch (IOException unused7) {
                }
                this.val$remote.close();
            }
        }
    }

    @Override // org.eclipse.jgit.transport.BasePackFetchConnection, org.eclipse.jgit.transport.BasePackConnection, org.eclipse.jgit.transport.BaseConnection, org.eclipse.jgit.transport.Connection, java.lang.AutoCloseable
    public void close() {
        super.close();
        try {
            Thread thread = this.worker;
            if (thread != null) {
                thread.join();
            }
        } catch (InterruptedException unused) {
        } finally {
            this.worker = null;
        }
    }
}
