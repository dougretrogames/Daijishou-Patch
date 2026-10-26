package org.eclipse.jgit.transport;

import androidx.exifinterface.media.ExifInterface;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProxySelector;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.security.DigestOutputStream;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.stream.Collectors;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FilenameUtils;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.NullProgressMonitor;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.util.Base64;
import org.eclipse.jgit.util.HttpSupport;
import org.eclipse.jgit.util.StringUtils;
import org.eclipse.jgit.util.TemporaryBuffer;
import org.jsoup.nodes.DocumentType;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/* INFO: loaded from: classes5.dex */
public class AmazonS3 {
    private static final String AWS_API_V2 = "2";
    private static final String AWS_API_V4 = "4";
    private static final String AWS_S3_SERVICE_NAME = "s3";
    private static final String HMAC = "HmacSHA1";
    private static final Set<String> SIGNED_HEADERS;
    private static final String X_AMZ_ACL = "x-amz-acl";
    private static final String X_AMZ_META = "x-amz-meta-";
    private final String acl;
    private final String awsApiSignatureVersion;
    private final String domain;
    private final WalkEncryption encryption;
    final int maxAttempts;
    private final String protocol;
    private final ProxySelector proxySelector;
    private final String publicKey;
    private final String region;
    private final char[] secretKey;
    private final SecretKeySpec secretKeySpec;
    private final File tmpDir;

    interface Keys {
        public static final String ACCESS_KEY = "accesskey";
        public static final String ACL = "acl";
        public static final String AWS_API_SIGNATURE_VERSION = "aws.api.signature.version";
        public static final String CRYPTO_ALG = "crypto.algorithm";
        public static final String CRYPTO_VER = "crypto.version";
        public static final String DOMAIN = "domain";
        public static final String HTTP_RETRY = "httpclient.retry-max";
        public static final String PASSWORD = "password";
        public static final String PROTOCOL = "protocol";
        public static final String REGION = "region";
        public static final String SECRET_KEY = "secretkey";
        public static final String TMP_DIR = "tmpdir";
    }

    static {
        HashSet hashSet = new HashSet();
        SIGNED_HEADERS = hashSet;
        hashSet.add("content-type");
        hashSet.add("content-md5");
        hashSet.add("date");
    }

    private static boolean isSignedHeader(String str) {
        String lowerCase = StringUtils.toLowerCase(str);
        return SIGNED_HEADERS.contains(lowerCase) || lowerCase.startsWith("x-amz-");
    }

