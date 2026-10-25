package org.eclipse.jgit.lib;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class RefRename {
    protected final RefUpdate destination;
    private RefUpdate.Result result = RefUpdate.Result.NOT_ATTEMPTED;
    protected final RefUpdate source;

    protected abstract RefUpdate.Result doRename() throws IOException;

    protected RefRename(RefUpdate refUpdate, RefUpdate refUpdate2) {
        String str;
        this.source = refUpdate;
        this.destination = refUpdate2;
        if (refUpdate.getName().startsWith(Constants.R_HEADS) && refUpdate2.getName().startsWith(Constants.R_HEADS)) {
            str = "Branch: ";
        } else {
            str = "";
        }
        setRefLogMessage(str + "renamed " + Repository.shortenRefName(refUpdate.getName()) + " to " + Repository.shortenRefName(refUpdate2.getName()));
    }

    public PersonIdent getRefLogIdent() {
        return this.destination.getRefLogIdent();
    }

    public void setRefLogIdent(PersonIdent personIdent) {
        this.destination.setRefLogIdent(personIdent);
    }

    public String getRefLogMessage() {
        return this.destination.getRefLogMessage();
    }

    public void setRefLogMessage(String str) {
        if (str == null) {
            disableRefLog();
        } else {
            this.destination.setRefLogMessage(str, false);
        }
    }

    public void disableRefLog() {
        this.destination.setRefLogMessage("", false);
    }

    public RefUpdate.Result getResult() {
        return this.result;
    }

    public RefUpdate.Result rename() throws IOException {
        try {
            RefUpdate.Result resultDoRename = doRename();
            this.result = resultDoRename;
            return resultDoRename;
        } catch (IOException e) {
            this.result = RefUpdate.Result.IO_FAILURE;
            throw e;
        }
    }

    protected boolean needToUpdateHEAD() throws IOException {
        Ref refExactRef = this.source.getRefDatabase().exactRef("HEAD");
        if (refExactRef == null || !refExactRef.isSymbolic()) {
            return false;
        }
        return refExactRef.getTarget().getName().equals(this.source.getName());
    }
}
