package com.google.protobuf;

import androidx.exifinterface.media.ExifInterface;
import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ExtensionList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: FileOptionsKt.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/google/protobuf/FileOptionsKt;", "", "()V", "Dsl", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FileOptionsKt {
    public static final FileOptionsKt INSTANCE = new FileOptionsKt();

    /* INFO: compiled from: FileOptionsKt.kt */
    @Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u001c\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u0000 ¦\u00012\u00020\u0001:\u0004¦\u0001§\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010Y\u001a\u00020ZH\u0001J\u0018\u0010[\u001a\u00020\\2\u0010\u0010]\u001a\f\u0012\u0004\u0012\u00020Z\u0012\u0002\b\u00030^J\u0006\u0010_\u001a\u00020\\J\u0006\u0010`\u001a\u00020\\J\u0006\u0010a\u001a\u00020\\J\u0006\u0010b\u001a\u00020\\J\u0006\u0010c\u001a\u00020\\J\u0006\u0010d\u001a\u00020\\J\u0006\u0010e\u001a\u00020\\J\u0006\u0010f\u001a\u00020\\J\u0006\u0010g\u001a\u00020\\J\u0006\u0010h\u001a\u00020\\J\u0006\u0010i\u001a\u00020\\J\u0006\u0010j\u001a\u00020\\J\u0006\u0010k\u001a\u00020\\J\u0006\u0010l\u001a\u00020\\J\u0006\u0010m\u001a\u00020\\J\u0006\u0010n\u001a\u00020\\J\u0006\u0010o\u001a\u00020\\J\u0006\u0010p\u001a\u00020\\J\u0006\u0010q\u001a\u00020\\J\u0006\u0010r\u001a\u00020\\J\u001b\u0010s\u001a\u00020\u00062\u0010\u0010]\u001a\f\u0012\u0004\u0012\u00020Z\u0012\u0002\b\u00030^H\u0086\u0002J,\u0010t\u001a\u0002Hu\"\b\b\u0000\u0010u*\u00020\u00012\u0012\u0010]\u001a\u000e\u0012\u0004\u0012\u00020Z\u0012\u0004\u0012\u0002Hu0^H\u0086\u0002¢\u0006\u0002\u0010vJ>\u0010t\u001a\u000e\u0012\u0004\u0012\u0002Hx\u0012\u0004\u0012\u00020Z0w\"\b\b\u0000\u0010x*\u00020\u00012\u0018\u0010]\u001a\u0014\u0012\u0004\u0012\u00020Z\u0012\n\u0012\b\u0012\u0004\u0012\u0002Hx0y0^H\u0087\u0002¢\u0006\u0002\bzJ\u0006\u0010{\u001a\u00020\u0006J\u0006\u0010|\u001a\u00020\u0006J\u0006\u0010}\u001a\u00020\u0006J\u0006\u0010~\u001a\u00020\u0006J\u0006\u0010\u007f\u001a\u00020\u0006J\u0007\u0010\u0080\u0001\u001a\u00020\u0006J\u0007\u0010\u0081\u0001\u001a\u00020\u0006J\u0007\u0010\u0082\u0001\u001a\u00020\u0006J\u0007\u0010\u0083\u0001\u001a\u00020\u0006J\u0007\u0010\u0084\u0001\u001a\u00020\u0006J\u0007\u0010\u0085\u0001\u001a\u00020\u0006J\u0007\u0010\u0086\u0001\u001a\u00020\u0006J\u0007\u0010\u0087\u0001\u001a\u00020\u0006J\u0007\u0010\u0088\u0001\u001a\u00020\u0006J\u0007\u0010\u0089\u0001\u001a\u00020\u0006J\u0007\u0010\u008a\u0001\u001a\u00020\u0006J\u0007\u0010\u008b\u0001\u001a\u00020\u0006J\u0007\u0010\u008c\u0001\u001a\u00020\u0006J\u0007\u0010\u008d\u0001\u001a\u00020\u0006J\u0007\u0010\u008e\u0001\u001a\u00020\u0006J7\u0010\u008f\u0001\u001a\u00020\\\"\t\b\u0000\u0010u*\u00030\u0090\u00012\u0012\u0010]\u001a\u000e\u0012\u0004\u0012\u00020Z\u0012\u0004\u0012\u0002Hu0^2\u0006\u0010\u0005\u001a\u0002HuH\u0086\n¢\u0006\u0003\u0010\u0091\u0001J=\u0010\u008f\u0001\u001a\u00020\\\"\u000f\b\u0000\u0010u*\t\u0012\u0004\u0012\u0002Hu0\u0092\u00012\u0012\u0010]\u001a\u000e\u0012\u0004\u0012\u00020Z\u0012\u0004\u0012\u0002Hu0^2\u0006\u0010\u0005\u001a\u0002HuH\u0086\n¢\u0006\u0003\u0010\u0093\u0001J(\u0010\u008f\u0001\u001a\u00020\\2\u0013\u0010]\u001a\u000f\u0012\u0004\u0012\u00020Z\u0012\u0005\u0012\u00030\u0094\u00010^2\u0007\u0010\u0005\u001a\u00030\u0094\u0001H\u0086\nJ3\u0010\u0095\u0001\u001a\u00020\\\"\b\b\u0000\u0010u*\u00020\u00012\u0012\u0010]\u001a\u000e\u0012\u0004\u0012\u00020Z\u0012\u0004\u0012\u0002Hu0^2\u0006\u0010\u0005\u001a\u0002Hu¢\u0006\u0003\u0010\u0096\u0001J'\u0010\u0097\u0001\u001a\u00020\\*\u000e\u0012\u0004\u0012\u00020R\u0012\u0004\u0012\u00020S0Q2\u0006\u0010\u0005\u001a\u00020RH\u0007¢\u0006\u0003\b\u0098\u0001J/\u0010\u0097\u0001\u001a\u00020\\\"\b\b\u0000\u0010x*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002Hx\u0012\u0004\u0012\u00020Z0w2\u0006\u0010\u0005\u001a\u0002Hx¢\u0006\u0003\u0010\u0099\u0001J/\u0010\u009a\u0001\u001a\u00020\\*\u000e\u0012\u0004\u0012\u00020R\u0012\u0004\u0012\u00020S0Q2\u000e\u0010\u009b\u0001\u001a\t\u0012\u0004\u0012\u00020R0\u009c\u0001H\u0007¢\u0006\u0003\b\u009d\u0001J1\u0010\u009a\u0001\u001a\u00020\\\"\b\b\u0000\u0010x*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002Hx\u0012\u0004\u0012\u00020Z0w2\u000e\u0010\u009b\u0001\u001a\t\u0012\u0004\u0012\u0002Hx0\u009c\u0001J\u001e\u0010[\u001a\u00020\\*\u000e\u0012\u0004\u0012\u00020R\u0012\u0004\u0012\u00020S0QH\u0007¢\u0006\u0003\b\u009e\u0001J\u0017\u0010[\u001a\u00020\\*\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020Z0wH\u0086\bJ(\u0010\u009f\u0001\u001a\u00020\\*\u000e\u0012\u0004\u0012\u00020R\u0012\u0004\u0012\u00020S0Q2\u0006\u0010\u0005\u001a\u00020RH\u0087\n¢\u0006\u0003\b \u0001J0\u0010\u009f\u0001\u001a\u00020\\*\u000e\u0012\u0004\u0012\u00020R\u0012\u0004\u0012\u00020S0Q2\u000e\u0010\u009b\u0001\u001a\t\u0012\u0004\u0012\u00020R0\u009c\u0001H\u0087\n¢\u0006\u0003\b¡\u0001J2\u0010\u009f\u0001\u001a\u00020\\\"\b\b\u0000\u0010x*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002Hx\u0012\u0004\u0012\u00020Z0w2\u0006\u0010\u0005\u001a\u0002HxH\u0086\n¢\u0006\u0003\u0010\u0099\u0001J4\u0010\u009f\u0001\u001a\u00020\\\"\b\b\u0000\u0010x*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002Hx\u0012\u0004\u0012\u00020Z0w2\u000e\u0010\u009b\u0001\u001a\t\u0012\u0004\u0012\u0002Hx0\u009c\u0001H\u0086\nJ2\u0010\u008f\u0001\u001a\u00020\\*\u000e\u0012\u0004\u0012\u00020R\u0012\u0004\u0012\u00020S0Q2\b\u0010¢\u0001\u001a\u00030£\u00012\u0006\u0010\u0005\u001a\u00020RH\u0087\u0002¢\u0006\u0003\b¤\u0001J<\u0010\u008f\u0001\u001a\u00020\\\"\b\b\u0000\u0010x*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002Hx\u0012\u0004\u0012\u00020Z0w2\b\u0010¢\u0001\u001a\u00030£\u00012\u0006\u0010\u0005\u001a\u0002HxH\u0086\u0002¢\u0006\u0003\u0010¥\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u000f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00188G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u000f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R*\u0010!\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\"\u0010#\u001a\u0004\b$\u0010\t\"\u0004\b%\u0010\u000bR$\u0010&\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b'\u0010\t\"\u0004\b(\u0010\u000bR$\u0010)\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b*\u0010\t\"\u0004\b+\u0010\u000bR$\u0010,\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u000f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b-\u0010\u0012\"\u0004\b.\u0010\u0014R$\u0010/\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u000f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b0\u0010\u0012\"\u0004\b1\u0010\u0014R$\u00102\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b3\u0010\t\"\u0004\b4\u0010\u000bR$\u00105\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u000f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b6\u0010\u0012\"\u0004\b7\u0010\u0014R$\u00109\u001a\u0002082\u0006\u0010\u0005\u001a\u0002088G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R$\u0010>\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u000f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b?\u0010\u0012\"\u0004\b@\u0010\u0014R$\u0010A\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u000f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bB\u0010\u0012\"\u0004\bC\u0010\u0014R$\u0010D\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u000f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bE\u0010\u0012\"\u0004\bF\u0010\u0014R$\u0010G\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bH\u0010\t\"\u0004\bI\u0010\u000bR$\u0010J\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u000f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bK\u0010\u0012\"\u0004\bL\u0010\u0014R$\u0010M\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u000f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bN\u0010\u0012\"\u0004\bO\u0010\u0014R\u001d\u0010P\u001a\u000e\u0012\u0004\u0012\u00020R\u0012\u0004\u0012\u00020S0Q8F¢\u0006\u0006\u001a\u0004\bT\u0010UR\u0017\u0010V\u001a\u0004\u0018\u00010\u0018*\u00020\u00008F¢\u0006\u0006\u001a\u0004\bW\u0010X¨\u0006¨\u0001"}, d2 = {"Lcom/google/protobuf/FileOptionsKt$Dsl;", "", "_builder", "Lcom/google/protobuf/DescriptorProtos$FileOptions$Builder;", "(Lcom/google/protobuf/DescriptorProtos$FileOptions$Builder;)V", "value", "", "ccEnableArenas", "getCcEnableArenas", "()Z", "setCcEnableArenas", "(Z)V", "ccGenericServices", "getCcGenericServices", "setCcGenericServices", "", "csharpNamespace", "getCsharpNamespace", "()Ljava/lang/String;", "setCsharpNamespace", "(Ljava/lang/String;)V", "deprecated", "getDeprecated", "setDeprecated", "Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "features", "getFeatures", "()Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "setFeatures", "(Lcom/google/protobuf/DescriptorProtos$FeatureSet;)V", "goPackage", "getGoPackage", "setGoPackage", "javaGenerateEqualsAndHash", "getJavaGenerateEqualsAndHash$annotations", "()V", "getJavaGenerateEqualsAndHash", "setJavaGenerateEqualsAndHash", "javaGenericServices", "getJavaGenericServices", "setJavaGenericServices", "javaMultipleFiles", "getJavaMultipleFiles", "setJavaMultipleFiles", "javaOuterClassname", "getJavaOuterClassname", "setJavaOuterClassname", "javaPackage", "getJavaPackage", "setJavaPackage", "javaStringCheckUtf8", "getJavaStringCheckUtf8", "setJavaStringCheckUtf8", "objcClassPrefix", "getObjcClassPrefix", "setObjcClassPrefix", "Lcom/google/protobuf/DescriptorProtos$FileOptions$OptimizeMode;", "optimizeFor", "getOptimizeFor", "()Lcom/google/protobuf/DescriptorProtos$FileOptions$OptimizeMode;", "setOptimizeFor", "(Lcom/google/protobuf/DescriptorProtos$FileOptions$OptimizeMode;)V", "phpClassPrefix", "getPhpClassPrefix", "setPhpClassPrefix", "phpMetadataNamespace", "getPhpMetadataNamespace", "setPhpMetadataNamespace", "phpNamespace", "getPhpNamespace", "setPhpNamespace", "pyGenericServices", "getPyGenericServices", "setPyGenericServices", "rubyPackage", "getRubyPackage", "setRubyPackage", "swiftPrefix", "getSwiftPrefix", "setSwiftPrefix", "uninterpretedOption", "Lcom/google/protobuf/kotlin/DslList;", "Lcom/google/protobuf/DescriptorProtos$UninterpretedOption;", "Lcom/google/protobuf/FileOptionsKt$Dsl$UninterpretedOptionProxy;", "getUninterpretedOption", "()Lcom/google/protobuf/kotlin/DslList;", "featuresOrNull", "getFeaturesOrNull", "(Lcom/google/protobuf/FileOptionsKt$Dsl;)Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "_build", "Lcom/google/protobuf/DescriptorProtos$FileOptions;", "clear", "", "extension", "Lcom/google/protobuf/ExtensionLite;", "clearCcEnableArenas", "clearCcGenericServices", "clearCsharpNamespace", "clearDeprecated", "clearFeatures", "clearGoPackage", "clearJavaGenerateEqualsAndHash", "clearJavaGenericServices", "clearJavaMultipleFiles", "clearJavaOuterClassname", "clearJavaPackage", "clearJavaStringCheckUtf8", "clearObjcClassPrefix", "clearOptimizeFor", "clearPhpClassPrefix", "clearPhpMetadataNamespace", "clearPhpNamespace", "clearPyGenericServices", "clearRubyPackage", "clearSwiftPrefix", "contains", "get", ExifInterface.GPS_DIRECTION_TRUE, "(Lcom/google/protobuf/ExtensionLite;)Ljava/lang/Object;", "Lcom/google/protobuf/kotlin/ExtensionList;", ExifInterface.LONGITUDE_EAST, "", "-getRepeatedExtension", "hasCcEnableArenas", "hasCcGenericServices", "hasCsharpNamespace", "hasDeprecated", "hasFeatures", "hasGoPackage", "hasJavaGenerateEqualsAndHash", "hasJavaGenericServices", "hasJavaMultipleFiles", "hasJavaOuterClassname", "hasJavaPackage", "hasJavaStringCheckUtf8", "hasObjcClassPrefix", "hasOptimizeFor", "hasPhpClassPrefix", "hasPhpMetadataNamespace", "hasPhpNamespace", "hasPyGenericServices", "hasRubyPackage", "hasSwiftPrefix", "set", "Lcom/google/protobuf/MessageLite;", "(Lcom/google/protobuf/ExtensionLite;Lcom/google/protobuf/MessageLite;)V", "", "(Lcom/google/protobuf/ExtensionLite;Ljava/lang/Comparable;)V", "Lcom/google/protobuf/ByteString;", "setExtension", "(Lcom/google/protobuf/ExtensionLite;Ljava/lang/Object;)V", "add", "addUninterpretedOption", "(Lcom/google/protobuf/kotlin/ExtensionList;Ljava/lang/Object;)V", "addAll", "values", "", "addAllUninterpretedOption", "clearUninterpretedOption", "plusAssign", "plusAssignUninterpretedOption", "plusAssignAllUninterpretedOption", ConfigConstants.CONFIG_INDEX_SECTION, "", "setUninterpretedOption", "(Lcom/google/protobuf/kotlin/ExtensionList;ILjava/lang/Object;)V", "Companion", "UninterpretedOptionProxy", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Dsl {

        /* INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final DescriptorProtos.FileOptions.Builder _builder;

        public /* synthetic */ Dsl(DescriptorProtos.FileOptions.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        @Deprecated(message = "Field javaGenerateEqualsAndHash is deprecated")
        public static /* synthetic */ void getJavaGenerateEqualsAndHash$annotations() {
        }

        private Dsl(DescriptorProtos.FileOptions.Builder builder) {
            this._builder = builder;
        }

        /* INFO: compiled from: FileOptionsKt.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/FileOptionsKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/FileOptionsKt$Dsl;", "builder", "Lcom/google/protobuf/DescriptorProtos$FileOptions$Builder;", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final /* synthetic */ Dsl _create(DescriptorProtos.FileOptions.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public final /* synthetic */ DescriptorProtos.FileOptions _build() {
            DescriptorProtos.FileOptions fileOptionsBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(fileOptionsBuild, "_builder.build()");
            return fileOptionsBuild;
        }

        public final String getJavaPackage() {
            String javaPackage = this._builder.getJavaPackage();
            Intrinsics.checkNotNullExpressionValue(javaPackage, "_builder.getJavaPackage()");
            return javaPackage;
        }

        public final void setJavaPackage(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setJavaPackage(value);
        }

        public final void clearJavaPackage() {
            this._builder.clearJavaPackage();
        }

        public final boolean hasJavaPackage() {
            return this._builder.hasJavaPackage();
        }

        public final String getJavaOuterClassname() {
            String javaOuterClassname = this._builder.getJavaOuterClassname();
            Intrinsics.checkNotNullExpressionValue(javaOuterClassname, "_builder.getJavaOuterClassname()");
            return javaOuterClassname;
        }

        public final void setJavaOuterClassname(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setJavaOuterClassname(value);
        }

        public final void clearJavaOuterClassname() {
            this._builder.clearJavaOuterClassname();
        }

        public final boolean hasJavaOuterClassname() {
            return this._builder.hasJavaOuterClassname();
        }

        public final boolean getJavaMultipleFiles() {
            return this._builder.getJavaMultipleFiles();
        }

        public final void setJavaMultipleFiles(boolean z) {
            this._builder.setJavaMultipleFiles(z);
        }

        public final void clearJavaMultipleFiles() {
            this._builder.clearJavaMultipleFiles();
        }

        public final boolean hasJavaMultipleFiles() {
            return this._builder.hasJavaMultipleFiles();
        }

        public final boolean getJavaGenerateEqualsAndHash() {
            return this._builder.getJavaGenerateEqualsAndHash();
        }

        public final void setJavaGenerateEqualsAndHash(boolean z) {
            this._builder.setJavaGenerateEqualsAndHash(z);
        }

        public final void clearJavaGenerateEqualsAndHash() {
            this._builder.clearJavaGenerateEqualsAndHash();
        }

        public final boolean hasJavaGenerateEqualsAndHash() {
            return this._builder.hasJavaGenerateEqualsAndHash();
        }

        public final boolean getJavaStringCheckUtf8() {
            return this._builder.getJavaStringCheckUtf8();
        }

        public final void setJavaStringCheckUtf8(boolean z) {
            this._builder.setJavaStringCheckUtf8(z);
        }

        public final void clearJavaStringCheckUtf8() {
            this._builder.clearJavaStringCheckUtf8();
        }

        public final boolean hasJavaStringCheckUtf8() {
            return this._builder.hasJavaStringCheckUtf8();
        }

        public final DescriptorProtos.FileOptions.OptimizeMode getOptimizeFor() {
            DescriptorProtos.FileOptions.OptimizeMode optimizeFor = this._builder.getOptimizeFor();
            Intrinsics.checkNotNullExpressionValue(optimizeFor, "_builder.getOptimizeFor()");
            return optimizeFor;
        }

        public final void setOptimizeFor(DescriptorProtos.FileOptions.OptimizeMode value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setOptimizeFor(value);
        }

        public final void clearOptimizeFor() {
            this._builder.clearOptimizeFor();
        }

        public final boolean hasOptimizeFor() {
            return this._builder.hasOptimizeFor();
        }

        public final String getGoPackage() {
            String goPackage = this._builder.getGoPackage();
            Intrinsics.checkNotNullExpressionValue(goPackage, "_builder.getGoPackage()");
            return goPackage;
        }

        public final void setGoPackage(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setGoPackage(value);
        }

        public final void clearGoPackage() {
            this._builder.clearGoPackage();
        }

        public final boolean hasGoPackage() {
            return this._builder.hasGoPackage();
        }

        public final boolean getCcGenericServices() {
            return this._builder.getCcGenericServices();
        }

        public final void setCcGenericServices(boolean z) {
            this._builder.setCcGenericServices(z);
        }

        public final void clearCcGenericServices() {
            this._builder.clearCcGenericServices();
        }

        public final boolean hasCcGenericServices() {
            return this._builder.hasCcGenericServices();
        }

        public final boolean getJavaGenericServices() {
            return this._builder.getJavaGenericServices();
        }

        public final void setJavaGenericServices(boolean z) {
            this._builder.setJavaGenericServices(z);
        }

        public final void clearJavaGenericServices() {
            this._builder.clearJavaGenericServices();
        }

        public final boolean hasJavaGenericServices() {
            return this._builder.hasJavaGenericServices();
        }

        public final boolean getPyGenericServices() {
            return this._builder.getPyGenericServices();
        }

        public final void setPyGenericServices(boolean z) {
            this._builder.setPyGenericServices(z);
        }

        public final void clearPyGenericServices() {
            this._builder.clearPyGenericServices();
        }

        public final boolean hasPyGenericServices() {
            return this._builder.hasPyGenericServices();
        }

        public final boolean getDeprecated() {
            return this._builder.getDeprecated();
        }

        public final void setDeprecated(boolean z) {
            this._builder.setDeprecated(z);
        }

        public final void clearDeprecated() {
            this._builder.clearDeprecated();
        }

        public final boolean hasDeprecated() {
            return this._builder.hasDeprecated();
        }

        public final boolean getCcEnableArenas() {
            return this._builder.getCcEnableArenas();
        }

        public final void setCcEnableArenas(boolean z) {
            this._builder.setCcEnableArenas(z);
        }

        public final void clearCcEnableArenas() {
            this._builder.clearCcEnableArenas();
        }

        public final boolean hasCcEnableArenas() {
            return this._builder.hasCcEnableArenas();
        }

        public final String getObjcClassPrefix() {
            String objcClassPrefix = this._builder.getObjcClassPrefix();
            Intrinsics.checkNotNullExpressionValue(objcClassPrefix, "_builder.getObjcClassPrefix()");
            return objcClassPrefix;
        }

        public final void setObjcClassPrefix(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setObjcClassPrefix(value);
        }

        public final void clearObjcClassPrefix() {
            this._builder.clearObjcClassPrefix();
        }

        public final boolean hasObjcClassPrefix() {
            return this._builder.hasObjcClassPrefix();
        }

        public final String getCsharpNamespace() {
            String csharpNamespace = this._builder.getCsharpNamespace();
            Intrinsics.checkNotNullExpressionValue(csharpNamespace, "_builder.getCsharpNamespace()");
            return csharpNamespace;
        }

        public final void setCsharpNamespace(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setCsharpNamespace(value);
        }

        public final void clearCsharpNamespace() {
            this._builder.clearCsharpNamespace();
        }

        public final boolean hasCsharpNamespace() {
            return this._builder.hasCsharpNamespace();
        }

        public final String getSwiftPrefix() {
            String swiftPrefix = this._builder.getSwiftPrefix();
            Intrinsics.checkNotNullExpressionValue(swiftPrefix, "_builder.getSwiftPrefix()");
            return swiftPrefix;
        }

        public final void setSwiftPrefix(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setSwiftPrefix(value);
        }

        public final void clearSwiftPrefix() {
            this._builder.clearSwiftPrefix();
        }

        public final boolean hasSwiftPrefix() {
            return this._builder.hasSwiftPrefix();
        }

        public final String getPhpClassPrefix() {
            String phpClassPrefix = this._builder.getPhpClassPrefix();
            Intrinsics.checkNotNullExpressionValue(phpClassPrefix, "_builder.getPhpClassPrefix()");
            return phpClassPrefix;
        }

        public final void setPhpClassPrefix(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setPhpClassPrefix(value);
        }

        public final void clearPhpClassPrefix() {
            this._builder.clearPhpClassPrefix();
        }

        public final boolean hasPhpClassPrefix() {
            return this._builder.hasPhpClassPrefix();
        }

        public final String getPhpNamespace() {
            String phpNamespace = this._builder.getPhpNamespace();
            Intrinsics.checkNotNullExpressionValue(phpNamespace, "_builder.getPhpNamespace()");
            return phpNamespace;
        }

        public final void setPhpNamespace(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setPhpNamespace(value);
        }

        public final void clearPhpNamespace() {
            this._builder.clearPhpNamespace();
        }

        public final boolean hasPhpNamespace() {
            return this._builder.hasPhpNamespace();
        }

        public final String getPhpMetadataNamespace() {
            String phpMetadataNamespace = this._builder.getPhpMetadataNamespace();
            Intrinsics.checkNotNullExpressionValue(phpMetadataNamespace, "_builder.getPhpMetadataNamespace()");
            return phpMetadataNamespace;
        }

        public final void setPhpMetadataNamespace(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setPhpMetadataNamespace(value);
        }

        public final void clearPhpMetadataNamespace() {
            this._builder.clearPhpMetadataNamespace();
        }

        public final boolean hasPhpMetadataNamespace() {
            return this._builder.hasPhpMetadataNamespace();
        }

        public final String getRubyPackage() {
            String rubyPackage = this._builder.getRubyPackage();
            Intrinsics.checkNotNullExpressionValue(rubyPackage, "_builder.getRubyPackage()");
            return rubyPackage;
        }

        public final void setRubyPackage(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setRubyPackage(value);
        }

        public final void clearRubyPackage() {
            this._builder.clearRubyPackage();
        }

        public final boolean hasRubyPackage() {
            return this._builder.hasRubyPackage();
        }

        public final DescriptorProtos.FeatureSet getFeatures() {
            DescriptorProtos.FeatureSet features = this._builder.getFeatures();
            Intrinsics.checkNotNullExpressionValue(features, "_builder.getFeatures()");
            return features;
        }

        public final void setFeatures(DescriptorProtos.FeatureSet value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setFeatures(value);
        }

        public final void clearFeatures() {
            this._builder.clearFeatures();
        }

        public final boolean hasFeatures() {
            return this._builder.hasFeatures();
        }

        public final DescriptorProtos.FeatureSet getFeaturesOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return FileOptionsKtKt.getFeaturesOrNull(dsl._builder);
        }

        /* INFO: compiled from: FileOptionsKt.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/FileOptionsKt$Dsl$UninterpretedOptionProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class UninterpretedOptionProxy extends DslProxy {
            private UninterpretedOptionProxy() {
            }
        }

        public final /* synthetic */ DslList getUninterpretedOption() {
            List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = this._builder.getUninterpretedOptionList();
            Intrinsics.checkNotNullExpressionValue(uninterpretedOptionList, "_builder.getUninterpretedOptionList()");
            return new DslList(uninterpretedOptionList);
        }

        public final /* synthetic */ void addUninterpretedOption(DslList dslList, DescriptorProtos.UninterpretedOption value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addUninterpretedOption(value);
        }

        public final /* synthetic */ void plusAssignUninterpretedOption(DslList<DescriptorProtos.UninterpretedOption, UninterpretedOptionProxy> dslList, DescriptorProtos.UninterpretedOption value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addUninterpretedOption(dslList, value);
        }

        public final /* synthetic */ void addAllUninterpretedOption(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllUninterpretedOption(values);
        }

        public final /* synthetic */ void plusAssignAllUninterpretedOption(DslList<DescriptorProtos.UninterpretedOption, UninterpretedOptionProxy> dslList, Iterable<DescriptorProtos.UninterpretedOption> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllUninterpretedOption(dslList, values);
        }

        public final /* synthetic */ void setUninterpretedOption(DslList dslList, int i, DescriptorProtos.UninterpretedOption value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setUninterpretedOption(i, value);
        }

        public final /* synthetic */ void clearUninterpretedOption(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearUninterpretedOption();
        }

        public final /* synthetic */ Object get(ExtensionLite extension) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            if (extension.isRepeated()) {
                Object obj = get(extension);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of com.google.protobuf.FileOptionsKt.Dsl.get");
                return obj;
            }
            Object extension2 = this._builder.getExtension(extension);
            Intrinsics.checkNotNullExpressionValue(extension2, "{\n        _builder.getExtension(extension)\n      }");
            return extension2;
        }

        /* INFO: renamed from: -getRepeatedExtension, reason: not valid java name */
        public final /* synthetic */ ExtensionList m3414getRepeatedExtension(ExtensionLite extension) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            Object extension2 = this._builder.getExtension(extension);
            Intrinsics.checkNotNullExpressionValue(extension2, "_builder.getExtension(extension)");
            return new ExtensionList(extension, (List) extension2);
        }

        public final /* synthetic */ boolean contains(ExtensionLite extension) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            return this._builder.hasExtension(extension);
        }

        public final /* synthetic */ void clear(ExtensionLite extension) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            this._builder.clearExtension(extension);
        }

        public final /* synthetic */ void setExtension(ExtensionLite extension, Object value) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setExtension(extension, value);
        }

        public final /* synthetic */ <T extends Comparable<? super T>> void set(ExtensionLite<DescriptorProtos.FileOptions, T> extension, T value) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            Intrinsics.checkNotNullParameter(value, "value");
            setExtension(extension, value);
        }

        public final /* synthetic */ void set(ExtensionLite<DescriptorProtos.FileOptions, ByteString> extension, ByteString value) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            Intrinsics.checkNotNullParameter(value, "value");
            setExtension(extension, value);
        }

        public final /* synthetic */ <T extends MessageLite> void set(ExtensionLite<DescriptorProtos.FileOptions, T> extension, T value) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            Intrinsics.checkNotNullParameter(value, "value");
            setExtension(extension, value);
        }

        public final /* synthetic */ void add(ExtensionList extensionList, Object value) {
            Intrinsics.checkNotNullParameter(extensionList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addExtension(extensionList.getExtension(), value);
        }

        public final /* synthetic */ <E> void plusAssign(ExtensionList<E, DescriptorProtos.FileOptions> extensionList, E value) {
            Intrinsics.checkNotNullParameter(extensionList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            add(extensionList, value);
        }

        public final /* synthetic */ void addAll(ExtensionList extensionList, Iterable values) {
            Intrinsics.checkNotNullParameter(extensionList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            Iterator it = values.iterator();
            while (it.hasNext()) {
                add(extensionList, it.next());
            }
        }

        public final /* synthetic */ <E> void plusAssign(ExtensionList<E, DescriptorProtos.FileOptions> extensionList, Iterable<? extends E> values) {
            Intrinsics.checkNotNullParameter(extensionList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAll(extensionList, values);
        }

        public final /* synthetic */ void set(ExtensionList extensionList, int i, Object value) {
            Intrinsics.checkNotNullParameter(extensionList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setExtension(extensionList.getExtension(), i, value);
        }

        public final /* synthetic */ void clear(ExtensionList<?, DescriptorProtos.FileOptions> extensionList) {
            Intrinsics.checkNotNullParameter(extensionList, "<this>");
            clear(extensionList.getExtension());
        }
    }

    private FileOptionsKt() {
    }
}
