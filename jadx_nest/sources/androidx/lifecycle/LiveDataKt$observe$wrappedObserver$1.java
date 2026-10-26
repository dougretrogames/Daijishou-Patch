package androidx.lifecycle;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* INFO: compiled from: LiveData.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "t", "onChanged", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 8, 0}, xi = 176)
public final class LiveDataKt$observe$wrappedObserver$1<T> implements Observer {
    final /* synthetic */ Function1<T, Unit> $onChanged;

    /* WARN: Multi-variable type inference failed */
    public LiveDataKt$observe$wrappedObserver$1(Function1<? super T, Unit> function1) {
        this.$onChanged = function1;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(T t) {
        this.$onChanged.invoke(t);
    }
}
