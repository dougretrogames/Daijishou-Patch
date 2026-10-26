package org.apache.commons.collections4.sequence;

import java.util.List;

/* INFO: loaded from: classes5.dex */
@FunctionalInterface
public interface ReplacementsHandler<T> {
    void handleReplacement(int i, List<T> list, List<T> list2);
}
