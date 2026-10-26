package org.eclipse.jgit.internal.storage.file;

import com.googlecode.javaewah.EWAHCompressedBitmap;
import java.util.Iterator;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.ObjectIdOwnerMap;

/* INFO: loaded from: classes5.dex */
abstract class BasePackBitmapIndex implements PackBitmapIndex {
    private final ObjectIdOwnerMap<StoredBitmap> bitmaps;

    BasePackBitmapIndex(ObjectIdOwnerMap<StoredBitmap> objectIdOwnerMap) {
        this.bitmaps = objectIdOwnerMap;
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackBitmapIndex
    public EWAHCompressedBitmap getBitmap(AnyObjectId anyObjectId) {
        StoredBitmap storedBitmap = (StoredBitmap) this.bitmaps.get(anyObjectId);
        if (storedBitmap != null) {
            return storedBitmap.getBitmap();
        }
        return null;
    }

    ObjectIdOwnerMap<StoredBitmap> getBitmaps() {
        return this.bitmaps;
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackBitmapIndex
    public int getBaseBitmapCount() {
        Iterator<V> it = getBitmaps().iterator();
        int i = 0;
        while (it.hasNext()) {
            if (((StoredBitmap) it.next()).isBase()) {
                i++;
            }
        }
        return i;
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackBitmapIndex
    public long getBaseBitmapSizeInBytes() {
        long currentSizeInBytes = 0;
        for (StoredBitmap storedBitmap : getBitmaps()) {
            if (storedBitmap.isBase()) {
                currentSizeInBytes += storedBitmap.getCurrentSizeInBytes();
            }
        }
        return currentSizeInBytes;
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackBitmapIndex
    public int getXorBitmapCount() {
        Iterator<V> it = getBitmaps().iterator();
        int i = 0;
        while (it.hasNext()) {
            if (!((StoredBitmap) it.next()).isBase()) {
                i++;
            }
        }
        return i;
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackBitmapIndex
    public long getXorBitmapSizeInBytes() {
        long currentSizeInBytes = 0;
        for (StoredBitmap storedBitmap : getBitmaps()) {
            if (!storedBitmap.isBase()) {
                currentSizeInBytes += storedBitmap.getCurrentSizeInBytes();
            }
        }
        return currentSizeInBytes;
    }

    static final class StoredBitmap extends ObjectIdOwnerMap.Entry {
        private volatile Object bitmapContainer;
        private final int flags;

        StoredBitmap(AnyObjectId anyObjectId, EWAHCompressedBitmap eWAHCompressedBitmap, StoredBitmap storedBitmap, int i) {
            super(anyObjectId);
            this.bitmapContainer = storedBitmap != null ? new XorCompressedBitmap(eWAHCompressedBitmap, storedBitmap) : eWAHCompressedBitmap;
            this.flags = i;
        }

        EWAHCompressedBitmap getBitmap() {
            EWAHCompressedBitmap bitmapWithoutCaching = getBitmapWithoutCaching();
            this.bitmapContainer = bitmapWithoutCaching;
            return bitmapWithoutCaching;
        }

        EWAHCompressedBitmap getBitmapWithoutCaching() {
            Object obj = this.bitmapContainer;
            if (obj instanceof EWAHCompressedBitmap) {
                return (EWAHCompressedBitmap) obj;
            }
            XorCompressedBitmap xorCompressedBitmap = (XorCompressedBitmap) obj;
            EWAHCompressedBitmap eWAHCompressedBitmapXor = xorCompressedBitmap.bitmap;
            while (true) {
                Object obj2 = xorCompressedBitmap.xorBitmap.bitmapContainer;
                if (obj2 instanceof EWAHCompressedBitmap) {
                    EWAHCompressedBitmap eWAHCompressedBitmapXor2 = eWAHCompressedBitmapXor.xor((EWAHCompressedBitmap) obj2);
                    eWAHCompressedBitmapXor2.trim();
                    return eWAHCompressedBitmapXor2;
                }
                xorCompressedBitmap = (XorCompressedBitmap) obj2;
                eWAHCompressedBitmapXor = eWAHCompressedBitmapXor.xor(xorCompressedBitmap.bitmap);
            }
        }

        int getFlags() {
            return this.flags;
        }

        boolean isBase() {
            return this.bitmapContainer instanceof EWAHCompressedBitmap;
        }

        long getCurrentSizeInBytes() {
            int iSizeInBytes;
            Object obj = this.bitmapContainer;
            if (obj instanceof EWAHCompressedBitmap) {
                iSizeInBytes = ((EWAHCompressedBitmap) obj).sizeInBytes();
            } else {
                iSizeInBytes = ((XorCompressedBitmap) obj).bitmap.sizeInBytes();
            }
            return iSizeInBytes;
        }
    }

    private static final class XorCompressedBitmap {
        final EWAHCompressedBitmap bitmap;
        final StoredBitmap xorBitmap;

        XorCompressedBitmap(EWAHCompressedBitmap eWAHCompressedBitmap, StoredBitmap storedBitmap) {
            this.bitmap = eWAHCompressedBitmap;
            this.xorBitmap = storedBitmap;
        }
    }
}
