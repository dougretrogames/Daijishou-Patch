package org.eclipse.jgit.api.errors;

import java.util.ArrayList;
import java.util.List;

/* INFO: loaded from: classes5.dex */
public class CheckoutConflictException extends GitAPIException {
    private static final long serialVersionUID = 1;
    private List<String> conflictingPaths;

    public CheckoutConflictException(List<String> list, org.eclipse.jgit.errors.CheckoutConflictException checkoutConflictException) {
        super(checkoutConflictException.getMessage(), checkoutConflictException);
        this.conflictingPaths = list;
    }

    CheckoutConflictException(String str, Throwable th) {
        super(str, th);
    }

    CheckoutConflictException(String str, List<String> list, Throwable th) {
        super(str, th);
        this.conflictingPaths = list;
    }

    CheckoutConflictException(String str) {
        super(str);
    }

    CheckoutConflictException(String str, List<String> list) {
        super(str);
        this.conflictingPaths = list;
    }

    public List<String> getConflictingPaths() {
        return this.conflictingPaths;
    }

    CheckoutConflictException addConflictingPath(String str) {
        if (this.conflictingPaths == null) {
            this.conflictingPaths = new ArrayList();
        }
        this.conflictingPaths.add(str);
        return this;
    }
}
