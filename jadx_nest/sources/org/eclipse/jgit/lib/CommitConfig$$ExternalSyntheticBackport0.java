package org.eclipse.jgit.lib;

import android.content.res.TypedArray;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import org.apache.commons.collections4.CollectionUtils;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class CommitConfig$$ExternalSyntheticBackport0 {
    public static /* synthetic */ int m(byte b, byte b2) {
        return (b & 255) - (b2 & 255);
    }

    public static /* synthetic */ int m(int i, int i2, int i3) {
        if (i < 0 || i2 < 0 || i3 < 0 || i > i3 - i2) {
            throw new IndexOutOfBoundsException("Range [" + i + ", " + i + " + " + i2 + ") out of bounds for length " + i3);
        }
        return i;
    }

    public static /* synthetic */ int m(boolean z, boolean z2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        return (((((((((((((((Boolean.hashCode(z) * 31) + Boolean.hashCode(z2)) * 31) + Objects.hashCode(obj)) * 31) + Objects.hashCode(obj2)) * 31) + Objects.hashCode(obj3)) * 31) + Objects.hashCode(obj4)) * 31) + Objects.hashCode(obj5)) * 31) + Objects.hashCode(obj6)) * 31) + Objects.hashCode(obj7);
    }

    public static /* synthetic */ String m(String str) {
        int length = str.length();
        int iCharCount = 0;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (!Character.isWhitespace(iCodePointAt)) {
                break;
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        while (length > iCharCount) {
            int iCodePointBefore = Character.codePointBefore(str, length);
            if (!Character.isWhitespace(iCodePointBefore)) {
                break;
            }
            length -= Character.charCount(iCodePointBefore);
        }
        return str.substring(iCharCount, length);
    }

    public static /* synthetic */ String m(Object[] objArr, Class cls, String str) {
        String[] strArrSplit = str.length() == 0 ? new String[0] : str.split(";");
        StringBuilder sb = new StringBuilder();
        sb.append(cls.getSimpleName()).append(CollectionUtils.DEFAULT_TOSTRING_PREFIX);
        for (int i = 0; i < strArrSplit.length; i++) {
            sb.append(strArrSplit[i]).append("=").append(objArr[i]);
            if (i != strArrSplit.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(CollectionUtils.DEFAULT_TOSTRING_SUFFIX);
        return sb.toString();
    }

    public static /* synthetic */ List m(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(Objects.requireNonNull(it.next()));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static /* synthetic */ List m(Object[] objArr) {
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            arrayList.add(Objects.requireNonNull(obj));
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ Set m5773m(Object[] objArr) {
        HashSet hashSet = new HashSet(objArr.length);
        for (Object obj : objArr) {
            if (!hashSet.add(Objects.requireNonNull(obj))) {
                throw new IllegalArgumentException("duplicate element: " + obj);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m5774m(Object obj) throws Exception {
        if (obj instanceof AutoCloseable) {
            ((AutoCloseable) obj).close();
            return;
        }
        if (obj instanceof ExecutorService) {
            m((ExecutorService) obj);
            return;
        }
        if (obj instanceof TypedArray) {
            ((TypedArray) obj).recycle();
            return;
        }
        if (obj instanceof MediaMetadataRetriever) {
            ((MediaMetadataRetriever) obj).release();
        } else if (obj instanceof MediaDrm) {
            ((MediaDrm) obj).release();
        } else {
            m$1(obj);
        }
    }

    public static /* synthetic */ void m(ExecutorService executorService) {
        boolean zIsTerminated;
        if (executorService == ForkJoinPool.commonPool() || (zIsTerminated = executorService.isTerminated())) {
            return;
        }
        executorService.shutdown();
        boolean z = false;
        while (!zIsTerminated) {
            try {
                zIsTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
            } catch (InterruptedException unused) {
                if (!z) {
                    executorService.shutdownNow();
                    z = true;
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public static /* synthetic */ boolean m(Optional optional) {
        return !optional.isPresent();
    }

    public static /* synthetic */ String m$1(String str) {
        int length = str.length();
        while (length > 0) {
            int iCodePointBefore = Character.codePointBefore(str, length);
            if (!Character.isWhitespace(iCodePointBefore)) {
                break;
            }
            length -= Character.charCount(iCodePointBefore);
        }
        return str.substring(0, length);
    }

    public static /* synthetic */ void m$1(Object obj) {
        throw new IllegalArgumentException();
    }
}
