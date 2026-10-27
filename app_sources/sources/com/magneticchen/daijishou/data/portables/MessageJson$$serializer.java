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

/* JADX INFO: compiled from: MessageJson.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/magneticchen/daijishou/data/portables/MessageJson.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/magneticchen/daijishou/data/portables/MessageJson;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class MessageJson$$serializer implements GeneratedSerializer<MessageJson> {
    public static final MessageJson$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        MessageJson$$serializer messageJson$$serializer = new MessageJson$$serializer();
        INSTANCE = messageJson$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.magneticchen.daijishou.data.portables.MessageJson", messageJson$$serializer, 10);
        pluginGeneratedSerialDescriptor.addElement("title", true);
        pluginGeneratedSerialDescriptor.addElement("message", true);
        pluginGeneratedSerialDescriptor.addElement("acknowledgmentText", true);
        pluginGeneratedSerialDescriptor.addElement("acknowledgmentLink", true);
        pluginGeneratedSerialDescriptor.addElement("cancelText", true);
        pluginGeneratedSerialDescriptor.addElement("cancelLink", true);
        pluginGeneratedSerialDescriptor.addElement("neutralText", true);
        pluginGeneratedSerialDescriptor.addElement("neutralLink", true);
        pluginGeneratedSerialDescriptor.addElement("targetVersion", true);
        pluginGeneratedSerialDescriptor.addElement("belowVersion", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private MessageJson$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE)};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlinx.serialization.UnknownFieldException */
    /* JADX INFO: renamed from: deserialize, reason: merged with bridge method [inline-methods] */
    public MessageJson m192deserialize(Decoder decoder) throws UnknownFieldException {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Integer num;
        String str6;
        String str7;
        String str8;
        Integer num2;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        int i2 = 9;
        int i3 = 8;
        String strDecodeStringElement = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
            String str9 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, (Object) null);
            String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 2);
            String str10 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, (Object) null);
            String str11 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, (Object) null);
            String str12 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, StringSerializer.INSTANCE, (Object) null);
            String str13 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, StringSerializer.INSTANCE, (Object) null);
            String str14 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, StringSerializer.INSTANCE, (Object) null);
            Integer num3 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, IntSerializer.INSTANCE, (Object) null);
            str4 = str12;
            i = 1023;
            num = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, IntSerializer.INSTANCE, (Object) null);
            str7 = str14;
            str2 = str13;
            num2 = num3;
            str6 = str9;
            str = str11;
            str8 = strDecodeStringElement3;
            str5 = str10;
            str3 = strDecodeStringElement2;
        } else {
            boolean z = true;
            int i4 = 0;
            Integer num4 = null;
            Integer num5 = null;
            String str15 = null;
            String str16 = null;
            String str17 = null;
            str = null;
            String str18 = null;
            String str19 = null;
            String strDecodeStringElement4 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 9;
                        break;
                    case 0:
                        strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
                        i4 |= 1;
                        i2 = 9;
                        i3 = 8;
                        break;
                    case 1:
                        str19 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, str19);
                        i4 |= 2;
                        i2 = 9;
                        i3 = 8;
                        break;
                    case 2:
                        strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 2);
                        i4 |= 4;
                        i2 = 9;
                        break;
                    case 3:
                        str18 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, str18);
                        i4 |= 8;
                        i2 = 9;
                        break;
                    case 4:
                        str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, str);
                        i4 |= 16;
                        i2 = 9;
                        break;
                    case 5:
                        str17 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, StringSerializer.INSTANCE, str17);
                        i4 |= 32;
                        i2 = 9;
                        break;
                    case 6:
                        str15 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, StringSerializer.INSTANCE, str15);
                        i4 |= 64;
                        i2 = 9;
                        break;
                    case 7:
                        str16 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, StringSerializer.INSTANCE, str16);
                        i4 |= 128;
                        i2 = 9;
                        break;
                    case 8:
                        num5 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i3, IntSerializer.INSTANCE, num5);
                        i4 |= 256;
                        break;
                    case 9:
                        num4 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i2, IntSerializer.INSTANCE, num4);
                        i4 |= 512;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            String str20 = strDecodeStringElement;
            str2 = str15;
            str3 = str20;
            String str21 = str18;
            str4 = str17;
            str5 = str21;
            num = num4;
            str6 = str19;
            str7 = str16;
            str8 = strDecodeStringElement4;
            num2 = num5;
            i = i4;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new MessageJson(i, str3, str6, str8, str5, str, str4, str2, str7, num2, num, (SerializationConstructorMarker) null);
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, MessageJson value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        MessageJson.write$Self$app_release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
