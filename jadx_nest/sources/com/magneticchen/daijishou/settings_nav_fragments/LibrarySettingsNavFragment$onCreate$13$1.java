package com.magneticchen.daijishou.settings_nav_fragments;

import android.widget.Toast;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: LibrarySettingsNavFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class LibrarySettingsNavFragment$onCreate$13$1 extends Lambda<Unit> implements Function1<PlayableItemEntity, Unit> {
    final /* synthetic */ LibrarySettingsNavFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LibrarySettingsNavFragment$onCreate$13$1(LibrarySettingsNavFragment librarySettingsNavFragment) {
        super(1);
        this.this$0 = librarySettingsNavFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PlayableItemEntity playableItemEntity) {
        invoke2(playableItemEntity);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(PlayableItemEntity it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.setVisible(true);
        this.this$0.getDaijishouLibrary().updatePlayableItem(it);
        Toast.makeText(this.this$0.requireContext(), this.this$0.getString(R.string.restored_period), 0).show();
    }
}
