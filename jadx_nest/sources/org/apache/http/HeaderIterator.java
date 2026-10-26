package org.apache.http;

import java.util.Iterator;

/* INFO: loaded from: classes5.dex */
public interface HeaderIterator extends Iterator<Object> {
    @Override // java.util.Iterator
    boolean hasNext();

    Header nextHeader();
}
