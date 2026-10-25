package org.eclipse.jgit.transport;

import androidx.webkit.ProxyConfig;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.transport.http.HttpConnection;
import org.eclipse.jgit.util.Base64;
import org.eclipse.jgit.util.GSSManagerFactory;
import org.ietf.jgss.GSSContext;
import org.ietf.jgss.GSSCredential;
import org.ietf.jgss.GSSException;
import org.ietf.jgss.GSSManager;
import org.ietf.jgss.GSSName;
import org.ietf.jgss.Oid;

/* JADX INFO: loaded from: classes5.dex */
abstract class HttpAuthMethod {
    static final String EMPTY_STRING = "";
    static final String SCHEMA_NAME_SEPARATOR = " ";
    protected final Type type;

    abstract void authorize(String str, String str2);

    abstract void configureRequest(HttpConnection httpConnection) throws IOException;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class Type {
        public static final Type BASIC;
        public static final Type DIGEST;
        private static final /* synthetic */ Type[] ENUM$VALUES;
        public static final Type NEGOTIATE;
        public static final Type NONE;

        /* synthetic */ Type(String str, int i, HttpAuthMethodIA httpAuthMethodIA) {
            this(str, i);
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            Type[] typeArr = ENUM$VALUES;
            int length = typeArr.length;
            Type[] typeArr2 = new Type[length];
            System.arraycopy(typeArr, 0, typeArr2, 0, length);
            return typeArr2;
        }

        public abstract String getSchemeName();

        public abstract HttpAuthMethod method(String str);

        /* JADX INFO: renamed from: org.eclipse.jgit.transport.HttpAuthMethod$Type$1, reason: invalid class name */
        final enum AnonymousClass1 extends Type {
            AnonymousClass1(String str, int i) {
                super(str, i, null);
            }

            @Override // org.eclipse.jgit.transport.HttpAuthMethod.Type
            public HttpAuthMethod method(String str) {
                return None.INSTANCE;
            }

            @Override // org.eclipse.jgit.transport.HttpAuthMethod.Type
            public String getSchemeName() {
                return "None";
            }
        }

        private Type(String str, int i) {
            super(str, i);
        }

        static {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1("NONE", 0);
            NONE = anonymousClass1;
            AnonymousClass2 anonymousClass2 = new AnonymousClass2("BASIC", 1);
            BASIC = anonymousClass2;
            AnonymousClass3 anonymousClass3 = new AnonymousClass3("DIGEST", 2);
            DIGEST = anonymousClass3;
            AnonymousClass4 anonymousClass4 = new AnonymousClass4("NEGOTIATE", 3);
            NEGOTIATE = anonymousClass4;
            ENUM$VALUES = new Type[]{anonymousClass1, anonymousClass2, anonymousClass3, anonymousClass4};
        }

        /* JADX INFO: renamed from: org.eclipse.jgit.transport.HttpAuthMethod$Type$2, reason: invalid class name */
        final enum AnonymousClass2 extends Type {
            AnonymousClass2(String str, int i) {
                super(str, i, null);
            }

            @Override // org.eclipse.jgit.transport.HttpAuthMethod.Type
            public HttpAuthMethod method(String str) {
                return new Basic();
            }

            @Override // org.eclipse.jgit.transport.HttpAuthMethod.Type
            public String getSchemeName() {
                return "Basic";
            }
        }

        /* JADX INFO: renamed from: org.eclipse.jgit.transport.HttpAuthMethod$Type$3, reason: invalid class name */
        final enum AnonymousClass3 extends Type {
            AnonymousClass3(String str, int i) {
                super(str, i, null);
            }

            @Override // org.eclipse.jgit.transport.HttpAuthMethod.Type
            public HttpAuthMethod method(String str) {
                return new Digest(str);
            }

            @Override // org.eclipse.jgit.transport.HttpAuthMethod.Type
            public String getSchemeName() {
                return "Digest";
            }
        }

        /* JADX INFO: renamed from: org.eclipse.jgit.transport.HttpAuthMethod$Type$4, reason: invalid class name */
        final enum AnonymousClass4 extends Type {
            AnonymousClass4(String str, int i) {
                super(str, i, null);
            }

            @Override // org.eclipse.jgit.transport.HttpAuthMethod.Type
            public HttpAuthMethod method(String str) {
                return new Negotiate(str);
            }

            @Override // org.eclipse.jgit.transport.HttpAuthMethod.Type
            public String getSchemeName() {
                return "Negotiate";
            }
        }
    }

