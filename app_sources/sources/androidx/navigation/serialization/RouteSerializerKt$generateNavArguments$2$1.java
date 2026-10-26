package androidx.navigation.serialization;

import androidx.exifinterface.media.ExifInterface;
import androidx.navigation.NavArgumentBuilder;
import androidx.navigation.NavType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* INFO: compiled from: RouteSerializer.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/navigation/NavArgumentBuilder;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class RouteSerializerKt$generateNavArguments$2$1 extends Lambda implements Function1<NavArgumentBuilder, Unit> {
    final /* synthetic */ int $index;
    final /* synthetic */ String $name;
    final /* synthetic */ KSerializer<T> $this_generateNavArguments;
    final /* synthetic */ Map<KType, NavType<?>> $typeMap;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* WARN: Multi-variable type inference failed */
    RouteSerializerKt$generateNavArguments$2$1(KSerializer<T> kSerializer, int i, Map<KType, ? extends NavType<?>> map, String str) {
        super(1);
        this.$this_generateNavArguments = kSerializer;
        this.$index = i;
        this.$typeMap = map;
        this.$name = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(NavArgumentBuilder navArgumentBuilder) {
        invoke2(navArgumentBuilder);
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        SerialDescriptor elementDescriptor = this.$this_generateNavArguments.getDescriptor().getElementDescriptor(this.$index);
        boolean zIsNullable = elementDescriptor.isNullable();
        NavType<?> navTypeComputeNavType = RouteSerializerKt.computeNavType(elementDescriptor, this.$typeMap);
        if (navTypeComputeNavType != null) {
            navArgument.setType(navTypeComputeNavType);
            navArgument.setNullable(zIsNullable);
            if (this.$this_generateNavArguments.getDescriptor().isElementOptional(this.$index)) {
                navArgument.setUnknownDefaultValuePresent$navigation_common_release(true);
                return;
            }
            return;
        }
        throw new IllegalArgumentException(RouteSerializerKt.unknownNavTypeErrorMessage(this.$name, elementDescriptor.getSerialName(), this.$this_generateNavArguments.getDescriptor().getSerialName(), this.$typeMap.toString()));
    }
}
