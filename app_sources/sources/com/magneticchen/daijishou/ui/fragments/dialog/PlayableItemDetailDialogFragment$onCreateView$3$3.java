package com.magneticchen.daijishou.ui.fragments.dialog;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.google.android.material.chip.Chip;
import com.magneticchen.daijishou.service.youtube.YoutubePlayerManager;
import com.magneticchen.daijishou.service.youtube.YoutubePlayerService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "id", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class PlayableItemDetailDialogFragment$onCreateView$3$3 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ PlayableItemDetailDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PlayableItemDetailDialogFragment$onCreateView$3$3(PlayableItemDetailDialogFragment playableItemDetailDialogFragment) {
        super(1);
        this.this$0 = playableItemDetailDialogFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final String id2) {
        Intrinsics.checkNotNullParameter(id2, "id");
        Chip chip = this.this$0.previewVideoButton;
        Chip chip2 = null;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewVideoButton");
            chip = null;
        }
        chip.setVisibility(0);
        Chip chip3 = this.this$0.previewVideoButton;
        if (chip3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewVideoButton");
        } else {
            chip2 = chip3;
        }
        final PlayableItemDetailDialogFragment playableItemDetailDialogFragment = this.this$0;
        chip2.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$onCreateView$3$3$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlayableItemDetailDialogFragment$onCreateView$3$3.invoke$lambda$0(id2, playableItemDetailDialogFragment, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(String id2, PlayableItemDetailDialogFragment this$0, View view) {
        YoutubePlayerManager manager;
        Intrinsics.checkNotNullParameter(id2, "$id");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        YoutubePlayerService youtubePlayerService = this$0.youtubePlayerService;
        this$0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.youtube.com/watch?v=" + id2 + "&t=" + ((youtubePlayerService == null || (manager = youtubePlayerService.getManager()) == null) ? null : Integer.valueOf((int) manager.getTrackSeconds())))));
    }
}
