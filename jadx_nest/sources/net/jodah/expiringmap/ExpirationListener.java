package net.jodah.expiringmap;

/* INFO: loaded from: classes5.dex */
public interface ExpirationListener<K, V> {
    void expired(K k, V v);
}
