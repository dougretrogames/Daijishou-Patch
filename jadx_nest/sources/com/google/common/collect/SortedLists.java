package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class SortedLists {
    private SortedLists() {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    static abstract class KeyPresentBehavior {
        public static final KeyPresentBehavior ANY_PRESENT = new AnonymousClass1("ANY_PRESENT", 0);
        public static final KeyPresentBehavior LAST_PRESENT = new AnonymousClass2("LAST_PRESENT", 1);
        public static final KeyPresentBehavior FIRST_PRESENT = new AnonymousClass3("FIRST_PRESENT", 2);
        public static final KeyPresentBehavior FIRST_AFTER = new AnonymousClass4("FIRST_AFTER", 3);
        public static final KeyPresentBehavior LAST_BEFORE = new AnonymousClass5("LAST_BEFORE", 4);
        private static final /* synthetic */ KeyPresentBehavior[] $VALUES = $values();

        abstract <E> int resultIndex(Comparator<? super E> comparator, @ParametricNullness E key, List<? extends E> list, int foundIndex);

        private static /* synthetic */ KeyPresentBehavior[] $values() {
            return new KeyPresentBehavior[]{ANY_PRESENT, LAST_PRESENT, FIRST_PRESENT, FIRST_AFTER, LAST_BEFORE};
        }

        private KeyPresentBehavior(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        /* synthetic */ KeyPresentBehavior(String str, int i, AnonymousClass1 anonymousClass1) {
            this(str, i);
        }

        public static KeyPresentBehavior valueOf(String name) {
            return (KeyPresentBehavior) Enum.valueOf(KeyPresentBehavior.class, name);
        }

        public static KeyPresentBehavior[] values() {
            return (KeyPresentBehavior[]) $VALUES.clone();
        }

        /* JADX INFO: renamed from: com.google.common.collect.SortedLists$KeyPresentBehavior$1, reason: invalid class name */
        final enum AnonymousClass1 extends KeyPresentBehavior {
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            <E> int resultIndex(Comparator<? super E> comparator, @ParametricNullness E key, List<? extends E> list, int foundIndex) {
                return foundIndex;
            }

            AnonymousClass1(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }
        }

        /* JADX INFO: renamed from: com.google.common.collect.SortedLists$KeyPresentBehavior$2, reason: invalid class name */
        final enum AnonymousClass2 extends KeyPresentBehavior {
            AnonymousClass2(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            <E> int resultIndex(Comparator<? super E> comparator, @ParametricNullness E e, List<? extends E> list, int i) {
                int size = list.size() - 1;
                while (i < size) {
                    int i2 = ((i + size) + 1) >>> 1;
                    if (comparator.compare(list.get(i2), e) > 0) {
                        size = i2 - 1;
                    } else {
                        i = i2;
                    }
                }
                return i;
            }
        }

        /* JADX INFO: renamed from: com.google.common.collect.SortedLists$KeyPresentBehavior$3, reason: invalid class name */
        final enum AnonymousClass3 extends KeyPresentBehavior {
            AnonymousClass3(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            <E> int resultIndex(Comparator<? super E> comparator, @ParametricNullness E e, List<? extends E> list, int i) {
                int i2 = 0;
                while (i2 < i) {
                    int i3 = (i2 + i) >>> 1;
                    if (comparator.compare(list.get(i3), e) < 0) {
                        i2 = i3 + 1;
                    } else {
                        i = i3;
                    }
                }
                return i2;
            }
        }

        /* JADX INFO: renamed from: com.google.common.collect.SortedLists$KeyPresentBehavior$4, reason: invalid class name */
        final enum AnonymousClass4 extends KeyPresentBehavior {
            AnonymousClass4(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, @ParametricNullness E key, List<? extends E> list, int foundIndex) {
                return LAST_PRESENT.resultIndex(comparator, key, list, foundIndex) + 1;
            }
        }

        /* JADX INFO: renamed from: com.google.common.collect.SortedLists$KeyPresentBehavior$5, reason: invalid class name */
        final enum AnonymousClass5 extends KeyPresentBehavior {
            AnonymousClass5(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, @ParametricNullness E key, List<? extends E> list, int foundIndex) {
                return FIRST_PRESENT.resultIndex(comparator, key, list, foundIndex) - 1;
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    static abstract class KeyAbsentBehavior {
        public static final KeyAbsentBehavior NEXT_LOWER = new AnonymousClass1("NEXT_LOWER", 0);
        public static final KeyAbsentBehavior NEXT_HIGHER = new AnonymousClass2("NEXT_HIGHER", 1);
        public static final KeyAbsentBehavior INVERTED_INSERTION_INDEX = new AnonymousClass3("INVERTED_INSERTION_INDEX", 2);
        private static final /* synthetic */ KeyAbsentBehavior[] $VALUES = $values();

        abstract int resultIndex(int higherIndex);

        private static /* synthetic */ KeyAbsentBehavior[] $values() {
            return new KeyAbsentBehavior[]{NEXT_LOWER, NEXT_HIGHER, INVERTED_INSERTION_INDEX};
        }

        private KeyAbsentBehavior(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        /* synthetic */ KeyAbsentBehavior(String str, int i, AnonymousClass1 anonymousClass1) {
            this(str, i);
        }

        public static KeyAbsentBehavior valueOf(String name) {
            return (KeyAbsentBehavior) Enum.valueOf(KeyAbsentBehavior.class, name);
        }

        public static KeyAbsentBehavior[] values() {
            return (KeyAbsentBehavior[]) $VALUES.clone();
        }

        /* JADX INFO: renamed from: com.google.common.collect.SortedLists$KeyAbsentBehavior$1, reason: invalid class name */
        final enum AnonymousClass1 extends KeyAbsentBehavior {
            @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
            int resultIndex(int higherIndex) {
                return higherIndex - 1;
            }

            AnonymousClass1(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }
        }

        /* JADX INFO: renamed from: com.google.common.collect.SortedLists$KeyAbsentBehavior$2, reason: invalid class name */
        final enum AnonymousClass2 extends KeyAbsentBehavior {
            @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
            public int resultIndex(int higherIndex) {
                return higherIndex;
            }

            AnonymousClass2(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }
        }

        /* JADX INFO: renamed from: com.google.common.collect.SortedLists$KeyAbsentBehavior$3, reason: invalid class name */
        final enum AnonymousClass3 extends KeyAbsentBehavior {
            @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
            public int resultIndex(int higherIndex) {
                return ~higherIndex;
            }

            AnonymousClass3(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }
        }
    }

    public static <E extends Comparable> int binarySearch(List<? extends E> list, E e, KeyPresentBehavior presentBehavior, KeyAbsentBehavior absentBehavior) {
        Preconditions.checkNotNull(e);
        return binarySearch(list, e, Ordering.natural(), presentBehavior, absentBehavior);
    }

    public static <E, K extends Comparable> int binarySearch(List<E> list, Function<? super E, K> keyFunction, K key, KeyPresentBehavior presentBehavior, KeyAbsentBehavior absentBehavior) {
        Preconditions.checkNotNull(key);
        return binarySearch(list, keyFunction, key, Ordering.natural(), presentBehavior, absentBehavior);
    }

    public static <E, K> int binarySearch(List<E> list, Function<? super E, K> keyFunction, @ParametricNullness K key, Comparator<? super K> keyComparator, KeyPresentBehavior presentBehavior, KeyAbsentBehavior absentBehavior) {
        return binarySearch((List<? extends K>) Lists.transform(list, keyFunction), key, keyComparator, presentBehavior, absentBehavior);
    }

    public static <E> int binarySearch(List<? extends E> list, @ParametricNullness E e, Comparator<? super E> comparator, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        Preconditions.checkNotNull(comparator);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(keyPresentBehavior);
        Preconditions.checkNotNull(keyAbsentBehavior);
        if (!(list instanceof RandomAccess)) {
            list = Lists.newArrayList(list);
        }
        int size = list.size() - 1;
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) >>> 1;
            int iCompare = comparator.compare(e, list.get(i2));
            if (iCompare < 0) {
                size = i2 - 1;
            } else {
                if (iCompare <= 0) {
                    return i + keyPresentBehavior.resultIndex(comparator, e, list.subList(i, size + 1), i2 - i);
                }
                i = i2 + 1;
            }
        }
        return keyAbsentBehavior.resultIndex(i);
    }
}
