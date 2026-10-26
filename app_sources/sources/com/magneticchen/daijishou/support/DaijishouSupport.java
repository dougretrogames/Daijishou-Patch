package com.magneticchen.daijishou.support;

/**
 * Helper used by the reconstructed sources to rethrow checked throwables from
 * methods that cannot declare {@code throws Throwable}.
 */
public final class DaijishouSupport {

    private DaijishouSupport() {
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> RuntimeException sneakyThrow0(Throwable throwable) throws T {
        throw (T) throwable;
    }

    public static RuntimeException sneakyThrow(Throwable throwable) {
        return DaijishouSupport.<RuntimeException>sneakyThrow0(throwable);
    }

    /**
     * Adapts a Kotlin {@code Sequence} to {@code Iterable} so that Java
     * for-each loops can walk it.
     */
    public static <T> Iterable<T> iterable(final kotlin.sequences.Sequence<T> sequence) {
        return new Iterable<T>() {
            @Override
            public java.util.Iterator<T> iterator() {
                return sequence.iterator();
            }
        };
    }
}
