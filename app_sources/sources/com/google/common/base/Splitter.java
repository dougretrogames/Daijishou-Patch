package com.google.common.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.annotation.CheckForNull;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class Splitter {
    private final int limit;
    private final boolean omitEmptyStrings;
    private final Strategy strategy;
    private final CharMatcher trimmer;

    private interface Strategy {
        Iterator<String> iterator(Splitter splitter, CharSequence toSplit);
    }

    private Splitter(Strategy strategy) {
        this(strategy, false, CharMatcher.none(), Integer.MAX_VALUE);
    }

    private Splitter(Strategy strategy, boolean omitEmptyStrings, CharMatcher trimmer, int limit) {
        this.strategy = strategy;
        this.omitEmptyStrings = omitEmptyStrings;
        this.trimmer = trimmer;
        this.limit = limit;
    }

    public static Splitter on(char separator) {
        return on(CharMatcher.is(separator));
    }

    public static Splitter on(final CharMatcher separatorMatcher) {
        Preconditions.checkNotNull(separatorMatcher);
        return new Splitter(new AnonymousClass1(separatorMatcher));
    }

    /* INFO: renamed from: com.google.common.base.Splitter$1, reason: invalid class name */
    class AnonymousClass1 implements Strategy {
        final /* synthetic */ CharMatcher val$separatorMatcher;

        AnonymousClass1(final CharMatcher val$separatorMatcher) {
            this.val$separatorMatcher = val$separatorMatcher;
        }

        /* INFO: renamed from: com.google.common.base.Splitter$1$1, reason: invalid class name and collision with other inner class name */
        class C00361 extends SplittingIterator {
            @Override // com.google.common.base.Splitter.SplittingIterator
            int separatorEnd(int separatorPosition) {
                return separatorPosition + 1;
            }

            C00361(Splitter splitter, CharSequence toSplit) {
                super(splitter, toSplit);
            }

            @Override // com.google.common.base.Splitter.SplittingIterator
            int separatorStart(int start) {
                return AnonymousClass1.this.val$separatorMatcher.indexIn(this.toSplit, start);
            }
        }

        @Override // com.google.common.base.Splitter.Strategy
        public SplittingIterator iterator(Splitter splitter, final CharSequence toSplit) {
            return new C00361(splitter, toSplit);
        }
    }

    public static Splitter on(final String separator) {
        Preconditions.checkArgument(separator.length() != 0, "The separator may not be the empty string.");
        if (separator.length() == 1) {
            return on(separator.charAt(0));
        }
        return new Splitter(new AnonymousClass2(separator));
    }

    /* INFO: renamed from: com.google.common.base.Splitter$2, reason: invalid class name */
    class AnonymousClass2 implements Strategy {
        final /* synthetic */ String val$separator;

        AnonymousClass2(final String val$separator) {
            this.val$separator = val$separator;
        }

        /* INFO: renamed from: com.google.common.base.Splitter$2$1, reason: invalid class name */
        class AnonymousClass1 extends SplittingIterator {
            AnonymousClass1(Splitter splitter, CharSequence toSplit) {
                super(splitter, toSplit);
            }

            @Override // com.google.common.base.Splitter.SplittingIterator
            public int separatorStart(int start) {
                int length = AnonymousClass2.this.val$separator.length();
                int length2 = this.toSplit.length() - length;
                while (start <= length2) {
                    for (int i = 0; i < length; i++) {
                        if (this.toSplit.charAt(i + start) != AnonymousClass2.this.val$separator.charAt(i)) {
                            start++;
                        }
                    }
                    return start;
                }
                return -1;
            }

            @Override // com.google.common.base.Splitter.SplittingIterator
            public int separatorEnd(int separatorPosition) {
                return separatorPosition + AnonymousClass2.this.val$separator.length();
            }
        }

        @Override // com.google.common.base.Splitter.Strategy
        public SplittingIterator iterator(Splitter splitter, CharSequence toSplit) {
            return new AnonymousClass1(splitter, toSplit);
        }
    }

    public static Splitter on(Pattern separatorPattern) {
        return onPatternInternal(new JdkPattern(separatorPattern));
    }

    static Splitter onPatternInternal(final CommonPattern separatorPattern) {
        Preconditions.checkArgument(!separatorPattern.matcher("").matches(), "The pattern may not match the empty string: %s", separatorPattern);
        return new Splitter(new AnonymousClass3(separatorPattern));
    }

    /* INFO: renamed from: com.google.common.base.Splitter$3, reason: invalid class name */
    class AnonymousClass3 implements Strategy {
        final /* synthetic */ CommonPattern val$separatorPattern;

        AnonymousClass3(final CommonPattern val$separatorPattern) {
            this.val$separatorPattern = val$separatorPattern;
        }

        /* INFO: renamed from: com.google.common.base.Splitter$3$1, reason: invalid class name */
        class AnonymousClass1 extends SplittingIterator {
            final /* synthetic */ CommonMatcher val$matcher;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(final AnonymousClass3 this$0, Splitter splitter, CharSequence toSplit, final CommonMatcher val$matcher) {
                super(splitter, toSplit);
                this.val$matcher = val$matcher;
            }

            @Override // com.google.common.base.Splitter.SplittingIterator
            public int separatorStart(int start) {
                if (this.val$matcher.find(start)) {
                    return this.val$matcher.start();
                }
                return -1;
            }

            @Override // com.google.common.base.Splitter.SplittingIterator
            public int separatorEnd(int separatorPosition) {
                return this.val$matcher.end();
            }
        }

        @Override // com.google.common.base.Splitter.Strategy
        public SplittingIterator iterator(final Splitter splitter, CharSequence toSplit) {
            return new AnonymousClass1(this, splitter, toSplit, this.val$separatorPattern.matcher(toSplit));
        }
    }

    public static Splitter onPattern(String separatorPattern) {
        return onPatternInternal(Platform.compilePattern(separatorPattern));
    }

    public static Splitter fixedLength(final int length) {
        Preconditions.checkArgument(length > 0, "The length may not be less than 1");
        return new Splitter(new AnonymousClass4(length));
    }

    /* INFO: renamed from: com.google.common.base.Splitter$4, reason: invalid class name */
    class AnonymousClass4 implements Strategy {
        final /* synthetic */ int val$length;

        AnonymousClass4(final int val$length) {
            this.val$length = val$length;
        }

        /* INFO: renamed from: com.google.common.base.Splitter$4$1, reason: invalid class name */
        class AnonymousClass1 extends SplittingIterator {
            @Override // com.google.common.base.Splitter.SplittingIterator
            public int separatorEnd(int separatorPosition) {
                return separatorPosition;
            }

            AnonymousClass1(Splitter splitter, CharSequence toSplit) {
                super(splitter, toSplit);
            }

            @Override // com.google.common.base.Splitter.SplittingIterator
            public int separatorStart(int start) {
                int i = start + AnonymousClass4.this.val$length;
                if (i < this.toSplit.length()) {
                    return i;
                }
                return -1;
            }
        }

        @Override // com.google.common.base.Splitter.Strategy
        public SplittingIterator iterator(final Splitter splitter, CharSequence toSplit) {
            return new AnonymousClass1(splitter, toSplit);
        }
    }

    public Splitter omitEmptyStrings() {
        return new Splitter(this.strategy, true, this.trimmer, this.limit);
    }

    public Splitter limit(int maxItems) {
        Preconditions.checkArgument(maxItems > 0, "must be greater than zero: %s", maxItems);
        return new Splitter(this.strategy, this.omitEmptyStrings, this.trimmer, maxItems);
    }

    public Splitter trimResults() {
        return trimResults(CharMatcher.whitespace());
    }

    public Splitter trimResults(CharMatcher trimmer) {
        Preconditions.checkNotNull(trimmer);
        return new Splitter(this.strategy, this.omitEmptyStrings, trimmer, this.limit);
    }

    public Iterable<String> split(final CharSequence sequence) {
        Preconditions.checkNotNull(sequence);
        return new AnonymousClass5(sequence);
    }

    /* INFO: renamed from: com.google.common.base.Splitter$5, reason: invalid class name */
    class AnonymousClass5 implements Iterable<String> {
        final /* synthetic */ CharSequence val$sequence;

        AnonymousClass5(final CharSequence val$sequence) {
            this.val$sequence = val$sequence;
        }

        @Override // java.lang.Iterable
        public Iterator<String> iterator() {
            return Splitter.this.splittingIterator(this.val$sequence);
        }

        public String toString() {
            return Joiner.on(", ").appendTo(new StringBuilder().append(AbstractJsonLexerKt.BEGIN_LIST), (Iterable<? extends Object>) this).append(AbstractJsonLexerKt.END_LIST).toString();
        }
    }

    /* INFO: Access modifiers changed from: private */
    public Iterator<String> splittingIterator(CharSequence sequence) {
        return this.strategy.iterator(this, sequence);
    }

    public List<String> splitToList(CharSequence sequence) {
        Preconditions.checkNotNull(sequence);
        Iterator<String> itSplittingIterator = splittingIterator(sequence);
        ArrayList arrayList = new ArrayList();
        while (itSplittingIterator.hasNext()) {
            arrayList.add(itSplittingIterator.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public MapSplitter withKeyValueSeparator(String separator) {
        return withKeyValueSeparator(on(separator));
    }

    public MapSplitter withKeyValueSeparator(char separator) {
        return withKeyValueSeparator(on(separator));
    }

    public MapSplitter withKeyValueSeparator(Splitter keyValueSplitter) {
        return new MapSplitter(this, keyValueSplitter, null);
    }

    public static final class MapSplitter {
        private static final String INVALID_ENTRY_MESSAGE = "Chunk [%s] is not a valid entry";
        private final Splitter entrySplitter;
        private final Splitter outerSplitter;

        /* synthetic */ MapSplitter(Splitter splitter, Splitter splitter2, AnonymousClass1 anonymousClass1) {
            this(splitter, splitter2);
        }

        private MapSplitter(Splitter outerSplitter, Splitter entrySplitter) {
            this.outerSplitter = outerSplitter;
            this.entrySplitter = (Splitter) Preconditions.checkNotNull(entrySplitter);
        }

        public Map<String, String> split(CharSequence sequence) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String str : this.outerSplitter.split(sequence)) {
                Iterator itSplittingIterator = this.entrySplitter.splittingIterator(str);
                Preconditions.checkArgument(itSplittingIterator.hasNext(), INVALID_ENTRY_MESSAGE, str);
                String str2 = (String) itSplittingIterator.next();
                Preconditions.checkArgument(!linkedHashMap.containsKey(str2), "Duplicate key [%s] found.", str2);
                Preconditions.checkArgument(itSplittingIterator.hasNext(), INVALID_ENTRY_MESSAGE, str);
                linkedHashMap.put(str2, (String) itSplittingIterator.next());
                Preconditions.checkArgument(!itSplittingIterator.hasNext(), INVALID_ENTRY_MESSAGE, str);
            }
            return Collections.unmodifiableMap(linkedHashMap);
        }
    }

    private static abstract class SplittingIterator extends AbstractIterator<String> {
        int limit;
        int offset = 0;
        final boolean omitEmptyStrings;
        final CharSequence toSplit;
        final CharMatcher trimmer;

        abstract int separatorEnd(int separatorPosition);

        abstract int separatorStart(int start);

        protected SplittingIterator(Splitter splitter, CharSequence toSplit) {
            this.trimmer = splitter.trimmer;
            this.omitEmptyStrings = splitter.omitEmptyStrings;
            this.limit = splitter.limit;
            this.toSplit = toSplit;
        }

        /* INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.AbstractIterator
        @CheckForNull
        public String computeNext() {
            int i = this.offset;
            while (true) {
                int i2 = this.offset;
                if (i2 != -1) {
                    int iSeparatorStart = separatorStart(i2);
                    if (iSeparatorStart == -1) {
                        iSeparatorStart = this.toSplit.length();
                        this.offset = -1;
                    } else {
                        this.offset = separatorEnd(iSeparatorStart);
                    }
                    int i3 = this.offset;
                    if (i3 == i) {
                        int i4 = i3 + 1;
                        this.offset = i4;
                        if (i4 > this.toSplit.length()) {
                            this.offset = -1;
                        }
                    } else {
                        while (i < iSeparatorStart && this.trimmer.matches(this.toSplit.charAt(i))) {
                            i++;
                        }
                        while (iSeparatorStart > i && this.trimmer.matches(this.toSplit.charAt(iSeparatorStart - 1))) {
                            iSeparatorStart--;
                        }
                        if (this.omitEmptyStrings && i == iSeparatorStart) {
                            i = this.offset;
                        } else {
                            int i5 = this.limit;
                            if (i5 == 1) {
                                iSeparatorStart = this.toSplit.length();
                                this.offset = -1;
                                while (iSeparatorStart > i && this.trimmer.matches(this.toSplit.charAt(iSeparatorStart - 1))) {
                                    iSeparatorStart--;
                                }
                            } else {
                                this.limit = i5 - 1;
                            }
                            return this.toSplit.subSequence(i, iSeparatorStart).toString();
                        }
                    }
                } else {
                    return endOfData();
                }
            }
        }
    }
}
