package org.eclipse.jgit.transport;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import net.lingala.zip4j.util.InternalZipConstants;
import org.eclipse.jgit.errors.NotSupportedException;
import org.eclipse.jgit.errors.TransportException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.file.RefDirectory;
import org.eclipse.jgit.lib.BranchConfig;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectIdRef;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.SymbolicRef;

/* JADX INFO: loaded from: classes5.dex */
public class TransportSftp extends SshTransport implements WalkTransport {
    static final TransportProtocol PROTO_SFTP = new AnonymousClass1();

    /* JADX INFO: renamed from: org.eclipse.jgit.transport.TransportSftp$1, reason: invalid class name */
    class AnonymousClass1 extends TransportProtocol {
        @Override // org.eclipse.jgit.transport.TransportProtocol
        public int getDefaultPort() {
            return 22;
        }

        AnonymousClass1() {
        }

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public String getName() {
            return JGitText.get().transportProtoSFTP;
        }

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public Set<String> getSchemes() {
            return Collections.singleton(SshConstants.SFTP_SCHEME);
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
        public Transport open(URIish uRIish, Repository repository, String str) throws NotSupportedException {
            return new TransportSftp(repository, uRIish);
        }
    }

    TransportSftp(Repository repository, URIish uRIish) {
        super(repository, uRIish);
    }

    @Override // org.eclipse.jgit.transport.Transport
    public FetchConnection openFetch() throws TransportException {
        SftpObjectDB sftpObjectDB = new SftpObjectDB(this.uri.getPath());
        WalkFetchConnection walkFetchConnection = new WalkFetchConnection(this, sftpObjectDB);
        walkFetchConnection.available(sftpObjectDB.readAdvertisedRefs());
        return walkFetchConnection;
    }

    @Override // org.eclipse.jgit.transport.Transport
    public PushConnection openPush() throws TransportException {
        SftpObjectDB sftpObjectDB = new SftpObjectDB(this.uri.getPath());
        WalkPushConnection walkPushConnection = new WalkPushConnection(this, sftpObjectDB);
        walkPushConnection.available(sftpObjectDB.readAdvertisedRefs());
        return walkPushConnection;
    }

    FtpChannel newSftp() throws IOException {
        FtpChannel ftpChannel = getSession().getFtpChannel();
        ftpChannel.connect(getTimeout(), TimeUnit.SECONDS);
        return ftpChannel;
    }

    class SftpObjectDB extends WalkRemoteObjectDatabase {
        private FtpChannel ftp;
        private final String objectsPath;

        SftpObjectDB(String str) throws TransportException {
            str = str.startsWith("/~") ? str.substring(1) : str;
            str = str.startsWith("~/") ? str.substring(2) : str;
            try {
                FtpChannel ftpChannelNewSftp = TransportSftp.this.newSftp();
                this.ftp = ftpChannelNewSftp;
                ftpChannelNewSftp.cd(str);
                this.ftp.cd(Constants.OBJECTS);
                this.objectsPath = this.ftp.pwd();
            } catch (FtpChannel.FtpException e) {
                throw new TransportException(MessageFormat.format(JGitText.get().cannotEnterObjectsPath, str, e.getMessage()), e);
            } catch (IOException e2) {
                close();
                throw new TransportException(TransportSftp.this.uri, e2.getMessage(), e2);
            }
        }

        SftpObjectDB(SftpObjectDB sftpObjectDB, String str) throws TransportException {
            try {
                FtpChannel ftpChannelNewSftp = TransportSftp.this.newSftp();
                this.ftp = ftpChannelNewSftp;
                ftpChannelNewSftp.cd(sftpObjectDB.objectsPath);
                this.ftp.cd(str);
                this.objectsPath = this.ftp.pwd();
            } catch (FtpChannel.FtpException e) {
                throw new TransportException(MessageFormat.format(JGitText.get().cannotEnterPathFromParent, str, sftpObjectDB.objectsPath, e.getMessage()), e);
            } catch (IOException e2) {
                close();
                throw new TransportException(TransportSftp.this.uri, e2.getMessage(), e2);
            }
        }

        @Override // org.eclipse.jgit.transport.WalkRemoteObjectDatabase
        URIish getURI() {
            return TransportSftp.this.uri.setPath(this.objectsPath);
        }

        @Override // org.eclipse.jgit.transport.WalkRemoteObjectDatabase
        Collection<WalkRemoteObjectDatabase> getAlternates() throws IOException {
            try {
                return readAlternates(Constants.INFO_ALTERNATES);
            } catch (FileNotFoundException unused) {
                return null;
            }
        }

        @Override // org.eclipse.jgit.transport.WalkRemoteObjectDatabase
        WalkRemoteObjectDatabase openAlternate(String str) throws IOException {
            return TransportSftp.this.new SftpObjectDB(this, str);
        }

