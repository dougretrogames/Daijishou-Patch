package org.eclipse.jgit.revwalk;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Arrays;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.errors.CorruptObjectException;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectInserter;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.util.MutableInteger;
import org.eclipse.jgit.util.RawParseUtils;
import org.eclipse.jgit.util.StringUtils;

/* INFO: loaded from: classes5.dex */
public class RevTag extends RevObject {
    private byte[] buffer;
    private RevObject object;
    private String tagName;
    private static final byte[] SIGNATURE_START = Constants.encodeASCII("-----BEGIN");
    private static final byte[] GPG_SIGNATURE_START = Constants.encodeASCII(Constants.GPG_SIGNATURE_PREFIX);
    private static final byte[] CMS_SIGNATURE_START = Constants.encodeASCII(Constants.CMS_SIGNATURE_PREFIX);
    private static final byte[] SSH_SIGNATURE_START = Constants.encodeASCII(Constants.SSH_SIGNATURE_PREFIX);

    @Override // org.eclipse.jgit.revwalk.RevObject
    public final int getType() {
        return 4;
    }

    public static RevTag parse(byte[] bArr) throws CorruptObjectException {
        return parse(new RevWalk((ObjectReader) null), bArr);
    }

    public static RevTag parse(RevWalk revWalk, byte[] bArr) throws CorruptObjectException {
        Throwable th = null;
        try {
            ObjectInserter.Formatter formatter = new ObjectInserter.Formatter();
            try {
                RevTag revTagLookupTag = revWalk.lookupTag(formatter.idFor(4, bArr));
                revTagLookupTag.parseCanonical(revWalk, bArr);
                revTagLookupTag.buffer = bArr;
                return revTagLookupTag;
            } finally {
                formatter.close();
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null != th2) {
                th.addSuppressed(th2);
            }
            throw null;
        }
    }

    protected RevTag(AnyObjectId anyObjectId) {
        super(anyObjectId);
    }

    @Override // org.eclipse.jgit.revwalk.RevObject
    void parseHeaders(RevWalk revWalk) throws IOException {
        parseCanonical(revWalk, revWalk.getCachedBytes(this));
    }

    @Override // org.eclipse.jgit.revwalk.RevObject
    void parseBody(RevWalk revWalk) throws IOException {
        if (this.buffer == null) {
            this.buffer = revWalk.getCachedBytes(this);
            if ((this.flags & 1) == 0) {
                parseCanonical(revWalk, this.buffer);
            }
        }
    }

    void parseCanonical(RevWalk revWalk, byte[] bArr) throws CorruptObjectException {
        MutableInteger mutableInteger = new MutableInteger();
        mutableInteger.value = 53;
        int iDecodeTypeString = Constants.decodeTypeString(this, bArr, (byte) 10, mutableInteger);
        revWalk.idBuffer.fromString(bArr, 7);
        this.object = revWalk.lookupAny(revWalk.idBuffer, iDecodeTypeString);
        int i = mutableInteger.value + 4;
        mutableInteger.value = i;
        this.tagName = RawParseUtils.decode(StandardCharsets.UTF_8, bArr, i, RawParseUtils.nextLF(bArr, i) - 1);
        if (revWalk.isRetainBody()) {
            this.buffer = bArr;
        }
        this.flags |= 1;
    }

    public final PersonIdent getTaggerIdent() {
        byte[] bArr = this.buffer;
        int iTagger = RawParseUtils.tagger(bArr, 0);
        if (iTagger < 0) {
            return null;
        }
        return RawParseUtils.parsePersonIdent(bArr, iTagger);
    }

