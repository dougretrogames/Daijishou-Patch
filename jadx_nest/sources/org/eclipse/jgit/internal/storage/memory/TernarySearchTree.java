package org.eclipse.jgit.internal.storage.memory;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.util.StringUtils;

/* INFO: loaded from: classes5.dex */
public final class TernarySearchTree<Value> {
    private static final char WILDCARD = '?';
    private Node<Value> root;
    private final AtomicInteger size = new AtomicInteger(0);
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public interface Loader<Value> {
        Map<String, Value> loadAll();
    }

    private static class Node<Value> {
        final char c;
        Node<Value> eq;
        Node<Value> hi;
        Node<Value> lo;
        Value val;

        Node(char c) {
            this.c = c;
        }

        boolean hasValue() {
            return this.val != null;
        }
    }

    private static void validateKey(String str) {
        if (StringUtils.isEmptyOrNull(str)) {
            throw new IllegalArgumentException(JGitText.get().illegalTernarySearchTreeKey);
        }
    }

    private static <V> void validateValue(V v) {
        if (v == null) {
            throw new IllegalArgumentException(JGitText.get().illegalTernarySearchTreeValue);
        }
    }

    public ReadWriteLock getLock() {
        return this.lock;
    }

    public int replace(Iterable<Map.Entry<String, Value>> iterable) {
        this.lock.writeLock().lock();
        try {
            clear();
            for (Map.Entry<String, Value> entry : iterable) {
                insertImpl(entry.getKey(), entry.getValue());
            }
            this.lock.writeLock().unlock();
            return this.size.get();
        } catch (Throwable th) {
            this.lock.writeLock().unlock();
            throw th;
        }
    }

    public int reload(Iterable<Map.Entry<String, Value>> iterable) {
        this.lock.writeLock().lock();
        try {
            for (Map.Entry<String, Value> entry : iterable) {
                insertImpl(entry.getKey(), entry.getValue());
            }
            this.lock.writeLock().unlock();
            return this.size.get();
        } catch (Throwable th) {
            this.lock.writeLock().unlock();
            throw th;
        }
    }

    public int delete(Iterable<String> iterable) {
        this.lock.writeLock().lock();
        try {
            Iterator<String> it = iterable.iterator();
            while (it.hasNext()) {
                delete(it.next());
            }
            this.lock.writeLock().unlock();
            return this.size.get();
        } catch (Throwable th) {
            this.lock.writeLock().unlock();
            throw th;
        }
    }

    public int size() {
        return this.size.get();
    }

    @Nullable
    public Value get(String str) {
        validateKey(str);
        this.lock.readLock().lock();
        try {
            Node<Value> node = get(this.root, str, 0);
            if (node != null) {
                return node.val;
            }
            return null;
        } finally {
            this.lock.readLock().unlock();
        }
    }

    public boolean contains(String str) {
        return get(str) != null;
    }

