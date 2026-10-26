package org.apache.commons.io.function;

import java.io.IOException;
import java.util.function.BiFunction;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.apache.commons.io.IOExceptionList;

/* INFO: loaded from: classes5.dex */
final class IOStreams {
    static final Object NONE = new Object();

    static /* synthetic */ IOException lambda$forAll$0(Integer num, IOException iOException) {
        return iOException;
    }

    static <T> void forAll(Stream<T> stream, IOConsumer<T> iOConsumer) throws IOExceptionList {
        forAll(stream, iOConsumer, new IOStreams$$ExternalSyntheticLambda1());
    }

    static <T> void forAll(Stream<T> stream, IOConsumer<T> iOConsumer, BiFunction<Integer, IOException, IOException> biFunction) throws IOExceptionList {
        IOStream.adapt(stream).forAll(iOConsumer, new IOConsumer$$ExternalSyntheticLambda1());
    }

    static <T> void forEach(Stream<T> stream, IOConsumer<T> iOConsumer) throws IOException {
        of(stream).forEach(new IOStreams$$ExternalSyntheticLambda0(toIOConsumer(iOConsumer)));
    }

    static <T> Stream<T> of(Iterable<T> iterable) {
        return iterable == null ? Stream.empty() : StreamSupport.stream(iterable.spliterator(), false);
    }

    static <T> Stream<T> of(Stream<T> stream) {
        return stream == null ? Stream.empty() : stream;
    }

    @SafeVarargs
    static <T> Stream<T> of(T... tArr) {
        return tArr == null ? Stream.empty() : Stream.of((Object[]) tArr);
    }

    static <T> IOConsumer<T> toIOConsumer(IOConsumer<T> iOConsumer) {
        return iOConsumer != null ? iOConsumer : IOConsumer.noop();
    }

    private IOStreams() {
    }
}
