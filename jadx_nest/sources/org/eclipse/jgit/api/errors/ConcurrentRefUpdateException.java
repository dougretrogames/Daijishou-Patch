package org.eclipse.jgit.api.errors;

import java.text.MessageFormat;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.RefUpdate;

/* JADX INFO: loaded from: classes5.dex */
public class ConcurrentRefUpdateException extends GitAPIException {
    private static final long serialVersionUID = 1;
    private RefUpdate.Result rc;
    private Ref ref;

    /* JADX WARN: Illegal instructions before constructor call */
    public ConcurrentRefUpdateException(String str, Ref ref, RefUpdate.Result result, Throwable th) {
        if (result != null) {
            str = str + ". " + MessageFormat.format(JGitText.get().refUpdateReturnCodeWas, result);
        }
        super(str, th);
        this.rc = result;
        this.ref = ref;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ConcurrentRefUpdateException(String str, Ref ref, RefUpdate.Result result) {
        if (result != null) {
            str = str + ". " + MessageFormat.format(JGitText.get().refUpdateReturnCodeWas, result);
        }
        super(str);
        this.rc = result;
        this.ref = ref;
    }

    public Ref getRef() {
        return this.ref;
    }

    public RefUpdate.Result getResult() {
        return this.rc;
    }
}
