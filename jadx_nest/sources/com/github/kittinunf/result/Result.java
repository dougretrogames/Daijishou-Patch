package com.github.kittinunf.result;

import androidx.exifinterface.media.ExifInterface;
import java.lang.Exception;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: Result.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u0012*\u0006\b\u0000\u0010\u0001 \u0001*\u000e\b\u0001\u0010\u0002 \u0001*\u00060\u0003j\u0002`\u00042\u00020\u0005:\u0003\u0012\u0013\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u0004\u0018\u00018\u0000H\u0096\u0002¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u0004\u0018\u00018\u0001H\u0096\u0002¢\u0006\u0002\u0010\nJ?\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0002\u0010\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\f0\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u0002H\f0\u000eH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0010J\r\u0010\u0011\u001a\u00028\u0000H&¢\u0006\u0002\u0010\b\u0082\u0001\u0002\u0015\u0016\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0017"}, d2 = {"Lcom/github/kittinunf/result/Result;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_EAST, "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "()V", "component1", "()Ljava/lang/Object;", "component2", "()Ljava/lang/Exception;", "fold", "X", "success", "Lkotlin/Function1;", "failure", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "get", "Companion", "Failure", "Success", "Lcom/github/kittinunf/result/Result$Success;", "Lcom/github/kittinunf/result/Result$Failure;", "result"}, k = 1, mv = {1, 4, 0})
public abstract class Result<V, E extends Exception> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public V component1() {
        return null;
    }

    public E component2() {
        return null;
    }

    public abstract V get();

    private Result() {
    }

    public /* synthetic */ Result(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final <X> X fold(Function1<? super V, ? extends X> success, Function1<? super E, ? extends X> failure) {
        Intrinsics.checkNotNullParameter(success, "success");
        Intrinsics.checkNotNullParameter(failure, "failure");
        if (this instanceof Success) {
            return success.invoke((Object) ((Success) this).getValue());
        }
        if (this instanceof Failure) {
            return failure.invoke(((Failure) this).getError());
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: compiled from: Result.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u0000*\u0006\b\u0002\u0010\u0001 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0002¢\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00018\u0002H\u0096\u0002¢\u0006\u0002\u0010\u0007J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\r\u0010\u000e\u001a\u00028\u0002H\u0016¢\u0006\u0002\u0010\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0013\u0010\u0004\u001a\u00028\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/github/kittinunf/result/Result$Success;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/github/kittinunf/result/Result;", "", "value", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "equals", "", "other", "", "get", "hashCode", "", "toString", "", "result"}, k = 1, mv = {1, 4, 0})
    public static final class Success<V> extends Result {
        private final V value;

        public Success(V v) {
            super(null);
            this.value = v;
        }

        public final V getValue() {
            return this.value;
        }

        @Override // com.github.kittinunf.result.Result
        public V component1() {
            return this.value;
        }

        @Override // com.github.kittinunf.result.Result
        public V get() {
            return this.value;
        }

        public String toString() {
            return "[Success: " + this.value + AbstractJsonLexerKt.END_LIST;
        }

        public int hashCode() {
            V v = this.value;
            if (v != null) {
                return v.hashCode();
            }
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Success) && Intrinsics.areEqual(this.value, ((Success) other).value);
        }
    }

    /* JADX INFO: compiled from: Result.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u0000*\u000e\b\u0002\u0010\u0001 \u0001*\u00060\u0002j\u0002`\u00032\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00010\u0004B\r\u0012\u0006\u0010\u0006\u001a\u00028\u0002¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000b\u001a\u0004\u0018\u00018\u0002H\u0096\u0002¢\u0006\u0002\u0010\tJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\u000b\u0010\u0011\u001a\u00028\u0002¢\u0006\u0002\u0010\tJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0013\u0010\u0006\u001a\u00028\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/github/kittinunf/result/Result$Failure;", ExifInterface.LONGITUDE_EAST, "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lcom/github/kittinunf/result/Result;", "", "error", "(Ljava/lang/Exception;)V", "getError", "()Ljava/lang/Exception;", "Ljava/lang/Exception;", "component2", "equals", "", "other", "", "get", "getException", "hashCode", "", "toString", "", "result"}, k = 1, mv = {1, 4, 0})
    public static final class Failure<E extends Exception> extends Result {
        private final E error;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failure(E error) {
            super(null);
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
        }

        public final E getError() {
            return this.error;
        }

        @Override // com.github.kittinunf.result.Result
        public E component2() {
            return this.error;
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: E extends java.lang.Exception */
        @Override // com.github.kittinunf.result.Result
        public Void get() throws E {
            throw this.error;
        }

        public final E getException() {
            return this.error;
        }

        public String toString() {
            return "[Failure: " + this.error + AbstractJsonLexerKt.END_LIST;
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Failure) && Intrinsics.areEqual(this.error, ((Failure) other).error);
        }
    }

    /* JADX INFO: compiled from: Result.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\f\b\u0002\u0010\u0005*\u00060\u0006j\u0002`\u00072\u0006\u0010\b\u001a\u0002H\u0005¢\u0006\u0002\u0010\tJ4\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u00050\u000b\"\u0004\b\u0002\u0010\f\"\f\b\u0003\u0010\u0005*\u00060\u0006j\u0002`\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u000eJ?\u0010\n\u001a\u0012\u0012\u0004\u0012\u0002H\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u000b\"\u0004\b\u0002\u0010\f2\b\u0010\u000f\u001a\u0004\u0018\u0001H\f2\u0012\b\u0002\u0010\u0010\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u000e¢\u0006\u0002\u0010\u0011J\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\f0\u0013\"\u0004\b\u0002\u0010\f2\u0006\u0010\u0014\u001a\u0002H\f¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/github/kittinunf/result/Result$Companion;", "", "()V", "error", "Lcom/github/kittinunf/result/Result$Failure;", ExifInterface.LONGITUDE_EAST, "Ljava/lang/Exception;", "Lkotlin/Exception;", "ex", "(Ljava/lang/Exception;)Lcom/github/kittinunf/result/Result$Failure;", "of", "Lcom/github/kittinunf/result/Result;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "f", "Lkotlin/Function0;", "value", "fail", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Lcom/github/kittinunf/result/Result;", "success", "Lcom/github/kittinunf/result/Result$Success;", "v", "(Ljava/lang/Object;)Lcom/github/kittinunf/result/Result$Success;", "result"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <E extends Exception> Failure<E> error(E ex) {
            Intrinsics.checkNotNullParameter(ex, "ex");
            return new Failure<>(ex);
        }

        public final <V> Success<V> success(V v) {
            return new Success<>(v);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Result of$default(Companion companion, Object obj, Function0 function0, int i, Object obj2) {
            if ((i & 2) != 0) {
                function0 = Result$Companion$of$1.INSTANCE;
            }
            return companion.of(obj, function0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <V> Result<V, Exception> of(V value, Function0<? extends Exception> fail) {
            Success<V> success;
            Intrinsics.checkNotNullParameter(fail, "fail");
            return (value == null || (success = Result.INSTANCE.success(value)) == null) ? error(fail.invoke()) : success;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <V, E extends Exception> Result<V, E> of(Function0<? extends V> f) {
            Intrinsics.checkNotNullParameter(f, "f");
            try {
                Companion companion = this;
                return success(f.invoke());
            } catch (Exception e) {
                return error(e);
            }
        }
    }
}
