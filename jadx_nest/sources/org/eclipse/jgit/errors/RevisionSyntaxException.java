package org.eclipse.jgit.errors;

/* JADX INFO: loaded from: classes5.dex */
public class RevisionSyntaxException extends IllegalArgumentException {
    private static final long serialVersionUID = 1;
    private final String revstr;

    public RevisionSyntaxException(String str) {
        this.revstr = str;
    }

    public RevisionSyntaxException(String str, String str2) {
        super(str);
        this.revstr = str2;
    }

    public String getRevstr() {
        return this.revstr;
    }
}