    private static String toCleanString(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            if (sb.length() > 0) {
                sb.append(AbstractJsonLexerKt.COMMA);
            }
            sb.append(str.replace("\n", "").trim());
        }
        return sb.toString();
    }

    private static String remove(Map<String, String> map, String str) {
        String strRemove = map.remove(str);
        return strRemove != null ? strRemove : "";
    }

    private static String httpNow() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(new Date()) + " GMT";
    }

    private static MessageDigest newMD5() {
        try {
            return MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(JGitText.get().JRELacksMD5Implementation, e);
        }
    }

    public AmazonS3(Properties properties) {
        String property = properties.getProperty(Keys.AWS_API_SIGNATURE_VERSION, "2");
        this.awsApiSignatureVersion = property;
        File file = null;
        if (property.equals(AWS_API_V4)) {
            String property2 = properties.getProperty(Keys.REGION);
            this.region = property2;
            if (property2 == null) {
                throw new IllegalArgumentException(JGitText.get().missingAwsRegion);
            }
        } else if (property.equals("2")) {
            this.region = null;
        } else {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().invalidAwsApiSignatureVersion, property));
        }
        this.protocol = properties.getProperty("protocol", "http");
        this.domain = properties.getProperty("domain", "s3.amazonaws.com");
        String property3 = properties.getProperty(Keys.ACCESS_KEY);
        this.publicKey = property3;
        if (property3 == null) {
            throw new IllegalArgumentException(JGitText.get().missingAccesskey);
        }
        String property4 = properties.getProperty(Keys.SECRET_KEY);
        if (property4 == null) {
            throw new IllegalArgumentException(JGitText.get().missingSecretkey);
        }
        this.secretKeySpec = new SecretKeySpec(Constants.encodeASCII(property4), "HmacSHA1");
        this.secretKey = property4.toCharArray();
        String property5 = properties.getProperty(Keys.ACL, "PRIVATE");
        if (StringUtils.equalsIgnoreCase("PRIVATE", property5)) {
            this.acl = "private";
        } else if (StringUtils.equalsIgnoreCase(DocumentType.PUBLIC_KEY, property5) || StringUtils.equalsIgnoreCase("PUBLIC-READ", property5) || StringUtils.equalsIgnoreCase("PUBLIC_READ", property5)) {
            this.acl = "public-read";
        } else {
            throw new IllegalArgumentException("Invalid acl: " + property5);
        }
        try {
            this.encryption = WalkEncryption.instance(properties);
            this.maxAttempts = Integer.parseInt(properties.getProperty(Keys.HTTP_RETRY, ExifInterface.GPS_MEASUREMENT_3D));
            this.proxySelector = ProxySelector.getDefault();
            String property6 = properties.getProperty(Keys.TMP_DIR);
            if (property6 != null && property6.length() > 0) {
                file = new File(property6);
            }
            this.tmpDir = file;
        } catch (GeneralSecurityException e) {
            throw new IllegalArgumentException(JGitText.get().invalidEncryption, e);
        }
    }

    public URLConnection get(String str, String str2) throws IOException {
        for (int i = 0; i < this.maxAttempts; i++) {
            HttpURLConnection httpURLConnectionOpen = open("GET", str, str2);
            authorize(httpURLConnectionOpen, Collections.emptyMap(), 0L, null);
            int iResponse = HttpSupport.response(httpURLConnectionOpen);
            if (iResponse == 200) {
                this.encryption.validate(httpURLConnectionOpen, X_AMZ_META);
                return httpURLConnectionOpen;
            }
            if (iResponse == 404) {
                throw new FileNotFoundException(str2);
            }
            if (iResponse != 500) {
                throw error(JGitText.get().s3ActionReading, str2, httpURLConnectionOpen);
            }
        }
        throw maxAttempts(JGitText.get().s3ActionReading, str2);
    }

    public InputStream decrypt(URLConnection uRLConnection) throws IOException {
        return this.encryption.decrypt(uRLConnection.getInputStream());
    }

    public List<String> list(String str, String str2) throws IOException {
        if (str2.length() > 0 && !str2.endsWith(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            str2 = str2 + InternalZipConstants.ZIP_FILE_SEPARATOR;
        }
        ListParser listParser = new ListParser(str, str2);
        do {
            listParser.list();
        } while (listParser.truncated);
        return (List) listParser.entries.stream().sorted(Comparator.comparingLong(new AmazonS3$$ExternalSyntheticLambda0()).reversed()).map(new AmazonS3$$ExternalSyntheticLambda1()).collect(Collectors.toList());
    }

    public void delete(String str, String str2) throws IOException {
        for (int i = 0; i < this.maxAttempts; i++) {
            HttpURLConnection httpURLConnectionOpen = open("DELETE", str, str2);
            authorize(httpURLConnectionOpen, Collections.emptyMap(), 0L, null);
            int iResponse = HttpSupport.response(httpURLConnectionOpen);
            if (iResponse == 204) {
                return;
            }
            if (iResponse != 500) {
                throw error(JGitText.get().s3ActionDeletion, str2, httpURLConnectionOpen);
            }
        }
        throw maxAttempts(JGitText.get().s3ActionDeletion, str2);
    }

    public void put(String str, String str2, byte[] bArr) throws Throwable {
        Throwable th = null;
        if (this.encryption != WalkEncryption.NONE) {
            try {
                OutputStream outputStreamBeginPut = beginPut(str, str2, null, null);
                try {
                    outputStreamBeginPut.write(bArr);
                    if (outputStreamBeginPut != null) {
                        return;
                    } else {
                        return;
                    }
                } finally {
                    if (outputStreamBeginPut != null) {
                        outputStreamBeginPut.close();
                    }
                }
            } catch (Throwable th2) {
                if (0 == 0) {
                    throw th2;
                }
                if (null != th2) {
                    th.addSuppressed(th2);
                }
                throw null;
            }
        }
        String strEncodeBytes = Base64.encodeBytes(newMD5().digest(bArr));
        String strCalculateBodyHash = this.awsApiSignatureVersion.equals(AWS_API_V4) ? AwsRequestSignerV4.calculateBodyHash(bArr) : null;
        String strValueOf = String.valueOf(bArr.length);
        for (int i = 0; i < this.maxAttempts; i++) {
            HttpURLConnection httpURLConnectionOpen = open("PUT", str, str2);
            httpURLConnectionOpen.setRequestProperty("Content-Length", strValueOf);
            httpURLConnectionOpen.setRequestProperty("Content-MD5", strEncodeBytes);
            httpURLConnectionOpen.setRequestProperty(X_AMZ_ACL, this.acl);
            authorize(httpURLConnectionOpen, Collections.emptyMap(), bArr.length, strCalculateBodyHash);
            httpURLConnectionOpen.setDoOutput(true);
            httpURLConnectionOpen.setFixedLengthStreamingMode(bArr.length);
            try {
                OutputStream outputStream = httpURLConnectionOpen.getOutputStream();
                try {
                    outputStream.write(bArr);
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int iResponse = HttpSupport.response(httpURLConnectionOpen);
                    if (iResponse == 200) {
                        return;
                    }
                    if (iResponse != 500) {
                        throw error(JGitText.get().s3ActionWriting, str2, httpURLConnectionOpen);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (outputStream == null) {
                        throw th;
                    }
                    outputStream.close();
                    throw th;
                }
            } catch (Throwable th4) {
                if (th == null) {
                    throw th4;
                }
                if (th != th4) {
                    th.addSuppressed(th4);
                }
                throw th;
            }
        }
        throw maxAttempts(JGitText.get().s3ActionWriting, str2);
    }

    /* INFO: renamed from: org.eclipse.jgit.transport.AmazonS3$1, reason: invalid class name */
    class AnonymousClass1 extends TemporaryBuffer.LocalFile {
        private final /* synthetic */ String val$bucket;
        private final /* synthetic */ String val$key;
        private final /* synthetic */ MessageDigest val$md5;
        private final /* synthetic */ ProgressMonitor val$monitor;
        private final /* synthetic */ String val$monitorTask;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(File file, String str, String str2, MessageDigest messageDigest, ProgressMonitor progressMonitor, String str3) {
            super(file);
            this.val$bucket = str;
            this.val$key = str2;
            this.val$md5 = messageDigest;
            this.val$monitor = progressMonitor;
            this.val$monitorTask = str3;
        }

        @Override // org.eclipse.jgit.util.TemporaryBuffer, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            try {
                AmazonS3.this.putImpl(this.val$bucket, this.val$key, this.val$md5.digest(), this, this.val$monitor, this.val$monitorTask);
            } finally {
                destroy();
            }
        }
    }

    public OutputStream beginPut(String str, String str2, ProgressMonitor progressMonitor, String str3) throws IOException {
        MessageDigest messageDigestNewMD5 = newMD5();
        return this.encryption.encrypt(new DigestOutputStream(new AnonymousClass1(this.tmpDir, str, str2, messageDigestNewMD5, progressMonitor, str3), messageDigestNewMD5));
    }

    void putImpl(String str, String str2, byte[] bArr, TemporaryBuffer temporaryBuffer, ProgressMonitor progressMonitor, String str3) throws IOException {
        ProgressMonitor progressMonitor2 = progressMonitor == null ? NullProgressMonitor.INSTANCE : progressMonitor;
        String str4 = str3 == null ? MessageFormat.format(JGitText.get().progressMonUploading, str2) : str3;
        String strEncodeBytes = Base64.encodeBytes(bArr);
        Throwable th = null;
        String strCalculateBodyHash = this.awsApiSignatureVersion.equals(AWS_API_V4) ? AwsRequestSignerV4.calculateBodyHash(temporaryBuffer.toByteArray()) : null;
        long length = temporaryBuffer.length();
        for (int i = 0; i < this.maxAttempts; i++) {
            HttpURLConnection httpURLConnectionOpen = open("PUT", str, str2);
            httpURLConnectionOpen.setFixedLengthStreamingMode(length);
            httpURLConnectionOpen.setRequestProperty("Content-MD5", strEncodeBytes);
            httpURLConnectionOpen.setRequestProperty(X_AMZ_ACL, this.acl);
            this.encryption.request(httpURLConnectionOpen, X_AMZ_META);
            authorize(httpURLConnectionOpen, Collections.emptyMap(), length, strCalculateBodyHash);
            httpURLConnectionOpen.setDoOutput(true);
            progressMonitor2.beginTask(str4, (int) (length / 1024));
            try {
                OutputStream outputStream = httpURLConnectionOpen.getOutputStream();
                try {
                    temporaryBuffer.writeTo(outputStream, progressMonitor2);
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    progressMonitor2.endTask();
                    int iResponse = HttpSupport.response(httpURLConnectionOpen);
                    if (iResponse == 200) {
                        return;
                    }
                    if (iResponse != 500) {
                        throw error(JGitText.get().s3ActionWriting, str2, httpURLConnectionOpen);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (outputStream == null) {
                        throw th;
                    }
                    outputStream.close();
                    throw th;
                }
            } catch (Throwable th3) {
                if (th == null) {
                    throw th3;
                }
                if (th != th3) {
                    try {
                        th.addSuppressed(th3);
                    } catch (Throwable th4) {
                        progressMonitor2.endTask();
                        throw th4;
                    }
                }
                throw th;
            }
        }
        throw maxAttempts(JGitText.get().s3ActionWriting, str2);
    }

    IOException error(String str, String str2, HttpURLConnection httpURLConnection) throws IOException {
        IOException iOException = new IOException(MessageFormat.format(JGitText.get().amazonS3ActionFailed, str, str2, Integer.valueOf(HttpSupport.response(httpURLConnection)), httpURLConnection.getResponseMessage()));
        if (httpURLConnection.getErrorStream() != null) {
            Throwable th = null;
            try {
                InputStream errorStream = httpURLConnection.getErrorStream();
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int i = errorStream.read(bArr);
                        if (i < 0) {
                            break;
                        }
                        if (i > 0) {
                            byteArrayOutputStream.write(bArr, 0, i);
                        }
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    if (byteArray.length > 0) {
                        iOException.initCause(new IOException("\n" + new String(byteArray, StandardCharsets.UTF_8)));
                    }
                } finally {
                    if (errorStream != null) {
                        errorStream.close();
                    }
                }
            } catch (Throwable th2) {
                if (0 == 0) {
                    throw th2;
                }
                if (null == th2) {
                    throw null;
                }
                th.addSuppressed(th2);
                throw null;
            }
        }
        return iOException;
    }

    IOException maxAttempts(String str, String str2) {
        return new IOException(MessageFormat.format(JGitText.get().amazonS3ActionFailedGivingUp, str, str2, Integer.valueOf(this.maxAttempts)));
    }

    private HttpURLConnection open(String str, String str2, String str3) throws IOException {
        return open(str, str2, str3, Collections.emptyMap());
    }

    HttpURLConnection open(String str, String str2, String str3, Map<String, String> map) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(this.protocol);
        sb.append("://");
        sb.append(str2);
        sb.append(FilenameUtils.EXTENSION_SEPARATOR);
        sb.append(this.domain);
        sb.append('/');
        if (str3.length() > 0) {
            if (this.awsApiSignatureVersion.equals("2")) {
                HttpSupport.encode(sb, str3);
            } else if (this.awsApiSignatureVersion.equals(AWS_API_V4)) {
                sb.append(str3);
            }
        }
        if (!map.isEmpty()) {
            sb.append('?');
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                sb.append(next.getKey());
                sb.append('=');
                HttpSupport.encode(sb, next.getValue());
                if (it.hasNext()) {
                    sb.append(Typography.amp);
                }
            }
        }
        URL url = new URL(sb.toString());
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection(HttpSupport.proxyFor(this.proxySelector, url));
        httpURLConnection.setRequestMethod(str);
        httpURLConnection.setRequestProperty("User-Agent", "jgit/1.0");
        httpURLConnection.setRequestProperty("Date", httpNow());
        return httpURLConnection;
    }

    void authorize(HttpURLConnection httpURLConnection, Map<String, String> map, long j, String str) throws IOException {
        if (this.awsApiSignatureVersion.equals("2")) {
            authorizeV2(httpURLConnection);
        } else if (this.awsApiSignatureVersion.equals(AWS_API_V4)) {
            AwsRequestSignerV4.sign(httpURLConnection, map, j, str, AWS_S3_SERVICE_NAME, this.region, this.publicKey, this.secretKey);
        }
    }

    void authorizeV2(HttpURLConnection httpURLConnection) throws IOException {
        Map<String, List<String>> requestProperties = httpURLConnection.getRequestProperties();
        TreeMap treeMap = new TreeMap();
        for (Map.Entry<String, List<String>> entry : requestProperties.entrySet()) {
            String key = entry.getKey();
            if (isSignedHeader(key)) {
                treeMap.put(StringUtils.toLowerCase(key), toCleanString(entry.getValue()));
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(httpURLConnection.getRequestMethod());
        sb.append('\n');
        sb.append(remove(treeMap, "content-md5"));
        sb.append('\n');
        sb.append(remove(treeMap, "content-type"));
        sb.append('\n');
        sb.append(remove(treeMap, "date"));
        sb.append('\n');
        for (Map.Entry entry2 : treeMap.entrySet()) {
            sb.append((String) entry2.getKey());
            sb.append(AbstractJsonLexerKt.COLON);
            sb.append((String) entry2.getValue());
            sb.append('\n');
        }
        String host = httpURLConnection.getURL().getHost();
        sb.append('/');
        sb.append(host.substring(0, (host.length() - this.domain.length()) - 1));
        sb.append(httpURLConnection.getURL().getPath());
        try {
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(this.secretKeySpec);
            httpURLConnection.setRequestProperty("Authorization", "AWS " + this.publicKey + CollectionUtils.COLON + Base64.encodeBytes(mac.doFinal(sb.toString().getBytes(StandardCharsets.UTF_8))));
        } catch (InvalidKeyException e) {
            throw new IOException(MessageFormat.format(JGitText.get().invalidKey, e.getMessage()));
        } catch (NoSuchAlgorithmException e2) {
            throw new IOException(MessageFormat.format(JGitText.get().noHMACsupport, "HmacSHA1", e2.getMessage()));
        }
    }

    static Properties properties(File file) throws IOException {
        Properties properties = new Properties();
        Throwable th = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                properties.load(fileInputStream);
                return properties;
            } finally {
                fileInputStream.close();
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null != th2) {
                th.addSuppressed(th2);
            }
            throw null;
        }
    }

    /* INFO: Access modifiers changed from: private */
    static final class KeyInfo {
        private final long lastModifiedSecs;
        private final String name;

        public KeyInfo(String str, long j) {
            this.name = str;
            this.lastModifiedSecs = j;
        }

        public String getName() {
            return this.name;
        }

        public long getLastModifiedSecs() {
            return this.lastModifiedSecs;
        }
    }

    private final class ListParser extends DefaultHandler {
        private final String bucket;
        private StringBuilder data;
        final List<KeyInfo> entries = new ArrayList();
        private Instant keyLastModified;
        private String keyName;
        private final String prefix;
        boolean truncated;

        ListParser(String str, String str2) {
            this.bucket = str;
            this.prefix = str2;
        }

        void list() throws IOException {
            TreeMap treeMap = new TreeMap();
            if (this.prefix.length() > 0) {
                treeMap.put("prefix", this.prefix);
            }
            if (!this.entries.isEmpty()) {
                String str = this.prefix;
                List<KeyInfo> list = this.entries;
                treeMap.put("marker", str + list.get(list.size() - 1).getName());
            }
            for (int i = 0; i < AmazonS3.this.maxAttempts; i++) {
                HttpURLConnection httpURLConnectionOpen = AmazonS3.this.open("GET", this.bucket, "", treeMap);
                AmazonS3.this.authorize(httpURLConnectionOpen, treeMap, 0L, null);
                int iResponse = HttpSupport.response(httpURLConnectionOpen);
                if (iResponse == 200) {
                    this.truncated = false;
                    Throwable th = null;
                    this.data = null;
                    this.keyName = null;
                    this.keyLastModified = null;
                    try {
                        SAXParserFactory sAXParserFactoryNewInstance = SAXParserFactory.newInstance();
                        sAXParserFactoryNewInstance.setNamespaceAware(true);
                        XMLReader xMLReader = sAXParserFactoryNewInstance.newSAXParser().getXMLReader();
                        xMLReader.setContentHandler(this);
                        try {
                            InputStream inputStream = httpURLConnectionOpen.getInputStream();
                            try {
                                xMLReader.parse(new InputSource(inputStream));
                                if (inputStream != null) {
                                    return;
                                } else {
                                    return;
                                }
                            } finally {
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                            }
                        } catch (Throwable th2) {
                            if (0 == 0) {
                                throw th2;
                            }
                            if (null != th2) {
                                try {
                                    th.addSuppressed(th2);
                                } catch (SAXException e) {
                                    throw new IOException(MessageFormat.format(JGitText.get().errorListing, this.prefix), e);
                                }
                            }
                            throw null;
                        }
                    } catch (ParserConfigurationException | SAXException e2) {
                        throw new IOException(JGitText.get().noXMLParserAvailable, e2);
                    }
                } else {
                    if (iResponse != 500) {
                        throw AmazonS3.this.error("Listing", this.prefix, httpURLConnectionOpen);
                    }
                }
            }
            throw AmazonS3.this.maxAttempts("Listing", this.prefix);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            if ("Key".equals(str2) || "IsTruncated".equals(str2) || "LastModified".equals(str2)) {
                this.data = new StringBuilder();
            }
            if ("Contents".equals(str2)) {
                this.keyName = null;
                this.keyLastModified = null;
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void ignorableWhitespace(char[] cArr, int i, int i2) throws SAXException {
            StringBuilder sb = this.data;
            if (sb != null) {
                sb.append(cArr, i, i2);
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i, int i2) throws SAXException {
            StringBuilder sb = this.data;
            if (sb != null) {
                sb.append(cArr, i, i2);
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) throws SAXException {
            if ("Key".equals(str2)) {
                this.keyName = this.data.toString().substring(this.prefix.length());
            } else if ("IsTruncated".equals(str2)) {
                this.truncated = StringUtils.equalsIgnoreCase("true", this.data.toString());
            } else if ("LastModified".equals(str2)) {
                this.keyLastModified = Instant.parse(this.data.toString());
            } else if ("Contents".equals(str2)) {
                this.entries.add(new KeyInfo(this.keyName, this.keyLastModified.getEpochSecond()));
            }
            this.data = null;
        }
    }
}
