package org.eclipse.jgit.lib;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.Objects;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.util.References;

/* INFO: loaded from: classes5.dex */
public abstract class ObjectBuilder {
    private static final byte[] hencoding = Constants.encodeASCII("encoding");
    private PersonIdent author;
    private Charset encoding = StandardCharsets.UTF_8;
    private GpgSignature gpgSignature;
    private String message;

    public abstract byte[] build() throws UnsupportedEncodingException;

    protected PersonIdent getAuthor() {
        return this.author;
    }

    protected void setAuthor(PersonIdent personIdent) {
        this.author = (PersonIdent) Objects.requireNonNull(personIdent);
    }

    public void setGpgSignature(@Nullable GpgSignature gpgSignature) {
        this.gpgSignature = gpgSignature;
    }

    @Nullable
    public GpgSignature getGpgSignature() {
        return this.gpgSignature;
    }

    @Nullable
    public String getMessage() {
        return this.message;
    }

    public void setMessage(@Nullable String str) {
        this.message = str;
    }

    public Charset getEncoding() {
        return this.encoding;
    }

    public void setEncoding(Charset charset) {
        this.encoding = charset;
    }

    static void writeMultiLineHeader(String str, OutputStream outputStream, boolean z) throws IOException, IllegalArgumentException {
        int length = str.length();
        int i = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '\n') {
                if (cCharAt == '\r') {
                    int i2 = i + 1;
                    if (i2 < length && str.charAt(i2) == '\n') {
                        i = i2;
                    }
                    if (i + 1 < length) {
                        outputStream.write(10);
                        outputStream.write(32);
                    }
                } else {
                    if (cCharAt > 127 && z) {
                        throw new IllegalArgumentException(MessageFormat.format(JGitText.get().notASCIIString, str));
                    }
                    outputStream.write(cCharAt);
                }
            } else if (i + 1 < length) {
                outputStream.write(10);
                outputStream.write(32);
            }
            i++;
        }
    }

    static void writeEncoding(Charset charset, OutputStream outputStream) throws IOException {
        if (References.isSameObject(charset, StandardCharsets.UTF_8)) {
            return;
        }
        outputStream.write(hencoding);
        outputStream.write(32);
        outputStream.write(Constants.encodeASCII(charset.name()));
        outputStream.write(10);
    }
}
