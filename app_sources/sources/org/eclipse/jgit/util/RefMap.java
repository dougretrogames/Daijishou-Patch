package org.eclipse.jgit.util;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.RefComparator;

/* INFO: loaded from: classes5.dex */
public class RefMap extends AbstractMap<String, Ref> {
    private Set<Map.Entry<String, Ref>> entrySet;
    RefList<Ref> loose;
    RefList<Ref> packed;
    final String prefix;
    RefList<Ref> resolved;
    int size;
    boolean sizeIsValid;

    public RefMap() {
        this.prefix = "";
        this.packed = RefList.emptyList();
        this.loose = RefList.emptyList();
        this.resolved = RefList.emptyList();
    }

    /* WARN: Multi-variable type inference failed */
    public RefMap(String str, RefList<? extends Ref> refList, RefList<? extends Ref> refList2, RefList<? extends Ref> refList3) {
        this.prefix = str;
        this.packed = refList;
        this.loose = refList2;
        this.resolved = refList3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Ref get(Object obj) {
        String refName = toRefName((String) obj);
        Ref ref = this.resolved.get(refName);
        if (ref == null) {
            ref = this.loose.get(refName);
        }
        return ref == null ? this.packed.get(refName) : ref;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Ref put(String str, Ref ref) {
        String refName = toRefName(str);
        if (!refName.equals(ref.getName())) {
            throw new IllegalArgumentException();
        }
        if (!this.resolved.isEmpty()) {
            Iterator<Ref> it = this.resolved.iterator();
            while (it.hasNext()) {
                this.loose = this.loose.put(it.next());
            }
            this.resolved = RefList.emptyList();
        }
        int iFind = this.loose.find(refName);
        if (iFind >= 0) {
            Ref ref2 = this.loose.get(refName);
            this.loose = this.loose.set(iFind, ref);
            return ref2;
        }
        Ref ref3 = get((Object) str);
        this.loose = this.loose.add(iFind, ref);
        this.sizeIsValid = false;
        return ref3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Ref remove(Object obj) {
        Ref ref;
        String refName = toRefName((String) obj);
        int iFind = this.packed.find(refName);
        if (iFind >= 0) {
            ref = this.packed.get(refName);
            this.packed = this.packed.remove(iFind);
            this.sizeIsValid = false;
        } else {
            ref = null;
        }
        int iFind2 = this.loose.find(refName);
        if (iFind2 >= 0) {
            ref = this.loose.get(refName);
            this.loose = this.loose.remove(iFind2);
            this.sizeIsValid = false;
        }
        int iFind3 = this.resolved.find(refName);
        if (iFind3 < 0) {
            return ref;
        }
        Ref ref2 = this.resolved.get(refName);
        this.resolved = this.resolved.remove(iFind3);
        this.sizeIsValid = false;
        return ref2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return entrySet().isEmpty();
    }

    /* INFO: renamed from: org.eclipse.jgit.util.RefMap$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractSet<Map.Entry<String, Ref>> {
        AnonymousClass1() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<String, Ref>> iterator() {
            return RefMap.this.new SetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            if (!RefMap.this.sizeIsValid) {
                RefMap.this.size = 0;
                Iterator<Map.Entry<String, Ref>> it = RefMap.this.entrySet().iterator();
                while (it.hasNext()) {
                    RefMap.this.size++;
                    it.next();
                }
                RefMap.this.sizeIsValid = true;
            }
            return RefMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            if (RefMap.this.sizeIsValid) {
                return RefMap.this.size == 0;
            }
            return !iterator().hasNext();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            RefMap.this.packed = RefList.emptyList();
            RefMap.this.loose = RefList.emptyList();
            RefMap.this.resolved = RefList.emptyList();
            RefMap.this.size = 0;
            RefMap.this.sizeIsValid = true;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<String, Ref>> entrySet() {
        if (this.entrySet == null) {
            this.entrySet = new AnonymousClass1();
        }
        return this.entrySet;
    }

    @Override // java.util.AbstractMap
    public String toString() {
        StringBuilder sb = new StringBuilder(CollectionUtils.DEFAULT_TOSTRING_PREFIX);
        boolean z = true;
        for (Ref ref : values()) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(ref);
        }
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    public static Collector<Ref, ?, RefMap> toRefMap(BinaryOperator<Ref> binaryOperator) {
        return Collectors.collectingAndThen(RefList.toRefList(binaryOperator), new RefMap$$ExternalSyntheticLambda0());
    }

    static /* synthetic */ RefMap lambda$0(RefList refList) {
        return new RefMap("", refList, RefList.emptyList(), RefList.emptyList());
    }

    private String toRefName(String str) {
        if (this.prefix.length() <= 0) {
            return str;
        }
        return this.prefix + str;
    }

    String toMapKey(Ref ref) {
        String name = ref.getName();
        return this.prefix.length() > 0 ? name.substring(this.prefix.length()) : name;
    }

    private class SetIterator implements Iterator<Map.Entry<String, Ref>> {
        private int looseIdx;
        private Map.Entry<String, Ref> next;
        private int packedIdx;
        private int resolvedIdx;

        SetIterator() {
            if (RefMap.this.prefix.length() > 0) {
                this.packedIdx = -(RefMap.this.packed.find(RefMap.this.prefix) + 1);
                this.looseIdx = -(RefMap.this.loose.find(RefMap.this.prefix) + 1);
                this.resolvedIdx = -(RefMap.this.resolved.find(RefMap.this.prefix) + 1);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.next == null) {
                this.next = peek();
            }
            return this.next != null;
        }

        @Override // java.util.Iterator
        public Map.Entry<String, Ref> next() {
            if (hasNext()) {
                Map.Entry<String, Ref> entry = this.next;
                this.next = peek();
                return entry;
            }
            throw new NoSuchElementException();
        }

        public Map.Entry<String, Ref> peek() {
            if (this.packedIdx < RefMap.this.packed.size() && this.looseIdx < RefMap.this.loose.size()) {
                Ref ref = RefMap.this.packed.get(this.packedIdx);
                Ref ref2 = RefMap.this.loose.get(this.looseIdx);
                int iCompareTo = RefComparator.compareTo(ref, ref2);
                if (iCompareTo < 0) {
                    this.packedIdx++;
                    return toEntry(ref);
                }
                if (iCompareTo == 0) {
                    this.packedIdx++;
                }
                this.looseIdx++;
                return toEntry(resolveLoose(ref2));
            }
            if (this.looseIdx < RefMap.this.loose.size()) {
                RefList<Ref> refList = RefMap.this.loose;
                int i = this.looseIdx;
                this.looseIdx = i + 1;
                return toEntry(resolveLoose(refList.get(i)));
            }
            if (this.packedIdx >= RefMap.this.packed.size()) {
                return null;
            }
            RefList<Ref> refList2 = RefMap.this.packed;
            int i2 = this.packedIdx;
            this.packedIdx = i2 + 1;
            return toEntry(refList2.get(i2));
        }

        private Ref resolveLoose(Ref ref) {
            if (this.resolvedIdx < RefMap.this.resolved.size()) {
                Ref ref2 = RefMap.this.resolved.get(this.resolvedIdx);
                int iCompareTo = RefComparator.compareTo(ref, ref2);
                if (iCompareTo == 0) {
                    this.resolvedIdx++;
                    return ref2;
                }
                if (iCompareTo > 0) {
                    throw new IllegalStateException();
                }
            }
            return ref;
        }

        private Ent toEntry(Ref ref) {
            if (ref.getName().startsWith(RefMap.this.prefix)) {
                return RefMap.this.new Ent(ref);
            }
            this.packedIdx = RefMap.this.packed.size();
            this.looseIdx = RefMap.this.loose.size();
            this.resolvedIdx = RefMap.this.resolved.size();
            return null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class Ent implements Map.Entry<String, Ref> {
        private Ref ref;

        Ent(Ref ref) {
            this.ref = ref;
        }

        @Override // java.util.Map.Entry
        public String getKey() {
            return RefMap.this.toMapKey(this.ref);
        }

        @Override // java.util.Map.Entry
        public Ref getValue() {
            return this.ref;
        }

        @Override // java.util.Map.Entry
        public Ref setValue(Ref ref) {
            Ref refPut = RefMap.this.put(getKey(), ref);
            this.ref = ref;
            return refPut;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return getKey().hashCode();
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (!(key instanceof String) || !(value instanceof Ref)) {
                return false;
            }
            Ref ref = (Ref) value;
            if (!ref.getName().equals(this.ref.getName())) {
                return false;
            }
            ObjectId objectId = ref.getObjectId();
            ObjectId objectId2 = this.ref.getObjectId();
            return (objectId == null || objectId2 == null || !AnyObjectId.isEqual(objectId, objectId2)) ? false : true;
        }

        public String toString() {
            return this.ref.toString();
        }
    }
}
