package net.jodah.expiringmap;

/* JADX INFO: loaded from: classes5.dex */
public interface ExpiringEntryLoader<K, V> {
    ExpiringValue<V> load(K k);
}
