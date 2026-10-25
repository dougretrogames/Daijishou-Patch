package com.skydoves.balloon.internals;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.Balloon.Factory;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: FragmentBalloonLazy.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u0005B\u001d\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/skydoves/balloon/internals/FragmentBalloonLazy;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/skydoves/balloon/Balloon$Factory;", "Lkotlin/Lazy;", "Lcom/skydoves/balloon/Balloon;", "Ljava/io/Serializable;", "fragment", "Landroidx/fragment/app/Fragment;", "factory", "Lkotlin/reflect/KClass;", "<init>", "(Landroidx/fragment/app/Fragment;Lkotlin/reflect/KClass;)V", "cached", "value", "getValue", "()Lcom/skydoves/balloon/Balloon;", "isInitialized", "", "toString", "", "balloon_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FragmentBalloonLazy<T extends Balloon.Factory> implements Lazy<Balloon>, Serializable {
    private Balloon cached;
    private final KClass<T> factory;
    private final Fragment fragment;

    public FragmentBalloonLazy(Fragment fragment, KClass<T> factory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.fragment = fragment;
        this.factory = factory;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.Lazy
    public Balloon getValue() {
        Fragment viewLifecycleOwner;
        Balloon balloon = this.cached;
        if (balloon != null) {
            return balloon;
        }
        if (this.fragment.getContext() == null) {
            throw new IllegalArgumentException("Balloon can not be initialized. The passed fragment's context is null.");
        }
        Balloon.Factory factory = (Balloon.Factory) ((Class) new FragmentBalloonLazy$value$factory$1(this.factory).get()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        if (this.fragment.getView() != null) {
            viewLifecycleOwner = this.fragment.getViewLifecycleOwner();
        } else {
            viewLifecycleOwner = this.fragment;
        }
        Intrinsics.checkNotNull(viewLifecycleOwner);
        Context contextRequireContext = this.fragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        Balloon balloonCreate = factory.create(contextRequireContext, viewLifecycleOwner);
        this.cached = balloonCreate;
        return balloonCreate;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        return this.cached != null;
    }

    public String toString() {
        return isInitialized() ? getValue().toString() : "Lazy value not initialized yet.";
    }
}
