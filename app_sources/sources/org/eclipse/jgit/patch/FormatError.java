package org.eclipse.jgit.patch;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import org.eclipse.jgit.util.RawParseUtils;

/* INFO: loaded from: classes5.dex */
public class FormatError {
    private final byte[] buf;
    private final String message;
    private final int offset;
    private final Severity severity;

    public enum Severity {
        WARNING,
        ERROR;

        /* INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static Severity[] valuesCustom() {
            Severity[] severityArrValuesCustom = values();
            int length = severityArrValuesCustom.length;
            Severity[] severityArr = new Severity[length];
            System.arraycopy(severityArrValuesCustom, 0, severityArr, 0, length);
            return severityArr;
        }
    }

    FormatError(byte[] bArr, int i, Severity severity, String str) {
        this.buf = bArr;
        this.offset = i;
        this.severity = severity;
        this.message = str;
    }

    public Severity getSeverity() {
        return this.severity;
    }

    public String getMessage() {
        return this.message;
    }

    public byte[] getBuffer() {
        return this.buf;
    }

    public int getOffset() {
        return this.offset;
    }

    public String getLineText() {
        return RawParseUtils.decode(StandardCharsets.UTF_8, this.buf, this.offset, RawParseUtils.nextLF(this.buf, this.offset));
    }

    public String toString() {
        return getSeverity().name().toLowerCase(Locale.ROOT) + ": at offset " + getOffset() + ": " + getMessage() + "\n  in " + getLineText();
    }
}
