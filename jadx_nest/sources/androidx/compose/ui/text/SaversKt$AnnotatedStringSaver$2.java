package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: Savers.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/AnnotatedString;", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class SaversKt$AnnotatedStringSaver$2 extends Lambda implements Function1<Object, AnnotatedString> {
    public static final SaversKt$AnnotatedStringSaver$2 INSTANCE = new SaversKt$AnnotatedStringSaver$2();

    SaversKt$AnnotatedStringSaver$2() {
        super(1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    public final AnnotatedString invoke(Object obj) {
        List list;
        List list2;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        List list3 = (List) obj;
        Object obj2 = list3.get(1);
        List list4 = null;
        List list5 = (Intrinsics.areEqual(obj2, (Object) false) || obj2 == null) ? null : (List) SaversKt.AnnotationRangeListSaver.restore(obj2);
        Object obj3 = list3.get(2);
        List list6 = (Intrinsics.areEqual(obj3, (Object) false) || obj3 == null) ? null : (List) SaversKt.AnnotationRangeListSaver.restore(obj3);
        Object obj4 = list3.get(0);
        String str = obj4 != null ? (String) obj4 : null;
        Intrinsics.checkNotNull(str);
        if (list5 != null) {
            List list7 = list5;
            if (list7.isEmpty()) {
                list7 = null;
            }
            list = list7;
        } else {
            list = null;
        }
        if (list6 != null) {
            List list8 = list6;
            if (list8.isEmpty()) {
                list8 = null;
            }
            list2 = list8;
        } else {
            list2 = null;
        }
        Object obj5 = list3.get(3);
        Saver saver = SaversKt.AnnotationRangeListSaver;
        if (!Intrinsics.areEqual(obj5, (Object) false) && obj5 != null) {
            list4 = (List) saver.restore(obj5);
        }
        return new AnnotatedString(str, list, list2, list4);
    }
}
