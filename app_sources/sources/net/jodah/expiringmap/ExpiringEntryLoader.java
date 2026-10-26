package net.jodah.expiringmap;

/* INFO: loaded from: classes5.dex */
public interface ExpiringEntryLoader<K, V> {
    ExpiringValue<V> load(K k);
}
