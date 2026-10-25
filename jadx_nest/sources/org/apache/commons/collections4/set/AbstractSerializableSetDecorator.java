package org.apache.commons.collections4.set;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractSerializableSetDecorator<E> extends AbstractSetDecorator<E> {
    private static final long serialVersionUID = 1229469966212206107L;

    protected AbstractSerializableSetDecorator(Set<E> set) {
        super(set);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        setCollection((Collection) objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(decorated());
    }
}
