package org.eclipse.jgit.treewalk;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import org.eclipse.jgit.attributes.AttributesNode;
import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.FileMode;
import org.eclipse.jgit.lib.MutableObjectId;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.ObjectStream;

/* INFO: loaded from: classes5.dex */
public class CanonicalTreeParser extends AbstractTreeIterator {
    private int currPtr;
    private int nextPtr;
    private int prevPtr;
    private byte[] raw;
    private static final byte[] EMPTY = new byte[0];
    private static final byte[] ATTRS = Constants.encode(Constants.DOT_GIT_ATTRIBUTES);

    @Override // org.eclipse.jgit.treewalk.AbstractTreeIterator
    public boolean hasId() {
        return true;
    }

    public CanonicalTreeParser() {
        reset(EMPTY);
    }

    public CanonicalTreeParser(byte[] bArr, ObjectReader objectReader, AnyObjectId anyObjectId) throws IOException {
        super(bArr);
        reset(objectReader, anyObjectId);
    }

    private CanonicalTreeParser(CanonicalTreeParser canonicalTreeParser) {
        super(canonicalTreeParser);
    }

    @Deprecated
    public CanonicalTreeParser getParent() {
        return (CanonicalTreeParser) this.parent;
    }

    public void reset(byte[] bArr) {
        this.attributesNode = null;
        this.raw = bArr;
        this.prevPtr = -1;
        this.currPtr = 0;
        if (eof()) {
            this.nextPtr = 0;
        } else {
            parseEntry();
        }
    }

    public CanonicalTreeParser resetRoot(ObjectReader objectReader, AnyObjectId anyObjectId) throws IOException {
        CanonicalTreeParser canonicalTreeParser = this;
        while (canonicalTreeParser.parent != null) {
            canonicalTreeParser = (CanonicalTreeParser) canonicalTreeParser.parent;
        }
        canonicalTreeParser.reset(objectReader, anyObjectId);
        return canonicalTreeParser;
    }

    public CanonicalTreeParser next() {
        CanonicalTreeParser canonicalTreeParser = this;
        while (true) {
            int i = canonicalTreeParser.nextPtr;
            if (i == canonicalTreeParser.raw.length) {
                if (canonicalTreeParser.parent == null) {
                    canonicalTreeParser.currPtr = canonicalTreeParser.nextPtr;
                    return canonicalTreeParser;
                }
                canonicalTreeParser = (CanonicalTreeParser) canonicalTreeParser.parent;
            } else {
                canonicalTreeParser.prevPtr = canonicalTreeParser.currPtr;
                canonicalTreeParser.currPtr = i;
                canonicalTreeParser.parseEntry();
                return canonicalTreeParser;
            }
        }
    }

    public void reset(ObjectReader objectReader, AnyObjectId anyObjectId) throws IOException {
        reset(objectReader.open(anyObjectId, 2).getCachedBytes());
    }

    @Override // org.eclipse.jgit.treewalk.AbstractTreeIterator
    public CanonicalTreeParser createSubtreeIterator(ObjectReader objectReader, MutableObjectId mutableObjectId) throws IOException {
        mutableObjectId.fromRaw(idBuffer(), idOffset());
        if (!FileMode.TREE.equals(this.mode)) {
            throw new IncorrectObjectTypeException(mutableObjectId.toObjectId(), Constants.TYPE_TREE);
        }
        return createSubtreeIterator0(objectReader, mutableObjectId);
    }

    public final CanonicalTreeParser createSubtreeIterator0(ObjectReader objectReader, AnyObjectId anyObjectId) throws IOException {
        CanonicalTreeParser canonicalTreeParser = new CanonicalTreeParser(this);
        canonicalTreeParser.reset(objectReader, anyObjectId);
        return canonicalTreeParser;
    }

    @Override // org.eclipse.jgit.treewalk.AbstractTreeIterator
    public CanonicalTreeParser createSubtreeIterator(ObjectReader objectReader) throws IOException {
        return createSubtreeIterator(objectReader, new MutableObjectId());
    }

    @Override // org.eclipse.jgit.treewalk.AbstractTreeIterator
    public byte[] idBuffer() {
        return this.raw;
    }

    @Override // org.eclipse.jgit.treewalk.AbstractTreeIterator
    public int idOffset() {
        return this.nextPtr - 20;
    }

    @Override // org.eclipse.jgit.treewalk.AbstractTreeIterator
    public void reset() {
        if (first()) {
            return;
        }
        reset(this.raw);
    }

