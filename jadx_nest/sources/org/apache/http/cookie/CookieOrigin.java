package org.apache.http.cookie;

import java.util.Locale;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.http.util.Args;
import org.apache.http.util.TextUtils;
import org.eclipse.jgit.transport.SshConstants;

/* JADX INFO: loaded from: classes5.dex */
public final class CookieOrigin {
    private final String host;
    private final String path;
    private final int port;
    private final boolean secure;

    public CookieOrigin(String str, int i, String str2, boolean z) {
        Args.notBlank(str, "Host");
        Args.notNegative(i, SshConstants.PORT);
        Args.notNull(str2, "Path");
        this.host = str.toLowerCase(Locale.ROOT);
        this.port = i;
        if (!TextUtils.isBlank(str2)) {
            this.path = str2;
        } else {
            this.path = InternalZipConstants.ZIP_FILE_SEPARATOR;
        }
        this.secure = z;
    }

    public String getHost() {
        return this.host;
    }

    public String getPath() {
        return this.path;
    }

    public int getPort() {
        return this.port;
    }

    public boolean isSecure() {
        return this.secure;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(CollectionUtils.DEFAULT_TOSTRING_PREFIX);
        if (this.secure) {
            sb.append("(secure)");
        }
        sb.append(this.host);
        sb.append(AbstractJsonLexerKt.COLON);
        sb.append(Integer.toString(this.port));
        sb.append(this.path);
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }
}
