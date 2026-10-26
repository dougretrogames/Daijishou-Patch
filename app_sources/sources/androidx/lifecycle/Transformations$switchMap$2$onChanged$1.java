package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* INFO: Add missing generic type declarations: [Y] */
/* INFO: compiled from: Transformations.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u0001H\u0003H\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "X", "Y", "y", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class Transformations$switchMap$2$onChanged$1<Y> extends Lambda implements Function1<Y, Unit> {
    final /* synthetic */ MediatorLiveData<Y> $result;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    Transformations$switchMap$2$onChanged$1(MediatorLiveData<Y> mediatorLiveData) {
        super(1);
        this.$result = mediatorLiveData;
    }

    /* WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
        invoke2(obj);
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Y y) {
        this.$result.setValue(y);
    }
}
