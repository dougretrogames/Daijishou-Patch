package org.eclipse.jgit.errors;

import java.text.MessageFormat;
import org.eclipse.jgit.internal.JGitText;

/* INFO: loaded from: classes5.dex */
public class NoClosingBracketException extends InvalidPatternException {
    private static final long serialVersionUID = 1;

    public NoClosingBracketException(int i, String str, String str2, String str3) {
        super(createMessage(i, str, str2), str3);
    }

    private static String createMessage(int i, String str, String str2) {
        return MessageFormat.format(JGitText.get().noClosingBracket, str2, str, Integer.valueOf(i));
    }
}
