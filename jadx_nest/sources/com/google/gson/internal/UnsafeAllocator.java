package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes4.dex */
public abstract class UnsafeAllocator {
    public static final UnsafeAllocator INSTANCE = create();

    public abstract <T> T newInstance(Class<T> cls) throws Exception;

    /* JADX INFO: Access modifiers changed from: private */
    public static void assertInstantiable(Class<?> cls) {
        String strCheckInstantiable = ConstructorConstructor.checkInstantiable(cls);
        if (strCheckInstantiable != null) {
            throw new AssertionError("UnsafeAllocator is used for non-instantiable type: " + strCheckInstantiable);
        }
    }

    private static UnsafeAllocator create() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new AnonymousClass1(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
        } catch (Exception unused) {
            try {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    int iIntValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                    Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    return new AnonymousClass2(declaredMethod2, iIntValue);
                } catch (Exception unused2) {
                    return new AnonymousClass4();
                }
            } catch (Exception unused3) {
                Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                declaredMethod3.setAccessible(true);
                return new AnonymousClass3(declaredMethod3);
            }
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.UnsafeAllocator$1, reason: invalid class name */
    class AnonymousClass1 extends UnsafeAllocator {
        final /* synthetic */ Method val$allocateInstance;
        final /* synthetic */ Object val$unsafe;

        AnonymousClass1(Method method, Object obj) {
            this.val$allocateInstance = method;
            this.val$unsafe = obj;
        }

        @Override // com.google.gson.internal.UnsafeAllocator
        public <T> T newInstance(Class<T> cls) throws Exception {
            UnsafeAllocator.assertInstantiable(cls);
            return (T) this.val$allocateInstance.invoke(this.val$unsafe, cls);
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.UnsafeAllocator$2, reason: invalid class name */
    class AnonymousClass2 extends UnsafeAllocator {
        final /* synthetic */ int val$constructorId;
        final /* synthetic */ Method val$newInstance;

        AnonymousClass2(Method method, int i) {
            this.val$newInstance = method;
            this.val$constructorId = i;
        }

        @Override // com.google.gson.internal.UnsafeAllocator
        public <T> T newInstance(Class<T> cls) throws Exception {
            UnsafeAllocator.assertInstantiable(cls);
            return (T) this.val$newInstance.invoke(null, cls, Integer.valueOf(this.val$constructorId));
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.UnsafeAllocator$3, reason: invalid class name */
    class AnonymousClass3 extends UnsafeAllocator {
        final /* synthetic */ Method val$newInstance;

        AnonymousClass3(Method method) {
            this.val$newInstance = method;
        }

        @Override // com.google.gson.internal.UnsafeAllocator
        public <T> T newInstance(Class<T> cls) throws Exception {
            UnsafeAllocator.assertInstantiable(cls);
            return (T) this.val$newInstance.invoke(null, cls, Object.class);
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.UnsafeAllocator$4, reason: invalid class name */
    class AnonymousClass4 extends UnsafeAllocator {
        AnonymousClass4() {
        }

        @Override // com.google.gson.internal.UnsafeAllocator
        public <T> T newInstance(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls + ". Usage of JDK sun.misc.Unsafe is enabled, but it could not be used. Make sure your runtime is configured correctly.");
        }
    }
}
