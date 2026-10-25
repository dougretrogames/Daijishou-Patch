package androidx.compose.runtime.saveable;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: RememberSaveable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class SaveableHolder$valueProvider$1 extends Lambda implements Function0<Object> {
    final /* synthetic */ SaveableHolder<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SaveableHolder$valueProvider$1(SaveableHolder<T> saveableHolder) {
        super(0);
        this.this$0 = saveableHolder;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Saver saver = ((SaveableHolder) this.this$0).saver;
        SaveableHolder<T> saveableHolder = this.this$0;
        SaveableHolder<T> saveableHolder2 = saveableHolder;
        Object obj = ((SaveableHolder) saveableHolder).value;
        if (obj != null) {
            return saver.save(saveableHolder2, obj);
        }
        throw new IllegalArgumentException("Value should be initialized".toString());
    }
}
