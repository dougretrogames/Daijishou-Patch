package org.eclipse.jgit.transport;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.apache.http.message.TokenParser;
import org.eclipse.jgit.errors.NoRemoteRepositoryException;
import org.eclipse.jgit.errors.NotSupportedException;
import org.eclipse.jgit.errors.TransportException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.util.FS;
import org.eclipse.jgit.util.QuotedString;
import org.eclipse.jgit.util.SystemReader;
import org.eclipse.jgit.util.io.MessageWriter;
import org.eclipse.jgit.util.io.StreamCopyThread;

/* JADX INFO: loaded from: classes5.dex */
public class TransportGitSsh extends SshTransport implements PackTransport {
    private static final String EXT = "ext";
    static final TransportProtocol PROTO_SSH = new AnonymousClass1();

    /* JADX INFO: renamed from: org.eclipse.jgit.transport.TransportGitSsh$1, reason: invalid class name */
    class AnonymousClass1 extends TransportProtocol {
        private final String[] schemeNames;
        private final Set<String> schemeSet;

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public int getDefaultPort() {
            return 22;
        }

        AnonymousClass1() {
            String[] strArr = {"ssh", "ssh+git", "git+ssh"};
            this.schemeNames = strArr;
            this.schemeSet = Collections.unmodifiableSet(new LinkedHashSet(Arrays.asList(strArr)));
        }

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public String getName() {
            return JGitText.get().transportProtoSSH;
        }

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public Set<String> getSchemes() {
            return this.schemeSet;
        }

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public Set<TransportProtocol.URIishField> getRequiredFields() {
            return Collections.unmodifiableSet(EnumSet.of(TransportProtocol.URIishField.HOST, TransportProtocol.URIishField.PATH));
        }

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public Set<TransportProtocol.URIishField> getOptionalFields() {
            return Collections.unmodifiableSet(EnumSet.of(TransportProtocol.URIishField.USER, TransportProtocol.URIishField.PASS, TransportProtocol.URIishField.PORT));
        }

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public boolean canHandle(URIish uRIish, Repository repository, String str) {
            if (uRIish.getScheme() == null) {
                return (uRIish.getHost() == null || uRIish.getPath() == null || uRIish.getHost().length() == 0 || uRIish.getPath().length() == 0) ? false : true;
            }
            return super.canHandle(uRIish, repository, str);
        }

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public Transport open(URIish uRIish, Repository repository, String str) throws NotSupportedException {
            return new TransportGitSsh(repository, uRIish);
        }

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public Transport open(URIish uRIish) throws NotSupportedException, TransportException {
            return new TransportGitSsh(uRIish);
        }
    }

    TransportGitSsh(Repository repository, URIish uRIish) {
        super(repository, uRIish);
        initSshSessionFactory();
    }

