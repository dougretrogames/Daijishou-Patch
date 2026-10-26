package com.magneticchen.daijishou.nav_fragments;

import android.content.Context;
import android.widget.Toast;
import com.magneticchen.daijishou.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: PlatformLibraryListViewNavFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class PlatformLibraryListViewNavFragment$onCreateView$15$4 extends Lambda<Unit> implements Function1<Boolean, Unit> {
    final /* synthetic */ PlatformLibraryListViewNavFragment this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    PlatformLibraryListViewNavFragment$onCreateView$15$4(PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment) {
        super(1);
        this.this$0 = platformLibraryListViewNavFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment;
        int i;
        Context contextRequireContext = this.this$0.requireContext();
        if (z) {
            platformLibraryListViewNavFragment = this.this$0;
            i = R.string.remove_pin_succeed_message;
        } else {
            platformLibraryListViewNavFragment = this.this$0;
            i = R.string.remove_pin_failed_message;
        }
        Toast.makeText(contextRequireContext, platformLibraryListViewNavFragment.getString(i), 0).show();
    }
}
