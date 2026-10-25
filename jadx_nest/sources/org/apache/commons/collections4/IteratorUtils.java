package org.apache.commons.collections4;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Spliterators;
import java.util.function.IntFunction;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.apache.commons.collections4.functors.EqualPredicate;
import org.apache.commons.collections4.iterators.ArrayIterator;
import org.apache.commons.collections4.iterators.ArrayListIterator;
import org.apache.commons.collections4.iterators.BoundedIterator;
import org.apache.commons.collections4.iterators.CollatingIterator;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.EmptyListIterator;
import org.apache.commons.collections4.iterators.EmptyMapIterator;
import org.apache.commons.collections4.iterators.EmptyOrderedIterator;
import org.apache.commons.collections4.iterators.EmptyOrderedMapIterator;
import org.apache.commons.collections4.iterators.EnumerationIterator;
import org.apache.commons.collections4.iterators.FilterIterator;
import org.apache.commons.collections4.iterators.FilterListIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.iterators.IteratorEnumeration;
import org.apache.commons.collections4.iterators.IteratorIterable;
import org.apache.commons.collections4.iterators.LazyIteratorChain;
import org.apache.commons.collections4.iterators.ListIteratorWrapper;
import org.apache.commons.collections4.iterators.LoopingIterator;
import org.apache.commons.collections4.iterators.LoopingListIterator;
import org.apache.commons.collections4.iterators.NodeListIterator;
import org.apache.commons.collections4.iterators.ObjectArrayIterator;
import org.apache.commons.collections4.iterators.ObjectArrayListIterator;
import org.apache.commons.collections4.iterators.ObjectGraphIterator;
import org.apache.commons.collections4.iterators.PeekingIterator;
import org.apache.commons.collections4.iterators.PushbackIterator;
import org.apache.commons.collections4.iterators.SingletonIterator;
import org.apache.commons.collections4.iterators.SingletonListIterator;
import org.apache.commons.collections4.iterators.SkippingIterator;
import org.apache.commons.collections4.iterators.TransformIterator;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;
import org.apache.commons.collections4.iterators.UnmodifiableListIterator;
import org.apache.commons.collections4.iterators.UnmodifiableMapIterator;
import org.apache.commons.collections4.iterators.ZippingIterator;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: loaded from: classes5.dex */
public class IteratorUtils {
    private static final String DEFAULT_TOSTRING_DELIMITER = ", ";
    public static final ResettableIterator EMPTY_ITERATOR = EmptyIterator.RESETTABLE_INSTANCE;
    public static final ResettableListIterator EMPTY_LIST_ITERATOR = EmptyListIterator.RESETTABLE_INSTANCE;
    public static final OrderedIterator EMPTY_ORDERED_ITERATOR = EmptyOrderedIterator.INSTANCE;
    public static final MapIterator EMPTY_MAP_ITERATOR = EmptyMapIterator.INSTANCE;
    public static final OrderedMapIterator EMPTY_ORDERED_MAP_ITERATOR = EmptyOrderedMapIterator.INSTANCE;

    private static <E, C extends Collection<E>> C addAll(Iterator<? extends E> it, C c) {
        Objects.requireNonNull(it, "iterator");
        while (it.hasNext()) {
            c.add(it.next());
        }
        return c;
    }

    public static <E> ResettableIterator<E> arrayIterator(E... eArr) {
        return new ObjectArrayIterator(eArr);
    }

    public static <E> ResettableIterator<E> arrayIterator(E[] eArr, int i) {
        return new ObjectArrayIterator(eArr, i);
    }

    public static <E> ResettableIterator<E> arrayIterator(E[] eArr, int i, int i2) {
        return new ObjectArrayIterator(eArr, i, i2);
    }

    public static <E> ResettableIterator<E> arrayIterator(Object obj) {
        return new ArrayIterator(obj);
    }

    public static <E> ResettableIterator<E> arrayIterator(Object obj, int i) {
        return new ArrayIterator(obj, i);
    }