    TransportGitSsh(URIish uRIish) {
        super(uRIish);
        initSshSessionFactory();
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.transport.TransportGitSsh$2, reason: invalid class name */
    class AnonymousClass2 extends SshSessionFactory {
        AnonymousClass2() {
        }

        @Override // org.eclipse.jgit.transport.SshSessionFactory
        public RemoteSession getSession(URIish uRIish, CredentialsProvider credentialsProvider, FS fs, int i) throws TransportException {
            return new ExtSession(TransportGitSsh.this, null);
        }

        @Override // org.eclipse.jgit.transport.SshSessionFactory
        public String getType() {
            return TransportGitSsh.EXT;
        }
    }

    private void initSshSessionFactory() {
        if (useExtSession()) {
            setSshSessionFactory(new AnonymousClass2());
        }
    }

    @Override // org.eclipse.jgit.transport.Transport
    public FetchConnection openFetch() throws TransportException {
        return new SshFetchConnection(this);
    }

    @Override // org.eclipse.jgit.transport.Transport
    public FetchConnection openFetch(Collection<RefSpec> collection, String... strArr) throws NotSupportedException, TransportException {
        return new SshFetchConnection(collection, strArr);
    }

    @Override // org.eclipse.jgit.transport.Transport
    public PushConnection openPush() throws TransportException {
        return new SshPushConnection();
    }

    String commandFor(String str) {
        String path = this.uri.getPath();
        if (this.uri.getScheme() != null && this.uri.getPath().startsWith("/~")) {
            path = this.uri.getPath().substring(1);
        }
        return str + TokenParser.SP + QuotedString.BOURNE.quote(path);
    }

    void checkExecFailure(int i, String str, String str2) throws TransportException {
        if (i == 127) {
            throw new TransportException(this.uri, MessageFormat.format(JGitText.get().cannotExecute, commandFor(str)), (str2 == null || str2.length() <= 0) ? null : new IOException(str2));
        }
    }

    NoRemoteRepositoryException cleanNotFound(NoRemoteRepositoryException noRemoteRepositoryException, String str) {
        if (str == null || str.length() == 0) {
            return noRemoteRepositoryException;
        }
        String path = this.uri.getPath();
        if (this.uri.getScheme() != null && this.uri.getPath().startsWith("/~")) {
            path = this.uri.getPath().substring(1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("fatal: ");
        sb.append(QuotedString.BOURNE.quote(path));
        sb.append(": ");
        if (str.startsWith(sb.toString())) {
            str = str.substring(sb.length());
        }
        return new NoRemoteRepositoryException(this.uri, str);
    }

    private static boolean useExtSession() {
        return SystemReader.getInstance().getenv("GIT_SSH") != null;
    }

    private class ExtSession implements RemoteSession2 {
        /* synthetic */ ExtSession(TransportGitSsh transportGitSsh, TransportGitSshIA transportGitSshIA) {
            this();
        }

        @Override // org.eclipse.jgit.transport.RemoteSession
        public void disconnect() {
        }

        private ExtSession() {
        }

        @Override // org.eclipse.jgit.transport.RemoteSession
        public Process exec(String str, int i) throws TransportException {
            return exec(str, null, i);
        }

        @Override // org.eclipse.jgit.transport.RemoteSession2
        public Process exec(String str, Map<String, String> map, int i) throws TransportException {
            String str2 = SystemReader.getInstance().getenv("GIT_SSH");
            boolean zContains = str2.toLowerCase(Locale.ROOT).contains("plink");
            ArrayList arrayList = new ArrayList();
            arrayList.add(str2);
            if (zContains && !str2.toLowerCase(Locale.ROOT).contains("tortoiseplink")) {
                arrayList.add("-batch");
            }
            if (TransportGitSsh.this.getURI().getPort() > 0) {
                arrayList.add(zContains ? "-P" : "-p");
                arrayList.add(String.valueOf(TransportGitSsh.this.getURI().getPort()));
            }
            if (TransportGitSsh.this.getURI().getUser() != null) {
                arrayList.add(TransportGitSsh.this.getURI().getUser() + "@" + TransportGitSsh.this.getURI().getHost());
            } else {
                arrayList.add(TransportGitSsh.this.getURI().getHost());
            }
            arrayList.add(str);
            try {
                return createProcess(arrayList, map).start();
            } catch (IOException e) {
                throw new TransportException(e.getMessage(), e);
            }
        }

        private ProcessBuilder createProcess(List<String> list, Map<String, String> map) {
            ProcessBuilder processBuilder = new ProcessBuilder(new String[0]);
            processBuilder.command(list);
            if (map != null) {
                processBuilder.environment().putAll(map);
            }
            File directory = TransportGitSsh.this.local != null ? TransportGitSsh.this.local.getDirectory() : null;
            if (directory != null) {
                processBuilder.environment().put(Constants.GIT_DIR_KEY, directory.getPath());
            }
            File commonDirectory = TransportGitSsh.this.local != null ? TransportGitSsh.this.local.getCommonDirectory() : null;
            if (commonDirectory != null) {
                processBuilder.environment().put(Constants.GIT_COMMON_DIR_KEY, commonDirectory.getPath());
            }
            return processBuilder;
        }
    }

    class SshFetchConnection extends BasePackFetchConnection {
        private StreamCopyThread errorThread;
        private final Process process;

        SshFetchConnection(TransportGitSsh transportGitSsh) throws TransportException {
            this(Collections.emptyList(), new String[0]);
        }

        SshFetchConnection(Collection<RefSpec> collection, String... strArr) throws TransportException {
            super(TransportGitSsh.this);
            try {
                RemoteSession session = TransportGitSsh.this.getSession();
                TransferConfig.ProtocolVersion protocolVersion = TransportGitSsh.this.protocol;
                protocolVersion = protocolVersion == null ? TransferConfig.ProtocolVersion.V2 : protocolVersion;
                if ((session instanceof RemoteSession2) && TransferConfig.ProtocolVersion.V2.equals(protocolVersion)) {
                    this.process = ((RemoteSession2) session).exec(TransportGitSsh.this.commandFor(TransportGitSsh.this.getOptionUploadPack()), Collections.singletonMap(GitProtocolConstants.PROTOCOL_ENVIRONMENT_VARIABLE, GitProtocolConstants.VERSION_2_REQUEST), TransportGitSsh.this.getTimeout());
                } else {
                    this.process = session.exec(TransportGitSsh.this.commandFor(TransportGitSsh.this.getOptionUploadPack()), TransportGitSsh.this.getTimeout());
                }
                MessageWriter messageWriter = new MessageWriter();
                setMessageWriter(messageWriter);
                StreamCopyThread streamCopyThread = new StreamCopyThread(this.process.getErrorStream(), messageWriter.getRawStream());
                this.errorThread = streamCopyThread;
                streamCopyThread.start();
                init(this.process.getInputStream(), this.process.getOutputStream());
                try {
                    if (readAdvertisedRefs()) {
                        return;
                    }
                    lsRefs(collection, strArr);
                } catch (NoRemoteRepositoryException e) {
                    String messages = getMessages();
                    TransportGitSsh.this.checkExecFailure(this.process.exitValue(), TransportGitSsh.this.getOptionUploadPack(), messages);
                    throw TransportGitSsh.this.cleanNotFound(e, messages);
                }
            } catch (TransportException e2) {
                close();
                throw e2;
            } catch (Throwable th) {
                close();
                throw new TransportException(this.uri, JGitText.get().remoteHungUpUnexpectedly, th);
            }
        }

        @Override // org.eclipse.jgit.transport.BasePackFetchConnection, org.eclipse.jgit.transport.BasePackConnection, org.eclipse.jgit.transport.BaseConnection, org.eclipse.jgit.transport.Connection, java.lang.AutoCloseable
        public void close() {
            endOut();
            Process process = this.process;
            if (process != null) {
                process.destroy();
            }
            StreamCopyThread streamCopyThread = this.errorThread;
            if (streamCopyThread != null) {
                try {
                    streamCopyThread.halt();
                } catch (InterruptedException unused) {
                } finally {
                    this.errorThread = null;
                }
            }
            super.close();
        }
    }

    class SshPushConnection extends BasePackPushConnection {
        private StreamCopyThread errorThread;
        private final Process process;

        SshPushConnection() throws TransportException {
            super(TransportGitSsh.this);
            try {
                Process processExec = TransportGitSsh.this.getSession().exec(TransportGitSsh.this.commandFor(TransportGitSsh.this.getOptionReceivePack()), TransportGitSsh.this.getTimeout());
                this.process = processExec;
                MessageWriter messageWriter = new MessageWriter();
                setMessageWriter(messageWriter);
                StreamCopyThread streamCopyThread = new StreamCopyThread(processExec.getErrorStream(), messageWriter.getRawStream());
                this.errorThread = streamCopyThread;
                streamCopyThread.start();
                init(processExec.getInputStream(), processExec.getOutputStream());
                try {
                    readAdvertisedRefs();
                } catch (NoRemoteRepositoryException e) {
                    String messages = getMessages();
                    TransportGitSsh.this.checkExecFailure(this.process.exitValue(), TransportGitSsh.this.getOptionReceivePack(), messages);
                    throw TransportGitSsh.this.cleanNotFound(e, messages);
                }
            } catch (TransportException e2) {
                try {
                    close();
                } catch (Exception unused) {
                }
                throw e2;
            } catch (Throwable th) {
                try {
                    close();
                } catch (Exception unused2) {
                }
                throw new TransportException(this.uri, JGitText.get().remoteHungUpUnexpectedly, th);
            }
        }

        @Override // org.eclipse.jgit.transport.BasePackPushConnection, org.eclipse.jgit.transport.BasePackConnection, org.eclipse.jgit.transport.BaseConnection, org.eclipse.jgit.transport.Connection, java.lang.AutoCloseable
        public void close() {
            endOut();
            Process process = this.process;
            if (process != null) {
                process.destroy();
            }
            StreamCopyThread streamCopyThread = this.errorThread;
            if (streamCopyThread != null) {
                try {
                    streamCopyThread.halt();
                } catch (InterruptedException unused) {
                } finally {
                    this.errorThread = null;
                }
            }
            super.close();
        }
    }
}
