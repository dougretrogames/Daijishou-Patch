package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: Savers.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroidx/compose/runtime/saveable/SaverScope;", "it", "Landroidx/compose/ui/text/AnnotatedString$Range;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class SaversKt$AnnotationRangeSaver$1 extends Lambda implements Function2<SaverScope, AnnotatedString.Range<? extends Object>, Object> {
    public static final SaversKt$AnnotationRangeSaver$1 INSTANCE = new SaversKt$AnnotationRangeSaver$1();

    /* JADX INFO: compiled from: Savers.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AnnotationType.values().length];
            try {
                iArr[AnnotationType.Paragraph.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AnnotationType.Span.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AnnotationType.VerbatimTts.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AnnotationType.Url.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AnnotationType.String.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    SaversKt$AnnotationRangeSaver$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SaverScope saverScope, AnnotatedString.Range<? extends Object> range) {
        AnnotationType annotationType;
        Object objSave;
        Object item = range.getItem();
        if (item instanceof ParagraphStyle) {
            annotationType = AnnotationType.Paragraph;
        } else if (item instanceof SpanStyle) {
            annotationType = AnnotationType.Span;
        } else if (item instanceof VerbatimTtsAnnotation) {
            annotationType = AnnotationType.VerbatimTts;
        } else {
            annotationType = item instanceof UrlAnnotation ? AnnotationType.Url : AnnotationType.String;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[annotationType.ordinal()];
        if (i == 1) {
            Object item2 = range.getItem();
            Intrinsics.checkNotNull(item2, "null cannot be cast to non-null type androidx.compose.ui.text.ParagraphStyle");
            objSave = SaversKt.save((ParagraphStyle) item2, SaversKt.getParagraphStyleSaver(), saverScope);
        } else if (i == 2) {
            Object item3 = range.getItem();
            Intrinsics.checkNotNull(item3, "null cannot be cast to non-null type androidx.compose.ui.text.SpanStyle");
            objSave = SaversKt.save((SpanStyle) item3, SaversKt.getSpanStyleSaver(), saverScope);
        } else if (i == 3) {
            Object item4 = range.getItem();
            Intrinsics.checkNotNull(item4, "null cannot be cast to non-null type androidx.compose.ui.text.VerbatimTtsAnnotation");
            objSave = SaversKt.save((VerbatimTtsAnnotation) item4, SaversKt.VerbatimTtsAnnotationSaver, saverScope);
        } else if (i == 4) {
            Object item5 = range.getItem();
            Intrinsics.checkNotNull(item5, "null cannot be cast to non-null type androidx.compose.ui.text.UrlAnnotation");
            objSave = SaversKt.save((UrlAnnotation) item5, SaversKt.UrlAnnotationSaver, saverScope);
        } else {
            if (i != 5) {
                throw new NoWhenBranchMatchedException();
            }
            objSave = SaversKt.save(range.getItem());
        }
        return CollectionsKt.arrayListOf(SaversKt.save(annotationType), objSave, SaversKt.save(Integer.valueOf(range.getStart())), SaversKt.save(Integer.valueOf(range.getEnd())), SaversKt.save(range.getTag()));
    }
}
