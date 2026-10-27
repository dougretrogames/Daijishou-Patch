package com.magneticchen.daijishou.data.portables;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: PlatformsIndexPlatformListItemJson.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/magneticchen/daijishou/data/portables/PlatformsIndexPlatformListItemJson.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/magneticchen/daijishou/data/portables/PlatformsIndexPlatformListItemJson;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class PlatformsIndexPlatformListItemJson$$serializer implements GeneratedSerializer<PlatformsIndexPlatformListItemJson> {
    public static final PlatformsIndexPlatformListItemJson$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PlatformsIndexPlatformListItemJson$$serializer platformsIndexPlatformListItemJson$$serializer = new PlatformsIndexPlatformListItemJson$$serializer();
        INSTANCE = platformsIndexPlatformListItemJson$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.magneticchen.daijishou.data.portables.PlatformsIndexPlatformListItemJson", platformsIndexPlatformListItemJson$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("filename", false);
        pluginGeneratedSerialDescriptor.addElement("platformName", false);
        pluginGeneratedSerialDescriptor.addElement("platformShortname", true);
        pluginGeneratedSerialDescriptor.addElement("platformUniqueId", false);
        pluginGeneratedSerialDescriptor.addElement("revisionNumber", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PlatformsIndexPlatformListItemJson$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE)};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlinx.serialization.UnknownFieldException */
    /* JADX INFO: renamed from: deserialize, reason: merged with bridge method [inline-methods] */
    public PlatformsIndexPlatformListItemJson m205deserialize(Decoder decoder) throws UnknownFieldException {
        int i;
        String str;
        String str2;
        String str3;
        String strDecodeStringElement;
        Integer num;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        String strDecodeStringElement2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
            String strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 1);
            String str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, (Object) null);
            str = strDecodeStringElement3;
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 3);
            num = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, IntSerializer.INSTANCE, (Object) null);
            str3 = str4;
            str2 = strDecodeStringElement4;
            i = 31;
        } else {
            boolean z = true;
            int i2 = 0;
            String strDecodeStringElement5 = null;
            String str5 = null;
            String strDecodeStringElement6 = null;
            Integer num2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 1);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, str5);
                    i2 |= 4;
                } else if (iDecodeElementIndex == 3) {
                    strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 3);
                    i2 |= 8;
                } else {
                    if (iDecodeElementIndex != 4) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    num2 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, IntSerializer.INSTANCE, num2);
                    i2 |= 16;
                }
            }
            i = i2;
            str = strDecodeStringElement2;
            str2 = strDecodeStringElement5;
            str3 = str5;
            strDecodeStringElement = strDecodeStringElement6;
            num = num2;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new PlatformsIndexPlatformListItemJson(i, str, str2, str3, strDecodeStringElement, num, (SerializationConstructorMarker) null);
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, PlatformsIndexPlatformListItemJson value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        PlatformsIndexPlatformListItemJson.write$Self$app_release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
