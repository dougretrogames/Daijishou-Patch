package org.eclipse.jgit.internal.revwalk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;
import java.util.stream.Stream;
import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.lib.BitmapIndex;
import org.eclipse.jgit.revwalk.BitmapWalker;
import org.eclipse.jgit.revwalk.ObjectReachabilityChecker;
import org.eclipse.jgit.revwalk.ObjectWalk;
import org.eclipse.jgit.revwalk.RevObject;

/* JADX INFO: loaded from: classes5.dex */
public class BitmappedObjectReachabilityChecker implements ObjectReachabilityChecker {
    private final ObjectWalk walk;

    public BitmappedObjectReachabilityChecker(ObjectWalk objectWalk) {
        this.walk = objectWalk;
    }

    @Override // org.eclipse.jgit.revwalk.ObjectReachabilityChecker
    public Optional<RevObject> areAllReachable(Collection<RevObject> collection, Stream<RevObject> stream) throws IOException {
        try {
            ArrayList arrayList = new ArrayList(collection);
            ObjectWalk objectWalk = this.walk;
            BitmapIndex.BitmapBuilder bitmapBuilder = null;
            BitmapWalker bitmapWalker = new BitmapWalker(objectWalk, objectWalk.getObjectReader().getBitmapIndex(), null);
            Iterator<RevObject> it = stream.iterator();
            while (it.hasNext()) {
                BitmapIndex.BitmapBuilder bitmapBuilderFindObjects = bitmapWalker.findObjects(Arrays.asList(it.next()), bitmapBuilder, true);
                if (bitmapBuilder != null) {
                    bitmapBuilderFindObjects = bitmapBuilder.or((BitmapIndex.Bitmap) bitmapBuilderFindObjects);
                }
                bitmapBuilder = bitmapBuilderFindObjects;
                bitmapBuilder.getClass();
                arrayList.removeIf(new BitmappedObjectReachabilityChecker$$ExternalSyntheticLambda0(bitmapBuilder));
                if (arrayList.isEmpty()) {
                    return Optional.empty();
                }
            }
            return Optional.of((RevObject) arrayList.get(0));
        } catch (IncorrectObjectTypeException | MissingObjectException e) {
            throw new IllegalStateException(e);
        }
    }
}
