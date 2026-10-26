package androidx.navigation.serialization;

import androidx.exifinterface.media.ExifInterface;
import androidx.navigation.NamedNavArgument;
import androidx.navigation.NamedNavArgumentKt;
import androidx.navigation.NavType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.descriptors.ContextAwareKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: RouteSerializer.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a;\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u00022\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00070\u0006H\u0007¢\u0006\u0002\u0010\b\u001a(\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0002\u001a&\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0011H\u0002\u001a.\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0007*\u00020\u00132\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006H\u0002\u001a\u008e\u0001\u0010\u0015\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00070\u00062S\u0010\u0016\u001aO\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001c\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u000e0\u0017H\u0003¢\u0006\u0002\b\u001e\u001a\u008c\u0001\u0010\u0015\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00062S\u0010\u0016\u001aO\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001c\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u000e0\u0017H\u0003¢\u0006\u0002\b\u001f\u001a\u0018\u0010 \u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000fH\u0007\u001a8\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006H\u0007\u001a>\u0010$\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00062\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\f\u0010&\u001a\u00020'*\u00020\u0013H\u0000¨\u0006("}, d2 = {"generateRouteWithArgs", "", ExifInterface.GPS_DIRECTION_TRUE, "", "route", "typeMap", "", "Landroidx/navigation/NavType;", "(Ljava/lang/Object;Ljava/util/Map;)Ljava/lang/String;", "unknownNavTypeErrorMessage", "fieldName", "fieldType", "className", "assertNotAbstractClass", "", "Lkotlinx/serialization/KSerializer;", "handler", "Lkotlin/Function0;", "computeNavType", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlin/reflect/KType;", "forEachIndexed", "operation", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", ConfigConstants.CONFIG_INDEX_SECTION, "argName", "navType", "forEachIndexedName", "forEachIndexedKType", "generateHashCode", "generateNavArguments", "", "Landroidx/navigation/NamedNavArgument;", "generateRoutePattern", "path", "isValueClass", "", "navigation-common_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RouteSerializerKt {
    public static /* synthetic */ String generateRoutePattern$default(KSerializer kSerializer, Map map, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            map = MapsKt.emptyMap();
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return generateRoutePattern(kSerializer, map, str);
    }

    /* INFO: renamed from: androidx.navigation.serialization.RouteSerializerKt$generateRoutePattern$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: RouteSerializer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C01811 extends Lambda implements Function0<Unit> {
        final /* synthetic */ KSerializer<T> $this_generateRoutePattern;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01811(KSerializer<T> kSerializer) {
            super(0);
            this.$this_generateRoutePattern = kSerializer;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StringBuilder sb = new StringBuilder("Cannot generate route pattern from polymorphic class ");
            KClass<?> capturedKClass = ContextAwareKt.getCapturedKClass(this.$this_generateRoutePattern.getDescriptor());
            throw new IllegalArgumentException(sb.append(capturedKClass != null ? capturedKClass.getSimpleName() : null).append(". Routes can only be generated from concrete classes or objects.").toString());
        }
    }

    public static final <T> String generateRoutePattern(KSerializer<T> kSerializer, Map<KType, ? extends NavType<?>> typeMap, String str) {
        RouteBuilder routeBuilder;
        Intrinsics.checkNotNullParameter(kSerializer, "<this>");
        Intrinsics.checkNotNullParameter(typeMap, "typeMap");
        assertNotAbstractClass(kSerializer, new C01811(kSerializer));
        if (str != null) {
            routeBuilder = new RouteBuilder(str, kSerializer);
        } else {
            routeBuilder = new RouteBuilder(kSerializer);
        }
        forEachIndexedKType(kSerializer, typeMap, new AnonymousClass2(routeBuilder));
        return routeBuilder.build();
    }

    /* INFO: renamed from: androidx.navigation.serialization.RouteSerializerKt$generateRoutePattern$2, reason: invalid class name */
    /* INFO: compiled from: RouteSerializer.kt */
    @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, ConfigConstants.CONFIG_INDEX_SECTION, "", "argName", "", "navType", "Landroidx/navigation/NavType;", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass2 extends Lambda implements Function3<Integer, String, NavType<Object>, Unit> {
        final /* synthetic */ RouteBuilder<T> $builder;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(RouteBuilder<T> routeBuilder) {
            super(3);
            this.$builder = routeBuilder;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, NavType<Object> navType) {
            invoke(num.intValue(), str, navType);
            return Unit.INSTANCE;
        }

        /* WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class decompiler.core.dex.instructions.args.ArgType$PrimitiveArg
        	at decompiler.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at decompiler.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at decompiler.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void invoke(int i, String argName, NavType<Object> navType) {
            Intrinsics.checkNotNullParameter(argName, "argName");
            Intrinsics.checkNotNullParameter(navType, "navType");
            this.$builder.appendPattern(i, argName, navType);
        }
    }

    public static /* synthetic */ List generateNavArguments$default(KSerializer kSerializer, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = MapsKt.emptyMap();
        }
        return generateNavArguments(kSerializer, map);
    }

    /* INFO: renamed from: androidx.navigation.serialization.RouteSerializerKt$generateNavArguments$1, reason: invalid class name */
    /* INFO: compiled from: RouteSerializer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        final /* synthetic */ KSerializer<T> $this_generateNavArguments;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(KSerializer<T> kSerializer) {
            super(0);
            this.$this_generateNavArguments = kSerializer;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            throw new IllegalArgumentException("Cannot generate NavArguments for polymorphic serializer " + this.$this_generateNavArguments + ". Arguments can only be generated from concrete classes or objects.");
        }
    }

    public static final <T> List<NamedNavArgument> generateNavArguments(KSerializer<T> kSerializer, Map<KType, ? extends NavType<?>> typeMap) {
        Intrinsics.checkNotNullParameter(kSerializer, "<this>");
        Intrinsics.checkNotNullParameter(typeMap, "typeMap");
        assertNotAbstractClass(kSerializer, new AnonymousClass1(kSerializer));
        int elementsCount = kSerializer.getDescriptor().getElementsCount();
        ArrayList arrayList = new ArrayList(elementsCount);
        for (int i = 0; i < elementsCount; i++) {
            String elementName = kSerializer.getDescriptor().getElementName(i);
            arrayList.add(NamedNavArgumentKt.navArgument(elementName, new RouteSerializerKt$generateNavArguments$2$1(kSerializer, i, typeMap, elementName)));
        }
        return arrayList;
    }

    public static final <T> String generateRouteWithArgs(T route, Map<String, ? extends NavType<Object>> typeMap) {
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(typeMap, "typeMap");
        KSerializer kSerializerSerializer = SerializersKt.serializer(Reflection.getOrCreateKotlinClass(route.getClass()));
        Map<String, List<String>> mapEncodeToArgMap = new RouteEncoder(kSerializerSerializer, typeMap).encodeToArgMap(route);
        RouteBuilder routeBuilder = new RouteBuilder(kSerializerSerializer);
        forEachIndexedName(kSerializerSerializer, typeMap, new C01821(mapEncodeToArgMap, routeBuilder));
        return routeBuilder.build();
    }

    /* INFO: renamed from: androidx.navigation.serialization.RouteSerializerKt$generateRouteWithArgs$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: RouteSerializer.kt */
    @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", ConfigConstants.CONFIG_INDEX_SECTION, "", "argName", "", "navType", "Landroidx/navigation/NavType;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C01821 extends Lambda implements Function3<Integer, String, NavType<Object>, Unit> {
        final /* synthetic */ Map<String, List<String>> $argMap;
        final /* synthetic */ RouteBuilder<? extends T> $builder;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* WARN: Multi-variable type inference failed */
        C01821(Map<String, ? extends List<String>> map, RouteBuilder<? extends T> routeBuilder) {
            super(3);
            this.$argMap = map;
            this.$builder = routeBuilder;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, NavType<Object> navType) {
            invoke(num.intValue(), str, navType);
            return Unit.INSTANCE;
        }

        /* WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class decompiler.core.dex.instructions.args.ArgType$PrimitiveArg
        	at decompiler.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at decompiler.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at decompiler.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void invoke(int i, String argName, NavType<Object> navType) {
            Intrinsics.checkNotNullParameter(argName, "argName");
            Intrinsics.checkNotNullParameter(navType, "navType");
            List<String> list = this.$argMap.get(argName);
            Intrinsics.checkNotNull(list);
            this.$builder.appendArg(i, argName, navType, list);
        }
    }

    private static final <T> void assertNotAbstractClass(KSerializer<T> kSerializer, Function0<Unit> function0) {
        if (kSerializer instanceof PolymorphicSerializer) {
            function0.invoke();
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static final NavType<Object> computeNavType(SerialDescriptor serialDescriptor, Map<KType, ? extends NavType<?>> map) {
        Object next;
        Iterator<T> it = map.keySet().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!NavTypeConverterKt.matchKType(serialDescriptor, (KType) next));
        KType kType = (KType) next;
        NavType<?> navType = kType != null ? map.get(kType) : null;
        if (!(navType instanceof NavType)) {
            navType = null;
        }
        if (navType == null) {
            navType = NavTypeConverterKt.getNavType(serialDescriptor);
        }
        if (Intrinsics.areEqual(navType, UNKNOWN.INSTANCE)) {
            return null;
        }
        Intrinsics.checkNotNull(navType, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any?>");
        return navType;
    }

    public static final <T> int generateHashCode(KSerializer<T> kSerializer) {
        Intrinsics.checkNotNullParameter(kSerializer, "<this>");
        int iHashCode = kSerializer.getDescriptor().getSerialName().hashCode();
        int elementsCount = kSerializer.getDescriptor().getElementsCount();
        for (int i = 0; i < elementsCount; i++) {
            iHashCode = (iHashCode * 31) + kSerializer.getDescriptor().getElementName(i).hashCode();
        }
        return iHashCode;
    }

    static /* synthetic */ void forEachIndexedKType$default(KSerializer kSerializer, Map map, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            map = MapsKt.emptyMap();
        }
        forEachIndexedKType(kSerializer, map, function3);
    }

    private static final <T> void forEachIndexedKType(KSerializer<T> kSerializer, Map<KType, ? extends NavType<?>> map, Function3<? super Integer, ? super String, ? super NavType<Object>, Unit> function3) {
        int elementsCount = kSerializer.getDescriptor().getElementsCount();
        for (int i = 0; i < elementsCount; i++) {
            String elementName = kSerializer.getDescriptor().getElementName(i);
            NavType<Object> navTypeComputeNavType = computeNavType(kSerializer.getDescriptor().getElementDescriptor(i), map);
            if (navTypeComputeNavType == null) {
                throw new IllegalArgumentException(unknownNavTypeErrorMessage(elementName, kSerializer.getDescriptor().getElementDescriptor(i).getSerialName(), kSerializer.getDescriptor().getSerialName(), map.toString()));
            }
            function3.invoke(Integer.valueOf(i), elementName, navTypeComputeNavType);
        }
    }

    private static final <T> void forEachIndexedName(KSerializer<T> kSerializer, Map<String, ? extends NavType<Object>> map, Function3<? super Integer, ? super String, ? super NavType<Object>, Unit> function3) {
        int elementsCount = kSerializer.getDescriptor().getElementsCount();
        for (int i = 0; i < elementsCount; i++) {
            String elementName = kSerializer.getDescriptor().getElementName(i);
            NavType<Object> navType = map.get(elementName);
            if (navType == null) {
                throw new IllegalStateException(("Cannot locate NavType for argument [" + elementName + AbstractJsonLexerKt.END_LIST).toString());
            }
            function3.invoke(Integer.valueOf(i), elementName, navType);
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static final String unknownNavTypeErrorMessage(String str, String str2, String str3, String str4) {
        return "Route " + str3 + " could not find any NavType for argument " + str + " of type " + str2 + " - typeMap received was " + str4;
    }

    public static final boolean isValueClass(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        return Intrinsics.areEqual(serialDescriptor.getKind(), StructureKind.CLASS.INSTANCE) && serialDescriptor.getIsInline() && serialDescriptor.getElementsCount() == 1;
    }
}
