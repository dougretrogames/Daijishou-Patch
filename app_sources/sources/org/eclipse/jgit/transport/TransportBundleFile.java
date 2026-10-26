package org.eclipse.jgit.transport;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.jgit.errors.NotSupportedException;
import org.eclipse.jgit.errors.TransportException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.BranchConfig;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.util.FS;

/* INFO: loaded from: classes5.dex */
class TransportBundleFile extends Transport implements TransportBundle {
    static final TransportProtocol PROTO_BUNDLE = new AnonymousClass1();
    private final File bundle;

    @Override // org.eclipse.jgit.transport.Transport, java.lang.AutoCloseable
    public void close() {
    }

    /* INFO: renamed from: org.eclipse.jgit.transport.TransportBundleFile$1, reason: invalid class name */
    class AnonymousClass1 extends TransportProtocol {
        private final String[] schemeNames;
        private final Set<String> schemeSet;

        AnonymousClass1() {
            String[] strArr = {"bundle", "file"};
            this.schemeNames = strArr;
            this.schemeSet = Collections.unmodifiableSet(new LinkedHashSet(Arrays.asList(strArr)));
        }

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public String getName() {
            return JGitText.get().transportProtoBundleFile;
        }

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public Set<String> getSchemes() {
            return this.schemeSet;
        }

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public boolean canHandle(URIish uRIish, Repository repository, String str) {
            if (uRIish.getPath() != null && uRIish.getPort() <= 0 && uRIish.getUser() == null && uRIish.getPass() == null && uRIish.getHost() == null) {
                return uRIish.getScheme() == null || getSchemes().contains(uRIish.getScheme());
            }
            return false;
        }

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public Transport open(URIish uRIish, Repository repository, String str) throws NotSupportedException, TransportException {
            if ("bundle".equals(uRIish.getScheme())) {
                return new TransportBundleFile(repository, uRIish, FS.DETECTED.resolve(new File(BranchConfig.LOCAL_REPOSITORY), uRIish.getPath()));
            }
            return TransportLocal.PROTO_LOCAL.open(uRIish, repository, str);
        }

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public Transport open(URIish uRIish) throws NotSupportedException, TransportException {
            if ("bundle".equals(uRIish.getScheme())) {
                return new TransportBundleFile(uRIish, FS.DETECTED.resolve(new File(BranchConfig.LOCAL_REPOSITORY), uRIish.getPath()));
            }
            return TransportLocal.PROTO_LOCAL.open(uRIish);
        }
    }

    TransportBundleFile(Repository repository, URIish uRIish, File file) {
        super(repository, uRIish);
        this.bundle = file;
    }

    public TransportBundleFile(URIish uRIish, File file) {
        super(uRIish);
        this.bundle = file;
    }

    @Override // org.eclipse.jgit.transport.Transport
    public FetchConnection openFetch() throws TransportException, NotSupportedException {
        try {
            return new BundleFetchConnection(this, new FileInputStream(this.bundle));
        } catch (FileNotFoundException e) {
            TransportException transportException = new TransportException(this.uri, JGitText.get().notFound);
            transportException.initCause(e);
            throw transportException;
        }
    }

    @Override // org.eclipse.jgit.transport.Transport
    public PushConnection openPush() throws NotSupportedException {
        throw new NotSupportedException(JGitText.get().pushIsNotSupportedForBundleTransport);
    }
}
