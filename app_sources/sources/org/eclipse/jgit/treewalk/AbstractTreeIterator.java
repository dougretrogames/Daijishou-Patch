package org.eclipse.jgit.treewalk;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.attributes.AttributesNode;
import org.eclipse.jgit.errors.CorruptObjectException;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.FileMode;
import org.eclipse.jgit.lib.MutableObjectId;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.util.Paths;

/* INFO: loaded from: classes5.dex */
public abstract class AbstractTreeIterator {
    protected static final int DEFAULT_PATH_SIZE = 128;
    protected static final byte[] zeroid = new byte[20];
    protected AttributesNode attributesNode;
    int matchShift;
    AbstractTreeIterator matches;
    protected int mode;
    public final AbstractTreeIterator parent;
    protected byte[] path;
    protected int pathLen;
    protected final int pathOffset;

    public abstract void back(int i) throws CorruptObjectException;

    public abstract AbstractTreeIterator createSubtreeIterator(ObjectReader objectReader) throws IOException;

    public abstract boolean eof();

    public abstract boolean first();

    public abstract boolean hasId();

    public abstract byte[] idBuffer();

    public abstract int idOffset();

    public boolean isWorkTree() {
        return false;
    }

    protected boolean needsStopWalk() {
        return false;
    }

    public abstract void next(int i) throws CorruptObjectException;

    public void stopWalk() {
    }

    protected AbstractTreeIterator() {
        this.parent = null;
        this.path = new byte[128];
        this.pathOffset = 0;
    }

    protected AbstractTreeIterator(String str) {
        this.parent = null;
        if (str != null && str.length() > 0) {
            ByteBuffer byteBufferEncode = StandardCharsets.UTF_8.encode(CharBuffer.wrap(str));
            int iLimit = byteBufferEncode.limit();
            this.pathLen = iLimit;
            byte[] bArr = new byte[Math.max(128, iLimit + 1)];
            this.path = bArr;
            byteBufferEncode.get(bArr, 0, this.pathLen);
            byte[] bArr2 = this.path;
            int i = this.pathLen;
            if (bArr2[i - 1] != 47) {
                this.pathLen = i + 1;
                bArr2[i] = 47;
            }
            this.pathOffset = this.pathLen;
            return;
        }
        this.path = new byte[128];
        this.pathOffset = 0;
    }

