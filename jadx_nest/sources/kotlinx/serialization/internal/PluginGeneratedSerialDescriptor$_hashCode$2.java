package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: PluginGeneratedSerialDescriptor.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class PluginGeneratedSerialDescriptor$_hashCode$2 extends Lambda implements Function0<Integer> {
    final /* synthetic */ PluginGeneratedSerialDescriptor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PluginGeneratedSerialDescriptor$_hashCode$2(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor) {
        super(0);
        this.this$0 = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Integer invoke() {
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = this.this$0;
        return Integer.valueOf(PluginGeneratedSerialDescriptorKt.hashCodeImpl(pluginGeneratedSerialDescriptor, pluginGeneratedSerialDescriptor.getTypeParameterDescriptors$kotlinx_serialization_core()));
    }
}
