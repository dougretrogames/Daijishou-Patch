package org.eclipse.jgit.lib;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.revwalk.RevObject;
import org.eclipse.jgit.util.References;

/* JADX INFO: loaded from: classes5.dex */
public class TagBuilder extends ObjectBuilder {
    private ObjectId object;
    private String tag;
    private int type = -1;
    private static final byte[] hobject = Constants.encodeASCII("object");
    private static final byte[] htype = Constants.encodeASCII("type");
    private static final byte[] htag = Constants.encodeASCII("tag");
    private static final byte[] htagger = Constants.encodeASCII("tagger");

    public int getObjectType() {
        return this.type;
    }

    public ObjectId getObjectId() {
        return this.object;
    }

    public void setObjectId(AnyObjectId anyObjectId, int i) {
        this.object = anyObjectId.copy();
        this.type = i;
    }

    public void setObjectId(RevObject revObject) {
        setObjectId(revObject, revObject.getType());
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public PersonIdent getTagger() {
        return getAuthor();
    }

    public void setTagger(PersonIdent personIdent) {
        setAuthor(personIdent);
    }

    @Override // org.eclipse.jgit.lib.ObjectBuilder
    public byte[] build() throws UnsupportedEncodingException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Throwable th = null;
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream, getEncoding());
            try {
                byteArrayOutputStream.write(hobject);
                byteArrayOutputStream.write(32);
                getObjectId().copyTo(byteArrayOutputStream);
                byteArrayOutputStream.write(10);
                byteArrayOutputStream.write(htype);
                byteArrayOutputStream.write(32);
                byteArrayOutputStream.write(Constants.encodeASCII(Constants.typeString(getObjectType())));
                byteArrayOutputStream.write(10);
                byteArrayOutputStream.write(htag);
                byteArrayOutputStream.write(32);
                outputStreamWriter.write(getTag());
                outputStreamWriter.flush();
                byteArrayOutputStream.write(10);
                if (getTagger() != null) {
                    byteArrayOutputStream.write(htagger);
                    byteArrayOutputStream.write(32);
                    outputStreamWriter.write(getTagger().toExternalString());
                    outputStreamWriter.flush();
                    byteArrayOutputStream.write(10);
                }
                writeEncoding(getEncoding(), byteArrayOutputStream);
                byteArrayOutputStream.write(10);
                String message = getMessage();
                if (message != null) {
                    outputStreamWriter.write(message);
                    outputStreamWriter.flush();
                }
                GpgSignature gpgSignature = getGpgSignature();
                if (gpgSignature != null) {
                    if (message != null && !message.isEmpty() && !message.endsWith("\n")) {
                        throw new JGitInternalException(JGitText.get().signedTagMessageNoLf);
                    }
                    String externalString = gpgSignature.toExternalString();
                    outputStreamWriter.write(externalString);
                    outputStreamWriter.flush();
                    if (!externalString.endsWith("\n")) {
                        byteArrayOutputStream.write(10);
                    }
                }
                outputStreamWriter.close();
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th2) {
                outputStreamWriter.close();
                throw th2;
            }
        } catch (Throwable th3) {
            if (0 == 0) {
                throw th3;
            }
            if (null != th3) {
                try {
                    th.addSuppressed(th3);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            throw null;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Tag={\nobject ");
        ObjectId objectId = this.object;
        sb.append(objectId != null ? objectId.name() : "NOT_SET");
        sb.append("\ntype ");
        sb.append(this.object != null ? Constants.typeString(this.type) : "NOT_SET");
        sb.append("\ntag ");
        String str = this.tag;
        sb.append(str != null ? str : "NOT_SET");
        sb.append("\n");
        if (getTagger() != null) {
            sb.append("tagger ");
            sb.append(getTagger());
            sb.append("\n");
        }
        Charset encoding = getEncoding();
        if (!References.isSameObject(encoding, StandardCharsets.UTF_8)) {
            sb.append("encoding ");
            sb.append(encoding.name());
            sb.append("\n");
        }
        sb.append("\n");
        sb.append(getMessage() != null ? getMessage() : "");
        GpgSignature gpgSignature = getGpgSignature();
        sb.append(gpgSignature != null ? gpgSignature.toExternalString() : "");
        sb.append("}");
        return sb.toString();
    }
}
