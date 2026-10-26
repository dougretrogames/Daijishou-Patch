package androidx.compose.runtime;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* INFO: Add missing generic type declarations: [T] */
/* INFO: compiled from: Composer.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0002H\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "it", "invoke", "(Ljava/lang/Object;Lkotlin/Unit;)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class Updater$init$1<T> extends Lambda implements Function2<T, Unit, Unit> {
    final /* synthetic */ Function1<T, Unit> $block;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* WARN: Multi-variable type inference failed */
    Updater$init$1(Function1<? super T, Unit> function1) {
        super(2);
        this.$block = function1;
    }

    /* WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Object obj, Unit unit) {
        invoke2(obj, unit);
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(T t, Unit unit) {
        this.$block.invoke(t);
    }
}
