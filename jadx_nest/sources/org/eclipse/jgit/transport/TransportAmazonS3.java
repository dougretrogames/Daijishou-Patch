package org.eclipse.jgit.transport;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;
import net.lingala.zip4j.util.InternalZipConstants;
import org.eclipse.jgit.errors.NotSupportedException;
import org.eclipse.jgit.errors.TransportException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.file.RefDirectory;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectIdRef;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.SymbolicRef;

/* INFO: loaded from: classes5.dex */
public class TransportAmazonS3 extends HttpTransport implements WalkTransport {
    static final TransportProtocol PROTO_S3 = new AnonymousClass1();
    static final String S3_SCHEME = "amazon-s3";
    final String bucket;
    private final String keyPrefix;
    final AmazonS3 s3;

    @Override // org.eclipse.jgit.transport.Transport, java.lang.AutoCloseable
    public void close() {
    }

    /* INFO: renamed from: org.eclipse.jgit.transport.TransportAmazonS3$1, reason: invalid class name */
    class AnonymousClass1 extends TransportProtocol {
        AnonymousClass1() {
        }

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public String getName() {
            return "Amazon S3";
        }

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public Set<String> getSchemes() {
            return Collections.singleton(TransportAmazonS3.S3_SCHEME);
        }

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public Set<TransportProtocol.URIishField> getRequiredFields() {
            return Collections.unmodifiableSet(EnumSet.of(TransportProtocol.URIishField.USER, TransportProtocol.URIishField.HOST, TransportProtocol.URIishField.PATH));
        }

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public Set<TransportProtocol.URIishField> getOptionalFields() {
            return Collections.unmodifiableSet(EnumSet.of(TransportProtocol.URIishField.PASS));
        }

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public Transport open(URIish uRIish, Repository repository, String str) throws NotSupportedException {
            return new TransportAmazonS3(repository, uRIish);
        }
    }

    TransportAmazonS3(Repository repository, URIish uRIish) throws NotSupportedException {
        super(repository, uRIish);
        Properties propertiesLoadProperties = loadProperties();
        File directory = repository.getDirectory();
        if (!propertiesLoadProperties.containsKey(AmazonS3.Keys.TMP_DIR) && directory != null) {
            propertiesLoadProperties.put(AmazonS3.Keys.TMP_DIR, directory.getPath());
        }
        this.s3 = new AmazonS3(propertiesLoadProperties);
        this.bucket = uRIish.getHost();
        String path = uRIish.getPath();
        path = path.startsWith(InternalZipConstants.ZIP_FILE_SEPARATOR) ? path.substring(1) : path;
        this.keyPrefix = path.endsWith(InternalZipConstants.ZIP_FILE_SEPARATOR) ? path.substring(0, path.length() - 1) : path;
    }

    private Properties loadProperties() throws NotSupportedException {
        if (this.local.getDirectory() != null) {
            File file = new File(this.local.getDirectory(), this.uri.getUser());
            if (file.isFile()) {
                return loadPropertiesFile(file);
            }
        }
        File file2 = new File(this.local.getFS().userHome(), this.uri.getUser());
        if (file2.isFile()) {
            return loadPropertiesFile(file2);
        }
        Properties properties = new Properties();
        String user = this.uri.getUser();
        String pass = this.uri.getPass();
        if (user != null && pass != null) {
            properties.setProperty(AmazonS3.Keys.ACCESS_KEY, user);
            properties.setProperty(AmazonS3.Keys.SECRET_KEY, pass);
            return properties;
        }
        throw new NotSupportedException(MessageFormat.format(JGitText.get().cannotReadFile, file2));
    }

    private static Properties loadPropertiesFile(File file) throws NotSupportedException {
        try {
            return AmazonS3.properties(file);
        } catch (IOException e) {
            throw new NotSupportedException(MessageFormat.format(JGitText.get().cannotReadFile, file), e);
        }
    }

    @Override // org.eclipse.jgit.transport.Transport
    public FetchConnection openFetch() throws TransportException {
        DatabaseS3 databaseS3 = new DatabaseS3(this.bucket, this.keyPrefix + "/objects");
        WalkFetchConnection walkFetchConnection = new WalkFetchConnection(this, databaseS3);
        walkFetchConnection.available(databaseS3.readAdvertisedRefs());
        return walkFetchConnection;
    }

    @Override // org.eclipse.jgit.transport.Transport
    public PushConnection openPush() throws TransportException {
        DatabaseS3 databaseS3 = new DatabaseS3(this.bucket, this.keyPrefix + "/objects");
        WalkPushConnection walkPushConnection = new WalkPushConnection(this, databaseS3);
        walkPushConnection.available(databaseS3.readAdvertisedRefs());
        return walkPushConnection;
    }

    class DatabaseS3 extends WalkRemoteObjectDatabase {
        private final String bucketName;
        private final String objectsKey;

        @Override // org.eclipse.jgit.transport.WalkRemoteObjectDatabase
        void close() {
        }

        DatabaseS3(String str, String str2) {
            this.bucketName = str;
            this.objectsKey = str2;
        }

