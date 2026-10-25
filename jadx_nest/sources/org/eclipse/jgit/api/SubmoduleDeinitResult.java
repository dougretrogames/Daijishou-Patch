package org.eclipse.jgit.api;

/* JADX INFO: loaded from: classes5.dex */
public class SubmoduleDeinitResult {
    private String path;
    private SubmoduleDeinitCommand.SubmoduleDeinitStatus status;

    public SubmoduleDeinitResult(String str, SubmoduleDeinitCommand.SubmoduleDeinitStatus submoduleDeinitStatus) {
        this.path = str;
        this.status = submoduleDeinitStatus;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public SubmoduleDeinitCommand.SubmoduleDeinitStatus getStatus() {
        return this.status;
    }

    public void setStatus(SubmoduleDeinitCommand.SubmoduleDeinitStatus submoduleDeinitStatus) {
        this.status = submoduleDeinitStatus;
    }
}
