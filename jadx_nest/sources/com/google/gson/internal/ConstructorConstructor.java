package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.JsonIOException;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* JADX INFO: loaded from: classes4.dex */
public final class ConstructorConstructor {
    private final Map<Type, InstanceCreator<?>> instanceCreators;
    private final List<ReflectionAccessFilter> reflectionFilters;
    private final boolean useJdkUnsafe;

    public ConstructorConstructor(Map<Type, InstanceCreator<?>> map, boolean z, List<ReflectionAccessFilter> list) {
        this.instanceCreators = map;
        this.useJdkUnsafe = z;
        this.reflectionFilters = list;
    }

    static String checkInstantiable(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: " + cls.getName();
        }
        if (Modifier.isAbstract(modifiers)) {
            return "Abstract classes can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Class name: " + cls.getName();
        }
        return null;
    }

    public <T> ObjectConstructor<T> get(TypeToken<T> typeToken) {
        Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        InstanceCreator<?> instanceCreator = this.instanceCreators.get(type);
        if (instanceCreator != null) {
            return new AnonymousClass1(instanceCreator, type);
        }
        InstanceCreator<?> instanceCreator2 = this.instanceCreators.get(rawType);
        if (instanceCreator2 != null) {
            return new AnonymousClass2(instanceCreator2, type);
        }
        ObjectConstructor<T> objectConstructorNewSpecialCollectionConstructor = newSpecialCollectionConstructor(type, rawType);
        if (objectConstructorNewSpecialCollectionConstructor != null) {
            return objectConstructorNewSpecialCollectionConstructor;
        }
        ReflectionAccessFilter.FilterResult filterResult = ReflectionAccessFilterHelper.getFilterResult(this.reflectionFilters, rawType);
        ObjectConstructor<T> objectConstructorNewDefaultConstructor = newDefaultConstructor(rawType, filterResult);
        if (objectConstructorNewDefaultConstructor != null) {
            return objectConstructorNewDefaultConstructor;
        }
        ObjectConstructor<T> objectConstructorNewDefaultImplementationConstructor = newDefaultImplementationConstructor(type, rawType);
        if (objectConstructorNewDefaultImplementationConstructor != null) {
            return objectConstructorNewDefaultImplementationConstructor;
        }
        String strCheckInstantiable = checkInstantiable(rawType);
        if (strCheckInstantiable != null) {
            return new AnonymousClass3(strCheckInstantiable);
        }
        if (filterResult == ReflectionAccessFilter.FilterResult.ALLOW) {
            return newUnsafeAllocator(rawType);
        }
        return new AnonymousClass4("Unable to create instance of " + rawType + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.");
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.gson.internal.ConstructorConstructor$1, reason: invalid class name */
    class AnonymousClass1<T> implements ObjectConstructor<T> {
        final /* synthetic */ Type val$type;
        final /* synthetic */ InstanceCreator val$typeCreator;

        AnonymousClass1(InstanceCreator instanceCreator, Type type) {
            this.val$typeCreator = instanceCreator;
            this.val$type = type;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) this.val$typeCreator.createInstance(this.val$type);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.gson.internal.ConstructorConstructor$2, reason: invalid class name */
    class AnonymousClass2<T> implements ObjectConstructor<T> {
        final /* synthetic */ InstanceCreator val$rawTypeCreator;
        final /* synthetic */ Type val$type;

        AnonymousClass2(InstanceCreator instanceCreator, Type type) {
            this.val$rawTypeCreator = instanceCreator;
            this.val$type = type;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) this.val$rawTypeCreator.createInstance(this.val$type);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.gson.internal.ConstructorConstructor$3, reason: invalid class name */
    class AnonymousClass3<T> implements ObjectConstructor<T> {
        final /* synthetic */ String val$exceptionMessage;

        AnonymousClass3(String str) {
            this.val$exceptionMessage = str;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            throw new JsonIOException(this.val$exceptionMessage);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.gson.internal.ConstructorConstructor$4, reason: invalid class name */
    class AnonymousClass4<T> implements ObjectConstructor<T> {
        final /* synthetic */ String val$message;

        AnonymousClass4(String str) {
            this.val$message = str;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            throw new JsonIOException(this.val$message);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.gson.internal.ConstructorConstructor$5, reason: invalid class name */
    class AnonymousClass5<T> implements ObjectConstructor<T> {
        final /* synthetic */ Type val$type;

        AnonymousClass5(Type type) {
            this.val$type = type;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            Type type = this.val$type;
            if (type instanceof ParameterizedType) {
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    return (T) EnumSet.noneOf((Class) type2);
                }
                throw new JsonIOException("Invalid EnumSet type: " + this.val$type.toString());
            }
            throw new JsonIOException("Invalid EnumSet type: " + this.val$type.toString());
        }
    }

    private static <T> ObjectConstructor<T> newSpecialCollectionConstructor(Type type, Class<? super T> cls) {
        if (EnumSet.class.isAssignableFrom(cls)) {
            return new AnonymousClass5(type);
        }
        if (cls == EnumMap.class) {
            return new AnonymousClass6(type);
        }
        return null;
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.gson.internal.ConstructorConstructor$6, reason: invalid class name */
    class AnonymousClass6<T> implements ObjectConstructor<T> {
        final /* synthetic */ Type val$type;

        AnonymousClass6(Type type) {
            this.val$type = type;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            Type type = this.val$type;
            if (type instanceof ParameterizedType) {
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    return (T) new EnumMap((Class) type2);
                }
                throw new JsonIOException("Invalid EnumMap type: " + this.val$type.toString());
            }
            throw new JsonIOException("Invalid EnumMap type: " + this.val$type.toString());
        }
    }

    private static <T> ObjectConstructor<T> newDefaultConstructor(Class<? super T> cls, ReflectionAccessFilter.FilterResult filterResult) {
        String strTryMakeAccessible;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (filterResult != ReflectionAccessFilter.FilterResult.ALLOW && (!ReflectionAccessFilterHelper.canAccess(declaredConstructor, null) || (filterResult == ReflectionAccessFilter.FilterResult.BLOCK_ALL && !Modifier.isPublic(declaredConstructor.getModifiers())))) {
                return new AnonymousClass7("Unable to invoke no-args constructor of " + cls + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.");
            }
            if (filterResult == ReflectionAccessFilter.FilterResult.ALLOW && (strTryMakeAccessible = ReflectionHelper.tryMakeAccessible(declaredConstructor)) != null) {
                return new AnonymousClass8(strTryMakeAccessible);
            }
            return new AnonymousClass9(declaredConstructor);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.gson.internal.ConstructorConstructor$7, reason: invalid class name */
    class AnonymousClass7<T> implements ObjectConstructor<T> {
        final /* synthetic */ String val$message;

        AnonymousClass7(String str) {
            this.val$message = str;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            throw new JsonIOException(this.val$message);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.gson.internal.ConstructorConstructor$8, reason: invalid class name */
    class AnonymousClass8<T> implements ObjectConstructor<T> {
        final /* synthetic */ String val$exceptionMessage;

        AnonymousClass8(String str) {
            this.val$exceptionMessage = str;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            throw new JsonIOException(this.val$exceptionMessage);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.gson.internal.ConstructorConstructor$9, reason: invalid class name */
    class AnonymousClass9<T> implements ObjectConstructor<T> {
        final /* synthetic */ Constructor val$constructor;

        AnonymousClass9(Constructor constructor) {
            this.val$constructor = constructor;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            try {
                return (T) this.val$constructor.newInstance(new Object[0]);
            } catch (IllegalAccessException e) {
                throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e);
            } catch (InstantiationException e2) {
                throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(this.val$constructor) + "' with no args", e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(this.val$constructor) + "' with no args", e3.getCause());
            }
        }
    }

    private static <T> ObjectConstructor<T> newDefaultImplementationConstructor(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new AnonymousClass10();
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new AnonymousClass11();
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new AnonymousClass12();
            }
            return new AnonymousClass13();
        }
        if (!Map.class.isAssignableFrom(cls)) {
            return null;
        }
        if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
            return new AnonymousClass14();
        }
        if (ConcurrentMap.class.isAssignableFrom(cls)) {
            return new AnonymousClass15();
        }
        if (SortedMap.class.isAssignableFrom(cls)) {
            return new AnonymousClass16();
        }
        if ((type instanceof ParameterizedType) && !String.class.isAssignableFrom(TypeToken.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) {
            return new AnonymousClass17();
        }
        return new AnonymousClass18();
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.gson.internal.ConstructorConstructor$10, reason: invalid class name */
    class AnonymousClass10<T> implements ObjectConstructor<T> {
        AnonymousClass10() {
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) new TreeSet();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.gson.internal.ConstructorConstructor$11, reason: invalid class name */
    class AnonymousClass11<T> implements ObjectConstructor<T> {
        AnonymousClass11() {
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) new LinkedHashSet();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.gson.internal.ConstructorConstructor$12, reason: invalid class name */
    class AnonymousClass12<T> implements ObjectConstructor<T> {
        AnonymousClass12() {
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) new ArrayDeque();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.gson.internal.ConstructorConstructor$13, reason: invalid class name */
    class AnonymousClass13<T> implements ObjectConstructor<T> {
        AnonymousClass13() {
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) new ArrayList();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.gson.internal.ConstructorConstructor$14, reason: invalid class name */
    class AnonymousClass14<T> implements ObjectConstructor<T> {
        AnonymousClass14() {
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) new ConcurrentSkipListMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.gson.internal.ConstructorConstructor$15, reason: invalid class name */
    class AnonymousClass15<T> implements ObjectConstructor<T> {
        AnonymousClass15() {
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) new ConcurrentHashMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.gson.internal.ConstructorConstructor$16, reason: invalid class name */
    class AnonymousClass16<T> implements ObjectConstructor<T> {
        AnonymousClass16() {
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) new TreeMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.gson.internal.ConstructorConstructor$17, reason: invalid class name */
    class AnonymousClass17<T> implements ObjectConstructor<T> {
        AnonymousClass17() {
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) new LinkedHashMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.gson.internal.ConstructorConstructor$18, reason: invalid class name */
    class AnonymousClass18<T> implements ObjectConstructor<T> {
        AnonymousClass18() {
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) new LinkedTreeMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.gson.internal.ConstructorConstructor$19, reason: invalid class name */
    class AnonymousClass19<T> implements ObjectConstructor<T> {
        final /* synthetic */ Class val$rawType;

        AnonymousClass19(Class cls) {
            this.val$rawType = cls;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            try {
                return (T) UnsafeAllocator.INSTANCE.newInstance(this.val$rawType);
            } catch (Exception e) {
                throw new RuntimeException("Unable to create instance of " + this.val$rawType + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e);
            }
        }
    }

    private <T> ObjectConstructor<T> newUnsafeAllocator(Class<? super T> cls) {
        if (this.useJdkUnsafe) {
            return new AnonymousClass19(cls);
        }
        return new AnonymousClass20("Unable to create instance of " + cls + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.");
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.gson.internal.ConstructorConstructor$20, reason: invalid class name */
    class AnonymousClass20<T> implements ObjectConstructor<T> {
        final /* synthetic */ String val$exceptionMessage;

        AnonymousClass20(String str) {
            this.val$exceptionMessage = str;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            throw new JsonIOException(this.val$exceptionMessage);
        }
    }

    public String toString() {
        return this.instanceCreators.toString();
    }
}
