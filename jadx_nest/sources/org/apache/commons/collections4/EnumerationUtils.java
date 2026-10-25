package org.apache.commons.collections4;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import org.apache.commons.collections4.iterators.EnumerationIterator;
import org.apache.commons.collections4.iterators.IteratorIterable;

/* JADX INFO: loaded from: classes5.dex */
public class EnumerationUtils {
    public static <T> Iterable<T> asIterable(Enumeration<T> enumeration) {
        return new IteratorIterable(new EnumerationIterator(enumeration));
    }

    public static <T> T get(Enumeration<T> enumeration, int i) {
        CollectionUtils.checkIndexBounds(i);
        while (enumeration.hasMoreElements()) {
            i--;
            if (i == -1) {
                return enumeration.nextElement();
            }
            enumeration.nextElement();
        }
        throw new IndexOutOfBoundsException("Entry does not exist: " + i);
    }

    public static <E> List<E> toList(Enumeration<? extends E> enumeration) {
        return IteratorUtils.toList(new EnumerationIterator(enumeration));
    }

    public static List<String> toList(StringTokenizer stringTokenizer) {
        ArrayList arrayList = new ArrayList(stringTokenizer.countTokens());
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        return arrayList;
    }

    public static <E> Set<E> toSet(Enumeration<? extends E> enumeration) {
        return IteratorUtils.toSet(new EnumerationIterator(enumeration));
    }

    private EnumerationUtils() {
    }
}
