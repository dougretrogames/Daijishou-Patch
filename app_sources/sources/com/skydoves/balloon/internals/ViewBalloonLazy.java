package com.skydoves.balloon.internals;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ViewKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.Balloon.Factory;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* INFO: compiled from: ViewBalloonLazy.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u0005B\u001d\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/skydoves/balloon/internals/ViewBalloonLazy;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/skydoves/balloon/Balloon$Factory;", "Lkotlin/Lazy;", "Lcom/skydoves/balloon/Balloon;", "Ljava/io/Serializable;", "view", "Landroid/view/View;", "factory", "Lkotlin/reflect/KClass;", "<init>", "(Landroid/view/View;Lkotlin/reflect/KClass;)V", "cached", "value", "getValue", "()Lcom/skydoves/balloon/Balloon;", "isInitialized", "", "toString", "", "balloon_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ViewBalloonLazy<T extends Balloon.Factory> implements Lazy<Balloon>, Serializable {
    private Balloon cached;
    private final KClass<T> factory;
    private final View view;

    public ViewBalloonLazy(View view, KClass<T> factory) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.view = view;
        this.factory = factory;
    }

    /* WARN: Can't rename method to resolve collision */
    /* WARN: Multi-variable type inference failed */
    @Override // kotlin.Lazy
    public Balloon getValue() {
        Fragment viewLifecycleOwner;
        Balloon balloon = this.cached;
        if (balloon != null) {
            return balloon;
        }
        Context context = this.view.getContext();
        Balloon.Factory factory = (Balloon.Factory) ((Class) new ViewBalloonLazy$value$factory$1(this.factory).get()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(this.view);
        if (lifecycleOwner != null) {
            Intrinsics.checkNotNull(context);
            Balloon balloonCreate = factory.create(context, lifecycleOwner);
            this.cached = balloonCreate;
            return balloonCreate;
        }
        if (context instanceof LifecycleOwner) {
            Balloon balloonCreate2 = factory.create(context, (LifecycleOwner) context);
            this.cached = balloonCreate2;
            return balloonCreate2;
        }
        try {
            Fragment fragmentFindFragment = ViewKt.findFragment(this.view);
            if (fragmentFindFragment.getContext() != null) {
                if (fragmentFindFragment.getView() != null) {
                    viewLifecycleOwner = fragmentFindFragment.getViewLifecycleOwner();
                } else {
                    viewLifecycleOwner = fragmentFindFragment;
                }
                Intrinsics.checkNotNull(viewLifecycleOwner);
                Context contextRequireContext = fragmentFindFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                Balloon balloonCreate3 = factory.create(contextRequireContext, viewLifecycleOwner);
                this.cached = balloonCreate3;
                return balloonCreate3;
            }
            throw new IllegalArgumentException("Balloon can not be initialized. The passed fragment's context is null.");
        } catch (Exception unused) {
            throw new IllegalArgumentException("Balloon can not be initialized. The passed context is not an instance of the LifecycleOwner.");
        }
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        return this.cached != null;
    }

    public String toString() {
        return isInitialized() ? getValue().toString() : "Lazy value not initialized yet.";
    }
}
