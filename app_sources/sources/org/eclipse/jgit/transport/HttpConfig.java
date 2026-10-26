package org.eclipse.jgit.transport;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import org.eclipse.jgit.errors.ConfigInvalidException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.util.StringUtils;
import org.eclipse.jgit.util.SystemReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* INFO: loaded from: classes5.dex */
public class HttpConfig {
    public static final String COOKIE_FILE_CACHE_LIMIT_KEY = "cookieFileCacheLimit";
    public static final String COOKIE_FILE_KEY = "cookieFile";
    private static final int DEFAULT_COOKIE_FILE_CACHE_LIMIT = 10;
    private static final int DEFAULT_MAX_REDIRECTS = 5;
    private static final String ENV_HTTP_USER_AGENT = "GIT_HTTP_USER_AGENT";
    public static final String EXTRA_HEADER = "extraHeader";
    public static final String FOLLOW_REDIRECTS_KEY = "followRedirects";
    private static final String FTP = "ftp";
    public static final String HTTP = "http";
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) HttpConfig.class);
    private static final int MAX_REDIRECTS = new AnonymousClass1().get().intValue();
    public static final String MAX_REDIRECTS_KEY = "maxRedirects";
    private static final String MAX_REDIRECT_SYSTEM_PROPERTY = "http.maxRedirects";
    public static final String POST_BUFFER_KEY = "postBuffer";
    public static final String SAVE_COOKIES_KEY = "saveCookies";
    public static final String SSL_VERIFY_KEY = "sslVerify";
    public static final String USER_AGENT = "userAgent";
    private String cookieFile;
    private int cookieFileCacheLimit;
    private List<String> extraHeaders;
    private HttpRedirectMode followRedirects;
    private int maxRedirects;
    private int postBuffer;
    private boolean saveCookies;
    private boolean sslVerify;
    private String userAgent;

    /* INFO: renamed from: org.eclipse.jgit.transport.HttpConfig$1, reason: invalid class name */
    class AnonymousClass1 implements Supplier<Integer> {
        AnonymousClass1() {
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // java.util.function.Supplier
        public Integer get() {
            String property = SystemReader.getInstance().getProperty(HttpConfig.MAX_REDIRECT_SYSTEM_PROPERTY);
            if (property != null) {
                try {
                    return Integer.valueOf(Integer.parseUnsignedInt(property));
                } catch (NumberFormatException unused) {
                    HttpConfig.LOG.warn(MessageFormat.format(JGitText.get().invalidSystemProperty, HttpConfig.MAX_REDIRECT_SYSTEM_PROPERTY, property, 5));
                }
            }
            return 5;
        }
    }

    public enum HttpRedirectMode implements Config.ConfigEnum {
        TRUE("true"),
        INITIAL("initial"),
        FALSE("false");

        private final String configValue;

        /* INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static HttpRedirectMode[] valuesCustom() {
            HttpRedirectMode[] httpRedirectModeArrValuesCustom = values();
            int length = httpRedirectModeArrValuesCustom.length;
            HttpRedirectMode[] httpRedirectModeArr = new HttpRedirectMode[length];
            System.arraycopy(httpRedirectModeArrValuesCustom, 0, httpRedirectModeArr, 0, length);
            return httpRedirectModeArr;
        }

        HttpRedirectMode(String str) {
            this.configValue = str;
        }

        @Override // org.eclipse.jgit.lib.Config.ConfigEnum
        public String toConfigValue() {
            return this.configValue;
        }

        @Override // org.eclipse.jgit.lib.Config.ConfigEnum
        public boolean matchConfigValue(String str) {
            return this.configValue.equals(str);
        }
    }

    public int getPostBuffer() {
        return this.postBuffer;
    }

    public boolean isSslVerify() {
        return this.sslVerify;
    }

    public HttpRedirectMode getFollowRedirects() {
        return this.followRedirects;
    }

    public int getMaxRedirects() {
        return this.maxRedirects;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public List<String> getExtraHeaders() {
        List<String> list = this.extraHeaders;
        return list == null ? Collections.emptyList() : list;
    }

    public String getCookieFile() {
        return this.cookieFile;
    }

    public boolean getSaveCookies() {
        return this.saveCookies;
    }

    public int getCookieFileCacheLimit() {
        return this.cookieFileCacheLimit;
    }

    public HttpConfig(Config config, URIish uRIish) {
        init(config, uRIish);
    }

    /* WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class decompiler.core.dex.instructions.args.ArgType$UnknownArg
    	at decompiler.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at decompiler.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at decompiler.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public HttpConfig(URIish uRIish) {
        try {
            init(SystemReader.getInstance().getUserConfig(), uRIish);
        } catch (IOException | ConfigInvalidException e) {
            LOG.error(e.getMessage(), (Throwable) e);
            init(new Config(), uRIish);
        }
    }

    private void init(Config config, URIish uRIish) {
        int i = config.getInt("http", POST_BUFFER_KEY, 1048576);
        boolean z = config.getBoolean("http", SSL_VERIFY_KEY, true);
        HttpRedirectMode httpRedirectMode = (HttpRedirectMode) config.getEnum(HttpRedirectMode.valuesCustom(), "http", null, FOLLOW_REDIRECTS_KEY, HttpRedirectMode.INITIAL);
        int i2 = MAX_REDIRECTS;
        int i3 = config.getInt("http", MAX_REDIRECTS_KEY, i2);
        int i4 = i3 < 0 ? i2 : i3;
        String string = config.getString("http", null, USER_AGENT);
        if (string != null) {
            string = UserAgent.clean(string);
        }
        this.userAgent = string;
        String[] stringList = config.getStringList("http", null, EXTRA_HEADER);
        int iFindLastEmpty = findLastEmpty(stringList) + 1;
        if (iFindLastEmpty > 0) {
            stringList = (String[]) Arrays.copyOfRange(stringList, iFindLastEmpty, stringList.length);
        }
        this.extraHeaders = Arrays.asList(stringList);
        this.cookieFile = config.getString("http", null, COOKIE_FILE_KEY);
        this.saveCookies = config.getBoolean("http", SAVE_COOKIES_KEY, false);
        this.cookieFileCacheLimit = config.getInt("http", COOKIE_FILE_CACHE_LIMIT_KEY, 10);
        String strFindMatch = findMatch(config.getSubsections("http"), uRIish);
        if (strFindMatch != null) {
            i = config.getInt("http", strFindMatch, POST_BUFFER_KEY, i);
            z = config.getBoolean("http", strFindMatch, SSL_VERIFY_KEY, z);
            httpRedirectMode = (HttpRedirectMode) config.getEnum(HttpRedirectMode.valuesCustom(), "http", strFindMatch, FOLLOW_REDIRECTS_KEY, httpRedirectMode);
            int i5 = config.getInt("http", strFindMatch, MAX_REDIRECTS_KEY, i4);
            if (i5 >= 0) {
                i4 = i5;
            }
            String string2 = config.getString("http", strFindMatch, USER_AGENT);
            if (string2 != null) {
                this.userAgent = UserAgent.clean(string2);
            }
            String[] stringList2 = config.getStringList("http", strFindMatch, EXTRA_HEADER);
            if (stringList2.length > 0) {
                int iFindLastEmpty2 = findLastEmpty(stringList2) + 1;
                if (iFindLastEmpty2 > 0) {
                    stringList2 = (String[]) Arrays.copyOfRange(stringList2, iFindLastEmpty2, stringList2.length);
                }
                this.extraHeaders = Arrays.asList(stringList2);
            }
            String string3 = config.getString("http", strFindMatch, COOKIE_FILE_KEY);
            if (string3 != null) {
                this.cookieFile = string3;
            }
            this.saveCookies = config.getBoolean("http", strFindMatch, SAVE_COOKIES_KEY, this.saveCookies);
        }
        String str = SystemReader.getInstance().getenv(ENV_HTTP_USER_AGENT);
        if (!StringUtils.isEmptyOrNull(str)) {
            this.userAgent = UserAgent.clean(str);
        }
        this.postBuffer = i;
        this.sslVerify = z;
        this.followRedirects = httpRedirectMode;
        this.maxRedirects = i4;
    }

    private int findLastEmpty(String[] strArr) {
        for (int length = strArr.length - 1; length >= 0; length--) {
            if (strArr[length] == null) {
                return length;
            }
        }
        return -1;
    }

    private String findMatch(Set<String> set, URIish uRIish) {
        boolean z;
        int iSegmentCompare;
        String path = uRIish.getPath();
        boolean zIsEmptyOrNull = StringUtils.isEmptyOrNull(path);
        String str = null;
        if (!zIsEmptyOrNull && (path = normalize(path)) == null) {
            return null;
        }
        int i = -1;
        boolean z2 = false;
        for (String str2 : set) {
            try {
                URIish uRIish2 = new URIish(str2);
                if (compare(uRIish.getScheme(), uRIish2.getScheme()) && compare(uRIish.getHost(), uRIish2.getHost()) && defaultedPort(uRIish.getPort(), uRIish.getScheme()) == defaultedPort(uRIish2.getPort(), uRIish2.getScheme())) {
                    if (uRIish2.getUser() == null) {
                        z = false;
                    } else if (uRIish2.getUser().equals(uRIish.getUser())) {
                        z = true;
                    }
                    String path2 = uRIish2.getPath();
                    if (StringUtils.isEmptyOrNull(path2)) {
                        iSegmentCompare = 0;
                    } else if (!zIsEmptyOrNull && (iSegmentCompare = segmentCompare(path, path2)) >= 0) {
                    }
                    if (iSegmentCompare > i || (!z2 && z && iSegmentCompare >= 0 && iSegmentCompare == i)) {
                        str = str2;
                        i = iSegmentCompare;
                        z2 = z;
                    }
                }
            } catch (URISyntaxException unused) {
                LOG.warn(MessageFormat.format(JGitText.get().httpConfigInvalidURL, str2));
            }
        }
        return str;
    }

    private boolean compare(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equalsIgnoreCase(str2);
    }

    private int defaultedPort(int i, String str) {
        if (i >= 0) {
            return i;
        }
        if (FTP.equalsIgnoreCase(str)) {
            return 21;
        }
        return "http".equalsIgnoreCase(str) ? 80 : 443;
    }

    static int segmentCompare(String str, String str2) {
        String strNormalize = normalize(str2);
        if (strNormalize == null || !str.startsWith(strNormalize)) {
            return -1;
        }
        int length = str.length();
        int length2 = strNormalize.length();
        if (length2 == length || strNormalize.charAt(length2 - 1) == '/' || (length2 < length && str.charAt(length2) == '/')) {
            return length2;
        }
        return -1;
    }

    static String normalize(String str) {
        int i;
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        sb.append('/');
        int i2 = 0;
        if (length > 0 && str.charAt(0) == '/') {
            i2 = 1;
        }
        while (i2 < length) {
            int iIndexOf = str.indexOf(47, i2);
            if (iIndexOf < 0) {
                iIndexOf = length;
            }
            if (iIndexOf != i2 && (iIndexOf != (i = i2 + 1) || str.charAt(i2) != '.')) {
                if (iIndexOf == i2 + 2 && str.charAt(i2) == '.' && str.charAt(i) == '.') {
                    int length2 = sb.length() - 2;
                    while (length2 >= 0 && sb.charAt(length2) != '/') {
                        length2--;
                    }
                    if (length2 < 0) {
                        LOG.warn(MessageFormat.format(JGitText.get().httpConfigCannotNormalizeURL, str));
                        return null;
                    }
                    sb.setLength(length2 + 1);
                } else {
                    sb.append((CharSequence) str, i2, Math.min(length, iIndexOf + 1));
                }
            }
            i2 = iIndexOf + 1;
        }
        if (sb.length() > 1 && sb.charAt(sb.length() - 1) == '/' && length > 0 && str.charAt(length - 1) != '/') {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
}
