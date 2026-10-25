package org.eclipse.jgit.diff;

import java.io.IOException;
import java.io.OutputStream;
import java.security.DigestOutputStream;
import java.security.MessageDigest;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.util.io.NullOutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class PatchIdDiffFormatter extends DiffFormatter {
    private final MessageDigest digest;

    @Override // org.eclipse.jgit.diff.DiffFormatter
    protected void formatIndexLine(OutputStream outputStream, DiffEntry diffEntry) throws IOException {
    }

    @Override // org.eclipse.jgit.diff.DiffFormatter
    protected void writeHunkHeader(int i, int i2, int i3, int i4, String str) throws IOException {
    }

    public PatchIdDiffFormatter() {
        super(new DigestOutputStream(NullOutputStream.INSTANCE, Constants.newMessageDigest()));
        this.digest = ((DigestOutputStream) getOutputStream()).getMessageDigest();
    }

    public ObjectId getCalulatedPatchId() {
        return ObjectId.fromRaw(this.digest.digest());
    }
}
