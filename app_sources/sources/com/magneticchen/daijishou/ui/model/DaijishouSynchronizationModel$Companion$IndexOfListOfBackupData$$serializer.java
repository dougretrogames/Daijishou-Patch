package com.magneticchen.daijishou.ui.model;

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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* INFO: compiled from: DaijishouSynchronizationModel.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/magneticchen/daijishou/view_models/DaijishouSynchronizationModel.Companion.IndexOfListOfBackupData.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/magneticchen/daijishou/view_models/DaijishouSynchronizationModel$Companion$IndexOfListOfBackupData;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class DaijishouSynchronizationModel$Companion$IndexOfListOfBackupData$$serializer implements GeneratedSerializer<DaijishouSynchronizationModel.Companion.IndexOfListOfBackupData> {
    public static final DaijishouSynchronizationModel$Companion$IndexOfListOfBackupData$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        DaijishouSynchronizationModel$Companion$IndexOfListOfBackupData$$serializer daijishouSynchronizationModel$Companion$IndexOfListOfBackupData$$serializer = new DaijishouSynchronizationModel$Companion$IndexOfListOfBackupData$$serializer();
        INSTANCE = daijishouSynchronizationModel$Companion$IndexOfListOfBackupData$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel.Companion.IndexOfListOfBackupData", daijishouSynchronizationModel$Companion$IndexOfListOfBackupData$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("daijishouUUID", false);
        pluginGeneratedSerialDescriptor.addElement("title", true);
        pluginGeneratedSerialDescriptor.addElement("timestamp", true);
        pluginGeneratedSerialDescriptor.addElement("contentHashMapRandomIntChecksum", true);
        pluginGeneratedSerialDescriptor.addElement("signature", false);
        pluginGeneratedSerialDescriptor.addElement("filename", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private DaijishouSynchronizationModel$Companion$IndexOfListOfBackupData$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, StringSerializer.INSTANCE, LongSerializer.INSTANCE, IntSerializer.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public DaijishouSynchronizationModel.Companion.IndexOfListOfBackupData deserialize(Decoder decoder) {
        String str;
        String str2;
        long j;
        int i;
        String str3;
        String str4;
        int i2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 1);
            long jDecodeLongElement = compositeDecoderBeginStructure.decodeLongElement(descriptor2, 2);
            int iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 3);
            String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 4);
            str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, StringSerializer.INSTANCE, null);
            i = iDecodeIntElement;
            str = strDecodeStringElement3;
            str3 = strDecodeStringElement2;
            j = jDecodeLongElement;
            str4 = strDecodeStringElement;
            i2 = 63;
        } else {
            boolean z = true;
            int iDecodeIntElement2 = 0;
            String strDecodeStringElement4 = null;
            String str5 = null;
            long jDecodeLongElement2 = 0;
            int i3 = 0;
            String strDecodeStringElement5 = null;
            String strDecodeStringElement6 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        continue;
                    case 0:
                        strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
                        i3 |= 1;
                        continue;
                    case 1:
                        strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 1);
                        i3 |= 2;
                        break;
                    case 2:
                        jDecodeLongElement2 = compositeDecoderBeginStructure.decodeLongElement(descriptor2, 2);
                        i3 |= 4;
                        break;
                    case 3:
                        iDecodeIntElement2 = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 3);
                        i3 |= 8;
                        break;
                    case 4:
                        strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 4);
                        i3 |= 16;
                        break;
                    case 5:
                        str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, StringSerializer.INSTANCE, str5);
                        i3 |= 32;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            str = strDecodeStringElement4;
            str2 = str5;
            j = jDecodeLongElement2;
            i = iDecodeIntElement2;
            str3 = strDecodeStringElement6;
            str4 = strDecodeStringElement5;
            i2 = i3;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new DaijishouSynchronizationModel.Companion.IndexOfListOfBackupData(i2, str4, str3, j, i, str, str2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, DaijishouSynchronizationModel.Companion.IndexOfListOfBackupData value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        DaijishouSynchronizationModel.Companion.IndexOfListOfBackupData.write$Self$app_release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
