package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/* INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class TableCollectors {
    static <T, R, C, V> Collector<T, ?, ImmutableTable<R, C, V>> toImmutableTable(Function<? super T, ? extends R> rowFunction, Function<? super T, ? extends C> columnFunction, Function<? super T, ? extends V> valueFunction) {
        Preconditions.checkNotNull(rowFunction, "rowFunction");
        Preconditions.checkNotNull(columnFunction, "columnFunction");
        Preconditions.checkNotNull(valueFunction, "valueFunction");
        return Collector.of(new TableCollectors$$ExternalSyntheticLambda8(), new TableCollectors$$ExternalSyntheticLambda9(rowFunction, columnFunction, valueFunction), new TableCollectors$$ExternalSyntheticLambda10(), new TableCollectors$$ExternalSyntheticLambda1(), new Collector.Characteristics[0]);
    }

    static <T, R, C, V> Collector<T, ?, ImmutableTable<R, C, V>> toImmutableTable(Function<? super T, ? extends R> rowFunction, Function<? super T, ? extends C> columnFunction, Function<? super T, ? extends V> valueFunction, BinaryOperator<V> mergeFunction) {
        Preconditions.checkNotNull(rowFunction, "rowFunction");
        Preconditions.checkNotNull(columnFunction, "columnFunction");
        Preconditions.checkNotNull(valueFunction, "valueFunction");
        Preconditions.checkNotNull(mergeFunction, "mergeFunction");
        return Collector.of(new TableCollectors$$ExternalSyntheticLambda4(), new TableCollectors$$ExternalSyntheticLambda5(rowFunction, columnFunction, valueFunction, mergeFunction), new TableCollectors$$ExternalSyntheticLambda6(mergeFunction), new TableCollectors$$ExternalSyntheticLambda7(), new Collector.Characteristics[0]);
    }

    static /* synthetic */ ImmutableTableCollectorState lambda$toImmutableTable$1() {
        return new ImmutableTableCollectorState(null);
    }

    static <T, R, C, V, I extends Table<R, C, V>> Collector<T, ?, I> toTable(Function<? super T, ? extends R> rowFunction, Function<? super T, ? extends C> columnFunction, Function<? super T, ? extends V> valueFunction, Supplier<I> tableSupplier) {
        return toTable(rowFunction, columnFunction, valueFunction, new TableCollectors$$ExternalSyntheticLambda0(), tableSupplier);
    }

    static /* synthetic */ Object lambda$toTable$5(Object obj, Object obj2) {
        throw new IllegalStateException("Conflicting values " + obj + " and " + obj2);
    }

    static <T, R, C, V, I extends Table<R, C, V>> Collector<T, ?, I> toTable(Function<? super T, ? extends R> rowFunction, Function<? super T, ? extends C> columnFunction, Function<? super T, ? extends V> valueFunction, BinaryOperator<V> mergeFunction, Supplier<I> tableSupplier) {
        Preconditions.checkNotNull(rowFunction);
        Preconditions.checkNotNull(columnFunction);
        Preconditions.checkNotNull(valueFunction);
        Preconditions.checkNotNull(mergeFunction);
        Preconditions.checkNotNull(tableSupplier);
        return Collector.of(tableSupplier, new TableCollectors$$ExternalSyntheticLambda2(rowFunction, columnFunction, valueFunction, mergeFunction), new TableCollectors$$ExternalSyntheticLambda3(mergeFunction), new Collector.Characteristics[0]);
    }

    static /* synthetic */ Table lambda$toTable$7(BinaryOperator binaryOperator, Table table, Table table2) {
        for (Table.Cell cell : table2.cellSet()) {
            mergeTables(table, cell.getRowKey(), cell.getColumnKey(), cell.getValue(), binaryOperator);
        }
        return table;
    }

    /* INFO: Access modifiers changed from: private */
    static final class ImmutableTableCollectorState<R, C, V> {
        final List<MutableCell<R, C, V>> insertionOrder;
        final Table<R, C, MutableCell<R, C, V>> table;

        private ImmutableTableCollectorState() {
            this.insertionOrder = new ArrayList();
            this.table = HashBasedTable.create();
        }

        /* synthetic */ ImmutableTableCollectorState(AnonymousClass1 anonymousClass1) {
            this();
        }

        /* INFO: Access modifiers changed from: package-private */
        public void put(R row, C column, V value, BinaryOperator<V> merger) {
            MutableCell<R, C, V> mutableCell = this.table.get(row, column);
            if (mutableCell == null) {
                MutableCell<R, C, V> mutableCell2 = new MutableCell<>(row, column, value);
                this.insertionOrder.add(mutableCell2);
                this.table.put(row, column, mutableCell2);
                return;
            }
            mutableCell.merge(value, merger);
        }

        /* INFO: Access modifiers changed from: package-private */
        public ImmutableTableCollectorState<R, C, V> combine(ImmutableTableCollectorState<R, C, V> other, BinaryOperator<V> merger) {
            for (MutableCell<R, C, V> mutableCell : other.insertionOrder) {
                put(mutableCell.getRowKey(), mutableCell.getColumnKey(), mutableCell.getValue(), merger);
            }
            return this;
        }

        /* INFO: Access modifiers changed from: package-private */
        public ImmutableTable<R, C, V> toTable() {
            return ImmutableTable.copyOf(this.insertionOrder);
        }
    }

    private static final class MutableCell<R, C, V> extends Tables.AbstractCell<R, C, V> {
        private final C column;
        private final R row;
        private V value;

        MutableCell(R r, C c, V v) {
            this.row = (R) Preconditions.checkNotNull(r, "row");
            this.column = (C) Preconditions.checkNotNull(c, "column");
            this.value = (V) Preconditions.checkNotNull(v, "value");
        }

        @Override // com.google.common.collect.Table.Cell
        public R getRowKey() {
            return this.row;
        }

        @Override // com.google.common.collect.Table.Cell
        public C getColumnKey() {
            return this.column;
        }

        @Override // com.google.common.collect.Table.Cell
        public V getValue() {
            return this.value;
        }

        void merge(V v, BinaryOperator<V> binaryOperator) {
            Preconditions.checkNotNull(v, "value");
            this.value = (V) Preconditions.checkNotNull(binaryOperator.apply(this.value, v), "mergeFunction.apply");
        }
    }

    /* INFO: Access modifiers changed from: private */
    /* WARN: Multi-variable type inference failed */
    public static <R, C, V> void mergeTables(Table<R, C, V> table, @ParametricNullness R row, @ParametricNullness C column, V value, BinaryOperator<V> mergeFunction) {
        Preconditions.checkNotNull(value);
        V v = table.get(row, column);
        if (v == null) {
            table.put(row, column, value);
            return;
        }
        Object objApply = mergeFunction.apply(v, value);
        if (objApply == null) {
            table.remove(row, column);
        } else {
            table.put(row, column, objApply);
        }
    }

    private TableCollectors() {
    }
}
