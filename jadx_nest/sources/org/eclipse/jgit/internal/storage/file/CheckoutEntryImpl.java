package org.eclipse.jgit.internal.storage.file;

import org.eclipse.jgit.lib.CheckoutEntry;
import org.eclipse.jgit.lib.ReflogEntry;

/* JADX INFO: loaded from: classes5.dex */
public class CheckoutEntryImpl implements CheckoutEntry {
    static final String CHECKOUT_MOVING_FROM = "checkout: moving from ";
    private String from;
    private String to;

    CheckoutEntryImpl(ReflogEntry reflogEntry) {
        String comment = reflogEntry.getComment();
        int length = CHECKOUT_MOVING_FROM.length();
        int iIndexOf = comment.indexOf(" to ", length);
        int length2 = comment.length();
        this.from = comment.substring(length, iIndexOf);
        this.to = comment.substring(iIndexOf + " to ".length(), length2);
    }

    @Override // org.eclipse.jgit.lib.CheckoutEntry
    public String getFromBranch() {
        return this.from;
    }

    @Override // org.eclipse.jgit.lib.CheckoutEntry
    public String getToBranch() {
        return this.to;
    }
}
