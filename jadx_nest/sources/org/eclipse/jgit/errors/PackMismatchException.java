package org.eclipse.jgit.errors;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class PackMismatchException extends IOException {
    private static final long serialVersionUID = 1;
    private boolean permanent;

    public PackMismatchException(String str) {
        super(str);
    }

    public void setPermanent(boolean z) {
        this.permanent = z;
    }

    public boolean isPermanent() {
        return this.permanent;
    }
}