        @Override // org.eclipse.jgit.transport.WalkRemoteObjectDatabase
        Collection<String> getPackNames() throws IOException {
            ArrayList arrayList = new ArrayList();
            try {
                Collection<FtpChannel.DirEntry> collectionLs = this.ftp.ls(ConfigConstants.CONFIG_PACK_SECTION);
                Set set = (Set) collectionLs.stream().map(new TransportSftp$SftpObjectDB$$ExternalSyntheticLambda0()).collect(Collectors.toSet());
                HashMap map = new HashMap();
                for (FtpChannel.DirEntry dirEntry : collectionLs) {
                    String filename = dirEntry.getFilename();
                    if (filename.startsWith("pack-") && filename.endsWith(".pack")) {
                        if (set.contains(filename.substring(0, filename.length() - 5) + ".idx")) {
                            map.put(filename, Long.valueOf(dirEntry.getModifiedTime()));
                            arrayList.add(filename);
                        }
                    }
                }
                Collections.sort(arrayList, new TransportSftp$SftpObjectDB$$ExternalSyntheticLambda1(map));
                return arrayList;
            } catch (FtpChannel.FtpException e) {
                throw new TransportException(MessageFormat.format(JGitText.get().cannotListPackPath, this.objectsPath, e.getMessage()), e);
            }
        }

        @Override // org.eclipse.jgit.transport.WalkRemoteObjectDatabase
        WalkRemoteObjectDatabase.FileStream open(String str) throws IOException {
            try {
                return new WalkRemoteObjectDatabase.FileStream(this.ftp.get(str));
            } catch (FtpChannel.FtpException e) {
                if (e.getStatus() == 2) {
                    throw new FileNotFoundException(str);
                }
                throw new TransportException(MessageFormat.format(JGitText.get().cannotGetObjectsPath, this.objectsPath, str, e.getMessage()), e);
            }
        }

