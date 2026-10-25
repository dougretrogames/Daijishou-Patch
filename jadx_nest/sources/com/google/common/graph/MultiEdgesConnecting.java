package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
abstract class MultiEdgesConnecting<E> extends AbstractSet<E> {
    private final Map<E, ?> outEdgeToNode;
    private final Object targetNode;

    MultiEdgesConnecting(Map<E, ?> outEdgeToNode, Object targetNode) {
        this.outEdgeToNode = (Map) Preconditions.checkNotNull(outEdgeToNode);
        this.targetNode = Preconditions.checkNotNull(targetNode);
    }

    /* JADX INFO: renamed from: com.google.common.graph.MultiEdgesConnecting$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractIterator<E> {
        final /* synthetic */ Iterator val$entries;

        AnonymousClass1(final Iterator val$entries) {
            this.val$entries = val$entries;
        }

        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        protected E computeNext() {
            while (this.val$entries.hasNext()) {
                Map.Entry entry = (Map.Entry) this.val$entries.next();
                if (MultiEdgesConnecting.this.targetNode.equals(entry.getValue())) {
                    return (E) entry.getKey();
                }
            }
            return endOfData();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public UnmodifiableIterator<E> iterator() {
        return new AnonymousClass1(this.outEdgeToNode.entrySet().iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object edge) {
        return this.targetNode.equals(this.outEdgeToNode.get(edge));
    }
}
