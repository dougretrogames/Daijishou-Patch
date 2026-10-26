package org.eclipse.jgit.lib;

import java.io.IOException;
import org.apache.http.message.TokenParser;
import org.eclipse.jgit.errors.CorruptObjectException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.revwalk.RevBlob;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.treewalk.CanonicalTreeParser;
import org.eclipse.jgit.util.TemporaryBuffer;

/* INFO: loaded from: classes5.dex */
public class TreeFormatter {
    private byte[] buf;
    private TemporaryBuffer.Heap overflowBuffer;
    private int ptr;

    public static int entrySize(FileMode fileMode, int i) {
        return fileMode.copyToLength() + i + 22;
    }

    public TreeFormatter() {
        this(8192);
    }

    public TreeFormatter(int i) {
        this.buf = new byte[i];
    }

    public void append(String str, RevCommit revCommit) {
        append(str, FileMode.GITLINK, revCommit);
    }

    public void append(String str, RevTree revTree) {
        append(str, FileMode.TREE, revTree);
    }

    public void append(String str, RevBlob revBlob) {
        append(str, FileMode.REGULAR_FILE, revBlob);
    }

    public void append(String str, FileMode fileMode, AnyObjectId anyObjectId) {
        append(Constants.encode(str), fileMode, anyObjectId);
    }

    public void append(byte[] bArr, FileMode fileMode, AnyObjectId anyObjectId) {
        append(bArr, 0, bArr.length, fileMode, anyObjectId);
    }

    public void append(byte[] bArr, int i, int i2, FileMode fileMode, AnyObjectId anyObjectId) {
        append(bArr, i, i2, fileMode, anyObjectId, false);
    }

    public void append(byte[] bArr, int i, int i2, FileMode fileMode, AnyObjectId anyObjectId, boolean z) {
        if (i2 == 0 && !z) {
            throw new IllegalArgumentException(JGitText.get().invalidTreeZeroLengthName);
        }
        if (fmtBuf(bArr, i, i2, fileMode)) {
            anyObjectId.copyRawTo(this.buf, this.ptr);
            this.ptr += 20;
        } else {
            try {
                fmtOverflowBuffer(bArr, i, i2, fileMode);
                anyObjectId.copyRawTo(this.overflowBuffer);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void append(byte[] bArr, int i, int i2, FileMode fileMode, byte[] bArr2, int i3) {
        if (fmtBuf(bArr, i, i2, fileMode)) {
            System.arraycopy(bArr2, i3, this.buf, this.ptr, 20);
            this.ptr += 20;
        } else {
            try {
                fmtOverflowBuffer(bArr, i, i2, fileMode);
                this.overflowBuffer.write(bArr2, i3, 20);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private boolean fmtBuf(byte[] bArr, int i, int i2, FileMode fileMode) {
        byte[] bArr2 = this.buf;
        if (bArr2 == null || bArr2.length < this.ptr + entrySize(fileMode, i2)) {
            return false;
        }
        fileMode.copyTo(this.buf, this.ptr);
        int iCopyToLength = this.ptr + fileMode.copyToLength();
        byte[] bArr3 = this.buf;
        int i3 = iCopyToLength + 1;
        this.ptr = i3;
        bArr3[iCopyToLength] = 32;
        System.arraycopy(bArr, i, bArr3, i3, i2);
        int i4 = this.ptr + i2;
        byte[] bArr4 = this.buf;
        this.ptr = i4 + 1;
        bArr4[i4] = 0;
        return true;
    }

    private void fmtOverflowBuffer(byte[] bArr, int i, int i2, FileMode fileMode) throws IOException {
        if (this.buf != null) {
            TemporaryBuffer.Heap heap = new TemporaryBuffer.Heap(Integer.MAX_VALUE);
            this.overflowBuffer = heap;
            heap.write(this.buf, 0, this.ptr);
            this.buf = null;
        }
        fileMode.copyTo(this.overflowBuffer);
        this.overflowBuffer.write(32);
        this.overflowBuffer.write(bArr, i, i2);
        this.overflowBuffer.write(0);
    }

    public ObjectId insertTo(ObjectInserter objectInserter) throws IOException {
        byte[] bArr = this.buf;
        if (bArr != null) {
            return objectInserter.insert(2, bArr, 0, this.ptr);
        }
        return objectInserter.insert(2, this.overflowBuffer.length(), this.overflowBuffer.openInputStream());
    }

    public ObjectId computeId(ObjectInserter objectInserter) {
        byte[] bArr = this.buf;
        if (bArr != null) {
            return objectInserter.idFor(2, bArr, 0, this.ptr);
        }
        try {
            return objectInserter.idFor(2, this.overflowBuffer.length(), this.overflowBuffer.openInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] toByteArray() {
        byte[] bArr = this.buf;
        if (bArr != null) {
            int i = this.ptr;
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            return bArr2;
        }
        try {
            return this.overflowBuffer.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        byte[] byteArray = toByteArray();
        CanonicalTreeParser canonicalTreeParser = new CanonicalTreeParser();
        canonicalTreeParser.reset(byteArray);
        StringBuilder sb = new StringBuilder("Tree={");
        if (!canonicalTreeParser.eof()) {
            sb.append('\n');
            try {
                new ObjectChecker().checkTree(byteArray);
            } catch (CorruptObjectException e) {
                sb.append("*** ERROR: ").append(e.getMessage()).append("\n\n");
            }
        }
        while (!canonicalTreeParser.eof()) {
            FileMode entryFileMode = canonicalTreeParser.getEntryFileMode();
            sb.append(entryFileMode);
            sb.append(TokenParser.SP);
            sb.append(Constants.typeString(entryFileMode.getObjectType()));
            sb.append(TokenParser.SP);
            sb.append(canonicalTreeParser.getEntryObjectId().name());
            sb.append(TokenParser.SP);
            sb.append(canonicalTreeParser.getEntryPathString());
            sb.append('\n');
            canonicalTreeParser.next();
        }
        sb.append("}");
        return sb.toString();
    }
}
