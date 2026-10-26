package com.github.kittinunf.result;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.language.bm.Languages;

/* INFO: compiled from: Result.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a>\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\f\b\u0001\u0010\u0003*\u00060\u0004j\u0002`\u0005*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\b\u001a6\u0010\t\u001a\u00020\n\"\f\b\u0000\u0010\u0003*\u00060\u0004j\u0002`\u0005*\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u0002H\u00030\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\n0\b\u001aN\u0010\f\u001a\u0018\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000e0\r\u0012\u0002\b\u00030\u0006\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000e*\f\u0012\u0004\u0012\u0002H\u0002\u0012\u0002\b\u00030\u00062\u0016\u0010\u000f\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u0002H\u000e\u0012\u0002\b\u00030\u00060\u0010\u001ab\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u00030\u0006\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000e\"\f\b\u0002\u0010\u0003*\u00060\u0004j\u0002`\u0005*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00062\u001e\u0010\u0012\u001a\u001a\u0012\u0004\u0012\u0002H\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u00030\u00060\bH\u0086\bø\u0001\u0000\u001ad\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00140\u0006\"\u0004\b\u0000\u0010\u0002\"\f\b\u0001\u0010\u0003*\u00060\u0004j\u0002`\u0005\"\f\b\u0002\u0010\u0014*\u00060\u0004j\u0002`\u0005*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00062\u001e\u0010\u0012\u001a\u001a\u0012\u0004\u0012\u0002H\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00140\u00060\b\u001a$\u0010\u0015\u001a\u0004\u0018\u0001H\u0016\"\u0006\b\u0000\u0010\u0016\u0018\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006H\u0086\b¢\u0006\u0002\u0010\u0017\u001aI\u0010\u0018\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002\"\f\b\u0001\u0010\u0003*\u00060\u0004j\u0002`\u0005*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00062\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00020\bH\u0086\fø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001a1\u0010\u001b\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002\"\f\b\u0001\u0010\u0003*\u00060\u0004j\u0002`\u0005*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0006¢\u0006\u0002\u0010\u0017\u001aB\u0010\u001c\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u001d\u0012\u0004\u0012\u0002H\u00030\u0006\"\u0004\b\u0000\u0010\u0002\"\f\b\u0001\u0010\u0003*\u00060\u0004j\u0002`\u0005*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u001d\u001aV\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u00030\u0006\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000e\"\f\b\u0002\u0010\u0003*\u00060\u0004j\u0002`\u0005*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00062\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000e0\bH\u0086\bø\u0001\u0000\u001aX\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00140\u0006\"\u0004\b\u0000\u0010\u0002\"\f\b\u0001\u0010\u0003*\u00060\u0004j\u0002`\u0005\"\f\b\u0002\u0010\u0014*\u00060\u0004j\u0002`\u0005*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00062\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00140\b\u001aP\u0010 \u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0006\"\u0004\b\u0000\u0010\u0002\"\f\b\u0001\u0010\u0003*\u00060\u0004j\u0002`\u0005*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\n0\bH\u0086\bø\u0001\u0000\u001a@\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00020\"\"\u0004\b\u0000\u0010\u0002\"\f\b\u0001\u0010\u0003*\u00060\u0004j\u0002`\u0005*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00062\u0006\u0010\u0019\u001a\u0002H\u0002H\u0086\u0004¢\u0006\u0002\u0010#\u001a.\u0010$\u001a\u00020\n\"\u0004\b\u0000\u0010\u0002*\f\u0012\u0004\u0012\u0002H\u0002\u0012\u0002\b\u00030\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\n0\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006%"}, d2 = {Languages.ANY, "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_EAST, "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lcom/github/kittinunf/result/Result;", "predicate", "Lkotlin/Function1;", "failure", "", "f", "fanout", "Lkotlin/Pair;", "U", "other", "Lkotlin/Function0;", "flatMap", "transform", "flatMapError", "E2", "getAs", "X", "(Lcom/github/kittinunf/result/Result;)Ljava/lang/Object;", "getOrElse", "fallback", "(Lcom/github/kittinunf/result/Result;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getOrNull", "lift", "", "map", "mapError", "onError", "or", "Lcom/github/kittinunf/result/Result$Success;", "(Lcom/github/kittinunf/result/Result;Ljava/lang/Object;)Lcom/github/kittinunf/result/Result$Success;", "success", "result"}, k = 2, mv = {1, 4, 0})
public final class ResultKt {
    public static final /* synthetic */ <X> X getAs(Result<?, ?> getAs) {
        Intrinsics.checkNotNullParameter(getAs, "$this$getAs");
        if (getAs instanceof Result.Success) {
            X x = (X) ((Result.Success) getAs).getValue();
            Intrinsics.reifiedOperationMarker(2, "X");
            return x;
        }
        if (!(getAs instanceof Result.Failure)) {
            throw new NoWhenBranchMatchedException();
        }
        Object error = ((Result.Failure) getAs).getError();
        Intrinsics.reifiedOperationMarker(2, "X");
        return (X) error;
    }

    public static final <V, E extends Exception> Result.Success<V> or(Result<? extends V, ? extends E> or, V v) {
        Intrinsics.checkNotNullParameter(or, "$this$or");
        return or instanceof Result.Success ? (Result.Success) or : new Result.Success<>(v);
    }

    public static final <V, E extends Exception> V getOrElse(Result<? extends V, ? extends E> getOrElse, Function1<? super E, ? extends V> fallback) {
        Intrinsics.checkNotNullParameter(getOrElse, "$this$getOrElse");
        Intrinsics.checkNotNullParameter(fallback, "fallback");
        if (getOrElse instanceof Result.Success) {
            return (V) ((Result.Success) getOrElse).getValue();
        }
        if (getOrElse instanceof Result.Failure) {
            return fallback.invoke(((Result.Failure) getOrElse).getError());
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final <V, E extends Exception> V getOrNull(Result<? extends V, ? extends E> getOrNull) {
        Intrinsics.checkNotNullParameter(getOrNull, "$this$getOrNull");
        if (getOrNull instanceof Result.Success) {
            return (V) ((Result.Success) getOrNull).getValue();
        }
        if (getOrNull instanceof Result.Failure) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* WARN: Multi-variable type inference failed */
    public static final <V, U, E extends Exception> Result<U, E> map(Result<? extends V, ? extends E> map, Function1<? super V, ? extends U> transform) {
        Intrinsics.checkNotNullParameter(map, "$this$map");
        Intrinsics.checkNotNullParameter(transform, "transform");
        try {
            if (map instanceof Result.Success) {
                return new Result.Success(transform.invoke((Object) ((Result.Success) map).getValue()));
            }
            if (map instanceof Result.Failure) {
                return new Result.Failure(((Result.Failure) map).getError());
            }
            throw new NoWhenBranchMatchedException();
        } catch (Exception e) {
            return Result.INSTANCE.error(e);
        }
    }

    /* WARN: Multi-variable type inference failed */
    public static final <V, U, E extends Exception> Result<U, E> flatMap(Result<? extends V, ? extends E> flatMap, Function1<? super V, ? extends Result<? extends U, ? extends E>> transform) {
        Intrinsics.checkNotNullParameter(flatMap, "$this$flatMap");
        Intrinsics.checkNotNullParameter(transform, "transform");
        try {
            if (flatMap instanceof Result.Success) {
                return transform.invoke((Object) ((Result.Success) flatMap).getValue());
            }
            if (flatMap instanceof Result.Failure) {
                return new Result.Failure(((Result.Failure) flatMap).getError());
            }
            throw new NoWhenBranchMatchedException();
        } catch (Exception e) {
            return Result.INSTANCE.error(e);
        }
    }

    public static final <V, E extends Exception, E2 extends Exception> Result<V, E2> mapError(Result<? extends V, ? extends E> mapError, Function1<? super E, ? extends E2> transform) {
        Intrinsics.checkNotNullParameter(mapError, "$this$mapError");
        Intrinsics.checkNotNullParameter(transform, "transform");
        if (mapError instanceof Result.Success) {
            return new Result.Success(((Result.Success) mapError).getValue());
        }
        if (mapError instanceof Result.Failure) {
            return new Result.Failure(transform.invoke(((Result.Failure) mapError).getError()));
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final <V, E extends Exception, E2 extends Exception> Result<V, E2> flatMapError(Result<? extends V, ? extends E> flatMapError, Function1<? super E, ? extends Result<? extends V, ? extends E2>> transform) {
        Intrinsics.checkNotNullParameter(flatMapError, "$this$flatMapError");
        Intrinsics.checkNotNullParameter(transform, "transform");
        if (flatMapError instanceof Result.Success) {
            return new Result.Success(((Result.Success) flatMapError).getValue());
        }
        if (flatMapError instanceof Result.Failure) {
            return transform.invoke(((Result.Failure) flatMapError).getError());
        }
        throw new NoWhenBranchMatchedException();
    }

    /* WARN: Multi-variable type inference failed */
    public static final <V, E extends Exception> Result<V, E> onError(Result<? extends V, ? extends E> onError, Function1<? super E, Unit> f) {
        Intrinsics.checkNotNullParameter(onError, "$this$onError");
        Intrinsics.checkNotNullParameter(f, "f");
        if (onError instanceof Result.Success) {
            return new Result.Success(((Result.Success) onError).getValue());
        }
        if (onError instanceof Result.Failure) {
            f.invoke(((Result.Failure) onError).getError());
            return onError;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final <V, E extends Exception> boolean any(Result<? extends V, ? extends E> any, Function1<? super V, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(any, "$this$any");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        try {
            if (any instanceof Result.Success) {
                return predicate.invoke((Object) ((Result.Success) any).getValue()).booleanValue();
            }
            if (any instanceof Result.Failure) {
                return false;
            }
            throw new NoWhenBranchMatchedException();
        } catch (Exception unused) {
            return false;
        }
    }

    /* WARN: Multi-variable type inference failed */
    public static final <V, E extends Exception> Result<List<V>, E> lift(List<? extends Result<? extends V, ? extends E>> lift) {
        Result.Failure failure;
        Intrinsics.checkNotNullParameter(lift, "$this$lift");
        List<? extends Result<? extends V, ? extends E>> list = lift;
        Result.Success<V> success = Result.INSTANCE.success(new ArrayList());
        if (success == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.github.kittinunf.result.Result<kotlin.collections.MutableList<V>, E>");
        }
        Result.Failure failureError = success;
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Result result = (Result) it.next();
            try {
                if (failureError instanceof Result.Success) {
                    List list2 = (List) ((Result.Success) failureError).getValue();
                    try {
                        if (result instanceof Result.Success) {
                            list2.add(((Result.Success) result).getValue());
                            failure = new Result.Success(list2);
                        } else {
                            if (!(result instanceof Result.Failure)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            failure = new Result.Failure(((Result.Failure) result).getError());
                        }
                    } catch (Exception e) {
                        failure = Result.INSTANCE.error(e);
                    }
                } else {
                    if (!(failureError instanceof Result.Failure)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    failure = new Result.Failure(((Result.Failure) failureError).getError());
                }
                failureError = failure;
            } catch (Exception e2) {
                failureError = Result.INSTANCE.error(e2);
            }
        }
        return failureError;
    }

    public static final <V> void success(Result<? extends V, ?> success, Function1<? super V, Unit> f) {
        Intrinsics.checkNotNullParameter(success, "$this$success");
        Intrinsics.checkNotNullParameter(f, "f");
        if (success instanceof Result.Success) {
            f.invoke((Object) ((Result.Success) success).getValue());
        } else {
            if (!(success instanceof Result.Failure)) {
                throw new NoWhenBranchMatchedException();
            }
            ((Result.Failure) success).getError();
        }
    }

    public static final <E extends Exception> void failure(Result<?, ? extends E> failure, Function1<? super E, Unit> f) {
        Intrinsics.checkNotNullParameter(failure, "$this$failure");
        Intrinsics.checkNotNullParameter(f, "f");
        if (failure instanceof Result.Success) {
            ((Result.Success) failure).getValue();
        } else {
            if (!(failure instanceof Result.Failure)) {
                throw new NoWhenBranchMatchedException();
            }
            f.invoke(((Result.Failure) failure).getError());
        }
    }

    public static final <V, U> Result<Pair<V, U>, ?> fanout(Result<? extends V, ?> fanout, Function0<? extends Result<? extends U, ?>> other) {
        Intrinsics.checkNotNullParameter(fanout, "$this$fanout");
        Intrinsics.checkNotNullParameter(other, "other");
        try {
            if (fanout instanceof Result.Success) {
                Object value = ((Result.Success) fanout).getValue();
                Result<? extends U, ?> resultInvoke = other.invoke();
                try {
                    if (resultInvoke instanceof Result.Success) {
                        return new Result.Success(TuplesKt.to(value, ((Result.Success) resultInvoke).getValue()));
                    }
                    if (resultInvoke instanceof Result.Failure) {
                        return new Result.Failure(((Result.Failure) resultInvoke).getError());
                    }
                    throw new NoWhenBranchMatchedException();
                } catch (Exception e) {
                    return Result.INSTANCE.error(e);
                }
            }
            if (fanout instanceof Result.Failure) {
                return new Result.Failure(((Result.Failure) fanout).getError());
            }
            throw new NoWhenBranchMatchedException();
        } catch (Exception e2) {
            return Result.INSTANCE.error(e2);
        }
    }
}
