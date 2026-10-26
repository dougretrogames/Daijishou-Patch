package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.ReflectionAccessFilterHelper;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* INFO: loaded from: classes4.dex */
public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;
    private final Excluder excluder;
    private final FieldNamingStrategy fieldNamingPolicy;
    private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
    private final List<ReflectionAccessFilter> reflectionFilters;

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor, FieldNamingStrategy fieldNamingStrategy, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory, List<ReflectionAccessFilter> list) {
        this.constructorConstructor = constructorConstructor;
        this.fieldNamingPolicy = fieldNamingStrategy;
        this.excluder = excluder;
        this.jsonAdapterFactory = jsonAdapterAnnotationTypeAdapterFactory;
        this.reflectionFilters = list;
    }

    private boolean includeField(Field field, boolean z) {
        return (this.excluder.excludeClass(field.getType(), z) || this.excluder.excludeField(field, z)) ? false : true;
    }

    private List<String> getFieldNames(Field field) {
        SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
        if (serializedName == null) {
            return Collections.singletonList(this.fieldNamingPolicy.translateName(field));
        }
        String strValue = serializedName.value();
        String[] strArrAlternate = serializedName.alternate();
        if (strArrAlternate.length == 0) {
            return Collections.singletonList(strValue);
        }
        ArrayList arrayList = new ArrayList(strArrAlternate.length + 1);
        arrayList.add(strValue);
        Collections.addAll(arrayList, strArrAlternate);
        return arrayList;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        if (!Object.class.isAssignableFrom(rawType)) {
            return null;
        }
        ReflectionAccessFilter.FilterResult filterResult = ReflectionAccessFilterHelper.getFilterResult(this.reflectionFilters, rawType);
        if (filterResult == ReflectionAccessFilter.FilterResult.BLOCK_ALL) {
            throw new JsonIOException("ReflectionAccessFilter does not permit using reflection for " + rawType + ". Register a TypeAdapter for this type or adjust the access filter.");
        }
        boolean z = filterResult == ReflectionAccessFilter.FilterResult.BLOCK_INACCESSIBLE;
        if (ReflectionHelper.isRecord(rawType)) {
            return new RecordAdapter(rawType, getBoundFields(gson, typeToken, rawType, z, true), z);
        }
        return new FieldReflectionAdapter(this.constructorConstructor.get(typeToken), getBoundFields(gson, typeToken, rawType, z, false));
    }

    /* INFO: Access modifiers changed from: private */
    public static <M extends AccessibleObject & Member> void checkAccessible(Object obj, M m) {
        if (Modifier.isStatic(m.getModifiers())) {
            obj = null;
        }
        if (ReflectionAccessFilterHelper.canAccess(m, obj)) {
            return;
        }
        throw new JsonIOException(ReflectionHelper.getAccessibleObjectDescription(m, true) + " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type.");
    }

    private BoundField createBoundField(Gson gson, Field field, Method method, String str, TypeToken<?> typeToken, boolean z, boolean z2, boolean z3) {
        boolean zIsPrimitive = Primitives.isPrimitive(typeToken.getRawType());
        int modifiers = field.getModifiers();
        boolean z4 = Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers);
        JsonAdapter jsonAdapter = (JsonAdapter) field.getAnnotation(JsonAdapter.class);
        TypeAdapter<?> typeAdapter = jsonAdapter != null ? this.jsonAdapterFactory.getTypeAdapter(this.constructorConstructor, gson, typeToken, jsonAdapter) : null;
        boolean z5 = typeAdapter != null;
        if (typeAdapter == null) {
            typeAdapter = gson.getAdapter(typeToken);
        }
        return new AnonymousClass1(str, field, z, z2, z3, method, z5, typeAdapter, gson, typeToken, zIsPrimitive, z4);
    }

    /* INFO: renamed from: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$1, reason: invalid class name */
    class AnonymousClass1 extends BoundField {
        final /* synthetic */ Method val$accessor;
        final /* synthetic */ boolean val$blockInaccessible;
        final /* synthetic */ Gson val$context;
        final /* synthetic */ TypeToken val$fieldType;
        final /* synthetic */ boolean val$isPrimitive;
        final /* synthetic */ boolean val$isStaticFinalField;
        final /* synthetic */ boolean val$jsonAdapterPresent;
        final /* synthetic */ TypeAdapter val$typeAdapter;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Field field, boolean z, boolean z2, boolean z3, Method method, boolean z4, TypeAdapter typeAdapter, Gson gson, TypeToken typeToken, boolean z5, boolean z6) {
            super(str, field, z, z2);
            this.val$blockInaccessible = z3;
            this.val$accessor = method;
            this.val$jsonAdapterPresent = z4;
            this.val$typeAdapter = typeAdapter;
            this.val$context = gson;
            this.val$fieldType = typeToken;
            this.val$isPrimitive = z5;
            this.val$isStaticFinalField = z6;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
        void write(JsonWriter jsonWriter, Object obj) throws IllegalAccessException, IOException {
            Object objInvoke;
            if (this.serialized) {
                if (this.val$blockInaccessible) {
                    Method method = this.val$accessor;
                    if (method == null) {
                        ReflectiveTypeAdapterFactory.checkAccessible(obj, this.field);
                    } else {
                        ReflectiveTypeAdapterFactory.checkAccessible(obj, method);
                    }
                }
                Method method2 = this.val$accessor;
                if (method2 != null) {
                    try {
                        objInvoke = method2.invoke(obj, new Object[0]);
                    } catch (InvocationTargetException e) {
                        throw new JsonIOException("Accessor " + ReflectionHelper.getAccessibleObjectDescription(this.val$accessor, false) + " threw exception", e.getCause());
                    }
                } else {
                    objInvoke = this.field.get(obj);
                }
                if (objInvoke == obj) {
                    return;
                }
                jsonWriter.name(this.name);
                (this.val$jsonAdapterPresent ? this.val$typeAdapter : new TypeAdapterRuntimeTypeWrapper(this.val$context, this.val$typeAdapter, this.val$fieldType.getType())).write(jsonWriter, objInvoke);
            }
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
        void readIntoArray(JsonReader jsonReader, int i, Object[] objArr) throws JsonParseException, IOException {
            Object obj = this.val$typeAdapter.read(jsonReader);
            if (obj == null && this.val$isPrimitive) {
                throw new JsonParseException("null is not allowed as value for record component '" + this.fieldName + "' of primitive type; at path " + jsonReader.getPath());
            }
            objArr[i] = obj;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
        void readIntoField(JsonReader jsonReader, Object obj) throws IllegalAccessException, IOException {
            Object obj2 = this.val$typeAdapter.read(jsonReader);
            if (obj2 == null && this.val$isPrimitive) {
                return;
            }
            if (this.val$blockInaccessible) {
                ReflectiveTypeAdapterFactory.checkAccessible(obj, this.field);
            } else if (this.val$isStaticFinalField) {
                throw new JsonIOException("Cannot set value of 'static final' " + ReflectionHelper.getAccessibleObjectDescription(this.field, false));
            }
            this.field.set(obj, obj2);
        }
    }

    /* WARN: Code duplicated, block: B:48:0x00eb  */
    /* WARN: Code duplicated, block: B:50:0x00f3  */
    /* WARN: Code duplicated, block: B:53:0x010f  */
    /* WARN: Code duplicated, block: B:65:0x0130 A[SYNTHETIC] */
    /* WARN: Code duplicated, block: B:68:0x0122 A[SYNTHETIC] */
    /* WARN: Code duplicated, block: B:71:0x0110 A[SYNTHETIC] */
    private Map<String, BoundField> getBoundFields(Gson gson, TypeToken<?> typeToken, Class<?> cls, boolean z, boolean z2) {
        boolean z3;
        Method method;
        Type typeResolve;
        List<String> fieldNames;
        int size;
        BoundField boundField;
        int i;
        int i2;
        int i3;
        BoundField boundField2;
        Class<?> cls2 = cls;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!cls2.isInterface()) {
            TypeToken<?> typeToken2 = typeToken;
            boolean z4 = z;
            Class<?> rawType = cls2;
            while (rawType != Object.class) {
                Field[] declaredFields = rawType.getDeclaredFields();
                boolean z5 = true;
                boolean z6 = false;
                if (rawType != cls2 && declaredFields.length > 0) {
                    ReflectionAccessFilter.FilterResult filterResult = ReflectionAccessFilterHelper.getFilterResult(this.reflectionFilters, rawType);
                    if (filterResult == ReflectionAccessFilter.FilterResult.BLOCK_ALL) {
                        throw new JsonIOException("ReflectionAccessFilter does not permit using reflection for " + rawType + " (supertype of " + cls2 + "). Register a TypeAdapter for this type or adjust the access filter.");
                    }
                    z4 = filterResult == ReflectionAccessFilter.FilterResult.BLOCK_INACCESSIBLE;
                }
                boolean z7 = z4;
                int length = declaredFields.length;
                int i4 = 0;
                while (i4 < length) {
                    int i5 = i4;
                    Field field = declaredFields[i5];
                    boolean zIncludeField = this.includeField(field, z5);
                    boolean zIncludeField2 = this.includeField(field, z6);
                    if (zIncludeField || zIncludeField2) {
                        if (z2) {
                            if (Modifier.isStatic(field.getModifiers())) {
                                z3 = z6;
                            } else {
                                Method accessor = ReflectionHelper.getAccessor(rawType, field);
                                if (!z7) {
                                    ReflectionHelper.makeAccessible(accessor);
                                }
                                if (accessor.getAnnotation(SerializedName.class) != null && field.getAnnotation(SerializedName.class) == null) {
                                    throw new JsonIOException("@SerializedName on " + ReflectionHelper.getAccessibleObjectDescription(accessor, z6) + " is not supported");
                                }
                                i5 = i5;
                                method = accessor;
                                z3 = zIncludeField2;
                            }
                            if (!z7 && method == null) {
                                ReflectionHelper.makeAccessible(field);
                            }
                            typeResolve = C$Gson$Types.resolve(typeToken2.getType(), rawType, field.getGenericType());
                            fieldNames = this.getFieldNames(field);
                            size = fieldNames.size();
                            boundField = null;
                            i = 0;
                            while (i < size) {
                                String str = fieldNames.get(i);
                                if (i != 0) {
                                    zIncludeField = false;
                                }
                                int i6 = i5;
                                List<String> list = fieldNames;
                                boolean z8 = zIncludeField;
                                int i7 = length;
                                boundField2 = (BoundField) linkedHashMap.put(str, this.createBoundField(gson, field, method, str, TypeToken.get(typeResolve), z8, z3, z7));
                                if (boundField == null) {
                                    boundField = boundField2;
                                }
                                i++;
                                this = this;
                                zIncludeField = z8;
                                length = i7;
                                i5 = i6;
                                fieldNames = list;
                            }
                            i2 = length;
                            i3 = i5;
                            if (boundField == null) {
                                throw new IllegalArgumentException("Class " + cls.getName() + " declares multiple JSON fields named '" + boundField.name + "'; conflict is caused by fields " + ReflectionHelper.fieldToString(boundField.field) + " and " + ReflectionHelper.fieldToString(field));
                            }
                        } else {
                            z3 = zIncludeField2;
                        }
                        method = null;
                        if (!z7) {
                            ReflectionHelper.makeAccessible(field);
                        }
                        typeResolve = C$Gson$Types.resolve(typeToken2.getType(), rawType, field.getGenericType());
                        fieldNames = this.getFieldNames(field);
                        size = fieldNames.size();
                        boundField = null;
                        i = 0;
                        while (i < size) {
                            String str2 = fieldNames.get(i);
                            if (i != 0) {
                                zIncludeField = false;
                            }
                            int i8 = i5;
                            List<String> list2 = fieldNames;
                            boolean z9 = zIncludeField;
                            int i9 = length;
                            boundField2 = (BoundField) linkedHashMap.put(str2, this.createBoundField(gson, field, method, str2, TypeToken.get(typeResolve), z9, z3, z7));
                            if (boundField == null) {
                                boundField = boundField2;
                            }
                            i++;
                            this = this;
                            zIncludeField = z9;
                            length = i9;
                            i5 = i8;
                            fieldNames = list2;
                        }
                        i2 = length;
                        i3 = i5;
                        if (boundField == null) {
                            throw new IllegalArgumentException("Class " + cls.getName() + " declares multiple JSON fields named '" + boundField.name + "'; conflict is caused by fields " + ReflectionHelper.fieldToString(boundField.field) + " and " + ReflectionHelper.fieldToString(field));
                        }
                    } else {
                        i2 = length;
                        i3 = i5;
                    }
                    i4 = i3 + 1;
                    this = this;
                    typeToken2 = typeToken2;
                    length = i2;
                    z5 = true;
                    z6 = false;
                }
                typeToken2 = TypeToken.get(C$Gson$Types.resolve(typeToken2.getType(), rawType, rawType.getGenericSuperclass()));
                rawType = typeToken2.getRawType();
                cls2 = cls;
                z4 = z7;
            }
        }
        return linkedHashMap;
    }

    static abstract class BoundField {
        final boolean deserialized;
        final Field field;
        final String fieldName;
        final String name;
        final boolean serialized;

        abstract void readIntoArray(JsonReader jsonReader, int i, Object[] objArr) throws JsonParseException, IOException;

        abstract void readIntoField(JsonReader jsonReader, Object obj) throws IllegalAccessException, IOException;

        abstract void write(JsonWriter jsonWriter, Object obj) throws IllegalAccessException, IOException;

        protected BoundField(String str, Field field, boolean z, boolean z2) {
            this.name = str;
            this.field = field;
            this.fieldName = field.getName();
            this.serialized = z;
            this.deserialized = z2;
        }
    }

    public static abstract class Adapter<T, A> extends TypeAdapter<T> {
        final Map<String, BoundField> boundFields;

        abstract A createAccumulator();

        abstract T finalize(A a);

        abstract void readField(A a, JsonReader jsonReader, BoundField boundField) throws IllegalAccessException, IOException;

        Adapter(Map<String, BoundField> map) {
            this.boundFields = map;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, T t) throws IOException {
            if (t == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                Iterator<BoundField> it = this.boundFields.values().iterator();
                while (it.hasNext()) {
                    it.next().write(jsonWriter, t);
                }
                jsonWriter.endObject();
            } catch (IllegalAccessException e) {
                throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            A aCreateAccumulator = createAccumulator();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    BoundField boundField = this.boundFields.get(jsonReader.nextName());
                    if (boundField == null || !boundField.deserialized) {
                        jsonReader.skipValue();
                    } else {
                        readField(aCreateAccumulator, jsonReader, boundField);
                    }
                }
                jsonReader.endObject();
                return finalize(aCreateAccumulator);
            } catch (IllegalAccessException e) {
                throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e);
            } catch (IllegalStateException e2) {
                throw new JsonSyntaxException(e2);
            }
        }
    }

    private static final class FieldReflectionAdapter<T> extends Adapter<T, T> {
        private final ObjectConstructor<T> constructor;

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        T finalize(T t) {
            return t;
        }

        FieldReflectionAdapter(ObjectConstructor<T> objectConstructor, Map<String, BoundField> map) {
            super(map);
            this.constructor = objectConstructor;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        T createAccumulator() {
            return this.constructor.construct();
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        void readField(T t, JsonReader jsonReader, BoundField boundField) throws IllegalAccessException, IOException {
            boundField.readIntoField(jsonReader, t);
        }
    }

    private static final class RecordAdapter<T> extends Adapter<T, Object[]> {
        static final Map<Class<?>, Object> PRIMITIVE_DEFAULTS = primitiveDefaults();
        private final Map<String, Integer> componentIndices;
        private final Constructor<T> constructor;
        private final Object[] constructorArgsDefaults;

        RecordAdapter(Class<T> cls, Map<String, BoundField> map, boolean z) {
            super(map);
            this.componentIndices = new HashMap();
            Constructor<T> canonicalRecordConstructor = ReflectionHelper.getCanonicalRecordConstructor(cls);
            this.constructor = canonicalRecordConstructor;
            if (z) {
                ReflectiveTypeAdapterFactory.checkAccessible(null, canonicalRecordConstructor);
            } else {
                ReflectionHelper.makeAccessible(canonicalRecordConstructor);
            }
            String[] recordComponentNames = ReflectionHelper.getRecordComponentNames(cls);
            for (int i = 0; i < recordComponentNames.length; i++) {
                this.componentIndices.put(recordComponentNames[i], Integer.valueOf(i));
            }
            Class<?>[] parameterTypes = this.constructor.getParameterTypes();
            this.constructorArgsDefaults = new Object[parameterTypes.length];
            for (int i2 = 0; i2 < parameterTypes.length; i2++) {
                this.constructorArgsDefaults[i2] = PRIMITIVE_DEFAULTS.get(parameterTypes[i2]);
            }
        }

        private static Map<Class<?>, Object> primitiveDefaults() {
            HashMap map = new HashMap();
            map.put(Byte.TYPE, (byte) 0);
            map.put(Short.TYPE, (short) 0);
            map.put(Integer.TYPE, 0);
            map.put(Long.TYPE, 0L);
            map.put(Float.TYPE, Float.valueOf(0.0f));
            map.put(Double.TYPE, Double.valueOf(0.0d));
            map.put(Character.TYPE, (char) 0);
            map.put(Boolean.TYPE, false);
            return map;
        }

        /* INFO: Access modifiers changed from: package-private */
        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public Object[] createAccumulator() {
            return (Object[]) this.constructorArgsDefaults.clone();
        }

        /* INFO: Access modifiers changed from: package-private */
        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public void readField(Object[] objArr, JsonReader jsonReader, BoundField boundField) throws IOException {
            Integer num = this.componentIndices.get(boundField.fieldName);
            if (num == null) {
                throw new IllegalStateException("Could not find the index in the constructor '" + ReflectionHelper.constructorToString(this.constructor) + "' for field with name '" + boundField.fieldName + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
            }
            boundField.readIntoArray(jsonReader, num.intValue(), objArr);
        }

        /* INFO: Access modifiers changed from: package-private */
        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public T finalize(Object[] objArr) {
            try {
                return this.constructor.newInstance(objArr);
            } catch (IllegalAccessException e) {
                throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e);
            } catch (IllegalArgumentException e2) {
                e = e2;
                throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(this.constructor) + "' with args " + Arrays.toString(objArr), e);
            } catch (InstantiationException e3) {
                e = e3;
                throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(this.constructor) + "' with args " + Arrays.toString(objArr), e);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(this.constructor) + "' with args " + Arrays.toString(objArr), e4.getCause());
            }
        }
    }
}
