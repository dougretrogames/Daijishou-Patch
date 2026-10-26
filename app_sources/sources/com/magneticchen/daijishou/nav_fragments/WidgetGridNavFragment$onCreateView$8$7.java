package com.magneticchen.daijishou.nav_fragments;

import android.content.Context;
import android.widget.Toast;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: WidgetGridNavFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "succeed", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class WidgetGridNavFragment$onCreateView$8$7 extends Lambda<Unit> implements Function1<Boolean, Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ WidgetGridNavFragment this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    WidgetGridNavFragment$onCreateView$8$7(Context context, WidgetGridNavFragment widgetGridNavFragment) {
        super(1);
        this.$context = context;
        this.this$0 = widgetGridNavFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        String str = null;
        if (z) {
            Context context = this.$context;
            String str2 = this.this$0.widgetCreatedSuccessfullyString;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("widgetCreatedSuccessfullyString");
            } else {
                str = str2;
            }
            Toast.makeText(context, str, 0).show();
            return;
        }
        Context context2 = this.$context;
        String str3 = this.this$0.widgetCreateCanceledString;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("widgetCreateCanceledString");
        } else {
            str = str3;
        }
        Toast.makeText(context2, str, 0).show();
    }
}
