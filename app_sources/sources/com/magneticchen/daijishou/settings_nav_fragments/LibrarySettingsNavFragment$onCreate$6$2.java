package com.magneticchen.daijishou.settings_nav_fragments;

import android.content.Context;
import android.widget.Toast;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: LibrarySettingsNavFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class LibrarySettingsNavFragment$onCreate$6$2 extends Lambda<Unit> implements Function0<Unit> {
    final /* synthetic */ LibrarySettingsNavFragment this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    LibrarySettingsNavFragment$onCreate$6$2(LibrarySettingsNavFragment librarySettingsNavFragment) {
        super(0);
        this.this$0 = librarySettingsNavFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Context contextRequireContext = this.this$0.requireContext();
        String str = this.this$0.canceledString;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("canceledString");
            str = null;
        }
        Toast.makeText(contextRequireContext, str, 0).show();
    }
}
