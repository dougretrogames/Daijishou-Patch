package org.apache.http;

import java.util.Iterator;

/* INFO: loaded from: classes5.dex */
public interface HeaderElementIterator extends Iterator<Object> {
    @Override // java.util.Iterator
    boolean hasNext();

    HeaderElement nextElement();
}
