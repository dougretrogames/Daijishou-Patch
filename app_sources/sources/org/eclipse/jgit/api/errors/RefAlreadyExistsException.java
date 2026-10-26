package org.eclipse.jgit.api.errors;

import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.lib.RefUpdate;

/* INFO: loaded from: classes5.dex */
public class RefAlreadyExistsException extends GitAPIException {
    private static final long serialVersionUID = 1;
    private final RefUpdate.Result updateResult;

    public RefAlreadyExistsException(String str) {
        this(str, null);
    }

    public RefAlreadyExistsException(String str, @Nullable RefUpdate.Result result) {
        super(str);
        this.updateResult = result;
    }

    @Nullable
    public RefUpdate.Result getUpdateResult() {
        return this.updateResult;
    }
}
