package androidx.navigation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: ActivityNavArgsLazy.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u0004H\u0087\b¨\u0006\u0005"}, d2 = {"navArgs", "Landroidx/navigation/NavArgsLazy;", "Args", "Landroidx/navigation/NavArgs;", "Landroid/app/Activity;", "navigation-runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ActivityNavArgsLazyKt {

    /* JADX INFO: renamed from: androidx.navigation.ActivityNavArgsLazyKt$navArgs$1, reason: invalid class name */
    /* JADX INFO: compiled from: ActivityNavArgsLazy.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroid/os/Bundle;", "Args", "Landroidx/navigation/NavArgs;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class AnonymousClass1 extends Lambda implements Function0<Bundle> {
        final /* synthetic */ Activity $this_navArgs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Activity activity) {
            super(0);
            this.$this_navArgs = activity;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Bundle invoke() {
            Bundle extras;
            Intent intent = this.$this_navArgs.getIntent();
            if (intent != null) {
                Activity activity = this.$this_navArgs;
                extras = intent.getExtras();
                if (extras == null) {
                    throw new IllegalStateException("Activity " + activity + " has null extras in " + intent);
                }
            } else {
                extras = null;
            }
            if (extras != null) {
                return extras;
            }
            throw new IllegalStateException("Activity " + this.$this_navArgs + " has a null Intent");
        }
    }

    public static final /* synthetic */ <Args extends NavArgs> NavArgsLazy<Args> navArgs(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.reifiedOperationMarker(4, "Args");
        return new NavArgsLazy<>(Reflection.getOrCreateKotlinClass(NavArgs.class), new AnonymousClass1(activity));
    }
}
