package org.apache.http.impl.cookie;

import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.http.cookie.CommonCookieAttributeHandler;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;
import org.apache.http.util.Args;
import org.apache.http.util.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
public class BasicPathHandler implements CommonCookieAttributeHandler {
    @Override // org.apache.http.cookie.CookieAttributeHandler
    public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
    }

    @Override // org.apache.http.cookie.CookieAttributeHandler
    public void parse(SetCookie setCookie, String str) throws MalformedCookieException {
        Args.notNull(setCookie, "Cookie");
        if (TextUtils.isBlank(str)) {
            str = InternalZipConstants.ZIP_FILE_SEPARATOR;
        }
        setCookie.setPath(str);
    }

    static boolean pathMatch(String str, String str2) {
        if (str2 == null) {
            str2 = InternalZipConstants.ZIP_FILE_SEPARATOR;
        }
        if (str2.length() > 1 && str2.endsWith(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        return str.startsWith(str2) && (str2.equals(InternalZipConstants.ZIP_FILE_SEPARATOR) || str.length() == str2.length() || str.charAt(str2.length()) == '/');
    }

    @Override // org.apache.http.cookie.CookieAttributeHandler
    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        Args.notNull(cookie, "Cookie");
        Args.notNull(cookieOrigin, "Cookie origin");
        return pathMatch(cookieOrigin.getPath(), cookie.getPath());
    }

    @Override // org.apache.http.cookie.CommonCookieAttributeHandler
    public String getAttributeName() {
        return "path";
    }
}
