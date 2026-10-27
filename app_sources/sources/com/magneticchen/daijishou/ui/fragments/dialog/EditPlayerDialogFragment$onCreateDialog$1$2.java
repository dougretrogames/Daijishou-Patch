package com.magneticchen.daijishou.ui.fragments.dialog;

import android.view.View;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.magneticchen.daijishou.data.db.entity.PlatformEntity;
import com.magneticchen.daijishou.data.db.entity.PlayerEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: EditPlayerDialogFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "Lcom/magneticchen/daijishou/data/db/entity/PlatformEntity;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class EditPlayerDialogFragment$onCreateDialog$1$2 extends Lambda implements Function1<List<? extends PlatformEntity>, Unit> {
    final /* synthetic */ ChipGroup $playerAssociatedPlatformsChipGroup;
    final /* synthetic */ PlayerEntity $playerEntity;
    final /* synthetic */ EditPlayerDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EditPlayerDialogFragment$onCreateDialog$1$2(ChipGroup chipGroup, PlayerEntity playerEntity, EditPlayerDialogFragment editPlayerDialogFragment) {
        super(1);
        this.$playerAssociatedPlatformsChipGroup = chipGroup;
        this.$playerEntity = playerEntity;
        this.this$0 = editPlayerDialogFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends PlatformEntity> list) {
        invoke2((List<PlatformEntity>) list);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<PlatformEntity> list) {
        this.$playerAssociatedPlatformsChipGroup.removeAllViews();
        Intrinsics.checkNotNull(list);
        PlayerEntity playerEntity = this.$playerEntity;
        final EditPlayerDialogFragment editPlayerDialogFragment = this.this$0;
        ChipGroup chipGroup = this.$playerAssociatedPlatformsChipGroup;
        for (final PlatformEntity platformEntity : list) {
            if (platformEntity.getPlayerIdList().indexOf(Long.valueOf(playerEntity.getId())) >= 0) {
                View chip = new Chip(editPlayerDialogFragment.requireContext());
                chip.setText(platformEntity.getName());
                chipGroup.addView(chip);
                chip.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditPlayerDialogFragment$onCreateDialog$1$2$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        EditPlayerDialogFragment$onCreateDialog$1$2.invoke$lambda$1$lambda$0(platformEntity, editPlayerDialogFragment, view);
                    }
                });
            }
        }
        View playerAssociatedPlatformsChipGroup = this.$playerAssociatedPlatformsChipGroup;
        Intrinsics.checkNotNullExpressionValue(playerAssociatedPlatformsChipGroup, "$playerAssociatedPlatformsChipGroup");
        playerAssociatedPlatformsChipGroup.setVisibility(!list.isEmpty() ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1$lambda$0(PlatformEntity platformEntity, EditPlayerDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(platformEntity, "$platformEntity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EditPlatformDialogFragment.Companion.newInstance(platformEntity).show(this$0.getParentFragmentManager(), EditPlatformDialogFragment.class.getName());
    }
}
