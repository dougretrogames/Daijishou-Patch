package com.skydoves.balloon.internals;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.Balloon.Factory;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: ActivityBalloonLazy.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u0005B%\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/skydoves/balloon/internals/ActivityBalloonLazy;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/skydoves/balloon/Balloon$Factory;", "Lkotlin/Lazy;", "Lcom/skydoves/balloon/Balloon;", "Ljava/io/Serializable;", "context", "Landroid/content/Context;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "factory", "Lkotlin/reflect/KClass;", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Lkotlin/reflect/KClass;)V", "cached", "value", "getValue", "()Lcom/skydoves/balloon/Balloon;", "isInitialized", "", "toString", "", "balloon_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ActivityBalloonLazy<T extends Balloon.Factory> implements Lazy<Balloon>, Serializable {
    private Balloon cached;
    private final Context context;
    private final KClass<T> factory;
    private final LifecycleOwner lifecycleOwner;

    public ActivityBalloonLazy(Context context, LifecycleOwner lifecycleOwner, KClass<T> factory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.context = context;
        this.lifecycleOwner = lifecycleOwner;
        this.factory = factory;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.Lazy
    public Balloon getValue() {
        Balloon balloon = this.cached;
        if (balloon != null) {
            return balloon;
        }
        Balloon balloonCreate = ((Balloon.Factory) ((Class) new ActivityBalloonLazy$value$factory$1(this.factory).get()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0])).create(this.context, this.lifecycleOwner);
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