    protected AbstractTreeIterator(byte[] bArr) {
        this.parent = null;
        if (bArr != null && bArr.length > 0) {
            int length = bArr.length;
            this.pathLen = length;
            byte[] bArr2 = new byte[Math.max(128, length + 1)];
            this.path = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, this.pathLen);
            byte[] bArr3 = this.path;
            int i = this.pathLen;
            if (bArr3[i - 1] != 47) {
                this.pathLen = i + 1;
                bArr3[i] = 47;
            }
            this.pathOffset = this.pathLen;
            return;
        }
        this.path = new byte[128];
        this.pathOffset = 0;
    }

    protected AbstractTreeIterator(AbstractTreeIterator abstractTreeIterator) {
        this.parent = abstractTreeIterator;
        byte[] bArr = abstractTreeIterator.path;
        this.path = bArr;
        int i = abstractTreeIterator.pathLen;
        int i2 = i + 1;
        this.pathOffset = i2;
        if (i2 > bArr.length) {
            growPath(i);
        }
        this.path[i] = 47;
    }

    protected AbstractTreeIterator(AbstractTreeIterator abstractTreeIterator, byte[] bArr, int i) {
        this.parent = abstractTreeIterator;
        this.path = bArr;
        this.pathOffset = i;
    }

    protected void growPath(int i) {
        setPathCapacity(this.path.length << 1, i);
    }

    protected void ensurePathCapacity(int i, int i2) {
        byte[] bArr = this.path;
        if (bArr.length >= i) {
            return;
        }
        int length = bArr.length;
        while (length < i && length > 0) {
            length <<= 1;
        }
        setPathCapacity(length, i2);
    }

    private void setPathCapacity(int i, int i2) {
        byte[] bArr = this.path;
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i2);
        for (AbstractTreeIterator abstractTreeIterator = this; abstractTreeIterator != null && abstractTreeIterator.path == bArr; abstractTreeIterator = abstractTreeIterator.parent) {
            abstractTreeIterator.path = bArr2;
        }
    }

    public int pathCompare(AbstractTreeIterator abstractTreeIterator) {
        return pathCompare(abstractTreeIterator, abstractTreeIterator.mode);
    }

    int pathCompare(AbstractTreeIterator abstractTreeIterator, int i) {
        int iAlreadyMatch = alreadyMatch(this, abstractTreeIterator);
        return pathCompare(abstractTreeIterator.path, iAlreadyMatch, abstractTreeIterator.pathLen, i, iAlreadyMatch);
    }

    public boolean findFile(String str) throws CorruptObjectException {
        return findFile(Constants.encode(str));
    }

    public boolean findFile(byte[] bArr) throws CorruptObjectException {
        while (!eof()) {
            byte[] bArr2 = bArr;
            int iPathCompare = pathCompare(bArr2, 0, bArr.length, 0, this.pathOffset);
            if (iPathCompare == 0) {
                return true;
            }
            if (iPathCompare > 0) {
                return false;
            }
            next(1);
            bArr = bArr2;
        }
        return false;
    }

    public int pathCompare(byte[] bArr, int i, int i2, int i3) {
        return pathCompare(bArr, i, i2, i3, 0);
    }

    private int pathCompare(byte[] bArr, int i, int i2, int i3, int i4) {
        return Paths.compare(this.path, i4, this.pathLen, this.mode, bArr, i, i2, i3);
    }

    private static int alreadyMatch(AbstractTreeIterator abstractTreeIterator, AbstractTreeIterator abstractTreeIterator2) {
        while (true) {
            AbstractTreeIterator abstractTreeIterator3 = abstractTreeIterator.parent;
            abstractTreeIterator2 = abstractTreeIterator2.parent;
            if (abstractTreeIterator3 == null || abstractTreeIterator2 == null) {
                return 0;
            }
            if (abstractTreeIterator3.matches == abstractTreeIterator2.matches) {
                return abstractTreeIterator.pathOffset;
            }
            abstractTreeIterator = abstractTreeIterator3;
        }
    }

    public boolean idEqual(AbstractTreeIterator abstractTreeIterator) {
        return ObjectId.equals(idBuffer(), idOffset(), abstractTreeIterator.idBuffer(), abstractTreeIterator.idOffset());
    }

    public ObjectId getEntryObjectId() {
        return ObjectId.fromRaw(idBuffer(), idOffset());
    }

    public void getEntryObjectId(MutableObjectId mutableObjectId) {
        mutableObjectId.fromRaw(idBuffer(), idOffset());
    }

    public FileMode getEntryFileMode() {
        return FileMode.fromBits(this.mode);
    }

    public int getEntryRawMode() {
        return this.mode;
    }

    public String getEntryPathString() {
        return TreeWalk.pathOf(this);
    }

    public byte[] getEntryPathBuffer() {
        return this.path;
    }

    public int getEntryPathLength() {
        return this.pathLen;
    }

    public int getEntryPathHashCode() {
        int i = 0;
        for (int iMax = Math.max(0, this.pathLen - 16); iMax < this.pathLen; iMax++) {
            byte b = this.path[iMax];
            if (b != 32) {
                i = (i >>> 2) + (b << Ascii.CAN);
            }
        }
        return i;
    }

    public EmptyTreeIterator createEmptyTreeIterator() {
        return new EmptyTreeIterator(this);
    }

    public AbstractTreeIterator createSubtreeIterator(ObjectReader objectReader, MutableObjectId mutableObjectId) throws IOException {
        return createSubtreeIterator(objectReader);
    }

    public void reset() throws CorruptObjectException {
        while (!first()) {
            back(1);
        }
    }

    public void skip() throws CorruptObjectException {
        next(1);
    }

    public int getNameLength() {
        return this.pathLen - this.pathOffset;
    }

    public int getNameOffset() {
        return this.pathOffset;
    }

    public void getName(byte[] bArr, int i) {
        byte[] bArr2 = this.path;
        int i2 = this.pathOffset;
        System.arraycopy(bArr2, i2, bArr, i, this.pathLen - i2);
    }

    public String toString() {
        return getClass().getSimpleName() + CollectionUtils.DEFAULT_TOSTRING_PREFIX + getEntryPathString() + CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
    }
}
