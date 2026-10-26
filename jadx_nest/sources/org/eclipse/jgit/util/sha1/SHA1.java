package org.eclipse.jgit.util.sha1;

import java.io.IOException;
import org.eclipse.jgit.errors.ConfigInvalidException;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.MutableObjectId;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.util.SystemReader;

/* INFO: loaded from: classes5.dex */
public abstract class SHA1 {
    private static final Sha1Implementation SHA1_IMPLEMENTATION = fromConfig();

    public abstract void digest(MutableObjectId mutableObjectId) throws Sha1CollisionException;

    public abstract byte[] digest() throws Sha1CollisionException;

    public abstract boolean hasCollision();

    public abstract SHA1 reset();

    public abstract SHA1 setDetectCollision(boolean z);

    public abstract ObjectId toObjectId() throws Sha1CollisionException;

    public abstract void update(byte b);

    public abstract void update(byte[] bArr);

    public abstract void update(byte[] bArr, int i, int i2);

    public enum Sha1Implementation {
        JAVA(SHA1Java.class),
        JDKNATIVE(SHA1Native.class);

        private final String implClassName;

        /* INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static Sha1Implementation[] valuesCustom() {
            Sha1Implementation[] sha1ImplementationArrValuesCustom = values();
            int length = sha1ImplementationArrValuesCustom.length;
            Sha1Implementation[] sha1ImplementationArr = new Sha1Implementation[length];
            System.arraycopy(sha1ImplementationArrValuesCustom, 0, sha1ImplementationArr, 0, length);
            return sha1ImplementationArr;
        }

        Sha1Implementation(Class cls) {
            this.implClassName = cls.getName();
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.implClassName;
        }
    }

    private static Sha1Implementation fromConfig() {
        try {
            return (Sha1Implementation) SystemReader.getInstance().getUserConfig().getEnum(ConfigConstants.CONFIG_CORE_SECTION, null, ConfigConstants.SHA1_IMPLEMENTATION, Sha1Implementation.JAVA);
        } catch (IOException | ConfigInvalidException unused) {
            return Sha1Implementation.JAVA;
        }
    }

    private static Sha1Implementation getImplementation() {
        String property = System.getProperty("org.eclipse.jgit.util.sha1.implementation");
        if (property == null) {
            return SHA1_IMPLEMENTATION;
        }
        if (property.equalsIgnoreCase(Sha1Implementation.JAVA.name())) {
            return Sha1Implementation.JAVA;
        }
        if (property.equalsIgnoreCase(Sha1Implementation.JDKNATIVE.name())) {
            return Sha1Implementation.JDKNATIVE;
        }
        return SHA1_IMPLEMENTATION;
    }

    public static SHA1 newInstance() {
        if (getImplementation() == Sha1Implementation.JDKNATIVE) {
            return new SHA1Native();
        }
        return new SHA1Java();
    }
}
