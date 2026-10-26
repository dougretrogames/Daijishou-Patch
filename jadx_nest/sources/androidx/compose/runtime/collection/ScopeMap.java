package androidx.compose.runtime.collection;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMapKt;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: ScopeMap.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\rJ\u0011\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0086\u0002J4\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\r0\u0017H\u0086\bJ\u001b\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010\u001dJ.\u0010\u001e\u001a\u00020\r2#\b\u0004\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00130\u0017H\u0086\bR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006 "}, d2 = {"Landroidx/compose/runtime/collection/ScopeMap;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "map", "Landroidx/collection/MutableScatterMap;", "getMap", "()Landroidx/collection/MutableScatterMap;", "size", "", "getSize", "()I", "add", "", "key", "scope", "(Ljava/lang/Object;Ljava/lang/Object;)V", "clear", "contains", "", "element", "forEachScopeOf", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "remove", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "removeScope", "(Ljava/lang/Object;)V", "removeScopeIf", "predicate", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ScopeMap<T> {
    public static final int $stable = 8;
    private final MutableScatterMap<Object, Object> map = ScatterMapKt.mutableScatterMapOf();

    public final MutableScatterMap<Object, Object> getMap() {
        return this.map;
    }

    public final int getSize() {
        return this.map.get_size();
    }

    public final void add(Object key, T scope) {
        MutableScatterMap<Object, Object> mutableScatterMap = this.map;
        int iFindInsertIndex = mutableScatterMap.findInsertIndex(key);
        boolean z = iFindInsertIndex < 0;
        Object obj = z ? null : mutableScatterMap.values[iFindInsertIndex];
        if (obj != null) {
            if (obj instanceof MutableScatterSet) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<T of androidx.compose.runtime.collection.ScopeMap.add$lambda$0>");
                ((MutableScatterSet) obj).add(scope);
            } else if (obj != scope) {
                MutableScatterSet mutableScatterSet = new MutableScatterSet(0, 1, null);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.ScopeMap.add$lambda$0");
                mutableScatterSet.add(obj);
                mutableScatterSet.add(scope);
                scope = (T) mutableScatterSet;
            }
            scope = (T) obj;
        }
        if (z) {
            int i = ~iFindInsertIndex;
            mutableScatterMap.keys[i] = key;
            mutableScatterMap.values[i] = scope;
            return;
        }
        mutableScatterMap.values[iFindInsertIndex] = scope;
    }

    public final boolean contains(Object element) {
        return this.map.containsKey(element);
    }

    public final void forEachScopeOf(Object key, Function1<? super T, Unit> block) {
        Object obj = getMap().get(key);
        if (obj == null) {
            return;
        }
        if (obj instanceof MutableScatterSet) {
            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
            Object[] objArr = mutableScatterSet.elements;
            long[] jArr = mutableScatterSet.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            block.invoke(objArr[(i << 3) + i3]);
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i == length) {
                    return;
                } else {
                    i++;
                }
            }
        } else {
            block.invoke(obj);
        }
    }

    public final void clear() {
        this.map.clear();
    }

    public final boolean remove(Object key, T scope) {
        Object obj = this.map.get(key);
        if (obj == null) {
            return false;
        }
        if (obj instanceof MutableScatterSet) {
            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
            boolean zRemove = mutableScatterSet.remove(scope);
            if (zRemove && mutableScatterSet.isEmpty()) {
                this.map.remove(key);
            }
            return zRemove;
        }
        if (!Intrinsics.areEqual(obj, scope)) {
            return false;
        }
        this.map.remove(key);
        return true;
    }

    public final void removeScopeIf(Function1<? super T, Boolean> predicate) {
        long[] jArr;
        long[] jArr2;
        long j;
        char c;
        long j2;
        int i;
        boolean zBooleanValue;
        MutableScatterSet mutableScatterSet;
        long[] jArr3;
        int i2;
        MutableScatterSet mutableScatterSet2;
        MutableScatterMap<Object, Object> map = getMap();
        long[] jArr4 = map.metadata;
        int length = jArr4.length - 2;
        if (length < 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            long j3 = jArr4[i3];
            char c2 = 7;
            long j4 = -9187201950435737472L;
            if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i4 = 8;
                int i5 = 8 - ((~(i3 - length)) >>> 31);
                int i6 = 0;
                while (i6 < i5) {
                    if ((j3 & 255) < 128) {
                        int i7 = (i3 << 3) + i6;
                        c = c2;
                        Object obj = map.keys[i7];
                        Object obj2 = map.values[i7];
                        j2 = j4;
                        if (obj2 instanceof MutableScatterSet) {
                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<T of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$1>");
                            MutableScatterSet mutableScatterSet3 = (MutableScatterSet) obj2;
                            Object[] objArr = mutableScatterSet3.elements;
                            long[] jArr5 = mutableScatterSet3.metadata;
                            int length2 = jArr5.length - 2;
                            if (length2 >= 0) {
                                int i8 = i4;
                                MutableScatterSet mutableScatterSet4 = mutableScatterSet3;
                                int i9 = 0;
                                while (true) {
                                    long j5 = jArr5[i9];
                                    j = j3;
                                    if ((((~j5) << c) & j5 & j2) != j2) {
                                        int i10 = 8 - ((~(i9 - length2)) >>> 31);
                                        int i11 = 0;
                                        while (i11 < i10) {
                                            if ((j5 & 255) < 128) {
                                                jArr3 = jArr4;
                                                int i12 = (i9 << 3) + i11;
                                                i2 = i11;
                                                if (predicate.invoke(objArr[i12]).booleanValue()) {
                                                    mutableScatterSet2 = mutableScatterSet4;
                                                    mutableScatterSet2.removeElementAt(i12);
                                                }
                                                j5 >>= i8;
                                                mutableScatterSet4 = mutableScatterSet2;
                                                i11 = i2 + 1;
                                                jArr4 = jArr3;
                                            } else {
                                                jArr3 = jArr4;
                                                i2 = i11;
                                            }
                                            mutableScatterSet2 = mutableScatterSet4;
                                            j5 >>= i8;
                                            mutableScatterSet4 = mutableScatterSet2;
                                            i11 = i2 + 1;
                                            jArr4 = jArr3;
                                        }
                                        jArr2 = jArr4;
                                        mutableScatterSet = mutableScatterSet4;
                                        if (i10 != i8) {
                                            break;
                                        }
                                    } else {
                                        jArr2 = jArr4;
                                        mutableScatterSet = mutableScatterSet4;
                                    }
                                    if (i9 == length2) {
                                        break;
                                    }
                                    i9++;
                                    mutableScatterSet4 = mutableScatterSet;
                                    j3 = j;
                                    jArr4 = jArr2;
                                    i8 = 8;
                                }
                            } else {
                                jArr2 = jArr4;
                                j = j3;
                                mutableScatterSet = mutableScatterSet3;
                            }
                            zBooleanValue = mutableScatterSet.isEmpty();
                        } else {
                            jArr2 = jArr4;
                            j = j3;
                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$1");
                            zBooleanValue = predicate.invoke(obj2).booleanValue();
                        }
                        if (zBooleanValue) {
                            map.removeValueAt(i7);
                        }
                        i = 8;
                    } else {
                        jArr2 = jArr4;
                        j = j3;
                        c = c2;
                        j2 = j4;
                        i = i4;
                    }
                    j3 = j >> i;
                    i6++;
                    i4 = i;
                    c2 = c;
                    j4 = j2;
                    jArr4 = jArr2;
                }
                jArr = jArr4;
                if (i5 != i4) {
                    return;
                }
            } else {
                jArr = jArr4;
            }
            if (i3 == length) {
                return;
            }
            i3++;
            jArr4 = jArr;
        }
    }

    public final void removeScope(T scope) {
        long[] jArr;
        long[] jArr2;
        long j;
        char c;
        long j2;
        int i;
        boolean zIsEmpty;
        MutableScatterSet mutableScatterSet;
        long[] jArr3;
        int i2;
        MutableScatterSet mutableScatterSet2;
        MutableScatterMap<Object, Object> map = getMap();
        long[] jArr4 = map.metadata;
        int length = jArr4.length - 2;
        if (length < 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            long j3 = jArr4[i3];
            char c2 = 7;
            long j4 = -9187201950435737472L;
            if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i4 = 8;
                int i5 = 8 - ((~(i3 - length)) >>> 31);
                int i6 = 0;
                while (i6 < i5) {
                    if ((j3 & 255) < 128) {
                        int i7 = (i3 << 3) + i6;
                        c = c2;
                        Object obj = map.keys[i7];
                        Object obj2 = map.values[i7];
                        j2 = j4;
                        if (obj2 instanceof MutableScatterSet) {
                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<T of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$1>");
                            MutableScatterSet mutableScatterSet3 = (MutableScatterSet) obj2;
                            Object[] objArr = mutableScatterSet3.elements;
                            long[] jArr5 = mutableScatterSet3.metadata;
                            int length2 = jArr5.length - 2;
                            if (length2 >= 0) {
                                int i8 = i4;
                                MutableScatterSet mutableScatterSet4 = mutableScatterSet3;
                                int i9 = 0;
                                while (true) {
                                    long j5 = jArr5[i9];
                                    j = j3;
                                    if ((((~j5) << c) & j5 & j2) != j2) {
                                        int i10 = 8 - ((~(i9 - length2)) >>> 31);
                                        int i11 = 0;
                                        while (i11 < i10) {
                                            if ((j5 & 255) < 128) {
                                                jArr3 = jArr4;
                                                int i12 = (i9 << 3) + i11;
                                                i2 = i11;
                                                if (objArr[i12] == scope) {
                                                    mutableScatterSet2 = mutableScatterSet4;
                                                    mutableScatterSet2.removeElementAt(i12);
                                                }
                                                j5 >>= i8;
                                                mutableScatterSet4 = mutableScatterSet2;
                                                i11 = i2 + 1;
                                                jArr4 = jArr3;
                                            } else {
                                                jArr3 = jArr4;
                                                i2 = i11;
                                            }
                                            mutableScatterSet2 = mutableScatterSet4;
                                            j5 >>= i8;
                                            mutableScatterSet4 = mutableScatterSet2;
                                            i11 = i2 + 1;
                                            jArr4 = jArr3;
                                        }
                                        jArr2 = jArr4;
                                        mutableScatterSet = mutableScatterSet4;
                                        if (i10 != i8) {
                                            break;
                                        }
                                    } else {
                                        jArr2 = jArr4;
                                        mutableScatterSet = mutableScatterSet4;
                                    }
                                    if (i9 == length2) {
                                        break;
                                    }
                                    i9++;
                                    mutableScatterSet4 = mutableScatterSet;
                                    j3 = j;
                                    jArr4 = jArr2;
                                    i8 = 8;
                                }
                            } else {
                                jArr2 = jArr4;
                                j = j3;
                                mutableScatterSet = mutableScatterSet3;
                            }
                            zIsEmpty = mutableScatterSet.isEmpty();
                        } else {
                            jArr2 = jArr4;
                            j = j3;
                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$1");
                            zIsEmpty = obj2 == scope;
                        }
                        if (zIsEmpty) {
                            map.removeValueAt(i7);
                        }
                        i = 8;
                    } else {
                        jArr2 = jArr4;
                        j = j3;
                        c = c2;
                        j2 = j4;
                        i = i4;
                    }
                    j3 = j >> i;
                    i6++;
                    i4 = i;
                    c2 = c;
                    j4 = j2;
                    jArr4 = jArr2;
                }
                jArr = jArr4;
                if (i5 != i4) {
                    return;
                }
            } else {
                jArr = jArr4;
            }
            if (i3 == length) {
                return;
            }
            i3++;
            jArr4 = jArr;
        }
    }
}
