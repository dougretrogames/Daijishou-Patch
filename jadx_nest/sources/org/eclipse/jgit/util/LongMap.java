package org.eclipse.jgit.util;

/* JADX INFO: loaded from: classes5.dex */
public class LongMap<V> {
    private static final float LOAD_FACTOR = 0.75f;
    private int growAt;
    private int size;
    private Node<V>[] table;

    public LongMap() {
        Node<V>[] nodeArrCreateArray = createArray(64);
        this.table = nodeArrCreateArray;
        this.growAt = (int) (nodeArrCreateArray.length * 0.75f);
    }

    public boolean containsKey(long j) {
        return get(j) != null;
    }

    public V get(long j) {
        for (Node<V> node = this.table[index(j)]; node != null; node = node.next) {
            if (node.key == j) {
                return node.value;
            }
        }
        return null;
    }

    public V remove(long j) {
        Node<V> node = null;
        for (Node<V> node2 = this.table[index(j)]; node2 != null; node2 = node2.next) {
            if (node2.key == j) {
                if (node == null) {
                    this.table[index(j)] = node2.next;
                } else {
                    node.next = node2.next;
                }
                this.size--;
                return node2.value;
            }
            node = node2;
        }
        return null;
    }

    public V put(long j, V v) {
        for (Node<V> node = this.table[index(j)]; node != null; node = node.next) {
            if (node.key == j) {
                V v2 = node.value;
                node.value = v;
                return v2;
            }
        }
        int i = this.size + 1;
        this.size = i;
        if (i == this.growAt) {
            grow();
        }
        insert(new Node<>(j, v));
        return null;
    }

    private void insert(Node<V> node) {
        int iIndex = index(node.key);
        node.next = this.table[iIndex];
        this.table[iIndex] = node;
    }

    private void grow() {
        Node<V>[] nodeArr = this.table;
        Node<V>[] nodeArrCreateArray = createArray(nodeArr.length << 1);
        this.table = nodeArrCreateArray;
        this.growAt = (int) (nodeArrCreateArray.length * 0.75f);
        for (Node<V> node : nodeArr) {
            while (node != null) {
                Node<V> node2 = node.next;
                insert(node);
                node = node2;
            }
        }
    }

    private final int index(long j) {
        int i = (int) j;
        return (((i >>> 13) ^ (i >>> 21)) ^ (i >>> 1)) & (this.table.length - 1);
    }

    private static final <V> Node<V>[] createArray(int i) {
        return new Node[i];
    }

    private static class Node<V> {
        final long key;
        Node<V> next;
        V value;

        Node(long j, V v) {
            this.key = j;
            this.value = v;
        }
    }
}