    public int insert(String str, Value value) {
        this.lock.writeLock().lock();
        try {
            insertImpl(str, value);
            return this.size.get();
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    public int insert(Map<String, Value> map) {
        this.lock.writeLock().lock();
        try {
            for (Map.Entry<String, Value> entry : map.entrySet()) {
                insertImpl(entry.getKey(), entry.getValue());
            }
            return this.size.get();
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    private void insertImpl(String str, Value value) {
        validateValue(value);
        if (!contains(str)) {
            this.size.addAndGet(1);
        }
        this.root = insert(this.root, str, value, 0);
    }

    public int delete(String str) {
        this.lock.writeLock().lock();
        try {
            if (contains(str)) {
                this.size.addAndGet(-1);
                this.root = insert(this.root, str, null, 0);
            }
            return this.size.get();
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    public void clear() {
        this.lock.writeLock().lock();
        try {
            this.size.set(0);
            this.root = null;
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    @Nullable
    public String keyLongestPrefixOf(String str) {
        if (StringUtils.isEmptyOrNull(str)) {
            return null;
        }
        this.lock.readLock().lock();
        try {
            Node<Value> node = this.root;
            int i = 0;
            int i2 = 0;
            while (node != null && i < str.length()) {
                char cCharAt = str.charAt(i);
                if (node.c > cCharAt) {
                    node = node.lo;
                } else if (node.c < cCharAt) {
                    node = node.hi;
                } else {
                    i++;
                    if (node.hasValue()) {
                        i2 = i;
                    }
                    node = node.eq;
                }
            }
            return str.substring(0, i2);
        } finally {
            this.lock.readLock().unlock();
        }
    }

    public Iterable<String> getKeys() {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.lock.readLock().lock();
        try {
            findKeysWithPrefix(this.root, new StringBuilder(), arrayDeque);
            return arrayDeque;
        } finally {
            this.lock.readLock().unlock();
        }
    }

    public Iterable<String> getKeysWithPrefix(String str) {
        ArrayDeque arrayDeque = new ArrayDeque();
        if (str == null) {
            return arrayDeque;
        }
        if (str.isEmpty()) {
            return getKeys();
        }
        this.lock.readLock().lock();
        try {
            validateKey(str);
            Node<Value> node = get(this.root, str, 0);
            if (node != null) {
                if (node.hasValue()) {
                    arrayDeque.add(str);
                }
                findKeysWithPrefix(node.eq, new StringBuilder(str), arrayDeque);
            }
            return arrayDeque;
        } finally {
            this.lock.readLock().unlock();
        }
    }

    public Map<String, Value> getAll() {
        HashMap map = new HashMap();
        this.lock.readLock().lock();
        try {
            findWithPrefix(this.root, new StringBuilder(), map);
            return map;
        } finally {
            this.lock.readLock().unlock();
        }
    }

    public List<Value> getAllValues() {
        ArrayList arrayList = new ArrayList();
        this.lock.readLock().lock();
        try {
            findValuesWithPrefix(this.root, new StringBuilder(), arrayList);
            return arrayList;
        } finally {
            this.lock.readLock().unlock();
        }
    }

    public Map<String, Value> getWithPrefix(String str) {
        HashMap map = new HashMap();
        if (str == null) {
            return map;
        }
        if (str.isEmpty()) {
            return getAll();
        }
        this.lock.readLock().lock();
        try {
            validateKey(str);
            Node<Value> node = get(this.root, str, 0);
            if (node != null) {
                if (node.hasValue()) {
                    map.put(str, node.val);
                }
                findWithPrefix(node.eq, new StringBuilder(str), map);
            }
            return map;
        } finally {
            this.lock.readLock().unlock();
        }
    }

    public List<Value> getValuesWithPrefix(String str) {
        ArrayList arrayList = new ArrayList();
        if (str == null) {
            return arrayList;
        }
        if (str.isEmpty()) {
            return getAllValues();
        }
        this.lock.readLock().lock();
        try {
            validateKey(str);
            Node<Value> node = get(this.root, str, 0);
            if (node != null) {
                if (node.hasValue()) {
                    arrayList.add(node.val);
                }
                findValuesWithPrefix(node.eq, new StringBuilder(str), arrayList);
            }
            return arrayList;
        } finally {
            this.lock.readLock().unlock();
        }
    }

    public Iterable<String> getKeysMatching(String str) throws Throwable {
        TernarySearchTree<Value> ternarySearchTree;
        ArrayDeque arrayDeque = new ArrayDeque();
        this.lock.readLock().lock();
        try {
            ternarySearchTree = this;
            try {
                ternarySearchTree.findKeysWithPrefix(this.root, new StringBuilder(), 0, str, arrayDeque);
                ternarySearchTree.lock.readLock().unlock();
                return arrayDeque;
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                ternarySearchTree.lock.readLock().unlock();
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            ternarySearchTree = this;
        }
    }

    private Node<Value> get(Node<Value> node, String str, int i) {
        if (node == null) {
            return null;
        }
        char cCharAt = str.charAt(i);
        if (node.c > cCharAt) {
            return get(node.lo, str, i);
        }
        if (node.c < cCharAt) {
            return get(node.hi, str, i);
        }
        return i < str.length() + (-1) ? get(node.eq, str, i + 1) : node;
    }

    private Node<Value> insert(Node<Value> node, String str, Value value, int i) {
        char cCharAt = str.charAt(i);
        if (node == null) {
            node = new Node<>(cCharAt);
        }
        if (node.c > cCharAt) {
            node.lo = insert(node.lo, str, value, i);
            return node;
        }
        if (node.c < cCharAt) {
            node.hi = insert(node.hi, str, value, i);
            return node;
        }
        if (i < str.length() - 1) {
            node.eq = insert(node.eq, str, value, i + 1);
            return node;
        }
        node.val = value;
        return node;
    }

    private void findKeysWithPrefix(Node<Value> node, StringBuilder sb, Queue<String> queue) {
        if (node == null) {
            return;
        }
        findKeysWithPrefix(node.lo, sb, queue);
        if (node.hasValue()) {
            queue.add(sb.toString() + node.c);
        }
        findKeysWithPrefix(node.eq, sb.append(node.c), queue);
        sb.deleteCharAt(sb.length() - 1);
        findKeysWithPrefix(node.hi, sb, queue);
    }

    private void findWithPrefix(Node<Value> node, StringBuilder sb, Map<String, Value> map) {
        if (node == null) {
            return;
        }
        findWithPrefix(node.lo, sb, map);
        if (node.hasValue()) {
            map.put(sb.toString() + node.c, node.val);
        }
        findWithPrefix(node.eq, sb.append(node.c), map);
        sb.deleteCharAt(sb.length() - 1);
        findWithPrefix(node.hi, sb, map);
    }

    private void findValuesWithPrefix(Node<Value> node, StringBuilder sb, List<Value> list) {
        if (node == null) {
            return;
        }
        findValuesWithPrefix(node.lo, sb, list);
        if (node.hasValue()) {
            list.add(node.val);
        }
        findValuesWithPrefix(node.eq, sb.append(node.c), list);
        sb.deleteCharAt(sb.length() - 1);
        findValuesWithPrefix(node.hi, sb, list);
    }

    private void findKeysWithPrefix(Node<Value> node, StringBuilder sb, int i, String str, Queue<String> queue) {
        if (node == null || StringUtils.isEmptyOrNull(str)) {
            return;
        }
        char cCharAt = str.charAt(i);
        if (cCharAt == '?' || node.c > cCharAt) {
            findKeysWithPrefix(node.lo, sb, i, str, queue);
        }
        if (cCharAt == '?' || node.c == cCharAt) {
            if (i == str.length() - 1 && node.hasValue()) {
                queue.add(sb.toString() + node.c);
            }
            if (i < str.length() - 1) {
                findKeysWithPrefix(node.eq, sb.append(node.c), i + 1, str, queue);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        if (cCharAt == '?' || node.c < cCharAt) {
            findKeysWithPrefix(node.hi, sb, i, str, queue);
        }
    }
}