    public static <E> ResettableIterator<E> arrayIterator(Object obj, int i, int i2) {
        return new ArrayIterator(obj, i, i2);
    }

    public static <E> ResettableListIterator<E> arrayListIterator(E... eArr) {
        return new ObjectArrayListIterator(eArr);
    }

    public static <E> ResettableListIterator<E> arrayListIterator(E[] eArr, int i) {
        return new ObjectArrayListIterator(eArr, i);
    }

    public static <E> ResettableListIterator<E> arrayListIterator(E[] eArr, int i, int i2) {
        return new ObjectArrayListIterator(eArr, i, i2);
    }

    public static <E> ResettableListIterator<E> arrayListIterator(Object obj) {
        return new ArrayListIterator(obj);
    }

    public static <E> ResettableListIterator<E> arrayListIterator(Object obj, int i) {
        return new ArrayListIterator(obj, i);
    }

    public static <E> ResettableListIterator<E> arrayListIterator(Object obj, int i, int i2) {
        return new ArrayListIterator(obj, i, i2);
    }

    public static <E> Enumeration<E> asEnumeration(Iterator<? extends E> it) {
        return new IteratorEnumeration((Iterator) Objects.requireNonNull(it, "iterator"));
    }

    public static <E> Iterable<E> asIterable(Iterator<? extends E> it) {
        Objects.requireNonNull(it, "iterator");
        return new IteratorIterable(it, false);
    }

    public static <E> Iterator<E> asIterator(Enumeration<? extends E> enumeration) {
        return new EnumerationIterator((Enumeration) Objects.requireNonNull(enumeration, "enumeration"));
    }

    public static <E> Iterator<E> asIterator(Enumeration<? extends E> enumeration, Collection<? super E> collection) {
        return new EnumerationIterator((Enumeration) Objects.requireNonNull(enumeration, "enumeration"), (Collection) Objects.requireNonNull(collection, "removeCollection"));
    }

    public static <E> Iterable<E> asMultipleUseIterable(Iterator<? extends E> it) {
        Objects.requireNonNull(it, "iterator");
        return new IteratorIterable(it, true);
    }

    public static <E> BoundedIterator<E> boundedIterator(Iterator<? extends E> it, long j) {
        return boundedIterator(it, 0L, j);
    }

    public static <E> BoundedIterator<E> boundedIterator(Iterator<? extends E> it, long j, long j2) {
        return new BoundedIterator<>(it, j, j2);
    }

    public static <E> Iterator<E> chainedIterator(Collection<? extends Iterator<? extends E>> collection) {
        return new IteratorChain(collection);
    }

    public static <E> Iterator<E> chainedIterator(Iterator<? extends E>... itArr) {
        return new IteratorChain(itArr);
    }

