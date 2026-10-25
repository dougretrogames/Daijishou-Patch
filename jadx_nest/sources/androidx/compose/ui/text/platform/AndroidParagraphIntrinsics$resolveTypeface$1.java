package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.TypefaceResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: AndroidParagraphIntrinsics.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"<anonymous>", "Landroid/graphics/Typeface;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "invoke-DPcqOEQ", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontWeight;II)Landroid/graphics/Typeface;"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class AndroidParagraphIntrinsics$resolveTypeface$1 extends Lambda implements Function4<FontFamily, FontWeight, FontStyle, FontSynthesis, Typeface> {
    final /* synthetic */ AndroidParagraphIntrinsics this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidParagraphIntrinsics$resolveTypeface$1(AndroidParagraphIntrinsics androidParagraphIntrinsics) {
        super(4);
        this.this$0 = androidParagraphIntrinsics;
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Typeface invoke(FontFamily fontFamily, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis) {
        return m2631invokeDPcqOEQ(fontFamily, fontWeight, fontStyle.m2495unboximpl(), fontSynthesis.getValue());
    }

    /* JADX INFO: renamed from: invoke-DPcqOEQ, reason: not valid java name */
    public final Typeface m2631invokeDPcqOEQ(FontFamily fontFamily, FontWeight fontWeight, int i, int i2) {
        State<Object> stateMo2467resolveDPcqOEQ = this.this$0.getFontFamilyResolver().mo2467resolveDPcqOEQ(fontFamily, fontWeight, i, i2);
        if (!(stateMo2467resolveDPcqOEQ instanceof TypefaceResult.Immutable)) {
            TypefaceDirtyTrackerLinkedList typefaceDirtyTrackerLinkedList = new TypefaceDirtyTrackerLinkedList(stateMo2467resolveDPcqOEQ, this.this$0.resolvedTypefaces);
            this.this$0.resolvedTypefaces = typefaceDirtyTrackerLinkedList;
            return typefaceDirtyTrackerLinkedList.getTypeface();
        }
        Object value = stateMo2467resolveDPcqOEQ.getValue();
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type android.graphics.Typeface");
        return (Typeface) value;
    }
}
