package kotlinx.serialization;

import androidx.exifinterface.media.ExifInterface;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* JADX INFO: compiled from: ContextualSerializer.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class ContextualSerializer$descriptor$1 extends Lambda implements Function1<ClassSerialDescriptorBuilder, Unit> {
    final /* synthetic */ ContextualSerializer<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ContextualSerializer$descriptor$1(ContextualSerializer<T> contextualSerializer) {
        super(1);
        this.this$0 = contextualSerializer;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
        invoke2(classSerialDescriptorBuilder);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ClassSerialDescriptorBuilder buildSerialDescriptor) {
        SerialDescriptor descriptor;
        Intrinsics.checkNotNullParameter(buildSerialDescriptor, "$this$buildSerialDescriptor");
        KSerializer kSerializer = ((ContextualSerializer) this.this$0).fallbackSerializer;
        List<Annotation> annotations = (kSerializer == null || (descriptor = kSerializer.getDescriptor()) == null) ? null : descriptor.getAnnotations();
        if (annotations == null) {
            annotations = CollectionsKt.emptyList();
        }
        buildSerialDescriptor.setAnnotations(annotations);
    }
}
