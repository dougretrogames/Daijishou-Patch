package org.eclipse.jgit.transport;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import org.eclipse.jgit.errors.NoRemoteRepositoryException;
import org.eclipse.jgit.errors.NotSupportedException;
import org.eclipse.jgit.errors.TransportException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.BranchConfig;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.RepositoryBuilder;
import org.eclipse.jgit.lib.RepositoryCache;
import org.eclipse.jgit.transport.resolver.ServiceNotAuthorizedException;
import org.eclipse.jgit.transport.resolver.ServiceNotEnabledException;
import org.eclipse.jgit.util.FS;
import org.eclipse.jgit.util.io.MessageWriter;
import org.eclipse.jgit.util.io.StreamCopyThread;

/* JADX INFO: loaded from: classes5.dex */
class TransportLocal extends Transport implements PackTransport {
    static final TransportProtocol PROTO_LOCAL = new AnonymousClass1();
    private final File remoteGitDir;

    @Override // org.eclipse.jgit.transport.Transport, java.lang.AutoCloseable
    public void close() {
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.transport.TransportLocal$1, reason: invalid class name */
    class AnonymousClass1 extends TransportProtocol {
        AnonymousClass1() {
        }

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public String getName() {
            return JGitText.get().transportProtoLocal;
        }

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public Set<String> getSchemes() {
            return Collections.singleton("file");
        }

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public boolean canHandle(URIish uRIish, Repository repository, String str) {
            if (uRIish.getPath() != null && uRIish.getPort() <= 0 && uRIish.getUser() == null && uRIish.getPass() == null && uRIish.getHost() == null) {
                return uRIish.getScheme() == null || getSchemes().contains(uRIish.getScheme());
            }
            return false;
        }

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public Transport open(URIish uRIish, Repository repository, String str) throws NoRemoteRepositoryException {
            File fileResolve = repository.getFS().resolve(repository.isBare() ? repository.getDirectory() : repository.getWorkTree(), uRIish.getPath());
            if (fileResolve.isFile()) {
                return new TransportBundleFile(repository, uRIish, fileResolve);
            }
            File fileResolve2 = RepositoryCache.FileKey.resolve(fileResolve, repository.getFS());
            if (fileResolve2 == null) {
                throw new NoRemoteRepositoryException(uRIish, JGitText.get().notFound);
            }
            return new TransportLocal(repository, uRIish, fileResolve2);
        }

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public Transport open(URIish uRIish) throws NotSupportedException, TransportException {
            File fileResolve = FS.DETECTED.resolve(new File(BranchConfig.LOCAL_REPOSITORY), uRIish.getPath());
            if (fileResolve.isFile()) {
                return new TransportBundleFile(uRIish, fileResolve);
            }
            File fileResolve2 = RepositoryCache.FileKey.resolve(fileResolve, FS.DETECTED);
            if (fileResolve2 == null) {
                throw new NoRemoteRepositoryException(uRIish, JGitText.get().notFound);
            }
            return new TransportLocal(uRIish, fileResolve2);
        }
    }

    TransportLocal(Repository repository, URIish uRIish, File file) {
        super(repository, uRIish);
        this.remoteGitDir = file;
    }

    TransportLocal(URIish uRIish, File file) {
        super(uRIish);
        this.remoteGitDir = file;
    }

    UploadPack createUploadPack(Repository repository) {
        return new UploadPack(repository);
    }

    ReceivePack createReceivePack(Repository repository) {
        return new ReceivePack(repository);
    }

    private Repository openRepo() throws TransportException {
        try {
            return new RepositoryBuilder().setFS(this.local != null ? this.local.getFS() : FS.DETECTED).setGitDir(this.remoteGitDir).build();
        } catch (IOException e) {
            TransportException transportException = new TransportException(this.uri, JGitText.get().notAGitDirectory);
            transportException.initCause(e);
            throw transportException;
        }
    }

    @Override // org.eclipse.jgit.transport.Transport
    public FetchConnection openFetch() throws TransportException {
        return openFetch(Collections.emptyList(), new String[0]);
    }

    @Override // org.eclipse.jgit.transport.Transport
    public FetchConnection openFetch(Collection<RefSpec> collection, String... strArr) throws TransportException {
        String optionUploadPack = getOptionUploadPack();
        if (!RemoteConfig.DEFAULT_UPLOAD_PACK.equals(optionUploadPack) && !"git upload-pack".equals(optionUploadPack)) {
            return new ForkLocalFetchConnection(collection, strArr);
        }
        return new InternalFetchConnection(this, new TransportLocal$$ExternalSyntheticLambda1(this), null, openRepo());
    }

    /* JADX INFO: renamed from: lambda$0$org-eclipse-jgit-transport-TransportLocal, reason: not valid java name */
    /* synthetic */ UploadPack m5845lambda$0$orgeclipsejgittransportTransportLocal(Void r1, Repository repository) throws ServiceNotEnabledException, ServiceNotAuthorizedException {
        return createUploadPack(repository);
    }

    @Override // org.eclipse.jgit.transport.Transport
    public PushConnection openPush() throws TransportException {
        String optionReceivePack = getOptionReceivePack();
        if (!RemoteConfig.DEFAULT_RECEIVE_PACK.equals(optionReceivePack) && !"git receive-pack".equals(optionReceivePack)) {
            return new ForkLocalPushConnection();
        }
        return new InternalPushConnection(this, new TransportLocal$$ExternalSyntheticLambda0(this), null, openRepo());
    }

    /* JADX INFO: renamed from: lambda$1$org-eclipse-jgit-transport-TransportLocal, reason: not valid java name */
    /* synthetic */ ReceivePack m5846lambda$1$orgeclipsejgittransportTransportLocal(Void r1, Repository repository) throws ServiceNotEnabledException, ServiceNotAuthorizedException {
        return createReceivePack(repository);
    }

    protected Process spawn(String str) throws TransportException {
        return spawn(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Process spawn(String str, TransferConfig.ProtocolVersion protocolVersion) throws TransportException {
        try {
            ProcessBuilder processBuilderRunInShell = this.local.getFS().runInShell(str, new String[]{BranchConfig.LOCAL_REPOSITORY});
            processBuilderRunInShell.directory(this.remoteGitDir);
            Map<String, String> mapEnvironment = processBuilderRunInShell.environment();
            mapEnvironment.remove(Constants.GIT_ALTERNATE_OBJECT_DIRECTORIES_KEY);
            mapEnvironment.remove("GIT_CONFIG");
            mapEnvironment.remove("GIT_CONFIG_PARAMETERS");
            mapEnvironment.remove(Constants.GIT_DIR_KEY);
            mapEnvironment.remove(Constants.GIT_COMMON_DIR_KEY);
            mapEnvironment.remove(Constants.GIT_WORK_TREE_KEY);
            mapEnvironment.remove("GIT_GRAFT_FILE");
            mapEnvironment.remove(Constants.GIT_INDEX_FILE_KEY);
            mapEnvironment.remove("GIT_NO_REPLACE_OBJECTS");
            if (TransferConfig.ProtocolVersion.V2.equals(protocolVersion)) {
                mapEnvironment.put(GitProtocolConstants.PROTOCOL_ENVIRONMENT_VARIABLE, GitProtocolConstants.VERSION_2_REQUEST);
            }
            return processBuilderRunInShell.start();
        } catch (IOException e) {
            throw new TransportException(this.uri, e.getMessage(), e);
        }
    }

    class ForkLocalFetchConnection extends BasePackFetchConnection {
        private Thread errorReaderThread;
        private Process uploadPack;

        ForkLocalFetchConnection(TransportLocal transportLocal) throws TransportException {
            this(Collections.emptyList(), new String[0]);
        }

        ForkLocalFetchConnection(Collection<RefSpec> collection, String... strArr) throws TransportException {
            super(TransportLocal.this);
            MessageWriter messageWriter = new MessageWriter();
            setMessageWriter(messageWriter);
            TransferConfig.ProtocolVersion protocolVersion = TransportLocal.this.protocol;
            Process processSpawn = TransportLocal.this.spawn(TransportLocal.this.getOptionUploadPack(), protocolVersion == null ? TransferConfig.ProtocolVersion.V2 : protocolVersion);
            this.uploadPack = processSpawn;
            StreamCopyThread streamCopyThread = new StreamCopyThread(processSpawn.getErrorStream(), messageWriter.getRawStream());
            this.errorReaderThread = streamCopyThread;
            streamCopyThread.start();
            init(new BufferedInputStream(this.uploadPack.getInputStream()), new BufferedOutputStream(this.uploadPack.getOutputStream()));
            if (readAdvertisedRefs()) {
                return;
            }
            lsRefs(collection, strArr);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.eclipse.jgit.transport.BasePackFetchConnection, org.eclipse.jgit.transport.BasePackConnection, org.eclipse.jgit.transport.BaseConnection, org.eclipse.jgit.transport.Connection, java.lang.AutoCloseable
        public void close() {
            super.close();
            Process process = this.uploadPack;
            if (process != null) {
                try {
                    process.waitFor();
                } catch (InterruptedException unused) {
                } finally {
                    this.uploadPack = null;
                }
            }
            Thread thread = this.errorReaderThread;
            if (thread != null) {
                try {
                    thread.join();
                } catch (InterruptedException unused2) {
                } finally {
                    this.errorReaderThread = null;
                }
            }
        }
    }

    class ForkLocalPushConnection extends BasePackPushConnection {
        private Thread errorReaderThread;
        private Process receivePack;

        ForkLocalPushConnection() throws TransportException {
            super(TransportLocal.this);
            MessageWriter messageWriter = new MessageWriter();
            setMessageWriter(messageWriter);
            Process processSpawn = TransportLocal.this.spawn(TransportLocal.this.getOptionReceivePack());
            this.receivePack = processSpawn;
            StreamCopyThread streamCopyThread = new StreamCopyThread(processSpawn.getErrorStream(), messageWriter.getRawStream());
            this.errorReaderThread = streamCopyThread;
            streamCopyThread.start();
            init(new BufferedInputStream(this.receivePack.getInputStream()), new BufferedOutputStream(this.receivePack.getOutputStream()));
            readAdvertisedRefs();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.eclipse.jgit.transport.BasePackPushConnection, org.eclipse.jgit.transport.BasePackConnection, org.eclipse.jgit.transport.BaseConnection, org.eclipse.jgit.transport.Connection, java.lang.AutoCloseable
        public void close() {
            super.close();
            Process process = this.receivePack;
            if (process != null) {
                try {
                    process.waitFor();
                } catch (InterruptedException unused) {
                } finally {
                    this.receivePack = null;
                }
            }
            Thread thread = this.errorReaderThread;
            if (thread != null) {
                try {
                    thread.join();
                } catch (InterruptedException unused2) {
                } finally {
                    this.errorReaderThread = null;
                }
            }
        }
    }
}
