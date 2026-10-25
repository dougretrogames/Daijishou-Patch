package org.eclipse.jgit.transport;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.BitSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.util.RawParseUtils;
import org.eclipse.jgit.util.References;
import org.eclipse.jgit.util.StringUtils;

/* JADX INFO: loaded from: classes5.dex */
public class URIish implements Serializable {
    private static final String HOST_P = "((?:[^\\\\/:]+)|(?:\\[[0-9a-f:]+\\]))";
    private static final String OPT_DRIVE_LETTER_P = "(?:[A-Za-z]:)?";
    private static final String OPT_PORT_P = "(?::(\\d*))?";
    private static final String OPT_USER_PWD_P = "(?:([^/:]+)(?::([^\\\\/]+))?@)?";
    private static final String PATH_P = "((?:[A-Za-z]:)?[\\\\/]?(?:(?:[^\\\\/]+[\\\\/]+)*[^\\\\/]+[\\\\/]*))";
    private static final String RELATIVE_PATH_P = "(?:(?:[^\\\\/]+[\\\\/]+)*[^\\\\/]+[\\\\/]*)";
    private static final String SCHEME_P = "([a-z][a-z0-9+-]+)://";
    private static final String USER_HOME_P = "(?:/~(?:[^\\\\/]+))";
    private static final long serialVersionUID = 1;
    private String host;
    private String pass;
    private String path;
    private int port;
    private String rawPath;
    private String scheme;
    private String user;
    private static final Pattern FULL_URI = Pattern.compile("^([a-z][a-z0-9+-]+)://(?:(?:([^/:]+)(?::([^\\\\/]+))?@)?((?:[^\\\\/:]+)|(?:\\[[0-9a-f:]+\\]))(?::(\\d*))?((?:/~(?:[^\\\\/]+))?(?:[\\\\/])|$))?(.+)?$");
    private static final Pattern LOCAL_FILE = Pattern.compile("^([\\\\/]?((?:[A-Za-z]:)?[\\\\/]?(?:(?:[^\\\\/]+[\\\\/]+)*[^\\\\/]+[\\\\/]*)))$");
    private static final Pattern SINGLE_SLASH_FILE_URI = Pattern.compile("^(file):([\\\\/](?![\\\\/])((?:[A-Za-z]:)?[\\\\/]?(?:(?:[^\\\\/]+[\\\\/]+)*[^\\\\/]+[\\\\/]*)))$");
    private static final Pattern RELATIVE_SCP_URI = Pattern.compile("^(?:([^/:]+)(?::([^\\\\/]+))?@)?((?:[^\\\\/:]+)|(?:\\[[0-9a-f:]+\\])):((?:(?:/~(?:[^\\\\/]+))[\\\\/])?(?:(?:[^\\\\/]+[\\\\/]+)*[^\\\\/]+[\\\\/]*))$");
    private static final Pattern ABSOLUTE_SCP_URI = Pattern.compile("^(?:([^/:]+)(?::([^\\\\/]+))?@)?([^\\\\/:]{2,}):([\\\\/](?:(?:[^\\\\/]+[\\\\/]+)*[^\\\\/]+[\\\\/]*))$");
    private static final BitSet reservedChars = new BitSet(127);

    static {
        for (byte b : Constants.encodeASCII("!*'();:@&=+$,/?#[]")) {
            reservedChars.set(b);
        }
    }

    public URIish(String str) throws URISyntaxException {
        this.port = -1;
        if (StringUtils.isEmptyOrNull(str)) {
            throw new URISyntaxException("The uri was empty or null", JGitText.get().cannotParseGitURIish);
        }
        Matcher matcher = SINGLE_SLASH_FILE_URI.matcher(str);
        if (matcher.matches()) {
            this.scheme = matcher.group(1);
            String strCleanLeadingSlashes = cleanLeadingSlashes(matcher.group(2), this.scheme);
            this.rawPath = strCleanLeadingSlashes;
            this.path = unescape(strCleanLeadingSlashes);
            return;
        }
        Matcher matcher2 = FULL_URI.matcher(str);
        if (matcher2.matches()) {
            this.scheme = matcher2.group(1);
            this.user = unescape(matcher2.group(2));
            this.pass = unescape(matcher2.group(3));
            String strGroup = matcher2.group(5);
            if ("file".equals(this.scheme) && "".equals(strGroup)) {
                this.rawPath = cleanLeadingSlashes(n2e(matcher2.group(4)) + CollectionUtils.COLON + strGroup + n2e(matcher2.group(6)) + n2e(matcher2.group(7)), this.scheme);
            } else {
                this.host = unescape(matcher2.group(4));
                if (strGroup != null && strGroup.length() > 0) {
                    this.port = Integer.parseInt(strGroup);
                }
                this.rawPath = cleanLeadingSlashes(n2e(matcher2.group(6)) + n2e(matcher2.group(7)), this.scheme);
            }
            this.path = unescape(this.rawPath);
            return;
        }
        Matcher matcher3 = RELATIVE_SCP_URI.matcher(str);
        if (matcher3.matches()) {
            this.user = matcher3.group(1);
            this.pass = matcher3.group(2);
            this.host = matcher3.group(3);
            String strGroup2 = matcher3.group(4);
            this.rawPath = strGroup2;
            this.path = strGroup2;
            return;
        }
        Matcher matcher4 = ABSOLUTE_SCP_URI.matcher(str);
        if (matcher4.matches()) {
            this.user = matcher4.group(1);
            this.pass = matcher4.group(2);
            this.host = matcher4.group(3);
            String strGroup3 = matcher4.group(4);
            this.rawPath = strGroup3;
            this.path = strGroup3;
            return;
        }
        Matcher matcher5 = LOCAL_FILE.matcher(str);
        if (matcher5.matches()) {
            String strGroup4 = matcher5.group(1);
            this.rawPath = strGroup4;
            this.path = strGroup4;
            return;
        }
        throw new URISyntaxException(str, JGitText.get().cannotParseGitURIish);
    }

