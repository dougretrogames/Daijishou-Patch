package com.magneticchen.daijishou.settings_nav_fragments;

import android.widget.Toast;
import com.magneticchen.daijishou.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: NavigationSettingsNavFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class NavigationSettingsNavFragment$onCreate$1$1 extends Lambda<Unit> implements Function0<Unit> {
    final /* synthetic */ NavigationSettingsNavFragment this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    NavigationSettingsNavFragment$onCreate$1$1(NavigationSettingsNavFragment navigationSettingsNavFragment) {
        super(0);
        this.this$0 = navigationSettingsNavFragment;
    }

    /* INFO: renamed from: com.magneticchen.daijishou.settings_nav_fragments.NavigationSettingsNavFragment$onCreate$1$1$1, reason: invalid class name */
    /* INFO: compiled from: NavigationSettingsNavFragment.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass1 extends Lambda<Unit> implements Function0<Unit> {
        final /* synthetic */ NavigationSettingsNavFragment this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(NavigationSettingsNavFragment navigationSettingsNavFragment) {
            super(0);
            this.this$0 = navigationSettingsNavFragment;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Toast.makeText(this.this$0.getContext(), this.this$0.getString(R.string.hotkeys_set), 0).show();
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        NavigationSettingsNavFragment.onCreate$lambda$0$rightTabHotkey(this.this$0, new AnonymousClass1(this.this$0));
    }
}
