package com.google.api.client.util.store;

import java.io.IOException;
import java.io.Serializable;

/* INFO: loaded from: classes3.dex */
public interface DataStoreFactory {
    <V extends Serializable> DataStore<V> getDataStore(String str) throws IOException;
}