    public static <E> Iterator<E> chainedIterator(Iterator<? extends E> it, Iterator<? extends E> it2) {
        return new IteratorChain(it, it2);
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: org.apache.commons.collections4.IteratorUtils$1, reason: invalid class name */
    class AnonymousClass1<E> extends LazyIteratorChain<E> {
        final /* synthetic */ Iterator val$iterators;

        AnonymousClass1(Iterator it) {
            this.val$iterators = it;
        }

        @Override // org.apache.commons.collections4.iterators.LazyIteratorChain
        protected Iterator<? extends E> nextIterator(int i) {
            if (this.val$iterators.hasNext()) {
                return (Iterator) this.val$iterators.next();
            }
            return null;
        }
    }

    public static <E> Iterator<E> chainedIterator(Iterator<? extends Iterator<? extends E>> it) {
        return new AnonymousClass1(it);
    }

    public static <E> Iterator<E> collatedIterator(Comparator<? super E> comparator, Collection<Iterator<? extends E>> collection) {
        if (comparator == null) {
            comparator = ComparatorUtils.NATURAL_COMPARATOR;
        }
        return new CollatingIterator(comparator, collection);
    }

    public static <E> Iterator<E> collatedIterator(Comparator<? super E> comparator, Iterator<? extends E>... itArr) {
        if (comparator == null) {
            comparator = ComparatorUtils.NATURAL_COMPARATOR;
        }
        return new CollatingIterator(comparator, itArr);
    }

    public static <E> Iterator<E> collatedIterator(Comparator<? super E> comparator, Iterator<? extends E> it, Iterator<? extends E> it2) {
        if (comparator == null) {
            comparator = ComparatorUtils.NATURAL_COMPARATOR;
        }
        return new CollatingIterator(comparator, it, it2);
    }

    public static <E> boolean contains(Iterator<E> it, Object obj) {
        return matchesAny(it, EqualPredicate.equalPredicate(obj));
    }

    public static <E> ResettableIterator<E> emptyIterator() {
        return EmptyIterator.resettableEmptyIterator();
    }

    public static <E> ResettableListIterator<E> emptyListIterator() {
        return EmptyListIterator.resettableEmptyListIterator();
    }

    public static <K, V> MapIterator<K, V> emptyMapIterator() {
        return EmptyMapIterator.emptyMapIterator();
    }

    public static <E> OrderedIterator<E> emptyOrderedIterator() {
        return EmptyOrderedIterator.emptyOrderedIterator();
    }

    public static <K, V> OrderedMapIterator<K, V> emptyOrderedMapIterator() {
        return EmptyOrderedMapIterator.emptyOrderedMapIterator();
    }

    public static <E> Iterator<E> filteredIterator(Iterator<? extends E> it, Predicate<? super E> predicate) {
        Objects.requireNonNull(it, "iterator");
        Objects.requireNonNull(predicate, "predicate");
        return new FilterIterator(it, predicate);
    }

    public static <E> ListIterator<E> filteredListIterator(ListIterator<? extends E> listIterator, Predicate<? super E> predicate) {
        Objects.requireNonNull(listIterator, "listIterator");
        Objects.requireNonNull(predicate, "predicate");
        return new FilterListIterator(listIterator, predicate);
    }

    public static <E> E find(Iterator<E> it, Predicate<? super E> predicate) {
        return (E) find(it, predicate, null);
    }

    private static <E> E find(Iterator<E> it, Predicate<? super E> predicate, E e) {
        Objects.requireNonNull(predicate, "predicate");
        if (it != null) {
            while (it.hasNext()) {
                E next = it.next();
                if (predicate.test(next)) {
                    return next;
                }
            }
        }
        return e;
    }

    public static <E> E first(Iterator<E> it) {
        return (E) get(it, 0);
    }

    public static <E> void forEach(Iterator<E> it, Closure<? super E> closure) {
        Objects.requireNonNull(closure, "closure");
        if (it != null) {
            while (it.hasNext()) {
                closure.accept(it.next());
            }
        }
    }

    public static <E> E forEachButLast(Iterator<E> it, Closure<? super E> closure) {
        Objects.requireNonNull(closure, "closure");
        if (it == null) {
            return null;
        }
        while (it.hasNext()) {
            E next = it.next();
            if (!it.hasNext()) {
                return next;
            }
            closure.accept(next);
        }
        return null;
    }

    public static <E> E get(Iterator<E> it, int i) {
        return (E) get(it, i, new IteratorUtils$$ExternalSyntheticLambda0());
    }

    static /* synthetic */ Object lambda$get$0(int i) {
        throw new IndexOutOfBoundsException("Entry does not exist: " + i);
    }

    static <E> E get(Iterator<E> it, int i, IntFunction<E> intFunction) {
        CollectionUtils.checkIndexBounds(i);
        while (it.hasNext()) {
            i--;
            if (i == -1) {
                return it.next();
            }
            it.next();
        }
        return intFunction.apply(i);
    }

    public static Iterator<?> getIterator(Object obj) {
        if (obj == null) {
            return emptyIterator();
        }
        if (obj instanceof Iterator) {
            return (Iterator) obj;
        }
        if (obj instanceof Iterable) {
            return ((Iterable) obj).iterator();
        }
        if (obj instanceof Object[]) {
            return new ObjectArrayIterator((Object[]) obj);
        }
        if (obj instanceof Enumeration) {
            return new EnumerationIterator((Enumeration) obj);
        }
        if (obj instanceof Map) {
            return ((Map) obj).values().iterator();
        }
        if (obj instanceof NodeList) {
            return new NodeListIterator((NodeList) obj);
        }
        if (obj instanceof Node) {
            return new NodeListIterator((Node) obj);
        }
        if (obj instanceof Dictionary) {
            return new EnumerationIterator(((Dictionary) obj).elements());
        }
        if (obj.getClass().isArray()) {
            return new ArrayIterator(obj);
        }
        try {
            Method method = obj.getClass().getMethod("iterator", null);
            if (Iterator.class.isAssignableFrom(method.getReturnType())) {
                Iterator<?> it = (Iterator) method.invoke(obj, null);
                if (it != null) {
                    return it;
                }
            }
        } catch (ReflectiveOperationException | RuntimeException unused) {
        }
        return singletonIterator(obj);
    }

    public static <E> int indexOf(Iterator<E> it, Predicate<? super E> predicate) {
        Objects.requireNonNull(predicate, "predicate");
        if (it == null) {
            return -1;
        }
        int i = 0;
        while (it.hasNext()) {
            if (predicate.test(it.next())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static boolean isEmpty(Iterator<?> it) {
        return it == null || !it.hasNext();
    }

    public static <E> ResettableIterator<E> loopingIterator(Collection<? extends E> collection) {
        return new LoopingIterator((Collection) Objects.requireNonNull(collection, "collection"));
    }

    public static <E> ResettableListIterator<E> loopingListIterator(List<E> list) {
        return new LoopingListIterator((List) Objects.requireNonNull(list, "list"));
    }

    public static <E> boolean matchesAll(Iterator<E> it, Predicate<? super E> predicate) {
        Objects.requireNonNull(predicate, "predicate");
        if (it == null) {
            return true;
        }
        while (it.hasNext()) {
            if (!predicate.test(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <E> boolean matchesAny(Iterator<E> it, Predicate<? super E> predicate) {
        return indexOf(it, predicate) != -1;
    }

    public static NodeListIterator nodeListIterator(Node node) {
        return new NodeListIterator((Node) Objects.requireNonNull(node, "node"));
    }

    public static NodeListIterator nodeListIterator(NodeList nodeList) {
        return new NodeListIterator((NodeList) Objects.requireNonNull(nodeList, "nodeList"));
    }

    public static <E> Iterator<E> objectGraphIterator(E e, Transformer<? super E, ? extends E> transformer) {
        return new ObjectGraphIterator(e, transformer);
    }

    public static <E> Iterator<E> peekingIterator(Iterator<? extends E> it) {
        return PeekingIterator.peekingIterator(it);
    }

    public static <E> Iterator<E> pushbackIterator(Iterator<? extends E> it) {
        return PushbackIterator.pushbackIterator(it);
    }

    public static <E> ResettableIterator<E> singletonIterator(E e) {
        return new SingletonIterator(e);
    }

    public static <E> ListIterator<E> singletonListIterator(E e) {
        return new SingletonListIterator(e);
    }

    public static int size(Iterator<?> it) {
        int i = 0;
        if (it != null) {
            while (it.hasNext()) {
                it.next();
                i++;
            }
        }
        return i;
    }

    public static <E> SkippingIterator<E> skippingIterator(Iterator<E> it, long j) {
        return new SkippingIterator<>(it, j);
    }

    public static <E> Stream<E> stream(Iterable<E> iterable) {
        return iterable == null ? Stream.empty() : StreamSupport.stream(iterable.spliterator(), false);
    }

    public static <E> Stream<E> stream(Iterator<E> it) {
        return it == null ? Stream.empty() : StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 16), false);
    }

    public static Object[] toArray(Iterator<?> it) {
        Objects.requireNonNull(it, "iterator");
        return toList(it, 100).toArray();
    }

    public static <E> E[] toArray(Iterator<? extends E> it, Class<E> cls) {
        Objects.requireNonNull(it, "iterator");
        Objects.requireNonNull(cls, "arrayClass");
        List list = toList(it, 100);
        return (E[]) list.toArray((Object[]) Array.newInstance((Class<?>) cls, list.size()));
    }

    public static <E> List<E> toList(Iterator<? extends E> it) {
        return toList(it, 10);
    }

    public static <E> List<E> toList(Iterator<? extends E> it, int i) {
        if (i < 1) {
            throw new IllegalArgumentException("Estimated size must be greater than 0");
        }
        return (List) addAll(it, new ArrayList(i));
    }

    public static <E> ListIterator<E> toListIterator(Iterator<? extends E> it) {
        Objects.requireNonNull(it, "iterator");
        return new ListIteratorWrapper(it);
    }

    public static <E> Set<E> toSet(Iterator<? extends E> it) {
        return toSet(it, 10);
    }

    public static <E> Set<E> toSet(Iterator<? extends E> it, int i) {
        if (i < 1) {
            throw new IllegalArgumentException("Estimated size must be greater than 0");
        }
        return (Set) addAll(it, new HashSet(i));
    }

    public static <E> String toString(Iterator<E> it) {
        return toString(it, TransformerUtils.stringValueTransformer(), DEFAULT_TOSTRING_DELIMITER, CollectionUtils.DEFAULT_TOSTRING_PREFIX, CollectionUtils.DEFAULT_TOSTRING_SUFFIX);
    }

    public static <E> String toString(Iterator<E> it, Transformer<? super E, String> transformer) {
        return toString(it, transformer, DEFAULT_TOSTRING_DELIMITER, CollectionUtils.DEFAULT_TOSTRING_PREFIX, CollectionUtils.DEFAULT_TOSTRING_SUFFIX);
    }

    public static <E> String toString(Iterator<E> it, Transformer<? super E, String> transformer, String str, String str2, String str3) {
        Objects.requireNonNull(transformer, "transformer");
        Objects.requireNonNull(str, "delimiter");
        Objects.requireNonNull(str2, "prefix");
        Objects.requireNonNull(str3, "suffix");
        StringBuilder sb = new StringBuilder(str2);
        if (it != null) {
            while (it.hasNext()) {
                sb.append(transformer.apply(it.next()));
                sb.append(str);
            }
            if (sb.length() > str2.length()) {
                sb.setLength(sb.length() - str.length());
            }
        }
        sb.append(str3);
        return sb.toString();
    }

    public static <I, O> Iterator<O> transformedIterator(Iterator<? extends I> it, Transformer<? super I, ? extends O> transformer) {
        Objects.requireNonNull(it, "iterator");
        Objects.requireNonNull(transformer, "transformer");
        return new TransformIterator(it, transformer);
    }

    public static <E> Iterator<E> unmodifiableIterator(Iterator<E> it) {
        return UnmodifiableIterator.unmodifiableIterator(it);
    }

    public static <E> ListIterator<E> unmodifiableListIterator(ListIterator<E> listIterator) {
        return UnmodifiableListIterator.unmodifiableListIterator(listIterator);
    }

    public static <K, V> MapIterator<K, V> unmodifiableMapIterator(MapIterator<K, V> mapIterator) {
        return UnmodifiableMapIterator.unmodifiableMapIterator(mapIterator);
    }

    public static <E> ZippingIterator<E> zippingIterator(Iterator<? extends E>... itArr) {
        return new ZippingIterator<>(itArr);
    }

    public static <E> ZippingIterator<E> zippingIterator(Iterator<? extends E> it, Iterator<? extends E> it2) {
        return new ZippingIterator<>(it, it2);
    }

    public static <E> ZippingIterator<E> zippingIterator(Iterator<? extends E> it, Iterator<? extends E> it2, Iterator<? extends E> it3) {
        return new ZippingIterator<>(it, it2, it3);
    }

    private IteratorUtils() {
    }
}