        private String resolveKey(String str) {
            if (str.endsWith(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                str = str.substring(0, str.length() - 1);
            }
            String strSubstring = this.objectsKey;
            while (str.startsWith("../")) {
                strSubstring = strSubstring.substring(0, strSubstring.lastIndexOf(47));
                str = str.substring(3);
            }
            return strSubstring + InternalZipConstants.ZIP_FILE_SEPARATOR + str;
        }

        @Override // org.eclipse.jgit.transport.WalkRemoteObjectDatabase
        URIish getURI() {
            return new URIish().setScheme(TransportAmazonS3.S3_SCHEME).setHost(this.bucketName).setPath(InternalZipConstants.ZIP_FILE_SEPARATOR + this.objectsKey);
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
            return TransportAmazonS3.this.new DatabaseS3(this.bucketName, resolveKey(str));
        }

        @Override // org.eclipse.jgit.transport.WalkRemoteObjectDatabase
        Collection<String> getPackNames() throws IOException {
            List<String> list = TransportAmazonS3.this.s3.list(TransportAmazonS3.this.bucket, resolveKey(ConfigConstants.CONFIG_PACK_SECTION));
            HashSet hashSet = new HashSet();
            hashSet.addAll(list);
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                if (str.startsWith("pack-") && str.endsWith(".pack")) {
                    if (hashSet.contains(str.substring(0, str.length() - 5) + ".idx")) {
                        arrayList.add(str);
                    }
                }
            }
            return arrayList;
        }

        @Override // org.eclipse.jgit.transport.WalkRemoteObjectDatabase
        WalkRemoteObjectDatabase.FileStream open(String str) throws IOException {
            URLConnection uRLConnection = TransportAmazonS3.this.s3.get(TransportAmazonS3.this.bucket, resolveKey(str));
            InputStream inputStream = uRLConnection.getInputStream();
            InputStream inputStreamDecrypt = TransportAmazonS3.this.s3.decrypt(uRLConnection);
            int contentLength = uRLConnection.getContentLength();
            if (inputStream != inputStreamDecrypt) {
                contentLength = -1;
            }
            return new WalkRemoteObjectDatabase.FileStream(inputStreamDecrypt, contentLength);
        }

        @Override // org.eclipse.jgit.transport.WalkRemoteObjectDatabase
        void deleteFile(String str) throws IOException {
            TransportAmazonS3.this.s3.delete(TransportAmazonS3.this.bucket, resolveKey(str));
        }

        @Override // org.eclipse.jgit.transport.WalkRemoteObjectDatabase
        OutputStream writeFile(String str, ProgressMonitor progressMonitor, String str2) throws IOException {
            return TransportAmazonS3.this.s3.beginPut(TransportAmazonS3.this.bucket, resolveKey(str), progressMonitor, str2);
        }

        @Override // org.eclipse.jgit.transport.WalkRemoteObjectDatabase
        void writeFile(String str, byte[] bArr) throws Throwable {
            TransportAmazonS3.this.s3.put(TransportAmazonS3.this.bucket, resolveKey(str), bArr);
        }

        Map<String, Ref> readAdvertisedRefs() throws Throwable {
            TreeMap<String, Ref> treeMap = new TreeMap<>();
            readPackedRefs(treeMap);
            readLooseRefs(treeMap);
            readRef(treeMap, "HEAD");
            return treeMap;
        }

        private void readLooseRefs(TreeMap<String, Ref> treeMap) throws Throwable {
            try {
                Iterator<String> it = TransportAmazonS3.this.s3.list(TransportAmazonS3.this.bucket, resolveKey("../refs")).iterator();
                while (it.hasNext()) {
                    readRef(treeMap, Constants.R_REFS + it.next());
                }
            } catch (IOException e) {
                throw new TransportException(getURI(), JGitText.get().cannotListRefs, e);
            }
        }

        private Ref readRef(TreeMap<String, Ref> treeMap, String str) throws Throwable {
            Throwable th;
            String str2 = "../" + str;
            try {
                BufferedReader bufferedReaderOpenReader = openReader(str2);
                try {
                    String line = bufferedReaderOpenReader.readLine();
                    if (bufferedReaderOpenReader != null) {
                        bufferedReaderOpenReader.close();
                    }
                    if (line == null) {
                        throw new TransportException(getURI(), MessageFormat.format(JGitText.get().transportExceptionEmptyRef, str));
                    }
                    if (line.startsWith(RefDirectory.SYMREF)) {
                        String strSubstring = line.substring(RefDirectory.SYMREF.length());
                        Ref unpeeled = treeMap.get(strSubstring);
                        if (unpeeled == null) {
                            unpeeled = readRef(treeMap, strSubstring);
                        }
                        if (unpeeled == null) {
                            unpeeled = new ObjectIdRef.Unpeeled(Ref.Storage.NEW, strSubstring, null);
                        }
                        SymbolicRef symbolicRef = new SymbolicRef(str, unpeeled);
                        treeMap.put(symbolicRef.getName(), symbolicRef);
                        return symbolicRef;
                    }
                    if (ObjectId.isId(line)) {
                        ObjectIdRef.Unpeeled unpeeled2 = new ObjectIdRef.Unpeeled(loose(treeMap.get(str)), str, ObjectId.fromString(line));
                        treeMap.put(unpeeled2.getName(), unpeeled2);
                        return unpeeled2;
                    }
                    throw new TransportException(getURI(), MessageFormat.format(JGitText.get().transportExceptionBadRef, str, line));
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
                                    throw new TransportException(getURI(), MessageFormat.format(JGitText.get().transportExceptionReadRef, str2), e);
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
    }
}
