package org.eclipse.jgit.errors;

/* JADX INFO: loaded from: classes5.dex */
public class DirCacheNameConflictException extends IllegalStateException {
    private static final long serialVersionUID = 1;
    private final String path1;
    private final String path2;

    public DirCacheNameConflictException(String str, String str2) {
        super(str + " " + str2);
        this.path1 = str;
        this.path2 = str2;
    }

    public String getPath1() {
        return this.path1;
    }

    public String getPath2() {
        return this.path2;
    }
}