    private static int nextStart(byte[] bArr, byte[] bArr2, int i) {
        int length = (bArr2.length - bArr.length) + 1;
        if (i > 0) {
            i = RawParseUtils.nextLF(bArr2, i - 1);
        }
        while (i < length) {
            int length2 = bArr.length;
            boolean z = false;
            int iNextLF = i;
            int i2 = 0;
            while (true) {
                if (i2 >= length2) {
                    z = true;
                    break;
                }
                int i3 = iNextLF + 1;
                if (bArr[i2] != bArr2[iNextLF]) {
                    iNextLF = i3;
                    break;
                }
                i2++;
                iNextLF = i3;
            }
            if (z) {
                return i;
            }
            do {
                iNextLF = RawParseUtils.nextLF(bArr2, iNextLF);
                if (iNextLF >= length) {
                    break;
                }
            } while (bArr2[iNextLF] == 10);
            i = iNextLF;
        }
        return -1;
    }

    private int getSignatureStart() {
        int iNextStart;
        byte[] bArr = this.buffer;
        int iTagMessage = RawParseUtils.tagMessage(bArr, 0);
        if (iTagMessage < 0) {
            return iTagMessage;
        }
        int iNextStart2 = nextStart(SIGNATURE_START, bArr, iTagMessage);
        if (iNextStart2 < 0) {
            return iNextStart2;
        }
        int iNextLF = RawParseUtils.nextLF(bArr, iNextStart2);
        while (iNextLF < bArr.length && (iNextStart = nextStart(SIGNATURE_START, bArr, iNextLF)) >= 0) {
            iNextLF = RawParseUtils.nextLF(bArr, iNextStart);
            iNextStart2 = iNextStart;
        }
        if (RawParseUtils.match(bArr, iNextStart2, GPG_SIGNATURE_START) > 0 || RawParseUtils.match(bArr, iNextStart2, CMS_SIGNATURE_START) > 0 || RawParseUtils.match(bArr, iNextStart2, SSH_SIGNATURE_START) > 0) {
            return iNextStart2;
        }
        return -1;
    }

    @Nullable
    public final byte[] getRawGpgSignature() {
        byte[] bArr = this.buffer;
        int signatureStart = getSignatureStart();
        if (signatureStart < 0) {
            return null;
        }
        return Arrays.copyOfRange(bArr, signatureStart, bArr.length);
    }

    public final String getFullMessage() {
        byte[] bArr = this.buffer;
        int iTagMessage = RawParseUtils.tagMessage(bArr, 0);
        if (iTagMessage < 0) {
            return "";
        }
        int signatureStart = getSignatureStart();
        if (signatureStart < 0) {
            signatureStart = bArr.length;
        }
        if (signatureStart == iTagMessage) {
            return "";
        }
        return RawParseUtils.decode(guessEncoding(), bArr, iTagMessage, signatureStart);
    }

    public final String getShortMessage() {
        byte[] bArr = this.buffer;
        int iTagMessage = RawParseUtils.tagMessage(bArr, 0);
        if (iTagMessage < 0) {
            return "";
        }
        int iEndOfParagraph = RawParseUtils.endOfParagraph(bArr, iTagMessage);
        int signatureStart = getSignatureStart();
        if (signatureStart >= iTagMessage && iEndOfParagraph > signatureStart) {
            if (signatureStart > iTagMessage) {
                signatureStart--;
            }
            iEndOfParagraph = signatureStart;
            if (iTagMessage == iEndOfParagraph) {
                return "";
            }
        }
        String strDecode = RawParseUtils.decode(guessEncoding(), bArr, iTagMessage, iEndOfParagraph);
        return RevCommit.hasLF(bArr, iTagMessage, iEndOfParagraph) ? StringUtils.replaceLineBreaksWithSpace(strDecode) : strDecode;
    }

    private Charset guessEncoding() {
        try {
            return RawParseUtils.parseEncoding(this.buffer);
        } catch (IllegalCharsetNameException | UnsupportedCharsetException unused) {
            return StandardCharsets.UTF_8;
        }
    }

    public final RevObject getObject() {
        return this.object;
    }

    public final String getTagName() {
        return this.tagName;
    }

    public final byte[] getRawBuffer() {
        return this.buffer;
    }

    public final void disposeBody() {
        this.buffer = null;
    }
}
