package co.infinum.retromock;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.coroutines.Continuation;
import retrofit2.Call;
import retrofit2.Response;

/* JADX INFO: loaded from: classes3.dex */
final class CallWrapperFactory {
    private CallWrapperFactory() {
    }

    static <T> CallWrapper create(Method method) {
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        if (genericParameterTypes.length > 0) {
            boolean z = true;
            Type type = genericParameterTypes[genericParameterTypes.length - 1];
            if (Utils.getRawType(type) == Continuation.class) {
                Type parameterLowerBound = Utils.getParameterLowerBound(0, (ParameterizedType) type);
                Utils.ParameterizedTypeImpl parameterizedTypeImpl = new Utils.ParameterizedTypeImpl(null, Call.class, parameterLowerBound);
                if (Utils.getRawType(parameterLowerBound) == Response.class && (parameterLowerBound instanceof ParameterizedType)) {
                    parameterizedTypeImpl = new Utils.ParameterizedTypeImpl(null, Call.class, Utils.getParameterUpperBound(0, (ParameterizedType) parameterLowerBound));
                } else {
                    z = false;
                }
                return new SuspendCallWrapper(parameterizedTypeImpl, z);
            }
        }
        return new NoOpCallWrapper(method.getGenericReturnType());
    }
}
