package org.eclipse.jgit.lib;

import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import java.text.MessageFormat;
import org.eclipse.jgit.errors.InvalidObjectIdException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.util.NB;
import org.eclipse.jgit.util.RawParseUtils;

/* JADX INFO: loaded from: classes5.dex */
public class MutableObjectId extends AnyObjectId {
    public MutableObjectId() {
    }

    MutableObjectId(MutableObjectId mutableObjectId) {
        fromObjectId(mutableObjectId);
    }

    public void setByte(int i, int i2) {
        int i3 = i >> 2;
        if (i3 == 0) {
            this.w1 = set(this.w1, i & 3, i2);
            return;
        }
        if (i3 == 1) {
            this.w2 = set(this.w2, i & 3, i2);
            return;
        }
        if (i3 == 2) {
            this.w3 = set(this.w3, i & 3, i2);
        } else if (i3 == 3) {
            this.w4 = set(this.w4, i & 3, i2);
        } else {
            if (i3 == 4) {
                this.w5 = set(this.w5, i & 3, i2);
                return;
            }
            throw new ArrayIndexOutOfBoundsException(i);
        }
    }

    private static int set(int i, int i2, int i3) {
        int i4 = i3 & 255;
        if (i2 == 0) {
            return (i & ViewCompat.MEASURED_SIZE_MASK) | (i4 << 24);
        }
        if (i2 == 1) {
            return (i & (-16711681)) | (i4 << 16);
        }
        if (i2 == 2) {
            return (i & (-65281)) | (i4 << 8);
        }
        if (i2 == 3) {
            return (i & InputDeviceCompat.SOURCE_ANY) | i4;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void clear() {
        this.w1 = 0;
        this.w2 = 0;
        this.w3 = 0;
        this.w4 = 0;
        this.w5 = 0;
    }

    public void fromObjectId(AnyObjectId anyObjectId) {
        this.w1 = anyObjectId.w1;
        this.w2 = anyObjectId.w2;
        this.w3 = anyObjectId.w3;
        this.w4 = anyObjectId.w4;
        this.w5 = anyObjectId.w5;
    }

    public void fromRaw(byte[] bArr) {
        fromRaw(bArr, 0);
    }

    public void fromRaw(byte[] bArr, int i) {
        this.w1 = NB.decodeInt32(bArr, i);
        this.w2 = NB.decodeInt32(bArr, i + 4);
        this.w3 = NB.decodeInt32(bArr, i + 8);
        this.w4 = NB.decodeInt32(bArr, i + 12);
        this.w5 = NB.decodeInt32(bArr, i + 16);
    }

    public void fromRaw(int[] iArr) {
        fromRaw(iArr, 0);
    }

    public void fromRaw(int[] iArr, int i) {
        this.w1 = iArr[i];
        this.w2 = iArr[i + 1];
        this.w3 = iArr[i + 2];
        this.w4 = iArr[i + 3];
        this.w5 = iArr[i + 4];
    }

    public void set(int i, int i2, int i3, int i4, int i5) {
        this.w1 = i;
        this.w2 = i2;
        this.w3 = i3;
        this.w4 = i4;
        this.w5 = i5;
    }

    public void fromString(byte[] bArr, int i) {
        fromHexString(bArr, i);
    }

    public void fromString(String str) {
        if (str.length() != 40) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().invalidId, str));
        }
        fromHexString(Constants.encodeASCII(str), 0);
    }

    private void fromHexString(byte[] bArr, int i) {
        try {
            this.w1 = RawParseUtils.parseHexInt32(bArr, i);
            this.w2 = RawParseUtils.parseHexInt32(bArr, i + 8);
            this.w3 = RawParseUtils.parseHexInt32(bArr, i + 16);
            this.w4 = RawParseUtils.parseHexInt32(bArr, i + 24);
            this.w5 = RawParseUtils.parseHexInt32(bArr, i + 32);
        } catch (ArrayIndexOutOfBoundsException e) {
            InvalidObjectIdException invalidObjectIdException = new InvalidObjectIdException(bArr, i, 40);
            invalidObjectIdException.initCause(e);
            throw invalidObjectIdException;
        }
    }

    @Override // org.eclipse.jgit.lib.AnyObjectId
    public ObjectId toObjectId() {
        return new ObjectId(this);
    }
}
