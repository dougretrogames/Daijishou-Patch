package com.google.android.gms.common.data;

import java.util.ArrayList;
import java.util.Iterator;
import org.retroachivements.api.data.pojo.feed.GetClaims;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class FreezableUtils {
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(ArrayList<E> arrayList) {
        GetClaims.Response response = (ArrayList<T>) new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            response.add(arrayList.get(i).freeze());
        }
        return response;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(Iterable<E> iterable) {
        GetClaims.Response response = (ArrayList<T>) new ArrayList();
        Iterator<E> it = iterable.iterator();
        while (it.hasNext()) {
            response.add(it.next().freeze());
        }
        return response;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freeze(E[] eArr) {
        GetClaims.Response response = (ArrayList<T>) new ArrayList(eArr.length);
        for (E e : eArr) {
            response.add(e.freeze());
        }
        return response;
    }
}