        @Override // org.eclipse.jgit.transport.WalkRemoteObjectDatabase
        void deleteFile(String str) throws IOException {
            try {
                this.ftp.delete(str);
                int iLastIndexOf = str.lastIndexOf(47);
                while (iLastIndexOf > 0) {
                    try {
                        str = str.substring(0, iLastIndexOf);
                        this.ftp.rmdir(str);
                        iLastIndexOf = str.lastIndexOf(47);
                    } catch (IOException unused) {
                        return;
                    }
                }
            } catch (FtpChannel.FtpException e) {
                throw new TransportException(MessageFormat.format(JGitText.get().cannotDeleteObjectsPath, this.objectsPath, str, e.getMessage()), e);
            }
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0019 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // org.eclipse.jgit.transport.WalkRemoteObjectDatabase
        OutputStream writeFile(String str, ProgressMonitor progressMonitor, String str2) throws IOException {
            IOException e;
            try {
                return this.ftp.put(str);
            } catch (FileNotFoundException unused) {
                mkdir_p(str);
                e = null;
                if (e == null) {
                    try {
                        return this.ftp.put(str);
                    } catch (IOException e2) {
                        e = e2;
                        throw new TransportException(MessageFormat.format(JGitText.get().cannotWriteObjectsPath, this.objectsPath, str, e.getMessage()), e);
                    }
                }
                throw new TransportException(MessageFormat.format(JGitText.get().cannotWriteObjectsPath, this.objectsPath, str, e.getMessage()), e);
            } catch (FtpChannel.FtpException e3) {
                int status = e3.getStatus();
                e = e3;
                if (status == 2) {
                    mkdir_p(str);
                    e = null;
                }
                if (e == null) {
                    return this.ftp.put(str);
                }
                throw new TransportException(MessageFormat.format(JGitText.get().cannotWriteObjectsPath, this.objectsPath, str, e.getMessage()), e);
            }
        }

        @Override // org.eclipse.jgit.transport.WalkRemoteObjectDatabase
        void writeFile(String str, byte[] bArr) throws IOException {
            String str2 = str + Constants.LOCK_SUFFIX;
            try {
                super.writeFile(str2, bArr);
                try {
                    this.ftp.rename(str2, str);
                } catch (IOException e) {
                    throw new TransportException(MessageFormat.format(JGitText.get().cannotWriteObjectsPath, this.objectsPath, str, e.getMessage()), e);
                }
            } catch (IOException e2) {
                try {
                    this.ftp.rm(str2);
                } catch (IOException unused) {
                }
                throw e2;
            }
        }

        /* JADX WARN: Code duplicated, block: B:20:0x0026 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        private void mkdir_p(String str) throws IOException {
            IOException e;
            int iLastIndexOf = str.lastIndexOf(47);
            if (iLastIndexOf <= 0) {
                return;
            }
            String strSubstring = str.substring(0, iLastIndexOf);
            try {
                this.ftp.mkdir(strSubstring);
            } catch (FileNotFoundException unused) {
                mkdir_p(strSubstring);
                e = null;
                if (e == null) {
                    try {
                        this.ftp.mkdir(strSubstring);
                        return;
                    } catch (IOException e2) {
                        e = e2;
                        throw new TransportException(MessageFormat.format(JGitText.get().cannotMkdirObjectPath, this.objectsPath, strSubstring, e.getMessage()), e);
                    }
                }
                throw new TransportException(MessageFormat.format(JGitText.get().cannotMkdirObjectPath, this.objectsPath, strSubstring, e.getMessage()), e);
            } catch (FtpChannel.FtpException e3) {
                int status = e3.getStatus();
                e = e3;
                if (status == 2) {
                    mkdir_p(strSubstring);
                    e = null;
                }
                if (e == null) {
                    this.ftp.mkdir(strSubstring);
                    return;
                }
                throw new TransportException(MessageFormat.format(JGitText.get().cannotMkdirObjectPath, this.objectsPath, strSubstring, e.getMessage()), e);
            }
        }

        Map<String, Ref> readAdvertisedRefs() throws Throwable {
            TreeMap<String, Ref> treeMap = new TreeMap<>();
            readPackedRefs(treeMap);
            readRef(treeMap, "../HEAD", "HEAD");
            readLooseRefs(treeMap, "../refs", Constants.R_REFS);
            return treeMap;
        }

        private void readLooseRefs(TreeMap<String, Ref> treeMap, String str, String str2) throws Throwable {
            try {
                for (FtpChannel.DirEntry dirEntry : this.ftp.ls(str)) {
                    String filename = dirEntry.getFilename();
                    if (!BranchConfig.LOCAL_REPOSITORY.equals(filename) && !"..".equals(filename)) {
                        String str3 = str + InternalZipConstants.ZIP_FILE_SEPARATOR + filename;
                        if (dirEntry.isDirectory()) {
                            readLooseRefs(treeMap, str3, str2 + filename + InternalZipConstants.ZIP_FILE_SEPARATOR);
                        } else {
                            readRef(treeMap, str3, str2 + filename);
                        }
                    }
                }
            } catch (IOException e) {
                throw new TransportException(MessageFormat.format(JGitText.get().cannotListObjectsPath, this.objectsPath, str, e.getMessage()), e);
            }
        }

        private Ref readRef(TreeMap<String, Ref> treeMap, String str, String str2) throws Throwable {
            Throwable th;
            try {
                BufferedReader bufferedReaderOpenReader = openReader(str);
                try {
                    String line = bufferedReaderOpenReader.readLine();
                    if (bufferedReaderOpenReader != null) {
                        bufferedReaderOpenReader.close();
                    }
                    if (line == null) {
                        throw new TransportException(MessageFormat.format(JGitText.get().emptyRef, str2));
                    }
                    if (line.startsWith(RefDirectory.SYMREF)) {
                        String strSubstring = line.substring(RefDirectory.SYMREF.length());
                        Ref unpeeled = treeMap.get(strSubstring);
                        if (unpeeled == null) {
                            unpeeled = readRef(treeMap, "../" + strSubstring, strSubstring);
                        }
                        if (unpeeled == null) {
                            unpeeled = new ObjectIdRef.Unpeeled(Ref.Storage.NEW, strSubstring, null);
                        }
                        SymbolicRef symbolicRef = new SymbolicRef(str2, unpeeled);
                        treeMap.put(symbolicRef.getName(), symbolicRef);
                        return symbolicRef;
                    }
                    if (ObjectId.isId(line)) {
                        ObjectIdRef.Unpeeled unpeeled2 = new ObjectIdRef.Unpeeled(loose(treeMap.get(str2)), str2, ObjectId.fromString(line));
                        treeMap.put(unpeeled2.getName(), unpeeled2);
                        return unpeeled2;
                    }
                    throw new TransportException(MessageFormat.format(JGitText.get().badRef, str2, line));
                } catch (Throwable th2) {
                    if (bufferedReaderOpenReader != null) {
                        try {
                            bufferedReaderOpenReader.close();
                        } catch (Throwable th3) {
                            th = th2;
                            th = th3;
                            if (th == null) {
                                throw th;
                            }
                            if (th != th) {
                                try {
                                    th.addSuppressed(th);
                                } catch (FileNotFoundException unused) {
                                    return null;
                                } catch (IOException e) {
                                    throw new TransportException(MessageFormat.format(JGitText.get().cannotReadObjectsPath, this.objectsPath, str, e.getMessage()), e);
                                }
                            }
                            throw th;
                        }
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                th = th4;
                th = null;
            }
        }

        private Ref.Storage loose(Ref ref) {
            if (ref != null && ref.getStorage() == Ref.Storage.PACKED) {
                return Ref.Storage.LOOSE_PACKED;
            }
            return Ref.Storage.LOOSE;
        }

        @Override // org.eclipse.jgit.transport.WalkRemoteObjectDatabase
        void close() {
            FtpChannel ftpChannel = this.ftp;
            if (ftpChannel != null) {
                try {
                    if (ftpChannel.isConnected()) {
                        this.ftp.disconnect();
                    }
                } finally {
                    this.ftp = null;
                }
            }
        }
    }
}
