package org.eclipse.jgit.lib;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.eclipse.jgit.util.References;

/* JADX INFO: loaded from: classes5.dex */
public class CommitBuilder extends ObjectBuilder {
    private PersonIdent committer;
    private ObjectId[] parentIds = EMPTY_OBJECTID_LIST;
    private ObjectId treeId;
    private static final ObjectId[] EMPTY_OBJECTID_LIST = new ObjectId[0];
    private static final byte[] htree = Constants.encodeASCII(Constants.TYPE_TREE);
    private static final byte[] hparent = Constants.encodeASCII("parent");
    private static final byte[] hauthor = Constants.encodeASCII("author");
    private static final byte[] hcommitter = Constants.encodeASCII("committer");
    private static final byte[] hgpgsig = Constants.encodeASCII("gpgsig");

    public ObjectId getTreeId() {
        return this.treeId;
    }

    public void setTreeId(AnyObjectId anyObjectId) {
        this.treeId = anyObjectId.copy();
    }

    @Override // org.eclipse.jgit.lib.ObjectBuilder
    public PersonIdent getAuthor() {
        return super.getAuthor();
    }

    @Override // org.eclipse.jgit.lib.ObjectBuilder
    public void setAuthor(PersonIdent personIdent) {
        super.setAuthor(personIdent);
    }

    public PersonIdent getCommitter() {
        return this.committer;
    }

    public void setCommitter(PersonIdent personIdent) {
        this.committer = personIdent;
    }

    public ObjectId[] getParentIds() {
        return this.parentIds;
    }

    public void setParentId(AnyObjectId anyObjectId) {
        this.parentIds = new ObjectId[]{anyObjectId.copy()};
    }

    public void setParentIds(AnyObjectId anyObjectId, AnyObjectId anyObjectId2) {
        this.parentIds = new ObjectId[]{anyObjectId.copy(), anyObjectId2.copy()};
    }

    public void setParentIds(ObjectId... objectIdArr) {
        this.parentIds = new ObjectId[objectIdArr.length];
        for (int i = 0; i < objectIdArr.length; i++) {
            this.parentIds[i] = objectIdArr[i].copy();
        }
    }

    public void setParentIds(List<? extends AnyObjectId> list) {
        this.parentIds = new ObjectId[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.parentIds[i] = list.get(i).copy();
        }
    }

    public void addParentId(AnyObjectId anyObjectId) {
        ObjectId[] objectIdArr = this.parentIds;
        if (objectIdArr.length == 0) {
            setParentId(anyObjectId);
            return;
        }
        ObjectId[] objectIdArr2 = new ObjectId[objectIdArr.length + 1];
        System.arraycopy(objectIdArr, 0, objectIdArr2, 0, objectIdArr.length);
        objectIdArr2[this.parentIds.length] = anyObjectId.copy();
        this.parentIds = objectIdArr2;
    }

    @Override // org.eclipse.jgit.lib.ObjectBuilder
    public byte[] build() throws UnsupportedEncodingException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream, getEncoding());
        try {
            byteArrayOutputStream.write(htree);
            byteArrayOutputStream.write(32);
            getTreeId().copyTo(byteArrayOutputStream);
            byteArrayOutputStream.write(10);
            for (ObjectId objectId : getParentIds()) {
                byteArrayOutputStream.write(hparent);
                byteArrayOutputStream.write(32);
                objectId.copyTo(byteArrayOutputStream);
                byteArrayOutputStream.write(10);
            }
            byteArrayOutputStream.write(hauthor);
            byteArrayOutputStream.write(32);
            outputStreamWriter.write(getAuthor().toExternalString());
            outputStreamWriter.flush();
            byteArrayOutputStream.write(10);
            byteArrayOutputStream.write(hcommitter);
            byteArrayOutputStream.write(32);
            outputStreamWriter.write(getCommitter().toExternalString());
            outputStreamWriter.flush();
            byteArrayOutputStream.write(10);
            GpgSignature gpgSignature = getGpgSignature();
            if (gpgSignature != null) {
                byteArrayOutputStream.write(hgpgsig);
                byteArrayOutputStream.write(32);
                writeMultiLineHeader(gpgSignature.toExternalString(), byteArrayOutputStream, true);
                byteArrayOutputStream.write(10);
            }
            writeEncoding(getEncoding(), byteArrayOutputStream);
            byteArrayOutputStream.write(10);
            if (getMessage() != null) {
                outputStreamWriter.write(getMessage());
                outputStreamWriter.flush();
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] toByteArray() throws UnsupportedEncodingException {
        return build();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Commit={\ntree ");
        ObjectId objectId = this.treeId;
        sb.append(objectId != null ? objectId.name() : "NOT_SET");
        sb.append("\n");
        for (ObjectId objectId2 : this.parentIds) {
            sb.append("parent ");
            sb.append(objectId2.name());
            sb.append("\n");
        }
        sb.append("author ");
        sb.append(getAuthor() != null ? getAuthor().toString() : "NOT_SET");
        sb.append("\ncommitter ");
        PersonIdent personIdent = this.committer;
        sb.append(personIdent != null ? personIdent.toString() : "NOT_SET");
        sb.append("\ngpgSignature ");
        GpgSignature gpgSignature = getGpgSignature();
        sb.append(gpgSignature != null ? gpgSignature.toString() : "NOT_SET");
        sb.append("\n");
        Charset encoding = getEncoding();
        if (!References.isSameObject(encoding, StandardCharsets.UTF_8)) {
            sb.append("encoding ");
            sb.append(encoding.name());
            sb.append("\n");
        }
        sb.append("\n");
        sb.append(getMessage() != null ? getMessage() : "");
        sb.append("}");
        return sb.toString();
    }
}
