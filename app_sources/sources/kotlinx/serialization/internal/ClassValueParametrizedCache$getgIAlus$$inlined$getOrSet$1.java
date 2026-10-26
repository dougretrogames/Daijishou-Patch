package kotlinx.serialization.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* INFO: Add missing generic type declarations: [T] */
/* INFO: renamed from: kotlinx.serialization.internal.ClassValueParametrizedCache$get-gIAlu-s$$inlined$getOrSet$1, reason: invalid class name */
/* INFO: compiled from: Caching.kt */
/* INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "invoke", "()Ljava/lang/Object;", "kotlinx/serialization/internal/ClassValueReferences$getOrSet$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ClassValueParametrizedCache$getgIAlus$$inlined$getOrSet$1<T> extends Lambda implements Function0<T> {
    public ClassValueParametrizedCache$getgIAlus$$inlined$getOrSet$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final T invoke() {
        return (T) new ParametrizedCacheEntry();
    }
}
