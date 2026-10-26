package com.google.common.cache;

/* INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public interface RemovalListener<K, V> {
    void onRemoval(RemovalNotification<K, V> notification);
}
