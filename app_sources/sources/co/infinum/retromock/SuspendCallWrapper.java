package co.infinum.retromock;

import java.lang.reflect.Type;
import kotlin.coroutines.Continuation;
import retrofit2.Call;

/* INFO: loaded from: classes3.dex */
class SuspendCallWrapper<T> implements CallWrapper {
    private boolean continuationWantsResponse;
    private Type returnType;

    public SuspendCallWrapper(Type type, boolean z) {
        this.returnType = type;
        this.continuationWantsResponse = z;
    }

    @Override // co.infinum.retromock.CallWrapper
    public Type getReturnType() {
        return this.returnType;
    }

    private Object handleContinuationWithResponse(Object[] objArr, Object obj) {
        Continuation continuation = (Continuation) objArr[objArr.length - 1];
        try {
            return KotlinExtensions.awaitResponse((Call) obj, continuation);
        } catch (Exception e) {
            return KotlinExtensions.suspendAndThrow(e, continuation);
        }
    }

    private Object handleContinuation(Object[] objArr, Object obj) {
        Continuation continuation = (Continuation) objArr[objArr.length - 1];
        try {
            return KotlinExtensions.await((Call) obj, continuation);
        } catch (Exception e) {
            return KotlinExtensions.suspendAndThrow(e, continuation);
        }
    }

    @Override // co.infinum.retromock.CallWrapper
    public Object wrap(Object obj, Object[] objArr) {
        if (this.continuationWantsResponse) {
            return handleContinuationWithResponse(objArr, obj);
        }
        return handleContinuation(objArr, obj);
    }
}
