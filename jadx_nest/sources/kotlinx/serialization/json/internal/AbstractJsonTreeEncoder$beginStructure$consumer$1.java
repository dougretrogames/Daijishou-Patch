package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.json.JsonElement;

/* JADX INFO: compiled from: TreeJsonEncoder.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "node", "Lkotlinx/serialization/json/JsonElement;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class AbstractJsonTreeEncoder$beginStructure$consumer$1 extends Lambda implements Function1<JsonElement, Unit> {
    final /* synthetic */ AbstractJsonTreeEncoder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AbstractJsonTreeEncoder$beginStructure$consumer$1(AbstractJsonTreeEncoder abstractJsonTreeEncoder) {
        super(1);
        this.this$0 = abstractJsonTreeEncoder;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(JsonElement jsonElement) {
        invoke2(jsonElement);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(JsonElement node) {
        Intrinsics.checkNotNullParameter(node, "node");
        AbstractJsonTreeEncoder abstractJsonTreeEncoder = this.this$0;
        abstractJsonTreeEncoder.putElement(abstractJsonTreeEncoder.getCurrentTag(), node);
    }
}
