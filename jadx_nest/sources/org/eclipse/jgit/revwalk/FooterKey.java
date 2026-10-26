package org.eclipse.jgit.revwalk;

import java.util.Locale;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.lib.Constants;

/* INFO: loaded from: classes5.dex */
public final class FooterKey {
    private final String name;
    final byte[] raw;
    public static final FooterKey SIGNED_OFF_BY = new FooterKey("Signed-off-by");
    public static final FooterKey ACKED_BY = new FooterKey("Acked-by");
    public static final FooterKey CC = new FooterKey("CC");

    public FooterKey(String str) {
        this.name = str;
        this.raw = Constants.encode(str.toLowerCase(Locale.ROOT));
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "FooterKey[" + this.name + CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
    }
}