    private static int parseHexByte(byte b, byte b2) {
        return (RawParseUtils.parseHexInt4(b) << 4) | RawParseUtils.parseHexInt4(b2);
    }

    private static String unescape(String str) throws URISyntaxException {
        int i;
        if (str == null) {
            return null;
        }
        if (str.indexOf(37) < 0) {
            return str;
        }
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        byte[] bArr = new byte[bytes.length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < bytes.length) {
            byte b = bytes[i2];
            if (b == 37) {
                int i4 = i2 + 2;
                if (i4 >= bytes.length) {
                    throw new URISyntaxException(str, JGitText.get().cannotParseGitURIish);
                }
                try {
                    i = i3 + 1;
                    bArr[i3] = (byte) parseHexByte(bytes[i2 + 1], bytes[i4]);
                    i2 = i4;
                } catch (ArrayIndexOutOfBoundsException e) {
                    URISyntaxException uRISyntaxException = new URISyntaxException(str, JGitText.get().cannotParseGitURIish);
                    uRISyntaxException.initCause(e);
                    throw uRISyntaxException;
                }
            } else {
                i = i3 + 1;
                bArr[i3] = b;
            }
            i3 = i;
            i2++;
        }
        return RawParseUtils.decode(bArr, 0, i3);
    }

    private static String escape(String str, boolean z, boolean z2) {
        if (str == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length());
        for (byte b : str.getBytes(StandardCharsets.UTF_8)) {
            int i = b & 255;
            if (i <= 32 || ((z2 && i > 127) || i == 37 || (z && reservedChars.get(i)))) {
                byteArrayOutputStream.write(37);
                byte[] bArrEncodeASCII = Constants.encodeASCII(String.format("%02x", Integer.valueOf(i)));
                byteArrayOutputStream.write(bArrEncodeASCII[0]);
                byteArrayOutputStream.write(bArrEncodeASCII[1]);
            } else {
                byteArrayOutputStream.write(i);
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        return RawParseUtils.decode(byteArray, 0, byteArray.length);
    }

    private String n2e(String str) {
        return str == null ? "" : str;
    }

    private String cleanLeadingSlashes(String str, String str2) {
        if (str.length() < 3 || str.charAt(0) != '/' || str.charAt(2) != ':' || ((str.charAt(1) < 'A' || str.charAt(1) > 'Z') && (str.charAt(1) < 'a' || str.charAt(1) > 'z'))) {
            return (str2 == null || str.length() < 2 || str.charAt(0) != '/' || str.charAt(1) != '~') ? str : str.substring(1);
        }
        return str.substring(1);
    }

    public URIish(URL url) {
        this.port = -1;
        this.scheme = url.getProtocol();
        String path = url.getPath();
        this.path = path;
        this.path = cleanLeadingSlashes(path, this.scheme);
        try {
            String rawPath = url.toURI().getRawPath();
            this.rawPath = rawPath;
            this.rawPath = cleanLeadingSlashes(rawPath, this.scheme);
            String userInfo = url.getUserInfo();
            if (userInfo != null) {
                int iIndexOf = userInfo.indexOf(58);
                this.user = iIndexOf < 0 ? userInfo : userInfo.substring(0, iIndexOf);
                this.pass = iIndexOf < 0 ? null : userInfo.substring(iIndexOf + 1);
            }
            this.port = url.getPort();
            this.host = url.getHost();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public URIish() {
        this.port = -1;
    }

    private URIish(URIish uRIish) {
        this.port = -1;
        this.scheme = uRIish.scheme;
        this.rawPath = uRIish.rawPath;
        this.path = uRIish.path;
        this.user = uRIish.user;
        this.pass = uRIish.pass;
        this.port = uRIish.port;
        this.host = uRIish.host;
    }

    public boolean isRemote() {
        return getHost() != null;
    }

    public String getHost() {
        return this.host;
    }

    public URIish setHost(String str) {
        URIish uRIish = new URIish(this);
        uRIish.host = str;
        return uRIish;
    }

    public String getScheme() {
        return this.scheme;
    }

    public URIish setScheme(String str) {
        URIish uRIish = new URIish(this);
        uRIish.scheme = str;
        return uRIish;
    }

    public String getPath() {
        return this.path;
    }

    public String getRawPath() {
        return this.rawPath;
    }

    public URIish setPath(String str) {
        URIish uRIish = new URIish(this);
        uRIish.path = str;
        uRIish.rawPath = str;
        return uRIish;
    }

    public URIish setRawPath(String str) throws URISyntaxException {
        URIish uRIish = new URIish(this);
        uRIish.path = unescape(str);
        uRIish.rawPath = str;
        return uRIish;
    }

    public String getUser() {
        return this.user;
    }

    public URIish setUser(String str) {
        URIish uRIish = new URIish(this);
        uRIish.user = str;
        return uRIish;
    }

    public String getPass() {
        return this.pass;
    }

    public URIish setPass(String str) {
        URIish uRIish = new URIish(this);
        uRIish.pass = str;
        return uRIish;
    }

    public int getPort() {
        return this.port;
    }

    public URIish setPort(int i) {
        URIish uRIish = new URIish(this);
        if (i <= 0) {
            i = -1;
        }
        uRIish.port = i;
        return uRIish;
    }

    public int hashCode() {
        int iHashCode = getScheme() != null ? getScheme().hashCode() : 0;
        if (getUser() != null) {
            iHashCode = (iHashCode * 31) + getUser().hashCode();
        }
        if (getPass() != null) {
            iHashCode = (iHashCode * 31) + getPass().hashCode();
        }
        if (getHost() != null) {
            iHashCode = (iHashCode * 31) + getHost().hashCode();
        }
        if (getPort() > 0) {
            iHashCode = (iHashCode * 31) + getPort();
        }
        return getPath() != null ? (iHashCode * 31) + getPath().hashCode() : iHashCode;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof URIish)) {
            return false;
        }
        URIish uRIish = (URIish) obj;
        return eq(getScheme(), uRIish.getScheme()) && eq(getUser(), uRIish.getUser()) && eq(getPass(), uRIish.getPass()) && eq(getHost(), uRIish.getHost()) && getPort() == uRIish.getPort() && eq(getPath(), uRIish.getPath());
    }

    private static boolean eq(String str, String str2) {
        if (References.isSameObject(str, str2)) {
            return true;
        }
        if (StringUtils.isEmptyOrNull(str) && StringUtils.isEmptyOrNull(str2)) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    public String toPrivateString() {
        return format(true, false);
    }

    public String toString() {
        return format(false, false);
    }

    private String format(boolean z, boolean z2) {
        StringBuilder sb = new StringBuilder();
        if (getScheme() != null) {
            sb.append(getScheme());
            sb.append("://");
        }
        if (getUser() != null) {
            sb.append(escape(getUser(), true, z2));
            if (z && getPass() != null) {
                sb.append(AbstractJsonLexerKt.COLON);
                sb.append(escape(getPass(), true, z2));
            }
        }
        if (getHost() != null) {
            if (getUser() != null && getUser().length() > 0) {
                sb.append('@');
            }
            sb.append(escape(getHost(), false, z2));
            if (getScheme() != null && getPort() > 0) {
                sb.append(AbstractJsonLexerKt.COLON);
                sb.append(getPort());
            }
        }
        if (getPath() != null) {
            if (getScheme() != null) {
                if (!getPath().startsWith(InternalZipConstants.ZIP_FILE_SEPARATOR) && !getPath().isEmpty()) {
                    sb.append('/');
                }
            } else if (getHost() != null) {
                sb.append(AbstractJsonLexerKt.COLON);
            }
            if (getScheme() == null) {
                sb.append(getPath());
            } else if (z2) {
                sb.append(escape(getPath(), false, z2));
            } else {
                sb.append(getRawPath());
            }
        }
        return sb.toString();
    }

    public String toASCIIString() {
        return format(false, true);
    }

    public String toPrivateASCIIString() {
        return format(true, true);
    }

    public String getHumanishName() throws IllegalArgumentException {
        String[] strArrSplit;
        String path = getPath();
        if (InternalZipConstants.ZIP_FILE_SEPARATOR.equals(path) || "".equals(path)) {
            path = getHost();
        }
        if (path == null) {
            throw new IllegalArgumentException();
        }
        if ("file".equals(this.scheme) || LOCAL_FILE.matcher(path).matches()) {
            strArrSplit = path.split("[\\" + File.separatorChar + "/]");
        } else {
            strArrSplit = path.split("/+");
        }
        if (strArrSplit.length == 0) {
            throw new IllegalArgumentException();
        }
        String strSubstring = strArrSplit[strArrSplit.length - 1];
        if (".git".equals(strSubstring)) {
            strSubstring = strArrSplit[strArrSplit.length - 2];
        } else if (strSubstring.endsWith(".git")) {
            strSubstring = strSubstring.substring(0, strSubstring.length() - ".git".length());
        }
        return (("file".equals(this.scheme) || LOCAL_FILE.matcher(path).matches()) && strSubstring.endsWith(Constants.DOT_BUNDLE_EXT)) ? strSubstring.substring(0, strSubstring.length() - Constants.DOT_BUNDLE_EXT.length()) : strSubstring;
    }
}
