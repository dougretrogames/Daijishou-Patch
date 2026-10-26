package kotlinx.serialization;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;

/* INFO: compiled from: SerializersCache.kt */
/* INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "Lkotlinx/serialization/KSerializer;", "", "clazz", "Lkotlin/reflect/KClass;", "types", "", "Lkotlin/reflect/KType;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$1 extends Lambda implements Function2<KClass<Object>, List<? extends KType>, KSerializer<Object>> {
    public static final SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$1 INSTANCE = new SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$1();

    SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$1() {
        super(2);
    }

    /* INFO: renamed from: kotlinx.serialization.SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$1$1, reason: invalid class name */
    /* INFO: compiled from: SerializersCache.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lkotlin/reflect/KClassifier;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass1 extends Lambda implements Function0<KClassifier> {
        final /* synthetic */ List<KType> $types;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* WARN: Multi-variable type inference failed */
        AnonymousClass1(List<? extends KType> list) {
            super(0);
            this.$types = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public final KClassifier invoke() {
            return this.$types.get(0).getClassifier();
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final KSerializer<Object> invoke(KClass<Object> clazz, List<? extends KType> types) {
        KSerializer<Object> nullable;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(types, "types");
        List<KSerializer<Object>> listSerializersForParameters = SerializersKt.serializersForParameters(SerializersModuleBuildersKt.EmptySerializersModule(), types, true);
        Intrinsics.checkNotNull(listSerializersForParameters);
        KSerializer<? extends Object> kSerializerParametrizedSerializerOrNull = SerializersKt.parametrizedSerializerOrNull(clazz, listSerializersForParameters, new AnonymousClass1(types));
        if (kSerializerParametrizedSerializerOrNull == null || (nullable = BuiltinSerializersKt.getNullable(kSerializerParametrizedSerializerOrNull)) == null) {
            return null;
        }
        return nullable;
    }
}
