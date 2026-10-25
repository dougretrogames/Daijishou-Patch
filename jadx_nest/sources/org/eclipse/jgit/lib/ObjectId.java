package org.eclipse.jgit.lib;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.errors.InvalidObjectIdException;
import org.eclipse.jgit.util.NB;
import org.eclipse.jgit.util.RawParseUtils;

/* JADX INFO: loaded from: classes5.dex */
public class ObjectId extends AnyObjectId implements Serializable {
    private static final ObjectId ZEROID;
    private static final String ZEROID_STR;
    private static final long serialVersionUID = 1;

    @Override // org.eclipse.jgit.lib.AnyObjectId
    public ObjectId toObjectId() {
        return this;
    }

    static {
        ObjectId objectId = new ObjectId(0, 0, 0, 0, 0);
        ZEROID = objectId;
        ZEROID_STR = objectId.name();
    }

    public static final ObjectId zeroId() {
        return ZEROID;
    }

    public static final boolean isId(@Nullable String str) {
        if (str == null || str.length() != 40) {
            return false;
        }
        for (int i = 0; i < 40; i++) {
            try {
                RawParseUtils.parseHexInt4((byte) str.charAt(i));
            } catch (ArrayIndexOutOfBoundsException unused) {
                return false;
            }
        }
        return true;
    }

    public static final String toString(ObjectId objectId) {
        return objectId != null ? objectId.name() : ZEROID_STR;
    }

    public static boolean equals(byte[] bArr, int i, byte[] bArr2, int i2) {
        return bArr[i] == bArr2[i2] && bArr[i + 1] == bArr2[i2 + 1] && bArr[i + 2] == bArr2[i2 + 2] && bArr[i + 3] == bArr2[i2 + 3] && bArr[i + 4] == bArr2[i2 + 4] && bArr[i + 5] == bArr2[i2 + 5] && bArr[i + 6] == bArr2[i2 + 6] && bArr[i + 7] == bArr2[i2 + 7] && bArr[i + 8] == bArr2[i2 + 8] && bArr[i + 9] == bArr2[i2 + 9] && bArr[i + 10] == bArr2[i2 + 10] && bArr[i + 11] == bArr2[i2 + 11] && bArr[i + 12] == bArr2[i2 + 12] && bArr[i + 13] == bArr2[i2 + 13] && bArr[i + 14] == bArr2[i2 + 14] && bArr[i + 15] == bArr2[i2 + 15] && bArr[i + 16] == bArr2[i2 + 16] && bArr[i + 17] == bArr2[i2 + 17] && bArr[i + 18] == bArr2[i2 + 18] && bArr[i + 19] == bArr2[i2 + 19];
    }

    public static final ObjectId fromRaw(byte[] bArr) {
        return fromRaw(bArr, 0);
    }

    public static final ObjectId fromRaw(byte[] bArr, int i) {
        return new ObjectId(NB.decodeInt32(bArr, i), NB.decodeInt32(bArr, i + 4), NB.decodeInt32(bArr, i + 8), NB.decodeInt32(bArr, i + 12), NB.decodeInt32(bArr, i + 16));
    }

    public static final ObjectId fromRaw(ByteBuffer byteBuffer) {
        return new ObjectId(byteBuffer.getInt(), byteBuffer.getInt(), byteBuffer.getInt(), byteBuffer.getInt(), byteBuffer.getInt());
    }

    public static final ObjectId fromRaw(int[] iArr) {
        return fromRaw(iArr, 0);
    }

    public static final ObjectId fromRaw(int[] iArr, int i) {
        return new ObjectId(iArr[i], iArr[i + 1], iArr[i + 2], iArr[i + 3], iArr[i + 4]);
    }

    public static final ObjectId fromString(byte[] bArr, int i) {
        return fromHexString(bArr, i);
    }

    public static ObjectId fromString(String str) {
        if (str.length() != 40) {
            throw new InvalidObjectIdException(str);
        }
        return fromHexString(Constants.encodeASCII(str), 0);
    }

    private static final ObjectId fromHexString(byte[] bArr, int i) {
        try {
            return new ObjectId(RawParseUtils.parseHexInt32(bArr, i), RawParseUtils.parseHexInt32(bArr, i + 8), RawParseUtils.parseHexInt32(bArr, i + 16), RawParseUtils.parseHexInt32(bArr, i + 24), RawParseUtils.parseHexInt32(bArr, i + 32));
        } catch (ArrayIndexOutOfBoundsException e) {
            InvalidObjectIdException invalidObjectIdException = new InvalidObjectIdException(bArr, i, 40);
            invalidObjectIdException.initCause(e);
            throw invalidObjectIdException;
        }
    }

    public ObjectId(int i, int i2, int i3, int i4, int i5) {
        this.w1 = i;
        this.w2 = i2;
        this.w3 = i3;
        this.w4 = i4;
        this.w5 = i5;
    }

    protected ObjectId(AnyObjectId anyObjectId) {
        this.w1 = anyObjectId.w1;
        this.w2 = anyObjectId.w2;
        this.w3 = anyObjectId.w3;
        this.w4 = anyObjectId.w4;
        this.w5 = anyObjectId.w5;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.w1);
        objectOutputStream.writeInt(this.w2);
        objectOutputStream.writeInt(this.w3);
        objectOutputStream.writeInt(this.w4);
        objectOutputStream.writeInt(this.w5);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        this.w1 = objectInputStream.readInt();
        this.w2 = objectInputStream.readInt();
        this.w3 = objectInputStream.readInt();
        this.w4 = objectInputStream.readInt();
        this.w5 = objectInputStream.readInt();
    }
}
