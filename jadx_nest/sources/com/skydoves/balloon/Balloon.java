package com.skydoves.balloon;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.method.MovementMethod;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupKt;
import androidx.core.widget.ImageViewCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewbinding.ViewBinding;
import com.skydoves.balloon.animations.BalloonRotateAnimation;
import com.skydoves.balloon.databinding.BalloonLayoutBodyBinding;
import com.skydoves.balloon.databinding.BalloonLayoutOverlayBinding;
import com.skydoves.balloon.extensions.ContextExtensionKt;
import com.skydoves.balloon.extensions.DrawableExtensionKt;
import com.skydoves.balloon.extensions.GlobalExtensionKt;
import com.skydoves.balloon.extensions.TextViewExtensionKt;
import com.skydoves.balloon.extensions.ViewExtensionKt;
import com.skydoves.balloon.internals.DefinitionKt;
import com.skydoves.balloon.overlay.BalloonAnchorOverlayView;
import com.skydoves.balloon.overlay.BalloonOverlayAnimation;
import com.skydoves.balloon.overlay.BalloonOverlayOval;
import com.skydoves.balloon.overlay.BalloonOverlayShape;
import com.skydoves.balloon.radius.RadiusLayout;
import com.skydoves.balloon.vectortext.VectorTextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: Balloon.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u009a\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 Ç\u00012\u00020\u0001:\u0006Å\u0001Æ\u0001Ç\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u00020.2\u0006\u00100\u001a\u000201H\u0002J\b\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u000205H\u0002J\u0010\u00106\u001a\u00020.2\u0006\u00107\u001a\u000208H\u0002J\u0010\u00109\u001a\u00020.2\u0006\u00107\u001a\u000208H\u0002J\u001e\u0010:\u001a\u0004\u0018\u00010;*\u00020<2\u0006\u0010=\u001a\u0002032\u0006\u0010>\u001a\u000203H\u0002J \u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020<2\u0006\u0010=\u001a\u0002032\u0006\u0010>\u001a\u000203H\u0002J$\u0010B\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u0002050C2\u0006\u0010=\u001a\u0002032\u0006\u0010>\u001a\u000203H\u0002J \u0010D\u001a\u00020@2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u0002052\u0006\u0010H\u001a\u000205H\u0002J\u0010\u0010I\u001a\u00020.2\u0006\u00107\u001a\u000208H\u0002J\u0010\u0010J\u001a\u0002032\u0006\u00107\u001a\u000208H\u0002J\u0010\u0010K\u001a\u0002032\u0006\u00107\u001a\u000208H\u0002J\b\u0010L\u001a\u00020.H\u0002J\b\u0010M\u001a\u00020.H\u0002J\b\u0010N\u001a\u00020.H\u0002J\b\u0010O\u001a\u00020.H\u0002J\b\u0010P\u001a\u00020.H\u0002J\b\u0010Q\u001a\u00020.H\u0002J\b\u0010R\u001a\u00020.H\u0002J\b\u0010S\u001a\u00020.H\u0002J\b\u0010T\u001a\u00020\u0017H\u0002J\b\u0010U\u001a\u00020.H\u0002J\b\u0010V\u001a\u00020.H\u0002J\b\u0010W\u001a\u00020.H\u0002J\b\u0010X\u001a\u00020.H\u0002J\n\u0010Y\u001a\u0004\u0018\u00010ZH\u0002J\b\u0010[\u001a\u00020.H\u0002J\b\u0010\\\u001a\u00020.H\u0002J\u0006\u0010]\u001a\u00020\u0017J\u0010\u0010^\u001a\u00020.2\u0006\u0010_\u001a\u00020`H\u0003J\u001c\u0010a\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u0002050C2\u0006\u0010_\u001a\u00020`H\u0002J\u001c\u0010b\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u0002050C2\u0006\u0010_\u001a\u00020`H\u0002J\u001c\u0010c\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u0002050C2\u0006\u0010_\u001a\u00020`H\u0002J\u0010\u0010d\u001a\u00020\u00172\u0006\u00107\u001a\u000208H\u0002J\u001e\u0010e\u001a\u00020.2\u0006\u00107\u001a\u0002082\f\u0010f\u001a\b\u0012\u0004\u0012\u0002080gH\u0002J\u0016\u0010h\u001a\u00020.2\u0006\u0010_\u001a\u00020`H\u0082@¢\u0006\u0002\u0010iJ6\u0010j\u001a\u00020\u00002\u0006\u0010k\u001a\u00020\u00002#\b\u0004\u0010l\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\bn\u0012\b\bo\u0012\u0004\b\b(k\u0012\u0004\u0012\u00020.0mH\u0083\bJ.\u0010p\u001a\u00020.2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010q\u001a\u0002052\b\b\u0002\u0010r\u001a\u0002052\b\b\u0002\u0010s\u001a\u00020tH\u0007J4\u0010u\u001a\u00020.2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010q\u001a\u0002052\b\b\u0002\u0010r\u001a\u0002052\b\b\u0002\u0010s\u001a\u00020tH\u0086@¢\u0006\u0002\u0010vJ6\u0010w\u001a\u00020\u00002\u0006\u0010k\u001a\u00020\u00002\u0006\u00107\u001a\u0002082\b\b\u0002\u0010q\u001a\u0002052\b\b\u0002\u0010r\u001a\u0002052\b\b\u0002\u0010s\u001a\u00020tH\u0007J$\u0010x\u001a\u00020.2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010q\u001a\u0002052\b\b\u0002\u0010r\u001a\u000205H\u0007J*\u0010y\u001a\u00020.2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010q\u001a\u0002052\b\b\u0002\u0010r\u001a\u000205H\u0086@¢\u0006\u0002\u0010zJ,\u0010{\u001a\u00020\u00002\u0006\u0010k\u001a\u00020\u00002\u0006\u00107\u001a\u0002082\b\b\u0002\u0010q\u001a\u0002052\b\b\u0002\u0010r\u001a\u000205H\u0007J$\u0010|\u001a\u00020.2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010q\u001a\u0002052\b\b\u0002\u0010r\u001a\u000205H\u0007J*\u0010}\u001a\u00020.2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010q\u001a\u0002052\b\b\u0002\u0010r\u001a\u000205H\u0086@¢\u0006\u0002\u0010zJ,\u0010~\u001a\u00020\u00002\u0006\u0010k\u001a\u00020\u00002\u0006\u00107\u001a\u0002082\b\b\u0002\u0010q\u001a\u0002052\b\b\u0002\u0010r\u001a\u000205H\u0007J$\u0010\u007f\u001a\u00020.2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010q\u001a\u0002052\b\b\u0002\u0010r\u001a\u000205H\u0007J+\u0010\u0080\u0001\u001a\u00020.2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010q\u001a\u0002052\b\b\u0002\u0010r\u001a\u000205H\u0086@¢\u0006\u0002\u0010zJ-\u0010\u0081\u0001\u001a\u00020\u00002\u0006\u0010k\u001a\u00020\u00002\u0006\u00107\u001a\u0002082\b\b\u0002\u0010q\u001a\u0002052\b\b\u0002\u0010r\u001a\u000205H\u0007J%\u0010\u0082\u0001\u001a\u00020.2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010q\u001a\u0002052\b\b\u0002\u0010r\u001a\u000205H\u0007J%\u0010\u0083\u0001\u001a\u00020.2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010q\u001a\u0002052\b\b\u0002\u0010r\u001a\u000205H\u0007J+\u0010\u0084\u0001\u001a\u00020.2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010q\u001a\u0002052\b\b\u0002\u0010r\u001a\u000205H\u0086@¢\u0006\u0002\u0010zJ-\u0010\u0085\u0001\u001a\u00020\u00002\u0006\u0010k\u001a\u00020\u00002\u0006\u00107\u001a\u0002082\b\b\u0002\u0010q\u001a\u0002052\b\b\u0002\u0010r\u001a\u000205H\u0007J-\u0010\u0086\u0001\u001a\u00020\u00002\u0006\u0010k\u001a\u00020\u00002\u0006\u00107\u001a\u0002082\b\b\u0002\u0010q\u001a\u0002052\b\b\u0002\u0010r\u001a\u000205H\u0007J%\u0010\u0087\u0001\u001a\u00020.2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010q\u001a\u0002052\b\b\u0002\u0010r\u001a\u000205H\u0007J%\u0010\u0088\u0001\u001a\u00020.2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010q\u001a\u0002052\b\b\u0002\u0010r\u001a\u000205H\u0007J+\u0010\u0089\u0001\u001a\u00020.2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010q\u001a\u0002052\b\b\u0002\u0010r\u001a\u000205H\u0086@¢\u0006\u0002\u0010zJ-\u0010\u008a\u0001\u001a\u00020\u00002\u0006\u0010k\u001a\u00020\u00002\u0006\u00107\u001a\u0002082\b\b\u0002\u0010q\u001a\u0002052\b\b\u0002\u0010r\u001a\u000205H\u0007J-\u0010\u008b\u0001\u001a\u00020\u00002\u0006\u0010k\u001a\u00020\u00002\u0006\u00107\u001a\u0002082\b\b\u0002\u0010q\u001a\u0002052\b\b\u0002\u0010r\u001a\u000205H\u0007J@\u0010\u008c\u0001\u001a\u00020.2\u0007\u0010\u008d\u0001\u001a\u00020\u00132\u0007\u0010\u008e\u0001\u001a\u0002082\u000f\b\u0002\u0010\u008f\u0001\u001a\b\u0012\u0004\u0012\u0002080g2\b\b\u0002\u0010q\u001a\u0002052\b\b\u0002\u0010r\u001a\u000205H\u0007JG\u0010\u0090\u0001\u001a\u00020.2\u0007\u0010\u008d\u0001\u001a\u00020\u00132\u0007\u0010\u008e\u0001\u001a\u0002082\u000f\b\u0002\u0010\u008f\u0001\u001a\b\u0012\u0004\u0012\u0002080g2\b\b\u0002\u0010q\u001a\u0002052\b\b\u0002\u0010r\u001a\u000205H\u0086@¢\u0006\u0003\u0010\u0091\u0001J6\u0010\u0092\u0001\u001a\u00020\u00002\u0007\u0010\u008d\u0001\u001a\u00020\u00132\u0006\u0010k\u001a\u00020\u00002\u0006\u00107\u001a\u0002082\b\b\u0002\u0010q\u001a\u0002052\b\b\u0002\u0010r\u001a\u000205H\u0007J9\u0010\u0093\u0001\u001a\u00020.2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010q\u001a\u0002052\b\b\u0002\u0010r\u001a\u0002052\b\b\u0002\u0010G\u001a\u0002052\b\b\u0002\u0010H\u001a\u000205H\u0007J9\u0010\u0094\u0001\u001a\u00020.2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010q\u001a\u0002052\b\b\u0002\u0010r\u001a\u0002052\b\b\u0002\u0010G\u001a\u0002052\b\b\u0002\u0010H\u001a\u000205H\u0007J9\u0010\u0095\u0001\u001a\u00020.2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010q\u001a\u0002052\b\b\u0002\u0010r\u001a\u0002052\b\b\u0002\u0010G\u001a\u0002052\b\b\u0002\u0010H\u001a\u000205H\u0007J9\u0010\u0096\u0001\u001a\u00020.2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010q\u001a\u0002052\b\b\u0002\u0010r\u001a\u0002052\b\b\u0002\u0010G\u001a\u0002052\b\b\u0002\u0010H\u001a\u000205H\u0007JB\u0010\u0097\u0001\u001a\u00020.2\u0007\u0010\u008d\u0001\u001a\u00020\u00132\u0006\u00107\u001a\u0002082\b\b\u0002\u0010q\u001a\u0002052\b\b\u0002\u0010r\u001a\u0002052\b\b\u0002\u0010G\u001a\u0002052\b\b\u0002\u0010H\u001a\u000205H\u0007J\u0011\u0010\u0098\u0001\u001a\u00020.2\u0006\u0010_\u001a\u00020`H\u0003J7\u0010\u0098\u0001\u001a\u00020.2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010q\u001a\u0002052\b\b\u0002\u0010r\u001a\u0002052\b\b\u0002\u0010G\u001a\u0002052\b\b\u0002\u0010H\u001a\u000205J\u0007\u0010\u0099\u0001\u001a\u00020.J\u0019\u0010\u009a\u0001\u001a\u00020.2\u0006\u0010G\u001a\u0002052\u0006\u0010H\u001a\u000205H\u0007J\u0011\u0010\u009b\u0001\u001a\u00020\u00172\b\u0010\u009c\u0001\u001a\u00030\u009d\u0001J\u0013\u0010\u009e\u0001\u001a\u00020.2\n\u0010\u009f\u0001\u001a\u0005\u0018\u00010 \u0001J\u0007\u0010¡\u0001\u001a\u00020.J\u001b\u0010\u009e\u0001\u001a\u00020.2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020.0mJ\u0011\u0010¢\u0001\u001a\u00020.2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u001b\u0010¢\u0001\u001a\u00020.2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020.0mJ\u0013\u0010£\u0001\u001a\u00020.2\n\u0010¤\u0001\u001a\u0005\u0018\u00010¥\u0001J\u0016\u0010£\u0001\u001a\u00020.2\r\u0010l\u001a\t\u0012\u0004\u0012\u00020.0¦\u0001J\u0013\u0010§\u0001\u001a\u00020.2\n\u0010¨\u0001\u001a\u0005\u0018\u00010©\u0001J#\u0010§\u0001\u001a\u00020.2\u001a\u0010l\u001a\u0016\u0012\u0004\u0012\u000208\u0012\u0005\u0012\u00030«\u0001\u0012\u0004\u0012\u00020.0ª\u0001J\u0013\u0010¬\u0001\u001a\u00020.2\n\u0010\u00ad\u0001\u001a\u0005\u0018\u00010®\u0001J\u0013\u0010¯\u0001\u001a\u00020.2\n\u0010\u00ad\u0001\u001a\u0005\u0018\u00010®\u0001J#\u0010¯\u0001\u001a\u00020.2\u001a\u0010l\u001a\u0016\u0012\u0004\u0012\u000208\u0012\u0005\u0012\u00030«\u0001\u0012\u0004\u0012\u00020\u00170ª\u0001J\u0011\u0010±\u0001\u001a\u00020.2\u0006\u00107\u001a\u000208H\u0002J\u0013\u0010²\u0001\u001a\u00020.2\n\u0010³\u0001\u001a\u0005\u0018\u00010´\u0001J\u0016\u0010²\u0001\u001a\u00020.2\r\u0010l\u001a\t\u0012\u0004\u0012\u00020.0¦\u0001J\u000f\u0010µ\u0001\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0017J\u0007\u0010¶\u0001\u001a\u000205J\u001c\u0010·\u0001\u001a\u00020.2\b\u0010¸\u0001\u001a\u00030¹\u00012\u0007\u0010º\u0001\u001a\u000208H\u0002J\u0011\u0010»\u0001\u001a\u00020.2\u0006\u00100\u001a\u000201H\u0002J\u001b\u0010¼\u0001\u001a\u0002052\u0007\u0010½\u0001\u001a\u0002052\u0007\u0010º\u0001\u001a\u000208H\u0002J\u0007\u0010¾\u0001\u001a\u000205J\u0007\u0010¿\u0001\u001a\u000201J\u0007\u0010À\u0001\u001a\u000208J\u0013\u0010Á\u0001\u001a\u00020.2\b\u0010Â\u0001\u001a\u00030Ã\u0001H\u0016J\u0013\u0010Ä\u0001\u001a\u00020.2\b\u0010Â\u0001\u001a\u00030Ã\u0001H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\"\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0017@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\"\u001a\u0004\b%\u0010&R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\"\u001a\u0004\b*\u0010+R\u001e\u0010°\u0001\u001a\u0011\u0012\u0005\u0012\u00030«\u0001\u0012\u0004\u0012\u00020\u0017\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006È\u0001"}, d2 = {"Lcom/skydoves/balloon/Balloon;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "context", "Landroid/content/Context;", "builder", "Lcom/skydoves/balloon/Balloon$Builder;", "<init>", "(Landroid/content/Context;Lcom/skydoves/balloon/Balloon$Builder;)V", "binding", "Lcom/skydoves/balloon/databinding/BalloonLayoutBodyBinding;", "overlayBinding", "Lcom/skydoves/balloon/databinding/BalloonLayoutOverlayBinding;", "bodyWindow", "Landroid/widget/PopupWindow;", "getBodyWindow", "()Landroid/widget/PopupWindow;", "overlayWindow", "getOverlayWindow", "value", "Lcom/skydoves/balloon/BalloonAlign;", "currentAlign", "getCurrentAlign", "()Lcom/skydoves/balloon/BalloonAlign;", "", "isShowing", "()Z", "destroyed", "onBalloonInitializedListener", "Lcom/skydoves/balloon/OnBalloonInitializedListener;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler$delegate", "Lkotlin/Lazy;", "autoDismissRunnable", "Lcom/skydoves/balloon/AutoDismissRunnable;", "getAutoDismissRunnable", "()Lcom/skydoves/balloon/AutoDismissRunnable;", "autoDismissRunnable$delegate", "balloonPersistence", "Lcom/skydoves/balloon/BalloonPersistence;", "getBalloonPersistence", "()Lcom/skydoves/balloon/BalloonPersistence;", "balloonPersistence$delegate", "createByBuilder", "", "adjustFitsSystemWindows", "parent", "Landroid/view/ViewGroup;", "getMinArrowPosition", "", "getDoubleArrowSize", "", "initializeArrow", "anchor", "Landroid/view/View;", "updateArrow", "getArrowForeground", "Landroid/graphics/drawable/BitmapDrawable;", "Landroid/widget/ImageView;", "x", "y", "adjustArrowColorByMatchingCardBackground", "Landroid/graphics/Bitmap;", "imageView", "getColorsFromBalloonCard", "Lkotlin/Pair;", "drawableToBitmap", "drawable", "Landroid/graphics/drawable/Drawable;", "width", "height", "adjustArrowOrientationByRules", "getArrowConstraintPositionX", "getArrowConstraintPositionY", "initializeBackground", "initializeBalloonWindow", "initializeBalloonListeners", "initializeBalloonRoot", "initializeBalloonContent", "initializeIcon", "initializeText", "initializeBalloonLayout", "hasCustomLayout", "initializeCustomLayout", "initializeBalloonOverlay", "applyBalloonAnimation", "applyBalloonOverlayAnimation", "getBalloonHighlightAnimation", "Landroid/view/animation/Animation;", "startBalloonHighlightAnimation", "stopBalloonHighlightAnimation", "shouldShowUp", "show", "placement", "Lcom/skydoves/balloon/BalloonPlacement;", "calculateOffset", "calculateAlignOffset", "calculateCenterOffset", "canShowBalloonWindow", "showOverlayWindow", "subAnchors", "", "awaitBalloon", "(Lcom/skydoves/balloon/BalloonPlacement;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "relay", "balloon", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "showAtCenter", "xOff", "yOff", "centerAlign", "Lcom/skydoves/balloon/BalloonCenterAlign;", "awaitAtCenter", "(Landroid/view/View;IILcom/skydoves/balloon/BalloonCenterAlign;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "relayShowAtCenter", "showAsDropDown", "awaitAsDropDown", "(Landroid/view/View;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "relayShowAsDropDown", "showAlignTop", "awaitAlignTop", "relayShowAlignTop", "showAlignBottom", "awaitAlignBottom", "relayShowAlignBottom", "showAlignRight", "showAlignEnd", "awaitAlignEnd", "relayShowAlignRight", "relayShowAlignEnd", "showAlignLeft", "showAlignStart", "awaitAlignStart", "relayShowAlignLeft", "relayShowAlignStart", "showAlign", "align", "mainAnchor", "subAnchorList", "awaitAlign", "(Lcom/skydoves/balloon/BalloonAlign;Landroid/view/View;Ljava/util/List;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "relayShowAlign", "updateAlignTop", "updateAlignBottom", "updateAlignEnd", "updateAlignStart", "updateAlign", ConfigConstants.CONFIG_KEY_UPDATE, "dismiss", "updateSizeOfBalloonCard", "dismissWithDelay", "delay", "", "setOnBalloonClickListener", "onBalloonClickListener", "Lcom/skydoves/balloon/OnBalloonClickListener;", "clearAllPreferences", "setOnBalloonInitializedListener", "setOnBalloonDismissListener", "onBalloonDismissListener", "Lcom/skydoves/balloon/OnBalloonDismissListener;", "Lkotlin/Function0;", "setOnBalloonOutsideTouchListener", "onBalloonOutsideTouchListener", "Lcom/skydoves/balloon/OnBalloonOutsideTouchListener;", "Lkotlin/Function2;", "Landroid/view/MotionEvent;", "setOnBalloonTouchListener", "onTouchListener", "Landroid/view/View$OnTouchListener;", "setOnBalloonOverlayTouchListener", "passedEventActionDownEvent", "passTouchEventToAnchor", "setOnBalloonOverlayClickListener", "onBalloonOverlayClickListener", "Lcom/skydoves/balloon/OnBalloonOverlayClickListener;", "setIsAttachedInDecor", "getMeasuredWidth", "measureTextWidth", "textView", "Landroid/widget/TextView;", "rootView", "traverseAndMeasureTextWidth", "getMeasuredTextWidth", "measuredWidth", "getMeasuredHeight", "getContentView", "getBalloonArrowView", "onPause", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onDestroy", "Builder", "Factory", "Companion", "balloon_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Balloon implements DefaultLifecycleObserver {
    private static boolean isConsumerActive;

    /* JADX INFO: renamed from: autoDismissRunnable$delegate, reason: from kotlin metadata */
    private final Lazy autoDismissRunnable;

    /* JADX INFO: renamed from: balloonPersistence$delegate, reason: from kotlin metadata */
    private final Lazy balloonPersistence;
    private final BalloonLayoutBodyBinding binding;
    private final PopupWindow bodyWindow;
    private final Builder builder;
    private final Context context;
    private BalloonAlign currentAlign;
    private boolean destroyed;

    /* JADX INFO: renamed from: handler$delegate, reason: from kotlin metadata */
    private final Lazy handler;
    private boolean isShowing;
    public OnBalloonInitializedListener onBalloonInitializedListener;
    private final BalloonLayoutOverlayBinding overlayBinding;
    private final PopupWindow overlayWindow;
    private Pair<MotionEvent, Boolean> passedEventActionDownEvent;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<Channel<DeferredBalloonGroup>> channel$delegate = LazyKt.lazy(new Balloon$$ExternalSyntheticLambda13());
    private static final Lazy<CoroutineScope> scope$delegate = LazyKt.lazy(new Balloon$$ExternalSyntheticLambda14());

    /* JADX INFO: compiled from: Balloon.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, d2 = {"Lcom/skydoves/balloon/Balloon$Factory;", "", "<init>", "()V", "create", "Lcom/skydoves/balloon/Balloon;", "context", "Landroid/content/Context;", "lifecycle", "Landroidx/lifecycle/LifecycleOwner;", "balloon_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static abstract class Factory {
        public abstract Balloon create(Context context, LifecycleOwner lifecycle);
    }

    /* JADX INFO: compiled from: Balloon.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;
        public static final /* synthetic */ int[] $EnumSwitchMapping$6;
        public static final /* synthetic */ int[] $EnumSwitchMapping$7;

        static {
            int[] iArr = new int[ArrowOrientation.values().length];
            try {
                iArr[ArrowOrientation.BOTTOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ArrowOrientation.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ArrowOrientation.START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ArrowOrientation.END.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ArrowPositionRules.values().length];
            try {
                iArr2[ArrowPositionRules.ALIGN_BALLOON.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[ArrowPositionRules.ALIGN_ANCHOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[BalloonAnimation.values().length];
            try {
                iArr3[BalloonAnimation.ELASTIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[BalloonAnimation.CIRCULAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[BalloonAnimation.FADE.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[BalloonAnimation.OVERSHOOT.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[BalloonAnimation.NONE.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[BalloonOverlayAnimation.values().length];
            try {
                iArr4[BalloonOverlayAnimation.FADE.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            $EnumSwitchMapping$3 = iArr4;
            int[] iArr5 = new int[BalloonHighlightAnimation.values().length];
            try {
                iArr5[BalloonHighlightAnimation.HEARTBEAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr5[BalloonHighlightAnimation.SHAKE.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr5[BalloonHighlightAnimation.BREATH.ordinal()] = 3;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr5[BalloonHighlightAnimation.ROTATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused16) {
            }
            $EnumSwitchMapping$4 = iArr5;
            int[] iArr6 = new int[PlacementType.values().length];
            try {
                iArr6[PlacementType.DROPDOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr6[PlacementType.ALIGNMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr6[PlacementType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused19) {
            }
            $EnumSwitchMapping$5 = iArr6;
            int[] iArr7 = new int[BalloonAlign.values().length];
            try {
                iArr7[BalloonAlign.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr7[BalloonAlign.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr7[BalloonAlign.START.ordinal()] = 3;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr7[BalloonAlign.END.ordinal()] = 4;
            } catch (NoSuchFieldError unused23) {
            }
            $EnumSwitchMapping$6 = iArr7;
            int[] iArr8 = new int[BalloonCenterAlign.values().length];
            try {
                iArr8[BalloonCenterAlign.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr8[BalloonCenterAlign.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr8[BalloonCenterAlign.START.ordinal()] = 3;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr8[BalloonCenterAlign.END.ordinal()] = 4;
            } catch (NoSuchFieldError unused27) {
            }
            $EnumSwitchMapping$7 = iArr8;
        }
    }

    public /* synthetic */ Balloon(Context context, Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, builder);
    }

    public final Balloon relayShowAlign(BalloonAlign align, Balloon balloon, View anchor) {
        Intrinsics.checkNotNullParameter(align, "align");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        return relayShowAlign$default(this, align, balloon, anchor, 0, 0, 24, null);
    }

    public final Balloon relayShowAlign(BalloonAlign align, Balloon balloon, View anchor, int i) {
        Intrinsics.checkNotNullParameter(align, "align");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        return relayShowAlign$default(this, align, balloon, anchor, i, 0, 16, null);
    }

    public final Balloon relayShowAlignBottom(Balloon balloon, View anchor) {
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        return relayShowAlignBottom$default(this, balloon, anchor, 0, 0, 12, null);
    }

    public final Balloon relayShowAlignBottom(Balloon balloon, View anchor, int i) {
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        return relayShowAlignBottom$default(this, balloon, anchor, i, 0, 8, null);
    }

    public final Balloon relayShowAlignEnd(Balloon balloon, View anchor) {
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        return relayShowAlignEnd$default(this, balloon, anchor, 0, 0, 12, null);
    }

    public final Balloon relayShowAlignEnd(Balloon balloon, View anchor, int i) {
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        return relayShowAlignEnd$default(this, balloon, anchor, i, 0, 8, null);
    }

    @Deprecated(message = "Use relayShowAlignStart instead.", replaceWith = @ReplaceWith(expression = "relayShowAlignStart(balloon, anchor, xOff, yOff)", imports = {}))
    public final Balloon relayShowAlignLeft(Balloon balloon, View anchor) {
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        return relayShowAlignLeft$default(this, balloon, anchor, 0, 0, 12, null);
    }

    @Deprecated(message = "Use relayShowAlignStart instead.", replaceWith = @ReplaceWith(expression = "relayShowAlignStart(balloon, anchor, xOff, yOff)", imports = {}))
    public final Balloon relayShowAlignLeft(Balloon balloon, View anchor, int i) {
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        return relayShowAlignLeft$default(this, balloon, anchor, i, 0, 8, null);
    }

    @Deprecated(message = "Use relayShowAlignEnd instead.", replaceWith = @ReplaceWith(expression = "relayShowAlignEnd(balloon, anchor, xOff, yOff)", imports = {}))
    public final Balloon relayShowAlignRight(Balloon balloon, View anchor) {
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        return relayShowAlignRight$default(this, balloon, anchor, 0, 0, 12, null);
    }

    @Deprecated(message = "Use relayShowAlignEnd instead.", replaceWith = @ReplaceWith(expression = "relayShowAlignEnd(balloon, anchor, xOff, yOff)", imports = {}))
    public final Balloon relayShowAlignRight(Balloon balloon, View anchor, int i) {
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        return relayShowAlignRight$default(this, balloon, anchor, i, 0, 8, null);
    }

    public final Balloon relayShowAlignStart(Balloon balloon, View anchor) {
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        return relayShowAlignStart$default(this, balloon, anchor, 0, 0, 12, null);
    }

    public final Balloon relayShowAlignStart(Balloon balloon, View anchor, int i) {
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        return relayShowAlignStart$default(this, balloon, anchor, i, 0, 8, null);
    }

    public final Balloon relayShowAlignTop(Balloon balloon, View anchor) {
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        return relayShowAlignTop$default(this, balloon, anchor, 0, 0, 12, null);
    }

    public final Balloon relayShowAlignTop(Balloon balloon, View anchor, int i) {
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        return relayShowAlignTop$default(this, balloon, anchor, i, 0, 8, null);
    }

    public final Balloon relayShowAsDropDown(Balloon balloon, View anchor) {
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        return relayShowAsDropDown$default(this, balloon, anchor, 0, 0, 12, null);
    }

    public final Balloon relayShowAsDropDown(Balloon balloon, View anchor, int i) {
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        return relayShowAsDropDown$default(this, balloon, anchor, i, 0, 8, null);
    }

    public final Balloon relayShowAtCenter(Balloon balloon, View anchor) {
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        return relayShowAtCenter$default(this, balloon, anchor, 0, 0, null, 28, null);
    }

    public final Balloon relayShowAtCenter(Balloon balloon, View anchor, int i) {
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        return relayShowAtCenter$default(this, balloon, anchor, i, 0, null, 24, null);
    }

    public final Balloon relayShowAtCenter(Balloon balloon, View anchor, int i, int i2) {
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        return relayShowAtCenter$default(this, balloon, anchor, i, i2, null, 16, null);
    }

    public final void showAlign(BalloonAlign align, View mainAnchor) {
        Intrinsics.checkNotNullParameter(align, "align");
        Intrinsics.checkNotNullParameter(mainAnchor, "mainAnchor");
        showAlign$default(this, align, mainAnchor, null, 0, 0, 28, null);
    }

    public final void showAlign(BalloonAlign align, View mainAnchor, List<? extends View> subAnchorList) {
        Intrinsics.checkNotNullParameter(align, "align");
        Intrinsics.checkNotNullParameter(mainAnchor, "mainAnchor");
        Intrinsics.checkNotNullParameter(subAnchorList, "subAnchorList");
        showAlign$default(this, align, mainAnchor, subAnchorList, 0, 0, 24, null);
    }

    public final void showAlign(BalloonAlign align, View mainAnchor, List<? extends View> subAnchorList, int i) {
        Intrinsics.checkNotNullParameter(align, "align");
        Intrinsics.checkNotNullParameter(mainAnchor, "mainAnchor");
        Intrinsics.checkNotNullParameter(subAnchorList, "subAnchorList");
        showAlign$default(this, align, mainAnchor, subAnchorList, i, 0, 16, null);
    }

    public final void showAlignBottom(View anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        showAlignBottom$default(this, anchor, 0, 0, 6, null);
    }

    public final void showAlignBottom(View anchor, int i) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        showAlignBottom$default(this, anchor, i, 0, 4, null);
    }

    public final void showAlignEnd(View anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        showAlignEnd$default(this, anchor, 0, 0, 6, null);
    }

    public final void showAlignEnd(View anchor, int i) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        showAlignEnd$default(this, anchor, i, 0, 4, null);
    }

    @Deprecated(message = "Use showAlignStart instead.", replaceWith = @ReplaceWith(expression = "showAlignStart(anchor, xOff, yOff)", imports = {}))
    public final void showAlignLeft(View anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        showAlignLeft$default(this, anchor, 0, 0, 6, null);
    }

    @Deprecated(message = "Use showAlignStart instead.", replaceWith = @ReplaceWith(expression = "showAlignStart(anchor, xOff, yOff)", imports = {}))
    public final void showAlignLeft(View anchor, int i) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        showAlignLeft$default(this, anchor, i, 0, 4, null);
    }

    @Deprecated(message = "Use showAlignEnd instead.", replaceWith = @ReplaceWith(expression = "showAlignEnd(anchor, xOff, yOff)", imports = {}))
    public final void showAlignRight(View anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        showAlignRight$default(this, anchor, 0, 0, 6, null);
    }

    @Deprecated(message = "Use showAlignEnd instead.", replaceWith = @ReplaceWith(expression = "showAlignEnd(anchor, xOff, yOff)", imports = {}))
    public final void showAlignRight(View anchor, int i) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        showAlignRight$default(this, anchor, i, 0, 4, null);
    }

    public final void showAlignStart(View anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        showAlignStart$default(this, anchor, 0, 0, 6, null);
    }

    public final void showAlignStart(View anchor, int i) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        showAlignStart$default(this, anchor, i, 0, 4, null);
    }

    public final void showAlignTop(View anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        showAlignTop$default(this, anchor, 0, 0, 6, null);
    }

    public final void showAlignTop(View anchor, int i) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        showAlignTop$default(this, anchor, i, 0, 4, null);
    }

    public final void showAsDropDown(View anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        showAsDropDown$default(this, anchor, 0, 0, 6, null);
    }

    public final void showAsDropDown(View anchor, int i) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        showAsDropDown$default(this, anchor, i, 0, 4, null);
    }

    public final void showAtCenter(View anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        showAtCenter$default(this, anchor, 0, 0, null, 14, null);
    }

    public final void showAtCenter(View anchor, int i) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        showAtCenter$default(this, anchor, i, 0, null, 12, null);
    }

    public final void showAtCenter(View anchor, int i, int i2) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        showAtCenter$default(this, anchor, i, i2, null, 8, null);
    }

    public final void updateAlign(BalloonAlign align, View anchor) {
        Intrinsics.checkNotNullParameter(align, "align");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        updateAlign$default(this, align, anchor, 0, 0, 0, 0, 60, null);
    }

    public final void updateAlign(BalloonAlign align, View anchor, int i) {
        Intrinsics.checkNotNullParameter(align, "align");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        updateAlign$default(this, align, anchor, i, 0, 0, 0, 56, null);
    }

    public final void updateAlign(BalloonAlign align, View anchor, int i, int i2) {
        Intrinsics.checkNotNullParameter(align, "align");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        updateAlign$default(this, align, anchor, i, i2, 0, 0, 48, null);
    }

    public final void updateAlign(BalloonAlign align, View anchor, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(align, "align");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        updateAlign$default(this, align, anchor, i, i2, i3, 0, 32, null);
    }

    public final void updateAlignBottom(View anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        updateAlignBottom$default(this, anchor, 0, 0, 0, 0, 30, null);
    }

    public final void updateAlignBottom(View anchor, int i) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        updateAlignBottom$default(this, anchor, i, 0, 0, 0, 28, null);
    }

    public final void updateAlignBottom(View anchor, int i, int i2) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        updateAlignBottom$default(this, anchor, i, i2, 0, 0, 24, null);
    }

    public final void updateAlignBottom(View anchor, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        updateAlignBottom$default(this, anchor, i, i2, i3, 0, 16, null);
    }

    public final void updateAlignEnd(View anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        updateAlignEnd$default(this, anchor, 0, 0, 0, 0, 30, null);
    }

    public final void updateAlignEnd(View anchor, int i) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        updateAlignEnd$default(this, anchor, i, 0, 0, 0, 28, null);
    }

    public final void updateAlignEnd(View anchor, int i, int i2) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        updateAlignEnd$default(this, anchor, i, i2, 0, 0, 24, null);
    }

    public final void updateAlignEnd(View anchor, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        updateAlignEnd$default(this, anchor, i, i2, i3, 0, 16, null);
    }

    public final void updateAlignStart(View anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        updateAlignStart$default(this, anchor, 0, 0, 0, 0, 30, null);
    }

    public final void updateAlignStart(View anchor, int i) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        updateAlignStart$default(this, anchor, i, 0, 0, 0, 28, null);
    }

    public final void updateAlignStart(View anchor, int i, int i2) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        updateAlignStart$default(this, anchor, i, i2, 0, 0, 24, null);
    }

    public final void updateAlignStart(View anchor, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        updateAlignStart$default(this, anchor, i, i2, i3, 0, 16, null);
    }

    public final void updateAlignTop(View anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        updateAlignTop$default(this, anchor, 0, 0, 0, 0, 30, null);
    }

    public final void updateAlignTop(View anchor, int i) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        updateAlignTop$default(this, anchor, i, 0, 0, 0, 28, null);
    }

    public final void updateAlignTop(View anchor, int i, int i2) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        updateAlignTop$default(this, anchor, i, i2, 0, 0, 24, null);
    }

    public final void updateAlignTop(View anchor, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        updateAlignTop$default(this, anchor, i, i2, i3, 0, 16, null);
    }

    private Balloon(Context context, Builder builder) {
        this.context = context;
        this.builder = builder;
        BalloonLayoutBodyBinding balloonLayoutBodyBindingInflate = BalloonLayoutBodyBinding.inflate(LayoutInflater.from(context), null, false);
        Intrinsics.checkNotNullExpressionValue(balloonLayoutBodyBindingInflate, "inflate(...)");
        this.binding = balloonLayoutBodyBindingInflate;
        BalloonLayoutOverlayBinding balloonLayoutOverlayBindingInflate = BalloonLayoutOverlayBinding.inflate(LayoutInflater.from(context), null, false);
        Intrinsics.checkNotNullExpressionValue(balloonLayoutOverlayBindingInflate, "inflate(...)");
        this.overlayBinding = balloonLayoutOverlayBindingInflate;
        this.bodyWindow = new PopupWindow(balloonLayoutBodyBindingInflate.getRoot(), -2, -2);
        this.overlayWindow = new PopupWindow(balloonLayoutOverlayBindingInflate.getRoot(), -1, -1);
        this.onBalloonInitializedListener = builder.getOnBalloonInitializedListener();
        this.handler = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Balloon$$ExternalSyntheticLambda6());
        this.autoDismissRunnable = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Balloon$$ExternalSyntheticLambda7(this));
        this.balloonPersistence = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Balloon$$ExternalSyntheticLambda8(this));
        createByBuilder();
    }

    public final PopupWindow getBodyWindow() {
        return this.bodyWindow;
    }

    public final PopupWindow getOverlayWindow() {
        return this.overlayWindow;
    }

    public final BalloonAlign getCurrentAlign() {
        return this.currentAlign;
    }

    /* JADX INFO: renamed from: isShowing, reason: from getter */
    public final boolean getIsShowing() {
        return this.isShowing;
    }

    private final Handler getHandler() {
        return (Handler) this.handler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler handler_delegate$lambda$0() {
        return new Handler(Looper.getMainLooper());
    }

    private final AutoDismissRunnable getAutoDismissRunnable() {
        return (AutoDismissRunnable) this.autoDismissRunnable.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AutoDismissRunnable autoDismissRunnable_delegate$lambda$1(Balloon balloon) {
        return new AutoDismissRunnable(balloon);
    }

    private final BalloonPersistence getBalloonPersistence() {
        return (BalloonPersistence) this.balloonPersistence.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BalloonPersistence balloonPersistence_delegate$lambda$2(Balloon balloon) {
        return BalloonPersistence.INSTANCE.getInstance(balloon.context);
    }

    private final void createByBuilder() {
        Lifecycle lifecycle;
        initializeBackground();
        initializeBalloonRoot();
        initializeBalloonWindow();
        initializeBalloonLayout();
        initializeBalloonContent();
        initializeBalloonOverlay();
        initializeBalloonListeners();
        FrameLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        adjustFitsSystemWindows(root);
        if (this.builder.getLifecycleOwner() == null) {
            Object obj = this.context;
            if (obj instanceof LifecycleOwner) {
                this.builder.setLifecycleOwner((LifecycleOwner) obj);
                Lifecycle lifecycle2 = ((LifecycleOwner) this.context).getLifecycle();
                Balloon lifecycleObserver = this.builder.getLifecycleObserver();
                if (lifecycleObserver == null) {
                    lifecycleObserver = this;
                }
                lifecycle2.addObserver(lifecycleObserver);
                return;
            }
        }
        LifecycleOwner lifecycleOwner = this.builder.getLifecycleOwner();
        if (lifecycleOwner == null || (lifecycle = lifecycleOwner.getLifecycle()) == null) {
            return;
        }
        Balloon lifecycleObserver2 = this.builder.getLifecycleObserver();
        if (lifecycleObserver2 == null) {
            lifecycleObserver2 = this;
        }
        lifecycle.addObserver(lifecycleObserver2);
    }

    private final void adjustFitsSystemWindows(ViewGroup parent) {
        parent.setFitsSystemWindows(false);
        IntRange intRangeUntil = RangesKt.until(0, parent.getChildCount());
        ArrayList<View> arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
        Iterator<Integer> it = intRangeUntil.iterator();
        while (it.hasNext()) {
            arrayList.add(parent.getChildAt(((IntIterator) it).nextInt()));
        }
        for (View view : arrayList) {
            view.setFitsSystemWindows(false);
            if (view instanceof ViewGroup) {
                adjustFitsSystemWindows((ViewGroup) view);
            }
        }
    }

    private final float getMinArrowPosition() {
        return (this.builder.getArrowSize() * this.builder.getArrowAlignAnchorPaddingRatio()) + this.builder.getArrowAlignAnchorPadding();
    }

    private final int getDoubleArrowSize() {
        return this.builder.getArrowSize() * 2;
    }

    private final void initializeArrow(View anchor) {
        ImageView imageView = this.binding.balloonArrow;
        imageView.setLayoutParams(new FrameLayout.LayoutParams(this.builder.getArrowSize(), this.builder.getArrowSize()));
        imageView.setAlpha(this.builder.getAlpha());
        Drawable arrowDrawable = this.builder.getArrowDrawable();
        if (arrowDrawable != null) {
            imageView.setImageDrawable(arrowDrawable);
        }
        imageView.setPadding(this.builder.getArrowLeftPadding(), this.builder.getArrowTopPadding(), this.builder.getArrowRightPadding(), this.builder.getArrowBottomPadding());
        if (this.builder.getArrowColor() != Integer.MIN_VALUE) {
            ImageViewCompat.setImageTintList(imageView, ColorStateList.valueOf(this.builder.getArrowColor()));
        } else {
            ImageViewCompat.setImageTintList(imageView, ColorStateList.valueOf(this.builder.getBackgroundColor()));
        }
        imageView.setOutlineProvider(ViewOutlineProvider.BOUNDS);
        this.binding.balloonCard.post(new Balloon$$ExternalSyntheticLambda1(this, anchor, imageView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initializeArrow$lambda$7$lambda$6(Balloon balloon, View view, ImageView imageView) {
        OnBalloonInitializedListener onBalloonInitializedListener = balloon.onBalloonInitializedListener;
        if (onBalloonInitializedListener != null) {
            onBalloonInitializedListener.onBalloonInitialized(balloon.getContentView());
        }
        balloon.adjustArrowOrientationByRules(view);
        balloon.updateArrow(view);
        Intrinsics.checkNotNull(imageView);
        ViewExtensionKt.visible(imageView, balloon.builder.getIsVisibleArrow());
    }

    private final void updateArrow(View anchor) {
        ImageView imageView = this.binding.balloonArrow;
        int i = WhenMappings.$EnumSwitchMapping$0[ArrowOrientation.INSTANCE.getRTLSupportOrientation$balloon_release(this.builder.getArrowOrientation(), this.builder.getIsRtlLayout()).ordinal()];
        if (i == 1) {
            imageView.setRotation(180.0f);
            imageView.setX(getArrowConstraintPositionX(anchor));
            imageView.setY((this.binding.balloonCard.getY() + this.binding.balloonCard.getHeight()) - 1);
            ViewCompat.setElevation(imageView, this.builder.getArrowElevation());
            Intrinsics.checkNotNull(imageView);
            imageView.setForeground(getArrowForeground(imageView, imageView.getX(), this.binding.balloonCard.getHeight()));
            return;
        }
        if (i == 2) {
            imageView.setRotation(0.0f);
            imageView.setX(getArrowConstraintPositionX(anchor));
            imageView.setY((this.binding.balloonCard.getY() - this.builder.getArrowSize()) + 1);
            Intrinsics.checkNotNull(imageView);
            imageView.setForeground(getArrowForeground(imageView, imageView.getX(), 0.0f));
            return;
        }
        if (i == 3) {
            imageView.setRotation(-90.0f);
            imageView.setX((this.binding.balloonCard.getX() - this.builder.getArrowSize()) + 1);
            imageView.setY(getArrowConstraintPositionY(anchor));
            Intrinsics.checkNotNull(imageView);
            imageView.setForeground(getArrowForeground(imageView, 0.0f, imageView.getY()));
            return;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        imageView.setRotation(90.0f);
        imageView.setX((this.binding.balloonCard.getX() + this.binding.balloonCard.getWidth()) - 1);
        imageView.setY(getArrowConstraintPositionY(anchor));
        Intrinsics.checkNotNull(imageView);
        imageView.setForeground(getArrowForeground(imageView, this.binding.balloonCard.getWidth(), imageView.getY()));
    }

    private final BitmapDrawable getArrowForeground(ImageView imageView, float f, float f2) {
        if (this.builder.getArrowColorMatchBalloon() && GlobalExtensionKt.isAPILevelHigherThan23()) {
            return new BitmapDrawable(imageView.getResources(), adjustArrowColorByMatchingCardBackground(imageView, f, f2));
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x00a8  */
    private final Bitmap adjustArrowColorByMatchingCardBackground(ImageView imageView, float x, float y) {
        LinearGradient linearGradient;
        imageView.setColorFilter(this.builder.getBackgroundColor(), PorterDuff.Mode.SRC_IN);
        Drawable drawable = imageView.getDrawable();
        Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(...)");
        Bitmap bitmapDrawableToBitmap = drawableToBitmap(drawable, imageView.getDrawable().getIntrinsicWidth(), imageView.getDrawable().getIntrinsicHeight());
        try {
            Pair<Integer, Integer> colorsFromBalloonCard = getColorsFromBalloonCard(x, y);
            int iIntValue = colorsFromBalloonCard.getFirst().intValue();
            int iIntValue2 = colorsFromBalloonCard.getSecond().intValue();
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDrawableToBitmap.getWidth(), bitmapDrawableToBitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            canvas.drawBitmap(bitmapDrawableToBitmap, 0.0f, 0.0f, (Paint) null);
            Paint paint = new Paint();
            int i = WhenMappings.$EnumSwitchMapping$0[this.builder.getArrowOrientation().ordinal()];
            if (i == 1) {
                linearGradient = new LinearGradient((bitmapDrawableToBitmap.getWidth() / 2) - (this.builder.getArrowSize() * 0.5f), 0.0f, bitmapDrawableToBitmap.getWidth(), 0.0f, iIntValue, iIntValue2, Shader.TileMode.CLAMP);
            } else {
                if (i != 2) {
                    if (i == 3) {
                        linearGradient = new LinearGradient((bitmapDrawableToBitmap.getWidth() / 2) - (this.builder.getArrowSize() * 0.5f), 0.0f, bitmapDrawableToBitmap.getWidth(), 0.0f, iIntValue, iIntValue2, Shader.TileMode.CLAMP);
                    } else if (i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                linearGradient = new LinearGradient((bitmapDrawableToBitmap.getWidth() / 2) + (this.builder.getArrowSize() * 0.5f), 0.0f, 0.0f, 0.0f, iIntValue, iIntValue2, Shader.TileMode.CLAMP);
            }
            paint.setShader(linearGradient);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawRect(0.0f, 0.0f, bitmapDrawableToBitmap.getWidth(), bitmapDrawableToBitmap.getHeight(), paint);
            imageView.setColorFilter(0, PorterDuff.Mode.SRC_IN);
            return bitmapCreateBitmap;
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException("Arrow attached outside balloon. Could not get a matching color.");
        }
    }

    private final Pair<Integer, Integer> getColorsFromBalloonCard(float x, float y) {
        int pixel;
        int pixel2;
        Drawable background = this.binding.balloonCard.getBackground();
        Intrinsics.checkNotNullExpressionValue(background, "getBackground(...)");
        Bitmap bitmapDrawableToBitmap = drawableToBitmap(background, this.binding.balloonCard.getWidth() + 1, this.binding.balloonCard.getHeight() + 1);
        int i = WhenMappings.$EnumSwitchMapping$0[this.builder.getArrowOrientation().ordinal()];
        if (i == 1 || i == 2) {
            int i2 = (int) y;
            pixel = bitmapDrawableToBitmap.getPixel((int) ((this.builder.getArrowSize() * 0.5f) + x), i2);
            pixel2 = bitmapDrawableToBitmap.getPixel((int) (x - (this.builder.getArrowSize() * 0.5f)), i2);
        } else {
            if (i != 3 && i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            int i3 = (int) x;
            pixel = bitmapDrawableToBitmap.getPixel(i3, (int) ((this.builder.getArrowSize() * 0.5f) + y));
            pixel2 = bitmapDrawableToBitmap.getPixel(i3, (int) (y - (this.builder.getArrowSize() * 0.5f)));
        }
        return new Pair<>(Integer.valueOf(pixel), Integer.valueOf(pixel2));
    }

    private final Bitmap drawableToBitmap(Drawable drawable, int width, int height) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    private final void adjustArrowOrientationByRules(View anchor) {
        if (this.builder.getArrowOrientationRules() == ArrowOrientationRules.ALIGN_FIXED) {
            return;
        }
        Rect rect = new Rect();
        anchor.getGlobalVisibleRect(rect);
        int[] iArr = {0, 0};
        this.bodyWindow.getContentView().getLocationOnScreen(iArr);
        if (this.builder.getArrowOrientation() == ArrowOrientation.TOP && iArr[1] < rect.bottom) {
            this.builder.setArrowOrientation(ArrowOrientation.BOTTOM);
        } else if (this.builder.getArrowOrientation() == ArrowOrientation.BOTTOM && iArr[1] > rect.top) {
            this.builder.setArrowOrientation(ArrowOrientation.TOP);
        }
        if (this.builder.getArrowOrientation() == ArrowOrientation.START && iArr[0] < rect.right) {
            this.builder.setArrowOrientation(ArrowOrientation.END);
        } else if (this.builder.getArrowOrientation() == ArrowOrientation.END && iArr[0] > rect.left) {
            this.builder.setArrowOrientation(ArrowOrientation.START);
        }
        initializeBalloonContent();
    }

    private final float getArrowConstraintPositionX(View anchor) {
        FrameLayout balloonContent = this.binding.balloonContent;
        Intrinsics.checkNotNullExpressionValue(balloonContent, "balloonContent");
        int i = ViewExtensionKt.getViewPointOnScreen(balloonContent).x;
        int i2 = ViewExtensionKt.getViewPointOnScreen(anchor).x;
        float minArrowPosition = getMinArrowPosition();
        float measuredWidth = ((getMeasuredWidth() - minArrowPosition) - this.builder.getMarginRight()) - this.builder.getMarginLeft();
        int i3 = WhenMappings.$EnumSwitchMapping$1[this.builder.getArrowPositionRules().ordinal()];
        if (i3 == 1) {
            return (this.binding.balloonWrapper.getWidth() * this.builder.getArrowPosition()) - (this.builder.getArrowSize() * 0.5f);
        }
        if (i3 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        if (anchor.getWidth() + i2 >= i) {
            if (getMeasuredWidth() + i >= i2) {
                float f = i2;
                float f2 = i;
                float width = (((anchor.getWidth() * this.builder.getArrowPosition()) + f) - f2) - (this.builder.getArrowSize() * 0.5f);
                float width2 = f + (anchor.getWidth() * this.builder.getArrowPosition());
                if (width2 - (this.builder.getArrowSize() * 0.5f) <= f2) {
                    return 0.0f;
                }
                if (width2 - (this.builder.getArrowSize() * 0.5f) > f2 && anchor.getWidth() <= (getMeasuredWidth() - this.builder.getMarginRight()) - this.builder.getMarginLeft()) {
                    return (width2 - (this.builder.getArrowSize() * 0.5f)) - f2;
                }
                if (width > getDoubleArrowSize()) {
                    if (width <= getMeasuredWidth() - getDoubleArrowSize()) {
                        return width;
                    }
                }
            }
            return measuredWidth;
        }
        return minArrowPosition;
    }

    private final float getArrowConstraintPositionY(View anchor) {
        int statusBarHeight = ViewExtensionKt.getStatusBarHeight(anchor, this.builder.getIsStatusBarVisible());
        FrameLayout balloonContent = this.binding.balloonContent;
        Intrinsics.checkNotNullExpressionValue(balloonContent, "balloonContent");
        int i = ViewExtensionKt.getViewPointOnScreen(balloonContent).y - statusBarHeight;
        int i2 = ViewExtensionKt.getViewPointOnScreen(anchor).y - statusBarHeight;
        float minArrowPosition = getMinArrowPosition();
        float measuredHeight = ((getMeasuredHeight() - minArrowPosition) - this.builder.getMarginTop()) - this.builder.getMarginBottom();
        int arrowSize = this.builder.getArrowSize() / 2;
        int i3 = WhenMappings.$EnumSwitchMapping$1[this.builder.getArrowPositionRules().ordinal()];
        if (i3 == 1) {
            return (this.binding.balloonWrapper.getHeight() * this.builder.getArrowPosition()) - arrowSize;
        }
        if (i3 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        if (anchor.getHeight() + i2 >= i) {
            if (getMeasuredHeight() + i >= i2) {
                float height = (((anchor.getHeight() * this.builder.getArrowPosition()) + i2) - i) - arrowSize;
                if (height > getDoubleArrowSize()) {
                    if (height <= getMeasuredHeight() - getDoubleArrowSize()) {
                        return height;
                    }
                }
            }
            return measuredHeight;
        }
        return minArrowPosition;
    }

    private final void initializeBackground() {
        RadiusLayout radiusLayout = this.binding.balloonCard;
        radiusLayout.setAlpha(this.builder.getAlpha());
        radiusLayout.setRadius(this.builder.getCornerRadius());
        ViewCompat.setElevation(radiusLayout, this.builder.getElevation());
        GradientDrawable backgroundDrawable = this.builder.getBackgroundDrawable();
        if (backgroundDrawable == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(this.builder.getBackgroundColor());
            gradientDrawable.setCornerRadius(this.builder.getCornerRadius());
            backgroundDrawable = gradientDrawable;
        }
        radiusLayout.setBackground(backgroundDrawable);
        radiusLayout.setPadding(this.builder.getPaddingLeft(), this.builder.getPaddingTop(), this.builder.getPaddingRight(), this.builder.getPaddingBottom());
    }

    private final void initializeBalloonWindow() {
        PopupWindow popupWindow = this.bodyWindow;
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(this.builder.getIsFocusable());
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setElevation(this.builder.getElevation());
        setIsAttachedInDecor(this.builder.getIsAttachedInDecor());
    }

    private final void initializeBalloonListeners() {
        setOnBalloonClickListener(this.builder.getOnBalloonClickListener());
        setOnBalloonDismissListener(this.builder.getOnBalloonDismissListener());
        setOnBalloonOutsideTouchListener(this.builder.getOnBalloonOutsideTouchListener());
        setOnBalloonTouchListener(this.builder.getOnBalloonTouchListener());
        setOnBalloonOverlayClickListener(this.builder.getOnBalloonOverlayClickListener());
        setOnBalloonOverlayTouchListener(this.builder.getOnBalloonOverlayTouchListener());
    }

    private final void initializeBalloonRoot() {
        ViewGroup.LayoutParams layoutParams = this.binding.balloonWrapper.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(this.builder.getMarginLeft(), this.builder.getMarginTop(), this.builder.getMarginRight(), this.builder.getMarginBottom());
    }

    private final void initializeBalloonContent() {
        int arrowSize = this.builder.getArrowSize() - 1;
        int elevation = (int) this.builder.getElevation();
        FrameLayout frameLayout = this.binding.balloonContent;
        int i = WhenMappings.$EnumSwitchMapping$0[this.builder.getArrowOrientation().ordinal()];
        if (i == 1) {
            frameLayout.setPadding(0, arrowSize, 0, RangesKt.coerceAtLeast(arrowSize, elevation));
            return;
        }
        if (i == 2) {
            frameLayout.setPadding(0, arrowSize, 0, RangesKt.coerceAtLeast(arrowSize, elevation));
        } else if (i == 3) {
            frameLayout.setPadding(arrowSize, 0, arrowSize, 0);
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            frameLayout.setPadding(arrowSize, 0, arrowSize, 0);
        }
    }

    private final void initializeIcon() {
        VectorTextView vectorTextView = this.binding.balloonText;
        IconForm iconForm = this.builder.getIconForm();
        if (iconForm != null) {
            Intrinsics.checkNotNull(vectorTextView);
            TextViewExtensionKt.applyIconForm(vectorTextView, iconForm);
        } else {
            Intrinsics.checkNotNull(vectorTextView);
            Context context = vectorTextView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            IconForm.Builder builder = new IconForm.Builder(context);
            builder.setDrawable(this.builder.getIconDrawable());
            builder.setIconWidth(this.builder.getIconWidth());
            builder.setIconHeight(this.builder.getIconHeight());
            builder.setIconColor(this.builder.getIconColor());
            builder.setIconSpace(this.builder.getIconSpace());
            builder.setDrawableGravity(this.builder.getIconGravity());
            TextViewExtensionKt.applyIconForm(vectorTextView, builder.build());
        }
        vectorTextView.isRtlSupport(this.builder.getIsRtlLayout());
    }

    private final void initializeText() {
        VectorTextView vectorTextView = this.binding.balloonText;
        TextForm textForm = this.builder.getTextForm();
        if (textForm != null) {
            Intrinsics.checkNotNull(vectorTextView);
            TextViewExtensionKt.applyTextForm(vectorTextView, textForm);
        } else {
            Intrinsics.checkNotNull(vectorTextView);
            Context context = vectorTextView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            TextForm.Builder builder = new TextForm.Builder(context);
            builder.setText(this.builder.getText());
            builder.setTextSize(this.builder.getTextSize());
            builder.setTextColor(this.builder.getTextColor());
            builder.setTextIsHtml(this.builder.getTextIsHtml());
            builder.setTextGravity(this.builder.getTextGravity());
            builder.setTextTypeface(this.builder.getTextTypeface());
            builder.setTextTypeface(this.builder.getTextTypefaceObject());
            builder.setTextLineSpacing(this.builder.getTextLineSpacing());
            builder.setTextLetterSpacing(this.builder.getTextLetterSpacing());
            vectorTextView.setMovementMethod(this.builder.getMovementMethod());
            builder.setEnableAutoSized(this.builder.getEnableAutoSized());
            builder.setMinAutoSizeTextSize(this.builder.getMinAutoSizeTextSize());
            builder.setMaxAutoSizeTextSize(this.builder.getMaxAutoSizeTextSize());
            TextViewExtensionKt.applyTextForm(vectorTextView, builder.build());
        }
        RadiusLayout balloonCard = this.binding.balloonCard;
        Intrinsics.checkNotNullExpressionValue(balloonCard, "balloonCard");
        measureTextWidth(vectorTextView, balloonCard);
    }

    private final void initializeBalloonLayout() {
        if (hasCustomLayout()) {
            initializeCustomLayout();
        } else {
            initializeIcon();
            initializeText();
        }
    }

    private final boolean hasCustomLayout() {
        return (this.builder.getLayoutRes() == null && this.builder.getLayout() == null) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0057  */
    /* JADX WARN: Code duplicated, block: B:6:0x0021  */
    private final void initializeCustomLayout() {
        View layout;
        Integer layoutRes = this.builder.getLayoutRes();
        if (layoutRes != null) {
            layout = LayoutInflater.from(this.context).inflate(layoutRes.intValue(), (ViewGroup) this.binding.balloonCard, false);
            if (layout == null) {
                layout = this.builder.getLayout();
                if (layout == null) {
                    throw new IllegalArgumentException("The custom layout is null.");
                }
            }
        } else {
            layout = this.builder.getLayout();
            if (layout == null) {
                throw new IllegalArgumentException("The custom layout is null.");
            }
        }
        ViewParent parent = layout.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(layout);
        }
        this.binding.balloonCard.removeAllViews();
        this.binding.balloonCard.addView(layout);
        RadiusLayout balloonCard = this.binding.balloonCard;
        Intrinsics.checkNotNullExpressionValue(balloonCard, "balloonCard");
        traverseAndMeasureTextWidth(balloonCard);
    }

    private final void initializeBalloonOverlay() {
        if (this.builder.getIsVisibleOverlay()) {
            BalloonAnchorOverlayView balloonAnchorOverlayView = this.overlayBinding.balloonOverlayView;
            balloonAnchorOverlayView.setOverlayColor(this.builder.getOverlayColor());
            balloonAnchorOverlayView.setOverlayPadding(this.builder.getOverlayPadding());
            balloonAnchorOverlayView.setOverlayPosition(this.builder.getOverlayPosition());
            balloonAnchorOverlayView.setBalloonOverlayShape(this.builder.getOverlayShape());
            balloonAnchorOverlayView.setOverlayPaddingColor(this.builder.getOverlayPaddingColor());
            balloonAnchorOverlayView.setOverlayPaddingShader(this.builder.getOverlayPaddingShader());
            this.overlayWindow.setClippingEnabled(false);
        }
    }

    private final void applyBalloonAnimation() {
        if (this.builder.getBalloonAnimationStyle() == Integer.MIN_VALUE) {
            int i = WhenMappings.$EnumSwitchMapping$2[this.builder.getBalloonAnimation().ordinal()];
            if (i == 1) {
                this.bodyWindow.setAnimationStyle(R.style.Balloon_Elastic_Anim);
                return;
            }
            if (i == 2) {
                View contentView = this.bodyWindow.getContentView();
                Intrinsics.checkNotNullExpressionValue(contentView, "getContentView(...)");
                ViewExtensionKt.circularRevealed(contentView, this.builder.getCircularDuration());
                this.bodyWindow.setAnimationStyle(R.style.Balloon_Normal_Dispose_Anim);
                return;
            }
            if (i == 3) {
                this.bodyWindow.setAnimationStyle(R.style.Balloon_Fade_Anim);
                return;
            } else if (i == 4) {
                this.bodyWindow.setAnimationStyle(R.style.Balloon_Overshoot_Anim);
                return;
            } else {
                if (i != 5) {
                    throw new NoWhenBranchMatchedException();
                }
                this.bodyWindow.setAnimationStyle(R.style.Balloon_None_Anim);
                return;
            }
        }
        this.bodyWindow.setAnimationStyle(this.builder.getBalloonAnimationStyle());
    }

    private final void applyBalloonOverlayAnimation() {
        if (this.builder.getBalloonOverlayAnimationStyle() == Integer.MIN_VALUE) {
            if (WhenMappings.$EnumSwitchMapping$3[this.builder.getBalloonOverlayAnimation().ordinal()] == 1) {
                this.overlayWindow.setAnimationStyle(R.style.Balloon_Fade_Anim);
                return;
            } else {
                this.overlayWindow.setAnimationStyle(R.style.Balloon_Normal_Anim);
                return;
            }
        }
        this.overlayWindow.setAnimationStyle(this.builder.getBalloonAnimationStyle());
    }

    private final Animation getBalloonHighlightAnimation() {
        int balloonHighlightAnimationStyle;
        if (this.builder.getBalloonHighlightAnimationStyle() == Integer.MIN_VALUE) {
            int i = WhenMappings.$EnumSwitchMapping$4[this.builder.getBalloonHighlightAnimation().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    int i2 = WhenMappings.$EnumSwitchMapping$0[this.builder.getArrowOrientation().ordinal()];
                    if (i2 == 1) {
                        balloonHighlightAnimationStyle = R.anim.balloon_shake_top;
                    } else if (i2 == 2) {
                        balloonHighlightAnimationStyle = R.anim.balloon_shake_bottom;
                    } else if (i2 == 3) {
                        balloonHighlightAnimationStyle = R.anim.balloon_shake_right;
                    } else {
                        if (i2 != 4) {
                            throw new NoWhenBranchMatchedException();
                        }
                        balloonHighlightAnimationStyle = R.anim.balloon_shake_left;
                    }
                } else {
                    if (i != 3) {
                        if (i != 4) {
                            return null;
                        }
                        return this.builder.getBalloonRotateAnimation();
                    }
                    balloonHighlightAnimationStyle = R.anim.balloon_fade;
                }
            } else if (this.builder.getIsVisibleArrow()) {
                int i3 = WhenMappings.$EnumSwitchMapping$0[this.builder.getArrowOrientation().ordinal()];
                if (i3 == 1) {
                    balloonHighlightAnimationStyle = R.anim.balloon_heartbeat_top;
                } else if (i3 == 2) {
                    balloonHighlightAnimationStyle = R.anim.balloon_heartbeat_bottom;
                } else if (i3 == 3) {
                    balloonHighlightAnimationStyle = R.anim.balloon_heartbeat_right;
                } else {
                    if (i3 != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    balloonHighlightAnimationStyle = R.anim.balloon_heartbeat_left;
                }
            } else {
                balloonHighlightAnimationStyle = R.anim.balloon_heartbeat_center;
            }
        } else {
            balloonHighlightAnimationStyle = this.builder.getBalloonHighlightAnimationStyle();
        }
        return AnimationUtils.loadAnimation(this.context, balloonHighlightAnimationStyle);
    }

    private final void startBalloonHighlightAnimation() {
        this.binding.balloon.post(new Balloon$$ExternalSyntheticLambda11(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startBalloonHighlightAnimation$lambda$28(Balloon balloon) {
        new Handler(Looper.getMainLooper()).postDelayed(new Balloon$$ExternalSyntheticLambda12(balloon), balloon.builder.getBalloonHighlightAnimationStartDelay());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startBalloonHighlightAnimation$lambda$28$lambda$27(Balloon balloon) {
        Animation balloonHighlightAnimation = balloon.getBalloonHighlightAnimation();
        if (balloonHighlightAnimation != null) {
            balloon.binding.balloon.startAnimation(balloonHighlightAnimation);
        }
    }

    private final void stopBalloonHighlightAnimation() {
        FrameLayout frameLayout = this.binding.balloon;
        Animation animation = frameLayout.getAnimation();
        if (animation != null) {
            animation.cancel();
            animation.reset();
        }
        frameLayout.clearAnimation();
    }

    public final boolean shouldShowUp() {
        String preferenceName = this.builder.getPreferenceName();
        if (preferenceName != null) {
            return getBalloonPersistence().shouldShowUp(preferenceName, this.builder.getShowTimes());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void show(BalloonPlacement placement) {
        View anchor = placement.getAnchor();
        if (canShowBalloonWindow(anchor)) {
            anchor.post(new Balloon$$ExternalSyntheticLambda2(this, anchor, placement));
        } else if (this.builder.getDismissWhenShowAgain()) {
            dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$34(Balloon balloon, View view, BalloonPlacement balloonPlacement) {
        Boolean boolValueOf = Boolean.valueOf(balloon.canShowBalloonWindow(view));
        if (!boolValueOf.booleanValue()) {
            boolValueOf = null;
        }
        if (boolValueOf != null) {
            boolValueOf.booleanValue();
            String preferenceName = balloon.builder.getPreferenceName();
            if (preferenceName != null) {
                if (balloon.getBalloonPersistence().shouldShowUp(preferenceName, balloon.builder.getShowTimes())) {
                    balloon.getBalloonPersistence().putIncrementedCounts(preferenceName);
                } else {
                    Function0<Unit> runIfReachedShowCounts = balloon.builder.getRunIfReachedShowCounts();
                    if (runIfReachedShowCounts != null) {
                        runIfReachedShowCounts.invoke();
                        return;
                    }
                    return;
                }
            }
            balloon.isShowing = true;
            balloon.currentAlign = balloonPlacement.getAlign();
            long autoDismissDuration = balloon.builder.getAutoDismissDuration();
            if (autoDismissDuration != -1) {
                balloon.dismissWithDelay(autoDismissDuration);
            }
            if (balloon.hasCustomLayout()) {
                RadiusLayout balloonCard = balloon.binding.balloonCard;
                Intrinsics.checkNotNullExpressionValue(balloonCard, "balloonCard");
                balloon.traverseAndMeasureTextWidth(balloonCard);
            } else {
                VectorTextView balloonText = balloon.binding.balloonText;
                Intrinsics.checkNotNullExpressionValue(balloonText, "balloonText");
                RadiusLayout balloonCard2 = balloon.binding.balloonCard;
                Intrinsics.checkNotNullExpressionValue(balloonCard2, "balloonCard");
                balloon.measureTextWidth(balloonText, balloonCard2);
            }
            balloon.binding.getRoot().measure(0, 0);
            balloon.bodyWindow.setWidth(balloon.getMeasuredWidth());
            balloon.bodyWindow.setHeight(balloon.getMeasuredHeight());
            balloon.binding.balloonText.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            balloon.initializeArrow(view);
            balloon.initializeBalloonContent();
            balloon.applyBalloonOverlayAnimation();
            balloon.showOverlayWindow(view, balloonPlacement.getSubAnchors());
            balloon.passTouchEventToAnchor(view);
            balloon.applyBalloonAnimation();
            balloon.startBalloonHighlightAnimation();
            Pair<Integer, Integer> pairCalculateOffset = balloon.calculateOffset(balloonPlacement);
            balloon.bodyWindow.showAsDropDown(view, pairCalculateOffset.component1().intValue(), pairCalculateOffset.component2().intValue());
        }
    }

    private final Pair<Integer, Integer> calculateOffset(BalloonPlacement placement) {
        int i = WhenMappings.$EnumSwitchMapping$5[placement.getType().ordinal()];
        if (i == 1) {
            return TuplesKt.to(Integer.valueOf(placement.getXOff()), Integer.valueOf(placement.getYOff()));
        }
        if (i == 2) {
            return calculateAlignOffset(placement);
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return calculateCenterOffset(placement);
    }

    private final Pair<Integer, Integer> calculateAlignOffset(BalloonPlacement placement) {
        View anchor = placement.getAnchor();
        int iRoundToInt = MathKt.roundToInt(anchor.getMeasuredWidth() * 0.5f);
        int iRoundToInt2 = MathKt.roundToInt(anchor.getMeasuredHeight() * 0.5f);
        int iRoundToInt3 = MathKt.roundToInt(getMeasuredWidth() * 0.5f);
        int iRoundToInt4 = MathKt.roundToInt(getMeasuredHeight() * 0.5f);
        int xOff = placement.getXOff();
        int yOff = placement.getYOff();
        int i = WhenMappings.$EnumSwitchMapping$6[placement.getAlign().ordinal()];
        if (i == 1) {
            return TuplesKt.to(Integer.valueOf(this.builder.getSupportRtlLayoutFactor() * ((iRoundToInt - iRoundToInt3) + xOff)), Integer.valueOf((-(getMeasuredHeight() + anchor.getMeasuredHeight())) + yOff));
        }
        if (i == 2) {
            return TuplesKt.to(Integer.valueOf(this.builder.getSupportRtlLayoutFactor() * ((iRoundToInt - iRoundToInt3) + xOff)), Integer.valueOf(yOff));
        }
        if (i == 3) {
            return TuplesKt.to(Integer.valueOf(this.builder.getSupportRtlLayoutFactor() * ((-getMeasuredWidth()) + xOff)), Integer.valueOf((-(iRoundToInt4 + iRoundToInt2)) + yOff));
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return TuplesKt.to(Integer.valueOf(this.builder.getSupportRtlLayoutFactor() * (anchor.getMeasuredWidth() + xOff)), Integer.valueOf((-(iRoundToInt4 + iRoundToInt2)) + yOff));
    }

    private final Pair<Integer, Integer> calculateCenterOffset(BalloonPlacement placement) {
        View anchor = placement.getAnchor();
        int iRoundToInt = MathKt.roundToInt(anchor.getMeasuredWidth() * 0.5f);
        int iRoundToInt2 = MathKt.roundToInt(anchor.getMeasuredHeight() * 0.5f);
        int iRoundToInt3 = MathKt.roundToInt(getMeasuredWidth() * 0.5f);
        int iRoundToInt4 = MathKt.roundToInt(getMeasuredHeight() * 0.5f);
        int xOff = placement.getXOff();
        int yOff = placement.getYOff();
        int i = WhenMappings.$EnumSwitchMapping$6[placement.getAlign().ordinal()];
        if (i == 1) {
            return TuplesKt.to(Integer.valueOf(this.builder.getSupportRtlLayoutFactor() * ((iRoundToInt - iRoundToInt3) + xOff)), Integer.valueOf((-(getMeasuredHeight() + iRoundToInt2)) + yOff));
        }
        if (i == 2) {
            return TuplesKt.to(Integer.valueOf(this.builder.getSupportRtlLayoutFactor() * ((iRoundToInt - iRoundToInt3) + xOff)), Integer.valueOf((-iRoundToInt2) + yOff));
        }
        if (i == 3) {
            return TuplesKt.to(Integer.valueOf(this.builder.getSupportRtlLayoutFactor() * ((iRoundToInt - getMeasuredWidth()) + xOff)), Integer.valueOf(((-iRoundToInt4) - iRoundToInt2) + yOff));
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return TuplesKt.to(Integer.valueOf(this.builder.getSupportRtlLayoutFactor() * (iRoundToInt + xOff)), Integer.valueOf(((-iRoundToInt4) - iRoundToInt2) + yOff));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean canShowBalloonWindow(View anchor) {
        if (this.isShowing || this.destroyed) {
            return false;
        }
        Context context = this.context;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if ((activity == null || !activity.isFinishing()) && this.bodyWindow.getContentView().getParent() == null && anchor.isAttachedToWindow()) {
            return anchor.getWindowToken().isBinderAlive();
        }
        return false;
    }

    private final void showOverlayWindow(View anchor, List<? extends View> subAnchors) {
        if (this.builder.getIsVisibleOverlay()) {
            if (subAnchors.isEmpty()) {
                this.overlayBinding.balloonOverlayView.setAnchorView(anchor);
            } else {
                this.overlayBinding.balloonOverlayView.setAnchorViewList(CollectionsKt.plus((Collection<? extends View>) subAnchors, anchor));
            }
            this.overlayWindow.showAtLocation(anchor, this.builder.getOverlayGravity(), 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitBalloon(BalloonPlacement balloonPlacement, Continuation<? super Unit> continuation) {
        Companion companion = INSTANCE;
        companion.initConsumerIfNeeded();
        Object objSend = companion.getChannel().send(new DeferredBalloonGroup(CollectionsKt.listOf(new DeferredBalloon(this, balloonPlacement)), true), continuation);
        return objSend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSend : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.skydoves.balloon.Balloon$relay$1, reason: invalid class name */
    /* JADX INFO: compiled from: Balloon.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1 implements Function0<Unit> {
        final /* synthetic */ Balloon $balloon;
        final /* synthetic */ Function1<Balloon, Unit> $block;
        final /* synthetic */ OnBalloonDismissListener $previousListener;
        final /* synthetic */ Balloon this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(OnBalloonDismissListener onBalloonDismissListener, Balloon balloon, Function1<? super Balloon, Unit> function1, Balloon balloon2) {
            this.$previousListener = onBalloonDismissListener;
            this.this$0 = balloon;
            this.$block = function1;
            this.$balloon = balloon2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            OnBalloonDismissListener onBalloonDismissListener = this.$previousListener;
            if (onBalloonDismissListener != null) {
                onBalloonDismissListener.onBalloonDismiss();
            }
            if (this.this$0.destroyed) {
                return;
            }
            this.$block.invoke(this.$balloon);
        }
    }

    private final Balloon relay(Balloon balloon, Function1<? super Balloon, Unit> block) {
        setOnBalloonDismissListener(new AnonymousClass1(balloon.builder.getOnBalloonDismissListener(), this, block, balloon));
        return balloon;
    }

    public static /* synthetic */ void showAtCenter$default(Balloon balloon, View view, int i, int i2, BalloonCenterAlign balloonCenterAlign, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        if ((i3 & 8) != 0) {
            balloonCenterAlign = BalloonCenterAlign.TOP;
        }
        balloon.showAtCenter(view, i, i2, balloonCenterAlign);
    }

    public final void showAtCenter(View anchor, int xOff, int yOff, BalloonCenterAlign centerAlign) {
        BalloonAlign balloonAlign;
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        Intrinsics.checkNotNullParameter(centerAlign, "centerAlign");
        PlacementType placementType = PlacementType.CENTER;
        int i = WhenMappings.$EnumSwitchMapping$7[centerAlign.ordinal()];
        if (i == 1) {
            balloonAlign = BalloonAlign.TOP;
        } else if (i == 2) {
            balloonAlign = BalloonAlign.BOTTOM;
        } else if (i == 3) {
            balloonAlign = BalloonAlign.START;
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            balloonAlign = BalloonAlign.END;
        }
        show(new BalloonPlacement(anchor, null, balloonAlign, xOff, yOff, placementType, 0, 0, 194, null));
    }

    public static /* synthetic */ Object awaitAtCenter$default(Balloon balloon, View view, int i, int i2, BalloonCenterAlign balloonCenterAlign, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        if ((i3 & 8) != 0) {
            balloonCenterAlign = BalloonCenterAlign.TOP;
        }
        return balloon.awaitAtCenter(view, i, i2, balloonCenterAlign, continuation);
    }

    public final Object awaitAtCenter(View view, int i, int i2, BalloonCenterAlign balloonCenterAlign, Continuation<? super Unit> continuation) {
        Object objAwaitBalloon = awaitBalloon(new BalloonPlacement(view, null, balloonCenterAlign.toAlign(), i, i2, PlacementType.CENTER, 0, 0, 194, null), continuation);
        return objAwaitBalloon == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitBalloon : Unit.INSTANCE;
    }

    public static /* synthetic */ Balloon relayShowAtCenter$default(Balloon balloon, Balloon balloon2, View view, int i, int i2, BalloonCenterAlign balloonCenterAlign, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        if ((i3 & 16) != 0) {
            balloonCenterAlign = BalloonCenterAlign.TOP;
        }
        return balloon.relayShowAtCenter(balloon2, view, i, i2, balloonCenterAlign);
    }

    public static /* synthetic */ void showAsDropDown$default(Balloon balloon, View view, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        balloon.showAsDropDown(view, i, i2);
    }

    public final void showAsDropDown(View anchor, int xOff, int yOff) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        show(new BalloonPlacement(anchor, null, null, xOff, yOff, PlacementType.DROPDOWN, 0, 0, 198, null));
    }

    public static /* synthetic */ Object awaitAsDropDown$default(Balloon balloon, View view, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return balloon.awaitAsDropDown(view, i, i2, continuation);
    }

    public final Object awaitAsDropDown(View view, int i, int i2, Continuation<? super Unit> continuation) {
        Object objAwaitBalloon = awaitBalloon(new BalloonPlacement(view, null, null, i, i2, PlacementType.DROPDOWN, 0, 0, 198, null), continuation);
        return objAwaitBalloon == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitBalloon : Unit.INSTANCE;
    }

    public static /* synthetic */ Balloon relayShowAsDropDown$default(Balloon balloon, Balloon balloon2, View view, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return balloon.relayShowAsDropDown(balloon2, view, i, i2);
    }

    public static /* synthetic */ void showAlignTop$default(Balloon balloon, View view, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        balloon.showAlignTop(view, i, i2);
    }

    public final void showAlignTop(View anchor, int xOff, int yOff) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        show(new BalloonPlacement(anchor, null, BalloonAlign.TOP, xOff, yOff, null, 0, 0, 226, null));
    }

    public static /* synthetic */ Object awaitAlignTop$default(Balloon balloon, View view, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return balloon.awaitAlignTop(view, i, i2, continuation);
    }

    public final Object awaitAlignTop(View view, int i, int i2, Continuation<? super Unit> continuation) {
        Object objAwaitBalloon = awaitBalloon(new BalloonPlacement(view, null, BalloonAlign.TOP, i, i2, null, 0, 0, 226, null), continuation);
        return objAwaitBalloon == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitBalloon : Unit.INSTANCE;
    }

    public static /* synthetic */ Balloon relayShowAlignTop$default(Balloon balloon, Balloon balloon2, View view, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return balloon.relayShowAlignTop(balloon2, view, i, i2);
    }

    public static /* synthetic */ void showAlignBottom$default(Balloon balloon, View view, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        balloon.showAlignBottom(view, i, i2);
    }

    public final void showAlignBottom(View anchor, int xOff, int yOff) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        show(new BalloonPlacement(anchor, null, BalloonAlign.BOTTOM, xOff, yOff, null, 0, 0, 226, null));
    }

    public static /* synthetic */ Object awaitAlignBottom$default(Balloon balloon, View view, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return balloon.awaitAlignBottom(view, i, i2, continuation);
    }

    public final Object awaitAlignBottom(View view, int i, int i2, Continuation<? super Unit> continuation) {
        Object objAwaitBalloon = awaitBalloon(new BalloonPlacement(view, null, BalloonAlign.BOTTOM, i, i2, null, 0, 0, 226, null), continuation);
        return objAwaitBalloon == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitBalloon : Unit.INSTANCE;
    }

    public static /* synthetic */ Balloon relayShowAlignBottom$default(Balloon balloon, Balloon balloon2, View view, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return balloon.relayShowAlignBottom(balloon2, view, i, i2);
    }

    public static /* synthetic */ void showAlignRight$default(Balloon balloon, View view, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        balloon.showAlignRight(view, i, i2);
    }

    @Deprecated(message = "Use showAlignEnd instead.", replaceWith = @ReplaceWith(expression = "showAlignEnd(anchor, xOff, yOff)", imports = {}))
    public final void showAlignRight(View anchor, int xOff, int yOff) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        show(new BalloonPlacement(anchor, null, BalloonAlign.END, xOff, yOff, null, 0, 0, 226, null));
    }

    public static /* synthetic */ void showAlignEnd$default(Balloon balloon, View view, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        balloon.showAlignEnd(view, i, i2);
    }

    public final void showAlignEnd(View anchor, int xOff, int yOff) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        show(new BalloonPlacement(anchor, null, BalloonAlign.END, xOff, yOff, null, 0, 0, 226, null));
    }

    public static /* synthetic */ Object awaitAlignEnd$default(Balloon balloon, View view, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return balloon.awaitAlignEnd(view, i, i2, continuation);
    }

    public final Object awaitAlignEnd(View view, int i, int i2, Continuation<? super Unit> continuation) {
        Object objAwaitBalloon = awaitBalloon(new BalloonPlacement(view, null, BalloonAlign.END, i, i2, null, 0, 0, 226, null), continuation);
        return objAwaitBalloon == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitBalloon : Unit.INSTANCE;
    }

    public static /* synthetic */ Balloon relayShowAlignRight$default(Balloon balloon, Balloon balloon2, View view, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return balloon.relayShowAlignRight(balloon2, view, i, i2);
    }

    public static /* synthetic */ Balloon relayShowAlignEnd$default(Balloon balloon, Balloon balloon2, View view, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return balloon.relayShowAlignEnd(balloon2, view, i, i2);
    }

    public static /* synthetic */ void showAlignLeft$default(Balloon balloon, View view, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        balloon.showAlignLeft(view, i, i2);
    }

    @Deprecated(message = "Use showAlignStart instead.", replaceWith = @ReplaceWith(expression = "showAlignStart(anchor, xOff, yOff)", imports = {}))
    public final void showAlignLeft(View anchor, int xOff, int yOff) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        show(new BalloonPlacement(anchor, null, BalloonAlign.START, xOff, yOff, null, 0, 0, 226, null));
    }

    public static /* synthetic */ void showAlignStart$default(Balloon balloon, View view, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        balloon.showAlignStart(view, i, i2);
    }

    public final void showAlignStart(View anchor, int xOff, int yOff) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        show(new BalloonPlacement(anchor, null, BalloonAlign.START, xOff, yOff, null, 0, 0, 226, null));
    }

    public static /* synthetic */ Object awaitAlignStart$default(Balloon balloon, View view, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return balloon.awaitAlignStart(view, i, i2, continuation);
    }

    public final Object awaitAlignStart(View view, int i, int i2, Continuation<? super Unit> continuation) {
        Object objAwaitBalloon = awaitBalloon(new BalloonPlacement(view, null, BalloonAlign.START, i, i2, null, 0, 0, 226, null), continuation);
        return objAwaitBalloon == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitBalloon : Unit.INSTANCE;
    }

    public static /* synthetic */ Balloon relayShowAlignLeft$default(Balloon balloon, Balloon balloon2, View view, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return balloon.relayShowAlignLeft(balloon2, view, i, i2);
    }

    public static /* synthetic */ Balloon relayShowAlignStart$default(Balloon balloon, Balloon balloon2, View view, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return balloon.relayShowAlignStart(balloon2, view, i, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void showAlign$default(Balloon balloon, BalloonAlign balloonAlign, View view, List list, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            list = CollectionsKt.emptyList();
        }
        balloon.showAlign(balloonAlign, view, list, (i3 & 8) != 0 ? 0 : i, (i3 & 16) != 0 ? 0 : i2);
    }

    public final void showAlign(BalloonAlign align, View mainAnchor, List<? extends View> subAnchorList, int xOff, int yOff) {
        Intrinsics.checkNotNullParameter(align, "align");
        Intrinsics.checkNotNullParameter(mainAnchor, "mainAnchor");
        Intrinsics.checkNotNullParameter(subAnchorList, "subAnchorList");
        show(new BalloonPlacement(mainAnchor, subAnchorList, align, xOff, yOff, null, 0, 0, 224, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object awaitAlign$default(Balloon balloon, BalloonAlign balloonAlign, View view, List list, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            list = CollectionsKt.emptyList();
        }
        return balloon.awaitAlign(balloonAlign, view, list, (i3 & 8) != 0 ? 0 : i, (i3 & 16) != 0 ? 0 : i2, continuation);
    }

    public final Object awaitAlign(BalloonAlign balloonAlign, View view, List<? extends View> list, int i, int i2, Continuation<? super Unit> continuation) {
        Object objAwaitBalloon = awaitBalloon(new BalloonPlacement(view, list, balloonAlign, i, i2, null, 0, 0, 224, null), continuation);
        return objAwaitBalloon == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitBalloon : Unit.INSTANCE;
    }

    public static /* synthetic */ Balloon relayShowAlign$default(Balloon balloon, BalloonAlign balloonAlign, Balloon balloon2, View view, int i, int i2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            i = 0;
        }
        if ((i3 & 16) != 0) {
            i2 = 0;
        }
        return balloon.relayShowAlign(balloonAlign, balloon2, view, i, i2);
    }

    public static /* synthetic */ void updateAlignTop$default(Balloon balloon, View view, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i = 0;
        }
        if ((i5 & 4) != 0) {
            i2 = 0;
        }
        if ((i5 & 8) != 0) {
            i3 = balloon.getMeasuredWidth();
        }
        if ((i5 & 16) != 0) {
            i4 = balloon.getMeasuredHeight();
        }
        balloon.updateAlignTop(view, i, i2, i3, i4);
    }

    public final void updateAlignTop(View anchor, int xOff, int yOff, int width, int height) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        update(new BalloonPlacement(anchor, null, BalloonAlign.TOP, xOff, yOff, null, width, height, 34, null));
    }

    public static /* synthetic */ void updateAlignBottom$default(Balloon balloon, View view, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i = 0;
        }
        if ((i5 & 4) != 0) {
            i2 = 0;
        }
        if ((i5 & 8) != 0) {
            i3 = balloon.getMeasuredWidth();
        }
        if ((i5 & 16) != 0) {
            i4 = balloon.getMeasuredHeight();
        }
        balloon.updateAlignBottom(view, i, i2, i3, i4);
    }

    public final void updateAlignBottom(View anchor, int xOff, int yOff, int width, int height) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        update(new BalloonPlacement(anchor, null, BalloonAlign.BOTTOM, xOff, yOff, null, width, height, 34, null));
    }

    public static /* synthetic */ void updateAlignEnd$default(Balloon balloon, View view, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i = 0;
        }
        if ((i5 & 4) != 0) {
            i2 = 0;
        }
        if ((i5 & 8) != 0) {
            i3 = balloon.getMeasuredWidth();
        }
        if ((i5 & 16) != 0) {
            i4 = balloon.getMeasuredHeight();
        }
        balloon.updateAlignEnd(view, i, i2, i3, i4);
    }

    public final void updateAlignEnd(View anchor, int xOff, int yOff, int width, int height) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        update(new BalloonPlacement(anchor, null, BalloonAlign.END, xOff, yOff, null, width, height, 34, null));
    }

    public static /* synthetic */ void updateAlignStart$default(Balloon balloon, View view, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i = 0;
        }
        if ((i5 & 4) != 0) {
            i2 = 0;
        }
        if ((i5 & 8) != 0) {
            i3 = balloon.getMeasuredWidth();
        }
        if ((i5 & 16) != 0) {
            i4 = balloon.getMeasuredHeight();
        }
        balloon.updateAlignStart(view, i, i2, i3, i4);
    }

    public final void updateAlignStart(View anchor, int xOff, int yOff, int width, int height) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        update(new BalloonPlacement(anchor, null, BalloonAlign.START, xOff, yOff, null, width, height, 34, null));
    }

    public static /* synthetic */ void updateAlign$default(Balloon balloon, BalloonAlign balloonAlign, View view, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            i = 0;
        }
        if ((i5 & 8) != 0) {
            i2 = 0;
        }
        if ((i5 & 16) != 0) {
            i3 = balloon.getMeasuredWidth();
        }
        if ((i5 & 32) != 0) {
            i4 = balloon.getMeasuredHeight();
        }
        balloon.updateAlign(balloonAlign, view, i, i2, i3, i4);
    }

    public final void updateAlign(BalloonAlign align, View anchor, int xOff, int yOff, int width, int height) {
        Intrinsics.checkNotNullParameter(align, "align");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        update(new BalloonPlacement(anchor, null, align, xOff, yOff, null, width, height, 34, null));
    }

    private final void update(BalloonPlacement placement) {
        if (this.isShowing) {
            updateArrow(placement.getAnchor());
            Pair<Integer, Integer> pairCalculateOffset = calculateOffset(placement);
            this.bodyWindow.update(placement.getAnchor(), pairCalculateOffset.component1().intValue(), pairCalculateOffset.component2().intValue(), placement.getWidth(), placement.getHeight());
            if (this.builder.getIsVisibleOverlay()) {
                this.overlayBinding.balloonOverlayView.forceInvalidate();
            }
        }
    }

    public static /* synthetic */ void update$default(Balloon balloon, View view, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i = 0;
        }
        if ((i5 & 4) != 0) {
            i2 = 0;
        }
        if ((i5 & 8) != 0) {
            i3 = balloon.getMeasuredWidth();
        }
        if ((i5 & 16) != 0) {
            i4 = balloon.getMeasuredHeight();
        }
        balloon.update(view, i, i2, i3, i4);
    }

    public final void update(View anchor, int xOff, int yOff, int width, int height) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        update(new BalloonPlacement(anchor, null, null, xOff, yOff, PlacementType.CENTER, width, height, 6, null));
    }

    public final void dismiss() {
        if (this.isShowing) {
            Balloon$$ExternalSyntheticLambda4 balloon$$ExternalSyntheticLambda4 = new Balloon$$ExternalSyntheticLambda4(this);
            if (this.builder.getBalloonAnimation() == BalloonAnimation.CIRCULAR) {
                View contentView = this.bodyWindow.getContentView();
                Intrinsics.checkNotNullExpressionValue(contentView, "getContentView(...)");
                contentView.post(new Balloon$dismiss$$inlined$circularUnRevealed$1(contentView, this.builder.getCircularDuration(), balloon$$ExternalSyntheticLambda4));
                return;
            }
            balloon$$ExternalSyntheticLambda4.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dismiss$lambda$44(Balloon balloon) {
        balloon.isShowing = false;
        balloon.currentAlign = null;
        balloon.bodyWindow.dismiss();
        balloon.overlayWindow.dismiss();
        balloon.getHandler().removeCallbacks(balloon.getAutoDismissRunnable());
        return Unit.INSTANCE;
    }

    public final void updateSizeOfBalloonCard(int width, int height) {
        this.builder.setMeasuredWidth(width);
        if (this.binding.balloonCard.getChildCount() != 0) {
            RadiusLayout balloonCard = this.binding.balloonCard;
            Intrinsics.checkNotNullExpressionValue(balloonCard, "balloonCard");
            View view = ViewGroupKt.get(balloonCard, 0);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = width;
                layoutParams.height = height;
                view.setLayoutParams(layoutParams);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
    }

    public final boolean dismissWithDelay(long delay) {
        return getHandler().postDelayed(getAutoDismissRunnable(), delay);
    }

    public final void setOnBalloonClickListener(OnBalloonClickListener onBalloonClickListener) {
        if (onBalloonClickListener != null || this.builder.getDismissWhenClicked()) {
            this.binding.balloonWrapper.setOnClickListener(new Balloon$$ExternalSyntheticLambda3(onBalloonClickListener, this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setOnBalloonClickListener$lambda$47(OnBalloonClickListener onBalloonClickListener, Balloon balloon, View view) {
        if (onBalloonClickListener != null) {
            Intrinsics.checkNotNull(view);
            onBalloonClickListener.onBalloonClick(view);
        }
        if (balloon.builder.getDismissWhenClicked()) {
            balloon.dismiss();
        }
    }

    public final void clearAllPreferences() {
        getBalloonPersistence().clearAllPreferences();
    }

    public final /* synthetic */ void setOnBalloonClickListener(Function1 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        setOnBalloonClickListener(new BalloonKt$sam$com_skydoves_balloon_OnBalloonClickListener$0(block));
    }

    public final void setOnBalloonInitializedListener(OnBalloonInitializedListener onBalloonInitializedListener) {
        this.onBalloonInitializedListener = onBalloonInitializedListener;
    }

    public final /* synthetic */ void setOnBalloonInitializedListener(Function1 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        setOnBalloonInitializedListener(new BalloonKt$sam$com_skydoves_balloon_OnBalloonInitializedListener$0(block));
    }

    public final void setOnBalloonDismissListener(OnBalloonDismissListener onBalloonDismissListener) {
        this.bodyWindow.setOnDismissListener(new Balloon$$ExternalSyntheticLambda5(this, onBalloonDismissListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setOnBalloonDismissListener$lambda$48(Balloon balloon, OnBalloonDismissListener onBalloonDismissListener) {
        balloon.stopBalloonHighlightAnimation();
        balloon.dismiss();
        if (onBalloonDismissListener != null) {
            onBalloonDismissListener.onBalloonDismiss();
        }
    }

    public final /* synthetic */ void setOnBalloonDismissListener(Function0 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        setOnBalloonDismissListener(new BalloonKt$sam$com_skydoves_balloon_OnBalloonDismissListener$0(block));
    }

    /* JADX INFO: renamed from: com.skydoves.balloon.Balloon$setOnBalloonOutsideTouchListener$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Balloon.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0017¨\u0006\b"}, d2 = {"com/skydoves/balloon/Balloon$setOnBalloonOutsideTouchListener$1", "Landroid/view/View$OnTouchListener;", "onTouch", "", "view", "Landroid/view/View;", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "balloon_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ViewOnTouchListenerC02961 implements View.OnTouchListener {
        final /* synthetic */ OnBalloonOutsideTouchListener $onBalloonOutsideTouchListener;

        ViewOnTouchListenerC02961(OnBalloonOutsideTouchListener onBalloonOutsideTouchListener) {
            this.$onBalloonOutsideTouchListener = onBalloonOutsideTouchListener;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent event) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.getAction() == 4) {
                if (Balloon.this.builder.getDismissWhenTouchOutside()) {
                    Balloon.this.dismiss();
                }
                OnBalloonOutsideTouchListener onBalloonOutsideTouchListener = this.$onBalloonOutsideTouchListener;
                if (onBalloonOutsideTouchListener != null) {
                    onBalloonOutsideTouchListener.onBalloonOutsideTouch(view, event);
                }
                return true;
            }
            if (!Balloon.this.builder.getDismissWhenTouchMargin() || event.getAction() != 1) {
                return false;
            }
            FrameLayout balloonWrapper = Balloon.this.binding.balloonWrapper;
            Intrinsics.checkNotNullExpressionValue(balloonWrapper, "balloonWrapper");
            if (ViewExtensionKt.getViewPointOnScreen(balloonWrapper).x <= event.getRawX()) {
                FrameLayout balloonWrapper2 = Balloon.this.binding.balloonWrapper;
                Intrinsics.checkNotNullExpressionValue(balloonWrapper2, "balloonWrapper");
                if (ViewExtensionKt.getViewPointOnScreen(balloonWrapper2).x + Balloon.this.binding.balloonWrapper.getMeasuredWidth() >= event.getRawX()) {
                    return false;
                }
            }
            if (Balloon.this.builder.getDismissWhenTouchOutside()) {
                Balloon.this.dismiss();
            }
            OnBalloonOutsideTouchListener onBalloonOutsideTouchListener2 = this.$onBalloonOutsideTouchListener;
            if (onBalloonOutsideTouchListener2 != null) {
                onBalloonOutsideTouchListener2.onBalloonOutsideTouch(view, event);
            }
            return true;
        }
    }

    public final void setOnBalloonOutsideTouchListener(OnBalloonOutsideTouchListener onBalloonOutsideTouchListener) {
        this.bodyWindow.setTouchInterceptor(new ViewOnTouchListenerC02961(onBalloonOutsideTouchListener));
    }

    public final /* synthetic */ void setOnBalloonOutsideTouchListener(Function2 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        setOnBalloonOutsideTouchListener(new BalloonKt$sam$com_skydoves_balloon_OnBalloonOutsideTouchListener$0(block));
    }

    public final void setOnBalloonTouchListener(View.OnTouchListener onTouchListener) {
        if (onTouchListener != null) {
            this.bodyWindow.setTouchInterceptor(onTouchListener);
        }
    }

    public final void setOnBalloonOverlayTouchListener(View.OnTouchListener onTouchListener) {
        if (onTouchListener != null) {
            this.overlayWindow.setTouchInterceptor(onTouchListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setOnBalloonOverlayTouchListener$lambda$49(Function2 function2, View view, MotionEvent motionEvent) {
        return ((Boolean) function2.invoke(view, motionEvent)).booleanValue();
    }

    public final void setOnBalloonOverlayTouchListener(Function2<? super View, ? super MotionEvent, Boolean> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        setOnBalloonOverlayTouchListener(new Balloon$$ExternalSyntheticLambda0(block));
    }

    private final void passTouchEventToAnchor(View anchor) {
        if (this.builder.getPassTouchEventToAnchor()) {
            setOnBalloonOverlayTouchListener(new Balloon$$ExternalSyntheticLambda10(anchor, this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean passTouchEventToAnchor$lambda$50(View view, Balloon balloon, View view2, MotionEvent event) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(event, "event");
        view2.performClick();
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        if (event.getAction() == 0) {
            balloon.passedEventActionDownEvent = TuplesKt.to(event, Boolean.valueOf(rect.contains((int) event.getRawX(), (int) event.getRawY())));
        }
        Pair<MotionEvent, Boolean> pair = balloon.passedEventActionDownEvent;
        MotionEvent first = pair != null ? pair.getFirst() : null;
        Pair<MotionEvent, Boolean> pair2 = balloon.passedEventActionDownEvent;
        boolean zBooleanValue = pair2 != null ? pair2.getSecond().booleanValue() : false;
        if (zBooleanValue && event.getAction() == 1) {
            View rootView = view.getRootView();
            Intrinsics.checkNotNull(first);
            rootView.dispatchTouchEvent(first);
            return true;
        }
        if (!zBooleanValue) {
            return false;
        }
        view.getRootView().dispatchTouchEvent(event);
        return true;
    }

    public final void setOnBalloonOverlayClickListener(OnBalloonOverlayClickListener onBalloonOverlayClickListener) {
        this.overlayBinding.getRoot().setOnClickListener(new Balloon$$ExternalSyntheticLambda9(onBalloonOverlayClickListener, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setOnBalloonOverlayClickListener$lambda$51(OnBalloonOverlayClickListener onBalloonOverlayClickListener, Balloon balloon, View view) {
        if (onBalloonOverlayClickListener != null) {
            onBalloonOverlayClickListener.onBalloonOverlayClick();
        }
        if (balloon.builder.getDismissWhenOverlayClicked()) {
            balloon.dismiss();
        }
    }

    public final /* synthetic */ void setOnBalloonOverlayClickListener(Function0 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        setOnBalloonOverlayClickListener(new BalloonKt$sam$com_skydoves_balloon_OnBalloonOverlayClickListener$0(block));
    }

    public final Balloon setIsAttachedInDecor(boolean value) {
        this.bodyWindow.setAttachedInDecor(value);
        return this;
    }

    private final void measureTextWidth(TextView textView, View rootView) {
        int sumOfIntrinsicWidth;
        int iMeasureText = (int) textView.getPaint().measureText(textView.getText().toString());
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        Intrinsics.checkNotNullExpressionValue(compoundDrawablesRelative, "getCompoundDrawablesRelative(...)");
        if (DrawableExtensionKt.isExistHorizontalDrawable(compoundDrawablesRelative)) {
            Drawable[] compoundDrawablesRelative2 = textView.getCompoundDrawablesRelative();
            Intrinsics.checkNotNullExpressionValue(compoundDrawablesRelative2, "getCompoundDrawablesRelative(...)");
            textView.setMinHeight(DrawableExtensionKt.getIntrinsicHeight(compoundDrawablesRelative2));
            Drawable[] compoundDrawablesRelative3 = textView.getCompoundDrawablesRelative();
            Intrinsics.checkNotNullExpressionValue(compoundDrawablesRelative3, "getCompoundDrawablesRelative(...)");
            sumOfIntrinsicWidth = DrawableExtensionKt.getSumOfIntrinsicWidth(compoundDrawablesRelative3);
        } else {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            Intrinsics.checkNotNullExpressionValue(compoundDrawables, "getCompoundDrawables(...)");
            if (DrawableExtensionKt.isExistHorizontalDrawable(compoundDrawables)) {
                Drawable[] compoundDrawables2 = textView.getCompoundDrawables();
                Intrinsics.checkNotNullExpressionValue(compoundDrawables2, "getCompoundDrawables(...)");
                textView.setMinHeight(DrawableExtensionKt.getIntrinsicHeight(compoundDrawables2));
                Drawable[] compoundDrawables3 = textView.getCompoundDrawables();
                Intrinsics.checkNotNullExpressionValue(compoundDrawables3, "getCompoundDrawables(...)");
                sumOfIntrinsicWidth = DrawableExtensionKt.getSumOfIntrinsicWidth(compoundDrawables3);
            }
            textView.setMaxWidth(getMeasuredTextWidth(iMeasureText + textView.getCompoundPaddingStart() + textView.getCompoundPaddingEnd(), rootView));
        }
        iMeasureText += sumOfIntrinsicWidth;
        textView.setMaxWidth(getMeasuredTextWidth(iMeasureText + textView.getCompoundPaddingStart() + textView.getCompoundPaddingEnd(), rootView));
    }

    public final int getMeasuredHeight() {
        if (this.builder.getHeight() != Integer.MIN_VALUE) {
            return this.builder.getHeight();
        }
        return this.binding.getRoot().getMeasuredHeight();
    }

    public final ViewGroup getContentView() {
        RadiusLayout balloonCard = this.binding.balloonCard;
        Intrinsics.checkNotNullExpressionValue(balloonCard, "balloonCard");
        return balloonCard;
    }

    public final View getBalloonArrowView() {
        ImageView balloonArrow = this.binding.balloonArrow;
        Intrinsics.checkNotNullExpressionValue(balloonArrow, "balloonArrow");
        return balloonArrow;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onPause(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onPause(owner);
        if (this.builder.getDismissWhenLifecycleOnPause()) {
            dismiss();
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(LifecycleOwner owner) {
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onDestroy(owner);
        this.destroyed = true;
        this.overlayWindow.dismiss();
        this.bodyWindow.dismiss();
        LifecycleOwner lifecycleOwner = this.builder.getLifecycleOwner();
        if (lifecycleOwner == null || (lifecycle = lifecycleOwner.getLifecycle()) == null) {
            return;
        }
        lifecycle.removeObserver(this);
    }

    /* JADX INFO: compiled from: Balloon.kt */
    @BalloonInlineDsl
    @Metadata(d1 = {"\u0000¼\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b)\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\bH\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\n\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010¤\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0011\u0010\u000e\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010¥\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0011\u0010\u0011\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010¦\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0011\u0010\u0016\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0013J\u0011\u0010\u001a\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0013J\u0011\u0010\u001d\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0013J\u0011\u0010 \u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0011\u0010#\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010§\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u001b\u0010¨\u0003\u001a\u00020\u00002\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010!\u001a\u00020\u0007J\u001b\u0010©\u0003\u001a\u00020\u00002\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010!\u001a\u00020\u0007J\u0012\u0010ª\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010«\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010¬\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010\u00ad\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010®\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010¯\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0011\u0010&\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010°\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0011\u0010)\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010±\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0011\u0010,\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010²\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0011\u0010/\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010³\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010´\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010µ\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010¶\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010·\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010¸\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010¹\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0011\u00105\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010º\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0011\u00108\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010»\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0011\u00102\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010¼\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0011\u0010;\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010½\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0010\u0010¾\u0003\u001a\u00020\u00002\u0007\u0010£\u0003\u001a\u00020=J\u0011\u0010C\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u000f\u0010F\u001a\u00020\u00002\u0007\u0010£\u0003\u001a\u00020=J\u0012\u0010¿\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0011\u0010I\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010À\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0011\u0010N\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0013J\u000f\u0010S\u001a\u00020\u00002\u0007\u0010£\u0003\u001a\u00020PJ\u000f\u0010_\u001a\u00020\u00002\u0007\u0010£\u0003\u001a\u00020\\J\u000f\u0010Y\u001a\u00020\u00002\u0007\u0010£\u0003\u001a\u00020VJ\u0011\u0010e\u001a\u00020\u00002\t\u0010£\u0003\u001a\u0004\u0018\u00010bJ\u0012\u0010Á\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0011\u0010i\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010Â\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0011\u0010l\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010Ã\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0011\u0010o\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010Ä\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0011\u0010r\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010Å\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0011\u0010u\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010Æ\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u000f\u0010x\u001a\u00020\u00002\u0007\u0010£\u0003\u001a\u00020\u0013J\u0011\u0010{\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010Ç\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0011\u0010~\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010È\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010\u0081\u0001\u001a\u00020\u00002\t\u0010£\u0003\u001a\u0004\u0018\u00010bJ\u0012\u0010É\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010\u0084\u0001\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0013J\u0012\u0010Ê\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0011\u0010\u0089\u0001\u001a\u00020\u00002\b\u0010£\u0003\u001a\u00030\u0086\u0001J\u0012\u0010Ë\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010\u008d\u0001\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010Ì\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0010\u0010\u0090\u0001\u001a\u00020\u00002\u0007\u0010£\u0003\u001a\u00020=J\u0011\u0010\u0095\u0001\u001a\u00020\u00002\b\u0010£\u0003\u001a\u00030\u0092\u0001J\u0012\u0010\u0099\u0001\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0013J\u0012\u0010Í\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0010\u0010\u009c\u0001\u001a\u00020\u00002\u0007\u0010£\u0003\u001a\u00020=J\u0012\u0010\u009f\u0001\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0013J\u0012\u0010¢\u0001\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0013J\u0010\u0010¥\u0001\u001a\u00020\u00002\u0007\u0010£\u0003\u001a\u00020\u0007J\u0011\u0010¥\u0001\u001a\u00020\u00002\b\u0010£\u0003\u001a\u00030§\u0001J\u0012\u0010¯\u0001\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0013J\u0012\u0010´\u0001\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0013J\u0012\u0010Î\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010Ï\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0010\u0010·\u0001\u001a\u00020\u00002\u0007\u0010£\u0003\u001a\u00020=J\u0010\u0010º\u0001\u001a\u00020\u00002\u0007\u0010£\u0003\u001a\u00020\u0007J\u0011\u0010¿\u0001\u001a\u00020\u00002\b\u0010£\u0003\u001a\u00030¼\u0001J\u0012\u0010Ã\u0001\u001a\u00020\u00002\t\u0010£\u0003\u001a\u0004\u0018\u00010bJ\u0012\u0010Ð\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0011\u0010È\u0001\u001a\u00020\u00002\b\u0010£\u0003\u001a\u00030Å\u0001J\u0012\u0010Ì\u0001\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010Ñ\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010Ï\u0001\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010Ò\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010Ó\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010Ô\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010Õ\u0001\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010Õ\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010Ò\u0001\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010Ö\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0011\u0010Þ\u0001\u001a\u00020\u00002\b\u0010£\u0003\u001a\u00030\u0086\u0001J\u0012\u0010×\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0011\u0010Ú\u0001\u001a\u00020\u00002\b\u0010£\u0003\u001a\u00030×\u0001J\u0012\u0010á\u0001\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0013J\u0012\u0010ä\u0001\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010Ø\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010é\u0001\u001a\u00020\u00002\t\b\u0001\u0010ë\u0001\u001a\u00020\u0007J\u0011\u0010é\u0001\u001a\u00020\u00002\b\u0010å\u0001\u001a\u00030æ\u0001J#\u0010é\u0001\u001a\u00020\u0000\"\n\b\u0000\u0010Ù\u0003*\u00030Ú\u00032\b\u0010Û\u0003\u001a\u0003HÙ\u0003¢\u0006\u0003\u0010Ü\u0003J\u0010\u0010Ý\u0003\u001a\u00020\u00002\u0007\u0010£\u0003\u001a\u00020=J\u0012\u0010õ\u0001\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010Þ\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010ø\u0001\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0013J\u0012\u0010ß\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010û\u0001\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0012\u0010à\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0011\u0010\u0080\u0002\u001a\u00020\u00002\b\u0010á\u0003\u001a\u00030ý\u0001J\u0011\u0010\u0086\u0002\u001a\u00020\u00002\b\u0010£\u0003\u001a\u00030\u0083\u0002J\u0011\u0010\u008c\u0002\u001a\u00020\u00002\b\u0010£\u0003\u001a\u00030\u0089\u0002J\u0010\u0010\u0090\u0002\u001a\u00020\u00002\u0007\u0010â\u0003\u001a\u00020\u0007J\u0010\u0010ã\u0003\u001a\u00020\u00002\u0007\u0010£\u0003\u001a\u00020=J\u0010\u0010ä\u0003\u001a\u00020\u00002\u0007\u0010£\u0003\u001a\u00020=J\u0013\u0010×\u0002\u001a\u00020\u00002\n\u0010£\u0003\u001a\u0005\u0018\u00010Ô\u0002J\u0011\u0010Ý\u0002\u001a\u00020\u00002\b\u0010£\u0003\u001a\u00030Ú\u0002J\u0011\u0010é\u0002\u001a\u00020\u00002\b\u0010£\u0003\u001a\u00030æ\u0002J\u0012\u0010á\u0002\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0011\u0010ï\u0002\u001a\u00020\u00002\b\u0010£\u0003\u001a\u00030ì\u0002J\u0012\u0010ä\u0002\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u0007J\u0011\u0010ó\u0002\u001a\u00020\u00002\b\u0010£\u0003\u001a\u00030Î\u0002J\u001f\u0010ø\u0002\u001a\u00020\u00002\b\u0010£\u0003\u001a\u00030õ\u00022\n\b\u0002\u0010å\u0003\u001a\u00030Î\u0002H\u0007J \u0010æ\u0003\u001a\u00020\u00002\t\b\u0001\u0010£\u0003\u001a\u00020\u00072\n\b\u0002\u0010å\u0003\u001a\u00030Î\u0002H\u0007J\u0011\u0010ç\u0003\u001a\u00020\u00002\b\u0010\u0080\u0003\u001a\u00030\u0081\u0003J\u0011\u0010\u0095\u0002\u001a\u00020\u00002\b\u0010£\u0003\u001a\u00030\u0092\u0002J\u0011\u0010\u009b\u0002\u001a\u00020\u00002\b\u0010£\u0003\u001a\u00030\u0098\u0002J\u0011\u0010¡\u0002\u001a\u00020\u00002\b\u0010£\u0003\u001a\u00030\u009e\u0002J\u0011\u0010§\u0002\u001a\u00020\u00002\b\u0010£\u0003\u001a\u00030¤\u0002J\u0011\u0010\u00ad\u0002\u001a\u00020\u00002\b\u0010£\u0003\u001a\u00030ª\u0002J\u0011\u0010¶\u0002\u001a\u00020\u00002\b\u0010£\u0003\u001a\u00030³\u0002J\u001f\u0010\u0095\u0002\u001a\u00020\u00002\u0016\u0010è\u0003\u001a\u0011\u0012\u0005\u0012\u00030æ\u0001\u0012\u0005\u0012\u00030\u0091\u00030é\u0003J\u0018\u0010\u009b\u0002\u001a\u00020\u00002\u000f\u0010è\u0003\u001a\n\u0012\u0005\u0012\u00030\u0091\u00030\u0090\u0003J\u001f\u0010¡\u0002\u001a\u00020\u00002\u0016\u0010è\u0003\u001a\u0011\u0012\u0005\u0012\u00030æ\u0001\u0012\u0005\u0012\u00030\u0091\u00030é\u0003J&\u0010§\u0002\u001a\u00020\u00002\u001d\u0010è\u0003\u001a\u0018\u0012\u0005\u0012\u00030æ\u0001\u0012\u0005\u0012\u00030ë\u0003\u0012\u0005\u0012\u00030\u0091\u00030ê\u0003J\u0018\u0010¶\u0002\u001a\u00020\u00002\u000f\u0010è\u0003\u001a\n\u0012\u0005\u0012\u00030\u0091\u00030\u0090\u0003J\u0010\u0010º\u0002\u001a\u00020\u00002\u0007\u0010£\u0003\u001a\u00020=J\u0010\u0010½\u0002\u001a\u00020\u00002\u0007\u0010£\u0003\u001a\u00020=J\u0011\u0010±\u0002\u001a\u00020\u00002\b\u0010£\u0003\u001a\u00030ª\u0002J\u0010\u0010À\u0002\u001a\u00020\u00002\u0007\u0010£\u0003\u001a\u00020=J\u0010\u0010Ã\u0002\u001a\u00020\u00002\u0007\u0010£\u0003\u001a\u00020=J\u0010\u0010É\u0002\u001a\u00020\u00002\u0007\u0010£\u0003\u001a\u00020=J\u0010\u0010Æ\u0002\u001a\u00020\u00002\u0007\u0010£\u0003\u001a\u00020=J\u0010\u0010ì\u0003\u001a\u00020\u00002\u0007\u0010£\u0003\u001a\u00020=J\u0011\u0010Ñ\u0002\u001a\u00020\u00002\b\u0010£\u0003\u001a\u00030Î\u0002J\u0011\u0010\u008a\u0003\u001a\u00020\u00002\b\u0010£\u0003\u001a\u00030\u0087\u0003J\u0010\u0010í\u0003\u001a\u00020\u00002\u0007\u0010£\u0003\u001a\u00020\u0007J\u0018\u0010\u008f\u0003\u001a\u00020\u00002\u000f\u0010è\u0003\u001a\n\u0012\u0005\u0012\u00030\u0091\u00030\u0090\u0003J\u0011\u0010\u008f\u0003\u001a\u00020\u00002\b\u0010î\u0003\u001a\u00030ï\u0003J\u0010\u0010ð\u0003\u001a\u00020\u00002\u0007\u0010ñ\u0003\u001a\u00020=J\u0010\u0010\u009c\u0003\u001a\u00020\u00002\u0007\u0010£\u0003\u001a\u00020=J\u0010\u0010ò\u0003\u001a\u00020\u00002\u0007\u0010£\u0003\u001a\u00020=J\b\u0010ó\u0003\u001a\u00030ô\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001e\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001e\u0010\u001b\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001e\u0010\u001e\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\t\"\u0004\b \u0010\u000bR\u001e\u0010!\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\t\"\u0004\b#\u0010\u000bR\u001e\u0010$\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\t\"\u0004\b&\u0010\u000bR\u001e\u0010'\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\t\"\u0004\b)\u0010\u000bR\u001e\u0010*\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\t\"\u0004\b,\u0010\u000bR\u001e\u0010-\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\t\"\u0004\b/\u0010\u000bR\u001e\u00100\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\t\"\u0004\b2\u0010\u000bR\u001e\u00103\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\t\"\u0004\b5\u0010\u000bR\u001e\u00106\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\t\"\u0004\b8\u0010\u000bR\u001e\u00109\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\t\"\u0004\b;\u0010\u000bR\u001a\u0010<\u001a\u00020=X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010>\"\u0004\b?\u0010@R\u001e\u0010A\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\t\"\u0004\bC\u0010\u000bR\u001a\u0010D\u001a\u00020=X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010>\"\u0004\bF\u0010@R\u001e\u0010G\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\t\"\u0004\bI\u0010\u000bR\u0012\u0010J\u001a\u00020\u00138Ç\u0002¢\u0006\u0006\u001a\u0004\bK\u0010\u0015R\u001e\u0010L\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0015\"\u0004\bN\u0010\u0017R\u001a\u0010O\u001a\u00020PX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001a\u0010U\u001a\u00020VX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u001a\u0010[\u001a\u00020\\X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u001c\u0010a\u001a\u0004\u0018\u00010bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\u001a\u0010g\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\t\"\u0004\bi\u0010\u000bR\u001a\u0010j\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010\t\"\u0004\bl\u0010\u000bR\u001a\u0010m\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010\t\"\u0004\bo\u0010\u000bR\u001a\u0010p\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010\t\"\u0004\br\u0010\u000bR\u001a\u0010s\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010\t\"\u0004\bu\u0010\u000bR\u001a\u0010v\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010\u0015\"\u0004\bx\u0010\u0017R\u001a\u0010y\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010\u0015\"\u0004\b{\u0010\u0017R\u001e\u0010|\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010\t\"\u0004\b~\u0010\u000bR\u001e\u0010\u007f\u001a\u0004\u0018\u00010bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010d\"\u0005\b\u0081\u0001\u0010fR!\u0010\u0082\u0001\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010\u0015\"\u0005\b\u0084\u0001\u0010\u0017R \u0010\u0085\u0001\u001a\u00030\u0086\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0006\b\u0089\u0001\u0010\u008a\u0001R!\u0010\u008b\u0001\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008c\u0001\u0010\t\"\u0005\b\u008d\u0001\u0010\u000bR\u001d\u0010\u008e\u0001\u001a\u00020=X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008f\u0001\u0010>\"\u0005\b\u0090\u0001\u0010@R\"\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R!\u0010\u0097\u0001\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0098\u0001\u0010\u0015\"\u0005\b\u0099\u0001\u0010\u0017R\u001d\u0010\u009a\u0001\u001a\u00020=X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009b\u0001\u0010>\"\u0005\b\u009c\u0001\u0010@R\u001d\u0010\u009d\u0001\u001a\u00020\u0013X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009e\u0001\u0010\u0015\"\u0005\b\u009f\u0001\u0010\u0017R\u001d\u0010 \u0001\u001a\u00020\u0013X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¡\u0001\u0010\u0015\"\u0005\b¢\u0001\u0010\u0017R\u001d\u0010£\u0001\u001a\u00020\u0007X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¤\u0001\u0010\t\"\u0005\b¥\u0001\u0010\u000bR\"\u0010¦\u0001\u001a\u0005\u0018\u00010§\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¨\u0001\u0010©\u0001\"\u0006\bª\u0001\u0010«\u0001R$\u0010¬\u0001\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u0015\n\u0003\u0010±\u0001\u001a\u0006\b\u00ad\u0001\u0010®\u0001\"\u0006\b¯\u0001\u0010°\u0001R$\u0010²\u0001\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u0015\n\u0003\u0010±\u0001\u001a\u0006\b³\u0001\u0010®\u0001\"\u0006\b´\u0001\u0010°\u0001R\u001d\u0010µ\u0001\u001a\u00020=X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¶\u0001\u0010>\"\u0005\b·\u0001\u0010@R\u001d\u0010¸\u0001\u001a\u00020\u0007X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¹\u0001\u0010\t\"\u0005\bº\u0001\u0010\u000bR\"\u0010»\u0001\u001a\u0005\u0018\u00010¼\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b½\u0001\u0010¾\u0001\"\u0006\b¿\u0001\u0010À\u0001R\u001f\u0010Á\u0001\u001a\u0004\u0018\u00010bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÂ\u0001\u0010d\"\u0005\bÃ\u0001\u0010fR \u0010Ä\u0001\u001a\u00030Å\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÆ\u0001\u0010Ç\u0001\"\u0006\bÈ\u0001\u0010É\u0001R!\u0010Ê\u0001\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bË\u0001\u0010\t\"\u0005\bÌ\u0001\u0010\u000bR!\u0010Í\u0001\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÎ\u0001\u0010\t\"\u0005\bÏ\u0001\u0010\u000bR!\u0010Ð\u0001\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÑ\u0001\u0010\t\"\u0005\bÒ\u0001\u0010\u000bR!\u0010Ó\u0001\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÔ\u0001\u0010\t\"\u0005\bÕ\u0001\u0010\u000bR\"\u0010Ö\u0001\u001a\u0005\u0018\u00010×\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bØ\u0001\u0010Ù\u0001\"\u0006\bÚ\u0001\u0010Û\u0001R \u0010Ü\u0001\u001a\u00030\u0086\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÝ\u0001\u0010\u0088\u0001\"\u0006\bÞ\u0001\u0010\u008a\u0001R!\u0010ß\u0001\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bà\u0001\u0010\u0015\"\u0005\bá\u0001\u0010\u0017R\u001d\u0010â\u0001\u001a\u00020\u0013X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bã\u0001\u0010\u0015\"\u0005\bä\u0001\u0010\u0017R\"\u0010å\u0001\u001a\u0005\u0018\u00010æ\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bç\u0001\u0010è\u0001\"\u0006\bé\u0001\u0010ê\u0001R(\u0010ë\u0001\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0003\u0010ð\u0001\u001a\u0006\bì\u0001\u0010í\u0001\"\u0006\bî\u0001\u0010ï\u0001R\u001d\u0010ñ\u0001\u001a\u00020=X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bñ\u0001\u0010>\"\u0005\bò\u0001\u0010@R!\u0010ó\u0001\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bô\u0001\u0010\t\"\u0005\bõ\u0001\u0010\u000bR!\u0010ö\u0001\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b÷\u0001\u0010\u0015\"\u0005\bø\u0001\u0010\u0017R!\u0010ù\u0001\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bú\u0001\u0010\t\"\u0005\bû\u0001\u0010\u000bR\"\u0010ü\u0001\u001a\u0005\u0018\u00010ý\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bþ\u0001\u0010ÿ\u0001\"\u0006\b\u0080\u0002\u0010\u0081\u0002R\"\u0010\u0082\u0002\u001a\u0005\u0018\u00010\u0083\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0084\u0002\u0010\u0085\u0002\"\u0006\b\u0086\u0002\u0010\u0087\u0002R \u0010\u0088\u0002\u001a\u00030\u0089\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008a\u0002\u0010\u008b\u0002\"\u0006\b\u008c\u0002\u0010\u008d\u0002R\u001d\u0010\u008e\u0002\u001a\u00020\u0007X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008f\u0002\u0010\t\"\u0005\b\u0090\u0002\u0010\u000bR\"\u0010\u0091\u0002\u001a\u0005\u0018\u00010\u0092\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0093\u0002\u0010\u0094\u0002\"\u0006\b\u0095\u0002\u0010\u0096\u0002R\"\u0010\u0097\u0002\u001a\u0005\u0018\u00010\u0098\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0099\u0002\u0010\u009a\u0002\"\u0006\b\u009b\u0002\u0010\u009c\u0002R\"\u0010\u009d\u0002\u001a\u0005\u0018\u00010\u009e\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009f\u0002\u0010 \u0002\"\u0006\b¡\u0002\u0010¢\u0002R\"\u0010£\u0002\u001a\u0005\u0018\u00010¤\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¥\u0002\u0010¦\u0002\"\u0006\b§\u0002\u0010¨\u0002R\"\u0010©\u0002\u001a\u0005\u0018\u00010ª\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b«\u0002\u0010¬\u0002\"\u0006\b\u00ad\u0002\u0010®\u0002R\"\u0010¯\u0002\u001a\u0005\u0018\u00010ª\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b°\u0002\u0010¬\u0002\"\u0006\b±\u0002\u0010®\u0002R\"\u0010²\u0002\u001a\u0005\u0018\u00010³\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b´\u0002\u0010µ\u0002\"\u0006\b¶\u0002\u0010·\u0002R\u001d\u0010¸\u0002\u001a\u00020=X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¹\u0002\u0010>\"\u0005\bº\u0002\u0010@R\u001d\u0010»\u0002\u001a\u00020=X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¼\u0002\u0010>\"\u0005\b½\u0002\u0010@R\u001d\u0010¾\u0002\u001a\u00020=X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¿\u0002\u0010>\"\u0005\bÀ\u0002\u0010@R\u001d\u0010Á\u0002\u001a\u00020=X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÂ\u0002\u0010>\"\u0005\bÃ\u0002\u0010@R\u001d\u0010Ä\u0002\u001a\u00020=X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÅ\u0002\u0010>\"\u0005\bÆ\u0002\u0010@R\u001d\u0010Ç\u0002\u001a\u00020=X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÈ\u0002\u0010>\"\u0005\bÉ\u0002\u0010@R\u001d\u0010Ê\u0002\u001a\u00020=X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bË\u0002\u0010>\"\u0005\bÌ\u0002\u0010@R \u0010Í\u0002\u001a\u00030Î\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÏ\u0002\u0010Ð\u0002\"\u0006\bÑ\u0002\u0010Ò\u0002R\"\u0010Ó\u0002\u001a\u0005\u0018\u00010Ô\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÕ\u0002\u0010Ö\u0002\"\u0006\b×\u0002\u0010Ø\u0002R\"\u0010Ù\u0002\u001a\u0005\u0018\u00010Ú\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÛ\u0002\u0010Ü\u0002\"\u0006\bÝ\u0002\u0010Þ\u0002R!\u0010ß\u0002\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bà\u0002\u0010\t\"\u0005\bá\u0002\u0010\u000bR!\u0010â\u0002\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bã\u0002\u0010\t\"\u0005\bä\u0002\u0010\u000bR \u0010å\u0002\u001a\u00030æ\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bç\u0002\u0010è\u0002\"\u0006\bé\u0002\u0010ê\u0002R \u0010ë\u0002\u001a\u00030ì\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bí\u0002\u0010î\u0002\"\u0006\bï\u0002\u0010ð\u0002R \u0010ñ\u0002\u001a\u00030Î\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bò\u0002\u0010Ð\u0002\"\u0006\bó\u0002\u0010Ò\u0002R \u0010ô\u0002\u001a\u00030õ\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bö\u0002\u0010÷\u0002\"\u0006\bø\u0002\u0010ù\u0002R!\u0010ú\u0002\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bû\u0002\u0010\t\"\u0005\bü\u0002\u0010\u000bR \u0010ý\u0002\u001a\u00030Î\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bþ\u0002\u0010Ð\u0002\"\u0006\bÿ\u0002\u0010Ò\u0002R\"\u0010\u0080\u0003\u001a\u0005\u0018\u00010\u0081\u0003X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0082\u0003\u0010\u0083\u0003\"\u0006\b\u0084\u0003\u0010\u0085\u0003R\"\u0010\u0086\u0003\u001a\u0005\u0018\u00010\u0087\u0003X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0088\u0003\u0010\u0089\u0003\"\u0006\b\u008a\u0003\u0010\u008b\u0003R\u001d\u0010\u008c\u0003\u001a\u00020\u0007X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0003\u0010\t\"\u0005\b\u008e\u0003\u0010\u000bR)\u0010\u008f\u0003\u001a\f\u0012\u0005\u0012\u00030\u0091\u0003\u0018\u00010\u0090\u0003X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0092\u0003\u0010\u0093\u0003\"\u0006\b\u0094\u0003\u0010\u0095\u0003R\u001d\u0010\u0096\u0003\u001a\u00020=X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0096\u0003\u0010>\"\u0005\b\u0097\u0003\u0010@R\u001d\u0010\u0098\u0003\u001a\u00020\u0007X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0099\u0003\u0010\t\"\u0005\b\u009a\u0003\u0010\u000bR\u001d\u0010\u009b\u0003\u001a\u00020=X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009b\u0003\u0010>\"\u0005\b\u009c\u0003\u0010@R\u001d\u0010\u009d\u0003\u001a\u00020=X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009d\u0003\u0010>\"\u0005\b\u009e\u0003\u0010@R\u001d\u0010\u009f\u0003\u001a\u00020=X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009f\u0003\u0010>\"\u0005\b \u0003\u0010@R\u001d\u0010¡\u0003\u001a\u00020=X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¡\u0003\u0010>\"\u0005\b¢\u0003\u0010@¨\u0006õ\u0003"}, d2 = {"Lcom/skydoves/balloon/Balloon$Builder;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "width", "", "getWidth", "()I", "setWidth", "(I)V", "minWidth", "getMinWidth", "setMinWidth", "maxWidth", "getMaxWidth", "setMaxWidth", "widthRatio", "", "getWidthRatio", "()F", "setWidthRatio", "(F)V", "minWidthRatio", "getMinWidthRatio", "setMinWidthRatio", "maxWidthRatio", "getMaxWidthRatio", "setMaxWidthRatio", "measuredWidth", "getMeasuredWidth", "setMeasuredWidth", "height", "getHeight", "setHeight", "paddingLeft", "getPaddingLeft", "setPaddingLeft", "paddingTop", "getPaddingTop", "setPaddingTop", "paddingRight", "getPaddingRight", "setPaddingRight", "paddingBottom", "getPaddingBottom", "setPaddingBottom", "marginRight", "getMarginRight", "setMarginRight", "marginLeft", "getMarginLeft", "setMarginLeft", "marginTop", "getMarginTop", "setMarginTop", "marginBottom", "getMarginBottom", "setMarginBottom", "isVisibleArrow", "", "()Z", "setVisibleArrow", "(Z)V", "arrowColor", "getArrowColor", "setArrowColor", "arrowColorMatchBalloon", "getArrowColorMatchBalloon", "setArrowColorMatchBalloon", "arrowSize", "getArrowSize", "setArrowSize", "arrowHalfSize", "getArrowHalfSize", "arrowPosition", "getArrowPosition", "setArrowPosition", "arrowPositionRules", "Lcom/skydoves/balloon/ArrowPositionRules;", "getArrowPositionRules", "()Lcom/skydoves/balloon/ArrowPositionRules;", "setArrowPositionRules", "(Lcom/skydoves/balloon/ArrowPositionRules;)V", "arrowOrientationRules", "Lcom/skydoves/balloon/ArrowOrientationRules;", "getArrowOrientationRules", "()Lcom/skydoves/balloon/ArrowOrientationRules;", "setArrowOrientationRules", "(Lcom/skydoves/balloon/ArrowOrientationRules;)V", "arrowOrientation", "Lcom/skydoves/balloon/ArrowOrientation;", "getArrowOrientation", "()Lcom/skydoves/balloon/ArrowOrientation;", "setArrowOrientation", "(Lcom/skydoves/balloon/ArrowOrientation;)V", "arrowDrawable", "Landroid/graphics/drawable/Drawable;", "getArrowDrawable", "()Landroid/graphics/drawable/Drawable;", "setArrowDrawable", "(Landroid/graphics/drawable/Drawable;)V", "arrowLeftPadding", "getArrowLeftPadding", "setArrowLeftPadding", "arrowRightPadding", "getArrowRightPadding", "setArrowRightPadding", "arrowTopPadding", "getArrowTopPadding", "setArrowTopPadding", "arrowBottomPadding", "getArrowBottomPadding", "setArrowBottomPadding", "arrowAlignAnchorPadding", "getArrowAlignAnchorPadding", "setArrowAlignAnchorPadding", "arrowAlignAnchorPaddingRatio", "getArrowAlignAnchorPaddingRatio", "setArrowAlignAnchorPaddingRatio", "arrowElevation", "getArrowElevation", "setArrowElevation", "backgroundColor", "getBackgroundColor", "setBackgroundColor", "backgroundDrawable", "getBackgroundDrawable", "setBackgroundDrawable", "cornerRadius", "getCornerRadius", "setCornerRadius", "text", "", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "textColor", "getTextColor", "setTextColor", "textIsHtml", "getTextIsHtml", "setTextIsHtml", "movementMethod", "Landroid/text/method/MovementMethod;", "getMovementMethod", "()Landroid/text/method/MovementMethod;", "setMovementMethod", "(Landroid/text/method/MovementMethod;)V", "textSize", "getTextSize", "setTextSize", "enableAutoSized", "getEnableAutoSized", "setEnableAutoSized", "minAutoSizeTextSize", "getMinAutoSizeTextSize", "setMinAutoSizeTextSize", "maxAutoSizeTextSize", "getMaxAutoSizeTextSize", "setMaxAutoSizeTextSize", "textTypeface", "getTextTypeface", "setTextTypeface", "textTypefaceObject", "Landroid/graphics/Typeface;", "getTextTypefaceObject", "()Landroid/graphics/Typeface;", "setTextTypefaceObject", "(Landroid/graphics/Typeface;)V", "textLineSpacing", "getTextLineSpacing", "()Ljava/lang/Float;", "setTextLineSpacing", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "textLetterSpacing", "getTextLetterSpacing", "setTextLetterSpacing", "includeFontPadding", "getIncludeFontPadding", "setIncludeFontPadding", "textGravity", "getTextGravity", "setTextGravity", "textForm", "Lcom/skydoves/balloon/TextForm;", "getTextForm", "()Lcom/skydoves/balloon/TextForm;", "setTextForm", "(Lcom/skydoves/balloon/TextForm;)V", "iconDrawable", "getIconDrawable", "setIconDrawable", "iconGravity", "Lcom/skydoves/balloon/IconGravity;", "getIconGravity", "()Lcom/skydoves/balloon/IconGravity;", "setIconGravity", "(Lcom/skydoves/balloon/IconGravity;)V", "iconWidth", "getIconWidth", "setIconWidth", "iconHeight", "getIconHeight", "setIconHeight", "iconSpace", "getIconSpace", "setIconSpace", "iconColor", "getIconColor", "setIconColor", "iconForm", "Lcom/skydoves/balloon/IconForm;", "getIconForm", "()Lcom/skydoves/balloon/IconForm;", "setIconForm", "(Lcom/skydoves/balloon/IconForm;)V", "iconContentDescription", "getIconContentDescription", "setIconContentDescription", "alpha", "getAlpha", "setAlpha", "elevation", "getElevation", "setElevation", "layout", "Landroid/view/View;", "getLayout", "()Landroid/view/View;", "setLayout", "(Landroid/view/View;)V", "layoutRes", "getLayoutRes", "()Ljava/lang/Integer;", "setLayoutRes", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "isVisibleOverlay", "setVisibleOverlay", "overlayColor", "getOverlayColor", "setOverlayColor", "overlayPadding", "getOverlayPadding", "setOverlayPadding", "overlayPaddingColor", "getOverlayPaddingColor", "setOverlayPaddingColor", "overlayPaddingShader", "Landroid/graphics/Shader;", "getOverlayPaddingShader", "()Landroid/graphics/Shader;", "setOverlayPaddingShader", "(Landroid/graphics/Shader;)V", "overlayPosition", "Landroid/graphics/Point;", "getOverlayPosition", "()Landroid/graphics/Point;", "setOverlayPosition", "(Landroid/graphics/Point;)V", "overlayShape", "Lcom/skydoves/balloon/overlay/BalloonOverlayShape;", "getOverlayShape", "()Lcom/skydoves/balloon/overlay/BalloonOverlayShape;", "setOverlayShape", "(Lcom/skydoves/balloon/overlay/BalloonOverlayShape;)V", "overlayGravity", "getOverlayGravity", "setOverlayGravity", "onBalloonClickListener", "Lcom/skydoves/balloon/OnBalloonClickListener;", "getOnBalloonClickListener", "()Lcom/skydoves/balloon/OnBalloonClickListener;", "setOnBalloonClickListener", "(Lcom/skydoves/balloon/OnBalloonClickListener;)V", "onBalloonDismissListener", "Lcom/skydoves/balloon/OnBalloonDismissListener;", "getOnBalloonDismissListener", "()Lcom/skydoves/balloon/OnBalloonDismissListener;", "setOnBalloonDismissListener", "(Lcom/skydoves/balloon/OnBalloonDismissListener;)V", "onBalloonInitializedListener", "Lcom/skydoves/balloon/OnBalloonInitializedListener;", "getOnBalloonInitializedListener", "()Lcom/skydoves/balloon/OnBalloonInitializedListener;", "setOnBalloonInitializedListener", "(Lcom/skydoves/balloon/OnBalloonInitializedListener;)V", "onBalloonOutsideTouchListener", "Lcom/skydoves/balloon/OnBalloonOutsideTouchListener;", "getOnBalloonOutsideTouchListener", "()Lcom/skydoves/balloon/OnBalloonOutsideTouchListener;", "setOnBalloonOutsideTouchListener", "(Lcom/skydoves/balloon/OnBalloonOutsideTouchListener;)V", "onBalloonTouchListener", "Landroid/view/View$OnTouchListener;", "getOnBalloonTouchListener", "()Landroid/view/View$OnTouchListener;", "setOnBalloonTouchListener", "(Landroid/view/View$OnTouchListener;)V", "onBalloonOverlayTouchListener", "getOnBalloonOverlayTouchListener", "setOnBalloonOverlayTouchListener", "onBalloonOverlayClickListener", "Lcom/skydoves/balloon/OnBalloonOverlayClickListener;", "getOnBalloonOverlayClickListener", "()Lcom/skydoves/balloon/OnBalloonOverlayClickListener;", "setOnBalloonOverlayClickListener", "(Lcom/skydoves/balloon/OnBalloonOverlayClickListener;)V", "dismissWhenTouchOutside", "getDismissWhenTouchOutside", "setDismissWhenTouchOutside", "dismissWhenTouchMargin", "getDismissWhenTouchMargin", "setDismissWhenTouchMargin", "dismissWhenShowAgain", "getDismissWhenShowAgain", "setDismissWhenShowAgain", "dismissWhenClicked", "getDismissWhenClicked", "setDismissWhenClicked", "dismissWhenOverlayClicked", "getDismissWhenOverlayClicked", "setDismissWhenOverlayClicked", "dismissWhenLifecycleOnPause", "getDismissWhenLifecycleOnPause", "setDismissWhenLifecycleOnPause", "passTouchEventToAnchor", "getPassTouchEventToAnchor", "setPassTouchEventToAnchor", "autoDismissDuration", "", "getAutoDismissDuration", "()J", "setAutoDismissDuration", "(J)V", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "lifecycleObserver", "Landroidx/lifecycle/LifecycleObserver;", "getLifecycleObserver", "()Landroidx/lifecycle/LifecycleObserver;", "setLifecycleObserver", "(Landroidx/lifecycle/LifecycleObserver;)V", "balloonAnimationStyle", "getBalloonAnimationStyle", "setBalloonAnimationStyle", "balloonOverlayAnimationStyle", "getBalloonOverlayAnimationStyle", "setBalloonOverlayAnimationStyle", "balloonAnimation", "Lcom/skydoves/balloon/BalloonAnimation;", "getBalloonAnimation", "()Lcom/skydoves/balloon/BalloonAnimation;", "setBalloonAnimation", "(Lcom/skydoves/balloon/BalloonAnimation;)V", "balloonOverlayAnimation", "Lcom/skydoves/balloon/overlay/BalloonOverlayAnimation;", "getBalloonOverlayAnimation", "()Lcom/skydoves/balloon/overlay/BalloonOverlayAnimation;", "setBalloonOverlayAnimation", "(Lcom/skydoves/balloon/overlay/BalloonOverlayAnimation;)V", "circularDuration", "getCircularDuration", "setCircularDuration", "balloonHighlightAnimation", "Lcom/skydoves/balloon/BalloonHighlightAnimation;", "getBalloonHighlightAnimation", "()Lcom/skydoves/balloon/BalloonHighlightAnimation;", "setBalloonHighlightAnimation", "(Lcom/skydoves/balloon/BalloonHighlightAnimation;)V", "balloonHighlightAnimationStyle", "getBalloonHighlightAnimationStyle", "setBalloonHighlightAnimationStyle", "balloonHighlightAnimationStartDelay", "getBalloonHighlightAnimationStartDelay", "setBalloonHighlightAnimationStartDelay", "balloonRotateAnimation", "Lcom/skydoves/balloon/animations/BalloonRotateAnimation;", "getBalloonRotateAnimation", "()Lcom/skydoves/balloon/animations/BalloonRotateAnimation;", "setBalloonRotateAnimation", "(Lcom/skydoves/balloon/animations/BalloonRotateAnimation;)V", "preferenceName", "", "getPreferenceName", "()Ljava/lang/String;", "setPreferenceName", "(Ljava/lang/String;)V", "showTimes", "getShowTimes", "setShowTimes", "runIfReachedShowCounts", "Lkotlin/Function0;", "", "getRunIfReachedShowCounts", "()Lkotlin/jvm/functions/Function0;", "setRunIfReachedShowCounts", "(Lkotlin/jvm/functions/Function0;)V", "isRtlLayout", "setRtlLayout", "supportRtlLayoutFactor", "getSupportRtlLayoutFactor", "setSupportRtlLayoutFactor", "isFocusable", "setFocusable", "isStatusBarVisible", "setStatusBarVisible", "isAttachedInDecor", "setAttachedInDecor", "isComposableContent", "setComposableContent", "value", "setWidthResource", "setMinWidthResource", "setMaxWidthResource", "setHeightResource", "setSize", "setSizeResource", "setPadding", "setPaddingResource", "setPaddingHorizontal", "setPaddingHorizontalResource", "setPaddingVertical", "setPaddingVerticalResource", "setPaddingLeftResource", "setPaddingTopResource", "setPaddingRightResource", "setPaddingBottomResource", "setMargin", "setMarginResource", "setMarginHorizontal", "setMarginHorizontalResource", "setMarginVertical", "setMarginVerticalResource", "setMarginLeftResource", "setMarginTopResource", "setMarginRightResource", "setMarginBottomResource", "setIsVisibleArrow", "setArrowColorResource", "setArrowSizeResource", "setArrowDrawableResource", "setArrowLeftPaddingResource", "setArrowRightPaddingResource", "setArrowTopPaddingResource", "setArrowBottomPaddingResource", "setArrowAlignAnchorPaddingResource", "setArrowElevationResource", "setBackgroundColorResource", "setBackgroundDrawableResource", "setCornerRadiusResource", "setTextResource", "setTextColorResource", "setTextSizeResource", "setTextLineSpacingResource", "setTextLetterSpacingResource", "setIconDrawableResource", "setIconWidthResource", "setIconHeightResource", "setIconSize", "setIconSizeResource", "setIconColorResource", "setIconSpaceResource", "setIconContentDescriptionResource", "setElevationResource", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/viewbinding/ViewBinding;", "binding", "(Landroidx/viewbinding/ViewBinding;)Lcom/skydoves/balloon/Balloon$Builder;", "setIsVisibleOverlay", "setOverlayColorResource", "setOverlayPaddingResource", "setOverlayPaddingColorResource", "shader", "gravity", "setIsStatusBarVisible", "setIsAttachedInDecor", "startDelay", "setBalloonHighlightAnimationResource", "setBalloonRotationAnimation", "block", "Lkotlin/Function1;", "Lkotlin/Function2;", "Landroid/view/MotionEvent;", "setShouldPassTouchEventToAnchor", "setShowCounts", "runnable", "Ljava/lang/Runnable;", "setRtlSupports", "isRtlSupport", "setIsComposableContent", "build", "Lcom/skydoves/balloon/Balloon;", "balloon_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder {
        private float alpha;
        private int arrowAlignAnchorPadding;
        private float arrowAlignAnchorPaddingRatio;
        private int arrowBottomPadding;
        private int arrowColor;
        private boolean arrowColorMatchBalloon;
        private Drawable arrowDrawable;
        private float arrowElevation;
        private int arrowLeftPadding;
        private ArrowOrientation arrowOrientation;
        private ArrowOrientationRules arrowOrientationRules;
        private float arrowPosition;
        private ArrowPositionRules arrowPositionRules;
        private int arrowRightPadding;
        private int arrowSize;
        private int arrowTopPadding;
        private long autoDismissDuration;
        private int backgroundColor;
        private Drawable backgroundDrawable;
        private BalloonAnimation balloonAnimation;
        private int balloonAnimationStyle;
        private BalloonHighlightAnimation balloonHighlightAnimation;
        private long balloonHighlightAnimationStartDelay;
        private int balloonHighlightAnimationStyle;
        private BalloonOverlayAnimation balloonOverlayAnimation;
        private int balloonOverlayAnimationStyle;
        private BalloonRotateAnimation balloonRotateAnimation;
        private long circularDuration;
        private final Context context;
        private float cornerRadius;
        private boolean dismissWhenClicked;
        private boolean dismissWhenLifecycleOnPause;
        private boolean dismissWhenOverlayClicked;
        private boolean dismissWhenShowAgain;
        private boolean dismissWhenTouchMargin;
        private boolean dismissWhenTouchOutside;
        private float elevation;
        private boolean enableAutoSized;
        private int height;
        private int iconColor;
        private CharSequence iconContentDescription;
        private Drawable iconDrawable;
        private IconForm iconForm;
        private IconGravity iconGravity;
        private int iconHeight;
        private int iconSpace;
        private int iconWidth;
        private boolean includeFontPadding;
        private boolean isAttachedInDecor;
        private boolean isComposableContent;
        private boolean isFocusable;
        private boolean isRtlLayout;
        private boolean isStatusBarVisible;
        private boolean isVisibleArrow;
        private boolean isVisibleOverlay;
        private View layout;
        private Integer layoutRes;
        private LifecycleObserver lifecycleObserver;
        private LifecycleOwner lifecycleOwner;
        private int marginBottom;
        private int marginLeft;
        private int marginRight;
        private int marginTop;
        private float maxAutoSizeTextSize;
        private int maxWidth;
        private float maxWidthRatio;
        private int measuredWidth;
        private float minAutoSizeTextSize;
        private int minWidth;
        private float minWidthRatio;
        private MovementMethod movementMethod;
        private OnBalloonClickListener onBalloonClickListener;
        private OnBalloonDismissListener onBalloonDismissListener;
        private OnBalloonInitializedListener onBalloonInitializedListener;
        private OnBalloonOutsideTouchListener onBalloonOutsideTouchListener;
        private OnBalloonOverlayClickListener onBalloonOverlayClickListener;
        private View.OnTouchListener onBalloonOverlayTouchListener;
        private View.OnTouchListener onBalloonTouchListener;
        private int overlayColor;
        private int overlayGravity;
        private float overlayPadding;
        private int overlayPaddingColor;
        private Shader overlayPaddingShader;
        private Point overlayPosition;
        private BalloonOverlayShape overlayShape;
        private int paddingBottom;
        private int paddingLeft;
        private int paddingRight;
        private int paddingTop;
        private boolean passTouchEventToAnchor;
        private String preferenceName;
        private Function0<Unit> runIfReachedShowCounts;
        private int showTimes;
        private int supportRtlLayoutFactor;
        private CharSequence text;
        private int textColor;
        private TextForm textForm;
        private int textGravity;
        private boolean textIsHtml;
        private Float textLetterSpacing;
        private Float textLineSpacing;
        private float textSize;
        private int textTypeface;
        private Typeface textTypefaceObject;
        private int width;
        private float widthRatio;

        public final Builder setBalloonHighlightAnimation(BalloonHighlightAnimation value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return setBalloonHighlightAnimation$default(this, value, 0L, 2, null);
        }

        public final Builder setBalloonHighlightAnimationResource(int i) {
            return setBalloonHighlightAnimationResource$default(this, i, 0L, 2, null);
        }

        public Builder(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
            this.width = Integer.MIN_VALUE;
            this.maxWidth = new Point(Resources.getSystem().getDisplayMetrics().widthPixels, Resources.getSystem().getDisplayMetrics().heightPixels).x;
            this.measuredWidth = Integer.MIN_VALUE;
            this.height = Integer.MIN_VALUE;
            this.isVisibleArrow = true;
            this.arrowColor = Integer.MIN_VALUE;
            this.arrowSize = MathKt.roundToInt(TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics()));
            this.arrowPosition = 0.5f;
            this.arrowPositionRules = ArrowPositionRules.ALIGN_BALLOON;
            this.arrowOrientationRules = ArrowOrientationRules.ALIGN_ANCHOR;
            this.arrowOrientation = ArrowOrientation.BOTTOM;
            this.arrowAlignAnchorPaddingRatio = 2.5f;
            this.backgroundColor = ViewCompat.MEASURED_STATE_MASK;
            this.cornerRadius = TypedValue.applyDimension(1, 5.0f, Resources.getSystem().getDisplayMetrics());
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            this.text = "";
            this.textColor = -1;
            this.textSize = 12.0f;
            this.minAutoSizeTextSize = 12.0f;
            this.maxAutoSizeTextSize = 12.0f + 1;
            this.includeFontPadding = true;
            this.textGravity = 17;
            this.iconGravity = IconGravity.START;
            float f = 28;
            this.iconWidth = MathKt.roundToInt(TypedValue.applyDimension(1, f, Resources.getSystem().getDisplayMetrics()));
            this.iconHeight = MathKt.roundToInt(TypedValue.applyDimension(1, f, Resources.getSystem().getDisplayMetrics()));
            this.iconSpace = MathKt.roundToInt(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics()));
            this.iconColor = Integer.MIN_VALUE;
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            this.iconContentDescription = "";
            this.alpha = 1.0f;
            this.elevation = TypedValue.applyDimension(1, 2.0f, Resources.getSystem().getDisplayMetrics());
            this.overlayShape = BalloonOverlayOval.INSTANCE;
            this.overlayGravity = 17;
            this.dismissWhenTouchOutside = true;
            this.dismissWhenTouchMargin = true;
            this.dismissWhenOverlayClicked = true;
            this.autoDismissDuration = -1L;
            this.balloonAnimationStyle = Integer.MIN_VALUE;
            this.balloonOverlayAnimationStyle = Integer.MIN_VALUE;
            this.balloonAnimation = BalloonAnimation.FADE;
            this.balloonOverlayAnimation = BalloonOverlayAnimation.FADE;
            this.circularDuration = 500L;
            this.balloonHighlightAnimation = BalloonHighlightAnimation.NONE;
            this.balloonHighlightAnimationStyle = Integer.MIN_VALUE;
            this.showTimes = 1;
            boolean z = context.getResources().getConfiguration().getLayoutDirection() == 1;
            this.isRtlLayout = z;
            this.supportRtlLayoutFactor = DefinitionKt.unaryMinus(1, z);
            this.isFocusable = true;
            this.isStatusBarVisible = true;
            this.isAttachedInDecor = true;
        }

        public final int getWidth() {
            return this.width;
        }

        /* JADX INFO: renamed from: setWidth, reason: collision with other method in class */
        public final /* synthetic */ void m3725setWidth(int i) {
            this.width = i;
        }

        public final int getMinWidth() {
            return this.minWidth;
        }

        /* JADX INFO: renamed from: setMinWidth, reason: collision with other method in class */
        public final /* synthetic */ void m3696setMinWidth(int i) {
            this.minWidth = i;
        }

        public final int getMaxWidth() {
            return this.maxWidth;
        }

        /* JADX INFO: renamed from: setMaxWidth, reason: collision with other method in class */
        public final /* synthetic */ void m3692setMaxWidth(int i) {
            this.maxWidth = i;
        }

        public final float getWidthRatio() {
            return this.widthRatio;
        }

        /* JADX INFO: renamed from: setWidthRatio, reason: collision with other method in class */
        public final /* synthetic */ void m3726setWidthRatio(float f) {
            this.widthRatio = f;
        }

        public final float getMinWidthRatio() {
            return this.minWidthRatio;
        }

        /* JADX INFO: renamed from: setMinWidthRatio, reason: collision with other method in class */
        public final /* synthetic */ void m3697setMinWidthRatio(float f) {
            this.minWidthRatio = f;
        }

        public final float getMaxWidthRatio() {
            return this.maxWidthRatio;
        }

        /* JADX INFO: renamed from: setMaxWidthRatio, reason: collision with other method in class */
        public final /* synthetic */ void m3693setMaxWidthRatio(float f) {
            this.maxWidthRatio = f;
        }

        public final int getMeasuredWidth() {
            return this.measuredWidth;
        }

        /* JADX INFO: renamed from: setMeasuredWidth, reason: collision with other method in class */
        public final /* synthetic */ void m3694setMeasuredWidth(int i) {
            this.measuredWidth = i;
        }

        public final int getHeight() {
            return this.height;
        }

        /* JADX INFO: renamed from: setHeight, reason: collision with other method in class */
        public final /* synthetic */ void m3674setHeight(int i) {
            this.height = i;
        }

        public final int getPaddingLeft() {
            return this.paddingLeft;
        }

        /* JADX INFO: renamed from: setPaddingLeft, reason: collision with other method in class */
        public final /* synthetic */ void m3714setPaddingLeft(int i) {
            this.paddingLeft = i;
        }

        public final int getPaddingTop() {
            return this.paddingTop;
        }

        /* JADX INFO: renamed from: setPaddingTop, reason: collision with other method in class */
        public final /* synthetic */ void m3716setPaddingTop(int i) {
            this.paddingTop = i;
        }

        public final int getPaddingRight() {
            return this.paddingRight;
        }

        /* JADX INFO: renamed from: setPaddingRight, reason: collision with other method in class */
        public final /* synthetic */ void m3715setPaddingRight(int i) {
            this.paddingRight = i;
        }

        public final int getPaddingBottom() {
            return this.paddingBottom;
        }

        /* JADX INFO: renamed from: setPaddingBottom, reason: collision with other method in class */
        public final /* synthetic */ void m3713setPaddingBottom(int i) {
            this.paddingBottom = i;
        }

        public final int getMarginRight() {
            return this.marginRight;
        }

        /* JADX INFO: renamed from: setMarginRight, reason: collision with other method in class */
        public final /* synthetic */ void m3689setMarginRight(int i) {
            this.marginRight = i;
        }

        public final int getMarginLeft() {
            return this.marginLeft;
        }

        /* JADX INFO: renamed from: setMarginLeft, reason: collision with other method in class */
        public final /* synthetic */ void m3688setMarginLeft(int i) {
            this.marginLeft = i;
        }

        public final int getMarginTop() {
            return this.marginTop;
        }

        /* JADX INFO: renamed from: setMarginTop, reason: collision with other method in class */
        public final /* synthetic */ void m3690setMarginTop(int i) {
            this.marginTop = i;
        }

        public final int getMarginBottom() {
            return this.marginBottom;
        }

        /* JADX INFO: renamed from: setMarginBottom, reason: collision with other method in class */
        public final /* synthetic */ void m3687setMarginBottom(int i) {
            this.marginBottom = i;
        }

        /* JADX INFO: renamed from: isVisibleArrow, reason: from getter */
        public final boolean getIsVisibleArrow() {
            return this.isVisibleArrow;
        }

        public final /* synthetic */ void setVisibleArrow(boolean z) {
            this.isVisibleArrow = z;
        }

        public final int getArrowColor() {
            return this.arrowColor;
        }

        /* JADX INFO: renamed from: setArrowColor, reason: collision with other method in class */
        public final /* synthetic */ void m3645setArrowColor(int i) {
            this.arrowColor = i;
        }

        public final boolean getArrowColorMatchBalloon() {
            return this.arrowColorMatchBalloon;
        }

        /* JADX INFO: renamed from: setArrowColorMatchBalloon, reason: collision with other method in class */
        public final /* synthetic */ void m3646setArrowColorMatchBalloon(boolean z) {
            this.arrowColorMatchBalloon = z;
        }

        public final int getArrowSize() {
            return this.arrowSize;
        }

        /* JADX INFO: renamed from: setArrowSize, reason: collision with other method in class */
        public final /* synthetic */ void m3654setArrowSize(int i) {
            this.arrowSize = i;
        }

        public final /* synthetic */ float getArrowHalfSize() {
            return getArrowSize() * 0.5f;
        }

        public final float getArrowPosition() {
            return this.arrowPosition;
        }

        /* JADX INFO: renamed from: setArrowPosition, reason: collision with other method in class */
        public final /* synthetic */ void m3651setArrowPosition(float f) {
            this.arrowPosition = f;
        }

        public final ArrowPositionRules getArrowPositionRules() {
            return this.arrowPositionRules;
        }

        /* JADX INFO: renamed from: setArrowPositionRules, reason: collision with other method in class */
        public final /* synthetic */ void m3652setArrowPositionRules(ArrowPositionRules arrowPositionRules) {
            Intrinsics.checkNotNullParameter(arrowPositionRules, "<set-?>");
            this.arrowPositionRules = arrowPositionRules;
        }

        public final ArrowOrientationRules getArrowOrientationRules() {
            return this.arrowOrientationRules;
        }

        /* JADX INFO: renamed from: setArrowOrientationRules, reason: collision with other method in class */
        public final /* synthetic */ void m3650setArrowOrientationRules(ArrowOrientationRules arrowOrientationRules) {
            Intrinsics.checkNotNullParameter(arrowOrientationRules, "<set-?>");
            this.arrowOrientationRules = arrowOrientationRules;
        }

        public final ArrowOrientation getArrowOrientation() {
            return this.arrowOrientation;
        }

        /* JADX INFO: renamed from: setArrowOrientation, reason: collision with other method in class */
        public final /* synthetic */ void m3649setArrowOrientation(ArrowOrientation arrowOrientation) {
            Intrinsics.checkNotNullParameter(arrowOrientation, "<set-?>");
            this.arrowOrientation = arrowOrientation;
        }

        public final Drawable getArrowDrawable() {
            return this.arrowDrawable;
        }

        /* JADX INFO: renamed from: setArrowDrawable, reason: collision with other method in class */
        public final /* synthetic */ void m3647setArrowDrawable(Drawable drawable) {
            this.arrowDrawable = drawable;
        }

        public final int getArrowLeftPadding() {
            return this.arrowLeftPadding;
        }

        /* JADX INFO: renamed from: setArrowLeftPadding, reason: collision with other method in class */
        public final /* synthetic */ void m3648setArrowLeftPadding(int i) {
            this.arrowLeftPadding = i;
        }

        public final int getArrowRightPadding() {
            return this.arrowRightPadding;
        }

        /* JADX INFO: renamed from: setArrowRightPadding, reason: collision with other method in class */
        public final /* synthetic */ void m3653setArrowRightPadding(int i) {
            this.arrowRightPadding = i;
        }

        public final int getArrowTopPadding() {
            return this.arrowTopPadding;
        }

        /* JADX INFO: renamed from: setArrowTopPadding, reason: collision with other method in class */
        public final /* synthetic */ void m3655setArrowTopPadding(int i) {
            this.arrowTopPadding = i;
        }

        public final int getArrowBottomPadding() {
            return this.arrowBottomPadding;
        }

        /* JADX INFO: renamed from: setArrowBottomPadding, reason: collision with other method in class */
        public final /* synthetic */ void m3644setArrowBottomPadding(int i) {
            this.arrowBottomPadding = i;
        }

        public final int getArrowAlignAnchorPadding() {
            return this.arrowAlignAnchorPadding;
        }

        /* JADX INFO: renamed from: setArrowAlignAnchorPadding, reason: collision with other method in class */
        public final /* synthetic */ void m3642setArrowAlignAnchorPadding(int i) {
            this.arrowAlignAnchorPadding = i;
        }

        public final float getArrowAlignAnchorPaddingRatio() {
            return this.arrowAlignAnchorPaddingRatio;
        }

        /* JADX INFO: renamed from: setArrowAlignAnchorPaddingRatio, reason: collision with other method in class */
        public final /* synthetic */ void m3643setArrowAlignAnchorPaddingRatio(float f) {
            this.arrowAlignAnchorPaddingRatio = f;
        }

        public final float getArrowElevation() {
            return this.arrowElevation;
        }

        public final /* synthetic */ void setArrowElevation(float f) {
            this.arrowElevation = f;
        }

        public final int getBackgroundColor() {
            return this.backgroundColor;
        }

        /* JADX INFO: renamed from: setBackgroundColor, reason: collision with other method in class */
        public final /* synthetic */ void m3657setBackgroundColor(int i) {
            this.backgroundColor = i;
        }

        public final Drawable getBackgroundDrawable() {
            return this.backgroundDrawable;
        }

        /* JADX INFO: renamed from: setBackgroundDrawable, reason: collision with other method in class */
        public final /* synthetic */ void m3658setBackgroundDrawable(Drawable drawable) {
            this.backgroundDrawable = drawable;
        }

        public final float getCornerRadius() {
            return this.cornerRadius;
        }

        /* JADX INFO: renamed from: setCornerRadius, reason: collision with other method in class */
        public final /* synthetic */ void m3665setCornerRadius(float f) {
            this.cornerRadius = f;
        }

        public final CharSequence getText() {
            return this.text;
        }

        /* JADX INFO: renamed from: setText, reason: collision with other method in class */
        public final /* synthetic */ void m3718setText(CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(charSequence, "<set-?>");
            this.text = charSequence;
        }

        public final int getTextColor() {
            return this.textColor;
        }

        /* JADX INFO: renamed from: setTextColor, reason: collision with other method in class */
        public final /* synthetic */ void m3719setTextColor(int i) {
            this.textColor = i;
        }

        public final boolean getTextIsHtml() {
            return this.textIsHtml;
        }

        /* JADX INFO: renamed from: setTextIsHtml, reason: collision with other method in class */
        public final /* synthetic */ void m3722setTextIsHtml(boolean z) {
            this.textIsHtml = z;
        }

        public final MovementMethod getMovementMethod() {
            return this.movementMethod;
        }

        /* JADX INFO: renamed from: setMovementMethod, reason: collision with other method in class */
        public final /* synthetic */ void m3698setMovementMethod(MovementMethod movementMethod) {
            this.movementMethod = movementMethod;
        }

        public final float getTextSize() {
            return this.textSize;
        }

        /* JADX INFO: renamed from: setTextSize, reason: collision with other method in class */
        public final /* synthetic */ void m3723setTextSize(float f) {
            this.textSize = f;
        }

        public final boolean getEnableAutoSized() {
            return this.enableAutoSized;
        }

        /* JADX INFO: renamed from: setEnableAutoSized, reason: collision with other method in class */
        public final /* synthetic */ void m3672setEnableAutoSized(boolean z) {
            this.enableAutoSized = z;
        }

        public final float getMinAutoSizeTextSize() {
            return this.minAutoSizeTextSize;
        }

        /* JADX INFO: renamed from: setMinAutoSizeTextSize, reason: collision with other method in class */
        public final /* synthetic */ void m3695setMinAutoSizeTextSize(float f) {
            this.minAutoSizeTextSize = f;
        }

        public final float getMaxAutoSizeTextSize() {
            return this.maxAutoSizeTextSize;
        }

        /* JADX INFO: renamed from: setMaxAutoSizeTextSize, reason: collision with other method in class */
        public final /* synthetic */ void m3691setMaxAutoSizeTextSize(float f) {
            this.maxAutoSizeTextSize = f;
        }

        public final int getTextTypeface() {
            return this.textTypeface;
        }

        /* JADX INFO: renamed from: setTextTypeface, reason: collision with other method in class */
        public final /* synthetic */ void m3724setTextTypeface(int i) {
            this.textTypeface = i;
        }

        public final Typeface getTextTypefaceObject() {
            return this.textTypefaceObject;
        }

        public final /* synthetic */ void setTextTypefaceObject(Typeface typeface) {
            this.textTypefaceObject = typeface;
        }

        public final Float getTextLineSpacing() {
            return this.textLineSpacing;
        }

        public final /* synthetic */ void setTextLineSpacing(Float f) {
            this.textLineSpacing = f;
        }

        public final Float getTextLetterSpacing() {
            return this.textLetterSpacing;
        }

        public final /* synthetic */ void setTextLetterSpacing(Float f) {
            this.textLetterSpacing = f;
        }

        public final boolean getIncludeFontPadding() {
            return this.includeFontPadding;
        }

        /* JADX INFO: renamed from: setIncludeFontPadding, reason: collision with other method in class */
        public final /* synthetic */ void m3683setIncludeFontPadding(boolean z) {
            this.includeFontPadding = z;
        }

        public final int getTextGravity() {
            return this.textGravity;
        }

        /* JADX INFO: renamed from: setTextGravity, reason: collision with other method in class */
        public final /* synthetic */ void m3721setTextGravity(int i) {
            this.textGravity = i;
        }

        public final TextForm getTextForm() {
            return this.textForm;
        }

        /* JADX INFO: renamed from: setTextForm, reason: collision with other method in class */
        public final /* synthetic */ void m3720setTextForm(TextForm textForm) {
            this.textForm = textForm;
        }

        public final Drawable getIconDrawable() {
            return this.iconDrawable;
        }

        /* JADX INFO: renamed from: setIconDrawable, reason: collision with other method in class */
        public final /* synthetic */ void m3677setIconDrawable(Drawable drawable) {
            this.iconDrawable = drawable;
        }

        public final IconGravity getIconGravity() {
            return this.iconGravity;
        }

        /* JADX INFO: renamed from: setIconGravity, reason: collision with other method in class */
        public final /* synthetic */ void m3679setIconGravity(IconGravity iconGravity) {
            Intrinsics.checkNotNullParameter(iconGravity, "<set-?>");
            this.iconGravity = iconGravity;
        }

        public final int getIconWidth() {
            return this.iconWidth;
        }

        /* JADX INFO: renamed from: setIconWidth, reason: collision with other method in class */
        public final /* synthetic */ void m3682setIconWidth(int i) {
            this.iconWidth = i;
        }

        public final int getIconHeight() {
            return this.iconHeight;
        }

        /* JADX INFO: renamed from: setIconHeight, reason: collision with other method in class */
        public final /* synthetic */ void m3680setIconHeight(int i) {
            this.iconHeight = i;
        }

        public final int getIconSpace() {
            return this.iconSpace;
        }

        /* JADX INFO: renamed from: setIconSpace, reason: collision with other method in class */
        public final /* synthetic */ void m3681setIconSpace(int i) {
            this.iconSpace = i;
        }

        public final int getIconColor() {
            return this.iconColor;
        }

        /* JADX INFO: renamed from: setIconColor, reason: collision with other method in class */
        public final /* synthetic */ void m3675setIconColor(int i) {
            this.iconColor = i;
        }

        public final IconForm getIconForm() {
            return this.iconForm;
        }

        /* JADX INFO: renamed from: setIconForm, reason: collision with other method in class */
        public final /* synthetic */ void m3678setIconForm(IconForm iconForm) {
            this.iconForm = iconForm;
        }

        public final CharSequence getIconContentDescription() {
            return this.iconContentDescription;
        }

        /* JADX INFO: renamed from: setIconContentDescription, reason: collision with other method in class */
        public final /* synthetic */ void m3676setIconContentDescription(CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(charSequence, "<set-?>");
            this.iconContentDescription = charSequence;
        }

        public final float getAlpha() {
            return this.alpha;
        }

        /* JADX INFO: renamed from: setAlpha, reason: collision with other method in class */
        public final /* synthetic */ void m3641setAlpha(float f) {
            this.alpha = f;
        }

        public final float getElevation() {
            return this.elevation;
        }

        public final /* synthetic */ void setElevation(float f) {
            this.elevation = f;
        }

        public final View getLayout() {
            return this.layout;
        }

        /* JADX INFO: renamed from: setLayout, reason: collision with other method in class */
        public final /* synthetic */ void m3684setLayout(View view) {
            this.layout = view;
        }

        public final Integer getLayoutRes() {
            return this.layoutRes;
        }

        public final /* synthetic */ void setLayoutRes(Integer num) {
            this.layoutRes = num;
        }

        /* JADX INFO: renamed from: isVisibleOverlay, reason: from getter */
        public final boolean getIsVisibleOverlay() {
            return this.isVisibleOverlay;
        }

        public final /* synthetic */ void setVisibleOverlay(boolean z) {
            this.isVisibleOverlay = z;
        }

        public final int getOverlayColor() {
            return this.overlayColor;
        }

        /* JADX INFO: renamed from: setOverlayColor, reason: collision with other method in class */
        public final /* synthetic */ void m3706setOverlayColor(int i) {
            this.overlayColor = i;
        }

        public final float getOverlayPadding() {
            return this.overlayPadding;
        }

        /* JADX INFO: renamed from: setOverlayPadding, reason: collision with other method in class */
        public final /* synthetic */ void m3708setOverlayPadding(float f) {
            this.overlayPadding = f;
        }

        public final int getOverlayPaddingColor() {
            return this.overlayPaddingColor;
        }

        /* JADX INFO: renamed from: setOverlayPaddingColor, reason: collision with other method in class */
        public final /* synthetic */ void m3709setOverlayPaddingColor(int i) {
            this.overlayPaddingColor = i;
        }

        public final Shader getOverlayPaddingShader() {
            return this.overlayPaddingShader;
        }

        /* JADX INFO: renamed from: setOverlayPaddingShader, reason: collision with other method in class */
        public final /* synthetic */ void m3710setOverlayPaddingShader(Shader shader) {
            this.overlayPaddingShader = shader;
        }

        public final Point getOverlayPosition() {
            return this.overlayPosition;
        }

        /* JADX INFO: renamed from: setOverlayPosition, reason: collision with other method in class */
        public final /* synthetic */ void m3711setOverlayPosition(Point point) {
            this.overlayPosition = point;
        }

        public final BalloonOverlayShape getOverlayShape() {
            return this.overlayShape;
        }

        /* JADX INFO: renamed from: setOverlayShape, reason: collision with other method in class */
        public final /* synthetic */ void m3712setOverlayShape(BalloonOverlayShape balloonOverlayShape) {
            Intrinsics.checkNotNullParameter(balloonOverlayShape, "<set-?>");
            this.overlayShape = balloonOverlayShape;
        }

        public final int getOverlayGravity() {
            return this.overlayGravity;
        }

        /* JADX INFO: renamed from: setOverlayGravity, reason: collision with other method in class */
        public final /* synthetic */ void m3707setOverlayGravity(int i) {
            this.overlayGravity = i;
        }

        public final OnBalloonClickListener getOnBalloonClickListener() {
            return this.onBalloonClickListener;
        }

        /* JADX INFO: renamed from: setOnBalloonClickListener, reason: collision with other method in class */
        public final /* synthetic */ void m3699setOnBalloonClickListener(OnBalloonClickListener onBalloonClickListener) {
            this.onBalloonClickListener = onBalloonClickListener;
        }

        public final OnBalloonDismissListener getOnBalloonDismissListener() {
            return this.onBalloonDismissListener;
        }

        /* JADX INFO: renamed from: setOnBalloonDismissListener, reason: collision with other method in class */
        public final /* synthetic */ void m3700setOnBalloonDismissListener(OnBalloonDismissListener onBalloonDismissListener) {
            this.onBalloonDismissListener = onBalloonDismissListener;
        }

        public final OnBalloonInitializedListener getOnBalloonInitializedListener() {
            return this.onBalloonInitializedListener;
        }

        /* JADX INFO: renamed from: setOnBalloonInitializedListener, reason: collision with other method in class */
        public final /* synthetic */ void m3701setOnBalloonInitializedListener(OnBalloonInitializedListener onBalloonInitializedListener) {
            this.onBalloonInitializedListener = onBalloonInitializedListener;
        }

        public final OnBalloonOutsideTouchListener getOnBalloonOutsideTouchListener() {
            return this.onBalloonOutsideTouchListener;
        }

        /* JADX INFO: renamed from: setOnBalloonOutsideTouchListener, reason: collision with other method in class */
        public final /* synthetic */ void m3702setOnBalloonOutsideTouchListener(OnBalloonOutsideTouchListener onBalloonOutsideTouchListener) {
            this.onBalloonOutsideTouchListener = onBalloonOutsideTouchListener;
        }

        public final View.OnTouchListener getOnBalloonTouchListener() {
            return this.onBalloonTouchListener;
        }

        /* JADX INFO: renamed from: setOnBalloonTouchListener, reason: collision with other method in class */
        public final /* synthetic */ void m3705setOnBalloonTouchListener(View.OnTouchListener onTouchListener) {
            this.onBalloonTouchListener = onTouchListener;
        }

        public final View.OnTouchListener getOnBalloonOverlayTouchListener() {
            return this.onBalloonOverlayTouchListener;
        }

        /* JADX INFO: renamed from: setOnBalloonOverlayTouchListener, reason: collision with other method in class */
        public final /* synthetic */ void m3704setOnBalloonOverlayTouchListener(View.OnTouchListener onTouchListener) {
            this.onBalloonOverlayTouchListener = onTouchListener;
        }

        public final OnBalloonOverlayClickListener getOnBalloonOverlayClickListener() {
            return this.onBalloonOverlayClickListener;
        }

        /* JADX INFO: renamed from: setOnBalloonOverlayClickListener, reason: collision with other method in class */
        public final /* synthetic */ void m3703setOnBalloonOverlayClickListener(OnBalloonOverlayClickListener onBalloonOverlayClickListener) {
            this.onBalloonOverlayClickListener = onBalloonOverlayClickListener;
        }

        public final boolean getDismissWhenTouchOutside() {
            return this.dismissWhenTouchOutside;
        }

        /* JADX INFO: renamed from: setDismissWhenTouchOutside, reason: collision with other method in class */
        public final /* synthetic */ void m3671setDismissWhenTouchOutside(boolean z) {
            this.dismissWhenTouchOutside = z;
        }

        public final boolean getDismissWhenTouchMargin() {
            return this.dismissWhenTouchMargin;
        }

        /* JADX INFO: renamed from: setDismissWhenTouchMargin, reason: collision with other method in class */
        public final /* synthetic */ void m3670setDismissWhenTouchMargin(boolean z) {
            this.dismissWhenTouchMargin = z;
        }

        public final boolean getDismissWhenShowAgain() {
            return this.dismissWhenShowAgain;
        }

        /* JADX INFO: renamed from: setDismissWhenShowAgain, reason: collision with other method in class */
        public final /* synthetic */ void m3669setDismissWhenShowAgain(boolean z) {
            this.dismissWhenShowAgain = z;
        }

        public final boolean getDismissWhenClicked() {
            return this.dismissWhenClicked;
        }

        /* JADX INFO: renamed from: setDismissWhenClicked, reason: collision with other method in class */
        public final /* synthetic */ void m3666setDismissWhenClicked(boolean z) {
            this.dismissWhenClicked = z;
        }

        public final boolean getDismissWhenOverlayClicked() {
            return this.dismissWhenOverlayClicked;
        }

        /* JADX INFO: renamed from: setDismissWhenOverlayClicked, reason: collision with other method in class */
        public final /* synthetic */ void m3668setDismissWhenOverlayClicked(boolean z) {
            this.dismissWhenOverlayClicked = z;
        }

        public final boolean getDismissWhenLifecycleOnPause() {
            return this.dismissWhenLifecycleOnPause;
        }

        /* JADX INFO: renamed from: setDismissWhenLifecycleOnPause, reason: collision with other method in class */
        public final /* synthetic */ void m3667setDismissWhenLifecycleOnPause(boolean z) {
            this.dismissWhenLifecycleOnPause = z;
        }

        public final boolean getPassTouchEventToAnchor() {
            return this.passTouchEventToAnchor;
        }

        public final /* synthetic */ void setPassTouchEventToAnchor(boolean z) {
            this.passTouchEventToAnchor = z;
        }

        public final long getAutoDismissDuration() {
            return this.autoDismissDuration;
        }

        /* JADX INFO: renamed from: setAutoDismissDuration, reason: collision with other method in class */
        public final /* synthetic */ void m3656setAutoDismissDuration(long j) {
            this.autoDismissDuration = j;
        }

        public final LifecycleOwner getLifecycleOwner() {
            return this.lifecycleOwner;
        }

        /* JADX INFO: renamed from: setLifecycleOwner, reason: collision with other method in class */
        public final /* synthetic */ void m3686setLifecycleOwner(LifecycleOwner lifecycleOwner) {
            this.lifecycleOwner = lifecycleOwner;
        }

        public final LifecycleObserver getLifecycleObserver() {
            return this.lifecycleObserver;
        }

        /* JADX INFO: renamed from: setLifecycleObserver, reason: collision with other method in class */
        public final /* synthetic */ void m3685setLifecycleObserver(LifecycleObserver lifecycleObserver) {
            this.lifecycleObserver = lifecycleObserver;
        }

        public final int getBalloonAnimationStyle() {
            return this.balloonAnimationStyle;
        }

        /* JADX INFO: renamed from: setBalloonAnimationStyle, reason: collision with other method in class */
        public final /* synthetic */ void m3660setBalloonAnimationStyle(int i) {
            this.balloonAnimationStyle = i;
        }

        public final int getBalloonOverlayAnimationStyle() {
            return this.balloonOverlayAnimationStyle;
        }

        /* JADX INFO: renamed from: setBalloonOverlayAnimationStyle, reason: collision with other method in class */
        public final /* synthetic */ void m3663setBalloonOverlayAnimationStyle(int i) {
            this.balloonOverlayAnimationStyle = i;
        }

        public final BalloonAnimation getBalloonAnimation() {
            return this.balloonAnimation;
        }

        /* JADX INFO: renamed from: setBalloonAnimation, reason: collision with other method in class */
        public final /* synthetic */ void m3659setBalloonAnimation(BalloonAnimation balloonAnimation) {
            Intrinsics.checkNotNullParameter(balloonAnimation, "<set-?>");
            this.balloonAnimation = balloonAnimation;
        }

        public final BalloonOverlayAnimation getBalloonOverlayAnimation() {
            return this.balloonOverlayAnimation;
        }

        /* JADX INFO: renamed from: setBalloonOverlayAnimation, reason: collision with other method in class */
        public final /* synthetic */ void m3662setBalloonOverlayAnimation(BalloonOverlayAnimation balloonOverlayAnimation) {
            Intrinsics.checkNotNullParameter(balloonOverlayAnimation, "<set-?>");
            this.balloonOverlayAnimation = balloonOverlayAnimation;
        }

        public final long getCircularDuration() {
            return this.circularDuration;
        }

        /* JADX INFO: renamed from: setCircularDuration, reason: collision with other method in class */
        public final /* synthetic */ void m3664setCircularDuration(long j) {
            this.circularDuration = j;
        }

        public final BalloonHighlightAnimation getBalloonHighlightAnimation() {
            return this.balloonHighlightAnimation;
        }

        /* JADX INFO: renamed from: setBalloonHighlightAnimation, reason: collision with other method in class */
        public final /* synthetic */ void m3661setBalloonHighlightAnimation(BalloonHighlightAnimation balloonHighlightAnimation) {
            Intrinsics.checkNotNullParameter(balloonHighlightAnimation, "<set-?>");
            this.balloonHighlightAnimation = balloonHighlightAnimation;
        }

        public final int getBalloonHighlightAnimationStyle() {
            return this.balloonHighlightAnimationStyle;
        }

        public final /* synthetic */ void setBalloonHighlightAnimationStyle(int i) {
            this.balloonHighlightAnimationStyle = i;
        }

        public final long getBalloonHighlightAnimationStartDelay() {
            return this.balloonHighlightAnimationStartDelay;
        }

        public final /* synthetic */ void setBalloonHighlightAnimationStartDelay(long j) {
            this.balloonHighlightAnimationStartDelay = j;
        }

        public final BalloonRotateAnimation getBalloonRotateAnimation() {
            return this.balloonRotateAnimation;
        }

        public final /* synthetic */ void setBalloonRotateAnimation(BalloonRotateAnimation balloonRotateAnimation) {
            this.balloonRotateAnimation = balloonRotateAnimation;
        }

        public final String getPreferenceName() {
            return this.preferenceName;
        }

        /* JADX INFO: renamed from: setPreferenceName, reason: collision with other method in class */
        public final /* synthetic */ void m3717setPreferenceName(String str) {
            this.preferenceName = str;
        }

        public final int getShowTimes() {
            return this.showTimes;
        }

        public final /* synthetic */ void setShowTimes(int i) {
            this.showTimes = i;
        }

        public final Function0<Unit> getRunIfReachedShowCounts() {
            return this.runIfReachedShowCounts;
        }

        public final /* synthetic */ void setRunIfReachedShowCounts(Function0 function0) {
            this.runIfReachedShowCounts = function0;
        }

        /* JADX INFO: renamed from: isRtlLayout, reason: from getter */
        public final boolean getIsRtlLayout() {
            return this.isRtlLayout;
        }

        public final /* synthetic */ void setRtlLayout(boolean z) {
            this.isRtlLayout = z;
        }

        public final int getSupportRtlLayoutFactor() {
            return this.supportRtlLayoutFactor;
        }

        public final /* synthetic */ void setSupportRtlLayoutFactor(int i) {
            this.supportRtlLayoutFactor = i;
        }

        /* JADX INFO: renamed from: isFocusable, reason: from getter */
        public final boolean getIsFocusable() {
            return this.isFocusable;
        }

        /* JADX INFO: renamed from: setFocusable, reason: collision with other method in class */
        public final /* synthetic */ void m3673setFocusable(boolean z) {
            this.isFocusable = z;
        }

        /* JADX INFO: renamed from: isStatusBarVisible, reason: from getter */
        public final boolean getIsStatusBarVisible() {
            return this.isStatusBarVisible;
        }

        public final /* synthetic */ void setStatusBarVisible(boolean z) {
            this.isStatusBarVisible = z;
        }

        /* JADX INFO: renamed from: isAttachedInDecor, reason: from getter */
        public final boolean getIsAttachedInDecor() {
            return this.isAttachedInDecor;
        }

        public final /* synthetic */ void setAttachedInDecor(boolean z) {
            this.isAttachedInDecor = z;
        }

        /* JADX INFO: renamed from: isComposableContent, reason: from getter */
        public final boolean getIsComposableContent() {
            return this.isComposableContent;
        }

        public final /* synthetic */ void setComposableContent(boolean z) {
            this.isComposableContent = z;
        }

        public final Builder setWidth(int value) {
            if (value <= 0 && value != Integer.MIN_VALUE) {
                throw new IllegalArgumentException("The width of the balloon must bigger than zero.".toString());
            }
            this.width = MathKt.roundToInt(TypedValue.applyDimension(1, value, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final Builder setWidthResource(int value) {
            this.width = ContextExtensionKt.dimenPixel(this.context, value);
            return this;
        }

        public final Builder setMinWidth(int value) {
            this.minWidth = MathKt.roundToInt(TypedValue.applyDimension(1, value, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final Builder setMinWidthResource(int value) {
            this.minWidth = ContextExtensionKt.dimenPixel(this.context, value);
            return this;
        }

        public final Builder setMaxWidth(int value) {
            this.maxWidth = MathKt.roundToInt(TypedValue.applyDimension(1, value, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final Builder setMaxWidthResource(int value) {
            this.maxWidth = ContextExtensionKt.dimenPixel(this.context, value);
            return this;
        }

        public final Builder setWidthRatio(float value) {
            this.widthRatio = value;
            return this;
        }

        public final Builder setMinWidthRatio(float value) {
            this.minWidthRatio = value;
            return this;
        }

        public final Builder setMaxWidthRatio(float value) {
            this.maxWidthRatio = value;
            return this;
        }

        public final Builder setMeasuredWidth(int value) {
            if (value <= 0 && value != Integer.MIN_VALUE) {
                throw new IllegalArgumentException("The width of the balloon must bigger than zero.".toString());
            }
            this.measuredWidth = value;
            return this;
        }

        public final Builder setHeight(int value) {
            if (value <= 0 && value != Integer.MIN_VALUE) {
                throw new IllegalArgumentException("The height of the balloon must bigger than zero.".toString());
            }
            this.height = MathKt.roundToInt(TypedValue.applyDimension(1, value, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final Builder setHeightResource(int value) {
            this.height = ContextExtensionKt.dimenPixel(this.context, value);
            return this;
        }

        public final Builder setSize(int width, int height) {
            setWidth(width);
            setHeight(height);
            return this;
        }

        public final Builder setSizeResource(int width, int height) {
            setWidthResource(width);
            setHeightResource(height);
            return this;
        }

        public final Builder setPadding(int value) {
            setPaddingLeft(value);
            setPaddingTop(value);
            setPaddingRight(value);
            setPaddingBottom(value);
            return this;
        }

        public final Builder setPaddingResource(int value) {
            int iDimenPixel = ContextExtensionKt.dimenPixel(this.context, value);
            this.paddingLeft = iDimenPixel;
            this.paddingTop = iDimenPixel;
            this.paddingRight = iDimenPixel;
            this.paddingBottom = iDimenPixel;
            return this;
        }

        public final Builder setPaddingHorizontal(int value) {
            setPaddingLeft(value);
            setPaddingRight(value);
            return this;
        }

        public final Builder setPaddingHorizontalResource(int value) {
            setPaddingLeftResource(value);
            setPaddingRightResource(value);
            return this;
        }

        public final Builder setPaddingVertical(int value) {
            setPaddingTop(value);
            setPaddingBottom(value);
            return this;
        }

        public final Builder setPaddingVerticalResource(int value) {
            setPaddingTopResource(value);
            setPaddingBottomResource(value);
            return this;
        }

        public final Builder setPaddingLeft(int value) {
            this.paddingLeft = MathKt.roundToInt(TypedValue.applyDimension(1, value, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final Builder setPaddingLeftResource(int value) {
            this.paddingLeft = ContextExtensionKt.dimenPixel(this.context, value);
            return this;
        }

        public final Builder setPaddingTop(int value) {
            this.paddingTop = MathKt.roundToInt(TypedValue.applyDimension(1, value, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final Builder setPaddingTopResource(int value) {
            this.paddingTop = ContextExtensionKt.dimenPixel(this.context, value);
            return this;
        }

        public final Builder setPaddingRight(int value) {
            this.paddingRight = MathKt.roundToInt(TypedValue.applyDimension(1, value, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final Builder setPaddingRightResource(int value) {
            this.paddingRight = ContextExtensionKt.dimenPixel(this.context, value);
            return this;
        }

        public final Builder setPaddingBottom(int value) {
            this.paddingBottom = MathKt.roundToInt(TypedValue.applyDimension(1, value, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final Builder setPaddingBottomResource(int value) {
            this.paddingBottom = ContextExtensionKt.dimenPixel(this.context, value);
            return this;
        }

        public final Builder setMargin(int value) {
            setMarginLeft(value);
            setMarginTop(value);
            setMarginRight(value);
            setMarginBottom(value);
            return this;
        }

        public final Builder setMarginResource(int value) {
            int iDimenPixel = ContextExtensionKt.dimenPixel(this.context, value);
            this.marginLeft = iDimenPixel;
            this.marginTop = iDimenPixel;
            this.marginRight = iDimenPixel;
            this.marginBottom = iDimenPixel;
            return this;
        }

        public final Builder setMarginHorizontal(int value) {
            setMarginLeft(value);
            setMarginRight(value);
            return this;
        }

        public final Builder setMarginHorizontalResource(int value) {
            setMarginLeftResource(value);
            setMarginRightResource(value);
            return this;
        }

        public final Builder setMarginVertical(int value) {
            setMarginTop(value);
            setMarginBottom(value);
            return this;
        }

        public final Builder setMarginVerticalResource(int value) {
            setMarginTopResource(value);
            setMarginBottomResource(value);
            return this;
        }

        public final Builder setMarginLeft(int value) {
            this.marginLeft = MathKt.roundToInt(TypedValue.applyDimension(1, value, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final Builder setMarginLeftResource(int value) {
            this.marginLeft = ContextExtensionKt.dimenPixel(this.context, value);
            return this;
        }

        public final Builder setMarginTop(int value) {
            this.marginTop = MathKt.roundToInt(TypedValue.applyDimension(1, value, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final Builder setMarginTopResource(int value) {
            this.marginTop = ContextExtensionKt.dimenPixel(this.context, value);
            return this;
        }

        public final Builder setMarginRight(int value) {
            this.marginRight = MathKt.roundToInt(TypedValue.applyDimension(1, value, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final Builder setMarginRightResource(int value) {
            this.marginRight = ContextExtensionKt.dimenPixel(this.context, value);
            return this;
        }

        public final Builder setMarginBottom(int value) {
            this.marginBottom = MathKt.roundToInt(TypedValue.applyDimension(1, value, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final Builder setMarginBottomResource(int value) {
            this.marginBottom = ContextExtensionKt.dimenPixel(this.context, value);
            return this;
        }

        public final Builder setIsVisibleArrow(boolean value) {
            this.isVisibleArrow = value;
            return this;
        }

        public final Builder setArrowColor(int value) {
            this.arrowColor = value;
            return this;
        }

        public final Builder setArrowColorMatchBalloon(boolean value) {
            this.arrowColorMatchBalloon = value;
            return this;
        }

        public final Builder setArrowColorResource(int value) {
            this.arrowColor = ContextExtensionKt.contextColor(this.context, value);
            return this;
        }

        public final Builder setArrowSize(int value) {
            this.arrowSize = value != Integer.MIN_VALUE ? MathKt.roundToInt(TypedValue.applyDimension(1, value, Resources.getSystem().getDisplayMetrics())) : Integer.MIN_VALUE;
            return this;
        }

        public final Builder setArrowSizeResource(int value) {
            this.arrowSize = ContextExtensionKt.dimenPixel(this.context, value);
            return this;
        }

        public final Builder setArrowPosition(float value) {
            this.arrowPosition = value;
            return this;
        }

        public final Builder setArrowPositionRules(ArrowPositionRules value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.arrowPositionRules = value;
            return this;
        }

        public final Builder setArrowOrientation(ArrowOrientation value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.arrowOrientation = value;
            return this;
        }

        public final Builder setArrowOrientationRules(ArrowOrientationRules value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.arrowOrientationRules = value;
            return this;
        }

        public final Builder setArrowDrawable(Drawable value) {
            this.arrowDrawable = value != null ? value.mutate() : null;
            if (value != null && this.arrowSize == Integer.MIN_VALUE) {
                this.arrowSize = Math.max(value.getIntrinsicWidth(), value.getIntrinsicHeight());
            }
            return this;
        }

        public final Builder setArrowDrawableResource(int value) {
            setArrowDrawable(ContextExtensionKt.contextDrawable(this.context, value));
            return this;
        }

        public final Builder setArrowLeftPadding(int value) {
            this.arrowLeftPadding = MathKt.roundToInt(TypedValue.applyDimension(1, value, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final Builder setArrowLeftPaddingResource(int value) {
            this.arrowLeftPadding = ContextExtensionKt.dimenPixel(this.context, value);
            return this;
        }

        public final Builder setArrowRightPadding(int value) {
            this.arrowRightPadding = MathKt.roundToInt(TypedValue.applyDimension(1, value, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final Builder setArrowRightPaddingResource(int value) {
            this.arrowRightPadding = ContextExtensionKt.dimenPixel(this.context, value);
            return this;
        }

        public final Builder setArrowTopPadding(int value) {
            this.arrowTopPadding = MathKt.roundToInt(TypedValue.applyDimension(1, value, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final Builder setArrowTopPaddingResource(int value) {
            this.arrowTopPadding = ContextExtensionKt.dimenPixel(this.context, value);
            return this;
        }

        public final Builder setArrowBottomPadding(int value) {
            this.arrowBottomPadding = MathKt.roundToInt(TypedValue.applyDimension(1, value, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final Builder setArrowBottomPaddingResource(int value) {
            this.arrowBottomPadding = ContextExtensionKt.dimenPixel(this.context, value);
            return this;
        }

        public final Builder setArrowAlignAnchorPadding(int value) {
            this.arrowAlignAnchorPadding = MathKt.roundToInt(TypedValue.applyDimension(1, value, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final Builder setArrowAlignAnchorPaddingResource(int value) {
            this.arrowAlignAnchorPadding = ContextExtensionKt.dimenPixel(this.context, value);
            return this;
        }

        public final Builder setArrowAlignAnchorPaddingRatio(float value) {
            this.arrowAlignAnchorPaddingRatio = value;
            return this;
        }

        public final Builder setArrowElevation(int value) {
            this.arrowElevation = MathKt.roundToInt(TypedValue.applyDimension(1, value, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final Builder setArrowElevationResource(int value) {
            this.arrowElevation = ContextExtensionKt.dimen(this.context, value);
            return this;
        }

        public final Builder setBackgroundColor(int value) {
            this.backgroundColor = value;
            return this;
        }

        public final Builder setBackgroundColorResource(int value) {
            this.backgroundColor = ContextExtensionKt.contextColor(this.context, value);
            return this;
        }

        public final Builder setBackgroundDrawable(Drawable value) {
            this.backgroundDrawable = value != null ? value.mutate() : null;
            return this;
        }

        public final Builder setBackgroundDrawableResource(int value) {
            Drawable drawableContextDrawable = ContextExtensionKt.contextDrawable(this.context, value);
            this.backgroundDrawable = drawableContextDrawable != null ? drawableContextDrawable.mutate() : null;
            return this;
        }

        public final Builder setCornerRadius(float value) {
            this.cornerRadius = TypedValue.applyDimension(1, value, Resources.getSystem().getDisplayMetrics());
            return this;
        }

        public final Builder setCornerRadiusResource(int value) {
            this.cornerRadius = ContextExtensionKt.dimen(this.context, value);
            return this;
        }

        public final Builder setText(CharSequence value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.text = value;
            return this;
        }

        public final Builder setTextResource(int value) {
            this.text = this.context.getString(value);
            return this;
        }

        public final Builder setTextColor(int value) {
            this.textColor = value;
            return this;
        }

        public final Builder setTextColorResource(int value) {
            this.textColor = ContextExtensionKt.contextColor(this.context, value);
            return this;
        }

        public final Builder setTextIsHtml(boolean value) {
            this.textIsHtml = value;
            return this;
        }

        public final Builder setMovementMethod(MovementMethod value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.movementMethod = value;
            return this;
        }

        public final Builder setTextSize(float value) {
            this.textSize = value;
            return this;
        }

        public final Builder setTextSizeResource(int value) {
            Context context = this.context;
            this.textSize = ContextExtensionKt.px2Sp(context, ContextExtensionKt.dimen(context, value));
            return this;
        }

        public final Builder setEnableAutoSized(boolean value) {
            this.enableAutoSized = value;
            return this;
        }

        public final Builder setMinAutoSizeTextSize(float value) {
            this.minAutoSizeTextSize = value;
            return this;
        }

        public final Builder setMaxAutoSizeTextSize(float value) {
            this.maxAutoSizeTextSize = value;
            return this;
        }

        public final Builder setTextTypeface(int value) {
            this.textTypeface = value;
            return this;
        }

        public final Builder setTextTypeface(Typeface value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.textTypefaceObject = value;
            return this;
        }

        public final Builder setTextLineSpacing(float value) {
            this.textLineSpacing = Float.valueOf(value);
            return this;
        }

        public final Builder setTextLetterSpacing(float value) {
            this.textLetterSpacing = Float.valueOf(value);
            return this;
        }

        public final Builder setTextLineSpacingResource(int value) {
            this.textLineSpacing = Float.valueOf(ContextExtensionKt.dimen(this.context, value));
            return this;
        }

        public final Builder setTextLetterSpacingResource(int value) {
            this.textLetterSpacing = Float.valueOf(ContextExtensionKt.dimen(this.context, value));
            return this;
        }

        public final Builder setIncludeFontPadding(boolean value) {
            this.includeFontPadding = value;
            return this;
        }

        public final Builder setTextGravity(int value) {
            this.textGravity = value;
            return this;
        }

        public final Builder setTextForm(TextForm value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.textForm = value;
            return this;
        }

        public final Builder setIconDrawable(Drawable value) {
            this.iconDrawable = value != null ? value.mutate() : null;
            return this;
        }

        public final Builder setIconDrawableResource(int value) {
            Drawable drawableContextDrawable = ContextExtensionKt.contextDrawable(this.context, value);
            this.iconDrawable = drawableContextDrawable != null ? drawableContextDrawable.mutate() : null;
            return this;
        }

        public final Builder setIconGravity(IconGravity value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.iconGravity = value;
            return this;
        }

        public final Builder setIconWidth(int value) {
            this.iconWidth = MathKt.roundToInt(TypedValue.applyDimension(1, value, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final Builder setIconWidthResource(int value) {
            this.iconWidth = ContextExtensionKt.dimenPixel(this.context, value);
            return this;
        }

        public final Builder setIconHeight(int value) {
            this.iconHeight = MathKt.roundToInt(TypedValue.applyDimension(1, value, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final Builder setIconHeightResource(int value) {
            this.iconHeight = ContextExtensionKt.dimenPixel(this.context, value);
            return this;
        }

        public final Builder setIconSize(int value) {
            setIconWidth(value);
            setIconHeight(value);
            return this;
        }

        public final Builder setIconSizeResource(int value) {
            setIconWidthResource(value);
            setIconHeightResource(value);
            return this;
        }

        public final Builder setIconColor(int value) {
            this.iconColor = value;
            return this;
        }

        public final Builder setIconColorResource(int value) {
            this.iconColor = ContextExtensionKt.contextColor(this.context, value);
            return this;
        }

        public final Builder setIconSpace(int value) {
            this.iconSpace = MathKt.roundToInt(TypedValue.applyDimension(1, value, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final Builder setIconSpaceResource(int value) {
            this.iconSpace = ContextExtensionKt.dimenPixel(this.context, value);
            return this;
        }

        public final Builder setIconContentDescription(CharSequence value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.iconContentDescription = value;
            return this;
        }

        public final Builder setIconContentDescriptionResource(int value) {
            this.iconContentDescription = this.context.getString(value);
            return this;
        }

        public final Builder setIconForm(IconForm value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.iconForm = value;
            return this;
        }

        public final Builder setAlpha(float value) {
            this.alpha = value;
            return this;
        }

        public final Builder setElevation(int value) {
            this.elevation = MathKt.roundToInt(TypedValue.applyDimension(1, value, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final Builder setElevationResource(int value) {
            this.elevation = ContextExtensionKt.dimen(this.context, value);
            return this;
        }

        public final Builder setLayout(int layoutRes) {
            this.layoutRes = Integer.valueOf(layoutRes);
            return this;
        }

        public final Builder setLayout(View layout) {
            Intrinsics.checkNotNullParameter(layout, "layout");
            this.layout = layout;
            return this;
        }

        public final <T extends ViewBinding> Builder setLayout(T binding) {
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.layout = binding.getRoot();
            return this;
        }

        public final Builder setIsVisibleOverlay(boolean value) {
            this.isVisibleOverlay = value;
            return this;
        }

        public final Builder setOverlayColor(int value) {
            this.overlayColor = value;
            return this;
        }

        public final Builder setOverlayColorResource(int value) {
            this.overlayColor = ContextExtensionKt.contextColor(this.context, value);
            return this;
        }

        public final Builder setOverlayPadding(float value) {
            this.overlayPadding = TypedValue.applyDimension(1, value, Resources.getSystem().getDisplayMetrics());
            return this;
        }

        public final Builder setOverlayPaddingResource(int value) {
            this.overlayPadding = ContextExtensionKt.dimen(this.context, value);
            return this;
        }

        public final Builder setOverlayPaddingColor(int value) {
            this.overlayPaddingColor = value;
            return this;
        }

        public final Builder setOverlayPaddingColorResource(int value) {
            this.overlayPaddingColor = ContextExtensionKt.contextColor(this.context, value);
            return this;
        }

        public final Builder setOverlayPaddingShader(Shader shader) {
            Intrinsics.checkNotNullParameter(shader, "shader");
            this.overlayPaddingShader = shader;
            return this;
        }

        public final Builder setOverlayPosition(Point value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.overlayPosition = value;
            return this;
        }

        public final Builder setOverlayShape(BalloonOverlayShape value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.overlayShape = value;
            return this;
        }

        public final Builder setOverlayGravity(int gravity) {
            this.overlayGravity = gravity;
            return this;
        }

        public final Builder setIsStatusBarVisible(boolean value) {
            this.isStatusBarVisible = value;
            return this;
        }

        public final Builder setIsAttachedInDecor(boolean value) {
            this.isAttachedInDecor = value;
            return this;
        }

        public final Builder setLifecycleOwner(LifecycleOwner value) {
            this.lifecycleOwner = value;
            return this;
        }

        public final Builder setLifecycleObserver(LifecycleObserver value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.lifecycleObserver = value;
            return this;
        }

        public final Builder setBalloonAnimation(BalloonAnimation value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.balloonAnimation = value;
            if (value == BalloonAnimation.CIRCULAR) {
                setFocusable(false);
            }
            return this;
        }

        public final Builder setBalloonAnimationStyle(int value) {
            this.balloonAnimationStyle = value;
            return this;
        }

        public final Builder setBalloonOverlayAnimation(BalloonOverlayAnimation value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.balloonOverlayAnimation = value;
            return this;
        }

        public final Builder setBalloonOverlayAnimationStyle(int value) {
            this.balloonOverlayAnimationStyle = value;
            return this;
        }

        public final Builder setCircularDuration(long value) {
            this.circularDuration = value;
            return this;
        }

        public static /* synthetic */ Builder setBalloonHighlightAnimation$default(Builder builder, BalloonHighlightAnimation balloonHighlightAnimation, long j, int i, Object obj) {
            if ((i & 2) != 0) {
                j = 0;
            }
            return builder.setBalloonHighlightAnimation(balloonHighlightAnimation, j);
        }

        public final Builder setBalloonHighlightAnimation(BalloonHighlightAnimation value, long startDelay) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.balloonHighlightAnimation = value;
            this.balloonHighlightAnimationStartDelay = startDelay;
            return this;
        }

        public static /* synthetic */ Builder setBalloonHighlightAnimationResource$default(Builder builder, int i, long j, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                j = 0;
            }
            return builder.setBalloonHighlightAnimationResource(i, j);
        }

        public final Builder setBalloonHighlightAnimationResource(int value, long startDelay) {
            this.balloonHighlightAnimationStyle = value;
            this.balloonHighlightAnimationStartDelay = startDelay;
            return this;
        }

        public final Builder setBalloonRotationAnimation(BalloonRotateAnimation balloonRotateAnimation) {
            Intrinsics.checkNotNullParameter(balloonRotateAnimation, "balloonRotateAnimation");
            this.balloonRotateAnimation = balloonRotateAnimation;
            return this;
        }

        public final Builder setOnBalloonClickListener(OnBalloonClickListener value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.onBalloonClickListener = value;
            return this;
        }

        public final Builder setOnBalloonDismissListener(OnBalloonDismissListener value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.onBalloonDismissListener = value;
            return this;
        }

        public final Builder setOnBalloonInitializedListener(OnBalloonInitializedListener value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.onBalloonInitializedListener = value;
            return this;
        }

        public final Builder setOnBalloonOutsideTouchListener(OnBalloonOutsideTouchListener value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.onBalloonOutsideTouchListener = value;
            return this;
        }

        public final Builder setOnBalloonTouchListener(View.OnTouchListener value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.onBalloonTouchListener = value;
            return this;
        }

        public final Builder setOnBalloonOverlayClickListener(OnBalloonOverlayClickListener value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.onBalloonOverlayClickListener = value;
            return this;
        }

        public final /* synthetic */ Builder setOnBalloonClickListener(Function1 block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.onBalloonClickListener = new BalloonKt$sam$com_skydoves_balloon_OnBalloonClickListener$0(block);
            return this;
        }

        public final /* synthetic */ Builder setOnBalloonDismissListener(Function0 block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.onBalloonDismissListener = new BalloonKt$sam$com_skydoves_balloon_OnBalloonDismissListener$0(block);
            return this;
        }

        public final /* synthetic */ Builder setOnBalloonInitializedListener(Function1 block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.onBalloonInitializedListener = new BalloonKt$sam$com_skydoves_balloon_OnBalloonInitializedListener$0(block);
            return this;
        }

        public final /* synthetic */ Builder setOnBalloonOutsideTouchListener(Function2 block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.onBalloonOutsideTouchListener = new BalloonKt$sam$com_skydoves_balloon_OnBalloonOutsideTouchListener$0(block);
            setDismissWhenTouchOutside(false);
            return this;
        }

        public final Builder setOnBalloonOverlayClickListener(Function0<Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.onBalloonOverlayClickListener = new BalloonKt$sam$com_skydoves_balloon_OnBalloonOverlayClickListener$0(block);
            return this;
        }

        public final Builder setDismissWhenTouchOutside(boolean value) {
            this.dismissWhenTouchOutside = value;
            if (!value) {
                setFocusable(value);
            }
            return this;
        }

        public final Builder setDismissWhenTouchMargin(boolean value) {
            this.dismissWhenTouchMargin = value;
            return this;
        }

        public final Builder setOnBalloonOverlayTouchListener(View.OnTouchListener value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.onBalloonOverlayTouchListener = value;
            setDismissWhenOverlayClicked(false);
            return this;
        }

        public final Builder setDismissWhenShowAgain(boolean value) {
            this.dismissWhenShowAgain = value;
            return this;
        }

        public final Builder setDismissWhenClicked(boolean value) {
            this.dismissWhenClicked = value;
            return this;
        }

        public final Builder setDismissWhenLifecycleOnPause(boolean value) {
            this.dismissWhenLifecycleOnPause = value;
            return this;
        }

        public final Builder setDismissWhenOverlayClicked(boolean value) {
            this.dismissWhenOverlayClicked = value;
            return this;
        }

        public final Builder setShouldPassTouchEventToAnchor(boolean value) {
            this.passTouchEventToAnchor = value;
            return this;
        }

        public final Builder setAutoDismissDuration(long value) {
            this.autoDismissDuration = value;
            return this;
        }

        public final Builder setPreferenceName(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.preferenceName = value;
            return this;
        }

        public final Builder setShowCounts(int value) {
            this.showTimes = value;
            return this;
        }

        public final Builder runIfReachedShowCounts(Function0<Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.runIfReachedShowCounts = block;
            return this;
        }

        public final Builder runIfReachedShowCounts(Runnable runnable) {
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            runIfReachedShowCounts(new Balloon$Builder$$ExternalSyntheticLambda0(runnable));
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit runIfReachedShowCounts$lambda$165$lambda$164(Runnable runnable) {
            runnable.run();
            return Unit.INSTANCE;
        }

        public final Builder setRtlSupports(boolean isRtlSupport) {
            this.isRtlLayout = isRtlSupport;
            return this;
        }

        public final Builder setFocusable(boolean value) {
            this.isFocusable = value;
            return this;
        }

        public final Builder setIsComposableContent(boolean value) {
            this.isComposableContent = value;
            return this;
        }

        public final Balloon build() {
            return new Balloon(this.context, this, null);
        }
    }

    /* JADX INFO: compiled from: Balloon.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0012\u001a\u00020\u0013R!\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/skydoves/balloon/Balloon$Companion;", "", "<init>", "()V", "channel", "Lkotlinx/coroutines/channels/Channel;", "Lcom/skydoves/balloon/DeferredBalloonGroup;", "getChannel", "()Lkotlinx/coroutines/channels/Channel;", "channel$delegate", "Lkotlin/Lazy;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "scope$delegate", "isConsumerActive", "", "initConsumerIfNeeded", "", "balloon_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Channel<DeferredBalloonGroup> getChannel() {
            return (Channel) Balloon.channel$delegate.getValue();
        }

        private final CoroutineScope getScope() {
            return (CoroutineScope) Balloon.scope$delegate.getValue();
        }

        public final void initConsumerIfNeeded() {
            if (Balloon.isConsumerActive) {
                return;
            }
            Balloon.isConsumerActive = true;
            BuildersKt__Builders_commonKt.launch$default(getScope(), null, null, new Balloon$Companion$initConsumerIfNeeded$1(null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Channel channel_delegate$lambda$56() {
        return ChannelKt.Channel$default(0, null, null, 7, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CoroutineScope scope_delegate$lambda$57() {
        return CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
    }

    public final Balloon relayShowAtCenter(Balloon balloon, View anchor, int xOff, int yOff, BalloonCenterAlign centerAlign) {
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        Intrinsics.checkNotNullParameter(centerAlign, "centerAlign");
        setOnBalloonDismissListener(new Balloon$relayShowAtCenter$$inlined$relay$1(balloon.builder.getOnBalloonDismissListener(), this, balloon, anchor, xOff, yOff, centerAlign));
        return balloon;
    }

    public final Balloon relayShowAsDropDown(Balloon balloon, View anchor, int xOff, int yOff) {
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        setOnBalloonDismissListener(new Balloon$relayShowAsDropDown$$inlined$relay$1(balloon.builder.getOnBalloonDismissListener(), this, balloon, anchor, xOff, yOff));
        return balloon;
    }

    public final Balloon relayShowAlignTop(Balloon balloon, View anchor, int xOff, int yOff) {
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        setOnBalloonDismissListener(new Balloon$relayShowAlignTop$$inlined$relay$1(balloon.builder.getOnBalloonDismissListener(), this, balloon, anchor, xOff, yOff));
        return balloon;
    }

    public final Balloon relayShowAlignBottom(Balloon balloon, View anchor, int xOff, int yOff) {
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        setOnBalloonDismissListener(new Balloon$relayShowAlignBottom$$inlined$relay$1(balloon.builder.getOnBalloonDismissListener(), this, balloon, anchor, xOff, yOff));
        return balloon;
    }

    @Deprecated(message = "Use relayShowAlignEnd instead.", replaceWith = @ReplaceWith(expression = "relayShowAlignEnd(balloon, anchor, xOff, yOff)", imports = {}))
    public final Balloon relayShowAlignRight(Balloon balloon, View anchor, int xOff, int yOff) {
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        setOnBalloonDismissListener(new Balloon$relayShowAlignRight$$inlined$relay$1(balloon.builder.getOnBalloonDismissListener(), this, balloon, anchor, xOff, yOff));
        return balloon;
    }

    public final Balloon relayShowAlignEnd(Balloon balloon, View anchor, int xOff, int yOff) {
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        setOnBalloonDismissListener(new Balloon$relayShowAlignEnd$$inlined$relay$1(balloon.builder.getOnBalloonDismissListener(), this, balloon, anchor, xOff, yOff));
        return balloon;
    }

    @Deprecated(message = "Use relayShowAlignStart instead.", replaceWith = @ReplaceWith(expression = "relayShowAlignStart(balloon, anchor, xOff, yOff)", imports = {}))
    public final Balloon relayShowAlignLeft(Balloon balloon, View anchor, int xOff, int yOff) {
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        setOnBalloonDismissListener(new Balloon$relayShowAlignLeft$$inlined$relay$1(balloon.builder.getOnBalloonDismissListener(), this, balloon, anchor, xOff, yOff));
        return balloon;
    }

    public final Balloon relayShowAlignStart(Balloon balloon, View anchor, int xOff, int yOff) {
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        setOnBalloonDismissListener(new Balloon$relayShowAlignStart$$inlined$relay$1(balloon.builder.getOnBalloonDismissListener(), this, balloon, anchor, xOff, yOff));
        return balloon;
    }

    public final Balloon relayShowAlign(BalloonAlign align, Balloon balloon, View anchor, int xOff, int yOff) {
        Intrinsics.checkNotNullParameter(align, "align");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        setOnBalloonDismissListener(new Balloon$relayShowAlign$$inlined$relay$1(balloon.builder.getOnBalloonDismissListener(), this, balloon, align, anchor, xOff, yOff));
        return balloon;
    }

    public final int getMeasuredWidth() {
        int i = new Point(Resources.getSystem().getDisplayMetrics().widthPixels, Resources.getSystem().getDisplayMetrics().heightPixels).x;
        if (this.builder.getWidthRatio() != 0.0f) {
            return (int) (i * this.builder.getWidthRatio());
        }
        if (this.builder.getMinWidthRatio() == 0.0f && this.builder.getMaxWidthRatio() == 0.0f) {
            return this.builder.getWidth() != Integer.MIN_VALUE ? RangesKt.coerceAtMost(this.builder.getWidth(), i) : RangesKt.coerceAtMost(RangesKt.coerceIn(this.binding.getRoot().getMeasuredWidth(), this.builder.getMinWidth(), this.builder.getMaxWidth()), i);
        }
        float f = i;
        return RangesKt.coerceIn(this.binding.getRoot().getMeasuredWidth(), (int) (this.builder.getMinWidthRatio() * f), (int) (f * (this.builder.getMaxWidthRatio() == 0.0f ? 1.0f : this.builder.getMaxWidthRatio())));
    }

    private final void traverseAndMeasureTextWidth(ViewGroup parent) {
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = parent.getChildAt(i);
            if (childAt instanceof TextView) {
                measureTextWidth((TextView) childAt, parent);
            } else if (childAt instanceof ViewGroup) {
                traverseAndMeasureTextWidth((ViewGroup) childAt);
            }
        }
    }

    private final int getMeasuredTextWidth(int measuredWidth, View rootView) {
        int marginRight;
        int arrowSize;
        int i = new Point(Resources.getSystem().getDisplayMetrics().widthPixels, Resources.getSystem().getDisplayMetrics().heightPixels).x;
        int paddingLeft = rootView.getPaddingLeft() + rootView.getPaddingRight();
        if (this.builder.getIconDrawable() != null) {
            marginRight = this.builder.getIconWidth();
            arrowSize = this.builder.getIconSpace();
        } else {
            marginRight = this.builder.getMarginRight() + this.builder.getMarginLeft();
            arrowSize = this.builder.getArrowSize() * 2;
        }
        int i2 = paddingLeft + marginRight + arrowSize;
        int iCoerceAtMost = RangesKt.coerceAtMost(this.builder.getMaxWidth() - i2, i);
        if (this.builder.getWidthRatio() != 0.0f) {
            return ((int) (i * this.builder.getWidthRatio())) - i2;
        }
        if (this.builder.getMinWidthRatio() != 0.0f || this.builder.getMaxWidthRatio() != 0.0f) {
            return RangesKt.coerceAtMost(measuredWidth, ((int) (i * (this.builder.getMaxWidthRatio() == 0.0f ? 1.0f : this.builder.getMaxWidthRatio()))) - i2);
        }
        if (this.builder.getWidth() != Integer.MIN_VALUE && this.builder.getWidth() <= i) {
            return this.builder.getWidth() - i2;
        }
        return RangesKt.coerceAtMost(measuredWidth, iCoerceAtMost);
    }
}
