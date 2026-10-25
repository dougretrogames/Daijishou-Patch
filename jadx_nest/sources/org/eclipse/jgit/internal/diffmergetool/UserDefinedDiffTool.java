package org.eclipse.jgit.internal.diffmergetool;

/* JADX INFO: loaded from: classes5.dex */
public class UserDefinedDiffTool implements ExternalDiffTool {
    private boolean available;
    private final String cmd;
    private final String name;
    private String path;

    public UserDefinedDiffTool(String str, String str2, String str3) {
        this.name = str;
        this.path = str2;
        this.cmd = str3;
    }

    @Override // org.eclipse.jgit.internal.diffmergetool.ExternalDiffTool
    public String getName() {
        return this.name;
    }

    @Override // org.eclipse.jgit.internal.diffmergetool.ExternalDiffTool
    public String getPath() {
        return this.path;
    }

    @Override // org.eclipse.jgit.internal.diffmergetool.ExternalDiffTool
    public String getCommand() {
        return this.cmd;
    }

    @Override // org.eclipse.jgit.internal.diffmergetool.ExternalDiffTool
    public boolean isAvailable() {
        return this.available;
    }

    public void setAvailable(boolean z) {
        this.available = z;
    }

    public void setPath(String str) {
        this.path = str;
    }
}
