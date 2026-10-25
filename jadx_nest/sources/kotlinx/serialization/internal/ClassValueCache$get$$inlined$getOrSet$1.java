package kotlinx.serialization.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Caching.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "invoke", "()Ljava/lang/Object;", "kotlinx/serialization/internal/ClassValueReferences$getOrSet$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ClassValueCache$get$$inlined$getOrSet$1<T> extends Lambda implements Function0<T> {
    final /* synthetic */ KClass $key$inlined;
    final /* synthetic */ ClassValueCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClassValueCache$get$$inlined$getOrSet$1(ClassValueCache classValueCache, KClass kClass) {
        super(0);
        this.this$0 = classValueCache;
        this.$key$inlined = kClass;
    }

    @Override // kotlin.jvm.functions.Function0
    public final T invoke() {
        return (T) new CacheEntry(this.this$0.getCompute().invoke(this.$key$inlined));
    }
}
