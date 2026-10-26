package org.apache.commons.io.function;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.Spliterators;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiFunction;
import java.util.function.IntFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collector;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.apache.commons.io.IOExceptionList;

/* INFO: loaded from: classes5.dex */
public interface IOStream<T> extends IOBaseStream<T, IOStream<T>, Stream<T>> {
    static /* synthetic */ IOException lambda$forAll$10(Integer num, IOException iOException) {
        return iOException;
    }

    static <T> IOStream<T> adapt(Stream<T> stream) {
        return IOStreamAdapter.adapt(stream);
    }

    static <T> IOStream<T> empty() {
        return IOStreamAdapter.adapt(Stream.empty());
    }

    /* INFO: renamed from: org.apache.commons.io.function.IOStream$1, reason: invalid class name */
    class AnonymousClass1 implements Iterator<T> {
        T t = (T) IOStreams.NONE;
        final /* synthetic */ IOUnaryOperator val$f;
        final /* synthetic */ Object val$seed;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return true;
        }

        AnonymousClass1(Object obj, IOUnaryOperator iOUnaryOperator) {
            this.val$seed = obj;
            this.val$f = iOUnaryOperator;
        }

        @Override // java.util.Iterator
        public T next() throws NoSuchElementException {
            try {
                T tApply = this.t == IOStreams.NONE ? (T) this.val$seed : this.val$f.apply(this.t);
                this.t = tApply;
                return tApply;
            } catch (IOException e) {
                NoSuchElementException noSuchElementException = new NoSuchElementException();
                noSuchElementException.initCause(e);
                throw noSuchElementException;
            }
        }
    }

    static <T> IOStream<T> iterate(T t, IOUnaryOperator<T> iOUnaryOperator) {
        Objects.requireNonNull(iOUnaryOperator);
        return adapt(StreamSupport.stream(Spliterators.spliteratorUnknownSize(new AnonymousClass1(t, iOUnaryOperator), 1040), false));
    }

    static <T> IOStream<T> of(Iterable<T> iterable) {
        return iterable == null ? empty() : adapt(StreamSupport.stream(iterable.spliterator(), false));
    }

    @SafeVarargs
    static <T> IOStream<T> of(T... tArr) {
        return (tArr == null || tArr.length == 0) ? empty() : adapt(Arrays.stream(tArr));
    }

    static <T> IOStream<T> of(T t) {
        return adapt(Stream.of(t));
    }

    default boolean allMatch(IOPredicate<? super T> iOPredicate) throws IOException {
        return unwrap().allMatch(new IOStream$$ExternalSyntheticLambda10(iOPredicate));
    }

    default boolean anyMatch(IOPredicate<? super T> iOPredicate) throws IOException {
        return unwrap().anyMatch(new IOStream$$ExternalSyntheticLambda9(iOPredicate));
    }

    default <R, A> R collect(Collector<? super T, A, R> collector) {
        return (R) unwrap().collect(collector);
    }

    default <R> R collect(IOSupplier<R> iOSupplier, IOBiConsumer<R, ? super T> iOBiConsumer, IOBiConsumer<R, R> iOBiConsumer2) throws IOException {
        return (R) unwrap().collect(new IOStream$$ExternalSyntheticLambda22(iOSupplier), new IOStream$$ExternalSyntheticLambda23(iOBiConsumer), new IOStream$$ExternalSyntheticLambda1(iOBiConsumer2));
    }

    default long count() {
        return unwrap().count();
    }

    default IOStream<T> distinct() {
        return adapt(unwrap().distinct());
    }

    default IOStream<T> filter(IOPredicate<? super T> iOPredicate) throws IOException {
        return adapt(unwrap().filter(new IOStream$$ExternalSyntheticLambda6(iOPredicate)));
    }

    default Optional<T> findAny() {
        return unwrap().findAny();
    }

    default Optional<T> findFirst() {
        return unwrap().findFirst();
    }

    default <R> IOStream<R> flatMap(IOFunction<? super T, ? extends IOStream<? extends R>> iOFunction) throws IOException {
        return adapt(unwrap().flatMap(new IOStream$$ExternalSyntheticLambda3(iOFunction)));
    }

    static /* synthetic */ DoubleStream lambda$flatMapToDouble$7(IOFunction iOFunction, Object obj) {
        return (DoubleStream) Erase.apply(iOFunction, obj);
    }

    default DoubleStream flatMapToDouble(IOFunction<? super T, ? extends DoubleStream> iOFunction) throws IOException {
        return unwrap().flatMapToDouble(new IOStream$$ExternalSyntheticLambda14(iOFunction));
    }

    static /* synthetic */ IntStream lambda$flatMapToInt$8(IOFunction iOFunction, Object obj) {
        return (IntStream) Erase.apply(iOFunction, obj);
    }

    default IntStream flatMapToInt(IOFunction<? super T, ? extends IntStream> iOFunction) throws IOException {
        return unwrap().flatMapToInt(new IOStream$$ExternalSyntheticLambda11(iOFunction));
    }

    static /* synthetic */ LongStream lambda$flatMapToLong$9(IOFunction iOFunction, Object obj) {
        return (LongStream) Erase.apply(iOFunction, obj);
    }

    default LongStream flatMapToLong(IOFunction<? super T, ? extends LongStream> iOFunction) throws IOException {
        return unwrap().flatMapToLong(new IOStream$$ExternalSyntheticLambda12(iOFunction));
    }

    default void forAll(IOConsumer<T> iOConsumer) throws IOExceptionList {
        forAll(iOConsumer, new IOStream$$ExternalSyntheticLambda5());
    }

    default void forAll(IOConsumer<T> iOConsumer, BiFunction<Integer, IOException, IOException> biFunction) throws IOExceptionList {
        AtomicReference atomicReference = new AtomicReference();
        AtomicInteger atomicInteger = new AtomicInteger();
        unwrap().forEach(new IOStream$$ExternalSyntheticLambda18(IOStreams.toIOConsumer(iOConsumer), atomicReference, biFunction, atomicInteger));
        IOExceptionList.checkEmpty((List) atomicReference.get(), null);
    }

    static /* synthetic */ void lambda$forAll$11(IOConsumer iOConsumer, AtomicReference atomicReference, BiFunction biFunction, AtomicInteger atomicInteger, Object obj) {
        try {
            iOConsumer.accept(obj);
        } catch (IOException e) {
            if (atomicReference.get() == null) {
                atomicReference.set(new ArrayList());
            }
            if (biFunction != null) {
                ((List) atomicReference.get()).add((IOException) biFunction.apply(Integer.valueOf(atomicInteger.get()), e));
            }
        }
        atomicInteger.incrementAndGet();
    }

    default void forEach(IOConsumer<? super T> iOConsumer) throws IOException {
        unwrap().forEach(new IOStream$$ExternalSyntheticLambda17(iOConsumer));
    }

    default void forEachOrdered(IOConsumer<? super T> iOConsumer) throws IOException {
        unwrap().forEachOrdered(new IOStream$$ExternalSyntheticLambda19(iOConsumer));
    }

    default IOStream<T> limit(long j) {
        return adapt(unwrap().limit(j));
    }

    default <R> IOStream<R> map(IOFunction<? super T, ? extends R> iOFunction) throws IOException {
        return adapt(unwrap().map(new IOStream$$ExternalSyntheticLambda2(iOFunction)));
    }

    default DoubleStream mapToDouble(ToDoubleFunction<? super T> toDoubleFunction) {
        return unwrap().mapToDouble(toDoubleFunction);
    }

    default IntStream mapToInt(ToIntFunction<? super T> toIntFunction) {
        return unwrap().mapToInt(toIntFunction);
    }

    default LongStream mapToLong(ToLongFunction<? super T> toLongFunction) {
        return unwrap().mapToLong(toLongFunction);
    }

    default Optional<T> max(IOComparator<? super T> iOComparator) throws IOException {
        return unwrap().max(new IOStream$$ExternalSyntheticLambda21(iOComparator));
    }

    default Optional<T> min(IOComparator<? super T> iOComparator) throws IOException {
        return unwrap().min(new IOStream$$ExternalSyntheticLambda20(iOComparator));
    }

    default boolean noneMatch(IOPredicate<? super T> iOPredicate) throws IOException {
        return unwrap().noneMatch(new IOStream$$ExternalSyntheticLambda16(iOPredicate));
    }

    default IOStream<T> peek(IOConsumer<? super T> iOConsumer) throws IOException {
        return adapt(unwrap().peek(new IOStream$$ExternalSyntheticLambda4(iOConsumer)));
    }

    default Optional<T> reduce(IOBinaryOperator<T> iOBinaryOperator) throws IOException {
        return unwrap().reduce(new IOStream$$ExternalSyntheticLambda0(iOBinaryOperator));
    }

    default T reduce(T t, IOBinaryOperator<T> iOBinaryOperator) throws IOException {
        return unwrap().reduce(t, new IOStream$$ExternalSyntheticLambda13(iOBinaryOperator));
    }

    default <U> U reduce(U u, IOBiFunction<U, ? super T, U> iOBiFunction, IOBinaryOperator<U> iOBinaryOperator) throws IOException {
        return (U) unwrap().reduce(u, new IOStream$$ExternalSyntheticLambda7(iOBiFunction), new IOStream$$ExternalSyntheticLambda8(iOBinaryOperator));
    }

    default IOStream<T> skip(long j) {
        return adapt(unwrap().skip(j));
    }

    default IOStream<T> sorted() {
        return adapt(unwrap().sorted());
    }

    default IOStream<T> sorted(IOComparator<? super T> iOComparator) throws IOException {
        return adapt(unwrap().sorted(new IOStream$$ExternalSyntheticLambda15(iOComparator)));
    }

    default Object[] toArray() {
        return unwrap().toArray();
    }

    default <A> A[] toArray(IntFunction<A[]> intFunction) {
        return (A[]) unwrap().toArray(intFunction);
    }
}
