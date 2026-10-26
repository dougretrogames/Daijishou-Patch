package com.skydoves.balloon.internals;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: ViewProperty.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u0000¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"viewProperty", "Lcom/skydoves/balloon/internals/ViewPropertyDelegate;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroid/view/View;", "defaultValue", "(Landroid/view/View;Ljava/lang/Object;)Lcom/skydoves/balloon/internals/ViewPropertyDelegate;", "balloon_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ViewPropertyKt {
    public static final /* synthetic */ ViewPropertyDelegate viewProperty(View view, Object obj) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return new ViewPropertyDelegate(obj, new ViewPropertyKt$$ExternalSyntheticLambda0(view));
    }

    /* INFO: Access modifiers changed from: private */
    public static final Unit viewProperty$lambda$0(View view) {
        view.invalidate();
        return Unit.INSTANCE;
    }
}
