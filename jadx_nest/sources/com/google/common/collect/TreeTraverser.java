package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;
import javax.annotation.CheckForNull;

/* INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
@Deprecated
public abstract class TreeTraverser<T> {
    public abstract Iterable<T> children(T root);

    /* INFO: renamed from: com.google.common.collect.TreeTraverser$1, reason: invalid class name */
    class AnonymousClass1 extends TreeTraverser<T> {
        final /* synthetic */ Function val$nodeToChildrenFunction;

        AnonymousClass1(final Function val$nodeToChildrenFunction) {
            this.val$nodeToChildrenFunction = val$nodeToChildrenFunction;
        }

        @Override // com.google.common.collect.TreeTraverser
        public Iterable<T> children(T root) {
            return (Iterable) this.val$nodeToChildrenFunction.apply(root);
        }
    }

    @Deprecated
    public static <T> TreeTraverser<T> using(final Function<T, ? extends Iterable<T>> nodeToChildrenFunction) {
        Preconditions.checkNotNull(nodeToChildrenFunction);
        return new AnonymousClass1(nodeToChildrenFunction);
    }

    /* INFO: renamed from: com.google.common.collect.TreeTraverser$2, reason: invalid class name */
    class AnonymousClass2 extends FluentIterable<T> {
        final /* synthetic */ Object val$root;

        AnonymousClass2(final Object val$root) {
            this.val$root = val$root;
        }

        /* WARN: Multi-variable type inference failed */
        @Override // java.lang.Iterable
        public UnmodifiableIterator<T> iterator() {
            return TreeTraverser.this.preOrderIterator(this.val$root);
        }
    }

    @Deprecated
    public final FluentIterable<T> preOrderTraversal(final T root) {
        Preconditions.checkNotNull(root);
        return new AnonymousClass2(root);
    }

    UnmodifiableIterator<T> preOrderIterator(T root) {
        return new PreOrderIterator(root);
    }

    private final class PreOrderIterator extends UnmodifiableIterator<T> {
        private final Deque<Iterator<T>> stack;

        PreOrderIterator(T root) {
            ArrayDeque arrayDeque = new ArrayDeque();
            this.stack = arrayDeque;
            arrayDeque.addLast(Iterators.singletonIterator(Preconditions.checkNotNull(root)));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.stack.isEmpty();
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
        @Override // java.util.Iterator
        public T next() {
            Iterator<T> last = this.stack.getLast();
            T t = (T) Preconditions.checkNotNull(last.next());
            if (!last.hasNext()) {
                this.stack.removeLast();
            }
            Iterator<T> it = TreeTraverser.this.children(t).iterator();
            if (it.hasNext()) {
                this.stack.addLast(it);
            }
            return t;
        }
    }

    /* INFO: renamed from: com.google.common.collect.TreeTraverser$3, reason: invalid class name */
    class AnonymousClass3 extends FluentIterable<T> {
        final /* synthetic */ Object val$root;

        AnonymousClass3(final Object val$root) {
            this.val$root = val$root;
        }

        /* WARN: Multi-variable type inference failed */
        @Override // java.lang.Iterable
        public UnmodifiableIterator<T> iterator() {
            return TreeTraverser.this.postOrderIterator(this.val$root);
        }
    }

    @Deprecated
    public final FluentIterable<T> postOrderTraversal(final T root) {
        Preconditions.checkNotNull(root);
        return new AnonymousClass3(root);
    }

    UnmodifiableIterator<T> postOrderIterator(T root) {
        return new PostOrderIterator(root);
    }

    private static final class PostOrderNode<T> {
        final Iterator<T> childIterator;
        final T root;

        PostOrderNode(T t, Iterator<T> it) {
            this.root = (T) Preconditions.checkNotNull(t);
            this.childIterator = (Iterator) Preconditions.checkNotNull(it);
        }
    }

    private final class PostOrderIterator extends AbstractIterator<T> {
        private final ArrayDeque<PostOrderNode<T>> stack;

        PostOrderIterator(T root) {
            ArrayDeque<PostOrderNode<T>> arrayDeque = new ArrayDeque<>();
            this.stack = arrayDeque;
            arrayDeque.addLast(expand(root));
        }

        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        protected T computeNext() {
            while (!this.stack.isEmpty()) {
                PostOrderNode<T> last = this.stack.getLast();
                if (last.childIterator.hasNext()) {
                    this.stack.addLast(expand(last.childIterator.next()));
                } else {
                    this.stack.removeLast();
                    return last.root;
                }
            }
            return endOfData();
        }

        private PostOrderNode<T> expand(T t) {
            return new PostOrderNode<>(t, TreeTraverser.this.children(t).iterator());
        }
    }

    /* INFO: renamed from: com.google.common.collect.TreeTraverser$4, reason: invalid class name */
    class AnonymousClass4 extends FluentIterable<T> {
        final /* synthetic */ Object val$root;

        AnonymousClass4(final Object val$root) {
            this.val$root = val$root;
        }

        @Override // java.lang.Iterable
        public UnmodifiableIterator<T> iterator() {
            return new BreadthFirstIterator(this.val$root);
        }
    }

    @Deprecated
    public final FluentIterable<T> breadthFirstTraversal(final T root) {
        Preconditions.checkNotNull(root);
        return new AnonymousClass4(root);
    }

    private final class BreadthFirstIterator extends UnmodifiableIterator<T> implements PeekingIterator<T> {
        private final Queue<T> queue;

        BreadthFirstIterator(T root) {
            ArrayDeque arrayDeque = new ArrayDeque();
            this.queue = arrayDeque;
            arrayDeque.add(root);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.queue.isEmpty();
        }

        @Override // com.google.common.collect.PeekingIterator
        public T peek() {
            return this.queue.element();
        }

        @Override // java.util.Iterator, com.google.common.collect.PeekingIterator
        public T next() {
            T tRemove = this.queue.remove();
            Iterables.addAll(this.queue, TreeTraverser.this.children(tRemove));
            return tRemove;
        }
    }
}
