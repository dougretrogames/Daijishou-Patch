package com.google.protobuf;

import androidx.exifinterface.media.ExifInterface;
import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ExtensionList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: FieldOptionsKt.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u000f\u0010\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\nJ*\u0010\u000b\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2 = {"Lcom/google/protobuf/FieldOptionsKt;", "", "()V", "editionDefault", "Lcom/google/protobuf/DescriptorProtos$FieldOptions$EditionDefault;", "block", "Lkotlin/Function1;", "Lcom/google/protobuf/FieldOptionsKt$EditionDefaultKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeeditionDefault", "featureSupport", "Lcom/google/protobuf/DescriptorProtos$FieldOptions$FeatureSupport;", "Lcom/google/protobuf/FieldOptionsKt$FeatureSupportKt$Dsl;", "-initializefeatureSupport", "Dsl", "EditionDefaultKt", "FeatureSupportKt", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FieldOptionsKt {
    public static final FieldOptionsKt INSTANCE = new FieldOptionsKt();

    /* INFO: compiled from: FieldOptionsKt.kt */
    @Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u001c\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u0000 \u0094\u00012\u00020\u0001:\b\u0094\u0001\u0095\u0001\u0096\u0001\u0097\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010M\u001a\u00020NH\u0001J\u0018\u0010O\u001a\u00020P2\u0010\u0010Q\u001a\f\u0012\u0004\u0012\u00020N\u0012\u0002\b\u00030RJ\u0006\u0010S\u001a\u00020PJ\u0006\u0010T\u001a\u00020PJ\u0006\u0010U\u001a\u00020PJ\u0006\u0010V\u001a\u00020PJ\u0006\u0010W\u001a\u00020PJ\u0006\u0010X\u001a\u00020PJ\u0006\u0010Y\u001a\u00020PJ\u0006\u0010Z\u001a\u00020PJ\u0006\u0010[\u001a\u00020PJ\u0006\u0010\\\u001a\u00020PJ\u0006\u0010]\u001a\u00020PJ\u001b\u0010^\u001a\u00020\f2\u0010\u0010Q\u001a\f\u0012\u0004\u0012\u00020N\u0012\u0002\b\u00030RH\u0086\u0002J,\u0010_\u001a\u0002H`\"\b\b\u0000\u0010`*\u00020\u00012\u0012\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u0002H`0RH\u0086\u0002¢\u0006\u0002\u0010aJ>\u0010_\u001a\u000e\u0012\u0004\u0012\u0002Hc\u0012\u0004\u0012\u00020N0b\"\b\b\u0000\u0010c*\u00020\u00012\u0018\u0010Q\u001a\u0014\u0012\u0004\u0012\u00020N\u0012\n\u0012\b\u0012\u0004\u0012\u0002Hc0d0RH\u0087\u0002¢\u0006\u0002\beJ\u0006\u0010f\u001a\u00020\fJ\u0006\u0010g\u001a\u00020\fJ\u0006\u0010h\u001a\u00020\fJ\u0006\u0010i\u001a\u00020\fJ\u0006\u0010j\u001a\u00020\fJ\u0006\u0010k\u001a\u00020\fJ\u0006\u0010l\u001a\u00020\fJ\u0006\u0010m\u001a\u00020\fJ\u0006\u0010n\u001a\u00020\fJ\u0006\u0010o\u001a\u00020\fJ\u0006\u0010p\u001a\u00020\fJ4\u0010q\u001a\u00020P\"\b\b\u0000\u0010`*\u00020r2\u0012\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u0002H`0R2\u0006\u0010\u0005\u001a\u0002H`H\u0086\n¢\u0006\u0002\u0010sJ:\u0010q\u001a\u00020P\"\u000e\b\u0000\u0010`*\b\u0012\u0004\u0012\u0002H`0t2\u0012\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u0002H`0R2\u0006\u0010\u0005\u001a\u0002H`H\u0086\n¢\u0006\u0002\u0010uJ%\u0010q\u001a\u00020P2\u0012\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020v0R2\u0006\u0010\u0005\u001a\u00020vH\u0086\nJ1\u0010w\u001a\u00020P\"\b\b\u0000\u0010`*\u00020\u00012\u0012\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u0002H`0R2\u0006\u0010\u0005\u001a\u0002H`¢\u0006\u0002\u0010xJ%\u0010y\u001a\u00020P*\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00162\u0006\u0010\u0005\u001a\u00020\u0017H\u0007¢\u0006\u0002\bzJ%\u0010y\u001a\u00020P*\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020;0\u00162\u0006\u0010\u0005\u001a\u00020:H\u0007¢\u0006\u0002\b{J%\u0010y\u001a\u00020P*\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020?0\u00162\u0006\u0010\u0005\u001a\u00020>H\u0007¢\u0006\u0002\b|J-\u0010y\u001a\u00020P\"\b\b\u0000\u0010c*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002Hc\u0012\u0004\u0012\u00020N0b2\u0006\u0010\u0005\u001a\u0002Hc¢\u0006\u0002\u0010}J-\u0010~\u001a\u00020P*\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00162\r\u0010\u007f\u001a\t\u0012\u0004\u0012\u00020\u00170\u0080\u0001H\u0007¢\u0006\u0003\b\u0081\u0001J-\u0010~\u001a\u00020P*\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020;0\u00162\r\u0010\u007f\u001a\t\u0012\u0004\u0012\u00020:0\u0080\u0001H\u0007¢\u0006\u0003\b\u0082\u0001J-\u0010~\u001a\u00020P*\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020?0\u00162\r\u0010\u007f\u001a\t\u0012\u0004\u0012\u00020>0\u0080\u0001H\u0007¢\u0006\u0003\b\u0083\u0001J/\u0010~\u001a\u00020P\"\b\b\u0000\u0010c*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002Hc\u0012\u0004\u0012\u00020N0b2\r\u0010\u007f\u001a\t\u0012\u0004\u0012\u0002Hc0\u0080\u0001J\u001e\u0010O\u001a\u00020P*\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016H\u0007¢\u0006\u0003\b\u0084\u0001J\u001e\u0010O\u001a\u00020P*\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020;0\u0016H\u0007¢\u0006\u0003\b\u0085\u0001J\u001e\u0010O\u001a\u00020P*\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020?0\u0016H\u0007¢\u0006\u0003\b\u0086\u0001J\u0017\u0010O\u001a\u00020P*\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020N0bH\u0086\bJ(\u0010\u0087\u0001\u001a\u00020P*\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00162\u0006\u0010\u0005\u001a\u00020\u0017H\u0087\n¢\u0006\u0003\b\u0088\u0001J/\u0010\u0087\u0001\u001a\u00020P*\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00162\r\u0010\u007f\u001a\t\u0012\u0004\u0012\u00020\u00170\u0080\u0001H\u0087\n¢\u0006\u0003\b\u0089\u0001J(\u0010\u0087\u0001\u001a\u00020P*\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020;0\u00162\u0006\u0010\u0005\u001a\u00020:H\u0087\n¢\u0006\u0003\b\u008a\u0001J/\u0010\u0087\u0001\u001a\u00020P*\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020;0\u00162\r\u0010\u007f\u001a\t\u0012\u0004\u0012\u00020:0\u0080\u0001H\u0087\n¢\u0006\u0003\b\u008b\u0001J(\u0010\u0087\u0001\u001a\u00020P*\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020?0\u00162\u0006\u0010\u0005\u001a\u00020>H\u0087\n¢\u0006\u0003\b\u008c\u0001J/\u0010\u0087\u0001\u001a\u00020P*\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020?0\u00162\r\u0010\u007f\u001a\t\u0012\u0004\u0012\u00020>0\u0080\u0001H\u0087\n¢\u0006\u0003\b\u008d\u0001J1\u0010\u0087\u0001\u001a\u00020P\"\b\b\u0000\u0010c*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002Hc\u0012\u0004\u0012\u00020N0b2\u0006\u0010\u0005\u001a\u0002HcH\u0086\n¢\u0006\u0002\u0010}J3\u0010\u0087\u0001\u001a\u00020P\"\b\b\u0000\u0010c*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002Hc\u0012\u0004\u0012\u00020N0b2\r\u0010\u007f\u001a\t\u0012\u0004\u0012\u0002Hc0\u0080\u0001H\u0086\nJ1\u0010q\u001a\u00020P*\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00162\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\u0006\u0010\u0005\u001a\u00020\u0017H\u0087\u0002¢\u0006\u0003\b\u0090\u0001J1\u0010q\u001a\u00020P*\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020;0\u00162\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\u0006\u0010\u0005\u001a\u00020:H\u0087\u0002¢\u0006\u0003\b\u0091\u0001J1\u0010q\u001a\u00020P*\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020?0\u00162\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\u0006\u0010\u0005\u001a\u00020>H\u0087\u0002¢\u0006\u0003\b\u0092\u0001J;\u0010q\u001a\u00020P\"\b\b\u0000\u0010c*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002Hc\u0012\u0004\u0012\u00020N0b2\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\u0006\u0010\u0005\u001a\u0002HcH\u0086\u0002¢\u0006\u0003\u0010\u0093\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001d\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00168F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u001b8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u00020!2\u0006\u0010\u0005\u001a\u00020!8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010(\u001a\u00020'2\u0006\u0010\u0005\u001a\u00020'8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010-\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b.\u0010\u000f\"\u0004\b/\u0010\u0011R$\u00100\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b1\u0010\u000f\"\u0004\b2\u0010\u0011R$\u00104\u001a\u0002032\u0006\u0010\u0005\u001a\u0002038G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001d\u00109\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020;0\u00168F¢\u0006\u0006\u001a\u0004\b<\u0010\u001aR\u001d\u0010=\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020?0\u00168F¢\u0006\u0006\u001a\u0004\b@\u0010\u001aR$\u0010A\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bB\u0010\u000f\"\u0004\bC\u0010\u0011R$\u0010D\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bE\u0010\u000f\"\u0004\bF\u0010\u0011R\u0017\u0010G\u001a\u0004\u0018\u00010\u001b*\u00020\u00008F¢\u0006\u0006\u001a\u0004\bH\u0010IR\u0017\u0010J\u001a\u0004\u0018\u00010!*\u00020\u00008F¢\u0006\u0006\u001a\u0004\bK\u0010L¨\u0006\u0098\u0001"}, d2 = {"Lcom/google/protobuf/FieldOptionsKt$Dsl;", "", "_builder", "Lcom/google/protobuf/DescriptorProtos$FieldOptions$Builder;", "(Lcom/google/protobuf/DescriptorProtos$FieldOptions$Builder;)V", "value", "Lcom/google/protobuf/DescriptorProtos$FieldOptions$CType;", "ctype", "getCtype", "()Lcom/google/protobuf/DescriptorProtos$FieldOptions$CType;", "setCtype", "(Lcom/google/protobuf/DescriptorProtos$FieldOptions$CType;)V", "", "debugRedact", "getDebugRedact", "()Z", "setDebugRedact", "(Z)V", "deprecated", "getDeprecated", "setDeprecated", "editionDefaults", "Lcom/google/protobuf/kotlin/DslList;", "Lcom/google/protobuf/DescriptorProtos$FieldOptions$EditionDefault;", "Lcom/google/protobuf/FieldOptionsKt$Dsl$EditionDefaultsProxy;", "getEditionDefaults", "()Lcom/google/protobuf/kotlin/DslList;", "Lcom/google/protobuf/DescriptorProtos$FieldOptions$FeatureSupport;", "featureSupport", "getFeatureSupport", "()Lcom/google/protobuf/DescriptorProtos$FieldOptions$FeatureSupport;", "setFeatureSupport", "(Lcom/google/protobuf/DescriptorProtos$FieldOptions$FeatureSupport;)V", "Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "features", "getFeatures", "()Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "setFeatures", "(Lcom/google/protobuf/DescriptorProtos$FeatureSet;)V", "Lcom/google/protobuf/DescriptorProtos$FieldOptions$JSType;", "jstype", "getJstype", "()Lcom/google/protobuf/DescriptorProtos$FieldOptions$JSType;", "setJstype", "(Lcom/google/protobuf/DescriptorProtos$FieldOptions$JSType;)V", "lazy", "getLazy", "setLazy", "packed", "getPacked", "setPacked", "Lcom/google/protobuf/DescriptorProtos$FieldOptions$OptionRetention;", "retention", "getRetention", "()Lcom/google/protobuf/DescriptorProtos$FieldOptions$OptionRetention;", "setRetention", "(Lcom/google/protobuf/DescriptorProtos$FieldOptions$OptionRetention;)V", "targets", "Lcom/google/protobuf/DescriptorProtos$FieldOptions$OptionTargetType;", "Lcom/google/protobuf/FieldOptionsKt$Dsl$TargetsProxy;", "getTargets", "uninterpretedOption", "Lcom/google/protobuf/DescriptorProtos$UninterpretedOption;", "Lcom/google/protobuf/FieldOptionsKt$Dsl$UninterpretedOptionProxy;", "getUninterpretedOption", "unverifiedLazy", "getUnverifiedLazy", "setUnverifiedLazy", "weak", "getWeak", "setWeak", "featureSupportOrNull", "getFeatureSupportOrNull", "(Lcom/google/protobuf/FieldOptionsKt$Dsl;)Lcom/google/protobuf/DescriptorProtos$FieldOptions$FeatureSupport;", "featuresOrNull", "getFeaturesOrNull", "(Lcom/google/protobuf/FieldOptionsKt$Dsl;)Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "_build", "Lcom/google/protobuf/DescriptorProtos$FieldOptions;", "clear", "", "extension", "Lcom/google/protobuf/ExtensionLite;", "clearCtype", "clearDebugRedact", "clearDeprecated", "clearFeatureSupport", "clearFeatures", "clearJstype", "clearLazy", "clearPacked", "clearRetention", "clearUnverifiedLazy", "clearWeak", "contains", "get", ExifInterface.GPS_DIRECTION_TRUE, "(Lcom/google/protobuf/ExtensionLite;)Ljava/lang/Object;", "Lcom/google/protobuf/kotlin/ExtensionList;", ExifInterface.LONGITUDE_EAST, "", "-getRepeatedExtension", "hasCtype", "hasDebugRedact", "hasDeprecated", "hasFeatureSupport", "hasFeatures", "hasJstype", "hasLazy", "hasPacked", "hasRetention", "hasUnverifiedLazy", "hasWeak", "set", "Lcom/google/protobuf/MessageLite;", "(Lcom/google/protobuf/ExtensionLite;Lcom/google/protobuf/MessageLite;)V", "", "(Lcom/google/protobuf/ExtensionLite;Ljava/lang/Comparable;)V", "Lcom/google/protobuf/ByteString;", "setExtension", "(Lcom/google/protobuf/ExtensionLite;Ljava/lang/Object;)V", "add", "addEditionDefaults", "addTargets", "addUninterpretedOption", "(Lcom/google/protobuf/kotlin/ExtensionList;Ljava/lang/Object;)V", "addAll", "values", "", "addAllEditionDefaults", "addAllTargets", "addAllUninterpretedOption", "clearEditionDefaults", "clearTargets", "clearUninterpretedOption", "plusAssign", "plusAssignEditionDefaults", "plusAssignAllEditionDefaults", "plusAssignTargets", "plusAssignAllTargets", "plusAssignUninterpretedOption", "plusAssignAllUninterpretedOption", ConfigConstants.CONFIG_INDEX_SECTION, "", "setEditionDefaults", "setTargets", "setUninterpretedOption", "(Lcom/google/protobuf/kotlin/ExtensionList;ILjava/lang/Object;)V", "Companion", "EditionDefaultsProxy", "TargetsProxy", "UninterpretedOptionProxy", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Dsl {

        /* INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final DescriptorProtos.FieldOptions.Builder _builder;

        public /* synthetic */ Dsl(DescriptorProtos.FieldOptions.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        private Dsl(DescriptorProtos.FieldOptions.Builder builder) {
            this._builder = builder;
        }

        /* INFO: compiled from: FieldOptionsKt.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/FieldOptionsKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/FieldOptionsKt$Dsl;", "builder", "Lcom/google/protobuf/DescriptorProtos$FieldOptions$Builder;", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final /* synthetic */ Dsl _create(DescriptorProtos.FieldOptions.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public final /* synthetic */ DescriptorProtos.FieldOptions _build() {
            DescriptorProtos.FieldOptions fieldOptionsBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(fieldOptionsBuild, "_builder.build()");
            return fieldOptionsBuild;
        }

        public final DescriptorProtos.FieldOptions.CType getCtype() {
            DescriptorProtos.FieldOptions.CType ctype = this._builder.getCtype();
            Intrinsics.checkNotNullExpressionValue(ctype, "_builder.getCtype()");
            return ctype;
        }

        public final void setCtype(DescriptorProtos.FieldOptions.CType value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setCtype(value);
        }

        public final void clearCtype() {
            this._builder.clearCtype();
        }

        public final boolean hasCtype() {
            return this._builder.hasCtype();
        }

        public final boolean getPacked() {
            return this._builder.getPacked();
        }

        public final void setPacked(boolean z) {
            this._builder.setPacked(z);
        }

        public final void clearPacked() {
            this._builder.clearPacked();
        }

        public final boolean hasPacked() {
            return this._builder.hasPacked();
        }

        public final DescriptorProtos.FieldOptions.JSType getJstype() {
            DescriptorProtos.FieldOptions.JSType jstype = this._builder.getJstype();
            Intrinsics.checkNotNullExpressionValue(jstype, "_builder.getJstype()");
            return jstype;
        }

        public final void setJstype(DescriptorProtos.FieldOptions.JSType value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setJstype(value);
        }

        public final void clearJstype() {
            this._builder.clearJstype();
        }

        public final boolean hasJstype() {
            return this._builder.hasJstype();
        }

        public final boolean getLazy() {
            return this._builder.getLazy();
        }

        public final void setLazy(boolean z) {
            this._builder.setLazy(z);
        }

        public final void clearLazy() {
            this._builder.clearLazy();
        }

        public final boolean hasLazy() {
            return this._builder.hasLazy();
        }

        public final boolean getUnverifiedLazy() {
            return this._builder.getUnverifiedLazy();
        }

        public final void setUnverifiedLazy(boolean z) {
            this._builder.setUnverifiedLazy(z);
        }

        public final void clearUnverifiedLazy() {
            this._builder.clearUnverifiedLazy();
        }

        public final boolean hasUnverifiedLazy() {
            return this._builder.hasUnverifiedLazy();
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

        public final boolean getWeak() {
            return this._builder.getWeak();
        }

        public final void setWeak(boolean z) {
            this._builder.setWeak(z);
        }

        public final void clearWeak() {
            this._builder.clearWeak();
        }

        public final boolean hasWeak() {
            return this._builder.hasWeak();
        }

        public final boolean getDebugRedact() {
            return this._builder.getDebugRedact();
        }

        public final void setDebugRedact(boolean z) {
            this._builder.setDebugRedact(z);
        }

        public final void clearDebugRedact() {
            this._builder.clearDebugRedact();
        }

        public final boolean hasDebugRedact() {
            return this._builder.hasDebugRedact();
        }

        public final DescriptorProtos.FieldOptions.OptionRetention getRetention() {
            DescriptorProtos.FieldOptions.OptionRetention retention = this._builder.getRetention();
            Intrinsics.checkNotNullExpressionValue(retention, "_builder.getRetention()");
            return retention;
        }

        public final void setRetention(DescriptorProtos.FieldOptions.OptionRetention value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setRetention(value);
        }

        public final void clearRetention() {
            this._builder.clearRetention();
        }

        public final boolean hasRetention() {
            return this._builder.hasRetention();
        }

        /* INFO: compiled from: FieldOptionsKt.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/FieldOptionsKt$Dsl$TargetsProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class TargetsProxy extends DslProxy {
            private TargetsProxy() {
            }
        }

        public final /* synthetic */ DslList getTargets() {
            List<DescriptorProtos.FieldOptions.OptionTargetType> targetsList = this._builder.getTargetsList();
            Intrinsics.checkNotNullExpressionValue(targetsList, "_builder.getTargetsList()");
            return new DslList(targetsList);
        }

        public final /* synthetic */ void addTargets(DslList dslList, DescriptorProtos.FieldOptions.OptionTargetType value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addTargets(value);
        }

        public final /* synthetic */ void plusAssignTargets(DslList<DescriptorProtos.FieldOptions.OptionTargetType, TargetsProxy> dslList, DescriptorProtos.FieldOptions.OptionTargetType value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addTargets(dslList, value);
        }

        public final /* synthetic */ void addAllTargets(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllTargets(values);
        }

        public final /* synthetic */ void plusAssignAllTargets(DslList<DescriptorProtos.FieldOptions.OptionTargetType, TargetsProxy> dslList, Iterable<? extends DescriptorProtos.FieldOptions.OptionTargetType> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllTargets(dslList, values);
        }

        public final /* synthetic */ void setTargets(DslList dslList, int i, DescriptorProtos.FieldOptions.OptionTargetType value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setTargets(i, value);
        }

        public final /* synthetic */ void clearTargets(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearTargets();
        }

        /* INFO: compiled from: FieldOptionsKt.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/FieldOptionsKt$Dsl$EditionDefaultsProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class EditionDefaultsProxy extends DslProxy {
            private EditionDefaultsProxy() {
            }
        }

        public final /* synthetic */ DslList getEditionDefaults() {
            List<DescriptorProtos.FieldOptions.EditionDefault> editionDefaultsList = this._builder.getEditionDefaultsList();
            Intrinsics.checkNotNullExpressionValue(editionDefaultsList, "_builder.getEditionDefaultsList()");
            return new DslList(editionDefaultsList);
        }

        public final /* synthetic */ void addEditionDefaults(DslList dslList, DescriptorProtos.FieldOptions.EditionDefault value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addEditionDefaults(value);
        }

        public final /* synthetic */ void plusAssignEditionDefaults(DslList<DescriptorProtos.FieldOptions.EditionDefault, EditionDefaultsProxy> dslList, DescriptorProtos.FieldOptions.EditionDefault value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addEditionDefaults(dslList, value);
        }

        public final /* synthetic */ void addAllEditionDefaults(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllEditionDefaults(values);
        }

        public final /* synthetic */ void plusAssignAllEditionDefaults(DslList<DescriptorProtos.FieldOptions.EditionDefault, EditionDefaultsProxy> dslList, Iterable<DescriptorProtos.FieldOptions.EditionDefault> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllEditionDefaults(dslList, values);
        }

        public final /* synthetic */ void setEditionDefaults(DslList dslList, int i, DescriptorProtos.FieldOptions.EditionDefault value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setEditionDefaults(i, value);
        }

        public final /* synthetic */ void clearEditionDefaults(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearEditionDefaults();
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
            return FieldOptionsKtKt.getFeaturesOrNull(dsl._builder);
        }

        public final DescriptorProtos.FieldOptions.FeatureSupport getFeatureSupport() {
            DescriptorProtos.FieldOptions.FeatureSupport featureSupport = this._builder.getFeatureSupport();
            Intrinsics.checkNotNullExpressionValue(featureSupport, "_builder.getFeatureSupport()");
            return featureSupport;
        }

        public final void setFeatureSupport(DescriptorProtos.FieldOptions.FeatureSupport value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setFeatureSupport(value);
        }

        public final void clearFeatureSupport() {
            this._builder.clearFeatureSupport();
        }

        public final boolean hasFeatureSupport() {
            return this._builder.hasFeatureSupport();
        }

        public final DescriptorProtos.FieldOptions.FeatureSupport getFeatureSupportOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return FieldOptionsKtKt.getFeatureSupportOrNull(dsl._builder);
        }

        /* INFO: compiled from: FieldOptionsKt.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/FieldOptionsKt$Dsl$UninterpretedOptionProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of com.google.protobuf.FieldOptionsKt.Dsl.get");
                return obj;
            }
            Object extension2 = this._builder.getExtension(extension);
            Intrinsics.checkNotNullExpressionValue(extension2, "{\n        _builder.getExtension(extension)\n      }");
            return extension2;
        }

        /* INFO: renamed from: -getRepeatedExtension, reason: not valid java name */
        public final /* synthetic */ ExtensionList m3409getRepeatedExtension(ExtensionLite extension) {
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

        public final /* synthetic */ <T extends Comparable<? super T>> void set(ExtensionLite<DescriptorProtos.FieldOptions, T> extension, T value) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            Intrinsics.checkNotNullParameter(value, "value");
            setExtension(extension, value);
        }

        public final /* synthetic */ void set(ExtensionLite<DescriptorProtos.FieldOptions, ByteString> extension, ByteString value) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            Intrinsics.checkNotNullParameter(value, "value");
            setExtension(extension, value);
        }

        public final /* synthetic */ <T extends MessageLite> void set(ExtensionLite<DescriptorProtos.FieldOptions, T> extension, T value) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            Intrinsics.checkNotNullParameter(value, "value");
            setExtension(extension, value);
        }

        public final /* synthetic */ void add(ExtensionList extensionList, Object value) {
            Intrinsics.checkNotNullParameter(extensionList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addExtension(extensionList.getExtension(), value);
        }

        public final /* synthetic */ <E> void plusAssign(ExtensionList<E, DescriptorProtos.FieldOptions> extensionList, E value) {
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

        public final /* synthetic */ <E> void plusAssign(ExtensionList<E, DescriptorProtos.FieldOptions> extensionList, Iterable<? extends E> values) {
            Intrinsics.checkNotNullParameter(extensionList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAll(extensionList, values);
        }

        public final /* synthetic */ void set(ExtensionList extensionList, int i, Object value) {
            Intrinsics.checkNotNullParameter(extensionList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setExtension(extensionList.getExtension(), i, value);
        }

        public final /* synthetic */ void clear(ExtensionList<?, DescriptorProtos.FieldOptions> extensionList) {
            Intrinsics.checkNotNullParameter(extensionList, "<this>");
            clear(extensionList.getExtension());
        }
    }

    private FieldOptionsKt() {
    }

    /* INFO: renamed from: -initializeeditionDefault, reason: not valid java name */
    public final DescriptorProtos.FieldOptions.EditionDefault m3407initializeeditionDefault(Function1<? super EditionDefaultKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        EditionDefaultKt.Dsl.Companion companion = EditionDefaultKt.Dsl.INSTANCE;
        DescriptorProtos.FieldOptions.EditionDefault.Builder builderNewBuilder = DescriptorProtos.FieldOptions.EditionDefault.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        EditionDefaultKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    /* INFO: compiled from: FieldOptionsKt.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/google/protobuf/FieldOptionsKt$EditionDefaultKt;", "", "()V", "Dsl", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class EditionDefaultKt {
        public static final EditionDefaultKt INSTANCE = new EditionDefaultKt();

        /* INFO: compiled from: FieldOptionsKt.kt */
        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u0005\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/google/protobuf/FieldOptionsKt$EditionDefaultKt$Dsl;", "", "_builder", "Lcom/google/protobuf/DescriptorProtos$FieldOptions$EditionDefault$Builder;", "(Lcom/google/protobuf/DescriptorProtos$FieldOptions$EditionDefault$Builder;)V", "value", "Lcom/google/protobuf/DescriptorProtos$Edition;", "edition", "getEdition", "()Lcom/google/protobuf/DescriptorProtos$Edition;", "setEdition", "(Lcom/google/protobuf/DescriptorProtos$Edition;)V", "", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "_build", "Lcom/google/protobuf/DescriptorProtos$FieldOptions$EditionDefault;", "clearEdition", "", "clearValue", "hasEdition", "", "hasValue", "Companion", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Dsl {

            /* INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final DescriptorProtos.FieldOptions.EditionDefault.Builder _builder;

            public /* synthetic */ Dsl(DescriptorProtos.FieldOptions.EditionDefault.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }

            private Dsl(DescriptorProtos.FieldOptions.EditionDefault.Builder builder) {
                this._builder = builder;
            }

            /* INFO: compiled from: FieldOptionsKt.kt */
            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/FieldOptionsKt$EditionDefaultKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/FieldOptionsKt$EditionDefaultKt$Dsl;", "builder", "Lcom/google/protobuf/DescriptorProtos$FieldOptions$EditionDefault$Builder;", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final /* synthetic */ Dsl _create(DescriptorProtos.FieldOptions.EditionDefault.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, null);
                }
            }

            public final /* synthetic */ DescriptorProtos.FieldOptions.EditionDefault _build() {
                DescriptorProtos.FieldOptions.EditionDefault editionDefaultBuild = this._builder.build();
                Intrinsics.checkNotNullExpressionValue(editionDefaultBuild, "_builder.build()");
                return editionDefaultBuild;
            }

            public final DescriptorProtos.Edition getEdition() {
                DescriptorProtos.Edition edition = this._builder.getEdition();
                Intrinsics.checkNotNullExpressionValue(edition, "_builder.getEdition()");
                return edition;
            }

            public final void setEdition(DescriptorProtos.Edition value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setEdition(value);
            }

            public final void clearEdition() {
                this._builder.clearEdition();
            }

            public final boolean hasEdition() {
                return this._builder.hasEdition();
            }

            public final String getValue() {
                String value = this._builder.getValue();
                Intrinsics.checkNotNullExpressionValue(value, "_builder.getValue()");
                return value;
            }

            public final void setValue(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setValue(value);
            }

            public final void clearValue() {
                this._builder.clearValue();
            }

            public final boolean hasValue() {
                return this._builder.hasValue();
            }
        }

        private EditionDefaultKt() {
        }
    }

    /* INFO: renamed from: -initializefeatureSupport, reason: not valid java name */
    public final DescriptorProtos.FieldOptions.FeatureSupport m3408initializefeatureSupport(Function1<? super FeatureSupportKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        FeatureSupportKt.Dsl.Companion companion = FeatureSupportKt.Dsl.INSTANCE;
        DescriptorProtos.FieldOptions.FeatureSupport.Builder builderNewBuilder = DescriptorProtos.FieldOptions.FeatureSupport.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        FeatureSupportKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    /* INFO: compiled from: FieldOptionsKt.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/google/protobuf/FieldOptionsKt$FeatureSupportKt;", "", "()V", "Dsl", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class FeatureSupportKt {
        public static final FeatureSupportKt INSTANCE = new FeatureSupportKt();

        /* INFO: compiled from: FieldOptionsKt.kt */
        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0018\u001a\u00020\u0019H\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001d\u001a\u00020\u001bJ\u0006\u0010\u001e\u001a\u00020\u001bJ\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020 J\u0006\u0010\"\u001a\u00020 J\u0006\u0010#\u001a\u00020 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R$\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006%"}, d2 = {"Lcom/google/protobuf/FieldOptionsKt$FeatureSupportKt$Dsl;", "", "_builder", "Lcom/google/protobuf/DescriptorProtos$FieldOptions$FeatureSupport$Builder;", "(Lcom/google/protobuf/DescriptorProtos$FieldOptions$FeatureSupport$Builder;)V", "value", "", "deprecationWarning", "getDeprecationWarning", "()Ljava/lang/String;", "setDeprecationWarning", "(Ljava/lang/String;)V", "Lcom/google/protobuf/DescriptorProtos$Edition;", "editionDeprecated", "getEditionDeprecated", "()Lcom/google/protobuf/DescriptorProtos$Edition;", "setEditionDeprecated", "(Lcom/google/protobuf/DescriptorProtos$Edition;)V", "editionIntroduced", "getEditionIntroduced", "setEditionIntroduced", "editionRemoved", "getEditionRemoved", "setEditionRemoved", "_build", "Lcom/google/protobuf/DescriptorProtos$FieldOptions$FeatureSupport;", "clearDeprecationWarning", "", "clearEditionDeprecated", "clearEditionIntroduced", "clearEditionRemoved", "hasDeprecationWarning", "", "hasEditionDeprecated", "hasEditionIntroduced", "hasEditionRemoved", "Companion", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Dsl {

            /* INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final DescriptorProtos.FieldOptions.FeatureSupport.Builder _builder;

            public /* synthetic */ Dsl(DescriptorProtos.FieldOptions.FeatureSupport.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }

            private Dsl(DescriptorProtos.FieldOptions.FeatureSupport.Builder builder) {
                this._builder = builder;
            }

            /* INFO: compiled from: FieldOptionsKt.kt */
            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/FieldOptionsKt$FeatureSupportKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/FieldOptionsKt$FeatureSupportKt$Dsl;", "builder", "Lcom/google/protobuf/DescriptorProtos$FieldOptions$FeatureSupport$Builder;", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final /* synthetic */ Dsl _create(DescriptorProtos.FieldOptions.FeatureSupport.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, null);
                }
            }

            public final /* synthetic */ DescriptorProtos.FieldOptions.FeatureSupport _build() {
                DescriptorProtos.FieldOptions.FeatureSupport featureSupportBuild = this._builder.build();
                Intrinsics.checkNotNullExpressionValue(featureSupportBuild, "_builder.build()");
                return featureSupportBuild;
            }

            public final DescriptorProtos.Edition getEditionIntroduced() {
                DescriptorProtos.Edition editionIntroduced = this._builder.getEditionIntroduced();
                Intrinsics.checkNotNullExpressionValue(editionIntroduced, "_builder.getEditionIntroduced()");
                return editionIntroduced;
            }

            public final void setEditionIntroduced(DescriptorProtos.Edition value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setEditionIntroduced(value);
            }

            public final void clearEditionIntroduced() {
                this._builder.clearEditionIntroduced();
            }

            public final boolean hasEditionIntroduced() {
                return this._builder.hasEditionIntroduced();
            }

            public final DescriptorProtos.Edition getEditionDeprecated() {
                DescriptorProtos.Edition editionDeprecated = this._builder.getEditionDeprecated();
                Intrinsics.checkNotNullExpressionValue(editionDeprecated, "_builder.getEditionDeprecated()");
                return editionDeprecated;
            }

            public final void setEditionDeprecated(DescriptorProtos.Edition value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setEditionDeprecated(value);
            }

            public final void clearEditionDeprecated() {
                this._builder.clearEditionDeprecated();
            }

            public final boolean hasEditionDeprecated() {
                return this._builder.hasEditionDeprecated();
            }

            public final String getDeprecationWarning() {
                String deprecationWarning = this._builder.getDeprecationWarning();
                Intrinsics.checkNotNullExpressionValue(deprecationWarning, "_builder.getDeprecationWarning()");
                return deprecationWarning;
            }

            public final void setDeprecationWarning(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setDeprecationWarning(value);
            }

            public final void clearDeprecationWarning() {
                this._builder.clearDeprecationWarning();
            }

            public final boolean hasDeprecationWarning() {
                return this._builder.hasDeprecationWarning();
            }

            public final DescriptorProtos.Edition getEditionRemoved() {
                DescriptorProtos.Edition editionRemoved = this._builder.getEditionRemoved();
                Intrinsics.checkNotNullExpressionValue(editionRemoved, "_builder.getEditionRemoved()");
                return editionRemoved;
            }

            public final void setEditionRemoved(DescriptorProtos.Edition value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setEditionRemoved(value);
            }

            public final void clearEditionRemoved() {
                this._builder.clearEditionRemoved();
            }

            public final boolean hasEditionRemoved() {
                return this._builder.hasEditionRemoved();
            }
        }

        private FeatureSupportKt() {
        }
    }
}
