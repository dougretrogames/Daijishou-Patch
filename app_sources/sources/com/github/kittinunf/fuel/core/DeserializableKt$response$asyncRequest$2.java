package com.github.kittinunf.fuel.core;

import androidx.exifinterface.media.ExifInterface;
import com.github.kittinunf.fuel.Fuel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: Deserializable.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "U", "Lcom/github/kittinunf/fuel/core/Deserializable;", "error", "Lcom/github/kittinunf/fuel/core/FuelError;", "response", "Lcom/github/kittinunf/fuel/core/Response;", "invoke"}, k = 3, mv = {1, 4, 0})
final class DeserializableKt$response$asyncRequest$2 extends Lambda implements Function2<FuelError, Response, Unit> {
    final /* synthetic */ Function3 $failure;
    final /* synthetic */ Request $this_response;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    DeserializableKt$response$asyncRequest$2(Request request, Function3 function3) {
        super(2);
        this.$this_response = request;
        this.$failure = function3;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(FuelError fuelError, Response response) {
        invoke2(fuelError, response);
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: com.github.kittinunf.fuel.core.DeserializableKt$response$asyncRequest$2$1, reason: invalid class name */
    /* INFO: compiled from: Deserializable.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "U", "Lcom/github/kittinunf/fuel/core/Deserializable;", "invoke"}, k = 3, mv = {1, 4, 0})
    static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        final /* synthetic */ FuelError $error;
        final /* synthetic */ Response $response;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Response response, FuelError fuelError) {
            super(0);
            this.$response = response;
            this.$error = fuelError;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Function3 function3 = DeserializableKt$response$asyncRequest$2.this.$failure;
            Request request = DeserializableKt$response$asyncRequest$2.this.$this_response;
            Response response = this.$response;
            FuelError fuelError = this.$error;
            Fuel.INSTANCE.trace(new DeserializableKt$response$asyncRequest$2$1$1$1(fuelError));
            Unit unit = Unit.INSTANCE;
            function3.invoke(request, response, fuelError);
        }
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(FuelError error, Response response) {
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(response, "response");
        this.$this_response.getExecutionOptions().callback(new AnonymousClass1(response, error));
    }
}
