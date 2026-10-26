package org.apache.commons.collections4.properties;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/* INFO: loaded from: classes5.dex */
public class PropertiesFactory extends AbstractPropertiesFactory<Properties> {
    public static final Properties EMPTY_PROPERTIES = new EmptyProperties(null);
    public static final PropertiesFactory INSTANCE = new PropertiesFactory();

    private static final class EmptyProperties extends Properties {
        private static final long serialVersionUID = 1;

        @Override // java.util.Hashtable, java.util.Map
        public boolean containsValue(Object obj) {
            return false;
        }

        @Override // java.util.Properties
        public String getProperty(String str) {
            return null;
        }

        @Override // java.util.Properties
        public String getProperty(String str, String str2) {
            return str2;
        }

        @Override // java.util.Hashtable
        protected void rehash() {
        }

        private EmptyProperties() {
        }

        /* synthetic */ EmptyProperties(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.Hashtable, java.util.Map
        public synchronized void clear() {
        }

        @Override // java.util.Hashtable, java.util.Map
        public synchronized Object compute(Object obj, BiFunction<? super Object, ? super Object, ? extends Object> biFunction) {
            Objects.requireNonNull(obj);
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Hashtable, java.util.Map
        public synchronized Object computeIfAbsent(Object obj, Function<? super Object, ? extends Object> function) {
            Objects.requireNonNull(obj);
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Hashtable, java.util.Map
        public synchronized Object computeIfPresent(Object obj, BiFunction<? super Object, ? super Object, ? extends Object> biFunction) {
            Objects.requireNonNull(obj);
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Hashtable
        public synchronized boolean contains(Object obj) {
            return false;
        }

        @Override // java.util.Hashtable, java.util.Map
        public synchronized boolean containsKey(Object obj) {
            return false;
        }

        @Override // java.util.Hashtable, java.util.Dictionary
        public synchronized Enumeration<Object> elements() {
            return Collections.emptyEnumeration();
        }

        @Override // java.util.Hashtable, java.util.Map
        public Set<Map.Entry<Object, Object>> entrySet() {
            return Collections.emptySet();
        }

        @Override // java.util.Hashtable, java.util.Map
        public synchronized boolean equals(Object obj) {
            return (obj instanceof Properties) && ((Properties) obj).isEmpty();
        }

        @Override // java.util.Hashtable, java.util.Map
        public synchronized void forEach(BiConsumer<? super Object, ? super Object> biConsumer) {
            Objects.requireNonNull(biConsumer);
        }

        @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
        public synchronized Object get(Object obj) {
            return null;
        }

        @Override // java.util.Hashtable, java.util.Map
        public synchronized Object getOrDefault(Object obj, Object obj2) {
            return obj2;
        }

        @Override // java.util.Hashtable, java.util.Map
        public synchronized int hashCode() {
            return 0;
        }

        @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
        public synchronized boolean isEmpty() {
            return true;
        }

        @Override // java.util.Hashtable, java.util.Dictionary
        public synchronized Enumeration<Object> keys() {
            return Collections.emptyEnumeration();
        }

        @Override // java.util.Hashtable, java.util.Map
        public Set<Object> keySet() {
            return Collections.emptySet();
        }

        @Override // java.util.Properties
        public synchronized void load(InputStream inputStream) throws IOException {
            Objects.requireNonNull(inputStream);
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Properties
        public synchronized void load(Reader reader) throws IOException {
            Objects.requireNonNull(reader);
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Properties
        public synchronized void loadFromXML(InputStream inputStream) throws IOException {
            Objects.requireNonNull(inputStream);
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Hashtable, java.util.Map
        public synchronized Object merge(Object obj, Object obj2, BiFunction<? super Object, ? super Object, ? extends Object> biFunction) {
            Objects.requireNonNull(obj);
            Objects.requireNonNull(obj2);
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Properties
        public Enumeration<?> propertyNames() {
            return Collections.emptyEnumeration();
        }

        @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
        public synchronized Object put(Object obj, Object obj2) {
            Objects.requireNonNull(obj);
            Objects.requireNonNull(obj2);
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Hashtable, java.util.Map
        public synchronized void putAll(Map<? extends Object, ? extends Object> map) {
            Objects.requireNonNull(map);
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Hashtable, java.util.Map
        public synchronized Object putIfAbsent(Object obj, Object obj2) {
            Objects.requireNonNull(obj);
            Objects.requireNonNull(obj2);
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
        public synchronized Object remove(Object obj) {
            Objects.requireNonNull(obj);
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Hashtable, java.util.Map
        public synchronized boolean remove(Object obj, Object obj2) {
            Objects.requireNonNull(obj);
            Objects.requireNonNull(obj2);
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Hashtable, java.util.Map
        public synchronized Object replace(Object obj, Object obj2) {
            Objects.requireNonNull(obj);
            Objects.requireNonNull(obj2);
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Hashtable, java.util.Map
        public synchronized boolean replace(Object obj, Object obj2, Object obj3) {
            Objects.requireNonNull(obj);
            Objects.requireNonNull(obj2);
            Objects.requireNonNull(obj3);
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Hashtable, java.util.Map
        public synchronized void replaceAll(BiFunction<? super Object, ? super Object, ? extends Object> biFunction) {
            Objects.requireNonNull(biFunction);
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Properties
        public void save(OutputStream outputStream, String str) {
            super.save(outputStream, str);
        }

        @Override // java.util.Properties
        public synchronized Object setProperty(String str, String str2) {
            Objects.requireNonNull(str);
            Objects.requireNonNull(str2);
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
        public synchronized int size() {
            return 0;
        }

        @Override // java.util.Properties
        public Set<String> stringPropertyNames() {
            return Collections.emptySet();
        }

        @Override // java.util.Hashtable
        public synchronized String toString() {
            return super.toString();
        }

        @Override // java.util.Hashtable, java.util.Map
        public Collection<Object> values() {
            return Collections.emptyList();
        }
    }

    private PropertiesFactory() {
    }

    @Override // org.apache.commons.collections4.properties.AbstractPropertiesFactory
    protected Properties createProperties() {
        return new Properties();
    }
}
