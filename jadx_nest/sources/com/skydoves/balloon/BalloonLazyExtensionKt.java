package com.skydoves.balloon;

import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;
import com.skydoves.balloon.internals.ActivityBalloonLazy;
import com.skydoves.balloon.internals.FragmentBalloonLazy;
import com.skydoves.balloon.internals.ViewBalloonLazy;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: BalloonLazyExtension.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\n\b\u0000\u0010\u0003\u0018\u0001*\u00020\u0004*\u00020\u0005H\u0087\b\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\n\b\u0000\u0010\u0003\u0018\u0001*\u00020\u0004*\u00020\u0006H\u0087\b\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\n\b\u0000\u0010\u0003\u0018\u0001*\u00020\u0004*\u00020\u0007H\u0087\b\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\n\b\u0000\u0010\u0003\u0018\u0001*\u00020\u0004*\u00020\bH\u0087\b¨\u0006\t"}, d2 = {"balloon", "Lkotlin/Lazy;", "Lcom/skydoves/balloon/Balloon;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/skydoves/balloon/Balloon$Factory;", "Landroidx/activity/ComponentActivity;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View;", "Landroidx/viewbinding/ViewBinding;", "balloon_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BalloonLazyExtensionKt {
    @BalloonInlineDsl
    public static final /* synthetic */ <T extends Balloon.Factory> Lazy<Balloon> balloon(ComponentActivity componentActivity) {
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return new ActivityBalloonLazy(componentActivity, componentActivity, Reflection.getOrCreateKotlinClass(Balloon.Factory.class));
    }

    @BalloonInlineDsl
    public static final /* synthetic */ <T extends Balloon.Factory> Lazy<Balloon> balloon(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return new FragmentBalloonLazy(fragment, Reflection.getOrCreateKotlinClass(Balloon.Factory.class));
    }

    @BalloonInlineDsl
    public static final /* synthetic */ <T extends Balloon.Factory> Lazy<Balloon> balloon(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return new ViewBalloonLazy(view, Reflection.getOrCreateKotlinClass(Balloon.Factory.class));
    }

    @BalloonInlineDsl
    public static final /* synthetic */ <T extends Balloon.Factory> Lazy<Balloon> balloon(ViewBinding viewBinding) {
        Intrinsics.checkNotNullParameter(viewBinding, "<this>");
        View root = viewBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return new ViewBalloonLazy(root, Reflection.getOrCreateKotlinClass(Balloon.Factory.class));
    }
}
