package com.google.common.reflect;

import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.CheckForNull;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes4.dex */
@ElementTypesAreNonnullByDefault
public final class TypeResolver {
    private final TypeTable typeTable;

    /* synthetic */ TypeResolver(TypeTable typeTable, AnonymousClass1 anonymousClass1) {
        this(typeTable);
    }

    public TypeResolver() {
        this.typeTable = new TypeTable();
    }

    private TypeResolver(TypeTable typeTable) {
        this.typeTable = typeTable;
    }

    static TypeResolver covariantly(Type contextType) {
        return new TypeResolver().where(TypeMappingIntrospector.getTypeMappings(contextType));
    }

    static TypeResolver invariantly(Type contextType) {
        return new TypeResolver().where(TypeMappingIntrospector.getTypeMappings(WildcardCapturer.INSTANCE.capture(contextType)));
    }

    public TypeResolver where(Type formal, Type actual) {
        HashMap mapNewHashMap = Maps.newHashMap();
        populateTypeMappings(mapNewHashMap, (Type) Preconditions.checkNotNull(formal), (Type) Preconditions.checkNotNull(actual));
        return where(mapNewHashMap);
    }

    TypeResolver where(Map<TypeVariableKey, ? extends Type> mappings) {
        return new TypeResolver(this.typeTable.where(mappings));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void populateTypeMappings(Map<TypeVariableKey, Type> mappings, Type from, Type to) {
        if (from.equals(to)) {
            return;
        }
        new AnonymousClass1(mappings, to).visit(from);
    }

    /* JADX INFO: renamed from: com.google.common.reflect.TypeResolver$1, reason: invalid class name */
    class AnonymousClass1 extends TypeVisitor {
        final /* synthetic */ Map val$mappings;
        final /* synthetic */ Type val$to;

        AnonymousClass1(final Map val$mappings, final Type val$to) {
            this.val$mappings = val$mappings;
            this.val$to = val$to;
        }

        @Override // com.google.common.reflect.TypeVisitor
        void visitTypeVariable(TypeVariable<?> typeVariable) {
            this.val$mappings.put(new TypeVariableKey(typeVariable), this.val$to);
        }

        @Override // com.google.common.reflect.TypeVisitor
        void visitWildcardType(WildcardType fromWildcardType) {
            Type type = this.val$to;
            if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                Type[] upperBounds = fromWildcardType.getUpperBounds();
                Type[] upperBounds2 = wildcardType.getUpperBounds();
                Type[] lowerBounds = fromWildcardType.getLowerBounds();
                Type[] lowerBounds2 = wildcardType.getLowerBounds();
                Preconditions.checkArgument(upperBounds.length == upperBounds2.length && lowerBounds.length == lowerBounds2.length, "Incompatible type: %s vs. %s", fromWildcardType, this.val$to);
                for (int i = 0; i < upperBounds.length; i++) {
                    TypeResolver.populateTypeMappings(this.val$mappings, upperBounds[i], upperBounds2[i]);
                }
                for (int i2 = 0; i2 < lowerBounds.length; i2++) {
                    TypeResolver.populateTypeMappings(this.val$mappings, lowerBounds[i2], lowerBounds2[i2]);
                }
            }
        }

        @Override // com.google.common.reflect.TypeVisitor
        void visitParameterizedType(ParameterizedType fromParameterizedType) {
            Type type = this.val$to;
            if (type instanceof WildcardType) {
                return;
            }
            ParameterizedType parameterizedType = (ParameterizedType) TypeResolver.expectArgument(ParameterizedType.class, type);
            if (fromParameterizedType.getOwnerType() != null && parameterizedType.getOwnerType() != null) {
                TypeResolver.populateTypeMappings(this.val$mappings, fromParameterizedType.getOwnerType(), parameterizedType.getOwnerType());
            }
            Preconditions.checkArgument(fromParameterizedType.getRawType().equals(parameterizedType.getRawType()), "Inconsistent raw type: %s vs. %s", fromParameterizedType, this.val$to);
            Type[] actualTypeArguments = fromParameterizedType.getActualTypeArguments();
            Type[] actualTypeArguments2 = parameterizedType.getActualTypeArguments();
            Preconditions.checkArgument(actualTypeArguments.length == actualTypeArguments2.length, "%s not compatible with %s", fromParameterizedType, parameterizedType);
            for (int i = 0; i < actualTypeArguments.length; i++) {
                TypeResolver.populateTypeMappings(this.val$mappings, actualTypeArguments[i], actualTypeArguments2[i]);
            }
        }

        @Override // com.google.common.reflect.TypeVisitor
        void visitGenericArrayType(GenericArrayType fromArrayType) {
            Type type = this.val$to;
            if (type instanceof WildcardType) {
                return;
            }
            Type componentType = Types.getComponentType(type);
            Preconditions.checkArgument(componentType != null, "%s is not an array type.", this.val$to);
            TypeResolver.populateTypeMappings(this.val$mappings, fromArrayType.getGenericComponentType(), componentType);
        }

        @Override // com.google.common.reflect.TypeVisitor
        void visitClass(Class<?> fromClass) {
            if (!(this.val$to instanceof WildcardType)) {
                throw new IllegalArgumentException("No type mapping from " + fromClass + " to " + this.val$to);
            }
        }
    }

