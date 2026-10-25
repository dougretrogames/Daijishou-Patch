package org.eclipse.jgit.lib;

import com.googlecode.javaewah.EWAHCompressedBitmap;
import java.util.Iterator;
import org.eclipse.jgit.internal.storage.file.PackBitmapIndex;

/* JADX INFO: loaded from: classes5.dex */
public interface BitmapIndex {

    public interface Bitmap extends Iterable<BitmapObject> {
        Bitmap andNot(Bitmap bitmap);

        @Override // java.lang.Iterable
        Iterator<BitmapObject> iterator();

        Bitmap or(Bitmap bitmap);

        EWAHCompressedBitmap retrieveCompressed();

        Bitmap xor(Bitmap bitmap);
    }

    public interface BitmapBuilder extends Bitmap {
        BitmapBuilder addObject(AnyObjectId anyObjectId, int i);

        @Override // org.eclipse.jgit.lib.BitmapIndex.Bitmap
        BitmapBuilder andNot(Bitmap bitmap);

        Bitmap build();

        int cardinality();

        boolean contains(AnyObjectId anyObjectId);

        BitmapIndex getBitmapIndex();

        @Override // org.eclipse.jgit.lib.BitmapIndex.Bitmap
        BitmapBuilder or(Bitmap bitmap);

        void remove(AnyObjectId anyObjectId);

        boolean removeAllOrNone(PackBitmapIndex packBitmapIndex);

        @Override // org.eclipse.jgit.lib.BitmapIndex.Bitmap
        BitmapBuilder xor(Bitmap bitmap);
    }

    default void addBitmapLookupListener(BitmapLookupListener bitmapLookupListener) {
    }

    Bitmap getBitmap(AnyObjectId anyObjectId);

    BitmapBuilder newBitmapBuilder();

    public interface BitmapLookupListener {
        public static final BitmapLookupListener NOOP = new AnonymousClass1();

        void onBitmapFound(AnyObjectId anyObjectId);

        void onBitmapNotFound(AnyObjectId anyObjectId);

        /* JADX INFO: renamed from: org.eclipse.jgit.lib.BitmapIndex$BitmapLookupListener$1, reason: invalid class name */
        class AnonymousClass1 implements BitmapLookupListener {
            @Override // org.eclipse.jgit.lib.BitmapIndex.BitmapLookupListener
            public void onBitmapFound(AnyObjectId anyObjectId) {
            }

            @Override // org.eclipse.jgit.lib.BitmapIndex.BitmapLookupListener
            public void onBitmapNotFound(AnyObjectId anyObjectId) {
            }

            AnonymousClass1() {
            }
        }
    }
}
