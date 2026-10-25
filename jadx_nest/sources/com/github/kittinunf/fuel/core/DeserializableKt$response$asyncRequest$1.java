package com.github.kittinunf.fuel.core;

import androidx.exifinterface.media.ExifInterface;
import com.github.kittinunf.fuel.Fuel;
import com.github.kittinunf.result.Result;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: Deserializable.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "U", "Lcom/github/kittinunf/fuel/core/Deserializable;", "response", "Lcom/github/kittinunf/fuel/core/Response;", "invoke"}, k = 3, mv = {1, 4, 0})
final class DeserializableKt$response$asyncRequest$1 extends Lambda implements Function1<Response, Unit> {
    final /* synthetic */ Deserializable $deserializable;
    final /* synthetic */ Function3 $failure;
    final /* synthetic */ Function3 $success;
    final /* synthetic */ Request $this_response;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DeserializableKt$response$asyncRequest$1(Request request, Deserializable deserializable, Function3 function3, Function3 function4) {
        super(1);
        this.$this_response = request;
        this.$deserializable = deserializable;
        this.$success = function3;
        this.$failure = function4;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Response response) {
        invoke2(response);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        this.$this_response.getExecutionOptions().callback(new AnonymousClass1(Result.INSTANCE.of(new DeserializableKt$response$asyncRequest$1$deliverable$1(this, response)), response));
    }

    /* JADX INFO: renamed from: com.github.kittinunf.fuel.core.DeserializableKt$response$asyncRequest$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: Deserializable.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "U", "Lcom/github/kittinunf/fuel/core/Deserializable;", "invoke"}, k = 3, mv = {1, 4, 0})
    static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        final /* synthetic */ Result $deliverable;
        final /* synthetic */ Response $response;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Result result, Response response) {
            super(0);
            this.$deliverable = result;
            this.$response = response;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Result result = this.$deliverable;
            if (result instanceof Result.Success) {
                DeserializableKt$response$asyncRequest$1.this.$success.invoke(DeserializableKt$response$asyncRequest$1.this.$this_response, this.$response, ((Result.Success) result).getValue());
            } else {
                if (result instanceof Result.Failure) {
                    Exception error = ((Result.Failure) result).getError();
                    Function3 function3 = DeserializableKt$response$asyncRequest$1.this.$failure;
                    Request request = DeserializableKt$response$asyncRequest$1.this.$this_response;
                    Response response = this.$response;
                    FuelError fuelErrorWrap = FuelError.INSTANCE.wrap(error, this.$response);
                    Fuel.INSTANCE.trace(new DeserializableKt$response$asyncRequest$1$1$2$1$1(fuelErrorWrap));
                    Unit unit = Unit.INSTANCE;
                    function3.invoke(request, response, fuelErrorWrap);
                    return;
                }
                throw new NoWhenBranchMatchedException();
            }
        }
    }
}
