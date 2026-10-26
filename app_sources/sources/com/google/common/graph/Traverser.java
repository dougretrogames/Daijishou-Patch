package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.DoNotMock;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

/* INFO: loaded from: classes3.dex */
@DoNotMock("Call forGraph or forTree, passing a lambda or a Graph with the desired edges (built with GraphBuilder)")
@ElementTypesAreNonnullByDefault
public abstract class Traverser<N> {
    private final SuccessorsFunction<N> successorFunction;

    abstract Traversal<N> newTraversal();

    /* synthetic */ Traverser(SuccessorsFunction successorsFunction, AnonymousClass1 anonymousClass1) {
        this(successorsFunction);
    }

    private Traverser(SuccessorsFunction<N> successorFunction) {
        this.successorFunction = (SuccessorsFunction) Preconditions.checkNotNull(successorFunction);
    }

    /* INFO: renamed from: com.google.common.graph.Traverser$1, reason: invalid class name */
    class AnonymousClass1 extends Traverser<N> {
        final /* synthetic */ SuccessorsFunction val$graph;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SuccessorsFunction successorFunction, final SuccessorsFunction val$graph) {
            super(successorFunction, null);
            this.val$graph = val$graph;
        }

        @Override // com.google.common.graph.Traverser
        Traversal<N> newTraversal() {
            return Traversal.inGraph(this.val$graph);
        }
    }

    public static <N> Traverser<N> forGraph(SuccessorsFunction<N> graph) {
        return new AnonymousClass1(graph, graph);
    }

    public static <N> Traverser<N> forTree(SuccessorsFunction<N> tree) {
        if (tree instanceof BaseGraph) {
            Preconditions.checkArgument(((BaseGraph) tree).isDirected(), "Undirected graphs can never be trees.");
        }
        if (tree instanceof Network) {
            Preconditions.checkArgument(((Network) tree).isDirected(), "Undirected networks can never be trees.");
        }
        return new AnonymousClass2(tree, tree);
    }

    /* INFO: renamed from: com.google.common.graph.Traverser$2, reason: invalid class name */
    class AnonymousClass2 extends Traverser<N> {
        final /* synthetic */ SuccessorsFunction val$tree;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(SuccessorsFunction successorFunction, final SuccessorsFunction val$tree) {
            super(successorFunction, null);
            this.val$tree = val$tree;
        }

        @Override // com.google.common.graph.Traverser
        Traversal<N> newTraversal() {
            return Traversal.inTree(this.val$tree);
        }
    }

    public final Iterable<N> breadthFirst(N startNode) {
        return breadthFirst((Iterable) ImmutableSet.of(startNode));
    }

    /* INFO: renamed from: com.google.common.graph.Traverser$3, reason: invalid class name */
    class AnonymousClass3 implements Iterable<N> {
        final /* synthetic */ ImmutableSet val$validated;

        AnonymousClass3(final ImmutableSet val$validated) {
            this.val$validated = val$validated;
        }

        @Override // java.lang.Iterable
        public Iterator<N> iterator() {
            return Traverser.this.newTraversal().breadthFirst(this.val$validated.iterator());
        }
    }

    public final Iterable<N> breadthFirst(Iterable<? extends N> startNodes) {
        return new AnonymousClass3(validate(startNodes));
    }

    public final Iterable<N> depthFirstPreOrder(N startNode) {
        return depthFirstPreOrder((Iterable) ImmutableSet.of(startNode));
    }

    /* INFO: renamed from: com.google.common.graph.Traverser$4, reason: invalid class name */
    class AnonymousClass4 implements Iterable<N> {
        final /* synthetic */ ImmutableSet val$validated;

        AnonymousClass4(final ImmutableSet val$validated) {
            this.val$validated = val$validated;
        }

        @Override // java.lang.Iterable
        public Iterator<N> iterator() {
            return Traverser.this.newTraversal().preOrder(this.val$validated.iterator());
        }
    }

    public final Iterable<N> depthFirstPreOrder(Iterable<? extends N> startNodes) {
        return new AnonymousClass4(validate(startNodes));
    }

    public final Iterable<N> depthFirstPostOrder(N startNode) {
        return depthFirstPostOrder((Iterable) ImmutableSet.of(startNode));
    }

    /* INFO: renamed from: com.google.common.graph.Traverser$5, reason: invalid class name */
    class AnonymousClass5 implements Iterable<N> {
        final /* synthetic */ ImmutableSet val$validated;

        AnonymousClass5(final ImmutableSet val$validated) {
            this.val$validated = val$validated;
        }

        @Override // java.lang.Iterable
        public Iterator<N> iterator() {
            return Traverser.this.newTraversal().postOrder(this.val$validated.iterator());
        }
    }

    public final Iterable<N> depthFirstPostOrder(Iterable<? extends N> startNodes) {
        return new AnonymousClass5(validate(startNodes));
    }

    private ImmutableSet<N> validate(Iterable<? extends N> startNodes) {
        ImmutableSet<N> immutableSetCopyOf = ImmutableSet.copyOf(startNodes);
        UnmodifiableIterator<N> it = immutableSetCopyOf.iterator();
        while (it.hasNext()) {
            this.successorFunction.successors(it.next());
        }
        return immutableSetCopyOf;
    }

    private static abstract class Traversal<N> {
        final SuccessorsFunction<N> successorFunction;

        @CheckForNull
        abstract N visitNext(Deque<Iterator<? extends N>> horizon);

        Traversal(SuccessorsFunction<N> successorFunction) {
            this.successorFunction = successorFunction;
        }

        /* INFO: renamed from: com.google.common.graph.Traverser$Traversal$1, reason: invalid class name */
        class AnonymousClass1 extends Traversal<N> {
            final /* synthetic */ Set val$visited;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(SuccessorsFunction successorFunction, final Set val$visited) {
                super(successorFunction);
                this.val$visited = val$visited;
            }

            @Override // com.google.common.graph.Traverser.Traversal
            @CheckForNull
            N visitNext(Deque<Iterator<? extends N>> horizon) {
                Iterator<? extends N> first = horizon.getFirst();
                while (first.hasNext()) {
                    N next = first.next();
                    Objects.requireNonNull(next);
                    if (this.val$visited.add(next)) {
                        return next;
                    }
                }
                horizon.removeFirst();
                return null;
            }
        }

        static <N> Traversal<N> inGraph(SuccessorsFunction<N> graph) {
            return new AnonymousClass1(graph, new HashSet());
        }

        /* INFO: renamed from: com.google.common.graph.Traverser$Traversal$2, reason: invalid class name */
        class AnonymousClass2 extends Traversal<N> {
            AnonymousClass2(SuccessorsFunction successorFunction) {
                super(successorFunction);
            }

            @Override // com.google.common.graph.Traverser.Traversal
            @CheckForNull
            N visitNext(Deque<Iterator<? extends N>> deque) {
                Iterator<? extends N> first = deque.getFirst();
                if (first.hasNext()) {
                    return (N) Preconditions.checkNotNull(first.next());
                }
                deque.removeFirst();
                return null;
            }
        }

        static <N> Traversal<N> inTree(SuccessorsFunction<N> tree) {
            return new AnonymousClass2(tree);
        }

        final Iterator<N> breadthFirst(Iterator<? extends N> startNodes) {
            return topDown(startNodes, InsertionOrder.BACK);
        }

        final Iterator<N> preOrder(Iterator<? extends N> startNodes) {
            return topDown(startNodes, InsertionOrder.FRONT);
        }

        private Iterator<N> topDown(Iterator<? extends N> startNodes, InsertionOrder order) {
            ArrayDeque arrayDeque = new ArrayDeque();
            arrayDeque.add(startNodes);
            return new AnonymousClass3(arrayDeque, order);
        }

        /* INFO: renamed from: com.google.common.graph.Traverser$Traversal$3, reason: invalid class name */
        class AnonymousClass3 extends AbstractIterator<N> {
            final /* synthetic */ Deque val$horizon;
            final /* synthetic */ InsertionOrder val$order;

            AnonymousClass3(final Deque val$horizon, final InsertionOrder val$order) {
                this.val$horizon = val$horizon;
                this.val$order = val$order;
            }

            /* WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class decompiler.core.dex.instructions.args.ArgType$UnknownArg
            	at decompiler.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at decompiler.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at decompiler.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            protected N computeNext() {
                do {
                    N n = (N) Traversal.this.visitNext(this.val$horizon);
                    if (n != null) {
                        Iterator<? extends N> it = Traversal.this.successorFunction.successors(n).iterator();
                        if (it.hasNext()) {
                            this.val$order.insertInto(this.val$horizon, it);
                        }
                        return n;
                    }
                } while (!this.val$horizon.isEmpty());
                return endOfData();
            }
        }

        final Iterator<N> postOrder(Iterator<? extends N> startNodes) {
            ArrayDeque arrayDeque = new ArrayDeque();
            ArrayDeque arrayDeque2 = new ArrayDeque();
            arrayDeque2.add(startNodes);
            return new AnonymousClass4(arrayDeque2, arrayDeque);
        }

        /* INFO: renamed from: com.google.common.graph.Traverser$Traversal$4, reason: invalid class name */
        class AnonymousClass4 extends AbstractIterator<N> {
            final /* synthetic */ Deque val$ancestorStack;
            final /* synthetic */ Deque val$horizon;

            AnonymousClass4(final Deque val$horizon, final Deque val$ancestorStack) {
                this.val$horizon = val$horizon;
                this.val$ancestorStack = val$ancestorStack;
            }

            /* WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class decompiler.core.dex.instructions.args.ArgType$UnknownArg
            	at decompiler.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at decompiler.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at decompiler.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            protected N computeNext() {
                while (true) {
                    N n = (N) Traversal.this.visitNext(this.val$horizon);
                    if (n != null) {
                        Iterator<? extends N> it = Traversal.this.successorFunction.successors(n).iterator();
                        if (!it.hasNext()) {
                            return n;
                        }
                        this.val$horizon.addFirst(it);
                        this.val$ancestorStack.push(n);
                    } else {
                        if (!this.val$ancestorStack.isEmpty()) {
                            return (N) this.val$ancestorStack.pop();
                        }
                        return endOfData();
                    }
                }
            }
        }
    }

    /* WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* WARN: Unknown enum class pattern. Please report as an issue! */
    private static abstract class InsertionOrder {
        public static final InsertionOrder FRONT = new AnonymousClass1("FRONT", 0);
        public static final InsertionOrder BACK = new AnonymousClass2("BACK", 1);
        private static final /* synthetic */ InsertionOrder[] $VALUES = $values();

        abstract <T> void insertInto(Deque<T> deque, T value);

        /* INFO: renamed from: com.google.common.graph.Traverser$InsertionOrder$1, reason: invalid class name */
        final enum AnonymousClass1 extends InsertionOrder {
            AnonymousClass1(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // com.google.common.graph.Traverser.InsertionOrder
            <T> void insertInto(Deque<T> deque, T value) {
                deque.addFirst(value);
            }
        }

        private static /* synthetic */ InsertionOrder[] $values() {
            return new InsertionOrder[]{FRONT, BACK};
        }

        private InsertionOrder(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        /* synthetic */ InsertionOrder(String str, int i, AnonymousClass1 anonymousClass1) {
            this(str, i);
        }

        public static InsertionOrder valueOf(String name) {
            return (InsertionOrder) Enum.valueOf(InsertionOrder.class, name);
        }

        public static InsertionOrder[] values() {
            return (InsertionOrder[]) $VALUES.clone();
        }

        /* INFO: renamed from: com.google.common.graph.Traverser$InsertionOrder$2, reason: invalid class name */
        final enum AnonymousClass2 extends InsertionOrder {
            AnonymousClass2(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // com.google.common.graph.Traverser.InsertionOrder
            <T> void insertInto(Deque<T> deque, T value) {
                deque.addLast(value);
            }
        }
    }
}
