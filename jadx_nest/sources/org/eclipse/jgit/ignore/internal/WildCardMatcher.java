package org.eclipse.jgit.ignore.internal;

import java.util.regex.Pattern;
import org.eclipse.jgit.errors.InvalidPatternException;

/* JADX INFO: loaded from: classes5.dex */
public class WildCardMatcher extends NameMatcher {
    final Pattern p;

    WildCardMatcher(String str, Character ch, boolean z) throws InvalidPatternException {
        super(str, ch, z, false);
        this.p = Strings.convertGlob(this.subPattern);
    }

    @Override // org.eclipse.jgit.ignore.internal.NameMatcher, org.eclipse.jgit.ignore.IMatcher
    public boolean matches(String str, int i, int i2) {
        return this.p.matcher(str.substring(i, i2)).matches();
    }
}