    static HttpAuthMethod scanResponse(HttpConnection httpConnection, Collection<Type> collection) {
        Map<String, List<String>> headerFields = httpConnection.getHeaderFields();
        HttpAuthMethod httpAuthMethodMethod = Type.NONE.method("");
        for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
            if ("WWW-Authenticate".equalsIgnoreCase(entry.getKey())) {
                if (entry.getValue() == null) {
                    break;
                }
                for (String str : entry.getValue()) {
                    if (str != null && str.length() != 0) {
                        String[] strArrSplit = str.split(SCHEMA_NAME_SEPARATOR, 2);
                        try {
                            Type typeValueOf = Type.valueOf(strArrSplit[0].toUpperCase(Locale.ROOT));
                            if (collection == null || !collection.contains(typeValueOf)) {
                                if (httpAuthMethodMethod.getType().compareTo(typeValueOf) < 0) {
                                    httpAuthMethodMethod = typeValueOf.method(strArrSplit.length == 1 ? "" : strArrSplit[1]);
                                }
                            }
                        } catch (IllegalArgumentException unused) {
                        }
                    }
                }
                return httpAuthMethodMethod;
            }
        }
        return httpAuthMethodMethod;
    }

    protected HttpAuthMethod(Type type) {
        this.type = type;
    }

    boolean authorize(URIish uRIish, CredentialsProvider credentialsProvider) {
        String pass;
        String value;
        if (credentialsProvider != null) {
            CredentialItem.Username username = new CredentialItem.Username();
            CredentialItem.Password password = new CredentialItem.Password();
            if (!credentialsProvider.supports(username, password) || !credentialsProvider.get(uRIish, username, password)) {
                return false;
            }
            value = username.getValue();
            pass = password.getValue() == null ? null : new String(password.getValue());
            password.clear();
        } else {
            String user = uRIish.getUser();
            pass = uRIish.getPass();
            value = user;
        }
        if (value == null) {
            return false;
        }
        authorize(value, pass);
        return true;
    }

    public Type getType() {
        return this.type;
    }

    private static class None extends HttpAuthMethod {
        static final None INSTANCE = new None();

        @Override // org.eclipse.jgit.transport.HttpAuthMethod
        void authorize(String str, String str2) {
        }

        @Override // org.eclipse.jgit.transport.HttpAuthMethod
        void configureRequest(HttpConnection httpConnection) throws IOException {
        }

        public None() {
            super(Type.NONE);
        }
    }

    private static class Basic extends HttpAuthMethod {
        private String pass;
        private String user;

        public Basic() {
            super(Type.BASIC);
        }

        @Override // org.eclipse.jgit.transport.HttpAuthMethod
        void authorize(String str, String str2) {
            this.user = str;
            this.pass = str2;
        }

        @Override // org.eclipse.jgit.transport.HttpAuthMethod
        void configureRequest(HttpConnection httpConnection) throws IOException {
            httpConnection.setRequestProperty("Authorization", this.type.getSchemeName() + HttpAuthMethod.SCHEMA_NAME_SEPARATOR + Base64.encodeBytes((this.user + CollectionUtils.COLON + this.pass).getBytes(StandardCharsets.UTF_8)));
        }
    }

    private static class Digest extends HttpAuthMethod {
        private final Map<String, String> params;
        private String pass;
        private int requestCount;
        private String user;
        private static final SecureRandom PRNG = new SecureRandom();
        private static final char[] LHEX = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        Digest(String str) {
            super(Type.DIGEST);
            Map<String, String> map = parse(str);
            this.params = map;
            if ("auth".equals(map.get("qop"))) {
                byte[] bArr = new byte[8];
                PRNG.nextBytes(bArr);
                map.put("cnonce", Base64.encodeBytes(bArr));
            }
        }

        @Override // org.eclipse.jgit.transport.HttpAuthMethod
        void authorize(String str, String str2) {
            this.user = str;
            this.pass = str2;
        }

        @Override // org.eclipse.jgit.transport.HttpAuthMethod
        void configureRequest(HttpConnection httpConnection) throws IOException {
            String strKD;
            String str;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String str2 = this.params.get("realm");
            String str3 = this.params.get("nonce");
            String str4 = this.params.get("cnonce");
            String strUri = uri(httpConnection.getURL());
            String str5 = this.params.get("qop");
            String requestMethod = httpConnection.getRequestMethod();
            String str6 = this.user + CollectionUtils.COLON + str2 + CollectionUtils.COLON + this.pass;
            String str7 = requestMethod + CollectionUtils.COLON + strUri;
            linkedHashMap.put("username", this.user);
            linkedHashMap.put("realm", str2);
            linkedHashMap.put("nonce", str3);
            linkedHashMap.put("uri", strUri);
            if ("auth".equals(str5)) {
                int i = this.requestCount + 1;
                this.requestCount = i;
                str = String.format("%08x", Integer.valueOf(i));
                strKD = KD(H(str6), str3 + CollectionUtils.COLON + str + CollectionUtils.COLON + str4 + CollectionUtils.COLON + str5 + CollectionUtils.COLON + H(str7));
            } else {
                strKD = KD(H(str6), str3 + CollectionUtils.COLON + H(str7));
                str = null;
            }
            linkedHashMap.put("response", strKD);
            if (this.params.containsKey(ConfigConstants.CONFIG_KEY_ALGORITHM)) {
                linkedHashMap.put(ConfigConstants.CONFIG_KEY_ALGORITHM, MessageDigestAlgorithms.MD5);
            }
            if (str4 != null && str5 != null) {
                linkedHashMap.put("cnonce", str4);
            }
            if (this.params.containsKey("opaque")) {
                linkedHashMap.put("opaque", this.params.get("opaque"));
            }
            if (str5 != null) {
                linkedHashMap.put("qop", str5);
            }
            if (str != null) {
                linkedHashMap.put("nc", str);
            }
            StringBuilder sb = new StringBuilder();
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append((String) entry.getKey());
                sb.append('=');
                sb.append('\"');
                sb.append((String) entry.getValue());
                sb.append('\"');
            }
            httpConnection.setRequestProperty("Authorization", this.type.getSchemeName() + HttpAuthMethod.SCHEMA_NAME_SEPARATOR + String.valueOf(sb));
        }

        private static String uri(URL url) {
            StringBuilder sb = new StringBuilder();
            sb.append(url.getProtocol());
            sb.append("://");
            sb.append(url.getHost());
            if (url.getPort() > 0 && ((url.getPort() != 80 || !"http".equals(url.getProtocol())) && (url.getPort() != 443 || !ProxyConfig.MATCH_HTTPS.equals(url.getProtocol())))) {
                sb.append(AbstractJsonLexerKt.COLON).append(url.getPort());
            }
            sb.append(url.getPath());
            if (url.getQuery() != null) {
                sb.append('?').append(url.getQuery());
            }
            return sb.toString();
        }

        private static String H(String str) {
            MessageDigest messageDigestNewMD5 = newMD5();
            messageDigestNewMD5.update(str.getBytes(StandardCharsets.UTF_8));
            return LHEX(messageDigestNewMD5.digest());
        }

        private static String KD(String str, String str2) {
            MessageDigest messageDigestNewMD5 = newMD5();
            messageDigestNewMD5.update(str.getBytes(StandardCharsets.UTF_8));
            messageDigestNewMD5.update((byte) 58);
            messageDigestNewMD5.update(str2.getBytes(StandardCharsets.UTF_8));
            return LHEX(messageDigestNewMD5.digest());
        }

        private static MessageDigest newMD5() {
            try {
                return MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException("No MD5 available", e);
            }
        }

        private static String LHEX(byte[] bArr) {
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            for (byte b : bArr) {
                char[] cArr = LHEX;
                sb.append(cArr[(b >>> 4) & 15]);
                sb.append(cArr[b & Ascii.SI]);
            }
            return sb.toString();
        }

        private static Map<String, String> parse(String str) {
            int i;
            String strSubstring;
            int i2;
            HashMap map = new HashMap();
            int i3 = 0;
            while (i3 < str.length()) {
                if (i3 < str.length() && str.charAt(i3) == ',') {
                    i3++;
                }
                while (i3 < str.length() && Character.isWhitespace(str.charAt(i3))) {
                    i3++;
                }
                int iIndexOf = str.indexOf(61, i3);
                if (iIndexOf < 0 || (i = iIndexOf + 1) == str.length()) {
                    return Collections.emptyMap();
                }
                String strSubstring2 = str.substring(i3, iIndexOf);
                if (str.charAt(i) == '\"') {
                    int i4 = iIndexOf + 2;
                    int iIndexOf2 = str.indexOf(34, i4);
                    if (iIndexOf2 < 0) {
                        return Collections.emptyMap();
                    }
                    String strSubstring3 = str.substring(i4, iIndexOf2);
                    int i5 = iIndexOf2 + 1;
                    strSubstring = strSubstring3;
                    i2 = i5;
                } else {
                    int iIndexOf3 = str.indexOf(32, i);
                    int iIndexOf4 = str.indexOf(44, i);
                    if (iIndexOf3 < 0) {
                        iIndexOf3 = str.length();
                    }
                    if (iIndexOf4 < 0) {
                        iIndexOf4 = str.length();
                    }
                    int iMin = Math.min(iIndexOf3, iIndexOf4);
                    strSubstring = str.substring(i, iMin);
                    i2 = iMin + 1;
                }
                map.put(strSubstring2, strSubstring);
                i3 = i2;
            }
            return map;
        }
    }

    private static class Negotiate extends HttpAuthMethod {
        private static final GSSManagerFactory GSS_MANAGER_FACTORY = GSSManagerFactory.detect();
        private static final Oid OID;
        private final byte[] prevToken;

        @Override // org.eclipse.jgit.transport.HttpAuthMethod
        void authorize(String str, String str2) {
        }

        static {
            try {
                OID = new Oid("1.3.6.1.5.5.2");
            } catch (GSSException e) {
                throw new Error("Cannot create NEGOTIATE oid.", e);
            }
        }

        public Negotiate(String str) {
            super(Type.NEGOTIATE);
            this.prevToken = Base64.decode(str);
        }

        @Override // org.eclipse.jgit.transport.HttpAuthMethod
        void configureRequest(HttpConnection httpConnection) throws IOException {
            GSSManager gSSManagerNewInstance = GSS_MANAGER_FACTORY.newInstance(httpConnection.getURL());
            try {
                GSSContext gSSContextCreateContext = gSSManagerNewInstance.createContext(gSSManagerNewInstance.createName("HTTP@" + httpConnection.getURL().getHost().toLowerCase(Locale.ROOT), GSSName.NT_HOSTBASED_SERVICE), OID, (GSSCredential) null, 0);
                gSSContextCreateContext.requestCredDeleg(true);
                byte[] bArr = this.prevToken;
                byte[] bArrInitSecContext = gSSContextCreateContext.initSecContext(bArr, 0, bArr.length);
                httpConnection.setRequestProperty("Authorization", getType().getSchemeName() + HttpAuthMethod.SCHEMA_NAME_SEPARATOR + Base64.encodeBytes(bArrInitSecContext));
            } catch (GSSException e) {
                throw new IOException((Throwable) e);
            }
        }
    }
}
