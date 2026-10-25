package com.magneticchen.daijishou.dialog_fragments;

import android.content.Context;
import android.widget.Toast;
import com.magneticchen.daijishou.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class PlayableItemDetailDialogFragment$onCreateView$17$4 extends Lambda<Unit> implements Function1<Boolean, Unit> {
    final /* synthetic */ PlayableItemDetailDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PlayableItemDetailDialogFragment$onCreateView$17$4(PlayableItemDetailDialogFragment playableItemDetailDialogFragment) {
        super(1);
        this.this$0 = playableItemDetailDialogFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        PlayableItemDetailDialogFragment playableItemDetailDialogFragment;
        int i;
        Context contextRequireContext = this.this$0.requireContext();
        if (z) {
            playableItemDetailDialogFragment = this.this$0;
            i = R.string.remove_pin_succeed_message;
        } else {
            playableItemDetailDialogFragment = this.this$0;
            i = R.string.remove_pin_failed_message;
        }
        Toast.makeText(contextRequireContext, playableItemDetailDialogFragment.getString(i), 0).show();
    }
}
