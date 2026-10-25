package org.eclipse.jgit.internal.storage.file;

import java.io.Serializable;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.CheckoutEntry;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.lib.ReflogEntry;
import org.eclipse.jgit.util.RawParseUtils;

/* JADX INFO: loaded from: classes5.dex */
public class ReflogEntryImpl implements Serializable, ReflogEntry {
    private static final long serialVersionUID = 1;
    private String comment;
    private ObjectId newId;
    private ObjectId oldId;
    private PersonIdent who;

    ReflogEntryImpl(byte[] bArr, int i) {
        this.oldId = ObjectId.fromString(bArr, i);
        int i2 = i + 41;
        if (bArr[i + 40] != 32) {
            throw new IllegalArgumentException(JGitText.get().rawLogMessageDoesNotParseAsLogEntry);
        }
        this.newId = ObjectId.fromString(bArr, i2);
        int i3 = i + 81;
        int i4 = i + 82;
        if (bArr[i3] != 32) {
            throw new IllegalArgumentException(JGitText.get().rawLogMessageDoesNotParseAsLogEntry);
        }
        this.who = RawParseUtils.parsePersonIdentOnly(bArr, i4);
        int next = RawParseUtils.next(bArr, i4, '\t');
        if (next >= bArr.length) {
            this.comment = "";
        } else {
            int iNextLF = RawParseUtils.nextLF(bArr, next);
            this.comment = iNextLF > next ? RawParseUtils.decode(bArr, next, iNextLF - 1) : "";
        }
    }

    @Override // org.eclipse.jgit.lib.ReflogEntry
    public ObjectId getOldId() {
        return this.oldId;
    }

    @Override // org.eclipse.jgit.lib.ReflogEntry
    public ObjectId getNewId() {
        return this.newId;
    }

    @Override // org.eclipse.jgit.lib.ReflogEntry
    public PersonIdent getWho() {
        return this.who;
    }

    @Override // org.eclipse.jgit.lib.ReflogEntry
    public String getComment() {
        return this.comment;
    }

    public String toString() {
        return "Entry[" + this.oldId.name() + ", " + this.newId.name() + ", " + String.valueOf(getWho()) + ", " + getComment() + CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
    }

    @Override // org.eclipse.jgit.lib.ReflogEntry
    public CheckoutEntry parseCheckout() {
        if (getComment().startsWith("checkout: moving from ")) {
            return new CheckoutEntryImpl(this);
        }
        return null;
    }
}
