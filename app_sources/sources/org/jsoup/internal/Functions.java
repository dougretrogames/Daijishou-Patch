package org.jsoup.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/* INFO: loaded from: classes5.dex */
public final class Functions {
    private static final Function ListFunction = new Functions$$ExternalSyntheticLambda0();
    private static final Function SetFunction = new Functions$$ExternalSyntheticLambda1();
    private static final Function MapFunction = new Functions$$ExternalSyntheticLambda2();
    private static final Function IdentityMapFunction = new Functions$$ExternalSyntheticLambda3();

    static /* synthetic */ Object lambda$static$0(Object obj) {
        return new ArrayList();
    }

    static /* synthetic */ Object lambda$static$1(Object obj) {
        return new HashSet();
    }

    static /* synthetic */ Object lambda$static$2(Object obj) {
        return new HashMap();
    }

    static /* synthetic */ Object lambda$static$3(Object obj) {
        return new IdentityHashMap();
    }

    private Functions() {
    }

    public static <T, U> Function<T, List<U>> listFunction() {
        return ListFunction;
    }

    public static <T, U> Function<T, Set<U>> setFunction() {
        return SetFunction;
    }

    public static <T, K, V> Function<T, Map<K, V>> mapFunction() {
        return MapFunction;
    }

    public static <T, K, V> Function<T, IdentityHashMap<K, V>> identityMapFunction() {
        return IdentityMapFunction;
    }
}
