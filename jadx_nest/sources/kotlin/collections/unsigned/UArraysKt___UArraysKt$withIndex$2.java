package kotlin.collections.unsigned;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: _UArrays.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lkotlin/ULong;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class UArraysKt___UArraysKt$withIndex$2 extends Lambda implements Function0<Iterator<? extends ULong>> {
    final /* synthetic */ long[] $this_withIndex;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    UArraysKt___UArraysKt$withIndex$2(long[] jArr) {
        super(0);
        this.$this_withIndex = jArr;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Iterator<? extends ULong> invoke() {
        return ULongArray.m3990iteratorimpl(this.$this_withIndex);
    }
}