    @Override // org.eclipse.jgit.treewalk.AbstractTreeIterator
    public boolean first() {
        return this.currPtr == 0;
    }

    @Override // org.eclipse.jgit.treewalk.AbstractTreeIterator
    public boolean eof() {
        return this.currPtr == this.raw.length;
    }

    @Override // org.eclipse.jgit.treewalk.AbstractTreeIterator
    public void next(int i) {
        if (i == 1) {
            this.prevPtr = this.currPtr;
            this.currPtr = this.nextPtr;
            if (eof()) {
                return;
            }
            parseEntry();
            return;
        }
        int length = this.raw.length;
        int i2 = this.nextPtr;
        while (true) {
            i--;
            if (i <= 0 || i2 == length) {
                break;
            }
            this.prevPtr = i2;
            while (this.raw[i2] != 0) {
                i2++;
            }
            i2 += 21;
        }
        if (i != 0) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        this.currPtr = i2;
        if (eof()) {
            return;
        }
        parseEntry();
    }

    @Override // org.eclipse.jgit.treewalk.AbstractTreeIterator
    public void back(int i) {
        int i2;
        if (i == 1 && (i2 = this.prevPtr) >= 0) {
            this.currPtr = i2;
            this.prevPtr = -1;
            if (eof()) {
                return;
            }
            parseEntry();
            return;
        }
        if (i <= 0) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        int[] iArr = new int[i + 1];
        Arrays.fill(iArr, -1);
        int i3 = 0;
        while (i3 != this.currPtr) {
            System.arraycopy(iArr, 1, iArr, 0, i);
            iArr[i] = i3;
            while (this.raw[i3] != 0) {
                i3++;
            }
            i3 += 21;
        }
        int i4 = iArr[1];
        if (i4 == -1) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        this.prevPtr = iArr[0];
        this.currPtr = i4;
        parseEntry();
    }

    private void parseEntry() {
        int i;
        int i2 = this.currPtr;
        int i3 = i2 + 1;
        int i4 = this.raw[i2] - 48;
        while (true) {
            i = i3 + 1;
            byte b = this.raw[i3];
            if (32 == b) {
                break;
            }
            i4 = (i4 << 3) + (b - 48);
            i3 = i;
        }
        this.mode = i4;
        int i5 = this.pathOffset;
        while (true) {
            int i6 = i + 1;
            byte b2 = this.raw[i];
            if (b2 != 0) {
                if (i5 >= this.path.length) {
                    growPath(i5);
                }
                this.path[i5] = b2;
                i5++;
                i = i6;
            } else {
                this.pathLen = i5;
                this.nextPtr = i + 21;
                return;
            }
        }
    }

    public AttributesNode getEntryAttributesNode(ObjectReader objectReader) throws IOException {
        if (this.attributesNode == null) {
            this.attributesNode = findAttributes(objectReader);
        }
        if (this.attributesNode.getRules().isEmpty()) {
            return null;
        }
        return this.attributesNode;
    }

    private AttributesNode findAttributes(ObjectReader objectReader) throws IOException {
        CanonicalTreeParser canonicalTreeParser = new CanonicalTreeParser();
        canonicalTreeParser.reset(this.raw);
        if (canonicalTreeParser.findFile(ATTRS)) {
            return loadAttributes(objectReader, canonicalTreeParser.getEntryObjectId());
        }
        return noAttributes();
    }

    private static AttributesNode loadAttributes(ObjectReader objectReader, AnyObjectId anyObjectId) throws IOException {
        AttributesNode attributesNode = new AttributesNode();
        Throwable th = null;
        try {
            ObjectStream objectStreamOpenStream = objectReader.open(anyObjectId, 3).openStream();
            try {
                attributesNode.parse(objectStreamOpenStream);
                if (objectStreamOpenStream != null) {
                    objectStreamOpenStream.close();
                }
                return attributesNode.getRules().isEmpty() ? noAttributes() : attributesNode;
            } catch (Throwable th2) {
                if (objectStreamOpenStream != null) {
                    objectStreamOpenStream.close();
                }
                throw th2;
            }
        } catch (Throwable th3) {
            if (0 == 0) {
                throw th3;
            }
            if (null != th3) {
                th.addSuppressed(th3);
            }
            throw null;
        }
    }

    private static AttributesNode noAttributes() {
        return new AttributesNode(Collections.emptyList());
    }
}
