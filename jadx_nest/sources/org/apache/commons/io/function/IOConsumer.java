package org.apache.commons.io.function;

import java.io.IOException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Stream;
import org.apache.commons.io.IOExceptionList;

/* JADX INFO: loaded from: classes5.dex */
@FunctionalInterface
public interface IOConsumer<T> {
    public static final IOConsumer<?> NOOP_IO_CONSUMER = new IOConsumer$$ExternalSyntheticLambda3();

    static /* synthetic */ void lambda$static$0(Object obj) throws IOException {
    }

    void accept(T t) throws IOException;

    static <T> void forAll(IOConsumer<T> iOConsumer, Iterable<T> iterable) throws IOExceptionList {
        IOStreams.forAll(IOStreams.of(iterable), iOConsumer);
    }

    static <T> void forAll(IOConsumer<T> iOConsumer, Stream<T> stream) throws IOExceptionList {
        IOStreams.forAll(stream, iOConsumer, new IOConsumer$$ExternalSyntheticLambda1());
    }

    @SafeVarargs
    static <T> void forAll(IOConsumer<T> iOConsumer, T... tArr) throws IOExceptionList {
        IOStreams.forAll(IOStreams.of(tArr), iOConsumer);
    }

    static <T> void forEach(Iterable<T> iterable, IOConsumer<T> iOConsumer) throws IOException {
        IOStreams.forEach(IOStreams.of(iterable), iOConsumer);
    }

    static <T> void forEach(Stream<T> stream, IOConsumer<T> iOConsumer) throws IOException {
        IOStreams.forEach(stream, iOConsumer);
    }

    static <T> void forEach(T[] tArr, IOConsumer<T> iOConsumer) throws IOException {
        IOStreams.forEach(IOStreams.of(tArr), iOConsumer);
    }

    static <T> IOConsumer<T> noop() {
        return (IOConsumer<T>) NOOP_IO_CONSUMER;
    }

    default IOConsumer<T> andThen(IOConsumer<? super T> iOConsumer) {
        Objects.requireNonNull(iOConsumer, "after");
        return new IOConsumer$$ExternalSyntheticLambda2(this, iOConsumer);
    }

    static /* synthetic */ void lambda$andThen$1(IOConsumer _this, IOConsumer iOConsumer, Object obj) throws IOException {
        _this.accept(obj);
        iOConsumer.accept(obj);
    }

    default Consumer<T> asConsumer() {
        return new IOConsumer$$ExternalSyntheticLambda0(this);
    }
}
