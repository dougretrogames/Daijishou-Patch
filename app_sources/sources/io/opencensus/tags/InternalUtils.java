package io.opencensus.tags;

import java.util.Iterator;

/* INFO: loaded from: classes4.dex */
public final class InternalUtils {
    private InternalUtils() {
    }

    public static Iterator<Tag> getTags(TagContext tagContext) {
        return tagContext.getIterator();
    }
}
