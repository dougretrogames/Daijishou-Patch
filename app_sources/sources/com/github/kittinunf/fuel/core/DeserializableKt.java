package com.github.kittinunf.fuel.core;

import androidx.exifinterface.media.ExifInterface;
import com.github.kittinunf.fuel.core.deserializers.EmptyDeserializer;
import com.github.kittinunf.fuel.core.requests.CancellableRequest;
import com.github.kittinunf.fuel.core.requests.RequestTaskCallbacks;
import com.github.kittinunf.fuel.core.requests.RequestTaskKt;
import com.github.kittinunf.fuel.core.requests.SuspendableRequest;
import com.github.kittinunf.fuel.core.requests.SuspendableRequestKt;
import com.github.kittinunf.result.Result;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: Deserializable.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a[\u0010\u0000\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00040\u0002\u0012\u0004\u0012\u00020\u00050\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0006\"\u000e\b\u0001\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00040\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u00012\u0006\u0010\n\u001a\u0002H\u0007H\u0002¢\u0006\u0002\u0010\u000b\u001a7\u0010\f\u001a\u0002H\u0004\"\b\b\u0000\u0010\u0004*\u00020\u0006\"\u000e\b\u0001\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00040\b*\u00020\r2\u0006\u0010\n\u001a\u0002H\u0007H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001aS\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00040\u0010j\b\u0012\u0004\u0012\u0002H\u0004`\u0011\"\b\b\u0000\u0010\u0004*\u00020\u0006\"\u000e\b\u0001\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00040\b*\u00020\r2\u0006\u0010\n\u001a\u0002H\u0007H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a_\u0010\u0012\u001a*\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00050\u00010\u0010j\b\u0012\u0004\u0012\u0002H\u0004`\u0013\"\b\b\u0000\u0010\u0004*\u00020\u0006\"\u000e\b\u0001\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00040\b*\u00020\r2\u0006\u0010\n\u001a\u0002H\u0007H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001aC\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00050\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0006\"\u000e\b\u0001\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00040\b*\u00020\r2\u0006\u0010\n\u001a\u0002H\u0007H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a\u0015\u0010\u0015\u001a\u00020\u0016*\u00020\rH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001aY\u0010\u0018\u001a*\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00050\u00010\u0010j\b\u0012\u0004\u0012\u0002H\u0004`\u0013\"\b\b\u0000\u0010\u0004*\u00020\u0006\"\u000e\b\u0001\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00040\b*\u00020\r2\u0006\u0010\n\u001a\u0002H\u0007¢\u0006\u0002\u0010\u0019\u001as\u0010\u0018\u001a\u00020\u001a\"\b\b\u0000\u0010\u0004*\u00020\u0006\"\u000e\b\u0001\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00040\b*\u00020\r2\u0006\u0010\n\u001a\u0002H\u00072\u001e\u0010\u001b\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00160\u001c2\u001e\u0010\u001d\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00160\u001cH\u0002¢\u0006\u0002\u0010\u001e\u001a?\u0010\u0018\u001a\u00020\u001a\"\b\b\u0000\u0010\u0004*\u00020\u0006\"\u000e\b\u0001\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00040\b*\u00020\r2\u0006\u0010\n\u001a\u0002H\u00072\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00040 ¢\u0006\u0002\u0010!\u001a?\u0010\u0018\u001a\u00020\u001a\"\b\b\u0000\u0010\u0004*\u00020\u0006\"\u000e\b\u0001\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00040\b*\u00020\r2\u0006\u0010\n\u001a\u0002H\u00072\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00040\"¢\u0006\u0002\u0010#\u001ag\u0010\u0018\u001a\u00020\u001a\"\b\b\u0000\u0010\u0004*\u00020\u0006\"\u000e\b\u0001\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00040\b*\u00020\r2\u0006\u0010\n\u001a\u0002H\u000724\u0010\u001f\u001a0\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00050\u0001\u0012\u0004\u0012\u00020\u00160\u001cj\b\u0012\u0004\u0012\u0002H\u0004`$¢\u0006\u0002\u0010%\u001a[\u0010\u0018\u001a\u00020\u001a\"\b\b\u0000\u0010\u0004*\u00020\u0006\"\u000e\b\u0001\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00040\b*\u00020\r2\u0006\u0010\n\u001a\u0002H\u00072(\u0010\u001f\u001a$\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00050\u0001\u0012\u0004\u0012\u00020\u00160&j\b\u0012\u0004\u0012\u0002H\u0004`'¢\u0006\u0002\u0010(\u001a2\u0010)\u001a*\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00050\u00010\u0010j\b\u0012\u0004\u0012\u00020\u0016`\u0013*\u00020\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, d2 = {"serializeFor", "Lcom/github/kittinunf/result/Result;", "Lkotlin/Pair;", "Lcom/github/kittinunf/fuel/core/Response;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/github/kittinunf/fuel/core/FuelError;", "", "U", "Lcom/github/kittinunf/fuel/core/Deserializable;", "result", "deserializable", "(Lcom/github/kittinunf/result/Result;Lcom/github/kittinunf/fuel/core/Deserializable;)Lcom/github/kittinunf/result/Result;", "await", "Lcom/github/kittinunf/fuel/core/Request;", "(Lcom/github/kittinunf/fuel/core/Request;Lcom/github/kittinunf/fuel/core/Deserializable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitResponse", "Lkotlin/Triple;", "Lcom/github/kittinunf/fuel/core/ResponseOf;", "awaitResponseResult", "Lcom/github/kittinunf/fuel/core/ResponseResultOf;", "awaitResult", "awaitUnit", "", "(Lcom/github/kittinunf/fuel/core/Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "response", "(Lcom/github/kittinunf/fuel/core/Request;Lcom/github/kittinunf/fuel/core/Deserializable;)Lkotlin/Triple;", "Lcom/github/kittinunf/fuel/core/requests/CancellableRequest;", "success", "Lkotlin/Function3;", "failure", "(Lcom/github/kittinunf/fuel/core/Request;Lcom/github/kittinunf/fuel/core/Deserializable;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;)Lcom/github/kittinunf/fuel/core/requests/CancellableRequest;", "handler", "Lcom/github/kittinunf/fuel/core/Handler;", "(Lcom/github/kittinunf/fuel/core/Request;Lcom/github/kittinunf/fuel/core/Deserializable;Lcom/github/kittinunf/fuel/core/Handler;)Lcom/github/kittinunf/fuel/core/requests/CancellableRequest;", "Lcom/github/kittinunf/fuel/core/ResponseHandler;", "(Lcom/github/kittinunf/fuel/core/Request;Lcom/github/kittinunf/fuel/core/Deserializable;Lcom/github/kittinunf/fuel/core/ResponseHandler;)Lcom/github/kittinunf/fuel/core/requests/CancellableRequest;", "Lcom/github/kittinunf/fuel/core/ResponseResultHandler;", "(Lcom/github/kittinunf/fuel/core/Request;Lcom/github/kittinunf/fuel/core/Deserializable;Lkotlin/jvm/functions/Function3;)Lcom/github/kittinunf/fuel/core/requests/CancellableRequest;", "Lkotlin/Function1;", "Lcom/github/kittinunf/fuel/core/ResultHandler;", "(Lcom/github/kittinunf/fuel/core/Request;Lcom/github/kittinunf/fuel/core/Deserializable;Lkotlin/jvm/functions/Function1;)Lcom/github/kittinunf/fuel/core/requests/CancellableRequest;", "responseUnit", "fuel"}, k = 2, mv = {1, 4, 0})
public final class DeserializableKt {

    /* INFO: renamed from: com.github.kittinunf.fuel.core.DeserializableKt$await$1, reason: invalid class name */
    /* INFO: compiled from: Deserializable.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0001\"\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0086@"}, d2 = {"await", "", ExifInterface.GPS_DIRECTION_TRUE, "U", "Lcom/github/kittinunf/fuel/core/Deserializable;", "Lcom/github/kittinunf/fuel/core/Request;", "deserializable", "continuation", "Lkotlin/coroutines/Continuation;"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "com.github.kittinunf.fuel.core.DeserializableKt", f = "Deserializable.kt", i = {0, 0}, l = {233}, m = "await", n = {"$this$await", "deserializable"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeserializableKt.await(null, null, this);
        }
    }

    /* INFO: renamed from: com.github.kittinunf.fuel.core.DeserializableKt$awaitResponse$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: Deserializable.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0001\"\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u00032(\u0010\u0007\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\u00020\tj\b\u0012\u0004\u0012\u0002H\u0002`\u000b0\bH\u0086@"}, d2 = {"awaitResponse", "", ExifInterface.GPS_DIRECTION_TRUE, "U", "Lcom/github/kittinunf/fuel/core/Deserializable;", "Lcom/github/kittinunf/fuel/core/Request;", "deserializable", "continuation", "Lkotlin/coroutines/Continuation;", "Lkotlin/Triple;", "Lcom/github/kittinunf/fuel/core/Response;", "Lcom/github/kittinunf/fuel/core/ResponseOf;"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "com.github.kittinunf.fuel.core.DeserializableKt", f = "Deserializable.kt", i = {0, 0}, l = {256}, m = "awaitResponse", n = {"$this$awaitResponse", "deserializable"}, s = {"L$0", "L$1"})
    static final class C01871 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C01871(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeserializableKt.awaitResponse(null, null, this);
        }
    }

    /* INFO: renamed from: com.github.kittinunf.fuel.core.DeserializableKt$awaitResponseResult$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: Deserializable.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0001\"\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u000324\u0010\u0007\u001a0\u0012,\u0012*\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\f0\u000b0\tj\b\u0012\u0004\u0012\u0002H\u0002`\r0\bH\u0086@"}, d2 = {"awaitResponseResult", "", ExifInterface.GPS_DIRECTION_TRUE, "U", "Lcom/github/kittinunf/fuel/core/Deserializable;", "Lcom/github/kittinunf/fuel/core/Request;", "deserializable", "continuation", "Lkotlin/coroutines/Continuation;", "Lkotlin/Triple;", "Lcom/github/kittinunf/fuel/core/Response;", "Lcom/github/kittinunf/result/Result;", "Lcom/github/kittinunf/fuel/core/FuelError;", "Lcom/github/kittinunf/fuel/core/ResponseResultOf;"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "com.github.kittinunf.fuel.core.DeserializableKt", f = "Deserializable.kt", i = {0, 0}, l = {276}, m = "awaitResponseResult", n = {"$this$awaitResponseResult", "deserializable"}, s = {"L$0", "L$1"})
    static final class C01881 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C01881(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeserializableKt.awaitResponseResult(null, null, this);
        }
    }

    /* INFO: renamed from: com.github.kittinunf.fuel.core.DeserializableKt$awaitResult$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: Deserializable.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0001\"\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u00032\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\n0\t0\bH\u0086@"}, d2 = {"awaitResult", "", ExifInterface.GPS_DIRECTION_TRUE, "U", "Lcom/github/kittinunf/fuel/core/Deserializable;", "Lcom/github/kittinunf/fuel/core/Request;", "deserializable", "continuation", "Lkotlin/coroutines/Continuation;", "Lcom/github/kittinunf/result/Result;", "Lcom/github/kittinunf/fuel/core/FuelError;"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "com.github.kittinunf.fuel.core.DeserializableKt", f = "Deserializable.kt", i = {0, 0}, l = {267}, m = "awaitResult", n = {"$this$awaitResult", "deserializable"}, s = {"L$0", "L$1"})
    static final class C01891 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C01891(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeserializableKt.awaitResult(null, null, this);
        }
    }

    /* INFO: Add missing generic type declarations: [T] */
    /* INFO: renamed from: com.github.kittinunf.fuel.core.DeserializableKt$response$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: Deserializable.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "U", "Lcom/github/kittinunf/fuel/core/Deserializable;", "request", "Lcom/github/kittinunf/fuel/core/Request;", "response", "Lcom/github/kittinunf/fuel/core/Response;", "value", "invoke", "(Lcom/github/kittinunf/fuel/core/Request;Lcom/github/kittinunf/fuel/core/Response;Ljava/lang/Object;)V"}, k = 3, mv = {1, 4, 0})
    static final class C01901<T> extends Lambda implements Function3<Request, Response, T, Unit> {
        final /* synthetic */ Function3 $handler;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01901(Function3 function3) {
            super(3);
            this.$handler = function3;
        }

        /* WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Request request, Response response, Object obj) {
            invoke2(request, response, obj);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Request request, Response response, T value) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(response, "response");
            Intrinsics.checkNotNullParameter(value, "value");
            this.$handler.invoke(request, response, new Result.Success(value));
        }
    }

    /* INFO: renamed from: com.github.kittinunf.fuel.core.DeserializableKt$response$2, reason: invalid class name */
    /* INFO: compiled from: Deserializable.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\n¢\u0006\u0002\b\f"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "U", "Lcom/github/kittinunf/fuel/core/Deserializable;", "request", "Lcom/github/kittinunf/fuel/core/Request;", "response", "Lcom/github/kittinunf/fuel/core/Response;", "error", "Lcom/github/kittinunf/fuel/core/FuelError;", "invoke"}, k = 3, mv = {1, 4, 0})
    static final class AnonymousClass2 extends Lambda implements Function3<Request, Response, FuelError, Unit> {
        final /* synthetic */ Function3 $handler;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Function3 function3) {
            super(3);
            this.$handler = function3;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Request request, Response response, FuelError fuelError) {
            invoke2(request, response, fuelError);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Request request, Response response, FuelError error) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(response, "response");
            Intrinsics.checkNotNullParameter(error, "error");
            this.$handler.invoke(request, response, new Result.Failure(error));
        }
    }

    public static final <T, U extends Deserializable<? extends T>> CancellableRequest response(Request response, U deserializable, Function3<? super Request, ? super Response, ? super Result<? extends T, ? extends FuelError>, Unit> handler) {
        Intrinsics.checkNotNullParameter(response, "$this$response");
        Intrinsics.checkNotNullParameter(deserializable, "deserializable");
        Intrinsics.checkNotNullParameter(handler, "handler");
        return response(response, deserializable, new C01901(handler), new AnonymousClass2(handler));
    }

    /* INFO: Add missing generic type declarations: [T] */
    /* INFO: renamed from: com.github.kittinunf.fuel.core.DeserializableKt$response$3, reason: invalid class name */
    /* INFO: compiled from: Deserializable.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "U", "Lcom/github/kittinunf/fuel/core/Deserializable;", "<anonymous parameter 0>", "Lcom/github/kittinunf/fuel/core/Request;", "<anonymous parameter 1>", "Lcom/github/kittinunf/fuel/core/Response;", "value", "invoke", "(Lcom/github/kittinunf/fuel/core/Request;Lcom/github/kittinunf/fuel/core/Response;Ljava/lang/Object;)V"}, k = 3, mv = {1, 4, 0})
    static final class AnonymousClass3<T> extends Lambda implements Function3<Request, Response, T, Unit> {
        final /* synthetic */ Function1 $handler;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Function1 function1) {
            super(3);
            this.$handler = function1;
        }

        /* WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Request request, Response response, Object obj) {
            invoke2(request, response, obj);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Request request, Response response, T value) {
            Intrinsics.checkNotNullParameter(request, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(response, "<anonymous parameter 1>");
            Intrinsics.checkNotNullParameter(value, "value");
            this.$handler.invoke(new Result.Success(value));
        }
    }

    /* INFO: renamed from: com.github.kittinunf.fuel.core.DeserializableKt$response$4, reason: invalid class name */
    /* INFO: compiled from: Deserializable.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\n¢\u0006\u0002\b\f"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "U", "Lcom/github/kittinunf/fuel/core/Deserializable;", "<anonymous parameter 0>", "Lcom/github/kittinunf/fuel/core/Request;", "<anonymous parameter 1>", "Lcom/github/kittinunf/fuel/core/Response;", "error", "Lcom/github/kittinunf/fuel/core/FuelError;", "invoke"}, k = 3, mv = {1, 4, 0})
    static final class AnonymousClass4 extends Lambda implements Function3<Request, Response, FuelError, Unit> {
        final /* synthetic */ Function1 $handler;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(Function1 function1) {
            super(3);
            this.$handler = function1;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Request request, Response response, FuelError fuelError) {
            invoke2(request, response, fuelError);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Request request, Response response, FuelError error) {
            Intrinsics.checkNotNullParameter(request, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(response, "<anonymous parameter 1>");
            Intrinsics.checkNotNullParameter(error, "error");
            this.$handler.invoke(new Result.Failure(error));
        }
    }

    public static final <T, U extends Deserializable<? extends T>> CancellableRequest response(Request response, U deserializable, Function1<? super Result<? extends T, ? extends FuelError>, Unit> handler) {
        Intrinsics.checkNotNullParameter(response, "$this$response");
        Intrinsics.checkNotNullParameter(deserializable, "deserializable");
        Intrinsics.checkNotNullParameter(handler, "handler");
        return response(response, deserializable, new AnonymousClass3(handler), new AnonymousClass4(handler));
    }

    /* INFO: Add missing generic type declarations: [T] */
    /* INFO: renamed from: com.github.kittinunf.fuel.core.DeserializableKt$response$5, reason: invalid class name */
    /* INFO: compiled from: Deserializable.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "U", "Lcom/github/kittinunf/fuel/core/Deserializable;", "request", "Lcom/github/kittinunf/fuel/core/Request;", "response", "Lcom/github/kittinunf/fuel/core/Response;", "value", "invoke", "(Lcom/github/kittinunf/fuel/core/Request;Lcom/github/kittinunf/fuel/core/Response;Ljava/lang/Object;)V"}, k = 3, mv = {1, 4, 0})
    static final class AnonymousClass5<T> extends Lambda implements Function3<Request, Response, T, Unit> {
        final /* synthetic */ ResponseHandler $handler;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(ResponseHandler responseHandler) {
            super(3);
            this.$handler = responseHandler;
        }

        /* WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Request request, Response response, Object obj) {
            invoke2(request, response, obj);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Request request, Response response, T value) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(response, "response");
            Intrinsics.checkNotNullParameter(value, "value");
            this.$handler.success(request, response, value);
        }
    }

    /* INFO: renamed from: com.github.kittinunf.fuel.core.DeserializableKt$response$6, reason: invalid class name */
    /* INFO: compiled from: Deserializable.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\n¢\u0006\u0002\b\f"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "U", "Lcom/github/kittinunf/fuel/core/Deserializable;", "request", "Lcom/github/kittinunf/fuel/core/Request;", "response", "Lcom/github/kittinunf/fuel/core/Response;", "error", "Lcom/github/kittinunf/fuel/core/FuelError;", "invoke"}, k = 3, mv = {1, 4, 0})
    static final class AnonymousClass6 extends Lambda implements Function3<Request, Response, FuelError, Unit> {
        final /* synthetic */ ResponseHandler $handler;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(ResponseHandler responseHandler) {
            super(3);
            this.$handler = responseHandler;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Request request, Response response, FuelError fuelError) {
            invoke2(request, response, fuelError);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Request request, Response response, FuelError error) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(response, "response");
            Intrinsics.checkNotNullParameter(error, "error");
            this.$handler.failure(request, response, error);
        }
    }

    public static final <T, U extends Deserializable<? extends T>> CancellableRequest response(Request response, U deserializable, ResponseHandler<? super T> handler) {
        Intrinsics.checkNotNullParameter(response, "$this$response");
        Intrinsics.checkNotNullParameter(deserializable, "deserializable");
        Intrinsics.checkNotNullParameter(handler, "handler");
        return response(response, deserializable, new AnonymousClass5(handler), new AnonymousClass6(handler));
    }

    /* INFO: Add missing generic type declarations: [T] */
    /* INFO: renamed from: com.github.kittinunf.fuel.core.DeserializableKt$response$7, reason: invalid class name */
    /* INFO: compiled from: Deserializable.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "U", "Lcom/github/kittinunf/fuel/core/Deserializable;", "<anonymous parameter 0>", "Lcom/github/kittinunf/fuel/core/Request;", "<anonymous parameter 1>", "Lcom/github/kittinunf/fuel/core/Response;", "value", "invoke", "(Lcom/github/kittinunf/fuel/core/Request;Lcom/github/kittinunf/fuel/core/Response;Ljava/lang/Object;)V"}, k = 3, mv = {1, 4, 0})
    static final class AnonymousClass7<T> extends Lambda implements Function3<Request, Response, T, Unit> {
        final /* synthetic */ Handler $handler;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass7(Handler handler) {
            super(3);
            this.$handler = handler;
        }

        /* WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Request request, Response response, Object obj) {
            invoke2(request, response, obj);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Request request, Response response, T value) {
            Intrinsics.checkNotNullParameter(request, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(response, "<anonymous parameter 1>");
            Intrinsics.checkNotNullParameter(value, "value");
            this.$handler.success(value);
        }
    }

    /* INFO: renamed from: com.github.kittinunf.fuel.core.DeserializableKt$response$8, reason: invalid class name */
    /* INFO: compiled from: Deserializable.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\n¢\u0006\u0002\b\f"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "U", "Lcom/github/kittinunf/fuel/core/Deserializable;", "<anonymous parameter 0>", "Lcom/github/kittinunf/fuel/core/Request;", "<anonymous parameter 1>", "Lcom/github/kittinunf/fuel/core/Response;", "error", "Lcom/github/kittinunf/fuel/core/FuelError;", "invoke"}, k = 3, mv = {1, 4, 0})
    static final class AnonymousClass8 extends Lambda implements Function3<Request, Response, FuelError, Unit> {
        final /* synthetic */ Handler $handler;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass8(Handler handler) {
            super(3);
            this.$handler = handler;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Request request, Response response, FuelError fuelError) {
            invoke2(request, response, fuelError);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Request request, Response response, FuelError error) {
            Intrinsics.checkNotNullParameter(request, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(response, "<anonymous parameter 1>");
            Intrinsics.checkNotNullParameter(error, "error");
            this.$handler.failure(error);
        }
    }

    public static final <T, U extends Deserializable<? extends T>> CancellableRequest response(Request response, U deserializable, Handler<? super T> handler) {
        Intrinsics.checkNotNullParameter(response, "$this$response");
        Intrinsics.checkNotNullParameter(deserializable, "deserializable");
        Intrinsics.checkNotNullParameter(handler, "handler");
        return response(response, deserializable, new AnonymousClass7(handler), new AnonymousClass8(handler));
    }

    public static final <T, U extends Deserializable<? extends T>> Triple<Request, Response, Result<T, FuelError>> response(Request response, U deserializable) throws Throwable {
        Object objM3752constructorimpl;
        Object objM3752constructorimpl2;
        Intrinsics.checkNotNullParameter(response, "$this$response");
        Intrinsics.checkNotNullParameter(deserializable, "deserializable");
        try {
            kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
            objM3752constructorimpl = kotlin.Result.m3752constructorimpl(RequestTaskKt.toTask(response).call());
        } catch (Throwable th) {
            kotlin.Result.Companion companion2 = kotlin.Result.INSTANCE;
            objM3752constructorimpl = kotlin.Result.m3752constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM3755exceptionOrNullimpl = kotlin.Result.m3755exceptionOrNullimpl(objM3752constructorimpl);
        if (thM3755exceptionOrNullimpl != null) {
            FuelError fuelErrorWrap = FuelError.INSTANCE.wrap(thM3755exceptionOrNullimpl, Response.INSTANCE.error(response.getUrl()));
            return new Triple<>(response, fuelErrorWrap.getResponse(), Result.INSTANCE.error(fuelErrorWrap));
        }
        ResultKt.throwOnFailure(objM3752constructorimpl);
        Response rawResponse = (Response) objM3752constructorimpl;
        try {
            kotlin.Result.Companion companion3 = kotlin.Result.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(rawResponse, "rawResponse");
            objM3752constructorimpl2 = kotlin.Result.m3752constructorimpl(new Triple(response, rawResponse, new Result.Success(deserializable.deserialize(rawResponse))));
        } catch (Throwable th2) {
            kotlin.Result.Companion companion4 = kotlin.Result.INSTANCE;
            objM3752constructorimpl2 = kotlin.Result.m3752constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable thM3755exceptionOrNullimpl2 = kotlin.Result.m3755exceptionOrNullimpl(objM3752constructorimpl2);
        if (thM3755exceptionOrNullimpl2 != null) {
            kotlin.Result.Companion companion5 = kotlin.Result.INSTANCE;
            FuelError.Companion companion6 = FuelError.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(rawResponse, "rawResponse");
            objM3752constructorimpl2 = kotlin.Result.m3752constructorimpl(new Triple(response, rawResponse, new Result.Failure(companion6.wrap(thM3755exceptionOrNullimpl2, rawResponse))));
        }
        ResultKt.throwOnFailure(objM3752constructorimpl2);
        return (Triple) objM3752constructorimpl2;
    }

    public static final Triple<Request, Response, Result<Unit, FuelError>> responseUnit(Request responseUnit) {
        Intrinsics.checkNotNullParameter(responseUnit, "$this$responseUnit");
        return response(responseUnit, EmptyDeserializer.INSTANCE);
    }

    private static final <T, U extends Deserializable<? extends T>> CancellableRequest response(Request request, U u, Function3<? super Request, ? super Response, ? super T, Unit> function3, Function3<? super Request, ? super Response, ? super FuelError, Unit> function4) {
        return CancellableRequest.INSTANCE.enableFor(request, request.getExecutionOptions().submit(new RequestTaskCallbacks(request, null, new DeserializableKt$response$asyncRequest$1(request, u, function3, function4), new DeserializableKt$response$asyncRequest$2(request, function4), 2, null)));
    }

    /* WARN: Code duplicated, block: B:7:0x0014  */
    public static final <T, U extends Deserializable<? extends T>> Object await(Request request, U u, Continuation<? super T> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Object objM3752constructorimpl;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objAwait = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAwait);
            SuspendableRequest suspendableRequestSuspendable = SuspendableRequestKt.suspendable(request);
            anonymousClass1.L$0 = request;
            anonymousClass1.L$1 = u;
            anonymousClass1.label = 1;
            objAwait = suspendableRequestSuspendable.await(anonymousClass1);
            if (objAwait == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u = (U) anonymousClass1.L$1;
            ResultKt.throwOnFailure(objAwait);
        }
        Response response = (Response) objAwait;
        try {
            kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
            objM3752constructorimpl = kotlin.Result.m3752constructorimpl(u.deserialize(response));
        } catch (Throwable th) {
            kotlin.Result.Companion companion2 = kotlin.Result.INSTANCE;
            objM3752constructorimpl = kotlin.Result.m3752constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM3755exceptionOrNullimpl = kotlin.Result.m3755exceptionOrNullimpl(objM3752constructorimpl);
        if (thM3755exceptionOrNullimpl != null) {
            throw FuelError.INSTANCE.wrap(thM3755exceptionOrNullimpl, response);
        }
        ResultKt.throwOnFailure(objM3752constructorimpl);
        return objM3752constructorimpl;
    }

    public static final Object awaitUnit(Request request, Continuation<? super Unit> continuation) throws Throwable {
        Object objAwait = await(request, EmptyDeserializer.INSTANCE, continuation);
        return objAwait == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwait : Unit.INSTANCE;
    }

    /* WARN: Code duplicated, block: B:7:0x0014  */
    public static final <T, U extends Deserializable<? extends T>> Object awaitResponse(Request request, U u, Continuation<? super Triple<? extends Request, Response, ? extends T>> continuation) throws Throwable {
        C01871 c01871;
        Object objM3752constructorimpl;
        if (continuation instanceof C01871) {
            c01871 = (C01871) continuation;
            if ((c01871.label & Integer.MIN_VALUE) != 0) {
                c01871.label -= Integer.MIN_VALUE;
            } else {
                c01871 = new C01871(continuation);
            }
        } else {
            c01871 = new C01871(continuation);
        }
        Object objAwait = c01871.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c01871.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAwait);
            SuspendableRequest suspendableRequestSuspendable = SuspendableRequestKt.suspendable(request);
            c01871.L$0 = request;
            c01871.L$1 = u;
            c01871.label = 1;
            objAwait = suspendableRequestSuspendable.await(c01871);
            if (objAwait == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u = (U) c01871.L$1;
            request = (Request) c01871.L$0;
            ResultKt.throwOnFailure(objAwait);
        }
        Response response = (Response) objAwait;
        try {
            kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
            objM3752constructorimpl = kotlin.Result.m3752constructorimpl(new Triple(request, response, u.deserialize(response)));
        } catch (Throwable th) {
            kotlin.Result.Companion companion2 = kotlin.Result.INSTANCE;
            objM3752constructorimpl = kotlin.Result.m3752constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM3755exceptionOrNullimpl = kotlin.Result.m3755exceptionOrNullimpl(objM3752constructorimpl);
        if (thM3755exceptionOrNullimpl != null) {
            throw FuelError.INSTANCE.wrap(thM3755exceptionOrNullimpl, response);
        }
        ResultKt.throwOnFailure(objM3752constructorimpl);
        return objM3752constructorimpl;
    }

    /* WARN: Code duplicated, block: B:7:0x0014  */
    public static final <T, U extends Deserializable<? extends T>> Object awaitResult(Request request, U u, Continuation<? super Result<? extends T, ? extends FuelError>> continuation) throws Throwable {
        C01891 c01891;
        if (continuation instanceof C01891) {
            c01891 = (C01891) continuation;
            if ((c01891.label & Integer.MIN_VALUE) != 0) {
                c01891.label -= Integer.MIN_VALUE;
            } else {
                c01891 = new C01891(continuation);
            }
        } else {
            c01891 = new C01891(continuation);
        }
        Object objAwaitResult = c01891.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c01891.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAwaitResult);
            SuspendableRequest suspendableRequestSuspendable = SuspendableRequestKt.suspendable(request);
            c01891.L$0 = request;
            c01891.L$1 = u;
            c01891.label = 1;
            objAwaitResult = suspendableRequestSuspendable.awaitResult(c01891);
            if (objAwaitResult == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u = (U) c01891.L$1;
            ResultKt.throwOnFailure(objAwaitResult);
        }
        Result resultSerializeFor = serializeFor((Result) objAwaitResult, u);
        try {
            if (resultSerializeFor instanceof Result.Success) {
                return new Result.Success(((Pair) ((Result.Success) resultSerializeFor).getValue()).component2());
            }
            if (resultSerializeFor instanceof Result.Failure) {
                return new Result.Failure(((Result.Failure) resultSerializeFor).getError());
            }
            throw new NoWhenBranchMatchedException();
        } catch (Exception e) {
            return Result.INSTANCE.error(e);
        }
    }

    /* WARN: Code duplicated, block: B:7:0x0014  */
    public static final <T, U extends Deserializable<? extends T>> Object awaitResponseResult(Request request, U u, Continuation<? super Triple<? extends Request, Response, ? extends Result<? extends T, ? extends FuelError>>> continuation) throws Throwable {
        C01881 c01881;
        Response response;
        Result.Failure failureError;
        if (continuation instanceof C01881) {
            c01881 = (C01881) continuation;
            if ((c01881.label & Integer.MIN_VALUE) != 0) {
                c01881.label -= Integer.MIN_VALUE;
            } else {
                c01881 = new C01881(continuation);
            }
        } else {
            c01881 = new C01881(continuation);
        }
        Object objAwaitResult = c01881.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c01881.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAwaitResult);
            SuspendableRequest suspendableRequestSuspendable = SuspendableRequestKt.suspendable(request);
            c01881.L$0 = request;
            c01881.L$1 = u;
            c01881.label = 1;
            objAwaitResult = suspendableRequestSuspendable.awaitResult(c01881);
            if (objAwaitResult == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u = (U) c01881.L$1;
            request = (Request) c01881.L$0;
            ResultKt.throwOnFailure(objAwaitResult);
        }
        Result resultSerializeFor = serializeFor((Result) objAwaitResult, u);
        if (resultSerializeFor instanceof Result.Success) {
            response = (Response) ((Pair) ((Result.Success) resultSerializeFor).getValue()).component1();
        } else if (resultSerializeFor instanceof Result.Failure) {
            response = ((FuelError) ((Result.Failure) resultSerializeFor).getError()).getResponse();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        try {
            if (resultSerializeFor instanceof Result.Success) {
                failureError = new Result.Success(((Pair) ((Result.Success) resultSerializeFor).getValue()).component2());
            } else {
                if (!(resultSerializeFor instanceof Result.Failure)) {
                    throw new NoWhenBranchMatchedException();
                }
                failureError = new Result.Failure(((Result.Failure) resultSerializeFor).getError());
            }
        } catch (Exception e) {
            failureError = Result.INSTANCE.error(e);
        }
        return new Triple(request, response, failureError);
    }

    /* INFO: renamed from: com.github.kittinunf.fuel.core.DeserializableKt$serializeFor$2, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: Deserializable.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "Lcom/github/kittinunf/fuel/core/FuelError;", ExifInterface.GPS_DIRECTION_TRUE, "", "U", "Lcom/github/kittinunf/fuel/core/Deserializable;", "it", "Ljava/lang/Exception;", "Lkotlin/Exception;", "invoke"}, k = 3, mv = {1, 4, 0})
    static final class C01912 extends Lambda implements Function1<Exception, FuelError> {
        final /* synthetic */ Result $result;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01912(Result result) {
            super(1);
            this.$result = result;
        }

        @Override // kotlin.jvm.functions.Function1
        public final FuelError invoke(Exception it) {
            Object objError$default;
            Intrinsics.checkNotNullParameter(it, "it");
            FuelError.Companion companion = FuelError.INSTANCE;
            Exception exc = it;
            Result result = this.$result;
            if (result instanceof Result.Success) {
                objError$default = ((Result.Success) result).getValue();
            } else {
                if (!(result instanceof Result.Failure)) {
                    throw new NoWhenBranchMatchedException();
                }
                objError$default = Response.Companion.error$default(Response.INSTANCE, null, 1, null);
            }
            return companion.wrap(exc, (Response) objError$default);
        }
    }

    private static final <T, U extends Deserializable<? extends T>> Result<Pair<Response, T>, FuelError> serializeFor(Result<Response, ? extends FuelError> result, U u) {
        Result.Failure failureError;
        try {
            if (result instanceof Result.Success) {
                Response response = (Response) ((Result.Success) result).getValue();
                failureError = new Result.Success(TuplesKt.to(response, u.deserialize(response)));
            } else {
                if (!(result instanceof Result.Failure)) {
                    throw new NoWhenBranchMatchedException();
                }
                failureError = new Result.Failure(((Result.Failure) result).getError());
            }
        } catch (Exception e) {
            failureError = Result.INSTANCE.error(e);
        }
        return com.github.kittinunf.result.ResultKt.mapError(failureError, new C01912(result));
    }
}
