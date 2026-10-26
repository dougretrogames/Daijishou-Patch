package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.CheckForNull;

/* INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class DirectedGraphConnections<N, V> implements GraphConnections<N, V> {
    private static final Object PRED = new Object();
    private final Map<N, Object> adjacentNodeValues;

    @CheckForNull
    private final List<NodeConnection<N>> orderedNodeConnections;
    private int predecessorCount;
    private int successorCount;

    private static final class PredAndSucc {
        private final Object successorValue;

        PredAndSucc(Object successorValue) {
            this.successorValue = successorValue;
        }
    }

    /* INFO: Access modifiers changed from: private */
    static abstract class NodeConnection<N> {
        final N node;

        NodeConnection(N n) {
            this.node = (N) Preconditions.checkNotNull(n);
        }

        static final class Pred<N> extends NodeConnection<N> {
            Pred(N node) {
                super(node);
            }

            public boolean equals(@CheckForNull Object that) {
                if (that instanceof Pred) {
                    return this.node.equals(((Pred) that).node);
                }
                return false;
            }

            public int hashCode() {
                return Pred.class.hashCode() + this.node.hashCode();
            }
        }

        static final class Succ<N> extends NodeConnection<N> {
            Succ(N node) {
                super(node);
            }

            public boolean equals(@CheckForNull Object that) {
                if (that instanceof Succ) {
                    return this.node.equals(((Succ) that).node);
                }
                return false;
            }

            public int hashCode() {
                return Succ.class.hashCode() + this.node.hashCode();
            }
        }
    }

    private DirectedGraphConnections(Map<N, Object> adjacentNodeValues, @CheckForNull List<NodeConnection<N>> orderedNodeConnections, int predecessorCount, int successorCount) {
        this.adjacentNodeValues = (Map) Preconditions.checkNotNull(adjacentNodeValues);
        this.orderedNodeConnections = orderedNodeConnections;
        this.predecessorCount = Graphs.checkNonNegative(predecessorCount);
        this.successorCount = Graphs.checkNonNegative(successorCount);
        Preconditions.checkState(predecessorCount <= adjacentNodeValues.size() && successorCount <= adjacentNodeValues.size());
    }

    /* INFO: renamed from: com.google.common.graph.DirectedGraphConnections$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$graph$ElementOrder$Type;

        static {
            int[] iArr = new int[ElementOrder.Type.values().length];
            $SwitchMap$com$google$common$graph$ElementOrder$Type = iArr;
            try {
                iArr[ElementOrder.Type.UNORDERED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$common$graph$ElementOrder$Type[ElementOrder.Type.STABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static <N, V> DirectedGraphConnections<N, V> of(ElementOrder<N> incidentEdgeOrder) {
        ArrayList arrayList;
        int i = AnonymousClass5.$SwitchMap$com$google$common$graph$ElementOrder$Type[incidentEdgeOrder.type().ordinal()];
        if (i == 1) {
            arrayList = null;
        } else if (i == 2) {
            arrayList = new ArrayList();
        } else {
            throw new AssertionError(incidentEdgeOrder.type());
        }
        return new DirectedGraphConnections<>(new HashMap(4, 1.0f), arrayList, 0, 0);
    }

    /* WARN: Multi-variable type inference failed */
    static <N, V> DirectedGraphConnections<N, V> ofImmutable(N thisNode, Iterable<EndpointPair<N>> incidentEdges, Function<N, V> successorNodeToValueFn) {
        Preconditions.checkNotNull(thisNode);
        Preconditions.checkNotNull(successorNodeToValueFn);
        HashMap map = new HashMap();
        ImmutableList.Builder builder = ImmutableList.builder();
        int i = 0;
        int i2 = 0;
        for (EndpointPair<N> endpointPair : incidentEdges) {
            if (endpointPair.nodeU().equals(thisNode) && endpointPair.nodeV().equals(thisNode)) {
                map.put(thisNode, new PredAndSucc(successorNodeToValueFn.apply(thisNode)));
                builder.add(new NodeConnection.Pred(thisNode));
                builder.add(new NodeConnection.Succ(thisNode));
                i++;
            } else if (endpointPair.nodeV().equals(thisNode)) {
                N nNodeU = endpointPair.nodeU();
                Object objPut = map.put(nNodeU, PRED);
                if (objPut != null) {
                    map.put(nNodeU, new PredAndSucc(objPut));
                }
                builder.add(new NodeConnection.Pred(nNodeU));
                i++;
            } else {
                Preconditions.checkArgument(endpointPair.nodeU().equals(thisNode));
                N nNodeV = endpointPair.nodeV();
                V vApply = successorNodeToValueFn.apply(nNodeV);
                Object objPut2 = map.put(nNodeV, vApply);
                if (objPut2 != null) {
                    Preconditions.checkArgument(objPut2 == PRED);
                    map.put(nNodeV, new PredAndSucc(vApply));
                }
                builder.add(new NodeConnection.Succ(nNodeV));
            }
            i2++;
        }
        return new DirectedGraphConnections<>(map, builder.build(), i, i2);
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> adjacentNodes() {
        if (this.orderedNodeConnections == null) {
            return Collections.unmodifiableSet(this.adjacentNodeValues.keySet());
        }
        return new AnonymousClass1();
    }

    /* INFO: renamed from: com.google.common.graph.DirectedGraphConnections$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractSet<N> {
        AnonymousClass1() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public UnmodifiableIterator<N> iterator() {
            return new C00481(this, DirectedGraphConnections.this.orderedNodeConnections.iterator(), new HashSet());
        }

        /* INFO: renamed from: com.google.common.graph.DirectedGraphConnections$1$1, reason: invalid class name and collision with other inner class name */
        class C00481 extends AbstractIterator<N> {
            final /* synthetic */ Iterator val$nodeConnections;
            final /* synthetic */ Set val$seenNodes;

            C00481(final AnonymousClass1 this$1, final Iterator val$nodeConnections, final Set val$seenNodes) {
                this.val$nodeConnections = val$nodeConnections;
                this.val$seenNodes = val$seenNodes;
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            protected N computeNext() {
                while (this.val$nodeConnections.hasNext()) {
                    NodeConnection nodeConnection = (NodeConnection) this.val$nodeConnections.next();
                    if (this.val$seenNodes.add(nodeConnection.node)) {
                        return nodeConnection.node;
                    }
                }
                return endOfData();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return DirectedGraphConnections.this.adjacentNodeValues.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return DirectedGraphConnections.this.adjacentNodeValues.containsKey(obj);
        }
    }

    /* INFO: renamed from: com.google.common.graph.DirectedGraphConnections$2, reason: invalid class name */
    class AnonymousClass2 extends AbstractSet<N> {
        AnonymousClass2() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public UnmodifiableIterator<N> iterator() {
            if (DirectedGraphConnections.this.orderedNodeConnections == null) {
                return new AnonymousClass1(this, DirectedGraphConnections.this.adjacentNodeValues.entrySet().iterator());
            }
            return new C00492(this, DirectedGraphConnections.this.orderedNodeConnections.iterator());
        }

        /* INFO: renamed from: com.google.common.graph.DirectedGraphConnections$2$1, reason: invalid class name */
        class AnonymousClass1 extends AbstractIterator<N> {
            final /* synthetic */ Iterator val$entries;

            AnonymousClass1(final AnonymousClass2 this$1, final Iterator val$entries) {
                this.val$entries = val$entries;
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            protected N computeNext() {
                while (this.val$entries.hasNext()) {
                    Map.Entry entry = (Map.Entry) this.val$entries.next();
                    if (DirectedGraphConnections.isPredecessor(entry.getValue())) {
                        return (N) entry.getKey();
                    }
                }
                return endOfData();
            }
        }

        /* INFO: renamed from: com.google.common.graph.DirectedGraphConnections$2$2, reason: invalid class name and collision with other inner class name */
        class C00492 extends AbstractIterator<N> {
            final /* synthetic */ Iterator val$nodeConnections;

            C00492(final AnonymousClass2 this$1, final Iterator val$nodeConnections) {
                this.val$nodeConnections = val$nodeConnections;
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            protected N computeNext() {
                while (this.val$nodeConnections.hasNext()) {
                    NodeConnection nodeConnection = (NodeConnection) this.val$nodeConnections.next();
                    if (nodeConnection instanceof NodeConnection.Pred) {
                        return nodeConnection.node;
                    }
                }
                return endOfData();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return DirectedGraphConnections.this.predecessorCount;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return DirectedGraphConnections.isPredecessor(DirectedGraphConnections.this.adjacentNodeValues.get(obj));
        }
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> predecessors() {
        return new AnonymousClass2();
    }

    /* INFO: renamed from: com.google.common.graph.DirectedGraphConnections$3, reason: invalid class name */
    class AnonymousClass3 extends AbstractSet<N> {
        AnonymousClass3() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public UnmodifiableIterator<N> iterator() {
            if (DirectedGraphConnections.this.orderedNodeConnections == null) {
                return new AnonymousClass1(this, DirectedGraphConnections.this.adjacentNodeValues.entrySet().iterator());
            }
            return new AnonymousClass2(this, DirectedGraphConnections.this.orderedNodeConnections.iterator());
        }

        /* INFO: renamed from: com.google.common.graph.DirectedGraphConnections$3$1, reason: invalid class name */
        class AnonymousClass1 extends AbstractIterator<N> {
            final /* synthetic */ Iterator val$entries;

            AnonymousClass1(final AnonymousClass3 this$1, final Iterator val$entries) {
                this.val$entries = val$entries;
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            protected N computeNext() {
                while (this.val$entries.hasNext()) {
                    Map.Entry entry = (Map.Entry) this.val$entries.next();
                    if (DirectedGraphConnections.isSuccessor(entry.getValue())) {
                        return (N) entry.getKey();
                    }
                }
                return endOfData();
            }
        }

        /* INFO: renamed from: com.google.common.graph.DirectedGraphConnections$3$2, reason: invalid class name */
        class AnonymousClass2 extends AbstractIterator<N> {
            final /* synthetic */ Iterator val$nodeConnections;

            AnonymousClass2(final AnonymousClass3 this$1, final Iterator val$nodeConnections) {
                this.val$nodeConnections = val$nodeConnections;
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            protected N computeNext() {
                while (this.val$nodeConnections.hasNext()) {
                    NodeConnection nodeConnection = (NodeConnection) this.val$nodeConnections.next();
                    if (nodeConnection instanceof NodeConnection.Succ) {
                        return nodeConnection.node;
                    }
                }
                return endOfData();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return DirectedGraphConnections.this.successorCount;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return DirectedGraphConnections.isSuccessor(DirectedGraphConnections.this.adjacentNodeValues.get(obj));
        }
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> successors() {
        return new AnonymousClass3();
    }

    @Override // com.google.common.graph.GraphConnections
    public Iterator<EndpointPair<N>> incidentEdgeIterator(N thisNode) {
        Iterator itTransform;
        Preconditions.checkNotNull(thisNode);
        List<NodeConnection<N>> list = this.orderedNodeConnections;
        if (list == null) {
            itTransform = Iterators.concat(Iterators.transform(predecessors().iterator(), new DirectedGraphConnections$$ExternalSyntheticLambda0(thisNode)), Iterators.transform(successors().iterator(), new DirectedGraphConnections$$ExternalSyntheticLambda1(thisNode)));
        } else {
            itTransform = Iterators.transform(list.iterator(), new DirectedGraphConnections$$ExternalSyntheticLambda2(thisNode));
        }
        return new AnonymousClass4(this, itTransform, new AtomicBoolean(false));
    }

    static /* synthetic */ EndpointPair lambda$incidentEdgeIterator$2(Object obj, NodeConnection nodeConnection) {
        if (nodeConnection instanceof NodeConnection.Succ) {
            return EndpointPair.ordered(obj, nodeConnection.node);
        }
        return EndpointPair.ordered(nodeConnection.node, obj);
    }

    /* INFO: renamed from: com.google.common.graph.DirectedGraphConnections$4, reason: invalid class name */
    class AnonymousClass4 extends AbstractIterator<EndpointPair<N>> {
        final /* synthetic */ AtomicBoolean val$alreadySeenSelfLoop;
        final /* synthetic */ Iterator val$resultWithDoubleSelfLoop;

        AnonymousClass4(final DirectedGraphConnections this$0, final Iterator val$resultWithDoubleSelfLoop, final AtomicBoolean val$alreadySeenSelfLoop) {
            this.val$resultWithDoubleSelfLoop = val$resultWithDoubleSelfLoop;
            this.val$alreadySeenSelfLoop = val$alreadySeenSelfLoop;
        }

        /* INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        public EndpointPair<N> computeNext() {
            while (this.val$resultWithDoubleSelfLoop.hasNext()) {
                EndpointPair<N> endpointPair = (EndpointPair) this.val$resultWithDoubleSelfLoop.next();
                if (!endpointPair.nodeU().equals(endpointPair.nodeV()) || !this.val$alreadySeenSelfLoop.getAndSet(true)) {
                    return endpointPair;
                }
            }
            return endOfData();
        }
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.GraphConnections
    @CheckForNull
    public V value(N n) {
        Preconditions.checkNotNull(n);
        V v = (V) this.adjacentNodeValues.get(n);
        if (v == PRED) {
            return null;
        }
        return v instanceof PredAndSucc ? (V) ((PredAndSucc) v).successorValue : v;
    }

    @Override // com.google.common.graph.GraphConnections
    public void removePredecessor(N node) {
        Preconditions.checkNotNull(node);
        Object obj = this.adjacentNodeValues.get(node);
        if (obj == PRED) {
            this.adjacentNodeValues.remove(node);
        } else if (!(obj instanceof PredAndSucc)) {
            return;
        } else {
            this.adjacentNodeValues.put(node, ((PredAndSucc) obj).successorValue);
        }
        int i = this.predecessorCount - 1;
        this.predecessorCount = i;
        Graphs.checkNonNegative(i);
        List<NodeConnection<N>> list = this.orderedNodeConnections;
        if (list != null) {
            list.remove(new NodeConnection.Pred(node));
        }
    }

    @Override // com.google.common.graph.GraphConnections
    @CheckForNull
    public V removeSuccessor(Object obj) {
        Object obj2;
        Preconditions.checkNotNull(obj);
        Object obj3 = (V) this.adjacentNodeValues.get(obj);
        if (obj3 == null || obj3 == (obj2 = PRED)) {
            obj3 = (V) null;
        } else if (obj3 instanceof PredAndSucc) {
            this.adjacentNodeValues.put(obj, obj2);
            obj3 = (V) ((PredAndSucc) obj3).successorValue;
        } else {
            this.adjacentNodeValues.remove(obj);
        }
        if (obj3 != null) {
            int i = this.successorCount - 1;
            this.successorCount = i;
            Graphs.checkNonNegative(i);
            List<NodeConnection<N>> list = this.orderedNodeConnections;
            if (list != null) {
                list.remove(new NodeConnection.Succ(obj));
            }
        }
        if (obj3 == null) {
            return null;
        }
        return (V) obj3;
    }

    @Override // com.google.common.graph.GraphConnections
    public void addPredecessor(N node, V unused) {
        Map<N, Object> map = this.adjacentNodeValues;
        Object obj = PRED;
        Object objPut = map.put(node, obj);
        if (objPut != null) {
            if (objPut instanceof PredAndSucc) {
                this.adjacentNodeValues.put(node, objPut);
                return;
            } else if (objPut == obj) {
                return;
            } else {
                this.adjacentNodeValues.put(node, new PredAndSucc(objPut));
            }
        }
        int i = this.predecessorCount + 1;
        this.predecessorCount = i;
        Graphs.checkPositive(i);
        List<NodeConnection<N>> list = this.orderedNodeConnections;
        if (list != null) {
            list.add(new NodeConnection.Pred(node));
        }
    }

    @Override // com.google.common.graph.GraphConnections
    @CheckForNull
    public V addSuccessor(N n, V v) {
        Object obj = (V) this.adjacentNodeValues.put(n, v);
        if (obj == null) {
            obj = (V) null;
        } else if (obj instanceof PredAndSucc) {
            this.adjacentNodeValues.put(n, new PredAndSucc(v));
            obj = (V) ((PredAndSucc) obj).successorValue;
        } else if (obj == PRED) {
            this.adjacentNodeValues.put(n, new PredAndSucc(v));
            obj = (V) null;
        }
        if (obj == null) {
            int i = this.successorCount + 1;
            this.successorCount = i;
            Graphs.checkPositive(i);
            List<NodeConnection<N>> list = this.orderedNodeConnections;
            if (list != null) {
                list.add(new NodeConnection.Succ(n));
            }
        }
        if (obj == null) {
            return null;
        }
        return (V) obj;
    }

    /* INFO: Access modifiers changed from: private */
    public static boolean isPredecessor(@CheckForNull Object value) {
        return value == PRED || (value instanceof PredAndSucc);
    }

    /* INFO: Access modifiers changed from: private */
    public static boolean isSuccessor(@CheckForNull Object value) {
        return (value == PRED || value == null) ? false : true;
    }
}
