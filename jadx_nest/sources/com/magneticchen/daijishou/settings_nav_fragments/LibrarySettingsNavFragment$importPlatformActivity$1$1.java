package com.magneticchen.daijishou.settings_nav_fragments;

import android.content.Context;
import android.widget.Toast;
import com.magneticchen.daijishou.daijishou_library_db.PlatformEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: LibrarySettingsNavFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "platformEntity", "Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class LibrarySettingsNavFragment$importPlatformActivity$1$1 extends Lambda<Unit> implements Function1<PlatformEntity, Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ LibrarySettingsNavFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LibrarySettingsNavFragment$importPlatformActivity$1$1(Context context, LibrarySettingsNavFragment librarySettingsNavFragment) {
        super(1);
        this.$context = context;
        this.this$0 = librarySettingsNavFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PlatformEntity platformEntity) {
        invoke2(platformEntity);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(PlatformEntity platformEntity) {
        if (platformEntity == null) {
            Context context = this.$context;
            String str = this.this$0.notImportedString;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notImportedString");
                str = null;
            }
            Toast.makeText(context, str, 0).show();
            return;
        }
        Toast.makeText(this.this$0.requireContext(), "Added " + platformEntity.getShortname() + " platforms, " + platformEntity.getPlayerIdList().size() + " players.", 0).show();
    }
}