    public Type resolveType(Type type) {
        Preconditions.checkNotNull(type);
        if (type instanceof TypeVariable) {
            return this.typeTable.resolve((TypeVariable) type);
        }
        if (type instanceof ParameterizedType) {
            return resolveParameterizedType((ParameterizedType) type);
        }
        if (type instanceof GenericArrayType) {
            return resolveGenericArrayType((GenericArrayType) type);
        }
        return type instanceof WildcardType ? resolveWildcardType((WildcardType) type) : type;
    }

    Type[] resolveTypesInPlace(Type[] types) {
        for (int i = 0; i < types.length; i++) {
            types[i] = resolveType(types[i]);
        }
        return types;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Type[] resolveTypes(Type[] types) {
        Type[] typeArr = new Type[types.length];
        for (int i = 0; i < types.length; i++) {
            typeArr[i] = resolveType(types[i]);
        }
        return typeArr;
    }

    private WildcardType resolveWildcardType(WildcardType type) {
        return new Types.WildcardTypeImpl(resolveTypes(type.getLowerBounds()), resolveTypes(type.getUpperBounds()));
    }

    private Type resolveGenericArrayType(GenericArrayType type) {
        return Types.newArrayType(resolveType(type.getGenericComponentType()));
    }

    private ParameterizedType resolveParameterizedType(ParameterizedType type) {
        Type ownerType = type.getOwnerType();
        return Types.newParameterizedTypeWithOwner(ownerType == null ? null : resolveType(ownerType), (Class) resolveType(type.getRawType()), resolveTypes(type.getActualTypeArguments()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T expectArgument(Class<T> type, Object arg) {
        try {
            return type.cast(arg);
        } catch (ClassCastException unused) {
            throw new IllegalArgumentException(arg + " is not a " + type.getSimpleName());
        }
    }

    private static class TypeTable {
        private final ImmutableMap<TypeVariableKey, Type> map;

        TypeTable() {
            this.map = ImmutableMap.of();
        }

        private TypeTable(ImmutableMap<TypeVariableKey, Type> map) {
            this.map = map;
        }

        final TypeTable where(Map<TypeVariableKey, ? extends Type> mappings) {
            ImmutableMap.Builder builder = ImmutableMap.builder();
            builder.putAll(this.map);
            for (Map.Entry<TypeVariableKey, ? extends Type> entry : mappings.entrySet()) {
                TypeVariableKey key = entry.getKey();
                Type value = entry.getValue();
                Preconditions.checkArgument(!key.equalsType(value), "Type variable %s bound to itself", key);
                builder.put(key, value);
            }
            return new TypeTable(builder.buildOrThrow());
        }

        /* JADX INFO: renamed from: com.google.common.reflect.TypeResolver$TypeTable$1, reason: invalid class name */
        class AnonymousClass1 extends TypeTable {
            final /* synthetic */ TypeTable val$unguarded;
            final /* synthetic */ TypeVariable val$var;

            AnonymousClass1(final TypeTable this$0, final TypeVariable val$var, final TypeTable val$unguarded) {
                this.val$var = val$var;
                this.val$unguarded = val$unguarded;
            }

            @Override // com.google.common.reflect.TypeResolver.TypeTable
            public Type resolveInternal(TypeVariable<?> intermediateVar, TypeTable forDependent) {
                return intermediateVar.getGenericDeclaration().equals(this.val$var.getGenericDeclaration()) ? intermediateVar : this.val$unguarded.resolveInternal(intermediateVar, forDependent);
            }
        }

        final Type resolve(TypeVariable<?> var) {
            return resolveInternal(var, new AnonymousClass1(this, var, this));
        }

        Type resolveInternal(TypeVariable<?> var, TypeTable forDependants) {
            Type type = this.map.get(new TypeVariableKey(var));
            if (type == null) {
                Type[] bounds = var.getBounds();
                if (bounds.length != 0) {
                    Type[] typeArrResolveTypes = new TypeResolver(forDependants, null).resolveTypes(bounds);
                    if (!Types.NativeTypeVariableEquals.NATIVE_TYPE_VARIABLE_ONLY || !Arrays.equals(bounds, typeArrResolveTypes)) {
                        return Types.newArtificialTypeVariable(var.getGenericDeclaration(), var.getName(), typeArrResolveTypes);
                    }
                }
                return var;
            }
            return new TypeResolver(forDependants, null).resolveType(type);
        }
    }

    private static final class TypeMappingIntrospector extends TypeVisitor {
        private final Map<TypeVariableKey, Type> mappings = Maps.newHashMap();

        private TypeMappingIntrospector() {
        }

        static ImmutableMap<TypeVariableKey, Type> getTypeMappings(Type contextType) {
            Preconditions.checkNotNull(contextType);
            TypeMappingIntrospector typeMappingIntrospector = new TypeMappingIntrospector();
            typeMappingIntrospector.visit(contextType);
            return ImmutableMap.copyOf((Map) typeMappingIntrospector.mappings);
        }

        @Override // com.google.common.reflect.TypeVisitor
        void visitClass(Class<?> clazz) {
            visit(clazz.getGenericSuperclass());
            visit(clazz.getGenericInterfaces());
        }

        @Override // com.google.common.reflect.TypeVisitor
        void visitParameterizedType(ParameterizedType parameterizedType) {
            Class cls = (Class) parameterizedType.getRawType();
            TypeVariable[] typeParameters = cls.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            Preconditions.checkState(typeParameters.length == actualTypeArguments.length);
            for (int i = 0; i < typeParameters.length; i++) {
                map(new TypeVariableKey(typeParameters[i]), actualTypeArguments[i]);
            }
            visit(cls);
            visit(parameterizedType.getOwnerType());
        }

        @Override // com.google.common.reflect.TypeVisitor
        void visitTypeVariable(TypeVariable<?> t) {
            visit(t.getBounds());
        }

        @Override // com.google.common.reflect.TypeVisitor
        void visitWildcardType(WildcardType t) {
            visit(t.getUpperBounds());
        }

        private void map(TypeVariableKey var, Type arg) {
            if (this.mappings.containsKey(var)) {
                return;
            }
            Type type = arg;
            while (type != null) {
                if (var.equalsType(type)) {
                    while (arg != null) {
                        arg = this.mappings.remove(TypeVariableKey.forLookup(arg));
                    }
                    return;
                }
                type = this.mappings.get(TypeVariableKey.forLookup(type));
            }
            this.mappings.put(var, arg);
        }
    }

    private static class WildcardCapturer {
        static final WildcardCapturer INSTANCE = new WildcardCapturer();

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final AtomicInteger f52id;

        /* synthetic */ WildcardCapturer(AtomicInteger atomicInteger, AnonymousClass1 anonymousClass1) {
            this(atomicInteger);
        }

        private WildcardCapturer() {
            this(new AtomicInteger());
        }

        private WildcardCapturer(AtomicInteger id2) {
            this.f52id = id2;
        }

        final Type capture(Type type) {
            Preconditions.checkNotNull(type);
            if ((type instanceof Class) || (type instanceof TypeVariable)) {
                return type;
            }
            if (type instanceof GenericArrayType) {
                return Types.newArrayType(notForTypeVariable().capture(((GenericArrayType) type).getGenericComponentType()));
            }
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Class cls = (Class) parameterizedType.getRawType();
                TypeVariable<?>[] typeParameters = cls.getTypeParameters();
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                for (int i = 0; i < actualTypeArguments.length; i++) {
                    actualTypeArguments[i] = forTypeVariable(typeParameters[i]).capture(actualTypeArguments[i]);
                }
                return Types.newParameterizedTypeWithOwner(notForTypeVariable().captureNullable(parameterizedType.getOwnerType()), cls, actualTypeArguments);
            }
            if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                return wildcardType.getLowerBounds().length == 0 ? captureAsTypeVariable(wildcardType.getUpperBounds()) : type;
            }
            throw new AssertionError("must have been one of the known types");
        }

        TypeVariable<?> captureAsTypeVariable(Type[] upperBounds) {
            return Types.newArtificialTypeVariable(WildcardCapturer.class, "capture#" + this.f52id.incrementAndGet() + "-of ? extends " + Joiner.on(Typography.amp).join(upperBounds), upperBounds);
        }

        /* JADX INFO: renamed from: com.google.common.reflect.TypeResolver$WildcardCapturer$1, reason: invalid class name */
        class AnonymousClass1 extends WildcardCapturer {
            final /* synthetic */ TypeVariable val$typeParam;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(final WildcardCapturer this$0, AtomicInteger id2, final TypeVariable val$typeParam) {
                super(id2, null);
                this.val$typeParam = val$typeParam;
            }

            @Override // com.google.common.reflect.TypeResolver.WildcardCapturer
            TypeVariable<?> captureAsTypeVariable(Type[] upperBounds) {
                LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(upperBounds));
                linkedHashSet.addAll(Arrays.asList(this.val$typeParam.getBounds()));
                if (linkedHashSet.size() > 1) {
                    linkedHashSet.remove(Object.class);
                }
                return super.captureAsTypeVariable((Type[]) linkedHashSet.toArray(new Type[0]));
            }
        }

        private WildcardCapturer forTypeVariable(TypeVariable<?> typeParam) {
            return new AnonymousClass1(this, this.f52id, typeParam);
        }

        private WildcardCapturer notForTypeVariable() {
            return new WildcardCapturer(this.f52id);
        }

        @CheckForNull
        private Type captureNullable(@CheckForNull Type type) {
            if (type == null) {
                return null;
            }
            return capture(type);
        }
    }

    static final class TypeVariableKey {
        private final TypeVariable<?> var;

        TypeVariableKey(TypeVariable<?> var) {
            this.var = (TypeVariable) Preconditions.checkNotNull(var);
        }

        public int hashCode() {
            return Objects.hashCode(this.var.getGenericDeclaration(), this.var.getName());
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof TypeVariableKey) {
                return equalsTypeVariable(((TypeVariableKey) obj).var);
            }
            return false;
        }

        public String toString() {
            return this.var.toString();
        }

        @CheckForNull
        static TypeVariableKey forLookup(Type t) {
            if (t instanceof TypeVariable) {
                return new TypeVariableKey((TypeVariable) t);
            }
            return null;
        }

        boolean equalsType(Type type) {
            if (type instanceof TypeVariable) {
                return equalsTypeVariable((TypeVariable) type);
            }
            return false;
        }

        private boolean equalsTypeVariable(TypeVariable<?> that) {
            return this.var.getGenericDeclaration().equals(that.getGenericDeclaration()) && this.var.getName().equals(that.getName());
        }
    }
}
