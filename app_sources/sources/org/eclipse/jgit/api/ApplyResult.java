package org.eclipse.jgit.api;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* INFO: loaded from: classes5.dex */
public class ApplyResult {
    private List<File> updatedFiles = new ArrayList();

    public ApplyResult addUpdatedFile(File file) {
        this.updatedFiles.add(file);
        return this;
    }

    public List<File> getUpdatedFiles() {
        return this.updatedFiles;
    }
}
